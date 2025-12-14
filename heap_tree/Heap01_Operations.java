package heap_tree;

import java.util.Arrays;

/**
 * 
 * Heap:
 * Operations:
 * Insert 
 * Hapify 
 * Extract 
 * Decraese 
 * Delete 
 * BuildHeap
 * 
 * Min Heap :
 *    complete binary tree 
 *    All child value > root 
 * Max Heap :
 *    complete binary tree 
 *    All child value < root
 *    
 * Heap Implementation 
 * array for storing data 
 * left of i: 2*i+1
 * right of i: 2*i+2
 * parent of i: i-1/2
 * 
 * //////////////////////////////////////////////////////////////////
 * 1) Insert in Heap :
 * Time O H 
 * Must ensure binary properties 
 * 
 * Min Heap Insertion :
 *   every nodesmaller than its descendants 
 *   Complete binary tree 
 *   Time O Log N 
 * 
 * Do not think as tree .. it is array 
 * 
 * Insert :
 *   1) Chcek capacity 
 *   2) Insert the element at last index - complete binary tree statisfied
 *   3) To ensure min heap property compate with its parent 
 *   Compare element with parent :
 *   Loop till data not reached root:
 *        Find parent index 
 *        If parent > data :
 *            Swap parent and data 
 *        else :
 *           if data reached root or 
 *           parent > data 
 *           BREAK ;
 *  
 *             2
 *          /     \
 *         4        8
 *     /    \      /   \
 *    6    5      9     10
 *  / \   / \     /
 * 30  40 50 100 200
 *       
 * Insert 7 at end :
 *             2
 *          /     \
 *         4        8
 *     /    \       /   \
 *    6    5       9     10
 *  / \   / \     /  \
 * 30  40 50 100 200  7
 * 
 *Swap with parent
  *             2
 *          /     \
 *         4        8
 *     /    \       /   \
 *    6    5       7     10
 *  / \   / \     /  \
 * 30  40 50 100 200  9
 * 
  *             2
 *          /     \
 *         4        7
 *     /    \       /   \
 *    6    5       8     10
 *  / \   / \     /  \
 * 30  40 50 100 200  9
 * 
 * 
 *  Java implemetation uses :
 *  Dynamic array - so no capacit constrain 
 *
 *   /////////////////////////////////////////////////////////////////
 * 2) Heapify
 *    Time O LogN theta H 
 *    Used as subroutine in other standard operation 
 *    Extract minimum and build heap etc 
 *    
 *    
 *    Cosider a min heap , where all nodes follow min heap property
 *    Except 1 particular node 
 *    Heap with 1 violation for the heap 
 * 
 * Example :
 *            20   <--- violation at root itself
 *          /     \
 *         4        8
 *     /    \       /   \
 *    6    5       7     10
 *  / \   / \     /  \
 * 30  40 50 100 200  9
 *
 * Need to fix the heap :
 * 
 * Consider given an array and index to node causing violation 
 * For above array and i=0 , root voilation 
 * 
 * 1) Compare root to its left and right children 
 * 2) If min of root,left,right== root no change
 *       min of root,left,right= left/right change 
 *       Swap root with min of left,right with root 
 * 3) Call heapify for swapped data
 *    
 *
 * /////////////////////////////////////////////////////
 * 3) Get Minimum 
 * 
 *   Simply shares the minimum value 
 *   In min heap get arr[0] if size>-1
 *   
 * ///////////////////////////////////////////////////
 *
 * 4) Extract minimum in Heap
 * 
 *    Time O 1 + O log N 
 *    Remove minimum from heap
 *    Remove arr[0]
 *    And maintain min Heap 
 * 
 *
 *    1) Swap first element with last 
 *    2) Do size --  :  delete last element 
 *    3) Call heapify for root 
 *
 *
 *
 * /////////////////////////////////////////////////////
 *  
 * 5) Decrease key 
 *    Given an index of element and a new value data \
 *    
 *  Example : change 30 , i=7 value to 1
 *             2
 *          /     \
 *         4        8
 *     /    \      /   \
 *    6    5      9     10
 *  / \   / \     /
 * 30  40 50 100 200 
 * 
 *   Steps :
 *   1) Insert the data at i 
 *        Heap will not follow minHeap 
 *   2) Do reverse heapify 
 *      For swapped data at i:
 *      Loop :
 *       Find parent 
 *       if parent val > data
 *           swap 
 *       i=parent 
 *   3) Continue till root / parent greater 
 *   
 *  //////////////////////////////////////////////////////
 *  
 *  6) Delete 
 *      Given an index 
 *      Delete the data from heap 
 *      
 *   Steps easy  :
 *   Swap the last node with last value 
 *   Heapify with curr i 
 *   
 *   Steps2:
 *   Make the value as - infinity 
 *   Keep on comparing parent till root
 *   Extract minimum 
 *   
 * ////////////////////////////////////////////////////
 * 
 *  7) Build heap 
 *  
 *    Given an array convert to minHeap 
 *    Rearrange and convert 
 *    
 *    Step 1:
 *    Insert all - N * O Log N 
 *    
 *    Step 2: 
 *    Rearrange and insert 
 *    O Log N - merge/quick sort 
 *    Complete .....
 *    
 *    Step3 :
 *    Take array as heap 
 *    Call minHeapify 
 *    
 *    
 *    1) First make a call for bottom right internal node
 *    2) For every node , left and right should be heapified 
 *    3) So start from bottom and go to top 
 *    
 *    Last node index= size
 *    for parent of i= size-1/2  ; i>=0 ; i--
 *       Call minheapify 
 *    
 *  From top we can not fix min correctly , go from bottom 
 *    
 *    Min heapify = O LogN 
 *    called for N nodes 
 *    Time complexity : N Log N 
 *    
 *    No !!!!!!!!!!!!!!!!!!!
 *    
 *    Time Complexity is O N :
 *    
 *    Maximum no of nodes at height H :
 *      hegiht h nodes = n / ( 2^(h+1))
 *              N = 14      2^H+1   Nodes at each level 
 *            x        H=3   16     0.5> 1
 *          x   x      H=2   8      1.6 2
 *        x x   x x    H=1   4      3.9 4
 *     x x x x  x x x  H=0   2      7    7 
 *     
 *     O H  - Hepify time 
 *     N/2^(h+1) - no of node at each height 
 *     
 *     for height 1 to Log N we build heap - all internal nodes
 *     
 *     summation H * (h = 1 to log N   N/2^(h+1))
 *     Take N out use H inside 
 *     N * summation (h = 1 to log N   H/2^(h+1))
 *     
 *     
 *     Summation :
 *     s= 1/2^2+ 2/2^3 + 3/2^4 and so on
 *     
 *     s - s/2 = 1/2^2 + 1/2^3 + 1/2^4 + and so on... It is in G P 
 *     Geometric Progression 
 *     
 *     s/2 = 1/2^2  % ( 1-1/2)
 *     s/2 = 1/2 
 *     s=1 
 *     Summation =1 
 *     Time complexity = O N *1 = O N 
 *     
 *     
 *     
 *     
 *     
 *     
 *     
 *     
 *    
 *    
 *    
 *   
 * @author shree
 *
 */


