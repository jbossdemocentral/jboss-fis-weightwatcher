package com.redhat.weightwatcher.apiobj;


public class Observation {
	
	private int userid;
	
	
	private String obsdate; 
	private String obsname="weight";
	private int obsvalue;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getObsdate() {
		return obsdate;
	}
	public void setObsdate(String obsdate) {
		this.obsdate = obsdate;
	}
	public String getObsname() {
		return obsname;
	}
	public void setObsname(String obsname) {
		this.obsname = obsname;
	}
	public int getObsvalue() {
		return obsvalue;
	}
	public void setObsvalue(int obsvalue) {
		this.obsvalue = obsvalue;
	}
	
	
	

}
