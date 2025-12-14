package linked_List;

import java.util.HashSet;

/**
 * Problem #1 : Rotate the LL 
 * Given a singly linked list of size N. The task is to left-shift the linked list by k nodes,
 * where k is a given positive integer smaller than or equal to length of the linked list. 
 * 
 * Problem #2 : Detect a loop in LL
 * Given a linked list of N nodes. The task is to check if the linked list has a loop. Linked list can contain self loop.
 * 
 *     ///////////////////////////////////////////////////////////////////////IMPORTANT
 * Problem #3: REmpve loop in a linked list 
 * Given a linked list of N nodes such that it may contain a loop.
 * A loop here means that the last node of the link list is connected to the node at position X(1-based index). If the link list does not have any loop, X=0.
 * Remove the loop from the linked list, if it is present, i.e. unlink the last node which is forming the loop.
 * 
 * 
 * Implementation:
 *    We can use the Floyd Cycle Detection algorithm to detect and remove the loop. 
 *    In Floyd's algo, the slow and fast pointers meet at a loop node. 
 *    We can use this loop node to remove the cycle. 
 *    Count the number of nodes in the loop. Let the count be k.
 *    Fix one pointer to the head and another to a kth node from the head.
 *    Move both pointers at the same pace, they will meet at the loop starting node.
 *    Get a pointer to the last node of the loop and make the next of it NULL.
 *
 * ///////////////////////////////////////////////////////////////////////IMPORTANT
 * 
 * Problem #4 : Add numbers 
 * Given two numbers represented by two linked lists, write a function that returns Sum list.
 *  The sum list is linked list representation of addition of two input numbers.
 *  
 *  
 *  SEPERATE FILE LL98 
 *  
 * Problem #5 : Intersection point in Y shaped LL
 * Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
 * 
 *
 */
public class LL08_LL_sums_medium {

	public static void main(String[] args) {
		// sums
		//Start
		Node head = new Node(100);
		head.next = new Node(200);
		head.next.next = new Node(300);
		head.next.next.next = new Node(400);
		head.next.next.next.next = new Node(500);
		head.next.next.next.next.next = new Node(600);
		head.next.next.next.next.next.next = new Node(700);
		// head.next.next.next.next.next.next.next= new Node(800);
		
		int ans=intersectPoint(head, head);
		System.out.println(" VAL IS "+ans);
		
		
		head=rotate(head,3);
		System.out.println(" Rotated ans ...");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		boolean anb=detectLoop(head);
		System.out.println(" Loop present is "+anb);
		
		head=removeLoop(head);
		System.out.println(" Removed loop by changing data to -1 ans ...");
		LL02_Linked_List_Func.PrintLinkedList(head);

		
		head=removeLoop_Floyd_Hare_Turtle(head);
		System.out.println(" Removed loop Floyd ...");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=removeLoop_Floyd_Hare_TurtleGoG(head);
		System.out.println(" Removed loop Floyd ...");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		
	}

	 private static int intersectPoint(Node head1, Node head2)
	{
         // code here
        HashSet<Node> hs=new HashSet<>();
         while(head1!=null){
             hs.add(head1);
             head1=head1.next;
         }
         while(head2!=null){
             if(hs.contains(head2)){
                 return head2.data;
             }
             head2=head2.next;
         }
         return -1;
         
	}
	

	private static Node removeLoop_Floyd_Hare_Turtle(Node head) {
		// Floyd 
		
		//Base case 
		if(head==null || head.next==null || head.next.next==null) {
			return head;
		}
		
		  if( head==head.next) {
				head.next=null;
				return head;
			   }
		
		
		Node temp=head;
		
		Node hare=head.next;
		Node turtle=head;
		boolean No_loop=true;
		
		while(hare!=null && hare.next!=null) {
			if(hare==turtle) {
				No_loop=false;
				break;
			}
			turtle=turtle.next;
			hare=hare.next.next;
		}
		
		if(No_loop) {
			return temp;
		}
		
		// Now turtle at a good point in loop
		//Find size of loop
		int size=1;
		hare=temp.next;
		while(hare!=turtle) {
			size++;
			hare=hare.next;
		}
		System.out.println(" Size of loop is "+size);
		
		// 1 2 3 4 5 6 7 8 9 0 ; 0 pointing to 3 
		// 1 2 -- 3 4 5 6 7 8 9 0-- 3 loops 
		//  Size = 8 
		// initiate hare ad turtle AS head
	    // Hop one pointer size times 
		// p1 and p2 in head 1
		// p1 hops 8 , p1 at 9 
		// Hop p1 and p2 simultaneously 
		// p1 = 0 p2 = 2 
		// p1=3 p2=3 
		//STOP --> Got starting 
		
		hare=head;
		turtle=head;
		
		while(size>0) {
			hare=hare.next;
			size--;
		}
		Node prevloop=hare;
		while(hare!=turtle) {
			prevloop=hare;
			hare=hare.next;
			turtle=turtle.next;
		}
		prevloop.next=null;
		
		return temp;
	}

