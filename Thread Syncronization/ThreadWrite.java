/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Popular;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author deepak
 */
public class ThreadWrite extends Thread{
    
    private List<Input> sortedInputs;
    private String threadName;
    
    private ThreadWrite obj;
    private String filePath;
    
    ThreadWrite(String name, List<Input>inputs, String filePath) throws FileNotFoundException {
        this.threadName = name;
        this.sortedInputs = inputs;
        this.filePath = filePath;
    }
    
    /**
     *
     * @param sortedInputs
     */
    public void readFile() throws FileNotFoundException, IOException{
		
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		 //this.fout = new FileOutputStream("//Users//ankita//Desktop//HP//output.txt");
		  
                
                BufferedWriter out = new BufferedWriter(new FileWriter(this.filePath,true));
         
         
                
                 for(Input obj : sortedInputs) {
                     
                  out.write(this.threadName+" "+obj.getId()+"  "+ sdf.format(obj.getDateField()));   
                  
                  out.newLine();
            }
                 out.newLine();
                 out.write("****************");
		out.close();
		System.out.println("Done");	   
    }
    
    
    public void run() {
        
       /* synchronized(sortedInputs) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            for(Input obj : sortedInputs) {
                System.out.println(obj.getId()+"  "+sdf.format(obj.getDateField()));
               
            }
            
            System.out.println("Exiting thread "+this.threadName);
            System.out.println("************************************");
        }
        */
        
             try{
                 synchronized(filePath) {
               
            readFile();
                 }
             } catch(Exception e) {
                 e.printStackTrace();
             }
        
        
    }
    
}
