package org.dexpi.pid.imaging.pidElements;
/**
 * 
 * @author El Pulpo
 *
 */
public class LocatorElement{ //implements Comparable<LocatorElement>{

	public String type;
	public String id;
	public int lineNumber;

	public LocatorElement(String type, String id, int lineNumber) {
		this.type = type;
		this.id = id;
		this.lineNumber = lineNumber;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getID() {
		return this.id;
	}

	public int getLineNumber() {
		return this.lineNumber;
	}

	public String getType() {
		return this.type;
	}

}
