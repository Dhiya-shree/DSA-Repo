package dynamic_programming;

/**
 *  
 *  Dynamic programming :
 *  
 *  Optimization over plain recusrion 
 *  Idea :
 *     Reuse the solutions of subproblems 
 *     mainly when there are overlapping sub problems 
 *  
 *  Plain recursion : for input n , we use subproblem 
 *                   for n using n-1,n-2....1 for solving 
 *                   Ex fibonnaci series 
 *  
 *  
 *  In plain recursion if some subproblems are used again and again 
 *  Then recurring sub problems can be stored 
 *  So use stored solution when the sub problem is needed 
 *                   
 *   
 *  Dynamic programming :
 *  Idea :
 *     Reuse the solutions of subproblems 
 *     mainly when there are overlapping sub problems 
 *     
 *  Ways :
 *  1) Memoization - Top Down approach 
 *        MEMOIZATION ======> TABLUATION 
 *        
 *        
 *        Put for loops as per recusions base condts
 *        Replace recur func with table const 
 *        
 *  2) Tabulation - Bottom Up approach 
 *  
 *  Applications of DP :
 *  1) Bellman ford - find smallest distance between a node with oher node in a graph
 *  2) Floyd warshall Algorithm - find smallest distance between every pain in graph 
 *  3) Diff Utility LCS Longest common subsequence - find diff between two files ex) GIT 
 *  4) Search Closed words ( edit distance)- Find a word that is not in dictionary , 
 *                                              find word closest to wrong 
 *  5) Resource Allocation (0-1 knapsack )- optimal allocation of resources 
 *  
 *  
 * 
 * 
 * @author shree
 *
 */

/*
 * MEMOIZATION :
 * 
 * Call for N from top .......
 *   Step 1: Create a recusion solution 
 *   Step 2: Create a recusion solution with subproblems overlapping 
 *   Step 3: Create memo and store value of sub problem 
 *   Step 4: On overlapping reuse value from memo 
 * Add n-1,n-2,...1,0 values to down ...........
 *   
 *   Can optimize exponential solution to linear 
 *   Reusing subproblem solution from staorage 
 *   
 *   Memo array can be 1D / 2 D / 3 D  
 * 
 *   Dimension of memo array = parameters being passed in recursion function 
 *   1 parameter changing state - 1D array 
 *   2 parameter changing in recursion - 2D array  ex LCS 
 *   No of dimension of memo array = No of parameters changing in recursive call 
 *   
 *   Size of memo array = based on parameters being passed 
 *   For fibonnaci , n goes from 0 to n 
 *   Size of memo array = 0 to n+1
 * 
 * Example :
 * Find n fibbonaci number                      5
 *                                            /    \
 * for n=5                                   4       3
 * int Rfib (int n)                        /  \      / \           
 *    n==0 || n==1 return n              3    2     2   1 
 *    return Rfib(n-1)+fib(n-2)        / \   / \   / \  
 *                                    2   1  1  0  1  0
 *                                   / \
 *                                  1   0
 *                                  
 * 
 * In above fibonnacci recursion tree 
 * Many overlapping for Fib 3 , 2 found 
 * With normal recursion we have overlapping problem for 3 and 2
 * 
 * Normal recursion : Exponential time 2 power N
 * Fib normal recusrion : Golden ratio power N 
 * 
 * With memoization ->optimization to linear time 
 * 
 * Memoization fibonnaci :
 *  1 D memo array                        i = 0 1 2 3 4 5  
 * int memo[]={-1,-1,-1,.......-1}      memo= 0 1 1 2 3 5 -1 -1 -1 
 *                                     (memo filled after first branch )
 * int fib(int n){                                
 *                                                5 
 *   if(memo[n]==-1){                            / \
 *                                              4   3( use memo[3]=2)
 *   int res=0;                                / \ 
 *   n==0 || n==1 res=n                       3   2
 *   else res= fib(n-1)+fib(n-2)             / \  (use memo[2]=1)
 *                                          2   1
 *   memo[n]=res                           / \   (use memo[1]=1)
 *   }                                    1   0
 *   return memo[n]               <1st branch complete>
 *   
 *   }
 *   
 * }
 * 
 * Memoization :
 * No of call : 2n -1 
 * Work : O 1 
 * Time : 2n-1 = O n
 * 
 * With memoization 
 * Fibonnaci -> Optimized to linear time 
 * 
 * 
 * 
 * Memoization - top down 
 * Create a recursive solution + use memo array fpr overlapping sub problem 
 * Top down 
 * Start from main problem --> check sub problems 
 * 
 */

