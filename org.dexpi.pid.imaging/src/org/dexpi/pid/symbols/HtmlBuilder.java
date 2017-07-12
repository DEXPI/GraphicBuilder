package org.dexpi.pid.symbols;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * The HtmlBuilder is used to generate all html pages. It creates a main page,
 * category pages, a help page, a page containing an alphabetical listing of all
 * symbol names and a page containing all iso10628 registration numbers. Further
 * a page for every symbol, containing all information an image and the xml
 * code, is generated.
 * 
 * 
 * @author phbe01
 *
 */
public class HtmlBuilder {

	private ArrayList<Symbol> symbols;
	private String htmlHeader;
	private String htmlFooter;

	public HtmlBuilder(ArrayList<Symbol> symbols, String htmlHeader,
			String htmlFooter) throws FileNotFoundException {
		this.symbols = symbols;
		this.htmlHeader = htmlHeader;
		this.htmlFooter = htmlFooter;
	}

	/**
	 * Generates all html pages. The symbol's page will be named after the
	 * iso10628 registration number. If it doesn't exist, the symbol's label
	 * will be used.
	 * 
	 * @param INPUT_FOLDER_NAME
	 *            the folder where the xml files and images are located
	 * @throws FileNotFoundException
	 *             exception thrown
	 */
	public void buildHtml(String INPUT_FOLDER_NAME)
			throws FileNotFoundException {

		// create a page for every symbol
		for (Symbol symbol : this.symbols) {
			if (symbol.Iso10RegNr != "none") {
				generateSymbolHtml(symbol, INPUT_FOLDER_NAME + "/"
						+ symbol.Iso10RegNr + ".html");
			} else {
				generateSymbolHtml(symbol, INPUT_FOLDER_NAME + "/"
						+ symbol.label + ".html");
			}
		}
		// create main page
		generateMainPage();
		generateHelpPage();
		generateAlphabeticalList();
		generateIso10628List();
	}

	/**
	 * creates a link in html format
	 * 
	 * @param path
	 *            the path of the link
	 * @param name
	 *            the name to be displayed
	 * @return the html link
	 */
	@SuppressWarnings("static-method")
	private String createLink(String path, String name) {
		String html = "<a href=\"";
		html += path;
		if (!(path.contains(".html"))) {
			html += ".html";
		}
		html += "\">";
		html += name + "</a>";
		return html;
	}

	/**
	 * Creates a page with all iso10628 registration numbers (and links to the
	 * corresponding symbol page) in ascending order.
	 * 
	 * @throws FileNotFoundException
	 */
	private void generateIso10628List() throws FileNotFoundException {
		String html = this.htmlHeader;
		html += "   <div id=\"singlemain\">";
		html += addBackAndHelpLink();
		html += "<br/>";
		html += "<h1>List of ISO 10628 registration numbers</h1>";

		ArrayList<String> iso10 = new ArrayList<String>();
		// table entry for each symbol
		for (Symbol symbol : this.symbols) {
			iso10.add(symbol.Iso10RegNr);
		}
		Collections.sort(iso10);

		for (String iso10nr : iso10) {
			for (Symbol symbol : this.symbols) {
				if (iso10nr.equals(symbol.Iso10RegNr)) {
					if (!(symbol.Iso10RegNr == "none")) {
						html += "<p>"
								+ createLink(symbol.Iso10RegNr,
										symbol.Iso10RegNr) + "</p>";
						// html += "<p><a href=\"" + symbol.Iso10RegNr + ".html"
						// + "\">" + symbol.Iso10RegNr + "</a></p>";
					}
				}
			}
		}
		html += "</div>";
		html += this.htmlFooter;

		try (PrintWriter out = new PrintWriter(
				"./SymbolCatalogue/ProteusXml/iso10628List.html")) {
			out.println(html);
		}

	}

