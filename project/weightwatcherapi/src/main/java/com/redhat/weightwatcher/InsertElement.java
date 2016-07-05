package com.redhat.weightwatcher;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InsertElement {
	
	private boolean returnObjet=false;
	
	List<Fact> factList;

	@XmlAttribute(name="return-object")
	public boolean isReturnObjet() {
		return returnObjet;
	}

	public void setReturnObjet(boolean returnObjet) {
		this.returnObjet = returnObjet;
	}

	@XmlElement(name="com.redhat.weightwatcher.Fact")
	public List<Fact> getFactList() {
		return factList;
	}

	public void setFactList(List<Fact> factList) {
		this.factList = factList;
	} 

	
	
}
