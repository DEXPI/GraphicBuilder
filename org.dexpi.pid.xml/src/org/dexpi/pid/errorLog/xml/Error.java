package org.dexpi.pid.errorLog.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Below annotation defines root element of XML file
@XmlRootElement(namespace = "org.dexpi.pid.errorLog.xml.ErrorLog")
// You can define order in which elements will be created in XML file
// Optional
@XmlType(propOrder = { "ID", "componentName", "componentClass", "lineNumber",
		"errorDescription", "listOfDescriptions" })
public class Error {

	private String id;
	private String componentName;
	private String componentClass;
	private String lineNumber;
	private String errorDescription;

	private String subDescription;

	private ArrayList<Error> listOfDescriptions;

	public Error() {
	}

	public Error(String subDescription) {
		super();
		this.subDescription = subDescription;
	}
	

	public Error(String id, String componentName, String componentClass,
			String lineNumber, String errorDescription) {
		super();
		this.id = id;
		this.lineNumber = lineNumber;
		this.errorDescription = errorDescription;
		this.componentName = componentName;
		this.componentClass = componentClass;
	}

	@XmlAttribute(name = "Message")
	public java.lang.String getFileName() {
		return this.subDescription;
	}

	public String getID() {
		return this.id;
	}

	@XmlElement(name = "ID")
	public void setID(String id) {
		this.id = id;
	}

	public String getComponentName() {
		return this.componentName;
	}

	@XmlElement(name = "ComponentName")
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentClass() {
		return this.componentClass;
	}

	@XmlElement(name = "ComponentClass")
	public void setComponentClass(String componentClass) {
		this.componentClass = componentClass;
	}

	public String getLineNumber() {
		return this.lineNumber;
	}

	@XmlElement(name = "LineNumber")
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getErrorDescription() {
		return this.errorDescription;
	}

	@XmlElement(name = "ErrorDescription")
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public ArrayList<Error> getListOfDescriptions() {
		return this.listOfDescriptions;
	}

	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "DetailedDescription")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "Error")
	public void setListOfDescriptions(ArrayList<Error> listOfDescriptions) {
		this.listOfDescriptions = listOfDescriptions;
	}

}
