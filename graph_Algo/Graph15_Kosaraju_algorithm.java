package graph_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * 
 * Kosaraju ' s Algorithm 
 * 
 * Used to solve strongly connected components problem 
 * 
 * Given a directed graph Find all stong connected components 
 * 
 *  strongly connected components
 *  
 *  Components from which 1 can reach all other 
 *  Ex )
 *    1--->2--->3--->1 
 *    
 *    All 1,2,3 can reach anyone , so 1,2,3 are strong connected components 
 *    
 * In undirected , every connected vertex is strongly connected
 *   Ex ) 1<---->2
 *  
 * For undirected :
 * BFS / DFS gives the strongly connected nodes 
 * 
 * 
 * For Directed -> Kosaraju is used 
 * 
 *   0-->2--->3<---->4
 *   |   |
 *   -<--1
 *   
 *   Print 0 1 2 
 *         3 4 
 *         
 *   It can be of any order , but strongly connected needs to be grouped 
 *   
 *   
 *  To get the ans for strongly connected in a directed graph 
 *  
 *  Find the last vertex 
 *  REtrace from last vertex if start if reachable 
 *  Start to last is strongly connected 
 *  
 *  Steps :
 *  1) Order the vertices in decresing order of finish times in DFS
 *      O V+E time , O V time creating resultant  
 *  
 *  2) Reverse all the edges 
 *       O E 
 *  
 *  3) Do DFS of the reversal graph in the order obtained in step1 
 *       O V+E
 *  
 *  4) For every vertex print all reachable vertices as one strongly 
 *      Connected component 
 *  
 *  
 *  I/P :
 *   0-->1--->3---->4
 *   |   |
 *   -<--2 
 *  
 *  1) Traverse from 1 
 *      1  complete 1 
 *      2  complete 2
 *      0  complete 3 
 *      0-2 back 0-4 
 *      2-1 back 2-5 
 *      3 complete 6
 *      4 complete 7
 *      4-3 4-8 
 *      3-1 3-9 
 *      back to 1 10
 *      
 *      decreasing order
 *       Stack:  1 3 4 2 0
 *  
 *  2) Reverse edges and create Transpose graph 
 *   0-<--1<---3<----4
 *   |    |
 *   -->--2   
 *   
 *   In matrix - simply transpose matrix
 *   In list - Trverse and delete current put value in new list 
 *  
 *  3) Start from 1  in order of 1 3 4 2 0 
 *  
 *     1-->2-->0 strongly connected 
 *     
 *     Start from 3 
 *     1 is already marked 
 *     Print 3
 *     
 *     Start from 4 
 *     3 is already marked 
 *     Print 4 
 *  
 *  Implementation of Kosaraju 
 *  
 *  Step 1:
 *  1) Create an empty stack st 
 *  2) For every vertex u , do the following :
 *       if u is not visited 
 *         DFS of U--> stack U after recursion call  
 *  3) While s.is Empty == false 
 *        Pop an item and add to result 
 *        
 * DFS u and stack 
 *   DFS normal 
 *   stack u 
 *   
 * Why need to reverse a graph ?
 * When reversing a graph a strongly connected graph remains strongly 
 * connected . But others become disconnected 
 * 
 * 
 * Ex)   0--->1-->-2
 *       |    \->--3
 *       |------<--|
 *  
 * Step 1 : 0 1 2 3 
 * Step 2 : without reverse 
 *     start from 3 3-0-1-2 
 *   But 2 is not strongly connected so wrong ans 
 * Step 2; Reverse 
 *      0-<--1-<--2
 *      |    \-<--3
 *      |------>--|
 *  
 *  Start from 3 3-1-0 
 *         Then    2 This is correct
 * @author shree
 *
 */
public class Graph15_Kosaraju_algorithm {

	public static void main(String[] args) {
		
		GraphAdjList adj=new GraphAdjList(10);
		adj.AddEdgeDirected(0, 1);
		adj.AddEdgeDirected(1,2);
		adj.AddEdgeDirected(2, 5);
		adj.AddEdgeDirected(5,0);
		adj.AddEdgeDirected(1,3);
		adj.AddEdgeUnDirected(3,5);
		adj.AddEdgeDirected(4,5);		
		
		adj.AddEdgeDirected(6,7);
		adj.AddEdgeDirected(7,8);
		//adj.AddEdgeDirected(6,5); //NO LOOP 
		adj.AddEdgeUnDirected(8,6);
		adj.PrintTheAdjacencyList();
		
		// Step 1 
		DFSforAll(adj.adj,adj.size);
		
		//step2 
		ArrayList<ArrayList<Integer>> rev=ReverseTheGraph(adj.adj,adj.size);
	   
		// step 3 
		System.out.println(" ANSWER :::::");
		DFSforAll2(rev,adj.size);
	
	}
	
	
	private static ArrayList<ArrayList<Integer>> ReverseTheGraph(ArrayList<ArrayList<Integer>> adj, int size) {
		// reverse all 
		ArrayList<ArrayList<Integer>> rev=new ArrayList<>();
		for(int i=0;i<size;i++) {
			rev.add(new ArrayList<>());
		}
		
		int size2=0;int val=0;
		for(int i=0;i<size;i++) {
			size2=adj.get(i).size();
			for(int j=0;j<size2;j++) {
				val=adj.get(i).get(j);
				rev.get(val).add(i);
			}
		}
		System.out.println(rev.toString());
	    return rev;
	    
	}
	
