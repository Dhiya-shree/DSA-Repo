package impAlgorithm_array_search;


/**
 * 
 * Problem #1: Slinding Window 
 * 
 * Our Task: Given an array of integers of size 'n'. Our aim is to calculate the maximum sum of 'k' consecutive elements in the array.
 * 
 * Approach 1:
 *  Loop 1: i = From 0 to n-k-1
 *     ---> Loop 2 : j=from i to i+k
 *                   ans=ans+arr[j]
 *     ---> Real= Max(ans,Real)
 *                 
 * Approach #2:
 *   0,1,2,3,4,5,6,7,8,9,10                
 *   Init: sum[0] = 0+1+2
 *   sum[1]= prev sum - ar[0]+ar[3]
 *   sum[2]= prev_sum -ar[1]+ar[4]
 *   sum[3]= prev_sum - ar[2]+ar[5]..... so on 
 *   sum_nex= prev_sum - ar[i]+ar[i+k] while i+k<n
 *   
 *   Have a var max , update with max Sum 
 *   
 *   Applying sliding window technique :
 *   We compute the sum of first k elements out of n terms using a linear loop and store the sum in variable window_sum.
 *   Then we will graze linearly over the array till it reaches the end and simultaneously keep track of maximum sum.
 *   To get the current sum of block of k elements just subtract the first element from the previous block and add the last element of the current block .
 * 
 * ---------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 *  Problem #2: Pattern searching
 *  
 *  Given a string str and a pattern pat. You need to check whether the pattern is present or not in the given string. 
 *  
 *  Use above sliding window 
 *  
 *  Approach :
 *   Loop : i=0 to i+patter_len<=Str_len 
 *        Part_of_string = str.slice(i,i+plen-1)
 *        if(Part_of_String==pattern)
 *             True break
 *    return false 
 *    
 */
public class SlidingWindow_PatternSearch {

	public static void main(String[] args) {
		int arr[]= {0,1,2,3,5,6,7,8,9,11};
        int k=3;
        int ans=NotSlidingWindow(arr,k);
        System.out.println(" Ans for K window , max sum "+ans);
        ans=SlidingWindowTechnique(arr,k);
        System.out.println(" Ans for K window , max sum "+ans);
        ans=SlidingWindowTechniqueGoG(arr,k);
        System.out.println(" Ans for K window , max sum "+ans);
        
        /**-----------------------------------------------------------------------------------------------------------------------------------------  */
        String str="hq";
        String pattern ="q";
        boolean isThere=PatternSearch(str,pattern);
        System.out.println(" It is "+ isThere +" that it is present -_-");
        
	}
	
	private static boolean PatternSearch(String str, String pattern) {
		// Search for pattern 
		// Lets use sliding window technique 
		int plen=pattern.length();
		int strLen=str.length();
		System.out.println(" Pattern len "+plen+" String len "+strLen);
		if(plen>strLen) {
			return false;
		}
		String part;
		for(int i=0;i+plen<=strLen;i++) {
			part=str.substring(i, i+plen);
			System.out.println(" Part of str "+part+" At i "+i);
			if(part.equals(pattern)) {
				return true;
			}
		}
		return false;
	}

	private static int SlidingWindowTechniqueGoG(int[] arr, int k) {
		// GoG 
		int n=arr.length;
		if (n < k) {
	        System.out.println("Invalid");
	        return -1;
	    }

	    //sum of first window of size k
	    int window_sum = 0;
	    for (int i = 0; i < k; i++)
	        window_sum += arr[i];

	    // Compute sums of remaining windows by
	    // removing first element of previous
	    // window and adding last element of
	    // current window.
	    int max_sum = window_sum;
	    for (int i = k; i < n; i++) {
	        window_sum += (arr[i] - arr[i - k]);
	        max_sum = Math.max(max_sum, window_sum);
	    }
	    return max_sum;
	}

	private static int SlidingWindowTechnique(int[] arr, int k) {
		// Use O n to find max sum in window K 
		int n=arr.length;
		int prev_sum=0;
		if(n<k) {
			for(int i=0;i<n;i++) {
				prev_sum=prev_sum+arr[i];
			}
			return prev_sum;
		}
		else {
			for(int i=0;i<k;i++) {
				prev_sum=prev_sum+arr[i];
			}
		}
		System.out.println(" Prev sum init "+prev_sum);
		int max=prev_sum;
		int curr=0;
		
		for(int i=1;i+k-1<n;i++) {
			curr=prev_sum -arr[i-1]+arr[i+k-1];
			max=Math.max(max,curr);
			prev_sum=curr;
			System.out.println(" Max is "+max+" Curr is "+curr);
		}
		return max;
	}

	private static int NotSlidingWindow(int[] arr, int k) {
		// Use O n2 
		int curr=0;
		int n=arr.length;
		int max=Integer.MIN_VALUE;
		for(int i=0;(i+k-1)<n;i++) {
			curr=arr[i];
			for(int j=i+1;j<i+k;j++) {
				curr=curr+arr[j];
			}
			max=Math.max(max,curr);
			System.out.println(" Max is "+max+" Curr is "+curr);
		}
		return max;
	}
}
