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
import javax.xml.bind.annotation.XmlIDREF;
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
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ItemID" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="DependantAttribute" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute ref="{}DependantAttributeContents default="ValueAndUnits""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "IdentifierElement")
public class IdentifierElement extends GeneratedClass{

    @XmlAttribute(name = "Name", required = true)
    protected java.lang.String name;
    @XmlAttribute(name = "Value")
    protected java.lang.String value;
    @XmlAttribute(name = "ItemID")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object itemID;
    @XmlAttribute(name = "DependantAttribute")
    protected java.lang.String dependantAttribute;
    @XmlAttribute(name = "DependantAttributeContents")
    protected java.lang.String dependantAttributeContents;

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
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getValue() {
        return this.value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der itemID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getItemID() {
        return this.itemID;
    }

    /**
     * Legt den Wert der itemID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setItemID(Object value) {
        this.itemID = value;
    }

    /**
     * Ruft den Wert der dependantAttribute-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDependantAttribute() {
        return this.dependantAttribute;
    }

    /**
     * Legt den Wert der dependantAttribute-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDependantAttribute(java.lang.String value) {
        this.dependantAttribute = value;
    }

    /**
     * Ruft den Wert der dependantAttributeContents-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDependantAttributeContents() {
        if (this.dependantAttributeContents == null) {
            return "ValueAndUnits";
        }
		return this.dependantAttributeContents;
    }

    /**
     * Legt den Wert der dependantAttributeContents-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDependantAttributeContents(java.lang.String value) {
        this.dependantAttributeContents = value;
    }

}
