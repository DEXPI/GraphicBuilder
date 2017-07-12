//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *     &lt;extension base="{}PlantItem">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}Connection" minOccurs="0"/>
 *         &lt;element ref="{}CenterLine"/>
 *         &lt;element ref="{}Component"/>
 *         &lt;element ref="{}SignalConnectorSymbol"/>
 *         &lt;element ref="{}Symbol"/>
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
    "connectionOrCenterLineOrComponent"
})
@XmlRootElement(name = "SignalLine")
public class SignalLine
    extends PlantItem
{

    @XmlElements({
        @XmlElement(name = "Connection", type = Connection.class),
        @XmlElement(name = "CenterLine", type = CenterLine.class),
        @XmlElement(name = "Component", type = Component.class),
        @XmlElement(name = "SignalConnectorSymbol", type = SignalConnectorSymbol.class),
        @XmlElement(name = "Symbol", type = Symbol.class)
    })
    protected List<Object> connectionOrCenterLineOrComponent;

    /**
     * Gets the value of the connectionOrCenterLineOrComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connectionOrCenterLineOrComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnectionOrCenterLineOrComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Connection }
     * {@link CenterLine }
     * {@link Component }
     * {@link SignalConnectorSymbol }
     * {@link Symbol }
     * 
     * 
     */
    public List<Object> getConnectionOrCenterLineOrComponent() {
        if (this.connectionOrCenterLineOrComponent == null) {
            this.connectionOrCenterLineOrComponent = new ArrayList<Object>();
        }
        return this.connectionOrCenterLineOrComponent;
    }

}
