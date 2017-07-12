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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlMixed;
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
 *         &lt;element ref="{}Presentation"/>
 *         &lt;element ref="{}Extent"/>
 *         &lt;element ref="{}Position"/>
 *         &lt;element name="String">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{}TextStringFormatSpecification"/>
 *         &lt;element ref="{}GenericAttributes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="NumLines" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="String" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Font" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Justification" default="LeftBottom">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="LeftTop"/>
 *             &lt;enumeration value="LeftCenter"/>
 *             &lt;enumeration value="LeftBottom"/>
 *             &lt;enumeration value="CenterTop"/>
 *             &lt;enumeration value="CenterCenter"/>
 *             &lt;enumeration value="CenterBottom"/>
 *             &lt;enumeration value="RightTop"/>
 *             &lt;enumeration value="RightCenter"/>
 *             &lt;enumeration value="RightBottom"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Width" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Height" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="TextAngle" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="SlantAngle" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="ItemID" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="Set" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "", propOrder = {
    "presentationOrExtentOrPosition"
})
@XmlRootElement(name = "Text")
public class Text extends GeneratedClass{

    @XmlElements({
        @XmlElement(name = "Presentation", type = Presentation.class),
        @XmlElement(name = "Extent", type = Extent.class),
        @XmlElement(name = "Position", type = Position.class),
        @XmlElement(name = "String", type = Text.String.class),
        @XmlElement(name = "TextStringFormatSpecification", type = TextStringFormatSpecification.class),
        @XmlElement(name = "GenericAttributes", type = GenericAttributes.class)
    })
    protected List<Object> presentationOrExtentOrPosition;
    @XmlAttribute(name = "NumLines")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numLines;
    @XmlAttribute(name = "String")
    protected java.lang.String string;
    @XmlAttribute(name = "Font", required = true)
    protected java.lang.String font;
    @XmlAttribute(name = "Justification")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String justification;
    @XmlAttribute(name = "Width", required = true)
    protected double width;
    @XmlAttribute(name = "Height", required = true)
    protected double height;
    @XmlAttribute(name = "TextAngle")
    protected java.lang.Double textAngle;
    @XmlAttribute(name = "SlantAngle")
    protected java.lang.Double slantAngle;
    @XmlAttribute(name = "ItemID")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object itemID;
    @XmlAttribute(name = "Set")
    protected java.lang.String set;
    @XmlAttribute(name = "DependantAttribute")
    protected java.lang.String dependantAttribute;
    @XmlAttribute(name = "DependantAttributeContents")
    protected java.lang.String dependantAttributeContents;

    /**
     * Gets the value of the presentationOrExtentOrPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presentationOrExtentOrPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPresentationOrExtentOrPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Presentation }
     * {@link Extent }
     * {@link Position }
     * {@link Text.String }
     * {@link TextStringFormatSpecification }
     * {@link GenericAttributes }
     * 
     * 
     */
    public List<Object> getPresentationOrExtentOrPosition() {
        if (this.presentationOrExtentOrPosition == null) {
            this.presentationOrExtentOrPosition = new ArrayList<Object>();
        }
        return this.presentationOrExtentOrPosition;
    }

    //setzt den Wrt von getPresentationOrExtentOrPosition
    public void setPresentationOrExtentOrPosition(List<Object> newPresentationOrExtentOrPosition) {
    	this.presentationOrExtentOrPosition = newPresentationOrExtentOrPosition;
    }
    
    /**
     * Ruft den Wert der numLines-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumLines() {
        return this.numLines;
    }

    /**
     * Legt den Wert der numLines-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumLines(BigInteger value) {
        this.numLines = value;
    }

    /**
     * Ruft den Wert der string-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getString() {
        return this.string;
    }

    /**
     * Legt den Wert der string-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setString(java.lang.String value) {
        this.string = value;
    }

    /**
     * Ruft den Wert der font-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFont() {
        return this.font;
    }

    /**
     * Legt den Wert der font-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFont(java.lang.String value) {
        this.font = value;
    }

    /**
     * Ruft den Wert der justification-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getJustification() {
        if (this.justification == null) {
            return "LeftBottom";
        }
        
		return this.justification;
    }

    /**
     * Legt den Wert der justification-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setJustification(java.lang.String value) {
        this.justification = value;
    }

    /**
     * Ruft den Wert der width-Eigenschaft ab.
     * 
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Legt den Wert der width-Eigenschaft fest.
     * 
     */
    public void setWidth(double value) {
        this.width = value;
    }

    /**
     * Ruft den Wert der height-Eigenschaft ab.
     * 
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Legt den Wert der height-Eigenschaft fest.
     * 
     */
    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Ruft den Wert der textAngle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.Double }
     *     
     */
    public java.lang.Double getTextAngle() {
        return this.textAngle;
    }

    /**
     * Legt den Wert der textAngle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.Double }
     *     
     */
    public void setTextAngle(java.lang.Double value) {
        this.textAngle = value;
    }

    /**
     * Ruft den Wert der slantAngle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.Double }
     *     
     */
    public java.lang.Double getSlantAngle() {
        return this.slantAngle;
    }

    /**
     * Legt den Wert der slantAngle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.Double }
     *     
     */
    public void setSlantAngle(java.lang.Double value) {
        this.slantAngle = value;
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
     * Ruft den Wert der set-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSet() {
        return this.set;
    }

    /**
     * Legt den Wert der set-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSet(java.lang.String value) {
        this.set = value;
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
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class String {

        @XmlMixed
        protected List<java.lang.String> content;
        @XmlAttribute(name = "Value")
        protected java.lang.String value;

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

    }

}
