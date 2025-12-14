package tree_Data_Structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem #1 : Print nods at distance K 
 * 
 *    Kth node depth of nodes 
 *    K=0 root node
 * 
 * Problem #2 : Size of binary tree
 *  
 *     Size - no of nodes in a tree 
 *     Recursion 
 *     Consider every node as subnode 
 *     
 *     Time ON 
 *     Space O H - recursive stack 
 *     
 *     Iterative Solution :
 *     Use q to put all and count the size of queue 
 *     
 *     O N and space O N
 *     
 *     Size - Count nodes 
 * 
 * Normal tree
 * Recursive :
 *   Use any traversal 
 *   Use a static count / pass count 
 *   At each level add 1 
 *   
 * Iterative :
 *   Use queue 
 *   Use level order 
 *   Find the count at each pop 
 * 
 * 
 *  Problem #3 : Maximum value of binary tree
 *  
 *  Recursive 
 *     O N 
 *     O H space - recursive stack
 *    
 *    
 *  Skewed binary tree ? -> Use iterative - 1 value at a level 
 *  Perfect tree ? -> Use Recursive 
 *  
 *  
 *  Problem #4 :
 *  
 *  
 *  Problem #5: Height of tree
 *  
 * @author shree
 *
 */
public class Tree04_sums_easy {

	public static void main(String[] args) {
		BTNode root = new BTNode(10);
		root.left = new BTNode(20);
		root.right = new BTNode(30);
		root.left.left = new BTNode(40);
		root.left.right = new BTNode(50);
		root.left.right.right = new BTNode(500);
		root.right.right = new BTNode(60);
		root.right.right.right = new BTNode(400);
		root.right.right.right.left = new BTNode(4000);
		
		
		int k=2;//Level
		
		PrintNodeAtK(root,k);
				

		k=sizeOfBinaryTree(root);
		System.out.println(" Size "+k);
		
		
		k=MaximuminBinaryTree(root);
		System.out.println(" Maximum "+k);
		k=HeightOfTree(root);
		System.out.println(" Height "+k);
		
		
		int ani=CountNodesRecursive(root);
	    System.out.println(" Count of nodes "+ani);
	
	    ani=CountNodesIterative(root);
	    System.out.println(" Count of nodes "+ani);
	}

	private static int CountNodesIterative(BTNode root) {
		if(root==null) {
			System.out.println(" Empty ");
			return 0;
		}
		
	
		Queue<BTNode> q=new LinkedList<>();
		q.add(root);int size=0;
		int count=0;BTNode curr;
		while(!q.isEmpty()) {
			
			count=q.size();
			
			System.out.println("count "+count);
			//Here instead of count , we can not use q.size 
			// Queue will not be empty and dynamically grow everytime 
			//CAUTION !!!!!!!!!!
			for(int i=0;i<count;i++) {
				curr=q.poll();
				size++;
				if(curr.left!=null) {
					q.offer(curr.left);
				}
				if(curr.right!=null) {
					q.offer(curr.right);
				}
				System.out.print(curr.key+" ");
			}
			System.out.println();
		
		}
		return size;
	}

	private static int CountNodesRecursive(BTNode root) {
		//recurive for count nodes 
		// ON time , ON stack space 
		if(root==null) {
			return 0;
		}
		int left=CountNodesRecursive(root.left);
		int right=CountNodesRecursive(root.right);
		int total=left+right+1;
		return total;
	}
	

