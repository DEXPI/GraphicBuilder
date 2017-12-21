package org.dexpi.pid.test.testCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.dexpi.pid.imaging.GraphicBuilder;
import org.dexpi.pid.imaging.GraphicBuilderImageWriteListener;
import org.dexpi.pid.imaging.GraphicFactory;
import org.dexpi.pid.imaging.ImageFactory_PNG;
import org.dexpi.pid.imaging.InputRepository;
import org.dexpi.pid.imaging.JaxbErrorLogRepository;
import org.dexpi.pid.imaging.JaxbInputRepository;
import org.dexpi.pid.test.old.Tester;

import org.apache.logging.log4j.Logger;

abstract class AuxiliaryFunctions {
	// AUXILIARY FUNCTIONS:

	/**
	 * This function loads the file and calls the GraphicBuilder.
	 * 
	 * @param logger
	 *            logger to use
	 * @param INPUT_FOLDER_AND_FILE_NAME
	 *            URI for xml-file
	 * @throws Exception
	 */
	static void runGBuilder(Logger logger, String INPUT_FOLDER_AND_FILE_NAME,
			int resolutionX) throws Exception {

		File xmlFile = new File(INPUT_FOLDER_AND_FILE_NAME);
		logger.info("Starting Tester for Graphic Builder.");
		logger.info("Input file: " + INPUT_FOLDER_AND_FILE_NAME);

		// Building image from xmlFile:
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
		String outputFileName = INPUT_FOLDER_AND_FILE_NAME.replaceAll(".xml",
				".png");
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

		String imgMapName = "HTMLImageMap";
		logger.info(gBuilder.generateHTMLimageMap(imgMapName));
		String imgMap = gBuilder.generateHTMLimageMap(imgMapName);
		String htmlFileName = Tester.INPUT_FILE_NAME.replace(".xml", ".html");
		generateHTMLWebsite(file.getName(), htmlFileName, imgMap, imgMapName,
				logger);

		logger.info("Build finished.");
	}

	/**
	 * Subfunction to generate HTML-Website
	 * 
	 * @param imgFileName
	 * @param htmlFileName
	 * @param imgMap
	 * @param imgMapName
	 * @param logger
	 * @throws FileNotFoundException
	 */
	private static void generateHTMLWebsite(String imgFileName,
			String htmlFileName, String imgMap, String imgMapName, Logger logger)
			throws FileNotFoundException {
		String html = "<html>\n<body>\n";
		html += "<img usemap=\"#" + imgMapName + "\" src=\"" + imgFileName
				+ "\"/>\n";
		html += imgMap;
		html += "</body>\n</html>\n";

		logger.info("Writing HTML file to " + htmlFileName);

		try (PrintWriter out = new PrintWriter(htmlFileName)) {
			out.println(html);
		}
	}
}
