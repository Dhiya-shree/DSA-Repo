package searchSortCode;

import arrayCode.ArrayPart01;

/**
 * 
 * Sorting any sequence means to arrange the elements of that sequence according to some specific criterion.
 * For Example, the array arr[] = {5, 4, 2, 1, 3} after sorting in increasing order will be: arr[] = {1, 2, 3, 4, 5}. The same array after sorting in descending order will be: arr[] = {5, 4, 3, 2, 1}.
 *  
 * 
 * Better time O nlogn 
 * General purpose sorting Algo :
 * NLogN time :
 *  Divide And COnquer :-> parallel sorting 
 *    Merge Sort - stable - best for linked list - extra space needed becomes O 1 - best for external sorting
 *    Quick Sort - fastest of all
 *  ......:
 *    Heap Sort - Not possible 
 *    
 * Hybrid Sort :--> Used in library - mix of some sorta
 * 1) Tim Sort - python : insertion sort(small array) + merge sort 
 * 2) Intra sort - C++ O n logN  : quick(start with quick sort , if number of recursion > log n and unfair partition --> switch to heap sort ) 
 *                     + heap + insertion(small array)
 * 
 * Library general purpose sort - used in C++:
 *  3) Stable sort - merge sort 
 * 
 * 
 * Different algo to use for special cases
 * 
 * 1) Binary Array (0,1) - Quick sort - Partition method ( Lomato , Hoare , naive(stable but slow , require space))
 * 2) Array with three value (0,1,2 ) or sorting array with range , element occur multiple times ,
 *           sorting array into less than n , n , high than n 
 *       - Quick sort 
 * 3)Array of size n and small ranged values - Counting sort ( O n , max of element<N)
 * 4)Array of size n and range of size n2 or n3 or closer ...
 *           - radix Sort ( O n , O n+K for higher values )
 * 5) Array of uniformly distributed data over a range 
 *          - Bucket sort ( for uniform distributed data - fastest )
 * 6) When memory writes are costly ex EEPROM
 *         - Selection Sort ( O n2)
 *         - Cycle sort (O n2 , optimal memory write)
 * 7) When adjacent swap are allowed 
 *        - Bubble sort (traverse left to right )
 *        - Cocktail sort ( adv.bubble traverse both side)
 * 8) When array is small 
 *        - Selection sort 
 *        - Insertion sort ( best for small , n:10-20)( Internal compiler swirch if n is small)
 * 9) When available extra memory is small 
 *        - Shell sort - No extra space at all
 *        - O( n (log N)2) and O 1 space
 *         
 * 
 * @author shree
 *
 */
public class Sort01_Intro {

