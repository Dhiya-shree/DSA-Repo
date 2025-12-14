package dynamic_programming;

import java.util.Arrays;

/**
 *   
 *  0-1 Knapsack problem    :::  N P HARD Problem 
 *  
 *  
 *  Dynamic solution is time O N*W 
 *  It is NOT polynomial solution 
 *  
 *  We have W instead of N . W may be very high W>>>> N possible .
 *  It is called pseudo - polynomial solution 
 *  
 *  Dynamic can be worst for W>>>>>N 
 *  
 *  Knapsack 0-1 problem difficult to solve , in the sub group NP Hard problem 
 *  Solution of dynamic is not polynomial , but pseudo polynomial 
 *  
 * 
 *  Given value and weight of an array of objects and weight of knapsack 
 *  
 *  Find the elements to Maximize value of knapsack 
 *  
 *  An element can either be considered 1 or not considered 0   
 *  
 *  
 *  Sol1 :
 *  Greedy solution 
 *  find ratio weight/value 
 *  Fill in knapsack as per order of ratio 
 *  
 *  ex w= 60 100 120 
 *     v= 10  20  30 
 *     
 *     Knapsack=50 
 *     
 *     30/120>20/100>10/60
 * 
 *  For some certan value greedy may not work 
 * 
 * Recur 
 * 
 * if(knapsack==0)
 *    return 0
 *    
 * if(k<0 || i <0)
 *    return -1 
 * 
 * For every value , two possibility 
 *            ans1 - considered  recur k-wi,n  !!!! even in considered recur k-wi , n-1 // same element can not be used twice 
 *            ans2 - not considered  recur k,n-1
 *            
 *      if(ans1!=-1)
 *          max=ans1+1
 *      if(ans2!=-1)
 *          max=min of min,ans2
 *          
 *  
 * Time : T N =2( T(N-1) )+O 1
 * Recur time = 2^N
 *  
 * Dynamic 
 * 
 * Dynamic time : O W*n 
 * Dynamic Space : O W*n
 * 
 * If weight of knapsack is very high and n very small then Dynamic is worst 
 * 
 * N=5 W=1000
 * recur = 2^5=32 
 * Dynamic = 1000*5=5000
 * 
 * Dynamic can be used only when W*n<2^n
 * 
 * Create memo 2D memo[n+1][W+1]   W - knapsack weight 
 * 
 * memo ij -> maximum value that we collect with first i items and knapsac capacity j 
 * 
 * Ex 
 * memo col 0 and row 0 : val=0 
 * 
 * memo 1,1
 * 
 * element 1 weight vs knapsack weight 1 
 * 
 * if weight<=element , memo [n][W]=val 
 * 
 * 
 * 
 * 
 * Table 
 * 
 * table col 0 and row 0 : val=0 
 * 
 * table 1,1
 * 
 * element 1 weight vs knapsack weight 1 
 * 
 * if weight<=element , table [n][W]=val 
 * 
 * 
 * 
 * 
 * for int i=1 to n+1 elements 
 *    for int j=1 to k+1 weight 
 *    
 *    
 *      if element's weight> knapsack j 
 *         Can not keep element 0 val 
 *         table[i][j]=table[i-1][j] // maximum possible val for j weight till i-1 used 
 *         
 *      else  
 *        val = element value + table[i-1][ j-element weight] // i-1 as element can be included only once 
 *                                     // max possile till i-1 where weight= j- element weight 
 *                                     
 *        table[i][j]= maximum of val , 
 *                           table[i-1][j] // to maintain the max possible val as the one above 
 *       
 *   return table[n][k]
 * 
 * 
 * 
 * @author shree
 *
 */
public class DP19_01_KnapSack_Problem {

	public static void main(String[] args) {
		
		int val[]= {10,40,30,50,11,12,13,14,15,67,43,1,55,77,4,2,4,2,1,4};
		int weight[]= {5,4,6,3,3,2,1,5,8,6,4,5,7,8,5,3,2,9,1,6};
		int k=10;
		int n=val.length;
		counter=0;
		int sol=KS01_Recur(val,weight,n-1,k,0);
		System.out.println(" Knapsack ans "+sol+" at "+counter);
		
		counter=0;
		int memo[][]=new int[n+1][k+1];
	
		Arrays.fill(memo[0],0);  // 0 element 0 val 
		for(int i=1;i<n+1;i++) {
			Arrays.fill(memo[i], Integer.MIN_VALUE);
			memo[i][0]=0; // no weight 0 val 
		}
		sol=KS01_Memo(val,weight,n-1,k,0,memo);
		System.out.println(" Knapsack ans "+sol+" at "+counter);
		for(int i=0;i<n+1;i++) {
		System.out.println(" Memo is "+Arrays.toString(memo[i]));
		}
		
		counter=0;
		sol=KS01_table(val,weight,n,k);
		System.out.println(" Knapsack ans "+sol+" at "+counter);
}

