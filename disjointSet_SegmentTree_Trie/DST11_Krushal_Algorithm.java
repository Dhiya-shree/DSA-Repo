package disjointSet_SegmentTree_Trie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 
 * Krushal Algorithm 
 * Finding minimum spanning tree 
 * 
 * Spanning tree :
 * A tree where every vertice is connected to every other vertice 
 * Spanning tree with V vertice , will have V-1 egde
 * 
 * For  graph :
 *  A-5-B
 *  | \ |   
 * 4| 9\|2
 *  C---D
 *    3
 * 
 * Spanning tree possibility :
 * 
 *  A   B
 *    \ |   
 *    9\|2  (A)
 *  C---D
 *    3
 *    
 *  A   B
 *  | \ |   (B)
 * 4| 9\|2
 *  C   D
 *   
 *    (C)     (D)    (E)       (F) 
 *  A-5-B   A-5-B   A-5-B    A    B
 *  |      4|   |       |    |    |
 * 4|       |   |2     2|   4|    |2
 *  C---D   C   D   C---D    C----D
 *    3               3         3
 *  A-5-B
 *   \      (G)  
 *   9\ 
 * C---D
 *   3
 *   
 * Minimum weight of above spanning tree= 9  Spanning tree : F 
 * 
 * 
 * Property of spanning tree :
 * Must to connect all vertices 
 * Must not have any cycle 
 * No of edge = V-1
 * 
 * 
 * Krushal's Algorithm - Greedy Algo :
 * 
 * Create a object edge-- nodeA,nodeB,weight  A---5--B == A,B,5
 * 
 * 
 * 1) Order the edges based on increasing order of weight 
 * 2) Create a set MST , mstVal=0
 * 3) Loop for all the edges :
 *         If MST.len== V-1 break 
 *         else :
 *           if CheckIfCycle (currEdge)
 *              Continue , cos current edge makes a cycle .
 *           else 
 *              Add the edge in MST  
 *              mstVal=mstVal+edge.weight
 * 4) Return MSTval
 * 
 * 
 * 
 * 
 * With DISJOINT Set :
 * Krushal also 
 * 
 * Check if adding a edge will cause a cycle in already build mst 
 * If no cycly , add to mst 
 * 
 * Maintain different sets for diff vertex
 * Every vertex is individual set 
 * Add gradually after checking 
 * Disjoint set -> UNION helps in merging vertex 
 * 
 * On connecting two already connected set , we will get cycle 
 * u,v -- already connected 
 * 
 * Adding u,v,x .. will make it a cycle 
 * Find helps to check if u,v alraedy connected 
 * 
 * If no cycle , add u+v using union 
 * 
 * 
 * 1) Sort the array on increasing order O N log N , N==E 
 * 2) Initialize parent and rank , result=0     O V loop for nodes
 * 3) Loop for all edges                      O E , loop for edges 
 *       if size==v-1 return ; // got spanning tree
 *       
 *       int xrep=find edge.node1  // Find alpha V , alpha V= Ackermann constant <4 
 *       int yrep= find edge.node2
 *       
 *       if xrep==yrep 
 *         Cycle , don't mind 
 *       else 
 *         union(xrep,yrep)    
 *         size++
 *         re=res+edge.weight
 *     
 *   return res
 * 
 *   Time = O ElogE + V + E (alpha V)
 *        = O E log E
 *  Space = O V 
 * 
 * @author shree
 *
 */
class Edge implements Comparable<Edge>{
	char node1;
	char node2;
	int weight;
	Edge(){
		node1=0;
		node2=0;
		weight=0;
	}
	public Edge(char string, char string2, int i) {
		node1=string;
		node2=string2;
		weight=i;
	}
	@Override
	public int compareTo(Edge o) {
		// Compare 
		
		return this.weight-o.weight;
	}
}
public class DST11_Krushal_Algorithm {

	public static void main(String[] args) {
		// Krushal Algorithm 

		Edge edges[]= {
				new Edge('A','B',10),
				new Edge('A','C',8),
				new Edge('B','D',3),
				new Edge('C','B',5),
				new Edge('C','D',4),
				new Edge('E','D',15),
				new Edge('C','E',12),
				
		};
		int v=5;
		int ans=KrushalAlgo(edges,v);
		System.out.println(" Minimum spanning tree "+ans);
		
		// DISJOINT SET 
		parent=new int[v];
		rank=new int[v];
		ans=KrushalDisjointSet(edges,v);
		System.out.println(" Minimum spanning tree Disjoint set : "+ans);
	}

