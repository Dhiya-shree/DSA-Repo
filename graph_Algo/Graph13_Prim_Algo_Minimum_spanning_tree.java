package graph_Algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Prim spanning tree algo 
 * Greedy algorithm 
 * 
 * Consider you have 4 PC at home in different location 
 * All of them need to be connected with wires
 *       5m
 *  A -------- D
 *  |  \       |  
 *  |   \      |
 *  |    \10m  |
 *  |     \    |7m
 *  |9m    \   |
 *  |       \  |
 *  |        \ |
 *  |         \|
 *  B----------C
 *      8m
 *      
 *      
 *  Minimize the wire length and make sure all the computers are connected
 *  to each other may be through intermediate computer
 *  
 * 
 *    
 *  Manually best way of connection 
 *  A---5m----D---7m---C----8m--B  length : 20 m
 *      
 *  This is minimum spanning tree problem 
 *  
 *  Given a weighted + connected undirected graph
 *  Find the minimum weight spanning tree 
 *  
 *  
 *  Spanning tree :
 *  Tree ,which should not contain any cycles and connecting to all vertices 
 *  There should be no disconnected vertices also no cycle 
 *  For V vertices , there should be strictly V-1 Edges 
 *  Vertices: V 
 *  Edges E : V-1
 *  
 *  
 *  Example 1: GRAPH         SPANNING TREE 
 *            X----X           X---X   V=4 E=3
 *            |    |    ==>    |   |
 *            X----X           X   X(no cycle)
 *            
 *  Example 2: GRAPH         SPANNING TREE
 *            X----X           X---X  V=5 E=4
 *            |    |    ==>    |   |
 *            X----X           X   X(no cycle)
 *             \   |               |
 *              \  |               | 
 *                \|               |
 *                 X               X
 *                 
 * Given a weighted undirected connected graph
 * 1) Find all possible spanning tree 
 *  Example 1: GRAPH           SPANNING TREE D 130
 *            X--c--X            X-c--X   V=4 E=3
 *           a|     |b    ==>   a|    |b
 *            X---d-X            X    X(no cycle)
 *            
 * SPANNING TREE  A  60         Tree C  140
 *            X--c--X           X     X   V=4 E=3
 *                 b|    ==    a|    b|
 *            X--d--X           X--d--X(no cycle)
 *                        
 *  SPANNING TREE B  150
 *            X--c--X          
 *           a|       
 *            X--d--X
 *            
 *  Consider a=100,b=10,c==20,d=30 
 *  Then Spanning tree A is the minimum spanning tree
 *                     
 *                       
 *                  
 *  Prim's spannng tree is a Greedy algorithm .
 *  MST - minimum spanning algorithm 
 *  it maintains two sets .
 *  One set -> set of vertices which already have been included MST 
 *  Second set -> set of vertices not in MST 
 *  
 *       
 *  Everything needs to be connected :
 *  1) Find 1 part of the graph 
 *  Make a cut in graph 
 *  2) Find shortest conection of part1 to part2
 *  Find the minimum weight edge of this cut  
 *  3) Add the vertex in part 1 
 *             5    10
 *  Consider A -- B ---D
 *            \ 10|   /
 *           8 \  |  /10
 *              \ | /
 *                C
 *                     Set1|   Set2
 * 1) Make a cut at A    A |   B,C,D
 * 
 * 2) Find the minimum edge of cut A -> 8C ,5B ans: 5B
 * 3) Consider minimum as part of MST 
 *         A---5---B  | C,D 
 * 4) Consider all egdes connecting two sets 
 *        A-C 8
 *        B-D 15 
 *        B-C 10  minimum A-C 8
 * 5) Find minimum and add corresponding to set 1 
 *      C--8---A----5--B | D
 * 
 * 6) Prepeat sets 4&6 until set2 is empty 
 *    All edges connection set1 , set2
 *    B-D 15 
 *    C-D 20 
 *    Minimum if edge B-D 15
 *    Add D15 in MST 
 * 7) Adding to set 1
 *     C---8---A---5---B--15---D | null = set2 
 * 8) Minumum spanning tree achieved 
 * 
 * 
 * 
 * 
 * Prim spanning tree :
 * C++:
 * Given a matrix 2 D array representing 
 * undirected weighted and connected graph
 * X A  B  C  D
 * A 0  5  8  0
 * B 5  0  10 0
 * C 8  10 0  12  
 * D 0  15 12 0
 * 
 * Find weight of minimum spanig tree 
 * 
 * Use Key array to store all the minimmum weight of 
 * Set 1 connecting to set 2 
 * Key ={ A,B,C,D}
 * 
 * When set 1 has A Key ={0,5,8,xx}
 * 5-> weight of A,B
 * 8-> weight of A,C xx-> no connection infinite 
 * 
 * Add the minimum in MST 
 * Set= A,B , Update the key 
 * Key={0,5,8,15}
 * 5-> B no need to change
 * 8-> Minimum of A-C and B-C 8,10
 * 15-> B to D 
 * 
 * Add the minimum in MST 
 * Set=A,B,C , Update the key 
 * Key={0,5,8,12}
 * 0,5,8->already in MST 
 * 12 -> B-D and C-D minimum 
 * 
 * Add the minimum to MST 
 * Set=A,B,C,D Set==V stop 
 * 
 * Time Complexity : Theta V2 
 * 
 * Instead of finding all the edges and taking minimum 
 * We maintain array updated with minimum edges for all vertex using Key 
 * 
 * Above with array data so Theta V traversal for finding minimum 
 * Can be otimized by using ADJ list and Min heap data structure 
 * Time complexitty can be set to O Vlog V + O v+e Log v
 * V= O E , as E=V-1 to V-1/2
 * Optimized complexity : O E Log V
 * 
 * 
 * Graph + Greedy algorithm 
 * 
 * Find all edges take minimum out of it to create MST 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Graph13_Prim_Algo_Minimum_spanning_tree {

	public static void main(String[] args) {
		// spanning tree 
		
        int graph[][]= {
        		{0,5,8,0},
        		{5,0,10,0},
        		{8,10,0,12},
        		{0,15,12,0}};
        V=graph.length;
        MinimumSpanningTreePrim(graph);
        
        int ans=primMSTGoG(graph);
        System.out.println(" Distance gog "+ans);
	}

	static int V;//vertex number 
	private static void MinimumSpanningTreePrim(int[][] graph) {
		// Spanning tree
		V=graph.length;
		// Important key array to store the minimum edge to MST 
		int key[]=new int[V];
		int res=0;// Actual weight 
		
		// Need to fill all values of key array with Integer.MAX_VAlue
		//As minimum is being searched 
		Arrays.fill(key,Integer.MAX_VALUE);
		
		// Array to mark the members in mst set 
		//To mark diff btw set1 and set2
		boolean MST[]=new boolean[V];
		
		//Set the source 
		// Taking source as 0 .. make the key val as0 
		// Source to source = 0 
		key[0]=0;
		System.out.println(" From source "+0);
	    // For all the vertex 
		int u=0;//starting from first vertex 
		/** O V */
		for(int i=0;i<V;i++) {
			u=-1;//u used to store key index not 
			//value key index -1 not there so initiate u as -1
			
			/** O V */
			// Finding min key value index 
			for(int j=0;j<V;j++) {
				//Only for elements not in MST 
				if(MST[j]==false && (u==-1|| // first time setting u 
						key[j]<key[u]) ){
					// checking if curr key val< already set val u
					// Key[j]<key[u]
				    u=j;
				}
			}
			
			if(u==-1) {
				System.out.println(" All completed , ALL element in MST ");
				return;
			}
			
			// U has minimum key , add u in mST 
			MST[u]=true;
			res=res+key[u];
			System.out.println(" Distance to "+u+"- "+res);
			
			/** O V */
			//Update the key values based on newly added 
			for(int j=0;j<V;j++) {
				// Updating for non MST 
				// graph[u][j]== graph[j][u]
				if(MST[j]==false && graph[u][j]<key[j] && 
				graph[u][j]!=0) { // There may be some internally connected vertex 
					// For them value will be 0 in graph 
					// So mustt to add above condt 
					// Update key value for vertex connected with u 
					key[j]=graph[u][j];
					
				}
			}
		}
		
		
		System.out.println(" Total weight of path "+res);
        System.out.println(" Path data "+Arrays.toString(key));
	}

	// With matrix and array 
	// Time V*V
	
	// Optimization 
	//Use adjacency list to find vertex's edges quickly 
	// Use min heap to store Key array 
	
	// With minimum heap 
	// Decrease key , extract minimum operation i Log V 
	// So time O V+ E log V 
	
	public static int primMSTGoG(int graph[][]) 
    { 
    
    	int[] key=new int[V];int res=0; 
    	Arrays.fill(key,Integer.MAX_VALUE);
    	boolean[] mSet=new boolean[V]; key[0]=0;
    
    	for (int count = 0; count < V ; count++) 
    	{ 
    		int u = -1; 
    
    		for(int i=0;i<V;i++)
    		    if(!mSet[i]&&(u==-1||key[i]<key[u]))
    		        u=i;
    		mSet[u] = true; 
    		res+=key[u];
    
    		
    		for (int v = 0; v < V; v++) 
    
    			if (graph[u][v]!=0 && mSet[v] == false) 
    				key[v] = Math.min(key[v],graph[u][v]); 
    	} 
        return res;
    } 
}

