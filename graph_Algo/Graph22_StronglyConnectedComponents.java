package graph_Algo;

import java.util.ArrayList;

/**
 * 
 * trongly Connected
Difficulty: MediumAccuracy: 50.61%Submissions: 106K+Points: 4Average Time: 20m
Given an adjacency list, adj of Directed Graph, Find the number of strongly connected components in the graph.
 

Examples :

Input: adj[][] = [[2, 3], [0], [1], [4], []]

Output: 3
Explanation: We can clearly see that there are 3 Strongly Connected Components in the Graph.
 
Input: adj[][] = [[1], [2], [0]]

Output: 1
Explanation: All of the nodes are connected to each other. So, there's only one SCC.
Input: adj[][] = [[1], []]
Output: 2
Constraints:
2<=adj.size()<=106
0<=edges<=adj.size()-1
 * 
 * @author shree
 *
 */
public class Graph22_StronglyConnectedComponents {

}


class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        s=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>>  rev=new ArrayList<ArrayList<Integer>>();

        visited=new boolean[n];
        
        //Topo sort 
        for(int i=0;i<n;i++){
          //  System.out.print(adj.get(i));
            rev.add(new ArrayList<Integer>());
            if(visited[i]==false){
                dfs(i,adj);
            }
        }
        
        //Reverse
        for(int i=0;i<n;i++){
            int si=adj.get(i).size();
            for(int j=0;j<si;j++){
                int a=i;
                int b=adj.get(i).get(j);
                rev.get(b).add(a);
            }
        }
      //    System.out.println(adj);
    //       System.out.println(rev);
             //   System.out.println(s);
        ArrayList<Integer> arr=new ArrayList<Integer>(s);
        //recheck
        visited=new boolean[n];
        s=new ArrayList<Integer>();
        int ans=0;
        for(int i=0;i<n;i++){
           int val=arr.get(n-1-i);
            if(visited[val]==false){
        //        System.out.println("==="+val);
                dfs(val,rev);
                ans=ans+1;
            }
        }
 //       System.out.println(arr);
    //    System.out.println(s);
        return ans;
    }
    ArrayList<Integer> s;boolean visited[];
    public void dfs(int src,ArrayList<ArrayList<Integer>> adj){
        if(!visited[src]){
            visited[src]=true;
      //     System.out.print(src+" ");
            int s1=adj.get(src).size();
            for(int i=0;i<s1;i++){
                int val=adj.get(src).get(i);
                if(visited[val]==false){
                    dfs(val,adj);
                }
            }
            
            s.add(src);
        }
    }
}