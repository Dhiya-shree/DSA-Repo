package graph_Algo;

/**
 * 
 * Graph representation :
 *  Many type of representation 
 *  Common :
 *  1) Adjacency Matrix 
 *  2) Adjacency List 
 * 
 * 
 * Adjacency Matrix:
 * Create a matrix
 * Size of matrix : V x V
 * V => no of vertices 
 * matrix[i][j] value 1/0 
 * Value == 1
 * There is an edge from vertex i to vertex j
 * Value == 0 
 * There is no edge from i to j 
 * 
 * For directed graph , v1--->v2--->v3
 *   1  2  3
 * 1    x 
 * 2       x
 * 3
 * For undirected graph :
 *  Symmetrix matrix will be used  
 *  matrix[i][j] value will be equal to matrix[j][i]
 *  For v1---v2---v3
 *   1  2  3
 * 1    x 
 * 2  x    x
 * 3    x
 * 
 * 
 * 	Adjacency matrix needs additional data structures 
 *  
 *  Vertex can be -> String (city name) , pin code ( big decimal ) ans so on 
 *  In such cases the Object/String  needs to be mapped with number 0 to N-1 
 *  
 *  For graph:
 *  Chennai ----> Mumbai----> Delhi ---> Bangalore 
 *  
 *  Array data structure can be to be used 
 *  Array :
 *  1=> Bangalore
 *  2=> Chennai 
 *  3=> Delhi 
 *  4=> Mumbai 
 *   1  2  3  4
 * 1  
 * 2          x
 * 3 x
 * 4        x
 * 
 *  But reverse mapping is also needed , with array it will be linear search
 *  so use HashMap 
 *  Chennai -1
 *  Mumbai -2
 *  Delhi -3
 *  Bangalore - 4 
 *  
 *   1  2  3  4
 * 1    x
 * 2       x   
 * 3          x
 * 4 
 *
 * 
 * Properties :
 * 
 * Space Required Theta VxV
 * 
 * Operations :
 * 1) Check if i and j are adhjacent - O 1
 *      matrix[i][j]==1 yes else no 
 *      
 * 2) Find all vertices adjacent to u - O V 
 *      Traverse matrix[][u] , if val==1 add
 *      
 * 3) Find degree of u : O v
 *      Traverse matrix[][u] and count 1 
 *      
 * 4) Add/Remove an edge : O 1 
 *       matrix[i][j]=0
 *       
 * 5) Add/Remove a vector : O v^2
 *     Add: Create a bigger matrix and copy old 
 *     Remove: Create smaller matrix and copy  
 *        
 */
/* Disadvantage of adjacency matrix :
 *   1) It stores redundant information 
 *   2) Non connected vertex also present 
 *   
 *  Above overcomed by adjacency list 
 *   
 *  0---1---2---3
 *  |-------|
 *  
 *  Adjacency matrix :
 *    0 1 2 3
 *  0   x 
 *  1     x    
 *  2 x     x
 *  3  
 *  
 *  Adjacency list :
 *  
 *  Vertex Value_S
 *  0 -->1-->2
 *  1--->0-->2
 *  2--->0--->1--->3
 *  3--->2
 *  
 *  
 */
 /**
 *
 *  Adjacency List
 *  Array of List :
 *  1) Array of Dynamic sized array 
 *     Adv:
 *     Cache friendly 
 *     Easy implementation 
 *     Disadv:
 *      waste of space / amortizied time
 *  2) Array of Linked list 
 *  
  *  Adjacency list :
 *  
 *  Vertex Value_S
 *  vertex-> array of outgoing edge 
 *  0 -->1-->2
 *  1--->0-->2
 *  2--->0--->1--->3
 *  3--->2
 *
 * Directed Graph
 * Space = O V+E 
 * V - vertex , E - edges
 * ex) 1--->2    
 * 
 * Undirected graph :
 * Space = O V+ 2*E
 * ex) 1--->2 also need to add 2--->1
 * Every edge contributes to two cell 
 * 
 * 
 * Operations :
 * 1) Check if there is edge from u to v - O V
 *      traverse arr[u][] , check if v present  
 *      
 * 2) Find all vertices adjacent to u - O degree(u)
 *      Traverse array of u 
 *      
 * 3) Find degree of u : O 1
 *      Sizeof arr u 
 *      
 * 4) Add/Remove an edge : O 1 and O V
 *      O 1 -Arr u .add( new edge )
 *      O V -Arr u traverse and remove 
 *       
 * 5) Add/Remove a vector : O 1 and O V 
 *     Add: add in array list  
 *     Remove: traverse and remove    
 *
 * @author shree
 *
 */
public class Graph01_representation {

