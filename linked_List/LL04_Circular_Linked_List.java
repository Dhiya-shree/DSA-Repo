package linked_List;

/**
 * CIRCULAR LINKED LIST 
 * 
 * Tail is not null , but pointing back to head node 
 * Same as Linked List normal 
 * 
 * Advantages :
 * 1) Traverse whole list from any node 
 * 2) Implementation of algorithm like round robin 
 *     Till list is empty , circularly traverse and reduce process by 5 
 *     If process <=0 remove the node 
 * 3) Insert at beginning and end by
 *     joint maintaining one tail reference 
 * 
 * Disadvantages :
 *  Implementation of operation become complex
 * 
 * 
 * @author shree
 *
 */

class CNode{
	
	int data;
	CNode next;
	
	//Constructor 
	CNode(int x){
		data=x;
		next=null;
	}
}

public class LL04_Circular_Linked_List {

	public static void main(String[] args) {
		
		CReateASinglyCircularLinkedList();
		
		CNode head=new CNode(10);
		//PrintCircularLinkedList(head);
		head.next=new CNode(20);
		head.next.next = new CNode(30);
		head.next.next.next= new CNode(40);
		head.next.next.next.next= new CNode(20);
		head.next.next.next.next.next=new CNode(50);
		
		//Tail== head 
		head.next.next.next.next.next.next=head;
		PrintCircularLinkedList(head);
		PrintCircularLinkedListDoWhile(head);
		
		// O 1 Tricky implementation 
		//Insertion

		head = InsertAtBeginO1(head, 1);
		head = InsertAtEndO1(head, 98);
		System.out.println(" After insertion O1");
		PrintCircularLinkedListDoWhile(head);

		// Deletion

		head = DeleteAtBeginO1(head);
		head = DeleteAtEndpos(head,6);
		System.out.println(" After Delete ");
		PrintCircularLinkedListDoWhile(head);

		//Insertion
		
		head=InsertAtBegin(head,0);
		head=InsertAtEnd(head,99);
		System.out.println(" After insertion ");
		PrintCircularLinkedListDoWhile(head);

		// Deletion

		head = DeleteAtBegin(head);
		head = DeleteAtEnd(head);
		System.out.println(" After Delete ");
		PrintCircularLinkedListDoWhile(head);
		
	}

	private static CNode DeleteAtEndpos(CNode head,int pos) {
		// O 1 dleteion 
		if (head == null || head.next == null) {
			return null;
		}

		if(pos==0) {
			return DeleteAtBeginO1(head);
		}
		// Swap first and second data
		// Delete the second one
       CNode temp=head;
		int count=0;CNode prev=head;
		while(count!=pos && head!=null) {
			prev=head;
			count++;
			head=head.next;
		}
		
        prev.next=head.next;
		return temp;
	}

	private static CNode DeleteAtBeginO1(CNode head) {
		// O 1 dleteion 
		if(head==null || head.next==null) {
			return null;
		}
		
		//Swap first and second data 
		// Delete the second one
		
		int temp=head.next.data;
		head.next.data=head.data;
		head.data=temp;
		//Delete the 2nd one garbage collector
		head.next=head.next.next;
		
		
		return head;
	}

	private static CNode InsertAtEndO1(CNode head, int val) {
		// Do in O1 
		CNode insert = new CNode(val);
		if (head == null) {
			insert.next=insert;
			return insert;
		}

		// Add new
		insert.next = head.next;
		head.next = insert;

		// Swap data of insert and head
		int temp = head.data;
		head.data = insert.data;
		insert.data = temp;
		//Now insert is actual head 
		return insert;
	}

	private static CNode InsertAtBeginO1(CNode head, int val) {
		// Do in O1 
		CNode insert=new CNode(val);
		if(head==null) {
			insert.next=insert;
			return insert;
		}
		
		//Add new 
		insert.next=head.next;
		head.next=insert;
		
		// Swap data of insert and head 
		int temp=head.data;
		head.data=insert.data;
		insert.data=temp;
		return head;
	}

	private static CNode DeleteAtEnd(CNode head) {
		// Delete end
		if (head == null || head.next==null) {
			return head;
		}
		CNode temp=head;
		for(head=head.next;temp!=head.next.next;head=head.next) {
			System.out.print(head.data+"->");
		}
		
		head.next=temp;
		return temp;
	}

	private static CNode DeleteAtBegin(CNode head) {
		// delete beginning 
		if (head == null || head.next==null) {
			return head;
		}
		CNode temp=head.next;
		for(head=head.next;temp!=head.next.next;head=head.next) {
			System.out.print(head.data+"->");
		}
		
		head.next=temp;
		return head.next;
	}

	private static CNode InsertAtEnd(CNode head, int val) {
		// Insert at end 
		CNode insert=new CNode(val);
		if(head==null) {
			return insert;
		}
		insert.next=head;
		CNode temp=head;
		while(temp!=head.next) {
			System.out.print(head.data+"->");
			head=head.next;
		}
		head.next=insert;
		return temp;
	}

