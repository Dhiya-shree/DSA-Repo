package matrix_MultiArray;

import arrayCode.ArrayPart01;

/**
 * A beautiful matrix is a matrix in which the sum of elements in each row and column is equal. 
 * Given a square matrix of size NxN. Find the minimum number of operation(s) that are required
 *  to make the matrix beautiful. In one operation you can increment the value of any one cell by 1.
 * 
 * 
 * 
 * @author shree
 *
 */
public class Beautifull_Matrix {

	public static void main(String[] args) {
		// Beautify
         int mat[][]= {{1,2,3,4},
        		       {5,6,7,8},
        		       {9,10,11,12},
        		       {5,9,9,10}};
         int n=mat.length;
         
         BeautifyMatrix(mat,n);
         
	}

	private static void BeautifyMatrix(int[][] mat, int n) {
		// sum col and sum row should be same 
		int row[]=new int[n];
		int col[]=new int[n];
		int max[]=new int[n];
		int min[]=new int[n];
		int max_row=0;
		int max_col=0;
		int sum_row=0;
		int sum_col=0;
		int max_sum=0;
		
		// Below can be used only when max in col and max in row are same 
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				row[i]=mat[i][j]+row[i];
				col[i]=mat[j][i]+col[i];
			}
			max[i]=Math.max(row[i],col[i]);		
			min[i]=Math.min(row[i],col[i]);
			max_row=Math.max(row[i],max_row);	
			max_col=Math.max(col[i],max_col);
			max_sum=Math.max(max_col,max_row);
			sum_row=sum_row+row[i];
			sum_col=sum_col+col[i];
		}
		
		System.out.println(" max col "+max_col+"..sum col "+sum_col);
		System.out.println(" max row "+max_row+"..sum row "+sum_row);
		
		int changes=0;
		System.out.println(" Max sum "+max_sum);
		for(int i=0;i<n;i++) {
			changes=changes+(max_sum-row[i]);
		}
		System.out.println(" Changes "+changes);
		
		
		
		
		System.out.println(" Column sum ");
		ArrayPart01.PrintRayy(col);
		System.out.println(" Row sum ");
		ArrayPart01.PrintRayy(row);
		System.out.println(" Max  sum ");
		ArrayPart01.PrintRayy(max);
		System.out.println(" Min  sum ");
		ArrayPart01.PrintRayy(min);
	}

}
/*
 * 
 * Brute Force Approach
Intuition
A brute-force approach for this problem would involve trying out all possible combinations of incrementing matrix elements to achieve equal row and column sums.  This approach might not be the most efficient for large matrices.

Implementation
 Generate All Possible Combinations:
Generate all possible combinations of increments for matrix elements. For each element, you can increment it by any non-negative integer value.
You can use nested loops to iterate through each matrix element and try all possible increments.
 Check for Equal Sums:
For each combination of increments, calculate the sum of each row and column in the modified matrix.
Check if all row sums and column sums are equal. If they are, you've found a solution.
Count Operations:
Keep track of the number of operations (increments) required for each combination.
Find the Minimum Operations:
Among all combinations that result in equal row and column sums, find the one that requires the minimum number of operations.
Return Result.
Code
class Solution:
    def findMinOpeartion(self, matrix, n):
        def allPossibleCombinations(matrix, n):
            # Recursive generator to generate all possible combinations of increments
            if n == 0:
                yield []
                return
            for i in range(101):  # Increment by at most 100 (adjust as needed)
                for combination in allPossibleCombinations(matrix, n - 1):
                    yield [i] + combination
        def applyIncrements(matrix, n, increments):
            # Apply increments to the matrix and return the modified matrix
            modifiedMatrix = [row[:] for row in matrix]
            for i in range(n):
                for j in range(n):
                    modifiedMatrix[i][j] += increments[i * n + j]
            return modifiedMatrix

        def hasEqualSums(matrix, n):
            # Check if all row sums and column sums are equal
            sumRow = [sum(row) for row in matrix]
            sumCol = [sum(matrix[i][j] for i in range(n)) for j in range(n)]
            return all(val == sumRow[0] for val in sumRow) and all(val == sumCol[0] for val in sumCol)

        minOperations = float('inf')
        for combination in allPossibleCombinations(matrix, n * n):
            modifiedMatrix = applyIncrements(matrix, n, combination)

            if hasEqualSums(modifiedMatrix, n):
                minOperations = min(minOperations, sum(combination))

        return minOperations
Complexity
Time Complexity: O(100^(n^2)), where 'n' is the size of the matrix (assuming each element can be incremented by at most 100).
Space Complexity: O(n^2) (matrix storage) + O(n^2) (combinations generator) + O(n^2) (modified matrix storage) + O(n) (row and column sum arrays) + O(1) (auxiliary variables) = O(n^2). So, the space complexity of the brute-force approach is O(n^2), which grows quadratically with the size of the matrix 'n'.

Expected Approach
Intuition
The aim is to balance the sums of rows and columns by incrementing matrix elements in a way that minimizes the total number of operations. Here ,we will iteratively adjust elements in the matrix and update the corresponding row and column sums until the desired equal sums are achieved. We design the algo in such a way that it ensures efficient balancing of the matrix without unnecessary operations.

Example


 

Implementation
Initialize two arrays, sumRow and sumCol, both of size n, to store the sum of elements in each row and each column, respectively.
Loop through each element in the matrix and calculate the sums of rows and columns by accumulating the element values.
Find the maximum sum value among the sums of rows and columns. This value (maxSum) represents the target sum that we want to achieve for all rows and columns.
Initialize a variable count to keep track of the number of operations required to equalize the sums and  two pointers, i and j, to keep track of the current row and column, respectively.
Enter a loop that continues until both i and j are within the range [0, n):
Find the minimum difference (diff) between maxSum and the sum of the current row i and the sum of the current column j. This represents the amount needed to increment the current element to achieve the target sum.
Increment the current matrix element, update the sum of the current row, and update the sum of the current column by adding the calculated difference (diff).
Increment the count by the calculated difference (diff).
If the sum of the current row is now equal to maxSum, increment i to move to the next row.
If the sum of the current column is now equal to maxSum, increment j to move to the next column.
Return the final value of count
Code
class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        int sumRow[]=new int[N];
        int sumCol[]=new int[N];
        
        //calculating sumRow[] and sumCol[] array.
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                sumRow[i] += matrix[i][j];
                sumCol[j] += matrix[i][j];
            }
        }
                
        //finding maximum sum value in either row or in column.
        int maxSum = 0;
        for (int i = 0; i < N; ++i)
        {
            maxSum = Math.max(maxSum, sumRow[i]);
            maxSum = Math.max(maxSum, sumCol[i]);
        }
        
        int count = 0;
        for (int i = 0, j = 0; i < N && j < N;) 
        {
            //finding minimum increment required in either row or column.
            int diff = Math.min(maxSum - sumRow[i],  maxSum - sumCol[j]);
            
            //adding difference in corresponding cell,
            //sumRow[] and sumCol[] array.
            matrix[i][j] += diff;
            sumRow[i] += diff;
            sumCol[j] += diff;
            
            //updating the result.
            count += diff;
            
            //if ith row is satisfied, incrementing i for next iteration.
            if (sumRow[i] == maxSum)
                ++i;
            
            //if jth column is satisfied, incrementing j for next iteration.
            if (sumCol[j] == maxSum)
                ++j;
        }
        //returning the result.
        return count;
    }
}
Complexity
Time Complexity: As we are traversing the matrix entirely hence O(N*N)
Space Complexity: O(N) space will be required to store the sum of elements in each row and column.

Alternate Approach:
Intuition:
The idea in this is to calculate the maximum sum among all the rows and columns and then multiply that maximum value with n and subtract it with the sum of all the elements in the current matrix and we will get the minimum number of operations to make matrix beautiful.

Implementation:
Initialize two variables ans equal to 0 and ans2 equal to 0 to keep track of the maximum sum in rows and columns, respectively, and total equal to 0 to store the sum of all elements in the matrix.
Run a loop from i = 0 to n.
Initialize a variables sum equal to 0 and sum2 equal to 0.
Run a loop from j = 0 to n.
Add matrix[i][j] to the variable sum, matrix[j][i] to the variable sum2 and matrix[i][j] to the variable total.
Update ans with max(sum,ans) and ans2 with max(sum2,ans2).
Calculate the total number of operations by multiplying the number of rows or column(i.e. n) by the maximum of ans and ans2, and then subtracting the total sum, and return this value as the minimum operations required (i.e n*max(ans,ans2)-total).
Code:
class Solution
{
    public:
    //Function to find minimum number of operations that are required 
    //to make the matrix beautiful.
    int findMinOpeartion(vector<vector<int> > matrix, int n)
    {
        int ans=0; 
        int ans2=0; 
        int total=0; 
        
        for(int i=0; i<n; i++){ 
            int sum=0;
            int sum2=0; 
            for(int j=0;j<n; j++){
                sum+=matrix[i][j]; 
                sum2+=matrix[j][i]; 
                total+=matrix[i][j];
                } 
                ans=max(sum,ans);
                ans2=max(sum2,ans2); 
            
        } 
        
        return n*max(ans,ans2)-total;
    } 
};
Complexity:
Time Complexity: O(n2), As we are traversing the matrix only once.
Space Complexity: O(1), As we are not using any extra space.
 * 
 * 
 */
