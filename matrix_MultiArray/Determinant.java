package matrix_MultiArray;

import arrayCode.ArrayPart01;

/**
 *  Determinant of Matrix 
 * Determinant of a Matrix is a special number that is defined only for square matrices (matrices which have the same number of rows and columns). The determinant is used at many places in calculus and other concepts related to algebra, it actually represents the matrix in term of a real number which can be used in solving a system of linear equations and finding the inverse of a matrix.

How to calculate Determinant?


The value of the determinant of a matrix can be calculated by the following procedure:

For each element of the first row or first column get cofactor of those elements and then multiply the element with the determinant of the corresponding cofactor, and finally add them with alternate signs. As a base case, the value of the determinant of a 1*1 matrix is the single value itself.


Cofactor of an element, is a matrix which we can get by removing row and column of that element from that matrix.
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Determinant {

	public static void main(String[] args) {
		int matn[][]={{1, 0, 2, -1},
	               {3, 0, 0, 5},
	               {2, 1, 4, -3},
	               {1, 0, 5, 0}};
	       
	       int matNn=matn.length;
	       int ans=FindDeterminant(matn,matNn);
	       System.out.println("Determinant"+ans);
	       
		}
		
		 private static int FindDeterminant(int[][] mat, int n) {
			// Determinant 
			 if(n==1){
				 System.out.println(" Returing last element "+mat[0][0]);
				return mat[0][0]; 
			 }
			 if(n==2) {
				 System.out.println(" Returing 2D element "+((mat[0][0]*mat[1][1])-(mat[0][1]*mat[1][0])));
				 return ((mat[0][0]*mat[1][1])-(mat[0][1]*mat[1][0]));
				 
			 }
			 System.out.println(" Int n Value "+n);
			 int ans=0;boolean flag=true;int val=0;
			 for(int i=0;i<n;i++) {
				 //Lets find determinant for row 0 
				 //Always sending row as 0 
				 
				 if(mat[0][i]==0 && flag==true) {
					 flag=false;
					 continue;
				 }
				 else if(mat[0][i]==0 && flag==false) {
					 flag=true;
					 continue;
				 }
				 val=FindDeterminantCoFact(mat,0,i,n,mat[0][i]);
				 System.out.println(" For 0,"+i+" val :"+mat[0][i]+"...Gives deteminant of "+val);
				 if(flag==true) {
					 ans=ans+val;
					 flag=false;
				 }
				 else {
					 ans=ans+(-1*val);
					 flag=true;
				 }
				 
			 }
			return ans;
		}

		private static int FindDeterminantCoFact(int[][] mat, int r, int c,int n,int value) {
			// Find determinant 
			if(value==0) {
				return 0;
			}
			int newN=n-1;
			int matrix[][]=new int[newN][newN];
			
			
			int col=0;
			int row=0;
			for(int i=0;i<n;i++ ) {
				for(int j=0;j<n;j++) {
					if(col==n-1) {
						col=0;
						row++;
					}
					if(i!=r && j!=c) {
						matrix[row][col]=mat[i][j];
						col++;
					}
				}
			}
			System.out.println(" New matrix of len:"+newN+" for val "+value +" for r-c"+r+"-"+c);
			ArrayPart01.PrintRayy2D(matrix, newN, newN);
			int deter2=FindDeterminant(matrix,n-1);
			System.out.println(" determinant for above matrix is "+deter2);
			return (deter2*value);
		}
}
/**
 * Determinant:- The determinant of a Matrix is defined as a special number that is defined only for square matrices (matrices that have the same number of rows and columns). A determinant actually represents the matrix in terms of a real number which can be used in solving a system of a linear equation and finding the inverse of a matrix. The determinant of a product of matrices is the product of their determinants.

Expected Approach
Intuition
The value of the determinant can be calculated by using these 3 steps:-

For each element of the first row or first column get the cofactor of those elements(The cofactor of an element is a matrix that we can get by removing the row and column of that element from that matrix.).
Then multiply the element with the determinant of the corresponding cofactor. 
Finally, add them with alternate signs. As a base case, the value of the determinant of a 1*1 matrix is the single value itself. 
Example:
Determinant of 2 x 2 Matrix:


 
Determinant of 3 x 3 Matrix: 


 
Implementation
Steps:-

First, check if the size of the matrix is 1x1 then return the matrix element(base case).
Create a 2D array to store the cofactor and a D variable to store the determinant value.
Now run a loop from 0 to n-1.
Find the cofactor for the element of the first row.
Then recursively call to find determinants of all cofactor matrices.
Now multiply the determinant of the cofactor with its corresponding element with alternate signs and then add this value to the D(determinant) variable.
Return the determinant.
Complexity
Time Complexity: O(N4),
Space Complexity: O(N2), Space used for storing cofactors.



class Solution
{
    //Function to get cofactor of matrix[p][q] in temp[][]. 
    static void getCofactor(int matrix[][], int temp[][], int p, int q, int n)
    {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                //copying only those elements into temporary matrix 
                //which are not in given row and column.
                if(row != p && col != q)
                {
                    temp[i][j++] = matrix[row][col];

                    //if row is filled, we increase row index and
                    //reset column index.
                    if(j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
         }
    }
    
    
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        int D = 0; 

        //base case
        if (n == 1)
            return matrix[0][0];

        //creating a list to store Cofactors.
        int temp[][]  = new int[n][n];

        int sign = 1;

        //iterating for each element of first row.
        for (int i = 0; i < n; i++)
        {
            //getting Cofactor of matrix[0][i].
            getCofactor(matrix, temp, 0, i, n);
            D += sign * matrix[0][i] * determinantOfMatrix(temp, n - 1);

            //terms are to be added with alternate sign so changing the sign.
            sign = -sign;
        }
        //returning the determinant.
        return D;
    }
}
Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/determinant-of-a-matrix/
 * 
 * 
 * 
 */
