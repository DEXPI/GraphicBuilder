//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{}Position"/>
 *         &lt;element ref="{}PersistentID"/>
 *         &lt;element ref="{}NominalDiameter" minOccurs="0"/>
 *         &lt;element ref="{}InsideDiameter" minOccurs="0"/>
 *         &lt;element ref="{}OutsideDiameter" minOccurs="0"/>
 *         &lt;element ref="{}EndPreparation" minOccurs="0"/>
 *         &lt;element ref="{}GasketGap" minOccurs="0"/>
 *         &lt;element ref="{}Rating" minOccurs="0"/>
 *         &lt;element ref="{}ScheduleThickness" minOccurs="0"/>
 *         &lt;element ref="{}ConnectionType" minOccurs="0"/>
 *         &lt;element ref="{}WeldType" minOccurs="0"/>
 *         &lt;element ref="{}GenericAttributes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="unspecified"/>
 *             &lt;enumeration value="process"/>
 *             &lt;enumeration value="signal"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Function">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="unspecified"/>
 *             &lt;enumeration value="primary"/>
 *             &lt;enumeration value="secondary"/>
 *             &lt;enumeration value="tap"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Flow">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="unspecified"/>
 *             &lt;enumeration value="in"/>
 *             &lt;enumeration value="out"/>
 *             &lt;enumeration value="both"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "positionOrPersistentIDOrNominalDiameter"
})
@XmlRootElement(name = "Node")
public class Node extends GeneratedClass{

    @XmlElementRefs({
        @XmlElementRef(name = "ScheduleThickness", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Position", type = Position.class, required = false),
        @XmlElementRef(name = "ConnectionType", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GasketGap", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GenericAttributes", type = GenericAttributes.class, required = false),
        @XmlElementRef(name = "EndPreparation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OutsideDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InsideDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PersistentID", type = PersistentID.class, required = false), //JAXBElement.class, required = false),
        @XmlElementRef(name = "WeldType", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Rating", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NominalDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Identifier", type = Identifier.class, required = true)
    })
    protected List<Object> positionOrPersistentIDOrNominalDiameter;
    @XmlAttribute(name = "ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;
    @XmlAttribute(name = "Name")
    protected java.lang.String name;
    @XmlAttribute(name = "Type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String type;
    @XmlAttribute(name = "Function")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String function;
    @XmlAttribute(name = "Flow")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String flow;

    /**
     * Gets the value of the positionOrPersistentIDOrNominalDiameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the positionOrPersistentIDOrNominalDiameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPositionOrPersistentIDOrNominalDiameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Position }
     * {@link JAXBElement }{@code <}{@link LengthString }{@code >}
     * {@link JAXBElement }{@code <}{@link org.dexpi.pid.xml.String }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link GenericAttributes }
     * {@link JAXBElement }{@code <}{@link PersistentID }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link org.dexpi.pid.xml.String }{@code >}
     * {@link JAXBElement }{@code <}{@link org.dexpi.pid.xml.String }{@code >}
     * {@link JAXBElement }{@code <}{@link org.dexpi.pid.xml.String }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * 
     * 
     */
    public List<Object> getPositionOrPersistentIDOrNominalDiameter() {
        if (this.positionOrPersistentIDOrNominalDiameter == null) {
            this.positionOrPersistentIDOrNominalDiameter = new ArrayList<Object>();
        }
        return this.positionOrPersistentIDOrNominalDiameter;
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
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setType(java.lang.String value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der function-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFunction() {
        return this.function;
    }

    /**
     * Legt den Wert der function-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFunction(java.lang.String value) {
        this.function = value;
    }

    /**
     * Ruft den Wert der flow-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFlow() {
        return this.flow;
    }

    /**
     * Legt den Wert der flow-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFlow(java.lang.String value) {
        this.flow = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getID() {
        return this.id;
    }
    
    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setID(java.lang.String value) {
        this.id = value;
    }
}