	private static int KS01_table(int[] val, int[] weight, int n, int k) {
		// table 
		
		int table[][]=new int[n+1][k+1];
		
		/*Arrays.fill(table[0],0);
		for(int i=1;i<n+1;i++) {
			Arrays.fill(table[i],-1);
			table[i][0]=0;
		}*/
		
		for(int i=1;i<n+1;i++) {// i=1 means first element v0,w0 
			for(int j=1;j<k+1;j++) {  
				
				if(weight[i-1]>j) {
					// weight of element greater than knapsack 
					table[i][j]=table[i-1][j];
					//Blindly consider above value for the weight 
					//Maximize weight 
					// So for that weight , maximum value is taken 
				}
				else {
					table[i][j]=Math.max(table[i-1][j],     // by checking with above val at every case , the max will be always maintained as prev val 
							  val[i-1]+ 
							    table[i-1][j-(weight[i-1])]);   //  for k=10 element3= w=4 val=50 
					// table 4,50 / 10 = 50 + (10-4)maximum 
					// table 4,50 / 10 = 50 + max for w=[6]  // always above keeps maximum track 
					// table 4,50 / 10 = 50 + table[3][6]
				}
				
			}
		}
		
		for(int i=0;i<n+1;i++) {
			System.out.println(" Table at "+i+" is "+Arrays.toString(table[i]));
		}
		
		return table[n][k];
	}

	static int counter;
	private static int KS01_Memo(int[] val, int[] weight, int n, int k, int v, int[][] memo) {
		//recur 
		if(k==0) {
			return v;
		}
		if(k<0 ||n<0) {
			return -1;
		}

		if(memo[n][k]!=Integer.MIN_VALUE) {
		//	System.out.println(" Memo used ");
			return memo[n][k];
		}
	//	System.out.println(" At n "+n+" k is "+k+" v is "+v);
		//System.out.println("Running ......"+counter);
		counter++;
		int max=v;
		int consider=-1;int Noconsider=-1;
		if(k>=weight[n]) {
			//System.out.println(" Recur "+k+"  minus "+weight[n]+"== "+(k-weight[n])+" val is "+(v+val[n]));	
			// MUST to give N-1 as value can be considered only once 
			consider=KS01_Memo(val, weight,n-1, k-weight[n],v+val[n],memo);
			max=Math.max(consider,max);
		}
		if(n>0) {
			Noconsider=KS01_Memo(val, weight,n-1, k,v,memo);
		    max=Math.max(Noconsider,max);
		}
		//System.out.println(" At n "+n+" k is "+k+" v is "+v+" with max "+max+"  consi-No "+consider+"-"+Noconsider);
		memo[n][k]=Math.max(max, memo[n][k]);
		return max;
	}

	private static int KS01_Recur(int[] val, int[] weight, int n, int k,int v) {
		//recur 
		if(k==0) {
			return v;
		}
		if(k<0 ||n<0) {
			return -1;
		}
	//	System.out.println("Running ......"+counter);
		counter++;
		int max=v;
	//	System.out.println(" At n "+n+" k is "+k+" v is "+v);
		int consider=-1;int Noconsider=-1;
	    if(k>=weight[n]) {
	       //System.out.println(" Recur "+k+"  minus "+weight[n]+"== "+(k-weight[n])+" val is "+(v+val[n]));	
	    	// MUST to give N-1 as value can be considered only once 
	    	consider=KS01_Recur(val, weight,n-1, k-weight[n],v+val[n]);
	    	max=Math.max(consider,max);
	    }
	    if(n>0)
	    	Noconsider=KS01_Recur(val, weight,n-1, k,v);
		    max=Math.max(Noconsider,max);
		//System.out.println(" At n "+n+" k is "+k+" v is "+v+" with max "+max+"  consi-No "+consider+"-"+Noconsider);
		return max;
	}

}
