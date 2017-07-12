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
 *       &lt;attribute name="Area" type="{}AreaUnitsType" default="MetreSquared" />
 *       &lt;attribute name="Angle" type="{}AngleUnitsType" default="Degree-angle" />
 *       &lt;attribute name="Distance" type="{}LengthUnitsType" default="Millimetre" />
 *       &lt;attribute name="Temperature" type="{}TemperatureUnitsType" default="DegreeCelsius" />
 *       &lt;attribute name="Pressure" type="{}PressureUnitsType" default="Bar" />
 *       &lt;attribute name="Volume" type="{}VolumeUnitsType" default="MetreCubed" />
 *       &lt;attribute name="Weight" type="{}MassUnitsType" default="Kilogram" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "UnitsOfMeasure")
public class UnitsOfMeasure extends GeneratedClass{

    @XmlAttribute(name = "Area")
    protected AreaUnitsType area;
    @XmlAttribute(name = "Angle")
    protected AngleUnitsType angle;
    @XmlAttribute(name = "Distance")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String distance;
    @XmlAttribute(name = "Temperature")
    protected TemperatureUnitsType temperature;
    @XmlAttribute(name = "Pressure")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String pressure;
    @XmlAttribute(name = "Volume")
    protected VolumeUnitsType volume;
    @XmlAttribute(name = "Weight")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String weight;

    /**
     * Ruft den Wert der area-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AreaUnitsType }
     *     
     */
    public AreaUnitsType getArea() {
        if (this.area == null) {
            return AreaUnitsType.METRE_SQUARED;
        }
        
		return this.area;
    }

    /**
     * Legt den Wert der area-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AreaUnitsType }
     *     
     */
    public void setArea(AreaUnitsType value) {
        this.area = value;
    }

    /**
     * Ruft den Wert der angle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AngleUnitsType }
     *     
     */
    public AngleUnitsType getAngle() {
        if (this.angle == null) {
            return AngleUnitsType.DEGREE_ANGLE;
        }
        
		return this.angle;
    }

    /**
     * Legt den Wert der angle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleUnitsType }
     *     
     */
    public void setAngle(AngleUnitsType value) {
        this.angle = value;
    }

    /**
     * Ruft den Wert der distance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDistance() {
        if (this.distance == null) {
            return "Millimetre";
        }
        
		return this.distance;
    }

    /**
     * Legt den Wert der distance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDistance(java.lang.String value) {
        this.distance = value;
    }

    /**
     * Ruft den Wert der temperature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureUnitsType }
     *     
     */
    public TemperatureUnitsType getTemperature() {
        if (this.temperature == null) {
            return TemperatureUnitsType.DEGREE_CELSIUS;
        }
        
		return this.temperature;
    }

    /**
     * Legt den Wert der temperature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureUnitsType }
     *     
     */
    public void setTemperature(TemperatureUnitsType value) {
        this.temperature = value;
    }

    /**
     * Ruft den Wert der pressure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPressure() {
        if (this.pressure == null) {
            return "Bar";
        }
        
		return this.pressure;
    }

    /**
     * Legt den Wert der pressure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPressure(java.lang.String value) {
        this.pressure = value;
    }

    /**
     * Ruft den Wert der volume-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link VolumeUnitsType }
     *     
     */
    public VolumeUnitsType getVolume() {
        if (this.volume == null) {
            return VolumeUnitsType.METRE_CUBED;
        }
        
		return this.volume;
    }

    /**
     * Legt den Wert der volume-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeUnitsType }
     *     
     */
    public void setVolume(VolumeUnitsType value) {
        this.volume = value;
    }

    /**
     * Ruft den Wert der weight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getWeight() {
        if (this.weight == null) {
            return "Kilogram";
        }
        
		return this.weight;
    }

    /**
     * Legt den Wert der weight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setWeight(java.lang.String value) {
        this.weight = value;
    }

}
