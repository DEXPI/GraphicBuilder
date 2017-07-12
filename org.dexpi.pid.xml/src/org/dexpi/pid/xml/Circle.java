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
 *     &lt;extension base="{}Curve">
 *       &lt;sequence>
 *         &lt;element ref="{}Presentation"/>
 *         &lt;element ref="{}Extent"/>
 *         &lt;element ref="{}Position"/>
 *         &lt;element ref="{}GenericAttributes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Radius" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Filled">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Solid"/>
 *             &lt;enumeration value="Hatch"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "presentation",
    "extent",
    "position",
    "genericAttributes"
})
public class Circle
    extends Curve
{

    @XmlElement(name = "Presentation", required = true)
    protected Presentation presentation;
    @XmlElement(name = "Extent", required = true)
    protected Extent extent;
    @XmlElement(name = "Position", required = true)
    protected Position position;
    @XmlElement(name = "GenericAttributes")
    protected List<GenericAttributes> genericAttributes;
    @XmlAttribute(name = "Radius", required = true)
    protected double radius;
    @XmlAttribute(name = "Filled")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String filled;

    /**
     * Ruft den Wert der presentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Presentation }
     *     
     */
    public Presentation getPresentation() {
        return this.presentation;
    }

    /**
     * Legt den Wert der presentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Presentation }
     *     
     */
    public void setPresentation(Presentation value) {
        this.presentation = value;
    }

    /**
     * Ruft den Wert der extent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Extent }
     *     
     */
    public Extent getExtent() {
        return this.extent;
    }

    /**
     * Legt den Wert der extent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Extent }
     *     
     */
    public void setExtent(Extent value) {
        this.extent = value;
    }

    /**
     * Ruft den Wert der position-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Position }
     *     
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Legt den Wert der position-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Position }
     *     
     */
    public void setPosition(Position value) {
        this.position = value;
    }

    /**
     * Gets the value of the genericAttributes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericAttributes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericAttributes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericAttributes }
     * 
     * 
     */
    public List<GenericAttributes> getGenericAttributes() {
        if (this.genericAttributes == null) {
            this.genericAttributes = new ArrayList<GenericAttributes>();
        }
        return this.genericAttributes;
    }

    /**
     * Ruft den Wert der radius-Eigenschaft ab.
     * 
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * Legt den Wert der radius-Eigenschaft fest.
     * 
     */
    public void setRadius(double value) {
        this.radius = value;
    }

    /**
     * Ruft den Wert der filled-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFilled() {
        return this.filled;
    }

    /**
     * Legt den Wert der filled-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFilled(java.lang.String value) {
        this.filled = value;
    }

}
