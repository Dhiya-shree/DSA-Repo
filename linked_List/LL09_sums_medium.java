package linked_List;
/**
 * Problem #1: Pairwise swap of nodes in LL
 * Given a linked list of N positive integers. 
 * You need to swap elements pairwise. Your task is to complete the function pairwise_swap().
 * 
 * Naive:
 * while head not null and head.next not null:
 *    Swap data 
 *    head= head.next.next 
 *    
 * Efficient if nodes have large data :
 *   Swap nodes 
 * 
 * Problem #2 : Merge two sorted LL
 * 
 * Given two sorted linked lists consisting of N and M nodes respectively. 
 * The task is to merge both of the list (in-place) and return head of the merged list.
 * 
 * Problem # 3 : Merge K sorted LL 
 * Given K sorted linked lists of different sizes. 
 * The task is to merge them in such a way that after merging they will be a single sorted linked list.
 * 
 * Problem #4 : Merge Sort LL 
 * Given a LL merge sort it 
 * 
 * Problem #5 : Check if Linked List is Palindrome
 * 
 * Given a singly linked list of size N of integers.
 *  The task is to check if the given linked list is palindrome or not.
 * 
 * @author shree
 *
 */
public class LL09_sums_medium {

	public static void main(String[] args) {
		//medium 
		Node head = new Node(100);
		head.next = new Node(200);
		head.next.next = new Node(300);
		head.next.next.next = new Node(400);
		head.next.next.next.next = new Node(500);
		head.next.next.next.next.next = new Node(600);
		head.next.next.next.next.next.next = new Node(700);
		// head.next.next.next.next.next.next.next= new Node(800);
		
		Node head1 = new Node(10);
		head1.next = new Node(200);
		head1.next.next = new Node(308);
		head1.next.next.next = new Node(400);
		head1.next.next.next.next = new Node(550);
		head1.next.next.next.next.next = new Node(600);
		head1.next.next.next.next.next.next = new Node(770);
	 //head1.next.next.next.next.next.next.next= new Node(80);
		
		Node head2 = new Node(10);
		head2.next = new Node(20);
		head2.next.next = new Node(30);
		head2.next.next.next = new Node(30);
		head2.next.next.next.next = new Node(20);
		head2.next.next.next.next.next = new Node(10);
	   head2.next.next.next.next.next.next = new Node(10);
		
		boolean anb=isPalindromeLL(head2);
		System.out.println(" HEAD Ll ");
		LL02_Linked_List_Func.PrintLinkedList(head2);
		System.out.println(" IS a palindrom is "+anb);
		
		head=pairwise_swap(head);
		System.out.println(" After swap ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=pairwise_swapNode(head);
		System.out.println(" After swap ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		Node ans=MergeSortedLL(head,head1);
		System.out.println(" After merge ....");
		LL02_Linked_List_Func.PrintLinkedList(ans);
		
		Node arr[]= {head,head1,head2};
		ans=mergeKList(arr,arr.length);
		System.out.println(" After merge K sorted linked list  ....");
		LL02_Linked_List_Func.PrintLinkedList(ans);
		
		
		System.out.println("Before sorting   ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		head=MergeSortLL(head);
		System.out.println(" After merge sort linked list  ....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		
		
	}
	
	 private static Node pairwise_swapNode(Node head) {
		//base case 
		 if(head==null || head.next==null) {
			 return head;
		 }
		 
		 Node curr=head.next.next;
	        Node prev=head;
	        head=head.next;
	        head.next=prev;
	        while(curr!=null&&curr.next!=null){
	            prev.next=curr.next;
	            prev=curr;
	            Node next=curr.next.next;
	            curr.next.next=curr;
	            curr=next;
	        }
	        prev.next=curr;
	        return head;
		
	}

	private static Node MergeSortLL(Node head) {
		// Base cases
		 if(head==null || head.next==null) {
			 return head;
		 }
		 if(head.next.next==null) {
			 //For 2 elements 
			 if(head.data>head.next.data) {
				 int val=head.data;
				 head.data=head.next.data;
				 head.next.data=val;
				 return head;
			 }
			 return head;
		 }
		 
		 // For 3 elements 
		 head=MergeSortLLRecursion(head);
		return head;
	}

	private static Node MergeSortLLRecursion(Node head) {
		//Recusrion call 
		
		//Base case
		 if (head == null || head.next == null) {
	            return head;
	        }
		 
	//	System.out.println(" head .....");
		//LL02_Linked_List_Func.PrintLinkedList(head);
		// Set element before middle nex  as null
		Node middle=GetTheMiddle_andSetPrevNull(head);
		
		 
		System.out.println(" head .....");
		LL02_Linked_List_Func.PrintLinkedList(head);
		 
		System.out.println(" middle .....");
		LL02_Linked_List_Func.PrintLinkedList(middle);
		Node left=MergeSortLLRecursion(head);
		// Split till head...middle 
		
		Node right=MergeSortLLRecursion(middle);
		// From nex to middle to end 

		System.out.println(" Left .....");
		LL02_Linked_List_Func.PrintLinkedList(left);
		System.out.println(" Right ....");
		LL02_Linked_List_Func.PrintLinkedList(right);
		
		
		Node sorted=Merge_Sorted_Left_Right(left,right);
		
		System.out.println(" Sorted ....");
		LL02_Linked_List_Func.PrintLinkedList(sorted);
		
		return sorted;
	}

	private static Node Merge_Sorted_Left_Right(Node left, Node right) {
		
		// Code for merging two sorted array 
		//Using recusrion
      // Less data 
		 if(left==null){
	         return right;
	     }
	     if(right==null){
	         return left;
	     }
	     
	   //Using recusion 
	    if(left.data<=right.data){
	             
	             left.next=Merge_Sorted_Left_Right(left.next, right);
	             return left;
	         }
	         else{
	             right.next=Merge_Sorted_Left_Right(left, right.next);
	             return right;
	         }
	}

	private static Node GetTheMiddle_andSetPrevNull(Node head) {
		// find  middle set the prev as null
	    // return next
		
		if(head==null) {
			return head;
		}
		if(head.next==null) {
			return head;
		}
		Node val=head.next;
		if(head.next.next==null) {
			head.next=null;
			return val;
		}
		Node middle=head;
		Node prev=head;
		// For 1 2 3 4 
		//     1 2 
		//       2   4
		//   middle = 2 
		// head==null even 
		// head.next == null for odd 
		
		while(head!=null && head.next!=null) {
			middle=middle.next;
			head=head.next.next;
		}
		
		prev=middle.next;
		middle.next=null;
		return prev;
	}

	private static Node mergeKList(Node[]arr,int K)
	    {
	        //Add your code here.
	        if(K==1){
	            return arr[0];
	        }
	        
	        Node ans=arr[0];
	        for(int i=1;i<K;i++){
	            ans=MergeSortedLL(ans,arr[i]);
	        }
	        return ans;
	    }
	 
	private static Node MergeSortedLL(Node head1, Node head2) {
		// This is a "method-only" submission. 
	     // You only need to complete this method
	     
	     if(head1==null){
	         return head2;
	     }
	     if(head2==null){
	         return head1;
	     }
	     
	     int val=head1.data;
	     if(head1.data>head2.data){
	         val=head2.data;
	         head2=head2.next;
	     }
	     else{
	         head1=head1.next;
	     }
	     
	     Node ans=new Node(val);
	     Node start=ans;
	     while(head1!=null && head2!=null){
	         
	         if(head1.data<=head2.data){
	             ans.next=new Node(head1.data);
	             ans=ans.next;
	             head1=head1.next;
	         }
	         else{
	              ans.next=new Node(head2.data);
	               ans=ans.next;
	             head2=head2.next;
	         }
	     }
	     
	     while(head1!=null){
	        ans.next=new Node(head1.data);
	         ans=ans.next;
	             head1=head1.next;
	     }
	     while(head2!=null){
	           ans.next=new Node(head2.data);
	            ans=ans.next;
	             head2=head2.next;
	     }
	     return start;
	}

	private static Node pairwise_swap(Node node)
    {
        // your code 
        Node head=node;int dat=0;
        while(head!=null && head.next!=null){
            dat=head.data;
            head.data=head.next.data;
            head.next.data=dat;
            head=head.next.next;
        }
        return node;
    }

	private static boolean isPalindromeLL(Node head) 
	    {
	        //Your code here
	        if(head==null) {
				return true;
			}
			if(head.next==null) {
				return true;
			}
			if(head.next.next==null) {
			if(head.data==head.next.data){
			    return true;
			}
			return false;
			}
			
			if(head.next.next.next==null){
			    if(head.data==head.next.next.data){
			    return true;
			}
			return false;
			}
			
			Node middle=head;
			Node temp=head;
			// For 1 2 3 4 
			//     1 2
			//       2   4
			//   middle = 2 
			// head==null even 
			// head.next == null for odd 
			Node before=head;
			while(head!=null && head.next!=null) {
				before=middle;
				middle=middle.next;
				head=head.next.next;
			}
		
			// 1 2 3 4 5 
			//   2   4 
			Node mid=middle;
			if(head!=null) {	
				middle=middle.next;
			}
			
			Node start=middle;
			before.next=null;
			
			System.out.println("Before sorting   ....");
			LL02_Linked_List_Func.PrintLinkedList(start);
			
			//Reverse ll 
			
			Node prev=null;
			Node next=null;
			while(start!=null) {
				next=start.next;
				start.next=prev;
				prev=start;
				start=next;
			}
			start=prev;
			System.out.println("after reverse   ....");
			LL02_Linked_List_Func.PrintLinkedList(start);
			
			// Check the head and start 
			while(start!=null && temp!=null) {
				System.out.println(temp.data+" "+start.data);
				if(temp.data!=start.data) {
					return false;
				}
				start=start.next;
				temp=temp.next;
			}
			
		//	System.out.println("Head is null "+(temp.next.next==null));
			
			if(temp==null || temp.next==mid) {
				return true;
			}
			
			return false;
			
	    }    
}

/**
 * 
 * Merge two sorted linked lists

Given two sorted linked lists consisting of N and M nodes respectively. The task is to merge both of the lists (in place) and return the head of the merged list.

Examples:

Input: a: 5->10->15, b: 2->3->20
Output: 2->3->5->10->15->20

Input: a: 1->1, b: 2->4
Output: 1->1->2->4

Merge two sorted linked lists using Dummy Nodes:
The idea is to use a temporary dummy node as the start of the result list. The pointer Tail always points to the last node in the result list, so appending new nodes is easy.

Follow the below illustration for a better understanding:

Illustration:

Merge-Two-Sorted-LinkedLists1

Follow the steps below to solve the problem:

First, make a dummy node for the new merged linked list
Now make two pointers, one will point to list1 and another will point to list2.
Now traverse the lists till one of them gets exhausted.
If the value of the node pointing to either list is smaller than another pointer, add that node to our merged list and increment that pointer.
Below is the implementation of the above approach: 

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
        Node a = new Node(10);
        a.next = new Node(20);
        a.next.next = new Node(30);
        Node b = new Node(5);
        b.next = new Node(35);
        printlist(sortedMerge(a, b));
    }

    static Node sortedMerge(Node a, Node b)
    {
        if (a == null)
            return b;
        if (b == null)
            return a;
        Node head = null, tail = null;
        if (a.data <= b.data) {
            head = tail = a;
            a = a.next;
        }
        else {
            head = tail = b;
            b = b.next;
        }
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                tail = a;
                a = a.next;
            }
            else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        if (a == null) {
            tail.next = b;
        }
        else {
            tail.next = a;
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
5 10 20 30 35
Time Complexity: O(N + M), where N and M are the size of list1 and list2 respectively
Auxiliary Space: O(1)

 
 * 
 * 
 */
