package binary_Search_Tree;

/**
 * 
 * Problem #2: Design a data to 
 * Search,Insert,Delete,Kth Smallest 
 *  
 * Naive :
 * Inorder to find least 
 * For kth smallest 
 * Go to leftmost and start the count   
 * 
 * Efficient :
 * Augumented BST:
 * 
 * Additional parameter - left_count 
 * left_count= no of nodes in left subtree 
 *  
 * if left-count+1==K 
 *     ans=> root
 * if left-count+1>K
 *     go left 
 * else 
 *     check in right for value:
 *     K-left_count-1
 * 
 * @author shree
 *
 */

class BSTAugumentedSmallK{
	int key;
	int left_count;BSTAugumentedSmallK left;
	BSTAugumentedSmallK right;
	public BSTAugumentedSmallK(int d) {
		key=d;
		left_count=0;
		left=null;
		right=null;
	}
	
	public void update_count() {
		left_count=left_count+1;
	}
	
}
public class BST10_Augumented_BST_Kth_small {

	public static void main(String[] args) {
		// 

		int arr[]= {5,3,4,1,2,8,6,9};
		BSTAugumentedSmallK root=ConstructBST(arr);
		int small=SmallKthNode(root,0);
		ViewBST(root);
		System.out.println(" Small k "+small);
		
		//GoG 
		mainGFG();
	}
	
	private static int SmallKthNode(BSTAugumentedSmallK root,int K) {
		if(root==null) {
			return -1;
		}
		
		if(root.left_count==K) {
			return root.key;
		}
		
		int ans=-1;
		if(root.left_count<K) {
			ans=SmallKthNode(root.right,K);
		}
		else if(ans!=-1) {
			ans=SmallKthNode(root.left,K);
		}
		
		return ans ;
	}

	static int leftC;
	private static boolean InsertIterative(BSTAugumentedSmallK root, int data) {
		// insert terative 
		
		
		while(root!=null) {
			if(root.key==data) {
				return true;
			}
			if(root.key<data) {
				leftC=root.left_count+1;
				if(root.right==null) {
					System.out.println("root "+data+" "+leftC+" root prev"+root.key+" ..count "+root.left_count);
					root.right=new BSTAugumentedSmallK(data);
					root.right.left_count=leftC;
				    return true;
				}
				else {
					root=root.right;
				}
			}
			else {
				root.update_count();
				//leftC=root.left_count-1;

				if(root.left==null) {
					System.out.println("root "+root.key+" "+root.left_count+"...dta"+data);
					root.left=new BSTAugumentedSmallK(data);
				    return true;
				}
				else {
					root=root.left;
				}
			}
		}
		
		return false;
	}
	
	private static BSTAugumentedSmallK ConstructBST(int[] arr) {
		// construct 
		leftC=0;
		int n=arr.length;
		if(n==0) {
			return null;
		}
		BSTAugumentedSmallK root=new BSTAugumentedSmallK(arr[0]);
		for(int i=1;i<n;i++) {
			InsertIterative(root,arr[i]);
		}
		return root;
	}

	public static void ViewBST(BSTAugumentedSmallK root) {
		if(root==null) {
			return;
		}
		System.out.print(root.key+"-"+root.left_count+" ");
		ViewBST(root.left);
		System.out.print("|");
		ViewBST(root.right);
	}
	
	 public static AGNode insert(AGNode root, int x)
	    {
	        if (root == null)
	            return new AGNode(x);
	      
	        if (x < root.data) {
	            root.left = insert(root.left, x);
	            root.lCount++;
	        }
	     
	        else if (x > root.data)
	            root.right = insert(root.right, x);
	        return root;
	    }
	     
	    public static AGNode kthSmallest(AGNode root, int k)
	    {
	        if (root == null)
	            return null;
	     
	        int count = root.lCount + 1;
	        if (count == k)
	            return root;
	     
	        if (count > k)
	            return kthSmallest(root.left, k);
	     
	        return kthSmallest(root.right, k - count);
	    }
	     
	    public static void mainGFG()
	    {
	        AGNode root = null;
	        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
	     
	        for (int x : keys)
	            root = insert(root, x);
	     
	        int k = 4;
	        AGNode res = kthSmallest(root, k);
	        if (res == null)
	            System.out.println("There are less "
	                           + "than k AGNodes in the BST");
	        else
	            System.out.println("K-th Smallest"
	                    + " Element is " + res.data);
	    }
}

