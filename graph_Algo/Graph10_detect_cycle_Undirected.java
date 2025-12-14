package graph_Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 
 *  Detect cycle in an undirected graph 
 *  1) Return true if cycle is present 
 *  2) else false
 *  
 *  Undirected graph cycle detection simple than directed 
 *  Two issue in detection of cycle :
 *  
 *  One issue : Self loops with parent 
 *  1---2 is considered as cycle in undirected graph 1--2--1---2 and so on 
 *  
 *  So for every call we have to remember prev call 
 *  
 *  1---2---3---1 Loop 
 *  1---2---3---2 No a loop 
 * 
 * Sol:
 * Use Prev for DFS 
 * Use parent array for BFS 
 * 
 * Two issue : X shape Only for directed 
 * Not occur for undirected  
 * Undirected when we reach to 5 
 * We will go till 2 , 3, 4 individually 
 * as 5--> 1,2,3,4
 * 
 * But in directed it might be 
 * 1--->5--->4  Here 5 may have out 5--> 2,4 
 * 3--->5--->2 So when checking for 3 , 5 will be true resulting in loop 
 * Need to start visited for every loop 
 *    1         3
 *     \       /
 *      \    /
 *        5
 *       /  \
 *      /     \
 *     2       4
 *  Above   
 *       
 * 
 * @author shree
 *
 */
