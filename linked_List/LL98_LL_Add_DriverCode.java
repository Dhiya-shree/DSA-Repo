package linked_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinkedList {
    Node head;
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
	
	
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    
    static int getsize(Node head) { 
        int count = 0; 
        while (head != null) { 
            count++; 
            head = head.next; 
        } 
        return count; 
    } 
    
    static void addTwoLists(LinkedList first, LinkedList second, LinkedList res, LL98_LL_Add_DriverCode g) {
	    if (first.head == null) { 
            res.head = second.head; 
            return; 
        }  
        if (second.head == null) { 
            res.head = first.head; 
            return; 
        } 
        int size1 = getsize(first.head); 
        int size2 = getsize(second.head); 
        g.carry = 0;
        if (size1 == size2) { 
            g.addSameSize(first.head, second.head, res); 
        } else { 
            if (size1 < size2) { 
                Node temp = first.head; 
                first.head = second.head; 
                second.head = temp; 
            } 
            int diff = Math.abs(size1 - size2); 
            Node temp = first.head; 
            while (diff-- >= 0) { 
                g.cur = temp; 
                temp = temp.next; 
            } 
            g.addSameSize(g.cur, second.head, res);
            g.addCarryToRemaining(first.head, res); 
        }
        if(g.carry > 0) 
            res.push(g.carry); 
	}
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String[] inputline = br.readLine().trim().split(" ");
            int n1 = Integer.parseInt(inputline[0]);
            int n2 = Integer.parseInt(inputline[1]);
            
            inputline = br.readLine().trim().split(" ");
            LinkedList list1 = new LinkedList();
            for (int i = n1 -1; i >=0 ; i--) {
                int a = Integer.parseInt(inputline[i]);
                list1.push(a);
            }
            
		    inputline = br.readLine().trim().split(" ");
		    LinkedList list2 = new LinkedList();
		    for(int i = n2-1; i >= 0; i--) {
			    int b = Integer.parseInt(inputline[i]);
			    list2.push(b);
		    }
		    LinkedList res = new LinkedList();
		    LL98_LL_Add_DriverCode g = new LL98_LL_Add_DriverCode();
            addTwoLists(list1, list2, res, g);
		    res.printList(res.head);
        }
    }
}   
                               
// } Driver Code Ends


//User function Template for Java

 
/*class Node 
{
    int data;
    Node next;
    
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
public class LL98_LL_Add_DriverCode {


    Node cur; // Dont change the variable name, its used in main function
    int carry; // Dont change the variable name, its used in main function
    
    void printtu(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    //This function is called after the smaller list is added to the sublist of 
    //bigger list of same size. Once the right sublist is added, the carry
    //must be added to left side of larger list to get the final result.    
    void addCarryToRemaining(Node head, LinkedList res)  { 
        // Write code here
        
   //    Node resHead=res.head;
     //  Node ans=res.head;// Has val of addeded result 
     /*  int size=0;
       while(resHead!=null){
           size++;
           resHead=resHead.next;
       }*/
    //    printtu(ans);
      //  printtu(head);
        // Carry will have any diff if exsist 
  //     int count=0;
   //    Node start=head;
        Node Copy=head;
       Node  prev1=null;
	   Node next1=null;
	  //  head=res.head;
	  // Reverse the big list till the point of add
	  // 1 2 3 4 5 9 7 8 9 
	  //       +     2 2 3 
	  //       res   0 2 2 carry 1
	  // 1 2 3 4 5 9 
	  // Reverse till res below:
	  // Copy= 9 5 4 3 2 1
	 //  System.out.println("sizze " +size);
	  //  System.out.println("copy " +Copy.data);
	    while (Copy.next != null ) {
            next1 = Copy.next;
            Copy.next = prev1;
            prev1 = Copy;
            Copy = next1;
          //   size--;
        }
        Copy=prev1;
    //    printtu(Copy);
      // Copy= 9 5 4 3 2 1+ CArry 
      // Copy2 0 6 4 3 2 1 + Carry 0
  //    System.out.println("copy " +Copy.data);
      int sum=0;
      while(Copy!=null){
          sum=Copy.data+carry;
          Copy.data=sum%10;
          carry=sum/10;
          Copy=Copy.next;
      }
    // Ans = 0 2 2 
    // Carry = 0 6 4 3 2 1
    // Need final : 1 2 3 4 6 0 0 2 2 
    // Reverse copy and add till end 
    //Add res till end 
     Node Copy2=Copy;
   
    // System.out.println("copy2 " +Copy2.data);
        while (Copy2 != null ) {
            next1 = Copy2.next;
            Copy2.next = prev1;
            prev1 = Copy2;
            Copy2 = next1;
            // count++;
        }
        Copy2=prev1;
        //System.out.print(" Final ....");
      //  printtu(Copy2);
    //    printtu(ans);
       
       while(Copy2!=null){
           res.push(Copy2.data);
           Copy2=Copy2.next;
       }
        
    } 
    
    //Function which adds two linked lists of same size represented by head1  
    //and head2 and returns head of the resultant linked list. Carry
    //is propagated while returning from the recursion    
	void addSameSize(Node head1, Node head2, LinkedList res) { 
	    // Write code here
	    int sum=0;
	    carry=0;
	//    Node temp1;
	    Node tail1=head1;
	    Node tail2=head2;
	    Node prev1=null;
	    Node prev2=null;
	    Node next1=null;
	    Node next2=null;
	    
	   while (head1 != null && head2 != null) {
            next1 = head1.next;
            head1.next = prev1;
            prev1 = head1;
            head1 = next1;
            
            next2 = head2.next;
            head2.next = prev2;
            prev2 = head2;
            head2 = next2;
        }
        tail1 = prev1;
	    tail2 = prev2;
	    head1=tail1;    
	    head2=tail2;
	   //   System.out.println(head1.data+"....."+head2.data); 
	    Node head=res.head;
	    boolean first=true;
	    while(head1!=null && head2!=null){
	        sum=head1.data+head2.data+carry;
	        carry=sum/10;
	        sum=sum%10;
	        if(first){
	        head=new Node(sum);
	        res.head=head;
	        first=false;
	        }
	        else{
	            head.next=new Node(sum);
	            head=head.next;
	        }
	     //   System.out.println(head.data);
	        head1=head1.next;
	        head2=head2.next;
	       // head=head.next;
	    }
	    
	    // No need to worry about carry 
	    // Carry =1 for 500+500
	    // Carry stored by main and used 
	    // No need to add carry seperately in res 
	    
	    prev1=null;
	    next1=null;
	    head=res.head;
	      while (head != null) {
            next1 = head.next;
            head.next = prev1;
            prev1 = head;
            head = next1;
         
        }
       res.head = prev1;
    
    }
} 
