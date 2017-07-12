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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A BsplineCurve is general form of Rational or polynomial curve represented by control points, basis fuinctions and possibly weights.
 * 
 * <p>Java-Klasse für BsplineCurve complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BsplineCurve">
 *   &lt;complexContent>
 *     &lt;extension base="{}Curve">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{}Presentation" minOccurs="0"/>
 *         &lt;element ref="{}Extent"/>
 *         &lt;element name="ControlPoints" type="{}CTControlPoints"/>
 *         &lt;element name="KnotMultiplicities" type="{}KnotMultiplicities" minOccurs="0"/>
 *         &lt;element name="Knots" type="{}Knots" minOccurs="0"/>
 *         &lt;element name="WeightsData" type="{}WeightsData" minOccurs="0"/>
 *         &lt;element ref="{}GenericAttributes" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="Degree" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="CurveType" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="BsplineCurve"/>
 *             &lt;enumeration value="BsplineCurveWithKnots"/>
 *             &lt;enumeration value="RationalBsplineCurve"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CurveForm">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="PolyLine"/>
 *             &lt;enumeration value="CircularArc"/>
 *             &lt;enumeration value="EllipticArc"/>
 *             &lt;enumeration value="ParabolicArc"/>
 *             &lt;enumeration value="HyperbolicArc"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NumControlPoints" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="NumKnots" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="Closed" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SelfIntersect" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BsplineCurve", propOrder = {
    "presentationOrExtentOrControlPoints"
})
public class BsplineCurve
    extends Curve
{

    @XmlElements({
        @XmlElement(name = "Presentation", type = Presentation.class),
        @XmlElement(name = "Extent", type = Extent.class),
        @XmlElement(name = "ControlPoints", type = CTControlPoints.class),
        @XmlElement(name = "KnotMultiplicities", type = KnotMultiplicities.class),
        @XmlElement(name = "Knots", type = Knots.class),
        @XmlElement(name = "WeightsData", type = WeightsData.class),
        @XmlElement(name = "GenericAttributes", type = GenericAttributes.class)
    })
    protected List<Object> presentationOrExtentOrControlPoints;
    @XmlAttribute(name = "Degree", required = true)
    protected BigInteger degree;
    @XmlAttribute(name = "CurveType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String curveType;
    @XmlAttribute(name = "CurveForm")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String curveForm;
    @XmlAttribute(name = "NumControlPoints", required = true)
    protected BigInteger numControlPoints;
    @XmlAttribute(name = "NumKnots")
    protected BigInteger numKnots;
    @XmlAttribute(name = "Closed")
    protected Boolean closed;
    @XmlAttribute(name = "SelfIntersect")
    protected Boolean selfIntersect;

    /**
     * Gets the value of the presentationOrExtentOrControlPoints property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presentationOrExtentOrControlPoints property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPresentationOrExtentOrControlPoints().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Presentation }
     * {@link Extent }
     * {@link CTControlPoints }
     * {@link KnotMultiplicities }
     * {@link Knots }
     * {@link WeightsData }
     * {@link GenericAttributes }
     * 
     * 
     */
    public List<Object> getPresentationOrExtentOrControlPoints() {
        if (this.presentationOrExtentOrControlPoints == null) {
            this.presentationOrExtentOrControlPoints = new ArrayList<Object>();
        }
        return this.presentationOrExtentOrControlPoints;
    }

    /**
     * Ruft den Wert der degree-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDegree() {
        return this.degree;
    }

    /**
     * Legt den Wert der degree-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDegree(BigInteger value) {
        this.degree = value;
    }

    /**
     * Ruft den Wert der curveType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getCurveType() {
        return this.curveType;
    }

    /**
     * Legt den Wert der curveType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setCurveType(java.lang.String value) {
        this.curveType = value;
    }

    /**
     * Ruft den Wert der curveForm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getCurveForm() {
        return this.curveForm;
    }

    /**
     * Legt den Wert der curveForm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setCurveForm(java.lang.String value) {
        this.curveForm = value;
    }

    /**
     * Ruft den Wert der numControlPoints-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumControlPoints() {
        return this.numControlPoints;
    }

    /**
     * Legt den Wert der numControlPoints-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumControlPoints(BigInteger value) {
        this.numControlPoints = value;
    }

    /**
     * Ruft den Wert der numKnots-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumKnots() {
        return this.numKnots;
    }

    /**
     * Legt den Wert der numKnots-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumKnots(BigInteger value) {
        this.numKnots = value;
    }

    /**
     * Ruft den Wert der closed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClosed() {
        return this.closed;
    }

    /**
     * Legt den Wert der closed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClosed(Boolean value) {
        this.closed = value;
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