/**
 * 
 * Tabulation :
 * Bottom Up 
 * 
 * Call from bottom 0,1,2,3.........................
 * Step 1: Leave recusrion ,Do not think of recusrion 
 * Step 2: Use a table/array 
 * Step 3: Build the table for all values 
 * Step 4: Use table and solve 
 * Use the values from bottom and find soltion for up N ................
 * 
 *  * Table / array can be 1 D / 2 D / 3 D  
 * 
 *   Dimension of table array = parameters being passed in recursion function 
 *   1 parameter changing state - 1D array 
 *   2 parameter changing in recursion - 2D array  ex LCS 
 *   No of dimension of memo array = No of parameters changing in recursive call 
 *   
 *   Size of table array = based on parameters being passed 
 *   For fibonnaci , n goes from 0 to n 
 *   Size of table array = 0 to n+1
 * 
 * 
 *  Example : Fibonnaci 
 *  n=5
 *  f[]=new int[n+1]
 *  Table array size = 6   table: -1,-1,-1,-1,-1,-1
 *  
 *  Initialize table : 0,1,-1,-1,-1,-1
 *  f[0]=0 , f[1]=1
 *  
 *  for int i = 2 to n  Loop for 2 to n 
 *  f[i]=f[i-1]+f[i-2]  0,1,1,2,3,5 
 *  
 *  return f[n]
 *  
 *  Make table and fill in bottom up method - easy but ...
 *  Tablution problem : --> DEPENDENCY 
 *  Need to take care of dependency 
 *  If main problem is dependent upon n-3 , n-1 , n+1
 *  f[n]= f[n-3]+ f[n-1] +f[n+1]
 *  
 *  For above cases for finding f[n] all others needs to calculated 
 *  Dependency in table must be filled 
 *  Must to have values for n+1 also n-1 
 *  
 *  Required values in table must be filled before .
 *  
 *  Optimal Strategy game :
 *  Not easy to write bottom up , need complex bottom up solution 
 *  
 *  Tabulation :
 *  Time : O N 
 *  Space : O N 
 *  
 *  
 *  Fibonacci number nth :
 *  Best to find with matrix multiplication 
 *  Completes in time O Log N 
 *  
 *  So DP is not best for all ......
 * 
 * @author shree
 *
 */
/*
 *      Memoization                     Tabulation 
 *   
 *   1) Easy to implement            1) Complex for some optimal strategy etc 
 *  
 *   2) Need recursion call          2) No over head calls at all 
 *      overhead , on the event         Find the value only once 
 *      of overhead only use            From bottom fill value 
 *      memo value                      Use multiple times 
 *      ex) O 2N-1 - fibonnaci          ex) O N - fibonnaci 
 *      
 *   3) Slower because of           3) Comparatively faster 
 *        overhead calls 
 *        
 *   4) Easy to write from          4) Can not write from recursion 
 *      recursion solution                   solution 
 *      
 */
 

public class DP00_Introduction {

	public static void main(String[] args) {
		
		int n=10;
		FibonacciRecursion(n);
		memo=new int[n+1];
		Memoization_Fib(n);
		Tabulation_Fib(n);
		Matrix_Multiplication(n);
		
	}

