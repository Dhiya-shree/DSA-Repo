package disjointSet_SegmentTree_Trie;
/**
 * 
 * 
 * Number of Connected Components
Difficulty: EasyAccuracy: 64.32%Submissions: 7K+Points: 2Average Time: 20m
This problem is to find the number of connected components. There will be 2 incomplete functions namely unionNodes and findNumberOfConnectedNodes. You have to complete these functions. 

unionNodes: Join two subsets into a single set.
findNumberOfConnectedNodes: Determine number of different connected components in a graph.

Example 1:

Input:
N = 5
M = 2
Edges[] = {(1,3),(1,5)}
Output: 
3
Explanation: 
- Initially all nodes 1 2 3 4 5 are not connected. 
- After 1 3, node 1 and 3 will be connected.
- After 1 5, node 1 and 5 will be connected.
- Finally we have {1,3,5}, {2}, {4}. So we have a total of 3 connected components.
Example 2:

Input:
N = 5
M = 3
Edges[] = {(1,4),(2,3),(1,5)}
Output: 
2
Explanation: 
- Initially all nodes 1 2 3 4 5 are not connected.
- After 1 4, node 1 and 4 will be connected.
- After 2 3, node 2 and 3 will be connected.
- After 1 5, node 1 and 5 will be connected.
- Finally we have {1,4,5}, {2, 3}. So we have total of 2 connected components
Your Task:

You have to complete the function unionNodes() which merges the node1 and node2. You will also have to complete the function findNumberOfConnectedNodes() function will returntotal number of different connected components in a graph.

Note: We recommend you to solve this problem first https://practice.geeksforgeeks.org/problems/union-find/1. There are ways to solve this problem from BFS and DFS as well. But for this problem stick to filling these functions as in union-find. 

Constraints: 
1 <= N <= 105
1 <= M <= 105
1 <= node1, node2 <= N
 * @author shree
 *
 */
public class DST19_NumberOfConnectedComponents {

}


//User function Template for Java


class Solution
{

  //Function to merge two nodes a and b.
  static void unionNodes(int a, int b, int par[], int rank[],int n)
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

  

  //Function to determine number of connected components.
  static int findNumberOfConnectedComponents( int n, int arr[], int rank1[]) 
  {
    // ArrayList<ArrayList<Integer>> connected=new ArrayList<ArrayList<Integer>>(n);
   
    int connected[]=new int[n+1];
     for(int i=1;i<n+1;i++){
        //  System.out.print(arr[i]+" ");
          if(arr[i]==0){
              connected[i]=1;
          }
          else{
         int parent=Find(i,arr);
         connected[parent]=1;
          }
      }
      int ans=0;
      for(int i=1;i<n+1;i++){
        ans=ans+connected[i];
          
      }
      
       return (ans);
  }
  /*
  100000
1
2 3
  */
  
  static public int Find(int x,int par[]){
      
      if(par[x]==x){
          return x;
      }
      
      par[x]=Find(par[x],par);
      return par[x];
  }
}
/**



class Solution
{
    //Function to find root of a node.
    static int findRoot(int i, int arr[], int rank1[], int n) 
    {
        //finding the node whose arr[i] is equal to i.
        if(i==arr[i]) {                     
            return i;
        }
        return findRoot(arr[i], arr, rank1, n);  
    }

    //Function to merge two nodes a and b.
    static void unionNodes( int a, int b, int arr[], int rank1[], int n) 
    { 
        //find root of nodes a and b.
        int x = findRoot(a, arr, rank1, n);
        int y = findRoot(b, arr, rank1, n);
    
        //base case if they are already in same set.
        if(x == y)
            return;
        
        //changing the root of smaller size node to bigger size node
        //and increasing the size of the bigger size node.
        if(rank1[x]>=rank1[y]) {                
            rank1[x]+=rank1[y];
            arr[y] = arr[x];
        } else {
            rank1[y]+=rank1[x];
            arr[x] = arr[y];
        }
    }

    //Function to determine number of connected components.
    static int findNumberOfConnectedComponents( int n, int arr[], int rank1[]) 
    {
        int cnt=0;
    
        for(int i=1; i<=n; i++)
        {
            //the number of connected components is equal to 
            //number of nodes which are its own root.
            if( findRoot(i, arr, rank1, n) == i) {      
                cnt++;                                 
            }
        }
        return cnt;
    }
}


*/