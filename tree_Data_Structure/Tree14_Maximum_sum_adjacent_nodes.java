package tree_Data_Structure;

import java.util.HashMap;

/**
 * 
 * 
 * Maximum sum of Non-adjacent nodes
Difficulty: MediumAccuracy: 55.35%Submissions: 75K+Points: 4Average Time: 45m
Given a binary tree with a value associated with each node. Your task is to select a subset of nodes such that the sum of their values is maximized, with the condition that no two selected nodes are directly connected that is, if a node is included in the subset, neither its parent nor its children can be included.
 * @author shree
 *
 */
public class Tree14_Maximum_sum_adjacent_nodes {

	public static void main(String[] args) {
		int k=0;
		
	}
	  public int getMaxSum(Node root) {
	        // code here
	        hm=new HashMap<Node,Integer>();
	        return recur(root);
	    }
	    HashMap<Node,Integer> hm;
	    public int recur(Node root){
	        if(root==null){
	            return 0;
	        }
	        if(hm.containsKey(root)){
	            return hm.get(root);
	        }

	        int inc=root.data+
	            (root.left==null?0:(recur(root.left.left)+recur(root.left.right)))
	            + (root.right==null?0:(recur(root.right.left)+recur(root.right.right)));
	        int exc=recur(root.left)+recur(root.right);
	        
	        int ans= Math.max(inc,exc);
	        
	        hm.put(root,ans);
	        return ans;
	        
	    }
}
