package linked_List;

import java.util.HashSet;

/**
 * Problem #1: Insert in middle of LL
 * Given a linked list of size N and a key. The task is to insert the key in the middle of the linked list.
 * 
 * 
 *  ///////////////////////////////////////////////////////////////////////IMPORTANT
 * 
 * Problem #2: Merge Sort on Doubly Linked List
 * Given Pointer/Reference to the head of a doubly linked list of N nodes,
 * the task is to Sort the given doubly linked list using Merge Sort in both non-decreasing and non-increasing order.
 * 
 *   ///////////////////////////////////////////////////////////////////////IMPORTANT 
 * 
 *
 * Problem #3: Nth node from end of LL
 * Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.
 * 
 * Problem #4 : Given LL of 1,0,2 ..sort it
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s 
 * linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.
 * 
 * Problem #5: Remove duplicates from unsorted LL
 * Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. 
 * When a value appears in multiple nodes, the node which appeared first should be kept, 
 * all others duplicates are to be removed.
 * 
 * 
 * @author shree
 *
 */
public class LL07_LL_Sums_easy {

	public static void main(String[] args) {
		//Start
		Node head = new Node(100);
		head.next = new Node(200);
		head.next.next = new Node(300);
		head.next.next.next = new Node(400);
		head.next.next.next.next = new Node(500);
     	head.next.next.next.next.next = new Node(600);
		head.next.next.next.next.next.next= new Node(700);
	//	head.next.next.next.next.next.next.next= new Node(800);

		head=InsertInMiddle(head,400);
		System.out.println(" Inserted value ");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=removeDuplicatesGoG(head);
		System.out.println(" Removed duplicates  ");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=InsertInMiddle(head,400);
		head=removeDuplicates(head);
		System.out.println(" Removed duplicates  ");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		
		
		int val=getNthFromLast(head,2);
		System.out.println(" Ans is "+val);
		
		System.out.println(" Sort for 0,1,2....");
		head=segregate(head);
		
		
		//========================================================================================================
		
		// Simple creation of doubly linked list  
				DNode head2=new DNode(100);
				//2nd node 
				head2.next=new DNode(30);
				head2.next.prev=head2;
				//3rd node 
				head2.next.next=new DNode(50);
				head2.next.next.prev=head2.next;
				
				//4th node 
				head2.next.next.next=new DNode(40);
				head2.next.next.next.prev=head2.next.next;
				
				//5th node 
				head2.next.next.next.next=new DNode(90);
				head2.next.next.next.next.prev=head2.next.next.next;
				DNode temp=head2;
				System.out.println(" Unsorted ");
				LL03_Doubly_Linked_List.PrintDoubleLinkedList(head2);
				head2=SortDoubly(temp);
				System.out.println(" Sorted ");
				LL03_Doubly_Linked_List.PrintDoubleLinkedList(head2);

	}

	private static Node removeDuplicatesGoG(Node head)
	{
		Node temp = head;
		while (head != null && head.next!=null) {

			if (head.data == head.next.data) {
				head.next=head.next.next;
			}
			else {
				head=head.next;
			}
			
		}
		
		return temp;
	}
	private static DNode SortDoubly(DNode head) {
		// Sort merge 
		
		// For val ll size 1/2
		if(head==null || head.next==null) {
			return head;
		}
		if(head.next.next==null) {
			if(head.data<head.next.data) {
				return head;
			}
			else {
				int dat=head.data;
				head.data=head.next.data;
				head.next.data=dat;
				return head;
			}
	}
		
		head=MergeDoublyList(head);
		
		return head;
	}

	private static DNode MergeDoublyList(DNode head) {
		// recursive calls 
		 // Base case : if head is null
		DNode temp=head;
        if (head == null || head.next == null) {
            return head;
        }
        System.out.print(" For head....... ");
		LL03_Doubly_Linked_List.PrintDoubleLinkedList(head);
		DNode mid=GetTheMiddDoubly(head);

	//	DNode midNex=mid.next;
		
		//Set middle s null to send in first half as dll 
		//mid.next=null;
		//midNex.prev=null;
		
		DNode left=MergeDoublyList(temp);
		
		// set mid next prev as null to send as second half 
		
		DNode right=MergeDoublyList(mid);
		
		// Add the sorted mixture 
		DNode sorted = MergeDoublyAlgo(left,right);
		System.out.print(" For left....... ");
		LL03_Doubly_Linked_List.PrintDoubleLinkedList(left);
		System.out.print(" and right........ ");
		LL03_Doubly_Linked_List.PrintDoubleLinkedList(right);
		System.out.print(" -->  sorted ......  ");
		LL03_Doubly_Linked_List.PrintDoubleLinkedList(sorted);
		return sorted;
		
		// SAM BUT FOR Node 
//		 int mid=0;
//		while(high<low) {
//			mid=(high-low)/2;
//			//first half 
//			MergeDoublyList(low,mid,head,len);
//			
//			//Second half 
//			MergeDoublyList(mid+1,high,head,len);
//			
//			// Final algo to check and merge 
//			MergeDoublyAlgo(head,len,low,mid,high);
//
//		}
		
	}

