package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Minimum jumps needed to reach the end 
 * 
 * Given input array , every element value denotes the number f jumps that can be made from that 
 * particular point in array 
 * 
 * ex arr={3,4,2,1,2,1}
 * len arr=5 
 * 
 * Start from arr0 3 , arr0 to 1,2,3 possible to go 
 * arr1 4 , arr1 to arr 2,3,4,5 possible 
 * 
 * Minimum no of jumps= arr0(3) --> arr1(4) --> arr5 
 *                       start   1           2  end 
 *                       Jumps = 2 jumps 
 * 
 * ex2 : arr={4,1,5,3,1,3,2,1,8}
 *   o/p : 3 
 *   
 *   
 * Recur : arr,i 
 * 
 * minTot
 * minSb
 *    val of i=x 
 *    for j=i+1 to i+x
 *       minsub=min of minsub , recur(arr,j)
 *    min= min of min,minsub
 *    
 * return min
 * 
 * Dynamic  O N^2 Time 
 *          O N space 
 * 
 * Memo 
 * 
 * Memo : arr,i,memo
 * 
 * minTot
 * minSb
 *    val of i=x 
 *    for j=i+1 to i+x
 *       minsub=min of minsub , memo(arr,j,memo)
 *    min= min of min,minsub
 *    
 * return min
 * 
 * 
 * Table 
 * 
 * table[n+1]
 * table table0=0 , others MAX_VALUE
 * 
 *
 * 
 * @author shree
 *
 */
public class DP18_Min_Jumps_To_end {

	public static void main(String[] args) {
		// minimum jumps to reach the end
        int arr[]={4,1,5,3,1,3,2,1,8};
        int n=arr.length;
        
        //Recur 
        int sol=Min_Jumps(arr,n,0);
        System.out.println(" Minimum jumps recur "+sol);
        
        //Memo 
        // use 1 d array 
        
        int memo[]=new int[n+1];
        memo[0]=0;
        sol=Min_Jumps_Memo(arr,n,0,memo);
        System.out.println(" Minimum jumps memo "+sol);
        System.out.println(" Memo  "+Arrays.toString(memo));
        
        sol=Min_Jumps_Table(arr,n);
        System.out.println(" Minimum jumps table in rev "+sol);
        
        sol=GoG_Min_Jumps_Table(arr,n);
        System.out.println(" Minimum jumps table in order bottom-up "+sol);
        
        int arr2[]= {8,1,2,3,1,3,5,1,4};// {4,1,5,3,1,3,2,1,8};
        sol=GoG_Min_Jumps_Table(arr2,arr2.length);
        System.out.println(" Minimum jumps table in order bottom-up for rev "+sol);
        
	}

	private static int GoG_Min_Jumps_Table(int[] arr, int n) {
		// table
		
		int table[]=new int[n];
		Arrays.fill(table,Integer.MAX_VALUE);
		table[0]=0;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]+j>=i) {
					if(table[j]!=Integer.MAX_VALUE) {
						
						table[i]=Math.min(table[i], table[j]+1);
					}
				}
			}
		}
		
		System.out.println(" Table gog "+Arrays.toString(table));
		return table[n-1];
	}

	private static int Min_Jumps_Table(int[] arr, int n) {
		// table 
		int table[]=new int[n];
		
		//Initialize 
		Arrays.fill(table,Integer.MAX_VALUE);
		table[n-1]=0;
		
		for(int i=n-2;i>=0;i--) {
			int val=arr[i];
			table[i]=Integer.MAX_VALUE;
			for(int j=i+1;j<n && j<=i+val;j++) {
				table[i]=Math.min(table[i],table[j]+1);
			}
		}
		
		System.out.println(" Table "+Arrays.toString(table));
		 
		return table[0];
	}

	private static int Min_Jumps_Memo(int[] arr, int n, int idx, int[] memo) {
		// memo
		
		if(idx>=n-1) {
			return 0;
		}
		int min=Integer.MAX_VALUE;
		int subMin=Integer.MAX_VALUE;

		int val=arr[idx];
		if(val<=0) {
			return min;
		}
		
		if(memo[idx]!=0 ) {
			return memo[idx];
		}
		for(int i=idx+1;i<=val+idx && i<n;i++) {
			subMin=Min_Jumps(arr,n,i);

			if(subMin!=Integer.MAX_VALUE) {
				subMin=subMin+1;
			}
			min=Math.min(min,subMin);
		}

		memo[idx]=min;
		return min;
	}

	private static int Min_Jumps(int[] arr, int n, int idx) {
		// recursion 
		
		if(idx>=n-1) {
			return 0;
		}
		int min=Integer.MAX_VALUE;
		int subMin=Integer.MAX_VALUE;
		
		int val=arr[idx];
		if(val<=0) {
			return min;
		}
		for(int i=idx+1;i<=val+idx && i<n;i++) {
			subMin=Min_Jumps(arr,n,i);
			
			if(subMin!=Integer.MAX_VALUE) {
				subMin=subMin+1;
			}
			min=Math.min(min,subMin);
		}
		
		return min;
	}

}
