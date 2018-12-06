package com.qa.Presidents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
}
