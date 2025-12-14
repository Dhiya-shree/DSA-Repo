package linked_List;

import java.util.HashMap;

/**
 * Problem #1 : Sorted Insert in a Singly Linked List
 * 
 * Insert x in sorted LL 
 * 
 * Problem #2: Find length of Loop
 * Given a linked list of size N. The task is to complete the function countNodesinLoop() that checks whether a given Linked List contains
 *  a loop or not and if the loop is present then return the count of nodes in a loop or else return 0. C is 
 *  the position of the node to which the last node is connected. 
 *  If it is 0 then no loop.
 *  
 * Solution 1:
 * 1) With space : Use HashMap 
 * 2) Less space : Floyd Hare Turtle 
 * 
 *  
 * Problem #2 :Add two numbers represented by linked lists  .....................HARD
 * Given two decimal numbers represented by two linked lists of size N and M respectively. The task is to return a linked list that represents the sum of these two numbers.
 * For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. 
 * Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.
 * 
 * 
 * Problem # 3:Swap Kth nodes from ends .........................................HARD
 * Given a singly linked list of size N, and an integer K. You need to swap the Kth node from the beginning and Kth node from the end of the linked list
 * . Swap the nodes through the links. Do not change the content of the node
 * 
 * Problem#4 :Delete without head pointer
 * You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. Pointer/ reference to head node is not given. 
 * Note: No head reference is given to you. It is guaranteed that the node to be deleted is not a tail node in the linked list.
 * 
 * 
 * Problem #5 : Middle of linked list 
 *  Return data of middle 
 * 
 * @author shree
 *
 */
public class LL06_LL_sums_easy {

	public static void main(String[] args) {
		
		// Traversal
				Node head2 = new Node(100);
				head2.next = new Node(200);
				head2.next.next = new Node(300);
				head2.next.next.next = new Node(400);
				head2.next.next.next.next = new Node(500);
			head2.next.next.next.next.next = new Node(600);
				head2.next.next.next.next.next.next= new Node(700);
		//		head2.next.next.next.next.next.next.next= new Node(800);
		
				//Dont use below 
			deleteNode(head2);
				//SWAP and deletre
				
		head2=SwapNodes(head2,5,2);
		LL02_Linked_List_Func.PrintLinkedList(head2);
		
		head2=InsertInSorted(head2,105);
		LL02_Linked_List_Func.PrintLinkedList(head2);
		
		int ans=countNodesinLoop(head2);
		System.out.println("No of looops present  = +ans");
		
		ans=countNodesinLoopFlyod(head2);
		System.out.println("No of looops present  = +ans");
	
	    ans=MiddleInLL(head2);
	    System.out.println(" Middle is "+ans);
	}
	private static int MiddleInLL(Node head) {
		// data of middle 
		if(head==null) {
			return -1;
		}
		if(head.next==null) {
			return head.data;
		}
		
		if(head.next.next==null) {
			return head.next.data;
		}
		
		//Have two pointers 
		// Slow moving 1 node at a time 
		// Fast moving two nodes at a time
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			//head=head.next;
		}
		
