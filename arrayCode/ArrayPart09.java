package arrayCode;

import java.util.ArrayList;
import java.util.List;

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
 *    
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #3 : Print Pattern 
 * 
 * Print a sequence of numbers starting with N where A[0] = N, without using loop, in which  A[i+1] = A[i] - 5,  until A[i] > 0.
 *  After that A[i+1] = A[i] + 5  repeat it until A[i] = N.
 * Example 1:
 * Input: N = 16
 * Output: 16 11 6 1 -4 1 6 11 16
 * Explaination: The value decreases until it  is greater than 0. After that it increases and stops when it becomes 16 again.
 * 
 *   USE RECUSRSION  
 *  NO LOOP - RECURSION ; NO LOOP --- RECURSION; NO LOOP -->>> RECURSION ; NO LOOP === RECURSION ; NO LOPP ~~~ RECURSION ; NO LOOP :::: RECURISON ; NO LOOP _ RECURSION
 *  
 ///////////////////////////// NO LOOP -->>> RECURSION///////////////////////////////////////////// NO LOOP -->>> RECURSION/////////////////////////////////////////////////
  * 
  * -----------------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #4: Subarray with Given Sum
 * 
 * Our Task: Given an array arr[ ] of non-negative integers and an integer sum, find a subarray that adds to a given sum.
 * 1) Naive Approach:
 * The idea is to consider all subarrays one by one and check the sum of every subarray. The following program implements the given idea. 
 * Run two loops: the outer loop picks a starting point i and the inner loop tries all subarrays starting from i.
 * Time Complexity: O(n2), Trying all subarrays from every index, used nested loop for the same
 * Auxiliary Space: O(1). 
 * 
 * 2) Efficient Approach (Using Sliding Window):   SLLLLIIIDE WINDOW 
 * The idea is simple as we know that all the elements in subarray are positive so, If a subarray has sum greater than the given sum then there is no
 *  possibility that adding elements to the current subarray will be equal to the given sum. So the Idea is to use a similar approach to a sliding window. 
 *  Time Complexity: O(n)
 *  Auxiliary Space: O(1). Since no extra space has been taken.
 *  
 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #5 : Longest Subarray Of Evens And Odds
 * 
 * You are given an array of size n. Find the maximum possible length of a subarray such that its elements are arranged alternately either as even and odd or odd and even .
 *  
 * 
 * @author shree
 *
 */

public class ArrayPart09 {

	public static void main(String[] args) {
		// Array part 9 - 70 % completed 
		
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
        
        /**-----------------------------------------------------------------------------------------------------------------------------------------  */
        int N=10;
        int Pat=5;
        System.out.println(" Pattern without lopp with  recusion :");
        //System.out.println(N);
        PrintPatternWithoutLoop(N,Pat);
        
        List<Integer> list = pattern(N);
        int n=list.size();
        System.out.println("----------------------------------");
        for(int i=0;i<n;i++) {
        	System.out.println(list.get(i));
        }
        
        /**-----------------------------------------------------------------------------------------------------------------------------------------  */
        
        int find=20;
        isThere=FindSubArrayWithGivenSum(arr,find);
        System.out.println(" It is "+isThere);
        
        //-----------------------------------------------------------------------------------------------------------------------------------------------
        
        ans=FindMaxLengthSubArrayOddEven(arr);
        System.out.println(" Max len is "+ans);
	}
	
	private static int FindMaxLengthSubArrayOddEven(int[] arr) {
		// Length of conse odd and even sub array 
		int n=arr.length;
		int maxLen=0;
		int currLen=1;
		if(n==1) {
			return 1;
		}
		for(int i=1;i<n;i++) {
			if(((arr[i-1]^arr[i])&1)==1){
				currLen++;
			}
			else {
				currLen=1;
			}
			maxLen=Math.max(maxLen,currLen);
			System.out.println(" Max "+maxLen+" Curr len "+currLen+" AT i = "+i);
		}
		return maxLen;
	}

	private static boolean FindSubArrayWithGivenSum(int[] arr, int find) {
		// Find subarray with given sum 
		int toRemove=0;
		int sum=0;
		int n=arr.length;
		for(int i=0;i<n;i++) {
			sum=sum+arr[i];
			if(arr[i]==find || sum==find) {
				return true;
			}
			while(sum>find) {
				sum=sum-arr[toRemove];
				System.out.println(" Removed "+arr[toRemove]);
				toRemove++;
			}
			System.out.println(" Sum "+sum);
		}
		if(sum==find) {
			return true;
		}
		return false;
	}

	private static List<Integer> pattern(int n) {
		// call to next method 
		List<Integer> list = new ArrayList<Integer>();
		int pat=5;
		patternList(n,pat, list);
		return list;
	}

	static void patternList(int n,int pat,List<Integer> list) {
		// Returns List 
		if(n<=0) {
			list.add(n);
			return;
		}
		list.add(n);
		patternList(n-5,5,list);
		list.add(n);
		return;
	}

	private static void PrintPatternWithoutLoop(int n, int pat) {
		// Need to print pattern without using loop -> Bich use recusrion 
		
		if(n<=0) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		PrintPatternWithoutLoop(n-pat,pat);
		System.out.println(n);
		
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
