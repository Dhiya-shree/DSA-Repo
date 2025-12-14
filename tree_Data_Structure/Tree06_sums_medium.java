package tree_Data_Structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Problem #1 : Children sum property 
 * Children Sum Property is a property in which the sum of values of the left child and right child
 *  should be equal to the value of their node if both children are present. 
 *  Else if only one child is present then the value of the child should be equal to its node value
 *  root node value == left + right 
 * 
 * 
 * For every sub tree ,
 *   if left && right == null
 *        return true
 *   else 
 *     left + right must be equal to root 
 *         recursive
 *     if not return false
 * 
 * 
 *  Problem #2: Check for balanced tree 
 *  In a Balanced Binary Tree for every node, the difference 
 *  between heights of left subtree and right subtree should not be more than one.
 * 
 *  Height balanced :
 *    For node - Height of left sub tree must be 
 *                equal to height of right sub tree
 * 
 * 
 *  Method 1 : O N2
 *  Find left and right height for every node 
 *  Sub and check the ans
 *  
 *  Method 2 : O N 
 *  if tree unbalanced return -1
 *  else 
 *     return the sub tree maximum length 
 *  
 *  
 *  Problem #3 : Maximum width of Binary tree 
 *  
 *  Method 1 : 
 *     Use level order 
 *     Max count == max width 
 *  
 *  
 *  
 *  Problem #4 : Diameter of Binary Tree 
 *  
 * Method 1:
 *     Use recursion  O H space 
 *     For every node 
 *       Find maximum left subtree length 
 *       Find maximum right subtree length 
 *       Add to get maximumValue 
 *     return maximum amoung left and right  
 *     
 * Method 2 : Use more space  O N extra space 
 *   Use Hashmap to store node and its level 
 *   For every node , find maxi by sum of left and right height in hashmap 
 *   
 * Method 3: N 2
 *   Find height for each node and proceed
 *   
 * Problem #5 : Count subtree with the given sum 
 * 
 * 
 * 

Given a binary tree and an integer X. Your task is to complete the function countSubtreesWithSumX() that returns the count of the number of subtress having total node’s data sum equal to the value X.
Note that a subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
Example: For the tree given below:            

              5
            /    \
        -10     3
        /    \    /  \
      9     8  -4 7

Subtree with sum 7:
             -10
            /      \
          9        8

and one node 7.

Example 1:

Input:
       5
    /    \
  -10     3
 /   \   /  \
 9   8 -4    7
X = 7
Output: 2
Explanation: Subtrees with sum 7 are
[9, 8, -10] and [7] (refer the example
in the problem description).
Example 2:

Input:
    1
  /  \
 2    3
X = 5
Output: 0
Explanation: No subtree has sum equal
to 5.
Your Task:
You don't need to read input or print anything. Your task is to complete the function countSubtreesWithSumX() which takes the root node and an integer X as inputs and returns the number of subtrees of the given Binary Tree having sum exactly equal to X.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 103
-103 <= Node Value <= 103
 
 * 
 * 
 *     
 * @author shree
 *
 */
public class Tree06_sums_medium {

	public static void main(String[] args) {
		// Tree sums medium 
		BTNode root = new BTNode(100);
		root.left = new BTNode(40);
		root.right = new BTNode(60);
		
		root.left.left = new BTNode(10);
		root.left.left.left = new BTNode(90);
		
		root.left.right = new BTNode(70);
		root.left.right.right = new BTNode(30); ///
		
		root.right.right = new BTNode(50);
		root.right.left=new BTNode(100);
		
		root.right.right.right = new BTNode(60);
		//root.right.right.right.left = new BTNode(60);
		
		
		boolean ans=ChilrenSumProperty(root);
		System.out.println(" Children sum property "+ans);

		//O N2
		ans=BalancedTreeRootN2(root);
		System.out.println(" Balanced Tree "+ans);

		// O N 
		int ani=BalancedTreeorNot(root);
		System.out.println(" Balanced Tree "+ani);

		ani=BalancedTreeorNotGoG(root);
		System.out.println(" Balanced Tree "+ani);

		ani=MaximumWidth_LevelOrder(root);
		System.out.println(" Maximu width levele order "+ani);
	    
		ani=DiameterOfTreeMaxi(root);
		System.out.println(" Diameter of Tree"+ani);

	   // ani=NodesOfCompleteTree(root);
	    int sum=100;
	    ani=countSubtreesWithSumX(root,sum);
	    System.out.println(" Count od subtree with sum :"+sum+" is ..."+ani);
	}

	
	//Function to count number of subtrees having sum equal to given sum.
	private static int countSubtreesWithSumX(BTNode root, int X)
    {
	//Add your code here.
	count=0;//counted=true;
	   int ans=CountTree(root,X);
	  System.out.println(" Sum ans of root is "+ans);
	   return count;
	
    }
    
