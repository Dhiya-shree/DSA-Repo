package tree_Data_Structure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree Traversal 
 * Traversal to visit all nodes exactly once 
 *    1) Breadth first or Level Order
 *           Visit the root and print
 *           Print the left and right 
 *           Visit left --> left and right 
 *           Visit right --> left and right
 *    2) Depth Order 
 *         -->In order 
 *         -->Post order 
 *         -->Pre order 
 * 
 * 
 *   Depth first traversal :
 *     1) Print root 
 *     2) Process left sub tree as root - recursive
 *     3) Process right sub tree as root - recursive
 * 
 *   Breadth First or Level Order Traversal:
 *      1) Print root 
 *      2) Print left and right 
 *      3) Consider left and right as root1 androot2 
 *      4) Print all left and right in nxt level ...
 * 
 * 
 * Level order traversal :
 * Recursion wont work 
 * 
 * Method 1 :
 *   Find the height 
 *   For each height print the values 
 *   Time O N * H 
 * 
 * Method 2:
 *   Create a Queue 
 *   Push root in queue
 *   While q! empty :
 *      pop and print first 
 *      push it child 
 *      continue 
 * 
 * Size of queue depends on Maximum width of tree
 * 
 * 1)   30                30
 *      /                /  \
 *      20              20   10
 *      \              / \   / \
 *      10            1  2   3  4
 *      
 *  Size needed = 1  Size needed=4
 *  
 *  Time O N 
 *  Space O D - maximum depth
 *  
 *  Good method - Not able to print a line between level
 *  No track of level currently being processed
 *  
 *  
 * Method 3 :
 *   On traversing last node in a level of queue 
 *   The next level is completely there
 *   So keep track of last node of each level 
 *   By pushing null level 
 *  
 *   Create a Queue 
 *   Push root in queue
 *   While q! empty :
 *      if null :
 *         Print a line 
 *         Add a null in the queue
 *      else:
 *      pop and print first 
 *      push it child 
 *      continue
 *      
 *  Time O N
 *  Space Theta of Width
 *  Big O N or Theta of width
 *  Space = O N+1/2 ~ O N
 *  
 *  Perfect tree :
 *  All balanced nodes 
 *  If we have 31 nodes in a tree 
 *  Width of tree =  31+1 / 2= 6 
 *  Width = 6 
 *  
 *  Method 4:
 *  Using Two loops and a queue 
 *  After last node removal in a level,
 *  Queue has all the values of current level
 *  
 *  1) push root left and right in queue
 *  2) Print , left and right and push its child
 *  count 2
 *     1--> print left , push its child pop
 *       2--> print right, push its child pop
 *  count 4
 *  
 *  count 4
 *  3) Print 4 times , push all of its child ...
 *      1--> print child 1 , push its child
 *       2--> print child 2 , push its child
 *        3--> print child 3 , push its child
 *         4--> print child 4 , push its child
 *  count 8 
 *  
 *  and so on .......
 *  
 *  Time O N 
 *  Space O N spae 
 *  
 *  
 * @author shree
 *
 */
public class Tree03_Traversal_Level_order {

