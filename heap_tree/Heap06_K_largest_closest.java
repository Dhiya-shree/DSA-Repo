package heap_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  
 * Kth Largest Elements -- HARD 
 * 
 * Given an array arr[] of N positive integers and a number K. The task is to find the kth largest element in the array.

Example 1:

Input:
N = 5, K = 3
arr[] = {3, 5, 4, 2, 9}
Output: 
4
Explanation: 
Third largest element
in the array is 4.
Example 2:

Input:
N = 5, K = 5
arr[] = {4, 3, 7, 6, 5} 
Output: 
3
Explanation: 
Fifth largest element
in the array is 3.
Your Task:
You are required to complete the method KthLargest() which takes 3 arguments and returns the Kth Largest element.



 /////////
 * K largest elements 
 * 
 * Given an unsorted array and a element K 
 * Print first K elemets 
 * 
 * arr= 5 15 10 20 8 
 * K=2 
 * 
 * 1) Build max heap  O N 
 * 2) Take out Min K times K* O Log N / Level order traversal 
 * 
 * 
 * Efficient :
 * 
 * 1) Build a min heap of K items  K O Log K
 * 2) Traverse from K+1 to N :    
 *      if val<top 
 *         ignore 
 *      else 
 *         remove top 
 *         Add the val        N-K O Log K 
 * 3) Print min Heap O K 
 * 
 * 
 * Max Time : O N + K Log n 
 * Min Time : O K+ (N-K)Log K 
 * 
 * If K very small 
 * Max Time: O N + Log N 
 * Min Time: O N 
 * 
 * If K large = N
 * Max Time : O N+ N Log N 
 * Min Time : O N + Log N 
 * 
 Given an array of N positive integers, print k largest elements from the array. 

Example 1:

Input:
N = 5, k = 2
arr[] = {12,5,787,1,23}
Output: 787 23
Explanation: First largest element in
the array is 787 and the second largest
is 23.
Example 2:

Input:
N = 7, k = 3
arr[] = {1,23,12,9,30,2,50}
Output: 50 30 23
Explanation: Three Largest element in
the array are 50, 30 and 23.
Your Task:
Complete the function kLargest() that takes the array, N and K as input parameters and returns a list of k largest element in descending order. 

Expected Time Complexity: O(N log K)
Expected Auxiliary Space: O(K)

Constraints:
1 ≤ N ≤ 104
K ≤ N
1 ≤ array[i] ≤ 105
 * 
 *  //////////////////////////////////////////////////////////////////
 *  
 *  K closest elements :
 *  
 *  Given an array 10 15 7 3 4 
 *  And number x : 8 
 *  And value K : 2
 *  Find K closest value of X 
 *  
 *  2 closest value of 8 
 *  7 and 10 
 *  
 *  Naive : O N.K 
 *  Create visted array 
 *  for o to K 
 *     Loop for 0 to N 
 *      check the max closest in unvisted to x 
 *     Closest[0]=max
 *     Visted for max=true 
 * 
 *  Given no negative numbers....
 * 
 *  Method 1 :
 *  Subtract array with given number 
 *  Create Min heap of size N and extract K elements 
 *  
 *  Method 2 :
 *  Subtract array with given number to get (num,priority:min diff)
 *  Create Max heap of size K 
 *  Insert first K elements 
 *  From K to N :
 *   if data < max of heap 
 *   extract max 
 *   Add data 
 * 
 * 
 * @author shree
 *
 */
public class Heap06_K_largest_closest {

	public static void main(String[] args) {
		// Max heap 
		
		int arr[]= {5,15,10,20,8,60,50,100};
		int n=arr.length;
		int K =3;
		///////////////////////////////////////////////////// K LARGEST 
		System.out.println(" Using max heap of sixe N ");
	    MaxHeapElements(arr,n,K);	
	    
	    System.out.println(" using min heap of size K ");
	    MinHeapElements(arr,n,K);
	    
	    System.out.println();
	    MinHeapCustom(arr,n,K);
	    
	    /////////////////////////////////////////////////////// K Closest 
	
	    int x=99;
	    KClosestMaxHeap(arr,n,K,x);
	    
	 
	    //Optimized 
	   // KClosest ob = new KClosest();
        int arr2[] = {12, 16, 22, 30, 35, 39, 42,
                     45, 48, 50, 53, 55, 56
                    };
        int n2 = arr.length;
        int x2 = 35, k2 = 4;
        printKclosest(arr2, x2, k2, n2);
	    
	    ///////////////////// Kth largest 
	    
	    int ans=KthLargest(arr,n,K);
	    System.out.println(" K th largest is "+ans);
	
	    ans=KthSmallest(arr,n,K);
	    System.out.println(" K th smallest is "+ans);
	}
		
