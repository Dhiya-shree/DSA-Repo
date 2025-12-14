package linked_List;
/**
 * 
 * Doubly linked list 
 * 
 * Have an extra pointer for previous node 
 * On creation : 
 *    null 10|2000 null   null 30|5000 null  null 60|1500 null
 * After linking 
 *   head                     elements                        tail
 *   null 10|2000 5000 --> 2000 30|5000 1500 --> 5000 60|1500 null
 *   
 * Advantages of Doubly:
 * 1) Traversed in both direction 
 * 2) delete at end in O 1 given reference of tail 
 *    -- LL takes O N time to delete last 
 *    -- LL have to trversE to get to the previous ode
 *    -- Traversal to find prev can be O N 
 *    -- In DLL it is avoided 
 * 3) Insert  delete before and after given node 
 * -- LL insert at begin , end and delete at begin is O 1
 *    but DLL  even delete at end is O 1 
 * 4)Insert/delete at ends in O1 by maintaining tail 
 * 
 * 
 * Disadvantage :
 *   Extra space for prev 
 *   Code becomes more complex 
 * 
 * Application :
 *  Easy to build Dequeue 
 * 
 * 
 * @author shree
 *
 */

class DNode{
	
	int data;
	DNode next;
	DNode prev;
	
	//Constructor 
	DNode(int x){
		data=x;
		next=null;
		prev=null;
	}
}


public class LL03_Doubly_Linked_List {

	public static void main(String[] args) {
		//Doubly 
		
		CreationDoubleLL();
		
		// Simple creation of doubly linked list  
		DNode head=new DNode(10);
		//2nd node 
		head.next=new DNode(30);
		head.next.prev=head;
		//3rd node 
		head.next.next=new DNode(60);
		head.next.next.prev=head.next;
		
		//Insert 
		
		head=InsertAtBegin(head,0);
		head=InsertAtEnd(head,99);
		System.out.println(" after insertion ");
		PrintDoubleLinkedList(head);
		
		//Reverse 
		head=ReverseDLL(head);
		System.out.println(" After reverse ");
		PrintDoubleLinkedList(head);
		
		// Delete

		head = DeleteAtBegin(head, 0);
		head = DeleteAtEnd(head, 99);
		System.out.println(" after Delete ");
		PrintDoubleLinkedList(head);

	}

	private static DNode DeleteAtEnd(DNode head, int i) {
		//Have tail pointer and delete easily 
		// delete at end 
		if(head==null) {
			return head;
		}
		
		if(head.next==null) {
			return null;
		}
		DNode temp=head;
		
		while(temp.next!=null) {
			temp=temp.next;
		}
		
		temp.prev.next=null;
		return head;
	}

	private static DNode DeleteAtBegin(DNode head, int i) {
		// delete begin 
		if(head==null) {
			return head;
		}
		head=head.next;
		head.prev=null;
		return head;
	}

	private static DNode ReverseDLL(DNode head) {
		// Reverse 
		if(head==null || head.next==null) {
			return head;
		}
		DNode temp; DNode ans=head;
		while(head!=null) {
	    ans=head;
		temp=head.next;
		head.next=head.prev;
		head.prev=temp;
		
		head=temp;
		}
		//Tail
		
		
		return ans;
	}

	private static DNode InsertAtEnd(DNode head, int val) {
		// Insert at End 
		DNode insert=new DNode(val);
		if(head==null) {
			return insert;
		}
		DNode temp=head;
		while(head!=null && head.next!=null) {
			head=head.next;
		}
		head.next=insert;
		insert.prev=head;
		return temp;
	}

	private static DNode InsertAtBegin(DNode head, int val) {
		// Insert at begin 
		DNode insert=new DNode(val);
		insert.next=head;
		if(head!=null) {
		head.prev=insert;}
		
		return insert;
	}

	private static void CreationDoubleLL() {
		// Creation 
		DNode head=new DNode(10);
		DNode temp1=new DNode(30);
		DNode temp2=new DNode(60);
		head.next=temp1;
		temp1.next=temp2;
		temp1.prev=head;
		temp2.prev=temp1;
		
	}

	 static void PrintDoubleLinkedList(DNode head) {
		// Print till null
		if(head==null) {
			System.out.println(" NULL ....");
			return;
		}
	//	DNode temp=head;
		while(head.next!=null) {
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.print(head.data);
		System.out.println();
	}
}
