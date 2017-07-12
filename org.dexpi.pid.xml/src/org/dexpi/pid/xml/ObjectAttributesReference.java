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
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlMixed;
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
 *       &lt;choice minOccurs="0">
 *       &lt;/choice>
 *       &lt;attGroup ref="{}ItemReferenceGroup"/>
 *       &lt;attribute name="DependantAttribute" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute ref="{}DependantAttributeContents default="ValueAndUnits""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "ObjectAttributesReference")
public class ObjectAttributesReference extends GeneratedClass{

    @XmlMixed
    protected List<java.lang.String> content;
    @XmlAttribute(name = "DependantAttribute", required = true)
    protected java.lang.String dependantAttribute;
    @XmlAttribute(name = "DependantAttributeContents")
    protected java.lang.String dependantAttributeContents;
    @XmlAttribute(name = "ItemID")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object itemID;
    @XmlAttribute(name = "TagName")
    protected java.lang.String tagName;
    @XmlAttribute(name = "Name")
    protected java.lang.String name;
    @XmlAttribute(name = "ItemURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String itemURI;
    @XmlAttribute(name = "PersistentIDIdentifier")
    protected java.lang.String persistentIDIdentifier;
    @XmlAttribute(name = "PersistentIDContext")
    protected java.lang.String persistentIDContext;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String }
     * 
     * 
     */
    public List<java.lang.String> getContent() {
        if (this.content == null) {
            this.content = new ArrayList<java.lang.String>();
        }
        return this.content;
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
     * Ruft den Wert der tagName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getTagName() {
        return this.tagName;
    }

    /**
     * Legt den Wert der tagName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setTagName(java.lang.String value) {
        this.tagName = value;
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
     * Ruft den Wert der itemURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getItemURI() {
        return this.itemURI;
    }

    /**
     * Legt den Wert der itemURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setItemURI(java.lang.String value) {
        this.itemURI = value;
    }

    /**
     * Ruft den Wert der persistentIDIdentifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPersistentIDIdentifier() {
        return this.persistentIDIdentifier;
    }

    /**
     * Legt den Wert der persistentIDIdentifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPersistentIDIdentifier(java.lang.String value) {
        this.persistentIDIdentifier = value;
    }

    /**
     * Ruft den Wert der persistentIDContext-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPersistentIDContext() {
        return this.persistentIDContext;
    }

    /**
     * Legt den Wert der persistentIDContext-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPersistentIDContext(java.lang.String value) {
        this.persistentIDContext = value;
    }

}
