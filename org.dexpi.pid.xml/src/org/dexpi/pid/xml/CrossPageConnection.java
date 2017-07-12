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
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &lt;choice>
 *         &lt;element name="LinkedPersistentID" type="{}PersistentID" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="DrawingName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LinkLabel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "linkedPersistentID"
})
@XmlRootElement(name = "CrossPageConnection")
public class CrossPageConnection extends GeneratedClass{

    @XmlElement(name = "LinkedPersistentID")
    protected PersistentID linkedPersistentID;
    @XmlAttribute(name = "DrawingName")
    protected java.lang.String drawingName;
    @XmlAttribute(name = "LinkLabel")
    protected java.lang.String linkLabel;

    /**
     * Ruft den Wert der linkedPersistentID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PersistentID }
     *     
     */
    public PersistentID getLinkedPersistentID() {
        return this.linkedPersistentID;
    }

    /**
     * Legt den Wert der linkedPersistentID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PersistentID }
     *     
     */
    public void setLinkedPersistentID(PersistentID value) {
        this.linkedPersistentID = value;
    }

    /**
     * Ruft den Wert der drawingName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDrawingName() {
        return this.drawingName;
    }

    /**
     * Legt den Wert der drawingName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDrawingName(java.lang.String value) {
        this.drawingName = value;
    }

    /**
     * Ruft den Wert der linkLabel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getLinkLabel() {
        return this.linkLabel;
    }

    /**
     * Legt den Wert der linkLabel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setLinkLabel(java.lang.String value) {
        this.linkLabel = value;
    }

}
