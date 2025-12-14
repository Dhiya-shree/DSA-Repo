package graph_Algo;

import java.util.Arrays;

/**
 * 
 * Bellman ford Algorithm 
 * 
 * To find shortest distance from source to every other node 
 * 
 * Find the shortest distance from source to all other 
 * Vertex
 *         B
 *      1/ |\2
 *     /   |  \ 
 *    A  -3|   D
 *     \   |  /
 *     4 \ | /3
 *         C  
 * 
 * Distance o/p : 0 1 -2 1 
 *               A  B C  D 
 *               
 * Unweighted path 
 * Undirected : BFS DFS 
 * Directed A cyclic - Topological Sort O V+E
 * 
 * Weighted path :
 * Undirected : BFS DFS 
 * Directed : D ijk stra O E Log V ( only positive weight )
 * 
 * Directed for negative weight :
 * We can use Bellman ford 
 * 
 * 
 * D ijk stra -> Greedy Algorithm 
 * Bellman Ford -> Dynamic Algorithm 
 * 
 * Bellman Ford 
 * Uses shortest path of i-1 vertex to find shortest path for i vertex 
 * 
 * Idea :
 *   We first find shortest paths that are of one edge length
 *   Then shortest path that are of two length edge and so on ...
 *   
 *  Relax all edges V-1 times
 *  
 * Implementation : Bell man ford 
 * 
 * Initialize distance of all vertex 
 * dis[v]=inf,inf,inf....
 * dis[source]=0 - initialize source as 0 
 * 
 * Time O V*V
 * Run a loop V-1 time 
 * Loop i=0 to V-2
 * 
 *   For every edge u,v 
 *     Relax all => Min dis[x],dis[v]+V-X
 *  
 * 
 * Example :
 *         B
 *      1/ |\2
 *     /   |  \ 
 *    A  -3|   D
 *     \   |  /
 *     4 \ | /3
 *         C  
 *       
 * V=4
 * Dis[v]= inf,inf,inf,inf 
 * Dis[A]= 0
 * 
 * Iteration 1:
 * For B-C 
 * No updation dis[B]= inf 
 * 
 * For B-D 
 * No updation dis[B]= inf 
 * 
 * For C-D 
 * No updation dis[C]= inf 
 * 
 * For A-B 
 * dis[B]=1
 * For A-C 
 * dis[C]=4
 * 
 * Interation 2:
 * Process edges in same order as above 
 * For B-C 
 * dis[C]=-2
 * 
 * For B-D 
 * dis[D]=2
 * 
 * For C-D 
 * dis[D]=1
 * 
 * For A-B A-C no change 
 * 
 * For iteration 3:
 * No changes -> dont stop 
 * Some cases must have V-1 
 * Ex)
 * v1-->v2-->v3-->.....vn-1-->vn
 * For shrortest for vn 
 * Must to go till Vn-1
 * 
 * 
 * How bellman Ford handle negative cycle ?
 *         B
 *      4/ |\3
 *     /   |  \ 
 *    A  -8|   D
 *     \   |  /
 *     8 \ | /2
 *         C   
 * 
 * For A-B shortest, it will be stuck in the cycle 
 * Minus infinite as shortest distance 
 * 
 * To avoid this ,
 * After completing everything 
 * 
 * Do one more iteration 
 * if we are getting shorter path there is negative weight cycle 
 * 
 * At V-1 we should get shortest , 
 * if we are not getting even at V times
 * we can say -> having negative cycle 
 * 
 * @author shree
 *
 */
public class Graph16_bellman_ford_shortest_path_algo {

			
	public static void main(String[] args) {
		
		int graph[][]={{0,4,8,0},{4,0,-8,3},{8,-8,0,2},{0,3,2
			,0}};
		
		int graph2[][]= {{0,1,4,0},{1,0,-3,2},{4,-3,0,3},{0,2,3
			,0}};
		int source=0;
		System.out.println(" From source "+source);
		
		BellmanFordAlgo(graph,source);
		
        System.out.println(" From source "+source);
		
		BellmanFordAlgo(graph2,source);
		
		BellManFordGoG();
	}
	

