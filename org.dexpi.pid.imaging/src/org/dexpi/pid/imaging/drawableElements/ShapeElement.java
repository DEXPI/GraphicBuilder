package org.dexpi.pid.imaging.drawableElements;

import java.awt.Color;

/**
 * The shape element. Describes a closed polygon defined by arrays of x and y
 * coordinates. Each pair of (x, y) coordinates defines a point. The polygon is
 * defined by a sequence of line segments, connecting the points. The figure is
 * automatically closed by a line connecting the final point to the first point,
 * if those points are different.
 * 
 * 
 * 
 * @author El Pulpo
 *
 */
public class ShapeElement extends DrawableElement {

	double xCoordinates[];
	double yCoordinates[];
	boolean filled;

	/**
	 * Creates a shape element.
	 * 
	 * @param color
	 *            the color
	 * @param lineWeight
	 *            the line weight
	 * @param xCoordinates
	 *            the x coordinates of the points
	 * @param yCoordinates
	 *            the y coordinates of the points
	 * @param filled
	 *            filled
	 */
	public ShapeElement(Color color, float lineWeight, double[] xCoordinates,
			double[] yCoordinates, boolean filled) {
		this.color = color;
		this.lineWeight = lineWeight;
		this.xCoordinates = xCoordinates;
		this.yCoordinates = yCoordinates;
		this.filled = filled;
	}

	/**
	 * 
	 * @return the x coordinates
	 */
	public double[] getXCoordinates() {
		return this.xCoordinates;
	}

	/**
	 *
	 * @return the y coordinates
	 */
	public double[] getYCoordinates() {
		return this.yCoordinates;
	}

	/**
	 * 
	 * @return filled
	 */
	public boolean getFilled() {
		return this.filled;
	}

}
