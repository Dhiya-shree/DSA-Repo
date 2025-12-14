package tree_Data_Structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * Problem #1 :  Print left view of Binary tree 
 *  
 *  Iterative Solution:
 *   Using Two loops and a queue 
 *  After last node removal in a level,
 *  Queue has all the values of current level
 *  
 *  1) push root left and right in queue
 *  if left is null ----> Consider right
 *  2) Print , left and right and push its child
 *  count 2
 *     1--> print left , push its child pop
 *        if no left child present -> consider right's left 
 *       2--> remove right, push its child pop
 *        if no left child present -> consider right's right 
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
 *  Recursive :
 *  Use Depth - Pre Order Traversal
 *  Left Right Root .. no care about root so taking pre order one  
 *  
 *  use a variable 
 *  Level- current level 
 *  MaxLevel - Max level of left val seen  
 *  
 *  Time O N 
 *  Space O N , theta H 
 * 
 * 
 * Problem # 2:  Print Right view of the tree
 * 
 * Problem # 3:  Print Top view of the tree
 * 
 * Problem # 4:  Print Bottom view of the tree
 * 
 *Example : 
 *           10
 *           /\
 *         20  30
 *        / \    \
 *      40   50   60
 *          / \
 *         70  80
 *         
 * Left view : 10 20 40 70 
 * Right view: 10 30 60 80 
 * Top view  : 40 20 10 30 60 
 * Bottom view : 40 20 70 50 80 30 60 
 * 
 *  
 * Level order -------Iterative method 
 * Ans :
 *   L1: 10
 *   L2: 20 30  
 *   L3: 40 50 60 
 *   L4: 70 80
 * 
 * Left view :
 *   First value in each level 
 * 
 * Right view :
 *   Last value in each level 
 *   
 * Top view :
 *   Fist and last value in each level
 *   Method1: Hashing 
 *   Consider root as 0 -->store (root ,0)
 *   Level 1 --> first val -1 last value +1 -->store  (first val,-1),(last,+1)
 *   Level 2 --> first val -2 last value +2 -->store  (first val,-2),(last,+2)
 *   Level 3 --> first val -3 last value +3 -->store  (first val,-3),(last,+3)
 *   Traverse in HashMap from -3 to +3 
 *   Store the values  
 *  
 *   Method 2: Dequeue
 *   Create a deque 
 *   Put the root in deque\
 *   In each level 
 *   First value -->offer first
 *   Last value -->offer last  
 * 
 * Bottom view :
 * ??????????????????????????????????????????????????????????????????????????????
 * Bottom View: The Bottom View of a binary tree can be printed using the similar approach as that of printing the Top View. 
 * A node x is there in output if x is the bottom most instead of the top most node at its horizontal distance. 
 * The process of printing the bottom view is almost the same as that of top view with a little modification
 * that while storing the node's data along with a particular horizontal distance in the map,
 * keep updating the node's data in the map for a particular horizontal distance so 
 * that the map contains the last node appearing with a particular horizontal distance instead of first.
 * 
 * 
 * Recursive :----
 * Inorder 
 * Preorder 
 * PostOrder 
 * 
 * 
 * Bottom view:?????????????
 * Use inorder traversal
 * left root right  of last two level 
 * 
 * Top view :
 *  
 *
 * 
 * Left view :
 * Traverse left side  and add
 * if left side is null:
 *    Take right into consideration 
 * 
 * Right view :
 * Traverse right side 
 * If right=null
 *    Consider left side 
 * 
 * 
 * 
 * Problem #5 : Mirror TRee view
 * Given a Binary Tree, convert it into its mirror.
MirrorTree1            

Example 1:

Input:
      1
    /  \
   2    3
Output: 3 1 2
Explanation: The tree is
   1    (mirror)  1
 /  \    =>      /  \
2    3          3    2
The inorder of mirror is 3 1 2
Example 2:

Input:
      10
     /  \
    20   30
   /  \
  40  60
Output: 30 10 60 20 40
Explanation: The tree is
      10               10
    /    \  (mirror) /    \
   20    30    =>   30    20
  /  \                   /   \
 40  60                 60   40
The inroder traversal of mirror is
30 10 60 20 40.
Your Task:
Just complete the function mirror() that takes node as paramter  and convert it into its mirror. The printing is done by the driver code only.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 105


 * 
 * 
 * @author shree
 *
 */
public class Tree05_sums_View_of_Tree {

	public static void main(String[] args) {
		// Tree sums easy
		
		BTNode root = new BTNode(10);
		root.left = new BTNode(20);
		root.right = new BTNode(30);
		root.left.left = new BTNode(40);
		//root.left.left.left = new BTNode(100);
		root.left.right = new BTNode(50);
		root.left.right.left = new BTNode(70);
		root.left.right.right = new BTNode(80); ///
		root.right.right = new BTNode(60);
		//root.right.left = new BTNode(22);

	//	root.right.right.right = new BTNode(6000);
		// root.right.right.right.left = new BTNode(60);
				
		Tree03_Traversal_Level_order.TraverseLevelOrderQueueTwoLoops(root);
		
		PrintLeftViewOfBinaryTree(root);
		
		PrintLeftViewOfBinaryTreeGoG(root);
		
		PrintLeftViewOfBinaryTreeRecursive(root,0);
		
		System.out.println(" Right   ......");
		PrintRightViewOfBinaryTreeRecursive(root,0);
		
		
		System.out.println(" Top   ......");
		PrintTopViewOfBinaryTreeRecursive(root,0,root);
		
		BTNode root2 = new BTNode(10);
		root2.left = new BTNode(20);
		root2.right = new BTNode(30);
		System.out.println(" Top   ......");
		// Top view not working 
		PrintTopViewOfBinaryTreeRecursive(root2,0,root2);
		
		///////////////////////////////////////////////MIRROR ...........................................\
		
		System.out.println(" Tree :");
		Tree03_Traversal_Level_order.TraverseLevelOrderQueueTwoLoops(root);
		mirror(root);
		System.out.println(" Mirror Tree :");
		Tree03_Traversal_Level_order.TraverseLevelOrderQueueTwoLoops(root);
	}
	
