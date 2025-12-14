package graph_Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * 
 *  Detect cycle in an Directed graph 
 *  1) Return true if cycle is present 
 *  2) else false
 *  
 *  There is a loop in directed ,
 *  Only if we have loop from curr to one of it's ancestor of path 
 *  
 *  Undirected graph cycle detection simple than directed 
 *  Two issue in detection of cycle :
 *  
 *  No One issue : Self loops with parent  Not happen in directed 
 *  1---2 is considered as cycle in undirected graph 1--2--1---2 and so on 
 *  
 *  So for every call we have to remember prev call 
 *  
 *  1---2---3---1 Loop 
 *  1---2---3---2 No a loop 
 *  
 *  For directed hraph 
 *  1--->2 NO loop
 *  1<---2 No Loop
 *    _____
 *   /     \ LOOP 1<---->2 Loop 
 *  1       2
 *   \_____/
 * Yes Two issue : X shape Only for directed 
 * Not occur for undirected  
 * Undirected when we reach to 5 
 * We will go till 2 , 3, 4 individually 
 * as 5--> 1,2,3,4
 * 
 * But in directed it might be 
 * 1--->5--->4  Here 5 may have out 5--> 2,4 
 * 3--->5--->2 So when checking for 3 , 5 will be true resulting in loop 
 * Need to start visited for every loop 
 *    1         3
 *     \       /
 *      \    /
 *        5
 *       /  \
 *      /     \
 *     2       4
 *  Above X shape 
 *  
 *  It will have issues even in 1---->2<------3
 *  For 1 and 3 , 2 will be visited so issue 
 * 
 *  Solution :
 *  Use two visited for DFS 
 *  visited 1----> To check if the number was called before and to make main call
 *  visited 2 ---> In a BFS/DFS from source , instantiate everytime before call 
 *                 If two true in a same call==> Loop 
 *                 
 *       
 *  Cycle detection - BFS 
 *  Using Kahn's Topologcal sort 
 *  
 *   Topological sorting will only work for ayclic graph 
 *   
 *  Kahn algo working :
 *  Find indegree 
 *  Put 0 indegree in queue 
 *  Pop queue and reduce indegree of its adjacent 
 *  
 *  When we have cyclic graph 
 *  After inserting in queue 
 *  While taking adjacent 
 *  We will have nodes of indegree 0 as its adjacent
 *  If a loop exists 
 *   
 * KAHN'S algorithm:
 * BFS solution :
 * 1) Store integer of every vertex 
 * 2)Traverse BFS/DFS  create a array of indegree
 * 2)Create a queue q
 * 3) Add all 0 indegree vertex to queue ( Indegree starting point of queue)
 * 4) while q is not empty 
 * 5) every time on popping count ++
 *      curr= q.pop 
 *      print curr
 *      for all adjacent of curr // we an not simply push in queue 
 *      // As we can have internal node dependency 
 *         Val -> reduce the indegree
 *         if indegree==0
 *            push in queue
 *            
 * 6) if count== V no loop 
 *       count<V loop 
 * 
 * @author shree
 *
 */
public class Graph11_detect_cycle_directed {

