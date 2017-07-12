package org.dexpi.pid.imaging.builder2;

import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dexpi.pid.imaging.GraphicBuilder;
import org.dexpi.pid.imaging.GraphicFactory;
import org.dexpi.pid.imaging.ImageFactory;
import org.dexpi.pid.imaging.InputRepository;
import org.dexpi.pid.imaging.JaxbErrorLogRepository;
import org.dexpi.pid.imaging.JaxbInputRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GraphicBuilder2Tests {

	private static Logger logger = LogManager.getLogger("GraphicBuilderTester");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		// set listOfFiles
		ArrayList<File> listOfFiles = new ArrayList<File>();
		listOfFiles.add(new File("./files/junit/testfile01_Epq_SC.xml"));
		listOfFiles.add(new File("./files/junit/testfile02_Epq_SC_Tags.xml"));
		listOfFiles.add(new File("./files/junit/testfile03_Epq_SC_Labels.xml"));
		listOfFiles.add(new File("./files/junit/testfile04_Pipe_SC.xml"));

		int resolutionX = 700;

		// create images from xml Files
		for (File xmlFile : listOfFiles) {
			InputRepository inputRep = new JaxbInputRepository(xmlFile);
			GraphicFactory gFac = new ImageFactory();
			JaxbErrorLogRepository errorRep = new JaxbErrorLogRepository(
					xmlFile);
			GraphicBuilder gBuilder = new GraphicBuilder(inputRep, gFac,
					errorRep);

			BufferedImage image = gBuilder.buildImage(resolutionX);

			// Write image
			Iterator<ImageWriter> imageWriters = ImageIO
					.getImageWritersBySuffix("PNG");

			ImageWriter imageWriter = (ImageWriter) imageWriters.next();

			String outputFileName = xmlFile.getPath()
					.replaceAll(".xml", ".png");
			File file = new File(outputFileName);

			// Now we define the output stream
			ImageOutputStream ios = ImageIO.createImageOutputStream(file);
			imageWriter.setOutput(ios);

			// Now start writing the image
			imageWriter.write(image);
		}
	};

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShapeCatalogueReference() {
		// checks if using the shapeCatalogue works (incl rotation)
		logger.debug("Starting comparing images");
		boolean equal = compareImages("./files/junit/testfile01_Epq_SC.png",
				"./files/junit/testfile01_Epq_SC_ref.png");
		logger.debug("Comparison complete");
		if (!equal) {
			fail("Images are not equal");
		}
	}

	@Test
	public void testEquipmentDepAttr() {
		// checks use of dependantAttribute in Epq Tags
		logger.debug("Starting comparing images");
		boolean equal = compareImages(
				"./files/junit/testfile02_Epq_SC_Tags.png",
				"./files/junit/testfile02_Epq_SC_Tags_ref.png");
		logger.debug("Comparison complete");
		if (!equal) {
			fail("Images are not equal");
		}
	}

	@Test
	public void testDepAttrLabel() {
		// checks use of dependantAttribute in Labels
		logger.debug("Starting comparing images");
		boolean equal = compareImages(
				"./files/junit/testfile03_Epq_SC_Labels.png",
				"./files/junit/testfile03_Epq_SC_Labels_ref.png");
		logger.debug("Comparison complete");
		if (!equal) {
			fail("Images are not equal");
		}
	}

	@Test
	public void testPipe() {
		// checks the correct drawing of a PipingNetworkSystem
		logger.debug("Starting comparing images");
		boolean equal = compareImages("./files/junit/testfile04_Pipe_SC.png",
				"./files/junit/testfile04_Pipe_SC_ref.png");
		logger.debug("Comparison complete");
		if (!equal) {
			fail("Images are not equal");
		}
	}

	public boolean compareImages(String file1, String file2) {
		BufferedImage img1;
		BufferedImage img2;
		try {
			img1 = ImageIO.read(new File(file1));
			img2 = ImageIO.read(new File(file2));

			if (img1.getWidth() == img2.getWidth()
					&& img1.getHeight() == img2.getHeight()) {

				for (int x = 0; x < img1.getWidth(); x++) {

					for (int y = 0; y < img1.getHeight(); y++) {

						if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
							return false;
						}
					}
				}
			} else {
				return false;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
}
