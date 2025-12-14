package dynamic_programming;
/**
 * 
 * Nth Catalan Number
Difficulty: MediumAccuracy: 31.06%Submissions: 135K+Points: 4
Given a number n. The task is to find the nth catalan number.
The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
Catalan Number for n is equal to the number of expressions containing n pairs of parenthesis that are correctly matched, i.e., for each of the n(' there exist n ')' on there right and vice versa.
Note: Positions start from 0 as shown above.

Examples:

Input: n = 3
Output: 5
Explanation: Possible expressions are, ((())), (()()), ()(()), (())(), ()()()
 * @author shree
 *
 */
public class DP08_Catalan_number {
	    public static int findCatalan(int n) {
	        // code here
	        int cat[]=new int[n+1];
	        cat[0]=cat[1]=1;
	        for(int i=2;i<=n;i++){
	            cat[i]=0;
	            for(int j=0;j<i;j++){
	                cat[i]=cat[i]+cat[j]*cat[i-j-1];
	            }
	        }
	        return cat[n];
	        
	    }
	
}
