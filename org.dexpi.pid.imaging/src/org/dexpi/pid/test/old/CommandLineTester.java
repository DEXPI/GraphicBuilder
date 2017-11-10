package org.dexpi.pid.test.old;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dexpi.pid.imaging.GraphicBuilder;
import org.dexpi.pid.imaging.GraphicBuilderImageWriteListener;
import org.dexpi.pid.imaging.GraphicFactory;
import org.dexpi.pid.imaging.ImageFactory_PNG;
import org.dexpi.pid.imaging.InputRepository;
import org.dexpi.pid.imaging.JaxbErrorLogRepository;
import org.dexpi.pid.imaging.JaxbInputRepository;

public class CommandLineTester {

	private static String inpuFileName = null;

	public static String INPUT_FOLDER_NAME = null;

	private static Logger logger = LogManager.getLogger(Tester.class.getName());

	public static void main(String[] args) throws Exception {
		System.out.println("DEXPI GraphicBuilder");

		if (args.length == 0)
			throw new Exception("Please give a ProteusXML-file as argument.");

		inpuFileName = args[0];
		if (INPUT_FOLDER_NAME != null) {
			getFileNamesFromFolder();
		} else {
			(new CommandLineTester()).startTesting();
		}
	}

	/**
	 * gets all xml File Names from the given Folder
	 * 
	 * @throws Exception
	 *             exception thrown
	 */
	public static void getFileNamesFromFolder() throws Exception {
		File dir = new File(INPUT_FOLDER_NAME);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				inpuFileName = child.getPath();
				if (inpuFileName.endsWith(".xml")) {
					(new CommandLineTester()).startTesting();
				}
			}
		}
	}

	@SuppressWarnings("static-method")
	public void startTesting() throws Exception {

		File xmlFile = new File(inpuFileName);
		logger.info("Starting Tester for Graphic Builder.");
		logger.info("Input file: " + inpuFileName);

		// Building image from xmlFile:

		int resolutionX = 6000;

		JaxbErrorLogRepository errorRep = new JaxbErrorLogRepository(xmlFile);
		InputRepository inputRep = new JaxbInputRepository(xmlFile);
		GraphicFactory gFac = new ImageFactory_PNG();
		GraphicBuilder gBuilder = new GraphicBuilder(inputRep, gFac, errorRep);
		BufferedImage image = gBuilder.buildImage(resolutionX, null);

		// Writing image now:

		// Get all possible Image Writers that are actually available for the
		// type PNG
		Iterator<ImageWriter> imageWriters = ImageIO
				.getImageWritersBySuffix("PNG");

		// select the first found Writer
		ImageWriter imageWriter = (ImageWriter) imageWriters.next();

		// Ok, we need the output file of course
		String outputFileName = inpuFileName.replaceAll(".xml", ".png");
		logger.info("Output file: " + outputFileName);
		File file = new File(outputFileName);

		// Now we define the output stream
		try (ImageOutputStream ios = ImageIO.createImageOutputStream(file)) {
			imageWriter.setOutput(ios);

			// Here we add the Listener which reports to the logger, so we can
			// see
			// the progress
			imageWriter
					.addIIOWriteProgressListener(new GraphicBuilderImageWriteListener());

			// Now start writing the image
			imageWriter.write(image);
		}
		// logger.info(builder.generateHTMLimageMap("TestImageMap"));

		logger.info("Tester finished.");

	}

}
