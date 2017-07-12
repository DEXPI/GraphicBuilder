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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Location"/>
 *         &lt;element ref="{}Axis"/>
 *         &lt;element ref="{}Reference"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "location", "axis", "reference" })
@XmlRootElement(name = "Position")
public class Position extends GeneratedClass {

	@XmlElement(name = "Location", required = true)
	protected Location location;
	@XmlElement(name = "Axis", required = true)
	protected Axis axis;
	@XmlElement(name = "Reference", required = true)
	protected Reference reference;

	/**
	 * Ruft den Wert der location-Eigenschaft ab.
	 * 
	 * @return possible object is {@link Location }
	 * 
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * Legt den Wert der location-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link Location }
	 * 
	 */
	public void setLocation(Location value) {
		this.location = value;
	}

	/**
	 * Ruft den Wert der axis-Eigenschaft ab.
	 * 
	 * @return possible object is {@link Axis }
	 * 
	 */
	public Axis getAxis() {
		return this.axis;
	}

	/**
	 * Legt den Wert der axis-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link Axis }
	 * 
	 */
	public void setAxis(Axis value) {
		this.axis = value;
	}

	/**
	 * Ruft den Wert der reference-Eigenschaft ab.
	 * 
	 * @return possible object is {@link Reference }
	 * 
	 */
	public Reference getReference() {
		return this.reference;
	}

	/**
	 * Legt den Wert der reference-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link Reference }
	 * 
	 */
	public void setReference(Reference value) {
		this.reference = value;
	}

}
