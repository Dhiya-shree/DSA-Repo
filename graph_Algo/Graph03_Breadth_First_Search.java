package graph_Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 
 * Breadth First Search :
 * Graph traversal mechanism 
 * Time complexity : O V+E
 * Undirected : O V+2E
 * 
 * 1. Given an undirected graph and a source vertex 's' ,print B.F.S. from given source.
 * 2. B.F.S on disconnected graphs.
 * 3. Print number of islands in a graph (or number of connected components in a graph).
 * 
 * 
 * 1) BFS Source :
 * Given an undirected graph and a source vertex 's' ,print B.F.S. from given source.
 *      0
 *    / | \
 *   1  |  2
 *   |  |  |
 *   3  |  4
 *   \  |  /
 *    \ | /
 *      5
 *  Given s=0;
 *  Print : 0 1 2 5 3 4
 * Traverse 
 * Queue - Level Order Traversal
 * Use stack/queue 
 *  Print source 
 *  Print source  and put friends  in queue 
 *  loop for curr queue size 
 *  print friend and push its friend's
 *  Continue till all complete 
 *  
 *  Problem : There may be cycle 
 *  Each vertex can come again and again ans continue to loop till infinity 		
 *  Sol1: boolean array to check before adding in queue
 *     if boolean false - put in queue
 *     if true -> skip
 *     No need to check for its friend and put in queue .already visited and added its friend		
 * 
 *  Sol2 : Use hashset to store ans 
 *  If val already present in hashset , do not put in queue
 *  
 *  
 *  
 * 2) BFS on unconnected Graph
 * 
 *    Initialize visited boolean array 
 *    for every array :
 *        BFS with source as current 
 *        Level order traversal for unvisited 
 *        
 * 3. Print number of islands in a graph 
 *  (or number of connected components in a graph).
 *  
 *  In BFS on unconnected graph 
 *  Find the no of calls being made 
 *  To find islands in a graph
 *    
 * @author shree
 *
 */
/*
 * BFS applications:
 * 
 * 1) Shortest path in an unweighted graph 
 * 2) Crawler in search engine
 * 3) Peer to Peer network - Bit Torrent 
 * 4) Social networking search 
 * 5) In Garbage collection - delete memory 
 *     location not reachable Cheney algorithm
 *     Better locality of reference 
 * 6) In cycle detection 
 * 7) Ford Fulkerson - Maximum flow algo 
 * 8) Broadcasting 
 * 9) To test if graph is Bipartite 
 */

public class Graph03_Breadth_First_Search {

	public static void main(String[] args) {
		// BFS
		
		//Create graph with adj list 
		GraphAdjList adj=new GraphAdjList(10);
		adj.AddEdgeUnDirected(0, 1);
		adj.AddEdgeUnDirected(0, 2);
		adj.AddEdgeUnDirected(0, 5);
		adj.AddEdgeUnDirected(2,4);
		adj.AddEdgeUnDirected(1,3);
		adj.AddEdgeUnDirected(3,5);
		adj.AddEdgeUnDirected(4,5);		
		
		adj.AddEdgeUnDirected(6,7);
		adj.AddEdgeUnDirected(8,7);
		adj.AddEdgeUnDirected(6,8);
		adj.PrintTheAdjacencyList();

		int source=0;//source vertex
		
		//BFS 
		//Print source-->source friends-->source friend's friends and so on ...
	   	// No order in printing source's friends 
		BFSwithSourceConnected(adj.adj,source);
		
		//Without Source with some unconnected graph 
		BFSdisConnected(adj.adj);
		
		//Islands in a graph 
		//With above code 
		int iland=IslandsInGraph(adj.adj);
		System.out.println(" No of islands "+iland);
	}

	private static int IslandsInGraph(ArrayList<ArrayList<Integer>> adj) {
		// for every unvisted 
		//Find BFS with every unvisited vertex as source 
		//to check for cycle and unconnected 
		int v=adj.size();
		boolean visited[]=new boolean[v];
    	 System.out.println(" No of islands with BFS for all unvisited ");	
        int ans=0;
		for(int i=0;i<v;i++) {
				if(visited[i]==false) {
					ans++;// 1 link in iland found
					BFSwithSourceVisited(adj,visited,i);
				}
				}
		System.out.println();
		return ans;
	}

