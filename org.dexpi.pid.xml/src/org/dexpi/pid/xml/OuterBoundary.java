//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{}Curve"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "curve"
})
@XmlRootElement(name = "OuterBoundary")
public class OuterBoundary extends GeneratedClass{

    @XmlElementRef(name = "Curve", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends Curve> curve;

    /**
     * Ruft den Wert der curve-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Ellipse }{@code >}
     *     {@link JAXBElement }{@code <}{@link Curve }{@code >}
     *     {@link JAXBElement }{@code <}{@link Circle }{@code >}
     *     {@link JAXBElement }{@code <}{@link Shape }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeCurve }{@code >}
     *     {@link JAXBElement }{@code <}{@link Line }{@code >}
     *     {@link JAXBElement }{@code <}{@link PolyLine }{@code >}
     *     {@link JAXBElement }{@code <}{@link BsplineCurve }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrimmedCurve }{@code >}
     *     
     */
    public JAXBElement<? extends Curve> getCurve() {
		return this.curve;
    }

    /**
     * Legt den Wert der curve-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Ellipse }{@code >}
     *     {@link JAXBElement }{@code <}{@link Curve }{@code >}
     *     {@link JAXBElement }{@code <}{@link Circle }{@code >}
     *     {@link JAXBElement }{@code <}{@link Shape }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeCurve }{@code >}
     *     {@link JAXBElement }{@code <}{@link Line }{@code >}
     *     {@link JAXBElement }{@code <}{@link PolyLine }{@code >}
     *     {@link JAXBElement }{@code <}{@link BsplineCurve }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrimmedCurve }{@code >}
     *     
     */
    public void setCurve(JAXBElement<? extends Curve> value) {
        this.curve = value;
    }

}