		return slow.data;
	}
	private static void  deleteNode(Node del)
    {
         // Need to delete del 
         //Swap del and next data 
          del.data=del.next.data;
          // Delete the node after del
         Node nex=del.next.next;
         del.next=nex;
        
    }
	
	private static Node SwapNodes(Node head, int num, int K) {
		 if(num==1){
	            return head;
	        }
	        if(num==2){
			    if(K==2 || K==1){
			        Node end=head.next;
			        end.next=head;
			        head.next=null;
			        return end;
			    }
			    else{
			        return head;
			    }
			}
	        if(K==0 || K>num ||((K%2!=0 && num%2==0 && num/2==K))) {
				return head;
			}
			
			if(K==1 ||  num-K==1 || num==K) {
				//Interchange 1 and last node 
			return ChangeFor1(head,num,K);
		}
		
		int count=1;
		
		Node temp=head;
		Node prev1=head;
		Node prev2=head;
		Node next1=null;
		Node next2=null;
		Node start=head;
		Node end=null;
		int ck=num-K+1;
		
		boolean flg=((K%2==0 && num%2==0 && num/2==K));
		while(head.next!=null) {
			
			if(count==K && flg) {
			//	System.out.println(" Flag ");
				end=head.next;
				if(head.next!=null) {
					next2=head.next.next;
				}
				prev2.next=end;
				end.next=head;
				head.next=next2;
				return temp;
			}
			if(count==K) {
			//	System.out.println(" count "+count);
				prev1=prev2;
				start=head;
				if(head.next!=null) {
				next1=head.next;
				}
				//System.out.println(" For start "+start.data+" Prev "+prev1.data+" next "+next1.data);

			}
			
			if(count==ck) {
			//	System.out.println(" count "+count);
				end=head;
				if(head.next!=null) {
					next2=head.next;
				}
			//	System.out.println(" For end "+end.data+" Prev "+prev2.data+" next "+next2.data);
				break;
			}
			
			
			prev2=head;
			head=head.next;
			count++;
		}
		
		//System.out.println(" For start "+start.data+" Prev "+prev1.data+" next "+next1.data);
		//System.out.println(" For end "+end.data+" Prev "+prev2.data+" next "+next2.data);
		
		//Swap for start 
		prev1.next=end;
		end.next=next1;
		
		//Swap for end
		prev2.next=start;
		
			start.next=next2;
		
		
		return temp;
	}
	private static Node ChangeFor1(Node head, int num, int k) {
		//Interchange 1 and last node 
		Node start=head;
		Node nextStart=head.next;
		Node prev=head;
		while(head.next!=null) {
			prev=head;
			head=head.next;
		}
		
		prev.next=start;
		head.next=nextStart;
		start.next=null;
		return head;
	}
	//Function to add two numbers represented by linked list.
	static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
       Node t1=first;
           Node t2=second;Node link = null;
           StringBuffer f=new StringBuffer();StringBuffer s=new StringBuffer();String ans;
           while(t1!=null){
               f.append(t1.data);
               t1=t1.next;
           }
           while(t2!=null){
        	   s.append(t2.data);
               t2=t2.next;
           }
      //  System.out.println("s "+s+" f: "+f);
         //  ass=;
           String fs=(f.reverse().toString());
           int fl=fs.length();
           String ss=(s.reverse().toString());
             int sl=ss.length();
            //  System.out.println("s "+ss+" f: "+fs);
          ans=StringAdd(fs,fl,ss,sl);
       //  System.out.println("s "+s+" f: "+f+".."+ans);
          int digit=1;
           int end=ans.length();
           Node an=new Node((ans.charAt(0))-48);
          link=an;
           while(digit<end){
    
              an.next=new Node((ans.charAt(digit))-48);
                    an=an.next;
               digit++;
              
              //  System.out.println(ans);
           }
   		return link;
    }
      static String StringAdd(String fs, int fl, String ss, int sl) {
		//return add ans 
		 if(fl>sl) {
			 return StringAdd(ss,sl,fs,fl);
		 }
		 
		 StringBuilder ans=new StringBuilder();
		 int carry=0;int a=0;int b=0;int sum=0;
		 for(int i=0;i<fl;i++) {
			 a=ss.charAt(i)-48;
			 b=fs.charAt(i)-48;
			 sum=a+b+carry;
			ans.append(String.valueOf(sum%10));
			 carry=sum/10;
		 }
		//  System.out.println(ans+" carry "+carry);
		 int j=fl;
		 while(j<sl) {
			 sum=carry+(ss.charAt(j)-48);
			 ans.append(String.valueOf(sum%10));
			 carry=sum/10;
			 j++;
		 }
		  // System.out.println(ans+" carry "+carry);
		 while(carry>0) {
			 ans.append(String.valueOf(carry%10));
			 carry=carry/10;
		 }
		return ans.reverse().toString();
	}
	private static int countNodesinLoopFlyod(Node head) {
		  //Add your code here.
		        //Code here
		        int count=0;
		        if(head==null){
		            return 0;
		        }
		        Node hare=head.next;
		        Node turtle=head;
		      
		        while(hare!=turtle){
		            if(hare==null || hare.next==null){
		                //LOOp no 
		                return 0;
		            }
		            hare=hare.next.next;
		            turtle=turtle.next;
		           
		        }
		      //  System.out.println(" Hare "+hare.data+" Tur "+turtle.data);
		         //both pointers now point to the same node in the loop.
		         // Fix turtle 
		         // Hop the hare 
		         // Till hare sees turtle 
		         //Count the hops 
		         hare=hare.next;
		         count=1;
		         //After first hop check
		          while(hare!=turtle){
		             // System.out.println(" Hare "+hare.data);
		             hare=hare.next;
		             count++;
		          }
		        return count;
		    
	}

	private static int countNodesinLoop(Node head)
	    {
	        //Add your code here.
	        //Code here
	        int count=0;
	        HashMap<Node,Integer> hm=new HashMap<>();
	        if(head==null){
	            return 0;
	        }
	        while(head.next!=null){
	            if(hm.containsKey(head)){
	          //      System.out.println(hm.toString());
	                return(count-hm.get(head));
	            }
	            else{
	                hm.put(head,count);
	            }
	            count++;
	            head=head.next;
	        }
	        
	        return 0;
	    }

	private static Node InsertInSorted(Node head, int val) {
		// Given sorted insert 
		Node insert=new Node(val);
		if(head==null) {
			return insert;
		}
		if(head.data>val) {
			insert.next=head;
			return insert;
		}
		Node prev = null;Node temp=head;
		while(head.next!=null) {
			prev=head;
			head=head.next;
			
			if(head.data>val) {
				prev.next=insert;
				insert.next=head;
				return temp;
			}
		}
		
		head.next=insert;
		
		return temp;
	}
	
}