	private static int KthSmallest(int[] arr, int n, int k) {
		// k smallest 
		
		//K==N , Nth smallest = max 
		//K==1 mimimum in array 
		if(k==n){
            int min=arr[0];
            for(int i=1;i<n;i++){
                min=Math.min(arr[i],min);
            }
            return min;
        }
        if(k==1){
            int min=arr[0];
            for(int i=1;i<n;i++){
                min=Math.max(arr[i],min);
            }
            return min;
        }
        // Max heap is used here
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        
          for(int i=k;i<n;i++){
        	//smallest need to find
              if(pq.peek()>arr[i]){
                 pq.poll();
                 pq.add(arr[i]);
             }    
          }
          
          return pq.peek();
	}

	private static int KthLargest(int arr[], int n, int k) 
    {
        if(k==n){
            int min=arr[0];
            for(int i=1;i<n;i++){
                min=Math.min(arr[i],min);
            }
            return min;
        }
        if(k==1){
            int min=arr[0];
            for(int i=1;i<n;i++){
                min=Math.max(arr[i],min);
            }
            return min;
        }
        // Your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        
          for(int i=k;i<n;i++){
             if(pq.peek()<arr[i]){
                 pq.poll();
                 pq.add(arr[i]);
             }    
          }
          
          return pq.peek();
          
    }
		
		private static void KClosestMaxHeap(int[] arr, int n, int k, int x) {
		// Create max heap 
		PriorityQueue<DataWDiff> pq=new PriorityQueue<>(
	                   new Comparat());
		int diff=0;
		DataWDiff curr=null;
		for(int i=0;i<k;i++) {
			diff=Math.abs(arr[i]-x);
			pq.add(new DataWDiff(arr[i],diff));
		}
		
		for(int i=k;i<n;i++) {
			diff=Math.abs(arr[i]-x);
			System.out.println(arr[i]+" Diff "+diff+" Peek "+pq.peek().diff);
			if(diff<pq.peek().diff) {
				pq.poll();
				pq.add(new DataWDiff(arr[i], diff));
			}
		}
		//below wont work 
		System.out.println(" PQ at last with closest "+pq.toString());
	    
		
		for(int i=0;i<k;i++) {
			curr=pq.poll();
		   System.out.println(curr.data+" at "+curr.diff);
		}
	}


		private static void MinHeapCustom(int[] arr, int n, int k) {
		// using own class 
		MinHeapArray mh=new MinHeapArray(k);
		for(int i=0;i<k;i++) {
			mh.insert(arr[i]);
		}
		System.out.println(Arrays.toString(mh.arr));
		for(int i=k;i<n;i++) {
			if(arr[i]>mh.getMinimum()) {
				mh.extractMinimum();
				mh.insert(arr[i]);
			}
		}
		System.out.println(Arrays.toString(mh.arr));
		
	}


		private static void MinHeapElements(int[] arr, int n,int K) {
		// min heap of K 
			PriorityQueue<Integer> Pq=new PriorityQueue<>();
			
			for(int i=0;i<K;i++) {
				Pq.add(arr[i]);
			}
			
			for(int i=K;i<n;i++) {
				if(arr[i]<Pq.peek()) {
					//ignore
				}
				else {
					Pq.poll();
					Pq.add(arr[i]);
				}
			}
			
		  System.out.println(" PQ "+Pq.toString());
		  
			ArrayList<Integer> ans=new ArrayList<Integer>(K);
			while(!Pq.isEmpty()){
			    ans.add(0,Pq.poll());
			}
			
			System.out.println(ans.toString());
			return ;
		}


