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
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DefaultValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute ref="{}Units"/>
 *       &lt;attribute ref="{}Format"/>
 *       &lt;attribute name="AttributeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="ValueURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="UnitsURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "GenericAttribute")
public class GenericAttribute extends GeneratedClass{

    @XmlAttribute(name = "Name", required = true)
    protected java.lang.String name;
    @XmlAttribute(name = "Value")
    protected java.lang.String value;
    @XmlAttribute(name = "DefaultValue")
    protected java.lang.String defaultValue;
    @XmlAttribute(name = "Units")
    @XmlSchemaType(name = "anySimpleType")
    protected java.lang.String units;
    @XmlAttribute(name = "Format")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String format;
    @XmlAttribute(name = "AttributeURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String attributeURI;
    @XmlAttribute(name = "ValueURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String valueURI;
    @XmlAttribute(name = "UnitsURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String unitsURI;

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
     * Ruft den Wert der defaultValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDefaultValue() {
        return this.defaultValue;
    }

    /**
     * Legt den Wert der defaultValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDefaultValue(java.lang.String value) {
        this.defaultValue = value;
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
     * Ruft den Wert der format-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFormat() {
        return this.format;
    }

    /**
     * Legt den Wert der format-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFormat(java.lang.String value) {
        this.format = value;
    }

    /**
     * Ruft den Wert der attributeURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getAttributeURI() {
        return this.attributeURI;
    }

    /**
     * Legt den Wert der attributeURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setAttributeURI(java.lang.String value) {
        this.attributeURI = value;
    }

    /**
     * Ruft den Wert der valueURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getValueURI() {
        return this.valueURI;
    }

    /**
     * Legt den Wert der valueURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setValueURI(java.lang.String value) {
        this.valueURI = value;
    }

    /**
     * Ruft den Wert der unitsURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getUnitsURI() {
        return this.unitsURI;
    }

    /**
     * Legt den Wert der unitsURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setUnitsURI(java.lang.String value) {
        this.unitsURI = value;
    }

}
