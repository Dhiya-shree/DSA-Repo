package queue_Dequeue;
/**
 * 
 * Deque Traversal
Difficulty: BasicAccuracy: 44.42%Submissions: 29K+Points: 1
Given a deque dq containing integer elements, the task is to traverse the dq and print its elements of it. 
Note: Print a newline at the end.

Examples:

Input: dq = [1, 2, 3, 4, 5]
Output: 1 2 3 4 5
Explanation: dq will look like [1, 2, 3, 4, 5].
Input: dq = [1]
Output: 1
Explanation: dq will look like [1].
Constraints:
1 ≤ dq.size() ≤ 105
 * 
 * @author shree
 *
 */
public class QueueDequeue02_Clear_Traverse {
	//User function Template for Java


	//Function to traverse the Deque and print the elements of it.
	public static void printDeque(ArrayDeque<Integer> deq)
	{
	   //Your code here
	   /*Note: The output must be printed on different lines for multiple test cases.*/
	   //Below wont work
	  /**  for(Integer i:deq){
	       System.out.print(i+" ");
	   }*/
	    for(Integer i:deq){
	       System.out.print(i+" ");
	   }
	   System.out.println();
	}
}

