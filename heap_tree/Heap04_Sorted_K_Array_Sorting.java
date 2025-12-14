package heap_tree;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 *  Sort a K sorted array :
 *  
 *  Given an K sorted array 
 *  K=2 
 *  9 8 7 18 19 17 
 *  
 *  Any element might be in range of 
 *  i-K ... i+K in the sorted array 
 *  
 *  For element at 0 : K=2 
 *  9 in sorted array within pos 2 (i+K)
 *  
 *  1 => 1,2,3
 *  2=> 0 to 4 
 *  3=>1 to 5 
 *  4=> 2 to 5 (6 not exist )
 *  5=> 3 to 5 ( 6,7 not exist )
 *  
 *  Naive :
 *  Sort it merge / quick 
 *  N Log N 
 *  
 *   
 *  Efficient :
 *  O N log K 
 *  Use min heap for decreasing manner 
 *  
 *  Pq 
 *  Index -> index in arr 
 *  
 *  
 *  1) Create min heap of first K+1 elements 
 *  2) For K+1 to N-1 loop :
 *  3)   Add each element 
 *  
 *  Sliding window 
 *  Take K first elements put in Heap 
 *  In array 
 *  Remove min most from heap
 *  Set min most at pos 0 increment min pos 
 *  Add next element and so on ...
 *  
 *  
 * 
 * 
 * @author shree
 *
 */
public class Heap04_Sorted_K_Array_Sorting {

	public static void main(String[] args) {
		// Sort a K sorted 
		// K = 3 
		// 1 5 6 4 | 11 7 10  12 | 100 200 400 300
		// We have 3 unsorted array 
		// diff ranges and sorted in final array 
		
		//To get decreaasing count use min Heap
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int arr[]= {9,8,7,19,18};
		System.out.println(" Array Unsorted "+Arrays.toString(arr));

		int n=arr.length;
		int K=2;
		//Add first K in heap   O K log K 
		for(int i=0;i<=K;i++) {
			pq.add(arr[i]);
		}
		System.err.println(" PQ till K "+pq.toString());
		int correct=0;
		//put min in correct place , add extra element 
		for(int i=K+1;i<n;i++) {  // O N-K Log K
			arr[correct++]=pq.poll();
			pq.add(arr[i]);
		}
		
		// Finally remove everything in Pq 
		while(!pq.isEmpty()) {      //  K Log K 
			arr[correct++]=pq.poll();	
		}
		
		System.out.println(" Array sorted "+Arrays.toString(arr));

	}

}

/*
 * Sort K-Sorted Array

We can sort such arrays efficiently with the help of Heap data structure. Following is the detailed process that uses Heap. 
1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time (See this GFact). We are creating heap of size k as the element can be atmost k distance from its index in a sorted array. 
2) One by one remove min element from heap, put it in result array, and add a new element to heap from remaining elements.
Removing an element and adding a new element to min heap will take log k time. So overall complexity will be O(k) + O((n-k) * log(k)).

// A java program to sort a nearly sorted array
import java.util.Iterator;
import java.util.PriorityQueue;

class GFG {
    private static void kSort(int[] arr, int n, int k)
    {
        if (arr == null || arr.length == 0) {
          return;
        }
        // min heap
        PriorityQueue<Integer> priorityQueue
            = new PriorityQueue<>();
       // if there are less than k + 1 elements present in the array 
        int minCount = Math.min(arr.length, k + 1);
        // add first k + 1 items to the min heap
        for (int i = 0; i < minCount; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }

    // A utility function to print the array
    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver Code
    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        kSort(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
    }
}

// This code is contributed by
// Manpreet Singh(manpreetsngh294)

Output
Following is sorted array
2 3 6 8 12 56 
Time Complexity: O(k) + O((m) * log(k)) ,  where m = n - k
Auxiliary Space: O(k)


 * 
 * 
 */
