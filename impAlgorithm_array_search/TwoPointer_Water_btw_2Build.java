package impAlgorithm_array_search;

/**
 * Maximum Water Between Two Buildings .... 4 marks   - Two pointer 
 * Given an integer array representing the heights of N buildings, 
 * the task is to delete N-2 buildings such that the water that can be trapped between the remaining two building 
 * is maximum.
 * Note: The total water trapped between two buildings is gap between them (number of buildings removed)
 *  multiplied by height of the smaller building
 *  
 *  Sol:
 *  
 *  Dis= distance between two building 
 *  Space= min of two , building 
 *  
 *  Point p1 in 0 ; point P2 in n-1 
 *  water_ans=0;
 *  
 *  In the For Loop
 *  --> Find the water=space* dis 
 *  --> Set water_ans= Max of water, water_ans 
 *  
 *  --> If arr[p1]>arr[p2] ( first building higher than second - update the second as first building is high )
 *  ---------> p2--;
 *  --> Else ( second building > First ; set second , change first building )
 *  ---------> p1++;
 *  
 *  -> Return Ans
 *  
 *  
 * 
 * @author shree
 *
 */
public class TwoPointer_Water_btw_2Build {

	public static void main(String[] args) {
		 //int arr1[]= {1,2,3,4,5};//{1,3,4,6 ,8,10,12};
		 //int arr2[]= {3,4,15,26,15,88}; //{ 0, 2 ,3, 5, 7 ,9 , 11};
		 int arr3[]= {56, 10 ,70 ,15 ,6 ,7 ,74 ,4 ,14 ,74 ,59 ,16 ,52 ,28 ,23 ,41 ,16 ,80 ,40 ,11 ,97 ,90 ,83 ,67 ,7 ,29, 15, 69, 1 ,80 ,36};
         
         int ans=WaterBtw2Building(arr3);
         System.out.println(" Water "+ans);
         
         ans=WaterBtw2BuildingGoG(arr3);
         System.out.println(" Water "+ans);
	}
	
	private static int WaterBtw2BuildingGoG(int[] height) {
		    int n=height.length;
			int max = 0; 

			//using two pointers that point at first and last building respectively.
			int i = 0, j = n - 1; 

			while (i < j) 
			{ 
			    //if height at index i is less than height at index j, updating 
	    		//maximum water stored so far and incrementing i.
				if (height[i] < height[j]) 
				{ 
					max = Math.max(max, (j - i - 1) * height[i]); 
					i++; 
				} 
				//else if height at index i is more than height at index j,  
	    		//updating maximum water stored so far and decrementing j.
				else if (height[j] < height[i]) 
				{ 
					max = Math.max(max, (j - i - 1) * height[j]); 
					j--; 
				} 
				//else updating maximum water stored so far and both pointers.
				else
				{ 
					max = Math.max(max, (j - i - 1) * height[i]); 
					i++; 
					j--; 
				} 
			} 
	        //returning the result.
			return max; 
		} 

	private static int WaterBtw2Building(int[] arr) {
		
		int n=arr.length;
		
		//Special case 
		if(n<3) {
			return 0;
		}
		if(n==3) {
			return(Math.max(arr[0],arr[2]));
		}
		int p1=0;
		int p2=n-1;
		int dis=0;
		int space=0;
		int ans=0;
		int nans=0;
		
	while(p2>(p1+1)){
		dis=p2-p1-1;
		space=Math.min(arr[p1],arr[p2]);
		nans=space*dis;
		
		ans=Math.max(ans, nans);
		System.out.println(" P1 "+p1+" P2 "+p2+" ..ans "+nans+"....ans al "+ans);
		if(arr[p1]>arr[p2]) {
			p2--;
		}
		else {
			p1++;
		}
	}
		System.out.println(" P1 "+p1+" P2 "+p2+" Tot "+ans);
		return ans;
	}

}
