package graph_Algo;

import java.util.ArrayList;

/**
 * 
 * Depth First Search :
 * Time complexity : O V+E
 * Undirected : O V+2E
 * 1) DFS with given source in connected graph 
 * 2) DFS for disconnected graph 
 * 3) DFS finding connected components 
 * 
 * 
 * 
 * 
 * 1) DFS with given source in connected graph 
 * Ex) graph 
 *           0
 *          / \
 *         1   4
 *        /   / \ 
 *       2   5---6
 *       |
 *       3
 *  With source : 0      
 *  O/P : 0 1 2 3 4 5 6
 *  
 *  Steps : Recursion   
 *  DFS :
 *  Print element i
 *  While for all array of i :
 *    if value not visited 
 *    DFS recursion
 *    else
 *    Skip.....
 *   
 *  Steps : Iterative 
 *  Level order traversal 
 *  while visited count<V
 *  print i=q.poll
 *  if not visited put in queue 
 *  else skip 
 *  
 *  
 *  2) DFS for disconnected graph 
 *    Create visited 
 *    for every non visted node 
 *      Call DFSwith source as curr val 
 *      
 *  3) DFS finding connected components / No of islands
 *     Connected components is reaching a vertex from other vertex 
 *     0-->1-->2-->3-->5
 *     4<--->6
 *     7
 *     No of connected component = 3
 *     
 *     To find check DFS call count 
 *     
 * 
 * @author shree
 *
 */

/*
 * Application of DFS :
 * 1)Cycle Detection 
 * 2)Topological sorting (depenpency graph - scheduling job 
 *   ex: make file utility class 1 process irst , its object in class 2 used etc )
 * 3)Strongly connected components 
 *    1) Kosaraju Algorithm - 2 DFS traversal 
 *    2) Torjan Algorithm - 1 DFS traversal 
 * 4)Solving maze and similar puzzless as it tries every link , 
 *       DFS>>>BFS for maze
 *       BFS need to solve n-1 level to find maze
 *       DFS traverse heigh of state if not found continue 
 *       Even if ans found half way better than BFS
 * 5)Path solver 
 *       DFS natural in printing the path 
 *       DFS value 1-->2--3--4---5 exact path
 *       BFS ans : 1--9,10,2--4,6---5---2,0
 * 6) Backk tracking 
 * 7) Maze Generation 
 * 
 * Advantage of DFS :
 * 1)Linear stack memory from sorce to some end 
 * 2)Graph depth d and child from source b , time O b*d
 * 3)Before half way found solution -- best 
 * 
 * Disadvantage :
 * 1)Solution might be in last possible place 
 * 2)No guarantee for finding minimal solution 
 * 
 */
public class Graph04_Depth_First_Search {

	public static void main(String[] args) {
		// DFS

		//Graph 
		GraphAdjList adj=new GraphAdjList(12);
		adj.AddEdgeUnDirected(0, 1);
		adj.AddEdgeUnDirected(0, 2);
		adj.AddEdgeUnDirected(0, 5);
		adj.AddEdgeUnDirected(2,4);
		adj.AddEdgeUnDirected(1,3);
		adj.AddEdgeUnDirected(3,5);
		adj.AddEdgeUnDirected(4,5);		
		
		adj.AddEdgeUnDirected(6,7);
		adj.AddEdgeUnDirected(9,7);
		adj.AddEdgeUnDirected(6,8);
		adj.PrintTheAdjacencyList();
		
		
		//DFS recursive in nature 
		//Source -> friend1,friend2,friend3 ...
		//Print friend1 and get its friend
		//After completing one friend , process
		// source -> friend2
		
		//Make static visited array to break cycle
		visited=new boolean[adj.adj.size()];
		int source=0;
		System.out.println(" Recursive DFS with connected graph ");
		DFSwithSourceConnected(adj.adj,source);
		
		System.out.println();
		//DFS + disconnected
		System.out.println(" DFS disconnected graph ");
		visited=new boolean[adj.adj.size()];
		DFSdisConnected(adj.adj);
		
		System.out.println();
		System.out.println(" Connected components ");
		visited=new boolean[adj.adj.size()];
		int ans=ConnectedComponents(adj.adj,adj.size);
		System.out.println(" No of connected component is "+ans);
	}
     private static int ConnectedComponents(ArrayList<ArrayList<Integer>> adj, int size) {
    	// have to count call dfs+source for all unvisted 
    	 int ans=0;
 		for(int i=0;i<size;i++) {
 			if(visited[i]==false) {
 				ans++;
 				DFSwithSourceConnected(adj,i);
 			}
 			else {
 				//continue
 			}
 		}
		return ans;
	}
	private static void DFSdisConnected(ArrayList<ArrayList<Integer>> adj) {
		// have to call dfs+source for all unvisted 
		int size=adj.size();
		for(int i=0;i<size;i++) {
			if(visited[i]==false) {
				DFSwithSourceConnected(adj,i);
			}
			else {
				//continue
			}
		}
    	 
	}
	static boolean visited[];
	private static void DFSwithSourceConnected(ArrayList<ArrayList<Integer>> adj, int source) {
		// DFS
		System.out.print(source+" ");
		visited[source]=true;
		int size=adj.get(source).size();
		int val=0;
		//careful with i and val 
		//i -> count of edge with source 
		//Value -> actual vertex we have to recursive call
		for(int i=0;i<size;i++) {
			val=adj.get(source).get(i);
			if(visited[val]==true) {
				//skip
			}
			else {
				//Recursion call 
				//with curr as source 
				DFSwithSourceConnected(adj,val);
				
			}
		}
		
	}

}
/**

Depth First Traversal of a Graph

The Depth-First Traversal or the DFS traversal of a Graph is used to traverse a graph depth wise. That is, it in this traversal method, we start traversing the graph from a node and keep on going in the same direction as far as possible. When no nodes are left to be traversed along the current path, backtrack to find a new possible path and repeat this process until all of the nodes are visited.

We can implement the DFS traversal algorithm using a recursive approach. While performing the DFS traversal the graph may contain a cycle and the same node can be visited again, so in order to avoid this we can keep track of visited array using an auxiliary array. On each step of the recursion mark, the current vertex visited and call the recursive function again for all the adjacent vertices.

Illustration:


Step 1: Consider the below graph and apply the DFS algorithm recursively for every node using an auxiliary stack for recursive calls and an array to keep track of visited vertices.



Step 2: Process the vertex A, mark it visited and call DFS for its adjacent vertices. Suppose the first adjacent vertex processed is B. The vertex A is put on the auxilary stack for now.

 





Step 3: Process the vertex B, mark it visited and call DFS for its adjacent vertices. Suppose the first adjacent vertex processed is D. The vertex B is put on the auxilary stack for now.



Step 4: Process the vertex D, mark it visited and call DFS for its adjacent vertices. Suppose the first adjacent vertex processed is E. The vertex D is put on the auxilary stack for now.






Step 5: Process the vertex E, mark it visited and call DFS for its adjacent vertices. Suppose the first adjacent vertex processed is F. The vertex E is put on the auxilary stack
for now.



Step 6: Process the vertex F, mark it visited and call DFS for its adjacent vertices. There are no adjacent vertex of the vertex F, so backtrack to find a new path. The vertex F is put on the auxilary stack for now.






Step 7: Since the vertex F has no adjacent vertices left unvisited, backtrack and go to previous call, that is process any other adjacent vertex of node E, that is C.



Step 8: Process the vertex C, mark it visited and call DFS for its adjacent vertices. The vertex C is put on the auxilary stack for now.

 




Step 9: Since there are no adjacent vertex of C, backtrack to find a new path and keep removing nodes from stack until a new path is found. Since all of the nodes are processed so the stack will get empty.



Implementation:

// Java program to print DFS traversal from a given given graph
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph
{
    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");

        g.DFS(2);
    }
}

Output:
Following is Depth First Traversal (starting from vertex 2)
2 0 1 3



*/

