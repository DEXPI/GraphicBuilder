package org.dexpi.pid.imaging;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

//import javax.swing.plaf.SeparatorUI;

import org.dexpi.pid.imaging.drawableElements.CircleElement;
import org.dexpi.pid.imaging.drawableElements.DrawableElement;
import org.dexpi.pid.imaging.drawableElements.EllipseElement;
import org.dexpi.pid.imaging.drawableElements.LineElement;
import org.dexpi.pid.imaging.drawableElements.ShapeElement;
import org.dexpi.pid.imaging.drawableElements.TextElement;
import org.dexpi.pid.imaging.pidElements.ErrorElement;
import org.dexpi.pid.imaging.pidElements.PidElement;
import org.dexpi.pid.xml.PlantItem;

/**
 * Gets all relevant data from the input repository, checks it for errors and
 * creates an errorlog, and finally hands it over to the graphic factory for
 * drawing. In addition a html-imagemap is created.
 * 
 * The GraphicBuilder returns a BufferedImage via buildImage(resolutionX) which
 * can be written to a file by passing it to an imageWriter
 * 
 * 
 * 
 * 
 * @see ImageMapObject
 * @see InputRepository
 * @see GraphicFactory
 * 
 *
 */
public class GraphicBuilder {

	public static double GBVERSION = 1.0;

	private InputRepository inputRep; // gets the (xml) input and transforms it
										// to classes
	private GraphicFactory gFac; // draws the classes to a file
	private JaxbErrorLogRepository errorRep; // used for error output file
	private ArrayList<ErrorElement> listOfErrors = new ArrayList<ErrorElement>();
	private Locator locator; // locates the line number for error output file

	// default style in case presentation is missing
	private Color defaultColor = new Color(255, 0, 0);
	private float defaultLineWeight = (float) 0.25;
	private String defaultFont = "Arial";
	private double defaultTextHeight = 6.5;
	private Logger logger;

	public PrintStream outStreamHandle = System.out;

	/**
	 * Initializes the GraphicBuilder.
	 * 
	 * 
	 * @param inputRep
	 *            the input repository
	 * @param gFac
	 *            the graphic factory
	 * @param errorRep
	 *            the error repository
	 */
	public GraphicBuilder(InputRepository inputRep, GraphicFactory gFac, JaxbErrorLogRepository errorRep) {
		this.inputRep = inputRep;
		this.gFac = gFac;
		this.errorRep = errorRep;
		this.locator = inputRep.getLocator();
	}

	/**
	 * gets the relevant data from the inputRepository
	 */
	public void getInputData() {

		PidElement drawing = this.inputRep.getDrawing();
		if (drawing != null) {
			drawPidElement(drawing);
		} else {
			ErrorElement newError = new ErrorElement("Drawing", "-", "-");
			newError.setDescription("Drawing is missing");
			this.listOfErrors.add(newError);
		}

		ArrayList<PidElement> listOfPlantItems = this.inputRep.getPlantItems();

		if (listOfPlantItems != null)
			drawList(listOfPlantItems);
		else {
			System.out.println("This is null");
		}

		createImageMapElements(listOfPlantItems);

		ArrayList<PidElement> listOfAnnotationItems = this.inputRep.getAnnotationItems();
		drawList(listOfAnnotationItems);

		ArrayList<PidElement> listOfPiping = this.inputRep.getPiping();
		drawList(listOfPiping);

		if (!this.inputRep.getLoggerList().isEmpty()) {
			// NOTE currently we only use the GraphicBuidler logger here,
			// therefore it will only be created if necessary
			TinyFormatter fmt = new TinyFormatter();
			StreamHandler sh = new StreamHandler(this.outStreamHandle, fmt);

			this.logger = Logger.getLogger(GraphicBuilder.class.getName());

			logger.setUseParentHandlers(false);

			this.logger.addHandler(sh);

			for (String warning : this.inputRep.getLoggerList()) {
				this.logger.warning(warning);
			}
		}

		ArrayList<ErrorElement> listOfInputRepErrors = this.inputRep.getErrorList();
		for (ErrorElement error : listOfInputRepErrors) {
			this.listOfErrors.add(error);
		}

		ArrayList<ErrorElement> listOfGraphicFactoryErrors = this.gFac.getErrorList();
		for (ErrorElement error : listOfGraphicFactoryErrors) {
			this.listOfErrors.add(error);
		}
	}

