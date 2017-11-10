package org.dexpi.pid.imaging;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.WriteAbortedException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.dexpi.pid.imaging.pidElements.ErrorElement;
import org.dexpi.pid.imaging.pidElements.PidElement;
import org.w3c.dom.Element;

/**
 * The imageFactory creates the image and fills it with geometric shapes. The
 * desired resolution in x direction and the size of the "ProteusXml-Drawing"
 * are converted to a scale factor that sets the size of the ProteusXml-Drawing
 * in relation to the size of the image and transforms the Proteus coordinates
 * to coordinates in pixels.
 * 
 * To allow the addition of ShapeCatalogue objects, which have relative
 * coordinates, setScaleAnglePos() is used. The point zero of the image will be
 * shifted and rotated according to the desired position of the object instead
 * of transforming the relative coordinates of all its geometric objects to
 * absolute coordinates.
 * 
 * For an easier rotation a polar coordinate transformation is used.
 * 
 * 
 * @author El Pulpo
 *
 */

public class ImageFactory_PNG implements GraphicFactory {

	// NOTE: This only works because java matches from left to right and always
	// works on the first match
	// IFF this changes this pattern needs to be refactored with lookaheads and
	// lookbehinds, so it is more general!
	private static Pattern linebreakPattern = Pattern
			.compile("\r\n|\r|\n|&#xD;&#xA;|&#xD;|&#xA;");

	private static final double FONT_SIZE_FACTOR = 1.2;
	private Graphics g;
	private BufferedImage image;

	private double x, x0, y0; // scale factor(drawing), base coordinates(global)
	private float s; // scale factor stroke
	private double scaleX, scaleY; // shapeCatalogue Scale factor
	private double posX, posY; // relative Coordinates for ShapeCatalogue
	private double cosPhi, sinPhi, cosTheta, sinTheta, r; // Polar Coordinate
															// Transformation
															// and Rotation

	private List<ImageMapObject> imageMapObjects = new ArrayList<ImageMapObject>();
	private ArrayList<ErrorElement> listOfErrors = new ArrayList<ErrorElement>();

	/**
	 * Creates a basic image of a desired size and background color.
	 * Additionally the scale factor for coordinate transformation gets
	 * calculated. Once the image is created it can be filled with all kinds of
	 * geometric shapes.
	 * 
	 * @param resolutionX
	 *            the desired resolution in x direction (in pixels)
	 * @param origin
	 *            the point zero specified in the "Proteus" document
	 * @param size
	 *            the size specified in the "Proteus" document
	 * @param backgroundColor
	 *            the backgroundColor
	 */
	@Override
	public void init(int resolutionX, double[] origin, double[] size,
			Color backgroundColor) {

		// calculate offset for x if x < 0;
		double offsetX = 0.;
		offsetX = (-1) * origin[0];

		// scalefactor to scale elements according to resolution
		this.x = resolutionX / (size[0] + offsetX) - (origin[0] + offsetX);

		// scalefactor for lineWeights
		this.s = (float) this.x;

		// set origin of the drawing
		this.x0 = origin[0];

		this.y0 = size[1];

		// calculate resY
		double y = Math.abs(size[1] - origin[1]);
		int resolutionY = (int) (this.x * y);

		this.image = new BufferedImage(resolutionX, resolutionY,
				BufferedImage.TYPE_INT_ARGB);
		this.g = this.image.createGraphics();

		// initialize posX, posY, phi and Theta
		resetScaleAnglePos();

		// create background
		this.g.setColor(backgroundColor);
		this.g.fillRect((int) origin[0], (int) origin[1], resolutionX, resolutionY);
	}
	
