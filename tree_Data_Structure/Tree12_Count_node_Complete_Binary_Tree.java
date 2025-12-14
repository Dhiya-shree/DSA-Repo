package tree_Data_Structure;

/**
 * Complete Binary TRee 
 * 
 *  
 *  Completely filled except last level 
 *  Last level needs to be filled left to right 
 *   
 * 
 * In a completely filled binary tree 
 * With all left and right 
 * 
 * No of nodes = 2^ no of level - 1
 * 
 * From ROOT 
 * Go left -- find length 
 * Go right -- find length 
 * if left==right 
 *   it is PERFECT BINARY TREE 
 *   
 *   nodes = 2^ left -1 nodes 
 *   
 * Best case : completely perfect tree 
 * left - O H level in left 
 * Right - O H  
 * Net : 2 O H 
 * Level H: log2(N+1)
 * 
 * Worst :
 * For left/Right branch it might be recurrent 
 * O H * O H
 * 
 * 
 * Once through length recurrent mighr be needed recurrence 
 * N/3 nodes can be skipped , other 2/3 nodes might have  
 * T (n2/3) + O H 
 *
 *
 * @author shree
 *
 */
public class Tree12_Count_node_Complete_Binary_Tree {

	public static void main(String[] args) {
		//count nodes in complete binary tree 
		
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
		

		int ans=CountNaiveTree(root);
		System.out.println(" Count f nodes "+ans);
	    //count=0;
		ans=CountEfficientTree(root);
		System.out.println(" Count f nodes "+ans);
	
		ans=CountEfficientTreeGoG(root);
		System.out.println(" Count f nodes "+ans);
	
	
	}

	private static int CountEfficientTreeGoG(Node root) {
		// gog check if perfect tree
		if(root==null) {
			return 0;
		}
		int left=0;
		int right=0;
		Node curr=root;
		while(curr!=null) {
			left++;
			curr=curr.left;
		}
		curr=root;
		while(curr!=null) {
			right++;
			curr=curr.right;
		}
		
		int res=0;
		if(left==right) {
		   	res=(int) Math.pow(2,left);
		}
		else {
			left=CountEfficientTreeGoG(root.left);
			right=CountEfficientTreeGoG(root.right);
			res=left+right+1;
		}
		return res;
	}

	static int count;
	private static int CountEfficientTree(Node root) {
		// check if it is perfect tree with left length==right length 
		// Worst  N*2H 
		// BEST O 2 H 
		
		if(root==null) {
			return 0;
		}
		
		int res=0;
		int left=CountTreeLeft(root.left);
		int right=CountTreeRight(root.right);
		
		if(left==right) {
			 res=(int)(Math.pow(2,left+1)-1);
			count= (count+res);
		   
		}
		else {
			
		left=CountEfficientTree(root.left);
		right=CountEfficientTree(root.right);
		res=left+right+1;
		}
		
		return res;
	}

	private static int CountNaiveTree(Node root) {
		// Naive 
		if(root==null) {
			return 0;
		}
		int left=CountNaiveTree(root.left);
		int right=CountNaiveTree(root.right);
		
		return (1+left+right);
	}

	private static int CountTreeRight(Node root) {
		//rightmost branch length 
		// O H 
		if(root==null) {
			return 0;
		}
		int right=CountTreeLeft(root.right);
		return right+1;
	}

	private static int CountTreeLeft(Node root) {
		//left most branch length 
		//O H 
		if(root==null) {
			return 0;
		}
		int left=CountTreeLeft(root.left);
		return left+1;
	}

	
}