	/**
	 * Creates an imageMapElement that later will be displayed in the imageMap
	 * 
	 * @param listOfElements
	 *            the list of Elements that should be displayed in the imageMap
	 */
	private void createImageMapElements(ArrayList<PidElement> listOfElements) {
		for (PidElement pidElement : listOfElements) {
			if (pidElement.getDrawableElements().isEmpty() == false) {
				this.gFac.addImageMapElement(pidElement);
			}
		}

	}

	/**
	 * Loops through the list and draws each element
	 * 
	 * @param listOfElements
	 *            the elements to be drawn
	 */
	private void drawList(ArrayList<PidElement> listOfElements) {
		for (PidElement pidElement : listOfElements) {
			drawPidElement(pidElement);
			if (pidElement.getSubElements() != null)
				for (PidElement subElement : pidElement.getSubElements()) {
					drawPidElement(subElement);
				}
			else {
				System.out.println("Ok, this is null for " + pidElement.getClass());
				System.out.println("Line: " + pidElement.getLineNumber());
			}
		}
	}

	/**
	 * Checks the pidElement for errors, if none are found it will be drawn. Any
	 * occuring errors in the pidElement or its drawableElements will be added to
	 * the errorLog.
	 *
	 * @param pidElement
	 *            the element to be drawn
	 */
	private void drawPidElement(PidElement pidElement) {
		// check element for Errors
		ErrorElement eE = checkPidElement(pidElement);
		if (eE != null) {
			this.listOfErrors.add(eE);
		} else {
			// set Scale, Reference and Position if SC is referenced
			if (pidElement.getScRef() == true) {
				this.gFac.setScaleAnglePos(pidElement.getReference(), pidElement.getScale(), pidElement.getPosition());
			}

			// start drawing the Element
			ArrayList<String> drwElmErrors = drawElements(pidElement);

			// reset Scale, Reference and Position
			this.gFac.resetScaleAnglePos();

			// if errors occured in drawableElements->add new error to list
			if (drwElmErrors.isEmpty() == false) {
				ErrorElement newError = new ErrorElement(pidElement.getID(), pidElement.getComponentName(),
						pidElement.getComponentClass(), pidElement.getLineNumber());
				newError.setSubDescription(drwElmErrors);
				this.listOfErrors.add(newError);
			}
		}
	}

	/**
	 * Checks the drawableElements of a pidElement for errors and draws them. Should
	 * only minor errors occur, the drawableElement will be drawn with a default
	 * "Presentation".
	 * 
	 * @param pidElement
	 * @return list of errors that occured while drawing
	 */
	private ArrayList<String> drawElements(PidElement pidElement) {
		ArrayList<String> drwElmErrors = new ArrayList<String>();

		// count the n-th occurence of each object
		// used for location in case of error
		int l = 0; // line
		int s = 0; // shape
		int t = 0; // text
		int c = 0; // circle
		int e = 0; // ellipse

		// set the current group accordingly to the information given
		//TODO update
		this.gFac.setCurrentGroupNode(pidElement.getID(), pidElement.getTagName(), pidElement.getComponentName(), pidElement.getComponentClass());

		int counter = 0;

		// check if each drawableElement is correct -
		// checkAndDraw generates errorMsg and draws element with default
		// presentation if possible
		for (Object object : pidElement.getDrawableElements()) {
			++counter;
			// NOTE: Switch not applicable due to switch(object) not being
			// implemented in java || state Nov2015

			if (object instanceof LineElement) {
				l++;
				LineElement line = (LineElement) object;
				if (checkLineElement(line) == true) {
					addLineElement(line);
				} else {
					drwElmErrors.add(checkAndDrawLine(l, line, pidElement));
				}
			} else if (object instanceof ShapeElement) {
				s++;
				ShapeElement shape = (ShapeElement) object;
				if (checkShapeElement(shape) == true) {
					addShapeElement(shape);
				} else {
					drwElmErrors.add(checkAndDrawShape(s, shape, pidElement));
				}
			} else if (object instanceof TextElement) {
				t++;

				TextElement text = (TextElement) object;

				if (checkTextElement(text) == true) {
					addTextElement(text);
				} else {
					drwElmErrors.add(checkAndDrawText(t, text, pidElement));
				}
			} else if (object instanceof CircleElement) {
				c++;
				CircleElement circle = (CircleElement) object;
				if (checkCircleElement(circle) == true) {
					addCircleElement(circle);
				} else {
					drwElmErrors.add(checkAndDrawCircle(c, circle, pidElement));
				}
			} else if (object instanceof EllipseElement) {
				e++;
				EllipseElement ellipse = (EllipseElement) object;
				if (checkEllipseElement(ellipse) == true) {
					addEllipseElement(ellipse);
				} else {
					drwElmErrors.add(checkAndDrawEllipse(e, ellipse, pidElement));
				}
			}
		}

		if (counter != 0)
			this.gFac.addNodeToRoot();

		// reset current node
		this.gFac.setCurrentGroupNode(null, null, null, null);

		return drwElmErrors;
	}

