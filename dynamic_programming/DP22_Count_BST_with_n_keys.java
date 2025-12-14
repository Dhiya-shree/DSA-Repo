package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Count BST with n keys  -CATALAN 
 * 
 * BST :
 * Everything on left of node smaller 
 * Everything on right of node bigger 
 * 
 * Given n distinct keys , find how many BST can be made with the keys .
 * n=0 , BST = 0 
 * n=1 , BST =1   1
 * n=2 , BST =2   2    1    root left small , right large 
 *               /      \
 *              1        2
 * n=3 , BST = 5 
 *    1       1       2       3       3    All node in left must be smaller than root , 
 *     \       \     / \     /       /     All node in right must be smaller than root 
 *      2       3   1   3   1       2
 *       \     /             \     /
 *        3   2               2   1
 *        
 * 
 * Doesnt matter the array of elements 
 * 
 * 100,45,62 n=3 , BST Count= 5
 * Diven distinct n elements 45,62,100 BST count = 1,2,3 BST count 
 * 
 * 
 * For 4 1,2,3,4
 * with 1 as root = 5 
 *   left=0
 *   right=2,3,4 bst3=5
 * with 2 as root  = 2
 *   left = 1     bst1=1      MULTIPLY 
 *   right = 3,4  bst2=2
 * with 3 as root = 2
 *   left=1,2   bst2=2
 *   right=4    bst1=1       MULTIPLY left*right
 * with 4 as root  = 7 
 *   left=1,2,3 bst3=5       
 *   right=0   
 * 
 * BST 4 = 5+ 2+ 2+ 5 = 14 
 *   
 *   
 * For 5  , 1 2 3 4 5     
 * with 1 as root                                   1
 *   left=0                                       /   \
 *   right=2,3,4,5  bst4=14                     {}    {2,3,4,5}  
 *                                              0       14 = 14
 * with 2 as root                       2
 *   left = 1     bst1=1               /  \
 *   right = 3,4,5 bst3=5             1    3,4,5
 *                                    1  *  5   = 5
 * with 3 as root              3
 *   left=1,2   bst2=2        /  \
 *   right=4,5  bst2=2      1,2   4,5
 *                           2  *  2 = 4 
 * with 4 as root  = 5                    4
 *   left=1,2,3 bst3=5                  /   \
 *   right=5    bst1=1               1,2,3   5
 *                                     5   *  1  = 5
 * with 5 as root                 5
 *   left=1,2,3,4 bst4=14       /  \
 *   right=0               1,2,3,4  {}
 *                            14     na =14
 * BST 5 = 14 + 5+ 4+ 5+ 14 = 42 so on ....
 * 
 * 
 * Thus , general formula :
 *    res n = res0 * res n-1 + res 1* res n-2 + res 2* res n-3 +......+res n-1 * res0
 *            n-1
 *    res n = loop res(i)*res(n-i-1)
 *            i=0
 *    
 *  Dynamic table  O N^2 Time , Space O N 
 *  
 *  table 1=1 , table 2=2 
 *  
 *  for i=3 to N 
 *     count=0
 *     for int j= 1 to i
 *        right=table[i-j]
 *        left=table [i-1]
 *        curr=left*right , given left>0 and right>0 or curr=max of left,right 
 *        count=count+curr
 *     table[i]=count
 *       
 *  return table[n]
 *    
 *    
 *    
 *  CATALAN Number 
 *  
 *  Nth catalan nuumber gives -> Number of BST with N distinct nodes 
 *  
 *  Exp .             2n
 *    res n = 1/ (1+n)  C 
 *                       n
 *                       
 *    res 0 = 1
 *                
 *    res 1 = 1/2  2C1= 1
 *    res2 = 1/3 4C2 = 1/3 * 4!/2! * 2!= 4*3*2*1/ 3*2*2= 2
 *    res 3 = 1/4 6C3 
 *         = 1/4 * 6!/ 3! * 3!
 *         = 6*5*4*3*2*1 / 4*3*3*2*2
 *         = 5 
 *         
 *         
 *  
 *  
 *  
 * @author shree
 *
 */
