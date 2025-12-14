package graph_Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 
 * Problem #1: Find the nmber of islands in matrix 
 * 
 * Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.

Note: An island is either surrounded by water or boundary of grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Example 1:

Input:
grid = {{0,1},{1,0},{1,1},{1,0}}
Output:
1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.
Example 2:

Input:
grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
Output:
2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 1 0 
There are two islands :- one is colored in blue 
and other in orange.
Your Task:
You don't need to read or print anything. Your task is to complete the function numIslands() which takes the grid as an input parameter and returns the total number of islands.

Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n*m)

Constraints:1 ≤ n, m ≤ 500
 * 
 * 
 * Problem # 2: Find whether path exists 
 * Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall.
Note: There are only a single source and a single destination.
 

Example 1:

Input: grid = {{3,0,3,0,0},{3,0,0,0,3}
,{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}}
Output: 0
Explanation: The grid is-
3 0 3 0 0 
3 0 0 0 3 
3 3 3 3 3 
0 2 3 0 0 
3 0 0 1 3 
There is no path to reach at (3,1) i,e at 
destination from (4,3) i,e source.
Example 2:

Input: grid = {{1,3},{3,2}}
Output: 1
Explanation: The grid is-
1 3
3 2
There is a path from (0,0) i,e source to (1,1) 
i,e destination.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function is_Possible() which takes the grid as input parameter and returns boolean value 1 if there is a path otherwise returns 0.
 

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)
 

Constraints:
1 ≤ n ≤ 500

 * 
 * Problem # 3 : Level of nodes ( BFS visited must )
 * 
 * Given an integer X and an undirected acyclic graph with V nodes, labeled from 0 to V-1, and E edges, find the level of node labeled as X.

Level is the minimum number of edges you must travel from the node 0 to some target.

If there doesn't exists such a node that is labeled as X, return -1.

Example 1:

Input:

X = 4
Output:
2
Explanation:

We can clearly see that Node 4 lies at Level 2.
Example 2:

Input:

X = 1
Output:
1
Explanation:
Node 1 lies at level 1, immediate after Node 0.
Your task:
You dont need to read input or print anything. Your task is to complete the function nodeLevel() which takes two integers V and X denoting the number of vertices and the node, and another adjacency list adj as input parameters and returns the level of Node X. If node X isn't present it returns -1.

Expected Time Complexity: O(V)
Expected Auxiliary Space: O(V)

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ 104
0 ≤ adji, j < V
1 ≤ X < V
Graph doesn't contain multiple edges and self loops.
 * 
 * 
 * Problem # 4: Possible Path between 2 vertices 
 *                 DFS visited No need
 * Given a Directed Graph having V nodes numbered from 0 to V-1, and E directed edges. Given two nodes, source and destination, count the number of ways or paths between these two vertices in the directed graph. These paths should not contain any cycle.
Note: Graph doesn't contain multiple edges, self-loop, and cycles.


Example 1:

Input:
V = 5, E = 7
Edges of Graph = 
{0, 1}
{0, 2}
{0, 4}
{1, 3}
{1, 4}
{2, 4}
{3, 2}
source = 0 
destination = 4

Output: 4
Explanation: 

There are 4 paths from 0 to 4.
0 -> 4
0 -> 1 -> 4
0 -> 2 -> 4
0 -> 1 -> 3 -> 2 -> 4

Example 2:

Input:
V = 4, E = 5
Edges of Graph = 
{0, 1}
{0, 3}
{1, 2}
{1, 3}
{2, 3}
source = 0 
destination = 3
Output: 3
Explanation:

There are 3 paths from 0 to 3.
0 -> 3
0 -> 1 -> 3
0 -> 1 -> 2 -> 3

Your task:
You don't need to read, input, or print anything. Your task is to complete the function countPaths(), which takes the integer V denoting the number of vertices, adjacency list adj, integer source, and destination as input parameters and returns the number of paths in the graph from the source vertex to the destination vertex.


