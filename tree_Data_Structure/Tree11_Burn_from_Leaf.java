package tree_Data_Structure;

/**
 * Burn a binary TRee from a leaf :
 * ind time to burn the Binary Tree if we burn the given leaf at 0-th second. 
 * 
 * 
 * Method 1:
 * Find the maximum length of the tree from given node 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Tree11_Burn_from_Leaf {

	public static void main(String[] args) {
		Node root = new Node(100);
		root.left = new Node(40);
		root.right = new Node(60);
		root.left.left = new Node(10);
		root.left.left.left = new Node(110);
		root.left.right = new Node(301);
		root.left.right.right = new Node(30); ///
		root.right.right = new Node(600);
		root.right.left=new Node(22);
		
		root.right.right.right = new Node(6000);
		root.right.right.right.left = new Node(60);
		
		//len=false;

		Distance_tt rootDis=new Distance_tt(-1);
		int leaf=FindTheLeaf(root,600,rootDis);
		System.out.println(" Leaf "+leaf+" Node pos "+resRoot);
		System.out.println(" left "+rootDis.val);
		
		/*
		 *           100
		 *       40       60
		 *     10 301  22  600
		 *   110    30         6000
		 *                        60
		 */
		
	}

	static int resRoot=0;
	private static int FindTheLeaf(Node root, int leaf,Distance_tt dis) {
		// Go left root then right 
		
		if(root==null) {
			return 0;
		}
		else if(root.data==leaf) {
			dis.val=0;
			return 1;
		}
		
		//Create new Distance for leaft and right 
		Distance_tt lDis=new Distance_tt(-1);
		Distance_tt rDis=new Distance_tt(-1);
		
		int left=FindTheLeaf(root.left, leaf, lDis);
		int right=FindTheLeaf(root.right, leaf, rDis);
		
		
		// Value is not  -1 -> if leaf is present 
		// On value 0 , we are retracing back to root 
		// Distance of leaf to current root + right side current root 
		// leaf ----(ldis.val+1)----- --- ROOT--(ldis+right+1)---- right
		//Maximum length from the root node
		if(lDis.val!=-1) {
			dis.val=lDis.val+1;
			resRoot=Math.max(right+dis.val, resRoot);
		}
		else if(rDis.val!=-1) {
			dis.val=rDis.val+1;
			resRoot=Math.max(left+dis.val, resRoot);
		}
		
		
	// For max height for the root 
		return (Math.max(left,right)+1);
	}

	
}

//Wrapper class
//As primitive can not be passed by reference 
// We use wrapper to pass b
// PASS By reference 
class Distance_tt{
	int val;
	public Distance_tt(int d) {
		val=d;
	}
}

/**
 * 
 * Burn a Binary Tree From a Leaf

Given a binary tree and a leaf node from this tree. It is known that in 1s all nodes connected to a given node (left child, right child, and parent) get burned in 1 second. Then all the nodes which are connected through one intermediate get burned in 2 seconds, and so on. The task is to find the minimum time required to burn the complete binary tree.
Examples: 
 

Input : 
            1
       /       \
      2          3
    /  \          \
   4    5          6
      /   \         \
     7     8         9
                      \
                       10
Leaf = 8
Output : 7
Initially 8 is set to fire at 0th sec.
            1
       /       \
      2          3
    /  \          \
   4    5          6
      /   \         \
     7     F         9
                      \
                       10
After 1s: 5 is set to fire.
            1
       /       \
      2          3
    /  \          \
   4    F          6
      /   \         \
     7     F         9
                      \
                       10
After 2s: 2, 7 are set to fire.
            1
       /       \
      F          3
    /  \          \
   4    F          6
      /   \         \
     F     F         9
                      \
                       10
After 3s: 4, 1 are set to fire.
            F
       /       \
      F          3
    /  \          \
   F    F          6
      /   \         \
     F     F         9
                      \
                       10
After 4s: 3 is set to fire.
            F
       /       \
      F          F
    /  \          \
   F    F          6
      /   \         \
     F     F         9
                      \
                       10
After 5s: 6 is set to fire.
            F
       /       \
      F          F
    /  \          \
   F    F          F
      /   \         \
     F     F         9
                      \
                       10
After 6s: 9 is set to fire.
            F
       /       \
      F          F
    /  \          \
   F    F          F
      /   \         \
     F     F         F
                      \
                       10
After 7s: 10 is set to fire.
            F
       /       \
      F          F
    /  \          \
   F    F          F
      /   \         \
     F     F         F
                      \
                       F
It takes 7s to burn the complete tree. 
 

Approach: The idea is to store additional information for every node: 

Depth of left subtree.
Depth of right subtree.
The time required for the fire to reach the current node starting from the first leaf node burned.
A boolean variable to check if the initial burnt node is in the tree rooted under current node.

Before moving ahead with the approach let's take a look at the tree below: 

            1
        /      \          
       2        3
     /   \     /
    4     5   6 
   /     / \
  8     9   10
       /
      11
In the above tree, if we set the leaf node 11 at fire. 

In 1s, the fire will reach node 9.
In 2s, the fire will reach node 5.
In 3rd second, the fire will reach node 2 and 10. Here comes an observation: 
In 2s fire reached node 5. For node 5, the initial burned leaf is in it's left subtree, so the time taken to burn right subtree will be the height of the right subtree which is 1. Therefore, fire reaches to node 10 in (2+1) = 3s.
Again, for node 2. Fire reached to node 2 in 3s from right subtree. Therefore, time taken to burn left subtree will be it's height.
So the solution is to apply recursion and for every node calculate the below-required values:  

Left Depth.
Right Depth.
The time required for fire to reach the current node.
Is the current subtree contains initial burnt leaf node.
So, for the minimum time required to burn any subtree will be: 

The time required for fire to reach the root node from initial burnt leaf + depth of the opposite side 

Therefore, to find time required to burn the complete tree, we need to calculate the above value for every node, and take maximum of that value. 

ans = max(ans, (time required for fire to reach current node + depth of other subtree))

Below is the implementation of the above approach:

// Java code to implement the approach

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

	// Driver code
	public static void main(String args[])
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.left.left.left = new Node(8);
		root.left.right.left = new Node(9);
		root.left.right.right = new Node(10);
		root.left.right.left.left = new Node(11);
		Distance dist = new Distance(-1);
		int target = 11;

		burnTime(root, target, dist);
		System.out.print(res);
	}

	static int res = 0;

	// Function to find the time to burn
	public static int burnTime(Node root, int leaf,
							Distance dist)
	{
		if (root == null)
			return 0;
		if (root.key == leaf) {
			dist.val = 0;
			return 1;
		}
		Distance ldist = new Distance(-1),
				rdist = new Distance(-1);
		int lh = burnTime(root.left, leaf, ldist);
		int rh = burnTime(root.right, leaf, rdist);

		if (ldist.val != -1) {
			dist.val = ldist.val + 1;
			res = Math.max(res, dist.val + rh);
		}
		else if (rdist.val != -1) {
			dist.val = rdist.val + 1;
			res = Math.max(res, dist.val + lh);
		}
		return Math.max(lh, rh) + 1;
	}
}

// Class to define a node of the tree
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

class Distance {
	int val;
	Distance(int d) { val = d; }
}
 * 
 * 
 * 
 */
