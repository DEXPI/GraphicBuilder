package org.dexpi.pid.test.old;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tester {

	public static String INPUT_FILE_NAME = // null;

	// ---------------------------------------------------------------------------
	// DEXPI
	// "C:/Users/rwth/Documents/DEXPI/avt-dev-trunk/release/best_practice/dexpi_best_practice.proteus.xml";
	// "./files/aveva/aveva04.xml";
	// "./files/autodesk/Milestone_1_r0.4.xml";
	// "./files/intergraph/PID Ausschnitt Phase 1_Post.xml";
	// "./files/autodesk/Autodesk_export_V01.xml";
	// "./files/AVT Referenz/LinkedReferenz.xml";
	// "./files/AVT Referenz/DexpiBestPracticeV0.9.xml";
	// "./files/AVT Referenz/DexpiBestPracticeV0.8.xml";
	// "./files/testCases/InvalidIdentifier/dexpi_best_practice.proteus - invalid Identifier.xml";
	// "./files/testCases/NegativeCoordinateSystem/drawing_moved_origin.xml";

	// ---------------------------------------------------------------------------
	// SIEMENS
	// "./files/siemens/2013_03_11 COMOS DEXPI Export_EQ example.xml";
	// "./files/siemens/2013_03_11 COMOS XMpLant 333 Export_EQ example_ORG.xml";
	// "./files/siemens/2013-11-05_Siemens_DEXPI PID export from COMOS.xml";
	// "./files/siemens/siemens01.xml";
	// "./files/siemens/DEXPI_PID_slightlyFixed_phbe.xml";
	// "./files/siemens/DEXPI_PID_slightlyFixed_phbe.xml";

	// ---------------------------------------------------------------------------
	// INTERGRAPH
	// "./files/intergraph/PID Ausschnitt Phase 1_Post.xml";
	// "./files/intergraph/Intergraph_Export_V.0.0.2.6.xml";
	// "./files/intergraph/Intergraph_export_333_v0-0-0-2-6_B.xml";
	// "./files/intergraph/hackathon01.xml";
	// "./files/intergraph/hackathon04a.xml";

	// AUTODESK
	// ---------------------------------------------------------------------------
	// "./files/autodesk/2013-11-13_Autodesk.xml";
	// "./files/autodesk/2013-11-13_Autodesk_edited.xml";
	// "./files/autodesk/Milestone_1_DEXPI.xml";
	// "./files/autodesk/2014-10-16 Autodesk_Milestone_1_DEXPI.xml";
	// "./files/autodesk/Milestone_1CBRTES_korrigiert.xml";

	// ---------------------------------------------------------------------------
	// JUNIT
	// "./files/junit_tests_files/testfile01_Epq_SC.xml";
	// "./files/junit_tests_files/testfile02_Epq_SC_Tags.xml";
	// "./files/junit_tests_files/testfile03_Epq_SC_Labels.xml";
	// "./files/junit_tests_files/testfile04_Pipe_SC.xml";
	// "./files/junit_tests_files/testfile05_Epq_SC_ReferenceError.xml";
	// "./files/junit_tests_files/testfile06_Epq_SC_NullPointerExceptions.xml";
	// "./files/junit_tests_files/testfile07_Epq_SC_IndexOutOfBounds.xml";
	// "./files/PA/PA_Test.xml";

	// ---------------------------------------------------------------------------
	// Hackathon 04 - Autodesk - Munich
	"./files/Hackathon04/I01/I01-INTERGRAPH_Post.xml";

	public static String INPUT_FOLDER_NAME = null;
	// "./files/autodesk";
	// "./files/aveva";
	// "./files/AVT Referenz";
	// "./files/intergraph";
	// "./files/siemens";
	// "./files/TestProteusToDexpi";
	// "./files/Sample XML";

	private static Logger logger = LogManager.getLogger(Tester.class.getName());

	public static void main(String[] args) throws Exception {
		if (INPUT_FOLDER_NAME != null) {
			getFileNamesFromFolder();
		} else {
			(new Tester()).startTesting();
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
				INPUT_FILE_NAME = child.getPath();
				if (INPUT_FILE_NAME.endsWith(".xml")
						&& !(INPUT_FILE_NAME.contains("error"))) {
					(new Tester()).startTesting();
				}
			}
		}
	}

	public void startTesting() throws Exception {

		File xmlFile = new File(INPUT_FILE_NAME);
		logger.info("Starting Tester for Graphic Builder.");
		logger.info("Input file: " + INPUT_FILE_NAME);

		// Building image from xmlFile:

		int resolutionX = 4800;

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
		String outputFileName = INPUT_FILE_NAME.replaceAll(".xml", ".png");
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
		generateHTMLWebsite(file.getName(), htmlFileName, imgMap, imgMapName);

		logger.info("Tester finished.");

	}

	@SuppressWarnings("static-method")
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