Expected Time Complexity: O(V!)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 100
1 ≤ source, destination ≤ V


 * 
 * 
 * Problem #5 : X total shapes (no of iland)
 * 
 * Given  a grid of n*m consisting of O's and X's. The task is to find the number of 'X' total shapes.
Note: 'X' shape consists of one or more adjacent X's (diagonals not included).
 

Example 1:

Input: grid = {{X,O,X},{O,X,O},{X,X,X}}
Output: 3
Explanation: 
The grid is-
X O X
O X O
X X X
So, X with same colour are adjacent to each 
other vertically for horizontally (diagonals 
not included). So, there are 3 different groups 
in the given grid.

Example 2:

Input: grid = {{X,X},{X,X}}
Output: 1
Expanation: 
The grid is- 
X X
X X
So, X with same colour are adjacent to each
other vertically for horizontally (diagonals
not included). So, there is only 1 group
in the given grid.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function xShape() which takes grid as input parameter and returns the count of total X shapes.
 

Expected Time Compelxity: O(n*m)
Expected Space Compelxity: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 100
 * 
 * @author shree
 *
 */
class PairCount{
    int i,j;
    PairCount(int i,int j){
        this.i=i;
        this.j=j;
    }
}

public class Graph08_sums_medium_bfs_dfs {

