package com.tcs.ilp.iquest.bean;

public class Concept {

	private int conceptId;
	private String concept;
	public Concept(int conceptId, String concept) {
		super();
		this.conceptId = conceptId;
		this.concept = concept;
	}
	public int getConceptId() {
		return conceptId;
	}
	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	
	
}
