package binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BST :
 * Insert
 * Delete
 * Search
 *
 * 
 * INSERT:
 * Do not insert of key already presents
 * Inset in leaf if not present
 * 
 * stop if insert==root
 * Go left if insert is small
 * Go right otherwise
 * 
 * DELETION :
 * Leaf - just delete
 * Only child - just swap and delete
 * Root / internal node
 * 
 * For root once data found :
 * Swap with right data till null
 * or Swap with left data till null
 * WRONG
 * 
 * CAN NOT SWAP ALL
 * 50
 * / \
 * 30 70
 * / \ / \
 * 10 40 60 80
 * 
 * For deleteing 50 , if swapped all right
 * 70
 * / \
 * 30 80
 * / \ / \
 * 10 40 60 NULL
 * Not a BST anymore
 * 
 * If taking left , need to take left right
 * Swap 40 and 50
 * 
 * If taking right , need left of right
 * Swap 60 and 50
 * 
 * 
 * ABOVE THOUGHT IS WRONG ////
 * 
 * 
 * DELETION of internal node :
 * 
 * Find the closed small /big value and swap it
 * Successor Closest small number -> left most leaf
 * Successor Closest big number -> right most
 * 
 *
 * 
 * SEARCH :
 * Consider the root
 * Navigate left and right based on the data to search
 * 
 * Binary tree -> providing faster search
 * Search for 60
 * 
 * 50
 * / \
 * 30 70
 * / \ / \
 * 10 40 60 80
 * 
 * Root = 50 , search 60 >50
 * Go to right side
 * 
 * Root.right=70 , search 60<70
 * Go to left side
 * 
 * Root.right.left=60 , search==60
 * Stop
 * 
 * Adv:
 * No need to backtrace in tree
 * Value might be present in right side of tree or not at all
 * No chances of value to be present in other side tree
 * 
 * Seach for 90 :
 * Root = 50 , search 90 >50
 * Go to right side
 * 
 * Root.right=70 , search 90>70
 * Go to right side
 * 
 * Root.right.right=80 , 90>80
 * Go to right
 * 
 * Root.right.right.right==NULL , return false
 * 
 * Search case to handle :
 * root-> NULL return false
 * root-> Search data return true
 * root > search search(root.right)
 * else search(root.left)
 * 
 * Time - O H
 * Space : Tail elimination method with if else return
 * O (H)
 * Iterative space : O (1) ..run till you get null
 * 
 * Self balancing tree maitain height , so search time will be O log N
 * 
 * @author shree
 *
 */

class BSTNode {
	int key;
	int data;
	BSTNode left, right;

	BSTNode(int d) {
		key = d;
		left = null;
		right = null;
		data = d;
	}
}

public class BST02_operation_medium {

	public static void main(String[] args) {
		// Construct BST tree
		int arr[] = { 50, 30, 70, 40, 10, 60, 80 };
		BSTNode root = ConstructBST(arr);
		ViewBST(root);
		TraverseLevelOrderQueueTwoLoops(root);
		///////////////////////////////////////////////////////////// SEARCH
		int data = 55;
		boolean anb = SearchPresentRecursive(root, data);
		System.out.println(" Element present in recursive search " + anb);
		// Time O H
		// SPACE O H

		anb = SearchPresentIterative(root, data);
		System.out.println(" Element present in iterative search " + anb);
		// Time O H
		// Space O 1
		ViewBST(root);

		///////////////////////////////////////////////////////////// INSERT
		int insert = 75;
		System.out.println(" INSERT");
		root = InsertRecursive(root, insert);
		System.out.println(" Element added in recursive insert ");
		// Time O H
		// SPACE O H

		root = InsertRecursiveGoG(root, data);
		TraverseLevelOrderQueueTwoLoops(root);
		ViewBST(root);
		root = insertIterative(root, insert);
		System.out.println(" Element added in iterative insert ");
		TraverseLevelOrderQueueTwoLoops(root);
		// Time O H
		// Space O 1
		ViewBST(root);

		///////////////////////////////////////////////////////////////// DELETE
		System.out.println("BEFORE ");
		TraverseLevelOrderQueueTwoLoops(root);
		System.out.println(" DELETE");
		root = deleteNodeBST(root, 50);
		ViewBST(root);
		System.out.println();
		TraverseLevelOrderQueueTwoLoops(root);
		root = deleteNodeBSTRecursive(root, 55);
		System.out.println(" Delete 2");
		ViewBST(root);
		TraverseLevelOrderQueueTwoLoops(root);
	}