	public static void main(String[] args) {
		// matric with BFS and DFS 
		char grid1[][]={{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
		System.out.println(" No of islands "+numIslands(grid1));
		
      int grid2[][] = {{3,0,3,0,0},{3,0,0,0,3}
      ,{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}};
      // 2 destination 
      // 1 source 
      // Check if path from 1 to 2 is there 
      // 0 wall , can not pass 
      System.out.println(" Is possible "+is_Possible(grid2));
      
      int grid3[][]= {{0,0,1,1},{1,1,0,0},{1,1,0,0},{0,0,1,1}};
      ArrayList<ArrayList<Integer>> adj=printGraphArrayToList(4,grid3);
	
	  int V=4,X=3;
      System.out.println(" Node level is "+nodeLevel(V,adj,X));

	 //  int E=3;
	 //V5 E7 int grid4[][]={{0, 1},{0, 2}, {0, 4},{1, 3},{1, 4},{2, 4},{3, 2}};
	System.out.println(" No of path between sorce and destination is "+countPaths(V,adj,1,3));
	char grid5[][]= {{'X','O','X'},{'O','X','O'},
			{'X','X','X'}};	
	
	System.out.println(" Toal no of X is "+xShape(grid5));
	}
	
	// Function to find the number of islands.
    public static int numIslands(char[][] grid) {
        // Num of islands 
        // DFS or BFS will work 
        //Use DFS 
        //Best path 
      int   n=grid.length;
         int m=grid[0].length;
        //int arr[][]=new int[n*m][n*m]; int t=0;
         visited1=new boolean[n][m];
      int ans=0;
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]=='0'){
                  // visited1[i][j]=1;
               }
               else{
                     if(visited1[i][j]==false){
                 BFSNoOfIsland(grid,i,j,n,m);
                 ans++;
             }
                   // check 8 sides if to
                  // find any unconnected islands
               }
           } 
        }
       
         return ans;
        
    }
  
    static void BFSNoOfIsland(char[][] grid,int i,int j,int n,int m){
        
        Queue<PairCount> q=new ArrayDeque<PairCount>();
        q.offer(new PairCount(i,j));
        
        PairCount curr=null;int size=0;
        while(!q.isEmpty()){
            size=q.size();
            for(int k=0;k<size;k++){
                curr=q.poll();
                 i=curr.i;
                   j=curr.j;
            //    System.out.println(curr.i+" "+curr.j);
                if(visited1[i][j]==false){
                   visited1[i][j]=true;
                   
                   
 {// Add 8 possible combo 
            
            if(j-1>-1 && grid[i][j-1]=='1' && visited1[i][j-1]==false){
                q.offer(new PairCount(i,j-1)); }
            if(j+1<m && grid[i][j+1]=='1' && visited1[i][j+1]==false){
                q.offer(new PairCount(i,j+1)); }
            
            if(i-1>-1 && grid[i-1][j]=='1' && visited1[i-1][j]==false){
                q.offer(new PairCount(i-1,j)); }
            if(i+1<n && grid[i+1][j]=='1' && visited1[i+1][j]==false){ 
                q.offer(new PairCount(i+1,j)); }
            
            if(j-1>-1 && i+1<n
            && grid[i+1][j-1]=='1' && visited1[i+1][j-1]==false){
                q.offer(new PairCount(i+1,j-1)); }
            if(j+1<m && i+1<n&& grid[i+1][j+1]=='1' && visited1[i+1][j+1]==false){
                q.offer(new PairCount(i+1,j+1)); }
            
            if(i-1>-1 && j-1>-1 && grid[i-1][j-1]=='1'
            && visited1[i-1][j-1]==false){ q.offer(new PairCount(i-1,j-1)); }
            if(i-1>-1 && j+1<m && grid[i-1][j+1]=='1'
            && visited1[i-1][j+1]==false){ q.offer(new PairCount(i-1,j+1)); }
               
                        
  }// end adding in queue
                }
            }
        }
    }
    
    static boolean visited1[][];

	
	 public static boolean is_Possible(int[][] grid)
	    {
	        // Code here
	        n=grid.length;
	        m=grid[0].length;int si=0,sj=0;int found=0;int zero=0;
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(grid[i][j]==1){
	                    si=i;
	                    sj=j;
	                    found++;
	                }
	                if(grid[i][j]==2){
	                    if(i+1<n){ 
	                     if(grid[i+1][j]==1){ return true;}  
	                     if(grid[i+1][j]==0){zero++;} }
	                   if(i-1>-1){ 
	                     if(grid[i-1][j]==1){ return true;}  
	                     if(grid[i-1][j]==0){zero++;} }
	                   if(j-1>-1){ 
	                     if(grid[i][j-1]==1){ return true;}  
	                     if(grid[i][j-1]==0){zero++;} }
	                   if(j+1<m){ 
	                     if(grid[i][j+1]==1){ return true;}  
	                     if(grid[i][j+1]==0){zero++;} }
	                     if(zero==4){
	                       //  System.out.println(" 4 zero ");
	                         return false;
	                     }
	                     else{
	                    di=i;
	                    dj=j;
	                    found++;
	                     }
	                }
	                
	            }
	            if(found==2){
	                    break;}
	        }
	        
	        //Need to only find path 
	        anb=false; visited2=new boolean[n][m];
	        DFSPossible(si,sj,grid);
	        return anb;
	    }
	    static int n;

		static int m;

		static int di;

		static 
		int dj;static boolean anb;static boolean visited2[][];
	    
	    static void DFSPossible(int i,int j,int grid[][]){
	        
	        if(grid[i][j]==2){
	            anb=true;
	            return;
	        }
	        
	        visited2[i][j]=true;
	        //down
	        if(i+1<n && visited2[i+1][j]==false && grid[i+1][j]!=0 && anb==false){
	            if(grid[i+1][j]==2){
	                anb=true;
	                return;
	            }
	            DFSPossible(i+1,j,grid);
	        }
	        //up
	        if(i-1>-1 && visited2[i-1][j]==false && grid[i-1][j]!=0 && anb==false){
	             if(grid[i-1][j]==2){
	                anb=true;
	                return;
	            }
	            DFSPossible(i-1,j,grid);
	        }
	        //right
	        if(j+1<m && visited2[i][j+1]==false && grid[i][j+1]!=0 && anb==false){
	             if(grid[i][j+1]==2){
	                anb=true;
	                return;
	            }
	            DFSPossible(i,j+1,grid);
	        }
	        //left
	        if(j-1>-1 && visited2[i][j-1]==false && grid[i][j-1]!=0 && anb==false){
	             if(grid[i][j-1]==2){
	                anb=true;
	                return;
	            }
	            DFSPossible(i,j-1,grid);
	        }
	        
	    }
	
	static //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        //Boi do simple BFS with source 0 
        boolean visited[]=new boolean[V];
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(0);//from 0
        if(X==0){
            return 0;
        }
        
        int curr=0,size=0;int ans=0;int size2=0;int val=0;
        while(!q.isEmpty()){
            size=q.size();
            for(int k=0;k<size;k++){
                curr=q.poll();
                
                if(curr==X){
                    return ans;
                }
                if(visited[curr]==false){
                    visited[curr]=true;
                    
                    size2=adj.get(curr).size();
                    for(int l=0;l<size2;l++){
                        val=adj.get(curr).get(l);
                        if(visited[val]==false){
                            q.offer(val);
                        }
                    }
                }
            }
            ans++;
        }
        
        return -1;
    }
	
	    // Function to count paths between two vertices in a directed graph.
	    public static int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
	                   int destination) {
	        // Code here
	        
	        //No of ways asked , blindly go with DFS 
	        visited4=new boolean[V];ans=0;
	        DFSPathCount(adj,source,destination);
	        return ans;
	    }
	    
	    static boolean visited4[];static int ans;
	      public static void DFSPathCount(ArrayList<ArrayList<Integer>> adj, int source,
	                   int destination) {
	         
	         if(source==destination){
	             ans++;
	             return;
	         }    
	         //No cycle no need for visited4 
	         if(visited4[source]==false){
	             visited4[source]=true;
	             int size=adj.get(source).size();
	             int val=0;
	             for(int k=0;k<size;k++){
	                 val=adj.get(source).get(k);
	                 if(visited4[val]==false){ //NO cycle no need for visited4 
	                     DFSPathCount(adj,val,destination);
	                 }
	             }
	        }          
	                       
	         }
	
	
	//Function to find the number of 'X' total shapes.
    public static int xShape(char[][] grid)
    {
        // code here
        int n=grid.length;int m=grid[0].length;
        int ans=0;
        visited5=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X' && visited5[i][j]==false){
                    BFSXShape(i,j,grid,n,m);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    static boolean visited5[][];
    static void BFSXShape(int i,int j,char[][] grid,int n,int m){
        
        Queue<XShape> q=new ArrayDeque<>();
        q.offer(new XShape(i,j));
        int size=0;XShape curr=null;
        while(!q.isEmpty()){
            size=q.size();
            for(int k=0;k<size;k++){
                curr=q.poll();
                i=curr.i;j=curr.j;
                if(visited5[i][j]==false){
                    visited5[i][j]=true;
                    
     {//add in queue
         if(i+1<n && grid[i+1][j]=='X' && visited5[i+1][j]==false){
             q.offer(new XShape(i+1,j));
         }
         if(i-1>-1 && grid[i-1][j]=='X' && visited5[i-1][j]==false){
             q.offer(new XShape(i-1,j));
         }
         if(j+1<m && grid[i][j+1]=='X' && visited5[i][j+1]==false){
             q.offer(new XShape(i,j+1));
         }
         if(j-1>-1 && grid[i][j-1]=='X' && visited5[i][j-1]==false){
             q.offer(new XShape(i,j-1));
         }
         
     }// end add
        
                    
                }
            }
        }
    }
    
   
    private static ArrayList<ArrayList<Integer>> printGraphArrayToList(int V, int edges[][]) {
        
        //List interface - can not be instantiated 
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(V);
        // Must use above 
        //or else can not be converted lis <---- arraylist 
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        int size=edges.length;
        //Undirected graph
        int u=0;int v=0;
        for(int i=0;i<size;i++){
            v=edges[i][0];u=edges[i][1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        //Formed adjacency list 
        // Print the same 
        return adj;
    }
}

class XShape{
    int i,j;
    XShape(int x,int y){
        i=x;
        j=y;
    }
}