	private static void DFSforAll2(ArrayList<ArrayList<Integer>> adj, int size) {
		// dfs 
		int revSt[]=new int[size];
		int j=0;
		while(!s.isEmpty()) {
			revSt[j]=s.pop();
			j++;
		}
		System.out.println(" REv "+Arrays.toString(revSt));
		
		visited=new boolean[size];
		for(int i=0;i<size;i++) {
			if(visited[revSt[i]]==false) {
				DFSwithStack2(revSt[i],adj,size);
			}
			System.out.println();
		}
	//	System.out.println(" Stack "+s.toString());
	}
	
private static void DFSwithStack2(int source, ArrayList<ArrayList<Integer>> adj, int size) {
		
		if(visited[source]==false) {
			visited[source]=true;
			int val=0;
			int size2=adj.get(source).size();
			System.out.print(source+" ");
			for(int i=0;i<size2;i++) {
				val=adj.get(source).get(i);
				if(visited[val]==false) {
					DFSwithStack2(val,adj,size);
				}
			}
		//	s.add(source);
			
		}
	}

	private static void DFSforAll(ArrayList<ArrayList<Integer>> adj, int size) {
		// dfs 
		visited=new boolean[size];
		s=new Stack<>();
		for(int i=0;i<size;i++) {
			if(visited[i]==false) {
				DFSwithStack(i,adj,size);
			}
		//	System.out.println();
		}
		System.out.println(" Stack "+s.toString());
	}


	static Stack<Integer> s; static boolean visited[];
	private static void DFSwithStack(int source, ArrayList<ArrayList<Integer>> adj, int size) {
		
		if(visited[source]==false) {
			visited[source]=true;
			int val=0;
			int size2=adj.get(source).size();
		//	System.out.print(source+" ");
			for(int i=0;i<size2;i++) {
				val=adj.get(source).get(i);
				if(visited[val]==false) {
					DFSwithStack(val,adj,size);
				}
			}
			s.add(source);
			
		}
	}
	void DFSUtil(int v,boolean visited[],ArrayList<ArrayList<Integer>> adj) 
	{ 
		 
		visited[v] = true; 
		System.out.print(v + " "); 

		int n; 

		Iterator<Integer> i =adj.get(v).iterator(); 
		while (i.hasNext()) 
		{ 
			n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n,visited,adj); 
		} 
	} 

	ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adj) 
	{ 
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(V); 
		for (int v = 0; v < V; v++) 
		{ 
         g.add(new ArrayList<Integer>());
		}
		
		for (int v = 0; v < V; v++) 
		{ 
        for(int j=0;j<adj.get(v).size();j++) {
        	g.get(adj.get(v).get(j)).add(v);
        }
		} 
		return g; 
	} 

	void fillOrder(int v, boolean visited[], Stack<Integer> stack,ArrayList<ArrayList<Integer>> adj) 
	{  
		visited[v] = true; 

		Iterator<Integer> i = adj.get(v).iterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if(!visited[n]) 
				fillOrder(n, visited, stack,adj); 
		} 

		stack.push(v); 
	} 

	static int V;
	void printSCCs(ArrayList<ArrayList<Integer>> adj) 
	{ 
		Stack<Integer> stack = new Stack<>(); 
       
		boolean visited[] = new boolean[V]; 
		for(int i = 0; i < V; i++) 
			visited[i] = false; 

		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				fillOrder(i, visited, stack,adj); 

		ArrayList<ArrayList<Integer>> adj2 = getTranspose(adj); 

		for (int i = 0; i < V; i++) 
			visited[i] = false; 

		while (stack.empty() == false) 
		{ 
			int v = (int)stack.pop(); 

			if (visited[v] == false) 
			{ 
				DFSUtil(v, visited,adj2); 
				System.out.println(); 
			} 
		} 
	} 


}
