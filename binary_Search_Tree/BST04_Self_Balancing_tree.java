package binary_Search_Tree;

import arrayCode.ArrayPart01;

/**
 * Self balancing tree 
 * 
 * Keeps the heaight as O log N 
 * So all operation :
 *     Insert 
 *     Search 
 *     Delete 
 *     Floor
 *     Ceil 
 *  Has time complexity O H - O N 
 *  to O H ==> O log N 
 *  
 *  Same set of key make diff height tree 
 *  
 *  Set = 2,5,8,12,56,26,100
 *            x
 *  Take 5 as root :
 *          5
 *         2  8
 *              12
 *                26
 *                  56
 *                    100
 * big height
 * 
 * Take 12 as root and rearrange set 
 * Set arranged: 12 5 56 2 8 26 100
 *            12
 *           5  56
 *         2  8  26 100  
 * Height=Log N 
 * 
 * Order of insertion affects root
 * With knowing keys , make perfectly balanced binary tree
 * 
 * To make a balanced sub tree :
 * 1) Arrage array is acs :2,5,8,12,56,26,100
 * 2) Take mid as root    :12
 * 3) With root , consider left side for left sub tree and vice versa
 *    Left 2,5,8 
 *    Take the mid of left array 
 *    as left root 
 *    12 -> 5 
 * 4) Consider the remaining left for left and right respectively 
 * 5) If array size is 0 stop 
 * 
 * 
 * After construction : if user insert/delete data 
 * How to maintain a self balanced tree
 * 
 * RESTRUCTURE TREE ......
 * 
 * If left extra length :
 * Make root.left as root 
 * Prev root as root.left(Root)->right 
 * And rearrange left's right as -> curr  root left 
 * 
 *             50 
 *            /  \
 *           40   60
 *         / \    / \
 *        20 41  55  70
 *     / \    / \
 *    15 25  39 45 
 *    
 * For inserting 35 in tree : Not self balance
 * High val in left  7 
 * + 1 in left no need 
 * Make root as root.left as root 
 * Make root.left.right as root's left 
 * 
 *            40
 *          /    \
 *         20     50 
 *       / \     /  \
 *     15 25    41    60
 *          \   / \   / \
 *          32 39  45 55  70
 *       
 * Above is balanced
 * 
 * 
 *  Sorting :
 *  Quick sort :
 *  Take a parition , sort into left and right array based on the partition 
 *  Send the left for quicksort and right for quick sort 
 *  
 *  Merge Sort :
 *  SEperate as mid , low , high 
 *  REcursion call for low to mid 
 *  Recursion call for mid+1 to high 
 *  
 *  Merge based on two pointer 
 *  left arr - sorted right arr- sorted 
 *  pointer for left le , riight ri
 *  in new array fill up sorted values 
 *  
 *  Quick sort :
 *  Find partition :
 *  Swap element less than partition in right with
 *  high than partition in left 
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class BST04_Self_Balancing_tree {

	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int n=arr.length;
		int sortedarr[]=quicksortHoare(arr, 0, arr.length-1);
		
		BSTNode root=SelfBalanceTree(sortedarr,0,n-1,n-1);
		BST02_operation_medium.TraverseLevelOrderQueueTwoLoops(root);
	
	   // root=InsertSelfBalancingTree(root);
	    
	
	}
	
	private static BSTNode SelfBalanceTree(int[] arr, int left, int right,int size) {
		// Construct self balance tree 
		if(left>right) {
			return null;
		}
		if(left<0 || right>size) {
			return null;
		}
		
		if(left==right && left>0 && left<size) {
			return new BSTNode(arr[left]);
		}
		
		int mid=(int)((left+right)/2);
		BSTNode root=new BSTNode(arr[mid]);
		root.left=SelfBalanceTree(arr, left,mid-1,size);
		root.right=SelfBalanceTree(arr,mid+1, right,size);
		return root;
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
//		When pivot is smallest of all , pivot position , i=0, j=1
	//  When pivot is largest , then i= n-2 and j =n-1
	// All elements are EQUAL 
		//  Swapping happens many times 
		// Even if same pos change , so not stable 
		System.out.println(" Hoareee");
		ArrayPart01.PrintRayy(arr);
		return left;
	}
}


/*
 * Self Balancing BST

Self-Balancing Binary Search Trees are height-balanced binary search trees that automatically keeps height as small as possible when insertion and deletion operations are performed on tree. The height is typically maintained in order of Log n so that all operations take O(Log n) time on average. 

Examples : 
Red Black Tree 
  

Red Black Tree


AVL Tree: 
 
 



How do Self-Balancing-Tree maintain height? 
A typical operation done by trees is rotation. Following are two basic operations that can be performed to re-balance a BST without violating the BST property (keys(left) < key(root) < keys(right)). 

Left Rotation 
Right Rotation  
T1, T2 and T3 are subtrees of the tree 
rooted with y (on the left side) or x (on 
the right side)           
     y                               x
    / \     Right Rotation          /  \
   x   T3   - - - - - - - >        T1   y 
  / \       < - - - - - - -            / \
 T1  T2     Left Rotation            T2  T3
Keys in both of the above trees follow the 
following order 
 keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)
So BST property is not violated anywhere.

We will compare the efficiency of these trees: 

Metric                	RB Tree	                AVL Tree          	Splay Tree

Insertion in 
worst case           	O(logn)	                O(logn)	        Amortized O(logn)

Maximum height 
of tree             	2*log(n)	           1.44*log(n)	         O(n)

Search in 
worst case      	O(logn), Moderate	     O(logn), Faster	Amortized O(logn), Slower

Efficient          Three pointers         Two pointers with         no extra 
Implementation       with color bit      balance factor              information
 requires             per node                  per node 
 
Deletion in 
worst case	          O(logn)               	O(logn)	                  Amortized O(logn)

Mostly used	   universal data structure     When frequent lookups        When same element is
As 		                                    are required                retrieved again and again

Real world     Database Transactions    Multiset, Multimap,              Cache implementation,
Application			                      Map, Set, etc.                  Garbage collection Algorithms
 * 
 * 
 */