	/**
	 * sets lineNumber and returns an error message
	 * 
	 * @param e
	 *            the nth occurence of an ellipse in the pidElement
	 * @param ellipse
	 *            the ellipse
	 * @param pidElement
	 *            the pidElement that contains the ellipse
	 * @return the error message
	 */
	private String checkAndDrawEllipse(int e, EllipseElement ellipse, PidElement pidElement) {
		ellipse.setLineNumber(this.locator.getLineNumber(pidElement.getLineNumber(), e, "Ellipse"));
		return getEllipseErrorMsg(ellipse);

	}

	/**
	 * sets lineNumber and returns an error message
	 * 
	 * @param c
	 *            the nth occurence of a circle in the pidElement
	 * @param circle
	 *            the circle
	 * @param pidElement
	 *            the pidElement that contains the circle
	 * @return the error message
	 */
	private String checkAndDrawCircle(int c, CircleElement circle, PidElement pidElement) {
		circle.setLineNumber(this.locator.getLineNumber(pidElement.getLineNumber(), c, "Circle"));
		return getCircleErrorMsg(circle);

	}

	/**
	 * sets lineNumber and returns an error message
	 * 
	 * @param t
	 *            the nth occurence of a text in the pidElement
	 * @param text
	 *            the text
	 * @param pidElement
	 *            the pidElement that contains the text
	 * @return the error message
	 */
	private String checkAndDrawText(int t, TextElement text, PidElement pidElement) {
		text.setLineNumber(this.locator.getLineNumber(pidElement.getLineNumber(), t, "Text"));
		return getTextErrorMsg(text);
	}

	/**
	 * sets lineNumber and returns an error message
	 * 
	 * @param s
	 *            the nth occurence of a shape in the pidElement
	 * @param shape
	 *            the shape
	 * @param pidElement
	 *            the pidElement that contains the shape
	 * @return the error message
	 */
	private String checkAndDrawShape(int s, ShapeElement shape, PidElement pidElement) {

		shape.setLineNumber(this.locator.getLineNumber(pidElement.getLineNumber(), s, "Shape"));
		return getShapeErrorMsg(shape);
	}

	/**
	 * sets lineNumber and returns an error message
	 * 
	 * @param l
	 *            the nth occurence of a line in the pidElement
	 * @param line
	 *            the line
	 * @param pidElement
	 *            the pidElement that contains the line
	 * @return the error message
	 */
	private String checkAndDrawLine(int l, LineElement line, PidElement pidElement) {

		if (pidElement.getType() != null && pidElement.getType().equals("CenterLine")) {
			line.setLineNumber(pidElement.getLineNumber());
		} else {
			line.setLineNumber(this.locator.getLineNumber(pidElement.getLineNumber(), l, "Line"));
		}
		return getLineErrorMsg(line);
	}

	/**
	 * checks if the pidElement is correct and returns an errorElement
	 * 
	 * @param pidElement
	 *            the pidElement to be checked
	 * @return the errorElement containing all errors
	 */
	private ErrorElement checkPidElement(PidElement pidElement) {
		String id = null;
		String componentName = "";
		String componentClass = "";
		String errorMsg = "";

		if (pidElement.getID() == null && pidElement.getType() != "CenterLine") {
			pidElement.setLineNumber(this.locator.getLineNumberByMissingID(pidElement.getType()));
			errorMsg = errorMsg.replace(" ", ",") + "id ";
		} else {
			id = pidElement.getID();
		}
		if (pidElement.getComponentName() != null) {
			componentName = pidElement.getComponentName();
		}
		if (pidElement.getComponentClass() != null) {
			componentClass = pidElement.getComponentClass();
		}

		errorMsg = checkScaleRefPos(pidElement, errorMsg);

		errorMsg = getExtentErrorMsg(pidElement, errorMsg);

		errorMsg = checkDrawingAttributes(pidElement, errorMsg);

		if (errorMsg != "") {
			// in case Sc-reference is used:
			if (errorMsg.contains("reference") || errorMsg.contains("scale") || errorMsg.contains("position")
					|| errorMsg.contains("extent")) {
				if (pidElement.getSubElements() != null && pidElement.getScRef() == true) {
					pidElement.setLineNumber(pidElement.getSubElements().get(0).getLineNumber());
					id = pidElement.getSubElements().get(0).getID();
				}
			}

			ErrorElement pidError = new ErrorElement(id, componentName, componentClass, pidElement.getLineNumber());
			errorMsg = errorMsg.substring(0, 1).toUpperCase() + errorMsg.substring(1);
			pidError.setDescription(errorMsg + "missing or incorrect");
			return pidError;
		}
		return null;
	}