	/**
	 * Generates a page with all symbol names (and links to the corresponding
	 * symbol) in alphabetical order.
	 * 
	 * @throws FileNotFoundException
	 */
	private void generateAlphabeticalList() throws FileNotFoundException {
		String html = this.htmlHeader;
		html += "   <div id=\"singlemain\">";
		html += addBackAndHelpLink();
		html += "<br/>";
		html += "<h1>Alphabetical list</h1>";

		ArrayList<String> names = new ArrayList<String>();
		// table entry for each symbol
		for (Symbol symbol : this.symbols) {
			names.add(symbol.label);
		}
		Collections.sort(names);

		for (String name : names) {
			for (Symbol symbol : this.symbols) {
				if (name.equals(symbol.label)) {
					html += "<p>" + addClassLink(symbol) + "</p>";
				}
			}
		}
		html += "</div>";
		html += this.htmlFooter;

		try (PrintWriter out = new PrintWriter(
				"./SymbolCatalogue/ProteusXml/alphabeticalList.html")) {
			out.println(html);
		}
	}

	/**
	 * Generates the help page.
	 * 
	 * @throws FileNotFoundException
	 */
	private void generateHelpPage() throws FileNotFoundException {
		String html = this.htmlHeader;
		html += "   <div id=\"singlemain\">";
		// String html =
		// "<html>\n<head>\n<title>Help</title>\n</head>\n<body>\n";

		html += addBackAndHelpLink();
		html += "<br/>";
		html += "<h1>Help and information</h1>";
		html += "<br/>";
		html += "<img src=\"" + "../needHelp.png" + "\">\n";

		html += "<p><b>Description:</b> Here a short description and alternative names are listed.</p>";
		html += "<p><b>Possible representation:</b> Objects in the posccaesar database that "
				+ "can be represented by this symbol.</br> Please note, that a symbol can represent multiple objects.</p>";
		html += "<p><b>ISO10628 registration number:</b>  The registration number under "
				+ "which the symbol is listed in the DIN ISO 10628.</p>";
		html += "<p><b>ISO14617 registration number:</b>  The registration number under "
				+ "which the symbol is listed in the DIN ISO 14617.</p>";

		html += "<p><b>See also:</b>  Similiar symbols or examples.</p>";
		html += "<p><b>Intersection of:</b>  The symbol is characterized by the intersection of two or more classes.</br>"
				+ "For example prosecco could be described as the intersection of sparkling wine, "
				+ "the glera grape and the italian region Veneto.</p>";
		html += "<p><b>SubClasses:</b>  More specialized symbols.</p>";
		html += "<p><b>SuperClasses:</b>  More general symbols.</p>";
		html += "<p><b>ProteusXml 3.6.0 Code:</b>  The xml code to draw this symbol in the GraphicBuilder.</br>"
				+ "To use the symbol in a ProteusXml plant file, the code has to be copied to the ShapeCatalogue and referenced via the ComponentName.</p>";
		html += "</div>";
		html += this.htmlFooter;

		try (PrintWriter out = new PrintWriter(
				"./SymbolCatalogue/ProteusXml/help.html")) {
			out.println(html);
		}
	}

	/**
	 * Loops through the symbols and gets all categories.
	 * 
	 * @return list of categories in alphabetical order
	 */
	private ArrayList<String> getCategories() {
		ArrayList<String> categories = new ArrayList<String>();

		for (Symbol symbol : this.symbols) {
			if (!(categories.contains(symbol.category))) {
				categories.add(symbol.category);
			}
		}
		Collections.sort(categories);
		return categories;

	}

	/**
	 * Generates the index.html page.
	 * 
	 * @throws FileNotFoundException
	 */
	private void generateMainPage() throws FileNotFoundException {

		String html = this.htmlHeader;
		html += "   <div id=\"singlemain\">";
		html += "\n<table style=\"width:100%\">\n";

		html += addAlphabeticalAndISO10ListLink();
		html += "<br/>";
		html += "<h1>ISO 10628 and ISO 14617 symbol catalogue</h1>";
		html += "<p>The aim of this symbol catalogue is, to ensure and support the uniform and unambigous usage "
				+ "of the ISO 10628 and ISO 14617 graphic symbols, as required by the standards of the ISO 15926. "
				+ "The catalogue provides the ProteusXML3.6.0 code equivalent to the graphic symbols of the ISO norms"
				+ " along with the corresponding references to the Posccaesar RDL.</p>";
		// table headers
		html += "<tr>\n<th>Categories</th>\n</tr>";

		for (String category : getCategories()) {

			html += "<tr>\n";

			html += "<td>";
			html += "<a href=\"" + "./ProteusXml/"
					+ (category.replaceAll(" ", "")).replaceAll(",", "")
					+ ".html" + "\">" + category + "</a>";
			html += "</td>\n";

			html += "</tr>";

			generateCategoryPage(category);
		}

		html += "\n</table>\n";
		html += "</div>";
		html += this.htmlFooter;

		try (PrintWriter out = new PrintWriter("./SymbolCatalogue/index.html")) {
			out.println(html);
		}
	}

