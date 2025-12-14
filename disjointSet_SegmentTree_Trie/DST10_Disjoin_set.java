
package disjointSet_SegmentTree_Trie;

import java.util.Arrays;

/**
 *  Disjoint Set 
 *  
 *  Union Tree Data Structure 
 *  Used when sets or set of sets involved / social network 
 *  When a whole setis partitioned as multiple disjoint sub sets 
 *  
 *  No two subset can have anything in common 
 *  One elemnt can belong to only 1 set 
 *  If e E S , then e !E S1
 *  
 *  
 *  find x = Retrurn a representative of x's set 
 *  union x,y = Combine sets of x and y 
 *  
 *  Consider group of friends .
 *  If two people of friends of ech other then all ff.
 *  
 *  n=4 1 2 3 4 all alone 
 *  makeFriend 0,1   0-1 
 *  makeFriend 1,3   0-1+1-3 = 0-1-3
 *  areFriend 0,1 Yes
 *  areFriend 0,3 Yes (0-1-3 1 group)
 *  areFriend 0,2 No 
 *  
 *  Best way :
 *  Consider all people in undirected graph 
 *  Consider MakeFriend as Adjacency List or Adjaceny Matrix 
 *  
 *  Using adjaceny List :
 *  MakeFriends - O N  , add a entry in index list  , add same entry in index list's values list .........
 *  AreFriends - O N , check all index
 *  
 *  Using matrix 
 *  MakeFriends - O N , mark matrix x,y as 1 
 *  AreFriends - O 1 , check mat[x][y]
 *  
 * 
 *  Bestest Solution - Disjoint set 
 *  
 *  find x = Return a representative of x's set 
 *  
 *  Set 0-2-4-6 | 3-5 | 1-7
 *  Rep:   1       2     3
 *  
 *  find 2= 1 
 *  find 7= 3 
 *  find 6= 1  same val for every entry of subset 
 *  
 *  union x,y = Combine sets of x and y 
 *  
 *  boolean areFriends(x,y)
 *      return findx==findy 
 *  
 *  makeFriends(x,y
 *      union x,y 
 *     
 * Find and Union - O N 
 * Find and Union by rank  - O Log N 
 * Find and Union by rank + Path compression - O 1 amortizied time      
 * 
 *  
 * Disjoint : O N -- Simple
 * 
 * Construction 
 * 
 * parent array - arr = new int[n]
 *  n=5 
 *  arr= 0 1 2 3 4 
 *  parent= 0 1 2 3 4 -> collection of tree forest 
 *  ////////////////////////////////////////
 *      all self looping tree 
 *  Single node trees = 0 1 2 3 4 
 *  find 0=0 
 *  find 3=3 ...find x=x
 *  
 *  After values added 
 *  Parent array : 0  1  3 
 *                / \
 *               2   4 
 *  find(2)=0 
 *  find 0 =0
 *  find 3= 3
 *  ---------------------------------
 *  
 *  Case1 :
 *  parent = 0 1 2 3 4
 *  Union 0,2 :
 *  Take the second value as child
 *  parent = 0 1 0 3 4
 *  
 *  Union 2,4 :
 *  Take the second value as child 
 *  parent = 0 1 0 3 0 
 *  
 *  Find 2 :
 *  parent[2]=0 
 *  In the 0 rep 
 * 
 *  --------------------------
 *  Case 2 :
 *  parent = 0 1 2 3 4
 *  Union 2,4 :
 *  Take the second value as child
 *  parent = 0 1 2 3 2 
 *  
 *  0 1  2  3
 *        \
 *         4
 *         
 *  Union 0,2 :
 *  Take the second value as child 
 *  parent = 0 1 0 3 2 
 *   0  1  2  3      ===>    0   1   3
 *    \     \                |
 *     2     4               2
 *                           \
 * Find 4 :                   4
 * parent[4]=2
 * Continue further ...XXXX
 * 
 * parent[2]=0 
 * parent[0]=0
 * 
 * Till parent x=x ......STOP 
 * 
 * Disjoint Simple :
 * only for array starting from 0 
 * parent[i]=arr[i]
 * Find :
 * parent[i]==i return i 
 * else find parent[i]
 * Union :
 * xrep=Findx
 * yrep=Findy 
 * if(xrep==yrep) return 
 * else 
 * parent[yrep]=xrep
 * 
 * 
 *  //////////////////////////////////////////////////////////////////////
 *  Disjoint set 
 *  Union by rank 
 *  
 *  Rank is height of tree 
 *  For ebery element they have a parent and a rank 
 *  
 *  During union :                                      r1            r2  rank of r1=3          r1
 *  High rank tree                                     /  \           |   rank of r2=1         / | \
 *           \                                        x    y          x   Make r1 parent      x  y  r1
 *           Low rank tree                                 /\                                /  / \   \ 
 *  Use rank to determine which needs to be the parent    y  y                              x  y   y   x
 *  By above :
 *  Tree Height does not grow 
 *  
 *  Find x:
 *  if parent x==x return x 
 *  else find parent[x]
 *  
 *  Union 
 *  xrep=find x
 *  yrep=find y 
 *  if xrep==yrep return 
 *  xrank=rank xrep
 *  yrank= rank y rep 
 *  
 *  if xrank>=yrank
 *  parent yrep= xrep 
 *  rank xrep=  max of xrep,yrep+1
 *  else 
 *  parent xrep= y rep 
 *  rank xrep=  max of xrep+1,yrep
 *  
 *  // Path Compression 
 *  
 *  Optimzation tech for Find - Path Compression 
 *  
 *  
 *  //Simple find 
 *  if parent x==x return x 
 *  else find parent[x]
 *  
 *  //Path Compression 
 *  Find x :
 *  
 *    if parent[x]==x
 *       return 
 *    
 *    parent[x]=find(parent[x])
 *    return parent[x]
 *  
 *  Path compression changes the tree 
 *  Ex 0 1 2 3 4 5 6 7 
 *  
 *  Tree :    0
 *          /   \
 *         1     2 
 *       /  \     \
 *      3   4      5
 *    /  \
 *   6    7
 *   
 *  Find 6 :
 *  Simple :
 *  Find 6 ---- find 3 ---- find 1  ---- find 0 
 *  return 0 
 *  
 *  Path Compression
 *  
 *  Find 6 ----  parent[6]= find 3      parent[6]=0 return 0 ----> ans=0 
 *  Find 3 ---- parent[3]= find 1       parent[3]=0 return 0
 *  Find 1 ---- parent[1]= find 0       parent[1]=0 return 0
 *  Find 0 --- parent[0]==0 Stop ---------^^^^^^^^
 *  
 *  Find with path compression changes tree as below :
 *              0
 *           / | | \
 *          1  3 6  2
 *         /   |     \    
 *        4    7      5
 *        
 *        
 *  Tree changed to optimize upcoming Find 
 *  
 *  // Time complexity with Union and path compression 
 *  
 *  For M operation on n element 
 *  
 *     O(M aplha(n)) , where alpha(n)<= 4 
 *     alpha(n) - inverse Ackermann Function 
 *       
 *       
 *  Disjoint set - O 1 with Path compression+Rank 
 *  Find ans with union rank , will be based on rank .. might differ 
 *  
 *  
 * @author shree
 *
 */
