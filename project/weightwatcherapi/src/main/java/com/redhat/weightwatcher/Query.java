package com.redhat.weightwatcher;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


public class Query {

	private String outIdentifier="Watch" ;
	
	private String name="getWatch";
	
	@XmlAttribute(name="out-identifier")
	public String getOutIdentifier() {
		return outIdentifier;
	}

	public void setOutIdentifier(String outIdentifier) {
		this.outIdentifier = outIdentifier;
	}

	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
