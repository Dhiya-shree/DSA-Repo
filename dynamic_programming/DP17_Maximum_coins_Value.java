package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Minimum coins to make a value 
 * 
 * 
 * Given a array of coins and value .
 * Given infinite supply of every coin
 * 
 * Ex coins : 25 10 5 
 *    val : 30 
 *    
 *  Greedy approach :
 *  30 - max(10 25 5) & less than val =25  
 *  5 - max(10 25 5 ) & less than val=5
 *  0 - stop ans=2
 *  
 * Ex coins 9 6 5 1 val=11
 * 11 9,6,5,1  -9 
 * 2  9,6,5,1  -1
 * 1  9,6,5,1  -1
 * 0 stop coins = 3
 * Above is not correct , max coins= 2 6 and 5 
 * 
 * Use Dynamic approach 
 * 
 * 
 * Recur sol :
 * 
 * For any coins 
 * 
 * Possibility to consider any of coins 
 *     With a coin 
 *     Without a coin 
 *     
 *       9,6,5,1 11
 *       /           \ 
 *   9,6,5,1 2        6,5,1 11
 *   
 *   recur val,coin,n 
 *   
 *   if(val==0)
 *     return 0;
 *   
 *   if(coin.n<=val)
 *   int consider =1+ recur val-coin.n , coin , n
 *   
 *   int Noconsider= recur val,coin,n-1
 *   
 * 
 * Dynamic   O N*Val time and O Val space 
 * 
 *  Memo 
 *  
 * memo[n] 
 *  
 *   if(val==0)
 *     return 0;
 *  
 *   memo[val]!=0
 *   return memo[val]
 *   
 *   if(coin.n<=val)
 *   int consider =1+ recur val-coin.n , coin , n
 *   
 *   int Noconsider= recur val,coin,n-1
 *   
 *   memo=Min(consider , no consider)
 * 
 * @author shree
 *
 */
public class DP17_Maximum_coins_Value {

	public static void main(String[] args) {
		// Maximum coins to make a value 

		int coins[]= {9,6,5,1};
		int n=coins.length;
		int val=11;
		
		
		//REcur 
		
		int sol=GOG_Recur(coins,n,val);
		System.out.println(" GOG recur "+sol);
		
		//GOG MEMO 
		int memo[]=new int[val+1];
		sol=GOG_Memo(coins,n,val,memo);
		System.out.println(" GOG memo "+sol);
		System.out.println(" Memo array "+Arrays.toString(memo));
		
		//GOG Table 
		sol=GOG_Table(coins,val,n);
		System.out.println(" Table GOG ans "+sol);
		
		//Recur 
		int ans=Min_Coin_Recur(val,coins,n-1);
		System.out.println("Recursion ans "+ans);
		
		//Memo 
		memo=new int[val+1];
		ans=Min_Coin_Memo(val, coins,n-1,memo);
		System.out.println(" Memo array "+Arrays.toString(memo));
		System.out.println(" Memo ans "+ans);
	}

	private static int GOG_Table(int[] coins, int val, int n) {
		// create table 
		int table[]=new int[val+1];
		
		// table 1 - minimum coins required to get value i 
		// Fill table with MAX VALUE 
		Arrays.fill(table,Integer.MAX_VALUE);
		
		// Must to fill with max as finding minimum 
		// MUST TO fill table 0 as 0 
		table[0]=0;
		
		//without table0=0 all will be max_value 
		
		//Table bottom up approach 
		
		//Sort coins to less the work 
		Arrays.sort(coins);
		
		for(int i=1;i<val+1;i++) {
			
			for(int j=0;j<n && coins[j]<=i;j++) {
				
				table[i]=Math.min(table[i],table[i-coins[j]]+1);
			}
		}
		System.out.println(" Table "+Arrays.toString(table));
		return table[val];
	}

	private static int GOG_Memo(int[] coins, int n, int val, int[] memo) {
		// memo 
		if(val==0) {
			return 0;
		}
		
		int res=Integer.MAX_VALUE;
		if(val<0 ||n<0) {
			return res;
		}
		
		if(memo[val]!=0) {
			return memo[val];
		}
		for(int i=0;i<n;i++) {
			
			if(coins[i]<=val) {
				
				int subres=GOG_Memo(coins,n,val-coins[i],memo);
				
				if(subres!=Integer.MAX_VALUE) {
					res=Math.min(res, subres+1);//Add 1 here only if sol exist val==0
				}
			}
		}
		
		memo[val]=res;
		return res;
	}

	private static int GOG_Recur(int[] coins, int n, int val) {
		// gog recur 
		
		if(val==0) {
			return 0;
		}
		
		int res=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			if(coins[i]<=val) {
				int sub_res=GOG_Recur(coins, n, val-coins[i]);
				System.out.println(" Sub res AT "+i+" is "+sub_res);
				if(sub_res!=Integer.MAX_VALUE) {
					res=Math.min(res, sub_res+1);//Here add 1 , only if balance is zero proceed to add 1 
				}
			}
		}
		return res;
	}

	private static int Min_Coin_Memo(int val, int[] coins, int i, int[] memo) {
		// memo  

		if(val==0) {
			return 0;
		}
		
		
		if(memo[val]!=0) {
			return memo[val];
		}
		
		int consi=Integer.MAX_VALUE,Noconsi=Integer.MAX_VALUE,min=Integer.MAX_VALUE;
		if(val<0 || i<0) {
			return min;
		}
		
		if(coins[i]<=val) {
			consi=Min_Coin_Memo(val-coins[i], coins, i,memo);
			if(consi!=Integer.MAX_VALUE) {
				consi=consi+1;
			}
		}


		Noconsi=Min_Coin_Memo(val, coins, i-1,memo);
	   min=Math.min(consi, Noconsi);
		
        memo[val]=min;
		return min;
	}

	private static int Min_Coin_Recur(int val, int[] coins, int i) {
		// recursion 
		
		
		if(val==0) {
			return 0;
		}
		
		int consi=Integer.MAX_VALUE,Noconsi=Integer.MAX_VALUE,min=Integer.MAX_VALUE;
		
		if(val<0 || i<0) {
			return min;
		}
		if(coins[i]<=val) {
			
			consi=Min_Coin_Recur(val-coins[i], coins, i);
			if(consi!=Integer.MAX_VALUE) {
				consi=consi+1;
			//	min=consi;	
			//	System.out.println(" Consi in "+val+ " with i "+i+"-->"+min);
			}
			
			
		}
		
		
		if(i>=0) {
		Noconsi=Min_Coin_Recur(val, coins, i-1);
	//	System.out.println(" No Consi in "+(val)+ " with i "+(i-1)+"-->"+Noconsi);
		}
		min=Math.min(consi, Noconsi);
	//	System.out.println(" =================> "+val+ " with i "+i+"-->"+min+" consi "+consi+" no "+Noconsi);
		
		
		
		//System.out.println(" Val "+val+" consi "+consi+" No "+Noconsi+" MIn is "+min);
		return min;
	}

}