	private static void BFSdisConnected(ArrayList<ArrayList<Integer>> adj) {
		// for every unvisted 
		//Find BFS with every unvisited vertex as source 
		//to check for cycle and unconnected 
		int v=adj.size();
		boolean visited[]=new boolean[v];
	    System.out.println(" Disconnected graph bfs");	

		for(int i=0;i<v;i++) {
			if(visited[i]==false) {
				BFSwithSourceVisited(adj,visited,i);
			}
		}
	}

	private static void BFSwithSourceVisited(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int source) {
		// passing visited array
      //  int v=adj.size();
		System.out.println();
		System.out.print(" BFS from source "+source+" : ");

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
				if(visited[curr]) {
					//visited true continue 
					continue;
				}
				else {
					System.out.print(curr+" ");
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
		}
		
       
	
	}

	private static void BFSwithSourceConnected(ArrayList<ArrayList<Integer>> adj, int source) {
		// Traverse 
		//Queue - Level Order Traversal 
		//Problem : There may be cycle 
		// Each vertex can come again and again ans continue to loop till infinity 
		
		//Sol1: boolean array to check before adding in queue
		//  if boolean false - put in queue 
		// if true -> skip
		//No need to check for its friend and put in queue .already visited and added its friend
		
		//Sol2 : Use hashset to store ans 
		// If val already present in hashset , do not put in queue
		
		int v=adj.size();
		
		//To check for cycle
		boolean visited[]=new boolean[v];
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
				if(visited[curr]) {
					//visited true continue 
					continue;
				}
				else {
					System.out.print(curr+" ");
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
		}
		
		System.out.println(" BFS from source completed considering No unconnected vertex");
       
	
	}

}

/*
 * Algorithm to check if a graph is Bipartite: 
One approach is to check whether the graph is 2-colorable or not using backtracking algorithm m coloring problem. 
Following is a simple algorithm to find out whether a given graph is Bipartite or not using Breadth First Search (BFS). 
1. Assign RED color to the source vertex (putting into set U). 
2. Color all the neighbors with BLUE color (putting into set V). 
3. Color all neighbor’s neighbor with RED color (putting into set U). 
4. This way, assign color to all vertices such that it satisfies all the constraints of m way coloring problem where m = 2. 
5. While assigning colors, if we find a neighbor which is colored with same color as current vertex, then the graph cannot 
be colored with 2 vertices (or graph is not Bipartit
 * 
 *
 */
