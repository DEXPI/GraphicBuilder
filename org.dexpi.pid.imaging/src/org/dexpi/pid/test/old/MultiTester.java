package org.dexpi.pid.test.old;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

public class MultiTester {

	public static String INPUT_FOLDER_NAME = "Y:/DEXPI - Common Workspace/Meetings & Telkos/2015-03-17 Hackathon/DEXPI/test02/"; // ENDING
																																	// SLASH!
	public static String[] inputFileNames = { "DEXPI_from_Autodesk_export_V01",
			"DEXPI_from_AVEVA_export_v03",
			"DEXPI_from_INTERGRAPH_export_v0-0-2-6_A",
			"DEXPI_from_SIEMENS_export_v07" };

	private static Logger logger = LogManager.getLogger(Tester.class.getName());

	public static void main(String[] args) throws Exception {
		System.out.println("DEXPI GraphicBuilder");
		for (String fileName : inputFileNames) {
			logger.info("====================================================");

			logger.info("== " + fileName);
			logger.info("====================================================");

			fileName = INPUT_FOLDER_NAME + fileName + ".xml";
			(new MultiTester()).startTesting(fileName);

		}
	}

//	@SuppressWarnings("static-method")
	public void startTesting(String inpuFileName) throws Exception {

		File xmlFile = new File(inpuFileName);
		logger.info("Starting Tester for Graphic Builder.");
		logger.info("Input file: " + inpuFileName);
		
		// Building image from xmlFile:

		int resolutionX = 6000;

		String outputFileName = inpuFileName.replaceAll(".xml", ".png");
		
		JaxbErrorLogRepository errorRep = new JaxbErrorLogRepository(xmlFile);
		InputRepository inputRep = new JaxbInputRepository(xmlFile);
		GraphicFactory gFac = new ImageFactory_PNG();
		GraphicBuilder gBuilder = new GraphicBuilder(inputRep, gFac, errorRep);
		BufferedImage image = gBuilder.buildImage(resolutionX, outputFileName);

		// Writing image now:

		// Get all possible Image Writers that are actually available for the
		// type PNG
		Iterator<ImageWriter> imageWriters = ImageIO
				.getImageWritersBySuffix("PNG");

		// select the first found Writer
		ImageWriter imageWriter = (ImageWriter) imageWriters.next();

		// Ok, we need the output file of course
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

		logger.info("Tester finished.");

	}

	@SuppressWarnings({ "static-method", "unused" })
	@Deprecated
	private void generateHTMLWebsite(String imgFileName, String htmlFileName,
			String imgMap, String imgMapName) throws FileNotFoundException {
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
