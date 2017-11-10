package org.dexpi.pid.imaging;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.dexpi.pid.imaging.pidElements.ErrorElement;
import org.dexpi.pid.imaging.pidElements.PidElement;

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
 * 
 * 
 * @author El Pulpo
 *
 */
public interface GraphicFactory {

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
	public void init(int resolutionX, double origin[], double size[],
			Color backgroundColor);

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
	public void addLine(Color c, float lineWeight, double xCoordinates[],
			double yCoordinates[]);

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
	public void addShape(Color c, float lineWeight, double xCoordinates[],
			double yCoordinates[], boolean filled);

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
	public void addCircle(Color c, float lineWeight, double position[],
			double radius, double startAngle, double endAngle, boolean filled);

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
	public void addText(Color c, double position[], double extent[],
			double textAngle, String string, double height, String Font);

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
	public void addEllipse(Color c, float lineWeight, double[] position,
			double primAxis, double secAxis, double startAngle,
			double endAngle, boolean filled);

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
	public void setScaleAnglePos(double reference[], double scale[],
			double position[]);

	/**
	 * resets scale, angle and position
	 */
	public void resetScaleAnglePos();

	/**
	 * 
	 * @return the final image
	 */
	public BufferedImage buildImage();

	public boolean writeToDestination(String destination);
	
	/**
	 * Creates an imageMapElement of a pidElement. The imageMapElement basically
	 * defines the area occupied by the pidElement. This allows to display of
	 * additional information when hovering over this area with the mouse, if
	 * used in a html website.
	 * 
	 * @param pidElement
	 *            the pidElement
	 */
	public void addImageMapElement(PidElement pidElement);

	/**
	 * All imageMapObjects created are added to a list and can be returned if
	 * desired.
	 * 
	 * @return a list of all imageMapObjects created
	 */
	public List<ImageMapObject> getImageMapObjects();

	public ArrayList<ErrorElement> getErrorList();

}