	 static int HeightOfTree(BTNode root) {
		 if(root==null) {
			 return 0;
		 }
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
	
	
	//static int min=Integer.MIN_VALUE;
	private static int MaximuminBinaryTree(BTNode root) {
		// Maximim value of tree
		int max=Integer.MIN_VALUE;;
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		max=Math.max(root.key,MaximuminBinaryTree(root.left));
		max=Math.max(MaximuminBinaryTree(root.right), max);
		return max;
	}

	private static int sizeOfBinaryTree(BTNode root) {
		// Size of bbinary node 
		
		if(root==null) {
			return 0;
		}
		
		int s= sizeOfBinaryTree(root.left)+sizeOfBinaryTree(root.right);
		s=s+1;// For curr value 
		
		return s;
	}

	private static void PrintNodeAtK(BTNode root,int k) {
		// K-0 root node , print all nodes at level K 
		
		if(k==0) {
			System.out.println(root.key);
			return;
			
		}
	
		BTNode left=root.left;
		BTNode right=root.right;
		if(left!=null) {
			PrintNodeAtK(left,k-1);
		}
		if(right!=null) {
			PrintNodeAtK(right,k-1);
		}
		
	}

}

/*
 * 
 * Print Nodes at K Distance

Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root. 
For example, in the below tree, 4, 5 & 8 are at distance 2 from root. 

            1
          /   \
        2      3
      /  \    /
    4     5  8 
The problem can be solved using recursion. Thanks to eldho for suggesting the solution. 

Implementation:

// Java program to print nodes at k distance from root

/* A binary tree node has data, pointer to left child
and a pointer to right child *
class Node
{
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree
{
	Node root;

	void printKDistant(Node node, int k)
	{
		if (node == null|| k < 0 )
			//Base case
			return;
		if (k == 0)
		{
			System.out.print(node.data + " ");
			return;
		}
	//recursively traversing
			printKDistant(node.left, k - 1);
			printKDistant(node.right, k - 1);
		
	}
	
	/* Driver program to test above functions *
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		
		/* Constructed binary tree is
				1
			/ \
			2	 3
			/ \ /
		4 5 8
		*
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);

		tree.printKDistant(tree.root, 2);
	}
}

// This code has been contributed by Mayank Jaiswal
 

Output

4 5 8 
Time Complexity: O(n) where n is number of nodes in the given binary tree.

Space Complexity : O(height of the binary tree).

Note-

If it’s true print the node – Always check the K distance == 0 at every node
the left or right subtree – Decrement the distance by 1 when you are passing to its subtree 
 * 
 * 
 */

/**
 * 
 * 
 * Height of Binary Tree

Given a binary tree, the task is to find the height of the tree. Height of the tree is the number of edges in the tree from the root to the deepest node, Height of the empty tree is 0.
 

Example Tree

 

Recursively calculate height of left and right subtrees of a node and assign height to the node as max of the heights of two children plus 1. See below pseudo code and program for details.

Illustration:

 

Consider the following graph:

Example Tree

maxDepth(‘1’) = max(maxDepth(‘2’), maxDepth(‘3’)) + 1 = 2 + 1

because recursively 
maxDepth(‘2’) =  max (maxDepth(‘4’), maxDepth(‘5’)) + 1 = 1 + 1 and  (as height of both ‘4’ and ‘5’ are 1)
maxDepth(‘3’) = 1

Follow the below steps to Implement the idea:

Recursively do a Depth-first search.
If the tree is empty then return -1
Otherwise, do the following
Get the max depth of the left subtree recursively  i.e. call maxDepth( tree->left-subtree)
Get the max depth of the right subtree recursively  i.e. call maxDepth( tree->right-subtree)
Get the max of max depths of left and right subtrees and add 1 to it for the current node.
max_depth = max(max dept of left subtree,  max depth of right subtree) + 1
Return max_depth.
Below is the Implementation of the above approach:

// Java program to find height of tree

// A binary tree node
class Node {
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	/* Compute the "maxDepth" of a tree -- the number of
	nodes along the longest path from the root node
	down to the farthest leaf node.
	int maxDepth(Node node)
	{
		if (node == null)
			return 0;
		else {
			//* compute the depth of each subtree 
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			//* use the larger one 
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	//* Driver program to test above functions 
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Height of tree is "
						+ tree.maxDepth(tree.root));
	}
}
 

Output

Height of tree is 3
Time Complexity: O(N) (Please see our post Tree Traversal for details)
Auxiliary Space: O(N) due to recursive stack.


 * 
 */

/*
 * Maximum in Binary Tree

Given a Binary Tree, find the maximum(or minimum) element in it. For example, maximum in the following Binary Tree is 9.

1T

In Binary Search Tree, we can find maximum by traversing right pointers until we reach the rightmost node. But in Binary Tree, we must visit every node to figure out maximum. So the idea is to traverse the given tree and for every node return maximum of 3 values. 

Node’s data.
Maximum in node’s left subtree.
Maximum in node’s right subtree.
Below is the implementation of above approach. 

// Java code to Find maximum (or minimum) in
// Binary Tree

// A binary tree node
class Node {
	int data;
	Node left, right;

	public Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	// Returns the max value in a binary tree
	static int findMax(Node node)
	{
		if (node == null)
			return Integer.MIN_VALUE;

		int res = node.data;
		int lres = findMax(node.left);
		int rres = findMax(node.right);

		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

	/* Driver code 
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(2);
		tree.root.left = new Node(7);
		tree.root.right = new Node(5);
		tree.root.left.right = new Node(6);
		tree.root.left.right.left = new Node(1);
		tree.root.left.right.right = new Node(11);
		tree.root.right.right = new Node(9);
		tree.root.right.right.left = new Node(4);

		// Function call
		System.out.println("Maximum element is "
						+ tree.findMax(tree.root));
	}
}

// This code is contributed by Kamal Rawal
 

Output

Maximum element is 11
Complexity Analysis:

Time Complexity: O(N).
In the recursive function calls, every node of the tree is processed once and hence the complexity due to the function is O(N) if there are total N nodes in the tree. Therefore, the time complexity is O(N).

Space Complexity: O(N).
Recursive call is happening. The every node is processed once and considering the stack space, the space complexity will be O(N).


 * 
 */








/**

Size of Binary Tree

Size of a tree is the number of elements present in the tree. Size of the below tree is 5. 
 

Example Tree


Size() function recursively calculates the size of a tree. It works as follows:
Size of a tree = Size of left subtree + 1 + Size of right subtree.

 

Algorithm: 

size(tree)
1. If tree is empty then return 0
2. Else
     (a) Get the size of left subtree recursively  i.e., call 
          size( tree->left-subtree)
     (a) Get the size of right subtree recursively  i.e., call 
          size( tree->right-subtree)
     (c) Calculate size of the tree as following:
            tree_size  =  size(left-subtree) + size(right-
                               subtree) + 1
     (d) Return tree_size
 

// A recursive Java program to calculate the size of the
// tree

/* Class containing left and right child of current
   node and key value*
class Node {
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

/* Class to find size of Binary Tree *
class BinaryTree {
    Node root;

    // Function to return the size of binary tree
    int size() { return size(root); }

    /* computes number of nodes in tree *
    int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return (size(node.left) + 1 + size(node.right));
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes *
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The size of binary tree is : "
                           + tree.size());
    }
}
Output:  

Size of the tree is 5
Time Complexity: O(N)

As every node is visited once.

Auxiliary Space: O(N)

The extra space is due to the recursion call stack and the worst case occurs when the tree is either left skewed or right skewed.

Since this program is similar to traversal of tree, time and space complexities will be same as Tree traversal 




*/
