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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A BsplineSurface is general form of Rational or polynomial surface represented by control points, basis fuinctions and possibly weights.
 * 
 * <p>Java-Klasse für BsplineSurface complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BsplineSurface">
 *   &lt;complexContent>
 *     &lt;extension base="{}Surface">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{}Presentation" minOccurs="0"/>
 *         &lt;element ref="{}Extent"/>
 *         &lt;element name="ControlPointArray" type="{}CTControlPointArray"/>
 *         &lt;element name="KnotMultiplicitiesU" type="{}KnotMultiplicities" minOccurs="0"/>
 *         &lt;element name="KnotMultiplicitiesV" type="{}KnotMultiplicities" minOccurs="0"/>
 *         &lt;element name="KnotsU" type="{}Knots" minOccurs="0"/>
 *         &lt;element name="KnotsV" type="{}Knots" minOccurs="0"/>
 *         &lt;element name="Weights" type="{}CTWeights" minOccurs="0"/>
 *         &lt;element ref="{}GenericAttributes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="DegreeU" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="DegreeV" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="SurfaceType" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="BsplineSurface"/>
 *             &lt;enumeration value="BsplineSurfaceWithKnots"/>
 *             &lt;enumeration value="RationalBsplineSurface"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SurfaceForm">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Plane"/>
 *             &lt;enumeration value="RuledSurface"/>
 *             &lt;enumeration value="SurfaceOfLinearExtrusion"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NumControlPointsU" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="NumControlPointsV" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="NumKnotsU" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="NumKnotsV" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="ClosedU" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ClosedV" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SelfIntersect" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BsplineSurface", propOrder = {
    "presentationOrExtentOrControlPointArray"
})
public class BsplineSurface
    extends Surface
{

    @XmlElementRefs({
        @XmlElementRef(name = "KnotMultiplicitiesV", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ControlPointArray", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Weights", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "KnotsV", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Extent", type = Extent.class, required = false),
        @XmlElementRef(name = "GenericAttributes", type = GenericAttributes.class, required = false),
        @XmlElementRef(name = "KnotMultiplicitiesU", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Presentation", type = Presentation.class, required = false),
        @XmlElementRef(name = "KnotsU", type = JAXBElement.class, required = false)
    })
    protected List<Object> presentationOrExtentOrControlPointArray;
    @XmlAttribute(name = "DegreeU", required = true)
    protected BigInteger degreeU;
    @XmlAttribute(name = "DegreeV", required = true)
    protected BigInteger degreeV;
    @XmlAttribute(name = "SurfaceType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String surfaceType;
    @XmlAttribute(name = "SurfaceForm")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String surfaceForm;
    @XmlAttribute(name = "NumControlPointsU", required = true)
    protected BigInteger numControlPointsU;
    @XmlAttribute(name = "NumControlPointsV", required = true)
    protected BigInteger numControlPointsV;
    @XmlAttribute(name = "NumKnotsU")
    protected BigInteger numKnotsU;
    @XmlAttribute(name = "NumKnotsV")
    protected BigInteger numKnotsV;
    @XmlAttribute(name = "ClosedU")
    protected Boolean closedU;
    @XmlAttribute(name = "ClosedV")
    protected Boolean closedV;
    @XmlAttribute(name = "SelfIntersect")
    protected Boolean selfIntersect;

    /**
     * Gets the value of the presentationOrExtentOrControlPointArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presentationOrExtentOrControlPointArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPresentationOrExtentOrControlPointArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CTControlPointArray }{@code >}
     * {@link JAXBElement }{@code <}{@link KnotMultiplicities }{@code >}
     * {@link JAXBElement }{@code <}{@link CTWeights }{@code >}
     * {@link JAXBElement }{@code <}{@link Knots }{@code >}
     * {@link Extent }
     * {@link JAXBElement }{@code <}{@link KnotMultiplicities }{@code >}
     * {@link GenericAttributes }
     * {@link Presentation }
     * {@link JAXBElement }{@code <}{@link Knots }{@code >}
     * 
     * 
     */
    public List<Object> getPresentationOrExtentOrControlPointArray() {
        if (this.presentationOrExtentOrControlPointArray == null) {
            this.presentationOrExtentOrControlPointArray = new ArrayList<Object>();
        }
        return this.presentationOrExtentOrControlPointArray;
    }

    /**
     * Ruft den Wert der degreeU-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDegreeU() {
        return this.degreeU;
    }

    /**
     * Legt den Wert der degreeU-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDegreeU(BigInteger value) {
        this.degreeU = value;
    }

    /**
     * Ruft den Wert der degreeV-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDegreeV() {
        return this.degreeV;
    }

    /**
     * Legt den Wert der degreeV-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDegreeV(BigInteger value) {
        this.degreeV = value;
    }

    /**
     * Ruft den Wert der surfaceType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSurfaceType() {
        return this.surfaceType;
    }

    /**
     * Legt den Wert der surfaceType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSurfaceType(java.lang.String value) {
        this.surfaceType = value;
    }

    /**
     * Ruft den Wert der surfaceForm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSurfaceForm() {
        return this.surfaceForm;
    }

    /**
     * Legt den Wert der surfaceForm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSurfaceForm(java.lang.String value) {
        this.surfaceForm = value;
    }

    /**
     * Ruft den Wert der numControlPointsU-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumControlPointsU() {
        return this.numControlPointsU;
    }

    /**
     * Legt den Wert der numControlPointsU-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumControlPointsU(BigInteger value) {
        this.numControlPointsU = value;
    }

    /**
     * Ruft den Wert der numControlPointsV-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumControlPointsV() {
        return this.numControlPointsV;
    }

    /**
     * Legt den Wert der numControlPointsV-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumControlPointsV(BigInteger value) {
        this.numControlPointsV = value;
    }

    /**
     * Ruft den Wert der numKnotsU-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumKnotsU() {
        return this.numKnotsU;
    }

    /**
     * Legt den Wert der numKnotsU-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumKnotsU(BigInteger value) {
        this.numKnotsU = value;
    }

    /**
     * Ruft den Wert der numKnotsV-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumKnotsV() {
        return this.numKnotsV;
    }

    /**
     * Legt den Wert der numKnotsV-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumKnotsV(BigInteger value) {
        this.numKnotsV = value;
    }

    /**
     * Ruft den Wert der closedU-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClosedU() {
        return this.closedU;
    }

    /**
     * Legt den Wert der closedU-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClosedU(Boolean value) {
        this.closedU = value;
    }

    /**
     * Ruft den Wert der closedV-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClosedV() {
        return this.closedV;
    }

    /**
     * Legt den Wert der closedV-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClosedV(Boolean value) {
        this.closedV = value;
    }

    /**
     * Ruft den Wert der selfIntersect-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSelfIntersect() {
        return this.selfIntersect;
    }

    /**
     * Legt den Wert der selfIntersect-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSelfIntersect(Boolean value) {
        this.selfIntersect = value;
    }

}