	private static DNode MergeDoublyAlgo(DNode left, DNode right) {
		// Merge given sorted array 
	//	DNode result=null;
		
		if(left==null) {
			return right;
		}
		
		if(right==null) {
			return left;
		}
		
		// If sorted list has more values 
		// a- 5--7--9--12--15
		// b- 6--7--10--16--30
		System.out.print(" For left ");
		LL03_Doubly_Linked_List.PrintDoubleLinkedList(left);
		System.out.print(" and right ");
		LL03_Doubly_Linked_List.PrintDoubleLinkedList(right);
		
		if(left.data<=right.data) {
		left.next=MergeDoublyAlgo(left.next, right);
		left.next.prev=left;
		left.prev=null;
		System.out.print(" --> ans  ");
		LL03_Doubly_Linked_List.PrintDoubleLinkedList(left);
		return left;
		}
		else {
			right.next=MergeDoublyAlgo(left, right.next);
			right.next.prev=right;
			right.prev=null;
			System.out.print(" --> ans  ");
			LL03_Doubly_Linked_List.PrintDoubleLinkedList(right);
			return right;
		}
		
		
		
		
		//return result;
	}

	private static DNode GetTheMiddDoubly(DNode head) {
		//Return middle node 
		// Hare turtle like 
		// data of middle 
		if (head == null) {
			return head;
		}
		if (head.next == null) {
			return head;
		}

		if (head.next.next == null) {
		    DNode te=head.next;
		    head.next=null;
			return te;
		}
			// Have two pointers
				// Slow moving 1 node at a time
				// Fast moving two nodes at a time
				DNode slow = head;
				DNode fast = head;
				
				while (fast != null && fast.next != null) {
					slow = slow.next;
					fast = fast.next.next;
					// head=head.next;
				}
			DNode temp	=slow.next;
			System.out.println(" Temp middle ..."+temp.data);
			slow.next=null;
		return temp;
	}


	private static Node InsertInMiddle(Node head, int val) {
		//Insert in middle 
		Node insert=new Node(val);
		// data of middle 
		if (head == null) {
			return insert;
		}
		if (head.next == null) {
			head.next=insert;
			return head;
		}

		if (head.next.next == null) {
			insert.next=head.next;
			head.next=insert;
			return head;
		}

		Node temp=head;
		// Have two pointers
		// Slow moving 1 node at a time
		// Fast moving two nodes at a time
		Node slow = head;
		Node fast = head;
		Node nextu=null;
		Node prev=null;
		while (fast != null && fast.next != null) {
			prev=slow;
			slow = slow.next;
			fast = fast.next.next;
			// head=head.next;
		}
	//	System.out.println(" Count is "+count+" Slowdata "+slow.data);
		// 4 count 3 
		if(fast!=null){
		 //	Odd has fast as null
		nextu=slow.next;
		slow.next=insert;
		insert.next=nextu;
        
        }
		else{
		    //Even has fast next as null
		  prev.next=insert;
		insert.next=slow;  
		}
		return temp;
        
    }
	
	private static int getNthFromLast(Node head, int n)
	    {
	    	// Your code here
	    	if(head==null){
	    	    return -1;
	    	}
	    	boolean flg=false;
	    	int count=1;Node an=null;int ans=-1;
	    	Node temp=head;
	    	while(head!=null){
	    	  //  System.out.println(" count"+count+" data "+head.data);
	    	    if(count==n){
	    	        flg=true;
	    	    }
	    	    if(flg){
	    	        if(an==null){
	    	        an=temp;
	    	            ans=temp.data;
	    	        }
	    	        else{
	    	            an=an.next;
	    	            ans=an.data;
	    	        }
	    	    }
	    	    head=head.next;
	    	    count++;
	    	}
	    	return ans;
	    }
	