	public static void main(String[] args) {
		
		
		/**
		 * 
		 * Connectivity E type of graph:
		 * Sparse Graph -> graph where connectiviy is low 
		 *    No of edges very low 
		 *    Most of rea world example are sparse
		 *    Best with Adjacency List 
		 *    
		 * Dense Graph -> graph where connectiviy is high 
		 *    No of edges very high  
		 *    Best with Adjacency Matrix 
		 * 
		 * Limit of E :
		 * Undirected :
		 *   0<= E <= V*(V-1)/2
		 *   
		 * Directed :
		 *   0<= E <= V*(V-1)
		 *  
		 *   
		 * Degree of vertex u :
		 * 
		 * In undirected graph :
		 * Degree of u = No in/out , only adjacent count=degree
		 * 
		 * In directed graph :
		 * Degree of u = Out degree of u
		 *  
		 * 
		 */
		/*
		 * Comparison :
		 *                    Adjacency List  VS  Adjacency Matrix
		 * 1) Memory                Theta V+E     Theta VxV
		 * 
		 * 2)Check if there is           O V       Theta V
		 *   edge from u to v 
		 * 3) Find all         Theta(degree(u))    Theta V 
		 *    adjacent of u 
		 * 4) Add an Edge                O 1       O V 
		 * 
		 * 5) Remove an edge             O V       O V 
		 * 
		 * Undirected :
		 *   0<= E <= V*(V-1)/2
		 *   
		 * Directed :
		 *   0<= E <= V*(V-1)
		 * 
		 * 
		 * BFS / DFS / Djistra / Prim :
		 * 
		 * Adjacency List : Time O V+E
		 * Adjacency Matric : Time O VxV
		 * 
		 * 
		 */

	}

}

/**
 * 
 * Graph Representation

A graph is a data structure that consists of the following two components: 


1. A finite set of vertices also called as nodes. 
2. A finite set of ordered pair of the form (u, v) called as edge. The pair is ordered because (u, v) is not the same as (v, u) in case of a directed graph(di-graph). The pair of the form (u, v) indicates that there is an edge from vertex u to vertex v. The edges may contain weight/value/cost.


Graphs are used to represent many real-life applications: Graphs are used to represent networks. The networks may include paths in a city or telephone network or circuit network. Graphs are also used in social networks like linkedIn, Facebook. For example, in Facebook, each person is represented with a vertex(or node). Each node is a structure and contains information like person id, name, gender, and locale. See this for more applications of graph. 
Following is an example of an undirected graph with 5 vertices. 
 



The following two are the most commonly used representations of a graph. 
1. Adjacency Matrix 
2. Adjacency List 
There are other representations also like, Incidence Matrix and Incidence List. The choice of graph representation is situation-specific. It totally depends on the type of operations to be performed and ease of use. 


Adjacency Matrix: 
Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph. Let the 2D array be adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex i to vertex j. Adjacency matrix for undirected graph is always symmetric. Adjacency Matrix is also used to represent weighted graphs. If adj[i][j] = w, then there is an edge from vertex i to vertex j with weight w. 

The adjacency matrix for the above example graph is: 

Adjacency Matrix Representation
Pros: Representation is easier to implement and follow. Removing an edge takes O(1) time. Queries like whether there is an edge from vertex ‘u’ to vertex ‘v’ are efficient and can be done O(1).
Cons: Consumes more space O(V^2). Even if the graph is sparse(contains less number of edges), it consumes the same space. Adding a vertex is O(V^2) time.  Computing all neighbors of a vertex takes O(V) time (Not efficient).
 

Implementation of taking input for adjacency matrix

import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		// n is the number of vertices
		// m is the number of edges
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] adjMat = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjMat[u][v] = 1;
			adjMat[v][u] = 1;
		}
	}
}
 

Adjacency List: 
An array of lists is used. The size of the array is equal to the number of vertices. Let the array be an array[]. An entry array[i] represents the list of vertices adjacent to the ith vertex. This representation can also be used to represent a weighted graph. The weights of edges can be represented as lists of pairs. Following is the adjacency list representation of the above graph. 
 

Adjacency List Representation of Graph

Note that in the below implementation, we use dynamic arrays (vector in C++/ArrayList in Java) to represent adjacency lists instead of the linked list. The vector implementation has advantages of cache friendliness. 

// Java code to demonstrate Graph representation
// using ArrayList in Java

import java.util.*;

class Graph {

	// A utility function to add an edge in an
	// undirected graph
	static void addEdge(ArrayList<ArrayList<Integer> > adj,
						int u, int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	// A utility function to print the adjacency list
	// representation of graph
	static void
	printGraph(ArrayList<ArrayList<Integer> > adj)
	{
		for (int i = 0; i < adj.size(); i++) {
			System.out.println("\nAdjacency list of vertex"
							+ i);
			System.out.print("head");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> "
								+ adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		// Creating a graph with 5 vertices
		int V = 5;
		ArrayList<ArrayList<Integer> > adj
			= new ArrayList<ArrayList<Integer> >(V);

		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		// Adding edges one by one
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);

		printGraph(adj);
	}
}

Output
 Adjacency list of vertex 0
 head -> 1-> 4

 Adjacency list of vertex 1
 head -> 0-> 2-> 3-> 4

 Adjacency list of vertex 2
 head -> 1-> 3

 Adjacency list of vertex 3
 head -> 1-> 2-> 4

 Adjacency list of vertex 4
 head -> 0-> 1-> 3
 

Pros: Saves space O(|V|+|E|). In the worst case, there can be C(V, 2) number of edges in a graph thus consuming O(V^2) space. Adding a vertex is easier. Computing all neighbors of a vertex takes optimal time.


Cons: Queries like whether there is an edge from vertex u to vertex v are not efficient and can be done O(V).
 In Real-life problems,  graphs are sparse(|E| <<|V|2). That’s why adjacency lists Data structure is commonly used for storing graphs. Adjacency matrix will enforce (|V|2) bound on time complexity for such algorithms. 


 * 
 * 
 */