public class DST10_Disjoin_set {

	public static void main(String[] args) {
		
		int arr[]= {0,1,2,3,4};
		int n=arr.length;
		
		/// SIMPLE 
		parent_s=new int[n];
		//self looping 
		// can only work with array starting from 0 
		// Can NOT work with custom array arr 
		for(int i=0;i<n;i++) {
			parent_s[i]=i;
		}
		System.out.println(" Simple disjoin set ");
		System.out.println(Arrays.toString(parent_s));
		// O 2*N +1= O 1 
		Union_simple(2,4);
		Union_simple(0,2);
		
		// O N 
		int ans=Find_simple(2);
		System.out.println("Find "+ans);
		
		
		/// BY RANK 
		parent_r=new int[n];
		rank=new int[n];
		for(int i=0;i<n;i++) {
			parent_r[i]=i;
			rank[i]=0;// all with rank 0 at start 
		}
		System.out.println(" Union by Rank disjoin set Log N ");
		System.out.println(Arrays.toString(parent_r));
		Union_Rank(2,4);
		Union_Rank(0,2);
		ans=Find_Rank(4);
		System.out.println(" Ans find "+ans);
		
		// Path Compression 
		parent_p=new int[n];
		for(int i=0;i<n;i++) {
			parent_p[i]=i;
		}
		System.out.println(" Path Compression Disjoint set ");
		Union_Path(2,4);
		Union_Path(0,2);
		ans=Find_Path(4);
		System.out.println(" Ans find "+ans);
		
		// Disjoint set : Union by Rank + Find by Path Compression 
		System.out.println(" Path Compression + union rank Disjoint set ");
		parent=new int[n];
		rank=new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=i;
			rank[i]=0;
		}
		System.out.println("Parent "+Arrays.toString(parent));
		System.out.println("Rank "+Arrays.toString(rank));
		Union(2,4);
		Union(0,2);
		ans=Find(4);
		System.out.println(" ans is "+ans);
	}

	static int[] parent;
	private static int Find(int i) {
		// Find by path compression 
		if(parent[i]==i) {
			return i;
		}
		parent[i]=Find(parent[i]);
		return parent[i];
	}

	private static void Union(int i, int j) {
		// Union by rank 
		int xrep=parent[i];
		int yrep=parent[j];
		if(xrep==yrep) {
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
		System.out.println(" Union "+Arrays.toString(parent));
	}

	static int parent_p[];
	private static void Union_Path(int i, int j) {
		// normal union 
		int xrep=parent_p[i];
		int yrep=parent_p[j];
		if(xrep==yrep) {return;}
		parent_p[yrep]=xrep;
		System.out.println(" Union "+Arrays.toString(parent_p));
	}

	private static int Find_Path(int i) {
		// path compression 
		// cahnge tree to optimize find 
		if(parent_p[i]==i) {
			return i;
		}
		parent_p[i]=Find_Path(parent_p[i]);

		System.out.println("Path change "+Arrays.toString(parent_p));
		return parent_p[i];
	}

	static int rank[];static int parent_r[];
	private static int Find_Rank(int i) {
		// find 
		System.out.println("..............."+Arrays.toString(parent_r)+ " i "+i);
		if(parent_r[i]==i) {
			return i;
		}
		
		return Find_Rank(parent_r[i]);
	}

	private static void Union_Rank(int i, int j) {
		// Union by rank 
		// To make sure tree dont grow 
		// Make level at Log N 
		int xrep=Find_Rank(i);
		int yrep=Find_Rank(j);
		if(xrep==yrep) {
			return;
		}
		
		int xrank=rank[xrep];
		int yrank=rank[yrep];
		if(xrank>=yrank) {
			parent_r[yrep]=xrep;
			rank[xrep]=Math.max(xrank, yrank+1);
		}
		else {
			parent_r[xrep]=yrep;
			rank[yrep]=Math.max(xrank+1, yrank);
		}
		System.out.println("Parent" +Arrays.toString(parent_r));
		System.out.println("Rank" +Arrays.toString(rank));
	}

	static int parent_s[];
	private static int Find_simple(int i) {
		// return ans 
		
		if(parent_s[i]==i) {
			return i;
		}
		else {
		return Find_simple(parent_s[i]);
		}
	}

	private static void Union_simple(int i, int j) {
		// if already in a group no changes 
		int a=Find_simple(i);
		int b=Find_simple(j);
		if(a==b) {
			return;
		}
		// make the first tree a parent of second value tree b 
		parent_s[b]=a;
		System.out.println(Arrays.toString(parent_s));
	}
}