	private static BSTNode deleteNodeBSTRecursive(BSTNode root, int data) {
		// delete recursive
		if (root == null) {
			return null;
		}
		System.out.print("......" + root.key + " ..");
		System.out.print((root.left != null ? root.left.key + " " : "eee"));
		System.out.print((root.right != null ? root.right.key + " " : "eee"));
		if (root.key == data) {
			System.out.println(" Root" + root.key);
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				BSTNode head = SuccessorLeft(root, true);
				// We consider right only
				// Attach left
				head.left = root.left;
				return head;
			}
		}

		if (data < root.key) {
			root.left = deleteNodeBSTRecursive(root.left, data);
		} else {
			root.right = deleteNodeBSTRecursive(root.right, data);
		}

		return root;
	}

	/*
	 * Error input : 4 3 5 1 N N N N 2 N N
	 * 4
	 * 
	 * 4
	 * 3 5
	 * 1 N N N
	 * N 2
	 * N N
	 * 
	 * Here for delete 4
	 * root.right=5 root.right.left=null
	 * so sending the parent 5
	 * 
	 * Here again we are not setting the value of root left
	 */
	private static BSTNode deleteNodeBST(BSTNode root, int data) {
		// interim method
		BSTNode head = root;
		if (root == null) {
			return null;
		}
		if (root.key == data) {
			// Case needed
			// To return head
			// Only swap data - no need
			// If swap node yessss IMP!!!
			// But not possible to swap node bae
			// Each node hs two child
			// So Cant
			return SuccessorLeft(root, true);
		}

		BSTNode parent = root;
		while (root != null) {
			System.out.println(root.key);
			if (root.key == data) {
				if (parent.left != null && parent.left.key == data) {
					parent.left = SuccessorLeft(root, false);
				} else {
					parent.right = SuccessorLeft(root, false);
				}
			}

			if (root.key > data) {
				parent = root;
				root = root.right;
			} else {
				parent = root;
				root = root.left;
			}
		}
		return head;
	}

	private static BSTNode SuccessorLeft(BSTNode root, boolean isRoot) {
		// swap
		if (root.left == null && root.right == null) {
			return null;
		} else if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		} else {

			BSTNode head = root;
			// Root's right successor left most node
			// BSTNode head=root.left;
			BSTNode parent = root.right;
			if (parent.left == null) {
				return parent;
			}
			root = parent.left;
			while (root != null && root.left != null) {
				// parent.key=root.key;
				// Just swap the left most and right most
				parent = parent.left;
				root = root.left;
			}
			parent.left = null;
			// if(isRoot) {
			root.left = head.left;
			root.right = head.right;
			// }

			return root;
		}

	}

	private static BSTNode InsertRecursiveGoG(BSTNode root, int data) {
		// gog recursive

		// Cont for creation of data
		if (root == null) {
			return new BSTNode(data);
		}

		if (root.key > data) {
			root.left = InsertRecursiveGoG(root.left, data);
		} else if (root.key < data) {
			root.right = InsertRecursiveGoG(root.right, data);
		}

		// Same value as root case and all cases with r wo insert
		return root;
	}

	private static BSTNode insertIterative(BSTNode root, int data) {
		// special case root - null
		if (root == null) {
			return new BSTNode(data);
		} else {
			InsertIterative(root, data);
			return root;
		}
	}

	private static boolean InsertIterative(BSTNode root, int data) {
		// insert terative

		while (root != null) {
			if (root.key == data) {
				return true;
			}
			if (root.key < data) {
				if (root.right == null) {
					root.right = new BSTNode(data);
					return true;
				} else {
					root = root.right;
				}
			} else {
				if (root.left == null) {
					root.left = new BSTNode(data);
					return true;
				} else {
					root = root.left;
				}
			}
		}

		return false;
	}

	static boolean InsertYES;

	private static BSTNode InsertRecursive(BSTNode root, int data) {
		// recursive
		if (root == null) {
			return new BSTNode(data);
		} else if (root.key == data) {
			InsertYES = false;
			// If return null , the tree will break
			// Root has all is child
			// We are return parent.left= root
			// Thus preventing tree deformation
			return root;
		}
		// No return for below two condt.
		else if (root.key < data) {
			root.right = InsertRecursive(root.right, data);
		} else {
			root.left = InsertRecursive(root.left, data);
		}
		// Must to return root
		// If we return created node , deform the tree
		return root;

	}

	private static boolean SearchPresentIterative(BSTNode root, int data) {
		// iterative given size

		while (root != null) {
			if (root.key == data) {
				return true;
			} else if (root.key > data) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return false;
	}

	private static boolean SearchPresentRecursive(BSTNode root, int data) {
		// search
		if (root == null) {
			return false;
		} else if (root.key == data) {
			return true;
		} else if (root.key > data) {
			return SearchPresentRecursive(root.right, data);
		} else {
			return SearchPresentRecursive(root.right, data);
		}
	}

	public static BSTNode ConstructBST(int[] arr) {
		// construct

		int n = arr.length;
		if (n == 0) {
			return null;
		}
		BSTNode root = new BSTNode(arr[0]);
		for (int i = 1; i < n; i++) {
			InsertIterative(root, arr[i]);
		}
		return root;
	}

	public static void ViewBST(BSTNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		ViewBST(root.left);
		System.out.print("|");
		ViewBST(root.right);
	}

	public static void TraverseLevelOrderQueueTwoLoops(BSTNode root) {
		// best level order
		if (root == null) {
			System.out.println(" Empty ");
			return;
		}

		Queue<BSTNode> q = new LinkedList<>();
		q.add(root);
		int count = 0;
		BSTNode curr;
		while (!q.isEmpty()) {

			count = q.size();

			System.out.println("count " + count);
			// Here instead of count , we can not use q.size
			// Queue will not be empty and dynamically grow everytime
			// CAUTION !!!!!!!!!!
			for (int i = 0; i < count; i++) {
				curr = q.poll();
				if (curr.left != null) {
					q.offer(curr.left);
				}
				if (curr.right != null) {
					q.offer(curr.right);
				}
				System.out.print(curr.key + " ");
			}
			System.out.println();

		}
	}

}

