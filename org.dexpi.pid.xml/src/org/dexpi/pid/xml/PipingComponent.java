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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * PipingComponent covers all bought components. For Complex components they may have subcomponents that are either mechanical or piping. Component is used for mechanical items such as Valve Topworks.
 * 		
 * 
 * <p>Java-Klasse für PipingComponent complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PipingComponent">
 *   &lt;complexContent>
 *     &lt;extension base="{}PlantItem">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}PipingComponent"/>
 *         &lt;element ref="{}Component"/>
 *         &lt;element ref="{}NominalDiameter" minOccurs="0"/>
 *         &lt;element ref="{}LargeDiameter" minOccurs="0"/>
 *         &lt;element ref="{}SmallDiameter" minOccurs="0"/>
 *         &lt;element ref="{}InsideDiameter" minOccurs="0"/>
 *         &lt;element ref="{}OutsideDiameter" minOccurs="0"/>
 *         &lt;element ref="{}ConnectionType" minOccurs="0"/>
 *         &lt;element ref="{}Rating" minOccurs="0"/>
 *         &lt;element ref="{}OperatorType" minOccurs="0"/>
 *         &lt;element ref="{}WallThickness" minOccurs="0"/>
 *         &lt;element ref="{}FabricationCategory" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="Standard" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="StandardURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
//to change back -
//XMLType name = PipingComponent
//remove xml root element
// put elementRef in Pnseg back to jaxbelement.class

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pipingComponentOrComponentOrNominalDiameter"
})
@XmlRootElement(name = "PipingComponent")
public class PipingComponent
    extends PlantItem
{

    @XmlElementRefs({
        @XmlElementRef(name = "SmallDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WallThickness", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ConnectionType", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OperatorType", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PipingComponent", type = PipingComponent.class, required = false),
        @XmlElementRef(name = "FabricationCategory", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Component", type = Component.class, required = false),
        @XmlElementRef(name = "OutsideDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InsideDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LargeDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Rating", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NominalDiameter", type = JAXBElement.class, required = false)
    })
    protected List<Object> pipingComponentOrComponentOrNominalDiameter;
    @XmlAttribute(name = "Standard")
    protected java.lang.String standard;
    @XmlAttribute(name = "StandardURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String standardURI;

    /**
     * Gets the value of the pipingComponentOrComponentOrNominalDiameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pipingComponentOrComponentOrNominalDiameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPipingComponentOrComponentOrNominalDiameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthString }{@code >}
     * {@link JAXBElement }{@code <}{@link org.dexpi.pid.xml.String }{@code >}
     * {@link JAXBElement }{@code <}{@link PipingComponent }{@code >}
     * {@link JAXBElement }{@code <}{@link org.dexpi.pid.xml.String }{@code >}
     * {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * {@link Component }
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link org.dexpi.pid.xml.String }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * 
     * 
     */
    public List<Object> getPipingComponentOrComponentOrNominalDiameter() {
        if (this.pipingComponentOrComponentOrNominalDiameter == null) {
            this.pipingComponentOrComponentOrNominalDiameter = new ArrayList<Object>();
        }
        return this.pipingComponentOrComponentOrNominalDiameter;
    }

    /**
     * Ruft den Wert der standard-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getStandard() {
        return this.standard;
    }

    /**
     * Legt den Wert der standard-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setStandard(java.lang.String value) {
        this.standard = value;
    }

    /**
     * Ruft den Wert der standardURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getStandardURI() {
        return this.standardURI;
    }

    /**
     * Legt den Wert der standardURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setStandardURI(java.lang.String value) {
        this.standardURI = value;
    }

}
