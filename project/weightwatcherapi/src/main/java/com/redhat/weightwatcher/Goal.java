package com.redhat.weightwatcher;

public class Goal {
	private String userid;
	private String goalname="weight";
	private String target;
	private String start;
	private String low;
	private String high;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGoalname() {
		return goalname;
	}
	public void setGoalname(String goalname) {
		this.goalname = goalname;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	
	
}
