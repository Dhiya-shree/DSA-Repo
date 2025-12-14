package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Coin Change Problem 
 * 
 * Given infinite number of every coin type and a sum 
 * 
 * Find the maximum ways the sum can be made with coins 
 * 
 * Example coins - 1,2,3  sum - 4 
 * Ans :
 *   1+1+1+1
 *   1+1+2
 *   2+2
 *   1+3
 *   2uum
 *  Max combo : 4 
 *  
 * Example2 
 * Coins 2,3,5,6  Sum 10 
 * Ans :
 * 2+2+2+2+2
 * 2+2+3+3
 * 2+2+6
 * 5+5
 * 2+3+  
 * 
 * Combo : 5
 * 
 * 
 * 
 * Idea for recursive solution : 
 * 
 * Recursion O 2^n
 * 
 * coins set= x0,x1,x2.....xn;
 * sum = s
 * Two choices for every coin 
 *        1) Included 
 *        2) Not included
 * 
 * Return sum of result = Included + not included
 * 
 * 
 * CountWays(coin ,s,n)
 * Base case sum=0 add 1 
 *           sum<0 return 0
 * 
 * 
 * coin = 1,2,3
 * sum=4                        For 3 
 *                           coin  | sum
 *                           1,2,3 | 4 
 *                          /         \
 *                   	Included     Not Included
 *                      1,2,3|1        1,2 |4
 *                    /     \              | 
 *                1,2,3|0    Use3        Use 2
 *                 1 val     Use2      1,2 | 4
 *                                     /       \
 *                                 1,2|2         1|4
 *                               /      \           \      
 *                            1,2|0    1|2          Use 1 - 1 val
 *                             Val1       \
 *                                         Use1 val1
 *  Combo - 1+3,2+2,2+1,1+1+1+1
 *  Ans = 4 
 * 
 * 
 *  Time O 2^N
 * 
 * 
 *  Dynamic memo :
 *  
 *  Dynamic O n*sum time and space `
 *  
 *  Memo recur (coin pos sum memo)
 *  
 *  BASE sum=0 return 1
 *       sum<0 / pos<0 return 0
 *                                   
 *       memo[pos][sum]!=0 
 *           ---> return memo 
 *       
 *       else 
 *       included = memo recur (coins pos sum-coin.pos memo )
 *     aq  Not included = memo[pos-1][sum]  (coins pos-1 sum memo )
 *       
 *       memo pos.sum = included + Not included 
 *       
 *       return memo pos.sum
 *       
 * Dynamic Table 
 * 
 * Table row= n no of coins 
 *       col = 0 to sum 
 *       
 *  for int s=0 ; s< sum+1 ; s++
 *     for int p=1 ; p<n+1 ; p++  p=0 always 0 
 *     
 *     
 *     if s==0 => sum 0 ans=1 base case 
 *     
 *     else if s<coin[p-1] p-1 for array 0 to n-1 in place of 1 to n 
 *          if coin value high , just place prev sum value 
 *          table ps= table[p-1][s] 
 *     
 *     else 
 *     table ps= table[p-1][s] + // not included
 *                  table[p][s - coin(p-1) ] //included 
 *                  
 *                  
 *     
 * @author shree
 *
 */

public class DP11_Coin_Change_Problem {

	public static void main(String[] args) {
		// coin change 

		int coins[]= {1,2,3};
		int sum=4;
		
		//Recursion 
		int ans=CountWays_Recur(coins,sum,coins.length-1);
		System.out.println(" Answer recur "+ans);
		
		//Memo 
		int n=coins.length;
		int memo[][]=new int[n][sum+1];
		
		ans=CountWays_Memo(coins,sum,n-1,memo);
		System.out.println(" Answer dynamic memo "+ans);
		
		for(int i=0;i<n;i++) {
			System.out.println("Memo pos "+i+" is "+Arrays.toString(memo[i]));
		}
		//Table 
		ans=CountWays_Table(coins,sum);
		System.out.println(" Answer Dynamic table "+ans);
		ans=CountWays_Table2(coins,sum);
		System.out.println(" Answer Dynamic table "+ans);
		ans=CountWays_Table_1Table(coins,sum);
		System.out.println(" Answer Dynamic table "+ans);
	}

	private static int CountWays_Table2(int[] coins, int sum) {
		// table bottom up approach 
		int n=coins.length;
		int table[][]=new int[sum+1][n+1];
		int val=0;int val1=0,val2=0;
		for(int s=0;s<sum+1;s++) {
			for(int p=0;p<n+1;p++) {
				// we start from 0 to avoid additional if else 
				// so when checking for coins 1 is for 0 , 2 is for 1 ,... n is for n-1 in coins 
				int coin_pos=p-1;
				if(s==0) {
					table[s][p]=1;
				}
				else if(p==0) {
					table[s][p]=0;// start p from 1 instead 
				}
				else if(coins[coin_pos]>s) {
					table[s][p]=table[s][p-1];
					// get prev count for the sum 
					//sum=2 coin=3
					// value of table 2,2 
				}
				else {
					// prev count NOT included  sum=4 do not consider 3 ,table  2,4 ans 
					// Include sum=4 coin=1 subracted sum=4-1=3 find for table 1,3 ans 
					System.out.println(" At sum "+s+"-"+p+" coins till "+coins[coin_pos]+" Value"
							+ " to add "+table[s][p-1]+" and "+table[s-coins[coin_pos]][p]);
					table[s][p]=table[s][p-1]+table[s-coins[coin_pos]][p];
				}
			}
		}

		for(int i=0;i<sum+1;i++) {
			System.out.println("Table at pos "+i+" is "+Arrays.toString(table[i]));
		}
		return table[sum][n];
	}

	private static int CountWays_Table_1Table(int[] coins, int sum) {
		// use only 1 table 
		int n=coins.length;
		int table[]=new int[sum+1];

		for(int i=0;i<sum+1;i++) {
			table[i]=0;
			for(int j=0;j<n;j++) {
				
				if(i==0) {
					table[i]=1;
				}
				else if(coins[j]==i) {
					table[i]=table[i]+1;
				}
				else if(coins[j]<i) {
					System.out.println(" At sum "+i+" coins till "+coins[j]+" Value"
							+ " to add "+table[i]+" and "+table[i-coins[j]]);
					table[i]=table[i-coins[j]]+table[i];
				}
				System.out.print(table[i]+" ");
			}
			System.out.println();
		}
		
		return table[sum];
	}

	private static int CountWays_Table(int[] coins, int sum) {
		// table bottom up approach 
		int n=coins.length;
		int table[][]=new int[n+1][sum+1];
		int val=0;int val1=0,val2=0;
		for(int s=0;s<sum+1;s++) {
			for(int p=0;p<n+1;p++) {
				// we start from 0 to avoid additional if else 
				// so when checking for coins 1 is for 0 , 2 is for 1 ,... n is for n-1 in coins 
				int coin_pos=p-1;
				if(s==0) {
					table[p][s]=1;
				}
				else if(p==0) {
					table[p][s]=0;// start p from 1 instead 
				}
				else if(coins[coin_pos]>s) {
					table[p][s]=table[p-1][s];
					// get prev count for the sum 
					//sum=2 coin=3
					// value of table 2,2 
				}
				else {
					   // prev count NOT included  sum=4 do not consider 3 ,table  2,4 ans 
					   // Include sum=4 coin=1 subracted sum=4-1=3 find for table 1,3 ans 
					table[p][s]=table[p-1][s]+table[p][s-coins[coin_pos]];
				}
			}
		}
		
		for(int i=0;i<n+1;i++) {
			System.out.println("Table at pos "+i+" is "+Arrays.toString(table[i]));
		}
		return table[n][sum];
	}

	private static int CountWays_Memo(int[] coins, int sum, int pos, int[][] memo) {
		// memo 
		//Base case 
				if(sum==0) {
					return 1;
				}
				if(sum<0) {
					return 0;
				}
				
				if(pos<0) { 
					return 0;
				}
				
		// memo 
		if(memo[pos][sum]!=0) {
			return memo[pos][sum];
		}
		
		                        // inc                              //exc 
		memo[pos][sum]=CountWays_Memo(coins, sum-coins[pos], pos, memo)+CountWays_Memo(coins, sum, pos-1, memo);
		
		return memo[pos][sum];
	}

	private static int CountWays_Recur(int[] coins, int sum,int pos) {
		// count ways 
		
		//Base case 
		if(sum==0) {
			return 1;
		}
		if(sum<0) {
			return 0;
		}
		
		if(pos<0) { 
			return 0;
		}
		
		int n=pos;
		
		// Included   1,2,3 sum 4   inc= 1,2,3 sum 1 
		int included=CountWays_Recur(coins, sum-coins[n],pos);
		
		//Not included count    1,2,3 sum 4 nInc= 1,2 sum 4 
		int notIncluded=CountWays_Recur(coins, sum, pos-1);
		
		
		return included+notIncluded;
	}

}
