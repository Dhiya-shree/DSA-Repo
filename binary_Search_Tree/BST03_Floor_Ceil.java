package binary_Search_Tree;

/**
 * 
 * Floor :
 * In the BST , given num - x
 * Find the closest small value 
 * 
 * 1)x found in tree- retrn X 
 * 2)Val less than x found 
 *      -- return val 
 * 3)No val less than x 
 *     -- return null -1
 * 
 * Ceil :
 * In the BST , given num - x
 * Find the closest large value 
 * 
 * 
 * @author shree
 *
 */
public class BST03_Floor_Ceil {

	public static void main(String[] args) {
		// floor and ceil 

		int arr[]= {50,30,70,40,10,60,80};
		BSTNode root=BST02_operation_medium.ConstructBST(arr);
		BST02_operation_medium.ViewBST(root);
		BST02_operation_medium.TraverseLevelOrderQueueTwoLoops(root);
	
	   int check=20;
	   ans=-1;//finans=-1;
	   int floor=FloorRecursive(root,check);
	   System.out.println(" Floor for "+check+"= "+floor);
	   
	   floor=FloorIterative(root,check);
	   System.out.println(" Floor for "+check+"= "+floor);
	   
	   ans=-1;
	   int ceil=CeilRecursive(root,check);
	   System.out.println(" ceil for "+check+"= "+ceil);
	   
	   ceil=CeilIterative(root,check);
	   System.out.println(" ceil for "+check+"= "+ceil);
	
	}
    private static int CeilIterative(BSTNode root, int check) {
		// ceil iterative 
    	int ans=-1;
    	while(root!=null) {
    		System.out.print(root.key+" ");
    		if(root.key==check) {
    			return root.key;
    		}
    		
    		if(root.key>check) {
    			ans=root.key;
    			root=root.left;
    			//return ans;
    		}
    		else {
    			root=root.right;
    		}
    	}
		return ans;
	}
	private static int CeilRecursive(BSTNode root, int check) {
		// ceil recursive 
    	
    	if(root==null) {
    		return ans;
    	}
    	if(root.key==check) {
    		return root.key;
    	}
    	
    	if(root.key>check) {
    		ans=root.key;
    		//Once found someting a bit big , return it or go left 
    		ans=CeilRecursive(root.left,check);
    	}
    	else {
    		ans=CeilRecursive(root.right,check);
    	}
		return ans;
	}
	private static int FloorIterative(BSTNode root, int check) {
		// floor iterative 
    	int ans=-1;
    	while(root!=null) {
    		System.out.print(root.key+" ");
    		if(root.key==check) {
    			return root.key;
    		}
    		
    		if(root.key<check) {
    			ans=root.key;
    			root=root.right;
    		}
    		else {
    			root=root.left;
    		}
    	}
		return ans;
	}
	static int ans ;//static int finans;
	private static int FloorRecursive(BSTNode root,int data) {
		// floor recusrive 
		
		if(root==null) {
			return ans;
		}
		if(data==root.key) {
			ans=root.key;
			return ans;
		}
		System.out.print(root.key+"...");
		if(root.key<data) {
			ans=root.key;
			ans=FloorRecursive(root.right,data);
		}
		else {
			ans=FloorRecursive(root.left,data);;
		}
		
		return ans;
	}

}

