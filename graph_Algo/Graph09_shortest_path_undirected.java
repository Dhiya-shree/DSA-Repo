package graph_Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 *  Shortest Path in unweigted graph 
 *  
 *  Given a graph , a sourceand destination 
 *  Find shortest path between source and destination 
 * 
 * 1) Do DFS 
 * Find all occurence and take minimum path 
 * 
 * 2)  Do BFS - BFS always traverse in shortest path first
 * Take the first value of destination found .
 * 
 * Ex ) From 0 as source 
 *      
 *      0----------
 *      |  \       |
 *      |   2------4
 *      |   |      |
 *      1---3------5
 * 
 * 
 * Value of 0 to other vertex :
 * 0 to 0: 0
 * 0 to 1: 1
 * 0 to 2: 1
 * 0 to 3: 2
 * 0 to 4: 1
 * 0 to 5: 2
 * 
 * Ans : 0 1 1 2 1 2
 * 
 * Do BFS from 0 till all are visible 
 * Prepare the result array and add the no of steps at BFS
 * 
 * @author shree
 *
 */
public class Graph09_shortest_path_undirected {

	public static void main(String[] args) {
		// shortest path with BFS 
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
		  
		BFSshortestDistance(source,adj.adj,adj.size);
	}

	private static void BFSshortestDistance(int source,ArrayList<ArrayList<Integer>> adj, int n) {
		// use distance int matrix instead of boolean visited 
		int distance[]=new int[n];
		
		// Start a Queue 
		Queue<Integer> q=new ArrayDeque<>();
		q.add(source);
		int dis=0;// will be increasing for every BFS traversal 
		int curr=0,size=0;int size2=0;int val=0;
		while(!q.isEmpty()) {
			size=q.size();
			for(int k=0;k<size;k++) {
				curr=q.poll();
				if(distance[curr]==0) {
					//for source special 
					System.out.println(" Curr "+curr+" "+dis);
					if(curr==source) { distance[curr]=-1;}// Need to change at ans 
					else { distance[curr]=dis;}//setting the ans 
					
					size2=adj.get(curr).size();
					for(int l=0;l<size2;l++) {
						val=adj.get(curr).get(l);
						if(distance[val]==0) { // adding curr adjacent 
							q.add(val);
						}
					}
				}
			}
			// one step finish , do ++
			dis++;
		}
		
		//setting surce val as 0 
		distance[source]=0;
		
		System.out.println(" Answer shortest distance ");
		System.out.println(Arrays.toString(distance));
	}

}
