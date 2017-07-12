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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{}UnitsOfMeasure"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SchemaVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="3.6.0" />
 *       &lt;attribute name="OriginatingSystem" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ModelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Date" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="ProjectName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ProjectCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ProjectDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CompanyName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Time" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="Is3D" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" fixed="no" />
 *       &lt;attribute name="Units" use="required" type="{}LengthUnitsType" />
 *       &lt;attribute name="Discipline" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="PID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "unitsOfMeasure"
})
@XmlRootElement(name = "PlantInformation")
public class PlantInformation extends GeneratedClass{

    @XmlElement(name = "UnitsOfMeasure", required = true)
    protected UnitsOfMeasure unitsOfMeasure;
    @XmlAttribute(name = "SchemaVersion", required = true)
    protected java.lang.String schemaVersion;
    @XmlAttribute(name = "OriginatingSystem", required = true)
    protected java.lang.String originatingSystem;
    @XmlAttribute(name = "ModelName")
    protected java.lang.String modelName;
    @XmlAttribute(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlAttribute(name = "ProjectName")
    protected java.lang.String projectName;
    @XmlAttribute(name = "ProjectCode")
    protected java.lang.String projectCode;
    @XmlAttribute(name = "ProjectDescription")
    protected java.lang.String projectDescription;
    @XmlAttribute(name = "CompanyName")
    protected java.lang.String companyName;
    @XmlAttribute(name = "Time", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar time;
    @XmlAttribute(name = "Is3D", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected java.lang.String is3D;
    @XmlAttribute(name = "Units", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String units;
    @XmlAttribute(name = "Discipline", required = true)
    protected java.lang.String discipline;

    /**
     * Ruft den Wert der unitsOfMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UnitsOfMeasure }
     *     
     */
    public UnitsOfMeasure getUnitsOfMeasure() {
        return this.unitsOfMeasure;
    }

    /**
     * Legt den Wert der unitsOfMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitsOfMeasure }
     *     
     */
    public void setUnitsOfMeasure(UnitsOfMeasure value) {
        this.unitsOfMeasure = value;
    }

    /**
     * Ruft den Wert der schemaVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSchemaVersion() {
        if (this.schemaVersion == null) {
            return "3.6.0";
        }
        
		return this.schemaVersion;
    }

    /**
     * Legt den Wert der schemaVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSchemaVersion(java.lang.String value) {
        this.schemaVersion = value;
    }

    /**
     * Ruft den Wert der originatingSystem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getOriginatingSystem() {
		return this.originatingSystem;
    }

    /**
     * Legt den Wert der originatingSystem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setOriginatingSystem(java.lang.String value) {
        this.originatingSystem = value;
    }

    /**
     * Ruft den Wert der modelName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getModelName() {
        return this.modelName;
    }

    /**
     * Legt den Wert der modelName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setModelName(java.lang.String value) {
        this.modelName = value;
    }

    /**
     * Ruft den Wert der date-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return this.date;
    }

    /**
     * Legt den Wert der date-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Ruft den Wert der projectName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getProjectName() {
        return this.projectName;
    }

    /**
     * Legt den Wert der projectName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setProjectName(java.lang.String value) {
        this.projectName = value;
    }

    /**
     * Ruft den Wert der projectCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getProjectCode() {
        return this.projectCode;
    }

    /**
     * Legt den Wert der projectCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setProjectCode(java.lang.String value) {
        this.projectCode = value;
    }

    /**
     * Ruft den Wert der projectDescription-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getProjectDescription() {
        return this.projectDescription;
    }

    /**
     * Legt den Wert der projectDescription-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setProjectDescription(java.lang.String value) {
        this.projectDescription = value;
    }

    /**
     * Ruft den Wert der companyName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getCompanyName() {
        return this.companyName;
    }

    /**
     * Legt den Wert der companyName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setCompanyName(java.lang.String value) {
        this.companyName = value;
    }

    /**
     * Ruft den Wert der time-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTime() {
        return this.time;
    }

    /**
     * Legt den Wert der time-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }

    /**
     * Ruft den Wert der is3D-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getIs3D() {
        if (this.is3D == null) {
            return "no";
        }
        
		return this.is3D;
    }

    /**
     * Legt den Wert der is3D-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setIs3D(java.lang.String value) {
        this.is3D = value;
    }

    /**
     * Ruft den Wert der units-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getUnits() {
        return this.units;
    }

    /**
     * Legt den Wert der units-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setUnits(java.lang.String value) {
        this.units = value;
    }

    /**
     * Ruft den Wert der discipline-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDiscipline() {
        if (this.discipline == null) {
            return "PID";
        }
        
		return this.discipline;
    }

    /**
     * Legt den Wert der discipline-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDiscipline(java.lang.String value) {
        this.discipline = value;
    }

}
