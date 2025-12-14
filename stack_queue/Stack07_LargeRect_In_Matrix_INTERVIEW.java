package stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class Stack07_LargeRect_In_Matrix_INTERVIEW {

	public static void main(String[] args) {
		// Hard ques 
		
		/**
		 * Algo :
		 * 
		 *  --> Convert each row to histogram 
		 *  --> row 0 as it is 
		 *  --> row 1 if val=1 : row1+row0
		 *            if val=0 : row1 
		 * 
		 * Thus at each row , we form unit 1 rectangle with above elements 
		 * Now find max rectangle for each row 
		 * Max area is the answer 
		 * 
		 */
		int matrix[][]= {
				{1,0,0,0,1,1},
				{1,1,1,1,1,1},
				{1,1,1,1,1,1},
				{1,1,1,1,1,1},
				{1,1,1,1,0,0},
				{1,1,1,1,0,1},
				{1,1,1,1,0,0},
				{1,0,0,0,1,1}
		};
		
		int maxArea=EfficientmaxRectangleGoG(matrix,matrix.length,matrix[0].length);
		System.out.println(" Value of area "+maxArea);
		
		 maxArea=FindTheMaxAreaEfficient(matrix,matrix.length,matrix[0].length);
		System.out.println(" Value of area "+maxArea);


	}
	
	// Returns area of the largest rectangle with all 1s in
    // A[][]
    private static int EfficientmaxRectangleGoG( int A[][],int R, int C)
    {
        // Calculate area for first row and initialize it as
        // result
        int result = maxHist(R, C, A[0]);

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++) {

            for (int j = 0; j < C; j++)

                // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];

            // Update result if area with current row (as
            // last row of rectangle) is more
            result = Math.max(result, maxHist(R, C, A[i]));
        }

        return result;
    }
	
	
	// Finds the maximum area under the histogram
    // represented by histogram.  See below article for

    private static int maxHist(int R, int C, int row[])
    {
        // Create an empty stack. The stack holds indexes of
        // hist[] array/ The bars stored in stack are always
        // in increasing order of their heights.
        Stack<Integer> result = new Stack<Integer>();

        int top_val; // Top of stack

        int max_area = 0; // Initialize max area in current
        // row (or histogram)

        int area = 0; // Initialize area with current top

        // Run through all bars of given histogram (or row)
        int i = 0;
        while (i < C) {
            // If this bar is higher than the bar on top
            // stack, push it to stack
            if (result.empty()
                || row[result.peek()] <= row[i])
                result.push(i++);

            else {
                // If this bar is lower than top of stack,
                // then calculate area of rectangle with
                // stack top as the smallest (or minimum
                // height) bar. 'i' is 'right index' for the
                // top and element before top in stack is
                // 'left index'
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.empty())
                    area
                        = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }

        // Now pop the remaining bars from stack and
        // calculate area with every popped bar as the
        // smallest bar
        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
    
    
	static int RowArea[][];static int count=0;
	private static int FindTheMaxAreaEfficient(int[][] matrix, int R, int C) {
		// Time O R * C 
		// Consider every row as histogram bar 
		// Find the largest area for every point 
		// Instead of largest area find all area 
		RowArea=matrix;
        System.out.println(" Row area 0 "+Arrays.toString(RowArea[0]));
		System.out.println(" Addded row area ");
		
		
		
		// We have converted at each row we have column length 
		for(int i=1;i<R;i++) {
			System.out.print(" Row area "+i+" "+Arrays.toString(RowArea[i]));
			RowArea[i]=MatrixAdd(RowArea[i],RowArea[i-1],C);
			System.out.println(" ====> "+Arrays.toString(RowArea[i]));
		}
		
		// Send the individual row to find max area of histograms 
		int max=0;int curr=0;
		for(int i=0;i<R;i++) {
			curr=BetterLargeAreaMax(RowArea[i],C);
			max=Math.max(max,curr);
			System.out.println(" Row :"+ Arrays.toString(RowArea[i])+" Area "+curr);
		}
		
		
		return max;
	}

	private static int[] MatrixAdd(int[] m1, int[] m2,int n) {
		// Adding matrix 
		
		for(int i=0;i<n;i++) {
			m1[i]=m1[i]+(m2[i]*m1[i]);
		}
		
		return m1;
	}


	private static int BetterLargeAreaMax(int[] bar, int n) {
		// Pre calculation 
		/*
		 * *  Instead of counting left and right larger elements 
         *  Find left and rightmost smaller elements 
         *  With index of left and right smaller elements 
         *  We can find left and right count and proceed with area 
         *   Area= currval*(left+right+1)  
		 */
		int left[]=PreviousSmallerElement(bar,n);
		int right[]=NextSmallerElement(bar,n);
		System.out.println(" Bar   "+Arrays.toString(left));
		System.out.println(" Left  "+Arrays.toString(left));
		System.out.println(" Right "+Arrays.toString(right));
		
		int max_area=0;
		int area[]=new int[n];
		
		for(int i=0;i<n;i++) {
			area[i]=bar[i]*(left[i]+right[i]+1);
			max_area=Math.max(area[i],max_area);
		}
		RowArea[count]=area;
		count++;
		return max_area;
	}
	private static int[] NextSmallerElement(int[] arr, int n) {
		// Next smaller element
		Stack<Integer> s = new Stack<>();
		int ans[] = new int[n];

		ans[n-1] = 0;
		s.push(n-1);

		for (int i = n-2; i >=0; i--) {

			while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
				s.pop();
			}

			// Careful here -> Customized for right
			if (s.isEmpty()) {
				ans[i] = n-i-1;
			} else {
				ans[i] = s.peek()-i-1;
			}

			s.push(i);

		}

		return ans;
	}

	private static int[] PreviousSmallerElement(int[] arr, int n) {
		// Previous smaller element
		Stack<Integer> s=new Stack<>();
		int ans[]=new int[n];
		
		ans[0]=0;
		s.push(0);
		
		for(int i=1;i<n;i++) {
			
			while(!s.isEmpty() && arr[s.peek()]>=arr[i]) {
				s.pop();
			}
			
			// Careful here -> Customized for left
			if(s.isEmpty()) {
				ans[i]=i;
			}
			else {
				ans[i]=i-s.peek()-1;
			}
			
			s.push(i);
			
		}
		
		return ans;
	}


