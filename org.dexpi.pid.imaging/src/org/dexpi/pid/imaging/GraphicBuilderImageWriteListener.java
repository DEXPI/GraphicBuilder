package org.dexpi.pid.imaging;

/**
 * This class is designed as a listener, attached to the 
 * GraphicBuilder - the sole purpose is to tunnel the
 * progress of the GraphicBuilder towards a graphical service.
 * 
 * As this is merely an implementation of a standard IOWriteProgressListener
 * one should look at the class-definitino of this class for further
 * comments.
 */

import javax.imageio.ImageWriter;
import javax.imageio.event.IIOWriteProgressListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dexpi.pid.test.old.Tester;

public class GraphicBuilderImageWriteListener implements
		IIOWriteProgressListener {

	private int lastPercentage = -10;
	private int percentageSteps = 10;

	private Logger logger;

	public GraphicBuilderImageWriteListener() {
		this.logger = LogManager.getLogger(Tester.class.getName());
	}

	@Override
	public void imageComplete(ImageWriter source) {
		this.logger.debug("Image complete.");

	}

	@Override
	/**
	 * @author Michael Wiedau
	 * This uses only the [percentageSteps] percentages to display
	 */
	public void imageProgress(ImageWriter source, float percentageDone) {
		int iPercentageDone = Math.round(percentageDone);
		if ((iPercentageDone % this.percentageSteps == 0)
				&& iPercentageDone != this.lastPercentage) {
			this.logger.debug(iPercentageDone + "% written.");
			this.lastPercentage = iPercentageDone;
		}

	}

	@Override
	public void imageStarted(ImageWriter source, int imageIndex) {
		this.logger.debug("Writing image Nr. " + imageIndex + 1);

	}

	@Override
	public void thumbnailComplete(ImageWriter source) {
		this.logger.debug("Thumbnail complete");

	}

	@Override
	public void thumbnailProgress(ImageWriter source, float percentageDone) {
		this.logger.debug("Thumbnail: " + percentageDone + "% written.");

	}

	@Override
	public void thumbnailStarted(ImageWriter source, int imageIndex,
			int thumbnailIndex) {
		this.logger.debug("Thumbnail Nr. " + imageIndex + " written.");

	}

	@Override
	public void writeAborted(ImageWriter source) {
		this.logger.warn("Write aborted.");

	}

	public int getlastPercentage() {
		return this.lastPercentage;

	}
}
