package matrix_MultiArray;

/**
 *Search in Row-wise and Column-wise sorted matrix
 * Searching in a row-wise and column-wise sorted matrix is an important operation that finds applications in tasks such as database querying, efficient search algorithms, and optimization problems. It allows us to quickly locate a desired element in a structured matrix, eliminating the need to search through every element sequentially.

The process of searching in a row-wise and column-wise sorted matrix requires an efficient algorithm that takes advantage of the matrix's sorted structure. By making intelligent comparisons and traversing the matrix strategically, we can eliminate large portions of the matrix during the search process, narrowing down our search space.



Examples:

Input: mat[4][4] =          {{10, 20, 30, 40},  x = 29
                             {15, 25, 35, 45},
                             {27, 29, 37, 48},
                             {32, 33, 39, 50}}
 
Output: Found at (2, 1)
Explanation: Element at (2,1) is 29

Input : mat[4][4] =          {{10, 20, 30, 40},   x = 100
                              {15, 25, 35, 45},
                              {27, 29, 37, 48},
                              {32, 33, 39, 50}};
     
Output: Element not found
 * 
 * 1) Naive Approach:
The approach is to do a normal traversal through thr matrix row by row and print the index of he element if found, otherwise, print nit found.

Time Complexity: O(R*C) 
 *
 * @author shree
 *
 */
public class SearchInSortedRowColumn {

	public static void main(String[] args) {
		
		int matrix[][] = {{1, 2, 3, 4},
				{9, 11, 12,13},
				{21,22,34,45},
		         {5, 6, 7, 8},
		         { 14, 15,16,17}};
		
		int n=matrix.length;
		int m=matrix[0].length;
	
	    boolean found=SearchInSorted2D(matrix,n,m,14);
	    System.out.println(" It is found is "+found);
	
	    searchInSorted2DGoG(matrix,n,14);

	}
	
