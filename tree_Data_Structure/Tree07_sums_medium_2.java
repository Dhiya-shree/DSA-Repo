package tree_Data_Structure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem #1 : Spriral Tree Traversal / Zig Zag Traversal 
 * 
 * Use Level Order Traversal {@link Tree03_Traversal_Level_order}
 * Level order traversal print nodes at each level 
 * For alternative level use a new stack to put in values and print at end 
 * 
 * 
 * Ex :
 *            10
 *           /  \
 *          20   30
 *         / \   / \
 *        50 60 15  45
 *          / \     / \
 *         1   2   3   4
 *
 * Output : 10 | 30 20 | 50 60 15 45 | 4 3 2 1
 *          N   reverse    Normal       reverse
 *          
 * Method 1: Queue + Additional stack 
 * 
 * 1) Set reverse = false 
 * 2) If reverse== false 
 *      print the data 
 *    else reverse == true 
 *      put the data in stack 
 *  3) After removing the level items and push its child
 *     if reverse == true
 *        Empty the stack and print each 
 *     else 
 *        set reverse = true
 * 
 * Method 2: Two Stack 
 * Here instead of using queue and stack 
 * Use attack alternatively 
 * 
 * Use boolean reverse :
 * Stack 1 -> correct ; Stack 2-> reverse
 * 
 * if  reverse = false  
 *   Pop from pre existing stack and print 
 *   Push in reverse stack 
 *   left first , right next 
 *   
 * if reverse = true 
 *   Pop from reverse stack 
 *   Push in normal stack 
 *   right first , the left 
 *   ( Allows proper normal when popping )
 *   
 *  Stack Normal      Stack Reverse 
 *    
 *    right              left left
 *    left               left right
 *                       right left
 *                       right right
 * Normal poped:
 *    right<- left  
 * Reverse poped :
 *    left left<- left right <- right left <- right right 
 * 
 * Problem #2 : Node at distance 
 * Given a Binary Tree and a positive integer k. 
 * The task is to count all distinct nodes that are distance k from a leaf node. 
 * A node is at k distance from a leaf if it is present k levels above the leaf and also,
 * is a direct ancestor of this leaf node.
 * If k is more than the height of Binary Tree,
 * then nothing should be counted.
 *
 *Note: Any such node should be counted only once.
 *For example, if a node is at a distance k from 2 or more leaf nodes,
 * then it would add only 1 to our count.
 * 
 * 
 * Problem # 3: Is a Subtree ?
 * Given two binary trees with head reference as T and S having at most N nodes. The task is to check if S is present as subtree in T.
A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.

Example 1:

Input:
T:      1          S:   3
      /   \            /
     2     3          4
   /  \    /
  N    N  4
Output: 1 
Explanation: S is present in T

Example 2:

Input:
T:      26         S:   26
       /   \           /  \
     10     N        10    N
   /    \           /  \
   20    30        20  30
  /  \            /  \
 40   60         40  60
Output: 1 
Explanation: 
S and T are both same. Hence, 
it can be said that S is a subtree 
of T.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isSubtree() that takes root node of S and T as parameters and returns 1 if S is a subtree of T else 0.

Note: The nodes can have the duplicate values.


Expected Time Complexity: O(N^2).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 103
1 <= Value of nodes <= 104
 
 
 
 
 
 * 
 * 
 * Problem # 4: Foldable Binary TRee 
 * Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. An empty tree is considered as foldable.
Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.


