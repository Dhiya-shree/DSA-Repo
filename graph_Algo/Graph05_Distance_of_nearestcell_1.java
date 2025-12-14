package graph_Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * Problem #1 : Distance of nearest cell having 1
 * 
 * Binary grid of size n*m
 * Given a binary grid of n*m. Find the distance of the
 * nearest 1 in the grid for each cell.
 * The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1. 
 * There should be atleast one 1 in the grid.
 * 
 * Input: grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}}
Output: {{1,0,0,1},{0,0,1,1},{1,1,0,0}}
Explanation: The grid is-
0 1 1 0 
1 1 0 0 
0 0 1 1 
0's at (0,0), (0,3), (1,2), (1,3), (2,0) and
(2,1) are at a distance of 1 from 1's at (0,1),
(0,2), (0,2), (2,3), (1,0) and (1,1)
respectively.
  x 0 1 2 3
  0 0 1 1 0 
  1 1 1 0 0 
  2 0 0 1 1 
 * 
 * Ans :
 * Convert matrix as 
 * 0  1  2  3 
 * 4  5  6  7
 * 8  9  10 11
 * 12 13 14 15
 * 
 *  Up= val-4
 *  Down=val+4
 *  left=val-1
 *  Right=val+1
 * Consider V =n*m 
 * Hashset of 1 
 * Traverse elements
 * For every element :
 *    adj list : up , down , left , right 
 * 
 * for( 0 to v)
 * if val in hashset =>0
 * else 
 *    BFS with curr as source till reach val in hashset 
 *    
 * Make ans22 list as matrix 
 * 
 * 
 * 
 * Consider every element in list :
 * 
 * 1) check if elements is 1 is one and=0
 * 2) check up down top bottom is 1 , if yes ans22=-1
 * 3) check friends friends val if yes ans22=-2
 * 
 * Traverse the array and change - to +
 * 
 *     /*   failed 
	        3 8
	0 1 0 0 1 1 1 1
	0 0 1 0 1 1 0 1
	1 0 0 0 1 0 0 0
	        
	        
	        4 5
	1 0 1 0 0
	0 0 1 0 0
	0 0 0 0 1
	1 0 1 1 1

	3 4 
	0 1 1 0 
	1 1 0 0 
	0 0 1 1

	3 4 
	0 0 0 0
	0 0 0 0 
	0 0 0 1
	       System.out.println(adj.get(22).toString());
	       System.out.println(adj.get(14).toString());
	       System.out.println(adj.get(21).toString());
	       System.out.println(adj.get(23).toString());
	   System.out.println(Arrays.toString(ans)); *
 * 
 * @author shree
 *
 */
class ClassMinVal{
    int min;
    int i,j;
    ClassMinVal(int i,int j,int ans){
        this.i=i;
        this.j=j;
        min=ans;
    }

    
}
public class Graph05_Distance_of_nearestcell_1 {

