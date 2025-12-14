package tree_Data_Structure;

/**
 *  Tree Data Structure 
 *  ----- Hierarchy Data structure 
 *  ----- Non Linear Data Structure 
 *      root child1 child2 child3 child4 .....
 *      data addr   addr   addr   addr   .....
 *  Types of tree:
 *  ->Self balancing tree - best for search , insert,delete - O LogN
 *    ---> AVL Tree 
 *    ---> Red Black Tree       
 *  ->Binary Tree
 *  ->Binary SEarch tree
 *  ->Heap
 *  ->B- tree , B+ Tree
 *  ->Syntax tree
 *  -> K- D tree
 *  -> Trie
 *  -> Sufix tree
 *  ->Spanning tree
 *  
 *  
 *  Example : CEO--manager--TL--employee
 *  File management : root folder--sub --file
 *   
 *  Non Linear :
 *  Tree does not store in sequential manner 
 *  Tree store as node , degree
 *                   root - parent - ancestors
 *                   leaf - child  - descendants
 *                   subtree
 *  
 *  Root - start of tree
 *  child - node below a node 
 *  parent - node above a node 
 *  leaf - node without a child 
 *  Descendants - all nodes considering current as root node in subtree
 *  ancestors - all nodes considering current as child node 
 *  Degree - No of children a node has 
 *  Leaf node degree - is 0 
 *  Internal node - Node that don't have 0 degree / Nodes other than leaf node 
 *  
 * 
 *  Tree is recursive in nature 
 *  Tree has even more trees ...called sub trees.
 *  
 *  Applications of tree :
 *  
 *  --> To represent hierarchical data 
 *                --->Organization structure 
 *                --->Folder structure 
 *                ---> XML / HTML content - JSON Objects 
 *                ---> In OOP - Inheritance 
 *  --> Binary Search Trees - linked list implementation 
 *  --> Binary Heap - array implementation
 *  --> B and B+ Trees in Database Management structure - indexing 
 *  --> Spanning trees  used in bridges for forwarding packets 
 *  --> Shortest path trees used in routes - with routers as root 
 *  --> Parse tree , Expression tree - used in compiler 
 *  --> Tri e - prefix search , dictionary 
 *  --> Suffix Tree - search patterns in strings in O M pattern length 
 *  --> Binary Index tree - Range query search
 *  --> Segment tree - Range query search - array implementation
 *   
 *  
 *  Binary tree :
 *  Most popular and common tree 
 *  Every node has at most 2 children 
 *  Degree of node =< 2
 *  address | data | address
 *     left | root | right
 *  
 *  
 *  left child - left reference 
 *  right child - right reference 
 *  leaf - left and right is null 
 *  
 *  Example : root 30 
 *                
 *                left  30  right
 *               /               \
 *        left 40 null      left 50 right
 *       /                 /             \ 
 * left 70 right    null 60 null     null 80 null     
 *                
 *  
 * Types of Binary tree :
 * 
 * 1) Full tree 
 *    Every node with 0 or 2 children 
 *    All except leaf has 2 nodes
 *    the number of leaf nodes = number of internal nodes + 1
 *    
 * 2) Complete tree
 *    All level completely filled except last level 
 *    Last level has all keys as left as possible 
 *    
 * 3) Perfect tree
 *    All nodes have tw children 
 *    All leaf nodes at same level
 *    No of Node = 2^h -1
 * 
 * Properties of binary tree 
 * 1) Maximum number of nodes in level l = ( 2^(l-1) )
 * 2) Binary tree with L leaves has minimum level l= Log2(L)+1
 * 
 * 3) Maximum number of nodes in Tree heaight h = ( 2^h -1 )  
 * 4) Binary tree with N nodes , minimum height h= Log2( N+1)
 * 
 * 5)Binary node has 0 or 2 children Full tree 
 *     Number of leaf nodes = 1 + Number of nodes with 2 children
 * 
 * @author shree
 *
 */

class BTNode{
	int key;
	BTNode left;
	BTNode right;
	public BTNode(int k) {
		key=k;
		left=null;
		right=null;
	}
	
	public void print(BTNode root) {
		System.out.println(root.key);
		if(left==null && right==null) {
			return;
		}
		if(left!=null) {
			System.out.print(" "+left.key);
		}
		if(right!=null) {
			System.out.print(" "+right.key);
		}
		
		if(left!=null) {
			print(left);
		}
		if(right!=null) {
			print(right);
		}
		
		
	}
}
public class Tree01_Intro {

