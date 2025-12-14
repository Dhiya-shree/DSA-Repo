package matrix_MultiArray;

import arrayCode.ArrayPart01;

/**
 * Problem #1 : Add:
 * Commutative , Associative , Order must be same
 * 
 * Sub:
 * Not Commutative ,Not Associative , Order must be same
 * 
 *Problem #2 : Multiply:
 * Non Commutative , Associative , Order must not be same 
 * A*B possible only if col of A= row of B 
 * A*B might be possible and B*A might not be possible 
 * 
 * Problem #3 : Transpose 
 * Here, the outer loop iterates through the columns of the matrix, and the inner loop iterates through the rows. For each element in the matrix, we swap the row and column indices to get the corresponding element in the transpose.

Here's a step-by-step explanation of the code:

The program declares two integer variables, rows and cols, to store the number of rows and columns in the matrix, respectively.
The program then prompts the user to enter the number of rows and columns of the matrix, and uses the cin function to read the values into the rows and cols variables.
The program then creates an array of int with rows number of rows and cols number of columns, named matrix.
Next, the program uses a nested for loop to prompt the user to enter the elements of the matrix. The outer loop iterates through the rows and the inner loop iterates through the columns. At each iteration, the program uses the cin function to read the current element into the matrix array.
The program then prints the original matrix using another nested for loop. The outer loop iterates through the rows and the inner loop iterates through the columns. At each iteration, the program uses the cout function to print the current element of the matrix array.
Finally, the program prints the transpose of the matrix using another nested for loop. This time the outer loop iterates through the columns, and the inner loop iterates through the rows. The program uses matrix[j][i] to get the corresponding element of the transpose because, in a transpose, the rows become columns and vice-versa

 
 * Write a program to find the transpose of a square matrix of size N*N. Transpose of a matrix is obtained by changing rows to columns and columns to rows.

 * Problem #4 : Determinant of Matrix 
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
public class Matrix03_operation {

	public static void main(String[] args) {
		// Sub and Multiply 
       int A[][]= {{1,2,3},{3,4,5},{7,8,9}};
       int B[][]= {{2,4,6},{1,3,5},{0,9,8}};
       
       System.out.println(" Operation ");
       int ans1[][]=multiplyMatrix(A, B);
       Matrix02_Java_Intro.print(ans1);
       
       int ans2[][]=sumMatrix(A, B);
       Matrix02_Java_Intro.print(ans2);
       
       int mat[][] = {{1, 1, 1, 1},
               {2, 2, 2, 2},
               {3, 3, 3, 3},
               {4, 4, 4, 4}};
       int matN=mat.length;
       
       transpose(matN, mat);
       System.out.println(" TRnasposed ");
       ArrayPart01.PrintRayy2D(mat, matN, matN);
       
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

	static public void transpose(int n,int a[][])
	    {
	        int swap=0;
	      //  int copy[][]=new int[]
	        for(int i=0;i<n;i++){
	              for(int j=i;j<n;j++){
	                  swap=a[i][j];
	                  a[i][j]=a[j][i];
	                  a[j][i]=swap;
	                //  ans[i][j]=A[i][j]+B[i][j];
	              }
	          }
	    }
	 
	 
	public static int[][] multiplyMatrix(int A[][], int B[][])
    {
      int a1=A.length;
      int a2=A[0].length;
      int b1=B.length;
      int b2=B[0].length;
      
      if(b1==a2){
         int ans[][] =new int[a1][b2];
          for(int i=0;i<a1;i++){
              for(int j=0;j<b2;j++){
                  ans[i][j]=0;
                  for(int k=0;k<a2;k++){
                  ans[i][j]=ans[i][j]+A[i][k]*B[k][j];
                  }
              }
          }
          return ans;
      }
      else{
          int ans2[][]={{-1}};
          return ans2;
      }
    }

	
	public static int[][] sumMatrix(int A[][], int B[][])
    {
      // int ans[][]=new int[][];
      int a1=A.length;
      int a2=A[0].length;
      int b1=B.length;
      int b2=B[0].length;
      
      if(a1==b1 && a2==b2){
         int ans[][] =new int[a1][b2];
          for(int i=0;i<a1;i++){
              for(int j=0;j<b2;j++){
                  ans[i][j]=A[i][j]+B[i][j];
              }
          }
          return ans;
      }
      else{
          int ans2[][]={{-1}};
          return ans2;
      }
      
    }
	
	public static void transpose(int A[][], int B[][])
    {
        int i, j;
        int N=A.length;
        for (i = 0; i < N; i++)
            for (j = 0; j < N; j++)
                B[i][j] = A[j][i];
    }
}
/*
 * Matrix Operations (Addition, Subtraction, Multiplication)

Matrices Addition
The addition of two matrices A m*n and Bm*n gives a matrix Cm*n. Here, m and n represents the number of rows and columns in the matrix respectively. The elements of C are sum of corresponding elements in A and B which can be shown as:

1
Example: - mat1 = {{1, 2}, {3, 4}} mat2 = {{1, 2}, {3, 4}} mat1 + mat2 = {{2, 4}, {6, 8}}

The algorithm for addition of matrices can be written as:
 

for i in 1 to m
   for j in 1 to n
      cij = aij + bij

 

#include <bits/stdc++.h>
using namespace std;

int main(){
  
int N = 2, M = 2;
int m1[N][M] = { { 1, 2 },
                  { 4, 5 } };
int m2[N][M] = { { 5, 6 },
                  { 8, 9 } };
int ans[N][M];

// Traversing number of Rows
for(int i = 0; i < N; i++) 
{   
    // Traversing number of Columns  
    for (int j = 0; j < M; j++) 
    { 
        ans[i][j] = m1[i][j] + m2[i][j];
    } 
}

for (int i = 0; i < N; i++) 
{    
    for (int j = 0; j < M; j++) 
    { 
        cout<<ans[i][j]<<" ";
    } 
    cout<<endl;
 }
 
}

Output
6 8 
12 14 
 


Key points:

Addition of matrices is commutative which means A+B = B+A
Addition of matrices is associative which means A+(B+C) = (A+B)+C
The order of matrices A, B and A+B is always same
If order of A and B is different, A+B can’t be computed
The complexity of addition operation is O(m*n) where m*n is order of matrices


Matrices Subtraction
The subtraction of two matrices Am*n and Bm*n gives a matrix Cm*n. Here, m and n represents the number of rows and columns in the matrix respectively. The elements of C are difference of corresponding elements in A and B which can be represented as:

2
Example: - mat1 = {{1, 2}, {3, 4}}mat2 = {{1, 2}, {3, 4}}mat1 - mat2 = {{0, 0}, {0, 0}}

The algorithm for subtraction of matrices can be written as:
 

for i in 1 to m
   for j in 1 to n
      cij = aij-bij
 

#include <bits/stdc++.h>
using namespace std;

int main(){
  
int N = 2, M = 2;
int m1[N][M] = { { 5, 6 },
                  { 8, 9 } };
int m2[N][M] = { { 1, 2 },
                  { 4, 5 } };
int ans[N][M];

// Traversing number of Rows
for(int i = 0; i < N; i++) 
{   
    // Traversing number of Columns  
    for (int j = 0; j < M; j++) 
    { 
        ans[i][j] = m1[i][j] - m2[i][j];
    } 
}

for (int i = 0; i < N; i++) 
{    
    for (int j = 0; j < M; j++) 
    { 
        cout<<ans[i][j]<<" ";
    } 
    cout<<endl;
 }
 
}

Output
4 4 
4 4 


Key points:

Subtraction of matrices is non-commutative which means A-B ≠ B-A
Subtraction of matrices is non-associative which means A-(B-C) ≠ (A-B)-C
The order of matrices A, B and A-B is always same
If order of A and B is different, A-B can’t be computed
The complexity of subtraction operation is O(m*n) where m*n is order of matrices


Matrices Multiplication
The multiplication of two matrices Am*n and Bn*p gives a matrix Cm*p. It means number of columns in A must be equal to number of rows in B to calculate C=A*B. To calculate element c11, multiply elements of 1st row of A with 1st column of B and add them (5*1+6*4) which can be shown as:

1
Example: - mat1 = {{1, 2}, {3, 4}}mat2 = {{1, 2}, {3, 4}}mat1 * mat2 = {{7, 10}, {15, 22}}

The algorithm for multiplication of matrices A with order m*n and B with order n*p can be written as:
 

for i in 1 to m
   for j in 1 to p
      cij = 0
      for k in 1 to n
         cij += aik*bkj
 

#include <bits/stdc++.h>
using namespace std;

int main(){
  
int M = 2, N = 2, P = 2;
int m1[M][N] = { { 5, 6 },
                  { 8, 9 } };
int m2[N][P] = { { 1, 2 },
                  { 4, 5 } };
int ans[M][P];

// Traversing number of Rows
for(int i = 0; i < M; i++) 
{   
    // Traversing number of Columns  
    for (int j = 0; j < P; j++) 
    { 
        ans[i][j] = 0;
        
        for( int k = 0; k < N; k++ )
            ans[i][j] += m1[i][k] * m2[k][j];
    } 
}

for (int i = 0; i < N; i++) 
{    
    for (int j = 0; j < M; j++) 
    { 
        cout<<ans[i][j]<<" ";
    } 
    cout<<endl;
 }
 
}

Output
29 40 
44 61 


Key points:
 

Multiplication of matrices is always non-commutative which means A*B ≠ B*A
Multiplication of matrices is associative which means A*(B*C) = (A*B)*C
For computing A*B, the number of columns in A must be equal to number of rows in B
Existence of A*B does not imply existence of B*A
The complexity of multiplication operation (A*B) is O(m*n*p) where m*n and n*p are order of A and B respectively
The order of matrix C computed as A*B is O(m*p) where m*n and n*p are order of A and B respectively

 * 
 */