/*
Determinant of a Matrix | Explanation

What is the Determinant of a Matrix?


Determinant of a Matrix is a special number that is defined only for square matrices (matrices which have the same number of rows and columns). The determinant is used at many places in calculus and other concepts related to algebra, it actually represents the matrix in term of a real number which can be used in solving a system of linear equations and finding the inverse of a matrix.

How to calculate Determinant?


The value of the determinant of a matrix can be calculated by the following procedure:

For each element of the first row or first column get cofactor of those elements and then multiply the element with the determinant of the corresponding cofactor, and finally add them with alternate signs. As a base case, the value of the determinant of a 1*1 matrix is the single value itself.


Cofactor of an element, is a matrix which we can get by removing row and column of that element from that matrix.

Examples



Determinant of 2 x 2 Matrix:
A = | a   b |
    | c   d |

|A| = (ad - bc)



22

Determinant of 3 x 3 Matrix:
    | a b c |
A = | d e f |
    | g h i |

|A| = a(ei - fh) - b(di - gf) + c(dh - eg)





Calculating Determinant of an NxN Matrix


To calculate determinant of an NxN matrix, we will create two functions namely:
determinantOfMatrix(): This function will accept two parameters, the matrix and its dimension and will return the value of the determinant of the given matrix.
getCofactor(): This function will return cofactor of the given element in the first row of a given matrix.


The step-by-step approach is:
Inside the determinantOfMatrix() function, run a loop from 0 to N for all elements of the first row.
For every element in the first row, find its cofactor matrix using the getCofactor() function.
Then, multiply the element with the determinant of the corresponding cofactor, and finally add them with alternate signs.
To find the determinant of the current co-factor, call the determinantOfMatrix() function recursively, and pass the cofactor matrix and its dimension as parameters.


Implementation of the getDeterminant() function:

/* Recursive function for finding determinant of matrix. 
   n is current dimension of mat[][]. 
int determinantOfMatrix(int mat[N][N], int n) 
{ 
    int D = 0; // Initialize result 
  
    //  Base case : if matrix contains single element 
    if (n == 1) 
        return mat[0][0]; 
  
    int temp[N][N]; // To store cofactors 
  
    int sign = 1;  // To store sign multiplier 
  
     // Iterate for each element of first row 
    for (int f = 0; f < n; f++) 
    { 
        // Getting Cofactor of mat[0][f] 
        getCofactor(mat, temp, 0, f, n); 
        D += sign * mat[0][f] * determinantOfMatrix(temp, n - 1); 
  
        // terms are to be added with alternate sign 
        sign = -sign; 
    } 
  
    return D; 
} 
Implementation of the getCofactor() function:

// Function to get cofactor of mat[p][q] in temp[][]. n is current 
// dimension of mat[][] 
void getCofactor(int mat[N][N], int temp[N][N], int p, int q, int n) 
{ 
    int i = 0, j = 0; 
  
    // Looping for each element of the matrix 
    for (int row = 0; row < n; row++) 
    { 
        for (int col = 0; col < n; col++) 
        { 
            //  Copying into temporary matrix only those element 
            //  which are not in given row and column 
            if (row != p && col != q) 
            { 
                temp[i][j++] = mat[row][col]; 
  
                // Row is filled, so increase row index and 
                // reset col index 
                if (j == n - 1) 
                { 
                    j = 0; 
                    i++; 
                } 
            } 
        } 
    } 
} 

*/