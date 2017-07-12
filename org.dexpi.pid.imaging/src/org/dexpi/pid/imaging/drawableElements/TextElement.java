package org.dexpi.pid.imaging.drawableElements;

import java.awt.Color;

/**
 * The text element. Describes a text with a specific font, height, position.
 * The text can be rotated using textAngle ( in degrees). The extent is the area
 * occupied by the text, described by a rectangle with the minimum and maximum
 * values of x and y as corners. Currently it is not clear arround which point
 * the text will be rotated. ( Whether its the center point or the position)
 * 
 * 
 * @author El Pulpo
 *
 */
public class TextElement extends DrawableElement {

	String string;
	String font;
	double height;
	double extent[];
	double position[];
	double textAngle;

	/**
	 * Creates a text element.
	 * 
	 * @param string
	 *            the string
	 * @param font
	 *            the font
	 * @param height
	 *            the height of the letters
	 * @param color
	 *            the color
	 * @param position
	 *            the position
	 * @param extent
	 *            the extent (minX, maxX, minY, maxY)
	 * @param textAngle
	 *            the angle of the rotated text
	 */
	public TextElement(String string, String font, double height, Color color,
			double position[], double extent[], double textAngle) {
		this.string = string;
		this.font = font;
		this.height = height;
		this.color = color;
		this.position = position;
		this.extent = extent;
		this.textAngle = textAngle;

	}
	/**
	 * Creates a new empty text element.
	 */
	public TextElement() {
		// a precaution??
		this.lineWeight = 1;
	}

	/**
	 * sets the string
	 * 
	 * @param string
	 *            the string
	 */
	public void setString(String string) {
		this.string = string;
	}

	/**
	 * 
	 * @return the string
	 */
	public String getString() {
		return this.string;
	}

	/**
	 * sets the font
	 * 
	 * @param font
	 *            the font
	 */
	public void setFont(String font) {
		this.font = font;
	}

	/**
	 * 
	 * @return the font
	 */
	public String getFont() {
		return this.font;
	}

	/**
	 * sets the height
	 * 
	 * @param height
	 *            the height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * 
	 * @return the height
	 */
	public double getHeight() {
		return this.height;
	}

	/**
	 * sets the text angle
	 * 
	 * @param textAngle
	 *            the text angle (in degrees)
	 */
	public void setTextAngle(double textAngle) {
		this.textAngle = textAngle;
	}

	/**
	 * 
	 * @return the text angle (in degrees)
	 */
	public double getTextAngle() {
		return this.textAngle;
	}

	/**
	 * sets the position
	 * 
	 * @param position
	 *            the position (x,y)
	 */
	public void setPosition(double[] position) {
		this.position = position;
	}

	/**
	 * 
	 * @return the position (x,y)
	 */
	public double[] getPosition() {
		return this.position;
	}

	/**
	 * sets the extent
	 * 
	 * @param extent
	 *            the extent (minX,maxX, minY, maxY)
	 */
	public void setExtent(double[] extent) {
		this.extent = extent;

	}

	/**
	 * 
	 * @return the extent (minX,maxX, minY, maxY)
	 */
	public double[] getExtent() {
		return this.extent;
	}
	
	/**
	 * CopyConstructor for current TextElement
	 * @return Copy of TextElement
	 */
	public TextElement copy(){		
		TextElement ret = new TextElement(this.string, this.font, this.height, this.color,
				this.position.clone(), this.extent.clone(), this.textAngle);
		
		ret.setLineWeight(this.lineWeight);
		return ret;
	}
}