package com.qa.Presidents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	
    public static void main( String[] args ) throws IOException
    {
        
    	
    	//PresidentCollection.FileStream("C:\\data\\presidents.txt");
    	
    	List<String> PresidentList = Files.readAllLines(new File("C:\\data\\presidents.txt").toPath(), Charset.defaultCharset() ); 
    	
    	PresidentCollection.PresidentIterator(PresidentList);
    	PresidentCollection.yearWithMostPresidents();
    }
    

}
