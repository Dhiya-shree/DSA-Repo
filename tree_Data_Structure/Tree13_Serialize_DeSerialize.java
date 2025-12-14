package tree_Data_Structure;

import java.util.ArrayList;

/**
 * Serialize & Deserialize 
 *  Transmitting Tree structure -> needs serialize 
 *   Tree across the network 
 *   
 *  Used for setting binary problem test case 
 *
 * Serialize 
 * 
 *     10
 *   20  30
 *  40  50 60 
 *  
 *  Output : 10 20 40 N N 30 50 N N 60 N N
 *  
 * Deserialize
 * Input : 10 20 40 N N 30 50 N N 60 N N
 * Output
 *     10
 *   20  30
 *  40  50 60 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Tree13_Serialize_DeSerialize {

	public static void main(String[] args) {
		//serialize and deserialize 
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
		
       ArrayList<Integer> arr=new ArrayList<>();
//		arr.add(100);
//		arr.add(40);
//		arr.add(50);
//		arr.add(-1);
//		arr.add(-1);
//		arr.add(60);
//		arr.add(-1);
//		arr.add(-1);
//		arr.add(-1);
//		
		inorder(root);
		System.out.println();
       Serialize(root,arr);
       Node ans=deSerialize(arr);
       System.out.println(" Array "+arr);
       inorder(ans);
       
       System.out.println();
       SerializeGoG(root,arr);
        ans=deSerializeGoG(arr);
       System.out.println(" Array "+arr);
      // inorder(ans);
       
	}
	static final int EMPTY=-1;
    private static void Serialize(Node root, ArrayList<Integer> arr){
       if(root==null){
           arr.add(EMPTY);
           return;
       }
        arr.add(root.data);
        Serialize(root.left,arr);
        Serialize(root.right,arr);
   //     System.out.println(arr.toString());
    }  

    static int index=0;
    public static Node deSerialize(ArrayList<Integer> arr){
        if(index==arr.size())
            return null;
        int val=arr.get(index);
        index++;
        if(val==EMPTY)return null;
        Node root=new Node(val);
        root.left=deSerialize(arr);
        root.right=deSerialize(arr);
        return root;
    }
    
    private static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);    
        }
    }
    private static  void SerializeGoG(Node root, ArrayList<Integer> A) 
	{
	  //  System.out.println(A.toString());
	    if(root==null){
	   //    A.add(-1);
	     // ;
	    }
	    else{
	    // Change to in order root - left - right 
	    	SerializeGoG(root.left,A);
	    A.add(root.data);
	   
	    
	    SerializeGoG(root.right,A);
	    
	    }
	    
	}
	private static Node DeSerialize(ArrayList<Integer> A){
	      
	      if(count>N){
	          return null;
	      }
	       if(A.get(count)==-1){
	        return null;
	    }
	    Node root=new Node(A.get(count));
	    count=count+1;
	     root.right=DeSerialize(A);
	   // System.out.println(count+".."+root.data);
	      root.left=DeSerialize(A);
	      count=count+1;
	    
	  
	   
	    return root;
	}
	static int count;static int N;
	//Function to deserialize a list and construct the tree.
	 private static  Node deSerializeGoG(ArrayList<Integer> A)
    {
      //  System.out.println("s...."+A.toString());
        if(A.size()==0){
            return null;
        }
        else if (A.size()==1){
            return (new Node(A.get(0)));
        }
        //code here
       count=0;N=A.size()-1;
        Node root=(DeSerialize(A));
     //   print(root);
        return root;
    }
    
    public void print(Node root){
        if(root==null){
          //  System.out.print("...");
            
        }
        else{
            print(root.left);
           //  System.out.print(root.data+" ");
              print(root.right);
        }
        
    }
}

/**
Serialize and Deserialize a Binary Tree

Serialization is to store the tree in a file so that it can be later restored. The structure of the tree must be maintained. Deserialization is reading the tree back from a file.

serialize-sdeserialize-binary-tree

How to store a general Binary Tree?
A simple solution is to store both Inorder and Preorder traversals. 

This solution requires space twice the size of the Binary Tree. We can save space by storing Preorder traversal and a marker for NULL pointers. 

Store all possible child nodes for each node.
If there is no child node then push -1 for that child.
Put this preorder traversal in the file.
Examples:

Input:
     12
    /
13
Output: 12 13 -1 -1 -1

Input:
      20
    /   \
8     22 
Output: 20 8 -1 -1 22 -1 -1 

Input:
         20
       /    
     8     
   /  \
4   12 
    /   \
10  14
Output: 20 8 4 -1 -1 12 10 -1 -1 14 -1 -1 -1 

Input:
            20
           /    
         8     
       /
   10
  /
5
Output: 20 8 10 5 -1 -1 -1 -1 -1 

Input:
          20
            \
             8
              \   
               10
                 \
                  5   

Output: 20 -1 8 -1 10 -1 5 -1 -1

How to deserialize the above serialization?
Deserialization can be done by simply reading data from the file one by one and keep on adding children till a -1 is reached. If both the children are NULL then return back to the parent.

Below is the implementation of the above idea:

// A Java program to demonstrate serialization and
// deserialization of Binary Tree

import java.util.*;

// A binary tree Node has key,
// pointer to left and right children
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class BinaryTree {
	TreeNode root;

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root)
	{
		if (root == null) {
			return null;
		}
		Stack<TreeNode> s = new Stack<>();
		s.push(root);

		List<String> l = new ArrayList<>();
		while (!s.isEmpty()) {
			TreeNode t = s.pop();

			// If current node is NULL, store marker
			if (t == null) {
				l.add("#");
			}
			else {

				// Else, store current node
				// and recur for its children
				l.add("" + t.val);
				s.push(t.right);
				s.push(t.left);
			}
		}
		return String.join(",", l);
	}

	static int t;

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data)
	{
		if (data == null)
			return null;
		t = 0;
		String[] arr = data.split(",");
		return helper(arr);
	}

	public static TreeNode helper(String[] arr)
	{
		if (arr[t].equals("#"))
			return null;

		// Create node with this item
		// and recur for children
		TreeNode root
			= new TreeNode(Integer.parseInt(arr[t]));
		t++;
		root.left = helper(arr);
		t++;
		root.right = helper(arr);
		return root;
	}

	// A simple inorder traversal used
	// for testing the constructed tree
	static void inorder(TreeNode root)
	{
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

	// Driver code
	public static void main(String args[])
	{
		// Construct a tree shown in the above figure
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(20);
		tree.root.left = new TreeNode(8);
		tree.root.right = new TreeNode(22);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(12);
		tree.root.left.right.left = new TreeNode(10);
		tree.root.left.right.right = new TreeNode(14);

		String serialized = serialize(tree.root);
		System.out.println("Serialized view of the tree:");
		System.out.println(serialized);
		System.out.println();

		// Deserialize the stored tree into root1
		TreeNode t = deserialize(serialized);

		System.out.println(
			"Inorder Traversal of the tree constructed"
			+ " from serialized String:");
		inorder(t);
	}
}


*/