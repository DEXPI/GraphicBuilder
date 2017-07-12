package org.dexpi.pid.imaging.drawableElements;

import java.awt.Color;

/**
 * The ellipse element. Describes the outline of a elliptical arc. The resulting
 * arc begins at startAngle and ends at endAngle degrees, using the current
 * color. Angles are interpreted such that 0 degrees is at the 3 o'clock
 * position and the angle increases counter-clockwise. While similar to the
 * circle, instead of the radius two axis are specified. The primary axis
 * describes the height, the secondary the width of the ellipse.
 * 
 * 
 * 
 * @author El Pulpo
 *
 */
public class EllipseElement extends DrawableElement {
	double position[];
	boolean filled;
	double primAxis; // height
	double secAxis; // width
	double startAngle;
	double endAngle;
	
	/**
	 * Creates a new ellipse element. To draw only a portion of the ellipse, use
	 * start and end angle. The angle is measured counter clockwise, starting at
	 * 3 o'clock.
	 * 
	 * @param color
	 *            the color
	 * @param lineWeight
	 *            the line weight
	 * @param position
	 *            the position of the midpoint
	 * @param primAxis
	 *            the primary axis (height of the ellipse)
	 * @param secAxis
	 *            the secondary axis (width of the ellipse)
	 * @param startAngle
	 *            the start angle (in degrees)
	 * @param endAngle
	 *            the end angle (in degrees)
	 * @param filled
	 *            filled?
	 */
	public EllipseElement(Color color, float lineWeight, double[] position,
			double primAxis, double secAxis, double startAngle,
			double endAngle, boolean filled) {
		this.color = color;
		this.lineWeight = lineWeight;
		this.position = position;
		this.primAxis = primAxis;
		this.secAxis = secAxis;
		this.startAngle = startAngle;
		this.endAngle = endAngle;
		this.filled = filled;
	}

	/**
	 * 
	 * @return the primary axis (height)
	 */
	public double getPrimaryAxis() {
		return this.primAxis;
	}

	/**
	 * 
	 * @return the secondary axis (width)
	 */
	public double getSecondaryAxis() {
		return this.secAxis;
	}

	/**
	 * 
	 * @return the position (x,y)
	 */
	public double[] getPosition() {
		return this.position;
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

	/**
	 * 
	 * @return filled
	 */
	public boolean getFilled() {
		return this.filled;
	}
}