	private static void BellManFordGoG() {
		// belman ford 
		int V = 4;
		int E = 5; 

		GraphwWeight graph = new GraphwWeight(V, E); 

		// add edge 0-1 (or A-B) 
    	graph.edge[0].src = 0; 
    	graph.edge[0].dest = 1; 
    	graph.edge[0].weight = 1; 
    
    	// add edge 0-2 (or A-C) 
    	graph.edge[1].src = 0; 
    	graph.edge[1].dest = 2; 
    	graph.edge[1].weight = 4; 
    
    	// add edge 1-2 (or B-C) 
    	graph.edge[2].src = 1; 
    	graph.edge[2].dest = 2; 
    	graph.edge[2].weight = -3; 
    
    	// add edge 1-3 (or B-D) 
    	graph.edge[3].src = 1; 
    	graph.edge[3].dest = 3; 
    	graph.edge[3].weight = 2; 
    
    	// add edge 2-3 (or C-D) 
    	graph.edge[4].src = 2; 
    	graph.edge[4].dest = 3; 
    	graph.edge[4].weight = 3; 

		BellmanFord(graph, 0); 
	}

	static void BellmanFord(GraphwWeight graph, int src) 
	{ 
		int V = graph.V, E = graph.E; 
		int dist[] = new int[V]; 

	
		for (int i = 0; i < V; ++i) 
			dist[i] = Integer.MAX_VALUE; 
		dist[src] = 0; 

		for (int i = 1; i < V; ++i) { 
			for (int j = 0; j < E; ++j) { 
				int u = graph.edge[j].src; 
				int v = graph.edge[j].dest; 
				int weight = graph.edge[j].weight; 
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
					dist[v] = dist[u] + weight; 
			} 
		} 

		for (int j = 0; j < E; ++j) { 
			int u = graph.edge[j].src; 
			int v = graph.edge[j].dest; 
			int weight = graph.edge[j].weight; 
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
				System.out.println("Graph contains negative weight cycle"); 
				return; 
			} 
		} 
		System.out.println("Vertex Distance from Source"); 
		for (int i = 0; i < V; ++i) 
			System.out.println(i + "\t\t" + dist[i]); 
	} 


	private static void BellmanFordAlgo(int[][] graph, int source) {
		//bellman ford 
		int v=graph.length;
		int dis[]=new int[v];
		Arrays.fill(dis,Integer.MAX_VALUE);
		boolean MST[]=new boolean[v];
		
		//make source as 0
		dis[source]=0;
		
		// Loop for V-1 
		for(int i=0;i<v-1;i++) {
			int u=-1;
			
			//find min of dis
			for(int j=0;j<v;j++) {
				if(MST[j]==false && (u==-1|| dis[j]<dis[u])) {
					u=j;
				}
			}
			
			MST[u]=true;//setting as true 
			
			
			//update dis with relax function 
			for(int j=0;j<v;j++) {
				if(MST[j]==true) {
					
					for(int k=0;k<v;k++) {
						
						if(MST[k]==false && j!=k && graph[j][k]!=0 
						&& dis[k]>dis[j]+graph[j][k]) {
							dis[k]=dis[j]+graph[j][k];
						}
					}
				}
			}
					
		}
		
		System.out.println(" Array Distance "+Arrays.toString(dis));
		//int min=Integer.MAX_VALUE;
		// In case of infinite negative loop 
		for(int i=0;i<v-1;i++) {
			int u=-1;
			
			//find min of dis
			for(int j=0;j<v;j++) {
				if(MST[j]==false && (u==-1|| dis[j]<dis[u])) {
					u=j;
				}
			}
			
			if(u==-1) {
				System.out.println(" Ended");
				return;
			}
			MST[u]=true;//setting as true 
			
			
		}
		
		
	}

}