/**
 * 
 * Minimum Spanning Tree
Difficulty: MediumAccuracy: 47.82%Submissions: 160K+Points: 4Average Time: 25m
Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. The graph is represented by an adjacency list, where each element adj[i] is a vector containing vector of integers. Each vector represents an edge, with the first integer denoting the endpoint of the edge and the second integer denoting the weight of the edge.

Input:
3 3
0 1 5
1 2 3
0 2 1
 
Output: 4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Input: 
2 1
0 1 5

 

Output: 5 

Explanation: Only one Spanning Tree is possible which has a weight of 5.
Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges
 * 
 */
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<N> pq=new PriorityQueue<N>();
        int cost[]=new int[V];
        HashSet<Integer> mst=new HashSet<Integer>();
        HashSet<Integer> Nonmst=new HashSet<Integer>();
        for(int i=0;i<adj.size();i++){Nonmst.add(i);
            cost[i]=Integer.MAX_VALUE;}
       /*   for(int j=0;j<adj.get(i).size();j++){
            int l[]=adj.get(i).get(j);
             int a=l[0];int b=l[1];//nt c=0;//l[2];
            if(cost[i][a]!=0 && cost[a][i]!=0){
           
            cost[i][a]=b;cost[a][i]=b;
            }
         }*
         if(i==0){
             pq.add(new N(i,0));
         }
         else{
          pq.add(new N(i,Integer.MAX_VALUE));
         }
        }*/
       // Nonmst.remove(0);
        cost[0]=0;
     //   mst.put(0);
        int ans=0;
        while(mst.size()<V){
            int low=Integer.MAX_VALUE;int la=0;int lb=0;int idx=0;int lv=0;
            for(int n:Nonmst){
                if(cost[n]<low){
                    low=cost[n];la=n;
                }
            }
            
            Nonmst.remove(la);
            mst.add(la); ans=ans+low;
            int s=adj.get(la).size();
            for(int i=0;i<s;i++){
                int l[]=adj.get(la).get(i);
                if(!Nonmst.isEmpty() && Nonmst.contains(l[0])){
                    cost[l[0]]=Math.min(cost[l[0]],l[1]);
                }
            }
            
            
        }
        return ans;
        
    }
}
class N implements Comparable<N>{
    int i,val;
    N(int a,int v){
        i=a;val=v;
    }
    public int compareTo(N a){
        return this.val-a.val;
    }
    public String toString(){
        return i+ " "+val+" ";
    }
}