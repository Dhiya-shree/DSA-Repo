package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Maximum cut 
 * 
 * Given a rod length L  and length p,q,r 
 * Cut the rot to maximize the segments 
 * 
 * Ex: L=11
 *     p=2 q=3 r=5
 *     
 *     Maximum segments 2,2,2,2,3
 * 
 * 
 *  Recur 
 *  
 *  For every curt 3 possible sol 
 *     Consider p if p<=l 
 *     Consider q  if q<=l 
 *     Consider r   if r<=l
 *     
 *  recur l,p,q,r
 *  
 *  if l<=0 
 *    return 0 
 *    
 *  p<=l
 *  cutP=1+ recur l-p,p,q,r
 *  q<=l
 *  cutQ=1+ recur l-q,p,q,r
 *  r<=l
 *  cutR=1+ recur l-r,p,q,r
 * 
 *  max= Maximum of cutP,cutQ,cutR
 *  
 *  
 *  Dynamic
 *  
 *  Memo 1D array memo[n] n=l+1
 *  
 *  Memo l,p,q,r,memo
 *  
 *  if l<=0 
 *    return 0 
 *    
 *  if memo[l]!=0 
 *     return memo[l]  
 *  
 *  p<=l
 *  cutP=1+ recur l-p,p,q,r,memo
 *  q<=l
 *  cutQ=1+ recur l-q,p,q,r,memo
 *  r<=l
 *  cutR=1+ recur l-r,p,q,r,memo
 * 
 *  max= Maximum of cutP,cutQ,cutR
 *  memo[l]=max
 *  
 *  
 *  Table:
 *  
 *  
 *  
 *  
 *  
 * @author shree
 *
 */
public class DP16_Maximum_Cuts {

	public static void main(String[] args) {
		//  maximum cuts problem
		
		int L=11;
		int p=2,q=3,r=5;
		
		//REcur 
		
		int sol=Cut_Recur(L,p,q,r);
		System.out.println(" Maximum cuts recursion "+sol);
		
		//Dynamic
		
		//Memo 
		int memo[]=new int[L+1];
		
		sol=Cut_Memo(L,p,q,r,memo);
		System.out.println(" Maximum cuts dynamic memo "+sol);
		System.out.println(" Memo array "+Arrays.toString(memo));
		
		//Table 
		sol=Cut_Table(L,p,q,r);
		System.out.println(" Maximum cuts dynamic table "+sol);
		
	}

	private static int Cut_Table(int l, int p, int q, int r) {
		// bottom up table 
		
		int table[]=new int[l+1];
		int cp=0,cq=0,cr=0;int max=0;
		for(int i=1;i<l+1;i++) {
			if(p<=i) {
				cp=1+table[i-p];
			}
		    if(q<=i) {
		    	cq=1+table[i-q];
		    }
		    if(r<=i) {
		    	cr=1+table[i-r];
		    }
		    
			max=Math.max(cp,Math.max(cq, cr));
			table[i]=max;
		}
		
		System.out.println(" Table array "+Arrays.toString(table));
		return table[l];
	}

	private static int Cut_Memo(int l, int p, int q, int r, int[] memo) {
		// memo 
		
		if(l<=0) {
			return 0;
		}
		
		
		if(memo[l]!=0) {
			return memo[l];
		}
		
		int cut_P=0,cut_Q=0,cut_R=0;
		if(p!=0 && p<=l)  // Must to give bcos if p=6 l=4 we will add 1 
		cut_P=Cut_Memo(l-p, p, q, r,memo)+1;
		if(q!=0 && p!=q && q<=l)
		cut_Q=Cut_Memo(l-q, p, q, r,memo)+1;
		if(r!=p && r!=q && r!=0 && r<=l)
		cut_R=Cut_Memo(l-r, p, q, r,memo)+1;
		
		int max=Math.max(cut_Q,Math.max(cut_P, cut_R));
		memo[l]=max;
		return max;
	}

	private static int Cut_Recur(int l, int p, int q, int r) {
		// Recur sol 
		
		if(l<=0) {
			return 0;
		}
		
		int cut_P=0,cut_Q=0,cut_R=0;
		
		//MUST to check if p,q,r > L
		if(p<=l)
		cut_P=Cut_Recur(l-p, p, q, r);
		if(q<=l)
		cut_Q=Cut_Recur(l-q, p, q, r);
		if(r<=l)
		cut_R=Cut_Recur(l-r, p, q, r);
		int max=Math.max(cut_Q,Math.max(cut_P, cut_R))+1;
		return max;
		
		
		
	}

}
