package binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * Bottom view of tree 
 * 
 *  Level order only will fail !!!!
 *  
 *  Use vertical traversal+level order 
 *  
 *  For every root , distance d 
 *  root.left - d-1
 *  root.right - d+1
 *  
 *  HashMap distance , data 
 *  Save the last instance of a particular distance in hashMap 
 * 
 * 
 * @author shree
 *
 */
public class BST16_Bottom_View_BST {

	public static void main(String[] args) {
		
		int arr[]= {5,3,4,8,9,6,7,1,2,0,10};
		BSTNode root=BST02_operation_medium.ConstructBST(arr);
		System.out.println(" BST ");
		BST02_operation_medium.ViewBST(root);
		//Level order + Vertical traversal 
	    inBtw=new ArrayList<>();
	    TMap=new TreeMap<>();
	   Bottom_View_LevelOrderVerticalTraversal(root,0);
	    inBtw=new ArrayList<>();
	    Set<Integer> setu=TMap.keySet();
	    inBtw=new ArrayList<>();
	    for(Integer x:setu) {
	    	inBtw.add(TMap.get(x));
	    }
	
	    System.out.println(" Final array ");
	    System.out.println(inBtw.toString());
	    
	}

	private static void Bottom_View_LevelOrderVerticalTraversal(BSTNode root, int distance) {
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
				// Always add element 
				//if(!TMap.isEmpty() && TMap.containsKey(d)) {
					//Already present dont look 
				//}
			   // else {
					//Always add element 
					TMap.put(d,curr.data);
				//}
				
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


/**
 * 
 * Finding LCA in Binary Search Tree

We have already seen the definition of LCA and finding LCA of any two nodes in a Binary Tree in the previous post.

Let's look at the process of finding LCA in a Binary Search Tree.

Problem: Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA). For Simplicity, you may assume that both the values exist in the tree.

Consider the below BST:
BST_LCA
In the above BST:
LCA of 10 and 14 is 12
LCA of 14 and 8 is 8
LCA of 10 and 22 is 20




The LCA or Lowest Common Ancestor of any two nodes N1 and N2 is defined as the common ancestor of both the nodes which is closest to them. That is the distance of the common ancestor from the nodes N1 and N2 should be least possible.


Finding LCA

Since Binary Search Tree is also a Binary Tree, we can apply the same process of finding LCA of two nodes in BST as that of binary trees. But finding LCA in a Binary Tree takes O(N) time complexity.

However, we can solve this problem using BST properties. We can recursively traverse the BST from root. The main idea of the solution is, while traversing from top to bottom, the first node n we encounter with value between n1 and n2, i.e., n1 <= n <= n2, is LCA of n1 and n2 (assuming that n1 < n2). So just recursively traverse the BST, if node's value is greater than both n1 and n2 then our LCA lies in the left subtree of the node, if it's is smaller than both n1 and n2, then LCA lies on the right subtree. Otherwise root is LCA (assuming that both n1 and n2 are present in BST).

Below is the implementation of this approach:

// Recursive Java program to print lca of two nodes

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

class BinaryTree 
{
    Node root;
    
    /* Function to find LCA of n1 and n2. 
       The function assumes that both
       n1 and n2 are present in BST *
    Node lca(Node node, int n1, int n2) 
    {
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, 
        // then LCA lies in left subtree
        if (node.data > n1 && node.data > n2)
            return lca(node.left, n1, n2);

        // If both n1 and n2 are greater than root,
        // then LCA lies in right subtree
        if (node.data < n1 && node.data < n2) 
            return lca(node.right, n1, n2);

        return node;
    }

    // Driver Code
    public static void main(String args[]) 
    {
        // Let us construct the BST shown
        // in the above figure
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " 
                               + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " 
                                + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " 
                                + n2 + " is " + t.data);

    }
}


Output:
LCA of 10 and 14 is 12
LCA of 14 and 8 is 8
LCA of 10 and 22 is 20



The time complexity of the above solution is O(h) where h is the height of the tree. Also, the above solution requires O(h) extra space in function call stack for recursive function calls. We can avoid extra space using iterative solution.

/* Function to find LCA of n1 and n2. 
   The function assumes that both
   n1 and n2 are present in BST *
struct node *lca(struct node* root, int n1, int n2)
{
    while (root != NULL)
    {
        // If both n1 and n2 are smaller than root, 
        // then LCA lies in left subtree
        if (root->data > n1 && root->data > n2)
           root = root->left;

        // If both n1 and n2 are greater than root, 
        // then LCA lies in the right subtree
        else if (root->data < n1 && root->data < n2)
           root = root->right;

        else break;
    }

    return root;
}
 * 
 * 
 * 
 */
