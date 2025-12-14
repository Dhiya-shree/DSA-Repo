package analysis_Of_Algorithm;

public class Analysis01_Notation {

	/* 
	 Asymptotic Notations

Asymptotic notations are mathematical tools to represent the time complexity of algorithms for asymptotic analysis. The following 3 asymptotic notations are mostly used to represent the time complexity of algorithms:

thetanotation

1) Θ Notation: The theta notation bounds a function from above and below, so it defines exact asymptotic behavior. 
A simple way to get the Theta notation of an expression is to drop low-order terms and ignore leading constants. For example, consider the following expression. 
3n3 + 6n2 + 6000 = Θ(n3) 
Dropping lower order terms is always fine because there will always be a number(n) after which Θ(n3) has higher values than Θ(n2) irrespective of the constants involved. 
For a given function g(n), we denote Θ(g(n)) is following set of functions. 

Θ(g(n)) = {f(n): there exist positive constants c1, c2 and n0 such 
                 that 0 <= c1*g(n) <= f(n) <= c2*g(n) for all n >= n0}

The above definition means, if f(n) is theta of g(n), then the value f(n) is always between c1*g(n) and c2*g(n) for large values of n (n >= n0). The definition of theta also requires that f(n) must be non-negative for values of n greater than n0. 


BigO

2) Big O Notation: The Big O notation defines an upper bound of an algorithm, it bounds a function only from above. For example, consider the case of Insertion Sort. It takes linear time in best case and quadratic time in worst case. We can safely say that the time complexity of Insertion sort is O(n^2). Note that O(n^2) also covers linear time.
If we use O notation to represent time complexity of Insertion sort, we have to use two statements for best and worst cases:
1. The worst case time complexity of Insertion Sort is O(n^2).
2. The best case time complexity of Insertion Sort is O(n).

The Big O notation is useful when we only have upper bound on time complexity of an algorithm. Many times we easily find an upper bound by simply looking at the algorithm.
 

O(g(n)) = { f(n): there exist positive constants c and 
                  n0 such that 0 <= f(n) <= c*g(n) for 
                  all n >= n0}


BigOmega

3) Ω Notation: Just as Big O notation provides an asymptotic upper bound on a function, Ω notation provides an asymptotic lower bound.

Ω Notation can be useful when we have lower bound on time complexity of an algorithm. The Omega notation is the least used notation among all three.

For a given function g(n), we denote by Ω(g(n)) the set of functions.
 

Ω (g(n)) = {f(n): there exist positive constants c and
                  n0 such that 0 <= c*g(n) <= f(n) for
                  all n >= n0}.



	 *
	 */
	
	
	
