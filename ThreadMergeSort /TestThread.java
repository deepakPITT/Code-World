/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Popular;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ankita
 */
 class ThreadDemo extends Thread {
   private Thread t;
   private String threadName;
   
   ThreadDemo( String name){
       threadName = name;
       System.out.println("Creating " +  threadName );
   }
   
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         final String[][] data = new String[][] {
                new String[] { "2010.07.25", "Message A" },
                new String[] { "2000.07.25", "Message G" },
                new String[] { "2002.07.25", "Message B" },
                new String[] { "2004.07.25", "Message D" },
                new String[] { "2003.07.25", "Message F" },
                new String[] { "2006.07.25", "Message E" },
                new String[] { "2009.07.25", "Message R" } };

        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        for (final String[] s : data) {
            System.out.println(threadName+" "+s[0] + " " + s[1]);
        }
          //Thread.sleep(50);
       } catch (Exception e) {
         System.out.println("Thread " +  threadName + " interrupted.");
     }
     System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start ()
   {
      System.out.println("Starting " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }

}

public class TestThread {
   public static void main(String args[]) {
   
      ThreadDemo T1 = new ThreadDemo( "Thread-1");
      ThreadDemo T2 = new ThreadDemo( "Thread-2");
      T1.start();
      
      T2.start();
   }   
}