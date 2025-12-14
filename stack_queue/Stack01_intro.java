package stack_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
//Dont use stack below primitive 
//import java.util.Stack;


/**
 * STACK : 
 * Best with Linked List --> rather than list , array list , array etc ...
 * Linear Data Structure 
 * It acts like a box , insert n remove from one open end 
 * Insert operation - Push 
 * Remove operation for top element in the stack = Pop
 * 
 *  Operations of StacK :
 *  1) isEmpty() - true if stack s empty 
 *  2) push(element)- Insert an item to top
 *  3) Pop()- removes an element in the top 
 *  4) peek()- returns top element value 
 *  5) size ()- return size of stack
 * 
 *  
 *  Corner conditions for Stack:
 *  
 *  1) Underflow:
 *       When pop or peek called on empty stack  
 *  
 *  2) Overflow 
 *       When push called on full stack 
 *       
 * Stack - Java :
 *  Stack class in Java is a legacy class and inherits from Vector in Java. 
 *  It is a thread-safe class and hence involves overhead when we do not need thread safety.
 *  It is recommended to use ArrayDeque for stack implementation as
 *  it is more efficient in a single-threaded environment.
 *  Stack is supported by two class - Array Dequeue and Stack 
 *  Stack -extends--> Vector --implements--> List --extends------------|
 *                                                                     |--> Collection ---extends---> Iterator
 *  Array dequeue -extends--> Dequeue --implements--> Queue --extends--|                                                        
 *    <----- implements child-----
 *   
 * Array Dequeue should be used ..in a single threaded environment 
 * 
 *    
 * 
 * 
 * 
 * 
 * 
 * 
 * Applications of STACK:
 *  1) Function calls , recursion - stack memory .. line to continue after calls
 *    Call 1 C1 line 45 
 *    Next call C2 line 50
 *    Call C3 line 65 
 *    Call C3 ends first ---
 *    C2 -45 ends....
 *    Finally C1 45 line continues .. This memory stored in stack
 *    
 *  2) Balanced parenthesis
 *  3) Reversing items 
 *  3) Infix /Post fix /Prefix 
 *      Post and prefix - associativity , precedence does not matter 
 *      In fix - difficult for compiler to understand 
 *  4) Stock span problem and variants 
 *  5) Undo Re-do .. Forward Backward  
 *  
 *  
 *  Stack c++:
 *  Use Dequeue to build so called Container adapter 
 *  stack <int> varName;
 *  Internal working .. all functions O 1 
 *
 * @author shree
 *
 */

class STACK{
	int stack[];
	int capacity;
	int top;
	
	STACK(int c){
		capacity=c;
		top=-1;//No elements 
		stack=new int[c];
	}
	
	int peek() {
		if(top==-1) {
			System.out.println(" Empty stack .....");
			return -1;
		}
		return stack[top];
	}
	//Push 
	void push(int x) {
		top++;
		if(top<capacity) {		
			System.out.println(" top "+top);
			stack[top]=x;
		}
		else {
			top--;
			System.out.println(" No space .....");
		}
	}
	
	int pop() {
		if(top==-1) {
			System.out.println(" Empty stack ......");
			return -1;
		}
		int res=stack[top];
		top--;
		return res;
	}
	
	int size() {
		return top;

	}
	
	boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

class Dstack{
	ArrayList<Integer> list;
	int capacity;
	//int top;
	
	Dstack(){
		//capacity=c;
		list=new ArrayList<Integer>();
	}
	
	Dstack(int c){
		capacity=c;
		//top=-1;//No elements 
		list=new ArrayList<Integer>(c);
	}
	
	int peek() {
		if(list.isEmpty()) {
			System.out.println(" Empty stack .....");
			return -1;
		}
		return list.get(list.size()-1);
	}
	//Push 
	void push(int x) {
		list.add(x);
	}
	
	int pop() {
		if(list.isEmpty()) {
			System.out.println(" Empty stack ......");
			return -1;
		}
		int res=list.get(list.size()-1);
		list.remove(list.size()-1);
		return res;
	}
	
	int size() {
		return list.size()-1;

	}
	
