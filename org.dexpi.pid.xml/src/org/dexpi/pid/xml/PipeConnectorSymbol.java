//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *     &lt;extension base="{}AnnotationItem">
 *       &lt;sequence>
 *         &lt;element ref="{}CrossPageConnection" minOccurs="0"/>
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
    "crossPageConnection"
})
@XmlRootElement(name = "PipeConnectorSymbol")
public class PipeConnectorSymbol
    extends AnnotationItem
{

    @XmlElement(name = "CrossPageConnection")
    protected CrossPageConnection crossPageConnection;

    /**
     * Ruft den Wert der crossPageConnection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CrossPageConnection }
     *     
     */
    public CrossPageConnection getCrossPageConnection() {
        return this.crossPageConnection;
    }

    /**
     * Legt den Wert der crossPageConnection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossPageConnection }
     *     
     */
    public void setCrossPageConnection(CrossPageConnection value) {
        this.crossPageConnection = value;
    }

}
