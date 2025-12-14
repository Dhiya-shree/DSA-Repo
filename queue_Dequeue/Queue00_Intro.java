package queue_Dequeue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 *  Queue Data Structure :
 *  Container Adapter -
 *  It works on other container - array , linked list , stack to provide interface
 *  Pipe - supply chain
 *  FIFO - first in first out 
 *  
 *  dequeue()<---- |1|2|3|4|5<----- enqueue()
 *                  |       | 
 *                front    rear
 * 
 * Operations: 
 *  enqueue - add to queue 
 *  dequeue - remove 
 *  getFront - return int 
 *  getRear - return int at back 
 *  size - int of size 
 *  isEmpty - return true if empty 
 *  
 *  
 *  Application :
 *  1) Single resource multiple consumers -> ticket system 
 *  2) Synchronization between slow and fast devices 
 *  3) In operating systems buffers for keyboard, Spooling , First come first serve scheduling , semaphores  
 *  4) IN computer networks - mail queue , routers , switches 
 *  5) Variations : Deque , Priority queue , Doubly ended priority queue.
 *    
 *       Semaphores are sleeping processors available in queue .
 *       When resource available process wake up and use the resources 
 *       
 *       Spooling - used in printers , printers can do one process a time so used queue
 *       
 *       While routing data from high data network to low , a queue is used 
 *       
 * 
 * Queue all operation in O1 
 * C++:
 * STL - push - enqueue
 * STL - pop  - dequeue
 * queue<int> q;
 * 
 * JAVA:
 * An interface implemented by LinkedList , ArrayDeque
 * 
 * Queue inherits from collection interface 
 *            inherits     |<------- Linked List 
 * Collection <----- Queue |implements
 *                         |<------- Array Dequeue
 *                         
 * 
 * Methods :
 * Function that do not |Functions that 
 *  throw Exceptions    |throw exception :
 *         1) peek <-----|----element
 *         2) offer<-----|----add
 *         3) poll <-----|----remove
 * 
 *  ArrayDeque > Linked List :
 *  Cache friendly as  array
 *  Faster for find 
 *  
 *  LinkedList> ArrayDeque :
 *  At adding , if capacity greatly increase 
 *  Time complexity=O N 
 *  Only amortized complexity O 1 
 *  
 *                         
 * @author shree
 *
 */
public class Queue00_Intro {

	public static void main(String[] args) {
	//	Queue<Integer> q=new LinkedList<>();
		// ArrayDeque used -> cache friendly and faster 
		// Linked list worst -> O 1 
		// ArrayDeque -> amortized worst -> O 1 
		// Amortized -> Out of 1000 time runnig , one of them taking N time where all other takes 1
		// When exeeds capacity , Array addition O N 
		
		Queue<Integer> q=new ArrayDeque<>();
		
		q.offer(10);
		q.add(20);
		q.offer(30);
		q.add(50);
		q.add(50);
		
		//Offer best than add
		// When used with capacity 
		// If added return true 
		// Else return false 
		
		System.out.println(" Size "+q.size());
		System.out.println(" Empty "+q.isEmpty());
		System.out.println(q.toString());
		
		int val=q.poll();
		System.out.println(" poll "+val);
		//Remove first itemm and return the same 
		//return null if empty
		
		val=q.peek();
		System.out.println(" peek "+val);
		//No remove first item and return first
		//return null if empty
		
		val=q.remove();
		System.out.println(" remove "+val);
		//Remove first itemm and return the same 
		//return exception  if empty
		
		val=q.element();
		System.out.println(" peek "+val);
		//No remove first item and return first
		//return exception if empty
		

	}

}
