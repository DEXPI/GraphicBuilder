//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;choice>
 *           &lt;element ref="{}Circle"/>
 *           &lt;element ref="{}Ellipse"/>
 *         &lt;/choice>
 *         &lt;element ref="{}GenericAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="StartAngle" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="EndAngle" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "circle",
    "ellipse",
    "genericAttributes"
})
public class TrimmedCurve
    extends Curve
{

    @XmlElement(name = "Circle")
    protected Circle circle;
    @XmlElement(name = "Ellipse")
    protected Ellipse ellipse;
    @XmlElement(name = "GenericAttributes")
    protected GenericAttributes genericAttributes;
    @XmlAttribute(name = "StartAngle", required = true)
    protected double startAngle;
    @XmlAttribute(name = "EndAngle", required = true)
    protected double endAngle;

    /**
     * Ruft den Wert der circle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Circle }
     *     
     */
    public Circle getCircle() {
        return this.circle;
    }

    /**
     * Legt den Wert der circle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Circle }
     *     
     */
    public void setCircle(Circle value) {
        this.circle = value;
    }

    /**
     * Ruft den Wert der ellipse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Ellipse }
     *     
     */
    public Ellipse getEllipse() {
        return this.ellipse;
    }

    /**
     * Legt den Wert der ellipse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Ellipse }
     *     
     */
    public void setEllipse(Ellipse value) {
        this.ellipse = value;
    }

    /**
     * Ruft den Wert der genericAttributes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GenericAttributes }
     *     
     */
    public GenericAttributes getGenericAttributes() {
        return this.genericAttributes;
    }

    /**
     * Legt den Wert der genericAttributes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericAttributes }
     *     
     */
    public void setGenericAttributes(GenericAttributes value) {
        this.genericAttributes = value;
    }

    /**
     * Ruft den Wert der startAngle-Eigenschaft ab.
     * 
     */
    public double getStartAngle() {
        return this.startAngle;
    }

    /**
     * Legt den Wert der startAngle-Eigenschaft fest.
     * 
     */
    public void setStartAngle(double value) {
        this.startAngle = value;
    }

    /**
     * Ruft den Wert der endAngle-Eigenschaft ab.
     * 
     */
    public double getEndAngle() {
        return this.endAngle;
    }

    /**
     * Legt den Wert der endAngle-Eigenschaft fest.
     * 
     */
    public void setEndAngle(double value) {
        this.endAngle = value;
    }

}
