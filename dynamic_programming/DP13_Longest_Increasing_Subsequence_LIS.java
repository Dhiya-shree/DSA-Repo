package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Longest increasing sub sequence 
 * 
 * A subsequnece of given sequence is 0 or more element picked in order of apprearing in sequenece .
 * 
 * For sequenec length N , 2*N subsequnence possible 
 * 
 * For example :
 * arr = 3,4,2,8,10 
 * s^N - as 00000,00001,00010,00011.....11111(32)
 *    3,4,2,8,10 - 5
 *    34,342,3428,34280,32,328,3280,38,380,30 - 10 
 *    42,428,4280,48,480,40 - 6 
 *    28,280,20 - 3
 *    80," "- 2 
 * 
 * LIS= 3,4,8,10 
 * length = 4 
 * 
 * Array in sorted increasing LIS=N , decreasing LIS=1 
 * 
 * Naive :
 * Generate all sub sequence 2^N 
 * 
 * Dynamic :  Time O N^2 Space O N 
 * 
 * We need to find max lis at every point 
 *    3 4 2 8 10 
 *    1 2 1 3 4
 *    
 *    Ans = lis of element 10 : 4 
 *    
 * Create lis array lis[n]
 * 
 * For i=0 
 * lis[0]= 1 
 * 
 * For i>0 
 * 
 * For value 8 in 3 4 2 8 10 
 * Prev computed lis = 1 2 1 0 0 
 * 
 * For 8  index :3 check the value with pre computed array 
 *    lis=1 (consider only 8)
 *    val=0
 *   for i=0 to 3
 *      val=0
 *      if(arr.i < curr val )
 *      val= lis of i + 1
 *      
 *      lis = Max lis , val
 * 
 * 
 * For i in 1 to N-1 
 *   lis.i=1
 *   for j= 0 to i-1 
 *   
 *   if( arr.j < arr.i )
 *      lis= Math.max lis.i  , lis.j+1
 *  
 *    
 * LIS = Maximum of lis 
 *   
 *   
 * Better solution :
 *  Based on binary search O N LOG N 
 * 
 * 
 * 
 * Recur:
 * Two possible way for each element 
 * Consider 
 * Not consider 
 * 
 * Recur arr,0  3 4 2 8 10 
 *   no consider -  4 2 8 10  n=1 len=0
 *   
 *   consider  - 3 , 4 2 8 10 n=1  len=1
 *               /          \
 *            consider 4     Not consider 
 *           3,4 2810          3, 2,8,10 s=0,e=1,len=1
 *           4>3                   3>2 len++
 *           length=1                 /        \
 *                                Consider      Not ....
 *                                
 *                                
 *   Recur arr,n,start,end,len 
 *   
 *   if end>=n stop return len 
 *   
 *   else 
 *   
 *   if( arr.start<arr.end)
 *      val=ans+1
 *      
 *   consider = arr,n,end,end+1,val // update start and consider curr val 
 *   not consider = arr,n,start,end+1,len // No update start and consider old val 
 *   return maximum of above 
 *   
 *   
 *                                
 *                                
 *  Dynamic 
 *  
 *  memo  Worst case with top down 
 *  
 *  Create memo array memo[n][n]
 *  ans = memo[n-1][n-1]
 *  
 *  
 *  
 * 
 * 
 * @author shree
 *
 */
public class DP13_Longest_Increasing_Subsequence_LIS {

	public static void main(String[] args) {
		// LIS 
		
		int arr[]= {3,4,2,8,10};
		int n=arr.length;
		
		
		//GOG Dynamic 
		int ans=LIS_dynamic(arr,n);
		System.out.println(" GOG dynamic ans "+ans);
		
		
		//recur           arr n start end len 
		int sol=LIS_Recur(arr,n,0,0,0);
		System.out.println(" Recur sol "+sol);
		
		//memo
		int memo[][]=new int[n][n];
		sol=LIS_memo_NOUSE(arr,n,0,0,0,memo);
		System.out.println(" Recur sol "+sol);
	
		
		for(int i=0;i<n;i++) {
		System.out.println("Memo "+i+" "+Arrays.toString(memo[i]));
		}
		
		memo=new int[n][n];
		sol=LIS_memo(arr,n,0,0,0,memo);
		System.out.println(" Recur sol "+sol);
	
		
		for(int i=0;i<n;i++) {
		System.out.println("Memo "+i+" "+Arrays.toString(memo[i]));
		}

	}

	

	private static int LIS_dynamic(int[] arr, int n) {
		// gog 1 D array
		int lis[]=new int[n];
		
		//default 
		lis[0]=1;
		
		for(int i=1;i<n;i++) {
			lis[i]=1;
			for(int j=0;j<i;j++) {
				
				if(arr[j]<arr[i]) {
					lis[i]=Math.max(lis[i],lis[j]+1);
				}
			}
		}
		
		int LIS=0;//answer max lis 
		for(int i=0;i<n;i++) {
			LIS=Math.max(LIS,lis[i]);
			System.out.println(" At i "+i+" "+lis[i]);
		}
		
		return LIS;
	}
	
	private static int LIS_memo(int[] arr, int n, int start, int end, int ans, int[][] memo) {
		// lis 
				if(end==n) {
					return ans;
				}
				
				int val=ans;
				
				if(arr[start]<arr[end] || ( start==0 && end==0)) {
					val=val+1;
				}
				
				int lis_consider=LIS_Recur(arr, n, end, end+1, val);
				int lis_NOconsider=LIS_Recur(arr, n, start, end+1, ans);
				int lis=Math.max(lis_consider, lis_NOconsider);
				
				return lis;
	}

	private static int LIS_memo_NOUSE(int[] arr, int n, int start, int end, int ans, int[][] memo) {
		// memo 
		if(end==n) {
			return ans;
		}
		
		if(memo[start][end]!=0) {
			return memo[start][end];
		}
		
		int val=ans;
		
		if(arr[start]<arr[end] || ( start==0 && end==0)) {
			val=val+1;
		}
		
		int lis_consider=LIS_memo(arr, n, end, end+1, val,memo);
		int lis_NOconsider=LIS_memo(arr, n, start, end+1, ans,memo);
		int lis=Math.max(lis_consider, lis_NOconsider);
		
		memo[start][end]=lis;
		return lis;
		
	}

	private static int LIS_Recur(int[] arr, int n, int start, int end, int ans) {
		// lis 
		if(end==n) {
			return ans;
		}
		
		int val=ans;
		
		if(arr[start]<arr[end] || ( start==0 && end==0)) {
			val=val+1;
		}
		
		int lis_consider=LIS_Recur(arr, n, end, end+1, val);
		int lis_NOconsider=LIS_Recur(arr, n, start, end+1, ans);
		int lis=Math.max(lis_consider, lis_NOconsider);
		
		return lis;
	}

}
