package backtracking_sums;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * 
 * N Queen Problem 
 * 
 * Given N number of queens .
 * Place them in such a way no two queen can attack 
 * A queen can go diagonal , left and right 
 * And given in a NxN matrix 
 * 
 * 
 * As queen can go left/right and up/down and also diagonal 
 * 
 * One row can occupy only 1 queen amoung N queens in NxN matrix 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class BT10_N_Queen_Problem {

	
	public static void main(String[] args) {
		int N=5;// 4 5 suceess // 3 2 falied 
		int positionPlaced[][]=new int[N][N];
		
		ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		
		 ansF=new ArrayList<ArrayList<Integer>>();
		PermutationsColumn(positionPlaced,0,N,-1,N-1,new ArrayList<Integer>());
		
		
	   Permutations(positionPlaced,0,N,-1,N-1);
	   System.out.println("Ans wer "+ansF.toString());
	}

	static ArrayList<ArrayList<Integer>> ansF;
	private static void PermutationsColumn(int[][] positionPlaced, int QueenNo, int n, int left, int right,ArrayList<Integer> ans) {
		// Each queen 1 column 
		
				if(QueenNo>=n|| left>right ) {
					
					if(QueenNo==n) {
					
						System.out.println(" Queen placed "+ans.toString());
						ansF.add(new ArrayList<Integer>(ans));
					}
					else {
						System.out.println(" Current combo failed ");
						for(int i=0;i<n;i++) {
							System.out.println(Arrays.toString(positionPlaced[i]));
						}
					}
				}
				else {
					
					
					for(int i=0;i<=right;i++) {
						
						if(IsSafeToPlaceColumn(positionPlaced,QueenNo,n,i,left)) {
						positionPlaced[i][QueenNo]=1;
						ans.add(i);
						PermutationsColumn(positionPlaced, QueenNo+1, n, i, right,ans);
						ans.remove(QueenNo);
						positionPlaced[i][QueenNo]=0;
						}
					}
				}
				
				
		
	}

	private static boolean IsSafeToPlaceColumn(int[][] positionPlaced, int qNo, int n, int i,int left) {
			// check if any queen in attack sight 
			
			if(left==-1) {
				return true;
			}
			
			if(i==left) {//prev queen position 
				return false;
			}
			
			int a=i-i;int b=qNo-i;int c=qNo-1;int a2=i+1;
			
				for(int j=0;j<n;j++) {
				
				if(positionPlaced[i][j]==1) {
					return false;
				}
				if(positionPlaced[j][qNo]==1) {
					return false;
				}
				
				
			
					if(a<n && b<n && a>=0 && b>=0) {
						if(positionPlaced[a][b]==1) {return false;}
					}
					if(a2>=0 && a2<n && c<n && c>=0) {
						if(positionPlaced[a2][c]==1) {return false;}
					}
					a++;b++;c--;a2++;
			
				}
			return true;
		}

	private static void Permutations(int[][] positionPlaced, int QueenNo, int n, int left, int right) {
		// checks if queen can coexist 
		
		if(QueenNo>=n|| left>right ) {
			
			if(QueenNo==n) {
			
				System.out.println(" Queen placed ");
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						
						if(positionPlaced[j][i]==1) {
							System.out.print(j+" ");
						}
						
					}
					
				}
				System.out.println();
			}
			else {
				System.out.println(" Current combo failed ");
				for(int i=0;i<n;i++) {
					System.out.println(Arrays.toString(positionPlaced[i]));
				}
			}
		}
		else {
			
			
			for(int i=0;i<=right;i++) {
				
				if(IsSafeToPlace(positionPlaced,QueenNo,n,i,left)) {
				positionPlaced[QueenNo][i]=1;
				Permutations(positionPlaced, QueenNo+1, n, i, right);
				positionPlaced[QueenNo][i]=0;
				}
			}
		}
		
		
		
	}

	private static boolean IsSafeToPlace(int[][] positionPlaced, int queenNo, int n, int i,int left) {
		// check if any queen in attack sight 
		
		if(left==-1) {
			return true;
		}
		
		if(i==left) {//prev queen position 
			return false;
		}
		
		int a=queenNo-i;int b=queenNo-queenNo;int c=i+1;int a2=queenNo-1;
		
			for(int j=0;j<n;j++) {
			
			if(positionPlaced[j][i]==1) {
				return false;
			}
			if(positionPlaced[queenNo][j]==1) {
				return false;
			}
			
			
		
				if(a<n && b<n && a>=0 && b>=0) {
					if(positionPlaced[a][b]==1) {return false;}
				}
				if(a2>=0 && c<n && c>=0) {
					if(positionPlaced[a2][c]==1) {return false;}
				}
				a++;b++;c++;a2--;
		
			}
		return true;
	}
}