	/**
	 * if the pidElement is the "Drawing", its unique attributes get checked and the
	 * error message gets modified
	 * 
	 * @param pidElement
	 *            the pidElement
	 * @param errorMsg
	 *            the error message to be modified
	 * @return a modified error message
	 */
	@SuppressWarnings("static-method")
	private String checkDrawingAttributes(PidElement pidElement, String errorMsg) {
		if (pidElement.getID() == "Drawing") {
			if (pidElement.getComponentName() == null) {
				errorMsg = errorMsg.replace(" ", ",") + "name ";
			}
			if (pidElement.getComponentClass() == null) {
				errorMsg = errorMsg.replace(" ", ",") + "type ";
			}
		}
		return errorMsg;
	}

	/**
	 * Checks if scale, reference and position are correct and changes the error
	 * message accordingly.
	 * 
	 * @param pidElement
	 *            the pidElement to be checked
	 * @param errorMsg
	 *            the error message to be modified
	 * @return the modified error message
	 */
	@SuppressWarnings("static-method")
	private String checkScaleRefPos(PidElement pidElement, String errorMsg) {

		if (pidElement.getScale() == null) {
			errorMsg = errorMsg.replace(" ", ",") + "scale ";
		}
		if (pidElement.getPosition() == null && pidElement.getScRef() == true) {
			errorMsg = errorMsg.replace(" ", ",") + "position ";
		}

		if (pidElement.getReference() == null) {
			errorMsg = errorMsg.replace(" ", ",") + "reference ";
		} else {
			double[] ref = pidElement.getReference();
			if (Math.abs(1 - (ref[0] * ref[0] + ref[1] * ref[1])) > 0.000303) {
				errorMsg = errorMsg.replace(" ", ",") + "reference ";
			}
		}
		return errorMsg;
	}

	/**
	 * Checks the extent of the pidElement and changes the error message
	 * accordingly.
	 * 
	 * @param pidElement
	 *            the pidElement to be checked
	 * @param errorMsg
	 *            the error message to be modified
	 * @return the modified error message
	 */
	@SuppressWarnings("static-method")
	private String getExtentErrorMsg(PidElement pidElement, String errorMsg) {
		if (pidElement.getExtent() == null && pidElement.getType() != "PipingNetworkSystem"
				&& pidElement.getType() != "PipingNetworkSegment" && pidElement.getID() != "Drawing") {
			if (pidElement.getDrawableElements().isEmpty() == false) {
				// if no drawableElements present extent is not necessary
				errorMsg = errorMsg.replace(" ", ",") + "extent ";
			}
		}
		return errorMsg;
	}

	/**
	 * checks if all attributes necessary for drawing are present
	 * 
	 * @param circle
	 *            the circle
	 * @return true if correct
	 */
	private boolean checkCircleElement(CircleElement circle) {
		boolean correct = true;
		if (checkPresentation(circle) == false) {
			correct = false;
		}
		if (checkPosition(circle.getPosition()) == false) {
			correct = false;
		}
		if (checkRadius(circle.getRadius()) == false) {
			correct = false;
		}
		return correct;
	}

	/**
	 * composes an error message
	 * 
	 * @param circleElement
	 *            the circle
	 * @return the error message
	 */
	private String getCircleErrorMsg(CircleElement circleElement) {
		String errorMsg = "";
		errorMsg = getPresentationErrorMsg(errorMsg, circleElement);
		errorMsg = getPositionErrorMsg(errorMsg, circleElement.getPosition());
		errorMsg = getRadiusErrorMsg(errorMsg, circleElement.getRadius());

		if (errorMsg != "") {
			addDefaultCircle(circleElement);
			errorMsg = "Line #" + circleElement.getLineNumber() + " - Cannot draw circle: " + errorMsg
					+ "missing or incorrect.";
			return errorMsg;
		}

		return null;
	}

