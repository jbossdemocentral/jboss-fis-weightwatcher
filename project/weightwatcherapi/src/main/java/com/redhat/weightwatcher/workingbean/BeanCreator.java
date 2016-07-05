package com.redhat.weightwatcher.workingbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.redhat.weightwatcher.BatchSession;
import com.redhat.weightwatcher.Fact;
import com.redhat.weightwatcher.FireAllRules;
import com.redhat.weightwatcher.InsertElement;
import com.redhat.weightwatcher.Query;
import com.redhat.weightwatcher.apiobj.Goal;
import com.redhat.weightwatcher.apiobj.Observation;
import com.redhat.weightwatcher.apiobj.Participant;



public class BeanCreator {
	
	private Map<Integer, Participant> participantPool = new HashMap<Integer, Participant>();
	private Map<Integer, Goal> goalPool = new HashMap<Integer, Goal>();
	private Map<Integer, List<Observation>> oboservationPool = new HashMap<Integer, List<Observation>>();
	
	private Map<Integer, String> participantFactJson = new HashMap<Integer, String>();
	private Map<Integer, String> goalFactJson = new HashMap<Integer, String>();
	private Map<Integer, List<String>> oboservationFactJson= new HashMap<Integer, List<String>>();
	
	
	public Participant addParticipant (int userId, String userName){
		System.out.println("userId:["+userId+"]");
		System.out.println("userName:["+userName+"]");
		Participant theParticipant = participantPool.get(userId);
		if(theParticipant == null){
			theParticipant = new Participant();
			theParticipant.setUserId(userId);
		}
		
		theParticipant.setUserName(userName);
		
		participantPool.put(userId,theParticipant);
		
		return theParticipant;
	}
	
	public void setParticipantFactJson(int userid, String factjson){
		participantFactJson.put(userid, factjson);
	}

	
	public Goal addGoal (int userid,int target,int start, int low ,int high){
		
		
		Goal theGoal = goalPool.get(userid);
		if(theGoal == null){
			theGoal = new Goal();
			theGoal.setUserid(userid);
		}
		
		theGoal.setTarget(target);
		theGoal.setStart(start);
		theGoal.setStart(start);
		theGoal.setLow(low);
		theGoal.setHigh(high);
		
		goalPool.put(userid,theGoal);
		
		return theGoal;
	}
	public void setGoalFactJson(int userid, String factjson){
		goalFactJson.put(userid, factjson);
	}
	
	public Observation addObservation (int userid,String obsdate, int obsvalue){
		
		List<Observation> theObservationList = oboservationPool.get(userid);
		if(theObservationList == null){
			theObservationList = new ArrayList<Observation>();
			
		}
		Observation theObservation = new Observation();
		theObservation.setUserid(userid);
		theObservation.setObsvalue(obsvalue);
		theObservation.setObsdate(obsdate);
		
		theObservationList.add(theObservation);
		oboservationPool.put(userid,theObservationList);
		
		return theObservation;
	}
	
	public void setObservationFactJson(int userid, String factjson){
		List<String> theObservationList = oboservationFactJson.get(userid);
		if(theObservationList == null){
			theObservationList = new ArrayList<String>();
		}
		theObservationList.add(factjson);
		oboservationFactJson.put(userid, theObservationList);
	}
	
	public BatchSession createSessionContent(int userid){
		BatchSession bss = new BatchSession();
		
		InsertElement insertElement = new InsertElement();
		
		ArrayList<Fact> flist= new ArrayList<Fact>();
		Fact f1 = new Fact();
		f1.setFactid(1);
		f1.setFactname("Participant");
		f1.setFacttype(1);
		f1.setFacttxt("Incoming Participant JSON");
		f1.setFactjson(participantFactJson.get(userid));
		flist.add(f1);
		
		Fact f2 = new Fact();
		f2.setFactid(1);
		f2.setFactname("Goal");
		f2.setFacttype(1);
		f2.setFacttxt("Incoming Goal JSON");
		f2.setFactjson(goalFactJson.get(userid));
		flist.add(f2);
		
		List<String> theObservationList = oboservationFactJson.get(userid);
		int i=1;
		for(String observationFactJson:theObservationList){
			
			Fact f3 = new Fact();
			f3.setFactid(i);
			f3.setFactname("Observation");
			f3.setFacttype(1);
			f3.setFacttxt("Incoming Observation JSON");
			f3.setFactjson(observationFactJson);
			flist.add(f3);
			
			i++;
		}
		insertElement.setFactList(flist);
		
		bss.setInsertElement(insertElement);
		bss.setFireallrules(new FireAllRules());
		bss.setQuery(new Query());
		return bss;
	}
	
	
}
