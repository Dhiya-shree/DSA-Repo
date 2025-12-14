package tree_Data_Structure;

public class Tree24_Count_possibe_tree {

	// Unlabbled ?
	// Given labeled nodes
	// CATALAN Number

	// Total number of BST with N diff keys
	// Catalan number Cn
	// (2*n)!/((n+1)!*n!)

	// Total possible Binary Tree with N diff key
	// (Catalan of BST)* n!

	// Rooted TRee
	// One root - multiple vertex

	// Rooted tree with 0 / 3leaf
	// N nodes
	// ANS : 2*N+1 / 3

	// For Full tree with 0/2 leaf
	// Given N node
	// No of leaf = No of internal node+1
	/*
	 * 1
	 * 2 3
	 * 3 4 5 6
	 * 7 8 9 10
	 * 
	 * No of node = 10
	 * No of leaf =6 = n/2+1 (5+1)
	 * 
	 * 1
	 * 2 3 4
	 * 5 6 7 * 8 9 10
	 * * * * * 11 12 13
	 * No of nodes = 13
	 * leaf = 9 (5 internal node 4*2 +1 = 9)
	 * 
	 * For N-ary nodes:
	 * Internal*(N-1) +1
	 * 
	 * 
	 */

	// Full tree== Complete N ary Tree
	// All node - 0/N child

	// Leaf node = Internal node+1
	// Internal =10
	// Leaf =41
	// N = ?
	// Internal*(N-1) +1

	// 10*(N-1)=40 // DONT SKIP STEP ....... ESPECIALLLY + AND - YOU DUMB ASS!!!!!1
	// N=4+1= 5

	// Node X in Binary Tree
	// X has 2 children

	// Y inorderv successor of X
	// Inorder left - root - right

	// AS X has two children
	// Y must be the leftmost node in the right child of X

	/*
	 * Types of Binary tree :
	 * 
	 * 1) Full tree
	 * Every node with 0 or 2 children
	 * All except leaf has 2 nodes
	 * the number of leaf nodes = number of internal nodes + 1
	 * 
	 * 2) Complete tree
	 * All level completely filled except last level
	 * Last level has all keys as left as possible
	 * 
	 * 3) Perfect tree
	 * All nodes have tw children
	 * All leaf nodes at same level
	 * No of Node = 2^h -1
	 * 
	 * Properties of binary tree
	 * 1) Maximum number of nodes in level l = ( 2^(l-1) )
	 * 2) Binary tree with L leaves has minimum level l= Log2(L)+1
	 * 
	 * 3) Maximum number of nodes in Tree heaight h = ( 2^h -1 )
	 * 4) Binary tree with N nodes , minimum height h= Log2( N+1)
	 * 
	 * 5)Binary node has 0 or 2 children Full tree
	 * Number of leaf nodes = 1 + Number of nodes with 2 children
	 * 
	 */
}
