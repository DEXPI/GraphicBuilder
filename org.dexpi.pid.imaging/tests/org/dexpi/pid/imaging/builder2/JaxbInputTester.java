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
import org.dexpi.pid.imaging.InputRepository;
import org.dexpi.pid.imaging.JaxbInputRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JaxbInputTester {
	public InputRepository inputRep;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		File xmlFile = new File(
				"./files/AVT Referenz/DexpiBestPracticeV0.9.xml");
		this.inputRep = new JaxbInputRepository(xmlFile);
		inputRep.init();
	};

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		if (inputRep.getZeroPoint() == null) {
			fail("getting zero point failed");
		}
		if(inputRep.getSize()==null){
			fail("getting drawing size failed");
		}
	}
}
