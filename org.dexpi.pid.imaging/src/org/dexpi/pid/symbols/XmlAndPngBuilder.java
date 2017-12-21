package org.dexpi.pid.symbols;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import org.dexpi.pid.imaging.GraphicBuilder;
import org.dexpi.pid.imaging.GraphicBuilderImageWriteListener;
import org.dexpi.pid.imaging.GraphicFactory;
import org.dexpi.pid.imaging.ImageFactory_PNG;
import org.dexpi.pid.imaging.InputRepository;
import org.dexpi.pid.imaging.JaxbErrorLogRepository;
import org.dexpi.pid.imaging.JaxbInputRepository;

/**
 * 
 * @author phbe01
 * 
 *         Reads in the xml code of a symbol and creates a temporary plantModel
 *         file to draw the image. The image is trimmed to remove unnecessary
 *         white space.
 *
 */
public class XmlAndPngBuilder {

	public String INPUT_XML_HEADER;
	public String INPUT_XML_FOOTER;

	public static String OUTPUT_FILE_TEMP;

	public XmlAndPngBuilder(String INPUT_XML_HEADER, String INPUT_XML_FOOTER) {
		this.INPUT_XML_HEADER = INPUT_XML_HEADER;
		this.INPUT_XML_FOOTER = INPUT_XML_FOOTER;

	}

	/**
	 * Creates the temporary plantModel xml file by joining header, footer and
	 * symbol. The symbol is written to the shapeCatalogue and referenced by its
	 * componentName in the footer.
	 * 
	 * @param INPUT_XML_SYMBOL
	 *            the symbol to be drawn
	 * @throws IOException
	 *             exception thrown
	 */
	public void createXMLFile(String INPUT_XML_SYMBOL) throws IOException {

		// creates isoxxxx-xxx_temp.xml
		OUTPUT_FILE_TEMP = INPUT_XML_SYMBOL.replace(".xml", "_temp.xml");

		// get Symbol
		String xmlSymbol = readFile(INPUT_XML_SYMBOL);

		// get ComponentName
		int i = xmlSymbol.indexOf("ComponentName=") + 15;
		int j = xmlSymbol.indexOf("\"", i);
		String componentName = xmlSymbol.substring(i, j);

		// get basic file stuff
		String xmlHeader = readFile(this.INPUT_XML_HEADER);
		String xmlBottom = readFile(this.INPUT_XML_FOOTER).replace("abc", componentName);

		// create the new file
		writeStringToFile(
				xmlHeader + "\n" + xmlSymbol + "\n" + "</ShapeCatalogue>" + "\n" + xmlBottom + "\n" + "</PlantModel>");
	}

	/**
	 * Draws the created temporary xml file via the GraphicBuilder.
	 * 
	 * @param INPUT_XML_SYMBOL
	 *            the symbol to be drawn, only used for naming the image
	 * @throws IOException
	 *             exception thrown
	 * @throws JAXBException
	 *             exception thrown
	 * @throws XMLStreamException
	 *             exception thrown
	 */
	public void buildImage(String INPUT_XML_SYMBOL) throws IOException, JAXBException, XMLStreamException {

		File xmlFile = new File(OUTPUT_FILE_TEMP);

		String outputFileName = (INPUT_XML_SYMBOL).replaceAll(".xml", ".png");
		

		int resolutionX = 500;
		JaxbErrorLogRepository errorRep = new JaxbErrorLogRepository(xmlFile);
		InputRepository inputRep = new JaxbInputRepository(xmlFile);
		GraphicFactory gFac = new ImageFactory_PNG();
		GraphicBuilder gBuilder = new GraphicBuilder(inputRep, gFac, errorRep);
		BufferedImage image = gBuilder.buildImage(resolutionX, outputFileName);
		image = trim(image);

		// Writing image now:

		// Get all possible Image Writers that are actually available for the
		// type PNG
		Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersBySuffix("PNG");

		// Ok, we need the output file of course
		File file = new File(outputFileName);
		
		// select the first found Writer
		ImageWriter imageWriter = (ImageWriter) imageWriters.next();

		// Now we define the output stream
		try (ImageOutputStream ios = ImageIO.createImageOutputStream(file)) {
			imageWriter.setOutput(ios);

			// Here we add the Listener which reports to the logger, so we can
			// see
			// the progress
			imageWriter.addIIOWriteProgressListener(new GraphicBuilderImageWriteListener());

			// Now start writing the image
			imageWriter.write(image);
		}

		// delete errorLog and output_file_temp
		String errorLog = OUTPUT_FILE_TEMP.replace(".xml", ".graphic_errors.xml");
		File tempErrorLogFile = new File(errorLog);
		tempErrorLogFile.delete();

		xmlFile.delete();

	}

