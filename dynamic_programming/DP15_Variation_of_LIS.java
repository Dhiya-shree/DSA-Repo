package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * 
 * Variation of LIS 
 * 
 * Single array -> order must , No sort 
 * 
 * 2D array -> chain/bridge sort , then LIS 
 * 
 * 1) Minimum deletions to make an array sorted 
 *       Ex : 5 10 3 6 7 8  O/p : 2 
 *       Minimum no of elements to delete to make array sorted 
 *       
 *       Ans = Length of array - length of LIS 
 * 
 * 2) Maximum sum Increasing Subsequence 
 *      Find all increasing subsequence and
 *        find its maximum sum 
 *      i/p 3,20,4,6,7,30
 *      o/p 53
 *      3,20 - 23 
 *      4,6,7,30 - 47 
 *      3 20 30 - 53 
 *      Maximum sum= 53 
 *      
 *      At every replace in LCS , find sum and keep a track 
 *      
 * 
 * 
 * 3) Maximum length of Bitonic subsequence 
 * 
 *   Bitonic subsequence - a subsequence that is increasing then decreasing 
 *   Ex
 *   arr = 1 11 2 10 4 5 2 1
 *         1-11-2-10-4-5-2-1 ( wrong inc dec inc dec is wrong , First part inc , next dec )
 *         1-11 
 *         1--2--4--5--2--1
 *         1--2--10--4--2-1
 *         1 --2--10--5-2-1
 *         length=6   
 *         
 *    In Bitonic subsequence - increasing part can be empty also decreasing part can be empty 
 *    Thus ,
 *    1-2-3-4-5-6-7-1000 is bitonic , with empty decreasing part  
 *    10-9-8-7-6-5-4-3-2-1-0 also bitonic with empty increasing part 
 *    
 *    Solution :
 *    
 *    1) Find LIS and tail Traverse 0 to n-1 , find increasing sequence 
 *    2) Find LDS Length of longest decreasing part tail2 Traverse n-1 to 0 , find increasing sequence 
 *    3) Ans is max of tail+tail2-1
 * 
 * 4) Building Bridges NO ORDER 
 * 
 *    Build bridges between given city pair such that no bridges cross each other ...
 *    Skip some bridge to avoid crossing 
 *    Maximize no of bridges made 
 *    
 *    Given an array of pairs of cities and array representing requirement for bridges
 *    city 1,2,3,4,5,6 ....
 *    bridge city 6 and city 2 , city 4 and city 3 ... 
 *    i/p 6-2 ,4-3 , 2-6 , 1-5 
 *    
 *    Cont : NO TWO BRIDGE SHOULD CROSS
 *    
 *    NOT  ALLOWED ...           
 *    1 2 3 4 5  6
 *         \    /
 *       ___\__/   Brige can not cross
 *      /    \ 
 *    1 2 3 4 5 6
 *    
 *    
 *    ALLOWED ...           
 *    1 2 3 4 5  6
 *      _____/  /
 *     /  _____/
 *    /  /     
 *    1 2 3 4 5 6
 *    
 *     
 *   Input  i/p 6-2 ,4-3 , 2-6 , 1-5 
 *   City a : 6 4 2 1 
 *   City b : 2 3 6 5
 *   
 *   Sort based on city a
 *   City a : 1 2 4 6
 *   City b : 5 6 3 2 
 *     
 *   Solution 1 :
 *   
 *   1) Sort  on increasing order based on city A 
 *        If two pair has same city a , sort based on city B in increasing order 
 *      ex 3-5 1-5 2-3 2-6 2-1 
 *      sort baed on first value :1-5 2-3 2-6 2-1 3-5 
 *      sort based on 2nd  value :1-5 2-1 2-3 2-6 3-5
 *      
 *   2) Find LIS of sorted array acording to second value 
 *               5,1,3,6,5 ans :  1,3,6 or 1,3,5 
 *         Bridge without crossing : 2-1 2-3 3-5
 * 
 *     O N logN 
 *     
 * Only 1 bridge from index will work , two bridge from index WRONG FAIL !!!!!
 *   The bridges can be in increasing order /  /  or decreasing order    \   \
 *   Find LIS where cityA[i]>cityA[j] and cityB[i]>cityB[j]
 *   Find LDS where cityA[i]>cityA[j] and cityB[i]>cityB[j]  
 *  max= max of LIS, LDS 
 * 
 * 5) The Longest chain of pair  NO ORDER 
 *    
 *    Array of pair , where pair (a,b) a < b 
 *    Find the longest chain of pair such that (a,b),(c,d),(e,f).... where a<b<c<d<e<f....
 * 
 *    Ex :
 *    i/p 5-24 39-60 15-28 27-40 50-90
 *    o/p 5-24 27-40 50-90 
 *    Chain length : 3
 *    
 *    i/p 6-8 3-4 
 *    o/p 2 
 *    
 *    Solution :
 *    
 *    Sort array of pair accoding to first value 
 *    Find LIS of the sorted array 
 *    
 *    
 *    [or]
 *    LIS with cond arr[j][1]<arr[i][0]
 *    LDS with cont arr[j][1]>arr[i][0]
 *    max of above 
 *    
 *    
 *    Longest Chain Problem == Activity Selection Problem
 *    
 *    Building briges , first value >=< second . can not use lis and lds 
 * But Longest chain , always first value > second . Use lds and lis 
 * 
 * 
 * @author shree
 *
 */
public class DP15_Variation_of_LIS {

