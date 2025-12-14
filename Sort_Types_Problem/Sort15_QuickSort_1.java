package Sort_Types_Problem;

import arrayCode.ArrayPart01;

/**
 * Quick sort -Partition 
 * 
 * Partition function :
 * 
 * Given an unsorted array and an index 
 *  The index value must be partition it in such a way that 
 *  It divides into array > val and array<val 
 *  
 *  There are three methods for partition , so index val will break array to two pieces 
 *     1)Naive 
 *     2)Lomuto 
 *     3)Hoare 
 *  
 *  
 *  Quicksort is a Divide and Conquer Algorithm that is used for sorting the elements. In this algorithm, we choose a pivot and partitions the given array according to the pivot. Quicksort algorithm is a mostly used algorithm because this algorithm is cache-friendly and performs in-place sorting of the elements means no extra space requires for sorting the elements.
 * 
 * Note
 * 
 * 
 * 
 * Quicksort algorithm is generally unstable algorithm because quick sort cannot be able to maintain the relative 
 * order of the elements.
 * 
 * Three partitions are possible for the Quicksort algorithm:
 * 
 * Naive partition: In this partition helps to maintain the relative order of the elements but this partition takes O(n) extra space.
 *  O n + O n space - 3 traversal 
 * Lomuto partition: In this partition, The last element chooses as a pivot in this partition. The pivot acquires its required position after partition but more comparison takes place in this partition.
 *  O n + O 1 space - 1 traversal 
 * Hoare's partition: In this partition, The first element chooses as a pivot in this partition. The pivot displaces its required position after partition but less comparison takes place as compared to the Lomuto partition.
 
 *  
 *  NAIVE PARITION FUCTION :
 *  
 *  To partition a array based on a given pivot 
 *  
 *  1.  Naive partition

Algorithm:

Naivepartition(arr[],l,r)

1. Make a Temporary array temp[r-l+1] length
2. Choose last element as a pivot element
3. Run two loops:
    -> Store all the elements in the temp array that are less than pivot element
    -> Store the pivot element 
    -> Store all the elements in the temp array that are greater than pivot element.
4.Update all the elements of arr[] with the temp[] array    


QuickSort(arr[], l,  r)


If r > l
     1. Find the partition point of the array  
              m = Naivepartition(a,l,r) 
     2. Call Quicksort for less than partition point   
             Call Quicksort(arr, l, m-1)
     3. Call Quicksort for greater than the partition point 
             Call Quicksort(arr, m+1, r)
 *  
 *  
 * @author shree
 *
 */
public class Sort15_QuickSort_1 {
	
	public static void main(String[] args) {
		
		int arr[]= {5,13,6,9,12,11,8};
		// Expected o/p - 5 6 | 8 | 9  12 11 13
		int partion_index=6;
		int n=arr.length;
		
		int ans= NaivePartition(arr,partion_index,0,n-1);
		System.out.println(" Sorted array "+ans);
		

		int sol[]= quicksortNaive(arr,0,n-1);
		System.out.println(" Sorted array ");
		ArrayPart01.PrintRayy(sol);
		
		int arr2[]= {5,13,6,9,12,11,8};
		// Expected o/p - 5 6 | 8 | 9  12 11 13
		//int partion_index=6;
		int n2=arr2.length;
		sol= quicksortNaiveGOG(arr,0,n2-1);
		System.out.println(" Sorted array ");
		ArrayPart01.PrintRayy(sol);
		
		
	}

	static int partition(int a[], int start, int high)
	    {
	        // Creating temporary
	        int temp[] = new int[(high - start) + 1];

	        // Choosing a pivot
	        int pivot = a[high];
	        int index = 0;
	      
	        // smaller number
	        for (int i = start; i <= high; ++i) {
	            if (a[i] < pivot)
	            {
	                temp[index++] = a[i];
	            }
	        }
	      
	        // pivot position
	        int position = index;
	      
	        // Placing the pivot to its original position
	        temp[index++] = pivot;
	      
	        for (int i = start; i <= high; ++i) 
	        {
	            if (a[i] > pivot)
	            {
	                temp[index++] = a[i];
	            }
	        }

	        // Change the original array
	        for (int i = start; i <= high; ++i) {
	            a[i] = temp[i - start];
	        }
	      
	        // return the position of the pivot
	        return position;
	    }

