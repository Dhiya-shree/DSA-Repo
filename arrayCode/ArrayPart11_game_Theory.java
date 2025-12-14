package arrayCode;


/**
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
 * --------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #2 :Divide and Subtract Game
 * Jon and Arya are playing a game. Rules of game as follows:
 * They have a single number N initially.
 * Both will play an alternate move. Jon starts first.
 * Both will play each move optimally.
 * In each move, they can perform only one of these operation
 *        1. Divide that number by 2, 3, 4 or 5 and take floor of result.
 *        2. Subtract that number by 2, 3, 4 or 5.
 * If after making a move the number becomes 1, the player who made the move automatically loses the game.
 * When number becomes zero, the game will stop and the player who can't make a move loses the game.
 * 
 * For all N - 1 lose 
 * For divide - 2,3,4,5 - lose 
 * For sub - 3,4,5,6 - lose 
 * 
 * If its Arya turn then Arya will try to end the game with his turn or will select a position if possible such that bob will lose after Arya does her turn.
 * so, we will try to build our solution from 0 to n. and store it in dp. where dp[i] represents state, if started at ith position who will win the game.
 * dp[i] = 0, the person to play first at this position will win the game.
 * dp[i] = 1, the person to play second at this position will win the game.
 * we start from 0 : as who ever starts will lose the game so the opponent will win the game so we set dp[0] = 1.
 * for dp[1] to dp[5] as the first player have at least one move to make so dp[i],i∈[1,5] = 0.
 * next for some i∈[6,n], for i we will check if from any of the possible moves there exist a dp[j] = 1(means if we are at this position then the opponet will win like, if dp[j] = 1 then if its arya turn then in the end jon will win. so using this if Arya moves from position i to j, then at position j it will be jon's turn and thus using above analogy arya will win).
 * so for a position i we only have to look if there exist a poistion j from i-2, i-3, i-4, i-5, i/2, i/3, i/4, i/5, such that dp[j] = 1. then we assign dp[i] as 0. else we assign dp[i] as 1.
 * 
 * 
 * -----------------------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #3: Maximum Appearing Element !!!
 * Our Task: Given two arrays L[ ] and R[ ] of size N where L[i] and R[i] (0 ? L[i], R[i] < 106) denotes a range of numbers,
 *  the task is to find the maximum occurred integer in all the ranges. If more than one such integer exists, 
 *  print the smallest one. 
 * 
 * 
 * Follow the below steps to Implement the idea:
 * Initialize a Hash array arr[] to store the occurrence of every element in all the ranges combined.
 * Iterate over all the N ranges and increment L[i] by one and decrement R[i] by one.
 * Run a Loop from 1 to the maximum end value of all the ranges and take the Prefix sum. 
 * 
 *
 * @author shree
 *
 */
public class ArrayPart11_game_Theory {

	public static void main(String[] args) {
		// Wythoff array 
		// In matrixstart at any point 
		//Player can move left or down or diagonal
		// Predit who can win 
		// Similar to game of thrones 
		
		boolean ans=GameOfChoco(4,7);
		System.out.println(" Ans "+ ans);
		
		ans=GameOfChocoFindWythOffArray(4,7);
		System.out.println(" Ans "+ ans);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		String sans=DivideAndSubract(3);
		System.out.println(" Divide and sub ans "+sans);
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		int left[]= {1,2,5,15};
		int right[]= {5,8,7,18};
		int  ans1=MaximumAppearingElement(left,right);
		System.out.println(" Maximum apperared element is "+ans1);

	}

	private static int MaximumAppearingElement(int[] left, int[] right) {
		// TODO Auto-generated method stub
		int max=0;
		//int l_len=left.length;
		int rlen=right.length;
		for(int i=0;i<rlen;i++) {
			max=Math.max(max,right[i]);
		}
		////////////////////////////////////////////////////////////////////////////////////////
		//      IF MAX IS GIVEN USE THAT 
		/////////////////////////////////////////////////REDUCE COMPLEXITY BY O N 
		System.out.println(" max is "+max);
		int arr[]=new int[max+2];
		for(int i=0;i<rlen;i++) {
			arr[left[i]]=1;
			arr[right[i]+1]=-1;
		}
		int curr=0;int mcurr=0;
		int ans=0;
		for(int i=0;i<max;i++) {
			curr=curr+arr[i];
			if(mcurr<curr) {
				mcurr=curr;
				ans=i;
			}
		}
		
		////////////////////////////// Frequency array 
		
		for(int i=1;i<=max;i++) {
			arr[i]=arr[i-1]+arr[i];
			System.out.println(i+ " at os "+" Arr "+arr[i]);
		}
		return ans;
	}

	private static String DivideAndSubract(int N) {
		// Both of them playing optimally , 
		//Jon start first 
		// Jon always try to win 
		// Losing points for Jon
		//if 2,3,4,5,6 - Knot john wins 
		//
		//int curr=N;
		  int[] arr = new int[N+1];
	        
	        if(N == 0 || N == 1) return "Arya";
	        arr[0] = 0;
	        arr[1] = 1;
	        
	        for(int i=2; i<=N; i++) {
	            if(arr[i/2]==0 || arr[i/3]==0 || arr[i/4]==0 || arr[i/5]==0)
	               arr[i] = 1;
	            else if(arr[i-2]==0 || arr[i-3]==0 || arr[i-4]==0 || arr[i-5]==0)  
	               arr[i] = 1;
	            else
	               arr[i] = 0;
	        }
	        return (arr[N] == 1) ? "Jon" : "Arya";
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
