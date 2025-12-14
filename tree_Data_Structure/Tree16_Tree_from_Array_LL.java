package tree_Data_Structure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/**  
 * 
 * Construct Binary Tree from Parent Array   
                                  IMPORTANT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

Given an array of size N that can be used to represents a tree. The array indexes are values in tree nodes and array values give the parent node of that particular index (or node). The value of the root node index would always be -1 as there is no parent for root. Construct the standard linked representation of Binary Tree from this array representation.

Note: If two elements have the same parent, the one that appears first in the array will be the left child and the other is the right child. 


Example 1:

Input:
N = 7
parent[] = {-1,0,0,1,1,3,5}
Output: 0 1 2 3 4 5 6
Explanation: the tree generated
will have a structure like 
          0
        /   \
       1     2
      / \
     3   4
    /
   5
 /
6
Example 2:

Input:
N = 3
parent[] = {2, 0, -1}
Output: 2 0 1
Explanation: the tree generated will
have a sturcture like
               2
             /   
            0      
          /   
         1     

Your Task:
You don't need to read input or print anything. The task is to complete the function createTree() which takes 2 arguments parent[] and N and returns the root node of the constructed tree.





 * 
 * 
 * Tree from Linked List 
 * Given a Linked List Representation of Complete Binary Tree. The task is to construct the Binary tree.
Note : The complete binary tree is represented as a linked list in a way where if root node is stored at position i, its left, and right children are stored at position 2*i+1, 2*i+2 respectively.

Example 1:

Input:
N = 5
K = 1->2->3->4->5
Output: 1 2 3 4 5
Explanation: The tree would look like
      1
    /   \
   2     3
 /  \
4   5
Now, the level order traversal of
the above tree is 1 2 3 4 5.
Example 2:

Input:
N = 5
K = 5->4->3->2->1
Output: 5 4 3 2 1
Explanation: The tree would look like
     5
   /  \
  4    3
 / \
2    1
Now, the level order traversal of
the above tree is 5 4 3 2 1.
 * 
 * 
 * 
 * @author shree
 *
 */
class NodeLL{
	int data;
	NodeLL next;
	NodeLL(int d){
		data=d;
		next=null;
	}
}
public class Tree16_Tree_from_Array_LL {
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
		
		NodeLL head=new NodeLL(1);
		head.next=new NodeLL(2);
		head.next.next=new NodeLL(3);
		head.next.next.next=new NodeLL(4);
		head.next.next.next.next=new NodeLL(5);
		head.next.next.next.next.next=new NodeLL(6);
		head.next.next.next.next.next.next=new NodeLL(7);
		
		Node ans=convertLL(head,root);
		Tree20_Depth_First_ITERATIVE.PreOrder_Iterative_Space(ans);
   
    //TOUGH //////////////////////////////////////////////////HARD 
		int arr[]= {1,2,3,4,5,6,7,8,-1};
		
		ans=createTree(arr,arr.length);
		System.out.println(" Array to tree HashMAP");
		
		Tree20_Depth_First_ITERATIVE.PreOrder_Iterative_Space(ans);

    
    }
    
  //Function to construct binary tree from parent array.
    // -1 0 0 1 1 3 5 
    //  0 1 2 3 4 5 6
    
    // 2 0 -1 
    // 0 1  2
    // construct HM 
    // 2 0
    // 0 1
    // -1 2
    // Match and create 
    public static Node createTree(int parent[], int N)
    {
        //Your code here
        if(N==1){
            Node root=new Node(0);
            return root;
        }
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        Queue<Node> root=new ArrayDeque<>();
        ArrayList<Integer> ans=null;
        for(int i=0;i<N;i++){
            ans=new ArrayList<Integer>(2);
           if(hm.containsKey(parent[i])){
               ans=hm.get(parent[i]);
               ans.add(i);
            }
            else{
                ans.add(i);
            }
            hm.put(parent[i],ans);
           }
           
          // System.out.println(hm.toString());
           
     //   int count=1;
        ArrayList<Integer> root_data=hm.get(-1);
        ArrayList<Integer> leaf=null;
        Node left=null;
        Node right=null;
        
        //System.out.println(root_data.toString());
        int iroot=0;
        int ileft=0;
        int iright=0;
        
        hm.remove(-1,root_data);
        iroot=root_data.get(0);
        Node rootu=new Node(iroot);
        root.offer(rootu);
        Node curr=null;
        while(!hm.isEmpty() && !root.isEmpty()){
            curr=root.remove();
            iroot=curr.data;
        
            if(hm.containsKey(iroot)){
                leaf=hm.get(iroot);
                
               if(leaf.size()>1){
                   ileft=leaf.get(0);
                   iright=leaf.get(1);
           
                   left=new Node(ileft);
                   right=new Node(iright);
                   curr.left=left;
                   curr.right=right;
                   
                   root.add(left);
                   root.add(right);
                   
                   hm.remove(iroot,ileft);
                   hm.remove(iroot,iright);
               }
               else{
                  ileft=leaf.get(0); 
                  left=new Node(ileft);
                   curr.left=left;
                    hm.remove(iroot,ileft);
                   root.add(left);
               }
            }
     }
   
        return rootu;
    }
	
	private static Node convertLL(NodeLL head, Node node) {
        // add code here.}
        Queue<Node> root=new ArrayDeque<>();
       // Queue<Node> leaf=new ArrayDeque<>();
        //int leaf_count=2;
       
        Node ROOT=new Node(head.data);
        root.offer(ROOT);
         head=head.next;
        while(!root.isEmpty() && head!=null){
                Node rootu=root.remove();
                Node left=new Node(head.data);
                rootu.left=left;
                root.add(left);
                Node right=null;
                head=head.next;
                if((head!=null)){
                    right=new Node(head.data);
                    rootu.right=right;
                    head=head.next;
                    root.add(right);
                }
                
            }
     
     
     return ROOT;   
    }
	
}