/**
 * 
 * 
 * 
 * Floor in BST

Given a Binary Search Tree and a number x, find floor of x in the given BST.

Input : x = 14 and root of below tree
            10
           /  \
          5    15
              /  \
            12    30
Output : 12

Input : x = 15 and root of below tree
            10
           /  \
          5    15
              /  \
            12    30
Output : 15    



 


A simple solution is to traverse the tree using (Inorder or Preorder or Postorder) and keep track of closest smaller or same element. Time complexity of this solution is O(n) where n is total number of Nodes in BST.
We can efficiently find closest smaller or same element in O(h) time where h is height of BST. Algorithm to find the floor of a key in a binary search tree (BST): 
 

1 Start at the root Node.
2 If root->data == key, 
     floor of the key is equal 
     to the root.
3 Else if root->data > key, then 
     floor of the key must lie in the
     left subtree.
4 Else floor may lie in the right subtree 
  but only if there is a value lesser than 
  or equal to the key.If not, then root is
  the key.

For finding ceil of BST you can refer to this article. 
 


// Java code to find floor of a key in BST
class GfG {

    /*Structure of each Node in the tree*
    static class Node {
        int data;
        Node left, right;
    }

    /*This function is used to create and 
initializes new Nodes*
    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.data = key;
        return temp;
    }

    /* This function is used to insert 
new values in BST*
    static Node insert(Node root, int key)
    {
        if (root == null)
            return newNode(key);
        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }

    /*This function is used to find floor of a key*
    static int floor(Node root, int key)
    {
        if (root == null)
            return Integer.MAX_VALUE;

        /* If root->data is equal to key *
        if (root.data == key)
            return root.data;

        /* If root->data is greater than the key *
        if (root.data > key)
            return floor(root.left, key);

        /* Else, the floor may lie in right subtree 
    or may be equal to the root*
        int floorValue = floor(root.right, key);
        return (floorValue <= key) ? floorValue : root.data;
    }

    public static void main(String[] args)
    {
        /* Let us create following BST 
            7 
            / \ 
        5     10 
        / \ / \ 
        3 6 8 12 *
        Node root = null;
        root = insert(root, 7);
        insert(root, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 8);
        insert(root, 12);
        System.out.println(floor(root, 9));
    }
}

 


Output: 
8
*/



/*
 * 
 * Ceil in BST

Given a binary tree and a key(node) value, find the ceil value for that particular key value.
Ceil Value Node: Node with the smallest data larger than or equal to the key value.

For example, Let's consider the Binary Tree below - 

          8
        /   \    
      4      12
    /  \    /  \
   2    6  10   14

Key: 11   Ceil: 12
Key: 1    Ceil: 2
Key: 6    Ceil: 6
Key: 15   Ceil: -1
There are numerous applications where we need to find the floor/ceil value of a key in a binary search tree or sorted array. For example, consider designing a memory management system in which free nodes are arranged in BST. Find the best fit for the input request. 

Algorithm:  

Imagine we are moving down the tree, and assume we are root node. 
The comparison yields three possibilities,

A) Root data is equal to key. We are done, root data is ceil value.

B) Root data < key value, certainly the ceil value can't be in left subtree. 
   Proceed to search on right subtree as reduced problem instance.

C) Root data > key value, the ceil value may be in left subtree. 
   We may find a node with is larger data than key value in left subtree, 
   if not the root itself will be ceil node.

Here is the code for ceil value: 

// Java program to find ceil of a given value in BST 

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

    // Function to find ceil of a given input in BST. 
    // If input is more than the max key in BST, 
    // return -1 
    int Ceil(Node node, int input) 
    { 

        // Base case 
        if (node == null) { 
            return -1; 
        } 

        // We found equal key 
        if (node.data == input) { 
            return node.data; 
        } 

        // If root's key is smaller, 
        // ceil must be in right subtree 
        if (node.data < input) { 
            return Ceil(node.right, input); 
        } 

        // Else, either left subtree or root 
        // has the ceil value 
        int ceil = Ceil(node.left, input); 

        return (ceil >= input) ? ceil : node.data; 
    } 

    // Driver Code 
    public static void main(String[] args) 
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(8); 
        tree.root.left = new Node(4); 
        tree.root.right = new Node(12); 
        tree.root.left.left = new Node(2); 
        tree.root.left.right = new Node(6); 
        tree.root.right.left = new Node(10); 
        tree.root.right.right = new Node(14); 
        for (int i = 0; i < 16; i++) { 

            System.out.println(i + " " + tree.Ceil(tree.root, i)); 
        } 
    } 
} 

// This code has been contributed by Mayank Jaiswal 

 


Output
0 2
1 2
2 2
3 4
4 4
5 6
6 6
7 8
8 8
9 10
10 10
11 12
12 12
13 14
14 14
15 -1
Time complexity: O(logn) 

Auxiliary Space: O(logn) 


 * 
 * 
 */
