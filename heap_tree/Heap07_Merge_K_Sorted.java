package heap_tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *  Merge K sorted array 
 *  
 *  Given arrays sorted merge them 
 *  
 *  Input : 
 *  Arr[][]={   {10,20,30},
                 {2,5,15},
                {1,3,9,25,50}   };
 * 
 * Op:  1 2 3 5 9 10 15 20 25 30 50  
 * 
 * Total elemets max : N * K ==Actual N
 * 
 * Naive: N K Log N K 
 * Copy all into res array 
 * Sort the res array 
 * 
 * Naive solution : N + 2N + 3N +..... K N => N K^2
 * Create res array 
 * Merge 1 and 2 using 2 pointer into res 
 * Merge res and 3 and so on 
 * 
 * Efficient Data structure : O N K Log K 
 * if K very small ...
 * Time O N 
 * if K large K=N 
 * O N2 log N 
 * 
 * Use Min heap data structure 
 * 
 * Min heap -> Objects of class PositionMH 
 * Positon MH :
 * Value  - priorit element 
 * Position of array 
 * Position of value in array 
 * 
 * For value 
 * 
 * 10,20 - pos 0  value 10,20  pos of val : 0,1
 * 5,15  - pos 1  value  5,15  pos of val : 0,1
 * 4,9,11- pos 2  value 4,9,11 pos of val : 0,1,2
 * 
 * For inserting 9 :
 * value : 9 
 * position of array : 2
 * Pos of value : 1
 * 
 * 
 * Initially heap will have first of every element 
 * Heap arr K -> 10,5,4
 * (value,pos,pos of arr)
 * 
 * START Loop :
 * 
 * Extract minimum :
 *  get 4 , make the heap as 9,1,2
 *  Heapify
 * Build heap ->(5,0,1),(9,1,2),(10,0,0)
 * 
 * Extract minimum :
 *  get 5 , make the pointer to next array 
 *  Build heap ->(15,1,1),(9,1,2),(10,0,0)
 * 
 * Extract minimum :
 *  get 9 , make the pointer to next array 
 *  Build heap ->(15,1,1),(11,2,2),(10,0,0)
 * 
 * Extract minimum :
 *  get 10 , make the pointer to next array 
 *  Build heap ->(15,1,1),(11,2,2),(20,1,0)
 * 
 * Extract minimum :
 *  get 11 , make the pointer to next array 
 *  Build heap ->(15,1,1),(XX,3,2),(20,1,0)
 *  
 * When all the elements are used in PositionMH
 * Reduce the minHeap 
 * 
 * Extract minimum :
 *  get 15 , make the pointer to next array 
 *  Build heap ->(XX,2,1),(20,1,0)
 *  
 *  When all the elements are used in PositionMH
 *  Remove from the minHeap 
 * 
 * Extract minimum :
 *  get 20 , make the pointer to next array 
 *  Build heap ->(XX,2,0)
 * 
 *  When all the elements are used in PositionMH
 *  Remove from the minHeap 
 *  
 *  No elements in min heap --> END LOOP 
 * 
 * 
 * 
 * @author shree
 *
 */

class PositionMH{    //Comparator 
	ArrayList<Integer> arr;
	int pos;
	int arraypos;
	int size;
	int value;
	
	PositionMH(int i,ArrayList<Integer> arrayList){
		this.arr=arrayList;
		pos=0;
		arraypos=i;
		size=arrayList.size();
		value=arrayList.get(0);
	}
	
	boolean update() {
		pos++;
		if(pos>=size) {
			return false;
		}
		value=arr.get(pos);
		return true;
	}
	
}

class ComparaePositionH implements Comparator<PositionMH>{
	
	public int compare(PositionMH a,PositionMH b) {
		return a.value-b.value;
	}
}

class PositionMHC implements Comparable<PositionMHC>{
	ArrayList<Integer> arr;
	int pos;
	int arraypos;
	int size;
	int value;
	
	PositionMHC(int i,ArrayList<Integer> arrayList){
		this.arr=arrayList;
		pos=0;
		arraypos=i;
		size=arrayList.size();
		value=arrayList.get(0);
	}
	
	boolean update() {
		pos++;
		if(pos>=size) {
			return false;
		}
		value=arr.get(pos);
		return true;
	}
	
	public int compareTo(PositionMHC a) {
		
		if(this.value<=a.value) {
			return -1;
		}
		return 1;
	}
	
}

public class Heap07_Merge_K_Sorted {

	public static void main(String[] args) {
		// Merge K sorted 
		
		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        Scanner sc=new Scanner(System.in);
		for(int i=0;i<3;i++) {
			System.out.println(" Give count of elements 5");
			int c=5;
			arr.add(new ArrayList<>(c));
			System.out.println(" Give elements ");
			String[] s=sc.nextLine().trim().split(" ");
			for(int j=0;j<c;j++) {
				arr.get(i).add(Integer.parseInt(s[j]));
			}
		}
		sc.close();
		
		// Arr has input 
		int k=3;
		System.out.println(" Naive method two pointer ");
		MergeTwoPointer(arr,k);
		
		// With comparator 
		System.out.println("Min Heap+comparator");
		MergeKSortedPosMH(arr,k);
		
		//with comparable
		System.out.println("Min Heap+ comparable");
		MergeKSortedPosMHC(arr,k);
		
		
	}

