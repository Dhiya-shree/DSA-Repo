package impAlgorithm_Sorting;

import java.util.Arrays;

public class LazyAddition_MeetMaxPeople {

	public static void main(String[] args) {
		int start[]= {1,2,8,6,25,25};
		int end[]= {5,7,15,24,25,230};
		int n3=start.length;
		maxOverlapGoG(start, end, n3);
		
	}

	public static void maxOverlapGoG(int []start,int [] end ,int n)
	{
	    // Finding maximum starting time
	    int maxa = Arrays.stream(start).max().getAsInt();
	    
	    // Finding maximum ending time
	    int maxb = Arrays.stream(end).max().getAsInt();
	    
	    int maxc = Math.max(maxa,maxb); 
	        
	    int []x = new int[maxc + 2];
	    Arrays.fill(x, 0);
	        
	    int cur=0,idx=0;

	    // Creating an auxiliary array
	    for(int i = 0; i < n; i++)
	    {
	        // Lazy addition
	        ++x[start[i]];
	        --x[end[i]+1];
	    }
	        
	    int maxy=Integer.MIN_VALUE;
	    
	    //Lazily Calculating value at index i
	    for(int i = 0; i <= maxc; i++) 
	    {
	        cur+=x[i];
	        if(maxy < cur)
	        {
	            maxy = cur;
	            idx = i;
	            
	        }         
	    }
	        System.out.println("Maximum value is:"+
	                        maxy+" at position: "+idx+"");
	        
	} 
	
}