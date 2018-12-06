package com.qa.Presidents;

import java.util.ArrayList;
import java.util.Date;


public class President {
	
	private String wholeName;
	private String birthPlace;
	private Date DOB;
	private Date DOD;
	private String locationOfDeath;
	
	
	public President(String wholeName, Date DOB, String birthPlace, Date DOD, String locationOfDeath) {	
		this.wholeName = wholeName;
		this.birthPlace = birthPlace;
		this.DOB = DOB;
		this.DOD = DOD;
		this.locationOfDeath = locationOfDeath;
		
	}
	
	public President(String wholeName, Date DOB, String birthPlace) {	
		this.wholeName = wholeName;
		this.birthPlace = birthPlace;
		this.DOB = DOB;
		this.DOD = null;
		this.locationOfDeath = null;
		
	}
	
    public static void add(President p){
    	App.PresidentArrayList.add(p);
    }
    
    @Override
    public String toString() {
    return "Name: "+wholeName+" DOB: "+DOB+" BirthPlace: "+birthPlace+" DOD: "+DOD+" DeathPlace: "+locationOfDeath;
    }
    
	public static ArrayList<President> getPresidentArrayList() {
		return App.PresidentArrayList;
	}

	public static void setPresidentArrayList(ArrayList<President> presidentArrayList) {
		App.PresidentArrayList = presidentArrayList;
	}
	
	public String getWholeName() {
		return wholeName;
	}
	public void setWholeName(String wholeName) {
		this.wholeName = wholeName;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Date getDOD() {
		return DOD;
	}
	public void setDOD(Date dOD) {
		DOD = dOD;
	}
	public String getLocationOfDeath() {
		return locationOfDeath;
	}
	public void setLocationOfDeath(String locationOfDeath) {
		this.locationOfDeath = locationOfDeath;
	}

}
