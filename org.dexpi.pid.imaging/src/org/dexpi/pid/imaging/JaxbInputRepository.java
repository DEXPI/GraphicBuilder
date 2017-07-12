package org.dexpi.pid.imaging;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Unmarshaller.Listener;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.stream.StreamSource;

import org.dexpi.pid.imaging.drawableElements.CircleElement;
import org.dexpi.pid.imaging.drawableElements.DrawableElement;
import org.dexpi.pid.imaging.drawableElements.EllipseElement;
import org.dexpi.pid.imaging.drawableElements.LineElement;
import org.dexpi.pid.imaging.drawableElements.ShapeElement;
import org.dexpi.pid.imaging.drawableElements.TextElement;
import org.dexpi.pid.imaging.pidElements.ErrorElement;
import org.dexpi.pid.imaging.pidElements.PidElement;
import org.dexpi.pid.xml.ActuatingFunction;
import org.dexpi.pid.xml.ActuatingSystem;
import org.dexpi.pid.xml.ActuatingSystemComponent;
import org.dexpi.pid.xml.AnnotationItem;
import org.dexpi.pid.xml.CenterLine;
import org.dexpi.pid.xml.Circle;
import org.dexpi.pid.xml.Component;
import org.dexpi.pid.xml.ConnectionPoints;
import org.dexpi.pid.xml.Coordinate;
import org.dexpi.pid.xml.Curve;
import org.dexpi.pid.xml.DrawableObjectThatInheritsDirectlyFromPlantItem;
import org.dexpi.pid.xml.Drawing;
import org.dexpi.pid.xml.DrawingBorder;
import org.dexpi.pid.xml.Ellipse;
import org.dexpi.pid.xml.Equipment;
import org.dexpi.pid.xml.Extent;
import org.dexpi.pid.xml.GeneratedClass;
import org.dexpi.pid.xml.GenericAttribute;
import org.dexpi.pid.xml.GenericAttributes;
import org.dexpi.pid.xml.InformationFlow;
import org.dexpi.pid.xml.InstrumentationLoopFunction;
import org.dexpi.pid.xml.Label;
import org.dexpi.pid.xml.Line;
import org.dexpi.pid.xml.Node;
import org.dexpi.pid.xml.Nozzle;
import org.dexpi.pid.xml.PersistentID;
import org.dexpi.pid.xml.PipingComponent;
import org.dexpi.pid.xml.PipingNetworkSegment;
import org.dexpi.pid.xml.PipingNetworkSystem;
import org.dexpi.pid.xml.PlantItem;
import org.dexpi.pid.xml.PlantModel;
import org.dexpi.pid.xml.PolyLine;
import org.dexpi.pid.xml.Position;
import org.dexpi.pid.xml.Presentation;
import org.dexpi.pid.xml.ProcessInstrument;
import org.dexpi.pid.xml.ProcessInstrumentationFunction;
import org.dexpi.pid.xml.ProcessSignalGeneratingFunction;
import org.dexpi.pid.xml.ProcessSignalGeneratingSystem;
import org.dexpi.pid.xml.ProcessSignalGeneratingSystemComponent;
import org.dexpi.pid.xml.Scale;
import org.dexpi.pid.xml.Shape;
import org.dexpi.pid.xml.ShapeCatalogue;
import org.dexpi.pid.xml.SignalLine;
import org.dexpi.pid.xml.Text;
import org.dexpi.pid.xml.TrimmedCurve;

public class JaxbInputRepository implements InputRepository {

	// some minor changes to CenterLine, PersistentID and PipingComponent in
	// org.dexpi.pid.xml
	// have been made, because unlike the other classes they were classified as
	// jaxbelement.class for no obvious reason
	// changes are documented in the classes themselves

	private PlantModel plantModel;
	private ShapeCatalogue shapeCatalogue;
	private Drawing drawing;

	private double[] zeroPoint;
	private double[] size;
	private Extent extent;
	private Color backgroundColor;
	private ArrayList<PidElement> listOfPlantItems = new ArrayList<PidElement>();
	private ArrayList<PidElement> listOfAnnotationItems = new ArrayList<PidElement>();
	private ArrayList<PidElement> listOfPiping = new ArrayList<PidElement>();
	private ArrayList<ErrorElement> listOfErrors = new ArrayList<ErrorElement>();

	private ArrayList<String> loggerList = new ArrayList<String>();

	private ArrayList<Text> persistentIDTextElements = new ArrayList<Text>();
	private int counter = 0;

	public Locator locator = new Locator();

	/**
	 * creates java objects from xml
	 * 
	 * @param file
	 *            the xml-File to be drawn
	 * @throws JAXBException
	 *             exception thrown
	 * @throws FileNotFoundException
	 *             exception thrown
	 * @throws XMLStreamException
	 *             exception thrown
	 */
	public JaxbInputRepository(File file) throws JAXBException,
			FileNotFoundException, XMLStreamException {

		int lines = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while (reader.readLine() != null)
				++lines;
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create JAXB context
		JAXBContext jaxbContext = JAXBContext.newInstance(PlantModel.class);
		XMLInputFactory xif = XMLInputFactory.newFactory();
		StreamSource source = new StreamSource(file);
		XMLStreamReader xsr = xif.createXMLStreamReader(source);

		// create list of locatorElements
		xsr = new StreamReaderDelegate(xsr) {
			@Override
			public java.lang.String getLocalName() {
				java.lang.String localName = super.getLocalName();
				if (isStartElement()) {
					java.lang.String id = "";
					for (int i = 0; i < this.getAttributeCount(); i++) {
						if (this.getAttributeLocalName(i).equals("ID")) {
							id = this.getAttributeValue(i);
						}
					}

					JaxbInputRepository.this.locator.addElement(localName, id,
							this.getLocation().getLineNumber());
				}
				return localName;
			}
		};
		// sorts list (ascending by linenumber)
		this.locator.sortList();

		// initialize Marshaller
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		LocationListener ll = new LocationListener(xsr, lines,
				this.listOfErrors);
		unmarshaller.setListener(ll);

		unmarshaller.unmarshal(xsr);
		// this will create Java object from the XML file
		this.plantModel = (PlantModel) unmarshaller.unmarshal(source);

		// throw error IFF plantModel is null ('cause marshalling went
		// terribly wrong!)
		if (this.plantModel == null) {
			ErrorElement eE = new ErrorElement("0");
			eE.setDescription("Marshalling went terribly wrong!");
			this.listOfErrors.add(eE);
		} else
			init();
	}

	/*
	 * LocationListener is a private class that is attached to a
	 * XMLStreamReader-Object. The goal is to backtrace the line-number
	 * information that is normally lost while unmarshalling.
	 */
	private static class LocationListener extends Listener {

		private XMLStreamReader xsr;

		private int lines = 0;
		private int count = 0;
		private ArrayList<Integer> lineNumberHandleList;
		private ArrayList<ErrorElement> listOfErrors;

		@SuppressWarnings("unused")
		public LocationListener(XMLStreamReader xsr) {
			this.xsr = xsr;

		}

		public LocationListener(XMLStreamReader xsr, int lines,
				ArrayList<ErrorElement> listOfErrors) {
			this.xsr = xsr;
			this.lines = lines;
			this.lineNumberHandleList = new ArrayList<Integer>();
			this.listOfErrors = listOfErrors;
		}

