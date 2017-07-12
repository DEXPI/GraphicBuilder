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
 * <p>Java-Klasse für AngleUnitsType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="AngleUnitsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="rad"/>
 *     &lt;enumeration value="deg"/>
 *     &lt;enumeration value="Radian"/>
 *     &lt;enumeration value="Degree-angle"/>
 *     &lt;enumeration value="CentesimalSecond"/>
 *     &lt;enumeration value="CentesimalMinute"/>
 *     &lt;enumeration value="Second-angle"/>
 *     &lt;enumeration value="Minute-angle"/>
 *     &lt;enumeration value="Microradian"/>
 *     &lt;enumeration value="Milliradian"/>
 *     &lt;enumeration value="Kiloradian"/>
 *     &lt;enumeration value="Megaradian"/>
 *     &lt;enumeration value="Gigaradian"/>
 *     &lt;enumeration value="Mil_6400Radian"/>
 *     &lt;enumeration value="Cycle"/>
 *     &lt;enumeration value="Iso2041Cycle"/>
 *     &lt;enumeration value="DecimalDegree"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AngleUnitsType")
@XmlEnum
public enum AngleUnitsType {

    @XmlEnumValue("rad")
    RAD("rad"),
    @XmlEnumValue("deg")
    DEG("deg"),
    @XmlEnumValue("Radian")
    RADIAN("Radian"),
    @XmlEnumValue("Degree-angle")
    DEGREE_ANGLE("Degree-angle"),
    @XmlEnumValue("CentesimalSecond")
    CENTESIMAL_SECOND("CentesimalSecond"),
    @XmlEnumValue("CentesimalMinute")
    CENTESIMAL_MINUTE("CentesimalMinute"),
    @XmlEnumValue("Second-angle")
    SECOND_ANGLE("Second-angle"),
    @XmlEnumValue("Minute-angle")
    MINUTE_ANGLE("Minute-angle"),
    @XmlEnumValue("Microradian")
    MICRORADIAN("Microradian"),
    @XmlEnumValue("Milliradian")
    MILLIRADIAN("Milliradian"),
    @XmlEnumValue("Kiloradian")
    KILORADIAN("Kiloradian"),
    @XmlEnumValue("Megaradian")
    MEGARADIAN("Megaradian"),
    @XmlEnumValue("Gigaradian")
    GIGARADIAN("Gigaradian"),
    @XmlEnumValue("Mil_6400Radian")
    MIL_6400_RADIAN("Mil_6400Radian"),
    @XmlEnumValue("Cycle")
    CYCLE("Cycle"),
    @XmlEnumValue("Iso2041Cycle")
    ISO_2041_CYCLE("Iso2041Cycle"),
    @XmlEnumValue("DecimalDegree")
    DECIMAL_DEGREE("DecimalDegree");
    private final java.lang.String value;

    AngleUnitsType(java.lang.String v) {
        this.value = v;
    }

    public java.lang.String value() {
        return this.value;
    }

    public static AngleUnitsType fromValue(java.lang.String v) {
        for (AngleUnitsType c: AngleUnitsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
