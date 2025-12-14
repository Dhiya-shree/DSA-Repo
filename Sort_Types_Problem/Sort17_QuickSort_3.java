
package Sort_Types_Problem;

import arrayCode.ArrayPart01;

/**
 *  Hoare Partition - Quick sort 
 *  ( 2 pointer Lomato )
 *  
 *  Lomato is better , Lomato reposition the pivot in middle 
 *  Hoare do not swap the pivot to mid 
 *  
 *  Lomato ensure that all element from 0 tp pivot-1 are lesser 
 *  And all elements in pivot+1 to high are greater 
 *  
 *  Hooare ensure all element from 0 to pivot-1 are smaller 
 *  All elements from pivot to high can be EQUAL / HIGHER than pivot 
 *  1 Traversal and O 1 space 
 *  
 *  
 *  Hoare partition do not gurantee , the fix of particular pivot element 
 *  Hoare has less comparison 
 *  
 *  NAIVE partition 
 *      ----is stable
 *      ---- require 3 traversal and O n space
 *      ---- Fix the pivot 
 *      
 *  Lomato partition 
 *      ----is UNstable
 *      ---- require 1 traversal and O 1 space
 *      ---- Fix the pivot     
 *  
 *  Hoare partition 
 *      ----is Unstable
 *      ---- require 1 traversal , O 1 space - very less comparison 
 *      ---- DO NOT Fix the pivot   
 *  
 *  // All elements are EQUAL 
	//  Swapping happens many times 
	// Even if same pos change , so not stable 
	 * 
	 * 
 *  Consider 1st element as pivot element 
 *  
 * Hoare's Partition 

Hoare’s Partition Scheme works by initializing two indexes that start at two ends, the two indexes move toward each other until an inversion is (A smaller value on the left side and a greater value on the right side) found. When an inversion is found, two values are swapped and the process is repeated.

Algorithm: 

Hoarepartition(arr[], lo, hi)

   pivot = arr[lo]
   i = lo - 1  // Initialize left index
   j = hi + 1  // Initialize right index

   // Find a value in left side greater
   // than pivot
   do
      i = i + 1
   while arr[i] < pivot

   // Find a value in right side smaller
   // than pivot
   do
      j--;
   while (arr[j] > pivot);

   if i >= j then 
      return j

   swap arr[i] with arr[j]


   
QuickSort(arr[], l,  r)

If r > l
     1. Find the partition point of the array  
              m =Hoarepartition(a,l,r) 
     2. Call Quicksort for less than partition point   
             Call Quicksort(arr, l, m)
     3. Call Quicksort for greater than the partition point 
             Call Quicksort(arr, m+1, r)
 * 
 * 
 * @author shree
 *
 */
