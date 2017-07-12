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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{}PlantInformation"/>
 *         &lt;element name="RDLService" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ServiceAddress" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                 &lt;attribute name="QueryParameter" type="{http://www.w3.org/2001/XMLSchema}string" default="query" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{}Extent"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}Presentation"/>
 *           &lt;element ref="{}ShapeCatalogue"/>
 *           &lt;element ref="{}Drawing"/>
 *           &lt;element ref="{}PlantArea"/>
 *           &lt;element ref="{}Equipment"/>
 *           &lt;element ref="{}InstrumentComponent"/>
 *           &lt;element ref="{}InstrumentLoop"/>
 *           &lt;element ref="{}SignalLine"/>
 *           &lt;element ref="{}SignalConnectorSymbol"/>
 *           &lt;element ref="{}PipingNetworkSystem"/>
 *           &lt;element ref="{}ProcessInstrument"/>
 *           &lt;element ref="{}Curve"/>
 *           &lt;element ref="{}Surface"/>
 *           &lt;element ref="{}Text"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "plantInformation", "rdlService", "extent",
		"presentationOrShapeCatalogueOrDrawing" })
@XmlRootElement(name = "PlantModel")
public class PlantModel extends GeneratedClass {

	@XmlElement(name = "PlantInformation", required = true)
	protected PlantInformation plantInformation;
	@XmlElement(name = "RDLService")
	protected List<PlantModel.RDLService> rdlService;
	@XmlElement(name = "Extent", required = true)
	protected Extent extent;
	@XmlElementRefs({
			@XmlElementRef(name = "SignalLine", type = SignalLine.class, required = false),
			@XmlElementRef(name = "PlantArea", type = PlantArea.class, required = false),
			@XmlElementRef(name = "PipingNetworkSystem", type = PipingNetworkSystem.class, required = false),
			@XmlElementRef(name = "Drawing", type = Drawing.class, required = false),
			@XmlElementRef(name = "ProcessInstrument", type = ProcessInstrument.class, required = false),
			@XmlElementRef(name = "Text", type = Text.class, required = false),
			@XmlElementRef(name = "Curve", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "SignalConnectorSymbol", type = SignalConnectorSymbol.class, required = false),
			@XmlElementRef(name = "InstrumentLoop", type = InstrumentLoop.class, required = false),
			@XmlElementRef(name = "Surface", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "InstrumentComponent", type = InstrumentComponent.class, required = false),
			@XmlElementRef(name = "Equipment", type = Equipment.class, required = false),
			@XmlElementRef(name = "InstrumentationLoopFunction", type = InstrumentationLoopFunction.class, required = false),
			@XmlElementRef(name = "ProcessInstrumentationFunction", type = ProcessInstrumentationFunction.class, required = false),
			@XmlElementRef(name = "ActuatingSystemComponent", type = ActuatingSystemComponent.class, required = false),
			@XmlElementRef(name = "ProcessSignalGeneratingFunction", type = ProcessSignalGeneratingFunction.class, required = false),
			@XmlElementRef(name = "ActuatingSystem", type = ActuatingSystem.class, required = false),
			@XmlElementRef(name = "ActuatingFunction", type = ActuatingFunction.class, required = false),
			@XmlElementRef(name = "ProcessSignalGeneratingSystemComponent", type = ProcessSignalGeneratingSystemComponent.class, required = false),
			@XmlElementRef(name = "ProcessSignalGeneratingSystem", type = ProcessSignalGeneratingSystem.class, required = false),
			@XmlElementRef(name = "ShapeCatalogue", type = ShapeCatalogue.class, required = false),
			@XmlElementRef(name = "Presentation", type = Presentation.class, required = false) })
	public List<Object> presentationOrShapeCatalogueOrDrawing;

	/**
	 * Ruft den Wert der plantInformation-Eigenschaft ab.
	 * 
	 * @return possible object is {@link PlantInformation }
	 * 
	 */
	public PlantInformation getPlantInformation() {
		return this.plantInformation;
	}

	/**
	 * Legt den Wert der plantInformation-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link PlantInformation }
	 * 
	 */
	public void setPlantInformation(PlantInformation value) {
		this.plantInformation = value;
	}

