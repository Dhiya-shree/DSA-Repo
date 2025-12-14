package queue_Dequeue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem #1 : Reversing queue
 * 
 * Method 1: Iterative 
 *  use a stack/queue to store 
 *  Iterate again to store reverse 
 *  
 * Method 2: No duplicates 
 *  Traverse the queue 
 *  Pointer for rear 
 *  While rear != peek 
 *      add=remove
 *      
 * Method 3: Recursive 
 *     reverse()
 *     if(q is empty )
 *     return ;
 *        x=front data 
 *        pop
 *        reverse (x)
 *        q.push(x)
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Queue04_sums_basic {

	public static void main(String[] args) {
		
		Queue<Integer> q=new LinkedList<>();
		q.add(10);
		q.add(100);
		q.add(1000);
		q.add(10000);
		q.add(100000);
		System.out.println(" Original "+q.toString());
		Queue<Integer> q2=Iterative(q);
		System.out.println(" Iterative "+q.toString());
		Recursive(q);
		System.out.println(" Recursive "+q.toString());
		
		
	}

	private static void Recursive(Queue<Integer> q) {
		// recursion 
		if(q.isEmpty()) {
			return ;
		}
		int x=q.poll();
		Recursive(q);
		q.add(x);
		
		
	}

	private static Queue<Integer> Iterative(Queue<Integer> q) {
		Stack <Integer> s=new Stack<>();
		
		while(!q.isEmpty()) {
			s.push(q.poll());
		}
		
		while(!s.isEmpty()) {
			q.add(s.pop());
		}
		return q;
	}

}
