package stack_queue;

/**
 *  Stack with getMin at O 1
 * 
 * design a Stack that can implement the regular stack operations ie. push( ), pop( ), isEmpty( ), size( ) etc. 
 * along with the getMin( ) operation ( to fetch minimum element present in the stack) efficiently. 
 * We will first look at a Naive approach for doing this, followed by an Efficient Approach using an auxilary stack.
 * 
 * Steps :
 *  Use a auxillary stack 
 *  Put the min if min is less than or EQUAL to top of stack 
 *  Remove from aux stack if popped element is same as aux top element 
 *   
 * Stack with getMin at O 1 - O 1 space 
 * For positive only   
 * Steps :
 *   Use min variable 
 *   When ever you find a lesser value than min 
 *     NegativeMin = CurrMinValue - StackMinValue 
 *   In actual stack push the negative min value , update min as Curr Min value 
 *   When ever negative value is encountered in stack , use min instead 
 *   And set min value as = CurrMinValue -NegativeValue 
 *   
 *   Ex) push --> 5 10 20 200 2 76 45 31 
 *   Min value till 200 : 5 
 *   At push 2 : 
 *       Negative= val-min = 2 -5 = -3
 *   Push -3 in stackk 
 *   Min value = 2 
 *   
 *   On popping --> 31 45 76 -3 200 20 10 5
 *   At -3 ,
 *     Return min value - 2 
 *     Min= min - negative val
 *        = 2- (-3)
 *        Min=5 ..Continue 
 *        
 * Stack with getMin at O 1 - O 1 space 
 * For positive and negative   
 * Steps :
 *   Use min variable 
 *   When ever you find a lesser value than min 
 *     NegativeMin = 2*CurrMinValue - StackMinValue 
 *   In actual stack push the negative min value , update min as Curr Min value 
 *   When ever negative value is encountered in stack , use min instead 
 *   And set min value as = 2*CurrMinValue -NegativeValue 
 *   
 *   Ex) push --> 5 10 20 200 2 76 45 31 
 *   Min value till 200 : 5 
 *   At push 2 : 
 *       Negative= val-min = 2*2 -5 = -1
 *   Push -1 in stack 
 *   Min value = 2 
 *   
 *   On popping --> 31 45 76 -1 200 20 10 5
 *   At -1 ,
 *     Return min value - 2 
 *     Min= 2*min - negative val
 *        = 4- (-1)
 *        Min=5 ..Continue 
 *        
 * How 2*x – minEle is less than x in push()? 

x < minEle which means x – minEle < 0
 

// Adding x on both sides
x – minEle + x < 0 + x 
2*x – minEle < x 
We can conclude 2*x – minEle < new minEle 

While popping out, if we find the element(y) less than the current minEle, we find the new minEle = 2*minEle – y

How previous minimum element, prevMinEle is, 2*minEle – y
in pop() is y the popped element?

 // We pushed y as 2x – prevMinEle. Here 
// prevMinEle is minEle before y was inserted

y = 2*x – prevMinEle  

// Value of minEle was made equal to x
minEle = x .

new minEle = 2 * minEle – y 
                   = 2*x – (2*x – prevMinEle)
                   = prevMinEle // This is what we wanted
 * 
 * @author shree
 *
 */
class NodeMin2{
	int data;
	int min;
	NodeMin next;
	NodeMin2(){
		data=0;
		next=null;
		min=0;
	}
	NodeMin2(int val,int min){
		data=val;
		next=null;
		// Without this it takes value of class min=0;
		//min=min;
		// With above min will be zero 
		// If even one this was used in the scope 
		// Compiler will consider of the object and others as class
		// If no this keyword given --> blindly consider all as class min=0
		if(min==0) {
			System.out.println(" Min 0");
		}
		this.min=min;
	}
}

class NodeMin{
	int data;
	NodeMin next;
	NodeMin(){
		data=0;
		next=null;
	}
	NodeMin(int val){
		data=val;
		next=null;
	}
}
class StackONSpace{
	NodeMin head;
	NodeMin auxHead;
	int count;
	StackONSpace(){
		count=-1;
	}
	