	/**
	 * trims the image to remove white space around symbols (leaves 5px at each
	 * side)
	 * 
	 * @param img
	 *            the image to be trimmed
	 * @return the trimmed image
	 */
	public BufferedImage trim(BufferedImage img) {
		// point zero is upper left corner
		int xMin = getXmin(img); // the left border of the symbol
		int xMax = getXmax(img); // the right border of the symbol
		int yMin = getYmin(img); // the upper border of the symbol
		int yMax = getYmax(img); // the lower border of the symbol

		BufferedImage newImg = new BufferedImage(xMax - xMin + 10, yMax - yMin + 10, BufferedImage.TYPE_INT_RGB);
		Graphics g = newImg.createGraphics();
		g.drawImage(img, -xMin + 5, -yMin + 5, null);
		img = newImg;
		return img;
	}

	/**
	 * gets the left border of the image
	 * 
	 * @param img
	 *            the image
	 * @return trimmedWidth
	 */
	@SuppressWarnings("static-method")
	private int getXmin(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		int trimmedWidth = width;
		// returns right border
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (img.getRGB(j, i) != Color.WHITE.getRGB() && j < trimmedWidth) {
					trimmedWidth = j;
				}
			}
		}
		return trimmedWidth;
	}

	/**
	 * gets the right border of the image
	 * 
	 * @param img
	 *            the image
	 * @return trimmedWidth
	 */
	@SuppressWarnings("static-method")
	private int getXmax(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		int trimmedWidth = 0;
		for (int i = 0; i < height; i++) {
			for (int j = width - 1; j >= 0; j--) {
				if (img.getRGB(j, i) != Color.WHITE.getRGB() && j > trimmedWidth) {
					trimmedWidth = j;
					break;
				}
			}
		}
		return trimmedWidth;
	}

	/**
	 * gets the upper border of the image (x,y=0,0 is the upper left corner)
	 * 
	 * @param img
	 *            the image
	 * @return trimmedHeight
	 */
	@SuppressWarnings("static-method")
	private int getYmin(BufferedImage img) {
		int width = img.getWidth();
		int height = img.getHeight();
		int trimmedHeight = height;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (img.getRGB(i, j) != Color.WHITE.getRGB() && j < trimmedHeight) {
					trimmedHeight = j;
				}
			}
		}
		return trimmedHeight;
	}

	/**
	 * gets the lower border of the image (x,y=0,0 is the upper left corner)
	 * 
	 * @param img
	 *            the image
	 * @return trimmedHeight
	 */
	@SuppressWarnings("static-method")
	private int getYmax(BufferedImage img) {
		int width = img.getWidth();
		int height = img.getHeight();
		int trimmedHeight = 0;
		for (int i = 0; i < width; i++) {
			for (int j = height - 1; j >= 0; j--) {
				if (img.getRGB(i, j) != Color.WHITE.getRGB() && j > trimmedHeight) {
					trimmedHeight = j;
					break;
				}
			}
		}
		return trimmedHeight;
	}

	/**
	 * reads a file and saves content as a string
	 * 
	 * @param file
	 *            the file
	 * @return the string
	 * @throws IOException
	 */
	private static String readFile(String file) throws IOException {

		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		}

		return stringBuilder.toString();
	}

	/**
	 * creates a new file and writes the string to it.
	 * 
	 * @param string
	 *            the string
	 */
	private static void writeStringToFile(String string) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_TEMP))) {
			writer.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
