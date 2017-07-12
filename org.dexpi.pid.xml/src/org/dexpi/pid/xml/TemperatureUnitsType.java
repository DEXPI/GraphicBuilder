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
 * <p>Java-Klasse für TemperatureUnitsType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="TemperatureUnitsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="degC"/>
 *     &lt;enumeration value="degF"/>
 *     &lt;enumeration value="degK"/>
 *     &lt;enumeration value="K"/>
 *     &lt;enumeration value="DegreeCelsius"/>
 *     &lt;enumeration value="DegreeRankine"/>
 *     &lt;enumeration value="DegreeFahrenheit"/>
 *     &lt;enumeration value="Kelvin"/>
 *     &lt;enumeration value="MilliKelvin"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TemperatureUnitsType")
@XmlEnum
public enum TemperatureUnitsType {

    @XmlEnumValue("degC")
    DEG_C("degC"),
    @XmlEnumValue("degF")
    DEG_F("degF"),
    @XmlEnumValue("degK")
    DEG_K("degK"),
    K("K"),
    @XmlEnumValue("DegreeCelsius")
    DEGREE_CELSIUS("DegreeCelsius"),
    @XmlEnumValue("DegreeRankine")
    DEGREE_RANKINE("DegreeRankine"),
    @XmlEnumValue("DegreeFahrenheit")
    DEGREE_FAHRENHEIT("DegreeFahrenheit"),
    @XmlEnumValue("Kelvin")
    KELVIN("Kelvin"),
    @XmlEnumValue("MilliKelvin")
    MILLI_KELVIN("MilliKelvin");
    private final java.lang.String value;

    TemperatureUnitsType(java.lang.String v) {
        this.value = v;
    }

    public java.lang.String value() {
        return this.value;
    }

    public static TemperatureUnitsType fromValue(java.lang.String v) {
        for (TemperatureUnitsType c: TemperatureUnitsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