	/**
	 * if only "Presentation" is incorrect a default presentation is set for drawing
	 * 
	 * @param circle
	 *            the circle
	 */
	private void addDefaultCircle(CircleElement circle) {
		if (checkPosition(circle.getPosition()) == true && checkRadius(circle.getRadius()) == true) {
			circle.setColor(this.defaultColor);
			circle.setLineWeight(this.defaultLineWeight);
			addCircleElement(circle);
		}
	}

	/**
	 * checks if all attributes necessary for drawing are present
	 * 
	 * @param ellipse
	 *            the ellipse
	 * @return true if correct
	 */
	private boolean checkEllipseElement(EllipseElement ellipse) {
		boolean correct = true;
		if (checkPresentation(ellipse) == false) {
			correct = false;
		}
		if (checkPosition(ellipse.getPosition()) == false) {
			correct = false;
		}
		if (checkAxis(ellipse.getPrimaryAxis(), ellipse.getSecondaryAxis()) == false) {
			correct = false;
		}
		return correct;

	}

	/**
	 * composes an error message
	 * 
	 * @param ellipse
	 *            the ellipse
	 * @return the error message
	 */
	private String getEllipseErrorMsg(EllipseElement ellipse) {
		String errorMsg = "";
		errorMsg = getPresentationErrorMsg(errorMsg, ellipse);
		errorMsg = getPositionErrorMsg(errorMsg, ellipse.getPosition());
		errorMsg = getAxisErrorMsg(errorMsg, ellipse.getPrimaryAxis(), ellipse.getSecondaryAxis());

		addDefaultEllipse(ellipse);
		errorMsg = "Line #" + ellipse.getLineNumber() + " - Cannot draw ellipse: " + errorMsg + "missing or incorrect.";
		return errorMsg;

	}

	/**
	 * if only "Presentation" is incorrect a default presentation is set for drawing
	 * 
	 * @param ellipse
	 *            the ellipse
	 */
	private void addDefaultEllipse(EllipseElement ellipse) {
		if (checkPosition(ellipse.getPosition()) == true
				&& checkAxis(ellipse.getPrimaryAxis(), ellipse.getSecondaryAxis()) == true) {
			ellipse.setColor(this.defaultColor);
			ellipse.setLineWeight(this.defaultLineWeight);
			addEllipseElement(ellipse);
		}
	}

	/**
	 * checks if all attributes necessary for drawing are present
	 * 
	 * @param text
	 *            the text
	 * @return true if correct
	 */
	private boolean checkTextElement(TextElement text) {
		if (checkPresentation(text) == false) {
			return false;
		}
		if (checkPosition(text.getPosition()) == false) {
			return false;
		}
		if (checkExtent(text.getExtent()) == false) {
			return false;
		}
		if (text.getHeight() == 0) {
			return false;
		}
		if (text.getFont() == null) {
			return false;
		}

		if (text.getString().contains("ThisIsATrueTextErrorCode")) {
			return false;
		}

		return true;
	}

	/**
	 * composes an error message
	 * 
	 * @param textElement
	 *            the text
	 * @return the error message
	 */
	private String getTextErrorMsg(TextElement textElement) {
		String errorMsg = "";
		errorMsg = getPresentationErrorMsg(errorMsg, textElement);
		errorMsg = getPositionErrorMsg(errorMsg, textElement.getPosition());
		errorMsg = getExtentErrorMsg(errorMsg, textElement.getExtent());

		if (textElement.getHeight() == 0) {
			errorMsg = errorMsg.replace(" ", ",") + "textheight ";
		}
		if (textElement.getFont() == null) {
			errorMsg = errorMsg.replace(" ", ",") + "font ";
		}

		if (textElement.getString() == null) {
			errorMsg = errorMsg.replace(" ", ",") + "String is null ";
		}

		if (textElement.getString().contains("ThisIsATrueTextErrorCode")) {
			errorMsg = errorMsg.replace(" ", ",") + "Given dependent attribute could not be matched, is ";
		}

		if (errorMsg != "") {
			addDefaultTextElement(textElement);
			errorMsg = "Line #" + textElement.getLineNumber() + " - Cannot draw text: " + errorMsg
					+ "missing or incorrect.";
			return errorMsg;
		}

		return null;
	}