  //  static boolean counted;
    static int count;
    private static int CountTree(BTNode root, int X){
        if(root==null){
            return 0;
        }
        
        int left=CountTree(root.left,X);
        int right=CountTree(root.right,X);
        
       
        int total=left+right+root.key;
       // System.out.println(root.data+" "+left+" "+right+"..."+total);
         if(total==X){
           count++;
        //    System.out.print(root.data+" "+left+" "+right+"..."+count+"...");
            // Additional count
            // Left + right==0
            // Subtree --> tree with al of its descendants 
            //Below condt not needed 
         /*    if(root.data==X&& (root.right!=null || root.left!=null)){
                 count++;
            System.out.print(total+"..."+count);
             }
          //  counted=false;*/
            
        }
        //System.out.println();
        return total;
    }


	private static int DiameterOfTreeMaxi(BTNode root) {
		// Just send maxi and call below 
      //   Tree03_Traversal_Level_order.TraverseLevelOrderQueueTwoLoops(root);
		int val=DiameterOfTree(root);
		return Math.max(val, maxi);
	}

	static int maxi=0;
	private static int DiameterOfTree(BTNode root) {
		// Every node add left + right max 
		if(root==null) {
			return 0;
		}
		
		int left=DiameterOfTree(root.left);
		int right=DiameterOfTree(root.right);
		int total=left+right+1;
		if(maxi<total) {
			maxi=total;
		}
		return (Math.max(left,right)+1);
	}

