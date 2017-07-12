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
 *           &lt;element ref="{}Curve"/>
 *           &lt;element ref="{}Surface"/>
 *           &lt;element ref="{}Text"/>
 *           &lt;element ref="{}Label"/>
 *           &lt;element ref="{}GenericAttributes"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Size" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SizeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
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
    "curveOrSurfaceOrText"
})
@XmlRootElement(name = "DrawingBorder")
public class DrawingBorder extends GeneratedClass{

    @XmlElement(name = "Presentation", required = true)
    protected Presentation presentation;
    @XmlElement(name = "Extent", required = true)
    protected Extent extent;
    @XmlElementRefs({
        @XmlElementRef(name = "Text", type = Text.class, required = false),
        @XmlElementRef(name = "Curve", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Surface", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GenericAttributes", type = GenericAttributes.class, required = false),
        @XmlElementRef(name = "Label", type = Label.class, required = false)
    })
    protected List<Object> curveOrSurfaceOrText;
    @XmlAttribute(name = "Name")
    protected java.lang.String name;
    @XmlAttribute(name = "Size")
    protected java.lang.String size;
    @XmlAttribute(name = "SizeURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String sizeURI;

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
     * Gets the value of the curveOrSurfaceOrText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the curveOrSurfaceOrText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurveOrSurfaceOrText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Plane }{@code >}
     * {@link JAXBElement }{@code <}{@link Ellipse }{@code >}
     * {@link Text }
     * {@link JAXBElement }{@code <}{@link Surface }{@code >}
     * {@link JAXBElement }{@code <}{@link CurveBoundedSurface }{@code >}
     * {@link JAXBElement }{@code <}{@link Line }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeCurve }{@code >}
     * {@link JAXBElement }{@code <}{@link Shape }{@code >}
     * {@link JAXBElement }{@code <}{@link BsplineSurface }{@code >}
     * {@link GenericAttributes }
     * {@link JAXBElement }{@code <}{@link TrimmedCurve }{@code >}
     * {@link JAXBElement }{@code <}{@link Circle }{@code >}
     * {@link JAXBElement }{@code <}{@link Curve }{@code >}
     * {@link JAXBElement }{@code <}{@link PolyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link BsplineCurve }{@code >}
     * {@link Label }
     * 
     * 
     */
    public List<Object> getCurveOrSurfaceOrText() {
        if (this.curveOrSurfaceOrText == null) {
            this.curveOrSurfaceOrText = new ArrayList<Object>();
        }
        return this.curveOrSurfaceOrText;
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

}
