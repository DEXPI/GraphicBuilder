package org.dexpi.pid.imaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.dexpi.pid.imaging.pidElements.LocatorElement;

/**
 * 
 * Locates a specific xml element and gets its linenumber.
 * 
 * 
 * @author phbe01
 *
 */
public class Locator {

	private ArrayList<LocatorElement> listOfLocations;

	public Locator() {
		this.listOfLocations = new ArrayList<LocatorElement>();
	}

	/**
	 * adds an element to the list of locations
	 * 
	 * @param type
	 *            the type of the element (e.g. Equipment or
	 *            PipingNetworkSystem)
	 * @param id
	 *            the id of the element specified in the proteus document
	 * @param lineNumber
	 *            the line number
	 */
	public void addElement(String type, String id, int lineNumber) {
		this.listOfLocations.add(new LocatorElement(type, id, lineNumber));
	}

	/**
	 * sorts the list by line number in ascending order
	 */
	public void sortList() {
		Collections.sort(this.listOfLocations, new Comparator<LocatorElement>() {
			@Override
			public int compare(LocatorElement le1, LocatorElement le2) {

				return le1.lineNumber - le2.lineNumber;
			}
		});

	}

	/**
	 * returns the line number of an element identified via the id
	 * 
	 * @param id
	 *            the id
	 * @return the line number
	 */
	public int getLineNumber(String id) {
		int lineNumber = 0;
		for (LocatorElement le : this.listOfLocations) {
			if (le.getID().equals(id)) {
				lineNumber = le.getLineNumber();
			}
		}
		return lineNumber;
	}

	/**
	 * returns the line number of an element identified by the nth occurence of
	 * a certain type beginning at the parentLineNumber, should be used if the
	 * element can't be identified by ID
	 * 
	 * @param parentLineNumber
	 *            the line number where the search will be started
	 * @param nElement
	 *            the nth occurence
	 * @param type
	 *            the type of the element (e.g. Line or Circle)
	 * @return the line number
	 */
	public int getLineNumber(int parentLineNumber, int nElement, String type) {
		int lineNumber = 0;

		ArrayList<Integer> lineNumbers = new ArrayList<Integer>();
		String altType = "";
		if (type.equals("Line")) {
			altType = "PolyLine";
		}

		for (LocatorElement le : this.listOfLocations) {

			if (le.getLineNumber() > parentLineNumber
					&& le.getType().equals(type)
					|| le.getType().equals(altType)) {

				lineNumbers.add(le.getLineNumber());
			}
		}

		Collections.sort(lineNumbers);

		lineNumber = lineNumbers.get((nElement - 1));
		return lineNumber;
	}

	/**
	 * returns the line number of an element identified by its type
	 * 
	 * @param type
	 *            the type of the element (e.q. CenterLine or Equipment)
	 * @return the line number
	 */
	public int getLineNumberByType(String type) {

		int lineNumber = 0;
		for (LocatorElement le : this.listOfLocations) {

			if (le.getType().equals(type)) {
				lineNumber = le.getLineNumber();
			}
		}
		return lineNumber;
	}

	/**
	 * returns the line number of an element that is supposed to have an id (in
	 * the case its missing)
	 * 
	 * @param type
	 *            the type of the element (e.g. PipingNetworkSystem)
	 * @return the line number
	 */
	public int getLineNumberByMissingID(String type) {
		int lineNumber = 0;

		for (LocatorElement le : this.listOfLocations) {
			if (le.getType().equals(type) && le.getID() == "") {
				lineNumber = le.getLineNumber();
				le.setID("Missing");
				break;
			}
		}
		return lineNumber;
	}
}