	public static void main(String[] args) {
		//Create graph with adj list 
		GraphAdjList adj=new GraphAdjList(10);
		adj.AddEdgeDirected(0, 1);
		adj.AddEdgeDirected(0, 2);
		adj.AddEdgeDirected(4,0);
		adj.AddEdgeDirected(2,4);
		adj.AddEdgeDirected(1,3);
		//adj.AddEdgeUnDirected(3,5);
		adj.AddEdgeDirected(4,5);		
		
		adj.AddEdgeDirected(6,7);
		adj.AddEdgeDirected(8,7);
		adj.AddEdgeDirected(6,5); //NO LOOP 
		//adj.AddEdgeUnDirected(6,8);
		adj.PrintTheAdjacencyList();

		
		boolean anb=CheckForLoopDFS(adj.adj,adj.size);
		System.out.println(" Loop through DFS "+anb);
		
		// using kahns algorithm 
		anb=CheckForLoopBFS(adj.adj,adj.size);
		System.out.println(" Loop through BFS "+anb);
		
	}
   private static boolean CheckForLoopBFS(ArrayList<ArrayList<Integer>> adj, int size) {
		// store indegree
	   int indegree[]=new int[size];
	   int size2=0,val=0;
	   for(int i=0;i<size;i++) {
		   size2=adj.get(i).size();
		   for(int j=0;j<size2;j++) {
			   val=adj.get(i).get(j);
			   indegree[val]++;
		   }
	   }
	   
	   Queue<Integer> q=new ArrayDeque<>();
	   // Put 0 indegree in queue 
	   // if nodes in a cycle 
	   //in degree will not be zero
	   for(int i=0;i<size;i++) {
		   if(indegree[i]==0) {
			   q.offer(i);
		   }
	   }
	   
	   // if no 0 degree 
	   // All nodes formed a cycle 
	   if(q.isEmpty()) {
		   System.out.println(" No node with degree 0 , because of cycle ");
		   return true;
	   }
	   System.out.println(Arrays.toString(indegree));
	   int count=0;
	   int curr=0;
	   while(!q.isEmpty()) {
		   curr=q.poll();
		   count++;//count ++
		   System.out.print(curr+" "+count+"...........");
		   
		   size2=adj.get(curr).size();
		   
		   for(int i=0;i<size2;i++) {
			   
			   val=adj.get(curr).get(i);
			   
			   System.out.println("At "+val+" "+Arrays.toString(indegree)+" count "+count);
			   if(indegree[val]==0) {
				//   return true;
			   }
			   
			   indegree[val]--;
			   if(indegree[val]==0) {
				//   indegree[val]=-1;
				   q.offer(val);
			   }
			   System.out.println(q.toString());
		   }
		   
	   }
	   System.out.println(" Count "+count+"- size "+size);
	   if(count==size) {
		   return false;//no loop
	   }
		return true;
	}
static boolean visited[];static boolean inPath[];
	private static boolean CheckForLoopDFS(ArrayList<ArrayList<Integer>> adj, int size) {
		// check for loop 
		visited=new boolean[size];
		boolean anb=false;
		for(int i=0;i<size;i++) {
			if(visited[i]==false && anb==false) {
				inPath=new boolean[size];
				anb=DFScheckforLoopSource(adj,i);// No need for prev
			}
		}
		return anb;
	}
	private static boolean DFScheckforLoopSource(ArrayList<ArrayList<Integer>> adj,  int source) {
		// dfs check loop 
		System.out.println(" Check on "+source);
		if(inPath[source]) {
			System.out.println(" Loop at "+source);
			return true;
		}
		else {
			inPath[source]=true;
			visited[source]=true;
			int size2=adj.get(source).size();
			int val=0;
			for(int i=0;i<size2;i++) {
				val=adj.get(source).get(i);
				if(inPath[val]) {
					System.out.println(" Loop at "+source+"--"+val);
					return true;
				}
				else {
					if(DFScheckforLoopSource(adj, val))
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
/**
Directed Graph Cycle
Difficulty: MediumAccuracy: 27.88%Submissions: 473K+Points: 4
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

Examples:

Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]

Output: true
Explanation: The diagram clearly shows a cycle 0 → 2 → 0
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]

Output: false
Explanation: no cycle in the graph
Constraints:
1 ≤ V, E ≤ 105

**/

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int n=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
  //      System.out.println(adj);
        visited=new boolean[V];
        for(int i=0;i<V;i++){
        parent=new boolean[V];
            if(visited[i]==false){
                if(dfs(i,adj)){
                    return true;
                }
            }
        }
        return false;
        
    }
    boolean visited[];boolean parent[];
    public boolean dfs(int src,ArrayList<ArrayList<Integer>> adj){
        if(parent[src]){
            return true;
        }
        visited[src]=true;
        parent[src]=true;
        int s=adj.get(src).size();
        for(int i=0;i<s;i++){
            if(dfs(adj.get(src).get(i),adj)){
                return true;
            }
        }
        parent[src]=false;
        return false;
    }
}