	private static Node segregate(Node head)
    {
        // add your code here
        int zero=0;
        int one=0;
        int two=0;
        Node temp=head;
        while(head!=null){
            if(head.data==0){
                zero++;
            }
            else if(head.data==1){
                one++;
            }
            else{
                two++;
            }
            
            head=head.next;
        }
        head=temp;
        while(zero>0){
            temp.data=0;
            temp=temp.next;
            zero--;
        }
        while(one>0){
            temp.data=1;
            temp=temp.next;
            one--;
        }
        while(two>0){
            temp.data=2;
            temp=temp.next;
            two--;
        }
        
        return head;
    }

	private static Node removeDuplicates(Node head) 
    {
         // Your code here
         HashSet<Integer> hs=new HashSet<>();
         Node temp=head;
         int val=0;Node prev=head;
         while(head!=null){
             val=head.data;
             if(hs.contains(val)){
                 prev.next=head.next;
               //  prev=prev;
             }
             else{
                 hs.add(val);
                  prev=head;
             }
           //  prev=head;
           // Above prev wrong for input 2 2 2 2 2 
             //Expected ans : 2 , with above ans : 2 2 2 
             head=head.next;
         }
         return temp;
    }

}

/**
 * Nth Node from end of Linked List

Given a Linked List and a number N, write a function that returns the value at the Nth node from the end of the Linked List.

Lightbox
                                                                                   Linked-List

Examples:

Input: 1 -> 2 -> 3 -> 4, N = 3
Output: 2

Input: 35 -> 15 -> 4 -> 20, N = 4
Output: 35   

Naive Approach: Follow the given steps to solve the problem using this approach: 

Calculate the length of the Linked List. Let the length be len. 
Print the (len – n + 1)th node from the beginning of the Linked List. 
Below is the implementation of the above approach:

// Java program to find N'th node from
// end of linked list
class LinkedList {
	Node head; // head of the list

	/* Linked List node 
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	/* Function to get the Nth node from the last of a
	linked list 
	void printNthFromLast(int N)
	{
		int len = 0;
		Node temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		// check if value of N is not more than length of
		// the linked list
		if (len < N)
			return;

		temp = head;

		// 2) get the (len-N+1)th node from the beginning
		for (int i = 1; i < len - N + 1; i++)
			temp = temp.next;

		System.out.println(temp.data);
	}

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

	// Driver's code
	public static void main(String[] args)
	{
		LinkedList llist = new LinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);
		
		// Function call
		llist.printNthFromLast(4);
	}
}
 

Output

35
Time complexity: O(M) where M is the size of the linked list
Auxiliary Space: O(1)

Nth node from the end of a Linked List using two pointers:
As Nth node from the end equals to (Length – N + 1)th node from the start, so the idea is to Maintain two pointers starting from the head of the Linked-List and move one pointer to the Nth node from the start and then move both the pointers together until the pointer at the Nth position reaches the last node. Now the pointer which was moved later points at the Nth node from the end of the Linked-List

Below image is a dry run of the above approach:

Lightbox
Follow the given steps to solve the problem:

Maintain two pointers main_ptr and ref_ptr
Move ref_ptr to the Nth node from the start
Now move both main_ptr and ref_ptr, until the ref_ptr reaches the last node
Now print the data of the main_ptr, as it is at the Nth node from the end
Below is the implementation of the above approach: 

// Java program to find N'th
// node from end
class LinkedList {
	Node head; // head of the list

	/* Linked List node 
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	/* Function to get the
	Nth node from end of list 
	void printNthFromLast(int N)
	{
		Node main_ptr = head;
		Node ref_ptr = head;

		int count = 0;
		if (head != null) {
			while (count < N) {
				if (ref_ptr == null) {
					System.out.println(
						N + " is greater than the no "
						+ " of nodes in the list");
					return;
				}
				ref_ptr = ref_ptr.next;
				count++;
			}

			if (ref_ptr == null) {

				if (head != null)
					System.out.println("Node no. " + N
									+ " from last is "
									+ head.data);
			}
			else {

				while (ref_ptr != null) {
					main_ptr = main_ptr.next;
					ref_ptr = ref_ptr.next;
				}
				System.out.println("Node no. " + N
								+ " from last is "
								+ main_ptr.data);
			}
		}
	}

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

	// Driver's code
	public static void main(String[] args)
	{
		LinkedList llist = new LinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);

		// Function call
		llist.printNthFromLast(4);
	}
}

 

Output

35->15->4->20->NULL
Node no. 4 from end is: 35
Time Complexity: O(M) where M is the length of the linked list.
Auxiliary Space: O(1)
 * 
 * 
 * 
 */
