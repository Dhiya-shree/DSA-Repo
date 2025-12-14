package stack_queue;

//import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Problem #1 : Delete element in middle of stack Create temp stack Cop element
 * till middle Pop middle Copy back elements
 * 
 * Problem #2: Balanced Parenthesis
 * 
 * Parenthesis - () {} [] { ( ) } - yes correct [ ( ] ) - No not correct ..(
 * opened before but closes later ) [[ ( ) ] - No not closed
 * 
 * Use Stack LIFO
 * 
 * Traverse string If open bracket push in stack If close bracket : If sc is
 * empty --> return false; If sc.pop== open of close --> continue If not - false
 * return true if stack is empty
 * 
 * 
 * Problem #3 : Removing consecutive duplicates
 * 
 * You are given string str. You need to remove the consecutive duplicates from
 * the given string using a Stack
 * 
 * 
 * Problem #4 : Remove consecutive duplicates
 * 
 * You are given string str. You need to remove the pair of duplicates. Note:
 * The pair should be of adjacent elements and after removing a pair the
 * remaining string is joined together.
 * 
 * Example 1:
 * 
 * Input: aaabbaaccd
 * 
 * Output: ad
 * 
 * Explanation: Remove (aa)abbaaccd =>abbaaccd 
 * Remove a(bb)aaccd => aaaccd
 * Remove (aa)accd => accd
 * Remove a(cc)d => ad
 * 
 * 
 *  Problem #5 : Implement two stacks in a array
 *  
 *  Method 1 : Divide the space into two half
 *  An array of 100 spaces 
 *  Use 0 to 49 for stack 1 top=-1;
 *  Use 49 to 100 for stack 2 top=50
 *  
 *  Disadvantage : both stack can have only 50 elements
 *  
 *  Method 2 : Space efficient method 
 *  Stack1 can have 75 elements and Stack2 25 elements 
 *  
 *  Use top=0 for stack 1
 *  Use top=100 for stack 2 
 *  
 *  Stack 1 -- increment and stack2 -- decrement
 *  
 *  
 *  
 *  
 * 
 * @author shree
 *
 */

class TwoStack{
   
	int oneArray[];
	int top1;
	int top2;
	int capacity;
	int element;
	
	TwoStack(int c){
		capacity=c;
		oneArray=new int[c];
		top1=-1;
		top2=c;
	}
	
	void push1(int val) {
		top1=top1+1;
		if(top1<top2) {
			oneArray[top1]=val;
		}
		else {
			top1=top1-1;
			System.out.println(" Max limit stack1 reove from stack2 to continue...");
		}
		
	}
	
	void push2(int val) {
		top2=top2-1;
		if(top1<top2) {
			oneArray[top2]=val;
		}
		else {
			top2=top2+1;
			System.out.println(" Max limit stack2 reove from stack1 to continue...");
		}
		
	}
	
	int peek1() {
		
		if(top1==-1) {
			System.out.println(" Empty stack ");
			return -1;
		}
		else {
			
			return oneArray[top1];
		}
	}
	
    int peek2() {
		
		if(top2==capacity) {
			System.out.println(" Empty stack ");
			return -1;
		}
		else {
			return oneArray[top2];
		}
	}
	
    int pop1() {
		
		if(top1==-1) {
			System.out.println(" Empty stack ");
			return -1;
		}
		else {
			element=oneArray[top1];
			top1--;
			return element;
		}
	}
    
     int pop2() {
		
		if(top2==capacity) {
			System.out.println(" Empty stack ");
			return -1;
		}
		else {
			element=oneArray[top2];
			top2++;
			return element;
		}
	} 
     
     int size1(){

 		if(top1==-1) {
 			System.out.println(" Empty stack ");
 			return -1;
 		}
 		else {
 			return top1+1;
 		}
     }
     
     int size2() {
    	 if(top2==capacity) {
 			System.out.println(" Empty stack ");
 			return -1;
 		}
 		else {
 			
 			return (capacity-top2);
 		}
     }
	
}
public class Stack02basics {

	public static void main(String[] args) {

		String Str=" Hello (bdh[jhdw{jgdjk}bcjg]jsgfd[js]gkd)(";
		boolean anb=BalancedParenthesis(Str);
		System.out.println(" Balnced is "+anb);
		
		
	 Stack<Integer> ad= new Stack<>();
        // Stack not advisable 
        // Threading 
     //   ArrayDeque<Integer> ad=new ArrayDeque<>();
        // Amortized time complexity - O 1 
        // Amortized time complexity :
        //    Doing N operations and average time complexity of N operation is O N 
        //    However one among N operations one can be costly 
        System.out.println(" Empty is "+ad.isEmpty());
        ad.push(0);
        ad.push(1);
        ad.push(1);
		ad.push(1);
		ad.push(4);
		ad.push(5);
		//ad.push(6);
		System.out.println(" Empty is "+ad.isEmpty());
        System.out.println(" Size "+ad.size());
        
        ad=DeleteMiddle(ad,ad.size());
        System.out.println(" AFter deletion "+ad.toString());

        
        String dupe="aaabbbbbccccaaabbbccgggssskkkkks";
        String ans=RemoveDupli(dupe);
        System.out.println(" After remove conse duplicates "+ans);
	}

	private static String RemoveDupli(String str) {
		  // Your code here
        Stack<Character> sc=new Stack<>();
        int size=str.length();
        if(size==1){
            return str;
        }
        boolean Norepeat=true;
        char st=str.charAt(size-1);
        sc.push(st);
        for(int i=size-2;i>=0;i--){
            st=str.charAt(i);
            if(sc.peek()==st){
                Norepeat=false;
                continue;
            }
            sc.push(st);
        }
        if(Norepeat){
            return str;
        }
        System.out.println(sc.toString());
        System.out.println(sc.pop());
        StringBuffer sb=new StringBuffer();
        System.out.println(sb.toString());
        size=sc.size();
        while(size>0){
            sb.append(sc.pop());
            size--;
        }
        
        return sb.toString();
	}

	private static boolean BalancedParenthesis(String str) {
		// Balanced parenthesis 
		int size=str.length();
		char bracket;
		char close1=')';
		char close2=']';
		char close3='}';
		char open1='(';
		char open2='[';
		char open3='{';
		
		Stack<Character> sc=new Stack<>();
		// Put open bracket in stack 
		// If close bracket 
		// Check if top of stack 
		//  If top - pop the top 
		//  If no - return false 
	for(int i=0;i<size;i++) {
			bracket=str.charAt(i);
			
			// If open push in stackk
			if(bracket==open1 ||				
			bracket==open2 ||			
			bracket==open3 ) {
				sc.push(bracket);
				System.out.println(" Brackets "+sc.toString());
			}
			
			if(bracket==close1 ||				
					bracket==close2 ||			
					bracket==close3 ) {
				
		    // If sc empty return false 
		    if(sc.isEmpty()) {
		    	return false;
		    }
			//If close
			if(bracket==close1) {
				if(sc.peek()==open1) {
					sc.pop();
				}
				else {
					return false;
				}
			}
			else if(bracket==close2) {
				if(sc.peek()==open2) {
					sc.pop();
				}
				else {
					return false;
				}
			}
			else if(bracket==close3 ) {
				if(sc.peek()==open3) {
					sc.pop();
				}
				else {
					return false;
				}
				
			}
			
			}
			
		}
	//	System.out.println(" Brackets "+sc.toString());
		System.out.println(" Empty is "+sc.isEmpty());
		
	System.out.println(" Stack must be empty after push and pop ");
	   return sc.isEmpty();
	}

	private static Stack<Integer> DeleteMiddle(Stack<Integer>s,int sizeOfStack){
        // code here
		int mid=0;
		if(sizeOfStack%2!=0) {
        mid=(int) Math.floor((sizeOfStack+1)/2)-1;}
		else {
			 mid=(int) Math.floor((sizeOfStack+1)/2);
		}
		// middle= Middle element:- floor((size_of_stack+1)/2) (1-based indexing) from bottom of the stack.
		
		Stack<Integer> temp=new Stack<Integer>();
		int mid2=mid;int ele=0;
		while(mid2>0) {
			ele=s.pop();
			temp.push(ele);
			mid2--;
		}
		s.pop();
		while(mid>0 && !temp.isEmpty()) {
			ele=temp.pop();
			s.push(ele);
			mid--;
		}
		
		return s;
	}

}

/**
 * 
 * Balanced Parenthesis

Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in the given expression.

Example: 

Input: exp = “[()]{}{[()()]()}” 
Output: Balanced
Explanation: all the brackets are well-formed

Input: exp = “[(])” 
Output: Not Balanced 
Explanation: 1 and 4 brackets are not balanced because 
there is a closing ‘]’ before the closing ‘(‘

Check for Balanced Bracket expression using Stack:
The idea is to put all the opening brackets in the stack. Whenever you hit a closing bracket, search if the top of the stack is the opening bracket of the same nature. If this holds then pop the stack and continue the iteration, in the end if the stack is empty, it means all brackets are well-formed . Otherwise, they are not balanced.

Illustration: 
Below is the illustration of the above approach.



Follow the steps mentioned below to implement the idea:

Declare a character stack (say temp).
Now traverse the string exp. 
If the current character is a starting bracket ( ‘(‘ or ‘{‘  or ‘[‘ ) then push it to stack.
If the current character is a closing bracket ( ‘)’ or ‘}’ or ‘]’ ) then pop from stack and if the popped character is the matching starting bracket then fine.
Else brackets are Not Balanced.
After complete traversal, if there is some starting bracket left in stack then Not balanced, else Balanced.
Below is the implementation of the above approach:

// Java program for checking
// balanced brackets
import java.util.*;

public class BalancedBrackets {

	// function to check if brackets are balanced
	static boolean areBracketsBalanced(String expr)
	{
		// Using ArrayDeque is faster than using Stack class
		Deque<Character> stack
			= new ArrayDeque<Character>();

		// Traversing the Expression
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				// Push the element in the stack
				stack.push(x);
				continue;
			}

			// If current character is not opening
			// bracket, then it must be closing. So stack
			// cannot be empty at this point.
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (stack.isEmpty());
	}

	// Driver code
	public static void main(String[] args)
	{
		String expr = "([{}])";

		// Function call
		if (areBracketsBalanced(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}
}

Output
Balanced
Time Complexity: O(N), Iteration over the string of size N one time.
Auxiliary Space: O(N) for stack. 


 * 
 * 
 */
/*
 * mplement two Stacks in an Array

Create a data structure twoStacks that represent two stacks. Implementation of twoStacks should use only one array, i.e., both stacks should use the same array for storing elements. 

Following functions must be supported by twoStacks.

push1(int x) --> pushes x to first stack 
push2(int x) --> pushes x to second stack
pop1() --> pops an element from first stack and return the popped element 
pop2() --> pops an element from second stack and return the popped element
Implementation of twoStack should be space efficient.

Implement two stacks in an array by Dividing the space into two halves:
The idea to implement two stacks is to divide the array into two halves and assign two halves to two stacks, i.e., use arr[0] to arr[n/2] for stack1, and arr[(n/2) + 1] to arr[n-1] for stack2 where arr[] is the array to be used to implement two stacks and size of array be n. 

Follow the steps below to solve the problem:

To implement push1():
First, check whether the top1 is greater than 0 
If it is then add an element at the top1 index and decrement top1 by 1
Else return Stack Overflow
To implement push2():
First, check whether top2 is less than n - 1
If it is then add an element at the top2 index and increment the top2 by 1
Else return Stack Overflow
To implement pop1():
First, check whether the top1 is less than or equal to n / 2
If it is then increment the top1 by 1 and return that element.
Else return Stack Underflow
To implement pop2():
First, check whether the top2 is greater than or equal to (n + 1) / 2
If it is then decrement the top2 by 1 and return that element.
Else return Stack Underflow
Below is the implementation of the above approach.

import java.util.*;

class twoStacks {
    int[] arr;
    int size;
    int top1, top2;

    // Constructor
    twoStacks(int n)
    {
        size = n;
        arr = new int[n];
        top1 = n / 2 + 1;
        top2 = n / 2;
    }

    // Method to push an element x to stack1
    void push1(int x)
    {

        // There is at least one empty
        // space for new element
        if (top1 > 0) {
            top1--;
            arr[top1] = x;
        }
        else {
            System.out.println("Stack Overflow"
                             + " By element : " + x);
            return;
        }
    }

    // Method to push an element
    // x to stack2
    void push2(int x)
    {

        // There is at least one empty
        // space for new element
        if (top2 < size - 1) {
            top2++;
            arr[top2] = x;
        }
        else {
            System.out.println("Stack Overflow"
                             + " By element : " + x);
            return;
        }
    }

    // Method to pop an element from first stack
    int pop1()
    {
        if (top1 <= size / 2) {
            int x = arr[top1];
            top1++;
            return x;
        }
        else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
        return 0;
    }

    // Method to pop an element
    // from second stack
    int pop2()
    {
        if (top2 >= size / 2 + 1) {
            int x = arr[top2];
            top2--;
            return x;
        }
        else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
        return 1;
    }
};
class GFG {

    //* Driver program to test twoStacks class 
    public static void main(String[] args)
    {
        twoStacks ts = new twoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack1 is "
                         + ": " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack2 is "
                         + ": " + ts.pop2());
    }
}

// This code is contributed by aashish1995

Output
Stack Overflow By element : 7
Popped element from stack1 is : 11
Stack Overflow By element : 40
Popped element from stack2 is : 15
Time Complexity: 

Both Push operation: O(1)
Both Pop operation: O(1)
Auxiliary Space: O(N), Use of array to implement stack.

Problem in the above implementation:
The problem in the above implementation is that as we reserve half of the array for a stack and another half for the another stack. So, let if 1st half is full means first stack already have n/2 numbers of elements and 2nd half is not full means it doesn't have n/2 numbers of elements. So, if we look into the array, there are free spaces inside array(eg. in the next half) but we cannot push elements for stack 1(because first half is reserved for stack 1 and it's already full). It means this implementation show stack overflow although the array is not full. The solution for this answer is the below implementation.

 

Implement two stacks in an array by Starting from endpoints:
The idea is to start two stacks from two extreme corners of arr[]. 

Follow the steps below to solve the problem:

Stack1 starts from the leftmost corner of the array, the first element in stack1 is pushed at index 0 of the array. 
Stack2 starts from the rightmost corner of the array, the first element in stack2 is pushed at index (n-1) of the array. 
Both stacks grow (or shrink) in opposite directions. 
To check for overflow, all we need to check is for availability of space between top elements of both stacks.
To check for underflow, all we need to check is if the value of the top of the both stacks  is between 0 to (n-1) or not.
Below is the implementation of above approach:

// Java program to implement two stacks in a
// single array

import java.io.*;

class TwoStacks {
    int size;
    int top1, top2;
    int arr[];

    // Constructor
    TwoStacks(int n)
    {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = size;
    }

    // Method to push an element x to stack1
    void push1(int x)
    {
        // There is at least one empty space for
        // new element
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        }
        else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    // Method to push an element x to stack2
    void push2(int x)
    {
        // There is at least one empty space for
        // new element
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        }
        else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    // Method to pop an element from first stack
    int pop1()
    {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    // Method to pop an element from second stack
    int pop2()
    {
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    // Driver program to test twoStack class
    public static void main(String args[])
    {
        TwoStacks ts = new TwoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from"
                           + " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from"
                           + " stack2 is " + ts.pop2());
    }
}
// This code has been contributed by
// Amit Khandelwal(Amit Khandelwal 1).

Output
Popped element from stack1 is 11
Popped element from stack2 is 40
Time Complexity: 

Both Push operation: O(1)
Both Pop operation: O(1)
Auxiliary Space: O(N), Use of the array to implement stack.


 * 
 * 
 * 
 */
