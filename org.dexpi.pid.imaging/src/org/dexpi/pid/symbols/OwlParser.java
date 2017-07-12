package org.dexpi.pid.symbols;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * reads in the owl file, parses it and creates symbol classes
 * 
 * @author El Pulpo
 *
 */
public class OwlParser {
	private ArrayList<Symbol> symbols;
	private String owlCode;
	private String inputFolderName;

	public OwlParser(String owlCode, String inputFolderName) {
		this.owlCode = owlCode;
		this.inputFolderName = inputFolderName;
		this.symbols = new ArrayList<Symbol>();

		startParsing();

	}

	/**
	 * returns the symbols created while parsing
	 * 
	 * @return the symbols
	 */
	public ArrayList<Symbol> returnSymbols() {
		return this.symbols;
	}

	private void startParsing() {

		int start = 1;
		while (this.owlCode.indexOf("<Symbol", start) > start) {

			// beginning and end of Symbol
			int a = this.owlCode.indexOf("<Symbol", start);
			int z = this.owlCode.indexOf("</Symbol", a);

			String id = getID(a, z);
			String label = getLabel(a, z);
			String comment = getComment(a, z);

			ArrayList<String> subclass = getSubClassOf(a, z);
			ArrayList<String> repOf = getRepOf(a, z);

			String category = getCategory(a, z);

			String iso10Nr = getIso10628RegNr(a, z);
			String iso14Nr = getIso14617RegNr(a, z);

			ArrayList<String> seeAlso = getSeeAlso(a, z);
			ArrayList<String> intersectionOf = getIntersection(a, z);

			Symbol symbol = new Symbol(id, label, comment, repOf, iso10Nr,
					iso14Nr, subclass, seeAlso, intersectionOf, category);

			this.symbols.add(symbol);
			start = z;

		}
		createHierarchy();
		setXmlCode();

	}

	private void setXmlCode() {
		for (Symbol symbol : this.symbols) {
			try {
				String xmlCode = readFile(this.inputFolderName + "/"
						+ symbol.Iso10RegNr + ".xml");
				symbol.setXmlCode(xmlCode);
			} catch (IOException e) {
				// in case the file is not found
			}
		}
	}

	private void createHierarchy() {
		// sub and superclasses
		for (Symbol symbol : this.symbols) {
			if (symbol.getSubClassOf() != null) {
				for (Symbol parentSymbol : this.symbols) {
					for (String subClassOf : symbol.getSubClassOf()) {
						if (parentSymbol.getID().equals(subClassOf)) {
							symbol.addSuperClass(parentSymbol);
							parentSymbol.addSubClass(symbol);
						}
					}
				}
			}

			// see Also
			// if (symbol.getSeeAlso() != null) {
			// for (Symbol relatedSymbol : symbols) {
			// for (String seeAlso : symbol.getSeeAlso()) {
			// if (relatedSymbol.getID().equals(seeAlso)) {
			// symbol.addRelatedSymbol(relatedSymbol);
			// }
			// }
			// }
			// }

			// intersections
			if (symbol.getIntersectionOf() != null) {
				for (Symbol intersection : this.symbols) {
					for (String intersectionOf : symbol.getIntersectionOf()) {
						if (intersection.getID().equals(intersectionOf)) {
							symbol.addIntersection(intersection);
							intersection.addRelatedSymbol(symbol);
						}
					}
				}
			}
		}

	}

	private String getCategory(int a, int z) {
		String category = "";
		int j = this.owlCode.indexOf("<hasCategory", a);
		j = this.owlCode.indexOf(">", j) + 1;
		int k = this.owlCode.indexOf("<", j);
		if (j > a && k > a && j < z && k < z) {
			category = this.owlCode.substring(j, k);
		}

		return category;
	}

	private String getIso14617RegNr(int a, int z) {
		String iso14Nr = "";
		int j = this.owlCode.indexOf("<hasIso14617_RegNr", a);
		j = this.owlCode.indexOf(">", j) + 1;
		int k = this.owlCode.indexOf("<", j);
		if (j > a && k > a && j < z && k < z) {
			iso14Nr = this.owlCode.substring(j, k);
		}

		return iso14Nr;
	}

