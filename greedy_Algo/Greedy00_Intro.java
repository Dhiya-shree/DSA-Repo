package greedy_Algo;

import java.util.Arrays;

/**
 * 
 * Greedy Algorithm 
 * 
 *  Used for optimization problems 
 *  1) Shartest / longest distance path 
 *  2) Minimum / Maximum weight path etc \
 *  
 * Example :
 * Consider infinite supply of following value coins 
 * 10 , 5  , 2, 1
 * 
 * If someone ask for a amount 
 * How to give amount with minimum coins ?
 * 
 * amount : 52 
 * 10 - 5 , 2 - 1 
 * Total 6 coins 
 * 
 * 
 * Solution:
 * consider floor of division :
 * 1) Divide num by 10 => res= num - 10*remainder 
 * 2) Divide res by 5 => res= res - 5*remainder 
 * 3) Divide res by 2 => res= res - 2*remainder 
 * 4) Divide res by 1 => res= res - 1*remainder 
 * 
 * 
 * General structure of Greedy :
 * 
 * 
 *  getOptimal ( int arr[],int n){
 *  
 *  1) Initialize res=0 
 *  2) while (items are not considered ){
 *        i=selectAnItem()
 *        if(feasible to consider i)
 *             res=res+- i ;
 *      }
 *  3) return res 
 *  }
 *  
 *  
 *  Example :
 *  Dijistra selectAnItem -> relax alg for slection 
 *  Prim's Algorithm -> min heap to get nextx minimum  
 *  
 *  
 *  Greedy algorithm may not work always 
 *  Example1 -> coins 18,1,10 
 *  Find minimum coins neeed 
 *  
 *  For value : 20 
 *  By Greedy : 18 + 1 + 1 = 3 coins 
 *  CORRECT ANS : 2 coins 10+10 
 *  
 *  Example2 -> Coonsider source and destination vertex 
 *  Find the longest path 
 *  
 *  Pick the longest edge source connects to source 
 *  Might not work for some values 
 *  
 *  
 *  Greedy application 
 *  
 *  Finding optimal solution 
 *    Activity Selection 
 *    Fractional Knapsack 
 *    Job sequencing 
 *    Prim algo 
 *    Dijkstra algo 
 *    Krusal Algo 
 *    Huffman coding 
 *    
 *  Finding close to optimal solution 
 *    For NP Hard problem ( No Polynomial time solution)
 *    Travellong salesman problem 
 *     
 *  
 *
 * @author shree
 *
 */
public class Greedy00_Intro {

	public static void main(String[] args) {
		/*
		 * Find the minimum number of coins we can give 
		 * 
		 * Given 100 50 10 5 2 1 coins 
		 * And number x 
		 * 
		 * Find minimum coins to get number x 
		 * 
		 * 
		 */
		
		
		int coins[]= {100,50,10,5,2,1,500,1000};
		int amount=267;
		int val=MinimumCoinsGreedy(coins,amount);
		System.out.println(" Minimum coins needed is "+val);
		

	}

	private static int MinimumCoinsGreedy(int[] coins, int amount) {
		// create a variable res 
		int res=amount;
		int n=coins.length;
		//sort the coins in array  
		Arrays.sort(coins);
		System.out.println(" Sorted coins "+Arrays.toString(coins));
		// Loop for minimum combo 
		
		int count=0;int ans=0;
		for(int i=n-1;i>=0 && res>0;i--) {         // while condt res>0 and i<n
			count=0;
			count=res/coins[i];   // 267%1000=0 257/100= 2 
			res=res-(count*coins[i]); // remain res = 267 - 100*2 = 67
			ans=ans+count;
			System.out.println(" No of "+coins[i]+" coins is "+count);
		}
		
		return ans;
		/*
		 * 
		 * 
		 *  *  getOptimal ( int arr[],int n){
 *  
 *  1) Initialize res=0 
 *  2) while (items are not considered ){
 *        i=selectAnItem()
 *        if(feasible to consider i)
 *             res=res+- i ;
 *      }
 *  3) return res 
 *  }
		 */
	}

}


/**
 * 
 * Introduction to Greedy Algorithms

Greedy is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that offers the most obvious and immediate benefit. So the problems where choosing locally optimal also leads to the global optimal solution are best fit for Greedy.

For example, consider the Fractional Knapsack Problem. The problem states that:

Given a list of elements with specific values and weights associated with them, the task is to fill a Knapsack of weight W using these elements such that the value of knapsack is maximum possible.

Note: You are allowed to take a fraction of an element also in order to maximize the value.


The local optimal strategy is to choose the item that has maximum value vs weight ratio. This strategy also leads to global optimal solution because we are allowed to take fractions of an item.



In general, the Greedy Algorithm can be applied to solve a problem if it satisfies the below property:

At every step, we can make a choice that looks best at the moment, and we get the optimal solution of the complete problem.




Let us consider one more problem known as the Activity Selection Problem to understand the use of Greedy Algorithms.

Problem: You are given N activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
Example 1: Consider the following 3 activities sorted by
finish time.
     start[]  =  {10, 12, 20};
     finish[] =  {20, 25, 30};
A person can perform at most two activities. The 
maximum set of activities that can be executed 
is {0, 2} [ These are indexes in start[] and 
finish[] ]

Example 2: Consider the following 6 activities 
sorted by finish time.
     start[]  =  {1, 3, 0, 5, 8, 5};
     finish[] =  {2, 4, 6, 7, 9, 9};
A person can perform at most four activities. The 
maximum set of activities that can be executed 
is {0, 1, 3, 4} [ These are indexes in start[] and 
finish[] ]



The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the start time is more than or equal to the finish time of previously selected activity. We can sort the activities according to their finishing time so that we always consider the next activity as minimum finishing time activity.

To do this:
Sort the activities according to their finishing time.
Select the first activity from the sorted array and print it.
Do following for remaining activities in the sorted array.
If the start time of this activity is greater than or equal to the finish time of previously selected activity then select this activity and print it.
 * 
 */
