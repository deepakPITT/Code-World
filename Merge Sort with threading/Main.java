package Popular;

import Popular.BdayList;
import Popular.Input;
import Popular.SortThread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main
{
   
   
    public static void mergeSort(Input[] data, int startIndex, int endIndex )
    {
        if (startIndex < endIndex)
        {
            int midPoint =(startIndex + endIndex) / 2;
           
            mergeSort(data, startIndex, midPoint);
            mergeSort(data, midPoint + 1, endIndex);
            merge(data, startIndex, midPoint, endIndex);
        }        
    }
   
    public static void merge(Input[] data, int startIndex,
            int midPoint, int endIndex)
    {
        
        int i, j, k;
 
        Input[] tempData = new Input[data.length];
 
        
        for ( i = startIndex; i <= endIndex; i++)
            tempData[i] = data[i];
 
        i = startIndex; j = midPoint+1; k = startIndex;
 
       
        while (i <= midPoint && j <= endIndex) {
		    Date in = tempData[i].getDateField();
			Date jn = tempData[j].getDateField();
			
            if (in.before(jn) || in.equals(jn)) {
                data[k++] = tempData[i++];
				}
            else {
                data[k++] = tempData[j++];
			}
		}
		
		
 
      
        while (i <= midPoint)
            data[k++] = tempData[i++];
    }
   
   
   
    
    public static Input[] mainMerge() throws IOException, FileNotFoundException, ParseException
    {
        
        
        File f1 = new File("//Users//ankita//Desktop//HP//input.txt");
       List<Input> inputs = BdayList.parseFile(f1);
        
       final int DATA_SIZE = inputs.size();
        Input[] data = new Input[DATA_SIZE];
        Input[] dataCopy = new Input[DATA_SIZE];
        
        
        for(int idx = 0; idx<inputs.size(); idx++) {
            data[idx] = inputs.get(idx);
        }
       
        // Used to keep track of long the execution took
        long startNormal = 0;
        long startMulti = 0;
        long endNormal = 0;
        long endMulti = 0;
       
        // Fill array with a ton of random dates
        /*DateFormat dateFormatter = new SimpleDateFormat("mm-dd-yyyy");
		
		try{
		    data[0] = (dateFormatter.parse("10-01-1960"));
		    data[1] = (dateFormatter.parse("04-05-1978"));
		    data[2] = (dateFormatter.parse("09-17-1986"));
		    data[3] = (dateFormatter.parse("02-15-1971"));
		    data[4] = (dateFormatter.parse("07-01-1979"));
		    data[5] = (dateFormatter.parse("10-01-1960"));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
       
        
        for(int i = 0; i < data.length; i++)
            dataCopy[i] = data[i];
       
        int midPoint = data.length / 2;
       
        
        SortThread tPrimary = new SortThread(data, 0, midPoint);
        SortThread tSecondary = new SortThread(data, midPoint + 1,data.length - 1);
       
   
       
           startMulti = System.currentTimeMillis();
        tPrimary.start();
        tSecondary.start();
       
        // Wait for our worker threads to complete
        while(tSecondary.isAlive() || tPrimary.isAlive())
        {
            try
            {
                // Probably better to just sleep for one second
                // unless you are not sorting that much data.
                // Thread.yield();
                Thread.sleep(1000);
            }
            catch(Exception err)
            {
                // This won't happen, but if it does we cannot
                // recover, so bail.
                System.err.println(err.getMessage());
                System.exit(-1);
            }
        }
       
        // Merge two halves of sorted data
        merge(data, 0, midPoint, data.length - 1 );
        
        /*ThreadMerge m1 = new ThreadMerge(data, 0, data.length-1);
        ThreadMerge m2 = new ThreadMerge(data, 0, data.length-1);
        m1.run();
        m2.run();*/
       
        // Record end time
        endMulti = System.currentTimeMillis();
       
       
        
        return data;
    }
 
}
