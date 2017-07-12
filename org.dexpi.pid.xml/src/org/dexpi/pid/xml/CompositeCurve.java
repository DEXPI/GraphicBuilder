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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}Curve">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}Presentation"/>
 *         &lt;element ref="{}Extent"/>
 *         &lt;element ref="{}Curve" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}GenericAttributes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "presentationOrExtentOrCurve"
})
public class CompositeCurve
    extends Curve
{

    @XmlElementRefs({
        @XmlElementRef(name = "Curve", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Extent", type = Extent.class, required = false),
        @XmlElementRef(name = "GenericAttributes", type = GenericAttributes.class, required = false),
        @XmlElementRef(name = "Presentation", type = Presentation.class, required = false)
    })
    protected List<Object> presentationOrExtentOrCurve;

    /**
     * Gets the value of the presentationOrExtentOrCurve property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presentationOrExtentOrCurve property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPresentationOrExtentOrCurve().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Ellipse }{@code >}
     * {@link JAXBElement }{@code <}{@link Curve }{@code >}
     * {@link JAXBElement }{@code <}{@link Circle }{@code >}
     * {@link Extent }
     * {@link JAXBElement }{@code <}{@link Shape }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeCurve }{@code >}
     * {@link JAXBElement }{@code <}{@link Line }{@code >}
     * {@link JAXBElement }{@code <}{@link PolyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link BsplineCurve }{@code >}
     * {@link GenericAttributes }
     * {@link JAXBElement }{@code <}{@link TrimmedCurve }{@code >}
     * {@link Presentation }
     * 
     * 
     */
    public List<Object> getPresentationOrExtentOrCurve() {
        if (this.presentationOrExtentOrCurve == null) {
            this.presentationOrExtentOrCurve = new ArrayList<Object>();
        }
        return this.presentationOrExtentOrCurve;
    }

}