	private static int Matrix_Multiplication(int n) {
		/*
		 Nth Power of Matrix Approach to Find and Print Nth Fibonacci Numbers
This approach relies on the fact that if we n times multiply the matrix M = {{1,1},{1,0}} to itself (in other words calculate power(M, n)), then we get the (n+1)th Fibonacci number as the element at row and column (0, 0) in the resultant matrix.

If n is even then k = n/2:   
Therefore Nth Fibonacci Number = F(n) = [2*F(k-1) + F(k)]*F(k)
If n is odd then k = (n + 1)/2:    
Therefore Nth Fibonacci Number = F(n) = F(k)*F(k) + F(k-1)*F(k-1)

How does this formula work? 
The formula can be derived from the matrix equation. 

\begin{bmatrix}1 & 1 \\1 & 0 \end{bmatrix}^n = \begin{bmatrix}F_{n+1} & F_n \\F_n & F_{n-1} \end{bmatrix}      

Taking determinant on both sides, we get (-1)n = Fn+1Fn-1 – Fn2 

Moreover, since AnAm = An+m for any square matrix A, the following identities can be derived (they are obtained from two different coefficients of the matrix product)

FmFn + Fm-1Fn-1 = Fm+n-1         —————————(1)

By putting n = n+1 in equation(1),

FmFn+1 + Fm-1Fn = Fm+n             ————————–(2)

Putting m = n in equation(1).

F2n-1 = Fn2 + Fn-12

Putting m = n in equation(2)

F2n = (Fn-1 + Fn+1)Fn = (2Fn-1 + Fn)Fn  ——–

( By putting Fn+1 = Fn + Fn-1 )

To get the formula to be proved, we simply need to do the following 

If n is even, we can put k = n/2 
If n is odd, we can put k = (n+1)/2
		 */
		
		/* function that returns nth Fibonacci number */
	      int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
	        if (n == 0)
	            return 0;
	        power(F, n - 1);
	 
	        return F[0][0];
	    }
	 
	    static void multiply(int F[][], int M[][])
	    {
	        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
	        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
	        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
	        int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];
	 
	        F[0][0] = x;
	        F[0][1] = y;
	        F[1][0] = z;
	        F[1][1] = w;
	    }
	 
	    /* Optimized version of power() in method 4 */
	    static void power(int F[][], int n)
	    {
	        if (n == 0 || n == 1)
	            return;
	        int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };
	 
	        power(F, n / 2);
	        multiply(F, F);
	 
	        if (n % 2 != 0)
	            multiply(F, M);
	    }

	private static void Tabulation_Fib(int n) {
		// tabulation bottom - down 
		int table[]=new int[n+1];
		table[0]=0;table[1]=1;
		System.out.print(0+" "+1+" ");
		for(int i=2;i<=n;i++) {
			table[i]=table[i-1]+table[i-2];
			System.out.print(table[i]+" "); 
		}
	}

	static int memo[];
	private static int Memoization_Fib(int n) {
		// memoization top- down 
		if(n!=0 && memo[n]==0) {
		if(n==0||n==1) {
			System.out.print(n+" ");
            memo[n]=n;
		}
		else {
			int res=FibonacciRecursion(n-1)+FibonacciRecursion(n-2);
			System.out.println(res+" ");
			memo[n]= res;
		}
		}
		
			return memo[n];
		
		
	}

	private static int FibonacciRecursion(int n) {
		// normal recursion 
		if(n==0||n==1) {
			System.out.print(n+" ");
            return n;
		}
		else {
			int res=FibonacciRecursion(n-1)+FibonacciRecursion(n-2);
			System.out.println(res+" ");
			return res;
		}
		
	}
}

