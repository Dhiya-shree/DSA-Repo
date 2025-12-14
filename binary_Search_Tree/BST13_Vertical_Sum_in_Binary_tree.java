package binary_Search_Tree;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * Vertical sum in binary tree:  ...................HARD 
 * 
 * Nodes with same vertical distance is 
 * 
 * Nodes that are at same distance from left most node
 * 
 * 
 * To find horizontal distance 
 * 
 * Take root distance as 0 .
 * left child = root distance -1 
 * right child= root distance +1 
 * 
 *          55(0)
 *         /   \
 *   (-1)30     70(+1)
 *     /   \   /  \
 *    10   40 50  80(+2) 
 *  (-2)  (0) (0)  \   
 *                  90 
 *                  (+3)
 *    
 * Use any treaversal and put distance 
 * Sum all nodes with common distance 
 * 
 * As negative numversa are also involved can not use array / arrayList 
 * 
 * Use hashmap to store nodes value in same distance 
 * With distance as key 
 * 
 * 
 * No yu foool
 * 
 * Never use unordered Hashmap in Java
 * Use treeMap it keeps everything sorted
 * Tree map is self balancing tree 
 * 
 * So while converting from ashmap -> array no need for extra space / sorting 
 * 
 * Simply iterate and store 
 * 
 * 
 * 
 * @author shree
 *
 */
public class BST13_Vertical_Sum_in_Binary_tree {

	public static void main(String[] args) {
		// vertical ? Horizontal distaces from leftmost nodes 
		
		int arr[]= {5,3,4,8,9,6,7,1,2,0,10};
		BSTNode root=BST02_operation_medium.ConstructBST(arr);
		System.out.println(" BST ");
		BST02_operation_medium.ViewBST(root);

		tMap=new TreeMap<>();
		
		//Fill va in map 
		VerticalSumBST(root,0);
		

		//Traverse map  won't work
	//	Iterator itr= new Iterator();
		// can not iterate - because not a collection 
		
		Set<Entry<Integer, Integer>> mp=tMap.entrySet();
		
		for( Map.Entry<Integer,Integer> m: mp) {
			System.out.println(m.getKey()+"-"+m.getValue());
		}
		
	}
    
	private static void VerticalSumBST(BSTNode root, int distance) {
		// change the diatance and traverse 
		if(root==null) {
			return ;
		}
		
		System.out.println(" Distance ..."+root.data+"..... "+distance);
		if(tMap.containsKey(distance)) {
			int val=tMap.get(distance);
			tMap.put(distance, val+root.data);
		}
		else {
			tMap.put(distance, root.data);
		}
		
		//left - diatnace- 1
		VerticalSumBST(root.left,distance-1);
		
		//right - distance +1 
		VerticalSumBST(root.right,distance+1);
		
	}

	static TreeMap<Integer,Integer> tMap;
}


/**
 * 
 * Vertical Sum in a Binary Tree

Given a Binary Tree, find the vertical sum of the nodes that are in the same vertical line. Print all sums through different vertical lines.
Examples: 
 

      1
    /   \
  2      3
 / \    / \
4   5  6   7

The tree has 5 vertical lines
Vertical-Line-1 has only one node 4 => vertical sum is 4 
Vertical-Line-2: has only one node 2=> vertical sum is 2 
Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12 
Vertical-Line-4: has only one node 3 => vertical sum is 3 
Vertical-Line-5: has only one node 7 => vertical sum is 7
So expected output is 4, 2, 12, 3 and 7 

We need to check the Horizontal Distances from the root for all nodes. If two nodes have the same Horizontal Distance (HD), then they are on the same vertical line. The idea of HD is simple. HD for root is 0, a right edge (edge connecting to right subtree) is considered as +1 horizontal distance and a left edge is considered as -1 horizontal distance. For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0 and HD for node 7 is +2. 
We can do an in-order traversal of the given Binary Tree. While traversing the tree, we can recursively calculate HDs. We initially pass the horizontal distance as 0 for root. For left subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1. For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1.
Following is Java implementation for the same. HashMap is used to store the vertical sums for different horizontal distances. Thanks to Nages for suggesting this method. 
 


import java.util.TreeMap;
 
// Class for a tree node
class TreeNode {
 
    // data members
    private int key;
    private TreeNode left;
    private TreeNode right;
 
    // Accessor methods
    public int key()        { return key; }
    public TreeNode left()  { return left; }
    public TreeNode right() { return right; }
 
    // Constructor
    public TreeNode(int key)
   { this.key = key; left = null; right = null; }
 
    // Methods to set left and right subtrees
    public void setLeft(TreeNode left)   { this.left = left; }
    public void setRight(TreeNode right) { this.right = right; }
}
 
// Class for a Binary Tree
class Tree {
 
    private TreeNode root;
 
    // Constructors
    public Tree() { root = null; }
    public Tree(TreeNode n) { root = n; }
 
    // Method to be called by the consumer classes 
    // like Main class
    public void VerticalSumMain() { VerticalSum(root); }
 
    // A wrapper over VerticalSumUtil()
    private void VerticalSum(TreeNode root) {
 
        // base case
        if (root == null) { return; }
 
        // Creates an empty TreeMap hM
        TreeMap<Integer, Integer> hM =
                   new TreeMap<Integer, Integer>();
 
        // Calls the VerticalSumUtil() to store the 
        // vertical sum values in hM
        VerticalSumUtil(root, 0, hM);
 
        // Prints the values stored by VerticalSumUtil()
        if (hM != null) {
            System.out.println(hM.entrySet());
        }
    }
 
    // Traverses the tree in in-order form and builds
    // a hashMap hM that contains the vertical sum
    private void VerticalSumUtil(TreeNode root, int hD,
                         TreeMap<Integer, Integer> hM) {
 
        // base case
        if (root == null) {  return; }
 
        // Store the values in hM for left subtree
        VerticalSumUtil(root.left(), hD - 1, hM);
 
        // Update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.key());
 
        // Store the values in hM for right subtree
        VerticalSumUtil(root.right(), hD + 1, hM);
    }
}
 
// Driver class to test the verticalSum methods
public class Main {
 
    public static void main(String[] args) {
        /* Create the following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7
 
        *
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.left().setLeft(new TreeNode(4));
        root.left().setRight(new TreeNode(5));
        root.right().setLeft(new TreeNode(6));
        root.right().setRight(new TreeNode(7));
        Tree t = new Tree(root);
 
        System.out.println("Following are the values of" + 
                           " vertical sums with the positions" +
                        " of the columns with respect to root ");
        t.VerticalSumMain();
    }
}



Output
Following are the values of vertical sums with the positions of the columns with respect to root
-2: 4
-1: 2
0: 12
1: 11
2: 7
3: 9

 


 * 
 * 
 */