	public static void main(String[] args) {
		// Binary tree 
		
		BTNode root=new BTNode(10);
		root.left=new BTNode(20);
		root.right=new BTNode(30);
		root.left.left=new BTNode(40);
		root.left.right=new BTNode(50);
		root.right.right=new BTNode(60);
		
		//Below exception 
		root.print(root);
		

	}

}
/**
 * Introduction to Trees


A Tree is a non-linear data structure where each node is connected to a number of nodes with the help of pointers or references.


A Sample tree is as shown below:


Basic Tree Terminologies:
Root: The root of a tree is the first node of the tree. In the above image, the root node is the node 30.
Edge: An edge is a link connecting any two nodes in the tree. For example, in the above image there is an edge between node 11 and 6.
Siblings: The children nodes of same parent are called siblings. That is, the nodes with same parent are called siblings. In the above tree, nodes 5, 11, and 63 are siblings.
Leaf Node: A node is said to be the leaf node if it has no children. In the above tree, node 15 is one of the leaf nodes.
Height of a Tree: Height of a tree is defined as the total number of levels in the tree or the length of the path from the root node to the node present at the last level. The above tree is of height 2.


Binary Tree


A Tree is said to be a Binary Tree if all of its nodes have atmost 2 children. That is, all of its node can have either no child, 1 child, or 2 child nodes.


Below is a sample Binary Tree:


Properties of a Binary Tree:
The maximum number of nodes at level 'l' of a binary tree is (2l - 1). Level of root is 1. This can be proved by induction. For root, l = 1, number of nodes = 21-1 = 1 Assume that the maximum number of nodes on level l is 2l-1. Since in Binary tree every node has at most 2 children, next level would have twice nodes, i.e. 2 * 2l-1.
Maximum number of nodes in a binary tree of height 'h' is (2h – 1). Here height of a tree is the maximum number of nodes on the root to leaf path. The height of a tree with a single node is considered as 1. This result can be derived from point 2 above. A tree has maximum nodes if all levels have maximum nodes. So maximum number of nodes in a binary tree of height h is 1 + 2 + 4 + .. + 2h-1. This is a simple geometric series with h terms and sum of this series is 2h – 1. In some books, the height of the root is considered as 0. In that convention, the above formula becomes 2h+1 – 1.
In a Binary Tree with N nodes, the minimum possible height or the minimum number of levels is Log2(N+1). This can be directly derived from point 2 above. If we consider the convention where the height of a leaf node is considered 0, then above formula for minimum possible height becomes Log2(N+1) – 1.
A Binary Tree with L leaves has at least (Log2L + 1) levels. A Binary tree has maximum number of leaves (and minimum number of levels) when all levels are fully filled. Let all leaves be at level l, then below is true for number of leaves L.
   L   <=  2l-1  [From Point 1]
   l =  Log2L + 1 
   where l is the minimum number of levels. 

In a Binary tree in which every node has 0 or 2 children, the number of leaf nodes is always one more than the nodes with two children.
   L = T + 1
Where L = Number of leaf nodes
   T = Number of internal nodes with two children



Types of Binary Trees: Based on the structure and number of parents and children nodes, a Binary Tree is classified into the following common types:
Full Binary Tree: A Binary Tree is full if every node has either 0 or 2 children. The following are examples of a full binary tree. We can also say that a full binary tree is a binary tree in which all nodes except leave nodes have two children.






In a Full Binary, the number of leaf nodes is number of internal nodes plus 1.

Complete Binary Tree: A Binary Tree is a complete Binary Tree if all levels are completely filled except possibly the last level and the last level has all keys as left as possible Following are the examples of Complete Binary Trees:




Perfect Binary Tree: A Binary tree is a Perfect Binary Tree when all internal nodes have two children and all the leave nodes are at the same level. Following are the examples of Perfect Binary Trees:


 

A Perfect Binary Tree of height h (where height is the number of nodes on the path from the root to leaf) has 2h – 1 node.

 * 
 * 
 * 
 */

/*
 * Application of Tree



What is Tree ?
Tree is collection of nodes. A tree is a hierarchical data structure. Tree is a non-linear data structure which contains nodes and edges. 

Terminologies :

According to the above example image of tree

Nodes : 1 2 3 4 5 6 7 8 9 10 11 13 14

Root : 1

Internal Nodes : 1 2 3 4 5 6 7

External nodes :  8 9 10 11 13 14

(Parent , Child) : (1, 2 and 3), (2, 4 and 5), (3, 6 and 7),(4, 8 and 9), (5, 10 and 11) , (6, 13) , (7,14)

Siblings : (2, 3) , (4, 5), (6, 7), (8, 9), (10, 11)

Why Tree? 
Unlike Array and Linked List, which are linear data structures, tree is hierarchical (or non-linear) data structure. 

One reason to use trees might be because you want to store information that naturally forms a hierarchy. For example, the file system on a computer: 
                                            file system
                                                 /   <-- root
                                             /      \
                                           ...      home
                                                   /        \
                                           ugrad       course
                                               /            /    |    \
                                           ...        cs101 cs112 cs113
If we organize keys in form of a tree (with some ordering e.g., BST), we can search for a given key in moderate time (quicker than Linked List and slower than arrays). Self-balancing search trees like AVL and Red-Black trees guarantee an upper bound of O(Logn) for search.
We can insert/delete keys in moderate time (quicker than Arrays and slower than Unordered Linked Lists). Self-balancing search trees like AVL and Red-Black trees guarantee an upper bound of O(Logn) for insertion/deletion.
Like Linked Lists and unlike Arrays, Pointer implementation of trees don’t have an upper limit on number of nodes as nodes are linked using pointers.



Other Applications : 
 

Store hierarchical data, like folder structure, organization structure, XML/HTML data.
Binary Search Tree is a tree that allows fast search, insert, delete on a sorted data. It also allows finding closest item
Heap is a tree data structure which is implemented using arrays and used to implement priority queues.
B-Tree and B+ Tree : They are used to implement indexing in databases.
Syntax Tree:  Scanning, parsing , generation of code and evaluation of arithmetic expressions in Compiler design.
K-D Tree: A space partitioning tree used to organize points in K dimensional space.
Trie : Used to implement dictionaries with prefix lookup.
Suffix Tree : For quick pattern searching in a fixed text.
Spanning Trees and shortest path trees are used in routers and bridges respectively in computer networks
As a workflow for compositing digital images for visual effects.
Decision trees.
Organization chart of a large organization.
In XML parser.
Machine learning algorithm.
For indexing in database.
IN server like DNS (Domain Name Server)
In Computer Graphics.
To evaluate an expression.
In chess game to store defense moves of player.
In java virtual machine.
 * 
 * 
 */