/**
 * 
 * Introduction to Dynamic Programming

Dynamic Programming is an algorithmic approach to solve some complex problems easily and save time and number of comparisons by storing the results of past computations. The basic idea of dynamic programming is to store the results of previous calculation and reuse it in future instead of recalculating them.


We can also see Dynamic Programming as dividing a particular problem into subproblems and then storing the result of these subproblems to calculate the result of the actual problem.


Consider the problem to find the N-th Fibonacci number.

We know that n-th fibonacci number fib(n) can be defined as:
fib(n) = fib(n-1) + fib(n-2), where n >= 2.

and,

fib(0) = 0 
fib(1) = 1



We can see that the above function fib() to find the nth fibonacci number is divided into two subproblems fib(n-1) and fib(n-2) each one of which will be further divided into subproblems and so on.

The first few Fibonacci numbers are:

1, 1, 2, 3, 5, 8, 13, 21, 34,........


The recursive program to find N-th Fibonacci number is shown below:

int fib(int n) 
{ 
    if (n <= 1) 
        return n; 

    return fib(n-1) + fib(n-2); 
} 
Below is the recursion tree for the recursive solution to find the N-th Fibonacci number:
                         fib(5)
                     /             \
               fib(4)                fib(3)
             /      \                /     \
         fib(3)      fib(2)         fib(2)    fib(1)
        /     \        /    \       /    \
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /    \
fib(1) fib(0)



We can see that the function fib(3) is being called 2 times. If we would have stored the value of fib(3), then instead of computing it again, we could have reused the old stored value.

The time complexity of the recursive solution is exponential. However, we can improve the time complexity by using Dynamic Programming approach and storing the results of the subproblems as shown below:

int fib(int n) 
{ 
  // Declare an array to store Fibonacci numbers
  int f[n+2];   // 1 extra to handle case, n = 0 
  int i; 
  
  // 0th and 1st number of the series are 0 and 1
  f[0] = 0; 
  f[1] = 1; 
  
  for (i = 2; i <= n; i++) 
  { 
      // Add the previous 2 numbers in the series 
      // and store it 
      f[i] = f[i-1] + f[i-2]; 
  } 
  
  return f[n]; 
} 
The time complexity of the above solution is linear.
 */

/*
 * 
 *Properties of a Dynamic Programming Problem

There are two main properties of any problem which identifies a problem that it can be solved using the dynamic programming approach:
Overlapping Subproblem Property
Optimal Substructure Property


Let us look at each one of these properties in details:
Overlapping Subproblems: Like Divide and Conquer, Dynamic Programming combines solutions to sub-problems. Dynamic Programming is mainly used when solutions of the same subproblems are needed again and again. In dynamic programming, computed solutions to subproblems are stored in a table so that these don’t have to be recomputed. So Dynamic Programming is not useful when there are no common (overlapping) subproblems because there is no point storing the solutions if they are not needed again. For example, Binary Search doesn’t have common subproblems. If we take an example of following the recursive program for Fibonacci Numbers, there are many subproblems which are solved again and again.

//* simple recursive program for Fibonacci numbers *
int fib(int n) 
{ 
   if ( n <= 1 ) 
      return n; 
   return fib(n-1) + fib(n-2); 
}
Recursion tree for execution of fib(5):
                         fib(5)
                     /             \
               fib(4)                fib(3)
             /      \                /     \
         fib(3)      fib(2)         fib(2)    fib(1)
        /     \        /    \       /    \
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /    \
fib(1) fib(0)

We can see that the function fib(3) is being called 2 times. If we would have stored the value of fib(3), then instead of computing it again, we could have reused the old stored value.
Optimal Substructure: A given problem has Optimal Substructure Property if an optimal solution of the given problem can be obtained by using optimal solutions of its subproblems. For example, the Shortest Path problem has the following optimal substructure property: If a node x lies in the shortest path from a source node u to destination node v then the shortest path from u to v is combination of shortest path from u to x and shortest path from x to v. The standard All Pair Shortest Path algorithms like Floyd–Warshall and Bellman-Ford are typical examples of Dynamic Programming. On the other hand, the Longest Path problem doesn’t have the Optimal Substructure property. Here, by Longest Path we mean longest simple path (path without cycle) between any two nodes. Consider the following unweighted graph given in the CLRS book. There are two longest paths from q to t: q->r->t and q->s->t. Unlike shortest paths, these longest paths do not have the optimal substructure property. For example, the longest path q->r->t is not a combination of the longest path from q to r and longest path from r to t, because the longest path from q to r is q->s->t->r and the longest path from r to t is r->q->s->t.
 
 * 
 */
 