/**

Problem #2 
We can iterate through the linked list and use a hash set to keep track of the nodes we've visited. If we come across a node that we've already seen, we know that we've found a loop and we can count the number of nodes in the loop by continuing to iterate through the loop and counting the number of nodes until we reach the original starting point of the loop again.
 

Example:

 
We will maintain a hash-set d that will contain the nodes that we have visited.
First iteration d={1}
Second iteration d={1,2}
Third iteration d={1,2,3}
Fourth  iteration d={1,2,3,4}
Fifth iteration d={1,2,3,4,5}
Sixth iteration d={1,2,3,4,5} now 2 is already in the set. So the number of nodes in the cycle are 2,3,4,5, i.e 4
return 4.
Implementation:
Initialize an empty unordered_set, which will be used to keep track of the nodes that have been visited.
Create a pointer current that points to the head of the linked list.
Starting from the head of the linked list, iterate through each node and check whether the current node is already present in the unordered_set.
If the current node is not present in the unordered_set, add the node to the set and move the pointer to the next node.
If the current node is already present in the unordered_set, that means we have found a loop, and return the current size of the unordered_set.
If the end of the linked list is reached and no loop is found, return 0.
Code:
//Function to find the length of a loop in the linked list using brute force approach.
int countNodesinLoop(Node* head)
{
    Node* current = head;
    unordered_set<Node*> visited;
    
    // Iterating through the linked list
    while (current != NULL) {
        // checking if the current node is already visited
        if (visited.find(current) != visited.end()) {
            // if yes, then it means there is a loop
            // counting the number of nodes in the loop
            int count = 1;
            Node* temp = current->next;
            while (temp != current) {
                count++;
                temp = temp->next;
            }
            return count;
        }
        // if not visited, adding it to the set
        visited.insert(current);
        current = current->next;
    }
    //if there is no loop, return 0
    return 0;
}
Complexity:
Time Complexity: O(n), The solution involves iterating through the linked list once and in worst case, we traverse the entire linked list of size n. Therefore, the time complexity of the solution is O(n).
Space Complexity: O(n), as in the worst case, all elements of the linked list could be unique and stored in the set, requiring O(n) space.

Expected Solution:
Intuition:
For optimal solution, we can use two pointers, "fast" and "slow", to check for the presence of a loop in the linked list. The fast pointer is moved two nodes at a time, while the slow pointer is moved one node at a time. If there is a loop, the fast pointer will eventually catch up with the slow pointer, and the while loop will exit. The size of the loop is then calculated by moving the fast pointer one node at a time and incrementing a counter. The size of the loop is returned as the result.

Example:
Input:

N=4
value[]={2,3,1,7}
c=3

Initialize two pointers "fast" and "slow" both pointing to the head of the linked list.
    fast = head->next (fast is pointing to 3)
    slow = head (slow is pointing to 2)
In the first iteration of the while loop, fast and slow are not pointing to the same node, so the loop continues.
    fast = fast->next->next (fast is now pointing to 1)
    slow = slow->next (slow is now pointing to 3)
 In the second iteration of the while loop, fast and slow are now pointing to the same node (1), so the loop breaks.
Initialize a variable "size" to 1.
     Set fast = fast->next (fast is now pointing to 7)
In the second while loop, fast and slow are not pointing to the same node, so the loop continues.
     fast = fast->next (fast is now pointing to NULL)
     size = 2
The second while loop breaks because fast is now pointing to NULL
     The function returns 2, which is the length of the loop.
 (Tortoise and Hare method):
The tortoise and hare method or Floyd's Cycle algorithm works best to find the middle of the linked list, cycle detection in the linked list. It used two pointers Fast and slow start from the head. Fast moves twice as slow.While traversing the linked list one of these things will occur-

The Fast pointer may reach the end (NULL) this shows that there is no loop in the linked list.
The Fast pointer again catches the slow pointer at some time therefore a loop exists in the linked list.
Implementation:
Initialize two pointers, fast and slow, to the head of the linked list.
In a while loop, move the fast pointer two steps forward and the slow pointer one step forward.
Check if the fast pointer is equal to the slow pointer. If they are, it means a loop is present and we proceed to the next step. 
If not, check if the fast pointer or the node next to it is NULL. If it is, then there is no loop and we return 0.
Initialize a variable size to 1, as we have already found one node in the loop.
Set fast to the next node, and start iterating the loop with the fast pointer. Increase the size counter for each node visited.
Exit the loop when the fast pointer again reaches the slow pointer.
Return the size variable which now contains the length of the loop.
Complexity:
Time Complexity: O(n), where n is the number of nodes in the linked list. The solution involves a single loop through the linked list using two pointers, which takes O(n) time.
Space Complexity: O(1), the solution does not require any additional data structure and uses only two pointers, so the space complexity is constant at O(1).

//

class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //using two pointers and moving one pointer(slow) by one node and 
        //another pointer(fast) by two nodes in each iteration.
        Node fast = head.next;
        Node slow = head;
        
        while( fast!=slow )
        {
            //if the node pointed by first pointer(fast) or the node 
            //next to it is null, then loop is not present so we return 0.
            if( fast==null || fast.next==null ) 
            return 0;
            
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
            //incrementing the counter.
            size+=1;
        }
        //returning the length of the loop.
        return size;
    }
}

*/

