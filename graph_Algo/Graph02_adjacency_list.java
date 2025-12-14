package graph_Algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Adjacency List 
 * 
 * Array of Array for storing vertex and its edge 
 * 
 * C++:
 * Array of vector / vector of vector 
 * For undirected : push two value v1.add v2 and v2.add v1
 * For directed : push one set v1.add v2 only 
 * 
 * Java :
 * Array of ArrayList / ArrayList of ArrayList 
 * 
 * ArrayList<ArrayList<Integer>> aList=new ArrayList<ArrayList<Integer>>()
 * 
 * AddVertex( int v, int u){
 *   Directed:
 *       aList.get(v).add(u)
 *   Undirected: 
 *       aList.get(v).add(u)
 *       aList.get(u).add(v)
 * }
 * 
 * 
 * 
 * @author shree
 *
 */
class GraphAdjList{
	 ArrayList<ArrayList<Integer>> adj;
	 int size;
	public GraphAdjList(int v) {
		size=v;
		adj=new ArrayList<ArrayList<Integer>>(5);
		 for(int i=0;i<v;i++) {
				adj.add(new ArrayList<>());
			} 
	}
	
	  void PrintTheAdjacencyList() {
		// print 
		int V=adj.size();
		int size=0;
		for(int i=0;i<V;i++) {
			size=adj.get(i).size();
			System.out.print(" For vertex "+i+" :");
			for(int j=0;j<size;j++) {
				System.out.print(adj.get(i).get(j)+" ");		
			}
			System.out.println();
			
		}
		
	}
	  
	  void PrintTheAdjacencyList( ArrayList<ArrayList<Integer>> adj) {
			// print 
			int V=adj.size();
			int size=0;
			for(int i=0;i<V;i++) {
				size=adj.get(i).size();
				System.out.print(" For vertex "+i+" :");
				for(int j=0;j<size;j++) {
					System.out.print(adj.get(i).get(j)+" ");		
				}
				System.out.println();
				
			}
			
		}

	  void AddEdgeDirected(int v, int u) {
		// Directed simply add 
		adj.get(v).add(u);
		
	}
	
	 void AddEdgeUnDirected(int v, int u) {
		// Directed simply add 
		adj.get(v).add(u);
		adj.get(u).add(v);
		
	}
	
}
public class Graph02_adjacency_list {

	public static void main(String[] args) {
		
		int V=5;
		 ArrayList<ArrayList<Integer>> adj=
				 new ArrayList<ArrayList<Integer>>(5);
		 
		 
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		AddEdgeDirected(adj,1,0);
		AddEdgeUnDirected(adj,2,3);
		AddEdgeDirected(adj,1,1);
		AddEdgeDirected(adj,1,3);
		AddEdgeDirected(adj,1,3);
		AddEdgeUnDirected(adj,4,3);
		AddEdgeUnDirected(adj,4,0);
		System.out.println(" Arr "+adj.toString());
		//System.out.println(adj.get(0).get(0));
		
		PrintTheAdjacencyList(adj);
		
	}

	 @SuppressWarnings("unused")
	private List<List<Integer>> printGraphArrayToList(int V, int edges[][]) {
	        
	        //List interface - can not be instantiated 
	        List<List<Integer>> adj=new ArrayList<List<Integer>>(V);
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
	private static void PrintTheAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
		// print 
		int V=adj.size();
		int size=0;
		for(int i=0;i<V;i++) {
			size=adj.get(i).size();
			System.out.print(" For vertex "+i+" :");
			for(int j=0;j<size;j++) {
				System.out.print(adj.get(i).get(j)+" ");		
			}
			System.out.println();
			
		}
		
	}

	private static void AddEdgeDirected(ArrayList<ArrayList<Integer>> adj, int v, int u) {
		// Directed simply add 
		adj.get(v).add(u);
		
	}
	
	private static void AddEdgeUnDirected(ArrayList<ArrayList<Integer>> adj, int v, int u) {
		// Directed simply add 
		adj.get(v).add(u);
		adj.get(u).add(v);
		
	}
}
