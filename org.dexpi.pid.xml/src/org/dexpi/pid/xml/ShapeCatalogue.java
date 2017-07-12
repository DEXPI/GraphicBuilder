//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}Equipment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Nozzle" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}PipingComponent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}ProcessInstrument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}InstrumentComponent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Component" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}PipeConnectorSymbol" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}SignalConnectorSymbol" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Symbol" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}InsulationSymbol" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}PropertyBreak" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}ScopeBubble" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Label" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}PipeFlowArrow" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}PipeSlopeSymbol" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Units" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Date" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "equipmentOrNozzleOrPipingComponent"
})
@XmlRootElement(name = "ShapeCatalogue")
public class ShapeCatalogue extends GeneratedClass{

    @XmlElements({
        @XmlElement(name = "Equipment", type = Equipment.class),
        @XmlElement(name = "InstrumentationLoopFunction", type = InstrumentationLoopFunction.class),
        @XmlElement(name = "ProcessInstrumentationFunction", type = ProcessInstrumentationFunction.class),
        @XmlElement(name = "ActuatingSystemComponent", type = ActuatingSystemComponent.class),
        @XmlElement(name = "ProcessSignalGeneratingFunction", type = ProcessSignalGeneratingFunction.class),
        @XmlElement(name = "ActuatingSystem", type = ActuatingSystem.class),
        @XmlElement(name = "ActuatingFunction", type = ActuatingFunction.class),
        @XmlElement(name = "ProcessSignalGeneratingSystemComponent", type = ProcessSignalGeneratingSystemComponent.class),
        @XmlElement(name = "ProcessSignalGeneratingSystem", type = ProcessSignalGeneratingSystem.class),
        @XmlElement(name = "Nozzle", type = Nozzle.class),
        @XmlElement(name = "PipingComponent", type = PipingComponent.class),
        @XmlElement(name = "ProcessInstrument", type = ProcessInstrument.class),
        @XmlElement(name = "InstrumentComponent", type = InstrumentComponent.class),
        @XmlElement(name = "Component", type = Component.class),
        @XmlElement(name = "PipeConnectorSymbol", type = PipeConnectorSymbol.class),
        @XmlElement(name = "SignalConnectorSymbol", type = SignalConnectorSymbol.class),
        @XmlElement(name = "Symbol", type = Symbol.class),
        @XmlElement(name = "InsulationSymbol", type = InsulationSymbol.class),
        @XmlElement(name = "PropertyBreak", type = PropertyBreak.class),
        @XmlElement(name = "ScopeBubble", type = ScopeBubble.class),
        @XmlElement(name = "Label", type = Label.class),
        @XmlElement(name = "PipeFlowArrow", type = PipeFlowArrow.class),
        @XmlElement(name = "PipeSlopeSymbol", type = PipeSlopeSymbol.class)
    })
    protected List<Object> equipmentOrNozzleOrPipingComponent;
    @XmlAttribute(name = "Name", required = true)
    protected java.lang.String name;
    @XmlAttribute(name = "Version")
    protected java.lang.String version;
    @XmlAttribute(name = "Units")
    protected java.lang.String units;
    @XmlAttribute(name = "Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;

    /**
     * Gets the value of the equipmentOrNozzleOrPipingComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equipmentOrNozzleOrPipingComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipmentOrNozzleOrPipingComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Equipment }
     * {@link Nozzle }
     * {@link PipingComponent }
     * {@link ProcessInstrument }
     * {@link InstrumentComponent }
     * {@link Component }
     * {@link PipeConnectorSymbol }
     * {@link SignalConnectorSymbol }
     * {@link Symbol }
     * {@link InsulationSymbol }
     * {@link PropertyBreak }
     * {@link ScopeBubble }
     * {@link Label }
     * {@link PipeFlowArrow }
     * {@link PipeSlopeSymbol }
     * 
     * 
     */
    public List<Object> getEquipmentOrNozzleOrPipingComponent() {
        if (this.equipmentOrNozzleOrPipingComponent == null) {
            this.equipmentOrNozzleOrPipingComponent = new ArrayList<Object>();
        }
        return this.equipmentOrNozzleOrPipingComponent;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setName(java.lang.String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getVersion() {
        return this.version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setVersion(java.lang.String value) {
        this.version = value;
    }

    /**
     * Ruft den Wert der units-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getUnits() {
        return this.units;
    }

    /**
     * Legt den Wert der units-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setUnits(java.lang.String value) {
        this.units = value;
    }

    /**
     * Ruft den Wert der date-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return this.date;
    }

    /**
     * Legt den Wert der date-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

}
