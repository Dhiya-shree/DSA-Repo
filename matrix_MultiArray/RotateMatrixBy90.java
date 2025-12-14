package matrix_MultiArray;
/**
 * Rotate by 90 degree
Difficulty: EasyAccuracy: 56.88%Submissions: 114K+Points: 2Average Time: 20m
Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 

Examples:

Input: mat[][] = [[1, 2, 3],
                [4, 5, 6]
                [7, 8, 9]]
Output: Rotated Matrix:
[3, 6, 9]
[2, 5, 8]
[1, 4, 7]
Input: mat[][] = [[1, 2],
                [3, 4]]
Output: Rotated Matrix:
[2, 4]
[1, 3]
Constraints:
1 ≤ n ≤ 102
0 <= mat[i][j] <= 103
 * 
 * @author shree
 *
 */
public class RotateMatrixBy90 {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}
	 static void rotateby90(int arr[][]) {
	        // code here
	        // 00 01    01 11
	        // 10 11    00 10
	        int n=arr.length;
	      
	         for(int i=0;i<n;i++){
	              for(int j=i+1;j<n;j++){
	            int c=arr[i][j];
	            arr[i][j]=arr[j][i];
	            arr[j][i]=c;
	              }
	        }
	        
	          for(int i=0;i<n;i++){
	            int c=arr[i][0];
	            arr[i][0]=arr[i][n-1];
	            arr[i][n-1]=c;
	        }
	        
	        
	        
	    }
}
