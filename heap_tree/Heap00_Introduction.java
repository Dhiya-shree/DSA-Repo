package heap_tree;


/**
 * 
 * Binary Heap 
 * 
 * ---> Used in Heap sort 
 * ---> Used to implement Priority Queue
 *              --> used in Djistra 
 *              --> Prim minimum spannning tree 
 *              --> Huffman coding 
 *              --> all queue with priority , doctor queue 
 * 
 * Priority basedon numbers , ex rank 1 to 100 or ticket amount 1000,100,10 etc
 * For both the cases we have diff type of heap 
 * 
 * 1) Min Heap 
 *    Highest Priority item assigned lowest value 
 *    Ex Ranks 
 *    Lowest value remain at the top 
 *    Remove first the lowset value
 *    Every node should have value smaller than its descendants 
 *                                          2
 *                  10                   4      8
 *                20  15             6    5    9  10
 *              30 40 50          100 200
 *    All nodes lesses than the child , internal array representation 
 *    + Cmplete Binary tree ===> Min heap 
 *    
 * 2) Max Heap 
 *    Highest Priority item assigned highest value 
 *    Ex token amount  
 *    Highest value remain at the top 
 *    Remove first the highest value 
 * 
 * 
 * Binary heap --> Complete Binary tree 
 *  Where all level are completely filled except last level 
 *  + last level filed from left to right 
 *  
 * Why binary heap must be complete binary tree ?
 * Binary heap will be stored in a array .
 * Storing complete binary tree in array can be done without loss to space 
 * And +++
 *    Can hold proper parent child relationship 
 *    
 *                  10
 *               8      12
 *            5    9   11  14
 *          4   6 7
 *          
 * Above complete binary tree to array 
 * Ans :
 *    10 8 12 5 9 11 14 4 6 7 
 * 
 * For any node at index i :
 * Left child at : 2i + 1
 * Right child at : 2i + 2 
 * 
 * Parent of any child at i :
 * parent of i : (i-1)/2
 * 
 * Example :
 * For value 5 at pos i:3
 * left : 2*3+1 => 7 value :4
 * Right: 2*3+2 => 8 value :6
 * 
 * For value 11 at pos i:5
 * Parent of 11 at (i-1)/2
 * parent : 4/2 = 2 value :12 
 * 
 *  
 * Advantages of array as Binary complete tree => Heap :
 * 
 * 1) Items at contiguous loation : random access possible 
 * 2) Cache friendly : contiguous so locality of reference 
 * 3) Height of tree is minimum , so insert,search,delete operation not costly 
 * 4) Linked Data structure as tree , BLL CLL LL as tree is costlier than array 
 *                
 *    
 *  
 * 
 *  
 * 
 * @author shree
 *
 */
public class Heap00_Introduction {

}


/**

Binary Heap Introduction

A Heap is a Tree-based data structure, which satisfies the below properties:
 

A Heap is a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible).
A Heap is either Min Heap or Max Heap. In a Min-Heap, the key at root must be minimum among all keys present in the Binary Heap. The same property must be recursively true for all nodes in the Tree. Max Heap is similar to MinHeap.


Binary Heap: A Binary Heap is a heap where each node can have at most two children. In other words, a Binary Heap is a complete Binary Tree satisfying the above-mentioned properties. 



 

Representing Binary Heaps


Since a Binary Heap is a complete Binary Tree, it can be easily represented using Arrays. 
 

The root element will be at Arr[0].
Below table shows indexes of other nodes for the ith node, i.e., Arr[i]:
Arr[(i-1)/2]	Returns the parent node
Arr[(2*i)+1]	Returns the left child node
Arr[(2*i)+2]	Returns the right child node


Getting Maximum Element: In a Max-Heap, the maximum element is always present at the root node which is the first element in the array used to represent the Heap. So, the maximum element from a max heap can be simply obtained by returning the root node as Arr[0] in O(1) time complexity.

Getting Minimum Element: In a Min-Heap, the minimum element is always present at the root node which is the first element in the array used to represent the Heap. So, the minimum element from a minheap can be simply obtained by returning the root node as Arr[0] in O(1) time complexity.

*/