	static int parent[];
	static int rank[];
	private static int KrushalDisjointSet(Edge[] edges, int v) {
		//Minimum spanning tree with krushal - Disjoint set 
		Arrays.sort(edges);
		
		//initialize disjoint set 
		for(int i=0;i<v;i++) {
			parent[i]=i;
			rank[i]=0;
		}
		
		
		int res=0;
		int n=edges.length;
		int setLen=0;
		// loop through the edges 
		for(int i=0;i<n ;i++) {
			
			// found spanning tree with all v-1 elements 
			if(setLen==v-1) {
			 break;
			}
			
			Edge curr=edges[i];
			int xrep=findDJS((int)(curr.node1-'A'));
			int yrep=findDJS(curr.node2-'A');
			
			// Both already in same set 
			if(xrep==yrep) {
				System.out.println(" Will make cycle ");
			}
			else {
				res=res+curr.weight;
				setLen++;
				// add curr edge to set 
				unionDJS(xrep,yrep);
			}
		}
		
		return res;
	}

	private static void unionDJS(int i, int j) {
		// merge func  // already found xrep and yrep , use that  
		int xrep=i;//findDJS(i);
		int yrep=j;//findDJS(j);
		if(xrep==yrep) {
			System.out.println(" Already in same group ");
			System.out.println(" No need for add check ... returning here ");
			return;
		}
		
		int xrank=rank[xrep];
		int yrank=rank[yrep];
		if(xrank>=yrank) {
			parent[yrep]=xrep;
			rank[xrep]=Math.max(xrank, yrank+1);
		}
		else {
			parent[xrep]=yrep;
			rank[yrep]=Math.max(xrank+1, yrank);
		}
		
	}

	private static int findDJS(int node) {
		// find method path compression 
		if(parent[node]==node) {
			return node;
		}
		parent[node]=findDJS(parent[node]);
		return parent[node];
	}

	private static int KrushalAlgo(Edge[] edges, int v) {
		// minimum spanning tree 
		int e=v-1;// maximum edge of spanning tree 
		int n=edges.length;
		Arrays.sort(edges);
		
		Edge MST[]=new Edge[v-1];
		int count=0;
		int mstVal=0;
		for(int i=0;i<n;i++) {
			if(count==e) {
				break;
			}
			
			if(checkForCycle(MST,edges[i],count,v)) {
				System.out.println(" Makes a cycle .. not suitable ");
				continue;
			}
			else {
				MST[count]=edges[i];
				count++;
				mstVal=mstVal+edges[i].weight;
			}
			
		}
		return mstVal;
	}

	private static boolean checkForCycle(Edge[] mST, Edge edge,int count,int n) {
		// cycle detection 
		// Use DFS + stack or BFS 
		HashSet<Character> hs=new HashSet<Character>();
		for(int i=0;i<count;i++) {
			hs.add(mST[i].node1);
			hs.add(mST[i].node2);
		}
		
		if(hs.contains(edge.node1) && hs.contains(edge.node2)) {
			return true;
		}
		return false;
	}
	
	static long kruskalDSU(ArrayList<Edge> adj, int n, int m)
    {
        // add your code here
        Collections.sort( adj, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return (o1.weight)-(o2.weight);
            }
        });
		return m;
    }

}

