package org.dexpi.pid.test.testCases;

import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dexpi.pid.test.old.Tester;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestRunnerFiles {
	@SuppressWarnings("unused")
	private static String INPUT_FOLDER_NAME;
	@SuppressWarnings("unused")
	private static String INPUT_FILE_NAME;
	private static String INPUT_FOLDER_AND_FILE_NAME;

	private static Logger logger;

	private static BufferedImage sampleImage;

	//DEFINES
	
	///Choose Choose which kind of DiffImage will be build	
	// private static final ImageComparer.diffImageStyle diffStyle =
	// ImageComparer.diffImageStyle.HARDDIFF;
	// private static final ImageComparer.diffImageStyle diffStyle =
	// ImageComparer.diffImageStyle.OVERLAY;
	// private static final ImageComparer.diffImageStyle diffStyle =
	// ImageComparer.diffImageStyle.NONE;
	private static final ImageComparer.diffImageStyle diffStyle = ImageComparer.diffImageStyle.ALL;

	//ImageSize (small = 1200, 4800 else)
	private static final boolean small = false;
	public static final boolean EXIT_ON_EXCEPTION = false;

	private static int resolutionX = 0;
	private static String sampleImagePath = "";
	private static String PREFIX = "";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (small) {
			resolutionX = 1200;
		} else {
			resolutionX = 4800;
		}
		sampleImagePath = "./files/testCases/sampleMaterial/";
		PREFIX = "sample_" + resolutionX + "_";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//nothing to tear down yet
	}

	@SuppressWarnings("static-method")
	@Before
	public void setUp() throws Exception {
		logger = LogManager.getLogger(Tester.class.getName());
	}

	@SuppressWarnings("static-method")
	@After
	public void tearDown() throws Exception {
		logger = null;
		INPUT_FOLDER_NAME = null;
		INPUT_FILE_NAME = null;
		INPUT_FOLDER_AND_FILE_NAME = null;
		sampleImage = null;
	}
	
	/**
	 * This function is called to compute the test are set to compute the
	 * standard-testCase
	 * 
	 */
	@SuppressWarnings({ "static-method", "unused" })
	private void computeTest(String INPUT_FOLDER_NAME, String INPUT_FILE_NAME) {
		INPUT_FOLDER_AND_FILE_NAME = INPUT_FOLDER_NAME + INPUT_FILE_NAME;
		
		System.out.println(INPUT_FOLDER_AND_FILE_NAME);
		
		try {
			AuxiliaryFunctions.runGBuilder(logger, INPUT_FOLDER_AND_FILE_NAME,
					resolutionX);
		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("Exception! Something went terribly wrong in the GraphicBuilder!");
			if (EXIT_ON_EXCEPTION)
				System.exit(1);
		}

		System.out
				.println("\nSuccesfully run GBuilder - now comparing created image with sampleImage");

		// DEBUG:
		// loadSampleImage((sampleImagePath +
		// "dexpi_best_practice.proteus.xml").replace(

		loadSampleImage((sampleImagePath + PREFIX + INPUT_FILE_NAME).replace(
				".xml", ".png"));

		assertTrue(ImageComparer.compareImageWithImageFile(sampleImage,
				INPUT_FOLDER_NAME, INPUT_FILE_NAME.replace("xml", "png"),
				diffStyle));

		System.out.println("\n ---------------------------- \n");
	}
	
	private static void loadSampleImage(String sampleImageLocation) {
		try {
			sampleImage = ImageIO.read(new File(sampleImageLocation));
		} catch (IOException e) {
			System.out.println("SampleImage could not be read!");
			if (EXIT_ON_EXCEPTION)
				System.exit(1);
		}
	}
}
