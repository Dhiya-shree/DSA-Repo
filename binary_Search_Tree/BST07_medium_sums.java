package binary_Search_Tree;

import java.util.Arrays;

/**
 * Problem #1 :
 * Ceil on left side of array 
 * 
 * input: {2,8,30,15,25,12}
 * For 2 -> no -1
 * For 8 -> no -1
 * For 30 -> -1
 * For 15 -> 30
 * For 25 -> 30
 * For 12 ->15
 * 
 * Naive Solution :
 * O N2 
 * For every element :
 *   Check for ceil in the given array 
 *   
 * Efficient :
 * Use tree withort sorting the array
 *        2
 *          \
 *           8
 *            \
 *             30
 *            /
 *          15
 *        /  \
 *       12  25
 *       
 * For every element check root's left and check if left is present 
 * 
 * Problem #2: Design a data to 
 * Search,Insert,Delete,Kth Smallest 
 *
 * Use normal tree
 * For kth smallest 
 * Go to leftmost and start the count   
 *  
 * Problem #3 : Check for BST 
 * 
 * For every node check for left and right 
 * If left is small and right is big 
 *           55
 *         /   \
 *       30     70
 *     /   \   /  \
 *    10   40 50  80 
 *  
 *  Everything seems correct above .
 *  BUT NOT A FUCKING BINARY TREE 
 *  
 *  Root 55 < right tree val 50 X X X X X X X
 *  
 *  
 *  Naive solution :
 *  Find maximum in left sub tree 
 *  Find minimum in right subtree 
 *  
 *  For each node do above work 
 *  Left < right must be there 
 *  
 *  ANS:
 *  Do an Inorder trabersal 
 *  Go to extreme left 
 *  Have a pointer prev
 *  For first prev = MIN_VALUE 
 *  
 *  Go to left most 
 *  Make the left most as prev ....
 *  
 *  Go to root check if val > prev 
 *  make root as prev 
 *  
 *  Go to right check if val>prev 
 *  
 *  And so on ....
 *  
 *  
 *  Efficient solutions :
 *  
 *  Solution 1:
 *  Pass range at each node 
 *  Root node - - infinity to nfinity 
 *  root.left - -infinity to root value-1
 *  root.righht-  rootvalue+1 to infinity 
 *  
 *  If any value not in range - not a BST 
 *  
 *  
 *  Solution 2:
 *  
 *  Do inorder traversal 
 *  Have prev 
 *  For root.leftmost prev =-1 
 *  for root >  prev root.leftmost:
 *      Make root as prev
 *  for root.right > prev 
 *     Make root.right as prev and go on 
 *     
 *     
 *  
 *  
 * @author shree
 *
 */
public class BST07_medium_sums {

