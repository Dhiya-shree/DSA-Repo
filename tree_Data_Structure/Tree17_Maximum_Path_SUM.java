package tree_Data_Structure;

/**
 * Maximum path sum from any node
 * 
 * 
 * 
Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Example 1:

Input:
     10
    /  \
   2   -25
  / \  /  \
 20 1  3  4
Output: 32
Explanation: Path in the given tree goes
like 10 , 2 , 20 which gives the max
sum as 32.
Example 2:

Input:
     10
   /    \
  2      5
          \
          -2
Output: 17
Explanation: Path in the given tree goes
like 2 , 10 , 5 which gives the max sum
as 17.
Your Task:
You don't need to take input or print anything. Your task is to complete the function findMaxSum() that takes root as input and returns max sum between any two nodes in the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes ≤ 103
1 ≤ |Data on node| ≤ 104
 * 
 * 
 * @author shree
 *
 */
public class Tree17_Maximum_Path_SUM {

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
			
			
			int ans=findMaxSum(root);
			System.out.println(" Ans max path "+ans);
			
			
	 }
	 
	 private static int findMaxSum(Node node)
	    {
	        //your code goes here
	        if(node.left==null && node.right==null){
	            return node.data;
	        }
	        
	        maxsum=node.data;
	        int ans=FindMaxSum(node);
	       // System.out.println(ans+"....."+maxsum);
	        return Math.max(ans,maxsum);
	    }
	    static int maxsum;
	    private static  int FindMaxSum(Node root){
	        if(root==null){
	            return 0;
	        }
	        
	     int  left=FindMaxSum(root.left);
	       
	        // CAUTION !!!!!!!!!!!!!!!!!!!!!!!!!!
	        // Below condt must 
	        //-4 3 N 5 -5
	        // When all negative numbers are given as input 
	        // Without below condit 
	        // Max sum will be 0 
	        // For all negative condt  XXXXXXXXXX
	        if(left>maxsum && root.left!=null){
	            maxsum=left;
	        }


	      int right= FindMaxSum(root.right);
	        // Can consider only is next node is not null
	        //MUST for non negative condt 
	        
	         if(right>maxsum && root.right!=null){
	            maxsum=right;
	        }
	        
	      
	        
	        int total=left+right+root.data;
	        //Must to check for 3 7 -5 -6 -8 -8
	        
	        if(maxsum<total){
	            maxsum=total;
	        }

	        //Must to consider individual left and right 
	        //-5 -8 N 7 -5 N -2
	        //Help in single node positive
	        //0 -2 9 -9 -9 -3 -4 -7
	        if(root.data>maxsum){
	            maxsum=root.data;
	        }
	        
	        return Math.max(Math.max(left,right)+root.data,root.data);
	    }
}
