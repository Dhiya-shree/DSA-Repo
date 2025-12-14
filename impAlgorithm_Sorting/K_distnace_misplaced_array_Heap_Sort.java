package impAlgorithm_Sorting;
/**
 * Nearly sorted
Difficulty: MediumAccuracy: 75.25%Submissions: 70K+Points: 4Average Time: 30m
Given an array arr[], where each element is at most k away from its target position, you need to sort the array optimally.
Note: You need to change the given array arr[] in place.

Examples:

Input: arr[] = [6, 5, 3, 2, 8, 10, 9], k = 3
Output: [2, 3, 5, 6, 8, 9, 10]
Explanation: The sorted array will be 2 3 5 6 8 9 10
Input: arr[]= [1, 4, 5, 2, 3, 6, 7, 8, 9, 10], k = 2
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: The sorted array will be 1 2 3 4 5 6 7 8 9 10
 * 
 * 
 * @author shree
 *
 */
public class K_distnace_misplaced_array_Heap_Sort {

	
	// Every element id at most K distance from where it is supposed to be 
	// sorted 1 2 3 4 5 6 7 
	// K - 4 
	//  Given : 2 3 1 5 4 7 6 
	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}


class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int n, int k)
    {
        // your code here
         ArrayList<Integer> res=new ArrayList <Integer>();
        
        if(n==1){
            res.add(arr[0]);
            return res;
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
        
        return res;
    }
    
}

/**


e exactly applicable to the problem statement given here.
Given an array arr[] and a number k . The array is sorted in a way that every element is at max k distance away from it sorted position. It means if we completely sort the array, then the index of the element can go from i - k to i + k where i is index in the given array. Our task is to completely sort the array.

Examples: 

Input: arr= [6, 5, 3, 2, 8, 10, 9], k = 3 
Output: [2, 3, 5, 6, 8, 9, 10]

Input: arr[]= [1, 4, 5, 2, 3, 6, 7, 8, 9, 10], k = 2
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Table of Content

[Naive Approach] By sorting - O(n*log n) Time and O(1) Space
[Expected Approach] Using Heap - O(n*log k) Time and O(k) Space
[Naive Approach] By sorting - O(n*log n) Time and O(1) Space
We can simply use any sorting algorithm of O(n*log n) time complexity to achieve sorted array.

[Expected Approach] Using Heap - O(n*log k) Time and O(k) Space
The main idea is to sort the array efficiently from left to right by considering elements from the right side. For each position i, we find the minimum element in the range [i, i + k] with help of min-heap. we don't need to check numbers from left side as they are already at their correct positions.

Step by Step implementation:

Push the first k elements of the array into the min-heap. These elements form the initial search range for sorting the first few indices.
Iterate through the remaining elements of the array (from index k to n-1). For each element:
Push it into the min-heap.
The heap now contains k + 1 elements, so remove the smallest element (top of the heap) and place it at its correct position in the array (arr[i-k]).
After processing all elements in the array, the heap still contains the last k elements. Extract these elements one by one and place them in the remaining positions of the array.



// Java program to sort a nearly sorted array
import java.util.*;

class GfG {
    
    // Function to sort a nearly sorted array
    // where every element is at most
    // k positions away from its target position.
    static void nearlySorted(int[] arr, int k) {
        
        // Length of array
        int n = arr.length;

        // Creating a min heap
        PriorityQueue<Integer> pq =  new PriorityQueue<>();

        // Pushing first k elements in pq
        for (int i = 0; i < k; i++) 
            pq.add(arr[i]);

        int i;
        for (i = k; i < n; i++) {
            pq.add(arr[i]);

            // Size becomes k+1 so pop it
            // and add minimum element in (i-k) index
            arr[i - k] = pq.poll();
        }

        // Putting remaining elements in array
        while (!pq.isEmpty()) {
            arr[i - k] = pq.poll();
            i++;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {6, 5, 3, 2, 8, 10, 9};

        nearlySorted(arr, k);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}

Output
2 3 5 6 8 9 10 
Note: We can also use a Balanced Binary Search Tree instead of a Heap to store k+1 elements. The insert and delete operations on Balanced BST also take O(log k) time. So Balanced BST-based method will also take O(n log k) time, but the Heap based method seems to be more efficient as the minimum element will always be at the root. Also, Heap doesn't need extra space for left and right pointers.

*/