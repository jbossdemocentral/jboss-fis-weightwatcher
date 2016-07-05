package com.redhat.weightwatcher;

import java.util.Date;

public class Observation {
	private String userid;
	private Date obsdate;
	private String obsname;
	private String obsvalue;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getObsdate() {
		return obsdate;
	}
	public void setObsdate(Date obsdate) {
		this.obsdate = obsdate;
	}
	public String getObsname() {
		return obsname;
	}
	public void setObsname(String obsname) {
		this.obsname = obsname;
	}
	public String getObsvalue() {
		return obsvalue;
	}
	public void setObsvalue(String obsvalue) {
		this.obsvalue = obsvalue;
	}
	
	
}