(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
(c)
        10
       /  \
      7   15
     /    /
    5   11
(d)
         10
       /   \
      7     15
    /  \    /
   9   10  12
 
Example 1:

Input:
     10
    /    \
   7     15
 /  \   /  \
N   9  11   N
Output:Yes
Explaination:Structure of every left and right subtree are same. 
Example 2:

Input:
      10
    /    \
   7     15
 /  \   /  \
5   N  11   N
Output: No
Explaination: 7's left child is not NULL and right child is NULL. That's why the tree is not foldable. 


Your Task:
The task is to complete the function isFoldable() that takes root of the tree as input and returns true or false depending upon whether the tree is foldable or not.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 <= n <= 103
1 <= data of node <= 104
 * 
 * 
 * 
 * 
 * Problem #5 : Chek for balanced tree
 * 
 * 
 * 
 * @author shree
 *
 */
class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
public class Tree07_sums_medium_2 {

	public static void main(String[] args) {
		// Sum medium 2 
		
		Node root = new Node(100);
		root.left = new Node(40);
		root.right = new Node(60);
		root.left.left = new Node(10);
		root.left.left.left = new Node(100);
		root.left.right = new Node(30);
		root.left.right.right = new Node(30); ///
		root.right.right = new Node(600);
		root.right.left=new Node(22);
		
		root.right.right.right = new Node(6000);
		root.right.right.right.left = new Node(60);
		
		
		//////////////////////////SPIRAL ----- ZIG ZAG ///////////////////
		System.out.println(" TRee is :");
		TraverseLevelOrderQueueTwoLoops(root);
		ArrayList<Integer> ans=SpiralTraversal(root);
	    System.out.println("Spiral ans "+ans.toString());
	    
	    ans.clear();
	    ans=ZigZagTraversal(root);
	    System.out.println("Zig zag ans "+ans.toString());
	    
	    
       //------------------------------------------------------------------------
	      boolean anb=isSubtree(root,root.left); // root , subtree root
	      System.out.println(" Sub tree is "+anb);
	      
	      anb=IsFoldable(root);
	      System.out.println(" Tree folddable "+anb);

	}
	
	private static boolean IsFoldable(Node root) 
	{ 
		// your code 
		if(root==null){
		    return true;
		}
		if(root.left==null && root.right==null){
		    return true;
		}
		else if(root.left==null && root.right==null){
		    return false;
		}
		
		if(CheckIfFoldable(root.left,root.right)==-1){
		    return false;
		}
		else{
		    return true;
		}
	} 
	
	private static int CheckIfFoldable(Node left,Node right){
	    if(left==null && right==null){
	        return 0;
	    }
	    else if(left==null || right==null){
	        return -1;
	    }
	    
	    int left_i=CheckIfFoldable(left.right,right.left);
	    if(left_i==-1){
	        return -1;
	    }
	    
	    int right_i=CheckIfFoldable(left.left,right.right);
	     if(right_i==-1){
	        return -1;
	    }
	    return Math.min(left_i,right_i);
	}

	   static boolean matched;
	 private static boolean isSubtree(Node T, Node S) {
	        // add code here.
	        if(S==null){
	            return true;
	        }
	        if(T==null && S!=null){
	            return false;
	        }
	        matched=false;
	       
	        return IsSubTreeOrNOT(T,S);
	    }
	   
	    private   static boolean IsSubTreeOrNOT(Node root,Node S){
	         // Use pre order traversal 
	         
	         
	         if(root==null){
	             return false;// Root ended .. no match .. so False 
	         }
	         if(root.data==S.data){
	         //   System.out.println(" S "+S.data+" Root "+root.data);
	            matched= IsSubTreeOrNOTCheckBoth(root,S);
	         // System.out.println(" Matched "+matched);
	            if (matched){
	                return matched;
	            }
	         }
	         
	         boolean anl=IsSubTreeOrNOT(root.left,S);
	         if(anl){
	             return true;
	         }
	         boolean anr=IsSubTreeOrNOT(root.right,S);
	         
	         if(anr){
	             return true;
	         }
	         return false;
	     }
	     
	     /*
	            10          10
	           4  6        4  6
	          N 30 2     N  30
	          o-0
	          10 4 6 N 30 2
	          10 4 6 N 30
	          
	          4 1 3 N 2 3 4 N 4 3 4 N 1
	          4 N N
	     
	         1
	         1 2 3 N N 4
	         3 4
	     
	     */
	     private static boolean IsSubTreeOrNOTCheckBoth(Node root,Node S){
	         if(root==null && S==null){
	             return true;
	         }
	         else if( S==null){
	             return false;
	         }
	         else if(root==null){
	             return false;
	         }
	         
	         
	         if(root.data!=S.data){
	          //  System.out.println("False S "+S.data+" Root "+root.data);
	             return false;
	         }
	       // System.out.println(" S "+S.data+" Root "+root.data);
	          boolean ans=IsSubTreeOrNOTCheckBoth(root.left,S.left);
	          if(!ans){
	              return false;
	          }
	          boolean anr=IsSubTreeOrNOTCheckBoth(root.right,S.right);
	           if(!anr){
	              return false;
	          }
	          
	         return true;
	     }
	
	private static ArrayList<Integer> ZigZagTraversal(Node root) {
		// Use two stack 
		Stack<Node> sn=new Stack<>();//Normal put right then left
		Stack<Node> sr=new Stack<>();//Reverse  left , then right
		ArrayList<Integer> ans=new ArrayList<>();
		if(root==null) {
			return ans;
		}
		
		boolean reverse=false;
		//int count=0;
		Node curr;
		
		//Adding root in normal and to make sure below works 
		sn.add(root);
		
	      // Till 1 is empty normal / reverse empty at each level
			while(!sn.isEmpty() || !sr.isEmpty()) {
				//System.out.println(" Curr rev"+reverse+" sr "+sr.toString()+" sn "+sn.toString());
				if(reverse) {
				while (!sr.isEmpty()) {
					curr=sr.pop();
					ans.add(curr.data);
					
					//Put right first
					if(curr.right!=null) {
						sn.add(curr.right);
					}
					//left next
					if(curr.left!=null) {
						sn.add(curr.left);
					}
					//To get correct order at popping 
				}
				reverse=false;
				}
				else {
				while (!sn.isEmpty()) {
					//reverse false 
					// pop from normal put in rev
					curr=sn.pop();
					ans.add(curr.data);
					
					if(curr.left!=null) {
						sr.add(curr.left);
					}
					if(curr.right!=null) {
						sr.add(curr.right);
					}
				
					//Put left then right , to get reverse 
			        		
				}
				reverse=true;
			}
		}
		
		return ans;
	}


	private static ArrayList<Integer> SpiralTraversal(Node root) {
		// Use queue  stack and variable reverse 
		ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> q=new ArrayDeque<>();
       if(root==null){
           return ans;
       }
       q.add(root);
       //Reverse storing 
       boolean reverse=false;
       Stack<Integer> srev=new Stack<>();
       
       Node curr;int count=0;
       while(!q.isEmpty()){
           count=q.size();
           for(int i=0;i<count;i++){
           curr=q.poll();
           //Reverse extra 
           if(reverse){
               srev.push(curr.data);
           }
           else{
           ans.add(curr.data);
           }    
       
           if(curr.left!=null){
              q.offer(curr.left);
           }
           if(curr.right!=null){
               q.offer(curr.right);
           }
         }
         
         //Reverse the stack and add 
         if(reverse){
             while(!srev.isEmpty()){
                 ans.add(srev.pop());
             }
             
             //For next line
             reverse=false;
         }
         else{
             //Already reverse false 
             reverse=true;
         }
         
      }
      return ans;
	}
	
	 static void TraverseLevelOrderQueueTwoLoops(Node root) {
			//best level order 
				if(root==null) {
					System.out.println(" Empty ");
					return ;
				}
				
			
				Queue<Node> q=new LinkedList<>();
				q.add(root);
				int count=0;Node curr;
				while(!q.isEmpty()) {
					
					count=q.size();
					
					System.out.println("count "+count);
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
						System.out.print(curr.data+" ");
					}
					System.out.println();
					
				}
		}
			 

}

