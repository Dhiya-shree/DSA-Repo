package queue_Dequeue;

import java.util.ArrayDeque;

/**
 * JAVA Dequeue:
 * 
 * Collection <---- Queue <-- DEque <--- ArrayDequeue
 * ArrayDeque faster than inked list 
 * Because of array implementation 
 * 
 * Array Dequeue has functionalities of Stack , queue  dequeue
 *
 * Stack --- Vector , ArrayDeque
 * Vector is thread safe class
 * Stack can be implemented as vector ..
 * But as it is thread safe class - array deque is used 
 * Stack - push , pop , peek 
 * 
 * Why it must not be thread safe ?
 * Thread safe means it will have extra overhead for thread safety
 * And no use in single threaded environment 
 * 
 * Queue - Linked List , ArrayDeque
 * Array deque better -> cache friendly , array implementation 
 *                        greater performance 
 * Queue - offer,add,remove,poll,peek,element
 *                        
 * Deque - Linked List , ArrayDeque 
 * Again arrayDeque is used 
 * Deque func -
 * Implemented by ArrayDeque - circular array 
 * Amortized time complexity is O 1
 * 
 * front - first 
 * rear - last 
 * dq = { }
 *  No exception ----- Exception
 * offerFront  --------addFirst
 * offerLast   --------addLast
 * pollFirst   --------removeFirst
 * pollLast   --------removeLast
 * peekFirst   --------getFirst
 * peekLast   -------- getLast
 * 
 * Exception function are needed :::<<<<<<<<<<<<<<<<<<<<<<<<
 *  When we have NULL stored as value in dequeue
 *  
 * When values are null , peek will also throw null so confusion caused 
 * But get will work and can distinguish , as it throw exception if dequeue is empty
 * 
 * Iteration in DQ :
 * 1) Iterator :
 *      Iterator it = dq.iterator();
 *      while(it.hasNext){
 *      it=it.next;
 *       ....do something
 *       }
 *       For descending :
 *       Iterator it = dq.descendingIterator();
 * 
 * 2) For each 
 *    for(int x : dq){
 *     //Do something 
 *    }
 * @author shree
 *
 */
public class QueueDequeue01_ArrayDeque {

	public static void main(String[] args) {
		// jiyugi
		ArrayDeque<Integer> dq=new ArrayDeque<Integer>();
        dq.offerFirst(1);
        dq.offerFirst(2);
        dq.offer(3);// queue function 
        System.out.println(" DQ "+dq.toString());
        dq.push(0);// stack function 
        System.out.println(" DQ "+dq.toString());
        dq.offerFirst(-1);// dequeue func 
        System.out.println(" DQ "+dq.toString());
        dq.offerLast(10);
        dq.pollFirst();
        System.out.println(" DQ "+dq.toString());
        dq.pollLast();
        System.out.println(" DQ "+dq.toString());
        
		
	}

}
