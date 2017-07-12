//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *         &lt;element ref="{}Presentation"/>
 *         &lt;element ref="{}Extent"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}Component"/>
 *           &lt;element ref="{}Curve"/>
 *           &lt;element ref="{}Surface"/>
 *           &lt;element ref="{}Text"/>
 *           &lt;element ref="{}DrawingBorder"/>
 *           &lt;element ref="{}Symbol"/>
 *           &lt;element ref="{}InsulationSymbol"/>
 *           &lt;element ref="{}ScopeBubble"/>
 *           &lt;element ref="{}PropertyBreak"/>
 *           &lt;element ref="{}Label"/>
 *           &lt;element ref="{}PipeFlowArrow"/>
 *           &lt;element ref="{}PipeSlopeSymbol"/>
 *           &lt;element ref="{}GenericAttributes"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="PID" />
 *       &lt;attribute name="Revision" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RevisionURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Size" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SizeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Orientation">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Portrait"/>
 *             &lt;enumeration value="Landscape"/>
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
@XmlType(name = "", propOrder = {
    "presentation",
    "extent",
    "componentOrCurveOrSurface"
})
@XmlRootElement(name = "Drawing")
public class Drawing extends GeneratedClass{

    @XmlElement(name = "Presentation", required = true)
    protected Presentation presentation;
    @XmlElement(name = "Extent", required = true)
    protected Extent extent;
    @XmlElementRefs({
        @XmlElementRef(name = "DrawingBorder", type = DrawingBorder.class, required = false),
        @XmlElementRef(name = "PropertyBreak", type = PropertyBreak.class, required = false),
        @XmlElementRef(name = "Text", type = Text.class, required = false),
        @XmlElementRef(name = "Surface", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PipeSlopeSymbol", type = PipeSlopeSymbol.class, required = false),
        @XmlElementRef(name = "Symbol", type = Symbol.class, required = false),
        @XmlElementRef(name = "GenericAttributes", type = GenericAttributes.class, required = false),
        @XmlElementRef(name = "InsulationSymbol", type = InsulationSymbol.class, required = false),
        @XmlElementRef(name = "Curve", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PipeFlowArrow", type = PipeFlowArrow.class, required = false),
        @XmlElementRef(name = "Component", type = Component.class, required = false),
        @XmlElementRef(name = "Label", type = Label.class, required = false),
        @XmlElementRef(name = "ScopeBubble", type = ScopeBubble.class, required = false)
    })
    protected List<Object> componentOrCurveOrSurface;
    @XmlAttribute(name = "Name", required = true)
    protected java.lang.String name;
    @XmlAttribute(name = "Type", required = true)
    protected java.lang.String type;
    @XmlAttribute(name = "Revision")
    protected java.lang.String revision;
    @XmlAttribute(name = "RevisionURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String revisionURI;
    @XmlAttribute(name = "Title")
    protected java.lang.String title;
    @XmlAttribute(name = "Size")
    protected java.lang.String size;
    @XmlAttribute(name = "SizeURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String sizeURI;
    @XmlAttribute(name = "Orientation")
    protected java.lang.String orientation;

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
     * Gets the value of the componentOrCurveOrSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componentOrCurveOrSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponentOrCurveOrSurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DrawingBorder }
     * {@link PropertyBreak }
     * {@link JAXBElement }{@code <}{@link Plane }{@code >}
     * {@link JAXBElement }{@code <}{@link Ellipse }{@code >}
     * {@link Text }
     * {@link JAXBElement }{@code <}{@link CurveBoundedSurface }{@code >}
     * {@link JAXBElement }{@code <}{@link Surface }{@code >}
     * {@link PipeSlopeSymbol }
     * {@link JAXBElement }{@code <}{@link Line }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeCurve }{@code >}
     * {@link JAXBElement }{@code <}{@link Shape }{@code >}
     * {@link JAXBElement }{@code <}{@link BsplineSurface }{@code >}
     * {@link Symbol }
     * {@link JAXBElement }{@code <}{@link TrimmedCurve }{@code >}
     * {@link GenericAttributes }
     * {@link InsulationSymbol }
     * {@link JAXBElement }{@code <}{@link Curve }{@code >}
     * {@link JAXBElement }{@code <}{@link Circle }{@code >}
     * {@link PipeFlowArrow }
     * {@link JAXBElement }{@code <}{@link PolyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link BsplineCurve }{@code >}
     * {@link Component }
     * {@link Label }
     * {@link ScopeBubble }
     * 
     * 
     */
    public List<Object> getComponentOrCurveOrSurface() {
        if (this.componentOrCurveOrSurface == null) {
            this.componentOrCurveOrSurface = new ArrayList<Object>();
        }
        return this.componentOrCurveOrSurface;
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
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getType() {
        if (this.type == null) {
            return "PID";
        }
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
     * Ruft den Wert der revision-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRevision() {
        return this.revision;
    }

    /**
     * Legt den Wert der revision-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRevision(java.lang.String value) {
        this.revision = value;
    }

    /**
     * Ruft den Wert der revisionURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRevisionURI() {
        return this.revisionURI;
    }

    /**
     * Legt den Wert der revisionURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRevisionURI(java.lang.String value) {
        this.revisionURI = value;
    }

    /**
     * Ruft den Wert der title-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getTitle() {
        return this.title;
    }

    /**
     * Legt den Wert der title-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setTitle(java.lang.String value) {
        this.title = value;
    }

    /**
     * Ruft den Wert der size-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSize() {
        return this.size;
    }

    /**
     * Legt den Wert der size-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSize(java.lang.String value) {
        this.size = value;
    }

    /**
     * Ruft den Wert der sizeURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSizeURI() {
        return this.sizeURI;
    }

    /**
     * Legt den Wert der sizeURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSizeURI(java.lang.String value) {
        this.sizeURI = value;
    }

    /**
     * Ruft den Wert der orientation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getOrientation() {
        return this.orientation;
    }

    /**
     * Legt den Wert der orientation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setOrientation(java.lang.String value) {
        this.orientation = value;
    }

}