public class DP22_Count_BST_with_n_keys {

	
	
	public static void main(String[] args) {
		// count bst with n key 
		
		int n=5;
		
		//REcur sol 
		int sol=BSTCount_recurMain(n);
		System.out.println(" Recur sol "+sol);
		
		// recur memo
		int memo[]=new int[n+1];
		memo[0]=0;memo[1]=1;memo[2]=2;
		sol=BSTCOUNT_MemoMain(n,memo);
		System.out.println(" Memo ans "+sol);
		System.out.println(" Memo is "+Arrays.toString(memo));
		
		//Table 
		sol=BSTCount_Table(n);
		System.out.println(" Table is "+sol);
		
		//Catalan 
		sol=BST_Catalan(n);
		System.out.println(" Catalan sol is "+sol);

	}

	private static int BST_Catalan(int n) {
		// Catalan sol 
		if(n<3) {
			return n;
		}
			
		// Catalan  
		// C n = 1/ n+1 2n C n
		// C n = 1/n+1 * 2n * 2n-1 * 2n-1...n+1n/ n*n-1*n-2*...1 
		// C n = 2n * 2n-1 * ...* n+2 / n*n-1*...1
		
		int val=FactorialMethod(n+2,2*n)/FactorialMethod(2, n);
		return val;
	}

	private static int BSTCount_Table(int n) {
		//table 
		int table[]=new int[n+1];
		table[1]=1;table[2]=2;
		//  Using table 0 = 1 to avoid condt 
		table[0]=1;
		int left=0,right=0,curr=0,count=0;
		for(int i=3;i<=n;i++) {
			count=0;
			for(int j=1;j<=i;j++) {
				left=table[j-1];   // j as i , i as N 
				right=table[i-j];
				//if(left>0 && right>0) { 
				curr=left*right;// Table 0 given as 1
				
				count=count+curr;
			}
			table[i]=count;
		}
		System.out.println( " Table is "+Arrays.toString(table));
		return table[n];
	}

	private static int BSTCOUNT_MemoMain(int n,int memo[]) {
		// loop for every root 
		if(memo[n]!=0 || n==0) {
			return memo[n];
		}
		
		int count=0;int curr=0;int left=0;int right=0;
		for(int i=1;i<=n;i++) {

		    left=BSTCOUNT_MemoMain(i-1,memo);
		    right=BSTCOUNT_MemoMain(n-i, memo);
		    if(left>0 && right>0) {
		    	curr=left*right;
		    }  // Give MEMO 0 as 1 To avoid checks
		    else if(left>0) {
		    	curr=left;
		    }
		    else {
		    	curr=right;
		    }
		    System.out.println("Memo ................. For root "+i+" val is "+curr);
			count=count+curr;
		}
		memo[n]=count;
		return count;
	}

	private static int BSTCount_recurMain(int n) {
		// loop for every root 
		if(n<3) {
			return n; // bst 0=0 , bst 1=1 , bst 2 = 2 
		}
		int count=0;int curr=0;
		for(int i=1;i<=n;i++) {
		
			curr=BSTCount_recur(n,i-1,n-i);
			System.out.println(" For root "+i+" val is "+curr);
			count=count+curr;
		}
		return count;
	}

	private static int BSTCount_recur(int n,int l,int r) {
		// recur sol 
		
		
		if(n<3) {
			return n; // bst 0=0 , bst 1=1 , bst 2 = 2 
		}
		
		int left=0,right=0,count=0;
		if(l>0) {
		left=BSTCount_recurMain(l);
		}
		if( r>0) {
		right=BSTCount_recurMain(r);
		}
		
		if(left>0 && right>0) {
		count=left*right;
		}
		else if(left>0) {
			count=left;
		}
		else {
			count=right;
		}
		//System.out.println(" For root "+(n-right)+" ans is "+count);
		return count;
	}

	private static int FactorialMethod(int start,int N) {
        long res=1;
        for(int i=start;i<=N;i++){
            res=res*i;
        }
        System.out.println(res);
        return (int)res;
    }
}
