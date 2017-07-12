package org.dexpi.pid.imaging.pidElements;

import java.util.ArrayList;

/**
 * An element that allows to depict an error. ID, componentName, compoentClass
 * are specified by the ProteusXML 3.6.0 Schema. The subDescription allows to
 * add further details about the error. Example for output in xml:
 * &lt;Error&gt;
            &lt;ID&gt;1234&lt;/ID&gt;
            &lt;ComponentName&gt;ISO Ball Valve&lt;/ComponentName&gt;
            &lt;ComponentClass&gt;BallValve&lt;/ComponentClass&gt;
            &lt;LineNumber&gt;827&lt;/LineNumber&gt;
            &lt;DetailedDescription&gt;
                &lt;Error Message="Line #828 - Cannot draw circle: color,line weight missing or incorrect."/&gt;
                &lt;Error Message="Line #839 - Cannot draw line: color,line weight missing or incorrect."/&gt;
                &lt;Error Message="Line #847 - Cannot draw line: color,line weight missing or incorrect."/&gt;
                &lt;Error Message="Line #855 - Cannot draw line: color,line weight missing or incorrect."/&gt;
                &lt;Error Message="Line #863 - Cannot draw line: color,line weight missing or incorrect."/&gt;
                &lt;Error Message="Line #871 - Cannot draw line: color,line weight missing or incorrect."/&gt;
                &lt;Error Message="Line #879 - Cannot draw line: color,line weight missing or incorrect."/&gt;
            &lt;/DetailedDescription&gt;
        &lt;/Error&gt;
 * 
 * 
 * 
 * 
 * 
 * @author El Pulpo
 *
 */
public class ErrorElement {

	String id;
	String componentName;
	String componentClass;
	String lineNumber;
	String description;
	ArrayList<String> subDescription;

	/**
	 * Creates a new error element.
	 * 
	 * @param id
	 *            the id
	 * 
	 */
	public ErrorElement(String id) {
		this.subDescription = new ArrayList<String>();
		this.id = id;
	}

	/**
	 * Creates a new error element.
	 * 
	 * @param id
	 *            the id
	 * @param componentName
	 *            the componentName
	 * @param componentClass
	 *            the componentClass
	 */
	public ErrorElement(String id, String componentName, String componentClass) {
		this.subDescription = new ArrayList<String>();
		this.id = id;
		this.componentName = componentName;
		this.componentClass = componentClass;
	}

	/**
	 * Creates a new error element.
	 * 
	 * @param id
	 *            the id
	 * @param componentName
	 *            the componentName
	 * @param componentClass
	 *            the componentClass
	 * @param lineNumber
	 *            the line number ( in the xmlFile)
	 */
	public ErrorElement(String id, String componentName, String componentClass,
			int lineNumber) {
		this.subDescription = new ArrayList<String>();
		this.id = id;
		this.componentName = componentName;
		this.componentClass = componentClass;
		this.lineNumber = "" + lineNumber;
	}

	/**
	 * 
	 * @return the id
	 */
	public String getID() {
		return this.id;
	}

	/**
	 * sets the componentName
	 * 
	 * @param componentName
	 *            the componentName
	 */
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	/**
	 * 
	 * @return the componentName
	 */
	public String getComponentName() {
		return this.componentName;
	}

	/**
	 * sets the componentClass
	 * 
	 * @param componentClass
	 *            the componentClass
	 */
	public void setComponentClass(String componentClass) {
		this.componentClass = componentClass;
	}

	/**
	 * 
	 * @return the componentClass
	 */
	public String getComponentClass() {
		return this.componentClass;
	}

	/**
	 * 
	 * @return the lineNumber
	 */
	public String getLineNumber() {
		return this.lineNumber;
	}

	/**
	 * sets the description
	 * 
	 * @param description
	 *            the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * sets the subDescription
	 * 
	 * @param subDescription
	 *            the subDescription
	 */
	public void setSubDescription(ArrayList<String> subDescription) {
		this.subDescription = subDescription;
	}

	/**
	 * 
	 * @return the subDescroption
	 */
	public ArrayList<String> getSubDescriptions() {
		return this.subDescription;
	}

	/**
	 * Adds a subDescription. In case there are no subDescriptions yet, the
	 * ArrayList will be created and the subDescription will be added.
	 * 
	 * @param subDescription
	 *            the subDescriptions
	 */
	public void addSubDescriptions(ArrayList<String> subDescription) {
		if (this.subDescription == null) {
			this.subDescription = subDescription;
		} else {
			for (int i = 0; i < subDescription.size(); i++) {
				this.subDescription.add(subDescription.get(i));
			}
		}
	}

}