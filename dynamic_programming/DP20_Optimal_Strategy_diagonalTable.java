package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Optimal Strategy for a game    DIAGONAL TABLE , LOWER HALF EMPTY 
 * 
 * For player to win even-odd strategy 
 * For finding maximum a player can achieve - dynamic 
 * 
 * Consider a game , where there are even set of coins placed 
 * Two users , where they pick a coin based on turns .
 * Becos of even coins , both players get half half coins .
 * Both players play to optimizethe values 
 * Any player can pick , one on the two corner coins 
 * 
 * EVEN ODD STRATEGY 
 * ===> If need to always win against B , just check even and odd coins 
 * if value at even> odd , player A to start taking from first coin 
 * else player A to start taking last coins 
 * 
 * ex 20 5 4 6 
 *    even = 24 odd = 11   even=24 ,, but maximum = 25 
 *    player A need to start from first as even >odd
 * 
 * ex2 2 3 15 7 
 *     even=17
 *     odd=10 
 *     player A need to start from first as even >odd
 *     
 * ex3 3 20 7 4 
 *     even=10
 *     odd=24 
 *     Player A need to start from last 4 as odd>even 
 * 
 * DYNAMIC 
 * Need to find maximum  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * But here need to find maximum possible value achievable by a player who starts first 
 * 
 * I/p 20,5,4,6     o/p :25 
 * Player A starts first , A can pick 20/6 (consider he picks 6)
 * now arr ... 20,5,4
 * Player B can one among pick 20/4  and so on 
 * 
 * Player A can pick 20 , then  player B pick 6 as he try to play optimal . 
 * Player A can pick any among 5,4 .
 * A will pick 5 
 * Thus player A :25 Player B :10 
 * 
 * 
 * Two recursive solution :  O N2 TIME , O N2 Space dynamic sol 
 * 
 * Sol 1 :
 * 
 *   Recur arr,start,end,sum
 *   
 *   // only two elements find their maximum 
 *   if(end-start==1) return max of arr[start],arr[end]  
 *   
 *   PlayerA takes first = sum - Player B sol with remain (arr,start+1,end,sum-arr[start])
 *   PlayerA takes last = sum - Player B sol with remain (arr,start,end-1,sum-arr[end]) 
 *    
 *   return maximum for above two values 
 *   
 *   
 *   Main 
 *     Find sum of all elements sum=35 
 *     
 *     Recur arr,0,n-1,sum 
 *       
 * 
 * Sol 2 :
 * 
 * 
 * Consider only value of A picks 
 * A pick first = first + Min of A value ( after B picks first , after B picks last )
 * A pick last = last + Min of A value ( after B picks first , after B picks last )
 * 
 * return max of A first,A last 
 * 
 * Does not require sum as parameter 
 * 
 *  i,i+1,i+2.........j-2,j-1,j
 *  Player A takes first i , Player B can pick i+1, or j 
 *  Player A takes last j , Player B can pick i, or j-1 
 * 
 *  Recur2 arr,start,end 
 *  
 *  Cont 1,2 ----------- Optimal with A first 
 *  A picking i:FIRST
 *   B picking i+1  = A ans (arr,i+2,j)  ------- i A, i+1 B, A can pick i+2 to j 
 *   B picking j    = A ans (arr,i+1,j-1)------- i A, j B, A can pick i+1 to j-1 
 *   
 * A picking FIRST Max = first arr[i] + MIN( B picking i+1, B picking j)
 *   
 *  Cond 3,4----------- Optimal with A last 
 *  A picking j:LAST
 *   B picking i  = A ans (arr,i+1,j-1)  ------- j A, i B, A can pick i+1 to j-1 
 *   B picking j-1    = A ans (arr,i,j-2)------- j A, j-1 B, A can pick i to j-2
 *   
 *  A choice = Maximum of A picking first , A picking Last 
 *  
 *  return A choice val ; 
 *  
 *  
 * 
 * Sol 2 - Dynamic :
 * 
 * Two parameter start , end 
 * Memo 2 D memo[n][n] 
 * 
 * lower half of memo empty ,as start>end 
 * 
 * Solution = Recursion of 0 , n-1
 * 
 * Return memo[0][n-1]
 *
 *         
 *  Ans 0,3 requires ans 0,1,  1,2  2,3 etc 
 *  Any value requires below diagonal value 
 * 
 * 
 * Dynamic Table :
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class DP20_Optimal_Strategy_diagonalTable {

	public static void main(String[] args) {
		// optimal strategy game 
		
		int arr[]= {20,5,4,6,27,54,21,1,2,4,6,87,54,33,97,55};
		int n=arr.length;
		
		// GOG sol 
		/**
		 * 
		 * We need to return our maxmize value , but here opponent also maximize the value 
		 * 
		 * To get maximum value , when both party are optimizing 
		 * 
		 * We get optimal value of player B and subtract from sum 
		 * 
		 * sum=35 
		 * 
		 * Optimal value of player A = sum - 
		 *         Minimum(  optimal value of player B ( in event of 1) Player A chosiing first  2) Player A choosing second ) )
		 *          
		 *          
		 * Player A chosing first(25) = sum (35) - (10)Optimal value of player B ( Player A first --> B recur for remaining array : arr,n,start+1,end,sum-arr[start]  )
		 * Player A chosing last(11) = sum (35) - (24)Optimal value of player B ( Player A last --> B recur for remaining array : arr,n,start,end-1,sum-arr[end]  )
		 * 
		 * Optimal = Maximum of above = Max(25,11)= 25  
		 * 
		 * 
		 * 
		 * 
		 */
		long st=0,et=0;
		st=System.currentTimeMillis();
		int ans=OptimalStrategyNOsum(arr,0,n-1);
		System.out.println(" Optimal No sum "+ans);
		et=System.currentTimeMillis();
		System.out.println(" Time for optimal No sum recur is -----> "+((et-st)));
		
		st=System.currentTimeMillis();
		ans=Optimal_Dynamic(arr,n);
		System.out.println(" Dynamic No sum "+ans);
		et=System.currentTimeMillis();
		System.out.println(" Time for optimal No sum dynamic is -----> "+((et-st)));
		
		// REcur with sum
		st=System.currentTimeMillis();
		ans=OptimalStrategy(arr,n);
		System.out.println(" ANs is "+ans);
		et=System.currentTimeMillis();
		System.out.println(" Time for optimal sum recur is -----> "+((et-st)));
		
		
		//Waste won't work with memo 
		st=System.currentTimeMillis();
		ans=OptimalStrategyMemo(arr,n);
		System.out.println(" ANs is "+ans);
		et=System.currentTimeMillis();
		System.out.println(" Time for optimal sum memo is -----> "+((et-st)));
		
		
		//recur WONT WORK 
		int sol=RecurOptimal(arr,0,n-1,true,0,0);//start with A 
		System.out.println(" Recur optimal is "+sol);
		
		//worked for sample  NOT GOOD WONT WORK 
		sol=RecurForAll(arr,n);
		System.out.println(" sol is "+sol);
		
	}


	private static int Optimal_Dynamic(int[] arr, int n) {
		// Dynamic 
		
		int table[][]=new int[n][n];
		
		
		for(int i=0;i<n-1;i++) {
			table[i][i]=arr[i];   // arr start 3 end 3 value possible only arr 3 
			table[i][i+1]=Math.max(arr[i],arr[i+1]);    // arr start 3 end 4 value possible = max of arr[3], arr[4]
			// above end-start==1 , thus table[start][end]=max of arr[start], arr[end]
		}
		
		//Gap is the distance between i and j 
		// Start filling with 0 to 3 , then 1 to 4 , then 2 to 5 ...
		//Gap=3, elements = 4 
		// Increment gap by 2 , because alternative diagonals are needed
		/*
		 *      0 1 2 3 4 5
		 *      0 1 0 1 0 1  -0   fill 0 to 3
		 *      0 0 1 0 1 0  -1   fill 1 to 4
		 *      0 0 0 1 0 1  -2   fill 2 to 5
		 *      0 0 0 0 1 0  -3
		 *      0 0 0 0 0 1  -4
		 *      0 0 0 0 0 0  -5
		 *      
		 *      
		 * 
		 */
		// Gap starts from 3 
		for(int gap=3;gap<n;gap=gap+2) {
			// for gap=3,5,7....
			//n=6
			// gap==3 i=0,1,2,3 j=0,1,2,3,4,r5
			// gap==2 i=0,1,2,3 j=2,3,4,5
			// gap==4 i=0,1  j=4,5
			for(int i=0;i+gap<n;i++) {
				int j=i+gap;
				// A takes i , B takes i+1 then A can take i+2,j | B takes j then A can take i+1,j-1
				int AFirst=arr[i]+Math.min(table[i+2][j],table[i+1][j-1]);
				// A takes j , B takes i then A can take i+1,j-1 | B takes j-1 then A can take i,j-2
				int ALast=arr[j]+Math.min(table[i+1][j-1],table[i][j-2]);
				table[i][j]=Math.max(AFirst, ALast);
			}
		}
		/*  Cont 1,2 ----------- Optimal with A first 
		 *  A picking i:FIRST
		 *   B picking i+1  = A ans (arr,i+2,j)  ------- i A, i+1 B, A can pick i+2 to j 
		 *   B picking j    = A ans (arr,i+1,j-1)------- i A, j B, A can pick i+1 to j-1 
		 *   
		 * A picking FIRST Max = first arr[i] + MIN( B picking i+1, B picking j)
		 *   
		 *  Cond 3,4----------- Optimal with A last 
		 *  A picking j:LAST
		 *   B picking i  = A ans (arr,i+1,j-1)  ------- j A, i B, A can pick i+1 to j-1 
		 *   B picking j-1    = A ans (arr,i,j-2)------- j A, j-1 B, A can pick i to j-2
		 *   
		 *  A choice = Maximum of A picking first , A picking Last 
		 */  
		
		
		for(int i=0;i<n;i++) {
			System.out.println(" Table at "+i+" .... "+Arrays.toString(table[i]));
		}
		return table[0][n-1];
	}


	private static int OptimalStrategyNOsum(int[] arr, int start, int end) {
		// optimal strategy 
		if(end-start==1) {
			return Math.max(arr[start],arr[end]);
		}
		// Player A picks first i , next first i+1 , last j  
		//start= i , A picks i , next first= i+1 , last j 
		
		// B picks i+1 , then A can take i+2 or last 
		int F_B_First_then_A_pick=OptimalStrategyNOsum(arr,start+2,end);
		// B picks j , then A can take i+1 or last-1 
		int F_B_Last_then_A_Pick=OptimalStrategyNOsum(arr, start+1, end-1);
		                            // Minimum here because B will choose optimized value and pick lesser A 
		int A_pick_First=arr[start]+Math.min(F_B_First_then_A_pick, F_B_Last_then_A_Pick);
		
		// Player A picks last j ,  first i , last j-1
		// last=j , A picks j , next first= i , last j-1

		// B picks i , then A can take i+1 or last-1  
		int L_B_First_then_A_pick=OptimalStrategyNOsum(arr,start+1,end-1);
		// B picks j-1 , then A can take i or last-2
		int L_B_Last_then_A_Pick=OptimalStrategyNOsum(arr, start, end-2);

        // Minimum here because B will choose optimized value and pick lesser A 
        int A_pick_Last=arr[end]+Math.min(L_B_First_then_A_pick, L_B_Last_then_A_Pick);

        // A will decide maximum first or last  
        int max=Math.max(A_pick_Last, A_pick_First);
		return max;
	}


	private static int OptimalStrategyMemo(int[] arr, int n) {
		// Use memo 
		int memo[][]=new int[n][n];
		// Find sum of all elements 
	    int sum=0;
		for(int i=0;i<n;i++) {
			sum=sum+arr[i];
		}
		//	System.out.println(" Sum is "+sum);
				
	    for(int i=0;i<n;i++) {
	    	memo[i][i]=arr[i];
	    }
		int ans=MaximumPossibleMemo(arr,0,n-1,sum,memo);
		for(int i=0;i<n;i++) {
		System.out.println(" Memo "+i+" value ..."+Arrays.toString(memo[i]));
		}
		return ans;
	}


	private static int MaximumPossibleMemo(int[] arr, int start, int end, int sum, int[][] memo) {
		// Max possible with memo 
		if(memo[start][end]!=0)
			return memo[start][end];
		
		if(end-start==1) {//last two element 
			memo[start][end]=Math.max(arr[start],arr[end]);
		//	memo[end][start]=memo[start][end];// NO point lower half triangle not needed
			return memo[start][end];//return value 
		}
		
		
		// A first = sum - max possible for Player B with remaining 
		int A_First=sum-MaximumPossibleMemo(arr, start+1, end, sum-arr[start],memo);
		
		// A last = sum - max possible for player B with remaining 
		int A_Last=sum-MaximumPossibleMemo(arr, start, end-1, sum-arr[end], memo);
		
		int maxForPlayer=Math.max(A_First, A_Last);
		memo[start][end]=maxForPlayer; // FOR A and B , int the remaining array possibly only 1 maximum value
		//memo[end][start]=memo[start][end];  // NO point lower half triangle not needed
		return maxForPlayer;
	}


	private static int OptimalStrategy(int[] arr, int n) {
		// Find sum of all elements 
		int sum=0;
		for(int i=0;i<n;i++) {
			sum=sum+arr[i];
		}
	//	System.out.println(" Sum is "+sum);
		
		int ans=MaximumPossible(arr,0,n-1,sum);
		return ans;
	}


	private static int MaximumPossible(int[] arr, int start, int end, int sum) {
		// Consider 2 choices for player A and reduce sum 
		
		if(end-start==1) {// last two values for player A and B to select 
			return Math.max(arr[start],arr[end]);
		}
		
		// optimal A = sum - Optimal of B
	//	int first=MaximumPossible(arr, start+1, end, sum-arr[start]);int last=MaximumPossible(arr, start, end-1, sum-arr[end]);
		int choiceFirst=sum-MaximumPossible(arr, start+1, end, sum-arr[start]);
		int choiceLast=sum-MaximumPossible(arr, start, end-1, sum-arr[end]);
		//System.out.println(" A choosing first , B optimal value = "+first+" A= sum-B optimal= "+choiceFirst);
		//System.out.println(" A choosing last , B optimal value = "+last+" A= sum-B optimal= "+choiceLast);
		//System.out.println(" At bal sum "+sum+"...................................max is "+Math.max(choiceFirst, choiceLast));
		return Math.max(choiceFirst, choiceLast);
	}


	private static int RecurForAll(int[] arr, int n) {
		// recur for all
		int sumA=0,sumB=0,sf=0;
		int start=0;int end=n-1;
		for(int i=0;i<n;i++) {
			
			int sum1=arr[start]+FindBest(arr, n,start+1,end-1, true);
			int sum2=arr[end]+FindBest(arr, n,start+1,end-1, true);
		//	int sum3=arr[start]+FindBest(arr, n,start+1,end, false);
		  //  int sum4=arr[end]+FindBest(arr, n,start,end-1, false);
		//
		//	System.out.println(" Sum 1 "+sum1+" Sum 2 "+sum2+" sum3  "+sum3+" sum4 "+sum4);
			if(sum1>sum2) {
				sf=arr[start];
				start=start+1;
			}
			else {
				sf=arr[end];
				end=end-1;
			}
			
			if(i%2==0) {
				sumA=sumA+sf;
			//	System.out.println(" SumA add "+sf);
			}
			else {
				sumB=sumB+sf;
		//		System.out.println(" SumB... add "+sf);
			}
			
		}
	//	System.out.println(" Sum A "+sumA+" sum B "+sumB);
		return sumA;
	}


	private static int RecurOptimal(int[] arr, int start, int end, boolean toggle,int sumA,int sumB) {
		// recur 
		
		if(start>end) {
		//	System.out.println(" A sum "+sumA+" B sum "+sumB);
			
			return Math.max(sumA,sumB);
		}
		
		// consider 4 cases instead of 2 
		// a last b first 
		// a last b last  
		// a first b fisrt 
		// a first b last 
		int max=0;
		if(toggle) {
		
		int first=arr[start]+RecurOptimal(arr,start+1,end,false,sumA+arr[start],sumB);
		int second=arr[end]+RecurOptimal(arr,start,end-1,false,sumA+arr[end],sumB);
		if(first>second) {
			max=arr[start];
		}
		else {
			max=arr[end];
		}
		}
		
		else{
		
		int third=arr[start]+RecurOptimal(arr,start+1,end,true,sumA,sumB+arr[start]);
		int fourth=arr[end]+RecurOptimal(arr,start,end-1,true,sumA,sumB+arr[end]);
		if(third>fourth) {
			max=arr[start];
		}
		else {
			max=arr[end];
		}
		}
		
		//zRecurOptimal(arr,start,end,true,,0);
		return max;
	}
	
	
	
	private static int FindBest(int arr[],int n , int start,int end,boolean toggle) {
		
		if(start>end ||start>=n||end<0) {
			return 0;
		}
		
		int sumA=FindBest(arr,n,start+1,end,!toggle);
		int sumB=FindBest(arr, n, start, end-1, !toggle);
		
		if(toggle) {
			sumA=sumA+arr[start];
			sumB=sumB+arr[end];
		}
		
		return Math.max(sumA, sumB);
		
	}

}