/**

Disjoint Set Data Structure | Introduction

A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets.

For Example:

Consider that there are 5 students in a classroom namely, A, B, C, D, and E.

They will be denoted as 5 different subsets: {A}, {B}, {C}, {D}, {E}.


After some point of time, A became friends with B, and C became friend with D. So, A and B will now belong to a same set and C and D will now belong to another same set.

The disjoint data structure will now be: {A, B}, {C, D}, {E}.

If at any point in time, we want to check that if any two students are friends or not, then we can simply check whether they belong to the same set.

As explained above, there are generally two types of operations performed on a Disjoint-Set data structure:
Union(A, B): This operation tells to merge the sets containing elements A and B respectively by performing a Union operation on the sets.
Find(A): This operation tells to find the subset to which the element A belongs.


Implementation: The disjoint set data structure can be implemented using a Parent array representation. If we are dealing with n items, i’th element of the array represents the i’th item. More precisely, the i’th element of the array is the parent of the i’th item.

Implementing Find Operation: It can be implemented by recursively traversing the parent array until we hit a node who is the parent of itself.
// Finds the representative of the set  
// that i is an element of
int find(int i) 
{
    // If i is the parent of itself
    if (parent[i] == i) 
    {
        // Then i is the representative of 
        // this set
        return i;
    }
    else 
    {
        // Else if i is not the parent of 
        // itself, then i is not the 
        // representative of his set. So we 
        // recursively call Find on its parent
        return find(parent[i]);
    }
}


Implementing Union Operation: It takes as input two elements and finds the representatives of their sets using the find operation, and then finally puts either one of the trees (representing the set) under the root node of the other tree, effectively merging the trees and the sets.
// Unites the set that includes i 
// and the set that includes j
void union(int i, int j) 
{
    // Find the representatives
    // (or the root nodes) for the set
    // that includes i
    int irep = find(i),

    // And do the same for the set 
    // that includes j    
    int jrep = find(j);

    // Make the parent of i’s representative
    // be j’s  representative effectively 
    // moving all of i’s set into j’s set)
    Parent[irep] = jrep;
}



Application: There are a lot of applications of Disjoint-Set data structure. Consider the problem of detecting a cycle in a Graph. It can be easily solved using the Disjoint Set and Union-Find algorithm. This method assumes that the graph does not contain any self-loop.

Let us consider the following graph:

For each edge, make subsets using both the vertices of the edge. If both the vertices are in the same subset, a cycle is found.

Initially, all slots of parent array are initialized to -1 (means there is only one item in every subset).
0   1   2
-1 -1  -1 



Now process all edges one by one.
Edge 0-1: Find the subsets to which vertices 0 and 1 belong to. Since they are in different subsets, we take the union of them. For taking the union, either make node 0 as the parent of node 1 or vice-versa.
0   1   2    <----- 1 is made parent of 0 
                    (1 is now representative of subset {0, 1})
1  -1  -1

Edge 1-2: 1 is in subset 1 and 2 is in subset 2. So, take union.
0   1   2    <----- 2 is made parent of 1 
                    (2 is now representative of subset {0, 1, 2})
1   2  -1

Edge 0-2: 0 is in subset 2 and 2 is also in subset 2. Hence, including this edge forms a cycle.


Below is the implementation of the solution to detect cycle using Disjoint-Set:

// Java Program for union-find algorithm to detect cycle in a graph
import java.util.*;
import java.lang.*;
import java.io.*;

class Graph
{
    int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges

    class Edge
    {
        int src, dest;
    };

    // Creates a graph with V vertices and E edges
    Graph(int v,int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }

    // A utility function to find the subset of an element i
    int find(int parent[], int i)
    {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    void Union(int parent[], int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }


    // The main function to check whether a given graph
    // contains cycle or not
    int isCycle( Graph graph)
    {
        // Allocate memory for creating V subsets
        int parent[] = new int[graph.V];

        // Initialize all subsets as single element sets
        for (int i=0; i<graph.V; ++i)
            parent[i]=-1;

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < graph.E; ++i)
        {
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);

            if (x == y)
                return 1;

            graph.Union(parent, x, y);
        }
        return 0;
    }

    // Driver Method
    public static void main (String[] args)
    {
        //* Let us create following graph
      //   0
      //  |  \
      //  |    \
      //  1-----2 *
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}


Output:
graph contains cycle




Note: The implementation of union() and find() is naive and takes O(n) time in worst case. These methods can be improved to O(Logn) using Union by Rank or Height.


*/

