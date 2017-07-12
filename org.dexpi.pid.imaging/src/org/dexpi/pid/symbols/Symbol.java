package org.dexpi.pid.symbols;

import java.util.ArrayList;

public class Symbol {

	public String id;
	public String label;
	public String comment;
	public ArrayList<String> repOf;
	public String Iso10RegNr;
	public String Iso14RegNr;
	public String category;
	public ArrayList<String> subClassOf;
	public ArrayList<String> seeAlso;
	public ArrayList<String> intersectionOf;
	public String xmlCode;

	public ArrayList<Symbol> relatedSymbols;
	public ArrayList<Symbol> superSymbols;
	public ArrayList<Symbol> subSymbols;
	public ArrayList<Symbol> intersections;

	public Symbol(String id, String label, String comment,
			ArrayList<String> repOf, String Iso10RegNr, String Iso14RegNr,
			ArrayList<String> subClassOf, ArrayList<String> seeAlso,
			ArrayList<String> intersectionOf, String category) {
		this.id = id;
		this.label = label;
		this.comment = comment;
		this.repOf = repOf;
		this.Iso10RegNr = Iso10RegNr;
		this.Iso14RegNr = Iso14RegNr;
		this.subClassOf = subClassOf;
		this.seeAlso = seeAlso;
		this.intersectionOf = intersectionOf;
		this.category = category;
	}

	public String getID() {
		return this.id;
	}

	public ArrayList<String> getSubClassOf() {
		return this.subClassOf;
	}

	public ArrayList<String> getSeeAlso() {
		return this.seeAlso;
	}

	public ArrayList<String> getPossibleRepresentations() {
		return this.repOf;
	}

	public ArrayList<String> getIntersectionOf() {
		return this.intersectionOf;
	}

	public void addSubClass(Symbol symbol) {
		if (this.subSymbols == null) {
			this.subSymbols = new ArrayList<Symbol>();
			this.subSymbols.add(symbol);
		} else {
			this.subSymbols.add(symbol);
		}
	}

	public void addRelatedSymbol(Symbol symbol) {
		if (this.relatedSymbols == null) {
			this.relatedSymbols = new ArrayList<Symbol>();
			this.relatedSymbols.add(symbol);
		} else {
			this.relatedSymbols.add(symbol);
		}
	}

	public ArrayList<Symbol> getRelatedSymbols() {
		return this.relatedSymbols;
	}

	public ArrayList<Symbol> getSuperClass() {
		return this.superSymbols;
	}

	public ArrayList<Symbol> getSubClass() {
		return this.subSymbols;
	}

	public void setXmlCode(String xmlCode) {
		this.xmlCode = xmlCode;
	}

	public void addSuperClass(Symbol parentSymbol) {
		if (this.superSymbols == null) {
			this.superSymbols = new ArrayList<Symbol>();
			this.superSymbols.add(parentSymbol);
		} else {
			this.superSymbols.add(parentSymbol);
		}
	}

	public void addIntersection(Symbol intersection) {
		if (this.intersections == null) {
			this.intersections = new ArrayList<Symbol>();
			this.intersections.add(intersection);
		} else {
			this.intersections.add(intersection);
		}

	}

	public ArrayList<Symbol> getIntersections() {
		return this.intersections;
	}
}
