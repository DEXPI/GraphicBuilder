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
 *         &lt;element ref="{}NominalDiameter"/>
 *         &lt;element ref="{}InsideDiameter"/>
 *         &lt;element ref="{}OutsideDiameter"/>
 *         &lt;element ref="{}StartDiameter"/>
 *         &lt;element ref="{}EndDiameter"/>
 *         &lt;element ref="{}NormalDesignPressure"/>
 *         &lt;element ref="{}MinimumDesignPressure"/>
 *         &lt;element ref="{}MaximumDesignPressure"/>
 *         &lt;element ref="{}NormalDesignTemperature"/>
 *         &lt;element ref="{}MinimumDesignTemperature"/>
 *         &lt;element ref="{}MaximumDesignTemperature"/>
 *         &lt;element ref="{}MinimumOperatingPressure"/>
 *         &lt;element ref="{}MaximumOperatingPressure"/>
 *         &lt;element ref="{}MinimumOperatingTemperature"/>
 *         &lt;element ref="{}MaximumOperatingTemperature"/>
 *         &lt;element ref="{}NominalDesignPressure"/>
 *         &lt;element ref="{}LowerLimitDesignPressure"/>
 *         &lt;element ref="{}UpperLimitDesignPressure"/>
 *         &lt;element ref="{}NominalDesignTemperature"/>
 *         &lt;element ref="{}LowerLimitDesignTemperature"/>
 *         &lt;element ref="{}UpperLimitDesignTemperature"/>
 *         &lt;element ref="{}NormalOperatingPressure"/>
 *         &lt;element ref="{}LowerLimitOperatingPressure"/>
 *         &lt;element ref="{}UpperLimitOperatingPressure"/>
 *         &lt;element ref="{}TestPressure"/>
 *         &lt;element ref="{}NormalOperatingTemperature"/>
 *         &lt;element ref="{}LowerLimitOperatingTemperature"/>
 *         &lt;element ref="{}UpperLimitOperatingTemperature"/>
 *         &lt;element ref="{}WallThickness"/>
 *         &lt;element ref="{}Connection"/>
 *         &lt;element ref="{}CenterLine"/>
 *         &lt;element ref="{}Equipment"/>
 *         &lt;element ref="{}PipingComponent"/>
 *         &lt;element ref="{}ProcessInstrument"/>
 *         &lt;element ref="{}Component"/>
 *         &lt;element ref="{}PipeConnectorSymbol"/>
 *         &lt;element ref="{}PipeFlowArrow"/>
 *         &lt;element ref="{}PipeSlopeSymbol"/>
 *         &lt;element ref="{}InsulationSymbol"/>
 *         &lt;element ref="{}InstrumentConnection"/>
 *         &lt;element ref="{}Inclination"/>
 *       &lt;/choice>
 *       &lt;attribute name="DualFlow" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nominalDiameterOrInsideDiameterOrOutsideDiameter"
})
@XmlRootElement(name = "InformationFlow")
public class InformationFlow
    extends DrawableObjectThatInheritsDirectlyFromPlantItem
{

    @XmlElementRefs({
        @XmlElementRef(name = "LowerLimitOperatingTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NominalDesignPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WallThickness", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ProcessInstrument", type = ProcessInstrument.class, required = false),
        @XmlElementRef(name = "LowerLimitDesignTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UpperLimitDesignTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinimumDesignPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NormalOperatingTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaximumOperatingTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NormalDesignPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NormalDesignTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InsulationSymbol", type = InsulationSymbol.class, required = false),
        @XmlElementRef(name = "EndDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Inclination", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NormalOperatingPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UpperLimitOperatingPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UpperLimitOperatingTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LowerLimitOperatingPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinimumDesignTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PipeFlowArrow", type = PipeFlowArrow.class, required = false),
        @XmlElementRef(name = "Component", type = Component.class, required = false),
        @XmlElementRef(name = "Equipment", type = Equipment.class, required = false),
        @XmlElementRef(name = "InsideDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NominalDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TestPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PipeConnectorSymbol", type = PipeConnectorSymbol.class, required = false),  
        @XmlElementRef(name = "Label", type = Label.class, required = false), 
        @XmlElementRef(name = "NominalDesignTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PipeSlopeSymbol", type = PipeSlopeSymbol.class, required = false),
        @XmlElementRef(name = "PipingComponent", type = PipingComponent.class, required = false),
        @XmlElementRef(name = "MinimumOperatingPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InstrumentConnection", type = InstrumentConnection.class, required = false),
        @XmlElementRef(name = "StartDiameter", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UpperLimitDesignPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinimumOperatingTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LowerLimitDesignPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaximumDesignPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Connection", type = Connection.class, required = false),
        @XmlElementRef(name = "MaximumDesignTemperature", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CenterLine", type = CenterLine.class, required = false),
        @XmlElementRef(name = "MaximumOperatingPressure", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OutsideDiameter", type = JAXBElement.class, required = false)
    })
    protected List<Object> nominalDiameterOrInsideDiameterOrOutsideDiameter;
    @XmlAttribute(name = "DualFlow")
    protected Boolean dualFlow;

    /**
     * Gets the value of the nominalDiameterOrInsideDiameterOrOutsideDiameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nominalDiameterOrInsideDiameterOrOutsideDiameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNominalDiameterOrInsideDiameterOrOutsideDiameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthString }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link ProcessInstrument }
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link InsulationSymbol }
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link AngleDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link PipeFlowArrow }
     * {@link Equipment }
     * {@link Component }
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link PipeConnectorSymbol }
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link PipingComponent }{@code >}
     * {@link PipeSlopeSymbol }
     * {@link InstrumentConnection }
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link Connection }
     * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link CenterLine }{@code >}
     * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthDouble }{@code >}
     * 
     * 
     */
    public List<Object> getNominalDiameterOrInsideDiameterOrOutsideDiameter() {
        if (this.nominalDiameterOrInsideDiameterOrOutsideDiameter == null) {
            this.nominalDiameterOrInsideDiameterOrOutsideDiameter = new ArrayList<Object>();
        }
        return this.nominalDiameterOrInsideDiameterOrOutsideDiameter;
    }

    /**
     * Ruft den Wert der dualFlow-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDualFlow() {
        return this.dualFlow;
    }

    /**
     * Legt den Wert der dualFlow-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDualFlow(Boolean value) {
        this.dualFlow = value;
    }

}