	/**
	 * Generates a category page containing all symbols of that category.
	 * 
	 * @param category
	 *            the category
	 * @throws FileNotFoundException
	 */
	private void generateCategoryPage(String category)
			throws FileNotFoundException {

		String html = this.htmlHeader;
		html += "   <div id=\"singlemain\">";
		html += "<table style=\"width:100%\">\n";
		html += addBackAndHelpLink();
		html += "<br/>";
		html += "<h1>" + category + "</h1>";
		html += "<br/>";
		// table headers
		html += "<tr>\n<th>Name</th>\n<th>ISO10628-RegNr</th>\n";
		html += "<th>ISO14617-RegNr</th>\n";
		html += "<th>Possible representations</th>\n<th>Symbol</th>\n</tr>";

		// table entry for each symbol
		for (Symbol symbol : this.symbols) {
			// loop through the subsymbols to list them accordingly

			if (symbol.category.equals(category)) {
				html = createTable(html, symbol);
			}

		}
		html += "\n</table>\n";
		html += "</div>";
		html += this.htmlFooter;

		try (PrintWriter out = new PrintWriter("./SymbolCatalogue/ProteusXml/"
				+ (category.replaceAll(" ", "")).replaceAll(",", "") + ".html")) {
			out.println(html);
		}
	}

	/**
	 * Adds a table entry for a symbol to the html code.
	 * 
	 * @param html
	 *            the html code
	 * @param symbol
	 *            the symbol
	 * @return the modified html code
	 */
	private String createTable(String html, Symbol symbol) {

		html += "<tr>\n";

		html += "<td>" + addClassLink(symbol) + "</td>\n";

		html += "</td>";

		html += "<td>" + addIso10Number(symbol) + "</td>\n";
		html += "<td>" + addIso14Number(symbol) + "</td>\n";
		// html += "<td>" + addComment(symbol) + "</td>\n";
		html += "<td><nobr>" + addPossibleRepresentations(symbol)
				+ "</nobr></td>\n";
		html += "<td>" + addImage(symbol) + "</td>\n";
		html += "</tr>";
		return html;
	}

	/**
	 * Creates a link to a symbol's page.
	 * 
	 * @param symbol
	 * @return
	 */
	private String addClassLink(Symbol symbol) {
		String html = "";
		if (symbol.Iso10RegNr == "none") {
			html += createLink(symbol.label, symbol.label);
			// html += "<a href=\"" + symbol.label + ".html" + "\">"
			// + symbol.label + "</a>";
		} else {
			html += createLink(symbol.Iso10RegNr, symbol.label);
			// html += "<a href=\"" + symbol.Iso10RegNr + ".html" + "\">"
			// + symbol.label + "</a>";
		}
		return html;

	}

	/**
	 * generates the html page for a symbol
	 * 
	 * @param symbol
	 *            the symbol
	 * @param htmlFileName
	 *            the file name
	 * @throws FileNotFoundException
	 */
	private void generateSymbolHtml(Symbol symbol, String htmlFileName)
			throws FileNotFoundException {

		String html = this.htmlHeader;
		html += "   <div id=\"singlemain\">";
		html += addBackAndHelpLink();
		html += "<br/>";
		html += "<h1>" + symbol.label + "</h1>\n";
		html += "<p><b>Description: </b>" + addComment(symbol) + "</p>\n";
		html += "<p><b>Possible representation of: </b>"
				+ addPossibleRepresentations(symbol) + "</p>\n";

		html += "<p><b>ISO10628 registration number: </b>"
				+ addIso10Number(symbol) + "</p>\n";
		html += "<p><b>ISO14617 registration number: </b>"
				+ addIso14Number(symbol) + "</p>\n";

		html += "<br/>";
		html += "<br/>";
		html += addImage(symbol);
		html += "<br/>";
		html += "<br/>";
		html += "<br/>";
		html += addSuperClassLinks(symbol);
		html += addSubClassLinks(symbol);
		html += addIntersectionLinks(symbol);
		// remove related symbols - use intersection instead?
		html += addRelatedSymbolLinks(symbol);
		html += "<br/>";
		html += "<br/>";
		html += "<br/>";
		if (symbol.xmlCode != null) {
			String xmlCode = createHtmlEntities(symbol.xmlCode);

			html += "<p><b>ProteusXml 3.6.0 code: </b></p>" + "<pre><code>"
					+ xmlCode + "</code></pre>\n";
		}
		html += "</div>";
		html += this.htmlFooter;

		try (PrintWriter out = new PrintWriter(htmlFileName)) {
			out.println(html);
		}
	}

