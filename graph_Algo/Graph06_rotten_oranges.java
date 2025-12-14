package graph_Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

/**
 * 
 * Rotten Oranges
Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
 

Your Task:
You don't need to read or print anything, Your task is to complete the function orangesRotting() which takes grid as input parameter and returns the minimum time to rot all the fresh oranges. If not possible returns -1.
 

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 500
 * 
 * 
 * @author shree
 *
 */

class PairOpoint{
    int i,j;
    PairOpoint(int x,int y){
        i=x;
        j=y;
    }
}

public class Graph06_rotten_oranges {

	public static void main(String[] args) {
		// check if any fresh orange is stranded if yes return -1
		// BFS for every 1 fresh till we reach value 2
		// or bfs for every 2 and store the max for every fresh
		// compoare all fresh time and max of time ans

		int arr[][]= {{0,1,2},{0,1,2},{2,1,1}};
		int maxtime=orangesRotting(arr);
		System.out.println(" Max time for orange rott "+maxtime);
	}
	public static int orangesRotting(int[][] grid)
    {
       
         n=grid.length; m=grid[0].length;
        int ans=-1;int Fans=0;
      //  int ans[][]=new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(  grid[i][j]==1 &&
                    ((i+1<n && grid[i+1][j]==0) ||(i+1>=n)) &&
                    ((i-1>-1 && grid[i-1][j]==0 )||(i-1<0)) &&
                    ((j+1<m && grid[i][j+1]==0) || (j+1>=m)) &&
                ( (j-1>-1 && grid[i][j-1]==0 ||   j-1<0 )) 
                      ){
                          return -1;
                          //1 surrounded by all 0 
                      }
    
                  if(grid[i][j]==1){
                      if((i+1<n && grid[i+1][j]==2) ||
                    (i-1>-1 && grid[i-1][j]==2 )||
                    (j+1<m && grid[i][j+1]==2) || 
                (j-1>-1 && grid[i][j-1]==2 ) 
                      ){
                          ans=1;
                      }
                      else{
                          
                     ans= NearestRotten(grid,i,j);
                    // System.out.println(i+"-"+j+" :"+ans);
                      }
                     Fans=Math.max(ans,Fans);
                  }
       
       }
       
       
       }
       return Fans;
    }
    static int n;
	static int m;
       static int NearestRotten(int grid[][],int i,int j){
           boolean visit[][]=new boolean[n][m];
           Queue<PairOpoint> q=new ArrayDeque<>();
           q.offer(new PairOpoint(i,j));
           PairOpoint curr=null;int size=0;
           int ans=0;
           while(!q.isEmpty()){
               size=q.size();
               for(int k=0;k<size;k++){
                   curr=q.poll();
                   i=curr.i;
                   j=curr.j;
                   if(grid[i][j]==2){
                       return ans;
                   }
                   if(visit[i][j]==false){
                       visit[i][j]=true;
                  if(i+1<n ){
                      if(grid[i+1][j]==2){
                          return ans+1;
                      }
                      if(grid[i+1][j]==1){
                      q.offer(new PairOpoint(i+1,j));
                      }
                  }
                   if(i-1>=0){
                      if(grid[i-1][j]==2){
                          return ans+1;
                      }
                      if(grid[i-1][j]==1){
                      q.offer(new PairOpoint(i-1,j));
                      }
                  }
                   if(j+1<m ){
                      if(grid[i][j+1]==2){
                          return ans+1;
                      }
                      if(grid[i][j+1]==1){
                      q.offer(new PairOpoint(i,j+1));
                      }
                  }
                if(j-1>=0 ){
                      if(grid[i][j-1]==2){
                          return ans+1;
                      }
                      if(grid[i][j-1]==1){
                      q.offer(new PairOpoint(i,j-1));
                      }
                  }
                   
                   
               }
           }
           ans++;
       }
       return ans;
}  

}