		private static void MaxHeapElements(int[] arr, int n, int K) {

		MaxHeapArray mh=new MaxHeapArray(n);
		mh.buildHeap(arr);
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<K;i++) {
			int data=mh.extractMaximum();
			System.out.println(data);
		}
		

		}
		
		
		 static int findCrossOver(int arr[], int low, int high, int x)
		    {
		        // Base cases
		        if (arr[high] <= x) // x is greater than all
		            return high;
		        if (arr[low] > x)  // x is smaller than all
		            return low;

		        // Find the middle point
		        int mid = (low + high)/2;  /* low + (high - low)/2 */

		        /* If x is same as middle element, then return mid */
		        if (arr[mid] <= x && arr[mid+1] > x)
		            return mid;

		        /* If x is greater than arr[mid], then either arr[mid + 1]
		          is ceiling of x or ceiling lies in arr[mid+1...high] */
		        if(arr[mid] < x)
		            return findCrossOver(arr, mid+1, high, x);

		        return findCrossOver(arr, low, mid - 1, x);
		    }

		    static // This function prints k closest elements to x in arr[].
		    // n is the number of elements in arr[]
		    void printKclosest(int arr[], int x, int k, int n)
		    {
		        // Find the crossover point
		        int l = findCrossOver(arr, 0, n-1, x); 
		        int r = l+1;   // Right index to search
		        int count = 0; // To keep track of count of elements
		                       // already printed

		        // If x is present in arr[], then reduce left index
		        // Assumption: all elements in arr[] are distinct
		        if (arr[l] == x) l--;

		        // Compare elements on left and right of crossover
		        // point to find the k closest elements
		        while (l >= 0 && r < n && count < k)
		        {
		            if (x - arr[l] < arr[r] - x)
		                System.out.print(arr[l--]+" ");
		            else
		                System.out.print(arr[r++]+" ");
		            count++;
		        }

		        // If there are no more elements on right side, then
		        // print left elements
		        while (count < k && l >= 0)
		        {
		            System.out.print(arr[l--]+" ");
		            count++;
		        }


		        // If there are no more elements on left side, then
		        // print right elements
		        while (count < k && r < n)
		        {
		            System.out.print(arr[r++]+" ");
		            count++;
		        }
		    }

}

//wrapper class
class DataWDiff{
	int data;
	int diff;
	DataWDiff(int a,int d){
		data=a;
		diff=d;
	}
	
	
}

//comparable 
class Comparat implements Comparator<DataWDiff> {

	public int compare(DataWDiff o1, DataWDiff o2) {
		// custom comparator 
		// use 
	//	(o1.diff).compareTo(o2.diff);
		return (o2.diff-o1.diff);
	}

	
}

class Comparab implements Comparable<DataWDiff>{

	@Override
	public int compareTo(DataWDiff o) {
		// compare To
		return o.diff;
	}
	
}

/**
 * 
 * K Closest Elements

Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]. 

Examples: 

Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42, 
               45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, only the other closest elements are required 

In the following solutions, it is assumed that all elements of array are distinct.
A simple solution is to do linear search for k closest elements. 
1) Start from the first element and search for the crossover point (The point before which elements are smaller than or equal to X and after which elements are greater). This step takes O(n) time. 
2) Once we find the crossover point, we can compare elements on both sides of crossover point to print k closest elements. This step takes O(k) time.
The time complexity of the above solution is O(n).

An Optimized Solution is to find k elements in O(Logn + k) time. The idea is to use Binary Search to find the crossover point. Once we find index of crossover point, we can print k closest elements in O(k) time.  


// Java program to find k closest elements to a given value
class KClosest
{
    /* Function to find the cross over point (the point before
       which elements are smaller than or equal to x and after
       which greater than x)*
    int findCrossOver(int arr[], int low, int high, int x)
    {
        // Base cases
        if (arr[high] <= x) // x is greater than all
            return high;
        if (arr[low] > x)  // x is smaller than all
            return low;

        // Find the middle point
        int mid = (low + high)/2;  /* low + (high - low)/2 *

        /* If x is same as middle element, then return mid *
        if (arr[mid] <= x && arr[mid+1] > x)
            return mid;

        /* If x is greater than arr[mid], then either arr[mid + 1]
          is ceiling of x or ceiling lies in arr[mid+1...high] *
        if(arr[mid] < x)
            return findCrossOver(arr, mid+1, high, x);

        return findCrossOver(arr, low, mid - 1, x);
    }

    // This function prints k closest elements to x in arr[].
    // n is the number of elements in arr[]
    void printKclosest(int arr[], int x, int k, int n)
    {
        // Find the crossover point
        int l = findCrossOver(arr, 0, n-1, x); 
        int r = l+1;   // Right index to search
        int count = 0; // To keep track of count of elements
                       // already printed

        // If x is present in arr[], then reduce left index
        // Assumption: all elements in arr[] are distinct
        if (arr[l] == x) l--;

        // Compare elements on left and right of crossover
        // point to find the k closest elements
        while (l >= 0 && r < n && count < k)
        {
            if (x - arr[l] < arr[r] - x)
                System.out.print(arr[l--]+" ");
            else
                System.out.print(arr[r++]+" ");
            count++;
        }

        // If there are no more elements on right side, then
        // print left elements
        while (count < k && l >= 0)
        {
            System.out.print(arr[l--]+" ");
            count++;
        }


        // If there are no more elements on left side, then
        // print right elements
        while (count < k && r < n)
        {
            System.out.print(arr[r++]+" ");
            count++;
        }
    }

    /* Driver program to check above functions *
    public static void main(String args[])
    {
        KClosest ob = new KClosest();
        int arr[] = {12, 16, 22, 30, 35, 39, 42,
                     45, 48, 50, 53, 55, 56
                    };
        int n = arr.length;
        int x = 35, k = 4;
        ob.printKclosest(arr, x, 4, n);
    }
}
/* This code is contributed by Rajat Mishra *
 

Output: 

39 30 42 45

The time complexity of this method is O(Logn + k).
 * 
 * 
 */


