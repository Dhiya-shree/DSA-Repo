package Sort_Types_Problem;

import arrayCode.ArrayPart01;

/**
 * 
 * Heap sort :
 *  Comparison based algo All case Time : O n log n 
 *  Merge and Quick take less time than heap sort 
 *  Intro sort --> Uses heap sort , as quick sort can became n 2 
 *  // Intro sort , with quick sort when time is taking more than log n 
 *  It is not used in std liibrary , but as helper sort 
 *  Basic idea of selection sort 
 *  Selection sort(On2) linearly traverse to find the correct value 
 *  Heap sort uses heap data structure 
 *  
 *  Given an array :
 *     Restructure array as max heap / min heap in On time 
 *     Get Max heap , and swap last element with root 
 *     Then do heapify , and fix the root
 *     
 *  Consider arr ={10,15,50,4,20};
 *  Array as binary tree  
 *             10 
 *          15    50 
 *       4   20   ..   ....
 *  
 *  Build a Max heap to sort in increasing order 
 *  Build a Min heap to sort in decreasing order
 *  
 *  Step 1: Build an Max heap  O n
 *  Begins from last internal note and ends in root 0 
 *  Calls Max heapify at every step
 *    BuildHeap (){
 *    
 *      for i in (n-2)/2 , i>=0 ..
 *          Maxheapify (arr , n ,i )
 *          // Func that finds the largest of note  child1 , child 2 and swap with node
 *    }
 *    
 *    MaxHeapify(){
 *    
 *    int len= i ; // internal node 
 *    int left= 2*i +1 // Left child as it is int 2 is used
 *    int right = 2*i + 2 // Right child 
 *    T make sure no overflow check for sie
 *    if i<n is largest return; 
 *    if left<n && largest , swap left and i 
 *    if right<n && is largest , swap right and i 
 *    
 *    
 * --------For 15 call MaxHeapify , 
 *    
 *             10 
 *          20*    50 
 *       4   15   ..   .... 
 *       
 * --------For 50 call MaxHeapify , 
 *    
 *             10 
 *          20    50* 
 *       4   15   ..   .... 
 *
 * --------For 10 call MaxHeapify , 
 *    
 *             50* 
 *          20    10 
 *       4   15   ..   .... 
 *       
 *  Parent of i is ( i-1)/2
 *  So to find internal node we use (n-1)-1/2= n-2/2
 * 
 * Output 50 20 10 4 15
 * 
 * Step 2: Swap root to its correct position and remove from max heap 
 * After Max heap , in root we have max , Fix the max Arr[0] in last position 
 * Remove root value and Heapify the array
 * 
 * 50 20 10 4 15 --> Swap root 50 to last 
 * 15 20 10 4 50 Output 
 * 
 * Step 3: Heapify the remaining 15 20 10 4 |50 (50 at correct pos)
 * 
 * Input : 15 20 10 4 
 * Use Step 1 and 2 , 3 till all are in correct position 
 * 
 *         15 
 *      20   10
 *     4 
 *     
 * Max heapify output Step 2:
 *           20 
 *        15   10 
 *      4
 * Step 3:
 *  20 15 10 4| 50 
 *   Swap root with second last 
 *  -->  4 15 10 | 20 50 
 *  
 * Use step 1, 2 for arr => 4 15 10 
 *       4      ====>       15
 *   15    10             4    10
 *   
 * Step 3: 15 4 10 | 20 50 
 * Swap root with 3rd last 
 *  --->  10 4 | 15 20 50 
 *  
 *  Step 1 and 2 for input 10 ,4
 *       10           ===>  10 
 *     4   ...            4 ....
 *     
 *  Swap root with 4 last 
 *  10 4 |15 20 50 ==> 4 | 10 15 20 50 
 *  
 *  Step 1 , 2:
 *  i =0 
 *  
 *  Come out of loop .....................
 *  End .........
 *  
 *  
 *  
 * @author shree
 *
 */
public class Sort22_Heap_Sort {

	public static void main(String[] args) {
		int arr[] = {10,15,50,4,20};
		int n = arr.length; 

		//HeapSort ob = new HeapSort(); 
		Heapusort(arr,n); 

		System.out.println("Sorted array is"); 
		//System.out.println(" For loop sortu "+i);
        ArrayPart01.PrintRayy(arr);

	}
	