class SolutionBFSDFSrottenOrangeTimeLimitExceeded
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        HashSet<Integer> fresh=new HashSet<>();
        int n=grid.length;int m=grid[0].length;
        int v=0;
        int V=n*m;
        int noOfrot=0;int noOfNull=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        ans=new ArrayList<>(V);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(  grid[i][j]==1 &&
                    ((i+1<n && grid[i+1][j]==0) ||(i+1>=n)) &&
                    ((i-1>-1 && grid[i-1][j]==0 )||(i-1<0)) &&
                    ((j+1<m && grid[i][j+1]==0) || (j+1>=m)) &&
                ( (j-1>-1 && grid[i][j-1]==0 ||   j-1<0 )) 
                      ){
                          return -1;
                          //1 surrounded by all 0 
                      }
                      
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
                if(grid[i][j]==2){
                    noOfrot++;
                    ans.add(0);
                }
                else if(grid[i][j]==0){
                    noOfNull++;
                    ans.add(-1);
                }
                else{
                    fresh.add(v);
                    ans.add(V+1);
                }
                v++;
            }
            
        }
        
        //Special case no fresh oranges 
        if(noOfrot==0||noOfNull==(v-1)|| fresh.size()==(v-1)){
        //    System.out.println(" ...");
            return 0;
        }
       // System.out.println(adj.toString());
         int fin=-1;int dfsAns=0;
        for(int x: fresh){
            visited=new boolean[V];
           // ans.set(x,0);
        //   value=BFS(adj,x,0);
      
          
       //    fin=Math.max(value,fin);
     //     System.out.println();
        ansFound=false;
          DFS(adj,x,1);
     //     System.out.println(x+" "+ans.toString()+dfsAns);
          fin=Math.max(dfsAns,fin);
        }
        
        return fin;
        
    }
    
    boolean visited[];ArrayList<Integer> ans;int dfsAns;
    @SuppressWarnings("unused")
	private int BFSOrangesTry(ArrayList<ArrayList<Integer>> adj,
    int source) {
		
		int v=adj.size();
		
		//To check for cycle
		boolean visited[]=new boolean[v];int time=0;
		//Level order traversal put source in queue
		Queue<Integer> q=new ArrayDeque<>();
		q.add(source);
		//visited[source]=true;
		int size2=0;
		int size=0;int curr=0;int curr2=0;
		while(!q.isEmpty()) {
			size=q.size();
		
			for(int i=0;i<size;i++) {
				curr=q.poll();
				if(ans.get(curr)==0){
				    return time;
				}
				if(visited[curr]|| ans.get(curr)==-1 || ans.get(curr)==0) {
					//visited true continue 
					continue;
				}
				else {
			//		System.out.print(curr+" ");
					visited[curr]=true;
					size2=adj.get(curr).size();
					for(int j=0;j<size2;j++) {
						curr2=adj.get(curr).get(j);
						if(visited[curr2]==false) {
							q.add(curr2);
						}
					}
					
				}
			}
			time++;
		}
		return time;
	//	System.out.println(" BFS from source completed considering No unconnected vertex");
       
	
	}



    boolean ansFound;
    public void DFS(ArrayList<ArrayList<Integer>> adj,int source,int time){
      //  time++;
        if(visited[source]==false){
            visited[source]=true;
           // System.out.print(source+"-"+time+"   "+adj.get(source).toString());
            ans.set(source,Math.min(ans.get(source),time));
            int val=0;
        int size=adj.get(source).size();
        for(int i=0;i<size;i++){
            val=adj.get(source).get(i);
            if(ans.get(val)==0){
                dfsAns=time;
                ansFound=true;
                return;
            }
            if(ansFound==false && visited[val]==false && 
            ans.get(val)!=0 && ans.get(val)!=-1 &&
            ans.get(val)>time+1){
                DFS(adj,val,time+1);
            }
            else if(ansFound==false && visited[val]==false && 
            ans.get(val)!=0 && ans.get(val)!=-1){
                dfsAns=ans.get(val)+1;
            }
        }
        
        
        }
    }
}

