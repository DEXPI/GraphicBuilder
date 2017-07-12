package org.dexpi.pid.imaging.drawableElements;

import java.awt.Color;

/**
 * A simple geometric element, that can be drawn by the GraphicFactory.
 * 
 * @author El Pulpo
 *
 */
public class DrawableElement {

	int lineNumber;
	float lineWeight;
	Color color;

	/**
	 * sets the color
	 * 
	 * @param color
	 *            the color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * 
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * sets the line weight
	 * 
	 * @param lineWeight
	 *            the line weight
	 */
	public void setLineWeight(float lineWeight) {
		this.lineWeight = lineWeight;
	}

	/**
	 * 
	 * @return the line weight
	 */
	public float getLineWeight() {
		return this.lineWeight;
	}

	/**
	 * sets the line number
	 * 
	 * @param lineNumber
	 *            the line number
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * 
	 * @return the line number
	 */
	public int getLineNumber() {
		return this.lineNumber;
	}
}