class AGNode {
    int data;
    AGNode left, right;
    int lCount;
    AGNode(int x)
    {
        data = x;
        left = right = null;
        lCount = 0;
    }
}


/*
 * Find Kth Smallest in BST

Given the root of a binary search tree and K as input, find Kth smallest element in BST. 
For example, in the following BST, if k = 3, then the output should be 10, and if k = 5, then the output should be 14.

 





Method 1: Using Inorder Traversal (O(n) time and O(h) auxiliary space) 
The Inorder Traversal of a BST traverses the nodes in increasing order. So the idea is to traverse the tree in Inorder. While traversing, keep track of the count of the nodes visited. If the count becomes k, print the node. 

// A simple inorder traversal based Java program
// to find k-th smallest element in a BST.

import java.io.*;
// A BST node
class Node {
    int data;
    Node left, right;
    Node(int x)
    {
        data = x;
        left = right = null;
    }
}

class GFG {

    static int count = 0;
    // Recursive function to insert an key into BST
    public static Node insert(Node root, int x)
    {
        if (root == null)
            return new Node(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }

    // Function to find k'th largest element in BST
    // Here count denotes the number of nodes processed so far
    public static Node kthSmallest(Node root, int k)
    {
        // base case
        if (root == null)
            return null;

        // search in left subtree
        Node left = kthSmallest(root.left, k);

        // if k'th smallest is found in left subtree, return it
        if (left != null)
            return left;

        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root;

        // else search in right subtree
        return kthSmallest(root.right, k);
    }

    // Function to find k'th largest element in BST
    public static void printKthSmallest(Node root, int k)
    {
        Node res = kthSmallest(root, k);
        if (res == null)
            System.out.println("There are less than k nodes in the BST");
        else
            System.out.println("K-th Smallest Element is " + res.data);
    }

    public static void main(String[] args)
    {
        Node root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
        for (int x : keys)
            root = insert(root, x);
        int k = 3;
        printKthSmallest(root, k);
    }
}

Output
K-th Smallest Element is 10
 Time complexity: O(n) where n is the number of nodes in a binary search tree.

Auxiliary Space: O(h) where h is the height of the binary search tree.


We can optimize space using Morris Traversal. Please refer K’th smallest element in BST using O(1) Extra Space for details.



Method 2: Using Any Tree Traversal (pre-in-post) than return kth smallest easily.

Approach: Here we use pre order traversal than sort it and return the kth smallest element.

Algorithm: Here we have tree we will take preorder of it as :



preorder will : 20 8 4 12 10 14 22



  And store it in array/vector.
  After taking preorder we will sort it and than return k-1 element from the array.


import java.util.*;

class Node {
	int data;
	Node left, right;
	int lCount;
	Node(int x) {
		data = x;
		left = right = null;
		lCount = 0;
	}
}

public class KthSmallestElementBST {
	// Recursive function to insert a key into BST
	static Node insert(Node root, int x) {
		if (root == null)
			return new Node(x);

		// If a node is inserted in left subtree, then lCount of
		// this node is increased. For simplicity, we are
		// assuming that all keys (tried to be inserted) are
		// distinct.
		if (x < root.data) {
			root.left = insert(root.left, x);
			root.lCount++;
		}
		else if (x > root.data)
			root.right = insert(root.right, x);
		return root;
	}

	// Preorder traversal of BST
	static void preorder(Node root, List<Integer> v) {
		if (root == null) return;
		v.add(root.data);
		preorder(root.left, v);
		preorder(root.right, v);
	}

	public static void main(String[] args) {
		Node root = null;
		int[] keys = { 20, 8, 22, 4, 12, 10, 14 };
		for (int x : keys)
			root = insert(root, x);
		int k = 4;
		List<Integer> v = new ArrayList<Integer>();
		preorder(root, v);

		// Sorting the given vector
		Collections.sort(v);

		// Finding kth smallest element
		System.out.println(v.get(k-1));
	}
}


Complexity Analysis:

Time Complexity: O(nlogn) i.e O(n) time for preorder and nlogn time for sorting.
Auxiliary Space: O(n) i.e for vector/array storage.

Method 3: Augmented Tree Data Structure (O(h) Time Complexity and O(h) auxiliary space)

The idea is to maintain the rank of each node. We can keep track of elements in the left subtree of every node while building the tree. Since we need the K-th smallest element, we can maintain the number of elements of the left subtree in every node.
Assume that the root is having ‘lCount’ nodes in its left subtree. If K = lCount + 1, root is K-th node. If K < lCount + 1, we will continue our search (recursion) for the Kth smallest element in the left subtree of root. If K > lCount + 1, we continue our search in the right subtree for the (K – lCount – 1)-th smallest element. Note that we need the count of elements in the left subtree only.

// A simple inorder traversal based Java program
// to find k-th smallest element in a BST.
import java.io.*;
import java.util.*;

// A BST node
class Node {
	int data;
	Node left, right;
	int lCount;
	Node(int x)
	{
		data = x;
		left = right = null;
		lCount = 0;
	}
}

class Gfg {
	// Recursive function to insert an key into BST
	public static Node insert(Node root, int x)
	{
		if (root == null)
			return new Node(x);

		// If a node is inserted in left subtree, then
		// lCount of this node is increased. For simplicity,
		// we are assuming that all keys (tried to be
		// inserted) are distinct.
		if (x < root.data) {
			root.left = insert(root.left, x);
			root.lCount++;
		}

		else if (x > root.data)
			root.right = insert(root.right, x);
		return root;
	}

	// Function to find k'th largest element in BST
	// Here count denotes the number of nodes processed so far
	public static Node kthSmallest(Node root, int k)
	{
		// base case
		if (root == null)
			return null;

		int count = root.lCount + 1;
		if (count == k)
			return root;

		if (count > k)
			return kthSmallest(root.left, k);

		// else search in right subtree
		return kthSmallest(root.right, k - count);
	}

	// main function
	public static void main(String args[])
	{
		Node root = null;
		int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

		for (int x : keys)
			root = insert(root, x);

		int k = 4;
		Node res = kthSmallest(root, k);
		if (res == null)
			System.out.println("There are less than k nodes in the BST");
		else
			System.out.println("K-th Smallest Element is " + res.data);
	}
}

// This code is contributed by Aditya Kumar (adityakumar129)

Output
K-th Smallest Element is 12


Time complexity: O(h) where h is the height of the tree.
Auxiliary Space: O(h)

Method 4: Iterative approach using Stack: The basic idea behind the Iterative Approach using Stack to find the kth smallest element in a Binary Search Tree (BST) is to traverse the tree in an inorder fashion using a stack until we find the kth smallest element. Follow the steps to implement the above idea:

Create an empty stack and set the current node to the root of the BST.
Push all the left subtree nodes of the current node onto the stack until the current node is NULL.
Pop the top node from the stack and check if it is the k-th element. If it is, return its value.
Decrement the value of k by 1.
Set the current node to the right child of the popped node.
Go to step 2 if the stack is not empty or k is not equal to 0.
Below is the implementation of the above approach:

import java.util.Stack;

class Node {
	int data;
	Node left, right;

	Node(int key) {
		data = key;
		left = right = null;
	}
}

class GFG {
	static Node insert(Node root, int key) {
		if (root == null)
			return new Node(key);

		if (key < root.data)
			root.left = insert(root.left, key);
		else if (key > root.data)
			root.right = insert(root.right, key);

		return root;
	}

	static int kthSmallest(Node root, int k) {
		Stack<Node> stack = new Stack<>();

		while (root != null || !stack.empty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();

			if (--k == 0)
				return root.data;

			root = root.right;
		}

		return -1;
	}

	public static void main(String[] args) {
		Node root = null;
		int[] keys = { 20, 8, 22, 4, 12, 10, 14 };

		for (int x : keys)
			root = insert(root, x);

		int k = 4;
		int kth_smallest = kthSmallest(root, k);
		if (kth_smallest != -1)
			System.out.println("K-th smallest element in BST is: " + kth_smallest);
		else
			System.out.println("Invalid input");
	}
}


Output
K-th smallest element in BST is: 12

Time Complexity: O(h+ k), The time complexity of the Iterative Approach using Stack to find the kth smallest element in a BST is O(h + k), where h is the height of the BST and k is the value of k.

Auxiliary Space: O(h+k), The space complexity of the code is O(h + k), where h is the height of the BST and k is the maximum size of the stack. 


 * 
 * 
 */
