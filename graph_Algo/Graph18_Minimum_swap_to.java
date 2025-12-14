package graph_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
 * 
 * 
 * Minimum Swaps to Sort

Given an array arr[] of distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.

Examples:

Input: arr[] = [2, 8, 5, 4]
Output: 1
Explanation: Swap 8 with 4 to get the sorted array.
Input: arr[] = [10, 19, 6, 3, 5]
Output: 2
Explanation: Swap 10 with 3 and 19 with 5 to get the sorted array.
Input: arr[] = [1, 3, 4, 5, 6]
Output: 0
Explanation: Input array is already sorted.
 * 
 * 
 */

public class Graph18_Minimum_swap_to {

}
class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[]) {
        // 10 19 6 5 3
    	// 3  5  6 1 19 
    	// all swap 
    	// 1--4 2---5 3--3X 4--2 5---1
    	// ArrayList 1-->4 , 4--->2,2--->5,5--->1
    	// Min swap = dfs length -1 
        
        int n=arr.length;
        int sort[]=new int[n];
        HashMap<Integer,Integer>  hm=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            sort[i]=arr[i];
            hm.put(arr[i],i);
        }
        Arrays.sort(sort);
        ArrayList<Integer>  adj=new ArrayList<Integer>(n);
        
        for(int i=0;i<n;i++){
            if(arr[i]!=sort[i]){
                adj.add(hm.get(sort[i]));
            }
            else{
                adj.add(i);
            }
        }
        if(adj.isEmpty()){
            return 0;
        }
     //     System.out.println(adj);
        int ans=0;visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(arr[i]!=sort[i] && visited[i]==false){
                ans=ans+dfs(adj,hm.get(arr[i]))-1;
         //       System.out.println(ans+"--");
            }
        }
        
        
      return ans;
    }
    boolean visited[];
    public int dfs(ArrayList<Integer> adj,int src){
        if(visited[src]){
            return 0;
        }
        else{
            visited[src]=true;
        //   System.out.println(src+"-->");
            return 1+dfs(adj,adj.get(src));
        }
    }
}