	public static void main(String[] args) {
		//Problems 
		//For every 1 value
		//Find BFS 
		// if value already exist take the minimum 
		// if cell already has value < curr , skip  

		int arr[][]= {{0,0,0,0},{0,0,0,0},
				{0,0,0,0},{1,0,0,0}};
		
		arr=nearest(arr);
		
		System.out.println("Nearest cell having 1 ");
		for(int i=0;i<arr.length;i++) {
		System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	   public static int[][] nearest(int[][] grid)
	    {
	        // Code here
	        
	        n=grid.length;m=grid[0].length;
	    
	        ans=new int[n][m];
	     
	        //14  22 
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if( grid[i][j]==1){
	                BFSForMatrix(grid,i,j);
	                
	                }
	                
	            }
	        }
	      
	        return ans;
	    }
	     static int ans[][];static int n,m;
	    public static void BFSForMatrix(int[][] grid, int x,int y){
	        
	        boolean visited[][]=new boolean[n][m];
	        Queue<ClassMinVal> q=new ArrayDeque<>();
	        q.offer(new ClassMinVal(x,y,0));int i=0,j=0;
	       // System.out.print("start..11... "+x+"-"+y+" ");
	        int anss=1;int size=0;ClassMinVal curr=null;
	       while(!q.isEmpty()){
	            size=q.size();
	           for(int k=0;k<size;k++){
	                curr=q.poll();
	                i=curr.i;
	                j=curr.j;
	               //System.out.print(curr.min+"....");
	             if(grid[i][j]!=1 && ans[i][j]!=0){
	                ans[i][j]=Math.min(curr.min,ans[i][j]);
	             }
	             else if(grid[i][j]!=1){
	                 ans[i][j]=curr.min;
	             }
	                if(visited[i][j]==false){
	                    visited[i][j]=true;
	              
	                    // up left right down 
	         if(i+1<n && visited[i+1][j]==false &&
	         grid[i+1][j]!=1 && (ans[i+1][j]==0||ans[i+1][j]>anss)){
	                q.offer( new ClassMinVal(i+1,j,anss));
	            }
	            if(i-1>=0 && visited[i-1][j]==false && grid[i-1][j]!=1
	            && (ans[i-1][j]==0||ans[i-1][j]>anss)){
	                q.offer( new ClassMinVal(i-1,j,anss));
	            }
	            if(j-1>=0 && visited[i][j-1]==false && grid[i][j-1]!=1
	            && (ans[i][j-1]==0||ans[i][j-1]>anss)){
	               q.offer( new ClassMinVal(i,j-1,anss));
	            }
	            if(j+1<m &&  visited[i][j+1]==false && grid[i][j+1]!=1
	            && (ans[i][j+1]==0||ans[i][j+1]>anss)){
	               q.offer( new ClassMinVal(i,j+1,anss));
	            }
	                }
	        }
	            
	          anss=anss+1;
	        }
	     //   return anss;
	        
	    }
	    

	
	//Passes 90 on 90 
	// Heavy space + BFS 
	//Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearestHighSpace(int[][] grid)
    {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        int n=grid.length;int m=grid[0].length;
          cont=n*m+1;
         int V=n*m;
        ans22=new int[V];
        int v=0;
        //14  22 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                adj.add(new ArrayList<>());
                {
                    if(v+m<V){
                        adj.get(v).add(v+m);
                    }
                    if(v-m>-1){
                        adj.get(v).add(v-m);
                    }
                    if(v+1<((i+1)*m)){
                        adj.get(v).add(v+1);
                    }
                    if(v-1>=(i*m)){
                        adj.get(v).add(v-1);
                    }
                }
                if( grid[i][j]==1){
                ans22[v]=cont;
                }
                else{
                    if((i+1<n && grid[i+1][j]==1) ||
                      (i-1>-1 && grid[i-1][j]==1 )||
                      (j+1<m && grid[i][j+1]==1) ||
                      (j-1>-1 && grid[i][j-1]==1 )
                      ){
                          ans22[v]=-1;
                      }
                      
                }
                v++;
                
            }
        }
      
        /*   failed 
        3 8
0 1 0 0 1 1 1 1
0 0 1 0 1 1 0 1
1 0 0 0 1 0 0 0
        
        
        4 5
1 0 1 0 0
0 0 1 0 0
0 0 0 0 1
1 0 1 1 1

3 4 
0 1 1 0 
1 1 0 0 
0 0 1 1

3 4 
0 0 0 0
0 0 0 0 
0 0 0 1
       System.out.println(adj.get(22).toString());
       System.out.println(adj.get(14).toString());
       System.out.println(adj.get(21).toString());
       System.out.println(adj.get(23).toString());
   System.out.println(Arrays.toString(ans22)); */
       for(int i=0;i<V;i++){
           if(ans22[i]!=cont && ans22[i]!=-1){
               
               ans22[i]=BFSwithSource(i,adj,V);
            //   System.out.println(ans22[i]);
           }
       }
       v=0;
        for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(ans22[v]==cont){
                grid[i][j]=0;
            }
            else if(ans22[v]==-1){
                grid[i][j]=1;
            }
            else{
                grid[i][j]=ans22[v]*-1;
            }
            v++;
        }
        
        }
        return grid;
    }
     int ans22[];int cont;
    public int BFSwithSource(int source, ArrayList<ArrayList<Integer>> adj,int V){
        
        boolean visited[]=new boolean[V];
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(source);
       // boolean ans22Found=false;
        int ans22s=0;int size=0;int curr=0;int size2=0;int curr2=0;
        while(!q.isEmpty()){
            size=q.size();
           // if(source==22){
             //   System.out.println(q.toString()+" "+ans22s);
            //}
            for(int i=0;i<size;i++){
                curr=q.poll();
                 if(ans22[curr]==cont){
                    return ans22s;
                }
                if(visited[curr]==false){
                    visited[source]=true;
               
                 size2=adj.get(curr).size();
                 for(int j=0;j<size2;j++){
                     curr2=adj.get(curr).get(j);
                     if(visited[curr2]==false){
                         q.offer(curr2);
                     }
                     
                 }
                 
                }
            }
            
          //  ans22s=ans22+1;
             ans22s=ans22s-1;
        }
        return ans22s;
        
    }
    

}

