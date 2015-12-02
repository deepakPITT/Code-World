package Popular;



import Popular.Input;
import java.util.Date;

public class SortThread extends Thread {
    // Instance data
    private Input[] data;
    private int startIndex;
    private int endIndex;
   
    
    public SortThread(Input[] data, int startIndex, int endIndex)
    {
        this.data = data;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
   
    @Override
    public void run()
    {
        
        Main.mergeSort(data, startIndex, endIndex );
    }
}