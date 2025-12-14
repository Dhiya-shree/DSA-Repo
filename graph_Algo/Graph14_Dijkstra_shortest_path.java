package graph_Algo;

import java.util.Arrays;

/**
 * 
 * Dijkstra's Shortest Path Algorithm 
 * 
 * Given a weighted graph and a source 
 * Find the shortest distance from source to all other 
 * Vertex
 *         B
 *      5/ |\20
 *     /   |  \ 
 *    A   3|   D
 *     \   |  /
 *    10 \ | /2
 *         C 
 *         
 * From source A :
 * Output is :
 * A 0 
 * B 5 
 * C 8 
 * D 10 
 * 
 * 
 * Steps :
 * Have a key array with values infinity 
 * Make source as 0 in key 
 * 
 * Two sets similar to Prim 
 * Set1 -> distance finalized 
 * Set2 -> distance not finalized 
 * 
 * Find min in key array and pick the vertex 
 * Perform RELAX for the picked vertex 
 * Include the vertes in set 1 
 * Continue ....last three steps for all the vertex 
 * 
 * 
 * RELAX operation :
 * u-> finalized vertex 
 * v-> adjacent of u 
 * Relax(u,v){
 * // Check if there is a shorter path through V  
 *    Compare curr distance of U with distance through V
 *    if distance is more ...
 *    
 *    d[v]>d[u]+ W(u,v)
 *    
 *    d[v]=d[u]+W(u,v)
 *  
 *   Update the remaining vertex if we are getting 
 *   shorter distance through vertex V
 *    
 * }
 * 
 * 
 * Example :
 *         B
 *      5/ |\20
 *     /   |  \ 
 *    A   3|   D
 *     \   |  /
 *    10 \ | /2
 *         C 
 * V1:
 * Source = A , key[A]=0 , MST[A]=true 
 * 
 * Adjacent of A => B,C
 * Key[B]=5 , Key[C]=10
 * 
 * 
 * V2:
 * Min in Key= B , key[B]=5 , MST[B]=true 
 * 
 * Adjacent of B => C, D (A already in MST )
 * Relax (Keys,B)
 * For C : Key[C]>Key[B]+B-C
 * 10 > 5 + 3 
 * key[C]=8 
 * 
 * For D :
 *    key[D]>key[B]+B-D 
 *    infinity > 25 
 *    Key[D]=25
 * 
 * V3 :
 * Min in Key = C , key[C]=8 , MST[C]=true 
 * Adjacent of C => D (A,B already in MST )
 * Relax (Keys,C)
 * For D :
 *    key[D]>key[C]+C-D 
 *    20> 8+2  
 *    Key[D]=10 update......
 * 
 * V4:
 * Min in key = D , Key[D]=10 MST[D]=true 
 * Adjacent of D => NULL STOP 
 * 
 * 
 * Facts about Dijistra :
 * 1) It does not work for negatice weight edges 
 *         A----4---B
 *         \        |-10
 *        8 \_______C
 *        A-A-0             C=8
 *        A-B-4  With relax C=-6 (4-10)
 *        But shortest A-B is A---8--C--(-10)--B distance : 2
 * 
 * 2) Does the shortest path changes if some val is added to all edges ?
 *      A--1--B---2---C---3--D
 *       \------------7-----/
 *    Above smallest path A-D through A-B-C-D 
 *    
 *    If added 10 
  *      A--11--B---12---C---13--D
 *       \------------17--------/
 *    Now smallest is A-D 17 
 *    
 * 3) Does the shortest path changes if some val is multiplied to all edges ?
 *      A--1--B---2---C---3--D
 *       \------------7-----/
 *    Above smallest path A-D through A-B-C-D 
 *    
 *    If multiplied * 10 
  *      A--10--B---20---C---30--D
 *       \------------70--------/
 *    Now smallest is A-D through A-B-C-D  No change 
 *    
 * For optimization :
 * Use adjacency list 
 * An use min heap 
 * 
 * 
 * Implementation :
 * 1) Create an empty Priority Queue 
 * 2) Dist[v]= infinte ,inf,inf,inf...
 * 3) Dist[s]=0
 * 4) Insert all distances into Pq min heap array  O V 
 * 5) While pq.isEmpty()
 *          u=pq.extratMin   O Lg V 
 *          Relax all adjacent of u that are not in PQ O LOg V 
 * 
 * 
 * Consider graph in matrix
 * graph={{0,5,10,0},{5,0,3,20},{10,3,0,2},{0,20,2,0}};
 * 
 * 
 * @author shree
 *
 */
class GraphwWeight { 
	
	class Edge { 
		int src, dest, weight; 
		Edge() 
		{ 
			src = dest = weight = 0; 
		} 
	}; 

	int V, E; 
	Edge edge[]; 

	GraphwWeight(int v, int e) 
	{ 
		V = v; 
		E = e; 
		edge = new Edge[e]; 
		for (int i = 0; i < e; ++i) 
			edge[i] = new Edge(); 
	} 
	
}
public class Graph14_Dijkstra_shortest_path {