	/**
	 * adds a line to the image
	 * 
	 * @param c
	 *            the color
	 * @param lineWeight
	 *            the lineweight
	 * @param xCoordinates
	 *            the x-coordinates of the line
	 * @param yCoordinates
	 *            the y-coordinates of the line
	 */
	@Override
	public void addLine(Color c, float lineWeight, double[] xCoordinates,
			double[] yCoordinates) {

		double cosPhi1;
		double sinPhi1;

		int xIntCoord[] = new int[xCoordinates.length];
		int yIntCoord[] = new int[yCoordinates.length];

		this.g.setColor(c);
		BasicStroke stroke = new BasicStroke(lineWeight * this.s);
		((Graphics2D) this.g).setStroke(stroke);

		// transform to polar coordinates for easier rotation
		for (int i = 0; i < xCoordinates.length; i++) {
			this.r = Math.sqrt(Math.pow(xCoordinates[i], 2)
					+ Math.pow(yCoordinates[i], 2));
			if (this.r == 0) {
				cosPhi1 = 0;
				sinPhi1 = 0;
			} else {
				this.cosTheta = xCoordinates[i] / this.r;
				this.sinTheta = yCoordinates[i] / this.r;
				cosPhi1 = this.cosPhi * this.cosTheta - this.sinPhi * this.sinTheta;
				sinPhi1 = this.sinPhi * this.cosTheta + this.cosPhi * this.sinTheta;
			}
			// transform back to kartesian coordinates
			xIntCoord[i] = (int) ((this.scaleX * this.r * cosPhi1 - this.posX) * this.x);
			yIntCoord[i] = (int) ((this.posY - this.scaleY * this.r * sinPhi1) * this.x);
		}
		
		this.g.drawPolyline(xIntCoord, yIntCoord, xIntCoord.length);

	}

	/**
	 * adds a shape to the image
	 * 
	 * @param c
	 *            the color
	 * @param lineWeight
	 *            the lineweight
	 * @param xCoordinates
	 *            the x-coordinates of the shape
	 * @param yCoordinates
	 *            the y-coordinates of the shape
	 * @param filled
	 *            if filled is set to true the shape will be filled with color
	 */
	@Override
	public void addShape(Color c, float lineWeight, double xCoordinates[],
			double yCoordinates[], boolean filled) {
		
		double cosPhi1;
		double sinPhi1;
		this.g.setColor(c);
		BasicStroke stroke = new BasicStroke(lineWeight * this.s);
		((Graphics2D) this.g).setStroke(stroke);

		int xIntCoord[] = new int[xCoordinates.length];
		int yIntCoord[] = new int[yCoordinates.length];

		for (int i = 0; i < xCoordinates.length; i++) {
			this.r = Math.sqrt(Math.pow(xCoordinates[i], 2)
					+ Math.pow(yCoordinates[i], 2));
			if (this.r == 0) {
				cosPhi1 = 0;
				sinPhi1 = 0;
			} else {
				this.cosTheta = xCoordinates[i] / this.r;
				this.sinTheta = yCoordinates[i] / this.r;
				cosPhi1 = this.cosPhi * this.cosTheta - this.sinPhi * this.sinTheta;
				sinPhi1 = this.sinPhi * this.cosTheta + this.cosPhi * this.sinTheta;
			}
			xIntCoord[i] = (int) ((this.scaleX * this.r * cosPhi1 - this.posX) * this.x);
			yIntCoord[i] = (int) ((this.posY - this.scaleY * this.r * sinPhi1) * this.x);
		}

		if (filled == true) {
			this.g.fillPolygon(xIntCoord, yIntCoord, xIntCoord.length);
		} else {
			this.g.drawPolygon(xIntCoord, yIntCoord, xIntCoord.length);
		}

	}

	/**
	 * 
	 * adds an ellipse to the image
	 * 
	 * @param c
	 *            the color
	 * @param lineWeight
	 *            the lineweight
	 * @param position
	 *            the position
	 * @param primAxis
	 *            the height/primary axis of the ellipse
	 * @param secAxis
	 *            the width/secondary axis of the ellipse
	 * @param startAngle
	 *            the startAngle of the arc
	 * @param endAngle
	 *            the endAngle of the arc
	 * @param filled
	 *            if filled is set to true the ellipse will be filled with color
	 */
	@Override
	public void addEllipse(Color c, float lineWeight, double[] position,
			double primAxis, double secAxis, double startAngle,
			double endAngle, boolean filled) {

		this.g.setColor(c);
		BasicStroke stroke = new BasicStroke(lineWeight * this.s);
		((Graphics2D) this.g).setStroke(stroke);

		int x1 = (int) ((this.scaleX * position[0] - this.posX) * this.x);
		int y1 = (int) ((this.posY - this.scaleY * position[1]) * this.x);
		int height = (int) (primAxis * this.scaleY * this.x);
		int width = (int) (secAxis * this.scaleX * this.x);

		// startAngle = (startAngle + r) % 360;
		// endAngle = (endAngle + r) % 360;

		double arcAngle;
		if (endAngle < startAngle) {
			arcAngle = endAngle + 360 - startAngle;
		} else {
			arcAngle = endAngle - startAngle;
		}

		if (filled != true) {
			this.g.drawArc(x1 - width / 2, y1 - height / 2, width, height,
					(int) (startAngle), (int) (arcAngle));
		} else {
			this.g.fillArc(x1 - width / 2, y1 - height / 2, width, height,
					(int) (startAngle), (int) (arcAngle));
		}

	}

