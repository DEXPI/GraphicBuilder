//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//

package org.dexpi.pid.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="Layer" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Color" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LineType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LineWeight" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="R" type="{}Colour" />
 *       &lt;attribute name="G" type="{}Colour" />
 *       &lt;attribute name="B" type="{}Colour" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Presentation")
public class Presentation extends GeneratedClass {

	@XmlAttribute(name = "Layer")
	protected java.lang.String layer;
	@XmlAttribute(name = "Color")
	protected java.lang.String color;
	@XmlAttribute(name = "LineType")
	protected java.lang.String lineType;
	@XmlAttribute(name = "LineWeight")
	protected java.lang.String lineWeight;
	@XmlAttribute(name = "R")
	protected java.lang.Double r;
	@XmlAttribute(name = "G")
	protected java.lang.Double g;
	@XmlAttribute(name = "B")
	protected java.lang.Double b;

	/**
	 * Ruft den Wert der layer-Eigenschaft ab.
	 * 
	 * @return possible object is {@link java.lang.String }
	 * 
	 */
	public java.lang.String getLayer() {
		return this.layer;
	}

	/**
	 * Legt den Wert der layer-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link java.lang.String }
	 * 
	 */
	public void setLayer(java.lang.String value) {
		this.layer = value;
	}

	/**
	 * Ruft den Wert der color-Eigenschaft ab.
	 * 
	 * @return possible object is {@link java.lang.String }
	 * 
	 */
	public java.lang.String getColor() {
		return this.color;
	}

	/**
	 * Legt den Wert der color-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link java.lang.String }
	 * 
	 */
	public void setColor(java.lang.String value) {
		this.color = value;
	}

	/**
	 * Ruft den Wert der lineType-Eigenschaft ab.
	 * 
	 * @return possible object is {@link java.lang.String }
	 * 
	 */
	public java.lang.String getLineType() {
		return this.lineType;
	}

	/**
	 * Legt den Wert der lineType-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link java.lang.String }
	 * 
	 */
	public void setLineType(java.lang.String value) {
		this.lineType = value;
	}

	/**
	 * Ruft den Wert der lineWeight-Eigenschaft ab.
	 * 
	 * @return possible object is {@link java.lang.String }
	 * 
	 */
	public java.lang.String getLineWeight() {
		return this.lineWeight;
	}

	/**
	 * Legt den Wert der lineWeight-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link java.lang.String }
	 * 
	 */
	public void setLineWeight(java.lang.String value) {
		this.lineWeight = value;
	}

	/**
	 * Ruft den Wert der r-Eigenschaft ab.
	 * 
	 * @return possible object is {@link java.lang.Double }
	 * 
	 */
	public java.lang.Double getR() {
		return this.r;
	}

	/**
	 * Legt den Wert der r-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link java.lang.Double }
	 * 
	 */
	public void setR(java.lang.Double value) {
		this.r = value;
	}

	/**
	 * Ruft den Wert der g-Eigenschaft ab.
	 * 
	 * @return possible object is {@link java.lang.Double }
	 * 
	 */
	public java.lang.Double getG() {
		return this.g;
	}

	/**
	 * Legt den Wert der g-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link java.lang.Double }
	 * 
	 */
	public void setG(java.lang.Double value) {
		this.g = value;
	}

	/**
	 * Ruft den Wert der b-Eigenschaft ab.
	 * 
	 * @return possible object is {@link java.lang.Double }
	 * 
	 */
	public java.lang.Double getB() {
		return this.b;
	}

	/**
	 * Legt den Wert der b-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link java.lang.Double }
	 * 
	 */
	public void setB(java.lang.Double value) {
		this.b = value;
	}

}
