package org.dexpi.pid.test.old;

/**
 * This class is the one that has to be exported as a standalone graphicbuilder-jar!
 * @MaHe08
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dexpi.pid.imaging.GraphicBuilder;
import org.dexpi.pid.imaging.GraphicBuilderImageWriteListener;
import org.dexpi.pid.imaging.GraphicFactory;
import org.dexpi.pid.imaging.ImageFactory_SVG;
import org.dexpi.pid.imaging.InputRepository;
import org.dexpi.pid.imaging.JaxbErrorLogRepository;
import org.dexpi.pid.imaging.JaxbInputRepository;

public class StandAloneTester {

	/**
	 * Enhanced the CommandLineTester with an input-dialog in the case no
	 * xml-file is supplied. Still the command-line-functionality works!
	 * 
	 */
	private static String inputFileName = null;

	public static String INPUT_FOLDER_NAME = null;

	private static Logger logger = LogManager.getLogger(Tester.class.getName());

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter(
					"Proteus File", "xml"));

			fileChooser.showOpenDialog(null);

			try {
				File f = fileChooser.getSelectedFile();

				inputFileName = f.getAbsolutePath();
				try {
					infoBox("GraphicBuilder is working, this may take a few seconds.",
							"GB Working");
					(new StandAloneTester()).startTesting();
					infoBox("GraphicBuilder has finished!", "GB Finished");
				} catch (Exception e) {
					infoBox("GraphicBuilder caught an Exception - please contact the developer!"
							+ "\n" + e.getMessage(), "GB Finished");
				}

			} catch (Exception e) {
				System.out.println("DEXPI GraphicBuilder");
				infoBox("Please give a ProteusXML-file as argument.", "GB Error");
				throw new Exception("Please give a ProteusXML-file as argument.");
			}

		} else {
			System.out.println("DEXPI GraphicBuilder");

			inputFileName = args[0];
			if (INPUT_FOLDER_NAME != null) {
				getFileNamesFromFolder();
			} else {
				(new StandAloneTester()).startTesting();
			}
		}
	}

	/**
	 * Simple class, that displays an information
	 * 
	 * @param infoMessage
	 * @param titleBar
	 */
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage,
				"InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
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
				inputFileName = child.getPath();
				if (inputFileName.endsWith(".xml")) {
					(new StandAloneTester()).startTesting();
				}
			}
		}
	}

	@SuppressWarnings("static-method")
	public void startTesting() throws Exception {

		File xmlFile = new File(inputFileName);
		logger.info("Starting Tester for Graphic Builder.");
		logger.info("Input file: " + inputFileName);

		// Building image from xmlFile:

		int resolutionX = 6000;
		
		String outputFileName = inputFileName.replaceAll(".xml", ".png");

		JaxbErrorLogRepository errorRep = new JaxbErrorLogRepository(xmlFile);
		InputRepository inputRep = new JaxbInputRepository(xmlFile);
		GraphicFactory gFac = new ImageFactory_SVG();
//		GraphicFactory gFac = new ImageFactory_PNG();
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

		// logger.info(builder.generateHTMLimageMap("TestImageMap"));

		logger.info("Tester finished.");

	}

}