//	private static int FindTheMaxAreaNaive(int[][] matrix, int length, int length2) {
//		// Naive O R3* C3
//		// For every point in matrix 
//		// Check the row and column for every possible rectngle 
//		
//		return 0;
//	}

}

/*

Largest Rectangle with all 1's

Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1's. 

Example: 

Input:
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
Output :
8
Explanation : 
The largest rectangle with only 1's is from 
(1, 0) to (2, 3) which is
1 1 1 1
1 1 1 1 

Input:
0 1 1
1 1 1
0 1 1      
Output:
6
Explanation : 
The largest rectangle with only 1's is from 
(0, 1) to (2, 2) which is
1 1
1 1
1 1
 

Approach: 

In this article, an interesting method is discussed that uses largest rectangle under histogram as a subroutine. 

If the height of bars of the histogram is given then the largest area of the histogram can be found. This way in each row, the largest area of bars of the histogram can be found. To get the largest rectangle full of 1's, update the next row with the previous row and find the largest area under the histogram, i.e. consider each 1's as filled squares and 0's with an empty square and consider each row as the base.

Illustration: 

Input :
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
Step 1: 
0 1 1 0  maximum area  = 2
Step 2:
row 1  1 2 2 1  area = 4, maximum area becomes 4
row 2  2 3 3 2  area = 8, maximum area becomes 8
row 3  3 4 0 0  area = 6, maximum area remains 8
Algorithm: 

Run a loop to traverse through the rows.
Now If the current row is not the first row then update the row as follows, if matrix[i][j] is not zero then matrix[i][j] = matrix[i-1][j] + matrix[i][j].
Find the maximum rectangular area under the histogram, consider the ith row as heights of bars of a histogram. This can be calculated as given in this article Largest Rectangular Area in a Histogram
Do the previous two steps for all rows and print the maximum area of all the rows.
Note: It is strongly recommended to refer to Largest Area in Histogram post first as most of the code is taken from there. 

Implementation 

// Java program to find largest rectangle with all 1s
// in a binary matrix
import java.io.*;
import java.util.*;

class GFG {
    // Finds the maximum area under the histogram
    // represented by histogram.  See below article for

    static int maxHist(int R, int C, int row[])
    {
        // Create an empty stack. The stack holds indexes of
        // hist[] array/ The bars stored in stack are always
        // in increasing order of their heights.
        Stack<Integer> result = new Stack<Integer>();

        int top_val; // Top of stack

        int max_area = 0; // Initialize max area in current
        // row (or histogram)

        int area = 0; // Initialize area with current top

        // Run through all bars of given histogram (or row)
        int i = 0;
        while (i < C) {
            // If this bar is higher than the bar on top
            // stack, push it to stack
            if (result.empty()
                || row[result.peek()] <= row[i])
                result.push(i++);

            else {
                // If this bar is lower than top of stack,
                // then calculate area of rectangle with
                // stack top as the smallest (or minimum
                // height) bar. 'i' is 'right index' for the
                // top and element before top in stack is
                // 'left index'
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.empty())
                    area
                        = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }

        // Now pop the remaining bars from stack and
        // calculate area with every popped bar as the
        // smallest bar
        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }

    // Returns area of the largest rectangle with all 1s in
    // A[][]
    static int maxRectangle(int R, int C, int A[][])
    {
        // Calculate area for first row and initialize it as
        // result
        int result = maxHist(R, C, A[0]);

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++) {

            for (int j = 0; j < C; j++)

                // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];

            // Update result if area with current row (as
            // last row of rectangle) is more
            result = Math.max(result, maxHist(R, C, A[i]));
        }

        return result;
    }

    // Driver code
    public static void main(String[] args)
    {
        int R = 4;
        int C = 4;

        int A[][] = {
            { 0, 1, 1, 0 },
            { 1, 1, 1, 1 },
            { 1, 1, 1, 1 },
            { 1, 1, 0, 0 },
        };
        System.out.print("Area of maximum rectangle is "
                         + maxRectangle(R, C, A));
    }
}

Output
Area of maximum rectangle is 8
Complexity Analysis:  

Time Complexity: O(R x C). 
Only one traversal of the matrix is required, so the time complexity is O(R X C)
Space Complexity: O(C). 
Stack is required to store the columns, so space complexity is O(C)

*/