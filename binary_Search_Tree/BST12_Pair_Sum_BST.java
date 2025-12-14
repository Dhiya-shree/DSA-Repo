package binary_Search_Tree;

import java.util.HashSet;

/**
 * Pair with given sum 
 * 
 * 
 * Given a sum X 
 * 
 * Find if the value pair which sum gives x exist 
 * 
 * Method 0 : no extra space + time 
 * O N 
 *  Use hashmap 
 *  if root>x
 *    go left
 *  else 
 *   store x-root
 * 
 *    if x-root>root
 *      go right 
 *    else go  left
 *    
 * 
 * Method 1 extra space :
 * 
 * Do inorder traversal and store in array 
 * Do two pointer in the array 
 * 
 *  
 * 
 * @author shree
 *
 */
public class BST12_Pair_Sum_BST {

	public static void main(String[] args) {
		// pair sum 
		int arr[]= {5,3,4,8,9,6,7,1,2,10};
		BSTNode root=BST02_operation_medium.ConstructBST(arr);
		System.out.println(" BST ");
		BST02_operation_medium.ViewBST(root);
		
		hs=new HashSet<>();
		
		boolean anb=PairSumFind(root,20);
		System.out.println(" Pair sum available is "+anb);

	}

	private static boolean PairSumFind(BSTNode root, int x) {
		//pair sum 
		if(root==null) {
			return false;
		}
		
		if(!hs.isEmpty() && hs.contains(root.data)) {
			return true;
		}
		boolean ans=false;
		if(root.data>x) {
			root=root.right;
		}
		else {
			hs.add(x-root.data);
			ans=PairSumFind(root.left,x);
			if(!ans) {
			ans=PairSumFind(root.right,x);
			}
		}
		return ans;
	}

	static HashSet<Integer> hs;
	
	
	
}



