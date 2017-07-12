package org.dexpi.pid.errorLog.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//Below annotation defines root element of XML file
@XmlRootElement(name = "ErrorLog")
public class ErrorLog {

	private String correspondingFile;
	private ArrayList<Error> listOfErrors;

	public ErrorLog() {

	}

	public ErrorLog(String value) {
		super();
		this.correspondingFile = value;
	}

	@XmlAttribute(name = "CorrespondingFile")
	public java.lang.String getFileName() {
		return this.correspondingFile;
	}

	public void setFileName(java.lang.String correspondingFile) {
		this.correspondingFile = correspondingFile;
	}

	public ArrayList<Error> getListOfErrors() {
		return this.listOfErrors;
	}

	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "ErrorList")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "Error")
	public void setListOfErrors(ArrayList<Error> listOfErrors) {
		this.listOfErrors = listOfErrors;
	}
}