	/**
	 * makes < and > html compatible
	 * 
	 * @param xmlCode
	 * @return
	 */
	@SuppressWarnings("static-method")
	private String createHtmlEntities(String xmlCode) {
		// escape < and > inside the pre element
		xmlCode = xmlCode.replaceAll("<", "&lt;");
		xmlCode = xmlCode.replaceAll(">", "&gt;");
		return xmlCode;
	}

	/**
	 * adds links for an intersection
	 * 
	 * @param symbol
	 *            the symbol
	 * @return html link
	 */
	private String addIntersectionLinks(Symbol symbol) {
		String html = "";
		if (symbol.getIntersections() != null) {

			html += "<p><b>Intersection of: </b>";
			html += "<br/>";

			for (Symbol intersection : symbol.getIntersections()) {
				if (intersection.Iso10RegNr == "none") {
					html += createLink(intersection.label, intersection.label)
							+ "<br/>";
				} else {
					html += createLink(intersection.Iso10RegNr,
							intersection.label) + "<br/>";
				}
			}
			html += "</p>\n";
		}
		return html;
	}

	/**
	 * adds a link for related symbols
	 * 
	 * @param symbol
	 *            the symbol
	 * @return the html link
	 */
	private String addRelatedSymbolLinks(Symbol symbol) {
		String html = "";
		if (symbol.getRelatedSymbols() != null) {

			html += "<p><b>See also: </b>";

			if (symbol.getRelatedSymbols().size() > 1) {
				html += "<br/>";
			}
			for (Symbol relatedSymbol : symbol.getRelatedSymbols()) {
				if (relatedSymbol.Iso10RegNr == "none") {
					html += createLink(relatedSymbol.label, relatedSymbol.label)
							+ "<br/>";
				} else {
					html += createLink(relatedSymbol.Iso10RegNr,
							relatedSymbol.label) + "<br/>";
				}
			}
			html += "</p>\n";
		}
		return html;
	}

	/**
	 * adds a link for main page and help page
	 * 
	 * @return two html links in one string
	 */
	@SuppressWarnings("static-method")
	private String addBackAndHelpLink() {
		String html = "";
		html += "<a href=\"../index.html\">Back to main page</a> &nbsp &nbsp <a href=\"help.html\">Help</a> </p>";

		return html;

	}

	/**
	 * adds a link to the alphabetical list of symbol
	 * 
	 * @return the link
	 */
	@SuppressWarnings("static-method")
	private String addAlphabeticalAndISO10ListLink() {
		String html = "";
		html += "<a href=\"./ProteusXml/alphabeticalList.html\">Alphabetical list</a> &nbsp &nbsp<a href=\"./ProteusXml/iso10628List.html\">ISO10628RegNr list</a> &nbsp &nbsp <a href=\"./ProteusXml/help.html\">Help</a> </p>";

		return html;
	}

	/**
	 * checks if a symbol has a comment and adds it
	 * 
	 * @param symbol
	 *            the symbol
	 * @return the comment
	 */
	@SuppressWarnings("static-method")
	private String addComment(Symbol symbol) {
		String html = "";
		if (symbol.comment == "") {
			html = "-";
		} else {
			html = symbol.comment;
		}
		return html;
	}

	@SuppressWarnings("static-method")
	private String addIso10Number(Symbol symbol) {
		String html = "";
		if (symbol.Iso10RegNr == "none" || symbol.Iso10RegNr == "") {
			html = "-";
		} else {
			html = symbol.Iso10RegNr;
		}
		return html;
	}

