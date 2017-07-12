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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 			An Association references other objects either by ID, Name or Tag attribute. 
 * 			If ID elements are persistent (see PlantModel element) then ID references may be to items not in this file.
 * 			
 * 
 * <p>Java-Klasse für Association complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Association">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{}ItemReferenceGroup"/>
 *       &lt;attribute name="Type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="is about"/>
 *             &lt;enumeration value="is a subject of"/>
 *             &lt;enumeration value="is associated with"/>
 *             &lt;enumeration value="is a boundary of"/>
 *             &lt;enumeration value="refers to"/>
 *             &lt;enumeration value="is referenced by"/>
 *             &lt;enumeration value="is referenced in"/>
 *             &lt;enumeration value="describes"/>
 *             &lt;enumeration value="is described in"/>
 *             &lt;enumeration value="indirectly describes"/>
 *             &lt;enumeration value="is indirectly described in"/>
 *             &lt;enumeration value="defines"/>
 *             &lt;enumeration value="is defined in"/>
 *             &lt;enumeration value="is defined by"/>
 *             &lt;enumeration value="contains"/>
 *             &lt;enumeration value="is contained in"/>
 *             &lt;enumeration value="indirectly defines"/>
 *             &lt;enumeration value="is indirectly defined in"/>
 *             &lt;enumeration value="is connected to"/>
 *             &lt;enumeration value="is logically connected to"/>
 *             &lt;enumeration value="is involved with role in"/>
 *             &lt;enumeration value="is an activity with role involving"/>
 *             &lt;enumeration value="is fulfilled by"/>
 *             &lt;enumeration value="fulfills"/>
 *             &lt;enumeration value="is a part of"/>
 *             &lt;enumeration value="is an assembly including"/>
 *             &lt;enumeration value="is a component of"/>
 *             &lt;enumeration value="is a composition including"/>
 *             &lt;enumeration value="is an element of"/>
 *             &lt;enumeration value="is a collection including"/>
 *             &lt;enumeration value="is identified by"/>
 *             &lt;enumeration value="is an identifier for"/>
 *             &lt;enumeration value="is a template including"/>
 *             &lt;enumeration value="is a component of template"/>
 *             &lt;enumeration value="is a template that refers to"/>
 *             &lt;enumeration value="is a reference in template"/>
 *             &lt;enumeration value="is classified as"/>
 *             &lt;enumeration value="is incidentally classified as"/>
 *             &lt;enumeration value="has dataset"/>
 *             &lt;enumeration value="is a dataset of"/>
 *             &lt;enumeration value="is a comment referring to"/>
 *             &lt;enumeration value="is referenced in comment"/>
 *             &lt;enumeration value="has document"/>
 *             &lt;enumeration value="is a document for"/>
 *             &lt;enumeration value="is the location of"/>
 *             &lt;enumeration value="is located in"/>
 *             &lt;enumeration value="is upstream of"/>
 *             &lt;enumeration value="is downstream of"/>
 *             &lt;enumeration value="is the responsibility of"/>
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
@XmlType(name = "Association")
public class Association extends GeneratedClass{

    @XmlAttribute(name = "Type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String type;
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