/*
 * 
 * Deletion in a Binary Search Tree
 * 
 * We have discussed the Search and Insert operations in BST in the previous
 * post. In this post, delete operation is discussed.
 * 
 * That is, given a Binary Search Tree and a node to be deleted. The task is to
 * search that node in the given BST and delete it from the BST if it is
 * present.
 * 
 * When we delete a node, three cases may arise:
 * Node to be deleted is leaf: Simply remove from the tree.
 * 
 * Node to be deleted has only one child: Copy the child to the node and delete
 * the child.
 * 
 * 
 * Node to be deleted has two children: Find inorder successor of the node. Copy
 * contents of the inorder successor to the node and delete the inorder
 * successor. Note that inorder predecessor can also be used.
 * 
 * 
 * 
 * 
 * Note: The inorder successor can be obtained by finding the minimum value in
 * the right child of the node.
 * 
 * Below is the implementation of the above three cases:
 * 
 * // Java program to demonstrate delete
 * // operation in binary search tree
 * 
 * class BinarySearchTree
 * {
 * //* Class containing left and right child of current node and key value*
 * class Node
 * {
 * int key;
 * Node left, right;
 * 
 * public Node(int item)
 * {
 * key = item;
 * left = right = null;
 * }
 * }
 * 
 * // Root of BST
 * Node root;
 * 
 * // Constructor
 * BinarySearchTree()
 * {
 * root = null;
 * }
 * 
 * // This method mainly calls deleteRec()
 * void deleteKey(int key)
 * {
 * root = deleteRec(root, key);
 * }
 * 
 * //* A recursive function to insert a new key in BST *
 * Node deleteRec(Node root, int key)
 * {
 * //* Base Case: If the tree is empty *
 * if (root == null) return root;
 * 
 * //* Otherwise, recur down the tree *
 * if (key < root.key)
 * root.left = deleteRec(root.left, key);
 * else if (key > root.key)
 * root.right = deleteRec(root.right, key);
 * 
 * // if key is same as root's key, then This is the node
 * // to be deleted
 * else
 * {
 * // node with only one child or no child
 * if (root.left == null)
 * return root.right;
 * else if (root.right == null)
 * return root.left;
 * 
 * // node with two children: Get the inorder successor (smallest
 * // in the right subtree)
 * root.key = minValue(root.right);
 * 
 * // Delete the inorder successor
 * root.right = deleteRec(root.right, root.key);
 * }
 * 
 * return root;
 * }
 * 
 * int minValue(Node root)
 * {
 * int minv = root.key;
 * while (root.left != null)
 * {
 * minv = root.left.key;
 * root = root.left;
 * }
 * return minv;
 * }
 * 
 * // This method mainly calls insertRec()
 * void insert(int key)
 * {
 * root = insertRec(root, key);
 * }
 * 
 * /* A recursive function to insert a new key in BST *
 * Node insertRec(Node root, int key)
 * {
 * 
 * /* If the tree is empty, return a new node *
 * if (root == null)
 * {
 * root = new Node(key);
 * return root;
 * }
 * 
 * /* Otherwise, recur down the tree *
 * if (key < root.key)
 * root.left = insertRec(root.left, key);
 * else if (key > root.key)
 * root.right = insertRec(root.right, key);
 * 
 * /* return the (unchanged) node pointer *
 * return root;
 * }
 * 
 * // This method mainly calls InorderRec()
 * void inorder()
 * {
 * inorderRec(root);
 * }
 * 
 * // A utility function to do inorder traversal of BST
 * void inorderRec(Node root)
 * {
 * if (root != null)
 * {
 * inorderRec(root.left);
 * System.out.print(root.key + " ");
 * inorderRec(root.right);
 * }
 * }
 * 
 * // Driver Program to test above functions
 * public static void main(String[] args)
 * {
 * BinarySearchTree tree = new BinarySearchTree();
 * 
 * /* Let us create following BST
 * 50
 * / \
 * 30 70
 * / \ / \
 * 20 40 60 80 *
 * tree.insert(50);
 * tree.insert(30);
 * tree.insert(20);
 * tree.insert(40);
 * tree.insert(70);
 * tree.insert(60);
 * tree.insert(80);
 * 
 * System.out.println("Inorder traversal of the given tree");
 * tree.inorder();
 * 
 * System.out.println("\nDelete 20");
 * tree.deleteKey(20);
 * System.out.println("Inorder traversal of the modified tree");
 * tree.inorder();
 * 
 * System.out.println("\nDelete 30");
 * tree.deleteKey(30);
 * System.out.println("Inorder traversal of the modified tree");
 * tree.inorder();
 * 
 * System.out.println("\nDelete 50");
 * tree.deleteKey(50);
 * System.out.println("Inorder traversal of the modified tree");
 * tree.inorder();
 * }
 * }
 * 
 * Output:
 * Inorder traversal of the given tree
 * 20 30 40 50 60 70 80
 * Delete 20
 * Inorder traversal of the modified tree
 * 30 40 50 60 70 80
 * Delete 30
 * Inorder traversal of the modified tree
 * 40 50 60 70 80
 * Delete 50
 * Inorder traversal of the modified tree
 * 40 60 70 80
 * 
 * 
 * 
 * Illustration:
 * bst-delete
 * 
 * bst-delete2
 * 
 * 
 */

