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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für anonymous complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}PlantItem">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}ProcessInstrument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Component" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}NominalDiameter" minOccurs="0"/>
 *         &lt;element ref="{}InsideDiameter" minOccurs="0"/>
 *         &lt;element ref="{}OutsideDiameter" minOccurs="0"/>
 *         &lt;element ref="{}OperatorType" minOccurs="0"/>
 *         &lt;element ref="{}WallThickness" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "processInstrumentOrComponentOrNominalDiameter" })
@XmlRootElement(name = "ProcessInstrument")
public class ProcessInstrument extends
		DrawableObjectThatInheritsDirectlyFromPlantItem {

	@XmlElementRefs({
			@XmlElementRef(name = "WallThickness", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "ProcessInstrument", type = ProcessInstrument.class, required = false),
			@XmlElementRef(name = "OperatorType", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "Component", type = Component.class, required = false),
			@XmlElementRef(name = "OutsideDiameter", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "InsideDiameter", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "NominalDiameter", type = JAXBElement.class, required = false) })
	protected List<Object> processInstrumentOrComponentOrNominalDiameter;

	/**
	 * Gets the value of the processInstrumentOrComponentOrNominalDiameter
	 * property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the
	 * processInstrumentOrComponentOrNominalDiameter property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProcessInstrumentOrComponentOrNominalDiameter().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link JAXBElement }{@code <}{@link LengthString }{@code >}
	 * {@link ProcessInstrument } {@link JAXBElement }{@code <}{@link String }
	 * {@code >} {@link Component } {@link JAXBElement }{@code <}
	 * {@link LengthDouble }{@code >} {@link JAXBElement }{@code <}
	 * {@link LengthDouble }{@code >} {@link JAXBElement }{@code <}
	 * {@link LengthDouble }{@code >}
	 * 
	 * 
	 */
	public List<Object> getProcessInstrumentOrComponentOrNominalDiameter() {
		if (this.processInstrumentOrComponentOrNominalDiameter == null) {
			this.processInstrumentOrComponentOrNominalDiameter = new ArrayList<Object>();
		}
		return this.processInstrumentOrComponentOrNominalDiameter;
	}

}