	/*
	 *  * In-Place Sorting: An in-place sorting algorithm uses constant extra space for producing the output
     *  (modifies the given array only).
     * It sorts the list only by modifying the order of the elements within the list.
	 * 
	 * Three of such in-place sorting algorithms, namely:
	 *   Insertion Sort
	 *   Selection Sort
	 *   Bubble Sort
	 *   
	 *   
	 */
	public static void main(String[] args) {
		
		int arr[]= {2,1,4,3,5,6,7,8,9,0,10};
		int n=arr.length;
		int arr1[]= {2,1,4,3,5,6,7,8,9,0,10};
		int n1=arr.length;
		int arr2[]= {2,1,4,3,5,6,7,8,9,0,10};
		int n2=arr.length;
		int arr3[]= {2,1,4,3,5,6,7,8,9,0,10};
		int n3=arr.length;
		
		/**
		 * Insertion Sort
		 * 
		 * Insertion Sort is an In-Place sorting algorithm. This algorithm works in a
		 * similar way of sorting a deck of playing cards. The idea is to start
		 * iterating from the second element of array till last element and for every
		 * element insert at its correct position in the subarray before it. In the
		 * below image you can see, how the array [4, 3, 2, 10, 12, 1, 5, 6] is being
		 * sorted in increasing order following the insertion sort algorithm.
		 * img:https://media.geeksforgeeks.org/wp-content/uploads/insertionsort.png
		 * 
		 * Algorithm : Step 1: If the current element is 1st element of array, it is
		 * already sorted. Step 2: Pick next element Step 3: Compare the current element
		 * will all elements in the sorted sub-array before it. Step 4: Shift all of the
		 * elements in the sub-array before the current element which are greater than
		 * the current element by one place and insert the current element at the new
		 * empty space. Step 5: Repeat step 2-3 until the entire array is sorted.
		 *
		 * Ex: arr[] = {12, 11, 13, 5, 6}
		 * 
		 * Let us loop for i = 1 (second element of the array) to 4 (Size of input array- 1).
		 * 
		 * 
		 * i = 1, Since 11 is smaller than 12, move 12 and insert 11 before 12. 11, 12, 13, 5, 6
		 * i = 2, 13 will remain at its position as all elements in A[0..I-1] are smaller than 13 11, 12, 13, 5, 6 
		 * i = 3, 5 will move to the beginning and all other elements from 11 to 13 will move one 
		 *       position ahead of their current position. 5, 11, 12, 13, 6 
		 * i = 4, 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current
		 *        position. 5, 6, 11, 12, 13
		 */
		int ans[]=InsertionSort(arr,n);
		System.out.println(" Insert sort ");
		ArrayPart01.PrintRayy(ans);
		
		int ans2[]=InsertionSortGoG(arr1,n1);
		System.out.println(" Insert sort GoG");
		ArrayPart01.PrintRayy(ans2);
		
		
		
		/*
		 * Bubble sort 
		 * 
		 * Bubble Sort is also an in-place sorting algorithm. 
		 * This is the simplest sorting algorithm and it works on the principle that:
		 *     In one iteration if we swap all adjacent elements of an array such that 
		 *     after swap the first element is less than the second element
		 *     then at the end of the iteration, the first element of the array will be the minimum element
		 *  Bubble-Sort algorithm simply repeats the above steps N-1 times, where N is the size of the array. 
		 * 
		 * Example: Consider the array, arr[] = {5, 1, 4, 2, 8}.
		 * 
		 * First Pass: ( 5 1 4 2 8 ) --> ( 1 5 4 2 8 ), 
		 *      Here, algorithm compares the first two elements,  and swaps since 5 > 1.
		 *      ( 1 5 4 2 8 ) -->  ( 1 4 5 2 8 ), Swap since 5 > 4 
		 *      ( 1 4 5 2 8 ) -->  ( 1 4 2 5 8 ), Swap since 5 > 2 
		 *      ( 1 4 2 5 8 ) --> ( 1 4 2 5 8 ), 
		 *      -----Now, since these elements are already in order (8 > 5), algorithm does not swap them.
		 * Second Pass: ( 1 4 2 5 8 ) --> ( 1 4 2 5 8 ) 
		 *      ( 1 4 2 5 8 ) --> ( 1 2 4 5 8 ), Swap since 4 > 2
		 *      ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
		 *      ( 1 2 4 5 8 ) -->  ( 1 2 4 5 8 ) 
		 *      Now, the array is already sorted, but our algorithm does not know if it is completed.
		 *      The algorithm needs one whole pass without any swap to know it is sorted.
		 * Third Pass: ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
		 *      ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
		 *      ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
		 *      ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
		 * Note: The above solution can be further optimized by keeping a flag to check if the array is already sorted in the first pass itself and to stop any further iteration.
		 * Time Complexity: O(N2)
		 * 
		 * 
		 * 
		 */
	       
	      int ans3[]=BubbleSortGoG(arr2,n2);
		  System.out.println(" Bubble sort GoG");
		  ArrayPart01.PrintRayy(ans3);
		  
		  int ans4[]=BubbleSort(arr3,n3);
		  System.out.println(" bubble sort ");
		  ArrayPart01.PrintRayy(ans4);
		  
		  
		  /**
		   * Selection Sort
		   * 
		   * The selection sort algorithm sorts an array by repeatedly finding the minimum element
		   *  (considering ascending order) from unsorted part and putting it at the beginning.
		   *   The algorithm maintains two subarrays in a given array.
		   * The subarray which is already sorted.
		   * Remaining subarray which is unsorted.
		   * In every iteration of selection sort, the minimum element (considering ascending order) 
		   * from the unsorted subarray is picked and moved to the sorted subarray. 
		   * 
		   * Following example explains the above steps:--
		   * Example :
		   * arr[] = 64 25 12 22 11.
		   * // Find the minimum element in arr[0...4]
		   *  and place it at beginning
		   *  11 25 12 22 64
		   *  
		   *  // Find the minimum element in arr[1...4]
		   *  // and place it at beginning of arr[1...4]
		   *  11 12 25 22 64
		   *  
		   *  // Find the minimum element in arr[2...4]
		   *  // and place it at beginning of arr[2...4]
		   *  11 12 22 25 64
		   *  
		   *  // Find the minimum element in arr[3...4]
		   *  // and place it at beginning of arr[3...4]
		   *  11 12 22 25 64
		   *  
		   *  Time Complexity: O(N2)
		   * 
		   */
		  int ans5[]=SelectionSortGoG(arr2,n2);
		  System.out.println(" selection sort GoG");
		  ArrayPart01.PrintRayy(ans5);
		  
		  int ans6[]=SelectionSort(arr3,n3);
		  System.out.println(" selection sort ");
		  ArrayPart01.PrintRayy(ans6);
	}