	private static int MaximumWidth_LevelOrder(BTNode root) {
		// max size of queue
			if(root==null) {
				System.out.println(" Empty ");
				return 0;
			}
			
		
			Queue<BTNode> q=new LinkedList<>();
			q.add(root);
			int count=0;BTNode curr;
			int max=1;
			while(!q.isEmpty()) {
				
				count=q.size();
				max=Math.max(max,count);
				//System.out.println("count "+count);
				//Here instead of count , we can not use q.size 
				// Queue will not be empty and dynamically grow everytime 
				//CAUTION !!!!!!!!!!
				for(int i=0;i<count;i++) {
					curr=q.poll();
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
			return max;
	}

	private static int BalancedTreeorNotGoG(BTNode root) {
		
		if(root==null) {
			return 0;
		}
		
		int lh=BalancedTreeorNotGoG(root.left);
		if(lh==-1) {return -1;}
		
		int rh=BalancedTreeorNotGoG(root.right);
		if(rh==-1) {return -1;}
		
		if(Math.abs(lh-rh)>1) {
			return -1;
		}
		else {
			return (Math.max(lh, rh)+1);
		}
	}



	private static int BalancedTreeorNot(BTNode root) {
		// Balanced subtree 
		if(root==null) {
			return 0;//Leaf 
		}
		
		int left=BalancedTreeorNot(root.left);
		// MUST not add one here , left could be -1 also 
		if(left==-1) {
			return -1;
		}
		int right=BalancedTreeorNot(root.right);
		//Must NOT !!!!!! add 1 here, right could be -1 also 
		if(right==-1) {
			return -1;
		}
		
		if(Math.abs(left-right)<=1 && left!=-1 && right!=-1) {
			//Add 1 here -- safe place 
			return (Math.max(left, right)+1);
		}
		else {
			return -1;
			
		}

	}



	private static boolean BalancedTreeRootN2(BTNode root) {
		// recursion 
		if(root==null) {
			return true;
		}
		//height N time 
		int left=Tree04_sums_easy.HeightOfTree(root.left);
        int right=Tree04_sums_easy.HeightOfTree(root.right);
        boolean ans=false;
        if(Math.abs(left-right)<=1) {
			ans=BalancedTreeRootN2(root.left);
			if(ans==false) {
				System.out.println(" 1 ..."+root.key);
			}
			ans=ans&&BalancedTreeRootN2(root.right);
			if(ans==false) {
				System.out.println(" 2 ..."+root.key);
			}
		}
        if(ans==false) {
			System.out.println(" 3 ..."+root.key);
		}
		return ans;
	}

	private static boolean ChilrenSumProperty(BTNode root) {
		// root = null return true 
		if(root==null) {
			return true;
		}
		int left_and_right=0;
		if(root.left!=null) {
			left_and_right=root.left.key;
		}
		if(root.right!=null) {
			left_and_right=root.right.key+left_and_right;
		}
		
		
		boolean ans=false;
		//CAUTION !!!!!!!!!!!!!!!
		// Very important to add for leaf nodes 
		// Without this code wrong 
		if(root.left==null && root.right==null) {
			//For last leaf node 
			return true;
		}
		else if(root.key!=left_and_right ) {
			// For internal node with wrong value 
			System.out.println(root.key);
			return ans;
		}
		else {
			//For internal node with correct value 
			// Check further 
			ans=ChilrenSumProperty(root.left);
			if(ans==false) {
				System.out.println(root.key);
				return false;
			}
			else {
			ans=ChilrenSumProperty(root.right);
			if(ans==false) {
				System.out.println(root.key);
			}
			return ans;
			}
		}
		
		
		
	}

}

/**
Check for Balanced Binary Tree

A height balanced binary tree is a binary tree in which the height of the left subtree and right subtree of any node does not differ by more than 1 and both the left and right subtree are also height balanced.

In this article, we will look into methods how to determine if given Binary trees are height-balanced

 

Examples: The tree on the left is a height balanced binary tree. Whereas the tree on the right is not a height balanced tree. Because the left subtree of the root has a height which is 2 more than the height of the right subtree.
 


 

Naive Approach: To check if a tree is height-balanced:

Get the height of left and right subtrees using dfs traversal. Return true if the difference between heights is not more than 1 and left and right subtrees are balanced, otherwise return false. 

Below is the implementation of the above approach.

/* Java program to determine if binary tree is
height balanced or not *

/* A binary tree node has data, pointer to left child,
and a pointer to right child *
class Node {
	int data;
	Node left, right;
	Node(int d)
	{
		data = d;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	/* Returns true if binary tree with root as root is
	* height-balanced *
	boolean isBalanced(Node node)
	{
		int lh; /* for height of left subtree *

		int rh; /* for height of right subtree *

		/* If tree is empty then return true *
		if (node == null)
			return true;

		/* Get the height of left and right sub trees *
		lh = height(node.left);
		rh = height(node.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(node.left)
			&& isBalanced(node.right))
			return true;

		/* If we reach here then tree is not height-balanced
		*
		return false;
	}

	/* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION *
	/* The function Compute the "height" of a tree. Height
	is the number of nodes along the longest path from
	the root node down to the farthest leaf node.*
	int height(Node node)
	{
		/* base case tree is empty *
		if (node == null)
			return 0;

		/* If tree is not empty then height = 1 + max of
		left height and right heights *
		return 1
			+ Math.max(height(node.left),
					height(node.right));
	}

	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(8);

		if (tree.isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}

Output
Tree is not balanced
Time Complexity: O(n^2) in case of full binary tree.
Auxiliary Space: O(n) space for call stack since using recursion

 

Efficient implementation: Above implementation can be optimized by 

Calculating the height in the same recursion rather than calling a height() function separately. 

For each node make two recursion calls – one for left subtree and the other for the right subtree. 
Based on the heights returned from the recursion calls, decide if the subtree whose root is the current node is height-balanced or not. 
If it is balanced then return the height of that subtree. Otherwise, return -1 to denote that the subtree is not height-balanced.
Below is the implementation of the above approach.

// Java code to implement the approach

import java.io.*;
import java.lang.*;
import java.util.*;

// Class to define the tree node
class Node {
	int key;
	Node left;
	Node right;
	Node(int k)
	{
		key = k;
		left = right = null;
	}
}

class GFG {

	// Driver code
	public static void main(String args[])
	{
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(30);
		root.right.left = new Node(15);
		root.right.right = new Node(20);

		if (isBalanced(root) > 0)
			System.out.print("Balanced");
		else
			System.out.print("Not Balanced");
	}

	// Function to check if tree is height balanced
	public static int isBalanced(Node root)
	{
		if (root == null)
			return 0;
		int lh = isBalanced(root.left);
		if (lh == -1)
			return -1;
		int rh = isBalanced(root.right);
		if (rh == -1)
			return -1;

		if (Math.abs(lh - rh) > 1)
			return -1;
		else
			return Math.max(lh, rh) + 1;
	}
}

Output
Balanced
Time Complexity: O(n) 

Because we are only one dfs call and utilizing the height returned from that to determine the height balance, it is performing the task in linear time.
Auxiliary Space: O(n)


*/

/*
 * Maximum width of Binary Tree

Given a binary tree, the task is to find the maximum width of the given tree. Width of a tree is maximum of widths of all levels. 

Example: 

Input:
             1
          /   \
       2      3
    /   \       \
 4     5       8 
              /     \
           6        7
Output:  3
Explanation: For the above tree, 
width of level 1 is 1, 
width of level 2 is 2, 
width of level 3 is 3 
width of level 4 is 2. 
So the maximum width of the tree is 3.

Level Order Traversal using Queue
When a queue is used, we can count all the nodes in a level in constant time. This reduces the complexity to be a linear one. 

In this method do the following:

Store all the child nodes at the current level in the queue. 
Count the total number of nodes after the level order traversal for a particular level is completed. 
Since the queue now contains all the nodes of the next level, we can easily find out the total number of nodes in the next level by finding the size of the queue. 
Follow the same procedure for the successive levels. 
Store and update the maximum number of nodes found at each level.
Below is the implementation of the above approach.

// Java program to calculate width of binary tree

/* A binary tree node has data, pointer to left child
and a pointer to right child *
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

	/* Function to get the maximum width of a binary tree*
	int getMaxWidth(Node node)
	{
		int maxWidth = 0;
		int width;
		int h = height(node);
		int i;

		/* Get width of each level and compare
		the width with maximum width so far *
		for (i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}

		return maxWidth;
	}

	/* Get width of a given level *
	int getWidth(Node node, int level)
	{
		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1)
			return getWidth(node.left, level - 1)
				+ getWidth(node.right, level - 1);
		return 0;
	}

	/* UTILITY FUNCTIONS *

	/* Compute the "height" of a tree -- the number of
	nodes along the longest path from the root node
	down to the farthest leaf node.*
	int height(Node node)
	{
		if (node == null)
			return 0;
		else {
			/* compute the height of each subtree *
			int lHeight = height(node.left);
			int rHeight = height(node.right);

			/* use the larger one *
			return (lHeight > rHeight) ? (lHeight + 1)
									: (rHeight + 1);
		}
	}

	/* Driver code *
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();

		/*
		Constructed binary tree is:
			 1
			/ \
		   2   3
		  / \   \
		 4   5   8
				/ \
				6 7
		*
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(8);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);

		// Function call
		System.out.println("Maximum width is "
						+ tree.getMaxWidth(tree.root));
	}
}

// This code has been contributed by Mayank Jaiswal
 

Output

Maximum width is 3
Time Complexity: O(N) where N is the total number of nodes in the tree. Every node of the tree is processed once and hence the complexity is O(N).
Auxiliary Space: O(w) where w is the maximum width of the tree. 


 * 
 */



