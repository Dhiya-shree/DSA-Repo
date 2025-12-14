package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Matrix Chain Multiplication 
 * 
 * Matrix multiplication is possible only for two matrix 
 * with dimension such as 2x3 and 3x5 giving result of 2x5 
 * 
 * Matrix A 3x4  * B 4x5 = C 3x5 
 * Number of Integer multiplications needed = 3 x 4 x 5 
 * 
 * First row of A * First Col of B = First val of C
 * A 3x2       B 2x4               Multiply = 24 ( 3x2x4)                              C 3x4
 *  3 3       1 11 111 1111  = 3*1 + 3*0   3*11+3*00   3*111+3*000  3*1111+3*0000      3 33 333 3333   
 *  4 5   x   0 00 000 0000    4*1 + 5*0   4*11+5*00   4*111+5*000  4*1111+5*0000  =   4 44 444 4444
 *  6 2                        6*1 + 2*0   6*11+2*00   6*111+2*000  6*1111+2*0000      6 66 666 6666
 * 
 * 
 * 
 * Given a array of size n 
 * Array representing N-1 Matrices
 * 
 * Ex arr= 2,1,3,4  N=4 , it represent 3 matrices 
 * N= 4 , 3 matrix A B C 
 * Dimension of matrix : 
 * A = 2x1 
 * B = 1x3
 * C = 3x4
 * 
 * Mutiplication of matrix 
 * 
 * 1) A x (BxC)
 *       
 *       A x( Mul(1x3  3x4))= Ax (1x3x4)  : ans= 12 
 *       = Mul(2x1  x 1x4) AxBC 
 *       = 2x4
 *       = 8     ans= 12+8 = 20
 *     
 * 2) (AxB)xC
 *      
 *      = (2x1 1x3)x C
 *      =   2x3    x C   ans = 2x1x3= 6 
 *      =   2x3 3x4 
 *      = mul 2x3x4 = 24 ans= 6+24 = 30 
 *      
 *   
 *  Minimum no of multiplicaton required = 20 
 *  Best way to multiply is A x (BXC)
 *  
 *  arr= 2,1,3,4
 *  o/p=20
 *  
 *  
 * Ex 2 arr 2,1,3 
 *    No of matrix= 2 
 *    A= 2x1 B=1x3
 *  
 *  Matrix mul possible= AXB = 2x1x3 = 6 
 *  O/p = 6
 *  
 *  Base cases 
 *  
 *  if N=1,2 
 *  Only 1 matrix is present 
 *  A1 [1]  or A1x2 
 *  O/p  0 , no multiplication 
 *  
 *  if N=3 
 *  Multiply 
 *  arr 0x1x2 for ans 
 *  
 *  
 *  Different ways to make first partition :
 *  
 *  M1 x ( M2,M3,M4,M5.....Mn-1)=   a0 a1  , ( a1 a2 a3 .... an-1)
 *  M1xM2  x (M3,M4,M5 .....Mn-1)=  a0 a1 a2 , (a2 a3 a4 .... an-1)
 *  M1xM2xM3 x (M4,M5 .....Mn-1)=  a0 a1 a2 a3 , (a3 a4 a5 .... an-1)
 *                                   |
 *                                  Make a recursive call again for M1M2M3 
 *                                  Find minimum 
 *                                  
 *  
 *  Recursion arr , start=0,end=n  
 *  
 *  Base case 
 *  
 *  start-end==0  || start-end==1 
 *     return 0   // single array 
 *   
 *  start - end==2 
 *    return arri * arri+1 * arri+2
 *  
 *  
 *  int min
 *  for int i=1 to n-1 
 *    M1 size i = recur for M1 to Mi + recur for Mi to Mn-1
 *    min =min of M1 mul
 *    
 *  return min 
 *          j-1     j-1
 *  mChain (arr )=   min mChain(arr,i,k)+ mchain(arr,k,n)+ (arr i x arr k x arr j)
 *        k=i+1    k=i+1
 *        
 *        
 *  
 *  
 *  Dynamic TABLE 
 *  
 *  Requires upper half of the diagonal 
 *  Ans in table 0,N-1
 *  0,0 1,1  2,2  3,3 - all are 0 , Only  1 matrix 1D arr=1    A=[100]
 *  0,1 1,2  2,3  3,4 - all are 0 , Only 1 2D matrix  arr=1,2  A 1x2 = [1 100]
 *  
 *  Start fill from 
 *  0,2  - 6     0,1,2 - AxB 
 *  1,3  - 12    1,2,3 - BxC 
 *  0,3 - 0-2 x2-3 , 0-1 x 1-3 
 *  Ans=0,3 
 *  
 *  Recursive analysis 
 *                              array 0 to 4 
 *                          /       |       \
 *                     0-1 1-4     0-2 2-4    1-3 3-4
 *                   /   |         |      \    \     \
 *                ans  (1-2,2-4)  0-1,1-2  |    \     ans
 *                     (1-3,3-4)       2-3,3-4   1-2,2-3
 *          
 *   
 *   
 *   DP solution  Time O N^3  Space O n^2
 *   table nxn 
 *   table ij= stores result ffrom subarray i to j 
 *   table 0,n-1-> final result 
 *   
 *   arr[]= 10,20,30,40,50
 *   n=5 
 *   
 *   table 0,4 requires -> table 01 table 14 table02 table 24 table 03 table 34 
 *   
 *   gap=1 gap=gap+1 gap<n 
 *   
 *   i=0 i<n i++
 *     j=i+gap 
 *     if gap==1
 *     table ij= 0
 *     if gap==2
 *     table ij=arr[i]*arr[i+1]*arr[i+2]
 *     else
 *     table i,j = min ( table i-k+  table k-j + arr i* arr j *arr k) where k=i+1 to j-1  
 *     
 *   return table 0 n-1 
 *   
 *    
 *  
 *   
 *  
 *  
 * 
 * @author shree
 *
 */
