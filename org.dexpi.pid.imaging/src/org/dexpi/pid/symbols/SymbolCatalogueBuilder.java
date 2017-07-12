package org.dexpi.pid.symbols;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

/**
 * 
 * @author phbe01
 *
 *
 */
public class SymbolCatalogueBuilder {

	public String INPUT_FILE_OWL = "./symbolCatalogue/OWL_Schnittstelle.xml";

	public String INPUT_XML_HEADER = "./symbolCatalogue/xmlHeader.xml";
	public String INPUT_XML_FOOTER = "./symbolCatalogue/xmlFooter.xml";

	public String HTML_HEADER = "./symbolCatalogue/header.tpl.html";
	public String HTML_FOOTER = "./symbolCatalogue/footer.tpl.html";

	public ArrayList<Symbol> symbols;

	public HtmlBuilder htmlBuilder;
	public XmlAndPngBuilder xmlBuilder;

	private String inputFolderName;

	public SymbolCatalogueBuilder(String inputFolderName) throws IOException {

		this.inputFolderName = inputFolderName;
		// set xmlBuilder
		this.xmlBuilder = new XmlAndPngBuilder(this.INPUT_XML_HEADER,
				this.INPUT_XML_FOOTER);

		// Parse and set owl
		String owlCode = readFile(this.INPUT_FILE_OWL);
		OwlParser owlParser = new OwlParser(owlCode, inputFolderName);
		this.symbols = owlParser.returnSymbols();

		// set htmlBuilder
		String htmlHeader = readFile(this.HTML_HEADER);
		String htmlFooter = readFile(this.HTML_FOOTER);
		this.htmlBuilder = new HtmlBuilder(this.symbols, htmlHeader, htmlFooter);

	}

	/**
	 * 
	 * @throws IOException
	 *             exception thrown
	 * @throws JAXBException
	 *             exception thrown
	 * @throws XMLStreamException
	 *             exception thrown
	 */
	public void buildSymbolCatalogueImages() throws IOException, JAXBException,
			XMLStreamException {
		String INPUT_XML_SYMBOL;

		// get all files from folder
		File dir = new File(this.inputFolderName);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				INPUT_XML_SYMBOL = child.getPath();
				if (INPUT_XML_SYMBOL.endsWith(".xml")
						&& !(INPUT_XML_SYMBOL.contains("error"))
						&& !(INPUT_XML_SYMBOL).contains("temp")) {

					// create XML and Image
					this.xmlBuilder.createXMLFile(INPUT_XML_SYMBOL);
					this.xmlBuilder.buildImage(INPUT_XML_SYMBOL);

				}
			}
		}
	}

	public void buildSymbolCatalogueHTML() throws FileNotFoundException {
		// create html
		this.htmlBuilder.buildHtml(this.inputFolderName);
	}

	private static String readFile(String file) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String ls = System.getProperty("line.separator");

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		}
		return stringBuilder.toString();
	}

}
