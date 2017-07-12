package org.dexpi.pid.symbols;
/**
 * 
 * @author El Pulpo
 *
 */
public class BuilderTester {
	public static String INPUT_FOLDER_NAME = "./SymbolCatalogue/ProteusXML";

	public static void main(String[] args) throws Exception {

		// create the owl symbol context
		SymbolCatalogueBuilder scBuilder = new SymbolCatalogueBuilder(
				INPUT_FOLDER_NAME);

		// this creates the images
//		 scBuilder.buildSymbolCatalogueImages();

		// use this for creating html
		scBuilder.buildSymbolCatalogueHTML();

	}

}