	/**
	 * Gets the value of the rdlService property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the rdlService property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRDLService().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PlantModel.RDLService }
	 * 
	 * 
	 */
	public List<PlantModel.RDLService> getRDLService() {
		if (this.rdlService == null) {
			this.rdlService = new ArrayList<PlantModel.RDLService>();
		}
		return this.rdlService;
	}

	/**
	 * Ruft den Wert der extent-Eigenschaft ab.
	 * 
	 * @return possible object is {@link Extent }
	 * 
	 */
	public Extent getExtent() {
		return this.extent;
	}

	/**
	 * Legt den Wert der extent-Eigenschaft fest.
	 * 
	 * @param value
	 *            allowed object is {@link Extent }
	 * 
	 */
	public void setExtent(Extent value) {
		this.extent = value;
	}

	/**
	 * Gets the value of the presentationOrShapeCatalogueOrDrawing property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the presentationOrShapeCatalogueOrDrawing
	 * property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPresentationOrShapeCatalogueOrDrawing().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link JAXBElement }{@code <}{@link Plane }{@code >}
	 * {@link ProcessInstrument } {@link JAXBElement }{@code <}
	 * {@link CompositeCurve }{@code >} {@link JAXBElement }{@code <}{@link Shape }
	 * {@code >} {@link JAXBElement }{@code <}{@link BsplineSurface }{@code >}
	 * {@link JAXBElement }{@code <}{@link TrimmedCurve }{@code >} {@link Drawing }
	 * {@link PipingNetworkSystem } {@link JAXBElement }{@code <}{@link Circle }
	 * {@code >} {@link SignalConnectorSymbol } {@link Equipment }
	 * {@link PlantArea } {@link JAXBElement }{@code <}{@link Ellipse }{@code >}
	 * {@link Text } {@link JAXBElement }{@code <}{@link CurveBoundedSurface }
	 * {@code >} {@link JAXBElement }{@code <}{@link Surface }{@code >}
	 * {@link JAXBElement }{@code <}{@link Line }{@code >}
	 * {@link InstrumentComponent } {@link Presentation } {@link ShapeCatalogue }
	 * {@link SignalLine } {@link JAXBElement }{@code <}{@link Curve }{@code >}
	 * {@link InstrumentLoop } {@link JAXBElement }{@code <}{@link PolyLine }
	 * {@code >} {@link JAXBElement }{@code <}{@link BsplineCurve }{@code >}
	 * 
	 * 
	 */
	public List<Object> getPresentationOrShapeCatalogueOrDrawing() {
		if (this.presentationOrShapeCatalogueOrDrawing == null) {
			this.presentationOrShapeCatalogueOrDrawing = new ArrayList<Object>();
		}
		return this.presentationOrShapeCatalogueOrDrawing;
	}

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
	 *       &lt;/sequence>
	 *       &lt;attribute name="ServiceAddress" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
	 *       &lt;attribute name="QueryParameter" type="{http://www.w3.org/2001/XMLSchema}string" default="query" />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class RDLService {

		@XmlAttribute(name = "ServiceAddress", required = true)
		@XmlSchemaType(name = "anyURI")
		protected java.lang.String serviceAddress;
		@XmlAttribute(name = "QueryParameter")
		protected java.lang.String queryParameter;

		/**
		 * Ruft den Wert der serviceAddress-Eigenschaft ab.
		 * 
		 * @return possible object is {@link java.lang.String }
		 * 
		 */
		public java.lang.String getServiceAddress() {
			return this.serviceAddress;
		}

		/**
		 * Legt den Wert der serviceAddress-Eigenschaft fest.
		 * 
		 * @param value
		 *            allowed object is {@link java.lang.String }
		 * 
		 */
		public void setServiceAddress(java.lang.String value) {
			this.serviceAddress = value;
		}

		/**
		 * Ruft den Wert der queryParameter-Eigenschaft ab.
		 * 
		 * @return possible object is {@link java.lang.String }
		 * 
		 */
		public java.lang.String getQueryParameter() {
			if (this.queryParameter == null) {
				return "query";
			}
			return this.queryParameter;
		}

		/**
		 * Legt den Wert der queryParameter-Eigenschaft fest.
		 * 
		 * @param value
		 *            allowed object is {@link java.lang.String }
		 * 
		 */
		public void setQueryParameter(java.lang.String value) {
			this.queryParameter = value;
		}

	}

}
