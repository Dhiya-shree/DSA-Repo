package matrix_MultiArray;

import java.util.ArrayList;

public class TraversalSpiral_Boundary {

	public static void main(String[] args) {
		int matrix[][] = {{1, 2, 3, 4},
				{9, 11, 12,13},
				{21,22,34,45},
		         {5, 6, 7, 8},
		         { 14, 15,16,17}};
		
		int n=matrix.length;
		int m=matrix[0].length;
		ArrayList<Integer> ans=boundaryTraversal(matrix, n, m);
		System.out.println("Boundary Traversal is "+ans.toString());
		
		ans=SpiralTraversal(matrix, n, m); //O n2 O 1
		System.out.println("Spiral Traversal is "+ans.toString());
		
		ans=SpiralTraversalGoG(matrix, n, m);//O n2 O 1
		System.out.println("Spiral Traversal is "+ans.toString());
		
	    SpiralTraversalGoGRecur(matrix,0,0, n, m);//O n2 O 1
		System.out.println("Spiral Traversal is by recur ");//+ans.toString());
		
		ans=SpiralTraversalOn_Best_Time(matrix);//O n O n
		System.out.println("Spiral Traversal is by O N best time "+ans);//+ans.toString());
	
	}
	// Function to print in spiral order
    public static ArrayList<Integer> SpiralTraversalOn_Best_Time(int[][] matrix) {
    	/*
    	 * Algorithm:
Let the array have R rows and C columns. seen[r][c][/c] denotes that the cell on the r-th row and c-th column was previously visited. Our current position is (r, c), facing direction di, and we want to visit R x C total cells.
As we move through the matrix, our candidate's next position is (cr, cc). If the candidate is in the bounds of the matrix and unseen, then it becomes our next position; otherwise, our next position is the one after performing a clockwise turn.
    	 * 
    	 */
        ArrayList<Integer> ans = new ArrayList<Integer>();

        if (matrix.length == 0)
            return ans;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int x = 0, y = 0, di = 0;

        // Iterate from 0 to R * C - 1
        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];

            if (0 <= cr && cr < m && 0 <= cc && cc < n
                    && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return ans;
    }
	