	boolean isEmpty() {
		if((list.isEmpty())) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

class Lstack{
	LinkedList<Integer> list;
	int capacity;
	
	Lstack(){
		//capacity=c;
		list=new LinkedList<Integer>();
	}
	
	int peek() {
		if(list.isEmpty()) {
			System.out.println(" Empty stack .....");
			return -1;
		}
		return list.getFirst();
	}
	//Push 
	void push(int x) {
		list.addFirst(x);
	}
	
	int pop() {
		if(list.isEmpty()) {
			System.out.println(" Empty stack ......");
			return -1;
		}
		int res=list.getFirst();
		list.remove(0);
		return res;
	}
	
	int size() {
		return list.size();

	}
	
	boolean isEmpty() {
		if(list.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

class Node{
    int data;
    Node next;
    Node(int v){
    	data=v;
    	next=null;
    }
    Node(){
    	data=-1;
    	next=null;
    }
}

class NodeStack{
	int top;
	Node head;
	 NodeStack() {
	    top=-1;
		head=null;
	}
	 
	 // pop 
	 int pop() {
		 if(top==-1) {
			 System.out.println("bEmpty ....");
             return -1;
		 }
		 top--;
		 int res=head.data;
		 head=head.next;
		 return res;
	 }
	
	 // Push 
	 void push(int x) {
		 top++;
		 Node next=new Node(x);
		 next.next=head;
		 head=next;
		
	 }
	 
	 int size() {
		 return top;
	 }
	 
	 int peek() {
		 if(top==-1) {
			 System.out.println(" Empty ");
			// return -1;
		 }
		 return head.data;
	 }
	 
	 boolean isEmpty() {
		 if(top==-1) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 
	void display() {
	  Node temp=head;
	  while(temp!=null) {
		  System.out.print(temp.data+" ");
		  temp=temp.next;
	  }
	}
	
}
public class Stack01_intro {

	public static void main(String[] args) {
		// STACK
		// With array - O N 
		// With LL+size int - O 1
	
		
		STACK s=new STACK(5);
		System.out.println(" Empty is "+s.isEmpty());
		s.pop();
		s.push(0);System.out.print(s.peek());
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);System.out.print(s.peek());
		s.push(5);System.out.print(s.peek());
		s.push(6);System.out.print(s.peek());
		System.out.println(" Empty is "+s.isEmpty());
        System.out.println(" Size "+s.size());
        
        Dstack ds=new Dstack();
        System.out.println(" Empty is "+ds.isEmpty());
        ds.pop();
		ds.push(0);System.out.print(ds.peek());
		ds.push(1);
		ds.push(2);
		ds.push(3);
		ds.push(4);System.out.print(ds.peek());
		ds.push(5);System.out.print(ds.peek());
		ds.push(6);System.out.print(ds.peek());
		System.out.println(" Empty is "+ds.isEmpty());
        System.out.println(" Size "+ds.size());
        
        Lstack ls=new Lstack();
        System.out.println(" Empty is "+ls.isEmpty());
        ls.pop();
        ls.push(0);System.out.print(ls.peek());
        ls.push(1);
        ls.push(2);
		ls.push(3);
		ls.push(4);System.out.print(ls.peek());
		ls.push(5);System.out.print(ls.peek());
		ls.push(6);System.out.print(ls.peek());
		System.out.println(" Empty is "+ls.isEmpty());
        System.out.println(" Size "+ls.size());
        
        NodeStack ns=new NodeStack();
        System.out.println(" Empty is "+ns.isEmpty());
        ns.pop();
        ns.push(0);System.out.print(ns.peek());
        ns.push(1);
        ns.push(2);
		ns.push(3);
		ns.push(4);System.out.print(ns.peek());
		ns.push(5);System.out.print(ns.peek());
		ns.push(6);System.out.print(ns.peek());
		System.out.println(" Empty is "+ns.isEmpty());
        System.out.println(" Size "+ns.size());
        
        
      //  Stack<Integer> ss= new Stack<>();
        // Stack not advisable 
        // Threading 
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        // Amortized time complexity - O 1 
        // Amortized time complexity :
        //    Doing N operations and average time complexity of N operation is O N 
        //    However one among N operations one can be costly 
        System.out.println(" Empty is "+ad.isEmpty());
        try{
        ad.pop();
        }
        catch( Exception e){
        	System.out.println(" Error "+e);
        }
        finally {
        	System.out.println(" Passed ");
        }
        ad.push(0);System.out.print(ad.peek());
        ad.push(1);
        ad.push(2);
		ad.push(3);
		ad.push(4);System.out.print(ad.peek());
		ad.push(5);System.out.print(ad.peek());
		ad.push(6);System.out.print(ad.peek());
		System.out.println(" Empty is "+ad.isEmpty());
        System.out.println(" Size "+ad.size());
        
	}

}

/*
 *  Application of Stack Data Structure:

Stack is used for evaluating expression with operands and operations.
Matching tags in HTML and XML
Undo function in any text editor.
Infix to Postfix conversion.
Stacks are used for backtracking and parenthesis matching.
Stacks are used for conversion of one arithmetic notation to another arithmetic notation.
Stacks are useful for function calls, storing the activation records and deleting them after returning from the function. It is very useful in processing the function calls.
Stacks help in reversing any set of data or strings.
To manage recursion, stack data structure is used to account for the previous state of the recursion call.

Application of Stack in real life:

CD/DVD stand.
Stack of books in a book shop.
Undo and Redo mechanism in text editors.
The history of a web browser is stored in the form of a stack.
Call logs, E-mails, and Google photos in any gallery are also stored in form of a stack.
YouTube downloads and Notifications are also shown in LIFO format(the latest appears first ).

Advantages of Stack:

Stack helps in managing data that follows the LIFO technique.
Stacks are being used for systematic Memory Management.
It is used in many virtual machines like JVM.
When a function is called, the local variables and other function parameters are stored in the stack and automatically destroyed once returned from the function. Hence, efficient function management.
Stacks are more secure and reliable as they do not get corrupted easily.
Stack allows control over memory allocation and deallocation.
Stack cleans up the objects automatically.
Stacks are used to convert 
 * 
 * 
 * 
 */
/**
 * 
 * Stack Data Structure

Stack
It is a linear data structure that follows a particular order in which the operations are performed.

LIFO( Last In First Out ):

This strategy states that the element that is inserted last will come out first. You can take a pile of plates kept on top of each other as a real-life example. The plate which we put last is on the top and since we remove the plate that is at the top, we can say that the plate that was put last comes out first.

Basic Operations on Stack
In order to make manipulations in a stack, there are certain operations provided to us :- 

push() to insert an element into the stack
pop() to remove an element from the stack
top() Returns the top element of the stack.
isEmpty() returns true if stack is empty else false.
size() returns the size of stack.
 

Push:
Adds an item to the stack. If the stack is full, then it is said to be an Overflow condition.

Algorithm for push:

begin
 if stack is full
    return
 endif
else  
 increment top
 stack[top] assign value
end else
end procedure
Pop:
Removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack is empty, then it is said to be an Underflow condition.

Algorithm for pop:

begin
 if stack is empty
    return
 endif
else
 store value of stack[top]
 decrement top
 return value
end else
end procedure
Top:
Returns the top element of the stack.

Algorithm for Top:

begin 
  return stack[top]
end procedure
isEmpty:
Returns true if the stack is empty, else false.

Algorithm for isEmpty:

begin
 if top < 1
    return true
 else
    return false
end procedure
Understanding stack practically:
There are many real-life examples of a stack. Consider the simple example of plates stacked over one another in a canteen. The plate which is at the top is the first one to be removed, i.e. the plate which has been placed at the bottommost position remains in the stack for the longest period of time. So, it can be simply seen to follow the LIFO/FILO order.

Complexity Analysis:
Time Complexity
Operations  	Complexity
push() 	O(1)
pop()   	O(1)
isEmpty() 	O(1)
size()	O(1)
Types of Stacks:
Register Stack: This type of stack is also a memory element present in the memory unit and can handle a small amount of data only. The height of the register stack is always limited as the size of the register stack is very small compared to the memory.
Memory Stack: This type of stack can handle a large amount of memory data. The height of the memory stack is flexible as it occupies a large amount of memory data. 

 * 
 * 
 */

/*
 * Array Implementation of Stack

Below is the implementation of Stack using Array. For that we basically need to basically design our own stack class and include stack functionalities like push, pop, peek etc. 

 

/* Java program to implement basic stack
operations 
class Stack {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX]; // Maximum size of Stack

	boolean isEmpty()
	{
		return (top < 0);
	}
	Stack()
	{
		top = -1;
	}

	boolean push(int x)
	{
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			a[++top] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	int pop()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top--];
			return x;
		}
	}

	int peek()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top];
			return x;
		}
	}
	
	void print(){
	for(int i = top;i>-1;i--){
	System.out.print(" "+ a[i]);
	}
}
}

// Driver code
class Main {
	public static void main(String args[])
	{
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
		System.out.println("Top element is :" + s.peek());
		System.out.print("Elements present in stack :");
		s.print();
	}
}

Output
10 pushed into stack
20 pushed into stack
30 pushed into stack
30 Popped from stack
Top element is : 20
Elements present in stack : 20 10 
Advantages of array implementation:
Easy to implement.
Memory is saved as pointers are not involved. 
Disadvantages of array implementation:
It is not dynamic.
It doesn’t grow and shrink depending on needs at runtime.
We can implement dynamic size stack by using Vector in C++ and ArrayList in Java.


 * 
 */

/**
Linked List implementation of Stack

To implement a stack using the singly linked list concept, all the singly linked list operations should be performed based on Stack operations LIFO(last in first out) and with the help of that knowledge, we are going to implement a stack using a singly linked list. 

So we need to follow a simple rule in the implementation of a stack which is last in first out and all the operations can be performed with the help of a top variable. Let us learn how to perform Pop, Push, Peek, and Display operations in the following article:



In the stack Implementation, a stack contains a top pointer. which is the “head” of the stack where pushing and popping items happens at the head of the list. The first node has a null in the link field and second node-link has the first node address in the link field and so on and the last node address is in the “top” pointer.

The main advantage of using a linked list over arrays is that it is possible to implement a stack that can shrink or grow as much as needed. Using an array will put a restriction on the maximum capacity of the array which can lead to stack overflow. Here each new node will be dynamically allocated. so overflow is not possible.

Stack Operations: 
push(): Insert a new element into the stack i.e just insert a new element at the beginning of the linked list.
pop(): Return the top element of the Stack i.e simply delete the first element from the linked list.
peek(): Return the top element.
display(): Print all elements in Stack.
Push Operation:
Initialise a node
Update the value of that node by data i.e. node->data = data
Now link this node to the top of the linked list
And update top pointer to the current node
Pop Operation:
First Check whether there is any node present in the linked list or not, if not then return
Otherwise make pointer let say temp to the top node and move forward the top node by 1 step
Now free this temp node
Peek Operation:
Check if there is any node present or not, if not then return.
Otherwise return the value of top node of the linked list
Display Operation:
Take a temp node and initialize it with top pointer 
Now start traversing temp till it encounters NULL
Simultaneously print the value of the temp node
Below is the implementation of the above operations 

// Java program to Implement a stack
// using singly linked list
// import package
import static java.lang.System.exit;

// Driver code
class GFG {
	public static void main(String[] args)
	{
		// create Object of Implementing class
		StackUsingLinkedlist obj
			= new StackUsingLinkedlist();
		// insert Stack value
		obj.push(11);
		obj.push(22);
		obj.push(33);
		obj.push(44);

		// print Stack elements
		obj.display();

		// print Top element of Stack
		System.out.printf("\nTop element is %d\n",
						obj.peek());

		// Delete top element of Stack
		obj.pop();
		obj.pop();

		// print Stack elements
		obj.display();

		// print Top element of Stack
		System.out.printf("\nTop element is %d\n",
						obj.peek());
	}
}

// Create Stack Using Linked list
class StackUsingLinkedlist {

	// A linked list node
	private class Node {

		int data; // integer data
		Node link; // reference variable Node type
	}
	// create global top reference variable global
	Node top;
	// Constructor
	StackUsingLinkedlist() { this.top = null; }

	// Utility function to add an element x in the stack
	public void push(int x) // insert at the beginning
	{
		// create new node temp and allocate memory
		Node temp = new Node();

		// check if stack (heap) is full. Then inserting an
		// element would lead to stack overflow
		if (temp == null) {
			System.out.print("\nHeap Overflow");
			return;
		}

		// initialize data into temp data field
		temp.data = x;

		// put top reference into temp link
		temp.link = top;

		// update top reference
		top = temp;
	}

	// Utility function to check if the stack is empty or
	// not
	public boolean isEmpty() { return top == null; }

	// Utility function to return top element in a stack
	public int peek()
	{
		// check for empty stack
		if (!isEmpty()) {
			return top.data;
		}
		else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	// Utility function to pop top element from the stack
	public void pop() // remove at the beginning
	{
		// check for stack underflow
		if (top == null) {
			System.out.print("\nStack Underflow");
			return;
		}

		// update the top pointer to point to the next node
		top = (top).link;
	}

	public void display()
	{
		// check for stack underflow
		if (top == null) {
			System.out.printf("\nStack Underflow");
			exit(1);
		}
		else {
			Node temp = top;
			while (temp != null) {

				// print node data
				System.out.print(temp.data);

				// assign temp link to temp
				temp = temp.link;
				if(temp != null)
					System.out.print(" -> ");
			}
		}
	}
}

Output
44 -> 33 -> 22 -> 11
Top element is 44
22 -> 11
Top element is 22

Time Complexity: O(1), for all push(), pop(), and peek(), as we are not performing any kind of traversal over the list. We perform all the operations through the current pointer only.
Auxiliary Space: O(N), where N is the size of the stack


*/

/*

tack in C++ STL

The C++ STL offers a built-in class named stack for implementing the stack data structure easily and efficiently. This class provides almost all functions needed to perform the standard stack operations like push(), pop(), peek(), remove() etc..

Syntax:
 

stack< data_type > stack_name;

Here,
data_type: This defines the type of data to be 
           stored in the stack.
stack_name: This specifies the name of the stack.


Some Basic functions of Stack class in C++:
 

empty() – Returns whether the stack is empty.
size() – Returns the size of the stack.
top() – Returns a reference to the topmost element of the stack.
push(g) – Adds the element ‘g’ at the top of the stack.
pop() – Deletes the topmost element of the stack.

 

// CPP program to demonstrate working of STL stack 

#include <iostream> 
#include <stack> 

using namespace std; 
  
void showstack(stack <int> s) 
{ 
    while (!s.empty()) 
    { 
        cout << '\t' << s.top(); 
        s.pop(); 
    } 
    cout << '\n'; 
} 
  
int main () 
{ 
    stack <int> s; 
    s.push(10); 
    s.push(30); 
    s.push(20); 
    s.push(5); 
    s.push(1); 
  
    cout << "The stack is : "; 
    showstack(s); 
  
    cout << "\ns.size() : " << s.size(); 
    cout << "\ns.top() : " << s.top(); 
  
  
    cout << "\ns.pop() : "; 
    s.pop(); 
    showstack(s); 
  
    return 0; 
} 

Output
The stack is : 	1	5	20	30	10

s.size() : 5
s.top() : 1
s.pop() : 	5	20	30	10
 

Time Complexity and Internal Working of Stack
All the above Stack operations including push(), pop(), empty(), size(), top() have O(1) time complexity. How do they work internally??

Stack data structure can be implemented on top of any data structure that provide following operations:

back(), size(), empty(), push_back(), pop_back(). The three container which provide all these functionalities are List, deque and Vector, So stack container can be implemented using any of these three containers. By default it is implemented using deque container.

Since stack is implemented using other containers and acts as an interface, it is also known as the Container Adapter (which is a term in STL Language ). Other examples of container adapters can be queue and priority queue. All the operations like back(), size(), empty(), push_back(), pop_back() are implemented in O(1) time, So stack is guarenteed to take O(1) time complexity for all such operations.




*/

/**

Stack in Java Collection

Java Collection framework provides a Stack class which models and implements the Stack data structure. The class is based on the basic principle of last-in-first-out. In addition to the basic push and pop operations, the class provides three more functions of empty, search and peek. The class can also be said to extend Vector and treats the class as a stack with the five mentioned functions. The class can also be referred to as the subclass of Vector.

This diagram shows the hierarchy of Stack class:

The class supports one default constructor Stack() which is used to create an empty stack.

Below program shows a few basic operations provided by the Stack class:

// Java code for stack implementation

import java.io.*;
import java.util.*;

class Test
{   
    // Pushing element on the top of the stack
    static void stack_push(Stack<Integer> stack)
    {
        for(int i = 0; i < 5; i++)
        {
            stack.push(i);
        }
    }
    
    // Popping element from the top of the stack
    static void stack_pop(Stack<Integer> stack)
    {
        System.out.println("Pop :");

        for(int i = 0; i < 5; i++)
        {
            Integer y = (Integer) stack.pop();
            System.out.println(y);
        }
    }

    // Displaying element on the top of the stack
    static void stack_peek(Stack<Integer> stack)
    {
        Integer element = (Integer) stack.peek();
        System.out.println("Element on stack top : " + element);
    }
    
    // Searching element in the stack
    static void stack_search(Stack<Integer> stack, int element)
    {
        Integer pos = (Integer) stack.search(element);

        if(pos == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element is found at position " + pos);
    }

    public static void main (String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();

        stack_push(stack);
        stack_pop(stack);
        stack_push(stack);
        stack_peek(stack);
        stack_search(stack, 2);
        stack_search(stack, 6);
    }
}

Output
Pop :
4
3
2
1
0
Element on stack top : 4
Element is found at position 3
Element not found
 

Methods in Stack class:

Object push(Object element) : Pushes an element on the top of the stack.
Object pop() : Removes and returns the top element of the stack. An 'EmptyStackException' exception is thrown if we call pop() when the invoking stack is empty.
Object peek() : Returns the element on the top of the stack, but does not remove it.
boolean empty() : It returns true if nothing is on the top of the stack. Else, returns false.
int search(Object element) : It determines whether an object exists in the stack. If the element is found, it returns the position of the element from the top of the stack. Else, it returns -1.
Note: Please note that the Stack class in Java is a legacy class and inherits from Vector in Java. It is a thread-safe class and hence involves overhead when we do not need thread safety. It is recommended to use ArrayDeque for stack implementation as it is more efficient in a single-threaded environment.


**/