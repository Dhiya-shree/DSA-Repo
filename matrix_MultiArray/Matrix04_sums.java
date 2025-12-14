package matrix_MultiArray;

import java.util.ArrayList;
import java.util.Arrays;

import arrayCode.ArrayPart01;

/**
 * Problem #1: Matrix in Snakekuu pattern
 * Printing a matrix in a snake pattern is a programming technique in which the elements of a two-dimensional array are traversed in a zigzag pattern, resembling the movement of a snake. This approach provides a visually appealing output and can be useful in certain applications, such as displaying matrices or grids in a non-conventional manner.


Examples:

Input: mat[][] = { {1, 2, 3},
                   {4, 5, 6},
                   {7, 8, 9} };
Output: 1 2 3 6 5 4 7 8 9
 
 * 
 *  
 * Problem #2 : Bound TRaversal 
 * 
 * You are given a matrix of dimensions n x m. The task is to perform boundary traversal on the matrix in a clockwise manner.

Example 1:

Input:
n = 4, m = 4
matrix[][] = {{1, 2, 3, 4},
         {5, 6, 7, 8},
         {9, 10, 11, 12},
         {13, 14, 15,16}}
Output: 1 2 3 4 8 12 16 15 14 13 9 5
 *
 *Sol :
 *   Transpose 
 *   Interchange col 0 and n-1 ; 1 and n-2 ; 2 and n-3 so on....
 *
 *
 *Problem #3 : Spiral Traversal 
 *
 *The spiral traversal of a matrix is a fundamental operation that finds applications in tasks such as image processing, matrix manipulation, and graph algorithms. It allows us to access the elements of a matrix in a specific order, enabling efficient processing and analysis of the data it contains.

Examples:

Input:     {{1,    2,   3,   4},
            {5,    6,   7,   8},
            {9,   10,  11,  12},
            {13,  14,  15,  16 }}
Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 


Input:     {{1,   2,   3,   4,  5,   6},
            {7,   8,   9,  10,  11,  12},
            {13,  14,  15, 16,  17,  18}}
Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 

The process of spiral traversal follows a systematic pattern, where we traverse the matrix layer by layer, moving from the outermost layer towards the inner layers. At each layer, we visit the elements in a specific order, which can be visualized as a spiral path.
 *Method 2: This is a simple method to solve the following problem. 
Approach: The problem can be solved by dividing the matrix into loops or squares or boundaries. It can be seen that the elements of the outer loop are printed first in a clockwise manner then the elements of the inner loop is printed. So printing the elements of a loop can be solved using four loops that print all the elements. Every 'for' loop defines a single direction movement along with the matrix. The first for loop represents the movement from left to right, whereas the second crawl represents the movement from top to bottom, the third represents the movement from the right to left, and the fourth represents the movement from bottom to up.

Algorithm: 
Create and initialize variables k - starting row index, m - ending row index, l - starting column index, n - ending column index
Run a loop until all the squares of loops are printed.
In each outer loop traversal print the elements of a square in a clockwise manner.
Print the top row, i.e. Print the elements of the kth row from column index l to n, and increase the count of k.
Print the right column, i.e. Print the last column or n-1th column from row index k to m and decrease the count of n.
Print the bottom row, i.e. if k < m, then print the elements of m-1th row from column n-1 to l and decrease the count of m
Print the left column, i.e. if l < n, then print the elements of lth column from m-1th row to k and increase the count of l.
 * 
 * 
 * Problem #4 : Search in Row-wise and Column-wise sorted matrix
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


2) Efficient Approach:
In this approach, we consider the following steps:

Begin traversal from the top right corner/Bottom left corner - Not top left/Bottom right - as we wont know if we need to move horizontal / vertical 
If current element is the element to be found, then print the index
If current element < x, move downwards
If current element > x, move leftwards.
Time Complexity: O(R+C)
 * 
 * 
 * Problem #5 : Median of row wise sorted Matrix 
 * 
 * What is a Median?

Median is a statistical measure that represents the middle value in a set of data. It is a measure of central tendency, providing a representative value around which the data is distributed.

Finding the median in a row-wise sorted matrix is an important operation that has applications in various domains, including statistics, data analysis, and optimization problems. It allows us to quickly identify the central value of a matrix, providing insights into the distribution and characteristics of the data it represents.
 * 
 * xample:

Input: 1 3 5
       2 6 9
       3 6 9
Output: Median is 5
If we put all the values in a sorted array A[] = 1 2 3 3 5 6 6 9 9)

Input: 1 3 4
       2 5 6
       7 8 9
Output: Median is 5
 

We have 2 approaches to solve the problem: Naive approach and Efficient Approach

1) Naive Approach:
In this approach, all the elements of the matrix are put row-wise into an array. The array is further sorted and the median is found.

Time Complexity: O(r*c log(r*c))
 * 
 * 
 * 1) Efficient Approach:
This approach uses the following steps:

First, we find the minimum and maximum elements in the matrix. The minimum element can be easily found by comparing the first element of each row, and similarly, the maximum element can be found by comparing the last element of each row.
Then we use binary search on our range of numbers from minimum to maximum, we find the mid of the min and max and get a count of numbers less than or equal to our mid. And accordingly change the min or max.
For a number to be median, there should be (r*c)/2 numbers smaller than that number. So for every number, we get the count of numbers less than or equal to that by using upper_bound() in each row of the matrix, if it is less than the required count, the median must be greater than the selected number, else the median must be less than or equal to the selected number.
Time Complexity: O(r * log(max-min) * log(c))
 * 
 * @author shree
 *
 */
