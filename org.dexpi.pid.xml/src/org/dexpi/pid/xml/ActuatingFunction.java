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

//TODO VERIFY: Currently the content of this file is only copied from Equipment.java - schema-verify that this class is correct!

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "disciplineOrMinimumDesignPressureOrMaximumDesignPressure" })
@XmlRootElement(name = "ActuatingFunction")
public class ActuatingFunction extends
		DrawableObjectThatInheritsDirectlyFromPlantItem {

	@XmlElementRefs({
		@XmlElementRef(name = "LowerLimitDesignPressure", type = JAXBElement.class, required = false),
		@XmlElementRef(name = "Discipline", type = JAXBElement.class, required = false),
		@XmlElementRef(name = "Nozzle", type = Nozzle.class, required = false),
		@XmlElementRef(name = "MaximumDesignPressure", type = JAXBElement.class, required = false),
		@XmlElementRef(name = "UpperLimitDesignTemperature", type = JAXBElement.class, required = false),
		@XmlElementRef(name = "LowerLimitDesignTemperature", type = JAXBElement.class, required = false),
		@XmlElementRef(name = "MaximumDesignTemperature", type = JAXBElement.class, required = false),
		@XmlElementRef(name = "MinimumDesignPressure", type = JAXBElement.class, required = false),
		@XmlElementRef(name = "MinimumDesignTemperature", type = JAXBElement.class, required = false),
		@XmlElementRef(name = "Component", type = Component.class, required = false),
		@XmlElementRef(name = "Equipment", type = Equipment.class, required = false),
		@XmlElementRef(name = "InformationFlow", type = InformationFlow.class, required = false),
		@XmlElementRef(name = "UpperLimitDesignPressure", type = JAXBElement.class, required = false),
		@XmlElementRef(name = "Label", type = Label.class, required = false) })
protected List<Object> disciplineOrMinimumDesignPressureOrMaximumDesignPressure;
@XmlAttribute(name = "ProcessArea")
protected java.lang.String processArea;
@XmlAttribute(name = "Purpose")
protected java.lang.String purpose;

/**
 * Gets the value of the
 * disciplineOrMinimumDesignPressureOrMaximumDesignPressure property.
 * 
 * <p>
 * This accessor method returns a reference to the live list, not a
 * snapshot. Therefore any modification you make to the returned list will
 * be present inside the JAXB object. This is why there is not a
 * <CODE>set</CODE> method for the
 * disciplineOrMinimumDesignPressureOrMaximumDesignPressure property.
 * 
 * <p>
 * For example, to add a new item, do as follows:
 * 
 * <pre>
 * getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure().add(newItem);
 * </pre>
 * 
 * 
 * <p>
 * Objects of the following type(s) are allowed in the list
 * {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
 * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
 * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
 * {@link Nozzle } {@link JAXBElement }{@code <}{@link TemperatureDouble }
 * {@code >} {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
 * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
 * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
 * {@link JAXBElement }{@code <}{@link TemperatureDouble }{@code >}
 * {@link JAXBElement }{@code <}{@link PressureDouble }{@code >}
 * {@link Equipment } {@link Component }
 * 
 * 
 */
public List<Object> getDisciplineOrMinimumDesignPressureOrMaximumDesignPressure() {
	if (this.disciplineOrMinimumDesignPressureOrMaximumDesignPressure == null) {
		this.disciplineOrMinimumDesignPressureOrMaximumDesignPressure = new ArrayList<Object>();
	}
	return this.disciplineOrMinimumDesignPressureOrMaximumDesignPressure;
}

/**
 * Ruft den Wert der processArea-Eigenschaft ab.
 * 
 * @return possible object is {@link java.lang.String }
 * 
 */
public java.lang.String getProcessArea() {
	return this.processArea;
}

/**
 * Legt den Wert der processArea-Eigenschaft fest.
 * 
 * @param value
 *            allowed object is {@link java.lang.String }
 * 
 */
public void setProcessArea(java.lang.String value) {
	this.processArea = value;
}

/**
 * Ruft den Wert der purpose-Eigenschaft ab.
 * 
 * @return possible object is {@link java.lang.String }
 * 
 */
public java.lang.String getPurpose() {
	return this.purpose;
}

/**
 * Legt den Wert der purpose-Eigenschaft fest.
 * 
 * @param value
 *            allowed object is {@link java.lang.String }
 * 
 */
public void setPurpose(java.lang.String value) {
	this.purpose = value;
}


	
}