/*
Union by Rank and Path Compression

In the previous post, we introduced union find algorithm and used it to detect cycle in a graph. We used the following union() and find() operations for subsets.


// Naive implementation of find
static int find(int parent[], int i)
{
	if (parent[i] == -1)
		return i;
	return find(parent, parent[i]);
}

// Naive implementation of union()
static void Union(int parent[], int x, int y)
{
	int xset = find(parent, x);
	int yset = find(parent, y);
	parent[xset] = yset;
}

// This code is contributed by divyesh072019
 

The above union() and find() are naïve and the worst case time complexity is linear. The trees created to represent subsets can be skewed and can become like a linked list. Following is an example of the worst case scenario.

Let there be 4 elements 0, 1, 2, 3

Initially, all elements are single element subsets.
0 1 2 3 

Do Union(0, 1)
1 2 3 
/
0

Do Union(1, 2)
2 3 
/
1
/
0

Do Union(2, 3)
3 
/
2
/
1
/
0
 

The above operations can be optimized to O(Log n) time complexity in worst case. The idea is to always attach smaller depth tree under the root of the deeper tree. This technique is called union by rank. The term rank is preferred instead of height because if path compression technique (we have discussed it below) is used, then rank is not always equal to height. Also, size (in place of height) of trees can also be used as rank. Using size as rank also yields worst case time complexity as O(Logn).

Let us see the above example with the union by rank
Initially, all elements are single element subsets.
0 1 2 3 

Do Union(0, 1)
1 2 3 
/
0

Do Union(1, 2)
1 3
/ \
0 2

Do Union(2, 3)
   1
/  |  \
0  2   3
 

The second optimization to naive method is Path Compression. The idea is to flatten the tree when find() is called. When find() is called for an element x, root of the tree is returned. The find() operation traverses up from x to find root. The idea of path compression is to make the found root as parent of x so that we don't have to traverse all intermediate nodes again. If x is root of a subtree, then path (to root) from all nodes under x also compresses.

Let the subset {0, 1, .. 9} be represented as below and find() is called
for element 3.

When find() is called for 3, we traverse up and find 9 as representative
of this subset. With path compression, we also make 3 as the child of 9 so 
that when find() is called next time for 1, 2 or 3, the path to root is reduced.

 

The two techniques complement each other. The time complexity of each operation becomes even smaller than O(Logn). In fact, amortized time complexity effectively becomes small constant. 

Following is union by rank and path compression based implementation to find a cycle in a graph:



// A union by rank and path compression
// based program to detect cycle in a graph
class Graph {
    int V, E;
    Edge[] edge;

    Graph(int nV, int nE)
    {
        V = nV;
        E = nE;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    // class to represent edge
    class Edge {
        int src, dest;
    }

    // class to represent Subset
    class subset {
        int parent;
        int rank;
    }

    // A utility function to find
    // set of an element i (uses
    // path compression technique)
    int find(subset[] subsets, int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets,
                                     subsets[i].parent);
        return subsets[i].parent;
    }

    // A function that does union
    // of two sets of x and y
    // (uses union by rank)
    void Union(subset[] subsets,
               int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[yroot].rank < subsets[xroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }

    // The main function to check whether
    // a given graph contains cycle or not
    int isCycle(Graph graph)
    {
        int V = graph.V;
        int E = graph.E;

        subset[] subsets = new subset[V];
        for (int v = 0; v < V; v++) {

            subsets[v] = new subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        for (int e = 0; e < E; e++) {
            int x = find(subsets, graph.edge[e].src);
            int y = find(subsets, graph.edge[e].dest);
            if (x == y)
                return 1;
            Union(subsets, x, y);
        }
        return 0;
    }

    // Driver Code
    public static void main(String[] args)
    {
        /* Let us create the following graph
    0
    | \
    | \
    1-----2 *

        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph) == 1)
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}

// This code is contributed
// by ashwani khemani

Output
Graph contains cycle

*/