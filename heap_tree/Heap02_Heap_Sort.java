package heap_tree;

import java.util.Arrays;

/**
 * Heap Sort :
 * 
 * Based on selection sort algo .
 * In selection sort , we find maximum and swap with the last 
 * We use linear seach for finding max and completes with O N 2 time 
 * 
 * 
 * Heap sort => Optimized selection sort 
 * Instead of using linear seach 
 * Heap sort uses MinHeap / MaxHeap extract 
 * Given a array , sort it .
 * 
 * Heap sort :
 * 
 * 1) Build the max Heap O N
 * 2) Swap the last element with root of MaxHeap 
 * 3) Heapify Root  
 * 4) size -- consider array before the last element for max heap 
 * 
 * 
 * 
 * 
 * @author shree
 *
 */

class MaxHeapArray{
	int []arr;//one array for all data 
	int size;
	int capacity;
	
	MaxHeapArray(int c){
		arr=new int[c];
		capacity=c;
		size=-1;
	}
	
	void buildHeap(int Arr[]) {
		
		size=Arr.length-1;
		//setting array 
		
		for(int i=0;i<=size;i++) {
			arr[i]=Arr[i];
		}
		// Loop for N nodes 
		for(int i=(size-1)/2;i>=0;i--) {
			
			maxHeapifyarr(arr.length,i);// O Log N 
			
		}
		
		//Time complexity = O N lOg n ? No O N
	}
	
 void maxHeapifyarr(int n, int i) {
		// arr 
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && arr[left]>arr[largest]) {
			largest=left;
		}
		if(right<n && arr[right]>arr[largest]) {
			largest=right;
		}
		
		if(largest!=i) {
			int swap=arr[i];
			arr[i]=arr[largest];
			arr[largest]=swap;
			maxHeapifyarr(n, largest);
		}
		
	}

	int IncreaseKey(int i,int data) {
		
		int old=arr[i];
		arr[i]=data;int swap=0;
		while(i!=0 && arr[parent(i)]<arr[i]) {
			
			swap=arr[i];
			arr[i]=arr[parent(i)];
			arr[parent(i)]=swap;
			i=parent(i);
		}
		return old;
	}
	
	int deleteHeap(int i) {
		int data=arr[i];
		if(size==0) {
			size--;
			return data;
		}
		
		//step1 
		int swap=arr[size];
		arr[size]=arr[i];
		arr[i]=swap;
		
		//delete 
		arr[swap]=0;
		size--;
		
		//heapify from i 
		maxHeapifyIterative(i);
		
		return data;
		
	}
	
	
	int extractMaximum() {
		
		if(size<0) {
			System.out.println(" Empty ");
			return -1;
		}
		if(size==0) {
			size--;
			return arr[0];
		}
		
		//swap last and root min 
		int swap=arr[0];
		arr[0]=arr[size];
		arr[size]=swap;
		//Swap has minmum element 
		size--;//delete root from heap 
	//	System.out.print(swap+" "+size);
		//Heapify from root
		maxHeapifyarr(size,0);
		
		//return minimum 
		return swap;
	}
	boolean insert(int data) {
		size++;
		if(size>=capacity) {
			return false;
		}
		arr[size]=data;
		// Complete binary tree 
		int i=size;
		int p=parent(i);int swap=0;
		while(i>0 && p>=0 && arr[p]<data) {
			swap=arr[p];
			arr[p]=arr[i];
			arr[i]=swap;
			i=p;
			p=parent(i);
		}
		return true;
		
	}
	
	void maxHeapifyIterative(int i) {
		
		if(size==1) {
			return;
		}
		boolean heapify=true;
		while(heapify) {
			int left=left(i);
			int right=right(i);
			int arrleft=Integer.MIN_VALUE;
			int arrRight=Integer.MIN_VALUE;
			if(right>=0 && right<capacity) {
				arrRight=arr[right];
			}
           if(left>=0 && left<capacity) {
        	   arrleft=arr[left];
			}
			int min=Math.max(arrleft,arrRight);
			min=Math.max(arr[i],min);
			int swap=0;
			if(min==arrleft) {
				swap=arr[i];
				arr[i]=arr[left];
				arr[left]=swap;
			//	MinHeapify(left);
			}
			else if(min==arrRight) {
				swap=arr[i];
				arr[i]=arr[right];
				arr[right]=swap;
			//	maxHeapifyIterative(right);
			}
			else {
				heapify=false;
			}
		}
	}
	
	void MaxHeapify(int i) {
		int n=capacity;
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && arr[left]>arr[largest]) {
			largest=left;
		}
		if(right<n && arr[right]>arr[largest]) {
			largest=right;
		}
		
		if(largest!=i) {
			int swap=arr[i];
			arr[i]=arr[largest];
			arr[largest]=swap;
			MaxHeapify(largest);
		}
	}
	
	int getMaximum() {
		if(size>-1) {
			return arr[0];
		}
		else {
			System.out.println(" Empty ");
			return -1;
		}
	}
	
	int left(int i) {
		//left child 
		int c=2*i+1;
		if(c<capacity) {
			return c;//need pointer 
		}
		else {
			return 0;
		}
		
	}
	
	int right(int i) {
		//right child 
		int c=2*i+2;
		if(c<capacity) {
			return c;//need pointer
		}
		else {
			return 0;
		}
		
	}
	
	int parent(int i) {
		//parent 
		int p=(i-1)/2;
		if(p<capacity) {
			return p;//need pointer
		}
		else {
			return 0;
		}
	}

}