	private static void MergeKSortedPosMHC(ArrayList<ArrayList<Integer>> arr, int k) {
		// using comparable 
		
		   System.out.println(" Unmerged "+arr.toString());
		   ArrayList<Integer> result=new ArrayList<>();
		   
		   //Pq with comparable - no need to modify anything 
		   PriorityQueue<PositionMHC> pq=new PriorityQueue<>();
		    
		   for(int i=0;i<k;i++) {
			   pq.add(new PositionMHC(i,arr.get(i)));
		   }
		   
		   //Loop start 
		   PositionMHC curr=null;
		   while(pq.isEmpty()==false) {
			   //extract object 
			   curr=pq.poll();
			   //Add value 
			   result.add(curr.value);
			   boolean NoRemove=curr.update();//Updating value 
			   if(NoRemove) {
				   pq.add(curr);
			   }
			   
		   }
			
		   System.out.println(" Merged "+result);
		
	}

	private static void MergeKSortedPosMH(ArrayList<ArrayList<Integer>> arr, int k) {
		// using comparator 
		
	   System.out.println(" Unmerged "+arr.toString());
	   ArrayList<Integer> result=new ArrayList<>();
	   
	   //Pq with comparator 
	   PriorityQueue<PositionMH> pq=new PriorityQueue<>(new ComparaePositionH());
	   
	   /**
	    * 
	    * 		     PriorityQueue<PositionMH> pq1=new PriorityQueue<>(new 
		    		 Comparable<PositionMH>() {
		    	 public int compareTo(PositionMH a){
		    		 if(value<=a.value) {
		    			 return -1;
		    		 }
		    		 else {
		    			 return 1;
		    		 }
		    	 }
			});
 
	    * 
	    */
	   for(int i=0;i<k;i++) {
		   pq.add(new PositionMH(i,arr.get(i)));
	   }
	   
	   //Loop start 
	   PositionMH curr=null;
	   while(pq.isEmpty()==false) {
		   //extract object 
		   curr=pq.poll();
		   //Add value 
		   result.add(curr.value);
		   boolean NoRemove=curr.update();//Updating value 
		   if(NoRemove) {
			   pq.add(curr);
		   }
		   
	   }
		
	   System.out.println(" Merged "+result);
	}

	private static void MergeTwoPointer(ArrayList<ArrayList<Integer>> arr, int k) {
		// Array to merge 
		System.out.println(" Unmerged "+arr.toString());
		ArrayList<Integer> res=arr.get(0);
		
		for(int i=1;i<k;i++) {
		res=TwoPointer(res,arr.get(i));
		}
		System.out.println(" Merged "+res);
	}

	private static ArrayList<Integer> TwoPointer(ArrayList<Integer> res, ArrayList<Integer> arr) {
		//two pointer merge 
		ArrayList<Integer> curr=new ArrayList<>();
		int a=res.size();
		int b=arr.size();
		int i=0;int j=0;
		while(i<a && j<b) {
			if(res.get(i)<arr.get(j)) {
				curr.add(res.get(i));
				i++;
			}
			else {
				curr.add(arr.get(j));
				j++;
			}
			
			
		}
		
		while(i<a) {
			curr.add(res.get(i));
			i++;
		}
		while(j<b) {
			curr.add(arr.get(j));
			j++;
		}
		return curr;
	}

}

/*
 * 
 * Merge K Sorted Arrays

Given k sorted arrays of possibly different sizes, merge them and print the sorted output.
Examples: 

Input: k = 3 
      arr[][] = { {1, 3},
                  {2, 4, 6},
                  {0, 9, 10, 11}} ;
Output: 0 1 2 3 4 6 9 10 11 

Input: k = 2
      arr[][] = { {1, 3, 20},
                  {2, 4, 6}} ;
Output: 1 2 3 4 6 20 

A simple solution is to create an output array and one by one copy all k arrays to it. Finally, sort the output array. This approach takes O(N Log N) time where N is the count of all elements.
An efficient solution is to use a heap data structure. The time complexity of the heap-based solution is O(N Log k).
1. Create an output array. 
2. Create a min-heap of size k and insert 1st element in all the arrays into the heap 
3. Repeat the following steps while the priority queue is not empty. 
.....a) Remove the minimum element from the heap (minimum is always at the root) and store it in the output array. 
.....b) Insert the next element from the array from which the element is extracted. If the array doesn’t have any more elements, then do nothing.

Below is the implementation of the above approach:

/*package whatever //do not write package name here *

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    private static class HeapNode
        implements Comparable<HeapNode> {
        int x;
        int y;
        int value;

        HeapNode(int x, int y, int value)
        {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override public int compareTo(HeapNode hn)
        {
            if (this.value <= hn.value) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }

    // Function to merge k sorted arrays.
    public static ArrayList<Integer>
    mergeKArrays(int[][] arr, int K)
    {
        ArrayList<Integer> result
            = new ArrayList<Integer>();
        PriorityQueue<HeapNode> heap
            = new PriorityQueue<HeapNode>();

        // Initially add only first column of elements. First
        // element of every array
        for (int i = 0; i < arr.length; i++) {
            heap.add(new HeapNode(i, 0, arr[i][0]));
        }

        HeapNode curr = null;
        while (!heap.isEmpty()) {
            curr = heap.poll();
            result.add(curr.value);

            // Check if next element of curr min exists,
            // then add that to heap.
            if (curr.y < (arr[curr.x].length - 1)) {
                heap.add(
                    new HeapNode(curr.x, curr.y + 1,
                                 arr[curr.x][curr.y + 1]));
            }
        }

        return result;
    }

    public static void main(String[] args)
    {

        int[][] arr = { { 2, 6, 12 },
                            { 1, 9 },
                            { 23, 34, 90, 2000 } };
        System.out.println(
            MergeKSortedArrays.mergeKArrays(arr, arr.length)
                .toString());
    }
}
// This code has been contributed by Manjunatha KB

Output
Merged array is 
1 2 6 9 12 23 34 90 2000 
Time Complexity: O(N Log k)
Auxiliary Space: O(N)


 * 
 */
