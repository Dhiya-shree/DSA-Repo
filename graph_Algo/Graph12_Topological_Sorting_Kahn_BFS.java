package graph_Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * Topological sorting :
 * 
 * Given a directed A-cyclic graph 
 * In topological sorting :
 * Consider vertices / nodes as Job 
 * Directed edges as Dependencies
 * 
 * Given 0-->1
 *       \-->2
 *       
 * Topological sorting ans :
 * ans 1: 0 1 2 
 * ans 2: 0 2 1 
 * Both above are correct
 * 
 *  Consider all are jobs 
 *  Do 0 first for t time 
 *  Then 1 next for t time 
 *  Finally 2 for t time 
 *  
 *  Ex 2)
 *      0    1
 *     / \  /  \
 *    2    3    4
 *    
 * Ans : 0 1 2 3 4  
 *       0 1 3 2 4  
 *       0 1 4 3 2
 *       0 2 1 4 3
 *       1 4 0 2 3 Above all are correct 
 *       
 *       1 4 3 0 2 NOT correct 
 *       3 execution based on 1 and 0 
 *       1 and 0 needs to be completed before working on 3
 *       
 *       
 * 0 and 1 are non dependent jobs 
 * Print 0/1 in any order first : 0 1 or 1 0
 * 
 * 2 is dependent on 0 , after 0 print anytime 
 * 
 * 4 is dependent on 1 , ater 1 print anytime 
 * 
 * 3 is dependent on both 0 and 1 , print after 0 and 1 anytime 
 * 
 * 
 * 
 * DFS and BFS can be used , Time O V+E 
 * 
 * KAHN'S algorithm:
 * BFS solution :
 * 1) Store integer of every vertex 
 * 2)Traverse BFS/DFS  create a array of indegree
 * 2)Create a queue q
 * 3) Add all 0 indegree vertex to queue ( Indegree starting point of queue)
 * 4) while q is not empty 
 *      curr= q.pop
 *      print curr
 *      for all adjacent of curr // we an not simply push in queue 
 *      // As we can have internal node dependency 
 *         Val -> reduce the indegree
 *         if indegree==0
 *            push in queue
 * 
 * 
 * DFS Topological sorting   O V+ E extra space queue 
 * 
 * For adj traverse with DFS 
 * Create a stack 
 * After recursive DFS call for curr adhjacent
 * Push the value to stack 
 * 
 * MUSTT to push stack after the recursive call 
 * or else we might not get correct order 
 * 
 * By stack push at end 
 * we ensure that last descendant is popped at last 
 * 
 *  With stack 
 *  Last nod 
 *  prev 
 *  prev's prev and so on can be achieved helping in sorting 
 * 
 * @author shree
 *
 */
public class Graph12_Topological_Sorting_Kahn_BFS {

	public static void main(String[] args) {
		//Topology sorting 
		// Consider node as job 
		// and sort it 
		//Create graph with adj list 
				GraphAdjList adj=new GraphAdjList(10);
				adj.AddEdgeDirected(0, 1);
				adj.AddEdgeDirected(0, 2);
			//	adj.AddEdgeDirected(0, 5);
				adj.AddEdgeDirected(2,4);
				adj.AddEdgeDirected(1,3);
				//adj.AddEdgeUnDirected(3,5);
				adj.AddEdgeDirected(4,5);		
				
				adj.AddEdgeDirected(6,7);
				adj.AddEdgeDirected(8,7);
				adj.AddEdgeDirected(6,5); //NO LOOP 
				adj.AddEdgeDirected(5,9);
				adj.PrintTheAdjacencyList();
				
///// KAHN sorting 
	
	  BFSTopologicalSort(adj.adj,adj.size);

		adj=new GraphAdjList(10);
		adj.AddEdgeDirected(0, 1);
		adj.AddEdgeDirected(0, 2);
		adj.AddEdgeDirected(0, 5);
		adj.AddEdgeDirected(2,4);
		adj.AddEdgeDirected(1,3);
		//adj.AddEdgeUnDirected(3,5);
		//adj.AddEdgeUnDirected(4,5);		
		
		adj.AddEdgeDirected(6,7);
		adj.AddEdgeDirected(8,7);
		adj.AddEdgeDirected(6,5); //NO LOOP 
		//adj.AddEdgeUnDirected(6,8);
		adj.PrintTheAdjacencyList();
		
	// DFS sort 
		DFSSortingTopological(adj.adj,adj.size);
	}

