package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Maximum sum with No consecutives 
 * 
 * Given an array , find the maximum sum with non consecutive values
 * Ex : 1,2,3 
 * 1,2 consecutive  , 2,3 conecutive
 * Possible outcome : 1,2,3,1+3
 * Maximum value = 4(1+3)
 * 
 * Ex arr={1,10,2} o/p=2
 * 
 * Ex arr={8,7,6,10}
 *    Posible outcomes : 8,7,6,10,8+6,8+10,7+10 (non consecutive)
 *    Maximum : 18 8+10
 * 
 * Ex arr={10,5,15,20,2,30}
 *   Possible outcomes: 10+15+30,10,20,30....
 *   Maximum : 60 10+20+30 
 *   
 * 
 * Start from n-1   -> arr,n
 * |------Without last ------|
 * 0 1 2 3 4 ...... n-3 n-2 n-1 n 
 * |++++++ With last ++++|      |+ add n 
 * For n 
 * Two choices at every place 
 *   1) Make last part of solution => arr[n-1]+ Max array (arr,n-2)
 *   2) Make solution without curr n-1  => Max array (arr,n-1)
 *   
 * Recursive sol 
 * 
 * Maximum arr , n 
 *  
 *  if n==1 return arr[n]
 *  if n==2 return max arr[0],arr[2]
 *  else
 *    Without picking N (n-1) = Recur Maximum arr,n-1
 *    With picking n-1(N) = arr[n-1] + Maximum arr,n-2
 *    
 *    
 *  Ex consider n=3 in 8,7,6,10 
 *  With picking = 10 + Maximum arr 8,7 = 10+8=18 
 *  Without picking = Maximum of 8,7,6 
 *                  = Maximum of 6+ 8,7  && Maximum of 8,7 
 *                  = 6+8 , 8 
 *                  = 14 
 *   Ans = 18 
 * 
 *  Recursive Solution analysis :
 *                                 maxSum 5 
 *                               /          \
 *                       mS of 4            5+ ms of 3 
 *                     /    \                    /     \
 *                  ms 3    4+ms of 2       ms of 2      3+ms of 1 
 *                /   \            |           |                |
 *             ms 2   3+ms2         max        max             arr0
 *             |         |
 *            max        max
 *            
 *            Time T N = T N-1 + T N-2 + O 1 
 *                 Time= O 2^N
 *                     
 *            
 *  Dynamic Table solution : Time= O N Space = O N 
 *  
 *   Table[n]
 *   table i -> stores result array of length i 
 *   
 *   table[0]=arr[0]  // 0 fixed 
 *   table[1]= max arr[0],arr[1] // 1 fixed 
 *   
 *   for i=2 to n
 *      consi = arr[i]+max[i-2]
 *      Noconsi= max[i-1]
 *      table[i]=Max of consi,NoConsi 
 *   
 *   return table[n-1]
 *  
 *  
 *  Dynamic Table + O 1 Space 
 *  
 *  Instead of table , maintain 3 variable 
 *  
 *  res-> maximum result 
 *  prev -> for table[i-1]
 *  prev_prev -> for table [i-2]
 *  
 *  
 *  Start 
 *  prev_prev=arr[0]
 *  prev=Max of arr[0],arr[1]
 *  res=prev;
 *  
 *  for i=3 to N 
 *  
 *     res=max of prev , arr[i]+prev_prev
 *     prev_prev=prev
 *     prev=res
 *     
 * return res
 * 
 * 
 * @author shree
 *
 */
public class DP23_MaxSum_No_2_Consecutive {

	public static void main(String[] args) {
		//Maximum sum with no two consecutive 

		int arr[]={10,5,15,20,2,30,40,2,14,35,21,2,9,0};
		int n=arr.length;
		long st=0;
		long et=0;
		
		//Recur 
		st=System.currentTimeMillis();
		int sol=MaxSum_recur(arr,n);
		et=System.currentTimeMillis();
		System.out.println(" Time is "+(et-st));
		System.out.println(" Recur sol is "+sol);
		
		//Memo
		st=System.currentTimeMillis();
		int memo[]=new int[n+1];
		//Base case 
		// Consider 0 to N-1 as 1 to N 
		if(n==1) {
			System.out.println(" ANs is "+arr[0]);
		}
		else if(n==2) {
			System.out.println(" ANs is "+Math.max(arr[0],arr[1]));
		}
		else {
		memo[1]=arr[0];
		memo[2]=Math.max(arr[0],arr[1]);
		sol=MaxSum_Memo(arr,n,memo);
		et=System.currentTimeMillis();
		System.out.println(" Time is "+(et-st));
		System.out.println(" Memo ans is "+sol);
		System.out.println(" Memo is "+Arrays.toString(memo));
		}
		
		
		// TABLE 
		st=System.currentTimeMillis();
		sol=MaxSum_Table(arr,n);
		et=System.currentTimeMillis();
		System.out.println(" Time is "+(et-st));
		System.out.println(" Table ans is "+sol);
		
		// Dynamic Space 1 
		sol=MaxSum_Best(arr,n);
		System.out.println(" Max sum best "+sol);
	}

	private static int MaxSum_Best(int[] arr, int n) {
		// space O 1 
		if(n==1) {
			return arr[0];
		}
		int prev_prev=arr[0];
		int prev=Math.max(arr[0], arr[1]);
		int res=prev;// for arr of 2 
		System.out.println(" Values space 1 ....");
		System.out.print(prev_prev+" "+prev+" ");
		for(int i=2;i<n;i++) {
			int consi=arr[i]+prev_prev;
			int NoConsi=prev;
			res=Math.max(consi,NoConsi);
			System.out.print(res+" ");
			//Update 
			prev_prev=prev;
			prev=res;
		}
		return res;
	}

	private static int MaxSum_Table(int[] arr, int n) {
		// create table
		int table[]=new int[n];
		
		//Base case 
		table[0]=arr[0];
		table[1]=Math.max(arr[0],arr[1]);
		
		for(int i=2;i<n;i++) {
			int consi=arr[i]+table[i-2];//i-1 can not be considered 
			int NoConsi=table[i-1];// i not considered 
			table[i]=Math.max(consi, NoConsi);
		}
		System.out.println(" Table is "+Arrays.toString(table));
		
		return table[n-1];
	}

	private static int MaxSum_Memo(int[] arr, int n, int[] memo) {
		// use memo 
		if(memo[n]!=0) {
			return memo[n];
		}
		if(n<0) {
			System.out.println(" Negative N ");
			return 0;
		}
		// 1,2 base cases , remaining with sub below will work 
		int Consider=arr[n-1]+MaxSum_Memo(arr, n-2,memo);
		int NoConsider=MaxSum_Memo(arr,n-1,memo);
		int ans=Math.max(Consider, NoConsider);
        memo[n]=ans;
		
		return ans;
	}

	private static int MaxSum_recur(int[] arr, int n) {
		// Recurring for 1 to N as 0 to N-1 
		if(n==1) {
			return arr[0];
		}
		if(n==2) {
			return Math.max(arr[0],arr[1]);
		}
		
		// 1,2 base cases , remaining with sub below will work 
		int Consider=arr[n-1]+MaxSum_recur(arr, n-2);
		int NoConsider=MaxSum_recur(arr,n-1);
		int ans=Math.max(Consider, NoConsider);
		
		return ans;
	}

}
