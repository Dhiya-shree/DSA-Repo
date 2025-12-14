package backtracking_sums;

import java.util.Arrays;

/**
 * 
 * RAT IN A MAZE 
 * 
 * Given a maze as matrix .
 * Rat needs to go from 0,0 to n-1,n-1 righmost corner of matrix .
 * 
 * Matrix value :
 *   0 -> Blocked cell can not move
 *   1 -> Rat can move through cell 
 *   
 * Only two moves possible 
 * 1) i+1,j
 * 2) i,j+1
 * 
 * Example :
 * maze =   1 0 0 0                    1 0 0 0
 *          1 1 0 1      =====> ans =  1 1 0 0
 *          0 1 0 0                    0 1 0 0
 *          1 1 1 1                    0 1 1 1
 *   
 *   
 * Maze= 1 0 0
 *       0 1 0      ====> ans = NO Not possible to traverse 
 *       1 1 1
 * 
 * 
 * Solution 1:
 * 
 * 1) Do DFS 
 * 2) Add vertex came across in HashMap 
 * 3) Print from hashmap 
 * 
 * Naive Solution :
 * 
 * 1) Find all path from top left to bottom right 
 * 2) Check if it leads to solution 
 * 3) If solution found , return
 * 
 * Best BackTracking :
 * 
 * 1) Generate path after checking if path is safe 
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class BT03_Rat_in_A_Maze {

	public static void main(String[] args) {
		
		int maze[][]= {{1,0,0,0},{1,1,0,0},{0,1,0,0},{1,1,1,1}};
		int n=maze.length;
		
		visited=new int[n][n];
		ans=new int[n][n];
		// source is 0,0 no changes in that 
		// no need for dfs all 
		System.out.println(" Path found is "+FindPath_DFS_BackTracking(maze,n,0,0));
	
	   // GFG solution 
		visited=new int[n][n];
		if(GFGPath(maze,n,0,0)==false) {
			System.out.println("No Return path ");
		}
		else {
			System.out.println(" Path found ");
			for(int k=0;k<n;k++) {
				System.out.println(Arrays.toString(visited[k]));
			}
		}
	}

	private static boolean GFGPath(int[][] maze, int n, int i, int j) {
		// gfg code
		
		if(i==n-1 && j==n-1) {
			visited[i][j]=1;
			return true;
		}
		
		if(isSafePath(maze, n, i, j)) {
			visited[i][j]=1;
			
			if(GFGPath(maze, n, i+1, j)==true) {
				return true;
			}
			
			if(GFGPath(maze, n, i, j+1)==true) {
				return true;
			}
			
			visited[i][j]=0;
		}
		
		return false;
	}

	static int visited[][];static int ans[][];
	private static boolean FindPath_DFS_BackTracking(int[][] maze, int n,int i,int j) {
		// dfs 
		if(i==n-1 && j==n-1) {
			visited[i][j]=1;
			for(int k=0;k<n;k++) {
				System.out.println(Arrays.toString(visited[k]));
			}
			return true;
		}
		
		boolean anb=false;
		if(maze[i][j]==1) {
			visited[i][j]=1;
			System.out.println("I-J "+i+"-"+j);
			// path 1 
			if(isSafePath(maze,n,i+1,j)) {
				anb=FindPath_DFS_BackTracking(maze,n,i+1,j);
				if(anb) {
					return anb;
				}
				else {
					visited[i+1][j]=0;
				}
			}
			
			
			if(isSafePath(maze,n,i,j+1)) {
				anb=FindPath_DFS_BackTracking(maze,n,i,j+1);
				if(anb) {
					return anb;
				}
				else {
					visited[i][j+1]=0;
				}
			}
			
		}
		
		return anb;
	}
	private static boolean isSafePath(int[][] maze, int n, int i, int j) {
		// check safe 
		if(i>=0 && j>=0 && i<n && j<n && maze[i][j]==1) {
			System.out.println("path found .....");
			return true;
		}
		
		return false;
	}
}

/*

Rat in a Maze

Let us discuss Rat in a Maze as another example problem that can be solved using Backtracking.

A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down. 

In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source to destination. Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with a limited number of moves.

Following is an example maze.  

 Gray blocks are dead ends (value = 0).


Following is a binary matrix representation of the above maze. 

{1, 0, 0, 0}
{1, 1, 0, 1}
{0, 1, 0, 0}
{1, 1, 1, 1}
Following is a maze with highlighted solution path.



Following is the solution matrix (output of program) for the above input matrix. 

{1, 0, 0, 0}
{1, 1, 0, 0}
{0, 1, 0, 0}
{0, 1, 1, 1}
All entries in solution path are marked as 1.
 

Backtracking Algorithm: Backtracking is an algorithmic-technique for solving problems recursively by trying to build a solution incrementally. Solving one piece at a time, and removing those solutions that fail to satisfy the constraints of the problem at any point of time (by time, here, is referred to the time elapsed till reaching any level of the search tree) is the process of backtracking.

Approach: Form a recursive function, which will follow a path and check if the path reaches the destination or not. If the path does not reach the destination then backtrack and try other paths. 

Algorithm:  

Create a solution matrix, initially filled with 0’s.
Create a recursive function, which takes initial matrix, output matrix and position of rat (i, j).
if the position is out of the matrix or the position is not valid then return.
Mark the position output[i][j] as 1 and check if the current position is destination or not. If destination is reached print the output matrix and return.
Recursively call for position (i+1, j) and (i, j+1).
Unmark position (i, j), i.e output[i][j] = 0.

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    
    static int N; 
  
    static void printSolution(int sol[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print( " " + sol[i][j] + " "); 
            System.out.println(); 
        } 
    } 
  
    static boolean isSafe( int maze[][], int i, int j) 
    { 
        return (i < N && j < N && maze[i][j] == 1); 
    } 
  
    static boolean solveMaze(int maze[][]) 
    { 
        int sol[][] = new int[N][N]; 
  
        if (solveMazeRec(maze, 0, 0, sol) == false) { 
            System.out.print("Solution doesn't exist"); 
            return false; 
        } 
  
        printSolution(sol); 
        return true; 
    } 
  
    static boolean solveMazeRec(int maze[][], int i, int j, int sol[][]) 
    {  
        if (i == N - 1 && j == N - 1 && maze[i][j] == 1) { 
            sol[i][j] = 1; 
            return true; 
        } 
  
        if (isSafe(maze, i, j) == true) {  
            sol[i][j] = 1; 
  
            if (solveMazeRec(maze, i + 1, j, sol)) 
                return true; 
  
            if (solveMazeRec(maze, i, j + 1, sol)) 
                return true; 
   
            sol[i][j] = 0; 
        } 
  
        return false; 
    } 
    
    public static void main(String args[])
    {
        int maze[][] = { { 1, 0, 0, 0 }, 
                         { 1, 1, 0, 1 }, 
                         { 0, 1, 0, 0 }, 
                         { 1, 1, 1, 1 } }; 
  
        N = maze.length; 
        solveMaze(maze); 
    }
}
 

Output:
The 1 values show the path for rat 

 1  0  0  0 
 1  1  0  0 
 0  1  0  0 
 0  1  1  1 
Complexity Analysis: 

Time Complexity: O(2^(n^2)). 
The recursion can run upper-bound 2^(n^2) times.
Space Complexity: O(n^2). 
Output matrix is required so an extra space of size n*n is needed.


*/