/**
 * 
 * Tree Traversal in Spiral Form

Write a function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7. 
 

spiral_order

 


Method 1 (Recursive) 
To print the nodes in spiral order, nodes at different levels should be printed in alternating order. An additional Boolean variable ltr is used to change printing order of levels. If ltr is 1 then printGivenLevel() prints nodes from left to right else from right to left. Value of ltr is flipped in each iteration to change the order.
Function to print level order traversal of tree 

printSpiral(tree)
  bool ltr = 0;
  for d = 1 to height(tree)
     printGivenLevel(tree, d, ltr);
     ltr ~= ltr /*flip ltr*

Function to print all nodes at a given level 

printGivenLevel(tree, level, ltr)
if tree is NULL then return;
if level is 1, then
    print(tree->data);
else if level greater than 1, then
    if(ltr)
        printGivenLevel(tree->left, level-1, ltr);
        printGivenLevel(tree->right, level-1, ltr);
    else
        printGivenLevel(tree->right, level-1, ltr);
        printGivenLevel(tree->left, level-1, ltr);

Following is the implementation of above algorithm. 


// Java program for recursive level order traversal in spiral form

/* A binary tree node has data, pointer to left child 
   and a pointer to right child *
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Function to print the spiral traversal of tree
    void printSpiral(Node node)
    {
        int h = height(node);
        int i;

        /* ltr -> left to right. If this variable is set then the
           given label is traversed from left to right *
        boolean ltr = false;
        for (i = 1; i <= h; i++) {
            printGivenLevel(node, i, ltr);

            /*Revert ltr to traverse next level in opposite order*
            ltr = !ltr;
        }
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*
    int height(Node node)
    {
        if (node == null)
            return 0;
        else {

            /* compute the height of each subtree *
            int lheight = height(node.left);
            int rheight = height(node.right);

            /* use the larger one *
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    /* Print nodes at a given level *
    void printGivenLevel(Node node, int level, boolean ltr)
    {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.data + " ");
        else if (level > 1) {
            if (ltr != false) {
                printGivenLevel(node.left, level - 1, ltr);
                printGivenLevel(node.right, level - 1, ltr);
            }
            else {
                printGivenLevel(node.right, level - 1, ltr);
                printGivenLevel(node.left, level - 1, ltr);
            }
        }
    }
    /* Driver program to test the above functions *
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println("Spiral order traversal of Binary Tree is ");
        tree.printSpiral(tree.root);
    }
}

// This code has been contributed by Mayank Jaiswal(mayank_24)

Output
Spiral Order traversal of binary tree is 
1 2 3 4 5 6 7 

Time Complexity: O(n2). Worst case occurs in case of skewed trees.

Auxiliary Space: O(n) for call stack since using recursion

Method 2 (Iterative) 
We can print spiral order traversal in O(n) time and O(n) extra space. The idea is to use two stacks. We can use one stack for printing from left to right and other stack for printing from right to left. In every iteration, we have nodes of one level in one of the stacks. We print the nodes, and push nodes of next level in other stack. 


// Java implementation of an O(n) approach of level order
// traversal in spiral form

import java.util.*;

// A Binary Tree node
class Node {
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree {

    static Node root;

    void printSpiral(Node node)
    {
        if (node == null)
            return; // NULL check

        // Create two stacks to store alternate levels
        // For levels to be printed from right to left
        Stack<Node> s1 = new Stack<Node>(); 
        // For levels to be printed from left to right
        Stack<Node> s2 = new Stack<Node>(); 

        // Push first level to first stack 's1'
        s1.push(node);

        // Keep printing while any of the stacks has some nodes
        while (!s1.empty() || !s2.empty()) {
            // Print nodes of current level from s1 and push nodes of
            // next level to s2
            while (!s1.empty()) {
                Node temp = s1.peek();
                s1.pop();
                System.out.print(temp.data + " ");

                // Note that is right is pushed before left
                if (temp.right != null)
                    s2.push(temp.right);

                if (temp.left != null)
                    s2.push(temp.left);
            }

            // Print nodes of current level from s2 and push nodes of
            // next level to s1
            while (!s2.empty()) {
                Node temp = s2.peek();
                s2.pop();
                System.out.print(temp.data + " ");

                // Note that is left is pushed before right
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println("Spiral Order traversal of Binary Tree is ");
        tree.printSpiral(root);
    }
}

// This code has been contributed by Mayank Jaiswal(mayank_24)

Output
Spiral Order traversal of binary tree is 
1 2 3 4 5 6 7 
Time Complexity: O(n)

Auxiliary Space: O(n)

Method 3(Iterative, using Doubly Ended Queue)

The idea is to use a deque. While travelling left to right we can poll and print the elements from the front and insert their children(left child first followed by the right child) at the back. While travelling right to left we can poll and print the elements from the back and insert their children(right child first followed by the left child) at the front of the deque.

/*package whatever //do not write package name here *

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class GFG {
  
  //Defining Node class
  static class Node {

    int key;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
    }
}
  
  //Class to construct the tree
  static class MyTree {

    public MyTree(){};

    public Node root;

}
  
  //Function that prints the tree in spiral fashion
  public static void spiralPrint(Node root){

        //Declare a deque
        Deque<Node> dq = new ArrayDeque<>();
        
        //Insert the root of the tree into the deque
        dq.offer(root);
        
        //Create a  variable that will switch in each iteration
        boolean reverse = true;

        //Start iteration
        while (!dq.isEmpty()){
            
              //Save the size of the deque here itself, as in further steps the size
              //of deque will frequently change
            int n = dq.size();
            
              //If we are printing left to right
            if(!reverse){
              
              //Iterate from left to right
                for (int i =0; i < n; i++){
                        
                  //Insert the child from the back of the deque
                  //Left child first
                    if (dq.peekFirst().left  != null)
                        dq.offerLast(dq.peekFirst().left);
                  
                    if (dq.peekFirst().right != null)
                        dq.offerLast(dq.peekFirst().right);
                  
                  //Print the current processed element
                    System.out.print(dq.pollFirst().key + "  ");
                  
                  
                }
                //Switch reverse for next traversal
                reverse = !reverse;
              
            }else{

              //If we are printing right to left
              //Iterate the deque in reverse order and insert the children 
              //from the front
                while (n-- >0){
                    //Insert the child in the front of the deque
                    //Right child first
                    if (dq.peekLast().right != null)
                        dq.offerFirst(dq.peekLast().right);
                  
                    if (dq.peekLast().left != null)
                        dq.offerFirst(dq.peekLast().left);

                  //Print the current processed element
                    System.out.print(dq.pollLast().key + "  ");

                }
                //Switch reverse for next traversal
                reverse = !reverse;
                
            }
        }
    }
  
  
    public static void main (String[] args) {
        MyTree mt = new MyTree();
        mt.root = new Node(1);
        mt.root.left = new Node(2);
        mt.root.right = new Node(3);
        mt.root.left.left = new Node(7);
        mt.root.left.right = new Node(6);
        mt.root.right.left = new Node(5);
        mt.root.right.right = new Node(4);
        

      System.out.println("Spiral Order Traversal Of The Tree is :");
        spiralPrint(mt.root);
    }
}

//This code has been contributed by Abhishek Kumar Sah(kumarabhisheksah98)

Output
Spiral Order Traversal Of The Tree Is :
1  2  3  4  5  6  7  
Time Complexity: O(N)
Auxiliary Space: O(N)
 


 * 
 * 
 * 
 */
