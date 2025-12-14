package linked_List;
/**
 * 
 * Circular Doubly linked list 
 * 
 * Previous of head is last node 
 * Next of last node is head 
 * Empty circular linked list is NULL 
 * Single node circular linked list has 
 *    prev== next == same 
 * 
 * Advantage:
 * Traverse either way 
 * Implementing Josephus problem 
 * Last node in constant time , no need to maintain Tail 
 * No Tail needed 
 *   So easy insert , delete 
 *   
 * Disadvantage:
 *  Excess space 
 * 
 * @author shree
 *
 */
class CDNode{
	
	int data;
	CDNode next;
	CDNode prev;
	
	//Constructor 
	CDNode(int x){
		data=x;
		next=null;
		prev=null;
	}
}
public class LL05_Doubly_Circular_Linked_List {

	public static void main(String[] args) {
		// Doubly circular linked 
		// Simple creation of doubly linked list  
		CDNode head=new CDNode(10);
				//2nd node 
		head.next=new CDNode(30);
		head.next.prev=head;
				//3rd node 
		head.next.next=new CDNode(60);
		head.next.next.prev=head.next;
		
		head.next.next.next=new CDNode(90);
		head.next.next.next.prev=head.next.next;
		
		head.next.next.next.next=new CDNode(120);
		head.next.next.next.next.prev=head.next.next.next;
		
		//TAIL AND HEAD pointing 
		head.prev=head.next.next.next.next;
		head.next.next.next.next.next=head;
				
				//Insert 
				
				head=InsertAtBegin(head,0);
				head=InsertAtEnd(head,99);
				System.out.println(" after insertion ");
				PrintCircularDoubleLinkedList(head);
				
				
				// Delete

				head = DeleteAtBegin(head);
				System.out.println(" after Delete ");
				PrintCircularDoubleLinkedList(head);
				head = DeleteAtEnd(head,3);
				
				System.out.println(" after Delete ");
				PrintCircularDoubleLinkedList(head);
		

	}

	

	private static CDNode DeleteAtEnd(CDNode head, int pos) {
		// Delete at pos
		if(head==null || head.next==null) {
			return null;
		}
		if(pos==1) {
			return DeleteAtBegin(head);
		}
		
		int count=1;
		CDNode temp=head;
		head=head.next;
		while(head.next!=null && count!=pos && head!=temp) {
			head=head.next;
			count++;
		}
		head.prev.next=head.next;
		head.next.prev=head.prev;
		
		return temp;
	}

	private static CDNode DeleteAtBegin(CDNode head) {
		// Delete at begin 
		head.prev.next=head.next;
		head.next.prev=head.prev;
		return head.next;
	}

	private static CDNode InsertAtEnd(CDNode head, int val) {
		// insert begin 
		CDNode insert=new CDNode(val);
		if(head==null) {
			insert.next=insert;
			insert.prev=insert;
			return insert;
		}
		
		insert.prev=head.prev;
		insert.next=head;
		head.prev.next=insert;
		head.prev=insert;
		return head;
	}

	private static CDNode InsertAtBegin(CDNode head, int val) {
		// insert begin 
		CDNode insert=new CDNode(val);
		if(head==null) {
			insert.next=insert;
			insert.prev=insert;
			return insert;
		}
		
		head.prev.next=insert;
		insert.prev=head.prev;
		insert.next=head;
		head.prev=insert;
		return insert;
	}

	private static void PrintCircularDoubleLinkedList(CDNode head) {
		// Print till null
				if(head==null) {
					System.out.println(" NULL ....");
					return;
				}
	CDNode temp=head;
				while(head.next!=null && head.next!=temp) {
					System.out.print(head.data+"->");
					head=head.next;
				}
				System.out.print(head.data);
				System.out.println();
		
	}
}
