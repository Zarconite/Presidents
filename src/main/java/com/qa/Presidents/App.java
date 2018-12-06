package com.qa.Presidents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static ArrayList<President> PresidentArrayList = new ArrayList<President>();
	
    public static void main( String[] args ) throws IOException
    {
        
    	FileInputStream presidentInput = null; 
        
    	try {
    		presidentInput = new FileInputStream("C:\\data\\presidents.txt");
    		
    	} finally {
    		if (presidentInput != null) {
    			presidentInput.close();
    		}
    	}
    	
    	System.out.println(presidentInput);
    	
    	//ArrayList<President> PresidentList = FileUtils.readLines(new File("C:\\data\\presidents.txt"), "utf-8");
    	List<String> PresidentList = Files.readAllLines(new File("C:\\data\\presidents.txt").toPath(), Charset.defaultCharset() );
    	for(String a : PresidentList) {
    		System.out.println(a);
    	}
    	
    	//myClassroom.add(new Person("Whiskers","Catfish",12));
    	
    	//for(String b : PresidentList) {
    	for(int i = 1; i <= PresidentList.size()-1; i++) {
    		String[] singularPresident = PresidentList.get(i).split(",");
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
    		
    		Date DOB;
    		Date DOD;
    		
    		try {
 
    			DOB = sdf.parse(singularPresident[1].replace("\t", "").replace(" ", "-"));
    			
    			//System.out.println(singularPresident[3]);
    			if(singularPresident[3].equals("") || singularPresident[3].equals("\t")) {
    				Calendar cal = Calendar.getInstance();
            		President.add(new President(singularPresident[0],DOB,singularPresident[2].replace("\t", "")));
            		//System.out.println("Added No DOD");
    			}
    			
    			else {
    				DOD = sdf.parse(singularPresident[3].replace("\t", "").replace(" ", "-"));
    				Calendar cal = Calendar.getInstance();
            		President.add(new President(singularPresident[0],DOB,singularPresident[2].replace("\t", ""),DOD,singularPresident[4].replace("\t", "")));
            		//System.out.println("Added with DOD");
    			}
        		
    		} catch(ParseException pe) {
    			
    			System.out.println("you got a parsing issue here bucko: " + pe);
    			
    		}
    		
    		System.out.println(PresidentArrayList.get(i-1).toString());
    		
    	}
    	
		
		
		//for(President presidentsTotal:App.PresidentArrayList) { //temporary to ensure all encounters print via the overridden toString() method in Encounter
		//System.out.println(PresidentArrayList.toString());
		//}
    	
//    	public ArrayList<President> seperatedPresident(){
//    	       return President.stream()
//    	                .filter(prezido -> presidentInput.split())  //returns true if the person's age is greater than or equal to desired age
//    	                .collect(Collectors.toList()); //In order to get it out of the stream, we have to collect the stream into a new list
    	
    	//PresidentList = presidentInput.split("\\r?\\n");
    }
    

}
