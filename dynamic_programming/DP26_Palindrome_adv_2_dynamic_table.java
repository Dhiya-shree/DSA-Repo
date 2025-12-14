package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * 
 * Palindrome Partitioning 
 * 
 * Given a string , make minimum cuts to make string a palindrome
 * 
 * ex :
 * geek - o/p 2 palindrome ee  cut -> g| ee |k
 * abbac - o/p 1 palindrome abba  cut -> abba |c
 * abcde - o/p 4 palindrome a cut -> a |b|c|d|e
 * aaaa - o/p 0 already palindrome 
 * abbabbc o/p 2 plaindrome bbabb cut-> a| bbabb |c
 * 
 * 
 * Palindrome Partition :
 * 
 * Base case :
 * if string aleady palindrome => return 0 
 * if string len=1 return => 0 
 * 
 * partitions :
 * First partition :
 * s0 s1 s2 s3 s4 .... sn-1
 * s0 | s1 s2 s3 ..... sn-1
 * s0 s1 | s2 s3 s4 ...sn-1
 * .......................
 * s0 s1 s2 s3 ...sn-2 | sn-1
 * 
 * ex : first partition 
 *     geeks -> g|eeks 
 *              ge |eks 
 *              gee | ks
 *              geek |s 
 *              
 * Recursion :
 * 
 * pal partition s,i,j :
 * 
 * if len==1 || isPalindrome :
 *    return 0;
 *    
 *  int res=Integer.max_val 
 *  
 *  for(int k=i;k<j;k++)
 *     res=min of res , 1+ recur (i,k)+recur(k,j)
 *  return res 
 *     
 * 
 * Recursion Analysis :()- min of all cond
 *                        geek n=4 0,1,2,3  min=2
 *                   /            |        \   
 *               g|eek          ge|ek       gee|k
 *               0+1+(1)        1+1+2       1+1+0
 *              /  / | \        |   |        |   \
 *             0  /  |  |      g|e  e|k      gee   0
 *               /   |  e|ek  0+1+0  0+1+0   |  \
 *           e|ek   ee|k  0+1++1             |   \ 
 *         0+1+2    0+1+0                  g|ee  ge|e
 *                                       0+1+0   1+0+0
 *         
 *      
 *   Partition =   0 if palindrome 
 *                 0 if length 1
 *                k<j
 *                 min ( partition s,i,k  + partition s,k+1,j  + 1 ) 
 *                k=i                         // recursion      //current partition 
 *                
 *                
 *    Recursion time = T(N-1) +T(N-2)+.....
 *                   = O N^N-1 ?
 *                
 *   Dynamic table Time  O N^3 Space O N^2
 *   
 *   
 *   table[n][n] 
 *   table ij= mminimum cut for sub string i to j 
 *   
 *   if sub string 0-3= palindrome , ans=0
 *   else:
 *   table 0-3 = min of 1) table 0-0 + table 1-3 +1
 *                      2) table 0-1 + table 2-3 +1
 *                      3) table 0-2 + table 3-3 +1 
 *        
 *   for gap:1 to n
 *    
 *    for i=0 to n where i+gap<n
 *        j=i+gap 
 *        
 *      if substring s(i to j) is palindrome 
 *          table ij=0
 *      else 
 *         for k=i to j-1
 *           min of table[i][k]+table[k+1][j]+1
 *         table ij=min
 *           
 *   return table 0,n-1 
 *   
 *   
 *   Additionally use palindrome bboolean table to store palindrome value 
 *   Palindrome [n][n]
 *   
 *   palindrome ij= true if s.substring i to j is palindrome 
 *               = false 
 *   
 *   table[n][n]
 *   palindrome[n][n]
 *   for gap:1 to n
 *    
 *    for i=0 to n where i+gap<n
 *        j=i+gap 
 *        
 *      if gap==1 and char at i==j 
 *          palindrome ij= true 
 *          table ij=0 
 *      else if chat at i==j && palindrome i+1 j-1   a | bcdcb | a i==j && substring also palindrome 
 *          palindrome ij= true 
 *          table ij=0 
 *      else
 *         palindrome=false 
 *         min= max value 
 *         for k=i to j-1 
 *             min = minimum of (table[i][k]+table[k+1][j]+1)
 *         table ij=min 
 *         
 *           
 *   return table 0,n-1    
 * @author shree
 *
 */
public class DP26_Palindrome_adv_2_dynamic_table {