	public static void main(String[] args) {
		// Level order Traversal 
		
		//Find the height of tree
		// Print all nodes at every level 
		BTNode root = new BTNode(10);
		root.left = new BTNode(20);
		root.right = new BTNode(30);
		root.left.left = new BTNode(40);
		root.left.right = new BTNode(50);
		root.right.right = new BTNode(60);
		root.left.left.left = new BTNode(400);
		root.left.left.left.left = new BTNode(4000);
		
		
		// O N time -- with recursion - WRONG 
		TraverseAtAllLevel(root);
		
		
		// O N* H not good 
		//Find the height of tree
		// Print all nodes at every level 
		//Time O N + H 
		//Space O H + N
		  int h=HeightOfTreeGoG(root);
		    System.out.println(" Height gog "+h);
		    
		    // Print
		    
		 for(int i=0;i<h;i++) {
			 PrintNodeAtK(root,i);
			 System.out.println();
		 }
		 
		 
		 // O N + Space O N 
		 // Use queue push all the values 
		 // Dequeue root 
		 // Enqueue their child and so on 
		 
		 TraverseLevelOrderQueue(root);
		 System.out.println();
			// O N + Space O N
			// Use queue push all the values
			// Dequeue root
			// Enqueue their child and so on
            //++ have null to keep track 0f end
		 
		 
			 TraverseLevelOrderQueueNull(root);
			 System.out.println();
			 
			 
			 //
			 TraverseLevelOrderQueueTwoLoops(root);
			 
		}
		
	
	
	 
		 static void TraverseLevelOrderQueueTwoLoops(BTNode root) {
		//best level order 
			if(root==null) {
				System.out.println(" Empty ");
				return ;
			}
			
		
			Queue<BTNode> q=new LinkedList<>();
			q.add(root);
			int count=0;BTNode curr;
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
					System.out.print(curr.key+" ");
				}
				System.out.println();
				
			}
	}

		private static void TraverseLevelOrderQueueNull(BTNode root) {
		/// Use queue  + null
		//	Queue<BTNode> q=new ArrayDeque<>();
			Queue<BTNode> q=new LinkedList<>();
			//Bigger queue at the end before the last call
			//Queue Space == width of Binary tree 
			
			if(root==null) {
				System.out.println(" Empty ");
				return ;
			}
			
			//BTNode NULL=null;
			//Push root in 
			q.add(root);
			q.add(null);
			//Print root and push its child in queue
			BTNode curr;//Pointer to start 
			// If only null is there then break 
			while(!q.isEmpty() && q.size()>1) {
				
				curr=q.remove();
				
				if(curr==null ){
					System.out.println();
					q.add(null);
					continue;
					
				}
				
					System.out.print(curr.key+" ");
			   {// pushing curr children start
				if(curr.left!=null) {
					q.add(curr.left);
				}
				if(curr.right!=null) {
					q.add(curr.right);
				}
				}// pushing curr children end
				
				
				//Continue the process
				//Till no more chld to push and print all
				
			}
		
	}

		private static void TraverseLevelOrderQueue(BTNode root) {
		// Use queue 
		Queue<BTNode> q=new ArrayDeque<>();
		//Bigger queue at the end before the last call
		//Queue Space == width of Binary tree 
		
		if(root==null) {
			System.out.println(" Empty ");
			return ;
		}
		
		//Push root in 
		q.offer(root);
		
		//Print root and push its child in queue
		BTNode curr;//Pointer to start 
		while(!q.isEmpty()) {
			
			curr=q.poll();
			System.out.print(curr.key+" ");
			
			{// pushing curr children start
			if(curr.left!=null) {
				q.offer(curr.left);
			}
			if(curr.right!=null) {
				q.offer(curr.right);
			}
			}// pushing curr children end
			
			
			//Continue the process
			//Till no more chld to push and print all
			
		}
		
	}

		private static void TraverseAtAllLevel(BTNode root) {
		//Traverse at all level 
			if(root==null) {
				return;
			}
	//	System.out.print(root.key+" ");
		TraverseAtAllLevel(root.left,root.right);
		System.out.println();
		
	}

		private static void TraverseAtAllLevel(BTNode left, BTNode right) {
			// Traverse for left and right 
			if(left!=null) {
				System.out.print(left.key+" ");
				TraverseAtAllLevel(left);
				
			}
			if(right!=null) {
				System.out.println(right.key);
				TraverseAtAllLevel(right);
			}
			
		}

		private static int HeightOfTreeGoG(BTNode root) {
			//simple
			if(root==null) {
				return 0;
			}
			
			int h=Math.max(  HeightOfTreeGoG(root.left)
					, HeightOfTreeGoG(root.right));
			h=h+1;//For root
			return h;
		}
		
		private static void PrintNodeAtK(BTNode root,int k) {
			// K-0 root node , print all nodes at level K 
			
			if(k==0) {
				System.out.print(root.key+" ");
				return;
				
			}
		
			BTNode left=root.left;
			BTNode right=root.right;
			if(left!=null) {
				PrintNodeAtK(left,k-1);
			}
			if(right!=null) {
				PrintNodeAtK(right,k-1);
			}
			
		}

}


/**
 * 
 * Level Order Traversal of a Binary Tree

We have seen the three basic traversals(Preorder, postorder, and Inorder) of a Binary Tree. We can also traverse a Binary Tree using the Level Order Traversal.

In the Level Order Traversal, the binary tree is traversed level-wise starting from the first to last level sequentially.

Consider the below binary tree:


The Level Order Traversal of the above Binary Tree will be: 10 20 30 40 50 60 70 80.

Algorithm: The Level Order Traversal can be implemented efficiently using a Queue.
Create an empty queue q.
Push the root node of tree to q. That is, q.push(root).
Loop while the queue is not empty:
Pop the top node from queue and print the node.
Enqueue node's children (first left then right children) to q
Repeat the process until queue is not empty.


Implementation:

// Iterative Queue based Java program to do
// level order traversal of Binary Tree 

import java.util.Queue; 
import java.util.LinkedList; 

//* Class to represent Tree node *
class Node { 
    int data; 
    Node left, right; 

    public Node(int item) { 
        data = item; 
        left = null; 
        right = null; 
    } 
} 

//* Class to print Level Order Traversal *
class BinaryTree { 

    Node root; 

    //* Given a binary tree. Print its nodes in  
     //  level order using array for implementing queue *
    void printLevelOrder() 
    { 
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        while (!queue.isEmpty()) 
        { 
            Node tempNode = queue.poll(); 
            System.out.print(tempNode.data + " "); 

            //* Enqueue left child *
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
            } 

            //* Enqueue right child *
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
            } 
        } 
    } 

    // Driver Code
    public static void main(String args[]) 
    { 
        // Create the following Binary Tree
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        BinaryTree tree_level = new BinaryTree(); 
        tree_level.root = new Node(1); 
        tree_level.root.left = new Node(2); 
        tree_level.root.right = new Node(3); 
        tree_level.root.left.left = new Node(4); 
        tree_level.root.left.right = new Node(5); 

        System.out.println("Level order traversal " + 
                                "of binary tree is - "); 
        tree_level.printLevelOrder(); 
    } 
} 

Output:
1 2 3 4 5



Time Complexity: O(N), where N is the number of nodes in the Tree.
Auxiliary Space: O(N)

 * 
 * 
 * 
 */
