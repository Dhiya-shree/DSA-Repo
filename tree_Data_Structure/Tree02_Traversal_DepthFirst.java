package tree_Data_Structure;

/**
 * 
 * Tree Traversal 
 * Traversal to visit all nodes exactly once 
 *    1) Breadth first or Level Order
 *           Visit the root and print
 *           Print the left and right 
 *           Visit left --> left and right 
 *           Visit right --> left and right
 *    2) Depth Order 
 *         -->In order 
 *         -->Post order 
 *         -->Pre order 
 * 
 * 
 *   Depth first traversal :
 *     1) Print root 
 *     2) Process left sub tree as root - recursive
 *     3) Process right sub tree as root - recursive
 *     
 *  There are total 3! = 6 ways we can traverse 
 *  Best 3 ways and commonly used are :
 *  1) In order ====> left root right 
 *       a) left sub tree 
 *       b) root key 
 *       c) right sub tree 
 *  
 *  2) Pre order ====> root left right
 *       a) root key 
 *       b) left sub tree 
 *       c) right sub tree
 *       
 *  3) Post order ====> left right root
 *       a) left sub tree 
 *       b) right sub tree
 *       c) root key 
 * 
 *Example : 
 *           10
 *           /\
 *         20  30
 *        / \    \
 *      40   50   60
 *          / \
 *         70  80
 *          
 *   In order : 40 20 | 70 50 80 | 10 | 30 60 
 *  Pre order : 10 |20 40 | 50 70 80 | 30 60
 *  Post order: 40 | 70 80 50 | 20 | 60 | 30 | 10
 *
 * @author shree
 *
 */
public class Tree02_Traversal_DepthFirst {

	public static void main(String[] args) {
		// Binary tree 

		BTNode root = new BTNode(10);
		root.left = new BTNode(20);
		root.right = new BTNode(30);
		root.left.left = new BTNode(40);
		root.left.right = new BTNode(50);
		root.right.right = new BTNode(60);
		root.left.left.left = new BTNode(400);
		root.left.left.left.left = new BTNode(4000);

		// Below exception
		//System.out.println(root.key);
		printBT(root);
		
		// TRaversal 
		//Time O N 
		// SPace - Number of recursive call being made 
		//At each sub tree call being made 
		// So space - O height of tree +1 
		// Height - no of node in the longest path hj
		// High order of the tree from root to leaf 
		InOrderTraversal(root);
	    InOrderTraversalGoG(root);
	    System.out.println();
	    
	    PreOrderTraversal(root);
	    
	    System.out.println();
	    
	    PostOrderTraversal(root);

	   int h= HeightOfTree(root);
	   // Maximum number of edges from root to leaf 
	    System.out.println(" Height "+h);
	    //Time O N 
	    // Space O h
	    
	    h=HeightOfTreeGoG(root);
	    System.out.println(" Height gog "+h);
	    
	    // Print
	}
	
	private static int HeightOfTreeGoG(BTNode root) {
		//simple
		if(root==null) {
			return 0;
		}
		
		int h=Math.max(  HeightOfTreeGoG(root.left)
				, HeightOfTreeGoG(root.right));
		h=h+1;//For root
		return h;
	}

	private static int HeightOfTree(BTNode root) {
		// height of tree
		BTNode left=root.left;
		BTNode right=root.right;
		int left_h=1;
		int right_h=1;
		if(left!=null) {
			left_h=left_h+(HeightOfTree(left));
		}
		if(right!=null) {
			right_h=right_h+(HeightOfTree(right));
		}
		
		return(Math.max(left_h, right_h));
		
	}

	private static void PostOrderTraversal(BTNode root) {
		//  left right root
		if (root != null) {
			PostOrderTraversal(root.left);
			PostOrderTraversal(root.right);
			System.out.print(root.key + " ");
			
		}
		
	}

	private static void PreOrderTraversal(BTNode root) {
		// root left right
		if(root!=null) {
			System.out.print(root.key+" ");
			PreOrderTraversal(root.left);
			PreOrderTraversal(root.right);
			}
	}

	private static void InOrderTraversalGoG(BTNode root) {
		// left root right 
		if(root!=null) {
		InOrderTraversalGoG(root.left);
		System.out.print(root.key+" ");
		InOrderTraversalGoG(root.right);
		}
	//	System.out.println();
		
	}

	public static void InOrderTraversal(BTNode root) {
		// left root right 
		if(root.left!=null) {
			InOrderTraversal(root.left);
		//	System.out.print(root.left.key+" ");
		}
		System.out.print(root.key+" ");
		if(root.right!=null) {
			InOrderTraversal(root.right);
			//System.out.print(root.left.key+" ");
		}
		System.out.println();
	}

