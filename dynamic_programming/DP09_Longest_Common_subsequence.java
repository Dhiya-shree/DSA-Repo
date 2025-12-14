package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Longest sub sequence 
 * 
 * Given string1 AXYBC
 * and   string2 ABDEFC
 * 
 * Find longest common sub sequence 
 * 
 * 
 * Recursion solution :
 * 
 * Consider the last value in s1 and s2 
 * 
 * 
 *   //Base case stop condt 
 *   if(m==0 or n==0)
 *        return 0 ; //lcs == 0 
 * 
 *   if s1 m-1 == s2 n-1   ( axybC and abdefC - C common , 1)
 *      lcs = 1+ recur (s1,s2,m-1,n-1)
 *   
 *   else 
 *   // check for two cases 
 *   // Case 1 consider till string m and N-1 
 *   //  Check for ( axyB and abdeF ==> axyB and abdE)
 *      lcs1 = recur( s1,s2,m,n-1) ;
 *   // Case 2 consider till string m-1 and n 
 *   //  Check for ( axyB and abdeF ==> axY and abdEF)
 *      lcs1 = recur( s1,s2,m,n-1) ;
 *      
 *      lcs=max(lcs1,lcs2)
 *   
 * 
 *  In Dynamic Memoization solution 
 *  
 *  Here variable m and n , s1 and s2 lengths 
 *  Thus memo is 2 D 
 *  
 *  memo[][] = int [m][n]
 *  
 *  Store the value of lcs of m length and n length in memo 
 *  
 *  
 *        MEMOIZATION ======> TABLE 
 *        
 *        
 *        Put for loops as per recusions base condts
 *        Replace recur func with table const 
 *        
 *        
 *        
 *  
 *  Dynamic TABLE 
 *  
 *   axybc  and   ABDEFC
 *  Value at any point depends prev value 
 *  At a,A 1 all having a,A 0 or 1 only 
 *  
 *  At x,B(1,1) value depend on (1,0)xA0 (0,1)aB0 (0,0)aA1 => consider aA 1 
 *  further x!=B thus value of 1,1 =1 
 *  
 *  for i,j -> m,n 
 *  
 *  For every value at x,y 
 *  
 *   if s1.x==s2.y
 *    Add lcs=1+lcs[x-1][y-1]
 *    
 *   else 
 *     lcs1 = lcs[x-1][y]
 *     lcs2 = lcs[x][y-1]
 *     lcs=Maximum lcs1 , lcs2
 *  
 *  
 *  //////////////////////////WRONG 
 *  lcs1 = table x-1 y 
 *  lcs2 = table x y-1
 *  lcs3 = table x-1 y-1
 *  lcs = Maximum of lcs1 , lcs2 , lcs3 
 *  
 *  if s1.x==s2.y
 *    Add lcs=1+lcs
 *  table[i][j]=lcs 
 *   //////////////////////////WRONG 
 *    
 *  return Maximum of all lcs 
 *  
 * @author shree
 *
 */
public class DP09_Longest_Common_subsequence {

	public static void main(String[] args) {
		//longest common subsequence 
		
		String s1="AXYBC";
		int m=s1.length();
		
		String s2="ABDEFC";
		int n=s2.length();
		
		// recur solution 
		//Time O 2^n
		// Space O m
		int ans=LCS_Recur(s1,s2,m,n);
		System.out.println(" LCS recur is "+ans);
		
		//memo
		//Time O m+n 
		//Space O m+n
		int memo[][]=new int[m+1][n+1];
		
		 ans=LCS_Dynamic(s1,s2,m,n,memo);
	     System.out.println(" LCS dynamic memoization is "+ans);
	     
	     for(int i=0;i<m+1;i++) {
	    	 System.out.println(" Memo "+Arrays.toString(memo[i]));
	     }
	     
	     //Table 
	     ans=LCS_Tabulation(s1,s2,m,n);
	     System.out.println(" LCS dynamic Tabulation is "+ans);
	     

	}

	private static int LCS_Tabulation(String s1, String s2, int m, int n) {
		// Dynamic tabulation 
		int table[][]=new int[m][n];
		int ans=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				int lcs=0;
				if(i>0 && j>0 ) {
					lcs=table[i-1][j-1];
				}
				if(i>0) {
					lcs=Math.max(table[i-1][j], lcs);
				}
				if(j>0) {
					lcs=Math.max(table[i][j-1], lcs);
				}
				if(s1.charAt(i)==s2.charAt(j)) {
					table[i][j]=1+lcs;
				}
				else {
					table[i][j]=lcs;
				}
				ans=Math.max(ans,table[i][j]);
			}
		}
		
		for(int k=0;k<m;k++) {
			System.out.println(" Table "+Arrays.toString(table[k]));
		}
		return ans
				;
	}

	private static int LCS_Dynamic(String s1, String s2, int m, int n, int[][] memo) {
		// dynamic memoization 
		
		// base 
				if (m == 0 || n == 0) {
					return 0;
				}

		
		if(memo[m][n]!=0) {
			return memo[m][n];
		}
		
		
		int lcs = 0;
		// same last
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			lcs = 1 + LCS_Dynamic(s1, s2, m - 1, n - 1,memo);
		} else {
			// case 1
			int lcs1 = LCS_Dynamic(s1, s2, m, n - 1,memo);
			// case 2
			int lcs2 = LCS_Dynamic(s1, s2, m - 1, n,memo);

			lcs = Math.max(lcs1, lcs2);
		}

       memo[m][n]=lcs;		
		return lcs;

	}

	private static int LCS_Recur(String s1, String s2, int m, int n) {
		// base 
		if(m==0 || n==0) {
			return 0;
		}
		
		int lcs=0;
		// same last 
		if(s1.charAt(m-1)==s2.charAt(n-1)) {
			lcs=1+LCS_Recur(s1, s2, m-1, n-1);
		}
		else {
			//case 1 
			int lcs1=LCS_Recur(s1, s2, m, n-1);
			//case 2
			int lcs2=LCS_Recur(s1, s2, m-1, n);
			
			lcs=Math.max(lcs1,lcs2);
		}
		
		return lcs;
	}

}