class Distance1Best5SecGoG
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public class triplet{
        int r;
        int c;
        int step;
        triplet(int r,int c,int step){
            this.r=r;
            this.c=c;
            this.step=step;
        }
    }
    
    public int[][] nearest(int[][] grid){
        
        int r=grid.length;     //rows
        int c=grid[0].length;    //columns
        
        int ans22[][]=new int[r][c];
        boolean visited[][]=new boolean[r][c];
        Queue<triplet> q=new ArrayDeque<>();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    q.add(new triplet(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            triplet temp=q.poll();
            int x=temp.r,y=temp.c,s=temp.step;
            ans22[x][y]=s;
            int r1=x-1,r2=x+1;
            int c1=y-1,c2=y+1;
            if(r1>=0 && r1<r){
                if(visited[r1][y]==false){
                    q.add(new triplet(r1,y,s+1));
                    visited[r1][y]=true;
                }
            }
            if(r2>=0 && r2<r){
                if(visited[r2][y]==false){
                    q.add(new triplet(r2,y,s+1));
                    visited[r2][y]=true;
                }
            }
            if(c1>=0 && c1<c){
                if(visited[x][c1]==false){
                    q.add(new triplet(x,c1,s+1));
                    visited[x][c1]=true;
                }
            }
            if(c2>=0 && c2<c){
                if(visited[x][c2]==false){
                    q.add(new triplet(x,c2,s+1));
                    visited[x][c2]=true;
                }
            }
        }
        
        return ans22;
    }
    
}





//Only 10 out of 90 passed 
class Distance1
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
         n=grid.length;m=grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( grid[i][j]!=1){
                grid[i][j]=CheckFor1(grid,i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( grid[i][j]==1){
                grid[i][j]=0;
                }
                else if(grid[i][j]==-1){
                     grid[i][j]=1;
                }
                else{
                     grid[i][j]= grid[i][j]*-1;
                }
            }
        }
        return grid;
    }
    static int n,m;
    public int CheckFor1(int[][] arr,int i,int j)
    {
        Queue<CheckAll4> q=new ArrayDeque<>();
        int ans22=-1;
        q.offer(new CheckAll4(i,j,arr,n,m));
        boolean visited[][]=new boolean[n][m];
        visited[i][j]=true;
        boolean found=false;
        CheckAll4 curr=null;int size=0;
        while(!q.isEmpty()){
            size=q.size();
            for(int k=0;k<size;k++){
                curr=q.poll();
                i=curr.i;
                j=curr.j;
                if(curr.up==1 || curr.down==1 || curr.left==1 || curr.right==1){
                    found=true;
                    break;
                }
                else{
                    if(curr.up!=Integer.MIN_VALUE && visited[i+1][j]==false){
                        q.offer(new CheckAll4(i+1,j,arr,n,m));
                        visited[i+1][j]=true;
                    }
                    if(curr.down!=Integer.MIN_VALUE && visited[i-1][j]==false){
                        q.offer(new CheckAll4(i-1,j,arr,n,m));
                        visited[i-1][j]=true;
                    }
       
                    if(curr.left!=Integer.MIN_VALUE && visited[i][j-1]==false){
                        q.offer(new CheckAll4(i,j-1,arr,n,m));
                        visited[i][j-1]=true;
                    }
                    if(curr.right!=Integer.MIN_VALUE && visited[i][j+1]==false){
                        q.offer(new CheckAll4(i,j+1,arr,n,m));
                        visited[i][j+1]=true;
                    }
                }
            }
            
            // out of for loop 
            if(found){
                return ans22;
            }
            else{
                ans22--;
            }
        }
        
        return ans22;
    }
    class CheckAll4{
        int up,down,left,right;
        int i,j;
        CheckAll4(int i,int j,int [][]arr,int n,int m){
            up=Integer.MIN_VALUE;
            down=Integer.MIN_VALUE;
            left=Integer.MIN_VALUE;
            right=Integer.MIN_VALUE;
            this.i=i;
            this.j=j;
            if(i+1<n){
                up=arr[i+1][j];
            }
            if(i-1>=0){
                down=arr[i-1][j];
            }
            if(j-1>=0){
                left=arr[i][j-1];
            }
            if(j+1<m){
                right=arr[i][j+1];
            }
            
        }
        
    }

    
}