	/**
	 * adds a circle to the image
	 * 
	 * @param c
	 *            the color
	 * @param lineWeight
	 *            the lineweight
	 * @param position
	 *            the position
	 * @param radius
	 *            the radius
	 * @param startAngle
	 *            the startAngle of the arc
	 * @param endAngle
	 *            the endAngle of the arc
	 * @param filled
	 *            if filled is set to true the circle will be filled with color
	 */
	@Override
	public void addCircle(Color c, float lineWeight, double[] position,
			double radius, double startAngle, double endAngle, boolean filled) {

		this.g.setColor(c);
		BasicStroke stroke = new BasicStroke(lineWeight * this.s);
		((Graphics2D) this.g).setStroke(stroke);
		/*
		 * DEPRECATED int x1 = (int) ((scaleX * position[0] - posX) * x); int y1
		 * = (int) ((posY - scaleY * position[1]) * x); int r = (int) (radius *
		 * scaleX * x);
		 */
		double cosPhi1;
		double sinPhi1;

		int x1 = 0;
		int y1 = 0;
		int r = (int) (radius * this.scaleX * this.x);

		// I know it's ugly to use this in this case but it spares a lot of
		// refactoring
		this.r = Math.sqrt(Math.pow(position[0], 2) + Math.pow(position[1], 2));

		if (this.r == 0.) {
			cosPhi1 = 0;
			sinPhi1 = 0;
		} else {
			this.cosTheta = position[0] / this.r;
			this.sinTheta = position[1] / this.r;
			cosPhi1 = this.cosPhi * this.cosTheta - this.sinPhi * this.sinTheta;
			sinPhi1 = this.sinPhi * this.cosTheta + this.cosPhi * this.sinTheta;

			if (this.cosPhi != 1) {
				startAngle += 90;
				endAngle += 90;
			}
		}
		x1 = (int) ((this.scaleX * this.r * cosPhi1 - this.posX) * this.x);
		y1 = (int) ((this.posY - this.scaleY * this.r * sinPhi1) * this.x);

		double arcAngle;
		if (endAngle < startAngle) {
			arcAngle = endAngle + 360 - startAngle;
		} else {
			arcAngle = endAngle - startAngle;
		}

		// NOTE: Remember: r is radius in this case, not rotation!
		if (filled != true) {
			this.g.drawArc(x1 - r, y1 - r, 2 * r, 2 * r, (int) (startAngle),
					(int) (arcAngle));
		} else {
			this.g.fillArc(x1 - r, y1 - r, 2 * r, 2 * r, (int) (startAngle),
					(int) (arcAngle));
		}
	}

	/**
	 * adds text to the image
	 * 
	 * @param c
	 *            the color
	 * @param position
	 *            the position
	 * @param extent
	 *            the extent
	 * @param textAngle
	 *            the angle of the text
	 * @param string
	 *            the string
	 * @param height
	 *            the height of the text
	 * @param Font
	 *            the font
	 */
	@Override
	public void addText(Color c, double[] position, double[] extent,
			double textAngle, String string, double height, String font) {
		/*
		 * check for linebreaks and call this function recursively with
		 * corrected substrings
		 */
		if (string.contains("\r") || string.contains("\n")
				|| string.contains("&#xD;") || string.contains("&#xA;")) {
			String[] subStrings = linebreakPattern.split(string);
			double posYBackup = this.posY;
			for (int i = 0; i < subStrings.length; ++i) {
				System.out.println(subStrings[i]);
				double[] newPos = position.clone();
				addText(c, newPos, extent, textAngle, subStrings[i], height,
						font);
				this.posY += height * 0.8; // 0.8 is a magic constant that is also
										// used in JaxbInputRepository
			}
			this.posY = posYBackup;
			return;
		}

		this.g.setColor(c);

		double minX = 0;
		double minY = 0;
		if (extent == null) {
			extent = new double[4];
			extent[0] = 0;
			extent[2] = 0;
			// error--> extent is missing
		}
		// if text is rotated, lower left corner is reference point
		if (extent[0] <= 0) {
			minX = position[0];
		} else {
			minX = position[0] + height / 1.44 * Math.sin(textAngle);
		}
		if (extent[2] <= 0) {
			minY = position[1];
		} else {

			minY = Math.min(Math.min(extent[2], extent[3]), position[1]);

		}

		int intPos[] = new int[2];
		intPos[0] = (int) ((minX - this.posX) * this.x);
		intPos[1] = (int) ((this.posY - minY) * this.x);

		// set font
		Font textFont = new Font(font, Font.PLAIN, (int) (height
				* FONT_SIZE_FACTOR * this.x));
		this.g.setFont(textFont);

		// set Rotation Point
		int rotPt[] = new int[2];
		rotPt[0] = (int) ((position[0] - this.posX) * this.x);
		rotPt[1] = (int) ((this.posY - position[1]) * this.x);

		// rotating text is not possible, so the drawing will get rotated
		// arround
		// the text element

		// rotate
		((Graphics2D) this.g).rotate(Math.toRadians(-textAngle), rotPt[0], rotPt[1]);

		// draw string
		this.g.drawString(string, intPos[0], intPos[1]);

		// rotate back
		((Graphics2D) this.g).rotate(Math.toRadians(textAngle), rotPt[0], rotPt[1]);

	}

