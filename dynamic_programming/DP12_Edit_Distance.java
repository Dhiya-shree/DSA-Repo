
package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * EDIT Distance 
 * 
 * Application :
 * Suggest spelling error 
 * Find closest word in the dictionary 
 * Used in bio-informatics 
 * 
 * 
 * 
 * Given two string s1 and s2 . Find how many operation needed to change s1 to s2 
 * Operation includes -> Replace , Insert and Delete 
 * 
 * Example:
 * s1=CAT s2=CUT ans: 1 replace A->U 
 * s1=GEEK s2=GEEKS ans: 1 insert +S
 * s1=Satuday s2=Sunday ans:3 Delete AT Insert +U
 *  
 * Solution :
 * 1) Find LCS 
 * 2) Traverse LCS and s2 
 *     Find diff and return 
 *     
 *     
 * Recursion :  O 2^N time 
 * 
 * Recur s1,s2,n,m 
 * 
 * Base case 
 * if n==0 
 *    return m // balance needs to be added for char to match 
 *    
 * if m==0 
 *    return n // balance string to be deleted 
 *  
 *  if s1.n==s2.m 
 *      then char match recur for other char s1,s2,n-1,m-1
 *  else 
 *     Char not matched 
 *     3 possible solutions 
 *       1--> delete char in s1   s1,s2,n-1,m
 *       2--> insert char in s1   s1,s2,n,m-1
 *       3--> replace char in s1   s1,s2,n-1,m-1
 *     value= min of delete,insert,replace + 1 (plus 1 as currchar no match )
 *     
 * 
 * Dynamic   O M*N time and space 
 * 
 * Memo 
 * Create 2D array memo [n][m]
 * 
 *  ///////// Base case 
 * if n==0 
 *    return m // balance needs to be added for char to match 
 *    
 * if m==0 
 *    return n // balance string to be deleted
 *    
 *     
 * //////memo
 * if memo[n][m]!=0 return memo[n][m]
 * 
 * else ..................................
 *  if s1.n==s2.m 
 *      then char match recur for other char s1,s2,n-1,m-1
 *      value = recur s1,s2,n-1,m-1
 *  else 
 *     Char not matched 
 *     3 possible solutions 
 *       1--> delete char in s1   s1,s2,n-1,m
 *       2--> insert char in s1   s1,s2,n,m-1
 *       3--> replace char in s1   s1,s2,n-1,m-1
 *     value= min of delete,insert,replace + 1 (plus 1 as currchar no match ) 
 *     
 *  memo[n][m]=value
 *  return value ;
 *  
 *  
 *  
 *  Table 
 *  
 *  
 *  Create table table[n+1][m+1]
 *  
 *  table[1][1] means edit distance of s1 and s2 of length 1 and 1 
 *  
 *  From null to C it is 1 
 *  From null to CAT it is 3 thus table 0,1=1 0,3=3 llly table 3,0=3
 *  Example CAT and CUT 
 *  
 *  x  X C U T
 *  X  0 1 2 3
 *  C  1 
 *  A  2
 *  T  3
 *  
 * Condt :
 * 
 *  if i=0 table=j 
 *  if j=0 table=i 
 *  else .....
 *  
 *     if s1(i-1)==s2(j-1)
 *        val=table(i-1)(j-1)
 *        
 *    else 
 *       val=1 + min  of table(i-1)(j) , table(i)(j-1), table(i-1)(j-1)
 * 
 * 
 * @author shree
 *
 */
public class DP12_Edit_Distance {

	public static void main(String[] args) {
		// LCS + changes 

		String s1="cat";
		String s2="cut";
		int n=s1.length();
		int m=s2.length();
		//Recursion 
		int ans=RecurSolLCS(s1,s2,n,m);
		System.out.println(" LCS recur "+ans);
		
		int sol=EditRecur(s1,s2,n,m);
		System.out.println(" Recur "+sol);
		
		//int sizeMemo=Math.max(n,m);
		int memo[][]=new int[n+m][m];
		sol=EditMemo(s1,s2,n-1,m-1,memo);
		System.out.println(" Memo "+sol);
		
		for(int i=0;i<n;i++) {
			System.out.println(" Memo : "+Arrays.toString(memo[i]));
		}
		
		
		sol=EditTable(s1,s2,n,m);
		System.out.println(" Table "+sol);
		
		sol=EditTableGoG(s1,s2,n,m);
		System.out.println(" Table  GoG "+sol);
	}