	 private static Node removeLoop_Floyd_Hare_TurtleGoG(Node head) {
		//using two pointers and moving one pointer(slow) by one node and 
	        //another pointer(fast) by two nodes in each iteration.
		 //Single self repeating 
		   if( head.next==null ) {
			   return head;
		   }
		   if( head==head.next) {
			head.next=null;
			return head;
		   }
		 
		    Node temp=head;
	        Node fast = head.next;
	        Node slow = head;
	      
	        while( fast!=slow )
	        {
	            //if the node pointed by first pointer(fast) or the node 
	            //next to it is null, then loop is not present so we return 0.
	            if( fast==null || fast.next==null ) 
	            return temp;
	            
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        //both pointers now point to the same node in the loop.
	        
	        int size = 1;
	        
	        fast = fast.next;
	        //we start iterating the loop with first pointer and continue till 
	        //both pointers point to same node again.
	        while( fast!=slow )
	        {
	            fast = fast.next;
	            //incrementing the counter which stores length of loop..
	            size+=1;
	        }
	        
	        //updating the pointers again to starting node.
	        slow = head;
	        fast = head;
	        
	        //moving pointer (fast) by (size-1) nodes.
	        for(int i=0; i<size-1; i++)
	            fast = fast.next;
	        
	        //now we keep iterating with both pointers till fast reaches a node such
	        //that the next node is pointed by slow. At this situation slow is at
	        //the node where loop starts and first at last node so we simply 
	        //update the link part of first.
	        while( fast.next != slow )
	        {
	            fast = fast.next;
	            slow = slow.next;
	        }
	        //storing null in link part of the last node.
	        fast.next = null;
	        return temp;
	    }
	 
	private static Node removeLoop(Node head){
	        // code here
	        // remove the loop without losing any nodes
	         if(head==null || head.next==null||head.next.next==null){
		            return head;
		        }
		       
		       Node temp=head;
		       boolean flg=true;
		        while( head.next!=null){
		            
		            if(head.data==-1){
		                flg=false;
		                break;
		            }
		            head.data=-1;
		            head=head.next;
		        }
		        
		        if(flg){//no loop
		            return temp;
		        }
		        //Fix turtle 
		        if(head.next==head){
		            head.next=null;
		            return temp;
		        }
		        Node fix=head.next;
		        while(fix.next!=head){
		            fix=fix.next;
		        }
		        fix.next=null;
		        return temp;
	    }
	 
	 private static boolean detectLoop(Node head){
	        // Add code here
	        if(head==null || head.next==null||head.next.next==null){
	            return false;
	        }
	       
	        Node turtle=head;
	        Node hare=head.next;
	        while(hare!=null && hare.next!=null){
	            
	            if(hare==turtle){
	                return true;
	            }
	            turtle=turtle.next;
	            hare=hare.next.next;
	        }
	        return false;
	    }
	
	 private static Node rotate(Node head, int k) {
	        // add code here
	        Node tail=null;
	        Node break1=null;
	        Node head2=null;
	        int count=1;int num=0;
	        Node temp=head;
	        while(head!=null){
	            if(count==k){
	                break1=head;
	                head2=head.next;
	            }
	            count++;num++;
	            tail=head;
	            head=head.next;
	        }
	        if(k==num){
	            return temp;
	        }
	        tail.next=temp;
	        break1.next=null;
	        return head2;
	    }
}
