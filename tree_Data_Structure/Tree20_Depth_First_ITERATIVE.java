package tree_Data_Structure;

import java.util.Stack;

/**
 *   ITERATIVE - DEPTH ORDER FIRST 
 *   
 *   
 * 1) INORDER - iterative 
 *   Left - root - right 
 *   
 *   Use a stack 
 *   stack - root - left - left left - left left left ... so on 
 *   till left==null
 *   
 *   Pop the stack and check for right as root 
 *   
 *   till root .. print root 
 *   
 *   pop root and push as left 
 *   
 *   
 * 2) Pre order 
 * 
 *  till stack not empty 
 *    push root 
 *    print root
 *    push left 
 *    push right
 * 
 * 3) Pre order space efficient
 *  * Create stack 
		 * push root 
		 * curr=root !!!! NOt stack 
		 * 
		 * while s is not empty 
		 *  
		 *   while curr!=null 
		 *      
		 *      push curr.right if not null
		 *      print root 
		 *      root=root.left
		 *      
		 *    Loops ends when left is null
		 *  curr=s.pop -- right 
		 *  consider right as root and continue
		 * 
		
 * 
 * 
 * 4) Post order
 * 
 *    Push root
 * 
 * @author shree
 *
 */
public class Tree20_Depth_First_ITERATIVE {

	public static void main(String[] args) {
		Node root = new Node(100);
		root.left = new Node(40);
		root.right = new Node(60);
		root.left.left = new Node(10);
		root.left.right = new Node(301);
		root.right.right = new Node(600);
		root.right.left=new Node(22);
		root.left.left.left = new Node(110);
		root.left.left.right = new Node(30); ///
	
		
		root.left.right.left = new Node(6000);
		root.left.right.right = new Node(60);
		
		
		
		Inorder_Iterative(root);
		System.out.println();
		Preorder_Iterative_Naive(root);
		System.out.println(" Space Efficient ....");
		PreOrder_Iterative_Space(root);
		
		System.out.println();
        PostOrder_Iterative(root);		
 
	}

	private static void PostOrder_Iterative(Node root) {
		// post order 
		int DO_POST_ORDER=0;
		Stack<Node> s=new Stack<>();
		if(root==null) {
			return ;
		}
		Node curr=root.left;
		s.push(root);
		while(!s.isEmpty()) {
			//outer - for right 
			
			while(curr!=null) {
				//inner for left 
				s.push(curr);
	
				System.out.print(curr.data+" ");
			    curr=curr.left;
			}
			curr=s.pop();
			// Root
			System.out.print(curr.data+" ");
			//Right
			curr=curr.right;
		}
		
	}

	public static void PreOrder_Iterative_Space(Node root) {
		// Dont store left child 
		// You want to print right ?
		// So only push right child in stack 
		
		/*
		 * Create stack 
		 * push root 
		 * curr=root !!!! NOt stack 
		 * 
		 * while s is not empty 
		 *  
		 *   while curr!=null 
		 *      
		 *      push curr.right if not null
		 *      print root 
		 *      root=root.left
		 *      
		 *    Loops ends when left is null
		 *  curr=s.pop -- right 
		 *  consider right as root and continue
		 * 
		 */
		Stack<Node> s=new Stack<>();
		if(root==null) {
			return ;
		}
		Node curr=root;
		s.push(curr);
		while(!s.isEmpty()) {
			//outer - for right 
			
			while(curr!=null) {
				//inner for left 
				if(curr.right!=null) {
					s.push(curr.right);
				}
				System.out.print(curr.data+" ");
			    curr=curr.left;
			}
			curr=s.pop();
		}
		
		
	}

	private static void Preorder_Iterative_Naive(Node root) {
		// use stack print root first 
		Stack<Node> s=new Stack<>();
		if(root==null) {
			return ;
		}
		Node curr=root;
		s.push(curr);
		while(!s.isEmpty()) {
			
		       curr=s.pop();
				System.out.print(curr.data+" ");
				// See root left - right 
				// So put right first in stack before left 
				
				if(curr.right!=null) {
				s.push(curr.right);
				}
				//First RIGHT 
				if(curr.left!=null) {
					s.push(curr.left);
				}
					
			}
					
	}

