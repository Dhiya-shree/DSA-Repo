package graph_Algo;

import java.util.ArrayList;

/**
 * 
 * Mother Vertex
Difficulty: MediumAccuracy: 47.64%Submissions: 83K+Points: 4Average Time: 15m
Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.

Examples:

Input:

Output: 0
Explanation: According to the given edges, all 
nodes can be reached from nodes from 0, 1 and 2. 
But, since 0 is minimum among 0,1 and 2, so 0 
is the output.
Input:

Output: -1
Explanation: According to the given edges, 
no vertices are there from where we can 
reach all vertices. So, output is -1.
Your Task:
You don't need to read or print anything. Your task is to complete the function findMotherVertex() which takes V denoting the number of vertices and adjacency list as input parameter and returns the vertices from through which we can traverse all other vertices of the graph. If there is more than one possible nodes then return the node with minimum value. If not possible returns -1.

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
 * 
 * 
 * @author shree
 *
 */
public class Graph19_Mother_Vertex {

}

class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int all=0;
        for(int i=0;i<V;i++){
            all=all+adj.get(i).size();
        }
        
        if(all<V-1){
            return -1;
        }
        
        
        for(int i=0;i<V;i++){
            visited=new boolean[V];
          //  if(visited[i]==false){
                int s=dfs(i,adj);
       //         System.out.println(i+"-->"+s);
                if(s>=V){
                    return i;
                }
        //    }
        }
        return -1;
    }
    boolean visited[];
    public int dfs(int src,ArrayList<ArrayList<Integer>> adj){
        int s=0;
        if(!visited[src]){
            visited[src]=true;
            s=1;
     //        System.out.println(src+" ");
            int n=adj.get(src).size();
            for(int i=0;i<n;i++){
                int v=adj.get(src).get(i);
                if(!visited[v]){
                    s=s+dfs(v,adj);
                }
            }
        }
        return s;
    }
}
