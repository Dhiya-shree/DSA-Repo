package disjointSet_SegmentTree_Trie;
/**
 * 
 * Detect Cycle using DSU
Difficulty: MediumAccuracy: 48.37%Submissions: 63K+Points: 4Average Time: 15m
Given an undirected graph with no self loops with V (from 0 to V-1) nodes and E edges, the task is to check if there is any cycle in the undirected graph.

Note: Solve the problem using disjoint set union (DSU).

Examples

Input: 

Output: 1
Explanation: There is a cycle between 0->2->4->0
Input: 

Output: 0
Explanation: The graph doesn't contain any cycle
Your Task:
You don't need to read or print anyhting. Your task is to complete the function detectCycle() which takes number of vertices in the graph denoting as V and adjacency list adj and returns 1 if graph contains any cycle otherwise returns 0.

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ 104
 * 
 * 
 * @author shree
 *
 */
public class DST18_Detect_Cycle {

}



class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int parent[]=new int[V];
        int rank[]=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
            rank[i]=0;
        }
       
      //  System.out.println(adj.toString());
         int n=adj.size();
        for(int i=0;i<n;i++){
            int n1=adj.get(i).size();
            if(n1==1){
                continue;
            }
           // int a=adj.get(i).get(0);
            for(int j=1;j<n1;j++){
            if(isConnected(adj.get(i).get(0),adj.get(i).get(j),parent,rank)){
                return 1;
            }
            else{
                union_(adj.get(i).get(0),adj.get(i).get(j),parent,rank);
            }
            }
        }
        return 0;
       
    }
     public void union_(int a, int b, int par[], int rank[])
    {
        // add your code here
        int xrep=Find(a,par);
        int yrep=Find(b,par);
        if(xrep==yrep){
            return;
        }
        
        int xrank=rank[xrep];
        int yrank=rank[yrep];
        
        if(xrank>=yrank){
            par[yrep]=xrep;
            rank[xrep]=Math.max(xrank,yrank+1);
        }
        else{
             par[xrep]=yrep;
            rank[yrep]=Math.max(xrank+1,yrank);
        }
        
    }

    //Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
       int xrep=Find(a,par);
        int yrep=Find(b,par);
        if(xrep==yrep){
            return true;
        }
        return false;
    }
    
    public int Find(int x,int par[]){
        
        if(par[x]==x){
            return x;
        }
        
        par[x]=Find(par[x],par);
        return par[x];
    }

}

/*
 * Given an undirected graph with V nodes and E edges . The task is to check if there is any cycle in undirected graph.

Example :
Input :

 
Output : 1
Explanation : there is  a cycle between 0 -> 1 -> 2 -> 0.
Expected Approach
Intuition
The idea is that we will create sets containing only one node which are parent of itself . Now while traversing through the edges , If two edge belongs to the same set then they form a cycle . Otherwise , we will perform union to merge the sets together .
To find which set a node belongs to and to do union operation we use DSU . 

Example Walkthrough

 
Use an array to keep track of the subsets and which nodes belong to that subset. Let the array be parent[].

Initially, all slots of parent array are initialized to hold the same values as the node.

parent[] = {0, 1, 2}. Also when the value of the node and its parent are same, that is the root of that subset of nodes.

Now process all edges one by one.
Edge 0-1: 
       => Find the subsets in which vertices 0 and 1 are. 
       => 0 and 1 belongs to subset 0 and 1.
       => Since they are in different subsets, take the union of them. 
       => For taking the union, either make node 0 as parent of node 1 or vice-versa. 
       => 1 is made parent of 0 (1 is now representative of subset {0, 1})
       => parent[] = {1, 1, 2}

Edge 1-2: 
       => 1 is in subset 1 and 2 is in subset 2.
       => Since they are in different subsets, take union.
       => Make 2 as parent of 1. (2 is now representative of subset {0, 1, 2})
       => parent[] = {1, 2, 2}

Edge 0-2: 
       => 0 is in subset 2 and 2 is also in subset 2. 
       => Because 1 is parent of 0 and 2 is parent of 1. So 0 also belongs to subset 2
       => Hence, including this edge forms a cycle.

Therefore, the above graph contains a cycle.

Implementation
Initially create a parent[] array to keep track of the subsets.
Take a hash map for not considering a edge twice because we will be given an undirected graph
Traverse through all the edges of the graph
check which subsets each of the vertices belong to for each edge .
If two vertices of an edge belongs to same set then that edge is belong to a cycle return 1
Otherwise then we will union operation on those two subset.
Else no cycle found return 0 .
Complexity
Time complexity : O(V+E) as we traversing the whole graph .
Space complexity : O(V) for extra DSU .




class DSU
{
    private int n;
    private int parent[];
    DSU(int n)
    {
        this.n = n;
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) 
        {
            parent[i] = -1; 
        }
    }
    
    int find(int x)
    {
        if(parent[x]<0)
        {
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    
    void union(int x,int y)
    {
        int px=find(x);
        int py=find(y);
        if(px!=py)
        {
            parent[px]=py;
        }
    }
}

class Solution
{
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        DSU d = new DSU(V+1);
        Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();

        for (int u = 0; u < V; u++) 
        {
            for (int v : adj.get(u)) 
            {
                if (mp.containsKey(u) && mp.get(u).containsKey(v)) 
                {
                    continue;
                }
                
                if (mp.containsKey(v) && mp.get(v).containsKey(u)) 
                {
                    continue;
                }                
                
                if (!mp.containsKey(u)) 
                {
                    mp.put(u, new HashMap<>());
                }
                
                mp.get(u).put(v, 1);
                
                int x = d.find(u);
                int y = d.find(v);
                
                if (x == y) 
                {
                    return 1;
                }
                d.union(u, v);
            }
        }

        return 0;
    }
}
 

Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/detect-cycle-in-graph-using-dsu/
 * 
 */