		@Override
		public void beforeUnmarshal(Object target, Object parent) {

			Method method = null;
			try {
				// As we marshall twice in the first run we save the lineNumbers
				// to an ArrayList as well as the index to a counter-variable.
				// In a second step we apply these lineNumbers - else we would
				// simply write the count of lines of the file as a lineNumber.
				// Additionally there are some marshalling-artifacts generated
				// that marshall to "JaxbElement" - dunno why this happens,
				// maybe we have to investigate this further later. To ignore
				// these artifacts we simply forward the lineNumber-marshalling
				// and ignore them - so they will not get any lineNumbers.

				// Tested this method with a few documents that are around
				// 1500lines each - seems to work fine. @MaHe08

				if (this.xsr.getLocation().getLineNumber() != this.lines) {
					// This is the old shit
					method = GeneratedClass.class.getMethod("setLineNumber",
							new Class[] { int.class });
					int lineNumber = this.xsr.getLocation().getLineNumber();
					method.invoke(target, lineNumber);

					// this is the new shit
					this.lineNumberHandleList.add(lineNumber);

				} else {
					method = GeneratedClass.class.getMethod("setLineNumber",
							new Class[] { int.class });
					try {

						if (target instanceof JAXBElement)
							return;

						method.invoke(target,
								this.lineNumberHandleList.get(this.count++));
					} catch (Exception e) {
						ErrorElement eE = new ErrorElement("");
						eE.setDescription("GB-Error while marshalling LineNumbers - they might not all be correct!");
						this.listOfErrors.add(eE);
					}
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
	}

	// auxiliary function to read text from a file to a string
	@SuppressWarnings({ "resource", "static-method" })
	private String readFileToString(File file) throws IOException {
		FileInputStream stream = new FileInputStream(file);
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0,
					fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}

	/**
	 * sets the basic parameters of the drawing: zero point and size,
	 * backgroundcolor, drawing, shapecatalogue
	 * 
	 */
	@Override
	public void init() {

		// Refactored due to us now taking the extent of the drawing!

		// set Drawing and ShapeCatalogue
		for (Object object : this.plantModel
				.getPresentationOrShapeCatalogueOrDrawing()) {

			if (object instanceof Drawing) {
				this.drawing = (Drawing) object;

				try {
					this.extent = this.drawing.getExtent();

				} catch (Exception e) {
					// extent is missing or incorrect - exception will be
					// handled in GraphicBuilder
				}

				this.zeroPoint = new double[] { this.extent.getMin().getX(),
						this.extent.getMin().getY() };
				this.size = new double[] { this.extent.getMax().getX(),
						this.extent.getMax().getY() };

				// set backgroundColor
				if (this.drawing.getPresentation() != null) {
					this.backgroundColor = getColor(this.drawing
							.getPresentation());
				}
			} else if (object instanceof ShapeCatalogue) {
				this.shapeCatalogue = (ShapeCatalogue) object;
			}
		}

	}

	/**
	 * loops through the xml-structure and handles every occuring annotationItem
	 * 
	 */
	@Override
	public ArrayList<PidElement> getAnnotationItems() {

		// check if PlantItem and its SubPlantItems contain AnnotationItems
		for (Object object : this.plantModel
				.getPresentationOrShapeCatalogueOrDrawing()) {

			// level1 (PI) sys
			if (object instanceof AnnotationItem) {
				initializeAnnotationItemElements((AnnotationItem) object);
			} else if (object instanceof PlantItem) {
				for (AnnotationItem annotationItem : getSubAI((PlantItem) object)) {
					initializeAnnotationItemElements(annotationItem);
				}
				// level2 (subPi) seg
				for (PlantItem plantItem : getSubPI((PlantItem) object)) {
					for (AnnotationItem annotationItem : getSubAI(plantItem)) {
						initializeAnnotationItemElements(annotationItem);
					}
					// level3 (subSubPI)
					for (PlantItem subPlantItem : getSubPI(plantItem)) {
						for (AnnotationItem annotationItem : getSubAI(subPlantItem)) {
							initializeAnnotationItemElements(annotationItem);
						}
					}
				}
			}
		}
		return this.listOfAnnotationItems;
	}

	/**
	 * creates a PidElement corresponding to the annotationItem, initializes its
	 * basic attributes and adds it to the listOfAnnotationItems after graphic
	 * elements have been added
	 * 
	 * @param annotationItem
	 *            the item whose attributes and graphic elements get transfered
	 *            to the pidElement
	 */
	public void initializeAnnotationItemElements(AnnotationItem annotationItem) {

		PidElement aiElement = new PidElement(annotationItem.getID(),
				annotationItem.getComponentName(),
				annotationItem.getComponentClass());
		aiElement.init();
		this.listOfAnnotationItems.add(handleAnnotationItem(annotationItem,
				aiElement));

	}

	/**
	 * creates a PidElement corresponding to the plantItem, initializes its
	 * basic attributes and adds it to the listOfPlantItems after graphic
	 * elements have been added
	 * 
	 * @param plantItem
	 *            the item whose attributes and graphic elements get transfered
	 *            to the pidElement
	 */
	public void initializePlantItemElements(PlantItem plantItem) {
		// System.out.println("triggered by " + plantItem.getClass());
		if (plantItem instanceof Component) {
			Component component = (Component) plantItem;
			PidElement componentElement = new PidElement(component.getID(),
					component.getComponentName(), component.getComponentClass());
			componentElement.init();
			this.listOfPlantItems.add(handlePlantItem(component,
					componentElement));
		} else if (plantItem instanceof Equipment) {
			Equipment equipment = (Equipment) plantItem;
			PidElement equipmentElement = new PidElement(equipment.getID(),
					equipment.getComponentName(), equipment.getComponentClass());
			equipmentElement.init();
			this.listOfPlantItems.add(handlePlantItem(equipment,
					equipmentElement));
		} else if (plantItem instanceof DrawableObjectThatInheritsDirectlyFromPlantItem) {
			DrawableObjectThatInheritsDirectlyFromPlantItem dotidfpi = (DrawableObjectThatInheritsDirectlyFromPlantItem) plantItem;
			PidElement dotidfpiElement = new PidElement(dotidfpi.getID(),
					dotidfpi.getComponentName(), dotidfpi.getComponentClass());
			dotidfpi.init();
			this.listOfPlantItems
					.add(handlePlantItem(dotidfpi, dotidfpiElement));
		} else if (plantItem instanceof Nozzle) {
			Nozzle nozzle = (Nozzle) plantItem;
			PidElement nozzleElement = new PidElement(nozzle.getID(),
					nozzle.getComponentName(), nozzle.getComponentClass());
			nozzleElement.init();
			this.listOfPlantItems.add(handlePlantItem(nozzle, nozzleElement));
		} else if (plantItem instanceof PipingComponent) {
			PipingComponent pipingComponent = (PipingComponent) plantItem;
			PidElement pipingCompElement = new PidElement(
					pipingComponent.getID(),
					pipingComponent.getComponentName(),
					pipingComponent.getComponentClass());
			pipingCompElement.init();
			this.listOfPlantItems.add(handlePlantItem(pipingComponent,
					pipingCompElement));
		} else if (plantItem instanceof PipingNetworkSegment) {
			PipingNetworkSegment pnSeg = (PipingNetworkSegment) plantItem;

			PidElement pnSegElement = new PidElement(pnSeg.getID(),
					"PipingSegment", pnSeg.getComponentClass());
			pnSegElement.setType("PipingNetworkSegment");
			pnSegElement.init();
			this.listOfPlantItems.add(handlePlantItem(pnSeg, pnSegElement));
		} else if (plantItem instanceof PipingNetworkSystem) {
			PipingNetworkSystem pnSys = (PipingNetworkSystem) plantItem;
			PidElement pnSysElement = new PidElement(pnSys.getID(),
					"PipingSystem", pnSys.getComponentClass());
			pnSysElement.setType("PipingNetworkSystem");
			pnSysElement.init();
			this.listOfPlantItems.add(handlePlantItem(pnSys, pnSysElement));
		} else if (plantItem instanceof InformationFlow) {
			InformationFlow iFlow = (InformationFlow) plantItem;

			PidElement iFlowElement = new PidElement(iFlow.getID(),
					"InformationFlow", iFlow.getComponentClass());

			iFlowElement.setType("InformationFlow");
			iFlowElement.init();
			this.listOfPlantItems.add(handlePlantItem(iFlow, iFlowElement));
		} else if (plantItem instanceof ProcessInstrument) {
			ProcessInstrument processInstrument = (ProcessInstrument) plantItem;
			PidElement procInstrElement = new PidElement(
					processInstrument.getID(),
					processInstrument.getComponentName(),
					processInstrument.getComponentClass());
			procInstrElement.init();
			this.listOfPlantItems.add(handlePlantItem(processInstrument,
					procInstrElement));
		} else if (plantItem instanceof SignalLine) {
			SignalLine signalLine = (SignalLine) plantItem;
			PidElement signalLineElement = new PidElement(signalLine.getID(),
					signalLine.getComponentName(),
					signalLine.getComponentClass());
			signalLineElement.init();
			signalLineElement.setType("SignalLine");
			this.listOfPlantItems.add(handlePlantItem(signalLine,
					signalLineElement));
		}
	}

	/**
	 * handles (create PidElement, add graphics) centerLines and adds them to
	 * the listOfPiping
	 * 
	 * @param object
	 *            a CenterLine
	 */
	private void handleConnections(Object object) {

		// centerline is different from the other PlantItems and even
		// SignalLines
		// if something goes wrong here, its likely that its because of the
		// sloppy definition of what belongs in the centerline.

		if (object instanceof CenterLine) {
			CenterLine centerLine = (CenterLine) object;
			Color c = getColor(centerLine.getPresentation());
			float lineWeight = getLineWeight(centerLine.getPresentation());

			double xCoordinates[] = getXcoordinates(centerLine.getCoordinate());
			double yCoordinates[] = getYcoordinates(centerLine.getCoordinate());

			LineElement lineElement = new LineElement(c, lineWeight,
					xCoordinates, yCoordinates);

			PidElement centerLineElement = new PidElement(centerLine.getID(),
					"CenterLine", "CenterLine", "CenterLine");
			
			centerLineElement.setExtent(getExtent(this.extent));
			centerLineElement.addDrawableElement(lineElement);

			// check if CenterLine has already been added to the list
			boolean add = true;
			for (PidElement cL : this.listOfPiping) {
				if (cL.getID().equals(centerLine.getID())
						|| cL.getID().equals(
								centerLine.toString().replace(
										"org.dexpi.pid.xml.", ""))) {
					add = false;
				}
			}
			// get LineNumber and add to list
			if (centerLine.getID() == null && add == true) {
				centerLineElement.setID(centerLine.toString().replace(
						"org.dexpi.pid.xml.", ""));
				centerLineElement.setLineNumber(this.locator
						.getLineNumberByMissingID("CenterLine"));
			} else {
				centerLineElement.setLineNumber(this.locator
						.getLineNumber(centerLineElement.getID()));
			}

			if (add == true) {
				this.listOfPiping.add(centerLineElement);
			}

		}
	}

	/**
	 * returns all piping related pidElements
	 */
	@Override
	public ArrayList<PidElement> getPiping() {
		return this.listOfPiping;
	}

	/**
	 * gets the corresponding PlantItem to the itemId
	 * 
	 * @param itemID
	 *            the itemID of the textElement
	 * @return the PlantItem that corresponds to the itemID *
	 */
	private PlantItem checkItemID(Object itemID) {

		PlantItem piItemID = null;
		// check PlantItems for ItemID
		for (Object object : this.plantModel
				.getPresentationOrShapeCatalogueOrDrawing()) {
			if (object instanceof PlantItem) {
				if (object.equals(itemID)) {
					piItemID = (PlantItem) object;
				}
				for (PlantItem plantItem : getSubPI((PlantItem) object)) {
					if (plantItem.equals(itemID)) {
						piItemID = plantItem;
					}
					for (PlantItem subPlantItem : getSubPI(plantItem)) {
						if (subPlantItem.equals(itemID)) {
							piItemID = subPlantItem;
						}
					}
				}
			}
		}
		return piItemID;
	}

	/**
	 * filters the list of all subelements for AnnotationItems and returns them
	 * 
	 * @param plantItem
	 *            the plantItem whose subelements should be returned
	 * @return list of all subelements of the plantItem that are AnnotationItems
	 */
	public ArrayList<AnnotationItem> getSubAI(PlantItem plantItem) {
		ArrayList<AnnotationItem> listOfSubAI = new ArrayList<AnnotationItem>();
		for (Object object : getSubItems(plantItem)) {
			if (object instanceof AnnotationItem)
				listOfSubAI.add((AnnotationItem) object);
		}
		return listOfSubAI;
	}

	/**
	 * filters the list of all subelements for PlantItems and returns them
	 * 
	 * @param plantItem
	 *            the plantItem whose subelements should be returned
	 * @return list of all subelements of the plantItem that are PlantItems
	 */
	public ArrayList<PlantItem> getSubPI(PlantItem plantItem) {
		ArrayList<PlantItem> listOfSubPlantItems = new ArrayList<PlantItem>();
		for (Object object : getSubItems(plantItem)) {
			if (object instanceof PlantItem)
				listOfSubPlantItems.add((PlantItem) object);
		}
		return listOfSubPlantItems;
	}

	/**
	 * gets all subelements of a given plantItem
	 * 
	 * @param plantItem
	 *            the plantItem whose subelements should be returned
	 * @return all subelements of the given plantItem
	 */
	public ArrayList<Object> getSubItems(PlantItem plantItem) {
		// make list, fill and return
		ArrayList<Object> listOfSubItems = new ArrayList<Object>();

		if (plantItem instanceof Component) {
			Component component = (Component) plantItem;
			for (Object object : component.getComponent()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		} else if (plantItem instanceof DrawableObjectThatInheritsDirectlyFromPlantItem) {
			// To keep this path clean we have to use a sub-function
			handleDrawableObjectThatInheritsDirectlyFromPlantItem(plantItem,
					listOfSubItems);
		} else if (plantItem instanceof Nozzle) {
			// Scanning through nozzles to get nodes with persistent IDs and add
			// them to a help-list
			Nozzle nozzle = (Nozzle) plantItem;
			for (Object subObject : nozzle
					.getPresentationOrExtentOrPersistentID()) {

				if (subObject instanceof PlantItem) {
					listOfSubItems.add((PlantItem) subObject);
				} else if (subObject instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) subObject);
				}

				if (subObject instanceof ConnectionPoints) {
					ConnectionPoints connectionPoints = (ConnectionPoints) subObject;
					List<Node> nodes = connectionPoints.getNode();
					for (Node node : nodes) {
						String nodeID = null;
						if (node.getID() != null) {
							nodeID = node.getID();
						}
						List<Object> nodeContent = node
								.getPositionOrPersistentIDOrNominalDiameter();
						if (nodeContent.size() > 1) {
							// Now we got nodes with Position, PersistentID
							// and
							// GenericAttributes
							Text text = new Text();
							for (Object nodeContentObject : nodeContent) {
								if (nodeContentObject instanceof Position) {
									ArrayList<Object> list = new ArrayList<Object>();
									list.add(nodeContentObject);
									text.setPresentationOrExtentOrPosition(list);
								} else if (nodeContentObject instanceof PersistentID) {
									PersistentID persistentID = (PersistentID) nodeContentObject;
									if (nodeID == null) {
										text.setItemID(persistentID
												.getIdentifier());
									} else {
										text.setItemID(nodeID);
									}
									text.setItemID(nozzle);
								} else if (nodeContentObject instanceof GenericAttributes) {
									GenericAttributes genericAttributes = (GenericAttributes) nodeContentObject;
									ArrayList<Object> genericAttributesContent = (ArrayList<Object>) genericAttributes
											.getContent();
									for (Object subContent : genericAttributesContent) {
										if (subContent instanceof GenericAttribute) {
											GenericAttribute genericAttribute = (GenericAttribute) subContent;
											if (genericAttribute
													.getName()
													.equals("NominalDiameterNumericalValueRepresentationAssignmentClass")) {
												text.setDependantAttribute(genericAttribute
														.getName());
												text.setString(genericAttribute
														.getValue());
												text.setDependantAttributeContents(genericAttribute
														.getValue());
											}
										}
									}
								} else {
									System.out.println(nodeContentObject
											.getClass().toString());
									System.out
											.println("Something went wrong - maybe throw error?");
								}
							}

							// now if there has not been any persistent ID but
							// there has been a node-id, then we should use this
							if (text.getItemID() == null && nodeID != null) {
								text.setItemID(nozzle);
							}

							this.persistentIDTextElements.add(text);
						}
					}
				}
			}
		} else if (plantItem instanceof PipingComponent) {

			PipingComponent pipingComponent = (PipingComponent) plantItem;
			for (Object object : pipingComponent
					.getPipingComponentOrComponentOrNominalDiameter()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		} else if (plantItem instanceof PipingNetworkSegment) {
			PipingNetworkSegment pnSeg = (PipingNetworkSegment) plantItem;

			for (Object object : pnSeg
					.getNominalDiameterOrInsideDiameterOrOutsideDiameter()) {

				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				} else if (object instanceof CenterLine) {
					handleConnections(object);
				}

			}
			// needed for some annotationItems like PipeSlopeSymbol etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		} else if (plantItem instanceof PipingNetworkSystem) {
			PipingNetworkSystem pnSys = (PipingNetworkSystem) plantItem;
			for (Object object : pnSys
					.getNominalDiameterOrInsideDiameterOrOutsideDiameter()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		} else if (plantItem instanceof ProcessInstrument) {
			ProcessInstrument processInstrument = (ProcessInstrument) plantItem;
			for (Object object : processInstrument
					.getProcessInstrumentOrComponentOrNominalDiameter()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		} else if (plantItem instanceof SignalLine) {
			SignalLine signalLine = (SignalLine) plantItem;
			for (Object object : signalLine
					.getConnectionOrCenterLineOrComponent()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				} else if (object instanceof CenterLine) {
					handleConnections(object);
				}
			}
		}

		return listOfSubItems;

	}

	private void handleDrawableObjectThatInheritsDirectlyFromPlantItem(
			PlantItem plantItem, ArrayList<Object> listOfSubItems) {

		if (plantItem instanceof Equipment) {
			Equipment equipment = (Equipment) plantItem;

			for (Object object : equipment
					.getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// needed for some annotationItems like Labels etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		}

		else if (plantItem instanceof ProcessSignalGeneratingSystem) {
			ProcessSignalGeneratingSystem equipment = (ProcessSignalGeneratingSystem) plantItem;

			for (Object object : equipment
					.getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// needed for some annotationItems like Labels etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		}

		else if (plantItem instanceof ProcessSignalGeneratingSystemComponent) {
			ProcessSignalGeneratingSystemComponent equipment = (ProcessSignalGeneratingSystemComponent) plantItem;

			for (Object object : equipment
					.getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// needed for some annotationItems like Labels etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		}

		else if (plantItem instanceof ActuatingFunction) {
			ActuatingFunction equipment = (ActuatingFunction) plantItem;

			for (Object object : equipment
					.getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// needed for some annotationItems like Labels etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		}

		else if (plantItem instanceof ActuatingSystem) {
			ActuatingSystem equipment = (ActuatingSystem) plantItem;

			for (Object object : equipment
					.getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// needed for some annotationItems like Labels etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		}

		else if (plantItem instanceof ProcessSignalGeneratingFunction) {
			ProcessSignalGeneratingFunction equipment = (ProcessSignalGeneratingFunction) plantItem;

			for (Object object : equipment
					.getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// needed for some annotationItems like Labels etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		}

		else if (plantItem instanceof ActuatingSystemComponent) {
			ActuatingSystemComponent equipment = (ActuatingSystemComponent) plantItem;

			for (Object object : equipment
					.getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// needed for some annotationItems like Labels etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		}

		else if (plantItem instanceof ProcessInstrumentationFunction) {
			ProcessInstrumentationFunction equipment = (ProcessInstrumentationFunction) plantItem;

			for (Object object : equipment
					.getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// needed for some annotationItems like Labels etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// TODO Implement initializePlantItemElements

		}

		else if (plantItem instanceof InstrumentationLoopFunction) {
			InstrumentationLoopFunction equipment = (InstrumentationLoopFunction) plantItem;

			for (Object object : equipment
					.getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure()) {
				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}

			// needed for some annotationItems like Labels etc
			for (Object object : plantItem
					.getPresentationOrExtentOrPersistentID()) {
				if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				}
			}
		}

		else if (plantItem instanceof InformationFlow) {
			InformationFlow infoFlow = (InformationFlow) plantItem;

			for (Object object : infoFlow
					.getNominalDiameterOrInsideDiameterOrOutsideDiameter()) {

				if (object instanceof PlantItem) {
					listOfSubItems.add((PlantItem) object);
				} else if (object instanceof AnnotationItem) {
					listOfSubItems.add((AnnotationItem) object);
				} else if (object instanceof CenterLine) {
					handleConnections(object);
				}
			}
		} else
			System.out
					.println("This should not be reached! Please supply the developer with your input-file");
	}

	/**
	 *
	 * loops through the xml-structure and handles every occuring plantItem
	 * 
	 */
	@Override
	public ArrayList<PidElement> getPlantItems() {

		for (Object object : this.plantModel
				.getPresentationOrShapeCatalogueOrDrawing()) {
			if (object instanceof PlantItem) {
				initializePlantItemElements((PlantItem) object);

				for (PlantItem plantItem : getSubPI((PlantItem) object)) {
					initializePlantItemElements(plantItem);

					for (PlantItem subPlantItem : getSubPI(plantItem)) {
						initializePlantItemElements(subPlantItem);
					}
				}
			}
		}

		return this.listOfPlantItems;
	}

	@Override
	public PidElement getDrawing() {
		if (this.drawing == null) {
			return null;
		}
		PidElement drawingElement = new PidElement("Drawing",
				this.drawing.getName(), this.drawing.getType());
		drawingElement.init();
		drawingElement.setLineNumber(this.locator
				.getLineNumberByType("Drawing"));

		for (Object object : this.drawing.getComponentOrCurveOrSurface()) {
			if (object instanceof JAXBElement) {
				JAXBElement<?> jaxbElement = (JAXBElement<?>) object;
				drawingElement
						.addDrawableElements(handleDrawableElements(jaxbElement));
			} else if (object instanceof Text) {
				// DEBUG: never happened so far
				Text text = (Text) object;
				drawingElement.addDrawableElement(addText(text));
			} else if (object instanceof DrawingBorder) {
				DrawingBorder drawingBorder = (DrawingBorder) object;
				for (Object objectDB : drawingBorder.getCurveOrSurfaceOrText()) {
					// all curves (lines,circles etc) are JaxbElements
					if (objectDB instanceof JAXBElement) {
						JAXBElement<?> jaxbElement = (JAXBElement<?>) objectDB;
						drawingElement
								.addDrawableElements(handleDrawableElements(jaxbElement));
					} else if (objectDB instanceof Text) {
						Text text = (Text) objectDB;
						drawingElement.addDrawableElement(addText(text));
					}
				}
			}
			if (object instanceof AnnotationItem) {
				initializeAnnotationItemElements((AnnotationItem) object);
			}
		}
		return drawingElement;
	}

	public PidElement handleAnnotationItem(AnnotationItem annotationItem,
			PidElement pidElement) {

		pidElement.setExtent(getExtent(this.extent));

		// **********************************
		// this part supports relative coordinates in labels
		// the label and all the elements inside will be treated as if it had a
		// shapeCatalogue reference
		if (annotationItem instanceof Label) {

			for (Object object : annotationItem
					.getPresentationOrExtentOrPersistentID()) {
				double[] extent = getExtent(this.extent);

				// TODO verify
				// As we are now only using global coordinates we do not have to
				// reallocate the position of objects!
				if (object instanceof Position && extent != null) {
					Position position = (Position) object;
					// if extent is smaller than position it is save to assume,
					// that relative coordinates are used

					if (extent[0] < position.getLocation().getX()
							&& extent[1] < position.getLocation().getX()) {
						pidElement.setScRef(true);
						setScaleRefPos(annotationItem, pidElement);
						pidElement = aiAddDrawableElements(annotationItem,
								pidElement);

						pidElement.setLineNumber(this.locator
								.getLineNumber(pidElement.getID()));
					}
				}
			}
		}
		// ************************************

		// find shapeCatalogue Reference
		if (this.shapeCatalogue != null) {
			for (Object object : this.shapeCatalogue
					.getEquipmentOrNozzleOrPipingComponent()) {

				if (object instanceof AnnotationItem) {
					AnnotationItem annotationItemShape = (AnnotationItem) object;

					// in case SC Reference found:
					if ((annotationItemShape.getComponentName() != null)
							&& (annotationItem.getComponentName() != null)
							&& annotationItem.getComponentName().equals(
									annotationItemShape.getComponentName())) {

						setScaleRefPos(annotationItem, pidElement);
						pidElement.setScRef(true);
						pidElement = aiAddDrawableElements(annotationItemShape,
								pidElement);

						pidElement.setLineNumber(locator
								.getLineNumber(annotationItemShape.getID()));

						// inline Elements not in the Sc will be added as
						// subElement
						PidElement subElement = new PidElement(
								pidElement.getID(),
								pidElement.getComponentName(),
								pidElement.getComponentName());
						subElement.init();
						subElement.setExtent(getExtent(this.extent));
						subElement.setLineNumber(this.locator
								.getLineNumber(pidElement.getID()));
						pidElement.addSubElement(aiAddDrawableElements(
								annotationItem, subElement));
						break;
					}
				}
			}
		}

		// add drawableElements if no SC-reference exists
		if (pidElement.getScRef() != true) {
			pidElement = aiAddDrawableElements(annotationItem, pidElement);
			pidElement.setLineNumber(this.locator.getLineNumber(pidElement
					.getID()));
		}

		return pidElement;
	}

	private PidElement aiAddDrawableElements(AnnotationItem annotationItem,
			PidElement pidElement) {
		for (Object scObject : annotationItem
				.getPresentationOrExtentOrPersistentID()) {

			if (scObject instanceof JAXBElement) {
				JAXBElement<?> jaxbElement = (JAXBElement<?>) scObject;
				pidElement
						.addDrawableElements(handleDrawableElements(jaxbElement));
			}
			if (scObject instanceof Text) {
				Text text = (Text) scObject;
				pidElement.addDrawableElement(addText(text));
			}
		}
		return pidElement;
	}

	public PidElement handlePlantItem(PlantItem plantItem, PidElement pidElement) {

		pidElement.setExtent(getExtent(this.extent));// setExtent(getExtent(object));

		// find shapeCatalogue Reference
		if (this.shapeCatalogue != null) {
			for (Object object : this.shapeCatalogue
					.getEquipmentOrNozzleOrPipingComponent()) {

				if (object instanceof PlantItem) {
					PlantItem plantItemShape = (PlantItem) object;

					// in case SC Reference found:
					if ((plantItemShape.getComponentName() != null)
							&& (plantItem.getComponentName() != null)
							&& plantItem.getComponentName().equals(
									plantItemShape.getComponentName())) {

						// set position and scale
						setScaleRefPos(plantItem, pidElement);
						pidElement.setScRef(true);
						pidElement = piAddDrawableElements(plantItemShape,
								pidElement);
						pidElement.setLineNumber(this.locator
								.getLineNumber(plantItemShape.getID()));
						// inline Elements not in the Sc will be added as
						// subElement
						PidElement subElement = new PidElement(
								pidElement.getID(),
								pidElement.getComponentName(),
								pidElement.getComponentClass());
						subElement.init();
						subElement.setExtent(getExtent(this.extent));// pidElement.getExtent());
						// subElement.setScale(pidElement.getScale());
						// subElement.setPosition(pidElement.getPosition());
						// subElement.setReference(pidElement.getReference());
						subElement.setLineNumber(this.locator
								.getLineNumber(pidElement.getID()));
						pidElement.addSubElement(piAddDrawableElements(
								plantItem, subElement));
						pidElement.setID(plantItemShape.getID());
						break;
						// subElement has ID+linenumber of original PI
						// element has ID+LineNumber of ShapeCatalogueElement
					}
				}
			}
		}

		// add drawableElements if no ref to SC
		if (pidElement.getScRef() != true) {
			pidElement = piAddDrawableElements(plantItem, pidElement);
			pidElement.setLineNumber(this.locator.getLineNumber(pidElement
					.getID()));

		}

		return pidElement;
	}

	private PidElement piAddDrawableElements(PlantItem plantItem,
			PidElement pidElement) {
		for (Object scObject : plantItem
				.getPresentationOrExtentOrPersistentID()) {
			if (scObject instanceof JAXBElement) {
				JAXBElement<?> jaxbElement = (JAXBElement<?>) scObject;
				pidElement
						.addDrawableElements(handleDrawableElements(jaxbElement));
			} else if (scObject instanceof Text) {
				pidElement.addDrawableElement(addText((Text) scObject));
			}
		}
		return pidElement;
	}

	@Override
	public double[] getZeroPoint() {
		return this.zeroPoint;
	}

	@Override
	public double[] getSize() {
		return this.size;
	}

	@Override
	public Color getBackgroundcolor() {
		return this.backgroundColor;
	}

	/**
	 * adds curves (line, polyLine, circle etc) to the drawableElements
	 * 
	 * @param jaxbElement
	 *            the Curve
	 * @return ArrayList of drawableElements
	 */
	public ArrayList<DrawableElement> handleDrawableElements(
			JAXBElement<?> jaxbElement) {

		ArrayList<DrawableElement> drawableElements = new ArrayList<DrawableElement>();

		if (jaxbElement.getValue() instanceof Curve) {
			Curve curve = (Curve) jaxbElement.getValue();
			if (curve instanceof PolyLine) {
				drawableElements.add(addLine(curve));
			} else if (curve instanceof Line) {
				drawableElements.add(addLine(curve));
			}

			else if (curve instanceof Shape) {
				drawableElements.add(addShape(curve));
			}

			else if (curve instanceof Circle) {
				drawableElements.add(addCircle(curve));

			}

			else if (curve instanceof Ellipse) {
				drawableElements.add(addEllipse(curve));

			}
			// trimmed curve can either be a cirlce or a ellipse
			else if (curve instanceof TrimmedCurve) {
				if (((TrimmedCurve) curve).getCircle() != null) {
					drawableElements.add(addCircle(curve));
				} else if (((TrimmedCurve) curve).getEllipse() != null) {
					drawableElements.add(addEllipse(curve));
				}
			}

		}

		return drawableElements;
	}

	public LineElement addLine(Curve curve) {
		LineElement lineElement = null;

		if (curve instanceof PolyLine) {
			PolyLine polyLine = (PolyLine) curve;
			Color c = getColor(polyLine.getPresentation());
			float lineWeight = getLineWeight(polyLine.getPresentation());

			double xCoordinates[] = getXcoordinates(polyLine.getCoordinate());
			double yCoordinates[] = getYcoordinates(polyLine.getCoordinate());

			lineElement = new LineElement(c, lineWeight, xCoordinates,
					yCoordinates);
		}
		if (curve instanceof Line) {
			Line line = (Line) curve;
			Color c = getColor(line.getPresentation());
			float lineWeight = getLineWeight(line.getPresentation());

			double xCoordinates[] = getXcoordinates(line.getCoordinate());
			double yCoordinates[] = getYcoordinates(line.getCoordinate());

			lineElement = new LineElement(c, lineWeight, xCoordinates,
					yCoordinates);
		}
		return lineElement;
	}

	public ShapeElement addShape(Curve curve) {
		ShapeElement shapeElement = null;
		boolean filled = false;
		if (curve instanceof Shape) {
			Shape shape = (Shape) curve;
			Color c = getColor(shape.getPresentation());
			float lineWeight = getLineWeight(shape.getPresentation());

			double xCoordinates[] = getXcoordinates(shape.getCoordinate());
			double yCoordinates[] = getYcoordinates(shape.getCoordinate());

			if (shape.getFilled() != null && shape.getFilled().equals("Solid")) {
				filled = true;
			}
			shapeElement = new ShapeElement(c, lineWeight, xCoordinates,
					yCoordinates, filled);
		}
		return shapeElement;
	}

	private DrawableElement addEllipse(Curve curve) {
		EllipseElement ellipseElement = null;
		Ellipse ellipse = null;
		boolean filled = false;
		double startAngle = 0;
		double endAngle = 360;

		if (curve instanceof TrimmedCurve) {
			ellipse = ((TrimmedCurve) curve).getEllipse();

			startAngle = Math.ceil(((TrimmedCurve) curve).getStartAngle());
			endAngle = Math.ceil(((TrimmedCurve) curve).getEndAngle());

		} else if (curve instanceof Circle) {
			ellipse = (Ellipse) curve;
		}

		Color c = getColor(ellipse.getPresentation());

		float lineWeight = getLineWeight(ellipse.getPresentation());

		double position[] = getPosition(ellipse.getPosition());
		double primaryAxis;
		double secondaryAxis;
		try {
			primaryAxis = ellipse.getPrimaryAxis();
			secondaryAxis = ellipse.getSecondaryAxis();
		} catch (NullPointerException n) {
			primaryAxis = 0;
			secondaryAxis = 0;
		}
		if (ellipse.getFilled() != null && ellipse.getFilled().equals("Solid")) {
			filled = true;
		}

		ellipseElement = new EllipseElement(c, lineWeight, position,
				primaryAxis, secondaryAxis, startAngle, endAngle, filled);
		return ellipseElement;

	}

	public CircleElement addCircle(Curve curve) {
		CircleElement circleElement = null;
		Circle circle = null;
		boolean filled = false;
		double startAngle = 0;
		double endAngle = 360;

		if (curve instanceof TrimmedCurve) {
			circle = ((TrimmedCurve) curve).getCircle();

			startAngle = Math.ceil(((TrimmedCurve) curve).getStartAngle());
			endAngle = Math.ceil(((TrimmedCurve) curve).getEndAngle());

		} else if (curve instanceof Circle) {
			circle = (Circle) curve;
		}

		Color c = getColor(circle.getPresentation());

		float lineWeight = getLineWeight(circle.getPresentation());

		double position[] = getPosition(circle.getPosition());
		double radius;
		try {
			radius = circle.getRadius();
		} catch (NullPointerException n) {
			radius = 0;
		}
		if (circle.getFilled() != null && circle.getFilled().equals("Solid")) {
			filled = true;
		}

		circleElement = new CircleElement(c, lineWeight, position, radius,
				startAngle, endAngle, filled);
		return circleElement;

	}

	public TextElement addText(Text text) {

		TextElement textElement = new TextElement();

		// try to get the textAngle
		if (text.getTextAngle() != null) {
			textElement.setTextAngle(text.getTextAngle());
		} else {
			textElement.setTextAngle(0);
		}

		textElement.setExtent(getExtent(this.extent));// getExtent(object));

		for (Object object : text.getPresentationOrExtentOrPosition()) {

			// get the Color
			if (object instanceof Presentation) {
				textElement.setColor(getColor((Presentation) object));
			}
			// get the Position
			else if (object instanceof Position) {
				textElement.setPosition(getPosition(object));
			}
		}
		// TODO maybe make this dependable of size?
		// 0.8 is a guessed parameter, could be computed I guess

		try {
			textElement.setHeight(text.getHeight() * 0.8);
		} catch (NullPointerException n) {
			textElement.setHeight(0);
			ErrorElement eE = new ErrorElement("" + textElement.getLineNumber());
			eE.setDescription("Textheight could not be set");
			this.listOfErrors.add(eE);
		}
		textElement.setFont(text.getFont());

		if (text.getString() == null) {
			ErrorElement eE_3 = new ErrorElement("" + text.getLineNumber());

			eE_3.setDescription("Text does not have the mandatory String-Attribute. Creation of Text tried with Dependant Attributes - DEPRECATED!");
			this.listOfErrors.add(eE_3);

			// check if ItemID is present and has a
			// corresponding ID
			textElement.setString("DEP-ATTRIBUTE");

			if (text.getDependantAttribute()
					.equals("[NominalDiameterNumericalValueRepresentationAssignmentClass]")) {
				this.loggerList
						.add("WARNING: USAGE OF NODES FOR DEPENDANT ATTRIBUTES IS UNSAFE! @Line"
								+ text.getLineNumber());
				if (this.counter < this.persistentIDTextElements.size()) {
					text = this.persistentIDTextElements.get(this.counter);
					++this.counter;
				}
				text.setDependantAttribute(text.getString());
			}

			if (text.getItemID() != null
					&& text.getDependantAttribute() != null) {

				PlantItem plantItem = checkItemID(text.getItemID());

				if (plantItem == null) {
					textElement.setString("");
					ErrorElement eE_2 = new ErrorElement(""
							+ text.getLineNumber());

					eE_2.setDescription("ItemID doesnt correspond to any ID");

					this.listOfErrors.add(eE_2);
				} else {
					String depAttrText = getDepAttrText(plantItem, text).trim();
					text.setString(null);
					textElement.setString(depAttrText);
				}
			} else {
				textElement.setString("");
				ErrorElement eE;

				boolean isItemIDMissing = (text.getItemID() == null);
				boolean isStringMissing = (text.getString() == null);
				boolean isDependantAttributeMissing = (text
						.getDependantAttribute() == null);

				String errorMessage = "The following attributes are null: \n";

				if (!isItemIDMissing) {
					eE = new ErrorElement(text.getLineNumber()
							+ text.getItemID().toString());
				} else if (!isStringMissing) {
					eE = new ErrorElement(text.getLineNumber()
							+ text.getString());
				} else {
					eE = new ErrorElement(text.getLineNumber()
							+ "unkown identifier");
				}

				if (isItemIDMissing)
					errorMessage += "ItemID\n";
				if (isStringMissing)
					errorMessage += "String\n";
				if (isDependantAttributeMissing)
					errorMessage += "DependantAttribute\n";

				eE.setDescription(errorMessage);
				this.listOfErrors.add(eE);
			}

		} else {
			textElement.setString(text.getString());
		}

		return textElement;
	}

	/**
	 * checks the dependantAttribute of a text, looks for the corresponding
	 * genericAttributes and composes a string
	 * 
	 * @param plantItem
	 *            the plantItem with the corresponding ID to the texts ItemID
	 * @param text
	 *            the text
	 * @return a string with the desired values of genericAttributes
	 */

	@Deprecated
	private java.lang.String getDepAttrText(PlantItem plantItem, Text text)
			throws NullPointerException {

		// TODO retransform this function so it checks in multiple sets and make
		// it a check-function whether string && depAttr. are equal!

		java.lang.String textForLabel = text.getDependantAttribute().toString();
		ArrayList<GenericAttributes> listOfGenericAttributes = new ArrayList<>();
		for (Object object : plantItem.getPresentationOrExtentOrPersistentID()) {
			// get GenericAttributes
			if (object instanceof GenericAttributes) {
				listOfGenericAttributes.add((GenericAttributes) object);
			}
		}

		// Split depAttributes into Array
		// Pattern.quote(.) necessary due to "[" causing a regex-error
		// else
		java.lang.String[] depAttributes = (text.getDependantAttribute()
				.toString().split("(?=" + Pattern.quote("[") + ")|(?<="
				+ Pattern.quote("]") + ")"));

		// this var is necessary so we can get information on runtime whether
		// this information has changed
		String comparisionString = textForLabel;

		for (GenericAttributes genericAttributes : listOfGenericAttributes) {

			// search for depAttribute in genericAttributes
			// and replace depAttribute w/ corresponding
			// genericAttribute in textForLabel

			// so we have found what we were out to find and have applied it
			if (!textForLabel.contains("ThisIsATrueTextErrorCode")
					&& !textForLabel.equals(comparisionString))
				break;

			boolean[] markerMatrix = new boolean[depAttributes.length];
			Arrays.fill(markerMatrix, Boolean.TRUE);

			// This loop handles the standard-issue of not distinguishing
			// between value and unit - special cases are handled afterwards

			for (int i = 0; i < depAttributes.length; i++) {
				// get handle on single element and replace occurances of
				// special character
				java.lang.String depAttribute = depAttributes[i].toString();

				if (depAttribute.startsWith("[")) {

					depAttribute = depAttribute.replace("[", "");
					depAttribute = depAttribute.replace("]", "");
					depAttribute = depAttribute.replace(" ", "");
					depAttribute = depAttribute.replace("-", "");

					// get List of GenericAttributes
					for (Object object2 : genericAttributes.getContent()) {

						if (object2 instanceof GenericAttribute) {
							GenericAttribute genericAttribute = (GenericAttribute) object2;

							// search for depAttribute in genericAttributes
							if (genericAttribute.getName().equals(depAttribute)) {

								// replace depAttribute with corresponding
								// genericAttribute

								try {
									textForLabel = textForLabel.replace(
											depAttribute,
											genericAttribute.getValue()
													.toString()
													+ checkUnits(
															genericAttribute,
															text));
									// this marks the attribute as used
									markerMatrix[i] = false;
								} catch (Exception e) {
									textForLabel = textForLabel.replace(
											depAttribute, "");
									ErrorElement eE = new ErrorElement("" + genericAttribute.getLineNumber());

									eE.setDescription("Catched a nullpointer-exception in getDepAttrText");

									this.listOfErrors.add(eE);
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < depAttributes.length; ++i) {
				// sort out illegal bracket-strings [ATTRIBUTE_NOT_ALLOWED]
				String curElement = depAttributes[i];
				if (markerMatrix[i] && curElement.startsWith("[")) {
					// sort out custom tag-name for internal id-referencing
					// for nodes

					// [TagName] will be handled afterwards!
					if (!curElement.equals("[TagName]")) {
						// Now we have to take a look at illegal as well as
						// non-default attributes like [thisIsNotValid] or
						// [DesignVolumeFlowRate.value]
						boolean isInvalid = true;

						validationCheck: if (curElement.contains(".")) {
							String[] possibleValidCandidate = curElement
									.split(Pattern.quote("."));

							if (possibleValidCandidate.length != 2)
								break validationCheck;

							// reformat string
							for (int jay = 0; jay < possibleValidCandidate.length; ++jay) {
								String str = possibleValidCandidate[jay];

								str = str.replace("[", "");
								str = str.replace("]", "");
								str = str.replace(" ", "");
								str = str.replace("-", "");

								possibleValidCandidate[jay] = str;
							}

							// catch possible uppercase-problem
							possibleValidCandidate[1] = possibleValidCandidate[1]
									.toLowerCase();

							// get handle on genericAttributes
							for (Object object2 : genericAttributes
									.getContent()) {

								if (object2 instanceof GenericAttribute) {

									GenericAttribute genericAttribute = (GenericAttribute) object2;
									if (genericAttribute.getName().equals(
											possibleValidCandidate[0])) {

										switch (possibleValidCandidate[1]) {
										case ("values"):
										case ("value"):
											textForLabel = textForLabel
													.replace(curElement,
															genericAttribute
																	.getValue());
											isInvalid = false;
											break;
										case ("unit"):
										case ("units"):
											textForLabel = textForLabel
													.replace(
															curElement,
															checkUnits(
																	genericAttribute,
																	text));
											isInvalid = false;
											break;
										default:
										}
									}
								}
							}
						}

						if (isInvalid) {
							textForLabel = textForLabel.replace(curElement, "");
							textForLabel = "[ThisIsATrueTextErrorCode"
									+ text.getLineNumber() + "]";
						}
					}
				}
			}
		}

		if (textForLabel.contains("ThisIsATrueTextErrorCode")) {
			ErrorElement eE = new ErrorElement("" + text.getLineNumber());
			eE.setDescription("Given dependantAttribute could not be matched!");
			this.listOfErrors.add(eE);
		}

		if (plantItem.getTagName() != null)
			textForLabel = textForLabel.replace("[TagName]",
					plantItem.getTagName());
		else
			textForLabel = textForLabel.replace("[TagName]", "");

		textForLabel = textForLabel.replace("[", "");
		textForLabel = textForLabel.replace("]", "");
		return textForLabel;
	}

	/**
	 * checks if unit should be included in the string and abbreviates some of
	 * them according to the SI standard
	 * 
	 * @param genericAttribute
	 * @param text
	 * @return
	 */
	@SuppressWarnings("static-method")
	private java.lang.String checkUnits(GenericAttribute genericAttribute,
			Text text) {
		// check for Units
		java.lang.String unit = "";
		if (genericAttribute.getUnits() != null
				&& text.getDependantAttributeContents() == "ValueAndUnits") {

			// make better looking units
			switch (genericAttribute.getUnits()) {
			case "DegreeCelsius":
				unit = "\u00B0C"; // unicode f�r
									// Grad
				break;
			case "Kilowatt":
				unit = "kW";
				break;
			case "Millimetre":
				unit = "mm";
				break;
			case "Metre":
				unit = "m";
				break;
			case "SquareMetre":
				unit = "m\u00b2"; // unicode f�r ^2
				break;
			case "MetreSquared":
				unit = "m\u00b2"; // unicode f�r ^2
				break;
			case "MetreCubed":
				unit = "m\u00b3";
				break;
			case "MetreCubedPerHour":
				unit = "m\u00b3/h";
				break;
			case "RevolutionPerMinute":
				unit = "1/min";
				break;
			default:
				unit = genericAttribute.getUnits();
			}
		}
		return unit;
	}

	@SuppressWarnings("static-method")
	public double[] getPosition(Object object) {

		double position[] = new double[2];
		if (object instanceof Position) {
			position[0] = ((Position) object).getLocation().getX();
			position[1] = ((Position) object).getLocation().getY();
		}

		return position;
	}

	@SuppressWarnings("static-method")
	public double[] getExtent(Object object) {

		double extent[] = new double[4];

		if (object instanceof Extent) {
			try {
				extent[0] = ((Extent) object).getMin().getX();
				extent[1] = ((Extent) object).getMax().getX();

				extent[2] = ((Extent) object).getMin().getY();
				extent[3] = ((Extent) object).getMax().getY();
			} catch (Exception e) {
				extent = null;
			}
		}
		return extent;
	}

	public float getLineWeight(Presentation presentation) {
		float f = 0;
		try {
			f = Float.parseFloat(presentation.getLineWeight().toString());
		} catch (Exception e) {

			int ln = -1;

			if (presentation != null)
				ln = presentation.getLineNumber();

			ErrorElement eE = new ErrorElement("" + ln);
			eE.setDescription("LineWeight could not be retrieved!");

			this.listOfErrors.add(eE);
		}
		return f;
	}

	@SuppressWarnings("static-method")
	public Color getColor(Presentation presentation) {
		try {
			Color c = new Color((int) (presentation.getR() * 255),
					(int) (presentation.getG() * 255),
					(int) (presentation.getB() * 255));
			return c;
		} catch (NullPointerException n) {
			// Color c = new Color(255, 020, 147);
			return null;
		}

	}

	@SuppressWarnings("static-method")
	public double[] getXcoordinates(List<Coordinate> coordinates) {

		double xCoordinates[] = new double[coordinates.size()];

		for (int i = 0; i < coordinates.size(); i++) {
			xCoordinates[i] = coordinates.get(i).getX();
		}
		return xCoordinates;
	}

	@SuppressWarnings("static-method")
	public double[] getYcoordinates(List<Coordinate> coordinates) {

		double yCoordinates[] = new double[coordinates.size()];
		for (int i = 0; i < coordinates.size(); i++) {
			yCoordinates[i] = coordinates.get(i).getY();
		}
		return yCoordinates;
	}

	/**
	 * in case the shapeCatalogue is referenced, the position, reference, and
	 * scale of a pidElement is set here
	 *
	 * @param annotationItem
	 *            the annotationItem
	 * @param pidElement
	 *            the pidElement
	 * @return modified pidElement
	 */
	@SuppressWarnings("static-method")
	private PidElement setScaleRefPos(AnnotationItem annotationItem,
			PidElement pidElement) {
		for (Object object : annotationItem
				.getPresentationOrExtentOrPersistentID()) {
			if (object instanceof Position) {
				Position position = (Position) object;
				if (position.getReference() != null) {
					pidElement.setReference(new double[] {
							position.getReference().getX(),
							position.getReference().getY() });
					pidElement.setPosition(new double[] {
							position.getLocation().getX(),
							position.getLocation().getY() });
				} else {
					pidElement.setReference(null);
				}

			}
			if (object instanceof Scale) {
				Scale scale = (Scale) object;
				pidElement
						.setScale(new double[] { scale.getX(), scale.getY() });
			}
		}
		return pidElement;
	}

	/**
	 * in case the shapeCatalogue is referenced, the position, reference, and
	 * scale of a pidElement is set here
	 * 
	 * @param plantItem
	 *            the plantItem
	 * @param pidElement
	 *            the pidElement
	 * @return the modified pidElement
	 */
	@SuppressWarnings("static-method")
	public PidElement setScaleRefPos(PlantItem plantItem, PidElement pidElement) {

		for (Object object : plantItem.getPresentationOrExtentOrPersistentID()) {
			if (object instanceof Position) {
				Position position = (Position) object;

				pidElement.setReference(new double[] {
						position.getReference().getX(),
						position.getReference().getY() });
				pidElement.setPosition(new double[] {
						position.getLocation().getX(),
						position.getLocation().getY() });
			} else if (object instanceof Scale) {
				Scale scale = (Scale) object;
				pidElement
						.setScale(new double[] { scale.getX(), scale.getY() });
			}
		}
		return pidElement;
	}

	@Override
	public Locator getLocator() {
		return this.locator;
	}

	@Override
	public ArrayList<ErrorElement> getErrorList() {
		return this.listOfErrors;
	}

	@Override
	public ArrayList<String> getLoggerList() {
		return this.loggerList;
	}
}
