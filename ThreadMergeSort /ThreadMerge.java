

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadMerge extends Thread{
	
    	private Date[] data;
	    private int startIndex;
	    private int endIndex;
	
	ThreadMerge(Date[] data, int startIndex, int endIndex) {
        this.data = data;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
	
	
	public void run() {
		
		synchronized(data) {
			// Loop indexes
			int i, j, k;

			Date[] tempData = new Date[data.length];
			int midPoint = data.length/2;

			// copy both halves of data to auxiliary array tempData
			for ( i = startIndex; i <= endIndex; i++)
				tempData[i] = data[i];

			i = startIndex; j = midPoint+1; k = startIndex;

			// copy back next-greatest element at each time
			while (i <= midPoint && j <= endIndex) {
				Date in = tempData[i];
				Date jn = tempData[j];

				if (in.before(jn) || in.equals(jn)) {
					data[k++] = tempData[i++];
				}
				else {
					data[k++] = tempData[j++];
				}
			}



			// copy back remaining elements of first half (if any)
			while (i <= midPoint)
				data[k++] = tempData[i++];
		}
		
		System.out.println("Thread ID >> "+this.getId());
		DateFormat dateFormatter = new SimpleDateFormat("mm-dd-yyyy");
		for(int id=0; id<data.length; id++) {
			System.out.println(dateFormatter.format(data[id]));
		}
		System.out.println("Exiting Thread "+this.getId());
		System.out.println("****************************************");
    }
    
}