/**

Pair Sum with given BST

Given a Balanced Binary Search Tree and a target sum, write a function that returns true if there is a pair with sum equals to target sum, otherwise return false. Expected time complexity is O(n) and only O(Logn) extra space can be used. Any modification to Binary Search Tree is not allowed. Note that height of a Balanced BST is always O(Logn).





The Brute Force Solution is to consider each pair in BST and check whether the sum equals to X. The time complexity of this solution will be O(n^2).
 

A Better Solution is to create an auxiliary array and store the Inorder traversal of BST in the array. The array will be sorted as Inorder traversal of BST always produces sorted data. Once we have the Inorder traversal, we can pair in O(n) time (See this for details). This solution works in O(n) time but requires O(n) auxiliary space.  


// Java code to find a pair with given sum
// in a Balanced BST
import java.util.ArrayList;

// A binary tree node
class Node {

    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class BinarySearchTree {

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree()
    {
        root = null;
    }

    // Inorder traversal of the tree
    void inorder()
    {
        inorderUtil(this.root);
    }

    // Utility function for inorder traversal of the tree
    void inorderUtil(Node node)
    {
        if (node == null)
            return;

        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }

    // This method mainly calls insertRec()
    void insert(int key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST **
    Node insertRec(Node root, int data)
    {

        /* If the tree is empty, return a new node **
        if (root == null) {
            root = new Node(data);
            return root;
        }

        /* Otherwise, recur down the tree **
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    // Method that adds values of given BST into ArrayList
    // and hence returns the ArrayList
    ArrayList<Integer> treeToList(Node node, ArrayList<Integer>
                                                 list)
    {
        // Base Case
        if (node == null)
            return list;

        treeToList(node.left, list);
        list.add(node.data);
        treeToList(node.right, list);

        return list;
    }

    // method that checks if there is a pair present
    boolean isPairPresent(Node node, int target)
    {
        // This list a1 is passed as an argument
        // in treeToList method
        // which is later on filled by the values of BST
        ArrayList<Integer> a1 = new ArrayList<>();

        // a2 list contains all the values of BST
        // returned by treeToList method
        ArrayList<Integer> a2 = treeToList(node, a1);

        int start = 0; // Starting index of a2

        int end = a2.size() - 1; // Ending index of a2

        while (start < end) {

            if (a2.get(start) + a2.get(end) == target) // Target Found!
            {
                System.out.println("Pair Found: " + a2.get(start) + " + " + a2.get(end) + " "
                                   + "= " + target);
                return true;
            }

            if (a2.get(start) + a2.get(end) > target) // decrements end
            {
                end--;
            }

            if (a2.get(start) + a2.get(end) < target) // increments start
            {
                start++;
            }
        }

        System.out.println("No such values are found!");
        return false;
    }

    // Driver function
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        /*
              15
            /     \
           10     20
          / \     / \
          8 12    16 25 
       **
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(16);
        tree.insert(25);

        tree.isPairPresent(tree.root, 33);
    }
}

// This code is contributed by Kamal Rawal



 

Output :  
 

Pair Found: 8 + 25 = 33
Complexity Analysis: 
Time Complexity: O(n). 
Inorder Traversal of BST takes linear time.
Auxiliary Space: O(n). 
Use of array for storing the Inorder Traversal.
A space optimized solution is to first in-place convert BST to Doubly Linked List (DLL), then find pair in sorted DLL in O(n) time. This solution takes O(n) time and O(Logn) extra space, but it modifies the given BST.

The solution discussed below takes O(n) time, O(Logn) space and doesn't modify BST. The idea is same as finding the pair in sorted array (See method 1 of this for details). We traverse BST in Normal Inorder and Reverse Inorder simultaneously. In reverse inorder, we start from the rightmost node which is the maximum value node. In normal inorder, we start from the left most node which is minimum value node. We add sum of current nodes in both traversals and compare this sum with given target sum. If the sum is same as target sum, we return true. If the sum is more than target sum, we move to next node in reverse inorder traversal, otherwise we move to next node in normal inorder traversal. If any of the traversals is finished without finding a pair, we return false.

Following is the implementation of this approach. 
 


/* In a balanced binary search tree 
isPairPresent two element which sums to 
a given value time O(n) space O(logn) **
import java.util.*;
class GFG
{
static final int MAX_SIZE= 100;

// A BST node
static class node
{
    int val;
    node left, right;
};

// Stack type
static class Stack
{
    int size;
    int top;
    node []array;
};

// A utility function to create a stack of given size
static Stack createStack(int size)
{
    Stack stack = new Stack();
    stack.size = size;
    stack.top = -1;
    stack.array = new node[stack.size];
    return stack;
}

// BASIC OPERATIONS OF STACK
static int isFull(Stack stack)
{
    return (stack.top - 1 == stack.size)?1:0 ;
}

static int isEmpty(Stack stack)
{
    return stack.top == -1?1:0;
}

static void push(Stack stack, node node)
{
    if (isFull(stack)==1)
        return;
    stack.array[++stack.top] = node;
}

static node pop(Stack stack)
{
    if (isEmpty(stack) == 1)
        return null;
    return stack.array[stack.top--];
}

// Returns true if a pair with target
// sum exists in BST, otherwise false
static boolean isPairPresent(node root, int target)
{
    // Create two stacks. s1 is used for
    // normal inorder traversal and s2 is
    // used for reverse inorder traversal
    Stack s1 = createStack(MAX_SIZE);
    Stack s2 = createStack(MAX_SIZE);

    // Note the sizes of stacks is MAX_SIZE,
    // we can find the tree size and fix stack size
    // as O(Logn) for balanced trees like AVL and Red Black
    // tree. We have used MAX_SIZE to keep the code simple

    // done1, val1 and curr1 are used for
    // normal inorder traversal using s1
    // done2, val2 and curr2 are used for
    // reverse inorder traversal using s2
    boolean done1 = false, done2 = false;
    int val1 = 0, val2 = 0;
    node curr1 = root, curr2 = root;

    // The loop will break when we either
  // find a pair or one of the two
    // traversals is complete
    while (true) 
    {
      
        // Find next node in normal Inorder
        // traversal. See following post
        // https:// www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
        while (done1 == false) 
        {
            if (curr1 != null) 
            {
                push(s1, curr1);
                curr1 = curr1.left;
            }
            else 
            {
                if (isEmpty(s1) == 1)
                    done1 = true;
                else
                {
                    curr1 = pop(s1);
                    val1 = curr1.val;
                    curr1 = curr1.right;
                    done1 = true;
                }
            }
        }

        // Find next node in REVERSE Inorder traversal. The only
        // difference between above and below loop is, in below loop
        // right subtree is traversed before left subtree
        while (done2 == false) 
        {
            if (curr2 != null)
            {
                push(s2, curr2);
                curr2 = curr2.right;
            }
            else {
                if (isEmpty(s2) == 1)
                    done2 = true;
                else {
                    curr2 = pop(s2);
                    val2 = curr2.val;
                    curr2 = curr2.left;
                    done2 = true;
                }
            }
        }

        // If we find a pair, then print the pair and return. The first
        // condition makes sure that two same values are not added
        if ((val1 != val2) && (val1 + val2) == target)
        {
            System.out.print("Pair Found: " + 
                             val1+ "+ " + 
                             val2+ " = " +  
                             target +"\n");
            return true;
        }

        // If sum of current values is smaller,
        // then move to next node in
        // normal inorder traversal
        else if ((val1 + val2) < target)
            done1 = false;

        // If sum of current values is greater,
        // then move to next node in
        // reverse inorder traversal
        else if ((val1 + val2) > target)
            done2 = false;

        // If any of the inorder traversals is
        // over, then there is no pair
        // so return false
        if (val1 >= val2)
            return false;
    }
}

// A utility function to create BST node
static node NewNode(int val)
{
    node tmp = new node();
    tmp.val = val;
    tmp.right = tmp.left = null;
    return tmp;
}

// Driver program to test above functions
public static void main(String[] args)
{
    /* 
                15 
                / \ 
            10 20 
            / \ / \ 
            8 12 16 25 **
    node root = NewNode(15);
    root.left = NewNode(10);
    root.right = NewNode(20);
    root.left.left = NewNode(8);
    root.left.right = NewNode(12);
    root.right.left = NewNode(16);
    root.right.right = NewNode(25);

    int target = 33;
    if (isPairPresent(root, target) == false)
        System.out.print("\nNo such values are found\n");
}
}

// This code is contributed by aashish1995 
Output: 

 Pair Found: 8 + 25 = 33
Complexity Analysis: 
Time Complexity: O(n). 
Inorder Traversal of BST takes linear time.
Auxiliary Space: O(logn). 
The stack holds log N values as at a single time


*/