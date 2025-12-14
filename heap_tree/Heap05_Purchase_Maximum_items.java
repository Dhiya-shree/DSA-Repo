package heap_tree;

import java.util.Arrays;
import java.util.PriorityQueue;

import arrayCode.ArrayPart01;

/**
 * 
 * Purchasing maximum items with given sum 
 * 
 * Given input array and sum 
 * Cost []= 1 12 5 111 200
 * Total 5 items cost were given 
 * sum=10 
 * 
 * Ans : 2 
 * Can buy 1 and 5 , 6<10 
 *  
 * Naive : O N Log N + N   ++ O N space 
 * Merge / quick sort 
 * 
 * After sorting : 1 5 12 111 200 
 * Sum of array till value less than given sum 
 * 
 * 
 * Efficient : Heap 
 * Build heap -> O N 
 * Extract minimum -> O Log N* res less than 
 * 
 * if used priority Queue -> O N space 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Heap05_Purchase_Maximum_items {

	public static void main(String[] args) {
		// Purchasing maximum items with given sum 
		
		int cost[]= {1,12,5,111,200};
		int n=cost.length;
		int sum=10;
		
		int ans=SortingMethod(cost,sum,cost.length);
		System.out.println(" Sorting methos purchase "+ans);

		
		ans=HeapMethod(cost,sum,n);
		System.out.println(" Heap "+ans);
		
		ans=HeapMethod2(cost,sum,n);
		System.out.println(" Heap 2  : "+ans);
	}

	private static int HeapMethod2(int[] cost, int sum, int n) {
		//use own heap 
		MinHeapArray mh=new MinHeapArray(n);
		mh.buildHeap(cost);
		// 1 5 12 111 200 
		// 200 5 12 111
		System.out.println( " Heap "+Arrays.toString(mh.arr));
		int c=0;
		while(sum>0 && mh.size>-1 && mh.getMinimum()<sum) {
			sum=sum-mh.extractMinimum();
		c++;
		}
		return c;
		
	}

	private static int HeapMethod(int[] cost, int sum, int n) {
		//create heap and check 
		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		
		for(int x: cost) {
			PQ.add(x);
		}
		
		int c=0;
		while(sum>0 && !PQ.isEmpty() && PQ.peek()<sum) {
			sum=sum-PQ.poll();
			c++;
		}
		return c;
	}

	private static int SortingMethod(int[] cost, int sum, int n) {
		// Sorting method
		int cost2[]=cost;
		MergeSortAlgo(cost2,0,n-1);
		
		int s2=0;int i=0;
		while(s2<sum) {
			s2=s2+cost2[i];
			i++;
		}
		return i-1;
	}
	private static void MergeSortAlgo(int[] arr, int low, int high) {
		//end case r>l
		if(high>low) {
			
			int mid=(low+(high-low)/2);
			// 0 to 4 
			// 0+4/2= 2 also 0+(4-2)/2=2
			// 2 to 6
			//  2+6/2=4 also 2+(6-2)/2 = 2+2 =4
			//Mid , to avoid overflow add low 
			
			MergeSortAlgo(arr,low,mid);
			//Left side sort 
			
			MergeSortAlgo(arr, mid+1, high);
			// Right side sort 
			
			MergeSort_Final(arr,low,mid,high);
			// Final merge 
		}
		//return null;
	}

	private static void MergeSort_Final(int[] arr, int low, int mid, int high) {
		// Merging of two sorted algo 
		// Merge function 
		
				//Prepare two array left nd right
				int n1=mid-low+1;
				int n2=high-mid;
				
				int leftA[] = new int[n1];
				int rightA[] = new int[n2];
				
				for(int i=0;i<n1;i++) {
					leftA[i]=arr[low+i];
				}
				
				for(int i=0;i<n2;i++) {
					rightA[i]=arr[mid+i+1];
				}
				System.out.println(" N1 "+n1+"  N2 "+n2+" High "+high);
				
				ArrayPart01.PrintRayy(leftA);
				
				ArrayPart01.PrintRayy(rightA);
				// Sorting 
				
				// Initial indexes of first and second subarrays
		        int i = 0, j = 0;
		 
		        // Initial index of merged subarray array
		        int k = low;
		        while (i < n1 && j < n2) {
		            if (leftA[i] <= rightA[j]) {
		                arr[k] = leftA[i];
		                i++;
		            }
		            else {
		                arr[k] = rightA[j];
		                j++;
		            }
		            k++;
		        }
		 
		        /* Copy remaining elements of L[] if any */
		        while (i < n1) {
		            arr[k] = leftA[i];
		            i++;
		            k++;
		        }
		 
		        /* Copy remaining elements of R[] if any */
		        while (j < n2) {
		            arr[k] = rightA[j];
		            j++;
		            k++;
		        }
		    }

	

}

/**
 * 
 * Buy Maximum Items with Given Sum

Given an array arr[] consisting of the cost of toys and an integer K depicting the amount of money available to purchase toys. The task is to find the maximum number of toys one can buy with the amount K.
Note: One can buy only 1 quantity of a particular toy.

Examples: 

Input: arr[] = {1, 12, 5, 111, 200, 1000, 10, 9, 12, 15}, K = 50 
Output: 6 
Toys with amount 1, 5, 9, 10, 12, and 12 
can be purchased resulting in a total amount of 49. 
Hence, the maximum number of toys are 6.

Input: arr[] = {1, 12, 5, 111, 200, 1000, 10}, K = 50 
Output: 4

Approach: Insert all the elements of the given array in a priority_queue now one by one remove elements from this priority queue and add these costs in a variable sum initialised to 0. Keep removing the elements while the new addition keep the sum smaller than K. In the end, the count of elements removed will be the required answer.

Below is the implementation of the above approach:

// Java implementation of the approach
import java.io.*;
import java.util.*;

class GFG {

    // Function to return the count of
    // maximum toys that can be bought
    public static int maxToys(int[] arr, int k)
    {
        int n = arr.length;

        // Create a priority_queue and push
        // all the array elements in it
        PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            pq.offer(arr[i]);
        }

        // To store the count of maximum
        // toys that can be bought
        int count = 0;
        while (!pq.isEmpty() && pq.peek() <= k) {
            k = k - pq.poll();
            count++;
        }
        return count;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr
            = new int[] { 1, 12, 5, 111, 200, 1000, 10 };
        int k = 50;

        System.out.println(maxToys(arr, k));
    }
}
 

Output: 

4
Time Complexity: O(N*logN)
Auxiliary Space: O(N)


 * 
 */