/*

Applications, Advantages and Disadvantages of DFS

Depth First Search is a widely used algorithm for traversing a graph. Here we have discussed some applications, advantages, and disadvantages of the algorithm.

Applications of Depth First Search:
1. Detecting cycle in a graph: A graph has a cycle if and only if we see a back edge during DFS. So we can run DFS for the graph and check for back edges.

2. Path Finding: We can specialize the DFS algorithm to find a path between two given vertices u and z. 

Call DFS(G, u) with u as the start vertex. 
Use a stack S to keep track of the path between the start vertex and the current vertex. 
As soon as destination vertex z is encountered, return the path as the contents of the stack
3. Topological Sorting: Topological Sorting is mainly used for scheduling jobs from the given dependencies among jobs. In computer science, applications of this type arise in instruction scheduling, ordering of formula cell evaluation when recomputing formula values in spreadsheets, logic synthesis, determining the order of compilation tasks to perform in makefiles, data serialization, and resolving symbol dependencies in linkers.

4. To test if a graph is bipartite: We can augment either BFS or DFS when we first discover a new vertex, color it opposite its parents, and for each other edge, check it doesn’t link two vertices of the same color. The first vertex in any connected component can be red or black.

5. Finding Strongly Connected Components of a Graph: A directed graph is called strongly connected if there is a path from each vertex in the graph to every other vertex. (See this for DFS-based algo for finding Strongly Connected Components)

6. Solving puzzles with only one solution: such as mazes. (DFS can be adapted to find all solutions to a maze by only including nodes on the current path in the visited set.).

7. Web crawlers: Depth-first search can be used in the implementation of web crawlers to explore the links on a website.

8. Maze generation: Depth-first search can be used to generate random mazes.

9. Model checking: Depth-first search can be used in model checking, which is the process of checking that a model of a system meets a certain set of properties.

10. Backtracking: Depth-first search can be used in backtracking algorithms.

Advantages of Depth First Search:
Memory requirement is only linear with respect to the search graph. This is in contrast with breadth-first search which requires more space. The reason is that the algorithm only needs to store a stack of nodes on the path from the root to the current node.
The time complexity of a depth-first Search to depth d and branching factor b (the number of children at each node, the outdegree) is O(bd) since it generates the same set of nodes as a breadth-first search, but simply in a different order. Thus practically depth-first search is time-limited rather than space-limited.
 If the depth-first search finds a solution without exploring much in a path then the time and space it takes will be very less.
DFS requires less memory since only the nodes on the current path are stored. By chance, DFS may find a solution without examining much of the search space at all.
Disadvantages of Depth First Search:
The disadvantage of Depth-First Search is that there is a possibility that it may down the left-most path forever. Even a finite graph can generate an infinite tre One solution to this problem is to impose a cutoff depth on the search. Although the ideal cutoff is the solution depth d and this value is rarely known in advance of actually solving the problem. If the chosen cutoff depth is less than d, the algorithm will fail to find a solution, whereas if the cutoff depth is greater than d, a large price is paid in execution time, and the first solution found may not be an optimal one.
 Depth-First Search is not guaranteed to find the solution.
 And there is no guarantee to find a minimal solution if more than one solution.


*/