	@SuppressWarnings("static-method")
	private String addIso14Number(Symbol symbol) {
		String html = "";
		if (symbol.Iso14RegNr == "none" || symbol.Iso14RegNr == "") {
			html = "-";
		} else {
			html = symbol.Iso14RegNr;
		}
		return html;
	}

	@SuppressWarnings("static-method")
	private String addImage(Symbol symbol) {
		String html = "";
		// if the symbol has an image
		if (symbol.Iso10RegNr != "none") {
			html += "<img src=\"" + (symbol.Iso10RegNr) + ".png" + "\">\n";
		}
		return html;
	}

	@SuppressWarnings("static-method")
	private String addPossibleRepresentations(Symbol symbol) {
		String html = "";
		int size = symbol.getPossibleRepresentations().size();

		for (String repOf : symbol.getPossibleRepresentations()) {
			// html += createLink(repOf, repOf);
			html += "<a href=\"" + repOf + "\">" + repOf + "</a>";
			if (size > 1) {
				html = "<p>" + html + "</p>";
			}

		}

		return html;
	}

	/**
	 * loops through superclasses and adds a link for every superclass
	 * 
	 * @param symbol
	 *            the symbol
	 * @return the links
	 */
	private String addSuperClassLinks(Symbol symbol) {
		String html = "";

		if (symbol.getSuperClass() != null) {
			html += "<p><b>SuperClasses: </b>";

			if (symbol.getSuperClass().size() > 1) {
				html += "<br/>";
			}
			for (Symbol superSymbol : symbol.getSuperClass()) {
				if (superSymbol.Iso10RegNr == "none") {
					html += createLink(superSymbol.label, superSymbol.label);
					// html += "<a href=\"" + superSymbol.label + ".html" +
					// "\">"
					// + superSymbol.label + "</a>";
				} else {
					html += createLink(superSymbol.Iso10RegNr,
							superSymbol.label);
					// html += "<a href=\"" + superSymbol.Iso10RegNr + ".html"
					// + "\">" + superSymbol.label + "</a>";
				}
				if (superSymbol.getSuperClass() != null) {
					for (Symbol super2Symbol : superSymbol.getSuperClass()) {
						html += createSuperClassLink(super2Symbol);
						if (super2Symbol.getSuperClass() != null) {
							for (Symbol super3Symbol : super2Symbol
									.getSuperClass()) {
								html += createSuperClassLink(super3Symbol);
								if (super3Symbol.getSuperClass() != null) {
									for (Symbol super4Symbol : super3Symbol
											.getSuperClass()) {
										html += createSuperClassLink(super4Symbol);
										if (super4Symbol.getSuperClass() != null) {
											for (Symbol super5Symbol : super4Symbol
													.getSuperClass()) {
												html += createSuperClassLink(super5Symbol);
											}
										}
									}
								}
							}
						}
					}
				}

				html += "<br/>";
			}
			html += "</p>\n";
		}
		return html;
	}

	@SuppressWarnings("static-method")
	private String createSuperClassLink(Symbol superSymbol) {
		String html = "";
		if (superSymbol.Iso10RegNr == "none") {
			html = "&nbsp>&nbsp<a href=\"" + superSymbol.label + ".html"
					+ "\">" + superSymbol.label + "</a>";
		} else {
			html = "&nbsp>&nbsp<a href=\"" + superSymbol.Iso10RegNr + ".html"
					+ "\">" + superSymbol.label + "</a>";
		}
		return html;
	}

	/**
	 * adds a link for a symbols subclass
	 * 
	 * @param symbol
	 *            the symbol
	 * @return the link
	 */
	@SuppressWarnings("static-method")
	private String addSubClassLinks(Symbol symbol) {
		String html = "";
		if (symbol.getSubClass() != null) {

			html += "<p><b>SubClasses: </b>";

			if (symbol.getSubClass().size() > 1) {
				html += "<br/>";
			}
			for (Symbol subSymbol : symbol.getSubClass()) {
				if (subSymbol.Iso10RegNr == "none") {
					html += "<a href=\"" + subSymbol.label + ".html" + "\">"
							+ subSymbol.label + "</a><br/>";
				} else {
					html += "<a href=\"" + subSymbol.Iso10RegNr + ".html"
							+ "\">" + subSymbol.label + "</a><br/>";
				}
			}
			html += "</p>\n";
		}
		return html;
	}

}
