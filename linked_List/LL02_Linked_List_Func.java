package linked_List;

class Node{
	
	int data;
	Node next;
	
	//Constructor 
	Node(int x){
		data=x;
		next=null;
	}
}
public class LL02_Linked_List_Func {

	public static void main(String[] args) {
		
		// Traversal
		Node head2 = new Node(100);
		head2.next = new Node(200);
		head2.next.next = new Node(300);
		head2.next.next.next = new Node(400);
		head2.next.next.next.next = new Node(500);

		//Traverse
		System.out.println(" Linear traversal - O 1 space O N time  ");
		PrintLinkedList(head2);
		System.out.println(".....recursive traversal O N space O N time  ");
		RecursiveTraversal(head2);
		
		//INSERT
		
		int val=999;
		//Insert must retuen head 
		// IF not changes will not be reflected 
		head2=InsertAtBegin(head2,val);
		head2=InsertAtBegin(head2,99);
		System.out.println(" Check after insert at begin ");
		PrintLinkedList(head2);
		
		// No need to return neew head 
		//Alter the node 
		InsertAtEnd(head2,600);
		InsertAtEnd(head2,700);
		System.out.println(" Check after insert at end ");
		PrintLinkedList(head2);
		
		head2=InsertAtPosition(head2,3,111);
		System.out.println(" Check after insert at pos ");
		PrintLinkedList(head2);
		
		//DELETE 
		// delete must retuen head
		// IF not changes will not be reflected
		head2 = DeleteAtBegin(head2);
		head2 = DeleteAtBegin(head2);
		System.out.println(" Check after delete at begin ");
		PrintLinkedList(head2);

		// No need to return neew head
		// Alter the node
		DeleteAtEnd(head2);
		DeleteAtEnd(head2);
		System.out.println(" Check after delete at end ");
		PrintLinkedList(head2);
		
		Node head3=new Node(1);
		head3.next=new Node(2);
		head3=DeleteAtBegin(head3);
		System.out.println(" Check after delete at end ");
		PrintLinkedList(head3);
		
		DeleteAtEnd(head3);
		
		System.out.println(" Check after delete at end ");
		PrintLinkedList(head3);
		
		//SEARCH 
		
		val=300;
		int ans=SearchLinear(head2,val);
		System.out.println(" Pos of val in LL "+ans);
		
		ans=SearchRecursive(head2,val,0);
		System.out.println(" Pos of val in LL "+ans);
		
		ans=searchlessStack(head3, ans);
		System.out.println(" Pos of val less stACK in LL "+ans);
		
		head3=reverseList(head3);
		System.out.println(" Check after reverse ");
		PrintLinkedList(head3);
		
		
	}
	
	
	
	 private static Node reverseList(Node head)
	    {
	        // code here
	         if(head == null || head.next == null){
	            return head;
	        }
	        Node prev = head;
	        Node curr = head.next;
	        Node next;
	        while(curr!=null){
	            next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }
	        head.next = null;
	        head = prev;
	        return head;
	    }
	
	private static int searchlessStack(Node head, int x){
        if(head==null)return -1;
        if(head.data==x)return 1;
        else{
            int res=searchlessStack(head.next,x);
            if(res==-1)return -1;
            else return res+1;
        }
    }
	
	private static int SearchRecursive(Node head, int val, int count) {
		//base case 
		if(head==null) {
			return -1;
		}
		if(head.data==val) {
			return count;
		}
		count++;
		
		return SearchRecursive(head.next,val,count);
	}

	private static int SearchLinear(Node head, int val) {
		// swarch 
		
		if(head==null) {
			return -1;
		}
		int count=0;
		while(head!=null) {
			if(head.data==val) {
				return count;
			}
			head=head.next;
			count++;
		}
		return count;
	}

	private static Node InsertAtPosition(Node head, int pos, int val) {
		// Insert at pos 
		//If no pos insert at last 
		Node insert=new Node(val);
		if(head==null) {
			return insert;
		}
		if(pos==1) {
			insert.next=head;
			return insert;
		}
		Node temp=head;
		int count=0;//must be pos-2 
		while(head.next!=null && count<pos-2) {
			head=head.next;
			count++;
		}
		if((count!=pos-2)) {
			System.out.println(" No correct space to add ");
		}
		insert.next=head.next;
		head.next=insert;
		return temp;
	}

	private static void DeleteAtEnd(Node head) {
		// delete at end 
		//Return if already null 
		if(head==null) {
			System.out.println("NON or 1 ");
			return ;
		}
		
		Node prev = head;
		if(head.next==null) {
			
		}
		
		while(head.next!=null) {
			prev=head;
			head=head.next;
		}
		//Making the last as null 
		prev.next=null;
		return;
		
	}

	private static Node DeleteAtBegin(Node head) {
		// Delete at beginning 
		//Just return next node as head 
		return head.next;
	}

	private static void InsertAtEnd(Node head, int val) {
		// Insert at end 
		//We dont know end 
		
		if(head==null) {
			head=new Node(val);
			return;
		}
		while(head.next!=null) {
			head=head.next;
		}
		
		head.next=new Node(val);
		return ;
	}

	private static Node InsertAtBegin(Node head2, int val) {
		// Insert at begin 
		Node insert=new Node(val);
//		//Corner case head == NULL 
//		if(head2==null) {
//			return insert;
//		}
		//Null pointer exception if null head 
		insert.next=head2;
		return insert;
		
	}

	private static void RecursiveTraversal(Node head) {
		// Recursive print 
		if(head==null) {
			System.out.println(".");
			return;
		}
		System.out.print(head.data+"--");
		RecursiveTraversal(head.next);
		
	}

   static void PrintLinkedList(Node head) {
		// Print till null
		if(head==null) {
			System.out.println(" NULL ....");
			return;
		}
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

}
