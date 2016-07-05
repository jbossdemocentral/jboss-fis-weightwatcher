package com.redhat.weightwatcher;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="batch-execution")
@XmlType(propOrder = {"insertElement", "fireallrules", "query"})
public class BatchSession {

	
	private String lookup="watchsession";
	
	private InsertElement insertElement;
	
	
	private FireAllRules fireallrules;
	
	private Query query;

	@XmlAttribute(name="lookup")
	public String getLookup() {
		return lookup;
	}

	public void setLookup(String lookup) {
		this.lookup = lookup;
	}

	@XmlElement(name = "insert-elements")
	public InsertElement getInsertElement() {
		return insertElement;
	}

	public void setInsertElement(InsertElement insertElement) {
		this.insertElement = insertElement;
	}

	@XmlElement(name="fire-all-rules")
	public FireAllRules getFireallrules() {
		return fireallrules;
	}

	public void setFireallrules(FireAllRules fireallrules) {
		this.fireallrules = fireallrules;
	}
	@XmlElement(name="query")
	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
	
	
	
}