public class Matrix04_sums {

	public static void main(String[] args) {
		int mat[][] = { {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9} };
		
		ArrayList<Integer> ans=snakePattern(mat);
		System.out.println(" Val is "+ans.toString());
	
	
		int matrix[][] = {{1, 2, 3, 4},
				{9, 11, 12,13},
				{21,22,34,45},
		         {5, 6, 7, 8},
		         { 14, 15,16,17}};
		
		int n=matrix.length;
		int m=matrix[0].length;
		ans=boundaryTraversal(matrix, n, m);
		System.out.println("Boundary Traversal is "+ans.toString());
		
		ans=SpiralTraversal(matrix, n, m); //O n2 O 1
		System.out.println("Spiral Traversal is "+ans.toString());
		
		ans=SpiralTraversalGoG(matrix, n, m);//O n2 O 1
		System.out.println("Spiral Traversal is "+ans.toString());
		
	    SpiralTraversalGoGRecur(matrix,0,0, n, m);//O n2 O 1
		System.out.println("Spiral Traversal is by recur ");//+ans.toString());
		
		ans=SpiralTraversalOn_Best_Time(matrix);//O n O n
		System.out.println("Spiral Traversal is by O N best time "+ans);//+ans.toString());
	
	
	    boolean found=SearchInSorted2D(matrix,n,m,14);
	    System.out.println(" It is found is "+found);
	
	    searchInSorted2DGoG(matrix,n,14);
	    
	    // For only array with non duplicate values 
	    int median_ans=FindMedianInRowSortedArray(matrix,n,m);
	    System.out.println(" median is "+median_ans);
	    
	    median_ans=FindMedianInRowSortedGoG(matrix,n,m);
	    System.out.println(" median is "+median_ans);
	
	
	}
	
	static int FindMedianInRowSortedGoG(int m[][],int r, int c)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<r ; i++)
        {
            
            // Finding the minimum element
            if(m[i][0] < min)
                min = m[i][0];
            
            // Finding the maximum element
            if(m[i][c-1] > max)
                max = m[i][c-1];
        }
        
        int desired = (r * c + 1) / 2;
        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            
            // Find count of elements smaller than mid
            for(int i = 0; i < r; ++i)
            {
                
                get = Arrays.binarySearch(m[i],mid);
                
                // If element is not found in the array the 
                // binarySearch() method returns 
                // (-(insertion_point) - 1). So once we know 
                // the insertion point we can find elements
                // Smaller than the searched element by the 
                // following calculation
                if(get < 0)
                    get = Math.abs(get) - 1;
                
                // If element is found in the array it returns 
                // the index(any index in case of duplicate). So we go to last
                // index of element which will give  the number of 
                // elements smaller than the number including 
                // the searched element.
                else
                {
                    while(get < m[i].length && m[i][get] == mid)
                        get += 1;
                }
                
                place = place + get;
            }
            
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }
    
    // Driver Program to test above method.
	
	 private static int FindMedianInRowSortedArray(int[][] matrix, int n,int m) {
		// Given row sorted array 
		 // n --> ROW 
		 // m --> COL
		 int min=Integer.MAX_VALUE;int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			min=Math.min(matrix[i][0],min);
			max=Math.max(matrix[i][m-1],max);
		}
		
		int mid=0;//(min+max)/2;
		int mid_pos=0;
		int curr_mid_pos=0;
		int median_pos=(n*m+1)/2;
		
		//int left=min;int right=max;
		while(min<max) {
			mid=(min+max)/2;
			mid_pos=0;
			//int r=0;
			for(int i=0;i<n;i++) {
				//Check if the middle pos is in array 
				// Or return the pos where middle element is supposed to be 
				
				// For a sorted row - user binary search 
				// Check if middle present in row elements 
				// If not present pos= length of row 
				// If present at pos 0 = return 0 
				// If present at pos 2 = return 2
				// If it shoul be present between pos 2 and 3 = 3
				//index of the search key, if it is contained in the array;otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the
				//key would be inserted into the array: the index of the firstelement greater than the key, or a.length if allelements in the array are less than the specified key. Notethat this guarantees that the return value will be >= 0 ifand only if the key is found.
				
				// if else is not present at a , it will give n as ans , so adding 1
				System.out.println(" Current mid is "+mid+" left "+min+" right "+max);
				System.out.println(" search for array :");
				ArrayPart01.PrintRayy(matrix[i]);
				curr_mid_pos=Arrays.binarySearch(matrix[i],mid)+1;
				
				// ADD all pos to mid pos 
				System.out.println(" Found curr pos "+curr_mid_pos);
				mid_pos=mid_pos+Math.abs(curr_mid_pos);
				
				System.out.println(" Found mid_pos:"+mid_pos);
			}
			
			
			System.out.println(" Final mid pos "+mid_pos+" Median pos"+median_pos);
			if(mid_pos<median_pos) {
				min=mid+1;
			}
			else {
				// we dont stop at mid 
				// we keep on search including mid 
				
				max=mid;
			}
		}
		
		return min;
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
	 static ArrayList<Integer> snakePattern(int matrix[][])
	    {
	        // code here 
	        int a=matrix.length;
	        int b=matrix[0].length;
	         ArrayList<Integer> arr=new ArrayList<Integer>();
	        boolean flag=true;
	         for(int i=0;i<a;i++){
	             if(flag==true){
	              for(int j=0;j<b;j++){
	                arr.add(matrix[i][j]);
	              }
	              flag=false;
	             }
	             else{
	                for(int j=b-1;j>-1;j--){
	                   arr.add(matrix[i][j]);
	              }
	              flag=true;
	             }
	          }
	     return (arr);
	         //  System.out.println();
	    }
}