/*
 * Given a singly linked list, find the middle of the linked list. For example, if the given linked list is 1->2->3->4->5 then the output should be 3. 
If there are even nodes, then there would be two middle nodes, we need to print the second middle element. For example, if the given linked list is 1->2->3->4->5->6 then the output should be 4. 

Method 1: Traverse the whole linked list and count the no. of nodes. Now traverse the list again till count/2 and return the node at count/2. 
Below is the implementation of the above approach:

// Java Program for the above approach
class GFG {

	Node head;

	//*Creating a new Node
	class Node {
		int data;
		Node next;
		public Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	//*Function to add a new Node
	public void pushNode(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	//*Displaying the elements in the list
	public void printNode()
	{
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("Null"+"\n");
	}

	//*Finding the length of the list.*
	public int getLen()
	{
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	///*Printing the middle element of the list.*
	public void printMiddle()
	{
		if (head != null) {
			int length = getLen();
			Node temp = head;
			int middleLength = length / 2;
			while (middleLength != 0) {
				temp = temp.next;
				middleLength--;
			}
			System.out.print("The middle element is ["
							+ temp.data + "]");
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		GFG list = new GFG();
		for (int i = 5; i >= 1; i--) {
			list.pushNode(i);
			list.printNode();
			list.printMiddle();
		}
	}
}

 

Output

5->NULL
The middle element is [5]
4->5->NULL
The middle element is [5]
3->4->5->NULL
The middle element is [4]
2->3->4->5->NULL
The middle element is [4]
1->2->3->4->5->NULL
The middle element is [3]
Time Complexity: O(n) where n is no of nodes in linked list

Auxiliary Space: O(1)

Method 2: Traverse linked list using two-pointers. Move one pointer by one and the other pointers by two. When the fast pointer reaches the end, the slow pointer will reach the middle of the linked list.

Below image shows how printMiddle function works in the code :

middle-of-a-given-linked-list-in-C-and-Java1

// Java program to find middle of linked list
class LinkedList
{
	Node head; // head of linked list

	//* Linked list node 
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

	//* Function to print middle of linked list 
	void printMiddle()
	{
		Node slow_ptr = head;
		Node fast_ptr = head;
		
			while (fast_ptr != null && fast_ptr.next != null)
			{
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
			System.out.println("The middle element is [" +
								slow_ptr.data + "] \n");
		
	}

	//* Inserts a new Node at front of the list. 
	public void push(int new_data)
	{
	/	/* 1 & 2: Allocate the Node &
	//			Put in the data
		Node new_node = new Node(new_data);

	/	/* 3. Make next of new Node as head 
		new_node.next = head;

	/	/* 4. Move the head to point to new Node
		head = new_node;
	}

	//* This function prints contents of linked list
	//starting from the given node 
	public void printList()
	{
		Node tnode = head;
		while (tnode != null)
		{
			System.out.print(tnode.data+"->");
			tnode = tnode.next;
		}
		System.out.println("NULL");
	}

	public static void main(String [] args)
	{
		LinkedList llist = new LinkedList();
		for (int i=5; i>0; --i)
		{
			llist.push(i);
			llist.printList();
			llist.printMiddle();
		}
	}
}

 

Output

5->NULL
The middle element is [5]
4->5->NULL
The middle element is [5]
3->4->5->NULL
The middle element is [4]
2->3->4->5->NULL
The middle element is [4]
1->2->3->4->5->NULL
The middle element is [3]
Time Complexity: O(N), As we are traversing the list only once.
Auxiliary Space: O(1), As constant extra space is used.


 */

