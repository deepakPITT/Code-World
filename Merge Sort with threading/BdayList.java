/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Popular;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author deepak
 */
public class BdayList { 
    
     public static void parse1 (File f1 ) throws FileNotFoundException, IOException, ParseException
    {
        // read end of line and check for eof reached or not 
        //obj= this.obj;
        FileInputStream fis = new FileInputStream(f1);
	//Construct BufferedReader from InputStreamReader
	//BufferedReader br = new BufferedReader(new InputStreamReader(fis));
         
        Scanner sc = new Scanner(fis);
	String line = null;
        // parsing data
        StringTokenizer st = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        List<Input> myInput = new LinkedList<Input>();
        
        try {
        Date dt = null;
	while (sc.hasNextLine()){  
              
            line = sc.nextLine();
              // String[]  array = line.split(","); 
               st = new StringTokenizer(line);
		String tokens[] = new String[4];
		
		int i =0;
                
                if(line != null && !line.isEmpty()) {
		while(st.hasMoreTokens()) {
			
			tokens[i] = st.nextToken();
			i++;
		}
		
		String date = "";
		
		for(int id=1; id< tokens.length; id++) {
			if(id != tokens.length-1) {
			date = date+tokens[id]+"-";
			} else {
				date = date+tokens[id];
			}
		}
	
                dt = sdf.parse(date);
          Input obj = new Input(Integer.parseInt(tokens[0]),dt);
          myInput.add(obj);
         
                }
         
        }
        } catch(Exception e) {
            e.printStackTrace();
        } 
        System.out.println("Size >>> "+myInput.size());
        Collections.sort(myInput);
        
        String filePath = "//Users//ankita//Desktop//HP//output.txt";
        ThreadWrite t1 = new ThreadWrite("T1",myInput,filePath);
        ThreadWrite t2 = new ThreadWrite("T2",myInput,filePath);
        t1.start();
        t2.start();
    }      
    
    
     public static List<Input> parseFile (File f1 ) throws FileNotFoundException, IOException, ParseException
    {
        // read end of line and check for eof reached or not 
        //obj= this.obj;
        FileInputStream fis = new FileInputStream(f1);
	//Construct BufferedReader from InputStreamReader
	//BufferedReader br = new BufferedReader(new InputStreamReader(fis));
         
        Scanner sc = new Scanner(fis);
	String line = null;
        // parsing data
        StringTokenizer st = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        List<Input> myInput = new ArrayList<Input>();
        
        try {
        Date dt = null;
	while (sc.hasNextLine()){  
              
            line = sc.nextLine();
              // String[]  array = line.split(","); 
               st = new StringTokenizer(line);
		String tokens[] = new String[4];
		
		int i =0;
                
                if(line != null && !line.isEmpty()) {
		while(st.hasMoreTokens()) {
			
			tokens[i] = st.nextToken();
			i++;
		}
		
		String date = "";
		
		for(int id=1; id< tokens.length; id++) {
			if(id != tokens.length-1) {
			date = date+tokens[id]+"-";
			} else {
				date = date+tokens[id];
			}
		}
	
                dt = sdf.parse(date);
          Input obj = new Input(Integer.parseInt(tokens[0]),dt);
          myInput.add(obj);
         
                }
         
        }
        } catch(Exception e) {
            e.printStackTrace();
        } 
        System.out.println("Size >>> "+myInput.size());
        return myInput;
    }      
}
        
        