class Distance1MatrixNoBFS0TestCasePassed
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int v=n*m+1;
       int ans22[][]=new int[n][m];
       int left=Integer.MAX_VALUE-v;
        for(int i=0;i<n;i++){
            left=0;
            for(int j=0;j<m;j++){
               if(grid[i][j]==1){
                   ans22[i][j]=0;
                   left=1;
               }
              else{
                  ans22[i][j]=left;
                  left++;
              }
               
            }
            
        }
        
        int right=Integer.MAX_VALUE-v;
        for(int i=0;i<n;i++){
            right=0;
            for(int j=m-1;j>=0;j--){
               if(grid[i][j]==1){
                   ans22[i][j]=0;
                   right=1;
               }
              else{
                  ans22[i][j]=Math.min(ans22[i][j],right);
                  right++;
              }
               
            }
            
        }
        
        int up=Integer.MAX_VALUE-v;
        for(int j=0;j<m;j++){
            up=0;
            for(int i=0;i<n;i++){
               if(grid[i][j]==1){
                   ans22[i][j]=0;
                   up=1;
               }
              else{
                  ans22[i][j]=Math.min(ans22[i][j],up);
                  up++;
              }
               
            }
            
        }
        
         int down=Integer.MAX_VALUE-v;
        for(int j=0;j<m;j++){
            down=0;
            for(int i=n-1;i>=0;i--){
               if(grid[i][j]==1){
                   ans22[i][j]=0;
                   down=1;
               }
              else{
                  ans22[i][j]=Math.min(ans22[i][j],down);
                  down++;
              }
               
            }
            
        }
        return ans22;
        
    }
    
}