public class Heap02_Heap_Sort {

	public static void main(String[] args) {
		// Heap sort 
		
		int arr[]= {0,56,76,4,5,6,1,2,3,9,21,34,7,8,86,99};
        int n=arr.length;
        System.out.println(" rray "+Arrays.toString(arr));
        MaxHeapArray heap=new MaxHeapArray(n);
		heap.buildHeap(arr);
		
		System.out.println(" Heap sorted "+Arrays.toString(heap.arr));
		SortHeap(heap);
		
		//Heap for clas
	}

	private static void SortHeap(MaxHeapArray heap) {
		//use extract 
		
		
		int n=heap.size;int swap=0;
		System.out.println(" N "+n);
	//	int c=heap.size;
		for(int i=n;i>=1;i--) {
			swap=heap.arr[0];
			heap.arr[0]=heap.arr[i];
			heap.arr[i]=swap;
			System.out.print(swap+" ");
			n--;
			heap.maxHeapifyarr(i,0);
		}
		System.out.println(" Sorted "+Arrays.toString(heap.arr));
	}

}




class HeapSort
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i=(n-2/2);i>=0;i--){
            heapify(arr,n,i);
        }
        
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int left=2*i+1;
        int right=2*i+2;
        int large=i;
        if(left<n && arr[left]>arr[large]){
            large=left;
        }
        if(right<n && arr[right]>arr[large]){
            large=right;
        }
        if(i!=large){
            int swap=arr[i];
            arr[i]=arr[large];
            arr[large]=swap;
            heapify(arr,n,large);
        }
        return;
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr,n);
      //  System.out.println(Arrays.toString(arr));
        for(int i=n-1;i>=0;i--){
            
            int max=arr[0];
            arr[0]=arr[i];
            arr[i]=max;
        //    System.out.println(max);
            heapify(arr,i,0);
        }
    }
 }


/**
 * 
 * Heap Sort

Heap sort is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for remaining elements.

What is Binary Heap?
Let us first define a Complete Binary Tree. A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

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
 

import java.util.*;
import java.io.*;
import java.lang.*;
  
public class HeapSort 
{ 
	public void buildheap(int arr[],int n){
        for (int i = n / 2 - 1; i >= 0; i--) 
		    heapify(arr, n, i);
    }
	
	public void sort(int arr[]) 
	{ 
		int n = arr.length; 

		buildheap(arr,n); 
 
		for (int i=n-1; i>0; i--) 
		{ 
			 
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp; 

			heapify(arr, i, 0); 
		} 
	} 

	void heapify(int arr[], int n, int i) 
	{ 
		int largest = i;  
		int l = 2*i + 1; 
		int r = 2*i + 2; 

		if (l < n && arr[l] > arr[largest]) 
			largest = l; 
 
		if (r < n && arr[r] > arr[largest]) 
			largest = r; 

		if (largest != i) 
		{ 
			int swap = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = swap; 

			heapify(arr, n, largest); 
		} 
	} 

	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 
 
	public static void main(String args[]) 
	{ 
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		int n = arr.length; 

		HeapSort ob = new HeapSort(); 
		ob.sort(arr); 

		System.out.println("Sorted array is"); 
		printArray(arr); 
	} 
} 
Output:
Sorted array is
5 6 7 11 12 13 
Important Notes:
 

Heap sort is an in-place algorithm.
Its typical implementation is not stable, but can be made stable (See this).


Time Complexity: Time complexity of heapify is O(N*LogN). Time complexity of creating and build the heap is O(N) and overall time complexity of Heap Sort is O(N*LogN) where N is the number of elements in the list or array.

Heap sort algorithm has limited use because Quicksort and Mergesort are better in practice. Nevertheless, the Heap data structure itself is enormously used.


 * 
 */
