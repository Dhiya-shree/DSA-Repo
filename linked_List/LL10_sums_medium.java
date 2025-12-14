package linked_List;

/**
 * Problem # 1:Reverse a LL RECURSIVE
 * 
 * Method 1 : LL head - node1 - node2..... head- set Rest_head= node1- node2
 * .... Rest Tail = next of head
 * 
 * rest of tail --> head head--> null
 * 
 * Send the remaining Reest_head with head as node1 in recursion
 * 
 * Method 2: Instead of head and Rest Head Split as Rest tail head
 * 
 * Similar to iterative one
 * 
 * Have pointer prev and curr
 * 
 * curr next set as prev When curr is null and reach the end Return prev as new
 * head
 * 
 * 
 * Problem #2 : Reverse linked list in group of K
 * 
 * Our Task: Given a Linked List, the task is to Reverse Linked List in Groups
 * of size k
 * 
 * Example:
 * 
 * I/P: 10->20->30->40->50 k=3
 *  O/P: 30->10->20->50->40
 * 
 * I/P: 1->2->3->4->5->6->7->8 k=3 
 * O/P: 3->2->1->6->5->4->8->7
 * 
 * I/P: 1->2->3->4->5->6->7->8 k=5 
 * O/P: 5->4->3->2->1->8->7->6
 * 
 * Iterative :
 * 
 * Idea - After K links , consider the head and start the reverse 
 * 
 * While head ! null:
 *     Get the head as prevFirst ... 1st in original will be linked with last with second reverse and so on ...
 *     
 *     while head!=null && count less than K 
 *          reverse 
 *          
 *     if first K means , get the prev as start for 1st K value 
 *     else set Prev K (start of original).next --> prev current reversed start 
 *     
 *     prevFirst= head // As while loop got completed and this is a new pass.
 * 
 * 
 * Problem #3 :Detect Loop
 * 
 *   1) naive solution O n2 .. traverse every previous problem and compare with curr Node next 
 *   2) With space --> Create hashset if node already present loop detected
 *   3) With No space O 1 using dummy node 
 *         Point all the value to a dummy node 
 *         If the current node already points to dummy node 
 *         Bae there is a loop
 *   4) Changes in structure/ Class of linked List 
 *        Create an variable visited in LL 
 *        If next ode visited is already yes .. there you have a loop
 *        
 *   5) Flyod's Cycle detection algorithm 
 *   
 *   Time O M+ N 
 *   M -> no of nodes before cycle 
 *   n- > no of nodes in the cycle/ length of cycle 
 *        Turtle going on normal speed 
 *        Hare goes on 2X speed 
 *          It is must to go as 2x , because the diff between hare and  tortoise at each hop will increase by 1 
 *          As the distance constantly increase by 1 , at one point hare will be n points ahead of turtle 
 *          As it is a circle , when hare is n hops ahead of turtle and circle length is N 
 *          They are bound to meet ..
 *          
 *          We can not make the hare hope more than 2x , then diff will be 2 , 3 and so on ..
 *          On these cases instead of n .. it will pass the turtle as n+1 . n+2 and keep on running 
 *        So If they meet you have loop 
 *        
 *        To find loop length ; Fix the turtle 
 *          Rn hare in 1X time , When both of them meet again .. count the no of hops taken 
 *          There you go .. you have count of nodes loop 
 *          
 *        To find start of the loop :
 *          Turtle -> hare -> head 
 *          /// No need for count to get the start 
 *          Use cycle , break when hare == tortoise 
 *          They meet at their first meeting
 *           point 
 *          
 *           Set turtle as head 
 *           And hop both turtle and hare by 1x hops 
 *           Both of them meet at loop starting point
 *           
 *            start head 
 *            had ----- ------ - ---- loop start ----- --- ---  First meeting node -------- loops to start 
 *            <--------- M size -------->< -------------------K ----->
 *                                      <-----------                ------ N ------------------------>
 *           Because :
 *           Before the first meeting point
 *             x -- no of iteration of slow before meeting the first point 
 *             y -- no of iteration / cycle made by fast before meeting in the first point 
 *             
 *             Distance travelled by fast * 2 = Distance travelled by slow 
 *             (  M + K + (x* N) )*2= M + K + y*N
 *             M+ K =  N (y - 2x)
 *             
 *             Thus M+K is an multiple of N 
 *             
 *             Keep fast in first meeting point , slow in head .. hop by 1 time 
 *             How M+K being an multiple of N , makes hem meet at starting of loop 
 *             
 *            start head 
 *            slow ----- ------ - ---- loop start ----- --- ---  First meeting node FAST -------- loops to start 
 *            <--------- M size -------->< -------------------K ----->
 *                                      <-----------                ------ N ------------------------>
 *             
 *           Slow will reach start in M hops 
 *           Fast wil also reach from first meeting point to start in M hops 
 *           
 *           This is because ....
 *           Fast pointer took M+K distance to reach the first meeting point 
 *           M+K is a multiple of N .. Consider M+K= N 
 *           For fast to again reach first meeting pint it will take M+K  
 *           M+K = N 
 *           It is already after K hops from the starting .. so with M hops it will reach start point 
 *           
 *   Problem # 3: Segregate Even and Odd Nodes in C++
 *   
 *   Given a Linked List, the task is to Segregate Even and Odd Nodes in linked list
 *   
 *   1) Take note of last point 
 *      Traverse from start 
 *      If val is odd , add the node to end of last 
 *      Increase the size of last 
 *      
 *      If val is even continue 
 *      
 *   2) Have four pointer odd start odd end , even start even end 
 *   
 *      First odd found node odd start 
 *      First even found node even start 
 *      
 *      After that all odd after odd end 
 *      All even nodes after even end 
 *      
 *      Even end.next =odd start 
 *      
 *      Return even start 
 *   
 *   
 *   Problem #4 : Intersection Point of Two LL
 *   
 *   Method 1:
 *   1) Using Hash Set
 *   Time Complexity: O(m+n)
 *   Space Complexity: O(m)
 *      Create hashset store all in LL1 
 *      Traverse through LL2 
 *      if LL2 node present in hashset that is the insertion point 
 *      
 *  Method 2:
 *  2) Difference in Node Count Method
 *  Time Complexity: O(m+n)
 *  Space Complexity: O(1)
 *     Count the no of node in both links C1 and C2 ex)6 and 4 
 *     Traverse the bigger LL , no of times  to hop= difference in count of both LL.. ex) 2 (6-4)
 *     Traverse both LL1 and LL2 simultaneously and check if any node is intersection point 
 *     
 *     
 *   
 *   Problem #5 : Palindrome in LL 
 *   
 *   1) Using stack 2 traversal 
 *   2) Using middle approach 
 *      Find middle 
 *      Reverse middle.next to end 
 *      Compare with val from starting till middle 
 * 
 * @author shree
 *
 */
