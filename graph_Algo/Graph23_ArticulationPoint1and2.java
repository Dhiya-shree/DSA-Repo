package graph_Algo;

import java.util.ArrayList;

/**
 * 
 * Articulation Point - I
Difficulty: HardAccuracy: 39.26%Submissions: 74K+Points: 8Average Time: 20m
Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components and return it in sorted manner.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

Example 1:

Input:

Output:{1,4}
Explanation: Removing the vertex 1 will
discconect the graph as-

Removing the vertex 4 will disconnect the
graph as-

 

Your Task:
You don't need to read or print anything. Your task is to complete the function articulationPoints() which takes V and adj as input parameters and returns a list containing all the vertices removing which turn the graph into two or more disconnected components in sorted order. If there are no such vertices then returns a list containing -1.
 

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
 * 
 * @author shree
 *
 */
public class Graph23_ArticulationPoint1and2 {

}

class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> ans=new ArrayList<Integer>();
         int dis[]=new int[V];
         int low[]=new int[V];
         boolean visited[]=new boolean[V];
         boolean AP[]=new boolean[V];
       //  ArrayList<Integer> time=new ArrayList<Integer>();
         time=1;
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                DFS(i,low,dis,visited,AP,adj,-1);
            }
        }
        
        for(int i=0;i<V;i++){
            if(AP[i]){
              ans.add(i);
            }
        }
        
        if(ans.isEmpty()){
            ans.add(-1);
        }
         return ans;   
    }
    int time;
    public void DFS(int src,int low[],int dis[],boolean visited[],boolean AP[],
    ArrayList<ArrayList<Integer>> adj,int parent){
        
        
        
        visited[src]=true;
        dis[src]=low[src]=time; time++;
        //For root node
        int children=0;
        int s=adj.get(src).size();
        for(int i=0;i<s;i++){
            int v=adj.get(src).get(i);
            // No visited 
            if(visited[v]==false){
                children++;//For root node
                DFS(v,low,dis,visited,AP,adj,src);
                
                // From subtree 
                low[src]=Math.min(low[src],low[v]);
                
                //Non root node 
                // child low>=parent low
                if(parent!=-1 && low[v]>=dis[src]){
                    AP[src]=true;
                }
                
            }
            //Already visited non parent , update the low
            else if(v!=parent){
                low[src]=Math.min(low[src],dis[v]);
            }
  
        }
    
       if(parent==-1 && children>1){
           AP[src]=true;
       } 
    }
    
}

/*

rticulation Point - II
Difficulty: HardAccuracy: 55.15%Submissions: 26K+Points: 8Average Time: 30m
You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
Your task is to return all the articulation points (or cut vertices) in the graph.
An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.

Examples :

Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]

Output: [1, 4]
Explanation: Removing the vertex 1 or 4 will disconnects the graph as-
   
Input: V = 4, edges[][] = [[0, 1], [0, 2]]
Output: [0]
Explanation: Removing the vertex 0 will increase the number of disconnected components to 3.  
Constraints:
1 ≤ V, E ≤ 104
*/

class Solution2 {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        time=1;
        int low[]=new int[V];
        int dis[]=new int[V];
        boolean visited[]=new boolean[V];
        boolean AP[]=new boolean[V];
        ArrayList<Integer> ans=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        {//Construct ADJ
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<Integer>());
            }
            int e=edges.length;
            for(int i=0;i<e;i++){
                int e1=edges[i][0];
                int e2=edges[i][1];
                adj.get(e1).add(e2);
                adj.get(e2).add(e1);
            }
        }
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                DFS(i,low,dis,visited,AP,-1,adj);
            }
        }
        
        for(int i=0;i<V;i++){
            if(AP[i]){
                ans.add(i);
            }
        }
        
        if(ans.isEmpty()){
            ans.add(-1);
        }
        return ans;
    }
    
    static int time;
    static public void DFS(int src,int low[],int[] dis,boolean[] visited
        ,boolean [] AP ,int parent,ArrayList<ArrayList<Integer>> adj){
            
            
        visited[src]=true;
        dis[src]=low[src]=time;time++;
        
        int s=adj.get(src).size();
        int children=0;// For root node 
        for(int i=0;i<s;i++){
            int v=adj.get(src).get(i);
            
            if(visited[v]==false){
                children++;//for root node 
                
                //DFS for unvisited with current as source 
                DFS(v,low,dis,visited,AP,src,adj);
                
                //  if child connects to some other 
                low[src]=Math.min(low[src],low[v]);
                
                //Non Root node condition 
                if(parent!=-1 && low[v]>=dis[src]){
                    AP[src]=true;
                }
                
            }
            // Back edge case 
            // For child un visited --> consider child low 
            // For already visited some node --> consider the dis 
            else if(v!=parent && visited[v]){
                low[src]=Math.min(low[src],dis[v]);
            }
        }
        
        // root node 
        if(parent==-1 && children>1){
            AP[src]=true;
        }
            
            
            
        }  
    
    
    
}