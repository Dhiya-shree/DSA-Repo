package binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 *   Top View of Tree :
 *   
 *   Method 1: FAIL for 1 N 2
 *   For intermediatory will fail 
 *          x
 *        x   x
 *      x  x x  x
 *        x x x   
 *      x   x   x
 *    x   x   x   x
 *    
 *    Above even when the nodes are less than top of prev - itwill be considered as top 
 *   Do level order travsersal 
 *   Tak first and last entry of every level 
 *   Put it in map 
 *   
 *   Method 2: Use vertical distance 
 *   Do vertical traversal 
 *   With level order --> ANY other traversal FAIL 
 *   
 *   Save the first value root ...
 *   
 *   
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class BST15_Top_View_BST {

	public static void main(String[] args) {
		
		int arr[]= {5,3,4,8,9,6,7,1,2,0,10};
		BSTNode root=BST02_operation_medium.ConstructBST(arr);
		System.out.println(" BST ");
		BST02_operation_medium.ViewBST(root);
		//Level order + Vertical traversal 
	    inBtw=new ArrayList<>();
	    TMap=new TreeMap<>();
	    TopView_LevelOrderVerticalTraversal(root,0);
	    inBtw=new ArrayList<>();
	    Set<Integer> setu=TMap.keySet();
	    inBtw=new ArrayList<>();
	    for(Integer x:setu) {
	    	inBtw.add(TMap.get(x));
	    }
	
	    System.out.println(" Final array ");
	    System.out.println(inBtw.toString());
	    
	}

	private static void TopView_LevelOrderVerticalTraversal(BSTNode root, int distance) {
		// level order traversal 
		
		Queue<WrapNodeDistance> q=new ArrayDeque<>();
		q.offer(new WrapNodeDistance(root,distance));
		int count=0;
		BSTNode curr=null;
		int d=0;
		while(!q.isEmpty()) {
			count=q.size();
			for(int i=0;i<count;i++) {
				curr=q.peek().root;
				d=q.poll().distance;
				// Add the node only if not present previously 
				if(!TMap.isEmpty() && TMap.containsKey(d)) {
					//Already present dont look 
				}
				else {
					//Not present fist encouter in vertical 
					TMap.put(d,curr.data);
				}
				
				if(curr.left!=null) {
					q.offer(new WrapNodeDistance(curr.left, d-1));
				}
				if(curr.right!=null) {
					q.offer(new WrapNodeDistance(curr.right, d+1));
				}
			}
			
		}
		
	}

	static ArrayList<Integer> inBtw;
	static TreeMap<Integer,Integer> TMap;
}


/*

Top View of Binary Tree

The idea is to do something similar to vertical Order Traversal. Like vertical Order Traversal, we need to put nodes of same horizontal distance together. We do a level order traversal so that the topmost node at a horizontal node is visited before any other node of same horizontal distance below it. Hashing is used to check if a node at given horizontal distance is seen or not. 

// Java program to print top
// view of binary tree
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

// class to create a node
class Node {
    int data;
    Node left, right;

    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

// class of binary tree
class BinaryTree {
    Node root;

    public BinaryTree() { root = null; }

    // function should print the topView of
    // the binary tree
    private void TopView(Node root)
    {
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, Node> topViewMap
            = new TreeMap<Integer, Node>();

        if (root == null) {
            return;
        }
        else {
            q.add(new QueueObj(root, 0));
        }

        System.out.println(
            "The top view of the tree is : ");

        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left,
                                   tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right,
                                   tmpNode.hd + 1));
            }
        }
        for (Map.Entry<Integer, Node> entry :
             topViewMap.entrySet()) {
            System.out.print(entry.getValue().data);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args)
    {
       /* Create following Binary Tree
            1
           / \
          2   3
          \
            4
             \
              5
               \
                6
        *
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println(
            "Following are nodes in top view of Binary Tree");
        tree.TopView(tree.root);
    }
}

 


Output
Following are nodes in top view of Binary Tree
The top view of the tree is : 
2 1 3 6 



*/