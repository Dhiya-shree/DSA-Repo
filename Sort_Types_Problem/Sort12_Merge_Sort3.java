package Sort_Types_Problem;

import arrayCode.ArrayPart01;

/**
 * 
 * MERGE SORT Algorithm 
 * 
 * l - left 0
 * r - right n-1
 * 
 * No of elements must be at least 2 for merge sort 
 * 
 * Ending clause - at least 2 element 
 * r>l merge sort , else stop
 * 
 * Algo: for arr - 10,5,30,15,7
 * Check if two element is preset r 4 >l 0
 * 
 * Find mid point = l+ (r-l)/2; // L + is given to avoid overflow
 * If L+R / 2 is given and if both are large , There might be array overflow 
 * So mid = L +( L+R)/2 is given , to avoid overflow
 * mid= 0+4/2 +0 ; mid = 2
 * 
 * Sort the array into 3 parts 
 * 
 * 1) Recursive mergesort of low to mid 
 * 2) Recursive mergesort of mid to right 
 * 
 * 3)  Recursive MERGE_FINAL of low,mid,high
 * 
 *  Consider (....) => MERGE_FINAL output
 * For                      10,5,30,15,7 (5,7,10,15,30)
 *          (5,10,30)10,5,30               15,7(7,15)
 *       (5,10)10,5        30(30)        15     7
 *       10       5      stop           stop    stop
 *     stop      stop  
 * 
 * @author shree
 *
 */
public class Sort12_Merge_Sort3 {

	static int arr[]= {1,3,4,5,7,10,0,2,6,8,9};
	public static void main(String[] args) {
		
		//int arr[]= {1,3,4,5,7,10,0,2,6,8,9};
		int n=arr.length;
		MergeSortAlgo(arr,0,n-1);
		
		ArrayPart01.PrintRayy(arr);
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
 * Merge Sort is a Divide and Conquer algorithm. It divides the input array in two halves, calls itself for the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one in a sorted manner. See following implementation for details:

 

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)


The following diagram from wikipedia shows the complete merge sort process for an example array {38, 27, 43, 3, 9, 82, 10}. If we take a closer look at the diagram, we can see that the array is recursively divided in two halves till the size becomes 1. Once the size becomes 1, the merge processes comes into action and starts merging arrays back till the complete array is merged


* Java program for Merge Sort *
class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays *
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays *
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any *
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
       / /* Copy remaining elements of R[] if any *
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
    /* A utility function to print array of size n 
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 * 
 * Time Complexity: Sorting arrays on different machines. Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation. 
T(n) = 2T(n/2) + Θ(n)
The above recurrence can be solved either using Recurrence Tree method or Master method. It falls in case II of Master Method and solution of the recurrence is Θ(nLogn). 

Time complexity of Merge Sort is Θ(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array in two halves and take linear time to merge two halves.

Auxiliary Space: O(n)
 */