	private static int[] quicksortNaiveGOG(int[] numbers, int start, int end) {
	        if (start < end) {
	            int point = partition(numbers, start, end);

	            quicksortNaiveGOG(numbers, start, point - 1);
	            quicksortNaiveGOG(numbers, point + 1, end);
	        }
			return numbers;
	    }
	  
//	    // Function to print the array
//	    static void print(int numbers[])
//	    {
//	        for (int a : numbers)
//	        {
//	            System.out.print(a + " ");
//	        }
//	    }

	static int[] quicksortNaive(int numbers[], int start, int end)
    {
        if (start < end) {
        	// Passing partition index as last elemenst 
            int point = NaivePartition(numbers, end,start, end);

            quicksortNaive(numbers, start, point - 1);
            quicksortNaive(numbers, point + 1, end);
        }
        return numbers;
    }
	private static int NaivePartition(int[] arr, int partion_index, int low, int high) {
		// naive partition based on given index 
		int temp[]=new int[high-low+1];
		int index=0;
		// Copy the small elemesnts than partition in temp array 
		
		for(int i=low;i<=high;i++) {
			if( arr[i]<= arr[partion_index]) {
				temp[index]=arr[i];
				index++;
			}
		}
		
		// Copy the bigger elemesnts than partition in temp array 
		
				for(int i=low;i<=high;i++) {
					if( arr[i]> arr[partion_index]) {
						temp[index]=arr[i];
						index++;
					}
				}
		
	     // Temp has necessay changes -> bring it into the body of arr 
				for(int i=0;i<=high;i++) {
					arr[i]=temp[i];
				}
		return partion_index;
	}
}
/*
 * 1.  Naive partition

Algorithm:

Naivepartition(arr[],l,r)

1. Make a Temporary array temp[r-l+1] length
2. Choose last element as a pivot element
3. Run two loops:
    -> Store all the elements in the temp array that are less than pivot element
    -> Store the pivot element 
    -> Store all the elements in the temp array that are greater than pivot element.
4.Update all the elements of arr[] with the temp[] array    


QuickSort(arr[], l,  r)


If r > l
     1. Find the partition point of the array  
              m = Naivepartition(a,l,r) 
     2. Call Quicksort for less than partition point   
             Call Quicksort(arr, l, m-1)
     3. Call Quicksort for greater than the partition point 
             Call Quicksort(arr, m+1, r)

 

// Java program to demonstrate the naive partition
// in quick sort

import java.io.*;
import java.util.*;
public class GFG {
    static int partition(int a[], int start, int high)
    {
        // Creating temporary
        int temp[] = new int[(high - start) + 1];

        // Choosing a pivot
        int pivot = a[high];
        int index = 0;
      
        // smaller number
        for (int i = start; i <= high; ++i) {
            if (a[i] < pivot)
            {
                temp[index++] = a[i];
            }
        }
      
        // pivot position
        int position = index;
      
        // Placing the pivot to its original position
        temp[index++] = pivot;
      
        for (int i = start; i <= high; ++i) 
        {
            if (a[i] > pivot)
            {
                temp[index++] = a[i];
            }
        }

        // Change the original array
        for (int i = start; i <= high; ++i) {
            a[i] = temp[i - start];
        }
      
        // return the position of the pivot
        return position;
    }

    static void quicksort(int numbers[], int start, int end)
    {
        if (start < end) {
            int point = partition(numbers, start, end);

            quicksort(numbers, start, point - 1);
            quicksort(numbers, point + 1, end);
        }
    }
  
    // Function to print the array
    static void print(int numbers[])
    {
        for (int a : numbers)
        {
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args)
    {
        int numbers[] = { 3, 2, 1, 78, 9798, 97 };
      
        // rearrange using naive partition
        quicksort(numbers, 0, numbers.length - 1);
      
        print(numbers);
    }
}

 


Output
1 2 3 78 97 9798 

 * 
 */