/**

Given a grid of dimension n*m where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh oranges at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 

Examples:
Input:  arr[][C] = { {2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
Output: 2
Explanation: At 0th time frame:
{2, 1, 0, 2, 1}
{1, 0, 1, 2, 1}
{1, 0, 0, 2, 1}
At 1st time frame:
{2, 2, 0, 2, 2}
{2, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
At 2nd time frame:
{2, 2, 0, 2, 2}
{2, 0, 2, 2, 2}
{2, 0, 0, 2, 2}

Input:  arr[][C] = { {2, 1, 0, 2, 1}, {0, 0, 1, 2, 1}, {1, 0, 0, 2, 1}}
Output: -1
Explanation: At 0th time frame:
{2, 1, 0, 2, 1}
{0, 0, 1, 2, 1}
{1, 0, 0, 2, 1}
At 1st time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
At 2nd time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
The 1 at the bottom left corner of the matrix is never rotten hence output is -1.

Brute Force Approach
Intuition:
The idea is very basic. Traverse through all oranges in multiple rounds. In every round, rot the oranges to the adjacent position of oranges that were rotten in the last round.

Implementation:
Initialize an answer variable with 0 to store the answer.
Run a loop until there is no cell of the matrix which is changed in an iteration.
Initialize a bool variable changed=false to check if there is any change in the oranges or not in each iteration.
Create an empty vector v to store the cell index whose value is 2.
Run a nested loop and traverse the matrix. If the element of the matrix is equal 2 then push the row and column pair into the vector.
 Now traverse over the vector v, if the adjacent element's value is equal to 1, i.e. not rotten, and update changed to true.
Check if changed==false the break the loop.
Traverse the matrix and check if there is any cell which is 1. If 1 is present return -1
Else return ans.
Code:
class Solution 
{
    public:
    //Function to find minimum time required to rot all oranges. 
    bool issafe(int i, int j,int n,int m)
    {
        if (i >= 0 && i < n && j >= 0 && j < m)
            return true;
        return false;
    }
    int orangesRotting(vector<vector<int>>& grid) 
    {
        int n=grid.size();
        int m=grid[0].size();
        int ans=0;
        while(true) {
            bool changed=false;
            vector<pair<int,int>> v;
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if (grid[i][j] == 2) {
                        v.push_back({i,j});
                    }
                }
            }
            for(int k=0;k<v.size();k++) {
                int i=v[k].first;
                int j=v[k].second;
                if (issafe(i + 1, j,n,m) && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    changed = true;
                }
                if (issafe(i, j + 1,n,m) && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    changed = true;
                }
                if (issafe(i - 1, j,n,m) && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    changed = true;
                }
                if (issafe(i, j - 1,n,m) && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    changed = true;
                }
            }
            if(changed==false) break;
            ans++;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }
        return ans;
    }
};
Complexity Analysis:
Time Complexity: O((N*M) * (N *M)). The matrix needs to be traversed again and again until there is no change in the matrix, that can happen max(N *M)/2 times. So time complexity is O((N * M) * (N *M)).
Space Complexity: O(N*M). where N is the number of rows and M is the number of columns of grid.
Expected Approach
Intuition:
The idea is to use Breadth First Search. The condition of oranges getting rotten is when they come in contact with other rotten oranges. This is similar to breadth-first search where the graph is divided into layers or circles and the search is done from lower or closer layers to deeper or higher layers using multisource BFS.

Implementation:
Create an empty queue Q and two variables count(store number of oranges which is rotten or needs to be rotten) and answer(store answer). 
Find all rotten oranges and enqueue them to Q also set the count variable accordingly.
Run a loop While Q is not empty.
Increase the answer by 1.
Now calculate the size of the queue(i.e number of elements present in the queue) and run a loop from 0 to the size of the queue.
Dequeue an orange from the queue, and rot all adjacent oranges(if present) and decrease the count variable.
While rotting the adjacent, push the index into the queue.
Now the oranges rotten this time frame is only present in the queue.
If count>0 then return -1.
Else return max(0, answer).
Example walkthrough:


 

 
Code:
// Back-end Complete function Template for JAVA

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int ct = 0, res = -1;
        
        //queue to store cells which have rotten oranges.
        Queue<ArrayList<Integer>> q = new LinkedList<>(); 
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        //traversing over all the cells of the matrix.
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                //if grid value is more than 0, we increment the counter.
                if(grid[i][j]>0) 
                    ct++;
                //if grid value is 2, we push the cell indexes into queue.
                if(grid[i][j]==2)
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    q.add(temp);
                }
            }
        }
        
        while(!q.isEmpty())
        {
            //incrementing result counter.
            res++;
            int size = q.size();
            for(int k=0; k<size; k++)
            {
                //popping the front element of queue and storing cell indexes.
                ArrayList<Integer> cur=q.poll();
                ct--;
                
                //traversing the adjacent vertices.
                for(int i=0; i<4; i++)
                {
                    int x=cur.get(0)+dx[i], y=cur.get(1)+dy[i];
                    
                    //if cell indexes are within matrix bounds and grid value
                    //is not 1, we continue the loop else we store 2 in current
                    //cell and push the cell indexes in the queue.
                    if(x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y]!=1)
                        continue;
                    grid[x][y]=2;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(y);
                    q.add(temp);
                }
            }
        }
        //returning the minimum time.
        if(ct==0)
            return Math.max(0, res);
        return -1;
    }
}
Complexity Analysis:
Time Complexity: O( N *M). Each element of the matrix can be inserted into the queue only once so the upper bound of iteration is O(R*C), i.e. the number of elements. So time complexity is O(N *M).
Space Complexity: O(N*M). To store the elements in a queue O(N*M) space is needed.


*/