	/**
	 * Shifts and rotates the coordinate system to draw elements from the
	 * shapeCatalogue
	 * 
	 * @param reference
	 *            the reference, rotates the image. The two numbers represent
	 *            the cosinus and sinus of the desired angle.
	 * @param scale
	 *            the scale
	 * @param position
	 *            the position a shapeCatalogue-element should be drawn to
	 */
	@Override
	public void setScaleAnglePos(double[] reference, double[] scale,
			double[] position) {
		// in case a shapeCatalogue reference is used, the position (and angle)
		// for the symbol to be drawn to, is set here
		this.posX = this.x0 - position[0];
		this.posY = this.y0 - position[1];

		this.cosPhi = reference[0];
		this.sinPhi = reference[1];

		// check if Reference is correct (to 3 decimal places)
		if (Math.abs(1 - (this.cosPhi * this.cosPhi + this.sinPhi * this.sinPhi)) > 0.000303) {
			System.out
					.println("Reference is incorrect (X\u00b2+Y\u00b2 should equal 1)");
		}
		this.scaleX = scale[0];
		this.scaleY = scale[1];
	}

	/**
	 * resets scale, angle and position
	 */
	@Override
	public void resetScaleAnglePos() {
		this.scaleX = 1;
		this.scaleY = 1;
		this.cosPhi = 1;
		this.sinPhi = 0;
		this.posX = this.x0;
		this.posY = this.y0;
	}

	/**
	 * 
	 * @return the final image
	 */
	@Override
	public BufferedImage buildImage() {
		return this.image;
	}

	/**
	 * Creates an imageMapElement of a pidElement. The imageMapElement basically
	 * defines the area occupied by the pidElement. This allows to display of
	 * additional information when hovering over this area with the mouse, if
	 * used in a html website.
	 * 
	 * @param pidElement
	 *            the pidElement
	 */
	@Override
	public void addImageMapElement(PidElement pidElement) {

		if (pidElement.getComponentClass() != null) {
			if (pidElement.getExtent() != null && pidElement.getType() == null
					&& pidElement.getComponentClass().contains("Line") == false) {

				double[] extent = pidElement.getExtent();

				String id = pidElement.getID();
				String componentName = pidElement.getComponentName();

				int startX = (int) ((extent[0] - this.x0) * this.x);
				int rangeX = (int) ((extent[1] - extent[0]) * this.x);
				int startY = (int) ((this.y0 - extent[3]) * this.x);
				int rangeY = (int) ((extent[3] - extent[2]) * this.x);

				this.imageMapObjects
						.add(new ImageMapObject(startX, startY,
								(startX + rangeX), (startY + rangeY), id,
								componentName));
			} else if (pidElement.getType() != null
					|| pidElement.getComponentClass().contains("Line") == true) {
				//TODO somehow this is not required?
			}
		}

	}

	/**
	 * All imageMapObjects created are added to a list and can be returned if
	 * desired.
	 * 
	 * @return a list of all imageMapObjects created
	 */
	@Override
	public List<ImageMapObject> getImageMapObjects() {
		return this.imageMapObjects;
	}

	@Override
	public ArrayList<ErrorElement> getErrorList() {
		return this.listOfErrors;
	}
	
	/**
	 * Currently not implemented for PNG
	 * @param destination
	 * @return
	 */
	@Override
	public boolean writeToDestination(String destination) {
		//TODO currently not implemented
		
		return false;
	}
}