	private static void Inorder_Iterative(Node root) {
		//use stack 
		Stack<Node> s=new Stack<>();
		Node curr=root;
		
		while(curr!=null || s.isEmpty()==false) {
			
			while(curr!=null) {
				//For left branch push till null 
				s.push(curr);
				curr=curr.left;
			}
			
			curr=s.pop();
			System.out.print(curr.data+" ");
			//Pop and consider each right as root 
			curr=curr.right;
		}
		
	}
}


/**
Iterative Preorder Traversal

Given a Binary Tree, write an iterative function to print the Preorder traversal of the given binary tree.
To convert an inherently recursive procedure to iterative, we need an explicit stack. Following is a simple stack based iterative process to print Preorder traversal. 
1) Create an empty stack nodeStack and push root node to stack. 
2) Do the following while nodeStack is not empty. 
a) Pop an item from the stack and print it. 
b) Push right child of a popped item to stack 
c) Push left child of a popped item to stack
The right child is pushed before the left child to make sure that the left subtree is processed first.


 


// Java program to implement iterative preorder traversal
import java.util.Stack;

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

    void iterativePreorder()
    {
        iterativePreorder(root);
    }

    // An iterative process to print preorder traversal of Binary tree
    void iterativePreorder(Node node)
    {

        // Base Case
        if (node == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first *
        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            Node mynode = nodeStack.peek();
            System.out.print(mynode.data + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        tree.iterativePreorder();
    }
}

// This code has been contributed by Mayank Jaiswal

 


Output: 
10 8 3 5 2 2

 

Time Complexity: O(N) 
Auxiliary Space: O(H), where H is the height of the tree.

 

Another Solution: In the previous solution we can see that the left child is popped as soon as it is pushed to the stack, therefore it is not required to push it into the stack. 



The idea is to start traversing the tree from the root node, and keep printing the left child while exists and simultaneously, push the right child of every node in an auxiliary stack. Once we reach a null node, pop a right child from the auxiliary stack and repeat the process while the auxiliary stack is not-empty. 


This is a micro-optimization over the previous approach, both the solutions use asymptotically similar auxiliary space.


Below is the implementation of the above approach: 
 

import java.util.Stack;

// A binary tree node
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

class BinaryTree{

Node root;

void preorderIterative()
{
    preorderIterative(root);
}

// Iterative function to do Preorder
// traversal of the tree 
void preorderIterative(Node node)
{
    if (node == null) 
    {
        return;
    }

    Stack<Node> st = new Stack<Node>();
    
    // Start from root node (set curr 
    // node to root node)
    Node curr = node;
    
    // Run till stack is not empty or 
    // current is not NULL 
    while (curr != null || !st.isEmpty())
    {
        
        // Print left children while exist 
        // and keep pushing right into the  
        // stack. 
        while (curr != null)
        {
            System.out.print(curr.data + " ");
            
            if (curr.right != null)
                st.push(curr.right);
                
            curr = curr.left;
        }
        
        // We reach when curr is NULL, so We 
        // take out a right child from stack 
        if (!st.isEmpty()) 
        {
            curr = st.pop();
        }
    }
}

// Driver code
public static void main(String args[])
{
    BinaryTree tree = new BinaryTree();
    
    tree.root = new Node(10);
    tree.root.left = new Node(20);
    tree.root.right = new Node(30);
    tree.root.left.left = new Node(40);
    tree.root.left.left.left = new Node(70);
    tree.root.left.right = new Node(50);
    tree.root.right.left = new Node(60);
    tree.root.left.left.right = new Node(80);
    
    tree.preorderIterative();
}
}

// This code is contributed by Vivek Singh Bhadauria

 


Output: 
10 20 40 70 80 50 30 60

 
 

Time Complexity: O(N) 
Auxiliary Space: O(H), where H is the height of the tree.


*/