	private static void DFSSortingTopological(ArrayList<ArrayList<Integer>> adj, int size) {
		// dfs sorting 
		visited=new boolean[size];
		s=new Stack<>();
		
		for(int i=0;i<size;i++) {
			if(visited[i]==false) {
				DFSfromSorceSort(adj,size,i);
			}
		}
		System.out.println(" DFS sorted order ");
		while(!s.isEmpty()) {
			System.out.println(s.pop()+" ");
		}
	}

	private static void DFSfromSorceSort(ArrayList<ArrayList<Integer>> adj, int size, int i) {
		// normal dfs 
		
		if(visited[i]==false) {
			int size2=0,val=0;
			visited[i]=true;
			
			size2=adj.get(i).size();
			for(int k=0;k<size2;k++) {
				val=adj.get(i).get(k);
				if(visited[val]==false) {
					DFSfromSorceSort(adj, size, val);
				}
			}
			
			//for seeing sorted order 
			s.push(i);
		}
		
	}

	static boolean []visited; static Stack<Integer> s;
	private static void BFSTopologicalSort(ArrayList<ArrayList<Integer>> adj, int size) {
		// Store indegree of every vertex
		int size2=0;int val=0;
		int indegree[]=new int[size];
		//traverse every element adjacent 
		// all its adjacent have +1 indegree
		for(int i=0;i<size;i++) {  //O E
			// below will only give out degree
			//indegree[i]=adj.get(i).size();
			size2=adj.get(i).size();
			for(int j=0;j<size2;j++) {
				val=adj.get(i).get(j);
				indegree[val]++;
			}
		}
		
		
		//Create a Queue- it will only have points of indegree 0
		Queue<Integer> q=new ArrayDeque<>();
		
		//Add all 0 indegree vertices to queue
		for(int i=0;i<size;i++) {    //O V
			System.out.println(i+"--> "+indegree[i]);
			if(indegree[i]==0) {
				q.offer(i);
			}
		}
		
		
		int curr=0;
		//Condt 
		while(!q.isEmpty()) {   // O V+ E
			curr=q.poll();
			
			System.out.println(curr+" ");
			
			// decrease indegree of curr's adjacent 
			// if indegree ==0 put in queue
			size2=adj.get(curr).size();
			for(int i=0;i<size2;i++) {
				val=adj.get(curr).get(i);
				indegree[val]=indegree[val]-1;
				if(indegree[val]<1) {// 0
					q.offer(val);
				}
			}
		}
		
	}

}

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        s=new Stack<Integer>();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        int n=edges.length;
        ans=new ArrayList<Integer>();
        visited=new boolean[V];
        for(int i=0;i<V;i++){
            arr.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<n;i++){
            
            int s=edges[i][0];
            int e=edges[i][1];
            arr.get(s).add(e);
        }
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                dfs(i,arr);
            }
        }
       // while(!s.isEmpty)
     //  System.out.println(ans);
       return ans;
    }
   static ArrayList<Integer> ans;
    static Stack<Integer> s;
    static boolean visited[];
     public static void dfs(int src,ArrayList<ArrayList<Integer>> arr){
         if(!visited[src]){
             visited[src]=true;
             int n=arr.get(src).size();
             for(int i=0;i<n;i++){
                 dfs(arr.get(src).get(i),arr);
             }
             ans.add(0,src);
         }
     }
    
    
}
