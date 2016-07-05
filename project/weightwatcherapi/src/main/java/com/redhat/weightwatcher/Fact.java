package com.redhat.weightwatcher;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"factid", "facttype", "factname","factjson","facttxt"})
public class Fact {

	private int factid;
	private int facttype;
	private String factname;
	private String factjson;
	private String facttxt;
	
	@XmlElement(name="factid")
	public int getFactid() {
		return factid;
	}
	public void setFactid(int factid) {
		this.factid = factid;
	}
	
	//@XmlElement(name="facttype")
	public int getFacttype() {
		return facttype;
	}
	public void setFacttype(int facttype) {
		this.facttype = facttype;
	}
	//@XmlElement(name="factname")
	public String getFactname() {
		return factname;
	}
	public void setFactname(String factname) {
		this.factname = factname;
	}
	
	//@XmlElement(name="factjson")
	public String getFactjson() {
		return factjson;
	}
	public void setFactjson(String factjson) {
		this.factjson = factjson;
	}
	
	//@XmlElement(name="facttxt")
	public String getFacttxt() {
		return facttxt;
	}
	public void setFacttxt(String facttxt) {
		this.facttxt = facttxt;
	}
	
	
}