	/**
	 * 
	 * Big O Notation


 In this article, we will discuss the analysis of the algorithm using Big - O asymptotic notation in complete detail. 
 Big-O Analysis of Algorithms

We can express algorithmic complexity using the big-O notation. For a problem of size N: 

A constant-time function/method is "order 1" : O(1)
A linear-time function/method is "order N" : O(N)
A quadratic-time function/method is "order N squared" : O(N 2 ) 
Definition: Let g and f be functions from the set of natural numbers to itself. The function f is said to be O(g) (read big-oh of g), if there is a constant c > 0 and a natural number n0 such that f (n) ≤ cg(n) for all n >= n0 . 

Note: O(g) is a set!

Abuse of notation: f = O(g) does not mean f ∈ O(g).
The Big-O Asymptotic Notation gives us the Upper Bound Idea, mathematically described below: 

 

f(n) = O(g(n)) if there exists a positive integer n0 and a positive constant c, such that f(n)≤c.g(n) ∀ n≥n0 

The general step wise procedure for Big-O runtime analysis is as follows:  

Figure out what the input is and what n represents.
Express the maximum number of operations, the algorithm performs in terms of n.
Eliminate all excluding the highest order terms.
Remove all the constant factors.
Some of the useful properties of Big-O notation analysis are as follow: 
  

▪ Constant Multiplication: 
If f(n) = c.g(n), then O(f(n)) = O(g(n)) ; where c is a nonzero constant. 
▪ Polynomial Function: 
If f(n) = a0 + a1.n + a2.n2 + ---- + am.nm, then O(f(n)) = O(nm). 
▪ Summation Function: 
If f(n) = f1(n) + f2(n) + ---- + fm(n) and fi(n)≤fi+1(n) ∀ i=1, 2, ----, m, 
then O(f(n)) = O(max(f1(n), f2(n), ----, fm(n))). 
▪ Logarithmic Function: 
If f(n) = logan and g(n)=logbn, then O(f(n))=O(g(n)) 
; all log functions grow in the same manner in terms of Big-O.

 Basically, this asymptotic notation is used to measure and compare the worst-case scenarios of algorithms theoretically. For any algorithm, the Big-O analysis should be straightforward as long as we correctly identify the operations that are dependent on n, the input size. 


Runtime Analysis of Algorithms

In general cases, we mainly used to measure and compare the worst-case theoretical running time complexities of algorithms for the performance analysis. 
The fastest possible running time for any algorithm is O(1), commonly referred to as Constant Running Time. In this case, the algorithm always takes the same amount of time to execute, regardless of the input size. This is the ideal runtime for an algorithm, but it's rarely achievable. 
In actual cases, the performance (Runtime) of an algorithm depends on n, that is the size of the input or the number of operations is required for each input item. 
The algorithms can be classified as follows from the best-to-worst performance (Running Time Complexity): 


  

▪ A logarithmic algorithm - O(logn) 
Runtime grows logarithmically in proportion to n. 
▪ A linear algorithm - O(n) 
Runtime grows directly in proportion to n. 
▪ A superlinear algorithm - O(nlogn) 
Runtime grows in proportion to n. 
▪ A polynomial algorithm - O(nc) 
Runtime grows quicker than previous all based on n. 
▪ A exponential algorithm - O(cn) 
Runtime grows even faster than polynomial algorithm based on n. 
▪ A factorial algorithm - O(n!) 
Runtime grows the fastest and becomes quickly unusable for even 
small values of n.   

Where, n is the input size and c is a positive constant. 
 

asymtotic-analysis



Algorithmic Examples of Runtime Analysis: 
Some of the examples of all those types of algorithms (in worst-case scenarios) are mentioned below: 
 

▪ Logarithmic algorithm - O(logn) - Binary Search. 
▪ Linear algorithm - O(n) - Linear Search. 
▪ Superlinear algorithm - O(nlogn) - Heap Sort, Merge Sort. 
▪ Polynomial algorithm - O(n^c) - Strassen’s Matrix Multiplication, Bubble Sort, Selection Sort, Insertion Sort, Bucket Sort. 
▪ Exponential algorithm - O(c^n) - Tower of Hanoi. 
▪ Factorial algorithm - O(n!) - Determinant Expansion by Minors, Brute force Search algorithm for Traveling Salesman Problem. 

 

Mathematical Examples of Runtime Analysis: 
The performances (Runtimes) of different orders of algorithms separate rapidly as n (the input size) gets larger. Let's consider the mathematical example:  

If n = 10,                  If n=20,
    log(10) = 1;                log(20) = 2.996;
    10 = 10;                    20 = 20;
    10log(10)=10;               20log(20)=59.9;
    102=100;                    202=400;
    210=1024;                    220=1048576;
    10!=3628800;                20!=2.432902e+1818;
 

Memory Footprint Analysis of Algorithms 

For performance analysis of an algorithm, runtime measurement is not only relevant metric but also we need to consider the memory usage amount of the program. This is referred to as the Memory Footprint of the algorithm, shortly known as Space Complexity. 
Here also, we need to measure and compare the worst case theoretical space complexities of algorithms for the performance analysis. 
It basically depends on two major aspects described below: 

Firstly, the implementation of the program is responsible for memory usage. For example, we can assume that recursive implementation always reserves more memory than the corresponding iterative implementation of a particular problem.
And the other one is n, the input size or the amount of storage required for each item. For example, a simple algorithm with a high amount of input size can consume more memory than a complex algorithm with less amount of input size. 
Algorithmic Examples of Memory Footprint Analysis: The algorithms with examples are classified from the best-to-worst performance (Space Complexity) based on the worst-case scenarios are mentioned below:   

▪ Ideal algorithm - O(1) - Linear Search, Binary Search,
    Bubble Sort, Selection Sort, Insertion Sort, Heap Sort, Shell Sort.
▪ Logarithmic algorithm - O(log n) - Merge Sort.
▪ Linear algorithm - O(n) - Quick Sort.
▪ Sub-linear algorithm - O(n+k) - Radix Sort.
 

Space-Time Tradeoff and Efficiency 

There is usually a trade-off between optimal memory use and runtime performance. 
In general for an algorithm, space efficiency and time efficiency reach at two opposite ends and each point in between them has a certain time and space efficiency. So, the more time efficiency you have, the less space efficiency you have and vice versa. 
For example, Mergesort algorithm is exceedingly fast but requires a lot of space to do the operations. On the other side, Bubble Sort is exceedingly slow but requires the minimum space. 
At the end of this topic, we can conclude that finding an algorithm that works in less running time and also having less requirement of memory space, can make a huge difference in how well an algorithm performs. 

Example of Big-oh noatation:


// C++ program to findtime complexity for single for loop
#include <bits/stdc++.h>
using namespace std;
// main Code
int main()
{
              //declare variable
    int a = 0, b = 0;
              //declare size 
    int N = 5, M = 5;
    // This loop runs for N time
    for (int i = 0; i < N; i++) {
        a = a + 5;
    }
    // This loop runs for M time
    for (int i = 0; i < M; i++) {
        b = b + 10;
    }
   //print value of a and b
    cout << a << ' ' << b;
    return 0;
}

 


Output
25 50
 

Explanation : 
First Loop runs N Time whereas Second Loop runs M Time. The calculation takes O(1)times.
So by adding them the time complexity will be O ( N + M + 1) = O( N + M). 

Time Complexity : O( N + M)
	 * 
	 * 
	 * 
	 */
	
	
	/*
	 * 
	 * Omega Notation

This article will discuss Big - Omega Notation represented by a Greek letter (Ω).

Definition: Let g and f be the function from the set of natural numbers to itself. The function f is said to be Ω(g), if there is a constant c > 0 and a natural number n0 such that c*g(n) ≤ f(n) for all n ≥ n0

Mathematical Representation:

 

Ω(g) = {f(n): there exist positive constants c and n0 such that 0 ≤ c*g(n) ≤ f(n) for all n ≥ n0} 
Note: Ω (g) is a set
 

Graphical Representation:



 


Graphical Representation


 

In simple language, Big - Omega (Ω) notation specifies the asymptotic (at the extreme) lower bound for a function f(n).
 

Follow the steps below to calculate Big - Omega (Ω) for any program:

Break the program into smaller segments.
Find the number of operations performed for each segment(in terms of the input size) assuming the given input is such that the program takes the least amount of time.
Add up all the operations and simplify it, let's say it is f(n).
Remove all the constants and choose the term having the least order or any other function which is always less than f(n) when n tends to infinity, let say it is g(n) then, Big - Omega (Ω) of f(n) is Ω(g(n)).
 

Example: Consider an example to print all the possible pairs of an array. The idea is to run two nested loops to generate all the possible pairs of the given array. 

The pseudo-code is as follows:

int print(int a[], int n)
{
    for (int i = 0; i < n; i++) 
    {
        for (int j = 0; j < n; j++)
        {
            if(i != j)
                cout << a[i] << " " 
                     << a[j] << "\n";
        }
    }
}
Below is the implementation of the above approach:

 


// Java program for the above approach
import java.lang.*;
import java.util.*;

class GFG{

// Function to print all possible pairs
static void print(int a[], int n)
{
    for(int i = 0; i < n; i++) 
    {
        for(int j = 0; j < n; j++) 
        {
            if (i != j)
                System.out.println(a[i] + " " + a[j]);
        }
    }
}

// Driver code
public static void main(String[] args)
{
    
    // Given array
    int a[] = { 1, 2, 3 };

    // Store the size of the array
    int n = a.length;

    // Function Call
    print(a, n);
}
}

// This code is contributed by avijitmondal1998

 


Output
1 2
1 3
2 1
2 3
3 1
3 2
 

In this example, it is evident that the print statement gets executed n2 times therefore if the running time vs n graph is plotted a parabolic graph will be obtained, f(n2). Now linear functions g(n), logarithmic functions g(log n), constant functions g(1) all are less than a parabolic function when the input range tends to infinity therefore, the worst-case running time of this program can be Ω(log n), Ω(n), Ω(1), or any function g(n) which is less than n2 when n tends to infinity. See the below graphical representation.
When to use Big - Ω notation: Big - Ω notation is the least used notation for the analysis of algorithms because it can make a correct but imprecise statement over the performance of an algorithm. Suppose a person takes 100 minutes to complete a task, using Ω notation, it can be stated that the person takes more than 10 minutes to do the task, this statement is correct but not precise as it doesn't mention the upper bound of the time taken. Similarly, using Ω notation we can say that the worst-case running time for the binary search is Ω(1), which is true because we know that binary search would at least take constant time to execute.


	 * 
	 */
	
	
	/**
	 * 
	 * Theta Notation

This article will discuss Big - Theta notations represented by a Greek letter (Θ).

Definition: Let g and f be the function from the set of natural numbers to itself. The function f is said to be Θ(g), if there are constants c1, c2 > 0 and a natural number n0 such that c1* g(n) ≤ f(n) ≤ c2 * g(n) for all n ≥ n0 

Mathematical Representation: 

 

Θ (g(n)) = {f(n): there exist positive constants c1, c2 and n0 such that 0 ≤ c1 * g(n) ≤ f(n) ≤ c2 * g(n) for all n ≥ n0}
Note: Θ(g) is a set

The above definition means, if f(n) is theta of g(n), then the value f(n) is always between c1 * g(n) and c2 * g(n) for large values of n (n ≥ n0). The definition of theta also requires that f(n) must be non-negative for values of n greater than n0. 


Graphical Representation:



 


Graphical Representation


 

In simple language, Big - Theta(Θ) notation specifies asymptotic bounds (both upper and lower) for a function f(n) and provides the average time complexity of an algorithm. 

 

Follow the steps below to find the average time complexity of any program:

Break the program into smaller segments.
Find all types and number of inputs and calculate the number of operations they take to be executed. Make sure that the input cases are equally distributed.
Find the sum of all the calculated values and divide the sum by the total number of inputs let say the function of n obtained is g(n) after removing all the constants, then in Θ notation its represented as Θ(g(n))
Example 1:

 var doLinearSearch = function(array, targetValue) 
    {  for (var guess = 0; guess < array.length; guess++) 
        {    if (array[guess] === targetValue) 
             {        return guess;  // found it!   
              }
         }
      return -1;  // didn't find it
   };
Each time the for-loop iterates, it has to do several things-

compare guess with array.length
compare array[guess] with targetValue
possibly return the value of guess
increment guess.
So the complexity will be theta n.

Example 2: Consider an example to find whether a key exists in an array or not using linear search. The idea is to traverse the array and check every element if it is equal to the key or not.

The pseudo-code is as follows:

bool linearSearch(int a[], int n, int key)
{
    for (int i = 0; i < n; i++) {
        if (a[i] == key)
            return true;
    }

    return false;
}
Below is the implementation of the above approach:
 


// Java program for the above approach
import java.lang.*;
import java.util.*;

class GFG{

// Function to find whether a key exists in an 
// array or not using linear search
static boolean linearSearch(int a[], int n, 
                            int key)
{
    
    // Traverse the given array, a[]
    for(int i = 0; i < n; i++) 
    {
        
        // Check if a[i] is equal to key
        if (a[i] == key)
            return true;
    }
    return false;
}

// Driver code
public static void main(String[] args)
{
    
    // Given Input
    int arr[] = { 2, 3, 4, 10, 40 };
    int x = 10;
    int n = arr.length;

    // Function Call
    if (linearSearch(arr, n, x))
        System.out.println("Element is present in array");
    else
        System.out.println("Element is not present in array");
}
}
 


Output
Element is present in array
 

In a linear search problem, let's assume that all the cases are uniformly distributed (including the case when the key is absent in the array). So, sum all the cases (when the key is present at position 1, 2, 3, ......, n and not present, and divide the sum by n + 1. 

 

Average case time complexity = 

⇒ 

⇒ 

⇒ 
 (constants are removed)

 

When to use Big - Θ notation: Big - Θ analyzes an algorithm with most precise accuracy since while calculating Big - Θ, a uniform distribution of different type and length of inputs are considered, it provides the average time complexity of an algorithm, which is most precise while analyzing, however in practice sometimes it becomes difficult to find the uniformly distributed set of inputs for an algorithm, in that case, Big-O notation is used which represent the asymptotic upper bound of a function f.


	 * 
	 * 
	 * 
	 */
	
	
	
}