	// Function for printing matrix in spiral
    // form i, j: Start index of matrix, row
    // and column respectively m, n: End index
    // of matrix row and column respectively
    static void SpiralTraversalGoGRecur(int arr[][], int i, int j, int m,
                      int n)
    {
        // If i or j lies outside the matrix
        if (i >= m || j >= n) {
            return;
        }

        // Print First Row
        for (int p = i; p < n; p++) {
            System.out.print(arr[i][p] + " ");
        }

        // Print Last Column
        for (int p = i + 1; p < m; p++) {
            System.out.print(arr[p][n - 1] + " ");
        }

        // Print Last Row, if Last and
        // First Row are not same
        if ((m - 1) != i) {
            for (int p = n - 2; p >= j; p--) {
                System.out.print(arr[m - 1][p] + " ");
            }
        }

        // Print First Column, if Last and
        // First Column are not same
        if ((n - 1) != j) {
            for (int p = m - 2; p > i; p--) {
                System.out.print(arr[p][j] + " ");
            }
        }
        SpiralTraversalGoGRecur(arr, i + 1, j + 1, m - 1, n - 1);
    }
	private static ArrayList<Integer> SpiralTraversalGoG(int[][] matrix, int n, int m) {
		int i, k = 0, l = 0;
        n=n-1;
        m=m-1;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
		 ArrayList<Integer> arr=new ArrayList<Integer>();
        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(matrix[k][i] + " ");
                arr.add(matrix[k][i]);
            }
            k++;

            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
                System.out.print(matrix[i][n - 1] + " ");
                arr.add(matrix[i][n - 1]);
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(matrix[m - 1][i] + " ");
                    arr.add(matrix[m - 1][i]);
                }
                m--;
            }

            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(matrix[i][l] + " ");
                    arr.add(matrix[i][l]);
                }
                l++;
            }
        }
		return arr;
    }
	


	static ArrayList<Integer> SpiralTraversal(int matrix[][], int n, int m)
    {
         int a=n;
        int b=m;
         ArrayList<Integer> arr=new ArrayList<Integer>();
       // boolean flag=true;
       //i=0
         int i=0;
       if(m==1){
          for(int j=0;j<a;j++){
                arr.add(matrix[j][i]);
               // System.out.println(arr.toString());
          } 
       }
       else if(n==1){
            for(int j=0;j<b;j++){
                arr.add(matrix[i][j]);
               // System.out.println(arr.toString());
          } 
       }
       else{
    	   int top=0;int bottom=n-1;
    	   int left=0; int right=m-1;
    	   while(top<(bottom+1) && left<(right+1)) {
            i=top;
          for(int j=left;j<=right;j++){
                arr.add(matrix[i][j]);
               // System.out.println("..1.."+arr.toString());
          }
          top++;
       i=right;
        for(int j=top;j<=bottom;j++){
                arr.add(matrix[j][i]);
             //   System.out.println("..2.."+arr.toString());
          }
        right--;
         if(top<=bottom) {
             i=bottom;
        for(int j=right;j>=left;j--){
            arr.add(matrix[i][j]);
          //     System.out.println("....3..."+arr.toString());
          }
        bottom--;
          }
       
          if(left<=right) {
           i=left;
        for(int j=bottom;j>=top;j--){
                arr.add(matrix[j][i]);
           //    System.out.println("...4..."+arr.toString());
          }
        left++;
          }
          
       }
       }
     return (arr);
    }
	
	 static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
	    {
	         int a=n;
	        int b=m;
	         ArrayList<Integer> arr=new ArrayList<Integer>();
	       // boolean flag=true;
	       //i=0
	         int i=0;
	       if(m==1){
	          for(int j=0;j<a;j++){
	                arr.add(matrix[j][i]);
	               // System.out.println(arr.toString());
	          } 
	       }
	       else if(n==1){
	            for(int j=0;j<b;j++){
	                arr.add(matrix[i][j]);
	               // System.out.println(arr.toString());
	          } 
	       }
	       else{
	     i=0;
	          for(int j=0;j<b-1;j++){
	                arr.add(matrix[i][j]);
	               // System.out.println(arr.toString());
	          }
	       i=m-1;
	        for(int j=0;j<n-1;j++){
	                arr.add(matrix[j][i]);
	               // System.out.println(arr.toString());
	          }
	           i=n-1;
	        for(int j=m-1;j>0;j--){
	                arr.add(matrix[i][j]);
	             //   System.out.println(arr.toString());
	          }
	           i=0;
	        for(int j=n-1;j>0;j--){
	                arr.add(matrix[j][i]);
	              //  System.out.println(arr.toString());
	          }
	          
	       }
	     return (arr);
	    }

}