/*
 * 
 *N-Queen Problem

Let us discuss N Queen as another example problem that can be solved using backtracking. 
The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. For example, the following is a solution for the 4 Queen problem.

The expected output is a binary matrix that has 1s for the blocks where queens are placed. For example, the following is the output matrix for the above 4 queen solution.

 

{ 0,  1,  0,  0}
{ 0,  0,  0,  1}
{ 1,  0,  0,  0}
{ 0,  0,  1,  0}

 

Naive Algorithm 
Generate all possible configurations of queens on board and print a configuration that satisfies the given constraints.

while there are untried configurations
{
   generate the next configuration
   if queens don't attack in this configuration then
   {
      print this configuration;
   }
}
 

Backtracking Algorithm 
The idea is to place queens one by one in different columns, starting from the leftmost column. When we place a queen in a column, we check for clashes with already placed queens. In the current column, if we find a row for which there is no clash, we mark this row and column as part of the solution. If we do not find such a row due to clashes, then we backtrack and return false.

1) Start in the leftmost column
2) If all queens are placed
    return true
3) Try all rows in the current column. 
   Do following for every tried row.
    a) If the queen can be placed safely in this row 
       then mark this [row, column] as part of the 
       solution and recursively check if placing
       queen here leads to a solution.
    b) If placing the queen in [row, column] leads to
       a solution then return true.
    c) If placing queen doesn't lead to a solution then
       unmark this [row, column] (Backtrack) and go to 
       step (a) to try other rows.
4) If all rows have been tried and nothing worked,
   return false to trigger backtracking.
 

Implementation of Backtracking solution  


import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    
    static final int N = 4;
    static int board[][] = { { 0, 0, 0, 0 }, 
                    { 0, 0, 0, 0 }, 
                    { 0, 0, 0, 0 }, 
                    { 0, 0, 0, 0 } };
    static void printSolution(int board[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    }
  
    static boolean isSafe(int row, int col) 
    { 
        int i, j; 
  
        for (i = 0; i < col; i++) 
            if (board[row][i] == 1) 
                return false; 
  
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        for (i = row, j = col; j >= 0 && i < N; i++, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        return true; 
    } 
  
    static boolean solveRec(int col) 
    { 
        if (col == N) 
            return true; 
  
        for (int i = 0; i < N; i++) {  
            if (isSafe(i, col)) { 
                board[i][col] = 1; 
  
                if (solveRec(col + 1) == true) 
                    return true; 
  
                board[i][col] = 0; 
            } 
        }
        return false;
    }
    
    static  boolean solve() 
    { 
  
        if (solveRec(0) == false) { 
            System.out.print("Solution does not exist"); 
            return false; 
        } 
  
        printSolution(board); 
        return true; 
    }
    
    public static void main(String args[])
    {
        solve(); 
    }
}
 

Output:
 0  0  1  0 
 1  0  0  0 
 0  0  0  1 
 0  1  0  0 
 

Time Complexity: O(N!)
Auxiliary Space: O(N2)

  
 * 
 * 
 */
