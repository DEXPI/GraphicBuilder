package org.dexpi.pid.imaging.drawableElements;

import java.awt.Color;

/**
 * The line element. Describes a sequence of connected lines defined by arrays of x
 * and y coordinates. Each pair of (x, y) coordinates defines a point. The
 * figure is not closed if the first point differs from the last point.
 * 
 * 
 * @author El Pulpo
 *
 */
public class LineElement extends DrawableElement {

	double xCoordinates[];
	double yCoordinates[];

	/**
	 * Creates a new line element.
	 * 
	 * @param color
	 *            the color
	 * @param lineWeight
	 *            the line weight
	 * @param xCoordinates
	 *            the x coordinates of the points
	 * @param yCoordinates
	 *            the y coordinates of the points
	 */
	public LineElement(Color color, float lineWeight, double[] xCoordinates,
			double[] yCoordinates) {
		this.color = color;
		this.lineWeight = lineWeight;
		this.xCoordinates = xCoordinates;
		this.yCoordinates = yCoordinates;
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
}