/**
 * 
 * Given a 2D array, print it in spiral form. See the following examples.

Examples: 
 

Input:  {{1,    2,   3,   4},
              {5,    6,   7,   8},
             {9,   10,  11,  12},
            {13,  14,  15,  16 }}
Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
Explanation: The output is matrix in spiral format. 


Input: { {1,   2,   3,   4,  5,   6},
           {7,   8,   9,  10,  11,  12},
          {13,  14,  15, 16,  17,  18}}

Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
Explanation :The output is matrix in spiral format. 

Best Optimized Method 1: (Simulation Approach)

Intuition:
Draw the path that the spiral makes. We know that the path should turn clockwise whenever it would go out of bounds or into a cell that was previously visited.

Algorithm:
Let the array have R rows and C columns. seen[r][c][/c] denotes that the cell on the r-th row and c-th column was previously visited. Our current position is (r, c), facing direction di, and we want to visit R x C total cells.
As we move through the matrix, our candidate's next position is (cr, cc). If the candidate is in the bounds of the matrix and unseen, then it becomes our next position; otherwise, our next position is the one after performing a clockwise turn.

 


// Java program for the above approach
import java.util.*;

class Solution {

    // Function to print in spiral order
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();

        if (matrix.length == 0)
            return ans;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int x = 0, y = 0, di = 0;

        // Iterate from 0 to R * C - 1
        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];

            if (0 <= cr && cr < m && 0 <= cc && cc < n
                    && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(spiralOrder(a));
    }
}

 


Output
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 

Complexity Analysis:
 

Time Complexity: O(N), where N is the total number of elements in the input matrix. We add every element in the matrix to our final answer.
Auxiliary Space: O(N), the information stored in seen and in ans.


 

Method 2: This is a simple method to solve the following problem. 
Approach: The problem can be solved by dividing the matrix into loops or squares or boundaries. It can be seen that the elements of the outer loop are printed first in a clockwise manner then the elements of the inner loop is printed. So printing the elements of a loop can be solved using four loops that print all the elements. Every 'for' loop defines a single direction movement along with the matrix. The first for loop represents the movement from left to right, whereas the second crawl represents the movement from top to bottom, the third represents the movement from the right to left, and the fourth represents the movement from bottom to up.

Algorithm: 
Create and initialize variables k - starting row index, m - ending row index, l - starting column index, n - ending column index
Run a loop until all the squares of loops are printed.
In each outer loop traversal print the elements of a square in a clockwise manner.
Print the top row, i.e. Print the elements of the kth row from column index l to n, and increase the count of k.
Print the right column, i.e. Print the last column or n-1th column from row index k to m and decrease the count of n.
Print the bottom row, i.e. if k < m, then print the elements of m-1th row from column n-1 to l and decrease the count of m
Print the left column, i.e. if l < n, then print the elements of lth column from m-1th row to k and increase the count of l.
Below is the implementation of the above algorithm: 
 

// Java program to print a given matrix in spiral form
import java.io.*;

class GFG {

    // Function print matrix in spiral form
    static void spiralPrint(int m, int n, int a[][])
    {
        int i, k = 0, l = 0;

        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

            // Print the last row from the remaining rows 
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining
            // columns 
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int R = 4;
        int C = 4;
        int a[][] =  {{1, 2, 3, 4},
                   {5, 6, 7, 8},
                   {9, 10, 11, 12},
                   {13, 14, 15, 16}};

        // Function Call
        spiralPrint(R, C, a);
    }
}

// Contributed by Pramod Kumar

 


Output
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 

Complexity Analysis: 

Time Complexity: O(m*n). 
To traverse the matrix O(m*n) time is required.
Auxiliary Space: O(1). 
No extra space is required.


 

Method 3: (Recursive Approach)
Approach: The above problem can be solved by printing the boundary of the Matrix recursively. In each recursive call, we decrease the dimensions of the matrix. The idea of printing the boundary or loops is the same.
 

Algorithm: 
create a recursive function that takes a matrix and some variables (k - starting row index, m - ending row index, l - starting column index, n - ending column index) as parameters
Check the base cases (starting index is less than or equal to ending index) and print the boundary elements in clockwise manner
Print the top row, i.e. Print the elements of kth row from column index l to n, and increase the count of k.
Print the right column, i.e. Print the last column or n-1th column from row index k to m and decrease the count of n.
Print the bottom row, i.e. if k > m, then print the elements of m-1th row from column n-1 to l and decrease the count of m
Print the left column, i.e. if l < n, then print the elements of lth column from m-1th row to k and increase the count of l.
Call the function recursively with the values of starting and ending indices of rows and columns.
Below is the implementation of the above algorithm: 
 

// Java program for the above approach
import java.util.*;

class GFG {
    static int R = 4;
    static int C = 4;

    // Function for printing matrix in spiral
    // form i, j: Start index of matrix, row
    // and column respectively m, n: End index
    // of matrix row and column respectively
    static void print(int arr[][], int i, int j, int m,
                      int n)
    {
        // If i or j lies outside the matrix
        if (i >= m || j >= n) {
            return;
        }

        // Print First Row
        for (int p = i; p < n; p++) {
            System.out.print(arr[i][p] + " ");
        }

        // Print Last Column
        for (int p = i + 1; p < m; p++) {
            System.out.print(arr[p][n - 1] + " ");
        }

        // Print Last Row, if Last and
        // First Row are not same
        if ((m - 1) != i) {
            for (int p = n - 2; p >= j; p--) {
                System.out.print(arr[m - 1][p] + " ");
            }
        }

        // Print First Column, if Last and
        // First Column are not same
        if ((n - 1) != j) {
            for (int p = m - 2; p > i; p--) {
                System.out.print(arr[p][j] + " ");
            }
        }
        print(arr, i + 1, j + 1, m - 1, n - 1);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int a[][] = { { 1, 2, 3, 4 },
                      { 5, 6, 7, 8 },
                      { 9, 10, 11, 12 },
                      { 13, 14, 15, 16 } };

        // Function Call
        print(a, 0, 0, R, C);
    }
}

// This code is contributed by 29AjayKumar

 


Output
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
Complexity Analysis: 
 

Time Complexity: O(m*n). 
To traverse the matrix O(m*n) time is required.
Auxiliary Space: O(1). 
No extra space is required.
 * 
 * 
 * 
 */
