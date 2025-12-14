package Sort_Types_Problem;

import java.util.Arrays;

import arrayCode.ArrayPart01;
//////////////////                            888888888888888 MAARRRKK!!!!!!!11111

/**
 * MERGE SORTED ARRAY without space   ---------------------------- 8 MARK !!!!!!!!!!!!!!!!!!!
 * To merge the arrays in-place without extra spaces, we can start from the end of arr1 and the beginning of arr2.
 *  We compare the elements at these positions and swap them if necessary. 
 *  By repeatedly doing this, we ensure that the larger elements are moved to the end of arr1 and the smaller 
 *  elements are moved to the beginning of arr2. 
 * Finally, we sort both arrays to obtain the merged sorted order
 * 
 *  * Algo: for arr - 10,5,30,15,7
 * Check if two element is preset r 4 >l 0
 * 
 * Find mid point = l+ (r-l)/2; // L + is given to avoid overflow
 * If L+R / 2 is given and if both are large , There might be array overflow 
 * So mid = L +( L+R)/2 is given , to avoid overflow
 * mid= 0+4/2 +0 ; mid = 2
 * 
 * Sort the array into 3 parts 
 * 
 * 1) Recursive mergesort of low to mid  O n/2
 * 2) Recursive mergesort of mid to right  O n/2
 * 
 * 3)  Recursive MERGE_FINAL of low,mid,high O n 
 * 
 *  Consider (....) => MERGE_FINAL output
 * For                      10,5,30,15,7 (5,7,10,15,30) (On)
 *          (5,10,30)10,5,30               15,7(7,15) (On) 
 *       (5,10)10,5        30(30)        15     7       (O n )
 *       10       5      stop           stop    stop
 * 
 * 
 * Merge_Final O n at each level 
 *  No of level based on N 
 *  Total Merge Final - x+ O n
 *  x - Log base 2(N)
 *  if n is odd : X log base 2 (N) +1 / ceil of LOgN
 *  
 * Total time : N O log N 
 * 
 * Auxillary Space : O n 
 * Even if we have many level and many left and right element are there 
 * Space allocate is reallocate and deallocate 
 * In memory It will always require O n of space 
 * 
 * Solution of the drawback for additional storage:
Use linked list. 
 * 
 *  Adv.Merge sort work in O 1 space 
 * @author shree
 *
 */
public class Sort13_Merge_Sort4_Analysis {

	public static void main(String[] args) {
		/*
		 * Analysis of Merge Sort:
A merge sort consists of several passes over the input. The first pass merges segments of size 1, the second merges segments of size 2, and thei_{th}    pass merges segments of size 2i-1. Thus, the total number of passes is [log2n]. As merge showed, we can merge two sorted segments in linear time, which means that each pass takes O(n) time. Since there are [log2n] passes, the total computing time is O(nlogn).

Applications of Merge Sort: 
Merge Sort is useful for sorting linked lists in O(N log N) time. In the case of linked lists, the case is different mainly due to the difference in memory allocation of arrays and linked lists. Unlike arrays, linked list nodes may not be adjacent in memory. Unlike an array, in the linked list, we can insert items in the middle in O(1) extra space and O(1) time. Therefore, the merge operation of merge sort can be implemented without extra space for linked lists.
In arrays, we can do random access as elements are contiguous in memory. Let us say we have an integer (4-byte) array A and let the address of A[0] be x then to access A[i], we can directly access the memory at (x + i*4). Unlike arrays, we can not do random access in the linked list. Quick Sort requires a lot of this kind of access. In a linked list to access i’th index, we have to travel each and every node from the head to i’th node as we don’t have a contiguous block of memory. Therefore, the overhead increases for quicksort. Merge sort accesses data sequentially and the need of random access is low.
Inversion Count Problem
Used in External Sorting
Advantages of Merge Sort:
Merge sort has a time complexity of O(n log n), which means it is relatively efficient for sorting large datasets.
Merge sort is a stable sort, which means that the order of elements with equal values is preserved during the sort.
It is easy to implement thus making it a good choice for many applications.
It is useful for external sorting. This is because merge sort can handle large datasets, it is often used for external sorting, where the data being sorted does not fit in memory.
The merge sort algorithm can be easily parallelized, which means it can take advantage of multiple processors or cores to sort the data more quickly.
Merge sort requires relatively few additional resources (such as memory) to perform the sort. This makes it a good choice for systems with limited resources.
Drawbacks of Merge Sort:
Slower compared to the other sort algorithms for smaller tasks. Although effecient for large datasets its not the best choice for small datasets.
The merge sort algorithm requires an additional memory space of 0(n) for the temporary array. This is to store the subarrays that are used during the sorting process.
It goes through the whole process even if the array is sorted.
It requires more code to implement since we are dividing the array into smaller subarrays and then merging the sorted subarrays back together.
Recent Articles on Merge Sort
Coding practice for sorting.
Quiz on Merge Sort
Solution of the drawback for additional storage:
Use linked list. 
		 */
		
		
		int arrOne[]= {1,2,3,4,11,13,16,18,19,20};
		int arrTwo[]= {5,7,8,9,10};
		int ans[]=MergeSortedArrayFunc (arrOne,arrTwo);
		
		ArrayPart01.PrintRayy(ans);
		
		//ans=MergeSortedArrayNOTOptimized(arr,arr2);
	}


	private static int[] MergeSortedArrayFunc(int[] arr1, int[] arr2) {
		// Efficient M+n  
		 // we are basically working on the logic 
		 // that we will first make sure that all elemnts that must be in arr1 get in arr1 and that in arr2 in arr2
		 // we use two pointer approach
		          
		          int n=arr1.length;
		          int m=arr2.length;
		        //  int temp=0;
		        int i = n - 1;// intialize from last so we can comapre from last and if there is no swap we can break
		        int j = 0;//point of comparsion
		        
		        while (i >= 0 && j < m) {
		            if (arr1[i] > arr2[j]) {// it states that arr1[i] should be in arr[2];
		                int temp = arr1[i];// so swap them 
		                arr1[i] = arr2[j];
		                arr2[j] = temp;
		                i--;
		                j++;
		            } else {// if no more exists break
		                break; // No more swaps needed
		            }
		        }
		        
		        // Sort both arrays after the loop 
		        Arrays.sort(arr1);
		        Arrays.sort(arr2);

		System.out.println(" Arr 1");
		ArrayPart01.PrintRayy(arr1);
		System.out.println(" Arr 2");
		ArrayPart01.PrintRayy(arr2);
		return arr2;
	}

}
