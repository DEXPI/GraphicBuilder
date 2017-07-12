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
 * This Element holds the persistent Identifier for a PlantItem. There can be
 * more than one PersistentID and if so the Context must be used so that they
 * can be separately identified
 * 
 * <p>
 * Java-Klasse für PersistentID complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PersistentID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Identifier" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Context" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

// had to apply some changes, to revert do the following:
// XMLType name = PersistentID
// remove xml root element
// put elementRef for PersistentID in Node back to jaxbelement.class
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "PersistentID")
public class PersistentID extends GeneratedClass {

	@XmlAttribute(name = "Identifier", required = true)
	protected java.lang.String identifier;
	@XmlAttribute(name = "Context")
	protected java.lang.String context;

	/**
	 * Ruft den Wert der identifier-Eigenschaft ab.
	 * 
	 * @return possible object is {@link java.lang.String }
	 * 
	 */
	public java.lang.String getIdentifier() {
		return this.identifier;
	}

	/**
	 * Legt den Wert der identifier-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link java.lang.String }
	 * 
	 */
	public void setIdentifier(java.lang.String value) {
		this.identifier = value;
	}

	/**
	 * Ruft den Wert der context-Eigenschaft ab.
	 * 
	 * @return possible object is {@link java.lang.String }
	 * 
	 */
	public java.lang.String getContext() {
		return this.context;
	}

	/**
	 * Legt den Wert der context-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link java.lang.String }
	 * 
	 */
	public void setContext(java.lang.String value) {
		this.context = value;
	}

}
