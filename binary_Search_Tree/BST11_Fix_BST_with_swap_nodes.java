package binary_Search_Tree;

/***
 * 
 * Fix BST with two swapped nodes 
 *
 * Adjacent swap :
 * 
 *           55
 *         /   \
 *       30     70
 *     /   \   /  \
 *    10   40 50  80 
 *                 \   
 *                  90 
 * In array :
 *  10 30 40 55 50 70 80 90 
 *  
 * In change decreasing 55 50
 * 
 * 
 * 
 * 
 * Non adjacent swap 
 *           50
 *         /   \
 *       80     70
 *     /   \   /  \
 *    10   40 55  30 
 *                 \   
 *                  90
 * 
 * In inorder array 
 *  10 80 40 50 55 70 30 90 
 * 
 * If the swapping nodes are not adjacent 
 * we find two changes 
 * 
 *  decreasing 80 40 
 *  decreasing 70 30 
 * 
 * 
 * For array finding places to swap :
 * 10 80 40 50 55 70 30 90 
 * 
 * Prev = -infinity 
 * First = NIL 
 * Sec = NIL 
 * 
 * for i to n 
 *   if val<prev 
 *     if first=null 
 *        set as first 
 *     else /// Always set the second to handle adjacent cases 
 *        set as sec 
 *   prev = arr[i]
 * 
 * Swap first and second 
 * 
 * For handling adjacent cases , 
 * everytime with changes decreasing 
 * Set second blindly if first not null 
 * 
 * 
 * Do the same for tree 
 * Have First , SEcond and Prev data word 
 * 
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class BST11_Fix_BST_with_swap_nodes {

	public static void main(String[] args) {
		// fix swap nodes 
		
		int arr[]= {93, 61 ,87 ,9};
		BSTNode root=ConstructBST(arr);
		System.out.println(" BST ");
		ViewBST(root);
		
		int swap=0;
		//swapping to create non bst 
		 swap=root.data;
		root.data=root.left.left.data;
		root.left.left.data=swap;
		System.out.println(" BST ");
		ViewBST(root);
		
       FixTheNodes(root);
       
       prev=null;
       
       
       System.out.println(" Data "+first.data+" "+second.data);
       if(first!=null && second!=null) {
       //Fixing values 
       swap=first.data;
       first.data=second.data;
       second.data=swap;
       }
       System.out.println(" Changed ");
       ViewBST(root);
       
	}
    
	static BSTNode prev;
	static BSTNode first;static BSTNode second;
	private static void FixTheNodes(BSTNode root) {
		// inorder setting first and second
		
		if(root==null) {
			return;
		}
		
		FixTheNodes(root.left);
		
		if(prev!=null && root.data<prev.data) {
			if(first==null) {
				//Vert important
				// To swap we MUST make prev as node 
				// Prev make the fisrt not the root
				first=prev;
			}
			//Fool Always set ROOT 
			// For adjacet 
			//     100   1   
			// Root big Nex small 
			//When you are in next ...
			//You set first as prev  100
			//And  curr as Next second = 1 root
			//else {
				second=root;
			//}
		}
		
		prev=root;
		
		FixTheNodes(root.right);
		
	}

	private static BSTNode ConstructBST(int[] arr) {
		// construct 
		
		int n=arr.length;
		if(n==0) {
			return null;
		}
		BSTNode root=new BSTNode(arr[0]);
		for(int i=1;i<n;i++) {
			InsertIterative(root,arr[i]);
		}
		return root;
	}
	
	private static boolean InsertIterative(BSTNode root, int data) {
		// insert terative 
		
		
		
		while(root!=null) {
		    //Removing below condt to add duplicate in tree 
			
			if(root.data<=data) {
				if(root.right==null) {
					root.right=new BSTNode(data);
				    return true;
				}
				else {
					root=root.right;
				}
			}
			else {
				if(root.left==null) {
					root.left=new BSTNode(data);
				    return true;
				}
				else {
					root=root.left;
				}
			}
		}
		
		return false;
	}

	private static void ViewBST(BSTNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		ViewBST(root.left);
		System.out.print("|");
		ViewBST(root.right);
	}
}


/*
 * 
 * Fix BST with two nodes swapped

Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST. 

Input Tree:
         10
        /  \
       5    8
      / \
     2   20

In the above tree, nodes 20 and 8 must be swapped to fix the tree.  
Following is the output tree
         10
        /  \
       5    20
      / \
     2   8
 

The inorder traversal of a BST produces a sorted array. So a simple method is to store inorder traversal of the input tree in an auxiliary array. Sort the auxiliary array. Finally, insert the auxiliary array elements back to the BST, keeping the structure of the BST same. The time complexity of this method is O(nLogn) and the auxiliary space needed is O(n).

We can solve this in O(n) time and with a single traversal of the given BST. Since inorder traversal of BST is always a sorted array, the problem can be reduced to a problem where two elements of a sorted array are swapped. There are two cases that we need to handle:
1. The swapped nodes are not adjacent in the inorder traversal of the BST. 

 For example, Nodes 5 and 25 are swapped in {3 5 7 8 10 15 20 25}. 
 The inorder traversal of the given tree is 3 25 7 8 10 15 20 5 
If we observe carefully, during inorder traversal, we find node 7 is smaller than the previous visited node 25. Here save the context of node 25 (previous node). Again, we find that node 5 is smaller than the previous node 20. This time, we save the context of node 5 (the current node ). Finally, swap the two node's values.
2. The swapped nodes are adjacent in the inorder traversal of BST.

  For example, Nodes 7 and 8 are swapped in {3 5 7 8 10 15 20 25}. 
  The inorder traversal of the given tree is 3 5 8 7 10 15 20 25 
Unlike case #1, here only one point exists where a node value is smaller than the previous node value. e.g. node 7 is smaller than node 8. 

How to Solve? We will maintain three-pointers, first, middle, and last. When we find the first point where the current node value is smaller than the previous node value, we update the first with the previous node & the middle with the current node. When we find the second point where the current node value is smaller than the previous node value, we update the last with the current node. In the case of #2, we will never find the second point. So, the last pointer will not be updated. After processing, if the last node value is null, then two swapped nodes of BST are adjacent. 

Following is the implementation of the given code. 


// Java program to correct the BST 
// if two nodes are swapped
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class BinaryTree
{
    Node first, middle, last, prev;
    
    // This function does inorder traversal
    // to find out the two swapped nodes.
    // It sets three pointers, first, middle
    // and last. If the swapped nodes are
    // adjacent to each other, then first 
    // and middle contain the resultant nodes
    // Else, first and last contain the 
    // resultant nodes
    void correctBSTUtil( Node root)
    {
        if( root != null )
        {
            // Recur for the left subtree
            correctBSTUtil( root.left);

            // If this node is smaller than
            // the previous node, it's 
            // violating the BST rule.
            if (prev != null && root.data <
                                prev.data)
            {
                // If this is first violation,
                // mark these two nodes as
                // 'first' and 'middle'
                if (first == null)
                {
                    first = prev;
                    middle = root;
                }

                // If this is second violation,
                // mark this node as last
                else
                    last = root;
            }

            // Mark this node as previous
            prev = root;

            // Recur for the right subtree
            correctBSTUtil( root.right);
        }
    }

    // A function to fix a given BST where 
    // two nodes are swapped. This function 
    // uses correctBSTUtil() to find out 
    // two nodes and swaps the nodes to 
    // fix the BST
    void correctBST( Node root )
    {
        // Initialize pointers needed 
        // for correctBSTUtil()
        first = middle = last = prev = null;

        // Set the pointers to find out 
        // two nodes
        correctBSTUtil( root );

        // Fix (or correct) the tree
        if( first != null && last != null )
        {
            int temp = first.data;
            first.data = last.data;
            last.data = temp; 
        }
        // Adjacent nodes swapped
        else if( first != null && middle !=
                                    null ) 
        {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }

        // else nodes have not been swapped,
        // passed tree is really BST.
    }

    /* A utility function to print 
     Inorder traversal *
    void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.data);
        printInorder(node.right);
    }


    // Driver program to test above functions
    public static void main (String[] args) 
    {
        /*   6
            / \
           10  2
          / \ / \
         1  3 7 12
        
        10 and 2 are swapped
        *

        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);

        System.out.println("Inorder Traversal"+
                        " of the original tree");
        BinaryTree tree = new BinaryTree();
        tree.printInorder(root);

        tree.correctBST(root);

        System.out.println("\nInorder Traversal"+
                          " of the fixed tree");
        tree.printInorder(root);
    }
}
// This code is contributed by Chhavi

 

Output: 

Inorder Traversal of the original tree
1 10 3 6 7 2 12
Inorder Traversal of the fixed tree
1 2 3 6 7 10 12

Time Complexity: O(n) 
 * 
 * 
 */