/**
 * 
 * Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell and i2, j2 are the row number and column number of the nearest cell having value 1. There should be at least one 1 in the grid.

Examples:

Input: grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}}
Output: {{1,0,0,1},{0,0,1,1},{1,1,0,0}}
Explanation: The grid is-
0 1 1 0 
1 1 0 0 
0 0 1 1 
0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's at (0,1), (0,2), (0,2), (2,3), (1,0) and (1,1) respectively.


 
Input: grid = {{1,0,1},{1,1,0},{1,0,0}}
Output: {{0,1,0},{0,0,1},{0,1,2}}
Explanation: The grid is-
1 0 1
1 1 0
1 0 0
0's at (0,1), (1,2), (2,1) and (2,2) are at a 
distance of 1, 1, 1 and 2 from 1's at (0,0),
(0,2), (2,0) and (1,1) respectively.


 
Brute force Approach:
Intuition:
The idea is to traverse the matrix for each cell and find the minimum distance, To find the minimum distance traverse the matrix and find the cell which contains 1 and calculates the distance between two cells and store the minimum distance.

Implementation:
Traverse the matrix from start to end (using two nested loops)
For every element find the closest element which contains 1. To find the closest element traverse the matrix(using two nested loops) and find the minimum distance.
class Solution 
{
    public:
    //Function to find distance of nearest 1 in the grid for each cell.
	vector<vector<int>>nearest(vector<vector<int>>grid)
	{
	    // Code here
	    int N=grid.size();
	    int M=grid[0].size();
	    vector<vector<int>> ans(N,vector<int>(M, INT_MAX));
    
        // For each cell
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
            {
                // Traversing the whole matrix
                // to find the minimum distance.
                for (int k = 0; k < N; k++)
                    for (int l = 0; l < M; l++)
                    {
                        // If cell contain 1, check
                        // for minimum distance.
                        if (grid[k][l] == 1)
                            ans[i][j] = min(ans[i][j],
                                 abs(i-k) + abs(j-l));
                    }
            }
            
        return ans;
	}
};
 

Complexity:
Time Complexity: O(N2*M2), For every element in the matrix, the matrix is traversed and there are N*M elements So the time complexity is O(N2*M2)
Auxiliary Space Complexity: O(1), No extra space is required.

Expected Approach:
Intuition:
The problem involves finding the distance of the nearest cell containing a value of 1 for each cell in the binary grid. This distance is defined as the Manhattan distance, which is the sum of the absolute differences between the row and column indices of two cells. To solve this problem, we can use a Breadth-First Search (BFS) approach. We start by identifying all the cells with a value of 1 and initializing their distances as 0. Then, we perform a BFS traversal, expanding from these initial 1-valued cells and updating the distances of neighboring cells iteratively.

Implementation:
We define two arrays dx and dy to represent the four possible directions: right, left, down, and up. This is used to explore neighboring cells.
We define a function isValid that checks whether a cell is within the matrix bounds.
The nearest function takes the binary grid as input and initializes the dimensions n and m based on the grid size.
We create a queue q to store the cell indexes that have a grid value of 1.
We initialize a 2D vector dp of size n x m to store the distances. Initially, all distances are set to INT_MAX.
We iterate through the entire grid to find cells with a value of 1. For each such cell, we set its distance to 0, update the corresponding position in the dp vector, and push the cell index onto the queue.
We perform BFS using the queue. While the queue is not empty, we dequeue the front cell's index, and then iterate through its neighboring cells using the dx and dy arrays.
For each neighboring cell, if it's a valid cell and its distance can be reduced (current distance + 1 is smaller than the stored distance), we update its distance in the dp vector and enqueue its index.
After the BFS traversal, the dp vector will contain the distances of each cell to the nearest cell containing a value of 1.
We return the dp vector as the result.
Example:

Code:
// Back-end Complete function Template for JAVA

class Solution
{
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    //Function to check whether the cell is within the matrix bounds.
    boolean isValid(int x, int y, int n, int m)
    {
		if (x>=0 && x<n && y>=0 && y<m)
		    return true;
		return false;
	}
	
	//Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        //using dp list which will store the output.
        int[][] dp = new int[n][m];
        
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                dp[i][j] = 10000000;
        
        //queue to store the cell indexes which have grid value 1.
        Queue<ArrayList<Integer>> q = new LinkedList<>(); 
        
        
        //traversing all the cells of the matrix.
        for(int i = 0; i < n; i++)
        {
			for(int j = 0; j < m; j++)
			{
			    //if grid value is 1, we update the dp value at same cell as 0 
			    //and push the cell indexes into queue.
				if(grid[i][j] == 1){
					dp[i][j] = 0;
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);
					q.add(temp);
				}
			}
		}
		
		while(!q.isEmpty())
		{
		    //storing the cell indexes at top of queue and popping them.
			ArrayList <Integer> curr = q.poll();
			int x = curr.get(0);
			int y = curr.get(1);
			
			//iterating over the adjacent cells.
			for(int i = 0; i < 4; i++)
			{
				int n_x = x + dx[i];
				int n_y = y + dy[i];
				
				if(isValid(n_x, n_y, n, m) && dp[n_x][n_y] > dp[x][y] + 1)
				{
				    //updating dp and pushing cell indexes in queue.
					dp[n_x][n_y] = dp[x][y] + 1;
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(n_x);
					temp.add(n_y);
					q.add(temp);
				}
			}
		}
		//returning the dp list.
		return dp;
    }
}
Complexity:
Time Complexity: O(N*M), In BFS traversal every element is traversed only once so time Complexity is O(M*N).
Space Complexity: O(M*N), To store every element in the matrix O(M*N) space is required.

Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/distance-nearest-cell-1-binary-matrix/
 * 
 * 
 */
