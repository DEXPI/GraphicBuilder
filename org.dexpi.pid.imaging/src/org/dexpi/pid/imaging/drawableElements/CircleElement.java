package org.dexpi.pid.imaging.drawableElements;

import java.awt.Color;

/**
 * The circle element. Describes the outline of a circular arc. The resulting
 * arc begins at startAngle and ends at endAngle degrees, using the color.
 * Angles are interpreted such that 0 degrees is at the 3 o'clock position and
 * the angle increases counter-clockwise.
 * 
 * 
 * 
 * @author El Pulpo
 *
 */
public class CircleElement extends DrawableElement {
	double position[];
	double radius;
	boolean filled;
	double startAngle;
	double endAngle;

	/**
	 * Creates a new circle element. If only a portion of the circle should be
	 * drawn, use start angle and end angle. The angle is measured counter
	 * clockwise, starting at 3 o'clock.
	 * 
	 * @param color
	 *            the color
	 * @param lineWeight
	 *            the line weight
	 * @param position
	 *            the position of the midpoint
	 * @param radius
	 *            the radius
	 * @param startAngle
	 *            the start angle ( in degrees)
	 * @param endAngle
	 *            the end angle (in degrees)
	 * @param filled
	 *            filled
	 */
	public CircleElement(Color color, float lineWeight, double[] position,
			double radius, double startAngle, double endAngle, boolean filled) {
		this.color = color;
		this.lineWeight = lineWeight;
		this.position = position;
		this.radius = radius;
		this.startAngle = startAngle;
		this.endAngle = endAngle;
		this.filled = filled;
	}

	/**
	 * 
	 * @return the position
	 */
	public double[] getPosition() {
		return this.position;
	}

	/**
	 * 
	 * @return the radius
	 */
	public double getRadius() {
		return this.radius;
	}

	/**
	 * 
	 * @return the start angle
	 */
	public double getStartAngle() {
		return this.startAngle;
	}

	/**
	 * 
	 * @return the end angle
	 */
	public double getEndAngle() {
		return this.endAngle;
	}

	public boolean getFilled() {
		return this.filled;
	}

}
