package org.dexpi.pid.imaging.pidElements;

import java.util.ArrayList;

import org.dexpi.pid.imaging.drawableElements.DrawableElement;

/**
 * This class can be used to represent objects in the PI&#38;D. The graphic
 * representation should be added as drawableElements. If the graphic
 * representation is stored in the ShapeCatalogue, scRef should be set to true.
 * This ensures that, while drawing, the GraphicBuilder looks for the
 * corresponding representation in the ShapeCatalogue.
 * 
 * The extent (minX, maxX, minY, maxY) is the area occupied by the text,
 * described by a rectangle with the minimum and maximum values of x and y as
 * corners. The reference (cosPhi, sinPhi) can be used to describe a rotation.
 * The two numbers represent the cosinus and sinus of the desired angle.
 * 
 * 
 * 
 * For further information please refer to the ProteusXML 3.6.0 specification.
 * 
 * @author El Pulpo
 *
 */
public class PidElement {
	String id;
	String componentName;
	String componentClass;
	String tagName;
	String type;
	int lineNumber;
	boolean scRef;
	double[] reference;
	double[] scale;
	double[] position;
	double[] extent;
	double[] oldExtent;

	ArrayList<DrawableElement> drawableElements;
	ArrayList<PidElement> subElements;

	/**
	 * Creates a new pidElement.
	 * 
	 * @param id
	 *            the id
	 * @param componentName
	 *            the componentName
	 * @param componentClass
	 *            the componentClass
	 */
	public PidElement(String id, String tagName, String componentName, String componentClass) {
		this.id = id;
		this.tagName = tagName;
		this.componentName = componentName;
		this.componentClass = componentClass;
	}

	/**
	 * Creates a new pidElement.
	 * 
	 * @param id
	 *            the id
	 * @param componentName
	 *            the componentName
	 * @param componentClass
	 *            the componentClass
	 * @param type
	 *            the type, as shown in the xml file. For example &lt;equipment&gt;
	 *            or &lt;component&gt; etc.
	 */
	public PidElement(String id, String tagName, String componentName, String componentClass, String type) {
		this.id = id;
		this.tagName = tagName;
		this.componentName = componentName;
		this.componentClass = componentClass;
		this.type = type;
		// System.out.println("TY: " + this.type);
		init();
	}

	/**
	 * sets the lineNumber
	 * 
	 * @param lineNumber
	 *            the lineNumber
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * 
	 * @return the lineNumber
	 */
	public int getLineNumber() {
		return this.lineNumber;
	}

	/**
	 * Creates the necessary ArrayLists and sets defaultScale and defaultReference.
	 */
	public void init() {
		this.drawableElements = new ArrayList<DrawableElement>();
		this.subElements = new ArrayList<PidElement>();

		double[] defaultScale = { 1, 1, 1 };
		this.scale = defaultScale;

		double[] defaultReference = { 1, 0 };
		this.reference = defaultReference;

		this.scRef = false;
	}

	/**
	 * Adds drawableElements to the pidElement.
	 * 
	 * @param drawableElements
	 *            the list of drawableElements
	 */
	public void addDrawableElements(ArrayList<DrawableElement> drawableElements) {
		if (this.drawableElements == null) {
			this.drawableElements = drawableElements;
		} else {
			for (int i = 0; i < drawableElements.size(); i++) {
				this.drawableElements.add(drawableElements.get(i));
			}
		}
	}

	/**
	 * Adds a drawableElement to the pidElement.
	 * 
	 * @param drawableElement
	 *            the drawableElement
	 */
	public void addDrawableElement(DrawableElement drawableElement) {
		if (this.drawableElements == null) {
			this.drawableElements = new ArrayList<DrawableElement>();
		}

		this.drawableElements.add(drawableElement);
	}

	/**
	 * Adds subElements to the pidElement.
	 * 
	 * @param subElements
	 *            the list of subElements
	 */
	public void addSubElements(ArrayList<PidElement> subElements) {
		if (this.subElements == null) {
			this.subElements = subElements;
		} else {
			for (int i = 0; i < subElements.size(); i++) {
				this.subElements.add(subElements.get(i));
			}
		}
	}

	/**
	 * Adds a subElement to the pidElement.
	 * 
	 * @param subElement
	 *            the subElement
	 */
	public void addSubElement(PidElement subElement) {
		if (this.subElements == null) {
			this.subElements = new ArrayList<PidElement>();
		} else {
			this.subElements.add(subElement);
		}
	}

	/**
	 * Returns all subElements.
	 * 
	 * @return the subElements
	 */
	public ArrayList<PidElement> getSubElements() {
		return this.subElements;
	}

	/**
	 * Returns all drawableElements.
	 * 
	 * @return the drawableElements
	 */
	public ArrayList<DrawableElement> getDrawableElements() {
		return this.drawableElements;
	}

	/**
	 * Sets the extent.
	 * 
	 * @param extent
	 *            the extent
	 */
	public void setExtent(double[] extent) {
		this.extent = extent;
	}

	/**
	 * 
	 * @return the extent
	 */
	public double[] getExtent() {
		return this.extent;
	}

	/**
	 * 
	 * @return the id
	 */
	public String getID() {
		return this.id;
	}

	/**
	 * 
	 * @return the componentName
	 */
	public String getComponentName() {
		return this.componentName;
	}

	/**
	 * 
	 * @return the componentClass
	 */
	public String getComponentClass() {
		return this.componentClass;
	}

	/**
	 * sets the scale
	 * 
	 * @param scale
	 *            the scale(x,y,z)
	 */
	public void setScale(double[] scale) {
		this.scale = scale;
	}

	/**
	 * 
	 * @return the scale
	 */
	public double[] getScale() {
		return this.scale;
	}

	/**
	 * sets the reference
	 * 
	 * @param ref
	 *            the reference
	 */
	public void setReference(double[] ref) {
		this.reference = ref;
	}

	/**
	 * 
	 * @return the reference
	 */
	public double[] getReference() {
		return this.reference;
	}

	/**
	 * sets the position
	 * 
	 * @param pos
	 *            the position (x,y)
	 */
	public void setPosition(double[] pos) {
		this.position = pos;
	}

	/**
	 * 
	 * @return the position
	 */
	public double[] getPosition() {
		return this.position;
	}

	/**
	 * If a pidElement has a reference to the shapeCatalogue, scRef should be set to
	 * true.
	 * 
	 * @param scRef
	 *            the shapeCatalogueReference
	 */
	public void setScRef(boolean scRef) {
		this.scRef = scRef;
	}

	/**
	 * 
	 * @return the shapeCatalogueReference
	 */
	public boolean getScRef() {
		return this.scRef;
	}

	/**
	 * 
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * sets the type
	 * 
	 * @param type
	 *            the type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * sets the id
	 * 
	 * @param id
	 *            the id
	 */
	public void setID(String id) {
		this.id = id;

	}

	/**
	 * 
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * sets the tagName
	 * 
	 * @param tagName
	 *            the tagName
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * 
	 * @return the initially parsed extent
	 */
	public double[] getOldExtent() {
		return oldExtent;
	}

	/**
	 * sets the extent while parsing to this (so it can be used for the
	 * imageMapCalculation
	 * 
	 * @param oldExtent
	 *            the oldExtent, which was initially parsed for this object
	 */
	public void setOldExtent(double[] oldExtent) {
		this.oldExtent = oldExtent;
	}

}
