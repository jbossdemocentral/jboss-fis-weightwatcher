package com.redhat.weightwatcher.apiobj;

public class Goal {
	
	private int userid;
	private String goalname="weight";
	private int target = 0;
	private int start = 0;
	private int low = 0;
	private int high = 0;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getGoalname() {
		return goalname;
	}
	public void setGoalname(String goalname) {
		this.goalname = goalname;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	
	
}
