package com.qa.Presidents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
//import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PresidentCollection {

	public static ArrayList<President> PresidentArrayList = new ArrayList<President>();
	
	public static void PresidentIterator(List<String> PresidentList) {
    	for(int i = 1; i <= PresidentList.size()-1; i++) {
    		String[] singularPresident = PresidentList.get(i).split(",");
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
    		
    		Date DOB;
    		Date DOD;
    		
    		try {
 
    			DOB = sdf.parse(singularPresident[1].replace("\t", "").replace(" ", "-"));
    			
    			if(singularPresident[3].equals("") || singularPresident[3].equals("\t")) {
    				//Calendar cal = Calendar.getInstance();
            		President.add(new President(singularPresident[0],DOB,singularPresident[2].replace("\t", "")));
    			}
    			
    			else {
    				DOD = sdf.parse(singularPresident[3].replace("\t", "").replace(" ", "-"));
    				//Calendar cal = Calendar.getInstance();
            		President.add(new President(singularPresident[0],DOB,singularPresident[2].replace("\t", ""),DOD,singularPresident[4].replace("\t", "")));
    			}
        		
    		} catch(ParseException pe) {
    			
    			System.out.println("you got a parsing issue here bucko: " + pe);
    			
    		}
    		
    		System.out.println(PresidentCollection.PresidentArrayList.get(i-1).toString());
    		
    	}
    	
	}
	
	public static void yearWithMostPresidents() {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(PresidentCollection.PresidentArrayList.get(0).getDOB());
		int yearEarly = cal.get(Calendar.YEAR);
		
		//Calendar today = Calendar.getInstance();
		//today.set(Calendar.YEAR, 0);
		//int year = today.get(Calendar.YEAR);
		int year = 2018;
		
		int yearDifference = year-yearEarly;
		
		String[] presidentsAlive = new String[yearDifference];
		//String[] PresidentsDead = new String[yearDifference];
		
		
		for(int i = yearEarly; i < year; i++) {	
			int k = i-yearEarly;
			int aliveCount = 0;
			for(int j=0; j<PresidentCollection.PresidentArrayList.size();j++) {
				Calendar calDOB = Calendar.getInstance();
				calDOB.setTime(PresidentCollection.PresidentArrayList.get(j).getDOB());
				int yearDOB = calDOB.get(Calendar.YEAR);
				int yearDOD=0;
				try {
				Calendar calDOD = Calendar.getInstance();
				calDOD.setTime(PresidentCollection.PresidentArrayList.get(j).getDOD());
				yearDOD = calDOD.get(Calendar.YEAR);
				}
				catch(NullPointerException nullPointer) {
					yearDOD = year+1;
				}
				
			if(i <= yearDOD && i >= yearDOB) {
				aliveCount++;
				presidentsAlive[k] = aliveCount+","+i;
				
			}
			}
			System.out.println(presidentsAlive[k]);
			
			//splits presidents and years
			//String[] presidentCount = PresidentsAlive[k].split(",");
			//int numAlive = Integer.parseInt(presidentCount[0]);
			
			
			
			}
		SliceAndSplice(presidentsAlive);
	}
	
	public static void SliceAndSplice(String[] presidentsAlive) {
		
		String[] presidentSorter = new String[presidentsAlive.length];
		
		for(int i=0; i<presidentsAlive.length; i++) {
			presidentSorter[i]=presidentsAlive[i];
			if(presidentsAlive[i].charAt(1)==',') {
				presidentSorter[i]="0"+presidentSorter[i];
			}
		}
		
	}
	
}
