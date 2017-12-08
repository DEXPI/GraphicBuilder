
package org.dexpi.pid.imaging;

import java.awt.Color;
import java.util.ArrayList;

import org.dexpi.pid.imaging.pidElements.ErrorElement;
import org.dexpi.pid.imaging.pidElements.PidElement;

public interface InputRepository {

	/**
	 * sets zeroPoint, size, backgroundcolor, shapeCatalogue and drawing
	 */
	public void init();

	/**
	 * 
	 * @return the zeroPoint specified in the file
	 */
	public double[] getZeroPoint();

	/**
	 * 
	 * @return the size of the drawing
	 */
	public double[] getSize();

	/**
	 * 
	 * @return the backgroundColor of the drawing
	 */
	public Color getBackgroundcolor();

	/**
	 * 
	 * @return all items in &lt;Drawing&gt; that should be drawn
	 */
	public PidElement getDrawing();

	/**
	 * 
	 * @return all plantItems (transformed to pidElements)
	 */
	public ArrayList<PidElement> getPlantItems();

	/**
	 * 
	 * @return all annotationItems (transformed to pidElements)
	 */
	public ArrayList<PidElement> getAnnotationItems();

	/**
	 * 
	 * @return the locator
	 */
	public Locator getLocator();

	/**
	 * 
	 * @return all piping-related pidElements
	 */
	public ArrayList<PidElement> getPiping();

	public ArrayList<ErrorElement> getErrorList();

	public ArrayList<String> getLoggerList();
}
