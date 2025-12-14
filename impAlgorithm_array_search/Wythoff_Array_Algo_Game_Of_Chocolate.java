package impAlgorithm_array_search;


/**
 *
 * In mathematics, the Wythoff array is an infinite matrix of integers derived from the 
 * Fibonacci sequence and named after Dutch mathematician Willem Abraham Wythoff. 
 * Every positive integer occurs exactly once in the array, and every integer sequence
 *  defined by the Fibonacci recurrence can be derived by shifting a row of the array.
 *  The Wythoff array was first defined by Morrison (1980) using Wythoff pairs, 
 *  the coordinates of winning positions in Wythoff's game. It can also be defined using Fibonacci numbers
 *   and Zeckendorf's theorem, or directly from the golden ratio and the recurrence relation defining the Fibonacci numbers
 * 
 * 
 *  Golden Ratio : https://en.wikipedia.org/wiki/Golden_ratio
 *  
 *  WythOff ARray - is a array of losing points 
 *  All points other than wythoff array are winning points 
 *  
 *  Consider 2x2 matrix , 
 *  1 2 3    * 2 *
 *  4 5 6    * * 6
 *  7 8 9    7 * *
 *  
 *  Consider 9 is home , and from any point player can move left /down/diagonal 
 *  All points other than 7,2,6 are winning , i.e (0,0) , (1,2) , (2,1)
 *  Similarly for large array 
 *  Loosing array 
 *  0 1 2 3  4  5  6  7  8  9<- index 
 *  0 1 3 4  6  8  9 11 12 14<-loosing coordinate 
 *  0 2 5 7 10 13 15 18 20 23<-loosing coordinate
 *  0 1 2 3  4  5  6  7  8  9<-Difference 
 *  
 *  We are checking if the given number is loosing , if not we can say it is winning 
 *
 * Problem #1: Game of Chocolates - Medium level - Wythoff array
 * 
 * Bunty and Dolly are playing a game, described as follows.
 * Game Description: -
 * There are two boxes having A and B number of chocolates respectively.
 *  Both can eat L (L ≥ 1) chocolates from any one box or L chocolates from both the boxes in one move. 
 *  They play the game alternatively and the last one to eat the chocolate will be the winner.
 * As Bunty wants to impress Dolly, he wants to make Dolly the winner. 
 * You have to help Bunty in deciding who should play first. Assume that both the players play optimally.
 * 
 * 
 * Approach: The problem can be solved based on the following idea:
 * 
 * Any state can be uniquely identified using two integers (n, m) which are the number of chocolates in the boxes. Now each state can be classified into two categories: cold state (the player whose turn it is will lose) and hot state (the player whose turn it is will win). The classification can be done as follows:
 * (0, 0) is a cold position
 * Any state from which a cold state can be reached in a single move is a hot state.
 * The state from which any possible move leads to a hot state is a cold state.
 * The task is to check if the given state (A, B) is a hot state or cold state and
 *  based on that the one to start will be Dolly or Bunty respectively.
 * 
 * Follow the below steps to solve the problem:
 * If A > B, then swap A and B, so that, B is always greater than or equal to A.
 * Initialize k = B – A and d = 1 + sqrt(5).
 * Set, d = d/2, and again d = d*k.
 * Make a variable c = d after typecasting it into int.
 * Now, if a and c are equal then return 0 else return 1.
 * If the answer is 0 then print “Dolly” else print “Bunty”
 * 
 * This problem is based on Wythoff's array algo.
 * There is formula for the finding golden ratio, i.e.  \varphi ={\frac  {1+{\sqrt  {5}}}{2}}. 
 * Later this golder ratio will be multiply with absulute difference between 2 inputs.
 * If result of that should not be same as minimum number of input for winning.
 * 
 *   
 * @author shree
 *
 */
public class Wythoff_Array_Algo_Game_Of_Chocolate {

	public static void main(String[] args) {
		
		boolean ans=GameOfChoco(4,7);
		System.out.println(" Ans "+ ans);
		
		ans=GameOfChocoFindWythOffArray(4,7);
		System.out.println(" Ans "+ ans);

	}

	private static boolean GameOfChocoFindWythOffArray(int a, int b) {
		//Finding all the pairs upto A,B <= n*phi, n*phi^2
		//Phi - golden ratio
		if(a==0 && b==0) 
	        return false;
	        if(a==b) return true;
	        double gold = 1.61803398;
	        int n = 1;
	        if(a>b) {
	        	a=a^b;
	        	b=a^b;
	        	a=a^b;
	        };
	        int f = 0,s = 0;
	        while(s<b){
	            f = (int) (n*gold);
	            s = (int) (n*gold*gold);
	            n++;
	        }
	        // Checking if both A and B are correct points in WythOff Array 
	        return !(a==f && s==b);
	}

	private static boolean GameOfChoco(int A, int B) {
		// wythoff array value found by golden*diff if equal to min in A,B then A,B is wythoff arrray 
		// It is a losing point 
		// If not equal then winning point 
		int absDiff = Math.abs(B - A);
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        double temp = goldenRatio * absDiff;
        return Math.min(A, B) != (int)temp;
	}

}