	/**
	 * if only "Presentation" is incorrect a default presentation is set for drawing
	 * 
	 * @param textElement
	 *            the text
	 */
	private void addDefaultTextElement(TextElement textElement) {
		if (checkPosition(textElement.getPosition()) == false && checkExtent(textElement.getExtent()) == false) {
			textElement.setFont(this.defaultFont);
			textElement.setHeight(this.defaultTextHeight);
			textElement.setColor(this.defaultColor);
			addTextElement(textElement);
		}
	}

	/**
	 * checks if all attributes necessary for drawing are present
	 * 
	 * @param shape
	 *            the shape
	 * @return true if correct
	 */
	private boolean checkShapeElement(ShapeElement shape) {
		boolean correct = true;
		if (checkPresentation(shape) == false) {
			correct = false;
		}
		if (checkCoordinates(shape.getXCoordinates(), shape.getYCoordinates()) == false) {
			correct = false;
		}

		return correct;

	}

	/**
	 * composes an error message
	 * 
	 * @param shapeElement
	 *            the shape
	 * @return the error message
	 */
	private String getShapeErrorMsg(ShapeElement shapeElement) {
		String errorMsg = "";
		errorMsg = getPresentationErrorMsg(errorMsg, shapeElement);
		errorMsg = getCoordinateErrorMsg(errorMsg, shapeElement.getXCoordinates(), shapeElement.getYCoordinates());

		if (errorMsg != "") {
			addDefaultShapeElement(shapeElement);
			errorMsg = "Line #" + shapeElement.getLineNumber() + " - Cannot draw shape: " + errorMsg
					+ "missing or incorrect.";
			return errorMsg;
		}

		return null;
	}

	/**
	 * if only "Presentation" is incorrect a default presentation is set for drawing
	 * 
	 * @param shapeElement
	 *            the shape
	 */
	private void addDefaultShapeElement(ShapeElement shapeElement) {
		if (checkCoordinates(shapeElement.getXCoordinates(), shapeElement.getYCoordinates()) == true) {
			shapeElement.setColor(this.defaultColor);
			shapeElement.setLineWeight(this.defaultLineWeight);
			addShapeElement(shapeElement);
		}

	}

	/**
	 * checks if all attributes necessary for drawing are present
	 * 
	 * @param lineElement
	 *            the line
	 * @return true if correct
	 */
	private boolean checkLineElement(LineElement lineElement) {
		boolean correct = true;
		if (checkPresentation(lineElement) == false) {
			correct = false;
		}
		if (checkCoordinates(lineElement.getXCoordinates(), lineElement.getYCoordinates()) == false) {
			correct = false;
		}

		return correct;
	}

	/**
	 * composes an error message
	 * 
	 * @param lineElement
	 *            the line
	 * @return the error message
	 */
	private String getLineErrorMsg(LineElement lineElement) {
		String errorMsg = "";
		errorMsg = getPresentationErrorMsg(errorMsg, lineElement);
		errorMsg = getCoordinateErrorMsg(errorMsg, lineElement.getXCoordinates(), lineElement.getYCoordinates());

		addDefaultLine(lineElement);
		errorMsg = "Line #" + lineElement.getLineNumber() + " - Cannot draw line: " + errorMsg
				+ "missing or incorrect.";

		return errorMsg;
	}

	/**
	 * if only "Presentation" is incorrect a default presentation is set for drawing
	 * 
	 * @param lineElement
	 *            the line
	 */
	private void addDefaultLine(LineElement lineElement) {
		if (checkCoordinates(lineElement.getXCoordinates(), lineElement.getYCoordinates()) == true) {
			lineElement.setColor(this.defaultColor);
			lineElement.setLineWeight(this.defaultLineWeight);
			addLineElement(lineElement);
		}

	}

	/**
	 * checks if presentation is correct
	 * 
	 * @param de
	 *            the drawableElement to be checked
	 * @return true if correct
	 */
	@SuppressWarnings("static-method")
	private boolean checkPresentation(DrawableElement de) {
		if (de.getColor() == null || de.getLineWeight() == 0) {
			return false;
		}

		return true;
	}

