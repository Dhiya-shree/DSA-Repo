package queue_Dequeue;
/**
 * Rotate Deque By K
Difficulty: EasyAccuracy: 80.26%Submissions: 12K+Points: 2
Given a deque dq containing non-negative integers and a positive integer k, the task is to rotate elements of the deque by k places in a circular fashion. There will be two rotations which you have to implement depending on the type of rotating query. Below is the description of rotating type and value of k for which you have to rotate in circular way:
Type-1. right_Rotate_Deq_ByK(): this function should rotate deque by K places in a clockwise fashion.
Type-2. left_Rotate_Deq_ByK(): this function should rotate deque by K places in an anti-clockwise fashion.

Examples:

Input: dq = [1 2 3 4 5 6], type = 1, k = 2
Output: 5 6 1 2 3 4 
Explanation: The query type is 1 and k is 2. So, we need to right rotate dequeue by 2 times. In 1 right rotation we get 6 1 2 3 4 5. In another we get 5 6 1 2 3 4.
 * 
 * 
 * @author shree
 *
 */
public class QueueDequeue03_Rotate_Reverse {
	// Function to rotate deque by k places in anti-clockwise direction.
	public static void left_Rotate_Deq_ByK(ArrayDeque<Integer> deque, int k) {
	    // Your code here
	     while(k-->0){
	        int a=deque.removeFirst();
	        deque.addLast(a);
	        
	    }
	}

	// Function to rotate deque by k places in clockwise direction.
	public static void right_Rotate_Deq_ByK(ArrayDeque<Integer> deque, int k) {
	    // Your code here
	    while(k-->0){
	        int a=deque.removeLast();
	        deque.addFirst(a);
	        
	    }
	}
}