/**
 * 
 * Detect loop

Given a linked list, check if the linked list has a loop or not. The below diagram shows a linked list with a loop. 



                      Linked List with Loop

Detect loop in a linked list using Hashing:
The idea is to insert the nodes in the hashmap and whenever a node is encountered that is already present in the hashmap then return true.

Follow the steps below to solve the problem:

Traverse the list individually and keep putting the node addresses in a Hash Table. 
At any point, if NULL is reached then return false 
If the next of the current nodes points to any of the previously stored nodes in  Hash then return true.
Below is the implementation of the above approach:

class Node {        
    constructor() { 
        this.data; 
        this.next = null;
    }              
                   
    setter(x) {    
        this.data=x;
    }              
}                  

function printlist(head){
    let curr = head;
    let string = "";
    do{
        string += curr.data + " ";
        curr=curr.next;
    }while(curr!==null);
    return string;
}

function isLoop(head) 
{ 
    let s = new Set(); 
    for(let curr=head;curr!==null;curr=curr.next) {  
        if (s.has(curr)) 
            return true; 
        s.add(curr); 
    } 
    return false; 
}


let head = new Node();
head.setter(10);
let temp1=new Node();
temp1.setter(20);
let temp2=new Node();
temp2.setter(30);
let temp3 = new Node();
temp3.setter(40);
let temp4 = new Node();
temp4.setter(40);
let temp5 = new Node();
temp5.setter(50);
let temp6 = new Node();
temp6.setter(60);
let temp7 = new Node();
temp7.setter(70);
head.next=temp1;
temp1.next=temp2;
temp2.next=temp3;
temp3.next=temp4;
temp4.next=temp5;
temp5.next=temp6;
temp6.next=temp7;
temp7.next= temp3;
if(isLoop(head)) {
    console.log("Loop");
} else {
    console.log("No Loop");
}
 

Output

Loop
Detect loop in a linked list by Marking visited nodes without modifying Node structure:
The idea is to point the current node of the linked list to a node which is created. Whenever a node’s next is pointing to that node it means loop is there.

Follow the steps below to solve the problem:

A temporary node is created. 
The next pointer of each node that is traversed is made to point to this temporary node. 
This way we are using the next pointer of a node as a flag to indicate whether the node has been traversed or not. 
Every node is checked to see if the next is pointing to a temporary node or not.
In the case of the first node of the loop, the second time we traverse it this condition will be true, hence we find that loop exists. 
If we come across a node that points to null then the loop doesn’t exist.
Below is the implementation of the above approach:

// Java program to return first node of loop
public class GFG {

	static class Node {
		int key;
		Node next;
	};

	static Node newNode(int key)
	{
		Node temp = new Node();
		temp.key = key;
		temp.next = null;
		return temp;
	}

	// A utility function to print a linked list
	static void printList(Node head)
	{
		while (head != null) {
			System.out.print(head.key + " ");
			head = head.next;
		}
		System.out.println();
	}

	// Function to detect first node of loop
	// in a linked list that may contain loop
	static boolean detectLoop(Node head)
	{

		// Create a temporary node
		Node temp = new Node();
		while (head != null) {

			// This condition is for the case
			// when there is no loop
			if (head.next == null) {
				return false;
			}

			// Check if next is already
			// pointing to temp
			if (head.next == temp) {
				return true;
			}

			// Store the pointer to the next node
			// in order to get to it in the next step
			Node next = head.next;

			// Make next point to temp
			head.next = temp;

			// Get to the next node in the list
			head = next;
		}

		return false;
	}

	// Driver code
	public static void main(String args[])
	{
		Node head = newNode(1);
		head.next = newNode(2);
		head.next.next = newNode(3);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(5);

		// Create a loop for testing(5 is pointing to 3) /
		head.next.next.next.next.next = head.next.next;

		boolean found = detectLoop(head);
		if (found)
			System.out.println("Loop Found");
		else
			System.out.println("No Loop");
	}
};


 

Output

Loop Found
Time complexity: O(N). Only one traversal of the loop is needed.
Auxiliary Space: O(1) 



Detect loop using floyd cycle detection

Detect loop in a linked list using Floyd’s Cycle-Finding Algorithm:
This algorithm is used to find a loop in a linked list. It uses two pointers one moving twice as fast as the other one. The faster one is called the faster pointer and the other one is called the slow pointer.

Follow the steps below to solve the problem:

Traverse linked list using two pointers.
Move one pointer(slow_p) by one and another pointer(fast_p) by two.
If these pointers meet at the same node then there is a loop. If pointers do not meet then the linked list doesn’t have a loop.
Illustration:

The below image shows how the detect loop function works in the code:


Implementation of Floyd’s Cycle-Finding Algorithm:  

// Java program to detect loop in a linked list

import java.io.*;

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

	void detectLoop()
	{
		Node slow_p = head, fast_p = head;
		int flag = 0;
		while (slow_p != null && fast_p != null
			&& fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			System.out.println("Loop Found");
		else
			System.out.println("No Loop");
	}

	/* Driver program to test above functions 
	public static void main(String args[])
	{
		LinkedList llist = new LinkedList();

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/*Create loop for testing 
		llist.head.next.next.next.next = llist.head;

		llist.detectLoop();
	}
}

 

Output

Loop Found
Time complexity: O(N), Only one traversal of the loop is needed.
Auxiliary Space: O(1). 
 * 
 * 
 * 
 * Detect and remove loop in linked list

Method using Floyd’s Cycle detection algorithm :

This method is also dependent on Floyd’s Cycle detection algorithm.
Detect Loop using Floyd’s Cycle detection algorithm and get the pointer to a loop node.
Count the number of nodes in the loop. Let the count be k.
Fix one pointer to the head and another to a kth node from the head.
Move both pointers at the same pace, they will meet at the loop starting node.
Get a pointer to the last node of the loop and make the next of it NULL.
 
Below image is a dry run of the ‘remove loop’ function in the code :



Below is the implementation of the above approach:

// Java program to detect and remove loop in linked list

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

	// Function that detects loop in the list
	int detectAndRemoveLoop(Node node)
	{
		Node slow = node, fast = node;
		while (slow != null && fast != null
			&& fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			// If slow and fast meet at same point then loop
			// is present
			if (slow == fast) {
				removeLoop(slow, node);
				return 1;
			}
		}
		return 0;
	}

	// Function to remove loop
	void removeLoop(Node loop, Node head)
	{
		Node ptr1 = loop;
		Node ptr2 = loop;

		// Count the number of nodes in loop
		int k = 1, i;
		Node prevNode = ptr1;
		while (ptr1.next != ptr2) {
			// keeping track beforeing moving next
			prevNode = ptr1;
			ptr1 = ptr1.next;
			k++;
		}
		prevNode.next = null;
	}

	// Function to print the linked list
	void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);

		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;
		list.detectAndRemoveLoop(head);
		System.out.println(
			"Linked List after removing loop : ");
		list.printList(head);
	}
}

 

Output

Linked List after removing loop 
50 20 15 4 10 
 * 
 * 
 * 
 * 
 * 
 */