	/* Searches the element x in mat[][]. If the 
    element is found, then prints its position 
    and returns true, otherwise prints "not found"
    and returns false */
    private static void searchInSorted2DGoG(int[][] mat, 
                                    int n, int x)
    {
        
    	//n=n-1;
        // set indexes for top right
        int i = 0, j =mat[0].length; 
        // element

        while (i < n && j >= 0) 
        {
            if (mat[i][j] == x) 
            {
                System.out.print("Element found at " + 
                                    i + " " + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else // if mat[i][j] < x
                i++;
        }

        System.out.print("n Element not found");
        return; // if ( i==n || j== -1 )
    }
    
	private static boolean SearchInSorted2D(int[][] matrix, int n, int m, int x) {
		/*
		 * A better solution is use Divide and Conquer to find the element which has a time complexity of O(n1.58). 

Efficient approach: The simple idea is to remove a row or column in each comparison until an element is found. Start searching from the top-right corner of the matrix. There are three possible cases. 

The given number is greater than the current number: This will ensure that all the elements in the current row are smaller than the given number as the pointer is already at the right-most elements and the row is sorted. Thus, the entire row gets eliminated and continues the search for the next row. Here, elimination means that a row needs not be searched.
The given number is smaller than the current number: This will ensure that all the elements in the current column are greater than the given number. Thus, the entire column gets eliminated and continues the search for the previous column, i.e. the column on the immediate left.
The given number is equal to the current number: This will end the search.
Algorithm:

Let the given element be x, create two variable i = 0, j = n-1 as index of row and column
Run a loop until i = n
Check if the current element is greater than x then decrease the count of j. Exclude the current column.
Check if the current element is less than x then increase the count of i. Exclude the current row.
If the element is equal, then print the position and end.
		 * 
		 */
		   if(matrix[0][0]>x){
		        return false;
		    }
		    if(matrix[n-1][m-1]<x){
		        return false;
		    }
		    
		    int i=0;int j=m-1;
		    
		    while(i<n && j>=0){
		        
		        if(matrix[i][j]==x){
		            return true;
		        }
		        if(matrix[i][j]>x){
		            j--;
		        }
		        else{
		            i++;
		        }
		    }
		    return false;
	}


}
/*
Sample Problems on Matrix

Problem #1 : Transpose of a Matrix

Description - Transpose of a matrix is obtained by changing rows to columns and columns to rows. In other words, transpose of A[ ][ ] is obtained by changing A[ i ][ j ] to A[ j ][ i ].We are given a matrix of size m*n, We have to print the transpose of the matrix. 

Solution : We have given matrix A[ m ][ n ], We will create auxiliary matrix B[ n ][ m ] for storing the Transpose of the Matrix A. The idea is to place A [ j ][ i ] at B [ i ][ j ].
Pseudo Code
 

void transpose(A[m][n])
{
    B[n][m] // Transpose Matrix

    for ( i=0 to n-1 )
    {
        for ( j=0 to m-1 ) 
            B[i][j] = A[j][i]
    }
}

Time Complexity : O(m*n)
Auxiliary Space : O(m*n)

 

Problem #2 : Search Element in Row-wise and Column-wise Sorted Matrix

Description - Given an n x n matrix and a number x, find the position of x in the matrix. In the given matrix, every row and column is sorted in increasing order. 
Solution : Idea is to solve problem with row and column elimination reducing the search space. Before jumping at the solution, lets try to understand the concept that is actually allowing us to solve the problem in linear time.
Let’s start our search from the top-right corner of the array. There are three possible cases.

The number we are searching for is greater than the current number. This will ensure, that all the elements in the current row is smaller than the number we are searching for as we are already at the right-most element and the row is sorted. Thus, the entire row gets eliminated and we continue our search on the next row. Here elimination means we won’t search on that row again.
The number we are searching for is smaller than the current number. This will ensure, that all the elements in the current column is greater than the number we are searching for. Thus, the entire column gets eliminated and we continue our search on the previous column i.e. the column at the immediate left.
The number we are searching for is equal to the current number. This will end our search.
k - starting row index
m - ending row index
l - starting column index
n - ending column index
i - iterator
The steps of the algorithm are as follows:

Start the search at the topmost and rightmost corner in the matrix, i.e., i=0, j=n-1.
If the target value is equal to the value at the position we are at, then return the position of the current row and column.
If the target value is less than the value at the position we are at, then we can ignore all the values in the current column and continue the search to the next column. As the matrix is sorted row-wise and column-wise in ascending order, all the other values in the current column are greater than the target value.
If the target value is greater than the value at the position we are at, then we can ignore all the values in the current row and continue the search to the next row. As the matrix is sorted row-wise and column-wise in ascending order, all the other values in the row are lesser than the target valuample Problems on Matrix

Problem #1 : Transpose of a Matrix

Description - Transpose of a matrix is obtained by changing rows to columns and columns to rows. In other words, transpose of A[ ][ ] is obtained by changing A[ i ][ j ] to A[ j ][ i ].We are given a matrix of size m*n, We have to print the transpose of the matrix. 

Solution : We have given matrix A[ m ][ n ], We will create auxiliary matrix B[ n ][ m ] for storing the Transpose of the Matrix A. The idea is to place A [ j ][ i ] at B [ i ][ j ].
Pseudo Code
 

void transpose(A[m][n])
{
    B[n][m] // Transpose Matrix

    for ( i=0 to n-1 )
    {
        for ( j=0 to m-1 ) 
            B[i][j] = A[j][i]
    }
}

Time Complexity : O(m*n)
Auxiliary Space : O(m*n)

 

Problem #2 : Search Element in Row-wise and Column-wise Sorted Matrix

Description - Given an n x n matrix and a number x, find the position of x in the matrix. In the given matrix, every row and column is sorted in increasing order. 
Solution : Idea is to solve problem with row and column elimination reducing the search space. Before jumping at the solution, lets try to understand the concept that is actually allowing us to solve the problem in linear time.
Let’s start our search from the top-right corner of the array. There are three possible cases.

The number we are searching for is greater than the current number. This will ensure, that all the elements in the current row is smaller than the number we are searching for as we are already at the right-most element and the row is sorted. Thus, the entire row gets eliminated and we continue our search on the next row. Here elimination means we won’t search on that row again.
The number we are searching for is smaller than the current number. This will ensure, that all the elements in the current column is greater than the number we are searching for. Thus, the entire column gets eliminated and we continue our search on the previous column i.e. the column at the immediate left.
The number we are searching for is equal to the current number. This will end our search.
k - starting row index
m - ending row index
l - starting column index
n - ending column index
i - iterator
The steps of the algorithm are as follows:

Start the search at the topmost and rightmost corner in the matrix, i.e., i=0, j=n-1.
If the target value is equal to the value at the position we are at, then return the position of the current row and column.
If the target value is less than the value at the position we are at, then we can ignore all the values in the current column and continue the search to the next column. As the matrix is sorted row-wise and column-wise in ascending order, all the other values in the current column are greater than the target value.
If the target value is greater than the value at the position we are at, then we can ignore all the values in the current row and continue the search to the next row. As the matrix is sorted row-wise and column-wise in ascending order, all the other values in the row are lesser than the target valu

*/

/**
/*
 * 
 * Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print "Not Found". In the given matrix, every row and column is sorted in increasing order. The designed algorithm should have linear time complexity. 


Example: 
 

Input: mat[4][4] = { {10, 20, 30, 40},
                               15, 25, 35, 45},
                               {27, 29, 37, 48},
                             {32, 33, 39, 50}}
           x = 29
Output: Found at (2, 1)
Explanation: Element at (2,1) is 29


Input : mat[4][4] = { {10, 20, 30, 40},
                                {15, 25, 35, 45},
                               {27, 29, 37, 48},
                              {32, 33, 39, 50}};
          x = 100
Output : Element not found
Explanation: Element 100 is not found

 

Naive approach: The simple idea is to traverse the array and to search elements one by one.

Algorithm: 

Run a nested loop, outer loop for row and inner loop for the column
Check every element with x and if the element is found then print "element found"
If the element is not found, then print "element not found".
Below is the implementation of the above approach:

// Java program to search an element in row-wise
// and column-wise sorted matrix

class GFG {
  static int search(int[][] mat, int n, int x)
  {
    if (n == 0)
      return -1;

    // traverse through the matrix
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        // if the element is found
        if (mat[i][j] == x) {
          System.out.print("Element found at ("
                           + i + ", " + j
                           + ")\n");
          return 1;
        }
    }

    System.out.print(" Element not found");
    return 0;
  }
  public static void main(String[] args)
  {
    int mat[][] = { { 10, 20, 30, 40 },
                   { 15, 25, 35, 45 },
                   { 27, 29, 37, 48 },
                   { 32, 33, 39, 50 } };

    search(mat, 4, 29);
  }
}

// This code is contributed by Aditya Kumar (adityakumar129)

 


Output
Element found at (2, 1)

Time Complexity: O(n2)
Auxiliary Space: O(1)


A better solution is use Divide and Conquer to find the element which has a time complexity of O(n1.58). 

Efficient approach: The simple idea is to remove a row or column in each comparison until an element is found. Start searching from the top-right corner of the matrix. There are three possible cases. 

The given number is greater than the current number: This will ensure that all the elements in the current row are smaller than the given number as the pointer is already at the right-most elements and the row is sorted. Thus, the entire row gets eliminated and continues the search for the next row. Here, elimination means that a row needs not be searched.
The given number is smaller than the current number: This will ensure that all the elements in the current column are greater than the given number. Thus, the entire column gets eliminated and continues the search for the previous column, i.e. the column on the immediate left.
The given number is equal to the current number: This will end the search.
Algorithm:

Let the given element be x, create two variable i = 0, j = n-1 as index of row and column
Run a loop until i = n
Check if the current element is greater than x then decrease the count of j. Exclude the current column.
Check if the current element is less than x then increase the count of i. Exclude the current row.
If the element is equal, then print the position and end.
Below is the implementation of the above approach:

 


// JAVA Code for Search in a row wise and
// column wise sorted matrix

class GFG {

    /* Searches the element x in mat[][]. If the 
    element is found, then prints its position 
    and returns true, otherwise prints "not found"
    and returns false 
    private static void search(int[][] mat, 
                                    int n, int x)
    {
        
        // set indexes for top right
        int i = 0, j = n - 1; 
        // element

        while (i < n && j >= 0) 
        {
            if (mat[i][j] == x) 
            {
                System.out.print("Element found at " + 
                                    i + " " + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else // if mat[i][j] < x
                i++;
        }

        System.out.print("n Element not found");
        return; // if ( i==n || j== -1 )
    }
    // driver program to test above function
    public static void main(String[] args)
    {
        int mat[][] = { { 10, 20, 30, 40 },
                        { 15, 25, 35, 45 },
                        { 27, 29, 37, 48 },
                        { 32, 33, 39, 50 } };

        search(mat, 4, 29);
    }
}
// This code is contributed by Arnav Kr. Mandal.

 


Output
Element found at 2, 1
Time Complexity: O(n), Only one traversal is needed, i.e, i from 0 to n and j from n-1 to 0 with at most 2*n steps. The above approach will also work for m x n matrix (not only for n x n). Complexity would be O(m + n). 
Auxiliary Space: O(1), No extra space is required
 * 
 * 
 */