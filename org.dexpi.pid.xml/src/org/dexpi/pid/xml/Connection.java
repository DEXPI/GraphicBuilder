//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="ToID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ToNode" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="FromID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FromNode" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Connection")
public class Connection extends GeneratedClass{

    @XmlAttribute(name = "ToID")
    protected java.lang.String toID;
    @XmlAttribute(name = "ToNode")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger toNode;
    @XmlAttribute(name = "FromID")
    protected java.lang.String fromID;
    @XmlAttribute(name = "FromNode")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger fromNode;

    /**
     * Ruft den Wert der toID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getToID() {
        return this.toID;
    }

    /**
     * Legt den Wert der toID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setToID(java.lang.String value) {
        this.toID = value;
    }

    /**
     * Ruft den Wert der toNode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getToNode() {
        return this.toNode;
    }

    /**
     * Legt den Wert der toNode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setToNode(BigInteger value) {
        this.toNode = value;
    }

    /**
     * Ruft den Wert der fromID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFromID() {
        return this.fromID;
    }

    /**
     * Legt den Wert der fromID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFromID(java.lang.String value) {
        this.fromID = value;
    }

    /**
     * Ruft den Wert der fromNode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFromNode() {
        return this.fromNode;
    }

    /**
     * Legt den Wert der fromNode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFromNode(BigInteger value) {
        this.fromNode = value;
    }

}
