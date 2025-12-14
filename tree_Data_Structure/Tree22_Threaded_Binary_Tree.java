package tree_Data_Structure;

class SingleThreadedTreeNode
{
    int data;
    SingleThreadedTreeNode left;
    SingleThreadedTreeNode right;
    boolean rightThread;

    public SingleThreadedTreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}


public class Tree22_Threaded_Binary_Tree {

	public static void main(String[] args) {
		// right thread , returns to root 
		SingleThreadedTreeNode root = new SingleThreadedTreeNode(100);
//		root.left = new SingleThreadedTreeNode(40);
//		//root.left.rightThread=true;
//		root.right = new SingleThreadedTreeNode(60);
//		root.left.left = new SingleThreadedTreeNode(10);
//		root.left.left.rightThread=true;
//		root.left.left.left = new SingleThreadedTreeNode(100);
//		root.left.left.left.rightThread=true;
//		root.left.right = new SingleThreadedTreeNode(30);
//		root.left.right.right = new SingleThreadedTreeNode(30); ///
//		root.right.right = new SingleThreadedTreeNode(600);
//		root.right.left=new SingleThreadedTreeNode(22);
//		root.right.left.rightThread=true;
//		root.right.right.right = new SingleThreadedTreeNode(6000);
//		root.right.right.right.left = new SingleThreadedTreeNode(60);
//		root.right.right.right.left.rightThread=true;
		
		inOrder(root);
		

	}
	private static void inOrder(SingleThreadedTreeNode root)
	{
	    // Find leftmost node of the root node
		SingleThreadedTreeNode curr = leftMost(root);
	    
	    // Until the complete tree is traversed
	    while (curr != null)
	    {
	       System.out.print(curr.data+" ");

	        // If this node is a thread node, then go to
	        // inorder successor
	        if (curr.rightThread)
	            curr = curr.right;
	        // Else go to the leftmost child in 
	        // right subtree    
	        else 
	            curr = leftMost(curr.right);
	    }
	}

	private static SingleThreadedTreeNode leftMost(SingleThreadedTreeNode N)
	{
	    if (N == null)
	        return null;

	    while (N.left != null)
	        N = N.left;

	    return N;
	}
}
/*
Threaded Binary Tree

The Inorder traversal of a Binary tree can either be done using recursion or with the use of an auxiliary stack. Threaded Binary Trees are used to make the inorder traversal faster and do it without stack and without recursion. A binary tree is made threaded by making all right child pointers that would normally be NULL point to the inorder successor of the node (if it exists).

There are two types of threaded binary trees:
Single Threaded: Where a NULL right pointers is made to point to the inorder successor (if successor exists).
Double Threaded: Where both left and right NULL pointers are made to point to inorder predecessor and inorder successor respectively. The predecessor threads are useful for reverse inorder traversal and postorder traversal.


Note: The threads are also useful for fast accessing ancestors of a node.

Following diagram shows an example Single Threaded Binary Tree. The dotted lines represent threads.
threadedBT

Representation of a Threaded Node:

class Node
    {
        int data;
        Node left, right;
        boolean rightThread;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }


Since the right pointer in a Threaded Binary Tree is used for two purposes, the boolean variable rightThread is used to indicate whether the right pointer points to a right child or an inorder successor. Similarly, we can add leftThread for a double threaded binary tree.

Inorder Traversal in a Threaded Binary Tree: Below is the algorithm to perform inorder traversal in a Threaded Binary Tree using threads:
Start from the root node, go to the leftmost node and print the node.
Check if there is a thread towards the right for the current node.
If Yes, then follow the thread to the node and print the data of node linked with this thread.
Otherwise follow the link to the right subtree, find the leftmost node in the right subtree and print the leftmost node.
Repeat the above process until the complete tree is traversed.


Following diagram demonstrates the inorder traversal in a Threaded Binary Tree:
threadedTraversal

Below functions implements the inorder traversal in a threaded binary tree:


// Utility function to find leftmost node
// in a tree rooted with N
Node* leftMost(Node *N)
{
    if (N == NULL)
        return NULL;

    while (N->left != NULL)
        N = N->left;

    return N;
}

// Function to do inorder traversal in a 
// threaded binary tree
void inOrder(Node *root)
{
    // Find leftmost node of the root node
    Node *cur = leftmost(root);
    
    // Until the complete tree is traversed
    while (cur != NULL)
    {
        print cur->data;

        // If this node is a thread node, then go to
        // inorder successor
        if (cur->rightThread)
            cur = cur->right;
        // Else go to the leftmost child in 
        // right subtree    
        else 
            cur = leftmost(cur->right);
    }
}

*/