	 static BTNode left;static BTNode rightSwap;
	 private static  void mirror(BTNode root) {
	        // Your code here
	        if(root==null){
	            return ;
	        }
	        
	        mirror(root.left);
	        mirror(root.right);
	        left=root.left;
	        
	        rightSwap=root.right;
	        root.left=rightSwap;
	        root.right=left;
	        
	    }
	
	
	static int toplevel=0;static boolean right=false;
	private static void PrintTopViewOfBinaryTreeRecursive(BTNode root, int level,BTNode root2) {
		// printing if level> maxlevel 
		// And update maxlevel as level - currently seen 
		
		if(root==null) {
			return;
		}
		
		if(!right) {
			
		if(toplevel<level) {
			System.out.print(root.key+" ");
			toplevel=level;//Update max level
			// So in level 1 seen 
		}
		
		
		//Print all left side 
		//System.out.println(" left ");
		PrintTopViewOfBinaryTreeRecursive(root.left,level+1,root2);
		
		if(root==root2 ) {
			right=true;	
			toplevel=0;
			level=0;
			System.out.print(" ..0-"+root.key+" ");
			PrintTopViewOfBinaryTreeRecursive(root.right, level+1,root2);
			}
		
		}
		else {
			//System.out.println(" Right "+level+" top "+ toplevel );
			if(toplevel<level) {
				System.out.print(root.key+" ");
				toplevel=level;//Update max level
				// So in level 1 seen 
			}
			
			PrintTopViewOfBinaryTreeRecursive(root.right, level+1,root2);
		
		
		}
		
		
	}
	
	static int rightLevel=-1;
	private static void PrintRightViewOfBinaryTreeRecursive(BTNode root, int level) {
		// printing if level> maxlevel 
		// And update maxlevel as level - currently seen 
		
		if(root==null) {
			return;
		}
		
		if(rightLevel<level) {
			System.out.println(level+"... "+root.key+" ");
			rightLevel=level;//Update max level
			// So in level 1 seen 
		}
		
		PrintRightViewOfBinaryTreeRecursive(root.right, level+1);
		
		PrintRightViewOfBinaryTreeRecursive(root.left,level+1);
		
		
		
	}
	
	static int maxLevel=-1;
	private static void PrintLeftViewOfBinaryTreeRecursive(BTNode root, int level) {
		// printing if level> maxlevel 
		// And update maxlevel as level - currently seen 
		
		if(root==null) {
			return;
		}
		
		if(maxLevel<level) {
			System.out.println(level+"... "+root.key+" ");
			maxLevel=level;//Update max level
			// So in level 1 seen 
		}
		
		PrintLeftViewOfBinaryTreeRecursive(root.left,level+1);
		
		PrintLeftViewOfBinaryTreeRecursive(root.right, level+1);
		
	}

	private static void PrintLeftViewOfBinaryTreeGoG(BTNode root) {
		// For left most print while i=0
		//For right most print if i=count-1
			if(root==null) {
				System.out.println(" Empty ");
				return ;
			}
			
		
			Queue<BTNode> q=new LinkedList<>();
			q.add(root);
			int count=0;BTNode curr;
			while(!q.isEmpty()) {
				
				count=q.size();
				
			//	System.out.println("count "+count);
				// For left most print while i=0
				for(int i=0;i<count;i++) {
					curr=q.poll();
					if(i==0) {
						System.out.println(curr.key+" ");
					}
					if(curr.left!=null) {
						q.offer(curr.left);
					}
					if(curr.right!=null) {
						q.offer(curr.right);
					}
				//	System.out.print(curr.key+" ");
				}
				
				
			}
	}
	private static void PrintLeftViewOfBinaryTree(BTNode root) {
		if(root==null) {
			System.out.println(" Empty ");
			return ;
		}
		
	
		Queue<BTNode> q=new LinkedList<>();
		q.add(root);
		System.out.print(root.key+" ");
		int count=0;BTNode curr;
		boolean leftviewed=false;
		while(!q.isEmpty()) {
			
			count=q.size();
			
			System.out.println("count "+count);
		    leftviewed=false;
			for(int i=0;i<count;i++) {
				curr=q.remove();
				if(curr.left!=null && !leftviewed) {
					q.offer(curr.left);
					System.out.print(curr.left.key);
					leftviewed=true;
				}
				else if(curr.right!=null && !leftviewed) {
					System.out.print(curr.right.key);
					q.offer(curr.right);
					leftviewed=true;
				}
				if(curr.left!=null) {
					q.offer(curr.left);
				}
				if(curr.right!=null) {
					q.offer(curr.right);
				}
			
			}
			
			
		}
		
	}


}