public class Graph10_detect_cycle_Undirected {
public static void main(String[] args) {
	//Create graph with adj list 
	GraphAdjList adj=new GraphAdjList(10);
	adj.AddEdgeUnDirected(0, 1);
	adj.AddEdgeUnDirected(0, 2);
	adj.AddEdgeUnDirected(0, 5);
	adj.AddEdgeUnDirected(2,4);
	adj.AddEdgeUnDirected(1,3);
	//adj.AddEdgeUnDirected(3,5);
	//adj.AddEdgeUnDirected(4,5);		
	
	adj.AddEdgeUnDirected(6,7);
	adj.AddEdgeUnDirected(8,7);
	adj.AddEdgeUnDirected(6,5); //NO LOOP 
	//adj.AddEdgeUnDirected(6,8);
	adj.PrintTheAdjacencyList();
	
	
	System.out.println(" Check if loop present in undirected graph ");
	//Lets start from source 0 so prev is -1 
//	int prev=0;
	boolean anb=CheckForLoopBFS(adj.adj,adj.size,0);
	System.out.println(" Ans for loop is "+anb);
	
	
	anb=CheckForLoopDFS(adj.adj,adj.size);
	System.out.println(" Ans for loop is "+anb);
}

private static boolean CheckForLoopDFS(ArrayList<ArrayList<Integer>> adj, int size) {
	// loop for all unvisited 
	System.out.println(" DFS loop detection ");
	//visited1=new boolean[size]; no x shape in undirected 
	prev=0;
	boolean ans=false;
	visited=new boolean[size];
	for(int i=0;i<size;i++) {
      
		if(visited[i]==false && ans==false) {
			System.out.println(" Check..........................."+i);
			//visited=new boolean[size];
		ans=CheckForLoopDFSFromSource(adj,size,i,i);	
		}
	}
	return ans;
}

static boolean [] visited;static int prev;// no x shape in undirected static boolean [] visited1;
private static boolean CheckForLoopDFSFromSource(ArrayList<ArrayList<Integer>> adj, int size, int source, int prev) {
	// DFS loop 
	System.out.println(" Get "+source+"-"+prev);
	if(visited[source]) {
		return true;
	}
	else {
		visited[source]=true;
		/// no x shape in undirected visited1[source]=true;
		int n=adj.get(source).size();int val=0;
		for(int i=0;i<n;i++) {
			val=adj.get(source).get(i);
			if(visited[val] && val!=prev) {
				System.out.println(" Loop at "+source+" & "+val);
				return true;
			}
			else if(visited[val] && val==prev) {
				//just skip 
			}
			else {
				System.out.println(" Set "+source+"-"+prev);
				if(CheckForLoopDFSFromSource(adj,size,val,source)) {
					return true;
				}
			}
		}
	}
	return false;
}

private static boolean CheckForLoopBFS(ArrayList<ArrayList<Integer>> adj, int n, int source) {
	// Check for loop 
    boolean visited[]=new boolean[n];
	//boolean visited2[]=new boolean[n];  no x shape in undirected 
	boolean ans=false;
	for(int i=0;i<n;i++) {
		if(visited[i]==false && ans==false) {
			System.out.println(" Check..........................."+i);
			//visited2=new boolean[n];
			ans=CheckFromSource(adj,n,i,visited);
		}
	}
	System.out.println(" Ans bfs 1"+ans);
	
	visited=new boolean[n];
	//boolean visited2[]=new boolean[n];  no x shape in undirected 
	ans=false;
	for(int i=0;i<n;i++) {
		if(visited[i]==false && ans==false) {
			System.out.println(" Check..........................."+i);
			//visited2=new boolean[n];
			ans=CheckFromSourceTwo(adj,n,i,visited);
		}
	}
	System.out.println(" Ans bfs 2"+ans);
	
	return ans;
}

private static boolean CheckFromSource(ArrayList<ArrayList<Integer>> adj, int n, int source, boolean[] visited) {
	// Loop checking 
	Queue<ArrayList<Integer>> q=new ArrayDeque<>();
	ArrayList<Integer> temp=new ArrayList<>();
	temp.add(source);temp.add(0);
	q.add(temp);
	int curr=0;int size=0,size2=0;int prev=0,val=0;
	while(!q.isEmpty()) {
		
		size=q.size();
		for(int k=0;k<size;k++) {
			temp=new ArrayList<>();
			temp=q.poll();
			curr=temp.get(0);
			prev=temp.get(1);
			System.out.println(" Get "+curr+"-"+prev);
			if(visited[curr]) {
				System.out.println(" Loop at "+curr+" prev-- "+prev);
				return true;
			}
			else {
				// no x shape in undirected  visitedCheck[curr]=true;
				visited[curr]=true;
				size2=adj.get(curr).size();
				for(int l=0;l<size2;l++) {
					val=adj.get(curr).get(l);
					if(visited[val] && val!=prev) {
						System.out.println(" Loop at "+curr+" & "+val);
						return true;
					}
					else if(visited[val] && val==prev) {
						//Visited and simple undirected 
						// simply skip
						System.out.println(" Visited true .....");
					}
					else{
						temp=new ArrayList<>();
						temp.add(val);
						temp.add(curr);
						System.out.println(" Set "+val+"-"+curr);
						q.offer(temp);
					}
				}
			}
			
		}
	}
	
	return false;
}

private static boolean CheckFromSourceTwo(ArrayList<ArrayList<Integer>> adj, int n, int source, boolean[] visited) {
	// Loop checking 
	Queue<Integer> q=new ArrayDeque<>();
	int parent[]=new int[n];//parent to keep track of prev 
	q.add(source);
	parent[source]=0;
	int curr=0;int size=0,size2=0;int prev=0,val=0;
	while(!q.isEmpty()) {
		
		size=q.size();
		for(int k=0;k<size;k++) {
			
			curr=q.poll();
			prev=parent[curr];
			System.out.println(" Get "+curr+"-"+prev);
			if(visited[curr]) {
				System.out.println(" Loop at "+curr+" prev-- "+prev);
				return true;
			}
			else {
				// no x shape in undirected  visitedCheck[curr]=true;
				visited[curr]=true;
				size2=adj.get(curr).size();
				for(int l=0;l<size2;l++) {
					val=adj.get(curr).get(l);
					if(visited[val] && val!=prev) {
						System.out.println(" Loop at "+curr+" & "+val);
						return true;
					}
					else if(visited[val] && val==prev) {
						//Visited and simple undirected 
						// simply skip
						System.out.println(" Visited true .....");
					}
					else{
						q.add(val);
						parent[val]=curr;
						System.out.println(" Set "+val+"-"+curr);
					}
				}
			}
			
		}
	}
	
	return false;
}

}
