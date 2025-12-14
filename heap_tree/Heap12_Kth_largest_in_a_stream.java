package heap_tree;

import java.util.PriorityQueue;

/**
 * 
 * Kth largest in a stream 
 * 
 * Given an input stream of n integers, find the kth largest element each time when an new element is added to the stream.

Example 1:

Input:
k = 4, n = 6
arr[] = {1,2,3,4,5,6}
Output: -1 -1 -1 1 2 3
Explanation: k = 4
For 1, the 4th largest element doesn't
exist so we print -1.
For 2, the 4th largest element doesn't
exist so we print -1.
For 3, the 4th largest element doesn't
exist so we print -1.
For 4, the 4th largest element is 1
{1, 2, 3, 4}
For 5, the 4th largest element is 2
{2, 3, 4 ,5}
For 6, the 4th largest element is 3
{3, 4, 5, 6}

Example 2:

Input:
k = 1, n = 2
arr[] = {3,4}
Output: 3 4 
Your Task:
You are required to complete the method kthLargest() which takes 3 arguments and prints kth largest element -1.

Constraints:
1 <= n <= 106
1 <= k <= n
1 <= arr[i] <= 105

Expected Time Complexity: O(n*Log(k))
Expected Auxiliary Space: O(k)
 * 
 * 
 * @author shree
 *
 */
public class Heap12_Kth_largest_in_a_stream {

	public static void main(String[] args) {
		// stream instead of array 
		
		int k = 4,n = 6;
		int arr[] = {1,2,3,4,5,6};
		
		kthLargest(arr,n,k);

	}
	private static void kthLargest(int arr[], int n, int k){
        // Your code here
        
        if(k==1){
            int max=arr[0];
             System.out.print(max+" ");
            for(int i=1;i<n;i++){
                max=Math.max(arr[i],max);
                System.out.print(max+" ");
            }
            return;
        }
        
        //Create a min heap of size K 
        //Fill min heap with -1
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
      //  int j=0;
        for(int i=0;i<k-1;i++){
            pq.add(arr[i]);
            System.out.print(-1+" ");
        }
        System.out.println(pq.toString());
        
        pq.add(arr[k-1]);
        int val=pq.peek();
          System.out.print(val+" ");
        for(int i=k;i<n;i++){
            
            if(pq.peek()<arr[i]){
                pq.add(arr[i]);
                pq.poll();
            }
            System.out.print(pq.peek()+" ");
        }
       //  System.out.print(pq.peek()+" ");
    }
}
