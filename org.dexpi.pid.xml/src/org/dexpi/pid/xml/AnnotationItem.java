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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Defines aspects common to all Annotation items
 * 
 * <p>Java-Klasse für AnnotationItem complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AnnotationItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}Presentation"/>
 *         &lt;element ref="{}Extent"/>
 *         &lt;element ref="{}PersistentID"/>
 *         &lt;element ref="{}Position"/>
 *         &lt;element ref="{}Scale"/>
 *         &lt;element ref="{}Curve"/>
 *         &lt;element ref="{}Symbol" maxOccurs="unbounded"/>
 *         &lt;element ref="{}ConnectionPoints"/>
 *         &lt;element ref="{}Text"/>
 *         &lt;element ref="{}Description"/>
 *         &lt;element ref="{}GenericAttributes"/>
 *         &lt;element ref="{}History"/>
 *         &lt;element ref="{}Association"/>
 *       &lt;/choice>
 *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="ComponentClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ComponentClassURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="ComponentName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ComponentType">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Normal"/>
 *             &lt;enumeration value="Explicit"/>
 *             &lt;enumeration value="Parametric"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Revision" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RevisionURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Status">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Current"/>
 *             &lt;enumeration value="Deleted"/>
 *             &lt;enumeration value="Modified"/>
 *             &lt;enumeration value="New"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="StatusURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnnotationItem", propOrder = {
    "presentationOrExtentOrPersistentID"
})
@XmlSeeAlso({
    PipeSlopeSymbol.class,
    ScopeBubble.class,
    InsulationSymbol.class,
    SignalConnectorSymbol.class,
    PipeConnectorSymbol.class,
    Label.class,
    PropertyBreak.class,
    PipeFlowArrow.class,
    Symbol.class
})
public class AnnotationItem extends GeneratedClass{

    @XmlElementRefs({
        @XmlElementRef(name = "Text", type = Text.class, required = false),
        @XmlElementRef(name = "Symbol", type = Symbol.class, required = false),
        @XmlElementRef(name = "GenericAttributes", type = GenericAttributes.class, required = false),
        @XmlElementRef(name = "Presentation", type = Presentation.class, required = false),
        @XmlElementRef(name = "History", type = History.class, required = false),
        @XmlElementRef(name = "Position", type = Position.class, required = false),
        @XmlElementRef(name = "ConnectionPoints", type = ConnectionPoints.class, required = false),
        @XmlElementRef(name = "Description", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Curve", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Extent", type = Extent.class, required = false),
        @XmlElementRef(name = "Association", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PersistentID", type = PersistentID.class, required = false),
        //@XmlElementRef(name = "PersistentID", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Scale", type = Scale.class, required = false)
    })
    protected List<Object> presentationOrExtentOrPersistentID;
    @XmlAttribute(name = "ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;
    @XmlAttribute(name = "ComponentClass")
    protected java.lang.String componentClass;
    @XmlAttribute(name = "ComponentClassURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String componentClassURI;
    @XmlAttribute(name = "ComponentName")
    protected java.lang.String componentName;
    @XmlAttribute(name = "ComponentType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String componentType;
    @XmlAttribute(name = "Revision")
    protected java.lang.String revision;
    @XmlAttribute(name = "RevisionURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String revisionURI;
    @XmlAttribute(name = "Status")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String status;
    @XmlAttribute(name = "StatusURI")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String statusURI;

    /**
     * Gets the value of the presentationOrExtentOrPersistentID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presentationOrExtentOrPersistentID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPresentationOrExtentOrPersistentID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Ellipse }{@code >}
     * {@link Text }
     * {@link JAXBElement }{@code <}{@link Line }{@code >}
     * {@link JAXBElement }{@code <}{@link Shape }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeCurve }{@code >}
     * {@link Symbol }
     * {@link JAXBElement }{@code <}{@link TrimmedCurve }{@code >}
     * {@link GenericAttributes }
     * {@link Presentation }
     * {@link History }
     * {@link Position }
     * {@link ConnectionPoints }
     * {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * {@link JAXBElement }{@code <}{@link Curve }{@code >}
     * {@link JAXBElement }{@code <}{@link Circle }{@code >}
     * {@link Extent }
     * {@link JAXBElement }{@code <}{@link PolyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link BsplineCurve }{@code >}
     * {@link JAXBElement }{@code <}{@link PersistentID }{@code >}
     * {@link JAXBElement }{@code <}{@link Association }{@code >}
     * {@link Scale }
     * 
     * 
     */
    public List<Object> getPresentationOrExtentOrPersistentID() {
        if (this.presentationOrExtentOrPersistentID == null) {
            this.presentationOrExtentOrPersistentID = new ArrayList<Object>();
        }
        return this.presentationOrExtentOrPersistentID;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getID() {
        return this.id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setID(java.lang.String value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der componentClass-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getComponentClass() {
        return this.componentClass;
    }

    /**
     * Legt den Wert der componentClass-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setComponentClass(java.lang.String value) {
        this.componentClass = value;
    }

    /**
     * Ruft den Wert der componentClassURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getComponentClassURI() {
        return this.componentClassURI;
    }

    /**
     * Legt den Wert der componentClassURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setComponentClassURI(java.lang.String value) {
        this.componentClassURI = value;
    }

    /**
     * Ruft den Wert der componentName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getComponentName() {
        return this.componentName;
    }

    /**
     * Legt den Wert der componentName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setComponentName(java.lang.String value) {
        this.componentName = value;
    }

    /**
     * Ruft den Wert der componentType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getComponentType() {
        return this.componentType;
    }

    /**
     * Legt den Wert der componentType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setComponentType(java.lang.String value) {
        this.componentType = value;
    }

    /**
     * Ruft den Wert der revision-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRevision() {
        return this.revision;
    }

    /**
     * Legt den Wert der revision-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRevision(java.lang.String value) {
        this.revision = value;
    }

    /**
     * Ruft den Wert der revisionURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRevisionURI() {
        return this.revisionURI;
    }

    /**
     * Legt den Wert der revisionURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRevisionURI(java.lang.String value) {
        this.revisionURI = value;
    }

    /**
     * Ruft den Wert der status-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getStatus() {
        return this.status;
    }

    /**
     * Legt den Wert der status-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setStatus(java.lang.String value) {
        this.status = value;
    }

    /**
     * Ruft den Wert der statusURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getStatusURI() {
        return this.statusURI;
    }

    /**
     * Legt den Wert der statusURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setStatusURI(java.lang.String value) {
        this.statusURI = value;
    }

}