	public static void main(String[] args) {
		// D ijk stra shortest path 
		int graph[][]={{0,5,10,0},{5,0,3,20},{10,3,0,2},{0,20,2,0}};
		int source=0;
		System.out.println(" From source "+source);
        int dis[]=DijistraPath(graph,source);
        System.out.println(" Distances are "+Arrays.toString(dis));
	
        int ans[]=djikstraGoG(graph,0);
        System.out.println(" GOG "+Arrays.toString(ans));
	}

	//static final int V=4;
	public static int[] djikstraGoG(int graph[][], int src) 
    { 
    
		int V=graph.length;
    	int[] dist=new int[V];int res=0; 
    	Arrays.fill(dist,Integer.MAX_VALUE);dist[src]=0;
    	boolean[] fin=new boolean[V]; 
    
    	for (int count = 0; count < V-1 ; count++) 
    	{ 
    		int u = -1; 
    
    		for(int i=0;i<V;i++)
    		    if(!fin[i]&&(u==-1||dist[i]<dist[u]))
    		        u=i;
    		fin[u] = true; 
    		res=res+dist[u];
    		for (int v = 0; v < V; v++) 
    
    			if (graph[u][v]!=0 && fin[v] == false) 
    				dist[v] = Math.min(dist[v],dist[u]+graph[u][v]); 
    	} 
    	System.out.println(" Res "+res);
        return dist;
    } 
	
	private static int[] DijistraPath(int[][] graph, int source) {
		// D ijk stra 
		int V=graph.length;
		int dis[]=new int[V];
		Arrays.fill(dis,Integer.MAX_VALUE);
		
		// If source not set , all ans will be MAX_VALUE 
		dis[source]=0;
		
		boolean Fin[]=new boolean[V];// similar to MST 
		for(int i=0;i<V;i++) {
			int u=-1;
			
			// use in heap and reduce time to O Log V 
	    // Finding min in dis array 
			for(int j=0;j<V;j++) {
				if(Fin[j]==false && (u==-1||
						dis[j]<dis[u])) {
					u=i;
				}
			}
			
			Fin[u]=true;//Final dis set 
			if(u==-1){
				System.out.println(" End od array ");
				return dis;
			}
			
			
			//Relax function 
			for(int j=0;j<V;j++) {
				//With list , change time to Elog V 
				if(Fin[j]==false && // only for adjacent
						graph[u][j]!=0) {
					
					// Min of Key[J] , Key[
					dis[j]=Math.min(dis[j],dis[u]+graph[u][j]);
				}
			}
		}
		return dis;
	}
	
	//Optimized 
	// Use adjacency list 
	// Use min heap 

}

/**
Dijkstra Algorithm
Difficulty: MediumAccuracy: 50.83%Submissions: 223K+Points: 4Average Time: 25m
Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.

Note: The Graph is connected and doesn't contain any negative weight edge.

Examples:

Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
Output: [4, 3, 0]
Explanation:

Shortest Paths:
For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
For 2 to 1 minimum distance will be 3. By following path 2 -> 1
For 2 to 2 minimum distance will be 0. By following path 2 -> 2
Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
Output: [0, 4, 8, 10, 10]
Explanation: 

Shortest Paths: 
For 0 to 1 minimum distance will be 4. By following path 0 -> 1
For 0 to 2 minimum distance will be 8. By following path 0 -> 2
For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3 
For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
Constraints:
1 ≤ V ≤ 105
1 ≤ E = edges.size() ≤ 105
0 ≤ edges[i][j] ≤ 104
0 ≤ src < V



*/


class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
       // ArrayList<HashMap<Integer,Integer>> adj=new ArrayList
       int cost[]=new int[V];
       ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
       for(int i=0;i<V;i++){
           arr.add(new ArrayList<Integer>());
              cost[i]=Integer.MAX_VALUE;
       }
       for(int i=0;i<edges.length;i++){
           int a=edges[i][0];
           int b=edges[i][1];
           int c=edges[i][2];
           arr.get(a).add(i);
           arr.get(b).add(i);
        
       }
       
       PriorityQueue<N> pq=new PriorityQueue<N>();
       cost[src]=0;
       pq.add(new N(src,0));
       HashSet<Integer> set=new HashSet<Integer>();
       while(!pq.isEmpty() && set.size()<V){
          // System.out.println(pq+" "+Arrays.toString(cost));
           N c=pq.poll();
           {//relaax
               int s=arr.get(c.i).size();
               for(int i=0;i<s;i++){
                   int idx=arr.get(c.i).get(i);
                   int la=c.i;int lb=(c.i==edges[idx][0]?edges[idx][1]:edges[idx][0]);
                   int lv=edges[idx][2];
                   if(cost[lb]>(cost[la]+lv) && !set.contains(lb)){
                       cost[lb]=cost[la]+lv;
                       pq.add(new N(lb,cost[lb]));
                   }
               }
           }//relax ends 
           set.add(c.i);
       }
       return cost;
        
    }
}

class N implements Comparable<N>{
    int i,v;
    N(int a,int b){
        i=a;v=b;
    }
    public int compareTo(N a){
        return this.v-a.v;
    }
    public String toString(){
        return i+":"+v;
    }
}
