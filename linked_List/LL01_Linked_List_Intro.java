package linked_List;
/**
 * 
 * Linked List 
 * 
 * Self referential structure 
 * Reference of self type 
 * class Node{  //Node
 *     int data;
 *     Node next;// Reference of Node 
 * }
 * Node is stored in Node , so self referential 
 * Sequential data without contiguous memory location 
 * Java - stored in heap area 
 * Heap area is used to store dynamic allocate memory 
 * 
 * 
 * Advantage :
 * 1) Best insertion and deletion 
 * 2) Node , has address and value 
 * 
 * Disadvantage:
 * 1) Not cache friendly as not contiguous
 * 2) No random access - so no binary search 
 * 3) Extra memory for address storage 
 * 
 * Pointer - C/C++
 * 4 bytes used to store address and data int means 2 byte 
 * 
 * Reference - Java 
 * 
 * Applications :
 * 1) Worst case insertion end and begin - O 1 if we know head tail
 * 2) Worst case deletion from begin is O 1 if we know head tail
 * 3) Insertion and deletion n middle is O 1 if we know prev node
 * 4) Round Robin implementation - cpu scheduling algorithm 
 * 5) Merging two sorted linked list in less space 
 * 6) Simple memory management where we need to link free blocks
 * 6) Easy implementation of queue and dequeue
 * 
 * 
 *
 * @author shree
 *
 */
class NodeLL01{
	
	int data;
	Node next;
	
	//Constructor 
	NodeLL01(int x){
		data=x;
		next=null;
	}
}


public class LL01_Linked_List_Intro {

	public static void main(String[] args) {
		// intro
		// Create a linked list

		CreateALinkedList();
		LinkedListTraversal();
	}
	
 
	private static void LinkedListTraversal() {
		// Traversal
		Node head2=new Node(100);
		head2.next=new Node(200);
		head2.next.next=new Node(300);
		head2.next.next.next=new Node(400);
		head2.next.next.next.next=new Node(500);
		
		PrintLinkedList(head2);
	}


	private static void PrintLinkedList(Node head) {
		// Print till null
		Node temp=head;
		while(head.next!=null) {
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.print(head.data);
		System.out.println();
		//or.............. 
		head=temp;
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
	}


	private static void CreateALinkedList() {
		// Linked list 
		// head : 10 2000
		//    2000: 20 8000
		//   8000: 30 NULL
		//  store in heap area 
		
		//Initiation 
		Node head=new Node(10);
		Node temp1=new Node(20);
		Node temp2=new Node(30);
		//After initiation 
		// 10 NULL -- 20 NULL -- 30 NULL
		
		//Linking
		head.next=temp1;
		temp1.next=temp2;
		//After Linking 
		// 10 2000-> 20 8000-> 30 NULL
		
		//SHORT CUT METHOD
		Node head2=new Node(100);
		head2.next=new Node(200);
		//Below accepted ans also give 
		head2.next.next=new Node(300);
		// Below null pointer 
	//	head2 10.next 200.next 300.next is null currently 
    //  But 300.next  null -> . next gives null pointer 
		//	head2.next.next.next.next.next=new Node(500);
		head2.next.next.next=new Node(500);
		
	}

}