public class DP25_Matrix_Chain_Multiplication {

	public static void main(String[] args) {
		// matrix chain multiplication 
		int arr[]= {2,1,3,4};
		int n=arr.length;
		
		//Recur sol 
		int sol=MatMul_recur(arr,0,n-1);
		System.out.println(" Recur sol is "+sol);
		
		//Memo sol 
		int memo[][]=new int[n][n];
		sol=MatMul_memo(arr,0,n-1,memo);
		System.out.println(" Memo sol is "+sol);
		for(int i=0;i<n;i++) {
			System.out.println(" Memo "+Arrays.toString(memo[i]));
		}
		
		//Table
		sol=MatMul_Table(arr,n);
		System.out.println(" Table sol is "+sol);

	}

	private static int MatMul_Table(int[] arr, int n) {
		// Create table 
		int table[][]=new int[n][n];
		
		//start from gap=2 
		// as gap=1 , value=0 only 
		for(int gap=1;gap<n;gap++) {
			for(int i=0;i<n && i+gap<n ; i++) {
				int j=i+gap;
				if(gap==1) {
					table[i][j]=0 ;
				}
				else if(gap==2) {
					table[i][j]=arr[i]*arr[i+1]*arr[i+2];
				}
				else {
					//Find the most minimum in combo i,j = i,k and k,j where k=i+1 to j-1
					int min=Integer.MAX_VALUE;
					System.out.println(" For i and j "+i+" - "+j);
					for(int k=i+1;k<j && k<n;k++) {
						System.out.println(" For i k - k j "+i+" - "+k+" - "+j+" == "+table[i][k]+" + "+table[k][j]);
						min=Math.min(min,table[i][k]+table[k][j]+arr[i]*arr[k]*arr[j]);
					}
					table[i][j]=min;
				}
			}
		}
		
		for(int i=0;i<n; i++) {
			System.out.println(" Table "+Arrays.toString(table[i]));
		}
		
		return table[0][n-1];
	}

	private static int MatMul_memo(int[] arr, int start, int end, int[][] memo) {
		// Base case 
		if(end-start==0||end-start==1) {
			return 0;
		}
		
		if(memo[start][end]!=0) {
			return memo[start][end];
		}
		
		if(end-start==2) {
			memo[start][end]=arr[start]*arr[start+1]*arr[start+2];
			return memo[start][end];
		}
		
		int min=Integer.MAX_VALUE;
		int firstHalf=0,lastHalf=0,firstXlast=0,currPartition=0;
		for(int i=start+1;i<end;i++) {  // i must be > start , < end else STACK OVER FLOW 
			
			firstHalf=MatMul_memo(arr, start,i, memo);
			lastHalf=MatMul_memo(arr, i,end, memo);
			firstXlast=arr[start]*arr[i]*arr[end];//multi needed to add 2 partitions 
			currPartition=firstHalf+firstXlast+lastHalf;
			min=Math.min(currPartition,min);
		}
		
		memo[start][end]=min;
		return min;
	}

	private static int MatMul_recur(int[] arr, int start, int end) {
		// recur sol 
		
		if(end-start==0|| end-start==1) {
			return 0;
		}
		
		if(end-start==2) {
			return (arr[start]*arr[start+1]*arr[start+2]);
		}
		
		
		int min=Integer.MAX_VALUE;int currPartition=0;
		int FirstHalf=0;int LastHalf=0;int lastXFirstHalf=0;
		for(int i=start+1;i<end;i++) {   // FOCUS here !!!!! i from start+1 , else we will recur for same over and over 
			// I > start and I < end else STACK OVER FLOW 
			
			FirstHalf=MatMul_recur(arr, start, i);
			LastHalf=MatMul_recur(arr, i, end);
			lastXFirstHalf= arr[start]*arr[i]*arr[end];
			
			currPartition= FirstHalf+ lastXFirstHalf + LastHalf;
			
			min=Math.min(currPartition, min);
		}
		
		return min;
	}

}