	public static void printBT(BTNode root) {
		System.out.print(root.key+" ");
		if(root.left==null && root.right==null) {
			return;
		}
//		if(root.left!=null) {
//			System.out.print(" "+root.left.key);
//		}
//		if(root.right!=null) {
//			System.out.print(" "+root.right.key);
//		}
		
		if(root.left!=null) {
		//	System.out.println();
			printBT(root.left);
		}
		if(root.right!=null) {
		//	System.out.println();
			printBT(root.right);
		}
		System.out.println();
		
		
		
	}

}

/**
Binary Tree Traversals

Unlike linear data structures (Array, Linked List, Queues, Stacks, etc.), which have only one logical way to traverse them, trees can be traversed in different ways. Following are the generally used ways for traversing trees:

Example Tree

Inorder (Left, Root, Right) : 4 2 5 1 3
Preorder (Root, Left, Right) : 1 2 4 5 3.
Postorder (Left, Right, Root) : 4 5 2 3 1


Let's look at each of these tree traversal algorithms in details:
Inorder Traversal: In Inorder traversal, a node is processed after processing all the nodes in its left subtree. The right subtree of the node is processed after processing the node itself.
Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., 
      call Inorder(left->subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., 
      call Inorder(right->subtree)

Example: Inorder traversal for the above-given tree is 4 2 5 1 3.
Preorder Traversal: In preorder traversal, a node is processed before processing any of the nodes in its subtree.
Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., 
      call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., 
      call Preorder(right-subtree) 

Example: Preorder traversal for the above-given tree is 1 2 4 5 3.
Postorder Traversal: In post order traversal, a node is processed after processing all the nodes in its subtrees.
Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., 
      call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., 
      call Postorder(right-subtree)
   3. Visit the root.

Example: Postorder traversal for the above-given Tree is 4 5 2 3 1.



// Java program for different tree traversals

//* Class containing left and right child of current
 //  node and key value
class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

class BinaryTree
{
    // Root of Binary Tree
    Node root;

    BinaryTree()
    {
        root = null;
    }

    // Method to print postorder traversal.
    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    // Method to print inorder traversal
    void printInorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left child //
        printInorder(node.left);

        // then print the data of node //
        System.out.print(node.key + " ");

        // now recur on right child //
        printInorder(node.right);
    }

    // Method to print preorder traversal
    void printPreorder(Node node)
    {
        if (node == null)
            return;

        // first print data of node //
        System.out.print(node.key + " ");

        // then recur on left sutree //
        printPreorder(node.left);

        // now recur on right subtree //
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder() {     printPostorder(root); }
    void printInorder() {     printInorder(root); }
    void printPreorder() {     printPreorder(root); }

    // Driver method
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }
}

Output:
Preorder traversal of binary tree is
1 2 4 5 3 
Inorder traversal of binary tree is
4 2 5 1 3 
Postorder traversal of binary tree is
4 5 2 3 1



*/

/*
Binary Tree

A binary tree is a tree data structure composed of nodes, each of which has at most, two children, referred to as left and right nodes and the tree begins from root node.

Representation of Binary Tree:
Each node in the tree contains the following:

Data
Pointer to the left child
Pointer to the right child
 Binary Tree
This is the most typical representation of Binary Tree, but we have some other representation of trees as well, For example Binary Heap and Segment tree can be easily represented using Arrays. But in general when we talk about Binary tree or Binary Search Tree, they are typically represented using the linked structure.

 

Why do we study Binary Tree and not general n-array tree, where a node can have n number off children?

The reason is the most popular tree data structure that is used a lot is based on Binary Tree. Binary Search Tree is the most used tree data structure and it is a binary tree variation. Binary Heap is also a popular tree data structure, which is used to represent priority queues, is also a binary tree data structure. Segment tree data structure which is used for range queries is also a binary tree data structure. So most of the practically used and popular data structure are Binary Tree variation, that is why we study binary tree most if the times in academics.

 

In CPP/Java, we can use classes as part of their OOP feature. Below is an example of a tree node with integer data.

// Class containing left and right child
// of current node and key value
class Node {
	int key;
	Node left, right;

	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}
 

Implementation of Binary Tree:
Let us create a simple tree with 4 nodes. The created tree would be as follows. 

       1    <-- root
     /   \
    2     3  
   /   
  4
Below is the Implementation of the binary tree:

// Class containing left and right child

// of current node and key value

class Node {

	int key;

	Node left, right;

	public Node(int item)

	{

		key = item;

		left = right = null;
	}
}

// A Java program to introduce Binary Tree

class BinaryTree {

	// Root of Binary Tree

	Node root;

	// Constructors

	BinaryTree(int key) { root = new Node(key); }

	BinaryTree() { root = null; }

	public static void main(String[] args)

	{

		BinaryTree tree = new BinaryTree();

		// create root

		tree.root = new Node(1);

		/* following is the tree after above statement


  1
/    \
null null ................ //

		tree.root.left = new Node(2);

		tree.root.right = new Node(3);

		/* 2 and 3 become left and right children of 1


      1
   /      \
  2        3
/   \     /    \
null null null null //

		tree.root.left.left = new Node(4);

		/* 4 becomes left child of 2


    1
 /     \
 2       3
/ \    /    \
4  NULL NULL NULL
/ \
NULL NULL



//
	}
}


*/