	void push(int val) {
		NodeMin next=new NodeMin(val);
		next.next=head;
		head=next;
		count++;
		// Aux 
		if(auxHead==null) {
			NodeMin next2=new NodeMin(val);
			next2.next=auxHead;
			auxHead=next2;
			
		}
		else if(auxHead.data>=val) {
			NodeMin next2=new NodeMin(val);
			next2.next=auxHead;
			auxHead=next2;
		}
	}
	
	int pop() {
		count--;
		if(count==-1) {
			System.out.println(" Empty stack ");
			return -1;
		}
		int res=head.data;
		head=head.next;
		//Aux
		if(auxHead.data==res) {
			auxHead=auxHead.next;
		}
		
		return res;
	}
	
	int getMin() {
		if(auxHead==null) {
			System.out.println(" Over flow ");
			return -1;
		}
		if(count==-1) {
			System.out.println(" Empty stack ");
			return -1;
		}
		return auxHead.data;
	}
	
	
}

class StackO1PositiveSpace{
	//Only for positive data 
	NodeMin head;
	int min;
	int count;
	StackO1PositiveSpace(){
		count=0;min=-1;
	}
	
	void push(int val) {
		
		// Aux 
		if(min==-1) {
			min=val;
		}
		else if(min>val) {
			int val2=val;
			val=val2-min;
			min=val2;
		}
		NodeMin next=new NodeMin(val);
		next.next=head;
		head=next;
		count++;
	}
	
	int pop() {
		count--;
		if(count==-1) {
			System.out.println(" Empty stack ");
			return -1;
		}
		
		
		int res=head.data;
		head=head.next;
		
		//Aux
		int val=res;
		if(res<0) {
			val=min;
			min=min-res;
		}
		
		return (val);
	}
	
	int getMin() {
		if(min==-1) {
			System.out.println(" Over flow ");
		}
		if(count==-1) {
			System.out.println(" Empty stack ");
			return -1;
		}
		return min;
	}
	
	
}

class StackO1AllSpace{
	//For all data 
	NodeMin head;
	int min;
	int count;
	boolean notSet;
	StackO1AllSpace(){
		count=0;min=-1;
		notSet=true;
	}
	
	void push(int val) {
		// Aux 
		if (notSet) {
			min = val;
			notSet=false;
		} 
		else if (min >= val) {
			int val2=val;
			// new Min will be <= min 
			// val is less than <min 
			val = (2 * val2) - min;
			min=val2;
		}
		NodeMin next=new NodeMin(val);
		next.next=head;
		head=next;
		count++;
		
	}
	
	int pop() {
		count--;
		if(count==-1) {
			System.out.println(" Empty stack ");
			return -1;
		}
		int val=head.data;
		head=head.next;
		int res=val;
		//Aux
		if(res<=0) {
			res=min;
			min=(2*min)-val;
		}
		return (res);
	}
	
	int getMin() {
		if(notSet) {
			System.out.println(" Over flow ");
		}
		
		if(count==-1) {
			System.out.println(" Empty stack ");
			return -1;
		}
		return min;
	}
	
	
}

public class Stack08_Min_InStack_O1 {

	public static void main(String[] args) {
		
		StackONSpace sn=new StackONSpace();
		StackO1PositiveSpace sp=new StackO1PositiveSpace();
		StackO1AllSpace sa=new StackO1AllSpace();
		
		
		for(int i=5;i<10;i++) {
			sn.push(i);
			sp.push(i);
			sa.push(i);
		}
		
		System.out.println(" Get min sn "+sn.getMin());
		System.out.println(" Get min sp "+sp.getMin());
		System.out.println(" Get min sa "+sa.getMin());
		
		sn.push(2);
		sp.push(2);
		sa.push(2);
		for(int i=15;i<20;i++) {
			sn.push(i);
			sp.push(i);
			sa.push(i);
		}
		System.out.println(" Get min sn "+sn.getMin());
		System.out.println(" Get min sp "+sp.getMin());
		System.out.println(" Get min sa "+sa.getMin());
		for(int i=0;i<10;i++) {
			sn.pop();
			sp.pop();
			sa.pop();
		}
		System.out.println(" Get min sn "+sn.getMin());
		System.out.println(" Get min sp "+sp.getMin());
		System.out.println(" Get min sa "+sa.getMin());
		
		for(int i=0;i<2;i++) {
			sn.pop();
			sp.pop();
			sa.pop();
		}
		System.out.println(" Get min sn "+sn.getMin());
		System.out.println(" Get min sp "+sp.getMin());
		System.out.println(" Get min sa "+sa.getMin());
		
		
		NodeMin2 mi=new NodeMin2(50,-5);
		System.out.println(" Dtaa "+mi.data+" Min "+mi.min);

	}

}

