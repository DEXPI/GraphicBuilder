package org.dexpi.pid.imaging;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.XMLAbstractTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.dexpi.pid.imaging.pidElements.ErrorElement;
import org.dexpi.pid.imaging.pidElements.PidElement;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import SVGElements.Coordinate;

/**
 * NOTE: This description is directly copied from the ImageFactory_PNG, hence
 * this ImageFactory may work a bit different
 *
 * 
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
 * @author MaHe
 *
 */

public class ImageFactory_SVG implements GraphicFactory {

	// NOTE: This only works because java matches from left to right and always
	// works on the first match
	// IFF this changes this pattern needs to be refactored with lookaheads and
	// lookbehinds, so it is more general!
	private static Pattern linebreakPattern = Pattern.compile("\r\n|\r|\n|&#xD;&#xA;|&#xD;|&#xA;");

	private static final double FONT_SIZE_FACTOR = 1.2;

	private DOMImplementation impl;
	private String svgNS, dexpiNS, dexpiPrefix;
	private Document doc;
	private Element svgRoot;

	private double x, x0, y0; // scale factor(drawing), base coordinates(global)
	private float s; // scale factor stroke
	private double scaleX, scaleY; // shapeCatalogue Scale factor
	private double posX, posY; // relative Coordinates for ShapeCatalogue
	private double cosPhi, sinPhi, cosTheta, sinTheta, r; // Polar Coordinate
															// Transformation
															// and Rotation

	private String groupNodeTagName;
	private String groupNodeComponentClass;
	private Element groupNode;
	
	private List<ImageMapObject> imageMapObjects = new ArrayList<ImageMapObject>();
	private ArrayList<ErrorElement> listOfErrors = new ArrayList<ErrorElement>();

	private int resolutionX;
	private int resolutionY;

	/**
	 * Creates a basic image of a desired size and background color. Additionally
	 * the scale factor for coordinate transformation gets calculated. Once the
	 * image is created it can be filled with all kinds of geometric shapes.
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
	public void init(int resolutionX, double[] origin, double[] size, Color backgroundColor) {

		this.groupNodeTagName = null;
		this.groupNodeComponentClass = null;
		this.groupNode = null;
		
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

		this.impl = SVGDOMImplementation.getDOMImplementation();
		this.svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		this.doc = impl.createDocument(svgNS, "svg", null);

		// initialize posX, posY, phi and Theta
		resetScaleAnglePos();

		// Create a root-element for the SVG
		this.svgRoot = this.doc.getDocumentElement();

		//add DEXPI-namespace
		this.dexpiNS = "http://sandbox.dexpi.org/rdl/";
		this.dexpiPrefix = "dexpi";
		
		svgRoot.setAttribute("xmlns:" + this.dexpiPrefix, this.dexpiNS);
		
		// Set the width and height attributes on the root 'svg' element.
		this.svgRoot.setAttributeNS(null, "width", "" + resolutionX);
		this.svgRoot.setAttributeNS(null, "height", "" + resolutionY);

		this.resolutionX = resolutionX;
		this.resolutionY = resolutionY;
		
		/* Create the background of the image */
		// First we have to convert the background-color into an svg-format
		String color = convertAWTColorToSVGColor(backgroundColor);

		Element rectangle = this.doc.createElementNS(svgNS, "rect");
		rectangle.setAttributeNS(null, "x", "" + origin[0]);
		rectangle.setAttributeNS(null, "y", "" + origin[1]);
		rectangle.setAttributeNS(null, "width", "" + resolutionX);
		rectangle.setAttributeNS(null, "height", "" + resolutionY);
		rectangle.setAttributeNS(null, "fill", color);