/**
 * 
 * 
 * Binary Search Tree (Search and Insert)
 * 
 * What is Binary Search Tree?
 * A binary Search Tree is a node-based binary tree data structure which has the
 * following properties:
 * 
 * The left subtree of a node contains only nodes with keys lesser than the
 * node’s key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node’s key.
 * The left and right subtree each must also be a binary search tree.
 * There must be no duplicate nodes.
 * 200px-Binary_search_tree.svg
 * The above properties of the Binary Search Tree provide an ordering among keys
 * so that the operations like search, minimum and maximum can be done fast. If
 * there is no order, then we may have to compare every key to search for a
 * given key.
 * 
 * How to search a key in given Binary Tree?
 * For searching a value, if we had a sorted array we could have performed a
 * binary search. Let’s say we want to search a number in the array, in binary
 * search, we first define the complete list as our search space, the number can
 * exist only within the search space. Now we compare the number to be searched
 * or the element to be searched with the middle element (median) of the search
 * space and if the record being searched is less than the middle element, we go
 * searching in the left half, else we go searching in the right half, in case
 * of equality we have found the element. In binary search, we start with ‘n’
 * elements in search space and if the mid element is not the element that we
 * are looking for, we reduce the search space to ‘n/2’ we keep reducing the
 * search space until we either find the record that we are looking for or we
 * get to only one element in search space and be done with this whole
 * reduction.
 * 
 * Search operations in binary search trees will be very similar. Let’s say we
 * want to search for the number, we start at the root, and then we compare the
 * value to be searched with the value of the root, if it’s equal we are done
 * with the search if it’s smaller we know that we need to go to the left
 * subtree because in a binary search tree all the elements in the left subtree
 * are smaller and all the elements in the right subtree are larger. Searching
 * an element in the binary search tree is basically this traversal, at each
 * step we go either left or right and at each step we discard one of the
 * sub-trees. If the tree is balanced (we call a tree balanced if for all nodes
 * the difference between the heights of left and right subtrees is not greater
 * than one) we start with a search space of ‘n’ nodes and as we discard one of
 * the sub-trees, we discard ‘n/2’ nodes so our search space gets reduced to
 * ‘n/2’. In the next step, we reduce the search space to ‘n/4’ and we repeat
 * until we find the element or our search space is reduced to only one node.
 * The search here is also a binary search hence the name; Binary Search Tree.
 * 
 * Implementation:
 * 
 * // A utility function to search a given key in BST
 * public Node search(Node root, int key)
 * {
 * // Base Cases: root is null or key is present at root
 * if (root==null || root.key==key)
 * return root;
 * 
 * // Key is greater than root's key
 * if (root.key < key)
 * return search(root.right, key);
 * 
 * // Key is smaller than root's key
 * return search(root.left, key);
 * }
 * 
 * 
 * Illustration to search 6 in below tree:
 * 
 * Start from the root.
 * Compare the searching element with root, if less than root, then recursively
 * call left subtree, else recursively call right subtree.
 * If the element to search is found anywhere, return true, else return false.
 * bstsearch
 * 
 * Insertion of a key :
 * 
 * A new key is always inserted at the leaf. We start searching for a key from
 * the root until we hit a leaf node. Once a leaf node is found, the new node is
 * added as a child of the leaf node.
 * 
 * 100 100
 * 
 * / \ Insert 40 / \
 * 
 * 20 500 ———> 20 500
 * 
 * / \ / \
 * 
 * 10 30 10 30
 * 
 * \
 * 
 * 40
 * 
 * Implementation:
 * 
 * // Java program to demonstrate
 * import java.io.*;
 * // insert operation in binary
 * // search tree
 * class BinarySearchTree {
 * 
 * /* Class containing left
 * and right child of current node
 * and key value*
 * class Node {
 * int key;
 * Node left, right;
 * 
 * public Node(int item)
 * {
 * key = item;
 * left = right = null;
 * }
 * }
 * 
 * // Root of BST
 * Node root;
 * 
 * // Constructor
 * BinarySearchTree() { root = null; }
 * 
 * BinarySearchTree(int value) { root = new Node(value); }
 * 
 * // This method mainly calls insertRec()
 * void insert(int key) { root = insertRec(root, key); }
 * 
 * /* A recursive function to
 * insert a new key in BST *
 * Node insertRec(Node root, int key)
 * {
 * 
 * /* If the tree is empty,
 * return a new node *
 * if (root == null) {
 * root = new Node(key);
 * return root;
 * }
 * 
 * /* Otherwise, recur down the tree *
 * else if (key < root.key)
 * root.left = insertRec(root.left, key);
 * else if (key > root.key)
 * root.right = insertRec(root.right, key);
 * 
 * /* return the (unchanged) node pointer *
 * return root;
 * }
 * 
 * // This method mainly calls InorderRec()
 * void inorder() { inorderRec(root); }
 * 
 * // A utility function to
 * // do inorder traversal of BST
 * void inorderRec(Node root)
 * {
 * if (root != null) {
 * inorderRec(root.left);
 * System.out.println(root.key);
 * inorderRec(root.right);
 * }
 * }
 * 
 * // Driver Code
 * public static void main(String[] args)
 * {
 * BinarySearchTree tree = new BinarySearchTree();
 * 
 * /* Let us create following BST
 * 50
 * / \
 * 30 70
 * / \ / \
 * 20 40 60 80 *
 * tree.insert(50);
 * tree.insert(30);
 * tree.insert(20);
 * tree.insert(40);
 * tree.insert(70);
 * tree.insert(60);
 * tree.insert(80);
 * 
 * // print inorder traversal of the BST
 * tree.inorder();
 * }
 * }
 * 
 * 
 * 
 * Output
 * 
 * 20
 * 30
 * 40
 * 50
 * 60
 * 70
 * 80
 * Illustration to insert 2 in the below tree:
 * 
 * Start from the root.
 * Compare the inserting element with the root, if less than the root, then
 * recursively call the left subtree, else recursively call the right subtree.
 * After reaching the end, just insert that node at left(if less than current)
 * or else right.
 * bstsearch
 * 
 * Time Complexity: The worst-case time complexity of search and insert
 * operations is O(h) where h is the height of the Binary Search Tree. In the
 * worst case, we may have to travel from the root to the deepest leaf node. The
 * height of a skewed tree may become n and the time complexity of the search
 * and insert operation may become O(n).
 * Auxiliary Space: O(1)
 * 
 * Implementation: Insertion using the loop.
 * 
 * import java.io.*;
 * import java.util.*;
 * 
 * class GFG {
 * public static void main(String[] args)
 * {
 * BST tree = new BST();
 * tree.insert(30);
 * tree.insert(50);
 * tree.insert(15);
 * tree.insert(20);
 * tree.insert(10);
 * tree.insert(40);
 * tree.insert(60);
 * tree.inorder();
 * }
 * }
 * 
 * class Node {
 * Node left;
 * int val;
 * Node right;
 * Node(int val) { this.val = val; }
 * }
 * 
 * class BST {
 * Node root;
 * 
 * public void insert(int key)
 * {
 * Node node = new Node(key);
 * if (root == null) {
 * root = node;
 * return;
 * }
 * Node prev = null;
 * Node temp = root;
 * while (temp != null) {
 * if (temp.val > key) {
 * prev = temp;
 * temp = temp.left;
 * }
 * else if (temp.val < key) {
 * prev = temp;
 * temp = temp.right;
 * }
 * }
 * if (prev.val > key)
 * prev.left = node;
 * else
 * prev.right = node;
 * }
 * 
 * public void inorder()
 * {
 * Node temp = root;
 * Stack<Node> stack = new Stack<>();
 * while (temp != null || !stack.isEmpty()) {
 * if (temp != null) {
 * stack.add(temp);
 * temp = temp.left;
 * }
 * else {
 * temp = stack.pop();
 * System.out.print(temp.val + " ");
 * temp = temp.right;
 * }
 * }
 * }
 * }
 * 
 * 
 * Output
 * 
 * 10 15 20 30 40 50 60
 * Time Complexity: O(N)
 * Auxiliary Space: O(N)
 * 
 * 
 * 
 * 
 */