	public static void buildheap(int arr[],int n){
        for (int i = n / 2 - 1; i >= 0; i--) {
        	System.out.println(" For loop Build eap ... "+i);
            ArrayPart01.PrintRayy(arr);
		    heapify(arr, n, i);
        }
    }
	
	public static void Heapusort(int arr[],int n) 
	{

		buildheap(arr,n); 
 
		for (int i=n-1; i>0; i--) 
		{ 
			 
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp; 
			System.out.println(" For loop sortu "+i);
            ArrayPart01.PrintRayy(arr);
			heapify(arr, i, 0); 
		} 
	} 

	static void heapify(int arr[], int n, int i) 
	{ 
		int largest = i;  
		int l = 2*i + 1; 
		int r = 2*i + 2; 
		System.out.println(" For Heapify  "+i+" At vel "+arr[i]);
        ArrayPart01.PrintRayy(arr);
		if (l < n && arr[l] > arr[largest]) 
			largest = l; 
 
		if (r < n && arr[r] > arr[largest]) 
			largest = r; 

		if (largest != i) 
		{ 
			int swap = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = swap; 
			System.out.println(" For Heapify  "+i+" New val "+arr[largest]);
	        ArrayPart01.PrintRayy(arr);
			heapify(arr, n, largest); 
		} 
	} 

//	static void printArray(int arr[]) 
//	{ 
//		int n = arr.length; 
//		for (int i=0; i<n; ++i) 
//			System.out.print(arr[i]+" "); 
//		System.out.println(); 
//	} 
 
	

}


/*
 * 
 * Heap Sort

Heap sort is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for remaining elements.

What is Binary Heap?

Let us first define a Complete Binary Tree. A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible (Source Wikipedia).

A Binary Heap is a Complete Binary Tree where items are stored in a special order such that value in a parent node is greater(or smaller) than the values in its two children nodes. The former is called as max heap and the latter is called min heap. The heap can be represented by binary tree or array.

Array based representation for Binary Heap: Since a Binary Heap is a Complete Binary Tree, it can be easily represented as array and array based representation is space efficient. If the parent node is stored at index I, the left child can be calculated by 2 * I + 1 and right child by 2 * I + 2 (assuming the indexing starts at 0).

Heap Sort Algorithm for sorting an array in increasing order:
Build a max heap from the input data.
At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
Repeat above steps while size of heap is greater than 1.


How to build the heap?

Heapify procedure can be applied to a node only if its children nodes are heapified. So the heapification must be performed in the bottom up order.

Lets understand with the help of an example:
Input data: [4, 10, 3, 5, 1]
         4(0)
        /   \
     10(1)   3(2)
    /   \
 5(3)    1(4)

The numbers in bracket represent the indices in the array 
representation of data.

Applying heapify procedure to index 1:
         4(0)
        /   \
    10(1)    3(2)
    /   \
5(3)    1(4)

Applying heapify procedure to index 0:
        10(0)
        /  \
     5(1)  3(2)
    /   \
 4(3)    1(4)

The heapify procedure calls itself recursively to build heap
in top down manner.




Implementation:

// To heapify a subtree rooted with node i which is
// an index in arr[]. n is size of heap
void heapify(int arr[], int n, int i)
{
    int largest = i; // Initialize largest as root
    int l = 2*i + 1; // left = 2*i + 1
    int r = 2*i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (l < n && arr[l] > arr[largest])
        largest = l;

    // If right child is larger than largest so far
    if (r < n && arr[r] > arr[largest])
        largest = r;

    // If largest is not root
    if (largest != i)
    {
        swap(arr[i], arr[largest]);

        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest);
    }
}

// Main function for heap sort
void heapSort(int arr[], int n)
{
    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    // One by one extract an element from heap
    for (int i=n-1; i>=0; i--)
    {
        // Move current root to end
        swap(arr[0], arr[i]);

        // call max heapify on the reduced heap
        heapify(arr, i, 0);
    }
}
Important Notes:
Heap sort is an in-place algorithm.
Its typical implementation is not stable, but can be made stable (See this).


Time Complexity: Time complexity of heapify is O(N*LogN). Time complexity of createAndBuildHeap() is O(N) and overall time complexity of Heap Sort is O(N*LogN) where N is the number of elements in the list or array.

Heap sort algorithm has limited use because Quicksort and Mergesort are better in practice. Nevertheless, the Heap data structure itself is enormously used.
 * 
 * 
 * 
 */