class MinHeapArray{
	int []arr;//one array for all data 
	int size;
	int capacity;
	
	MinHeapArray(int c){
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
			
			minHeapifyIterative(i);// O Log N 
			
		}
		
		//Time complexity = O N lOg n ?
	}
	
	int decreaseKey(int i,int data) {
		
		int old=arr[i];
		arr[i]=data;int swap=0;
		while(i!=0 && arr[parent(i)]>arr[i]) {
			
			swap=arr[i];
			arr[i]=arr[parent(i)];
			arr[parent(i)]=swap;
			i=parent(i);
		}
		return old;
	}
	
	int deleteHeap(int i) {
		
		/*
		 if(heap_size==0 || i>=heap_size || i<0){
            return;
        }
        decreaseKey(i,Integer.MIN_VALUE);
        extractMin(); 
		  use above
		  
		 */
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
		minHeapifyIterative(i);
		
		return data;
		
	}
	
	
	int extractMinimum() {
		
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
		size=size-1;//delete root from heap 
		
		//Heapify from root
		MinHeapify(0);
		
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
		while(i>0 && p>=0 && arr[p]>data) {
			swap=arr[p];
			arr[p]=arr[i];
			arr[i]=swap;
			i=p;
			p=parent(i);
		}
		return true;
		
	}
	
	void minHeapifyIterative(int i) {
		
		if(size==1) {
			return;
		}
		boolean heapify=true;
		while(heapify) {
			int left=left(i);
			int right=right(i);
			int arrleft=Integer.MAX_VALUE;
			int arrRight=Integer.MAX_VALUE;
			if(right>=0 && right<capacity) {
				arrRight=arr[right];
			}
           if(left>=0 && left<capacity) {
        	   arrleft=arr[left];
			}
			int min=Math.min(arrleft,arrRight);
			min=Math.min(arr[i],min);
			int swap=0;
			if(min==arr[left]) {
				swap=arr[i];
				arr[i]=arr[left];
				arr[left]=swap;
				MinHeapify(left);
			}
			else if(min==arr[right]) {
				swap=arr[i];
				arr[i]=arr[right];
				arr[right]=swap;
				MinHeapify(right);
			}
			else {
				heapify=false;
			}
		}
	}
	
	void MinHeapify(int i) {
		
		if(i<0 || i>size) {
			return;
		}
		int left=left(i);
		int right=right(i);
		int smallest=i;
		if(left<=size && arr[left]<arr[smallest]) {
			smallest=left;
		}
		if(right<=size && arr[right]<arr[smallest]) {
			smallest=right;
		}
		if(i==smallest) {
			return;
		}
		System.out.println(i+" For arr "+arr[i]+" smallest "+arr[smallest]+" at "+i);
		// if need to check for whole 
		// call minheapify for left and right 
		if(smallest==i) {
			return;
		}
		else {
			int swap=arr[i];
			arr[i]=arr[smallest];
			arr[smallest]=swap;
			MinHeapify(smallest);
		}
		
	}
	
	int getMinimum() {
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
		
			return c;//need pointer 
		
		
	}
	
	int right(int i) {
		//right child 
		int c=2*i+2;
		return c;//need pointer
		
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
public class Heap01_Operations {

	public static void main(String[] args) {
		// try min heap
		int array[]= {1,12,5,111,200};
		int n=array.length;
		MinHeapArray mh=new MinHeapArray(n);
		
		mh.buildHeap(array);
		System.out.println(" Array in heap "+Arrays.toString(mh.arr));
		
		for(int i=0;i<n;i++) {
		int s=mh.extractMinimum();
		System.out.println(" Val min "+s );
		}
		System.out.println(" Array in heap "+Arrays.toString(mh.arr));
	}

}

/*
 * 
 * Operations of Heap Data Structure

Operations on Min Heap:
1) getMini(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).

2) extractMin(): Removes the minimum element from MinHeap. Time Complexity of this Operation is O(Logn) as this operation needs to maintain the heap property (by calling heapify()) after removing root.

3) decreaseKey(): Decreases value of key. The time complexity of this operation is O(Logn). If the decreases key value of a node is greater than the parent of the node, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

4) insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. IF new key is greater than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

5) delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minum infinite by calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, so we call extractMin() to remove the key.

Below is the implementation of basic heap operations.

// A C++ program to demonstrate common Binary Heap Operations
#include<iostream>
#include<climits>
using namespace std;

// Prototype of a utility function to swap two integers
void swap(int *x, int *y);

// A class for Min Heap
class MinHeap
{
	int *harr; // pointer to array of elements in heap
	int capacity; // maximum possible size of min heap
	int heap_size; // Current number of elements in min heap
public:
	// Constructor
	MinHeap(int capacity);

	// to heapify a subtree with the root at given index
	void MinHeapify(int );

	int parent(int i) { return (i-1)/2; }

	// to get index of left child of node at index i
	int left(int i) { return (2*i + 1); }

	// to get index of right child of node at index i
	int right(int i) { return (2*i + 2); }

	// to extract the root which is the minimum element
	int extractMin();

	// Decreases key value of key at index i to new_val
	void decreaseKey(int i, int new_val);

	// Returns the minimum key (key at root) from min heap
	int getMin() { return harr[0]; }

	// Deletes a key stored at index i
	void deleteKey(int i);

	// Inserts a new key 'k'
	void insertKey(int k);
};

// Constructor: Builds a heap from a given array a[] of given size
MinHeap::MinHeap(int cap)
{
	heap_size = 0;
	capacity = cap;
	harr = new int[cap];
}

// Inserts a new key 'k'
void MinHeap::insertKey(int k)
{
	if (heap_size == capacity)
	{
		cout << "\nOverflow: Could not insertKey\n";
		return;
	}

	// First insert the new key at the end
	heap_size++;
	int i = heap_size - 1;
	harr[i] = k;

	// Fix the min heap property if it is violated
	while (i != 0 && harr[parent(i)] > harr[i])
	{
	swap(&harr[i], &harr[parent(i)]);
	i = parent(i);
	}
}

// Decreases value of key at index 'i' to new_val. It is assumed that
// new_val is smaller than harr[i].
void MinHeap::decreaseKey(int i, int new_val)
{
	harr[i] = new_val;
	while (i != 0 && harr[parent(i)] > harr[i])
	{
	swap(&harr[i], &harr[parent(i)]);
	i = parent(i);
	}
}

// Method to remove minimum element (or root) from min heap
int MinHeap::extractMin()
{
	if (heap_size <= 0)
		return INT_MAX;
	if (heap_size == 1)
	{
		heap_size--;
		return harr[0];
	}

	// Store the minimum value, and remove it from heap
	int root = harr[0];
	harr[0] = harr[heap_size-1];
	heap_size--;
	MinHeapify(0);

	return root;
}


// This function deletes key at index i. It first reduced value to minus
// infinite, then calls extractMin()
void MinHeap::deleteKey(int i)
{
	decreaseKey(i, INT_MIN);
	extractMin();
}

// A recursive method to heapify a subtree with the root at given index
// This method assumes that the subtrees are already heapified
void MinHeap::MinHeapify(int i)
{
	int l = left(i);
	int r = right(i);
	int smallest = i;
	if (l < heap_size && harr[l] < harr[i])
		smallest = l;
	if (r < heap_size && harr[r] < harr[smallest])
		smallest = r;
	if (smallest != i)
	{
		swap(&harr[i], &harr[smallest]);
		MinHeapify(smallest);
	}
}

// A utility function to swap two elements
void swap(int *x, int *y)
{
	int temp = *x;
	*x = *y;
	*y = temp;
}

// Driver program to test above functions
int main()
{
	MinHeap h(11);
	h.insertKey(3);
	h.insertKey(2);
	h.deleteKey(1);
	h.insertKey(15);
	h.insertKey(5);
	h.insertKey(4);
	h.insertKey(45);
	cout << h.extractMin() << " ";
	cout << h.getMin() << " ";
	h.decreaseKey(2, 1);
	cout << h.getMin();
	return 0;
}
 

Output:

2 4 1
 * 
 * 
 */
/**

Insertion and Deletion in Heap

Insertion in Heaps

The insertion operation is also similar to that of the deletion process.
 


Given a Binary Heap and a new element to be added to this Heap. The task is to insert the new element to the Heap maintaining the properties of Heap.
 



Process of Insertion: Elements can be inserted to the heap following a similar approach as discussed above for deletion. The idea is to:
 

First increase the heap size by 1, so that it can store the new element.
Insert the new element at the end of the Heap.
This newly inserted element may distort the properties of Heap for its parents. So, in order to keep the properties of Heap, heapify this newly inserted element following a bottom-up approach.


Illustration:

Suppose the Heap is a Max-Heap as:
      10
    /    \
   5      3
  / \
 2   4

The new element to be inserted is 15.

Process:
Step 1: Insert the new element at the end.
      10
    /    \
   5      3
  / \    /
 2   4  15

Step 2: Heapify the new element following bottom-up 
        approach.
-> 15 is more than its parent 3, swap them.
       10
    /    \
   5      15
  / \    /
 2   4  3

-> 15 is again more than its parent 10, swap them.
       15
    /    \
   5      10
  / \    /
 2   4  3

Therefore, the final heap after insertion is:
       15
    /    \
   5      10
  / \    /
 2   4  3

Implementation:
 
# program to insert new element to Heap

# Function to heapify ith node in a Heap
# of size n following a Bottom-up approach


def heapify(arr, n, i):
	parent = int(((i-1)/2))
	# For Max-Heap
	# If current node is greater than its parent
	# Swap both of them and call heapify again
	# for the parent
	if arr[parent] > 0:
		if arr[i] > arr[parent]:
			arr[i], arr[parent] = arr[parent], arr[i]
			# Recursively heapify the parent node
			heapify(arr, n, parent)
# Function to insert a new node to the Heap


def insertNode(arr, key):
	global n
	# Increase the size of Heap by 1
	n += 1
	# Insert the element at end of Heap
	arr.append(key)
	# Heapify the new node following a
	# Bottom-up approach
	heapify(arr, n, n-1)
# A utility function to print array of size n


def printArr(arr, n):
	for i in range(n):
		print(arr[i], end=" ")


# Driver Code
# Array representation of Max-Heap
'''
	10
	/ \
	5 3
	/ \
	2 4
'''
arr = [10, 5, 3, 2, 4, 1, 7]
n = 7
key = 15
insertNode(arr, key)
printArr(arr, n)
# Final Heap will be:
'''
  15
  / \
 5	 10
/ \ /
2 4 3


 


Output
15 5 10 2 4 3
 
Deletion in Heap


 


Given a Binary Heap and an element present in the given Heap. The task is to delete an element from this Heap.
 



The standard deletion operation on Heap is to delete the element present at the root node of the Heap. That is if it is a Max Heap, the standard deletion operation will delete the maximum element and if it is a Min heap, it will delete the minimum element.

Process of Root Deletion (Or Extract Min in Min Heap):
Since deleting an element at any intermediary position in the heap can be costly, so we can simply replace the element to be deleted by the last element and delete the last element of the Heap.
 

Replace the root or element to be deleted by the last element.
Delete the last element from the Heap.
Since, the last element is now placed at the position of the root node. So, it may not follow the heap property. Therefore, heapify the last node placed at the position of root.


Illustration:

 Suppose the Heap is a Max-Heap as:
      10
    /    \
   5      3
  / \
 2   4

The element to be deleted is root, i.e. 10.

Process:
The last element is 4.

Step 1: Replace the last element with root, and delete it.
      4
    /    \
   5      3
  / 
 2   

Step 2: Heapify root.
Final Heap:
      5
    /    \
   4      3
  / 
 2   


Implementation:
 


# Python 3 program for implement deletion in Heaps
 
# To heapify a subtree rooted with node i which is
# an index of arr[] and n is the size of heap
def heapify(arr, n, i):
 
    largest = i #Initialize largest as root
    l = 2 * i + 1 # left = 2*i + 1
    r = 2 * i + 2 # right = 2*i + 2
 
    #If left child is larger than root
    if (l < n and arr[l] > arr[largest]):
        largest = l
 
    #If right child is larger than largest so far
    if (r < n and arr[r] > arr[largest]):
        largest = r
 
    # If largest is not root
    if (largest != i):
        arr[i],arr[largest]=arr[largest],arr[i]
 
        #Recursively heapify the affected sub-tree
        heapify(arr, n, largest)
 
#Function to delete the root from Heap
def deleteRoot(arr):
    global n
 
    # Get the last element
    lastElement = arr[n - 1]
 
    # Replace root with last element
    arr[0] = lastElement
 
    # Decrease size of heap by 1
    n = n - 1
 
    # heapify the root node
    heapify(arr, n, 0)
 
# A utility function to print array of size n
def printArray(arr, n):
 
    for i in range(n):
        print(arr[i],end=" ")
    print()
 
# Driver Code
if __name__ == '__main__':
 
    # Array representation of Max-Heap
    #      10
    #     /  \
    #    5    3
    #   / \
    #  2   4
    arr = [ 10, 5, 3, 2, 4 ]
 
    n = len(arr)
 
    deleteRoot(arr)
 
    printArray(arr, n)

 


Output
5 4 3 2
Time complexity: O(logn) where n is no of elements in the heap

Auxiliary Space: O(n)


*/