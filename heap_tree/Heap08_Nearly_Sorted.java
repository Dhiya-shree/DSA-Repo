package heap_tree;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 
 * Nearly sorted 
 * 
 * Given an array of n elements, where each element is at most k away from its target position, you need to sort the array optimally.

Example 1:

Input:
n = 7, k = 3
arr[] = {6,5,3,2,8,10,9}
Output: 2 3 5 6 8 9 10
Explanation: The sorted array will be
2 3 5 6 8 9 10
Example 2:

Input:
n = 5, k = 2
arr[] = {3,1,4,2,5}
Output: 1 2 3 4 5 
Note: DO NOT use STL sort() function for this question.

Your Task:
You are required to complete the method nearlySorted() which takes 3 arguments and returns the sorted array.

Expected Time Complexity : O(nlogk)
Expected Auxilliary Space : O(n)

Constraints:
1 ≤ n ≤ 106
1 ≤ k < n
1 ≤ arri ≤ 107
 * 
 * @author shree
 *
 */
public class Heap08_Nearly_Sorted {

	public static void main(String[] args) {
		// neraly K sorted 
		int arr[] = {6,5,3,2,8,10,9};
		int n=arr.length;
		int k=3;
		
		nearlySorted(arr,n,k);

	}
	
	private static void nearlySorted(int arr[], int n, int k)
    {
        // your code here
         ArrayList<Integer> res=new ArrayList <Integer>();
        
        if(n==1){
            res.add(arr[0]);
            System.out.println(res.toString());
            return;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0;i<k+1;i++){
            pq.add(arr[i]);
        }
        
          for(int i=k+1;i<n;i++){
                 res.add(pq.poll());
                 pq.add(arr[i]);
             }
             
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }   
        
        System.out.println(res.toString());
        return;
    }

}