/*
 * 
 * K Largest Elements

Method 1(Use Sorting) 
1) Sort the elements in descending order in O(n*log(n)) 
2) Print the first k numbers of the sorted array O(k). 

Following is the implementation of the above.  


// Java code for k largest elements in an array
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

class GFG {
    public static void kLargest(Integer[] arr, int k)
    {
        // Sort the given array arr in reverse order
        // This method doesn't work with primitive data
        // types. So, instead of int, Integer type
        // array will be used
        Arrays.sort(arr, Collections.reverseOrder());

        // Print the first kth largest elements
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }
  
  //This code is contributed by Niraj Dubey
  public static ArrayList<Integer> kLargest(int[] arr, int k)
    {
        //Convert using stream
        Integer[] obj_array = Arrays.stream( arr ).boxed().toArray( Integer[] :: new);
        Arrays.sort(obj_array, Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>(k);

        for (int i = 0; i < k; i++)
            list.add(obj_array[i]);
    
        return list;
    }

    public static void main(String[] args)
    {
        Integer arr[] = new Integer[] { 1, 23, 12, 9,
                                        30, 2, 50 };
        int k = 3;
        kLargest(arr, k);
      
        //This code is contributed by Niraj Dubey
        //What if primitive datatype array is passed and wanted to return in ArrayList<Integer>
        int[] prim_array = { 1, 23, 12, 9, 30, 2, 50 };
          System.out.print(kLargest(prim_array, k));
    }
}
// This code is contributed by Kamal Rawal

Output
50 30 23 
 
Time complexity: O(n*log(n))
Auxiliary Space: O(1)

Method 2 (Use Max Heap) 
1) Build a Max Heap tree in O(n) 
2) Use Extract Max k times to get k maximum elements from the Max Heap O(k*log(n))

Time complexity: O(n + k*log(n)) 

Method 3 (Use Min Heap) 
Using Min Heap.

 

import java.io.*;
import java.util.*;

class GFG{

public static void firstKElements(int arr[], int n, int k)
{
	
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	for(int i = 0; i < k; i++)
	{
		minHeap.add(arr[i]);
	}
	for(int i = k; i < n; i++)
	{
		if (minHeap.peek() > arr[i])
			continue;
		else
		{
			minHeap.poll();
			minHeap.add(arr[i]);
		}
	}
	
	Iterator iterator = minHeap.iterator(); 
	
	while (iterator.hasNext()) 
	{ 
		System.out.print(iterator.next() + " "); 
	} 
}

public static void main (String[] args)
{
	int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
	
	int size = arr.length;
	
	int k = 3;
	
	firstKElements(arr, size, k);
}
}

Output
50 88 96 
Time Complexity: O(nlogn)
Auxiliary Space: O(n)


 * 
 * 
 * 
 */
