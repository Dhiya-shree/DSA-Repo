package graph_Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/*
 * trongly connected component (Tarjans's Algo)
Difficulty: HardAccuracy: 36.78%Submissions: 29K+Points: 8Average Time: 30m
Given a Directed Graph with V vertices and E edges, Find the members of strongly connected components in the graph.

Note - Sort both the individual components and array of the components.

Example 1:

Input:

Output: 0 1 2 3 4
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph as mentioned
in the Output.
Input:

Output: 0 1 2
Explanation:
All of the nodes are connected to each other.
So, there's only one SCC as shown.

Your Task:
You don't need to read input or print anything. Your task is to complete the function tarjans() which takes the number of vertices V and adjacency list of the graph as input parameters and returns a list of list of integers denoting the members of strongly connected components in the given graph.
Note: A single strongly connected component must be represented in the form of a list if integers sorted in the ascending order. The resulting list should consist of a list of all SCCs which must be sorted in a way such that a lexicographically smaller list of integers appears first.


Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).


Constraints:
1 ≤ V  ≤ 105
1 ≤ E  ≤ 105
0 ≤ u, v ≤ N-1
 * 
 * 
 */
public class Graph25_Trojan_SCC {

}
class Solution
{
    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph.  
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       ans=new ArrayList<ArrayList<Integer>>();
       int low[]=new int[V];
       int dis[]=new int[V];
       boolean visited[]=new boolean[V];
       boolean stkMem[]=new boolean[V];
       time=1;
       Stack<Integer> s=new Stack<Integer>();
       
       for(int i=0;i<V;i++){
           if(visited[i]==false){
               DFS(i,low,dis,visited,stkMem,adj,s);
           }
       }
       
   //    System.out.println(Arrays.toString(dis));
     //         System.out.println(Arrays.toString(low));
      Collections.sort(ans,
      new Comparator<ArrayList<Integer>>(){
         public int compare(ArrayList<Integer> b,ArrayList<Integer> a){
             return b.get(0)-a.get(0);
         } 
      });
       return ans;
    }
    
    ArrayList<ArrayList<Integer>> ans;int time;
    public void DFS(int src,int low[],int dis[],boolean[] visited,
    boolean [] stkMem,
    ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        
        visited[src]=true;
        low[src]=dis[src]=time; time++;
        st.push(src);
        int min=low[src];
        stkMem[src]=true;
        int s=adj.get(src).size();
        
        for(int i=0;i<s;i++){
            int v=adj.get(src).get(i);
             if(visited[v]==false){
                DFS(v,low,dis,visited,stkMem,adj,st);
                low[src]=Math.min(low[src],low[v]);
            }
            else if(stkMem[v]){
                // already visited ?
                // Back edge it is
                low[src]=Math.min(low[src],dis[v]);
            }
            
        }
      //  processed[src]=true;
        int popped=-1;
        if(dis[src]==low[src]){
            ArrayList<Integer> ans1=new  ArrayList<Integer>();
       //     System.out.println(st);
            while(popped!=src){
                popped=st.pop();
                stkMem[popped]=false;
                ans1.add(popped);
            }
            Collections.sort(ans1);
            ans.add(ans1);
        }
        
    }
        
    }
    