/*
 * 
 * Delete node with only pointer given to it

A simple solution is to traverse the linked list until you find the node you want to delete. But this solution requires a pointer to the head node which contradicts the problem statement. 

The fast solution is to copy the data from the next node to the node to be deleted and delete the next node. Something like this:

It is important to note that this approach will only work if it is guaranteed that the given pointer does not point to the last node. Because if it is the last node, then you don’t have a next node to copy the data from.

struct Node *temp  = node_ptr->next;
node_ptr->data  = temp->data;
node_ptr->next  = temp->next;
free(temp);
Below is the implementation of the above code:

// Java program to del the node in
// which only a single pointer is
// known pointing to that node
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

	void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	void deleteNode(Node node)
	{
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		System.gc();
	}

	// Driver code
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.head.next = new Node(12);
		list.head.next.next = new Node(1);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(1);

		System.out.println("Before Deleting ");
		list.printList(head);

		/* I m deleting the head itself.
		You can check for more cases 
		list.deleteNode(head);
		System.out.println("");
		System.out.println("After deleting ");
		list.printList(head);
	}
}


 

Output

Before deleting 
1 12 1 4 1 
After deleting 
12 1 4 1 
Time complexity: O(1) since performing constant operations and modifying only single pointer to delete node

Auxiliary Space: O(1)


 * 
 * 
 */