/**


Breadth First Traversal of a Graph

The Breadth First Traversal or BFS traversal of a graph is similar to that of the Level Order Traversal of Trees.

The BFS traversal of Graphs also traverses the graph in levels. It starts the traversal with a given vertex, visits all of the vertices adjacent to the initially given vertex and pushes them all to a queue in order of visiting. Then it pops an element from the front of the queue, visits all of its neighbours and pushes the neighbours which are not already visited into the queue and repeats the process until the queue is empty or all of the vertices are visited.

The BFS traversal uses an auxiliary boolean array say visited[] which keeps track of the visited vertices. That is if visited[i] = true then it means that the i-th vertex is already visited.

Complete Algorithm:
Create a boolean array say visited[] of size V+1 where V is the number of vertices in the graph.
Create a Queue, mark the source vertex visited as visited[s] = true and push it into the queue.
Until the Queue is non-empty, repeat the below steps:
Pop an element from the queue and print the popped element.
Traverse all of the vertices adjacent to the vertex poped from the queue.
If any of the adjacent vertex is not already visited, mark it visited and push it to the queue.


Illustration:

Consider the graph shown in the below Image. The vertices marked blue are not-visited vertices and the vertices marked yellow are visited. The vertex numbered 1 is the source vertex, i.e. the BFS traversal will start from the vertex 1.

Following the BFS algorithm:
Mark the vertex 1 visited in the visited[] array and push it to the queue.











Step 3: POP the vertex at the front of queue that is 1, and print it.



Step 4: Check if adjacent vertices of the vertex 1 are not already visited. If not, mark them visited and push them back to the queue.

 
 





Step 5:
POP the vertex at front that is 2 and print it.
Check if the adjacent vertices of 2 are not already visited. If not, mark them visited and push them to queue. So, push 4 and 5.




Step 6:
POP the vertex at front that is 3 and print it.
Check if the adjacent vertices of 3 are not already visited. If not, mark them visited and push them to queue. So, donot push anything.


 





Step 7:
POP the vertex at front that is 4 and print it.




Step 8:
Check if the adjacent vertices of 4 are not already visited. If not, mark them visited and push them to queue. So, push 6 to the queue.







Step 9:
POP the vertex at front, that is 5 and print it.
Since, all of its adjacent vertices are already visited, donot push anything.




Step 10:
POP the vertex at front, that is 6 and print it.
Since, all of its adjacent vertices are already visited, donot push anything.


 
 



Since the Queue is empty now, it means that the complete graph is traversed.



Implementation:

// Java code to illustrate BFS traversal 
// in a Graph

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
    
    // Function to perform BFS traversal of a Graph
    static void BFS(ArrayList<ArrayList<Integer> > adj, int V)
    {
        // Initialize a boolean array
        // to keep track of visited vertices
        boolean visited[] =  new boolean[V+1];
    
        // Mark all vertices not-visited initially
        for (int i = 1; i <= V; i++)
            visited[i] = false;
        
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
    
        // The start vertex or source vertex is 1
        int s = 1;
        
        // Mark the current node as 
        // visited and enqueue it 
        visited[s]=true; 
        queue.add(s);   
        
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Traverse the nodes adjacent to the currently
            // poped element and push those elements to the
            // queue which are not already visited
            for (int i = 0; i < adj.get(s).size(); i++) {
                
                // Fetch adjacent node
                int newNode = adj.get(s).get(i);
                
                // Check if it is not visited
                if(visited[newNode] == false)
                {
                    // Mark it visited
                    visited[newNode] = true;
                    
                    // Add it to queue
                    queue.add(newNode);
                }
            }
        } 
    }
    
    // Driver Code
    public static void main(String[] args)
    {
        // Creating a graph with 6 vertices
        int V = 6;
        ArrayList<ArrayList<Integer> > adj 
                    = new ArrayList<ArrayList<Integer> >(V+1);
        
        for (int i = 0; i < V+1; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 6);
        
        BFS(adj, V);
    }
}


Output:
1 2 3 4 5 6



*/
/*
 * 
 * Applications of BFS

We have earlier discussed Breadth First Traversal Algorithm for Graphs. We have also discussed Applications of Depth First Traversal. In this article, applications of Breadth First Search are discussed. 

Shortest Path and Minimum Spanning Tree for unweighted graph In an unweighted graph, the shortest path is the path with least number of edges. With Breadth First, we always reach a vertex from given source using the minimum number of edges. Also, in case of unweighted graphs, any spanning tree is Minimum Spanning Tree and we can use either Depth or Breadth first traversal for finding a spanning tree. 
Peer to Peer Networks. In Peer to Peer Networks like BitTorrent, Breadth First Search is used to find all neighbor nodes. 
Crawlers in Search Engines: Crawlers build index using Breadth First. The idea is to start from source page and follow all links from source and keep doing same. Depth First Traversal can also be used for crawlers, but the advantage with Breadth First Traversal is, depth or levels of the built tree can be limited. 
Social Networking Websites: In social networks, we can find people within a given distance 'k' from a person using Breadth First Search till 'k' levels. 
GPS Navigation systems: Breadth First Search is used to find all neighboring locations. 
Broadcasting in Network: In networks, a broadcasted packet follows Breadth First Search to reach all nodes. 
In Garbage Collection: Breadth First Search is used in copying garbage collection using Cheney's algorithm. Refer this and for details. Breadth First Search is preferred over Depth First Search because of better locality of reference: 
Cycle detection in undirected graph: In undirected graphs, either Breadth First Search or Depth First Search can be used to detect cycle. We can use BFS to detect cycle in a directed graph also,
 Ford–Fulkerson algorithm In Ford-Fulkerson algorithm, we can either use Breadth First or Depth First Traversal to find the maximum flow. Breadth First Traversal is preferred as it reduces worst case time complexity to O(VE2). 
To test if a graph is Bipartite We can either use Breadth First or Depth First Traversal. 
Path Finding We can either use Breadth First or Depth First Traversal to find if there is a path between two vertices. 
Finding all nodes within one connected component: We can either use Breadth First or Depth First Traversal to find all nodes reachable from a given node. 
Many algorithms like Prim's Minimum Spanning Tree and Dijkstra's Single Source Shortest Path use structure similar to Breadth First Search. 
There can be many more applications as Breadth First Search is one of the core algorithms for Graphs.
 * 
 * 
 */

