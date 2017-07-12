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
 * <p>Java-Klasse für VolumeUnitsType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="VolumeUnitsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="cc"/>
 *     &lt;enumeration value="MicrometreSquaredMetre"/>
 *     &lt;enumeration value="MillimetreCubed"/>
 *     &lt;enumeration value="CentimetreCubed"/>
 *     &lt;enumeration value="DecimetreCubed"/>
 *     &lt;enumeration value="MetreCubed"/>
 *     &lt;enumeration value="StandardMetreCubed"/>
 *     &lt;enumeration value="KilometreCubed"/>
 *     &lt;enumeration value="MillionMetreCubed"/>
 *     &lt;enumeration value="Millilitre"/>
 *     &lt;enumeration value="Centilitre"/>
 *     &lt;enumeration value="Decilitre"/>
 *     &lt;enumeration value="Litre"/>
 *     &lt;enumeration value="Hectolitre"/>
 *     &lt;enumeration value="InchCubed"/>
 *     &lt;enumeration value="StandardFootCubed"/>
 *     &lt;enumeration value="FootCubed"/>
 *     &lt;enumeration value="HundredFootCubed"/>
 *     &lt;enumeration value="ThousandFootCubed"/>
 *     &lt;enumeration value="MillionFootCubed"/>
 *     &lt;enumeration value="BillionFootCubed"/>
 *     &lt;enumeration value="YardCubed"/>
 *     &lt;enumeration value="MileCubed"/>
 *     &lt;enumeration value="AcreFoot"/>
 *     &lt;enumeration value="UkBushel"/>
 *     &lt;enumeration value="UkFluidOunce"/>
 *     &lt;enumeration value="UkGallon"/>
 *     &lt;enumeration value="ThousandUkGallon"/>
 *     &lt;enumeration value="UkPint"/>
 *     &lt;enumeration value="UkQuart"/>
 *     &lt;enumeration value="UsBarrel"/>
 *     &lt;enumeration value="UsBushel"/>
 *     &lt;enumeration value="UsDryBarrel"/>
 *     &lt;enumeration value="UsDryPint"/>
 *     &lt;enumeration value="UsFluidOunce"/>
 *     &lt;enumeration value="UsGallon"/>
 *     &lt;enumeration value="ThousandUsGallon"/>
 *     &lt;enumeration value="UsLiquidPint"/>
 *     &lt;enumeration value="UsPint"/>
 *     &lt;enumeration value="UsQuart"/>
 *     &lt;enumeration value="Barrel"/>
 *     &lt;enumeration value="ThousandBarrel"/>
 *     &lt;enumeration value="MillionBarrel"/>
 *     &lt;enumeration value="Cubem"/>
 *     &lt;enumeration value="HectareMetre"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VolumeUnitsType")
@XmlEnum
public enum VolumeUnitsType {

    @XmlEnumValue("cc")
    CC("cc"),
    @XmlEnumValue("MicrometreSquaredMetre")
    MICROMETRE_SQUARED_METRE("MicrometreSquaredMetre"),
    @XmlEnumValue("MillimetreCubed")
    MILLIMETRE_CUBED("MillimetreCubed"),
    @XmlEnumValue("CentimetreCubed")
    CENTIMETRE_CUBED("CentimetreCubed"),
    @XmlEnumValue("DecimetreCubed")
    DECIMETRE_CUBED("DecimetreCubed"),
    @XmlEnumValue("MetreCubed")
    METRE_CUBED("MetreCubed"),
    @XmlEnumValue("StandardMetreCubed")
    STANDARD_METRE_CUBED("StandardMetreCubed"),
    @XmlEnumValue("KilometreCubed")
    KILOMETRE_CUBED("KilometreCubed"),
    @XmlEnumValue("MillionMetreCubed")
    MILLION_METRE_CUBED("MillionMetreCubed"),
    @XmlEnumValue("Millilitre")
    MILLILITRE("Millilitre"),
    @XmlEnumValue("Centilitre")
    CENTILITRE("Centilitre"),
    @XmlEnumValue("Decilitre")
    DECILITRE("Decilitre"),
    @XmlEnumValue("Litre")
    LITRE("Litre"),
    @XmlEnumValue("Hectolitre")
    HECTOLITRE("Hectolitre"),
    @XmlEnumValue("InchCubed")
    INCH_CUBED("InchCubed"),
    @XmlEnumValue("StandardFootCubed")
    STANDARD_FOOT_CUBED("StandardFootCubed"),
    @XmlEnumValue("FootCubed")
    FOOT_CUBED("FootCubed"),
    @XmlEnumValue("HundredFootCubed")
    HUNDRED_FOOT_CUBED("HundredFootCubed"),
    @XmlEnumValue("ThousandFootCubed")
    THOUSAND_FOOT_CUBED("ThousandFootCubed"),
    @XmlEnumValue("MillionFootCubed")
    MILLION_FOOT_CUBED("MillionFootCubed"),
    @XmlEnumValue("BillionFootCubed")
    BILLION_FOOT_CUBED("BillionFootCubed"),
    @XmlEnumValue("YardCubed")
    YARD_CUBED("YardCubed"),
    @XmlEnumValue("MileCubed")
    MILE_CUBED("MileCubed"),
    @XmlEnumValue("AcreFoot")
    ACRE_FOOT("AcreFoot"),
    @XmlEnumValue("UkBushel")
    UK_BUSHEL("UkBushel"),
    @XmlEnumValue("UkFluidOunce")
    UK_FLUID_OUNCE("UkFluidOunce"),
    @XmlEnumValue("UkGallon")
    UK_GALLON("UkGallon"),
    @XmlEnumValue("ThousandUkGallon")
    THOUSAND_UK_GALLON("ThousandUkGallon"),
    @XmlEnumValue("UkPint")
    UK_PINT("UkPint"),
    @XmlEnumValue("UkQuart")
    UK_QUART("UkQuart"),
    @XmlEnumValue("UsBarrel")
    US_BARREL("UsBarrel"),
    @XmlEnumValue("UsBushel")
    US_BUSHEL("UsBushel"),
    @XmlEnumValue("UsDryBarrel")
    US_DRY_BARREL("UsDryBarrel"),
    @XmlEnumValue("UsDryPint")
    US_DRY_PINT("UsDryPint"),
    @XmlEnumValue("UsFluidOunce")
    US_FLUID_OUNCE("UsFluidOunce"),
    @XmlEnumValue("UsGallon")
    US_GALLON("UsGallon"),
    @XmlEnumValue("ThousandUsGallon")
    THOUSAND_US_GALLON("ThousandUsGallon"),
    @XmlEnumValue("UsLiquidPint")
    US_LIQUID_PINT("UsLiquidPint"),
    @XmlEnumValue("UsPint")
    US_PINT("UsPint"),
    @XmlEnumValue("UsQuart")
    US_QUART("UsQuart"),
    @XmlEnumValue("Barrel")
    BARREL("Barrel"),
    @XmlEnumValue("ThousandBarrel")
    THOUSAND_BARREL("ThousandBarrel"),
    @XmlEnumValue("MillionBarrel")
    MILLION_BARREL("MillionBarrel"),
    @XmlEnumValue("Cubem")
    CUBEM("Cubem"),
    @XmlEnumValue("HectareMetre")
    HECTARE_METRE("HectareMetre");
    private final java.lang.String value;

    VolumeUnitsType(java.lang.String v) {
        this.value = v;
    }

    public java.lang.String value() {
        return this.value;
    }

    public static VolumeUnitsType fromValue(java.lang.String v) {
        for (VolumeUnitsType c: VolumeUnitsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
