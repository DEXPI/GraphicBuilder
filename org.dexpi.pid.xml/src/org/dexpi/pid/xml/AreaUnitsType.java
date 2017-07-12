//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für AreaUnitsType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="AreaUnitsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="sq mm"/>
 *     &lt;enumeration value="sq cm"/>
 *     &lt;enumeration value="sq dm"/>
 *     &lt;enumeration value="sq m"/>
 *     &lt;enumeration value="sq km"/>
 *     &lt;enumeration value="sq in"/>
 *     &lt;enumeration value="sq ft"/>
 *     &lt;enumeration value="sq yd"/>
 *     &lt;enumeration value="MillimetreSquared"/>
 *     &lt;enumeration value="CentimetreSquared"/>
 *     &lt;enumeration value="DecimetreSquared"/>
 *     &lt;enumeration value="MetreSquared"/>
 *     &lt;enumeration value="KilometreSquared"/>
 *     &lt;enumeration value="InchSquared"/>
 *     &lt;enumeration value="FootSquared"/>
 *     &lt;enumeration value="YardSquared"/>
 *     &lt;enumeration value="MileSquared"/>
 *     &lt;enumeration value="Barn"/>
 *     &lt;enumeration value="MicrometreSquared"/>
 *     &lt;enumeration value="Are"/>
 *     &lt;enumeration value="Hectare"/>
 *     &lt;enumeration value="Acre"/>
 *     &lt;enumeration value="HundredFootSquared"/>
 *     &lt;enumeration value="UsSurveyMileSquared"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AreaUnitsType")
@XmlEnum
public enum AreaUnitsType {

    @XmlEnumValue("sq mm")
    SQ_MM("sq mm"),
    @XmlEnumValue("sq cm")
    SQ_CM("sq cm"),
    @XmlEnumValue("sq dm")
    SQ_DM("sq dm"),
    @XmlEnumValue("sq m")
    SQ_M("sq m"),
    @XmlEnumValue("sq km")
    SQ_KM("sq km"),
    @XmlEnumValue("sq in")
    SQ_IN("sq in"),
    @XmlEnumValue("sq ft")
    SQ_FT("sq ft"),
    @XmlEnumValue("sq yd")
    SQ_YD("sq yd"),
    @XmlEnumValue("MillimetreSquared")
    MILLIMETRE_SQUARED("MillimetreSquared"),
    @XmlEnumValue("CentimetreSquared")
    CENTIMETRE_SQUARED("CentimetreSquared"),
    @XmlEnumValue("DecimetreSquared")
    DECIMETRE_SQUARED("DecimetreSquared"),
    @XmlEnumValue("MetreSquared")
    METRE_SQUARED("MetreSquared"),
    @XmlEnumValue("KilometreSquared")
    KILOMETRE_SQUARED("KilometreSquared"),
    @XmlEnumValue("InchSquared")
    INCH_SQUARED("InchSquared"),
    @XmlEnumValue("FootSquared")
    FOOT_SQUARED("FootSquared"),
    @XmlEnumValue("YardSquared")
    YARD_SQUARED("YardSquared"),
    @XmlEnumValue("MileSquared")
    MILE_SQUARED("MileSquared"),
    @XmlEnumValue("Barn")
    BARN("Barn"),
    @XmlEnumValue("MicrometreSquared")
    MICROMETRE_SQUARED("MicrometreSquared"),
    @XmlEnumValue("Are")
    ARE("Are"),
    @XmlEnumValue("Hectare")
    HECTARE("Hectare"),
    @XmlEnumValue("Acre")
    ACRE("Acre"),
    @XmlEnumValue("HundredFootSquared")
    HUNDRED_FOOT_SQUARED("HundredFootSquared"),
    @XmlEnumValue("UsSurveyMileSquared")
    US_SURVEY_MILE_SQUARED("UsSurveyMileSquared");
    private final java.lang.String value;

    AreaUnitsType(java.lang.String v) {
        this.value = v;
    }

    public java.lang.String value() {
        return this.value;
    }

    public static AreaUnitsType fromValue(java.lang.String v) {
        for (AreaUnitsType c: AreaUnitsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