public class LL10_sums_medium {

	public static void main(String[] args) {
		// medium 
		Node head = new Node(100);
		head.next = new Node(200);
		head.next.next = new Node(300);
		head.next.next.next = new Node(400);
		head.next.next.next.next = new Node(500);
		head.next.next.next.next.next = new Node(600);
		head.next.next.next.next.next.next = new Node(700);
		head.next.next.next.next.next.next.next= new Node(800);
			
		
		head=ReverseInKGroup(head,3);
		System.out.println(" After reversing  ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=reverseKGoG(head,3);
		System.out.println(" After reversing  ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=ReverseInKGroupRecursive(head,3);
		System.out.println(" After reversing recursive  ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=ReverseInKGroupRecursiveGoG(head,3);
		System.out.println(" After reversing recursive  ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=ReverseRecursive(head);
		System.out.println(" After reversing  ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=ReverseRecursiveEasy(head,null);
		System.out.println(" After reversing  ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=SegregateOddAndEvenNaive(head);
		System.out.println(" After segregate  ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		Node head3=SegregateOddAndEven(head);
		System.out.println(" After segregate  ....");
		LL02_Linked_List_Func.PrintLinkedList(head3);
		
		Node head2 = new Node(100);
		head2.next = new Node(200);
		head2.next.next = new Node(300);
		head2.next.next.next = new Node(400);
		//head2.next.next.next.next = head2;
		
		boolean anb=DetectLoopUsingDummy(head2);
		System.out.println(" Loop present is "+ anb);	
	
	    Node intersect=new Node(-1);
	    intersect.next=new Node(-2);
	    intersect.next.next=new Node(-3);
	    intersect.next.next.next = new Node(-4);
	    intersect.next.next.next.next = new Node(-5);
	    
	  //Interset 
	   head.next.next.next.next.next.next.next.next= intersect;
	   head2.next.next.next.next = intersect;
	   
	   int ans=FindTheIntersection(head,head2);
	   System.out.println(" Intersection found "+ans);
	    
	}
	 
   private static int FindTheIntersection(Node head, Node head2) {
		// intersection 
	    
	   System.out.println("LL01 .......");
		LL02_Linked_List_Func.PrintLinkedList(head);
		System.out.println("LL02 ....");
		LL02_Linked_List_Func.PrintLinkedList(head2);
		
	   int coun1=0;
	   int coun2=0;
	   Node temp1=head;
	   Node temp2=head2;
	   while(temp1!=null || temp2!=null) {
		   
		   if(temp1!=null) {
		   coun1++;
		    temp1=temp1.next;
		   }
		   
		   if(temp2!=null) {
			   coun2++;
			   temp2=temp2.next;
		   }
	   }
	   int diff= Math.abs(coun1-coun2);
	 //  int count=Math.min(coun2,coun1);
	   System.out.println(" Count 1 "+coun1+" Coun2 "+coun2+" ... Diff "+diff);
	   if(coun1>coun2) {
		  while(diff>0 && head!=null) {
			  head=head.next;
			  diff--;
		  }
		//  head=head.next;
	   }
	   else {
		   while(diff>0 && head2!=null) {
				  head2=head2.next;
				  diff--;
			  }
		//   head2=head2.next;
	   }
	   
	  System.out.println(" After skipping..head... "+head.data);
	  System.out.println(" Head 2.... "+head2.data);
	   while(head!=null && head2!=null ) {
		   if(head==head2) {
			   System.out.println(" Intersection found .....");
			   return head.data;
		   }
		   
		   head=head.next;
		   head2=head2.next;
	   }
	   System.out.println(" Intersection NOT found .....");
		return 0;
	}

private static Node SegregateOddAndEvenNaive(Node head) {
		// segreagte two traversal 
	   
	   Node temp=head;
	   Node Last=head;
	   
	   int len=1;
	   int odd=0;
	   while(Last.next!=null){
		   len++;
		   if(Last.data%2!=0) {
			   odd++;
		   }
		   Last=Last.next;
	   }
	   
	   if(Last.data%2!=0) {
		   odd++;
	   }
	   
	   if(odd==len || odd==0) {
		   return temp;
	   }
	   temp=Last;
	 Node prev=null;Node next=null;
	 boolean firsteven=true;
	   while(head!=null) {
		   
		   if(head.data%2!=0) {
			   Last.next=head;
			   Last=head;
			   
			   next=head.next;
			   if(prev!=null) {
				   prev.next=next;
			   }
			   
			 
			   head=next;
		   }
		   else {
			   if(firsteven) {
				   temp=head;
				   firsteven=false;
			   }
			   head=head.next;
		   }
		   prev=head;
	   }
	   
		return temp;
	}


private static Node SegregateOddAndEven(Node head) {
		//Segregate Odd and even 
	    Node odd_start=null,odd_end=null;
	    Node even_start=null,even_end=null;
	   while(head!=null) {
		if(head.data%2==0) {
			//First even encountered 
			if(even_start==null) {
				even_start=head;
				even_end=head;
			}
			else {// adding new even element in the end of even 
				// Updating even end 
				even_end.next=head;
				even_end=head;
			}
		}
		else {
			//For odd first element 
			if(odd_start==null) {
				odd_start=head;
				odd_end=head;
			}
			else {
				//Add curr element in odd end and update the odd end 
				odd_end.next=head;
				odd_end=head;
			}
		}
		head=head.next;
	   }
	   
	   // If no even 
	   if(even_start==null) {
		   odd_end.next=null;
		   return odd_start;
	   }
	   else if(odd_start==null) {
		   even_end=null;
		   return even_start;
	   }
	   else {
		   even_end.next=odd_start;//After even odd elements starting
		   odd_end.next=null; // Ending odd
		   return even_start;
	   }
	//	return null;
	}


private static boolean DetectLoopUsingDummy(Node head) {
		// detect using dummy 
	   Node Dummy=new Node(1);
	   Node next=null;
	   while(head.next!=null && head!=null) {
		   if( head.next==Dummy) {
			   return true;
		   }
		   next=head.next;
		   head.next=Dummy;
		   head=next;
	   }
		return false;
	}


private static Node ReverseInKGroupRecursiveGoG(Node head, int k) {
	   Node curr=head,next=null,prev=null;
       int count=0;
       while(curr!=null&&count<k){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
           count++;
       }
       if(next!=null){
           Node rest_head=ReverseInKGroupRecursiveGoG(next,k);
           head.next=rest_head;
       }
       return prev;
	}


private static Node ReverseInKGroupRecursive(Node head, int k) {
		Node prevFirst=head;//Stores actual head of the pass 
		int count=1;
		Node prev=null;
		Node next=null;
		
		while(head!=null && count<=k) {
			next=head.next;
			head.next=prev;
			prev=head;//new head
			head=next;	
			}
		
		//For all except last node seen 
		if(next!=null) {
			
			//Connect old head to new head of changed 
			prevFirst.next=ReverseInKGroupRecursive(head, k);
		}
		return prev;
	}


private static Node ReverseInKGroup(Node head, int k) {
		// reverse in group 
	   
	    int count=1;
	    Node temp=head;
	    Node prevFirst=null;
	    //Must be set as NULL at every instance 
	    Node prev=null;Node next=null;
	    Node curr=head;
	    boolean firstu=true;
	    while(head!=null) {
	    	
	    	// Reversing code for each pass 
	    	curr=head;
	    	prev=null;next=null;
	    //	prevFirst=head;
	    	while(head!=null && count<=k) {
	    	next=head.next;
	    	head.next=prev;
	    	prev=head;
	    	head=next;
	    	count++;
	    	}
	    	if(prev!=null) {
	    	System.out.println(" Prev data "+prev.data);}
	    	if(next!=null) {
	    		System.out.println(" Next "+next.data);
	    	}
	    	if(prevFirst!=null) {
	    		System.out.println(" Prev First "+prevFirst.data);
	    	}
	    //       Reversing code ends 
	    	
	    	if(firstu) {//First time K complete 
	    		System.out.println(" Setting prev as head "+prev.data);
	    		temp=prev;
	    	//	head=prev;
	    		firstu=false;
	    	}
	    	
	    	//  Prev first is head of first pass originally 
	    	//  A
	    	else {
	    		System.out.println(" Linking .....prevFirst "+prevFirst.data+" prev "+prev.data);
	    		prevFirst.next=prev;
	    	}
	    	
	    	
	    	//End of converted must be starting for nexxt pass
	    	// Next pass original start
	    	//Will be used to set last 
	    	prevFirst=curr;
	    	count=1;
	    }
	   
		return temp;
	}

   private static Node reverseKGoG(Node head,int k){
       Node curr=head,prevFirst=null;
       boolean isFirstPass=true;
       while(curr!=null){
           Node first=curr,prev=null;
           int count=0;
           while(curr!=null&&count<k){
           Node next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
           count++;
           }
           
           if(isFirstPass){head=prev;isFirstPass=false;}
           else{prevFirst.next=prev;}
           prevFirst=first;
       }
       return head;
   }

private static Node ReverseRecursiveEasy(Node curr,Node prev) {
	   if(curr==null)return prev;
       Node next=curr.next;
       curr.next=prev;
       return ReverseRecursiveEasy(next,curr);
   
	}


private static Node ReverseRecursive(Node head){
        if(head==null||head.next==null)return head;
        Node rest_head=ReverseRecursive(head.next);
        Node rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;
        return rest_head;
    }

}

/**
 * 
 *Reverse a linked list in groups of size k

Given a linked list, write a function to reverse every k nodes (where k is an input to the function). 

Example: 

Input: 1->2->3->4->5->6->7->8->NULL, K = 3 
Output: 3->2->1->6->5->4->8->7->NULL 
Input: 1->2->3->4->5->6->7->8->NULL, K = 5 
Output: 5->4->3->2->1->8->7->6->NULL 

Reverse the first sub-list of size k. While reversing keep track of the next node and previous node. Let the pointer to the next node be next and pointer to the previous node be prev. See this post for reversing a linked list.
head->next = reverse(next, k) ( Recursively call for rest of the list and link the two sub-lists )
Return prev ( prev becomes the new head of the list (see the diagrams of an iterative method of this post )
Below is image shows how the reverse function works: 



Below is the implementation of the above approach:

// Java program to reverse a linked list in groups of
// given size
class LinkedList {
	Node head; // head of list

	/* Linked list Node
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	Node reverse(Node head, int k)
	{
		if(head == null)
		return null;
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list 
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/* next is now a pointer to (k+1)th node
		Recursively call for the list starting from
		current. And make rest of the list as next of
		first node 
		if (next != null)
			head.next = reverse(next, k);

		// prev is now head of input list
		return prev;
	}

	/* Utility functions 

	/* Inserts a new Node at front of the list. 
	public void push(int new_data)
	{
		/* 1 & 2: Allocate the Node &
				Put in the data*
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head 
		new_node.next = head;

		/* 4. Move the head to point to new Node 
		head = new_node;
	}

	/* Function to print linked list 
	void printList()
	{
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions 
	public static void main(String args[])
	{
		LinkedList llist = new LinkedList();

		/* Constructed Linked List is 1->2->3->4->5->6->
		7->8->8->9->null 
		llist.push(9);
		llist.push(8);
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		System.out.println("Given Linked List");
		llist.printList();

		llist.head = llist.reverse(llist.head, 3);

		System.out.println("Reversed list");
		llist.printList();
	}
}

 

Output

Given linked list 
1 2 3 4 5 6 7 8 9 
Reversed Linked list 
3 2 1 6 5 4 9 8 7 
Complexity Analysis: 

Time Complexity: O(n). 
Traversal of list is done only once and it has ‘n’ elements.
Auxiliary Space: O(n/k). 
For each Linked List of size n, n/k or (n/k)+1 calls will be made during the recursion.
We can solve this question in O(1) Space Complexity.

Approach – 2 Space Optimized – Iterative 
The following steps are required for this Algorithm:

Create a dummy node and point it to the head of input i.e dummy->next = head.
 Calculate the length of the linked list which takes O(N) time, where N is the length of the linked list.
 Initialize three-pointers prev, curr, next to reverse k elements for every group.
Iterate over the linked lists till next!=NULL.
Points curr to the prev->next and next to the curr next.
Then, Using the inner for loop reverse the particular group using these four steps:
curr->next = next->next
next->next = prev->next
prev->next = next
next = curr->next
 7. This for loop runs for k-1 times for all groups except the last remaining element, for the last remaining element it runs  for the remaining length of the linked list – 1.

 8. Decrement count after for loop by k count -= k, to determine the length of the remaining linked list.

 9. Change prev position to curr, prev = curr.

Here is the code for the above algorithm.

import java.util.*;

// Linked List Node
class Node {
	int data;
	Node next;
	Node(int a)
	{
		data = a;
		next = null;
	}
}

class GFG {
	// utility function to insert node in the list
	static Node push(Node head, int val)
	{
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			return head;
		}

		Node temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = newNode;
		return head;
	}

	// utility function to reverse k nodes in the list
	static Node reverse(Node head, int k)
	{
		// If head is NULL or K is 1 then return head
		if (head == null || head.next == null)
			return head;

		// creating dummy node
		Node dummy = new Node(-1);
		dummy.next = head;

		// Initializing three points prev, curr, next
		Node prev = dummy;
		Node curr = dummy;
		Node next = dummy;

		// Calculating the length of linked list
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}

		// Iterating till next is not NULL
		while (next != null) {
			curr = prev.next; // Curr position after every
							// reverse group
			next = curr.next; // Next will always next to
							// curr
			int toLoop
				= count > k
					? k
					: count - 1; // toLoop will set to
								// count - 1 in case of
								// remaining element

			for (int i = 1; i < toLoop; i++) {
				// 4 steps as discussed above
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;
			}
			prev = curr; // Setting prev to curr
			count -= k; // Update count
		}
		return dummy.next; // dummy -> next will be our new
						// head for output linked
		// list
	}
	// utility function to print the list
	static void print(Node head)
	{
		while (head.next != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println(head.data);
	}

	public static void main(String args[])
	{
		Node head = null;
		int k = 3;
		head = push(head, 1);
		head = push(head, 2);
		head = push(head, 3);
		head = push(head, 4);
		head = push(head, 5);
		head = push(head, 6);
		head = push(head, 7);
		head = push(head, 8);
		head = push(head, 9);

		System.out.println("Given Linked List");
		print(head);
		System.out.println("Reversed list");
		Node newHead = reverse(head, k);
		print(newHead);
	}
}
 

Output

Given linked list 
1 2 3 4 5 6 7 8 9 
Reversed Linked list 
3 2 1 6 5 4 9 8 7 
Complexity Analysis 
Time Complexity: O(N) : While loop takes O(N/K) time and inner for loop takes O(K) time. So N/K * K = N. Therefore TC O(N)

Space Complexity: O(1) : No extra space is used. 
 * 
 * */
 


/* 
 * 
 *  Palindrome Linked List

Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.


Examples:

Input: R->A->D->A->R->NULL
Output: Yes

Input: C->O->D->E->NULL
Output: No

Check if a Singly Linked List is Palindrome using Stack:
The idea is to use a stack and push all the nodes into the stack, then again iterate over the linked list to validate if the linked list is palindrome or not.

Below image is a dry run of the above approach: 


Follow the steps below to solve the problem:

A simple solution is to use a stack of list nodes. This mainly involves three steps.
Traverse the given list from head to tail and push every visited node to stack.
Traverse the list again. For every visited node, pop a node from the stack and compare data of popped node with the currently visited node.
If all nodes matched, then return true, else false.
Below is the implementation of the above approach : 

/* Java program to check if linked list is palindrome
 * recursively 
import java.util.*;

class linkedList {
    public static void main(String args[])
    {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.ptr = two;
        two.ptr = three;
        three.ptr = four;
        four.ptr = five;
        five.ptr = six;
        six.ptr = seven;
        boolean condition = isPalindrome(one);
        System.out.println("isPalidrome :" + condition);
    }
    static boolean isPalindrome(Node head)
    {

        Node slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();

        while (slow != null) {
            stack.push(slow.data);
            slow = slow.ptr;
        }

        while (head != null) {

            int i = stack.pop();
            if (head.data == i) {
                ispalin = true;
            }
            else {
                ispalin = false;
                break;
            }
            head = head.ptr;
        }
        return ispalin;
    }
}

class Node {
    int data;
    Node ptr;
    Node(int d)
    {
        ptr = null;
        data = d;
    }
}
 

Output

isPalindrome is true
Time complexity: O(N), Iterating over the linked list of size N.
Auxiliary Space: O(N), Using an auxiliary stack

Check if a Singly Linked List is Palindrome by Reversing the Linked List:
The idea is to first reverse the second half part of the linked list and then check whether the list is palindrome or not.

Follow the steps below to solve the problem:

Get the middle of the linked list. 
Reverse the second half of the linked list. 
Check if the first half and second half are identical. 
Construct the original linked list by reversing the second half again and attaching it back to the first half
Below is the implementation of the above approach:

/* Java program to check if linked list is palindrome 

class LinkedList {
	Node head; // head of list
	Node slow_ptr, fast_ptr, second_half;

	/* Linked list Node
	class Node {
		char data;
		Node next;

		Node(char d)
		{
			data = d;
			next = null;
		}
	}

	/* Function to check if given linked list is
	palindrome or not 
	boolean isPalindrome(Node head)
	{
		slow_ptr = head;
		fast_ptr = head;
		Node prev_of_slow_ptr = head;
		Node midnode = null; // To handle odd size list
		boolean res = true; // initialize result

		if (head != null && head.next != null) {
			/* Get the middle of the list. Move slow_ptr by
			1 and fast_ptr by 2, slow_ptr will have the
			middle node 
			while (fast_ptr != null
				&& fast_ptr.next != null) {
				fast_ptr = fast_ptr.next.next;

				/*We need previous of the slow_ptr for
				linked lists with odd elements 
				prev_of_slow_ptr = slow_ptr;
				slow_ptr = slow_ptr.next;
			}

			/* fast_ptr would become NULL when there are
			even elements in the list and not NULL for
			odd elements. We need to skip the middle node
			for odd case and store it somewhere so that
			we can restore the original list 
			if (fast_ptr != null) {
				midnode = slow_ptr;
				slow_ptr = slow_ptr.next;
			}

			// Now reverse the second half and compare it
			// with first half
			second_half = slow_ptr;
			prev_of_slow_ptr.next
				= null; // NULL terminate first half
			reverse(); // Reverse the second half
			res = compareLists(head,
							second_half); // compare

			/* Construct the original list back 
			reverse(); // Reverse the second half again

			if (midnode != null) {
				// If there was a mid node (odd size case)
				// which was not part of either first half
				// or second half.
				prev_of_slow_ptr.next = midnode;
				midnode.next = second_half;
			}
			else
				prev_of_slow_ptr.next = second_half;
		}
		return res;
	}

	/* Function to reverse the linked list Note that this
	function may change the head 
	void reverse()
	{
		Node prev = null;
		Node current = second_half;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		second_half = prev;
	}

	/* Function to check if two input lists have same data
	boolean compareLists(Node head1, Node head2)
	{
		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			else
				return false;
		}

		/* Both are empty return 1
		if (temp1 == null && temp2 == null)
			return true;

		/* Will reach here when one is NULL
		and other is not 
		return false;
	}

	/* Push a node to linked list. Note that this function
	changes the head 
	public void push(char new_data)
	{
		/* Allocate the Node &
		Put in the data 
		Node new_node = new Node(new_data);

		/* link the old list of the new one 
		new_node.next = head;

		/* Move the head to point to new Node 
		head = new_node;
	}

	// A utility function to print a given linked list
	void printList(Node ptr)
	{
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.println("NULL");
	}

	/* Driver program to test the above functions 
	public static void main(String[] args)
	{

		/* Start with the empty list 
		LinkedList llist = new LinkedList();

		char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
		String string = new String(str);
		for (int i = 0; i < 7; i++) {
			llist.push(str[i]);
		}
		if (llist.isPalindrome(llist.head) != false) {
			System.out.println("Is Palindrome");
			System.out.println("");
		}
		else {
			System.out.println("Not Palindrome");
			System.out.println("");
		}
	}
}
 

Output

Is Palindrome
Time Complexity: O(N),  
Auxiliary Space: O(1)

*/

/**

Pairwise Swap Nodes of linked list

Given a singly linked list, write a function to swap elements pairwise. 

Input : 1->2->3->4->5->6->NULL 
Output : 2->1->4->3->6->5->NULL

Input : 1->2->3->4->5->NULL 
Output : 2->1->4->3->5->NULL

Input : 1->NULL 
Output : 1->NULL 

For example, if the linked list is 1->2->3->4->5 then the function should change it to 2->1->4->3->5.

Method 1 :  Swapping Data
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class Test {

    public static void main(String args[])
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        printlist(head);
        pairwiseSwap(head);
        printlist(head);
    }

    static void pairwiseSwap(Node head)
    {
        Node curr = head;
        while (curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
    }

    public static void printlist(Node head)
    {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
 

Output:
1 2 3 4 5 
2 1 4 3 5 
Time Complexity - O(n)

 

Method 2: Changing Pointers/References
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class Test {

    public static void main(String args[])
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        printlist(head);
        head = pairwiseSwap(head);
        printlist(head);
    }

    static Node pairwiseSwap(Node head)
    {
        if (head == null || head.next == null)
            return head;
        Node curr = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;
        return head;
    }

    public static void printlist(Node head)
    {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
 

Output:
1 2 3 4 5 
2 1 4 3 5 
Time Complexity - O(n)

*/


/*

Intersection of two linked list

There are two singly linked lists in a system. By some programming error, the end node of one of the linked lists got linked to the second list, forming an inverted Y-shaped list. Write a program to get the point where two linked lists merge. 

Y ShapedLinked List
The above diagram shows an example with two linked lists having 15 as intersection points.

Method : Using the difference in node counts

Get the count of the nodes in the first list, let the count be c1.
Get the count of the nodes in the second list, let the count be c2.
Get the difference of counts d = abs(c1 – c2)
Now traverse the bigger list from the first node to d nodes so that from here onwards both the lists have an equal no of nodes
Then we can traverse both lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)
Below image is a dry run of the above approach:


Below is the implementation of the above approach :

// Java program to get intersection point of two linked list

class LinkedList {

	static Node head1, head2;

	static class Node {

		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	/*function to get the intersection point of two linked
	lists head1 and head2 
	int getNode()
	{
		int c1 = getCount(head1);
		int c2 = getCount(head2);
		int d;

		if (c1 > c2) {
			d = c1 - c2;
			return _getIntesectionNode(d, head1, head2);
		}
		else {
			d = c2 - c1;
			return _getIntesectionNode(d, head2, head1);
		}
	}

	/* function to get the intersection point of two linked
	lists head1 and head2 where head1 has d more nodes than
	head2 
	int _getIntesectionNode(int d, Node node1, Node node2)
	{
		int i;
		Node current1 = node1;
		Node current2 = node2;
		for (i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next;
		}
		while (current1 != null && current2 != null) {
			if (current1.data == current2.data) {
				return current1.data;
			}
			current1 = current1.next;
			current2 = current2.next;
		}

		return -1;
	}

	/*Takes head pointer of the linked list and
	returns the count of nodes in the list 
	int getCount(Node node)
	{
		Node current = node;
		int count = 0;

		while (current != null) {
			count++;
			current = current.next;
		}

		return count;
	}

	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();

		// creating first linked list
		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(30);

		// creating second linked list
		list.head2 = new Node(10);
		list.head2.next = new Node(15);
		list.head2.next.next = new Node(30);

		System.out.println("The node of intersection is " + list.getNode());
	}
}


 

Output

The node of intersection is 15
Method : Use Hashing
Basically, we need to find a common node of two linked lists. So we hash all nodes of the first list and then check the second list. 
1) Create an empty hash set. 
2) Traverse the first linked list and insert all nodes’ addresses in the hash set. 
3) Traverse the second list. For every node check if it is present in the hash set. If we find a node in the hash set, return the node.

// Java program to get intersection point of two linked list
import java.util.*;
class Node {
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
class LinkedListIntersect {
	public static void main(String[] args)
	{
		// list 1
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
		n1.next.next.next.next = new Node(5);
		n1.next.next.next.next.next = new Node(6);
		n1.next.next.next.next.next.next = new Node(7);
		// list 2
		Node n2 = new Node(10);
		n2.next = new Node(9);
		n2.next.next = new Node(8);
		n2.next.next.next = n1.next.next.next;
		Print(n1);
		Print(n2);
		System.out.println(MegeNode(n1, n2).data);
	}

	// function to print the list
	public static void Print(Node n)
	{
		Node cur = n;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	// function to find the intersection of two node
	public static Node MegeNode(Node n1, Node n2)
	{
		// define hashset
		HashSet<Node> hs = new HashSet<Node>();
		while (n1 != null) {
			hs.add(n1);
			n1 = n1.next;
		}
		while (n2 != null) {
			if (hs.contains(n2)) {
				return n2;
			}
			n2 = n2.next;
		}
		return null;
	}
}
 

Output

1 2 3 4 5 6 7 
10 9 8 4 5 6 7 
4
This method required O(n) additional space and is not very efficient if one list is large.

*/


/**

Reverse a linked list iterative

Given a pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing the links between nodes.

Examples: 

Input: Head of following linked list 
1->2->3->4->NULL 
Output: Linked list should be changed to, 
4->3->2->1->NULL

Input: Head of following linked list 
1->2->3->4->5->NULL 
Output: Linked list should be changed to, 
5->4->3->2->1->NULL

Naive Approach:
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class Test {

    public static void main(String args[])
    {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        printlist(head);
        head = revList(head);
        printlist(head);
    }

    static Node revList(Node head)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (Node curr = head; curr != null;
             curr = curr.next) {
            arr.add(curr.data);
        }
        for (Node curr = head; curr != null;
             curr = curr.next) {
            curr.data = arr.remove(arr.size() - 1);
        }
        return head;
    }

    public static void printlist(Node head)
    {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
 

Output:
10 20 30 
30 20 10 
Reverse a linked list by Iterative Method:
The idea is to use three pointers curr, prev, and next to keep track of nodes to update reverse links.

Illustration:



 

Follow the steps below to solve the problem:

Initialize three pointers prev as NULL, curr as head, and next as NULL.
Iterate through the linked list. In a loop, do the following:
Before changing the next of curr, store the next node 
next = curr -> next
Now update the next pointer of curr to the prev 
curr -> next = prev 
Update prev as curr and curr as next 
prev = curr 
curr = next
Below is the implementation of the above approach:

// Java program for reversing the linked list

class LinkedList {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	/* Function to reverse the linked list 
	Node reverse(Node node)
	{
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	// prints content of double linked list
	void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);

		System.out.println("Given linked list");
		list.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
	}
}


 

Output

Given linked list
85 15 4 20 
Reversed linked list 
20 4 15 85
Time Complexity: O(N), Traversing over the linked list of size N. 
Auxiliary Space: O(1)

Remove duplicates from a sorted Singly Linked List

Write a function that takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list. The list should only be traversed once. 
For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list to 11->21->43->60. 

Algorithm: Traverse the list from the head (or start) node. While traversing, compare each node with its next node. If the data of the next node is the same as the current node then delete the next node. Before we delete a node, we need to store the next pointer of the node 

Implementation: Functions other than removeDuplicates() are just to create a linked list and test removeDuplicates(). 

// Java program to remove duplicates from a sorted linked list
class LinkedList
{
	Node head; // head of list

	/* Linked list Node
	class Node
	{
		int data;
		Node next;
		Node(int d) {data = d; next = null; }
	}

	void removeDuplicates()
	{
		/*Another reference to head
		Node curr = head;

		/* Traverse list till the last node 
		while (curr != null) {
			Node temp = curr;
			/*Compare current node with the next node and
			keep on deleting them until it matches the current
			node data 
			while(temp!=null && temp.data.equals(curr.data)) {
				temp = temp.next;
			}
			/*Set current node next to the next different
			element denoted by temp
			curr.next = temp;
			curr = curr.next;
		}
	}
					
	/* Utility functions 

	/* Inserts a new Node at front of the list. 
	public void push(int new_data)
	{
		/* 1 & 2: Allocate the Node &
				Put in the data
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head 
		new_node.next = head;

		/* 4. Move the head to point to new Node 
		head = new_node;
	}

	/* Function to print linked list 
	void printList()
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions 
	public static void main(String args[])
	{
		LinkedList llist = new LinkedList();
		llist.push(20);
		llist.push(13);
		llist.push(13);
		llist.push(11);
		llist.push(11);
		llist.push(11);
		
		System.out.println("List before removal of duplicates");
		llist.printList();
		
		llist.removeDuplicates();
		
		System.out.println("List after removal of elements");
		llist.printList();
	}
}

 

Output

Linked list before duplicate removal  11 11 11 13 13 20
Linked list after duplicate removal  11 13 20
Time Complexity: O(n) where n is the number of nodes in the given linked list.

Space Complexity: O(1) , as there is no extra space used

*/

/*

Segregate Even and Odd Nodes

Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers the same.

Examples: 

Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL

Input: 8->12->10->5->4->1->6->NULL
Output: 8->12->10->4->6->5->1->NULL

// If all numbers are even then do not change the list
Input: 8->12->10->NULL
Output: 8->12->10->NULL

// If all numbers are odd then do not change the list
Input: 1->3->5->7->NULL
Output: 1->3->5->7->NULL
The idea is to split the linked list into two:  one containing all even nodes and the other containing all odd nodes. And finally, attach the odd node linked list after the even node linked list. 
To split the Linked List, traverse the original Linked List and move all odd nodes to a separate Linked List of all odd nodes. At the end of loop, the original list will have all the even nodes and the odd node list will have all the odd nodes. To keep the ordering of all nodes same, we must insert all the odd nodes at the end of the even node list. And to do that in constant time, we must keep track of last pointer in the even node list.

Below is the implementation of the above approach:

// Java program to segregate even and odd nodes in a
// Linked List
import java.io.*;

class LinkedList {
	
	Node head; // head of list

	/* Linked list Node
	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	public void segregateEvenOdd() {
		
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;
		Node currentNode = head;
		
		while(currentNode != null) {
			int element = currentNode.data;
			
			if(element % 2 == 0) {
				
				if(evenStart == null) {
					evenStart = currentNode;
					evenEnd = evenStart;
				} else {
					evenEnd.next = currentNode;
					evenEnd = evenEnd.next;
				}
				
			} else {
				
				if(oddStart == null) {
					oddStart = currentNode;
					oddEnd = oddStart;
				} else {
					oddEnd.next = currentNode;
					oddEnd = oddEnd.next;
				}
			}
						// Move head pointer one step in forward direction
			currentNode = currentNode.next;
		}
		
		
		if(oddStart == null || evenStart == null) {
			return;
		}
		
		evenEnd.next = oddStart;
		oddEnd.next = null;
		head=evenStart;
	}
	
	/* Given a reference (pointer to pointer) to the head
		of a list and an int, push a new node on the front
		of the list. 
	void push(int new_data)
	{
		/* 1 & 2: Allocate the Node &
				Put in the data
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head 
		new_node.next = head;

		/* 4. Move the head to point to new Node 
		head = new_node;
	}

	// Utility function to print a linked list
	void printList()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	/* Driver program to test above functions 
	public static void main(String args[])
	{
		LinkedList llist = new LinkedList();
		llist.push(11);
		llist.push(10);
		llist.push(9);
		llist.push(6);
		llist.push(4);
		llist.push(1);
		llist.push(0);
		System.out.println("Original Linked List");
		llist.printList();

		llist.segregateEvenOdd();

		System.out.println("Modified Linked List");
		llist.printList();
	}
}
 

Output

Original Linked list
0 1 4 6 9 10 11 
Modified Linked list 
0 4 6 10 1 9 11 
Time Complexity: O(n), As we are only traversing linearly through the list.
Auxiliary Space: O(1)




*/