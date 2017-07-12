//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//

package org.dexpi.pid.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the org.dexpi.pid.xml package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory extends GeneratedClass {

	private final static QName _BsplineSurfaceKnotMultiplicitiesU_QNAME = new QName(
			"", "KnotMultiplicitiesU");
	private final static QName _BsplineSurfaceKnotMultiplicitiesV_QNAME = new QName(
			"", "KnotMultiplicitiesV");
	private final static QName _BsplineSurfaceControlPointArray_QNAME = new QName(
			"", "ControlPointArray");
	private final static QName _BsplineSurfaceWeights_QNAME = new QName("",
			"Weights");
	private final static QName _BsplineSurfaceKnotsU_QNAME = new QName("",
			"KnotsU");
	private final static QName _BsplineSurfaceKnotsV_QNAME = new QName("",
			"KnotsV");
	private final static QName _BsplineSurface_QNAME = new QName("",
			"BsplineSurface");
	private final static QName _MaximumAmbientTemperature_QNAME = new QName("",
			"MaximumAmbientTemperature");
	private final static QName _MaximumOperatingTemperature_QNAME = new QName(
			"", "MaximumOperatingTemperature");
	private final static QName _NominalDesignPressure_QNAME = new QName("",
			"NominalDesignPressure");
	private final static QName _NormalOperatingPressure_QNAME = new QName("",
			"NormalOperatingPressure");
	private final static QName _StartDiameter_QNAME = new QName("",
			"StartDiameter");
	private final static QName _Inclination_QNAME = new QName("", "Inclination");
	private final static QName _UpperLimitOperatingTemperature_QNAME = new QName(
			"", "UpperLimitOperatingTemperature");
	private final static QName _Plane_QNAME = new QName("", "Plane");
	private final static QName _MinimumRelativeHumidity_QNAME = new QName("",
			"MinimumRelativeHumidity");
	private final static QName _EndPreparation_QNAME = new QName("",
			"EndPreparation");
	private final static QName _Weight_QNAME = new QName("", "Weight");
	private final static QName _NominalDiameter_QNAME = new QName("",
			"NominalDiameter");
	private final static QName _OutsideDiameter_QNAME = new QName("",
			"OutsideDiameter");
	private final static QName _Surface_QNAME = new QName("", "Surface");
	private final static QName _FabricationCategory_QNAME = new QName("",
			"FabricationCategory");
	private final static QName _ScheduleThickness_QNAME = new QName("",
			"ScheduleThickness");
	private final static QName _Circle_QNAME = new QName("", "Circle");
	private final static QName _UpperLimitDesignPressure_QNAME = new QName("",
			"UpperLimitDesignPressure");
	private final static QName _NominalDesignTemperature_QNAME = new QName("",
			"NominalDesignTemperature");
	private final static QName _UpperLimitOperatingPressure_QNAME = new QName(
			"", "UpperLimitOperatingPressure");
	private final static QName _SmallDiameter_QNAME = new QName("",
			"SmallDiameter");
	private final static QName _UpperLimitDesignTemperature_QNAME = new QName(
			"", "UpperLimitDesignTemperature");
	private final static QName _TestPressure_QNAME = new QName("",
			"TestPressure");
	private final static QName _PolyLine_QNAME = new QName("", "PolyLine");
	private final static QName _TrimmedCurve_QNAME = new QName("",
			"TrimmedCurve");
	private final static QName _NormalOperatingTemperature_QNAME = new QName(
			"", "NormalOperatingTemperature");
	private final static QName _MaterialDescription_QNAME = new QName("",
			"MaterialDescription");
	private final static QName _InsideDiameter_QNAME = new QName("",
			"InsideDiameter");
	private final static QName _BsplineCurve_QNAME = new QName("",
			"BsplineCurve");
	private final static QName _Curve_QNAME = new QName("", "Curve");
	private final static QName _Rating_QNAME = new QName("", "Rating");
	private final static QName _WeldType_QNAME = new QName("", "WeldType");
	private final static QName _EndDiameter_QNAME = new QName("", "EndDiameter");
	private final static QName _MaximumDesignPressure_QNAME = new QName("",
			"MaximumDesignPressure");
	private final static QName _MinimumOperatingTemperature_QNAME = new QName(
			"", "MinimumOperatingTemperature");
	private final static QName _CompositeCurve_QNAME = new QName("",
			"CompositeCurve");
	private final static QName _MinimumAmbientTemperature_QNAME = new QName("",
			"MinimumAmbientTemperature");
	private final static QName _CurveBoundedSurface_QNAME = new QName("",
			"CurveBoundedSurface");
	private final static QName _Association_QNAME = new QName("", "Association");
	private final static QName _Material_QNAME = new QName("", "Material");
	private final static QName _MaximumRelativeHumidity_QNAME = new QName("",
			"MaximumRelativeHumidity");
	private final static QName _ConnectionType_QNAME = new QName("",
			"ConnectionType");
	private final static QName _LowerLimitOperatingPressure_QNAME = new QName(
			"", "LowerLimitOperatingPressure");
	private final static QName _Discipline_QNAME = new QName("", "Discipline");
	private final static QName _MinimumDesignTemperature_QNAME = new QName("",
			"MinimumDesignTemperature");
	private final static QName _GasketGap_QNAME = new QName("", "GasketGap");
	private final static QName _LargeDiameter_QNAME = new QName("",
			"LargeDiameter");
	private final static QName _Ellipse_QNAME = new QName("", "Ellipse");
	private final static QName _MaterialOfConstruction_QNAME = new QName("",
			"MaterialOfConstruction");
	private final static QName _MinimumDesignPressure_QNAME = new QName("",
			"MinimumDesignPressure");
	private final static QName _WallThickness_QNAME = new QName("",
			"WallThickness");
	private final static QName _MaximumDesignTemperature_QNAME = new QName("",
			"MaximumDesignTemperature");
	private final static QName _Description_QNAME = new QName("", "Description");
	private final static QName _PlantItem_QNAME = new QName("", "PlantItem");
	private final static QName _LowerLimitDesignTemperature_QNAME = new QName(
			"", "LowerLimitDesignTemperature");
	private final static QName _PersistentID_QNAME = new QName("",
			"PersistentID");
	private final static QName _CenterLine_QNAME = new QName("", "CenterLine");
	private final static QName _LowerLimitOperatingTemperature_QNAME = new QName(
			"", "LowerLimitOperatingTemperature");
	private final static QName _PipingComponent_QNAME = new QName("",
			"PipingComponent");
	private final static QName _Shape_QNAME = new QName("", "Shape");
	private final static QName _NormalDesignPressure_QNAME = new QName("",
			"NormalDesignPressure");
	private final static QName _NormalDesignTemperature_QNAME = new QName("",
			"NormalDesignTemperature");
	private final static QName _MaximumOperatingPressure_QNAME = new QName("",
			"MaximumOperatingPressure");
	private final static QName _MinimumOperatingPressure_QNAME = new QName("",
			"MinimumOperatingPressure");
	private final static QName _LowerLimitDesignPressure_QNAME = new QName("",
			"LowerLimitDesignPressure");
	private final static QName _Line_QNAME = new QName("", "Line");
	private final static QName _ControlPointWeight_QNAME = new QName("",
			"ControlPointWeight");
	private final static QName _OperatorType_QNAME = new QName("",
			"OperatorType");
	private final static QName _PlantItemManufacturer_QNAME = new QName("",
			"Manufacturer");
	private final static QName _PlantItemSupplier_QNAME = new QName("",
			"Supplier");
	private final static QName _PlantItemModelNumber_QNAME = new QName("",
			"ModelNumber");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: org.dexpi.pid.xml
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link Text }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Text createText() {
		return new Text();
	}

	/**
	 * Create an instance of {@link PlantModel }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PlantModel createPlantModel() {
		return new PlantModel();
	}

	/**
	 * Create an instance of {@link PipeFlowArrow }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PipeFlowArrow createPipeFlowArrow() {
		return new PipeFlowArrow();
	}

	/**
	 * Create an instance of {@link AnnotationItem }
	 * 
	 */
	@SuppressWarnings("static-method")
	public AnnotationItem createAnnotationItem() {
		return new AnnotationItem();
	}

	/**
	 * Create an instance of {@link Presentation }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Presentation createPresentation() {
		return new Presentation();
	}

	/**
	 * Create an instance of {@link Extent }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Extent createExtent() {
		return new Extent();
	}

	/**
	 * Create an instance of {@link Min }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Min createMin() {
		return new Min();
	}

	/**
	 * Create an instance of {@link Max }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Max createMax() {
		return new Max();
	}

	/**
	 * Create an instance of {@link PersistentID }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PersistentID createPersistentID() {
		return new PersistentID();
	}

	/**
	 * Create an instance of {@link Position }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Position createPosition() {
		return new Position();
	}

	/**
	 * Create an instance of {@link Location }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Location createLocation() {
		return new Location();
	}

	/**
	 * Create an instance of {@link Axis }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Axis createAxis() {
		return new Axis();
	}

	/**
	 * Create an instance of {@link Reference }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Reference createReference() {
		return new Reference();
	}

	/**
	 * Create an instance of {@link Scale }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Scale createScale() {
		return new Scale();
	}

	/**
	 * Create an instance of {@link Symbol }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Symbol createSymbol() {
		return new Symbol();
	}

	/**
	 * Create an instance of {@link ConnectionPoints }
	 * 
	 */
	@SuppressWarnings("static-method")
	public ConnectionPoints createConnectionPoints() {
		return new ConnectionPoints();
	}

	/**
	 * Create an instance of {@link Node }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Node createNode() {
		return new Node();
	}

	/**
	 * Create an instance of {@link LengthDouble }
	 * 
	 */
	@SuppressWarnings("static-method")
	public LengthDouble createLengthDouble() {
		return new LengthDouble();
	}

	/**
	 * Create an instance of {@link org.dexpi.pid.xml.String }
	 * 
	 */
	@SuppressWarnings("static-method")
	public org.dexpi.pid.xml.String createString() {
		return new org.dexpi.pid.xml.String();
	}

	/**
	 * Create an instance of {@link LengthString }
	 * 
	 */
	@SuppressWarnings("static-method")
	public LengthString createLengthString() {
		return new LengthString();
	}

	/**
	 * Create an instance of {@link GenericAttributes }
	 * 
	 */
	@SuppressWarnings("static-method")
	public GenericAttributes createGenericAttributes() {
		return new GenericAttributes();
	}

	/**
	 * Create an instance of {@link GenericAttribute }
	 * 
	 */
	@SuppressWarnings("static-method")
	public GenericAttribute createGenericAttribute() {
		return new GenericAttribute();
	}

	/**
	 * Create an instance of {@link Text.String }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Text.String createTextString() {
		return new Text.String();
	}

	/**
	 * Create an instance of {@link TextStringFormatSpecification }
	 * 
	 */
	@SuppressWarnings("static-method")
	public TextStringFormatSpecification createTextStringFormatSpecification() {
		return new TextStringFormatSpecification();
	}

	/**
	 * Create an instance of {@link ObjectAttributesReference }
	 * 
	 */
	@SuppressWarnings("static-method")
	public ObjectAttributesReference createObjectAttributesReference() {
		return new ObjectAttributesReference();
	}

	/**
	 * Create an instance of {@link History }
	 * 
	 */
	@SuppressWarnings("static-method")
	public History createHistory() {
		return new History();
	}

	/**
	 * Create an instance of {@link Transaction }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Transaction createTransaction() {
		return new Transaction();
	}

	/**
	 * Create an instance of {@link Association }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Association createAssociation() {
		return new Association();
	}

	/**
	 * Create an instance of {@link PressureDouble }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PressureDouble createPressureDouble() {
		return new PressureDouble();
	}

	/**
	 * Create an instance of {@link MassDouble }
	 * 
	 */
	@SuppressWarnings("static-method")
	public MassDouble createMassDouble() {
		return new MassDouble();
	}

	/**
	 * Create an instance of {@link Surface }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Surface createSurface() {
		return new Surface();
	}

	/**
	 * Create an instance of {@link PropertyBreak }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PropertyBreak createPropertyBreak() {
		return new PropertyBreak();
	}

	/**
	 * Create an instance of {@link Identifier }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Identifier createIdentifier() {
		return new Identifier();
	}

	/**
	 * Create an instance of {@link IdentifierElement }
	 * 
	 */
	@SuppressWarnings("static-method")
	public IdentifierElement createIdentifierElement() {
		return new IdentifierElement();
	}

	/**
	 * Create an instance of {@link Equipment }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Equipment createEquipment() {
		return new Equipment();
	}

	/**
	 * Create an instance of {@link PlantItem }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PlantItem createPlantItem() {
		return new PlantItem();
	}

	/**
	 * Create an instance of {@link Label }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Label createLabel() {
		return new Label();
	}

	/**
	 * Create an instance of {@link TemperatureDouble }
	 * 
	 */
	@SuppressWarnings("static-method")
	public TemperatureDouble createTemperatureDouble() {
		return new TemperatureDouble();
	}

	/**
	 * Create an instance of {@link Nozzle }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Nozzle createNozzle() {
		return new Nozzle();
	}

	/**
	 * Create an instance of {@link NozzleType }
	 * 
	 */
	@SuppressWarnings("static-method")
	public NozzleType createNozzleType() {
		return new NozzleType();
	}

	/**
	 * Create an instance of {@link Component }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Component createComponent() {
		return new Component();
	}

	/**
	 * Create an instance of {@link ShapeCatalogue }
	 * 
	 */
	@SuppressWarnings("static-method")
	public ShapeCatalogue createShapeCatalogue() {
		return new ShapeCatalogue();
	}

	/**
	 * Create an instance of {@link PipingComponent }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PipingComponent createPipingComponent() {
		return new PipingComponent();
	}

	/**
	 * Create an instance of {@link ProcessInstrument }
	 * 
	 */
	@SuppressWarnings("static-method")
	public ProcessInstrument createProcessInstrument() {
		return new ProcessInstrument();
	}

	/**
	 * Create an instance of {@link InstrumentComponent }
	 * 
	 */
	@SuppressWarnings("static-method")
	public InstrumentComponent createInstrumentComponent() {
		return new InstrumentComponent();
	}

	/**
	 * Create an instance of {@link PipeConnectorSymbol }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PipeConnectorSymbol createPipeConnectorSymbol() {
		return new PipeConnectorSymbol();
	}

	/**
	 * Create an instance of {@link CrossPageConnection }
	 * 
	 */
	@SuppressWarnings("static-method")
	public CrossPageConnection createCrossPageConnection() {
		return new CrossPageConnection();
	}

	/**
	 * Create an instance of {@link SignalConnectorSymbol }
	 * 
	 */
	@SuppressWarnings("static-method")
	public SignalConnectorSymbol createSignalConnectorSymbol() {
		return new SignalConnectorSymbol();
	}

	/**
	 * Create an instance of {@link InsulationSymbol }
	 * 
	 */
	@SuppressWarnings("static-method")
	public InsulationSymbol createInsulationSymbol() {
		return new InsulationSymbol();
	}

	/**
	 * Create an instance of {@link ScopeBubble }
	 * 
	 */
	@SuppressWarnings("static-method")
	public ScopeBubble createScopeBubble() {
		return new ScopeBubble();
	}

	/**
	 * Create an instance of {@link PipeSlopeSymbol }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PipeSlopeSymbol createPipeSlopeSymbol() {
		return new PipeSlopeSymbol();
	}

	/**
	 * Create an instance of {@link PolyLine }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PolyLine createPolyLine() {
		return new PolyLine();
	}

	/**
	 * Create an instance of {@link BsplineCurve }
	 * 
	 */
	@SuppressWarnings("static-method")
	public BsplineCurve createBsplineCurve() {
		return new BsplineCurve();
	}

	/**
	 * Create an instance of {@link Drawing }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Drawing createDrawing() {
		return new Drawing();
	}

	/**
	 * Create an instance of {@link DrawingBorder }
	 * 
	 */
	@SuppressWarnings("static-method")
	public DrawingBorder createDrawingBorder() {
		return new DrawingBorder();
	}

	/**
	 * Create an instance of {@link CurveBoundedSurface }
	 * 
	 */
	@SuppressWarnings("static-method")
	public CurveBoundedSurface createCurveBoundedSurface() {
		return new CurveBoundedSurface();
	}

	/**
	 * Create an instance of {@link Weights }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Weights createWeights() {
		return new Weights();
	}

	/**
	 * Create an instance of {@link PlantInformation }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PlantInformation createPlantInformation() {
		return new PlantInformation();
	}

	/**
	 * Create an instance of {@link UnitsOfMeasure }
	 * 
	 */
	@SuppressWarnings("static-method")
	public UnitsOfMeasure createUnitsOfMeasure() {
		return new UnitsOfMeasure();
	}

	/**
	 * Create an instance of {@link PlantModel.RDLService }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PlantModel.RDLService createPlantModelRDLService() {
		return new PlantModel.RDLService();
	}

	/**
	 * Create an instance of {@link PlantArea }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PlantArea createPlantArea() {
		return new PlantArea();
	}

	/**
	 * Create an instance of {@link InstrumentLoop }
	 * 
	 */
	@SuppressWarnings("static-method")
	public InstrumentLoop createInstrumentLoop() {
		return new InstrumentLoop();
	}

	/**
	 * Create an instance of {@link SignalLine }
	 * 
	 */
	@SuppressWarnings("static-method")
	public SignalLine createSignalLine() {
		return new SignalLine();
	}

	/**
	 * Create an instance of {@link Connection }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Connection createConnection() {
		return new Connection();
	}

	/**
	 * Create an instance of {@link CenterLine }
	 * 
	 */
	@SuppressWarnings("static-method")
	public CenterLine createCenterLine() {
		return new CenterLine();
	}

	/**
	 * Create an instance of {@link PipingNetworkSystem }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PipingNetworkSystem createPipingNetworkSystem() {
		return new PipingNetworkSystem();
	}

	/**
	 * Create an instance of {@link PipingNetworkSegment }
	 * 
	 */
	@SuppressWarnings("static-method")
	public PipingNetworkSegment createPipingNetworkSegment() {
		return new PipingNetworkSegment();
	}

	/**
	 * Create an instance of {@link InstrumentConnection }
	 * 
	 */
	@SuppressWarnings("static-method")
	public InstrumentConnection createInstrumentConnection() {
		return new InstrumentConnection();
	}

	/**
	 * Create an instance of {@link AngleDouble }
	 * 
	 */
	@SuppressWarnings("static-method")
	public AngleDouble createAngleDouble() {
		return new AngleDouble();
	}

	/**
	 * Create an instance of {@link Ellipse }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Ellipse createEllipse() {
		return new Ellipse();
	}

	/**
	 * Create an instance of {@link OuterBoundary }
	 * 
	 */
	@SuppressWarnings("static-method")
	public OuterBoundary createOuterBoundary() {
		return new OuterBoundary();
	}

	/**
	 * Create an instance of {@link Line }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Line createLine() {
		return new Line();
	}

	/**
	 * Create an instance of {@link BsplineSurface }
	 * 
	 */
	@SuppressWarnings("static-method")
	public BsplineSurface createBsplineSurface() {
		return new BsplineSurface();
	}

	/**
	 * Create an instance of {@link Plane }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Plane createPlane() {
		return new Plane();
	}

	/**
	 * Create an instance of {@link org.dexpi.pid.xml.Double }
	 * 
	 */
	@SuppressWarnings("static-method")
	public org.dexpi.pid.xml.Double createDouble() {
		return new org.dexpi.pid.xml.Double();
	}

	/**
	 * Create an instance of {@link Circle }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Circle createCircle() {
		return new Circle();
	}

	/**
	 * Create an instance of {@link TrimmedCurve }
	 * 
	 */
	@SuppressWarnings("static-method")
	public TrimmedCurve createTrimmedCurve() {
		return new TrimmedCurve();
	}

	/**
	 * Create an instance of {@link ControlPoints }
	 * 
	 */
	@SuppressWarnings("static-method")
	public ControlPoints createControlPoints() {
		return new ControlPoints();
	}

	/**
	 * Create an instance of {@link Coordinate }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Coordinate createCoordinate() {
		return new Coordinate();
	}

	/**
	 * Create an instance of {@link InnerBoundary }
	 * 
	 */
	@SuppressWarnings("static-method")
	public InnerBoundary createInnerBoundary() {
		return new InnerBoundary();
	}

	/**
	 * Create an instance of {@link CompositeCurve }
	 * 
	 */
	@SuppressWarnings("static-method")
	public CompositeCurve createCompositeCurve() {
		return new CompositeCurve();
	}

	/**
	 * Create an instance of {@link Shape }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Shape createShape() {
		return new Shape();
	}

	/**
	 * Create an instance of {@link ControlPointArray }
	 * 
	 */
	@SuppressWarnings("static-method")
	public ControlPointArray createControlPointArray() {
		return new ControlPointArray();
	}

	/**
	 * Create an instance of {@link CTWeights }
	 * 
	 */
	@SuppressWarnings("static-method")
	public CTWeights createCTWeights() {
		return new CTWeights();
	}

	/**
	 * Create an instance of {@link KnotMultiplicities }
	 * 
	 */
	@SuppressWarnings("static-method")
	public KnotMultiplicities createKnotMultiplicities() {
		return new KnotMultiplicities();
	}

	/**
	 * Create an instance of {@link VolumeDouble }
	 * 
	 */
	@SuppressWarnings("static-method")
	public VolumeDouble createVolumeDouble() {
		return new VolumeDouble();
	}

	/**
	 * Create an instance of {@link Knots }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Knots createKnots() {
		return new Knots();
	}

	/**
	 * Create an instance of {@link CTControlPoints }
	 * 
	 */
	@SuppressWarnings("static-method")
	public CTControlPoints createCTControlPoints() {
		return new CTControlPoints();
	}

	/**
	 * Create an instance of {@link AreaDouble }
	 * 
	 */
	@SuppressWarnings("static-method")
	public AreaDouble createAreaDouble() {
		return new AreaDouble();
	}

	/**
	 * Create an instance of {@link CTControlPointArray }
	 * 
	 */
	@SuppressWarnings("static-method")
	public CTControlPointArray createCTControlPointArray() {
		return new CTControlPointArray();
	}

	/**
	 * Create an instance of {@link WeightsData }
	 * 
	 */
	@SuppressWarnings("static-method")
	public WeightsData createWeightsData() {
		return new WeightsData();
	}

	/**
	 * Create an instance of {@link Integer }
	 * 
	 */
	@SuppressWarnings("static-method")
	public Integer createInteger() {
		return new Integer();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link KnotMultiplicities }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "KnotMultiplicitiesU", scope = BsplineSurface.class)
	public JAXBElement<KnotMultiplicities> createBsplineSurfaceKnotMultiplicitiesU(
			KnotMultiplicities value) {
		return new JAXBElement<KnotMultiplicities>(
				_BsplineSurfaceKnotMultiplicitiesU_QNAME,
				KnotMultiplicities.class, BsplineSurface.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link KnotMultiplicities }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "KnotMultiplicitiesV", scope = BsplineSurface.class)
	public JAXBElement<KnotMultiplicities> createBsplineSurfaceKnotMultiplicitiesV(
			KnotMultiplicities value) {
		return new JAXBElement<KnotMultiplicities>(
				_BsplineSurfaceKnotMultiplicitiesV_QNAME,
				KnotMultiplicities.class, BsplineSurface.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CTControlPointArray }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "ControlPointArray", scope = BsplineSurface.class)
	public JAXBElement<CTControlPointArray> createBsplineSurfaceControlPointArray(
			CTControlPointArray value) {
		return new JAXBElement<CTControlPointArray>(
				_BsplineSurfaceControlPointArray_QNAME,
				CTControlPointArray.class, BsplineSurface.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CTWeights }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Weights", scope = BsplineSurface.class)
	public JAXBElement<CTWeights> createBsplineSurfaceWeights(CTWeights value) {
		return new JAXBElement<CTWeights>(_BsplineSurfaceWeights_QNAME,
				CTWeights.class, BsplineSurface.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Knots }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "KnotsU", scope = BsplineSurface.class)
	public JAXBElement<Knots> createBsplineSurfaceKnotsU(Knots value) {
		return new JAXBElement<Knots>(_BsplineSurfaceKnotsU_QNAME, Knots.class,
				BsplineSurface.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Knots }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "KnotsV", scope = BsplineSurface.class)
	public JAXBElement<Knots> createBsplineSurfaceKnotsV(Knots value) {
		return new JAXBElement<Knots>(_BsplineSurfaceKnotsV_QNAME, Knots.class,
				BsplineSurface.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link BsplineSurface }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "BsplineSurface", substitutionHeadNamespace = "", substitutionHeadName = "Surface")
	public JAXBElement<BsplineSurface> createBsplineSurface(BsplineSurface value) {
		return new JAXBElement<BsplineSurface>(_BsplineSurface_QNAME,
				BsplineSurface.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MaximumAmbientTemperature")
	public JAXBElement<TemperatureDouble> createMaximumAmbientTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_MaximumAmbientTemperature_QNAME, TemperatureDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MaximumOperatingTemperature")
	public JAXBElement<TemperatureDouble> createMaximumOperatingTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_MaximumOperatingTemperature_QNAME, TemperatureDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "NominalDesignPressure")
	public JAXBElement<PressureDouble> createNominalDesignPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(_NominalDesignPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "NormalOperatingPressure")
	public JAXBElement<PressureDouble> createNormalOperatingPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(_NormalOperatingPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "StartDiameter")
	public JAXBElement<LengthDouble> createStartDiameter(LengthDouble value) {
		return new JAXBElement<LengthDouble>(_StartDiameter_QNAME,
				LengthDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AngleDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Inclination")
	public JAXBElement<AngleDouble> createInclination(AngleDouble value) {
		return new JAXBElement<AngleDouble>(_Inclination_QNAME,
				AngleDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "UpperLimitOperatingTemperature")
	public JAXBElement<TemperatureDouble> createUpperLimitOperatingTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_UpperLimitOperatingTemperature_QNAME, TemperatureDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Plane }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Plane", substitutionHeadNamespace = "", substitutionHeadName = "Surface")
	public JAXBElement<Plane> createPlane(Plane value) {
		return new JAXBElement<Plane>(_Plane_QNAME, Plane.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link org.dexpi.pid.xml.Double }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MinimumRelativeHumidity")
	public JAXBElement<org.dexpi.pid.xml.Double> createMinimumRelativeHumidity(
			org.dexpi.pid.xml.Double value) {
		return new JAXBElement<org.dexpi.pid.xml.Double>(
				_MinimumRelativeHumidity_QNAME, org.dexpi.pid.xml.Double.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link org.dexpi.pid.xml.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "EndPreparation")
	public JAXBElement<org.dexpi.pid.xml.String> createEndPreparation(
			org.dexpi.pid.xml.String value) {
		return new JAXBElement<org.dexpi.pid.xml.String>(_EndPreparation_QNAME,
				org.dexpi.pid.xml.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link MassDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Weight")
	public JAXBElement<MassDouble> createWeight(MassDouble value) {
		return new JAXBElement<MassDouble>(_Weight_QNAME, MassDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "NominalDiameter")
	public JAXBElement<LengthDouble> createNominalDiameter(LengthDouble value) {
		return new JAXBElement<LengthDouble>(_NominalDiameter_QNAME,
				LengthDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "OutsideDiameter")
	public JAXBElement<LengthDouble> createOutsideDiameter(LengthDouble value) {
		return new JAXBElement<LengthDouble>(_OutsideDiameter_QNAME,
				LengthDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Surface }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Surface")
	public JAXBElement<Surface> createSurface(Surface value) {
		return new JAXBElement<Surface>(_Surface_QNAME, Surface.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link java.lang.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "FabricationCategory")
	public JAXBElement<java.lang.String> createFabricationCategory(
			java.lang.String value) {
		return new JAXBElement<java.lang.String>(_FabricationCategory_QNAME,
				java.lang.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthString }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "ScheduleThickness")
	public JAXBElement<LengthString> createScheduleThickness(LengthString value) {
		return new JAXBElement<LengthString>(_ScheduleThickness_QNAME,
				LengthString.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Circle }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Circle", substitutionHeadNamespace = "", substitutionHeadName = "Curve")
	public JAXBElement<Circle> createCircle(Circle value) {
		return new JAXBElement<Circle>(_Circle_QNAME, Circle.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "UpperLimitDesignPressure")
	public JAXBElement<PressureDouble> createUpperLimitDesignPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(_UpperLimitDesignPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "NominalDesignTemperature")
	public JAXBElement<TemperatureDouble> createNominalDesignTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_NominalDesignTemperature_QNAME, TemperatureDouble.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "UpperLimitOperatingPressure")
	public JAXBElement<PressureDouble> createUpperLimitOperatingPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(
				_UpperLimitOperatingPressure_QNAME, PressureDouble.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "SmallDiameter")
	public JAXBElement<LengthDouble> createSmallDiameter(LengthDouble value) {
		return new JAXBElement<LengthDouble>(_SmallDiameter_QNAME,
				LengthDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "UpperLimitDesignTemperature")
	public JAXBElement<TemperatureDouble> createUpperLimitDesignTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_UpperLimitDesignTemperature_QNAME, TemperatureDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "TestPressure")
	public JAXBElement<PressureDouble> createTestPressure(PressureDouble value) {
		return new JAXBElement<PressureDouble>(_TestPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PolyLine }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "PolyLine", substitutionHeadNamespace = "", substitutionHeadName = "Curve")
	public JAXBElement<PolyLine> createPolyLine(PolyLine value) {
		return new JAXBElement<PolyLine>(_PolyLine_QNAME, PolyLine.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link TrimmedCurve }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "TrimmedCurve", substitutionHeadNamespace = "", substitutionHeadName = "Curve")
	public JAXBElement<TrimmedCurve> createTrimmedCurve(TrimmedCurve value) {
		return new JAXBElement<TrimmedCurve>(_TrimmedCurve_QNAME,
				TrimmedCurve.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "NormalOperatingTemperature")
	public JAXBElement<TemperatureDouble> createNormalOperatingTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_NormalOperatingTemperature_QNAME, TemperatureDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link java.lang.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MaterialDescription")
	public JAXBElement<java.lang.String> createMaterialDescription(
			java.lang.String value) {
		return new JAXBElement<java.lang.String>(_MaterialDescription_QNAME,
				java.lang.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "InsideDiameter")
	public JAXBElement<LengthDouble> createInsideDiameter(LengthDouble value) {
		return new JAXBElement<LengthDouble>(_InsideDiameter_QNAME,
				LengthDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link BsplineCurve }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "BsplineCurve", substitutionHeadNamespace = "", substitutionHeadName = "Curve")
	public JAXBElement<BsplineCurve> createBsplineCurve(BsplineCurve value) {
		return new JAXBElement<BsplineCurve>(_BsplineCurve_QNAME,
				BsplineCurve.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Curve }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Curve")
	public JAXBElement<Curve> createCurve(Curve value) {
		return new JAXBElement<Curve>(_Curve_QNAME, Curve.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link org.dexpi.pid.xml.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Rating")
	public JAXBElement<org.dexpi.pid.xml.String> createRating(
			org.dexpi.pid.xml.String value) {
		return new JAXBElement<org.dexpi.pid.xml.String>(_Rating_QNAME,
				org.dexpi.pid.xml.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link org.dexpi.pid.xml.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "WeldType")
	public JAXBElement<org.dexpi.pid.xml.String> createWeldType(
			org.dexpi.pid.xml.String value) {
		return new JAXBElement<org.dexpi.pid.xml.String>(_WeldType_QNAME,
				org.dexpi.pid.xml.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "EndDiameter")
	public JAXBElement<LengthDouble> createEndDiameter(LengthDouble value) {
		return new JAXBElement<LengthDouble>(_EndDiameter_QNAME,
				LengthDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MaximumDesignPressure")
	public JAXBElement<PressureDouble> createMaximumDesignPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(_MaximumDesignPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MinimumOperatingTemperature")
	public JAXBElement<TemperatureDouble> createMinimumOperatingTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_MinimumOperatingTemperature_QNAME, TemperatureDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CompositeCurve }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "CompositeCurve", substitutionHeadNamespace = "", substitutionHeadName = "Curve")
	public JAXBElement<CompositeCurve> createCompositeCurve(CompositeCurve value) {
		return new JAXBElement<CompositeCurve>(_CompositeCurve_QNAME,
				CompositeCurve.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MinimumAmbientTemperature")
	public JAXBElement<TemperatureDouble> createMinimumAmbientTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_MinimumAmbientTemperature_QNAME, TemperatureDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CurveBoundedSurface }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "CurveBoundedSurface", substitutionHeadNamespace = "", substitutionHeadName = "Surface")
	public JAXBElement<CurveBoundedSurface> createCurveBoundedSurface(
			CurveBoundedSurface value) {
		return new JAXBElement<CurveBoundedSurface>(_CurveBoundedSurface_QNAME,
				CurveBoundedSurface.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Association }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Association")
	public JAXBElement<Association> createAssociation(Association value) {
		return new JAXBElement<Association>(_Association_QNAME,
				Association.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link java.lang.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Material")
	public JAXBElement<java.lang.String> createMaterial(java.lang.String value) {
		return new JAXBElement<java.lang.String>(_Material_QNAME,
				java.lang.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link org.dexpi.pid.xml.Double }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MaximumRelativeHumidity")
	public JAXBElement<org.dexpi.pid.xml.Double> createMaximumRelativeHumidity(
			org.dexpi.pid.xml.Double value) {
		return new JAXBElement<org.dexpi.pid.xml.Double>(
				_MaximumRelativeHumidity_QNAME, org.dexpi.pid.xml.Double.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link org.dexpi.pid.xml.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "ConnectionType")
	public JAXBElement<org.dexpi.pid.xml.String> createConnectionType(
			org.dexpi.pid.xml.String value) {
		return new JAXBElement<org.dexpi.pid.xml.String>(_ConnectionType_QNAME,
				org.dexpi.pid.xml.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "LowerLimitOperatingPressure")
	public JAXBElement<PressureDouble> createLowerLimitOperatingPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(
				_LowerLimitOperatingPressure_QNAME, PressureDouble.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link java.lang.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Discipline")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	public JAXBElement<java.lang.String> createDiscipline(java.lang.String value) {
		return new JAXBElement<java.lang.String>(_Discipline_QNAME,
				java.lang.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MinimumDesignTemperature")
	public JAXBElement<TemperatureDouble> createMinimumDesignTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_MinimumDesignTemperature_QNAME, TemperatureDouble.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "GasketGap")
	public JAXBElement<LengthDouble> createGasketGap(LengthDouble value) {
		return new JAXBElement<LengthDouble>(_GasketGap_QNAME,
				LengthDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "LargeDiameter")
	public JAXBElement<LengthDouble> createLargeDiameter(LengthDouble value) {
		return new JAXBElement<LengthDouble>(_LargeDiameter_QNAME,
				LengthDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Ellipse }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Ellipse", substitutionHeadNamespace = "", substitutionHeadName = "Curve")
	public JAXBElement<Ellipse> createEllipse(Ellipse value) {
		return new JAXBElement<Ellipse>(_Ellipse_QNAME, Ellipse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link org.dexpi.pid.xml.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MaterialOfConstruction")
	public JAXBElement<org.dexpi.pid.xml.String> createMaterialOfConstruction(
			org.dexpi.pid.xml.String value) {
		return new JAXBElement<org.dexpi.pid.xml.String>(
				_MaterialOfConstruction_QNAME, org.dexpi.pid.xml.String.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MinimumDesignPressure")
	public JAXBElement<PressureDouble> createMinimumDesignPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(_MinimumDesignPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LengthString }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "WallThickness")
	public JAXBElement<LengthString> createWallThickness(LengthString value) {
		return new JAXBElement<LengthString>(_WallThickness_QNAME,
				LengthString.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MaximumDesignTemperature")
	public JAXBElement<TemperatureDouble> createMaximumDesignTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_MaximumDesignTemperature_QNAME, TemperatureDouble.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link java.lang.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Description")
	public JAXBElement<java.lang.String> createDescription(
			java.lang.String value) {
		return new JAXBElement<java.lang.String>(_Description_QNAME,
				java.lang.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PlantItem }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "PlantItem")
	public JAXBElement<PlantItem> createPlantItem(PlantItem value) {
		return new JAXBElement<PlantItem>(_PlantItem_QNAME, PlantItem.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "LowerLimitDesignTemperature")
	public JAXBElement<TemperatureDouble> createLowerLimitDesignTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_LowerLimitDesignTemperature_QNAME, TemperatureDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PersistentID }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "PersistentID")
	public JAXBElement<PersistentID> createPersistentID(PersistentID value) {
		return new JAXBElement<PersistentID>(_PersistentID_QNAME,
				PersistentID.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CenterLine }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "CenterLine")
	public JAXBElement<CenterLine> createCenterLine(CenterLine value) {
		return new JAXBElement<CenterLine>(_CenterLine_QNAME, CenterLine.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "LowerLimitOperatingTemperature")
	public JAXBElement<TemperatureDouble> createLowerLimitOperatingTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_LowerLimitOperatingTemperature_QNAME, TemperatureDouble.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PipingComponent }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "PipingComponent")
	public JAXBElement<PipingComponent> createPipingComponent(
			PipingComponent value) {
		return new JAXBElement<PipingComponent>(_PipingComponent_QNAME,
				PipingComponent.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Shape }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Shape", substitutionHeadNamespace = "", substitutionHeadName = "Curve")
	public JAXBElement<Shape> createShape(Shape value) {
		return new JAXBElement<Shape>(_Shape_QNAME, Shape.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "NormalDesignPressure")
	public JAXBElement<PressureDouble> createNormalDesignPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(_NormalDesignPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link TemperatureDouble }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "NormalDesignTemperature")
	public JAXBElement<TemperatureDouble> createNormalDesignTemperature(
			TemperatureDouble value) {
		return new JAXBElement<TemperatureDouble>(
				_NormalDesignTemperature_QNAME, TemperatureDouble.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MaximumOperatingPressure")
	public JAXBElement<PressureDouble> createMaximumOperatingPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(_MaximumOperatingPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "MinimumOperatingPressure")
	public JAXBElement<PressureDouble> createMinimumOperatingPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(_MinimumOperatingPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PressureDouble }
	 * {@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "LowerLimitDesignPressure")
	public JAXBElement<PressureDouble> createLowerLimitDesignPressure(
			PressureDouble value) {
		return new JAXBElement<PressureDouble>(_LowerLimitDesignPressure_QNAME,
				PressureDouble.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Line }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Line", substitutionHeadNamespace = "", substitutionHeadName = "Curve")
	public JAXBElement<Line> createLine(Line value) {
		return new JAXBElement<Line>(_Line_QNAME, Line.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link java.lang.Double }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "ControlPointWeight")
	public JAXBElement<java.lang.Double> createControlPointWeight(
			java.lang.Double value) {
		return new JAXBElement<java.lang.Double>(_ControlPointWeight_QNAME,
				java.lang.Double.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link org.dexpi.pid.xml.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "OperatorType")
	public JAXBElement<org.dexpi.pid.xml.String> createOperatorType(
			org.dexpi.pid.xml.String value) {
		return new JAXBElement<org.dexpi.pid.xml.String>(_OperatorType_QNAME,
				org.dexpi.pid.xml.String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link java.lang.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Manufacturer", scope = PlantItem.class)
	public JAXBElement<java.lang.String> createPlantItemManufacturer(
			java.lang.String value) {
		return new JAXBElement<java.lang.String>(_PlantItemManufacturer_QNAME,
				java.lang.String.class, PlantItem.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link java.lang.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "Supplier", scope = PlantItem.class)
	public JAXBElement<java.lang.String> createPlantItemSupplier(
			java.lang.String value) {
		return new JAXBElement<java.lang.String>(_PlantItemSupplier_QNAME,
				java.lang.String.class, PlantItem.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link java.lang.String }{@code >}
	 * 
	 */
	@SuppressWarnings("static-method")
	@XmlElementDecl(namespace = "", name = "ModelNumber", scope = PlantItem.class)
	public JAXBElement<java.lang.String> createPlantItemModelNumber(
			java.lang.String value) {
		return new JAXBElement<java.lang.String>(_PlantItemModelNumber_QNAME,
				java.lang.String.class, PlantItem.class, value);
	}

}