/**

Implementation of Inorder, Preorder and Postorder Traversal

Unlike linear data structures (Array, Linked List, Queues, Stacks, etc) which have only one logical way to traverse them, trees can be traversed in different ways. The following are the generally used methods for traversing trees:

Example:


 
Inorder Traversal
Algorithm Inorder(tree)
Traverse the left subtree, i.e., call Inorder(left->subtree)
Visit the root.
Traverse the right subtree, i.e., call Inorder(right->subtree)
Uses of Inorder Traversal:
In the case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversal is reversed can be used. 
Example: In order traversal for the above-given figure is 4 2 5 1 3.

// Java program for different tree traversals

/* Class containing left and right child of current
node and key value
class Node {
	int key;
	Node left, right;

	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}

class BinaryTree {
	// Root of Binary Tree
	Node root;

	BinaryTree() { root = null; }

	/* Given a binary tree, print its nodes in inorder
	void printInorder(Node node)
	{
		if (node == null)
			return;

		//* first recur on left child 
		printInorder(node.left);

		//* then print the data of node 
		System.out.print(node.key + " ");

		//* now recur on right child 
		printInorder(node.right);
	}

	// Wrappers over above recursive functions
	void printInorder() { printInorder(root); }

	// Driver code
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function call
		System.out.println(
			"\nInorder traversal of binary tree is ");
		tree.printInorder();
	}
}
 

Preorder Traversal
Algorithm Preorder(tree)

Visit the root.
Traverse the left subtree, i.e., call Preorder(left->subtree)
Traverse the right subtree, i.e., call Preorder(right->subtree) 
Uses of Preorder:
Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expressions on an expression tree.
Example: Preorder traversal for the above-given figure is 1 2 4 5 3.

// Java program for different tree traversals

/* Class containing left and right child of current
node and key value
class Node {
	int key;
	Node left, right;

	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}

class BinaryTree {
	// Root of Binary Tree
	Node root;

	BinaryTree() { root = null; }

	//* Given a binary tree, print its nodes in preorder
	void printPreorder(Node node)
	{
		if (node == null)
			return;

		//* first print data of node 
		System.out.print(node.key + " ");

		//* then recur on left subtree 
		printPreorder(node.left);

		//* now recur on right subtree 
		printPreorder(node.right);
	}

	// Wrappers over above recursive functions
	void printPreorder() { printPreorder(root); }

	// Driver code
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function call
		System.out.println(
			"Preorder traversal of binary tree is ");
		tree.printPreorder();
	}
}
 

Postorder Traversal
Algorithm Postorder(tree)

Traverse the left subtree, i.e., call Postorder(left->subtree)
Traverse the right subtree, i.e., call Postorder(right->subtree)
Visit the root
Uses of Postorder:
Postorder traversal is used to delete the tree. Postorder traversal is also useful to get the postfix expression of an expression tree
Example: Postorder traversal for the above-given figure is 4 5 2 3 1

Below is the implementation of the above traversal methods:

// Java program for different tree traversals

/* Class containing left and right child of current
node and key value
class Node {
	int key;
	Node left, right;

	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}

class BinaryTree {
	// Root of Binary Tree
	Node root;

	BinaryTree() { root = null; }

	/* Given a binary tree, print its nodes according to the
	"bottom-up" postorder traversal. 
	void printPostorder(Node node)
	{
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	// Wrappers over above recursive functions
	void printPostorder() { printPostorder(root); }

	// Driver code
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function call
		System.out.println(
			"\nPostorder traversal of binary tree is ");
		tree.printPostorder();
	}
}
 

Output

Preorder traversal of binary tree is 
1 2 4 5 3 
Inorder traversal of binary tree is 
4 2 5 1 3 
Postorder traversal of binary tree is 
4 5 2 3 1 
Time Complexity: O(N)
Auxiliary Space: If we don’t consider the size of the stack for function calls then O(1) otherwise O(h) where h is the height of the tree. 

Note: The height of the skewed tree is n (no. of elements) so the worst space complexity is O(N) and the height is (Log N) for the balanced tree so the best space
complexity is O(Log N).


*/