	public static void main(String[] args) {
		//Variation of LIS 
		
		//Max increasing sum 
		int arr[]= {1,11,2,10,4,5,2,1}; //{3,20,4,6,7,30};
		int n=arr.length;
		
		int ans=MaximumIncreasingSequence_SUM(arr,n);
		System.out.println(" Maximum increasing sub sequence sum is "+ans);
		
		ans=Bitonic_subsequence(arr,n);
		System.out.println(" Bitonic subsequene "+ans);
		
		int cities[][]= {{6,2},{4,3},{2,6},{1,5},{2,3},{2,4}}; //{{6,2},{4,3},{2,6},{1,5}};
		int n1=cities.length;
		
		//Wont work 
		//MUST SORT then LCS based on second value 
		ans=Build_Bridges(cities,n1);
		System.out.println(" No of bridges is "+ans);
		
		ans=GoG_Build_Bridges(cities,n1);
		System.out.println(" No of bridges CORRECT TRY MUST IMP  is "+ans);
		
		
		int pair[][]= {{6,8},{3,4}};//{{5,24},{39,60},{15,28},{27,40},{50,90}};
		int n2=pair.length;
		// WON'T WORK !!!!!!!!!!!!!!!!!!!!!!!
		// MUST SORT 
		ans=Longest_Chain_Pair(pair,n2);
		System.out.println(" No of bridges is "+ans);

	}

	private static int Longest_Chain_Pair(int[][] pair, int n) {
		// LIS to longest chain 

		int tail[]=new int[n];
		int tail2[]=new int[n];
		tail[0]=1;tail2[0]=1;
		int max=1;
		for(int i=1;i<n;i++) {
			tail[i]=1;
			tail2[i]=1;
			for(int j=0;j<i;j++) {

			   if(pair[j][1]<pair[i][0]) {
				   tail[i]=Math.max(tail[i],tail[j]+1);
			   }
			   if(pair[j][1]>pair[i][0]) {
				   tail2[i]=Math.max(tail2[i],tail2[j]+1);
			   }
			}
			max=Math.max(max,Math.max(tail[i],tail2[i]));
		}
		System.out.println(" Longest chain  "+Arrays.toString(tail));
		System.out.println(" Longest chain lds "+Arrays.toString(tail2));
		
		return max;
	}

	private static int GoG_Build_Bridges(int[][] cities, int n1) {
		// Sort based on array[i][0] and then array[i][1]
		//Then find LIS for array[][1] city b 
		
		//sort 
		
		//lis
		
		
		return 0;
	}

	private static int Build_Bridges(int[][] cities, int n) {
		// LIS to build briges 
		
		int tail[]=new int[n];
		int tail2[]=new int[n];
		tail2[0]=1;
		tail[0]=1;
		int max=1;
		for(int i=1;i<n;i++) {
			tail[i]=1;tail2[i]=1;
			for(int j=0;j<i;j++) {
				
				// Wont work for same city origin 2-1 2-5 no issues 
				if(cities[i][0]>cities[j][0] &&cities[i][1]>cities[j][1]) {
					tail[i]=Math.max(tail[i],tail[j]+1);
				}
				if(cities[i][0]<cities[j][0] &&cities[i][1]<cities[j][1]) {
					tail2[i]=Math.max(tail2[i],tail2[j]+1);
				}
			}
			max=Math.max(max,Math.max(tail[i],tail2[i]));
		}
		System.out.println(" Tail array Build bridge "+Arrays.toString(tail));
		System.out.println(" Tail array Build bridge "+Arrays.toString(tail2));
		return max;
	}

	private static int Bitonic_subsequence(int[] arr, int n) {
		// Bitonic is inc + dec sequence 
		
		int tail[]=new int[n];
		int tail2[]=new int[n];
		
		//default 
		tail2[n-1]=1;
		tail[0]=1;
		
		//Longest increasing subsequnence
		for(int i=1;i<n ;i++) {
			tail[i]=1;
			for(int j=0;j<n;j++) {
				
				if(arr[j]<arr[i]) {
					tail[i]=Math.max(tail[i],1+tail[j]);
				}	
				
				/*  ABSOLUTELY WRONG !!!!!!!!!
				 * Decreasing sequence needs o be checked from n-1 to 0 not otherwise !!!!!!!
				if(arr[j]>arr[i]) {
					tail2[i]=Math.max(tail2[i],1+tail2[j]);
				}
				
				*/
				
			}
		}
		
		
		System.out.println(" Longest increasing sub sequence "+Arrays.toString(tail));
		
		tail2=new int[n];
		tail2[n-1]=1;
		//Longest Decreasing subsequnence
		for(int i=n-1;i>=0;i--) {
			tail2[i]=1;
			for(int j=n-1;j>i;j--) {

				if(arr[j]<arr[i]) {
					tail2[i]=Math.max(tail2[i],1+tail2[j]);
				}

			}
		}
				
		System.out.println("2.Longest Decreasing sub sequence"+Arrays.toString(tail2));	
		int bitonic=0;
		for(int i=0;i<n;i++) {
			// -1 as 1 element considered twice 
			bitonic=Math.max(bitonic,tail[i]+tail2[i]-1);
		}
				
		return bitonic;
	}

	private static int MaximumIncreasingSequence_SUM(int[] arr, int n) {
		// Maximum Increasing Sequence
		
		int msis[]=new int[n];
		int max=0;
		for(int i=0;i<n;i++) {
			msis[i]=arr[i];// for index has the particular value 
			for(int j=0;j<i;j++) {
				
				if(arr[j]<arr[i]) {   
					// if arr value is smaller than curr , add that array msis msis[j] with arr[i]
					
					msis[i]=Math.max(msis[i],arr[i]+msis[j]);
				}
			}
			max=Math.max(max, msis[i]);
		}
		
        System.out.println(" Array MSIS "+Arrays.toString(msis));
		return max;
	}

}