	private String getIso10628RegNr(int a, int z) {
		String iso10Nr = "";
		int j = this.owlCode.indexOf("<hasIso10623_RegNr", a);
		j = this.owlCode.indexOf(">", j) + 1;
		int k = this.owlCode.indexOf("<", j);
		if (j > a && k > a && j < z && k < z) {
			iso10Nr = this.owlCode.substring(j, k);
		}
		if (iso10Nr == "") {
			iso10Nr = "none";
		}
		return iso10Nr;
	}

	private ArrayList<String> getRepOf(int a, int z) {
		ArrayList<String> repOf = new ArrayList<String>();

		for (int i = 0; i < 3; i++) {

			int j = this.owlCode.indexOf("<isPossibleRepresentationOf", a);
			j = this.owlCode.indexOf(">", j) + 1;
			int k = this.owlCode.indexOf("<", j);

			if (j > a && k > a && j < z && k < z) {
				repOf.add(this.owlCode.substring(j, k));
				a = k;
			}
		}
		return repOf;
	}

	private ArrayList<String> getSubClassOf(int a, int z) {
		ArrayList<String> subClassOf = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {

			int j = this.owlCode.indexOf("<rdfs:subClassOf", a);
			j = this.owlCode.indexOf("#", j) + 1;
			int k = this.owlCode.indexOf("\"", j);

			if (j > a && k > a && j < z && k < z) {
				subClassOf.add(this.owlCode.substring(j, k));
				a = k;
			}
		}
		return subClassOf;
	}

	private ArrayList<String> getSeeAlso(int a, int z) {
		ArrayList<String> seeAlso = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {

			int j = this.owlCode.indexOf("<rdfs:seeAlso", a);
			j = this.owlCode.indexOf("#", j) + 1;
			int k = this.owlCode.indexOf("\"", j);

			if (j > a && k > a && j < z && k < z) {
				seeAlso.add(this.owlCode.substring(j, k));
				a = k;
			}
		}
		return seeAlso;
	}

	private ArrayList<String> getIntersection(int a, int z) {

		int j = this.owlCode.indexOf("<owl:intersectionOf", a);

		ArrayList<String> intersection = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {

			j = this.owlCode.indexOf("<owl:Class rdf:about=", j);
			j = this.owlCode.indexOf("#", j) + 1;
			int k = this.owlCode.indexOf("\"", j);

			if (j > a && k > a && j < z && k < z) {
				intersection.add(this.owlCode.substring(j, k));
				j = k;
			}
		}

		return intersection;

	}

	private String getComment(int a, int z) {
		String comment = "";
		int j = this.owlCode.indexOf("<rdfs:comment>", a);
		j = this.owlCode.indexOf(">", j) + 1;
		int k = this.owlCode.indexOf("</", j);

		if (j > a && k > a && j < z && k < z) {
			comment = this.owlCode.substring(j, k);
		}
		return comment;
	}

	private String getLabel(int a, int z) {
		String label = "";

		int j = this.owlCode.indexOf("<rdfs:label>", a);
		j = this.owlCode.indexOf(">", j) + 1;
		int k = this.owlCode.indexOf("</", j);

		if (j > a && k > a && j < z && k < z) {
			label = this.owlCode.substring(j, k);
		}
		return label;
	}

	private String getID(int a, int z) {
		String id = "";
		int j = this.owlCode.indexOf("rdf:ID=", a) + 8;
		// j = string.indexOf("\"", j);
		int k = this.owlCode.indexOf("\"", j);
		if (j > a && k > a && j < z && k < z) {
			id = this.owlCode.substring(j, k);
		}

		return id;
	}

	private static String readFile(String file) throws IOException {
		// TODO REWRITE SO WE DO NOT HAVE A POSSIBLE RESOURCE-LEAK
		// TODO URGENT BEFORE WE GO OPEN SOURCE!
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		reader.close();
		return stringBuilder.toString();
	}

}