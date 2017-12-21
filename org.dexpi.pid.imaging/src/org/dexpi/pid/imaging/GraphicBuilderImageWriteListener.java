package org.dexpi.pid.imaging;

import java.io.PrintStream;
import java.util.logging.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

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

import org.dexpi.pid.test.old.StandAloneTester;

public class GraphicBuilderImageWriteListener implements
		IIOWriteProgressListener {

	private int lastPercentage = -10;
	private int percentageSteps = 10;

	private Logger logger;

	public GraphicBuilderImageWriteListener() {
		this.logger = Logger.getLogger(GraphicBuilder.class.getName());
		this.logger.setLevel(Level.ALL);
		
		PrintStream psh = StandAloneTester.getPrintStreamHandle();
		if(psh != null) {
			TinyFormatter fmt = new TinyFormatter();
			StreamHandler sh = new StreamHandler(psh, fmt);
			this.logger.addHandler(sh);
		}
	}

	@Override
	public void imageComplete(ImageWriter source) {
		this.logger.log(Level.FINE , "Image complete.");

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
			this.logger.info(iPercentageDone + "% written.");
			this.lastPercentage = iPercentageDone;
		}

	}

	@Override
	public void imageStarted(ImageWriter source, int imageIndex) {
		this.logger.log(Level.INFO, "Writing image Nr. " + imageIndex + 1);

	}

	@Override
	public void thumbnailComplete(ImageWriter source) {
		this.logger.log(Level.INFO, "Thumbnail complete");

	}

	@Override
	public void thumbnailProgress(ImageWriter source, float percentageDone) {
		this.logger.log(Level.INFO, "Thumbnail: " + percentageDone + "% written.");

	}

	@Override
	public void thumbnailStarted(ImageWriter source, int imageIndex,
			int thumbnailIndex) {
		this.logger.log(Level.INFO, "Thumbnail Nr. " + imageIndex + " written.");

	}

	@Override
	public void writeAborted(ImageWriter source) {
		this.logger.log(Level.INFO, "Write aborted.");

	}

	public int getlastPercentage() {
		return this.lastPercentage;

	}
}
