package graph_Algo;

/**
 *
 * Non linear DS :
 *   Tree (heirarchy parent-child relation )
 *   Graph ( friendship relation , cycle of connected nodes)
 *   
 *  Tree -> can not connect with everyone 
 *  Graph -> allow anyone to connect with anyone 
 *  
 *  Graph -> pair of sets 
 *  Graph => (V,E)
 *  Vectors V 
 *  V ={v1,v2,v3}
 *  Edges E 
 *  E={ (v1.v2),(v1.v3),(v2,v3)}
 *                 v1
 *  Gives         /  \
 *               v2--v3
 *               
 * 
 * Types of Graph :
 * 1) UnDirected Graph :
 *    Also alled Complete graph
 *    Edges are undirected .
 *    (v1,v2) also means (v2,v1)
 *     (v1)<------------->(v2)
 *   Example ) Social networks
 *   
 *    Degree of vertex = no of edges going through it 
 *    Ex)Above for v1 :  degree= 2
 *    
 *    Sum of Degrees = s* | no of edges |
 *    Ex)Degrees sum= 6 , no of edge *2 =6 
 *    
 *    Maximum no of edges = |V|* (|V|-1)  / 2 
 *    Ex) V=3 
 *        3*2/2= 6/2 = 3 max edge possible 
 *    
 *    
 * 
 * 2) Directed graph :
 *    Edges directed 
 *    (v1,v2) -> can not go from v2 to v1 
 *    (v1)-------------->(v2)
 *    Example ) pages in website 1->2 page etc 
 *    Used by crawlers to crawl the web 
 *    crawler-> spider bot launched by Search engine 
 *    ex) v1<-----v2----->v3
 *        v1----->v2
 *    
 *    Two type of degree:
 *    1) In degree:
 *       No of edges coming to an vertex
 *       For v2 : 1 
 *    2) Out degree:
 *        No of egdes coming out from an vertex
 *        For v2 :2
 *    
 *    Sum of InDegrees =  | no of edges |
 *    Ex ) 2+1 = 3
 *    Sum of OutDegrees =  | no of edges |
 *    Ex) Out Degrees sum= 3 ,no of edge =3
 *    
 *    Maximum no of edges = |V|* (|V|-1)  
 *    Ex) V=3 
 *        3*2= 6 max edge possible 
 *        v1,v2    v2,v1
 *        v1,v3    v3,v1
 *        v2,v3    v3,v2
 *        
 * Above all not considering self loop :(v1.v1)
 * Complete graph:
 * Directed 
 * Each vertex connected to V-1 vertex 
 * V* V-1
 * 
 * UnDirected 
 * Each vertex connected to V-1 vertex 
 * V* V-1 / 2
 * 
 *  Terms of Graph :
 *  
 *  1) Walk :(Path)
 *     Sequence of vertices by following edges on the graph 
 *     v1,v2,v3,v1 or v1,v2
 *     
 *  2) Path :(Simple Path)
 *     Special walk with no reputation 
 *     There should not be repeated vertices / repeated edges 
 *     Sequence of vertices following edges with no repitation 
 *     
 *  3) Cyclic :
 *      A walk that begins and ends with same vertex 
 *     Cyclic undirected graph:
 *                 v1
 *                /  \
 *               v2--v3
 *     Cyclic Directed graph
 *        v2----> v1 ----->v3
 *        |                |
 *        ----<---v4---<----
 *   
 *   4) Ayclic graph (job scheduling)
 *     A-Cyclic undirected graph:
 *                 v1
 *                /  \
 *               v2   v3
 *     A-Cyclic Directed graph
 *        v2----> v1 <-----v3
 *        |                |
 *        ------->v4---<----  
 *        
 *   5) Weighted graph :
 *      Weights associated with each edge 
 *      It can be directed / undirected 
 *      Ex) Road map with cities as vertex 
 *          road as edge and length of road as weights    
 *      Ex) Routers , routes traffic flow from source to destination
 *
 * @author shree
 *
 */
public class Graph00_Introduction {

	

}

/**
 * Introduction to Graphs

A Graph is a data structure that consists of the following two components:
A finite set of vertices also called nodes.
A finite set of ordered pair of the form (u, v) called as edge. The pair is ordered because (u, v) is not the same as (v, u) in case of a directed graph(digraph). The pair of the form (u, v) indicates that there is an edge from vertex u to vertex v. The edges may contain weight/value/cost.


Graphs are used to represent many real-life applications:
Graphs are used to represent networks. The networks may include paths in a city or telephone network or circuit network. For example Google GPS
Graphs are also used in social networks like linkedIn, Facebook. For example, in Facebook, each person is represented with a vertex(or node). Each node is a structure and contains information like person id, name, gender and locale.


Directed and Undirected Graphs


Directed Graphs: The Directed graphs are such graphs in which edges are directed in a single direction. For Example, the below graph is a directed graph:
Undirected Graphs: Undirected graphs are such graphs in which the edges are directionless or in other words bi-directional. That is, if there is an edge between vertices u and v then it means we can use the edge to go from both u to v and v to u. Following is an example of an undirected graph with 5 vertices:

Representing Graphs


Following two are the most commonly used representations of a graph:
Adjacency Matrix.
Adjacency List.


Let us look at each one of the above two method in details:
Adjacency Matrix: The Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph. Let the 2D array be adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex i to vertex j. Adjacency matrix for undirected graph is always symmetric. Adjacency Matrix is also used to represent weighted graphs. If adj[i][j] = w, then there is an edge from vertex i to vertex j with weight w. The adjacency matrix for the above example undirected graph is:Adjacency Matrix RepresentationPros: Representation is easier to implement and follow. Removing an edge takes O(1) time. Queries like whether there is an edge from vertex 'u' to vertex 'v' are efficient and can be done O(1). Cons: Consumes more space O(V^2). Even if the graph is sparse(contains less number of edges), it consumes the same space. Adding a vertex is O(V^2) time. Please see this for a sample Python implementation of adjacency matrix.
Adjacency List: Graph can also be implemented using an array of lists. That is every index of the array will contain a complete list. Size of the array is equal to the number of vertices and every index i in the array will store the list of vertices connected to the vertex numbered i. Let the array be array[]. An entry array[i] represents the list of vertices adjacent to the ith vertex. This representation can also be used to represent a weighted graph. The weights of edges can be represented as lists of pairs. Following is the adjacency list representation of the above example undirected graph.Adjacency List Representation of GraphBelow is the implementation of the adjacency list representation of Graphs: Note: In below implementation, we use dynamic arrays (vector in C++/ArrayList in Java) to represent adjacency lists instead of a linked list. The vector implementation has advantages of cache friendliness.

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
    static void printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
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
Output:
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

Pros: Saves space O(|V|+|E|). In the worst case, there can be C(V, 2) number of edges in a graph thus consuming O(V^2) space. Adding a vertex is easier. Cons: Queries like whether there is an edge from vertex u to vertex v are not efficient and can be done O(V).
 * 
 * 
 */