	private static int EditTableGoG(String s1, String s2, int n, int m) {
		// table dynamic 

		int table[][]=new int[n+1][m+1];

		//int val=0;
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {

				if(i==0) {
					table[i][j]=j;
				}
				else if(j==0) {
					table[i][j]=i;
				}
				else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						table[i][j]=table[i-1][j-1];
					}
					else {
						table[i][j]=1+Math.min(table[i][j-1],Math.min(table[i-1][j],table[i-1][j-1]));
					}
				}
			}
		}
		for(int i=0;i<n+1;i++) {
			System.out.println(" Table "+i+" : "+Arrays.toString(table[i]));
		}
		
		return table[n][m];
	}

	private static int EditTable(String s1, String s2, int n, int m) {
		// table dynamic 
		
		int table[][]=new int[n+1][m+1];
		
		int val=0;
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
			
				
				val=Math.min(table[i][j-1],Math.min(table[i-1][j],table[i-1][j-1]));
				
				if(s1.charAt(i-1)!=s2.charAt(j-1)) {
					val=val+1;
				}
				
				if(i==n && j<m) {
					val=val+(m-j);
				}
				
				if(j==m  && i<n) {
					val=val+(n-i);
				}
				
				table[i][j]=val;
			}
		}
		
		for(int i=0;i<n+1;i++) {
			System.out.println(" Table "+i+" : "+Arrays.toString(table[i]));
		}
		
		return table[n][m];
	}

	private static int EditMemo(String s1, String s2, int n, int m, int[][] memo) {
		// memo 
		if(n<0) {
			return m+1;
		}
		/// MUST diff needs to be added 
		if(m<0) {
			return n+1;
		}
		
		if(memo[n][m]!=0) {
			return memo[n][m];
		}
		
		int ed=0;
		if(s1.charAt(n)==s2.charAt(m)) {
			ed=EditMemo(s1, s2, n-1, m-1, memo);
		}
		else {
			int ed_insert=EditMemo(s1,s2,n,m-1, memo);    //EditRecur(s1+(s2.charAt(m-1)), s2, n+1, m-1);
			int ed_delete= EditMemo(s1,s2,n-1,m, memo);  //EditRecur(s1.substring(0,n-1), s2, n-1, m-1);
			int ed_replace=EditMemo(s1,s2,n-1,m-1, memo); 
			ed=1+Math.min(ed_insert, Math.min(ed_delete, ed_replace)); //use minimum 
			
		}
		memo[n][m]=ed;
		return ed;
	}

	private static int EditRecur(String s1, String s2, int n, int m) {
		// recur 
		if(n<=0) {
			return m;
		}
		/// MUST diff needs to be added 
		if(m<=0) {
			return n;
		}
		
		int ed=0;
		if(s1.charAt(n-1)==s2.charAt(m-1)) {
			ed=EditRecur(s1,s2,n-1,m-1);
		}
		else {
			int ed_insert=EditRecur(s1,s2,n,m-1);     //EditRecur(s1+(s2.charAt(m-1)), s2, n+1, m-1);
			int ed_delete= EditRecur(s1,s2,n-1,m);     //EditRecur(s1.substring(0,n-1), s2, n-1, m-1);
			int ed_replace=EditRecur(s1,s2,n-1,m-1);
			ed=1+Math.min(ed_insert, Math.min(ed_delete, ed_replace)); //use minimum 
			
		}
		return ed;
	}

	private static int RecurSolLCS(String s1, String s2, int n, int m) {
		// resur simple 
		if(m<=0 || n<=0) {
			return 0;
		}
		
		int lcs=0;
		if(s1.charAt(n-1)==s2.charAt(m-1)) {
			lcs=1+RecurSolLCS(s1,s2,n-1,m-1);
		}
		else {
			int lcs1=RecurSolLCS(s1,s2,n,m-1);
			int lcs2=RecurSolLCS(s1,s2,n-1,m);
			lcs=Math.max(lcs1, lcs2);
		}
		
		return lcs;
	}

}