	public static void main(String[] args) {
		String a="1 2 3 44 55 6666 77777";
		int n=a.length();
		StringToArray(a,n);
		char one=a.charAt(0);
		int on=(one-48);
		System.out.println(" ON "+on);
		
	//	BSTNode root=null;
		int arr[]= {1,2,3,2,1};
		int ans[]=CeilOfArray(arr);
		System.out.println("ARR: "+Arrays.toString(arr));
		System.out.println("ANS: "+Arrays.toString(ans));
	
		BSTNode root=ConstructBST(arr);
		ViewBST(root);
		BST02_operation_medium.TraverseLevelOrderQueueTwoLoops(root);
	   //count=Integer.MIN_VALUE;
	    int small=FindTheKthSmall(root,3);
	    System.out.println(" Kth small"+small+".."+ansFin);
	    ViewBST(root);
		BST02_operation_medium.TraverseLevelOrderQueueTwoLoops(root);
	   
	    // Check for bst 
		
		// Solution 1
		boolean anb=CheckForBSTRange(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
		System.out.println(" Is a BST is "+anb);
		//Solution 2 
		prev=Integer.MIN_VALUE;
		anb=InorderCheck(root);
		System.out.println(" Is a BST is "+anb);
		
	}

	static int prev;
	private static boolean InorderCheck(BSTNode root) {
		//inorder 
		if(root==null) {
			return true;
		}
		
		boolean left=InorderCheck(root.left);
		if(left==false) {
			return false;
		}
		
		if(root.data<prev) {
			return false;
		}
		else {
			prev=root.data;
		}
		
		left=InorderCheck(root.right);
		return left;
	}


	private static boolean CheckForBSTRange(BSTNode root, int maxValue, int minValue) {
		// TODO Auto-generated method stub
		if(root==null) {
			return true;
		}
		
		if(root.left!=null && root.left.data>root.data) {
			return false;
		}
		
		if(root.right!=null && root.right.data<root.data) {
			return false;
		}
		
		boolean left=CheckForBSTRange(root.left,root.data,minValue);
		
		if(left) {
			left=CheckForBSTRange(root.right, maxValue, root.data);
		}
		
		return left;
	}


	private static void StringToArray(String s, int n) {
		int arr[]=new int[n];
		int i=0;int val=0;int j=0;
		while(i<n) {
			if(s.charAt(i)!=' ') {
			val=val*10+(s.charAt(i)-48);
			}
			else {
				arr[j]=val;
				val=0;
				j++;
			}
			i++;
			
		}
		System.out.println("...string to arr"+Arrays.toString(arr));
	}


	static int count;
	private static int FindTheKthSmall(BSTNode root, int i) {
		// 
		if(root==null) {
			///count=0;
			return 0;
		}
		//nAIVE
		//Efficient is Augumented BST 
		FindTheKthSmall(root.left,i);
//		if(count==i && ansFin==-1) {
//			System.out.println(" ....left");
//			ansFin=root.key;
//			return 0;
//		}
		//Root left must not be alculated
		
		//For root
		count=count+1;
		System.out.println(" Count "+count+" "+root.key);
		if(count==i) {
			ansFin=root.key;
			//return ansFin;
		}
		//No use of value 
		FindTheKthSmall(root.right,i);
		
		return ansFin;
	}

	static int ansFin;
	private static int[] CeilOfArray(int[] arr) {
		//Insert a element in tree 
		//On insertion check for max closest value 
		int n=arr.length;
		int ans[]=new int[n];
		BSTNode root=null;
		for(int i=0;i<n;i++) {
			ansFin=-1;//ansSet=true;
			root=InsertAndGetCeil(arr[i],root);
			ans[i]=ansFin;
		}
		return ans;
	}
	
	private static BSTNode InsertAndGetCeil(int check,BSTNode root) {
		// return -1 if none
		if(root==null) {
			return new BSTNode(check);
		}
		
		if((root.key==check || root.key>check) && (ansFin==-1|| root.key<ansFin)) {
			ansFin=root.key;
		}
		
		if(check>root.key) {
			root.right=InsertAndGetCeil(check,root.right);
		}
		else {
         root.left=InsertAndGetCeil(check,root.left);
		}
		return root;
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
	
	private static void ViewBST(BSTNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.key+" ");
		ViewBST(root.left);
		System.out.print("|");
		ViewBST(root.right);
	}
	
private static boolean InsertIterative(BSTNode root, int data) {
	// insert terative 
	
	
	
	while(root!=null) {
	    //Removing below condt to add duplicate in tree 
		
		if(root.key<=data) {
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

}


/**

Check for BST

A binary search tree (BST) is a node based binary tree data structure which has the following properties. 

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
From the above properties it naturally follows that: 

Each node (item in the tree) has a distinct key.
BST



METHOD 1 (Simple but Wrong) 
Following is a simple program. For each node, check if the left node of it is smaller than the node and right node of it is greater than the node.
 

boolean isBST(Node node)
{
    if (node == null)
        return true;
    
    /* False if left is > than node **
    if (node.left != null && node.left.data > node.data)
        return false;
    
    /* False if right is < than node **
    if (node.right != null && node.right.data < node.data) 
        return false; 
    
    /* False if, recursively, the left or right is not a BST **
    if (!isBST(node.left) || !isBST(node.right)) 
        return false; 
    
    /* Passing all that, it's a BST **
    return true; 
}

// This code is contributed by shubhamsingh10

This approach is wrong as this will return true for below binary tree (and below tree is not a BST because 4 is in left subtree of 3) 
tree_bst

METHOD 2 (Correct but not efficient) 
For each node, check if max value in left subtree is smaller than the node and min value in right subtree greater than the node. 


/* Returns true if a binary tree is a binary search tree ** 
int isBST(Node node) 
{ 
  if (node == null) 
    return 1; 
    
  /* false if the max of the left is > than us **
  if (node.left != null && maxValue(node.left) >= node.data) 
    return 0; 
    
  /* false if the min of the right is <= than us **
  if (node.right != null && minValue(node.right) <= node.data) 
    return 0; 
  
  /* false if, recursively, the left or right is not a BST **
  if (!isBST(node.left) || !isBST(node.right)) 
    return 0; 
    
  /* passing all that, it's a BST **
  return 1; 
} 

// This code is contributed by akshitsaxenaa09.
It is assumed that you have helper functions minValue() and maxValue() that return the min or max int value from a non-empty tree

METHOD 3 (Correct and Efficient): 
Method 2 above runs slowly since it traverses over some parts of the tree many times. A better solution looks at each node only once. The trick is to write a utility helper function isBSTUtil(struct node* node, int min, int max) that traverses down the tree keeping track of the narrowing min and max allowed values as it goes, looking at each node only once. The initial values for min and max should be INT_MIN and INT_MAX -- they narrow from there. 

Note: This method is not applicable if there are duplicate elements with value INT_MIN or INT_MAX.

Below is the implementation of the above approach: 


//Java implementation to check if given Binary tree
//is a BST or not

/* Class containing left and right child of current
 node and key value**
class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BinaryTree
{
    //Root of the Binary Tree
    Node root;

    /* can give min and max value according to your code or
    can write a function to find min and max value of tree. **

    /* returns true if given search tree is binary
     search tree (efficient version) **
    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }

    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. **
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST **
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints **
        if (node.data < min || node.data > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints **
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }

    /* Driver program to test above functions **
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}


Output: 

IS BST
Time Complexity: O(n) 
Auxiliary Space: O(1) if Function Call Stack size is not considered, otherwise O(n)
  
Simplified Method 3 
We can simplify method 2 using NULL pointers instead of INT_MIN and INT_MAX values.  
 


// Java program to check if a given tree is BST. 
class Sol
{

// A binary tree node has data, pointer to 
//left child && a pointer to right child /
static class Node 
{ 
    int data; 
    Node left, right; 
}; 

// Returns true if given tree is BST. 
static boolean isBST(Node root, Node l, Node r) 
{ 
    // Base condition 
    if (root == null) 
        return true; 

    // if left node exist then check it has 
    // correct data or not i.e. left node's data 
    // should be less than root's data 
    if (l != null && root.data <= l.data) 
        return false; 

    // if right node exist then check it has 
    // correct data or not i.e. right node's data 
    // should be greater than root's data 
    if (r != null && root.data >= r.data) 
        return false; 

    // check recursively for every node. 
    return isBST(root.left, l, root) && 
        isBST(root.right, root, r); 
} 

// Helper function that allocates a new node with the 
//given data && null left && right pointers. /
static Node newNode(int data) 
{ 
    Node node = new Node(); 
    node.data = data; 
    node.left = node.right = null; 
    return (node); 
} 

// Driver code
public static void main(String args[])
{ 
    Node root = newNode(3); 
    root.left = newNode(2); 
    root.right = newNode(5); 
    root.left.left = newNode(1); 
    root.left.right = newNode(4); 

    if (isBST(root,null,null)) 
        System.out.print("Is BST"); 
    else
        System.out.print("Not a BST"); 
}
} 

// This code is contributed by Arnab Kundu



Output: 

Not a BST
METHOD 4(Using In-Order Traversal) 
Thanks to LJW489 for suggesting this method. 
1) Do In-Order Traversal of the given tree and store the result in a temp array. 
2) This method assumes that there are no duplicate values in the tree
3) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.
Time Complexity: O(n)
We can avoid the use of a Auxiliary Array. While doing In-Order traversal, we can keep track of previously visited node. If the value of the currently visited node is less than the previous value, then tree is not BST. Thanks to ygos for this space optimization. 


// Java implementation to check if given Binary tree
// is a BST or not

/* Class containing left and right child of current
 node and key value**
class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BinaryTree
{
    // Root of the Binary Tree
    Node root;

    // To keep tract of previous node in Inorder Traversal
    Node prev;

    boolean isBST()  {
        prev = null;
        return isBST(root);
    }

    /* Returns true if given search tree is binary
       search tree (efficient version) **
    boolean isBST(Node node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if (!isBST(node.left))
                return false;

            // allows only distinct values node
            if (prev != null && node.data <= prev.data )
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }

    /* Driver program to test above functions **
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}


The use of a static variable can also be avoided by using a reference to the prev node as a parameter.

// Java program to check if a given tree is BST.
import java.io.*;

class GFG {
    /* A binary tree node has data, pointer to
    left child and a pointer to right child **
    public static class Node
    {
        public int data;
        public Node left, right;
        
        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    };
    
    static  Node prev;
    
    static Boolean isBSTUtil(Node root)
    {
        // traverse the tree in inorder fashion and 
        // keep track of prev node
        if (root != null)
        {
            if (!isBSTUtil(root.left))
            return false;
    
            // Allows only distinct valued nodes 
            if (prev != null && 
                root.data <= prev.data)
            return false;
    
            prev = root;
    
            return isBSTUtil(root.right);
        }
        return true;
    }
    
    static Boolean isBST(Node root)
    {
        return isBSTUtil(root);
    }
    
    // Driver Code
    public static void main (String[] args) 
    {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
    
        if (isBST(root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
    }
}

// This code is contributed by Shubham Singh
Output:  

Not a BST


*/