/**

Kruskal’s Minimum Spanning Tree Algorithm

What is Minimum Spanning Tree?


Given a connected and undirected graph, a spanning tree of that graph is a subgraph that is a tree and connects all the vertices together. A single graph can have many different spanning trees. A minimum spanning tree (MST) or minimum weight spanning tree for a weighted, connected, and undirected graph is a spanning tree with a weight less than or equal to the weight of every other spanning tree. The weight of a spanning tree is the sum of weights given to each edge of the spanning tree.

Number of edges in a minimum spanning tree: A minimum spanning tree has (V – 1) edges, where V is the number of vertices in the given graph.

Algorithm: The Kruskal's algorithm for finding MST works on a Greedy method:
Sort all the edges of the given graph in increasing order according to their weight.
Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If cycle is not formed, include this edge, else discard it.
Repeat step 2 until there are (V-1) edges in the spanning tree.


Note: In Step 2 to check whether adding an edge forms a cycle or not efficiently, Union-Find algorithm is used.

Illustration: Consider the below input graph.



The graph contains 9 vertices and 14 edges. So, the minimum spanning tree formed will be having (9 - 1) = 8 edges.

After sorting:
Weight   Src    Dest
1         7      6
2         8      2
2         6      5
4         0      1
4         2      5
6         8      6
7         2      3
7         7      8
8         0      7
8         1      2
9         3      4
10        5      4
11        1      7
14        3      5


Now pick all edges one by one from sorted list of edges:
Pick edge 7-6: No cycle is formed, include it.
Pick edge 8-2: No cycle is formed, include it.
Pick edge 6-5: No cycle is formed, include it.
Pick edge 0-1: No cycle is formed, include it.
Pick edge 2-5: No cycle is formed, include it.
Pick edge 8-6: Since including this edge results in cycle, discard it.
Pick edge 2-3: No cycle is formed, include it.
Pick edge 7-8: Since including this edge results in cycle, discard it.
Pick edge 0-7: No cycle is formed, include it.
Pick edge 1-2: Since including this edge results in cycle, discard it.
Pick edge 3-4: No cycle is formed, include it.
Since the number of edges included equals (V - 1), the algorithm stops here.


Implementation:

import java.util.Arrays;

// Class that represents an edge of the graph
class Edge implements Comparable<Edge>{
    
    // Weight of the edge
    int weight;
    
    // Vertices on both ends of the edge
    int u, v;
    
    Edge(int weight, int u, int v) {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.weight > o.weight)
            return 1;
        return -1;
    }
}

class GFG {
    
    // Function to implement find root method
    // of the union find algorithm
    static int findRoot(int node, int parent[])
    {   
        // Find root of set that contains node, node
        while(parent[node] != node)
        {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }

        return node;
    }

    // Function to perform union of two sets, 
    // node1 and node2 belongs to
    static void unionSets(int node1, int node2, int parent[])
    {
        // Find root of set, node1 belongs to
        int p1 = findRoot(node1, parent);

        // Find root of set, node2 belongs to
        int p2 = findRoot(node2, parent);

        // Make parent of p1 as p2, to join two sets
        parent[p1] = parent[p2];
    }

    // Function to implement the kruskal's MST Algorithm
    static int kruskalMST(Edge edge[], int V, int E)
    {
        // Parent array for union-find Algorithm
        int parent[] = new int[V];

        // Initialize the parent array
        for(int i=0; i<V; i++)
        {
            parent[i] = i;
        }

        int u, v, cost, minCost = 0;

        for(int i = 0; i<E; i++)
        {
            u = edge[i].u;
            v = edge[i].v;
            cost = edge[i].weight;

            // Check if selected edge will form 
            // a cycle or not
            // --> It will form a cycle if they belongs 
            //     to the same set
            if(findRoot(u,parent)!=findRoot(v,parent))
            {
                minCost += cost;
                unionSets(u, v, parent);
            }
        }

        return minCost;
    }
    
    // Driver code
    public static void main(String[] args)
    {
        /* Let us create following weighted graph 
            10 
        0--------1 
        |  \     | 
       6|   5\   |15 
        |       \ | 
        2--------3 
            4     *
        int V = 4; // Number of vertices in graph 
        int E = 5; // Number of edges in graph  
    
        // Declare a list of Pair of Pair 
        // pair<int, pair<int, int> > graph[],
        // such that graph.first is the weight of an edge
        // and, graph.second.first and graph.second.second
        // are the vertices joined to form the edge
        Edge edge[] = new Edge[E];

        // add edge 0-1
        edge[0] = new Edge(10, 0, 1);

        // add edge 0-2
        edge[1] = new Edge(6, 0, 2);

        // add edge 0-3
        edge[2] = new Edge(5, 0, 3);

        // add edge 1-3
        edge[3] = new Edge(15, 1, 3);

        // add edge 2-3
        edge[4] = new Edge(4, 2, 3);
    
        // Sort the graph according to weight of edges
        Arrays.sort(edge);
        
        // Apply Kruskal's Algorithm
        int minCost = kruskalMST(edge, V, E);
    
        System.out.print("The cost of MST is: "+minCost);
    }
}


Output:
The cost of MST is: 19




Time Complexity: O(ElogE) or O(ElogV). Sorting of edges takes O(ELogE) time. After sorting, we iterate through all edges and apply the find-union algorithm. The find and union operations can take at most O(LogV) time. So overall complexity is O(ELogE + ELogV) time. The value of E can be at most O(V2), so O(LogV) is the same as O(LogE). Therefore, the overall time complexity is O(ElogE) or O(ElogV).


*/