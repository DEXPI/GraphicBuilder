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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}Surface">
 *       &lt;sequence>
 *         &lt;element ref="{}Surface"/>
 *         &lt;element ref="{}OuterBoundary" minOccurs="0"/>
 *         &lt;element ref="{}InnerBoundary" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "surface",
    "outerBoundary",
    "innerBoundary"
})
public class CurveBoundedSurface
    extends Surface
{

    @XmlElementRef(name = "Surface", type = JAXBElement.class)
    protected JAXBElement<? extends Surface> surface;
    @XmlElement(name = "OuterBoundary")
    protected OuterBoundary outerBoundary;
    @XmlElement(name = "InnerBoundary")
    protected List<InnerBoundary> innerBoundary;

    /**
     * Ruft den Wert der surface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Plane }{@code >}
     *     {@link JAXBElement }{@code <}{@link BsplineSurface }{@code >}
     *     {@link JAXBElement }{@code <}{@link Surface }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurveBoundedSurface }{@code >}
     *     
     */
    public JAXBElement<? extends Surface> getSurface() {
        return this.surface;
    }

    /**
     * Legt den Wert der surface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Plane }{@code >}
     *     {@link JAXBElement }{@code <}{@link BsplineSurface }{@code >}
     *     {@link JAXBElement }{@code <}{@link Surface }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurveBoundedSurface }{@code >}
     *     
     */
    public void setSurface(JAXBElement<? extends Surface> value) {
        this.surface = value;
    }

    /**
     * Ruft den Wert der outerBoundary-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OuterBoundary }
     *     
     */
    public OuterBoundary getOuterBoundary() {
        return this.outerBoundary;
    }

    /**
     * Legt den Wert der outerBoundary-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OuterBoundary }
     *     
     */
    public void setOuterBoundary(OuterBoundary value) {
        this.outerBoundary = value;
    }

    /**
     * Gets the value of the innerBoundary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerBoundary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerBoundary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InnerBoundary }
     * 
     * 
     */
    public List<InnerBoundary> getInnerBoundary() {
        if (this.innerBoundary == null) {
            this.innerBoundary = new ArrayList<InnerBoundary>();
        }
        return this.innerBoundary;
    }

}