	/**
	 * adds a specific error to the error message
	 * 
	 * @param errorMsg
	 *            the error message to be modified
	 * @param de
	 *            the drawableElement to be checked
	 * @return the modified error message
	 */
	@SuppressWarnings("static-method")
	private String getPresentationErrorMsg(String errorMsg, DrawableElement de) {
		if (de.getColor() == null) {
			errorMsg = errorMsg.replace(" ", ",") + "color ";
		}
		if (de.getLineWeight() == 0) {
			errorMsg = errorMsg.replace(" ", ",") + "lineweight ";
		}

		return errorMsg;
	}

	/**
	 * checks if extent is correct
	 * 
	 * @param extent
	 *            the extent
	 * @return true if correct
	 */
	@SuppressWarnings("static-method")
	private boolean checkExtent(double[] extent) {
		if (extent == null) {
			return false;
		}

		return true;
	}

	/**
	 * adds a specific error to the error message
	 * 
	 * @param errorMsg
	 *            the error message to be modified
	 * @param extent
	 *            the extent
	 * @return the modified error message
	 */
	@SuppressWarnings("static-method")
	private String getExtentErrorMsg(String errorMsg, double[] extent) {
		if (extent == null) {
			errorMsg = errorMsg.replace(" ", ",") + "extent ";
		}

		return errorMsg;
	}

	/**
	 * checks if radius is correct
	 * 
	 * @param radius
	 *            the radius
	 * @return true if correct
	 */
	@SuppressWarnings("static-method")
	private boolean checkRadius(double radius) {
		if (radius == 0) {
			return false;
		}

		return true;
	}

	/**
	 * adds a radius specific error to the error message
	 * 
	 * @param errorMsg
	 *            the error message to be modified
	 * @param radius
	 *            the radius
	 * @return the modified error message
	 */
	@SuppressWarnings("static-method")
	private String getRadiusErrorMsg(String errorMsg, double radius) {
		if (radius == 0) {
			errorMsg = errorMsg.replace(" ", ",") + "radius ";
		}
		return errorMsg;
	}

	/**
	 * checks if axis are correct
	 * 
	 * @param primAxis
	 *            the primary axis
	 * @param secAxis
	 *            the secondary axis
	 * @return true if correct
	 */
	@SuppressWarnings("static-method")
	private boolean checkAxis(double primAxis, double secAxis) {
		if (primAxis == 0 || secAxis == 0) {
			return false;
		}

		return true;
	}

	/**
	 * adds a specific error to the error message
	 * 
	 * @param errorMsg
	 *            the error message to be modified
	 * @param primAxis
	 *            the primary axis
	 * @param secAxis
	 *            the secondary axis
	 * @return the modified error message
	 */
	@SuppressWarnings("static-method")
	private String getAxisErrorMsg(String errorMsg, double primAxis, double secAxis) {
		if (primAxis == 0 || secAxis == 0) {
			errorMsg = errorMsg.replace(" ", ",") + "axis";
		}

		return errorMsg;
	}

	/**
	 * checks if position is correct
	 * 
	 * @param position
	 *            the position
	 * @return true if correct
	 */
	@SuppressWarnings("static-method")
	private boolean checkPosition(double[] position) {
		if (position == null) {
			return false;
		}

		return true;
	}

	/**
	 * adds a specific error to the error message
	 * 
	 * @param errorMsg
	 *            the error message
	 * @param position
	 *            the position
	 * @return the modified error message
	 */
	@SuppressWarnings("static-method")
	private String getPositionErrorMsg(String errorMsg, double[] position) {
		if (position == null) {
			errorMsg = errorMsg.replace(" ", ",") + "position ";
		}

		return errorMsg;
	}

	/**
	 * checks if coordinates are correct
	 * 
	 * @param xCoordinates
	 *            the x coordinates
	 * @param yCoordinates
	 *            the y corrdinates
	 * @return true if correct
	 */
	@SuppressWarnings("static-method")
	private boolean checkCoordinates(double[] xCoordinates, double[] yCoordinates) {
		if (xCoordinates == null || yCoordinates == null) {
			return false;
		}

		return true;
	}

	/**
	 * adds a specific error to the error message
	 * 
	 * @param errorMsg
	 *            the error message
	 * @param xCoordinates
	 *            the x coordinates
	 * @param yCoordinates
	 *            the y coordinates
	 * @return the modified error message
	 */
	@SuppressWarnings("static-method")
	private String getCoordinateErrorMsg(String errorMsg, double[] xCoordinates, double[] yCoordinates) {

		if (xCoordinates == null || yCoordinates == null) {
			errorMsg = errorMsg.replace(" ", ",") + "coordinates ";
		}

		return errorMsg;
	}

