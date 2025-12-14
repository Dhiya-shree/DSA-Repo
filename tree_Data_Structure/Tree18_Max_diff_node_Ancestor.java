package tree_Data_Structure;

/**
 * Maximum difference between node and its ancestor
 * 
 * 

Given a Binary Tree, you need to find the maximum value which you can get by subtracting the value of node B from the value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. 

Example 1:

Input:
    5
 /    \
2      1
Output: 4
Explanation:The maximum difference we can
get is 4, which is bewteen 5 and 1.
Example 2:

Input:
      1
    /    \
   2      3
           \
            7
Output: -1
Explanation:The maximum difference we can
get is -1, which is between 1 and 2.
Your Task:
The task is to complete the function maxDiff() which finds the maximum difference between the node and its ancestor.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
2 <= Number of edges <= 104
0 <= Data of a node <= 105

Note: The Input/Output format and Examples given are used for the system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code.
 * 
 * 
 * @author shree
 *
 */
public class Tree18_Max_diff_node_Ancestor {

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
		
		
		int ans=maxDiff(root);
		System.out.println(" Ans max path is just diff of root "+ans);
		System.out.println(" Actual ans :"+maxD);
		
		
 }
	//Function to return the maximum difference between any 
    //node and its ancestor.
    private static int maxDiff(Node root)
    {
        //your code here
        mini=Integer.MAX_VALUE;
        maxi=Integer.MIN_VALUE;
        maxD=Integer.MIN_VALUE;
       
        
        int ans=MaxDiff(root);
        ans=Math.max(ans,maxD);
        return ans;
    }
    static int maxi;
    static int mini;//static boolean leftSet;static boolean rightSet;
    static int maxD;//static int left;static int right;
    
    private static int MaxDiff(Node root)
    {  
        if(root==null){
            return Integer.MAX_VALUE;
        }
        
     int left=MaxDiff(root.left);
        
      int right=MaxDiff(root.right);
        
        
        //System.out.println(root.data+" "+left+" .."+right);
        
        mini=Math.min(left,right);
        //  System.out.println(Math.min(Math.min(left,right),root.data));
        int diff=root.data-mini;
        
        maxD=Math.max(maxD,diff);
        return Math.min(Math.min(left,right),root.data);
    }
}