	private static CNode InsertAtBegin(CNode head, int val) {
		// Insert at begin 
		CNode insert=new CNode(val);
		if(head==null) {
			return insert;
		}
		insert.next=head;
		CNode temp=head;
		while(temp!=head.next) {
			System.out.print(head.data+"->");
			head=head.next;
		}
		head.next=insert;
		return insert;
		
	}

	private static void CReateASinglyCircularLinkedList() {
		// simple list 
		//Create 
		CNode head=new CNode(10);
		CNode temp1=new CNode(20);
		CNode temp2 = new CNode(30);
		CNode temp3= new CNode(40);
		CNode temp4=new CNode(50);
		
		//L\
	
		head.next=temp1;
		temp1.next=temp2;
		temp2.next=temp3;
		temp3.next=temp4;
		//Tail== head 
		temp4.next=head;
		PrintCircularLinkedList(head);
		PrintCircularLinkedListDoWhile(head);
		
	}
	
	private static void PrintCircularLinkedListDoWhile(CNode head) {
		//do while 
		if(head==null) {
			System.out.println(" NULL ....");
			return;
		}
		CNode temp=head;
		do{
			System.out.print(head.data+"->");
			head=head.next;
		}while(head!=null && head!=temp );
		System.out.println();
	}

	private static void PrintCircularLinkedList(CNode head) {
		// Print till null
		if(head==null) {
			System.out.println(" NULL ....");
			return;
		}
		System.out.print(head.data+"->");
		CNode temp=head;
		for(head=head.next;temp!=head;head=head.next) {
			System.out.print(head.data+"->");
		}
		System.out.println();
	}
}

/*
 * Circular Linked Lists


A circular linked list is a linked list where all nodes are connected to form a circle. There is no NULL at the end. A circular linked list can be a singly circular linked list or doubly circular linked list.
 



Below is a pictorial representation of Circular Linked List:


Implementation:
To implement a circular singly linked list, we take an external pointer that points to the last node of the list. If we have a pointer last pointing to the last node, then last -> next will point to the first node.


The pointer last points to node Z and last -> next points to the node P.

 

Why have we taken a pointer that points to the last node instead of first node?


For insertion of node in the beginning we need to traverse the whole list. Also, for insertion at the end, the whole list has to be traversed. If instead of start pointer we take a pointer to the last node then in both the cases there won’t be any need to traverse the whole list. So, insertion in the beginning or at the end takes constant time irrespective of the length of the list.

Below is a sample program to create and traverse in a Circular Linked List in both Java and C++:
 


// A complete Java program to demonstrate the 
// working of Circular Linked Lists

class CLL 
{ 
    // A circular linked list node
    static class Node 
    { 
        int data; 
        Node next; 
    }; 

    // Function to insert a node in a Circular
    // linked list at the end
    static Node addEnd(Node last, int data) 
    { 
        if (last == null) 
        {
            // Creating a node dynamically. 
            Node temp = new Node(); 
        
            // Assigning the data. 
            temp.data = data; 
            last = temp; 
        
            // Creating the link. 
            last.next = last; 
        
            return last; 
        } 
        
        Node temp = new Node(); 
    
        temp.data = data; 
        temp.next = last.next; 
        last.next = temp; 
        last = temp; 
    
        return last; 
    } 
    
    // Function to traverse a given Circular Linked 
    // List using the Last pointer
    static void traverse(Node last) 
    { 
        Node p; 
    
        // If list is empty, return. 
        if (last == null) 
        { 
            System.out.println("List is empty."); 
            return; 
        } 
    
        // Pointing to first Node of the list. 
        p = last.next; 
    
        // Traversing the list. 
        do
        { 
            System.out.print(p.data + " "); 
            p = p.next; 
    
        } 
        while(p != last.next); 
    
    } 
    
    // Driver code 
    public static void main(String[] args) 
    { 
        Node last = null; 
    
        last = addEnd(last, 6); 
        last = addEnd(last, 4); 
        last = addEnd(last, 2); 
        last = addEnd(last, 8); 
        last = addEnd(last, 12); 
        last = addEnd(last, 10); 
    
        traverse(last); 
    } 
} 

Output:
 

6 4 2 8 12 10


Advantages of Circular Linked Lists:
 

Any node can be a starting point. We can traverse the whole list by starting from any point. We just need to stop when the first visited node is visited again.
Useful for implementation of a queue. Unlike this implementation, we don’t need to maintain two pointers for front and rear if we use a circular linked list. We can maintain a pointer to the last inserted node and the front can always be obtained as the next of last.
Circular lists are useful in applications to repeatedly go around the list. For example, when multiple applications are running on a PC, it is common for the operating system to put the running applications on a list and then to cycle through them, giving each of them a slice of time to execute, and then making them wait while the CPU is given to another application. It is convenient for the operating system to use a circular list so that when it reaches the end of the list it can cycle around to the front of the list.
Circular Doubly Linked Lists are used for implementation of advanced data structures like Fibonacci Heap.
 * 
 */