		if(this.groupNode != null)
			this.groupNode.appendChild(rectangle);
		else
			this.svgRoot.appendChild(rectangle);		
	}

	/**
	 * This function converts a AWT-Color to a formatted SVG-Color-String
	 * 
	 * @param color
	 *            color to be transformed
	 * @return String 'rgb(R,G,B)', whereas R, G, B = [0, 255];
	 */
	private String convertAWTColorToSVGColor(Color color) {
		String ret = "rgb(";

		ret += color.getRed();
		ret += ",";
		ret += color.getGreen();
		ret += ",";
		ret += color.getBlue();

		ret += ")";

		return ret;
	}

	// debug-function to write the svg to a file for test-purposes
	@SuppressWarnings("unused")
	private void debug_writeSVG() {
		// now write to file
		DOMSource source = new DOMSource(doc);
		FileWriter writer;
		try {
			// TODO outsource this function
			writer = new FileWriter(new File("c:/uni/output.svg"));

			StreamResult result = new StreamResult(writer);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.transform(source, result);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param destination
	 *            Destination where file should be written to, e.g.
	 *            "c:/destination/fileName.svg"
	 * @return true if successful, else false
	 */
	@Override
	public boolean writeToDestination(String destination) {
		// now write to file
		destination = destination.replace("xml", "svg").replaceAll("png", "svg");

		DOMSource source = new DOMSource(doc);
		FileWriter writer;
		try {
			writer = new FileWriter(new File(destination));

			StreamResult result = new StreamResult(writer);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
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
	public void addLine(Color c, float lineWeight, double[] xCoordinates, double[] yCoordinates) {

		double cosPhi1;
		double sinPhi1;

		int xIntCoord[] = new int[xCoordinates.length];
		int yIntCoord[] = new int[yCoordinates.length];

		String color = convertAWTColorToSVGColor(c);

		Element polyline = this.doc.createElementNS(svgNS, "polyline");
		polyline.setAttributeNS(null, "fill", "none");
		polyline.setAttributeNS(null, "stroke", color);
		polyline.setAttributeNS(null, "stroke-width", "" + (lineWeight * this.s));

		// transform to polar coordinates for easier rotation
		for (int i = 0; i < xCoordinates.length; i++) {
			this.r = Math.sqrt(Math.pow(xCoordinates[i], 2) + Math.pow(yCoordinates[i], 2));
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

		String points = "";
		for (int i = 0; i < xIntCoord.length; ++i) {
			points += xIntCoord[i];
			points += ",";
			points += yIntCoord[i];
			points += " ";
		}

		polyline.setAttributeNS(null, "points", points);

		if(this.groupNode != null)
			this.groupNode.appendChild(polyline);
		else
			this.svgRoot.appendChild(polyline);
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
	public void addShape(Color c, float lineWeight, double xCoordinates[], double yCoordinates[], boolean filled) {

		double cosPhi1;
		double sinPhi1;

		String color = convertAWTColorToSVGColor(c);

		Element polygon = this.doc.createElementNS(svgNS, "polygon");
		if (filled == true) {
			polygon.setAttributeNS(null, "fill", color);
		} else {
			polygon.setAttributeNS(null, "fill", "none");
		}
		polygon.setAttributeNS(null, "stroke", color);
		polygon.setAttributeNS(null, "stroke-width", "" + (lineWeight * this.s));

		int xIntCoord[] = new int[xCoordinates.length];
		int yIntCoord[] = new int[yCoordinates.length];

		for (int i = 0; i < xCoordinates.length; i++) {
			this.r = Math.sqrt(Math.pow(xCoordinates[i], 2) + Math.pow(yCoordinates[i], 2));
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

		String points = "";
		for (int i = 0; i < xIntCoord.length; ++i) {
			points += xIntCoord[i];
			points += ",";
			points += yIntCoord[i];
			points += " ";
		}

		polygon.setAttributeNS(null, "points", points);

		if(this.groupNode != null)
			this.groupNode.appendChild(polygon);
		else
			this.svgRoot.appendChild(polygon);
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
	public void addEllipse(Color c, float lineWeight, double[] position, double primAxis, double secAxis,
			double startAngle, double endAngle, boolean filled) {

		// TODO test ellipse with new testcase

		String color = convertAWTColorToSVGColor(c);

		Element ellipse = this.doc.createElementNS(svgNS, "path");
		if (filled == true) {
			ellipse.setAttributeNS(null, "fill", color);
		} else {
			ellipse.setAttributeNS(null, "fill", "none");
		}
		ellipse.setAttributeNS(null, "stroke", color);
		ellipse.setAttributeNS(null, "stroke-width", "" + (lineWeight * this.s));

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

		/*
		 * x1 - width / 2 y1 - height / 2 width height (int) (startAngle) (int)
		 * (arcAngle));
		 */

		double[] newPos = { (double) (x1), (double) (y1) };
		int clockWise = (arcAngle < 180) ? 1 : 0;

		String ellipsePath = "";

		Coordinate endCoordinate = getLocationFromAngle(endAngle, r, newPos);

		ellipsePath += "M" + x1 + " " + y1;
		ellipsePath += " " + "A" + width + " " + height + " " + 0 + " " + 0 + " " + clockWise + " "
				+ endCoordinate.getX() + " " + endCoordinate.getY();

		ellipse.setAttributeNS(null, "d", ellipsePath);

		if(this.groupNode != null)
			this.groupNode.appendChild(ellipse);
		else
			this.svgRoot.appendChild(ellipse);

		// TODO: verify ellipse-call

		/*
		 * if (filled != true) { this.g.drawArc(x1 - width / 2, y1 - height / 2, width,
		 * height, (int) (startAngle), (int) (arcAngle)); } else { this.g.fillArc(x1 -
		 * width / 2, y1 - height / 2, width, height, (int) (startAngle), (int)
		 * (arcAngle)); }
		 */

	}

	private Coordinate getLocationFromAngle(double degree, double radius, double[] center) {
		double radian = (degree * Math.PI) / 180;
		return new Coordinate(Math.cos(radian) * radius + center[0], Math.sin(radian) * radius + center[1]);
	}

	private String getFullCirclePath(Coordinate[] points, double radius, int clockWise) {
		String circlePath = "";

		circlePath += "M" + points[0].getX() + " " + points[0].getY();
		circlePath += " " + "A" + radius + " " + radius + " " + 0 + " " + 0 + " " + clockWise + " " + points[1].getX()
				+ " " + points[1].getY();
		circlePath += " " + 'A' + radius + " " + radius + " " + 0 + " " + 0 + " " + clockWise + " " + points[2].getX()
				+ " " + points[2].getY();
		circlePath += " " + 'A' + radius + " " + radius + " " + 0 + " " + 0 + " " + clockWise + " " + points[3].getX()
				+ " " + points[3].getY();
		circlePath += " " + 'Z';

		return circlePath;
	}

	private String getPartialCirclePath(Coordinate[] points, double radius, int clockWise) {
		String circlePath = "";

		circlePath += "M" + points[0].getX() + " " + points[0].getY();
		circlePath += " " + 'A' + radius + " " + radius + " " + 0 + " " + 0 + " " + clockWise + " " + points[3].getX()
				+ " " + points[3].getY();

		return circlePath;
	}

	private String getPathArc(double[] center, double start, double end, double radius) {

		if (end == start)
			end += 360;

		double degree = end - start;

		degree = degree < 0 ? (degree + 360) : degree;

		Coordinate[] points = new Coordinate[4];

		if ((int) degree == 360) {
			points[0] = getLocationFromAngle(start, radius, center);
			points[1] = getLocationFromAngle(start + degree / 3, radius, center);
			points[2] = getLocationFromAngle(start + degree * 2 / 3, radius, center);
			points[3] = getLocationFromAngle(end, radius, center);

			for (Coordinate coord : points) {
				coord.setX(Math.round(coord.getX() * 1000.0) / 1000.0);
				coord.setY(Math.round(coord.getY() * 1000.0) / 1000.0);
			}

			return this.getFullCirclePath(points, radius, (degree < 180) ? 0 : 1);
		} else {
			points[0] = getLocationFromAngle(start + 180, radius, center);
			points[1] = getLocationFromAngle(start + degree / 3, radius, center);
			points[2] = getLocationFromAngle(start + degree * 2 / 3, radius, center);
			points[3] = getLocationFromAngle(end + 180, radius, center);

			for (Coordinate coord : points) {
				coord.setX(Math.round(coord.getX() * 1000.0) / 1000.0);
				coord.setY(Math.round(coord.getY() * 1000.0) / 1000.0);
			}

			return this.getPartialCirclePath(points, radius, (degree < 180) ? 1 : 0);
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
	public void addCircle(Color c, float lineWeight, double[] position, double radius, double startAngle,
			double endAngle, boolean filled) {

		String color = convertAWTColorToSVGColor(c);

		Element circle = this.doc.createElementNS(svgNS, "path");

		if (filled == true) {
			circle.setAttributeNS(null, "fill", color);
		} else {
			circle.setAttributeNS(null, "fill", "none");
		}

		circle.setAttributeNS(null, "stroke", color);
		circle.setAttributeNS(null, "stroke-width", "" + (lineWeight * this.s));

		double cosPhi1;
		double sinPhi1;

		double x1 = 0;
		double y1 = 0;
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
		x1 = ((this.scaleX * this.r * cosPhi1 - this.posX) * this.x);
		y1 = ((this.posY - this.scaleY * this.r * sinPhi1) * this.x);

		/*
		 * double arcAngle; if (endAngle < startAngle) { arcAngle = endAngle + 360 -
		 * startAngle; } else { arcAngle = endAngle - startAngle; }
		 */

		double[] newPos = { (double) (x1), (double) (y1) };
		String path = getPathArc(newPos, startAngle, endAngle, r);

		circle.setAttributeNS(null, "d", path);

		if(this.groupNode != null)
			this.groupNode.appendChild(circle);
		else
			this.svgRoot.appendChild(circle);
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
	public void addText(Color c, double[] position, double[] extent, double textAngle, String string, double height,
			String font) {
		/*
		 * check for linebreaks and call this function recursively with corrected
		 * substrings
		 */
		if (string.contains("\r") || string.contains("\n") || string.contains("&#xD;") || string.contains("&#xA;")) {
			String[] subStrings = linebreakPattern.split(string);
			double posYBackup = this.posY;
			for (int i = 0; i < subStrings.length; ++i) {
//				System.out.println(subStrings[i]);
				double[] newPos = position.clone();
				addText(c, newPos, extent, textAngle, subStrings[i], height, font);
				this.posY += height * 0.8; // 0.8 is a magic constant that is also
											// used in JaxbInputRepository
			}
			this.posY = posYBackup;
			return;
		}

		String color = convertAWTColorToSVGColor(c);

		Element text = this.doc.createElementNS(svgNS, "text");

		text.setAttributeNS(null, "fill", color);

		double minX = 0;
		double minY = 0;
//		if (extent == null) {
//			extent = new double[4];
//			extent[0] = 0;
//			extent[2] = 0;
//			// error--> extent is missing
//		}

		/*
		 * NOTE: As we only use absolute coordinates now, the next section is relative
		 * (as the extent is no longer of interest)
		 * Hence, it is replaced with the reduced part below
		 */

		// if text is rotated, lower left corner is reference point
		// if (extent[0] <= 0) {
		// minX = position[0];
		// } else {
		// minX = position[0] + height / 1.44 * Math.sin(textAngle);
		// }
		// if (extent[2] <= 0) {
		// minY = position[1];
		// } else {
		// minY = Math.min(Math.min(extent[2], extent[3]), position[1]);
		// }

		minX = position[0] + height / 1.44 * Math.sin(textAngle);
		minY = position[1];

		int intPos[] = new int[2];
		intPos[0] = (int) ((minX - this.posX) * this.x);
		intPos[1] = (int) ((this.posY - minY) * this.x);

		// set font
		// Font textFont = new Font(font, Font.PLAIN, (int) (height * FONT_SIZE_FACTOR *
		// this.x));
		// this.g.setFont(textFont);

		// set Rotation Point
		int rotPt[] = new int[2];
		rotPt[0] = (int) ((position[0] - this.posX) * this.x);
		rotPt[1] = (int) ((this.posY - position[1]) * this.x);

		// rotating text is not possible, so the drawing will get rotated
		// arround
		// the text element

		// rotate
		// ((Graphics2D) this.g).rotate(Math.toRadians(-textAngle), rotPt[0], rotPt[1]);

		String rotation = "rotate(" + textAngle + " " + rotPt[0] + "," + rotPt[1] + ")";

		text.setAttributeNS(null, "x", "" + intPos[0]);
		text.setAttributeNS(null, "y", "" + intPos[1]);
		text.setAttributeNS(null, "font-family", font);
		text.setAttributeNS(null, "font-size", "" + (height * FONT_SIZE_FACTOR * this.x));
		text.setAttributeNS(null, "transform", rotation);

		Text textString = this.doc.createTextNode(string);
		text.appendChild(textString);

		if(this.groupNode != null)
			this.groupNode.appendChild(text);
		else
			this.svgRoot.appendChild(text);

		// draw string
		// this.g.drawString(string, intPos[0], intPos[1]);

		// rotate back
		// ((Graphics2D) this.g).rotate(Math.toRadians(textAngle), rotPt[0], rotPt[1]);

	}

	/**
	 * Shifts and rotates the coordinate system to draw elements from the
	 * shapeCatalogue
	 * 
	 * @param reference
	 *            the reference, rotates the image. The two numbers represent the
	 *            cosinus and sinus of the desired angle.
	 * @param scale
	 *            the scale
	 * @param position
	 *            the position a shapeCatalogue-element should be drawn to
	 */
	@Override
	public void setScaleAnglePos(double[] reference, double[] scale, double[] position) {
		// in case a shapeCatalogue reference is used, the position (and angle)
		// for the symbol to be drawn to, is set here
		this.posX = this.x0 - position[0];
		this.posY = this.y0 - position[1];

		this.cosPhi = reference[0];
		this.sinPhi = reference[1];

		// check if Reference is correct (to 3 decimal places)
		if (Math.abs(1 - (this.cosPhi * this.cosPhi + this.sinPhi * this.sinPhi)) > 0.000303) {
			System.out.println("Reference is incorrect (X\u00b2+Y\u00b2 should equal 1)");
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
	 * return a buffered-image, hence the build svg will be transformed to a
	 * buffered image
	 * 
	 * @return the final image
	 */
	@Override
	public BufferedImage buildImage() {

		// System.out.println("Transcoding");

		PNGTranscoder pngTranscoder = new PNGTranscoder();

		pngTranscoder.addTranscodingHint(XMLAbstractTranscoder.KEY_XML_PARSER_VALIDATING, Boolean.FALSE);

		// Set the transcoding hints.
		pngTranscoder.addTranscodingHint(PNGTranscoder.KEY_WIDTH, new Float(this.resolutionX));
		pngTranscoder.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, new Float(this.resolutionY));

		TranscoderInput input = new TranscoderInput(doc);

		// //NOTE: This section of the code writes the image directly as an PNG to the
		// given destination
		// try {
		// String destination = "c:/destination/name.png";
		// OutputStream ostream = new FileOutputStream(destination);
		// TranscoderOutput output = new TranscoderOutput(ostream);
		//
		// pngTranscoder.transcode(source, output);
		//
		// ret = pngTranscoder.createImage(resolutionX, resolutionY);
		//
		// // Flush and close the stream.
		// ostream.flush();
		// ostream.close();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		ByteArrayOutputStream ostream = null;
		try {
			// Create the transcoder output.
			ostream = new ByteArrayOutputStream();
			TranscoderOutput output = new TranscoderOutput(ostream);

			// Save the image.
			pngTranscoder.transcode(input, output);

			// Flush and close the stream.
			ostream.flush();
			ostream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Convert the byte stream into an image.
		byte[] imgData = ostream.toByteArray();
		Image img = Toolkit.getDefaultToolkit().createImage(imgData);

		// Wait until the entire image is loaded.
		MediaTracker tracker = new MediaTracker(new JPanel());
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		// now we do need the image as a buffered image
		BufferedImage ret = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = ret.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

//		System.out.println("ret");

		// Return the newly rendered image.
		return ret;
	}

	/**
	 * Creates an imageMapElement of a pidElement. The imageMapElement basically
	 * defines the area occupied by the pidElement. This allows to display of
	 * additional information when hovering over this area with the mouse, if used
	 * in a html website.
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

				this.imageMapObjects.add(
						new ImageMapObject(startX, startY, (startX + rangeX), (startY + rangeY), id, componentName));
			} else if (pidElement.getType() != null || pidElement.getComponentClass().contains("Line") == true) {
				// TODO somehow this is not required?
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
	public void setCurrentGroupNode(String tagName, String componentClass) {

		if(tagName != null && componentClass != null) {
			this.groupNode = this.doc.createElementNS(svgNS, "g");
			this.groupNodeTagName = tagName;
			this.groupNodeComponentClass = componentClass;

			this.groupNode.setAttributeNS(dexpiNS, "tagName", this.groupNodeTagName );
			this.groupNode.setAttributeNS(dexpiNS, "componentClass", this.groupNodeComponentClass );
			
//			svgRoot.appendChild(this.groupNode);
		}
		else {
			this.groupNode = null;
			this.groupNodeTagName = null;
			this.groupNodeComponentClass = null;
		}
	}
	
	@Override
	public void addNodeToRoot() {
		if(this.groupNode != null)
			svgRoot.appendChild(this.groupNode);

		//as this funciton is only called, when a node is written, the node is no longer written to. Hence, we can nullify it to prevent errors
		this.groupNode = null;
	}
	
	@Override
	public ArrayList<ErrorElement> getErrorList() {
		return this.listOfErrors;
	}
}
