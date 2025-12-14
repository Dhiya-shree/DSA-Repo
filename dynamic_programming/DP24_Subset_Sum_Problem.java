package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Subset Sum Problem  
 * 
 * Given an array and sum .
 * Find how many subset of array , form the sum .
 * 
 * arr={1,2,3} n=3 
 * no of subset=2^3
 * Subsets = 1,2,3,1 2,1 3,2 3,1 2 3,{}
 * 
 * Ex Arr= {10,5,2,3,6}
 *    sum = 8 
 *    Subset sum is 8 = 5 3 , 2 6  o/p=2
 *    
 *    Arr= {1,2,3}
 *    sum=4 
 *    Subset with sum 4 = 1 3  o/p=1
 *    
 *    Arr={10,20,15}
 *    sum=37
 *    Subset with sum 37= 0   o/p=0 
 *    
 *  SPECIAL CASE - EMPTY SET , when sum=0 , o/p=1 given no negative 
 *    arr={10,15,20}
 *    sum=0
 *    Subset with sum 0 = {} o/p=1
 * 
 *
 *  Recursion anaysis :
 *   
 *  arr= 10,20,15 sum=25 
 *  
 *  Two cases  1) Considered 2) Not considered 
 *  Can traverse from left or right 
 *  
 *                                      { }
 *                                  /         \
 *                n=3 no consi  { }            15     n=3 Considered 
 *                            /     \          /    \   
 *                         { }     20         15      15,20   n=2
 *                       /   \    /  \       /  \      /   \
 *                    { }   10  20 10,20   15 15,10  15,20  15,20,10  n=1
 *                    
 *                    Time = T N = 2 T (N) + O 1
 *                         = O 2^N 
 *   Recur  2 O^N 
 *   
 *   for recur arr,n-1,sum 
 *   
 *   if n<0 
 *     if sum==0 return 1
 *     else return 0 
 *   
 *   int include=Recur(arr,n-1,sum-arr[i])
 *   int No include = REcur(arr,n-1,sum)
 *   
 *   return include+No Include 
 *     
 *  MEMO 
 *  
 *  memo[n+1][sum+1]
 *                    
 *                         
 *  Dynamic solution   Time = N*sum
 *  
 *  Table [n+1][sum+1]
 *  
 *  table i j -> Count of subsets in arr 0 to i-1 with sum j 
 *  
 *  In table , table[0][]=0 and table[][0]= 1 sum 0 all elements 1 
 *       table[0][0]=1 even if 0 element , sum 0 = 1
 *       
 *  As we are using sum as index sum must not be negative 
 *  For table i j 
 *  if j<arr[i-1]  sum<element value X do not procced 
 *     table ij = table[i-1][j] prev solution for the sum 
 *  else 
 *     Not included= table[i-1][j] prev sol for the sum 
 *     Included = table[i-1][j - arr[i-1]
 *     table ij= included + Not included 
 *     
 *  Fill row by row as prev row value is needed 
 *     
 *  Row by Row Traversal is preferred as it is more cache friendly    
 *     
 *   
 *  
 *     
 *      
 *  
 *  
 *  
 * @author shree
 *
 */
public class DP24_Subset_Sum_Problem {

	public static void main(String[] args) {
		// Subset with sum 
		int arr[]= {10,5,2,3,6};
		int n=arr.length;
		int sum=8;
		
		//Recur sol  1 without sum 
		int sol=SubSet_recur(arr,n-1,sum,0);
		System.out.println(" Ans is "+sol);
		
		//Recur sol with sum  
		
		sol=SubSet_sum_recur(arr,n-1,sum);
		System.out.println(" Ans with sum is "+sol);
		
		
		// Memo 
		int memo[][]=new int[n][sum+1];
		sol=SubSet_sum_memo(arr,n-1,sum,memo);
		System.out.println(" Ans with sum is "+sol);
		for(int i=0;i<n;i++) {
		System.out.println(" Memo table "+Arrays.toString(memo[i]));
		}
		
		
		//Table Dynamic 
		sol=SubSet_sum_Table(arr,n,sum);
		System.out.println(" Ans with Table is "+sol);
	}

	private static int SubSet_sum_Table(int[] arr, int n, int sum) {
		// Table 
	    int table[][]=new int[n+1][sum+1];
	    //Base cases
	    Arrays.fill(table[0],0);// element 0 val 0 
	    table[0][0]=1; // execpt for sum == 0 
	    for(int i=0;i<n+1;i++) {
	    	table[i][0]=1;   // sum=0 ans alwways 1 
	    }
	    
	    // As we are using sum as index sum must not be negative 
	    for(int i=1;i<n+1;i++) {
	    	for(int j=1;j<sum+1;j++) {
	    		
	    		// arr 1 => actual val of arr 0 , arr n == arr[n-1]
	    		if(j<arr[i-1]) {//sum val < arr val 
	    			table[i][j]=table[i-1][j];//prev val 
	    		}
	    		else {
	    			int included=table[i-1][j-arr[i-1]];
	    			int NoInc = table[i-1][j];
	    			table[i][j]=included+NoInc;
	    		}
	    	}
	    }
	    
	    for(int i=0;i<n+1;i++) {
	    	System.out.println(" Table "+Arrays.toString(table[i]));
	    }
	    
		return table[n][sum];
	}

	private static int SubSet_sum_memo(int[] arr, int n, int sum, int[][] memo) {
		//use to visualize memo 
		if(sum==0) {
			memo[n][sum]=1;
			return 1;
		}
		if(n<0 || sum<0) {
			
		//	memo[n][sum]=-1;
			return 0;
		}
		
		if(memo[n][sum]==-1) {
			return 0;
		}
		else if(memo[n][sum]!=0) {
			return memo[n][sum];
		}
		
		int include=SubSet_sum_memo(arr, n-1, sum-arr[n], memo);
		int Noinclude=SubSet_sum_memo(arr, n-1, sum, memo);
		
		int ans=include+Noinclude;
		memo[n][sum]=ans;
		return ans;
		
	}

	private static int SubSet_sum_recur(int[] arr, int n, int sum) {
		// subset subtract sum 
		
		if(sum==0) {
		//	System.out.println(" Val found ");
			return 1;
		}
		if(n<0 || sum<0) {
	//		System.out.println(" Stop ....");
			return 0;
		}
		
		int include=SubSet_sum_recur(arr, n-1, sum-arr[n]);
		int Noinclude=SubSet_sum_recur(arr, n-1, sum);
		int ans=include+Noinclude;
		
		return ans;
	}

	private static int SubSet_recur(int[] arr, int n, int sum,int currSum) {
		// subset two choice , include not include 
		int ans=0;
		if(currSum==sum) {
			System.out.println(" At n is "+n);
			ans=ans+1;
			return 1;
		}
	
		
		if(n<0) {
			return 0;
		}
		
		int include=SubSet_recur(arr,n-1, sum, currSum+arr[n]);
		int NoInclude=SubSet_recur(arr,n-1, sum, currSum);
		ans=ans+include+NoInclude;
		
		return ans;
	}
}
