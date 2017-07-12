//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Presentation" minOccurs="0"/>
 *         &lt;element ref="{}Extent" minOccurs="0"/>
 *         &lt;element ref="{}Node" maxOccurs="unbounded"/>
 *         &lt;element ref="{}GenericAttributes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="NumPoints" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="FlowIn" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="1" />
 *       &lt;attribute name="FlowOut" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="2" />
 *     &lt;/restriction>
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
    "node",
    "genericAttributes"
})
@XmlRootElement(name = "ConnectionPoints")
public class ConnectionPoints extends GeneratedClass{

    @XmlElement(name = "Presentation")
    protected Presentation presentation;
    @XmlElement(name = "Extent")
    protected Extent extent;
    @XmlElement(name = "Node", required = true)
    protected List<Node> node;
    @XmlElement(name = "GenericAttributes")
    protected List<GenericAttributes> genericAttributes;
    @XmlAttribute(name = "NumPoints", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numPoints;
    @XmlAttribute(name = "FlowIn")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger flowIn;
    @XmlAttribute(name = "FlowOut")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger flowOut;

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
     * Gets the value of the node property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the node property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Node }
     * 
     * 
     */
    public List<Node> getNode() {
        if (this.node == null) {
            this.node = new ArrayList<Node>();
        }
        return this.node;
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
     * Ruft den Wert der numPoints-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumPoints() {
        return this.numPoints;
    }

    /**
     * Legt den Wert der numPoints-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumPoints(BigInteger value) {
        this.numPoints = value;
    }

    /**
     * Ruft den Wert der flowIn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFlowIn() {
        if (this.flowIn == null) {
            return new BigInteger("1");
        }
		return this.flowIn;
    }

    /**
     * Legt den Wert der flowIn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFlowIn(BigInteger value) {
        this.flowIn = value;
    }

    /**
     * Ruft den Wert der flowOut-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFlowOut() {
        if (this.flowOut == null) {
            return new BigInteger("2");
        }
		return this.flowOut;
    }

    /**
     * Legt den Wert der flowOut-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFlowOut(BigInteger value) {
        this.flowOut = value;
    }

}