	public static void main(String[] args) {
		//Palindrome partioning 
	    
		String s="abbabbc";
		int n=s.length();
		
		int sol=Palindrome_Partition_Recur(s,0,n-1);
		System.out.println(" Solution recur "+sol);
		
		int memo[][]=new int[n][n];
		sol=Palindrome_Partition_Memo(s,0,n-1,memo,n);
		System.out.println(" Solution memo "+sol);
		System.out.println(" Memo table ");
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(memo[i]));
		}
		
		sol=Palindrome_Partition_Table(s,n);
		System.out.println(" Solution table "+sol);
		
		// Use a nxn table to check palindrome 
		sol=Palindrome_Partition_Table_Advanced(s,n);
		System.out.println(" Solution table + palindrome table : Advanced  "+sol);
	}

	private static int Palindrome_Partition_Table_Advanced(String s, int n) {
		//Use palindrome table boolean values to9 precompute palindrome
		
		boolean palindrome[][]=new boolean[n][n];
		int table[][]=new int[n][n];
		
		for(int i=0;i<n;i++) {
			palindrome[i][i]=true;//single char palindrome is true 
		}
		
		for(int gap=1;gap<n;gap++) {
			for(int i=0;i<n && i+gap<n;i++) {
				int j=i+gap;
				
				if( s.charAt(i)==s.charAt(j) && gap==1) {
					table[i][j]=0;  // 2 char both same 
					palindrome[i][j]=true;
				}
				// for case like a | bbcdcbb | a ... both s.char at i === s.char at j
				//      and substring i+1 to j-1 bbcdcbb is also palindrome 
				// thus i to j   abbcdcbba is a palindrome 
				else if(s.charAt(i)==s.charAt(j) && palindrome[i+1][j-1]) {
					table[i][j]=0;
					palindrome[i][j]=true;
				}
				else {
					//Not a palindrome 
					palindrome[i][j]=false; // by default all false no need to set 
					int min=Integer.MAX_VALUE;
					for(int k=i;k<j;k++) {            // must be k+1 here 
						min=Math.min(min, table[i][k]+table[k+1][j]+1);
					}
					table[i][j]=min;
				}
			}
		}
		
		System.out.println(" Table is below ");
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(table[i]));
		}
		
		System.out.println("Palindrome Table is below ");
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(palindrome[i]));
		}
		
		return table[0][n-1];
		
	}

	private static int Palindrome_Partition_Table(String s, int n) {
		// table 
		int table[][]=new int[n][n];
		
		for(int gap=1;gap<n;gap++) {
			for(int i=0;i<n && i+gap<n;i++) {
				int j=i+gap;
				
				if(gap==1 && s.charAt(i)!=s.charAt(j)) {
						table[i][j]=1;
					}
				else if(gap==2 && s.charAt(i)!=s.charAt(i+2)) {
					table[i][j]=Math.min(1+table[i][i+1]+table[j][j], 
							               1+table[i][i]+table[i+1][j]);
				}
				else if(gap>2 && !IsPalindrome(s, i, j)){
					
			    int min=Integer.MAX_VALUE;
				
				for(int k=i;k<j;k++) {
					int first=table[i][k];
					int second=table[k+1][j];
					min=Math.min(min,1+first+second);
				}
			    table[i][j]=min;
				}
			}
		}
		System.out.println(" Table is below ");
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(table[i]));
		}
		
		return table[0][n-1];
	}

	private static int Palindrome_Partition_Memo(String s, int i, int j, int[][] memo,int n) {
		//base case
		if(i<n && j<n && memo[i][j]!=0) {
			return memo[i][j];
		}
		if(i>=j || IsPalindrome(s,i,j) ) {
			return 0;
		}
		
		int min=Integer.MAX_VALUE;
		int firstHalf=0;int secondHalf=0;int partNow=1;int val=0;
		for(int k=i;k<j;k++) {
			firstHalf=Palindrome_Partition_Memo(s,i,k, memo,n);
			secondHalf=Palindrome_Partition_Memo(s,k+1, j, memo, n);
			val=firstHalf+partNow+secondHalf;
			min=Math.min(val,min);
		}
		memo[i][j]=min;
		return min;
	}

	private static int Palindrome_Partition_Recur(String s, int i, int j) {
		// base case 
		if(i>=j || IsPalindrome(s,i,j) ) {
			return 0;
		}
		
		// Loop for all partition and check ans 
		int min=Integer.MAX_VALUE;
		int firstHalf=0;int secondHalf=0;int partNow=1;int val=0;
		for(int k=i;k<j;k++) {
			firstHalf=Palindrome_Partition_Recur(s,i,k); // But here must be K only
			secondHalf=Palindrome_Partition_Recur(s,k+1,j);//Here must to give K+1 else stack overflow calling same i,j 
	        val=firstHalf+partNow+secondHalf;
			min=Math.min(min,val);
		}
		
		return min;
	}

	private static boolean IsPalindrome(String s, int i, int j) {
		// check if palindrome
//		String str=s.substring(i,j+1); 
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			else {
				i++;
				j--;
			}
		}
	
//	System.out.println(str+" is palindrome");
	return true;
	}
	
}
