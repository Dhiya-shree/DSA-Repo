package backtracking_sums;

/**
 * 
 * BackTracking Algorithm 
 *
 * Cutting down some recursive calls by using an isSafe function before 
 * proceeding further with recursive call 
 * 
 * There are three types of problems in backtracking –  
 *   Decision Problem – search for a feasible solution.
 *   Optimization Problem – search for the best solution.
 *   Enumeration Problem – find all feasible solutions.
 * 
 *  isSafe(){
 *   safe to procced ?
 *   return( if it will give correct result ?)
 * 
 * 
 *  RecursiveFunc(){
 *   
 *     (isSafe){
 *        ---> proceed recursion
 *      }
 *      
 *      // end 
 *  }
 * 
 * 
 * Concept of Backtracking

 

Backtracking can be defined as a general algorithmic technique that considers searching every possible combination in order to solve a computational problem. 
 

What is Backtracking Algorithm?
Backtracking is an algorithmic technique for solving problems recursively by trying to build a solution incrementally, one piece at a time, removing those solutions that fail to satisfy the constraints of the problem at any point of time (by time, here, is referred to the time elapsed till reaching any level of the search tree).

Types of Backtracking Algorithm
There are three types of problems in backtracking –  

Decision Problem – In this, we search for a feasible solution.
Optimization Problem – In this, we search for the best solution.
Enumeration Problem – In this, we find all feasible solutions.
When can be Backtracking Algorithm used?
For example, consider the SudoKu solving Problem, we try filling digits one by one. Whenever we find that current digit cannot lead to a solution, we remove it (backtrack) and try next digit. This is better than naive approach (generating all possible combinations of digits and then trying every combination one by one) as it drops a set of permutations whenever it backtracks.

Backtracking Algorithms

 


 * 
 * Example :
 * Given a string , print all those permutation which do not contain "AB"
 * as a substring 
 * 
 * Input - ABC
 * Output - ACB , BAC , CBA , BCA 
 * 
 * ABC all possible permutation :
 * ABC , ACB , BAC , ACB , CBA , CAB 
 * 
 * Conatin AB : ABC , CAB 
 * Others -> ans 
 * 
 * Solution 1 : Naive 
 * Find all possible permutation 
 * Before printing check if any has AB as substring 
 * 
 * Solution 2 : 
 * Return if permutation is of length N 
 * 
 * AND
 * It has substring AB 
 * if it has substring AB -> do not proceed 
 * 
 * ALSO AND 
 * When we have BA as remaining string to swap , do not proceed with swap
 * 
 * 
 * Not proceeding further when current result might not produce 
 * valid data -> saves time 
 * 
 * When solution is generating permutation and choosing from the permutation 
 *   use -> BACKTRACKING 
 *   
 * BackTracking :
 * Cut down some recursive calls by using an isSafe function before 
 * proceeding further with recursive call 
 * 
 * @author shree
 *
 */
public class BT00_Intro_Concepts {

	public static void main(String[] args) {
		String str="ABC";
		int n=str.length();
		String sub="AB";
		
		permuteBackTrack(str,0,n-1,sub);
		
		permuteNaive(str,0,n-1,sub);
		
		permute(str,0,n-1);
	}

	private static void permuteBackTrack(String str, int left, int right, String sub) {
		// +++ Use isSafe 
		System.out.println(" Safe is "+str);
		if(left==right) {
			System.out.println(" Backtrack permute is "+str);
		}
		else {
			
			for(int i=left;i<=right;i++) {
				
			if((isSafe_permute(str,left,i,right))) {
				System.out.println(" Permurte "+str+" left "+left);
				str=swap(str,i,left);
				permuteBackTrack(str, left+1, right, sub);
				str=swap(str,i,left);
			}
			
			}
		}
		
	}

	private static boolean isSafe_permute(String str, int left, int i, int right) {
		// check to avoid A B substring - 2 possibility 
		
		// 1 - l-1 is A and i is B so already fixed pas as AB 
		// i is 0,1,2,... l-1 pos of B 0,1,2.. so check for l!=0		
		if(left!=0 && str.charAt(i)=='B' && str.charAt(left-1)=='A') {
			return false;
		}
		// 2 - last two char before swap is BA --> AB 
		if(right==left+1 && str.charAt(i)=='A' && str.charAt(left)=='B') {
			return false;
		}
		
		return true;
	}

	private static void permuteNaive(String str, int left, int right, String sub) {
		//find all possible permutation 
		// +++ check if perutation has given substring // TODO Auto-generated method stub
		System.out.println(" String ..."+str);
		if(left==right) {
	      if(!str.contains(sub)) {
	    	  System.out.println("Naive Permute is "+str);
	      }
	      // return 
	      return;
		}
		else {
			for(int i=left;i<=right;i++) {
				str=swap(str,i,left);
				permuteNaive(str, left+1, right, sub);
				str=swap(str,i,left);
			}
		}
		
	}

	private static void permute(String str,int left, int right) {
		//find all possible permutation 
		
		if(left==right ) {
			System.out.println(" Permute is "+str);
			return;
		}
		else {
			for(int i=left;i<=right;i++) {
				str=swap(str,i,left);
				permute(str,left+1, right);
				str=swap(str,i,left);
			}
			
		}
		
	}

	private static String swap(String str, int i, int j) {
		//just swap 
		char a=str.charAt(i);
		char b=str.charAt(j);
		char ch[]=str.toCharArray();
		ch[i]=b;
		ch[j]=a;
		return (new String(ch));
		
	}
}
