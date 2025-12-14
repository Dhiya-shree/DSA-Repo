package recursion;

/**
 * 
 * 
 * 
 * @author shree
 *
 */
public class R00_Recursion_Tail_Recursion {

}


/*
 * 
 * Tail Recursion

As we read before, that recursion is defined when a function invokes/calls itself.

Tail Recursion: A recursive function is said to be following Tail Recursion if it invokes itself at the end of the function. That is, if all of the statements are executed before the function invokes itself then it is said to be following Tail Recursion.

For Example:
 


public static void printN(int N)
{
    if(N==0)
        return;
    else
        System.out.print(N + " ");
    
    printN(N-1);
}
The above function call for N = 5 will print:
 

5 4 3 2 1


 

Which one is Better-Tail Recursive or Non Tail-Recursive?


The tail-recursive functions are considered better than non-tail recursive functions as tail-recursion can be optimized by the compiler. The idea used by compilers to optimize tail-recursive functions is simple, since the recursive call is the last statement, there is nothing left to do in the current function, so saving the current function’s stack frame is of no use.


 

Can a non-tail recursive function be written as tail-recursive to optimize it?


Consider the following function to calculate factorial of N. Although it looks like Tail Recursive at first look, it is a non-tail-recursive function. If we take a closer look, we can see that the value returned by fact(N-1) is used in fact(N), so the call to fact(N-1) is not the last thing done by fact(N).
 

int fact(int N) 
{ 
    if (N == 0) 
        return 1; 
  
    return N*fact(N-1); 
} 

The above function can be written as a Tail Recursive function. The idea is to use one more argument and accumulate the factorial value in the second argument. When N reaches 0, return the accumulated value.
 

int factTR(int N, int a) 
{ 
    if (N == 0)  
        return a; 
  
    return factTR(N-1, N*a); 
} 

 * 
 */

/**
Recursion Introduction

What is Recursion?
Recursion is a way to solve a problem or way to write a program in which a function calls itself directly or indirectly. Using recursive algorithms, certain problems like Towers of Hanoi (TOH), Inorder/Preorder/Postorder Tree Traversals and DFS of Graph, can be solved quite easily.



Direct Recursion	Indirect Recursion
void fun1() {
    ...
    ...
    fun1();
    ...
}
void fun1() {
    ...
    ...
    fun2();
    ...
 }

void fun2() {

    ...
    ...
    fun1();
    ...
}
In direct recursion, function calls itself while in indirect recursion the function fun1 calls another function fun2 which calls the fun1 function.

What is the need of base condition in recursion?

import java.io.*;

class Test {
  	static void fun1() {
    	System.out.println("GFG!");
      	fun1();
    }
    public static void main (String[] args) {
        fun1();
    }
}

/*
Output -
GFG
GFG
...
...
StackOverflow
*

The above functions have an issue - they recursively call themselves without any breaking condition, leading to StackOverflow or Segmentation Fault. In a recursive program, the solution to the base case is provided and the solution of bigger problem is expressed in terms of smaller problems.
 


/*package whatever //do not write package name here *

import java.io.*;

class GFG {
  	static void fun1(int n)
	{
	    if (n == 0) // base case
    	    return;

        System.out.println("GFG!");
    	fun1(n - 1);
	}
 
    public static void main (String[] args) {
		fun1(2);
    }
}

Output
GFG
GFG
In the above example, the base case for n == 0 is defined and a larger value of a number can be solved by converting to a smaller one till the base case is reached. This ensures that the code doesn't go into a never-ending state.


 

How memory is allocated to different function calls in recursion?

When any function is called from main(), the memory is allocated to it on stack. A recursive function calls itself, the memory for the called function is allocated on top of memory allocated to the calling function and a different copy of local variables is created for each function call. When the base case is reached, the function returns its value to the function by whom it is called and memory is de-allocated and the process continues.

 

Typical Structure of a Recursive Function
... fun(...) {
	Base Cases
	... ...
	Recursive Call (i.e. call to fun())
	with atleast one change in parameter
	... ...	
}
Illustration of memory in Recursion Stack
When any function is called from main(), the memory is allocated to it on stack. A recursive function calls itself, the memory for the called function is allocated on top of memory allocated to the calling function and a different copy of local variables is created for each function call. When the base case is reached, the function returns its value to the function by whom it is called and memory is de-allocated and the process continues. Let us take the example of how recursion works by taking a simple function:


/*package whatever //do not write package name here *

import java.io.*;

class GFG {
    static void printFun(int test)
    {
        if (test < 1)
            return;
        else {
            System.out.print(test + " ");
            printFun(test - 1);
            System.out.print(test + " ");
            return;
        }
    }

    public static void main(String[] args)
    {
        // Calling function printFun()
        int test = 3;

        printFun(test);
    }
}

Output
3 2 1 1 2 3 
When printFun(3) is called from main(), memory is allocated to printFun(3) and a local variable test is initialized to 3 and statement 1 to 4 are pushed on the stack as shown in below diagram. It first prints ‘3’. In statement 2, printFun(2) is called and memory is allocated to printFun(2) and a local variable test is initialized to 2 and statements 1 to 4 are pushed in the stack. Similarly, printFun(2) calls printFun(1) and printFun(1) calls printFun(0). printFun(0) goes to if statement and it returns to printFun(1). Remaining statements of printFun(1) are executed and it returns to printFun(2) and so on. In the output, values from 3 to 1 are printed and then 1 to 3 are printed. The memory stack has been shown in below diagram.


recursion
Disadvantage of Recursion: Note that both recursive and iterative programs have the same problem-solving powers, i.e., every recursive program can be written iteratively and vice versa. A recursive program has greater space requirements than an iterative program as all functions will remain in the stack until the base case is reached. A recursive program also has greater time requirements because of function calls and return overhead. 

Advantages of Recursion: Recursion provides a clean and simple way to write code. Some problems are inherently recursive like tree traversals, Tower of Hanoi, etc. For such problems, it is preferred to write recursive code. We can write such codes also iteratively with the help of the stack data structure.



*/