/**

Stack with getMin() in O(1)

Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack must have a time and space complexity of O(1). 
Note: To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, lists, etc

Example: 

Input: Consider the following SpecialStack

16  –> TOP
15
29
19
18

 

When getMin() is called it should return 15, 
which is the minimum element in the current stack. 

If we do pop two times on stack, the stack becomes

29  –> TOP
19
18

When getMin() is called, it should return 18 
which is the minimum in the current stack.

 

Approach: To solve the problem follow the below idea:

We define a variable minEle that stores the current minimum element in the stack. Now the interesting part is, how to handle the case when the minimum element is removed. To handle this, we push “2x – minEle” into the stack instead of x so that the previous minimum element can be retrieved using the current minEle and its value stored in the stack

Follow the given steps to implement the stack operations:

Push(x): Insert x at the top of the stack

If the stack is empty, insert x into the stack and make minEle equal to x.
If the stack is not empty, compare x with minEle. Two cases arise:
If x is greater than or equal to minEle, simply insert x.
If x is less than minEle, insert (2*x – minEle) into the stack and make minEle equal to x. 
For example, let the previous minEle be 3. Now we want to insert 2. We update minEle as 2 and insert 2*2 – 3 = 1 into the stack
Pop(): Removes an element from the top of the stack

Remove the element from the top. Let the removed element be y. Two cases arise:
If y is greater than or equal to minEle, the minimum element in the stack is still minEle.
If y is less than minEle, the minimum element now becomes (2*minEle – y), so update (minEle = 2*minEle – y). This is where we retrieve the previous minimum from the current minimum and its value in the stack. 
For example, let the element to be removed be 1 and minEle be 2. We remove 1 and update minEle as 2*2 – 1 = 3
Important Points: 

Stack doesn’t hold the actual value of an element if it is minimum so far.
The actual minimum element is always stored in the minEle variable
Below is the illustration of the above approach:

Push(x) 

stack_insert 

Number to be Inserted: 3, Stack is empty, so insert 3 into stack and minEle = 3.
Number to be Inserted: 5, Stack is not empty, 5> minEle, insert 5 into stack and minEle = 3.
Number to be Inserted: 2, Stack is not empty, 2< minEle, insert (2*2-3 = 1) into stack and minEle = 2.
Number to be Inserted: 1, Stack is not empty, 1< minEle, insert (2*1-2 = 0) into stack and minEle = 1.
Number to be Inserted: 1, Stack is not empty, 1 = minEle, insert 1 into stack and minEle = 1.
Number to be Inserted: -1, Stack is not empty, -1 < minEle, insert (2*-1 – 1 = -3) into stack and minEle = -1.
Pop() 

stack_removal 

Initially the minimum element minEle in the stack is -1.
Number removed: -3, Since -3 is less than the minimum element the original number being removed is minEle which is -1, and the new minEle = 2*-1 – (-3) = 1
Number removed: 1, 1 == minEle, so number removed is 1 and minEle is still equal to 1.
Number removed: 0, 0< minEle, original number is minEle which is 1 and new minEle = 2*1 – 0 = 2.
Number removed: 1, 1< minEle, original number is minEle which is 2 and new minEle = 2*2 – 1 = 3.
Number removed: 5, 5> minEle, original number is 5 and minEle is still 3
Below is the implementation of the above approach:

// Java program to implement a stack that supports
// getMinimum() in O(1) time and O(1) extra space.
import java.util.*;

// A user defined stack that supports getMin() in
// addition to push() and pop()
class MyStack {
	Stack<Integer> s;
	Integer minEle;

	// Constructor
	MyStack() { s = new Stack<Integer>(); }

	// Prints minimum element of MyStack
	void getMin()
	{
		// Get the minimum number in the entire stack
		if (s.isEmpty())
			System.out.println("Stack is empty");

		// variable minEle stores the minimum element
		// in the stack.
		else
			System.out.println("Minimum Element in the "
							+ " stack is: " + minEle);
	}

	// prints top element of MyStack
	void peek()
	{
		if (s.isEmpty()) {
			System.out.println("Stack is empty ");
			return;
		}

		Integer t = s.peek(); // Top element.

		System.out.print("Top Most Element is: ");

		// If t < minEle means minEle stores
		// value of t.
		if (t < minEle)
			System.out.println(minEle);
		else
			System.out.println(t);
	}

	// Removes the top element from MyStack
	void pop()
	{
		if (s.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		System.out.print("Top Most Element Removed: ");
		Integer t = s.pop();

		// Minimum will change as the minimum element
		// of the stack is being removed.
		if (t < minEle) {
			System.out.println(minEle);
			minEle = 2 * minEle - t;
		}

		else
			System.out.println(t);
	}

	// Insert new number into MyStack
	void push(Integer x)
	{
		if (s.isEmpty()) {
			minEle = x;
			s.push(x);
			System.out.println("Number Inserted: " + x);
			return;
		}

		// If new number is less than original minEle
		if (x < minEle) {
			s.push(2 * x - minEle);
			minEle = x;
		}

		else
			s.push(x);

		System.out.println("Number Inserted: " + x);
	}
};

// Driver Code
public class Main {
	public static void main(String[] args)
	{
		MyStack s = new MyStack();
	
		// Function calls
		s.push(3);
		s.push(5);
		s.getMin();
		s.push(2);
		s.push(1);
		s.getMin();
		s.pop();
		s.getMin();
		s.pop();
		s.peek();
	}
}

Output
Number Inserted: 3
Number Inserted: 5
Minimum Element in the stack is: 3
Number Inserted: 2
Number Inserted: 1
Minimum Element in the stack is: 1
Top Most Element Removed: 1
Minimum Element in the stack is: 2
Top Most Element Removed: 2
Top Most Element is: 5
 

How does this approach work? 
When the element to be inserted is less than minEle, we insert “2x – minEle”. The important thing to note is, that 2x – minEle will always be less than x (proved below), i.e., new minEle and while popping out this element we will see that something unusual has happened as the popped element is less than the minEle. So we will be updating minEle.

 
How 2*x – minEle is less than x in push()? 

x < minEle which means x – minEle < 0
 

// Adding x on both sides
x – minEle + x < 0 + x 
2*x – minEle < x 
We can conclude 2*x – minEle < new minEle 

While popping out, if we find the element(y) less than the current minEle, we find the new minEle = 2*minEle – y

How previous minimum element, prevMinEle is, 2*minEle – y
in pop() is y the popped element?

 // We pushed y as 2x – prevMinEle. Here 
// prevMinEle is minEle before y was inserted

y = 2*x – prevMinEle  

// Value of minEle was made equal to x
minEle = x .

new minEle = 2 * minEle – y 
                   = 2*x – (2*x – prevMinEle)
                   = prevMinEle // This is what we wanted

 
Design a stack that supports getMin() in O(1) time and O(1) extra space by creating a MinStack class:
To solve the problem follow the below idea:

 

Create a class node that has two variables Val and min.  Val will store the actual value that we are going to insert in the stack, whereas min will store the min value so far seen up to that node

Below is the implementation of the above approach:

// Java program for the above approach

import java.io.*;
import java.util.*;
class MinStack {
	Stack<Node> s;

	class Node {
		int val;
		int min;
		public Node(int val, int min)
		{
			this.val = val;
			this.min = min;
		}
	}

	//** initialize your data structure here. 
	public MinStack() { this.s = new Stack<Node>(); }
	public void push(int x)
	{
		if (s.isEmpty()) {
			this.s.push(new Node(x, x));
		}
		else {
			int min = Math.min(this.s.peek().min, x);
			this.s.push(new Node(x, min));
		}
	}
	public int pop() { return this.s.pop().val; }
	public int top() { return this.s.peek().val; }
	public int getMin() { return this.s.peek().min; }
}

// Driver code
class GFG {

	public static void main(String[] args)
	{
		MinStack s = new MinStack();
	
		// Function calls
		s.push(-1);
		s.push(10);
		s.push(-4);
		s.push(0);
		System.out.println(s.getMin());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.getMin());
	}
}

Output
-4
0
-4
-1

*/