/**
 * 
 * Median of a Row Wise Sorted Matrix

We are given a row-wise sorted matrix of size r*c, we need to find the median of the matrix given. It is assumed that r*c is always odd.
Examples: 
 

Input : 1 3 5
        2 6 9
        3 6 9
Output : Median is 5
If we put all the values in a sorted 
array A[] = 1 2 3 3 5 6 6 9 9)

Input: 1 3 4
       2 5 6
       7 8 9
Output: Median is 5
 

Simple Method: The simplest method to solve this problem is to store all the elements of the given matrix in an array of size r*c. Then we can either sort the array and find the median element in O(r*clog(r*c)) or we can use the approach discussed here to find the median in O(r*c). Auxiliary space required will be O(r*c) in both cases.
An efficient approach for this problem is to use a binary search algorithm. The idea is that for a number to be median there should be exactly (n/2) numbers that are less than this number. So, we try to find the count of numbers less than all the numbers. Below is the step by step algorithm for this approach: 
Algorithm:  

First, we find the minimum and maximum elements in the matrix. The minimum element can be easily found by comparing the first element of each row, and similarly, the maximum element can be found by comparing the last element of each row.
Then we use binary search on our range of numbers from minimum to maximum, we find the mid of the min and max and get a count of numbers less than or equal to our mid. And accordingly change the min or max.
For a number to be median, there should be (r*c)/2 numbers smaller than that number. So for every number, we get the count of numbers less than that by using upper_bound() in each row of the matrix, if it is less than the required count, the median must be greater than the selected number, else the median must be less than or equal to the selected number.
Below is the implementation of the above approach:

 


// Java program to find median of a matrix
// sorted row wise
import java.util.Arrays;

public class MedianInRowSorted 
{
    // function to find median in the matrix
    static int binaryMedian(int m[][],int r, int c)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<r ; i++)
        {
            
            // Finding the minimum element
            if(m[i][0] < min)
                min = m[i][0];
            
            // Finding the maximum element
            if(m[i][c-1] > max)
                max = m[i][c-1];
        }
        
        int desired = (r * c + 1) / 2;
        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            
            // Find count of elements smaller than mid
            for(int i = 0; i < r; ++i)
            {
                
                get = Arrays.binarySearch(m[i],mid);
                
                // If element is not found in the array the 
                // binarySearch() method returns 
                // (-(insertion_point) - 1). So once we know 
                // the insertion point we can find elements
                // Smaller than the searched element by the 
                // following calculation
                if(get < 0)
                    get = Math.abs(get) - 1;
                
                // If element is found in the array it returns 
                // the index(any index in case of duplicate). So we go to last
                // index of element which will give  the number of 
                // elements smaller than the number including 
                // the searched element.
                else
                {
                    while(get < m[i].length && m[i][get] == mid)
                        get += 1;
                }
                
                place = place + get;
            }
            
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }
    
    // Driver Program to test above method.
    public static void main(String[] args) 
    {
        int r = 3, c = 3;
        int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };
        
        System.out.println("Median is " + binaryMedian(m, r, c));
    }
}

// This code is contributed by Sumit Ghosh

 


Output
Median is 5

Time Complexity: O(32 * r * log(c)). The upper bound function will take log(c) time and is performed for each row. And since the numbers will be max of 32 bit, so binary search of numbers from min to max will be performed in at most 32 ( log2(2^32) = 32 ) operations. 
Auxiliary Space: O(1) 
 * 
 * 
 */

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
/*
 * 
 * Matrix Rotation

Given a Square Matrix of dimension N * N. The task is to rotate the matrix in anti-clock wise direction by 90 degrees.



On observing carefully, we can easily conclude that:
first row of destination ------> last column of source
second row of destination ------> second last column of source
.
.
.
.
last row of destination ------> first column of source


Therefore, rotating a matrix in anti-clockwise direction by 90 degrees is equivalent to replacing rows from top of the matrix by columns from the end.

Implementation of above approach: This method can be easily implemented by using extra space. The idea is to create a temporary matrix of same dimensions as that of the orginal matrix and copy the original matrix into this temporary matrix. Finally, replace each row in the orginal matrix one by one by columns of the temporary matrix from last to first.

Algorithm:
Original Matrix: mat[N][N].
Temporary Matrix: temp[N][N].

Copy original matrix into temporary matrix:
for(i = 0; i < N; i++)
{
    for(j = 0; j < N; j++)
    {
        temp[i][j] = mat[i][j];
    }
}

Updating Original Matrix by Rotated Matrix:
// Replace each row in the orginal matrix one by 
// one by columns of the temporary matrix from 
// last to first
for(i = 0; i < N; i++)
{
    for(j = 0; j < N; j++)
    {
        mat[i][j] = temp[j][N-i-1];
    }
}



Without Using Extra Space

The above problem can also be solved without using any addition matrix or extra-space. This is also called in-place rotating a square matrix by 90 degrees in anti-clockwise direction.

An N x N matrix will have floor(N/2) square cycles. For example, a 4 X 4 matrix will have 2 cycles. The first cycle is formed by its 1st row, last column, last row and 1st column. The second cycle is formed by 2nd row, second-last column, second-last row and 2nd column.

The idea is for each square cycle, we swap the elements involved with the corresponding cell in the matrix in anti-clockwise direction i.e. from top to left, left to bottom, bottom to right and from right to top one at a time. We use nothing but a temporary variable to achieve this.

Below steps demonstrate the idea:
First Cycle (Involves Red Elements)
 1  2  3 4 
 5  6  7  8 
 9 10 11 12 
 13 14 15 16 

 
Moving first group of four elements (First
elements of 1st row, last row, 1st column 
and last column) of first cycle in counter
clockwise. 
 4  2  3 16
 5  6  7 8 
 9 10 11 12 
 1 14  15 13 
 
Moving next group of four elements of 
first cycle in counter clockwise 
 4  8  3 16 
 5  6  7  15  
 2  10 11 12 
 1  14  9 13 

Moving final group of four elements of 
first cycle in counter clockwise 
 4  8 12 16 
 3  6  7 15 
 2 10 11 14 
 1  5  9 13 


Second Cycle (Involves Blue Elements)
 4  8 12 16 
 3  6 7  15 
 2  10 11 14 
 1  5  9 13 

Fixing second cycle
 4  8 12 16 
 3  7 11 15 
 2  6 10 14 
 1  5  9 13


Below function in-place rotates a square matrix by 90 degrees counter-clockwise:

// An Inplace function to rotate a N x N matrix 
// by 90 degrees in anti-clockwise direction 
void rotateMatrix(int mat[][N]) 
{ 
    // Consider all squares one by one 
    for (int i = 0; i < N / 2; i++) 
    { 
        // Consider elements in group of 4 in 
        // current square 
        for (int j = i; j < N-i-1; j++) 
        { 
            // store current cell in temp variable 
            int temp = mat[i][j]; 

            // move values from right to top 
            mat[i][j] = mat[j][N-1-i]; 

            // move values from bottom to right 
            mat[j][N-1-i] = mat[N-1-i][N-1-j]; 

            // move values from left to bottom 
            mat[N-1-i][N-1-j] = mat[N-1-j][i]; 

            // assign temp to left 
            mat[N-1-j][i] = temp; 
        } 
    } 
} 
 * 
 * 
 */