	/**
	 * hands over element to the graphic factory
	 * 
	 * @param ellipse
	 *            the ellipse
	 */
	private void addEllipseElement(EllipseElement ellipse) {
		// calculate offset and apply it to start and end-angle

		this.gFac.addEllipse(ellipse.getColor(), ellipse.getLineWeight(), ellipse.getPosition(),
				ellipse.getPrimaryAxis(), ellipse.getSecondaryAxis(), ellipse.getStartAngle(), ellipse.getEndAngle(),
				ellipse.getFilled());

	}

	/**
	 * hands over element to the graphic factory
	 * 
	 * @param circleElement
	 *            the circle
	 */
	private void addCircleElement(CircleElement circleElement) {
		this.gFac.addCircle(circleElement.getColor(), circleElement.getLineWeight(), circleElement.getPosition(),
				circleElement.getRadius(), circleElement.getStartAngle(), circleElement.getEndAngle(),
				circleElement.getFilled());
	}

	/**
	 * hands over element to the graphic factory
	 * 
	 * @param textElement
	 *            the text
	 */
	private void addTextElement(TextElement textElement) {
		this.gFac.addText(textElement.getColor(), textElement.getPosition(), textElement.getExtent(),
				textElement.getTextAngle(), textElement.getString(), textElement.getHeight(), textElement.getFont());
	}

	/**
	 * hands over element to the graphic factory
	 * 
	 * @param shapeElement
	 *            the shape
	 */
	private void addShapeElement(ShapeElement shapeElement) {
		this.gFac.addShape(shapeElement.getColor(), shapeElement.getLineWeight(), shapeElement.getXCoordinates(),
				shapeElement.getYCoordinates(), shapeElement.getFilled());
	}

	/**
	 * hands over element to the graphic factory
	 * 
	 * @param lineElement
	 *            the line
	 */
	private void addLineElement(LineElement lineElement) {
		this.gFac.addLine(lineElement.getColor(), lineElement.getLineWeight(), lineElement.getXCoordinates(),
				lineElement.getYCoordinates());
	}
	
	/**
	 * creates the image, so that elements can be added to it via the graphic
	 * factory and returns it after addition has been completed
	 *
	 * @param resolutionX
	 *            the resolution in x direction
	 * @param destination
	 *            the destination of the output-file, needed for svg-writing
	 * @return the buffered image
	 */
	public BufferedImage buildImage(int resolutionX, String destination) {
		// NOTE This is the entry-point of this class
		// initialize image

		if (this.inputRep.getZeroPoint() != null && this.inputRep.getSize() != null
				&& this.inputRep.getBackgroundcolor() != null) {
			this.gFac.init(resolutionX, this.inputRep.getZeroPoint(), this.inputRep.getSize(),
					this.inputRep.getBackgroundcolor());
		} else {
			// in case size and zero point are missing
			this.gFac.init(resolutionX, new double[] { 0, 0 }, new double[] { 500, 500 }, new Color(255, 255, 255));
		}

		// check and add errors if necessary
		if (this.inputRep.getZeroPoint() == null || this.inputRep.getSize() == null) {
			ErrorElement newError = new ErrorElement("PlantModel", "-", "-");
			newError.setDescription("Extent is missing or incorrect");
			this.listOfErrors.add(newError);
		}
		if (this.inputRep.getBackgroundcolor() == null && this.inputRep.getDrawing() != null) {
			ErrorElement newError = new ErrorElement("Drawing", "-", "-", this.inputRep.getDrawing().getLineNumber());
			newError.setDescription("Presentation is missing or incorrect");
			this.listOfErrors.add(newError);
		}

		getInputData();
		this.errorRep.generateXmlErrorLog(this.listOfErrors);

		if (destination != null) {
			this.gFac.writeToDestination(destination);
		}
		
		return this.gFac.buildImage();

	}

	/**
	 * generates a string of the imageMapElements, that contains the html code
	 * necessary for displaying the imageMap
	 * 
	 * @param mapName
	 *            the name of the imageMap
	 * @return a string containing the html-code
	 */
	public String generateHTMLimageMap(String mapName) {
		return ImageMapObject.generateImageMap(this.gFac.getImageMapObjects(), mapName);
	}

	public void setOutStreamHandle(PrintStream newHandle) {
		this.outStreamHandle = newHandle;
	}
}