/**
 * Overlapping Subproblems Property

We had already discussed the basics of Overlapping Subproblems property of a problem that can be solved using Dynamic Programming algorithm. Let us extend our previous example of Fibonacci Number to discuss the overlapping subproblems property in details.

 


//* simple recursive program for Fibonacci numbers *
int fib(int n)
{
   if ( n <= 1 )
      return n;
   return fib(n-1) + fib(n-2);
}
Recursion tree for execution of fib(5)
 

                              
                         fib(5)
                     /             \
               fib(4)                fib(3)
             /      \                /     \
         fib(3)      fib(2)         fib(2)    fib(1)
        /     \        /    \       /    \
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /    \
fib(1) fib(0)


We already discussed how storing results of the subproblems can be effective in reducing the number of calculations or operations to obtain the final result. As in the above recursion tree, we can see that different values like fib(1), fib(0), fib(2) are being calculated more than once. There are two different ways to store the values so that these values can be reused:
 

Memoization (Top Down)
Tabulation (Bottom Up)


Let us look at each one of these in details:
 

Memoization (Top Down): The memoized program for a problem is similar to the recursive version with a small modification that it looks into a lookup table before computing solutions. We initialize a lookup array with all initial values as NIL. Whenever we need the solution to a subproblem, we first look into the lookup table. If the precomputed value is there then we return that value, otherwise, we calculate the value and put the result in the lookup table so that it can be reused later. Following is the memoized version for nth Fibonacci Number. 

//* Java program for Memoized version *
public class Fibonacci
{
  final int MAX = 100;
  final int NIL = -1;

  int lookup[] = new int[MAX];

  //* Function to initialize NIL values in lookup table *
  void _initialize()
  {
    for (int i = 0; i < MAX; i++)
        lookup[i] = NIL;
  }

  //* Function for nth Fibonacci number *
  int fib(int n)
  {
      if (lookup[n] == NIL)
      {
          if (n <= 1)
              lookup[n] = n;
          else
              lookup[n] = fib(n-1) + fib(n-2);
      }
    
      return lookup[n];
  }

  // Driver Code
  public static void main(String[] args)
  {
      Fibonacci f = new Fibonacci();
      int n = 40;
      f._initialize();
      System.out.println("Fibonacci number is" + " " + f.fib(n));
  }
}
Output:
Fibonacci number is 102334155
Tabulation (Bottom Up): The tabulated program for a given problem builds a table in bottom up fashion and returns the last entry from table. For example, for the same Fibonacci number, we first calculate fib(0) then fib(1) then fib(2) then fib(3) and so on. So literally, we are building the solutions of subproblems bottom-up. Following is the tabulated version for nth Fibonacci Number. 

//* Java program for Tabulated version *

public class Fibonacci
{
    int fib(int n)
    {
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
    
        for (int i = 2; i <= n; i++)
            f[i] = f[i-1] + f[i-2];
    
        return f[n];
    }

    public static void main(String[] args)
    {
        Fibonacci f = new Fibonacci();
        int n = 9;
        System.out.println("Fibonacci number is" + " " + f.fib(n));
    }
}
Output:
Fibonacci number is 34

Both Tabulated and Memoized approaches stores the solutions of subproblems. In Memoized version, the table is filled on demand while in Tabulated version, starting from the first entry, all entries are filled one by one. Unlike the Tabulated version, all entries of the lookup table are not necessarily filled in Memoized version. 
 * 
 */