public class Sort17_QuickSort_3 {

public static void main(String[] args) {
		
		int arr[]= {5,13,6,9,12,11,8};
		// Expected o/p - 5 6 | 8 | 9  12 11 13
		//int partion_index=6;
		int n=arr.length;
		
		// Take partition as 1st elemet 
		int ans= HoarePartition(arr,0,n-1);
		
		System.out.println(" Sorted array "+ans);
		ArrayPart01.PrintRayy(arr);
		int sol[]= quicksortHoare(arr,0,n-1);
		System.out.println(" Sorted array ");
		ArrayPart01.PrintRayy(sol);
		
		ArrayPart01.PrintRayy(arr);
		int arr2[]= {5,13,6,9,12,11,8};
		// Expected o/p - 5 6 | 8 | 9  12 11 13
		//int partion_index=6;
		int n2=arr2.length;
		sol= quicksortHoareGoG(arr2,0,n2-1);
		System.out.println(" Sorted array ");
		ArrayPart01.PrintRayy(sol);
		ArrayPart01.PrintRayy(arr2);
		
}

private static int[] quicksortHoare(int[] arr, int low, int high) {
	// Hoare 
	
	if(low<high) {
		int pivot_pos=HoarePartition(arr,low,high);
		quicksortHoare(arr,low,pivot_pos-1);
		quicksortHoare(arr,pivot_pos+1,high);
	}
	return arr;
}

private static int HoarePartition(int[] arr, int low, int high) {
	// Begin at last , go left j 
	// I begin with 0 and go right 
	// On traversing from j , if you see element less than pivot 
	// Swap with element in I side greater than pivot 
	// If right is Big than pivot , simply i++
	// If left is small than pivot , No swap 
	// If left is high than pivot swap 
	
	int left=low;
	int right=high; // High is given as arr.length-1
	int pivot=arr[low];
	int swap=0;
	while(left<right) {
		
		while(arr[left]<pivot) {
		    left++;
		}
		while(arr[right]>pivot) {
		    right--;
		}
		
		swap=arr[right];
		arr[right]=arr[left];
		arr[left]=swap;
	//	left++;
		//right--;
		
	}
	System.out.println("Pivot "+pivot+" Left "+left);
//	When pivot is smallest of all , pivot position , i=0, j=1
//  When pivot is largest , then i= n-2 and j =n-1
// All elements are EQUAL 
	//  Swapping happens many times 
	// Even if same pos change , so not stable 
	System.out.println(" Hoareee");
	ArrayPart01.PrintRayy(arr);
	return left;
}

//This function takes first element as pivot, and
// places all the elements smaller than the pivot on the
// left side and all the elements greater than the pivot
// on the right side. It returns the index of the last
// element on the smaller side
static int partition(int[] arr, int low, int high)
{
    int pivot = arr[low];
    int i = low - 1, j = high + 1;

    while (true)
    {
        // Find leftmost element greater
        // than or equal to pivot
        do {
            i++;
        } while (arr[i] < pivot);

        // Find rightmost element smaller
        // than or equal to pivot
        do {
            j--;
        } while (arr[j] > pivot);

        // If two pointers met.
        if (i >= j)
            return j;
      
        // swap(arr[i], arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}

// The main function that
// implements QuickSort
// arr[] --> Array to be sorted,
// low --> Starting index,
// high --> Ending index 
static int[] quicksortHoareGoG(int[] arr, int low, int high)
{
    if (low < high) {
      
        // pi is partitioning index,
        // arr[p] is now at right place 
        int pi = partition(arr, low, high);

        // Separately sort elements before
        // partition and after partition
        quicksortHoareGoG(arr, low, pi);
        quicksortHoareGoG(arr, pi + 1, high);
    }
    return arr;
}

}

/**
 * 
 * Quicksort is a Divide and Conquer Algorithm that is used for sorting the elements. In this algorithm, we choose a pivot and partitions the given array according to the pivot. Quicksort algorithm is a mostly used algorithm because this algorithm is cache-friendly and performs in-place sorting of the elements means no extra space requires for sorting the elements.

Note:

Quicksort algorithm is generally unstable algorithm because quick sort cannot be able to maintain the relative 
order of the elements.

Three partitions are possible for the Quicksort algorithm:

Naive partition: In this partition helps to maintain the relative order of the elements but this partition takes O(n) extra space.
Lomuto partition: In this partition, The last element chooses as a pivot in this partition. The pivot acquires its required position after partition but more comparison takes place in this partition.
Hoare's partition: In this partition, The first element chooses as a pivot in this partition. The pivot displaces its required position after partition but less comparison takes place as compared to the Lomuto partition.
Hoare's Partition 

Hoare’s Partition Scheme works by initializing two indexes that start at two ends, the two indexes move toward each other until an inversion is (A smaller value on the left side and a greater value on the right side) found. When an inversion is found, two values are swapped and the process is repeated.

Algorithm: 

Hoarepartition(arr[], lo, hi)

   pivot = arr[lo]
   i = lo - 1  // Initialize left index
   j = hi + 1  // Initialize right index

   // Find a value in left side greater
   // than pivot
   do
      i = i + 1
   while arr[i] < pivot

   // Find a value in right side smaller
   // than pivot
   do
      j--;
   while (arr[j] > pivot);

   if i >= j then 
      return j

   swap arr[i] with arr[j]


   
QuickSort(arr[], l,  r)

If r > l
     1. Find the partition point of the array  
              m =Hoarepartition(a,l,r) 
     2. Call Quicksort for less than partition point   
             Call Quicksort(arr, l, m)
     3. Call Quicksort for greater than the partition point 
             Call Quicksort(arr, m+1, r)

 

// Java implementation of QuickSort
// using Hoare's partition scheme

import java.io.*;

class GFG {

    // This function takes first element as pivot, and
    // places all the elements smaller than the pivot on the
    // left side and all the elements greater than the pivot
    // on the right side. It returns the index of the last
    // element on the smaller side
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;

        while (true)
        {
            // Find leftmost element greater
            // than or equal to pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Find rightmost element smaller
            // than or equal to pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If two pointers met.
            if (i >= j)
                return j;
          
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
        }
    }

    // The main function that
    // implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index 
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
          
            // pi is partitioning index,
            // arr[p] is now at right place 
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to print an array 
    static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(" " + arr[i]);
      
        System.out.println();
    }

    // Driver Code
    static public void main(String[] args)
    {
        int[] arr = { 10, 17, 18, 9, 11, 15 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);

        printArray(arr, n);
    }
}

 


Output
 9 10 11 15 17 18
 */