	private static int[] SelectionSortGoG(int[] arr, int n) {
		// selection sort 
		// One by one move boundary of unsorted subarray
		int swap=0;
	    for ( int i = 0; i < n-1; i++)
	    {
	        // Find the minimum element in unsorted array
	        int min_idx = i;
	        for ( int j = i+1; j < n; j++) {
	          if (arr[j] < arr[min_idx]) {
	            min_idx = j;}
	        }
	        swap=arr[min_idx];
			arr[min_idx]=arr[i];
			arr[i]=swap;
		}
		return arr;
		
	}

	private static int[] SelectionSort(int[] arr, int n) {
		// Find minimum in unsorted and place it in first 
		int index=0;
		int min=Integer.MIN_VALUE;
		int swap=0;
		//Till i ---> sorted array 
		// i+1 to n-1 ---> unsorted array
		for(int i=0;i<n;i++) {
			min=arr[i];
			//Finding the minimum element 
			for(int j=i+1;j<n;j++) {
				if(arr[j]<min) {
					index=j+1;
				}
			}
			//Swapping the min element found 
			swap=arr[index];
			arr[index]=arr[i];
			arr[i]=swap;
		}
		return arr;
	}

	private static int[] BubbleSort(int[] arr, int n) {
		// SWAP is bubble sort 
		int swap=0;
		// Either use 1 to n-1 and check arr[i]<arr[j]
		// Or use 0 to n-2 and check arr[i]>arr[j+1]
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]<arr[j]) {
					swap=arr[j];
					arr[j]=arr[i];
					arr[i]=swap;
				}
			}
		}
		return arr;
	}

	private static int[] BubbleSortGoG(int[] arr, int n) {
		int swap=0;
		for ( int i = 0; i < n; i++)       
			  //Optimized 
		       // Last i elements are already in place    
		       for (int j = 0; j < n-i-1; j++)  
		           if (arr[j] > arr[j+1]) {
		        	   swap=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=swap;}
		return arr; 
	}

//	private static void swap(int i, int j) {
//		// swap
//		int temp=j;
//		j=i;
//		i=temp;
//		
//	}

	private static int[] InsertionSortGoG(int[] arr, int n) {
		// Gog  n2
		int j=0;
		for ( int i = 1; i < n; i++) 
		   { 
		       int key = arr[i]; 
		       j = i-1; 
		  
		       /* Move elements of arr[0..i-1], that are 
		          greater than key, to one position ahead 
		          of their current position */
		       while (j >= 0 && arr[j] > key) 
		       { 
		           arr[j+1] = arr[j]; 
		           j = j-1; 
		       } 
		       arr[j+1] = key; 
		   } 
		return arr;
	}

	private static int[] InsertionSort(int[] arr, int n) {
		//check every element with previous element n2 
		// Shift all to right , if key btw sorted sub array
		
		int shift=0;
		int key=0;
		for(int i=1;i<n;i++) {
			key=arr[i];
			shift=i-1;
			// shift all if key is lesser than the sorted array
			while (shift >= 0 && arr[shift] > key) 
		       { 
		           arr[shift+1] = arr[shift]; 
		           shift = shift-1; 
		       } 
		       arr[shift+1] = key;
			}
		
		return arr;
	}
}
