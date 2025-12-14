package tree_Data_Structure;

/**
 * Construct a Binary tree 
 * 
 * Not possible with pre order and post order 
 * Not possible with only with in-order
 * 
 * Possible to construct only if :----
 * In order - pre order combo 
 * In order - post order combo 
 * 
 * 1) From in order array 
 * 2) From Pre order array 
 * 
 * 
 * ex 1: Inorder left-- root -- right 
 * in[] ={50,20,60,10,15,30,45}
 *            10
 *           /  \
 *          20   30
 *         / \   / \
 *        50 60 15  45
 * ex 2: Preorder root--left--right
 * in[] ={50,20,60,10,15,30,45}
 * pre[]={10,20,50,60,30,15,45}
 *            10
 *           /  \
 *          20   30
 *         / \   / \
 *        50 60 15  45
 * 
 * Above both not possible for large trees 
 * 
 * Must to have both In order + combo 
 * in[] ={40,20,60,50,70,10,80,100,30}
 * pre[]={10,20,40,50,60,70,30,80,100}
 * 
 * Root from above :
 * From pre - root always pre[0]
 * So in= 50,20,60   10   15,30,45
 * 
 * 
 * Use preorder to find root -> left root -> left's left root -> 
 *                  left right root -> right root ->........
 *                  
 * For every index/root in Pre order :
 *        Create a BTNode 
 *        Find index i in inorder (preOrder root in inorder )
 *        BTNode.left = left of index in inorder 
 *        BTNode.right = right of index in inorder
 *        Return root 
 *        
 *        Recursively call for left , left-> left , left-> right ....
 *        Call for right , right -> left , right-> right and so on ....
 *        
 *        
 * Algo :
 * static PreOrderIndex 0
 * is - index start in inorder 0 
 * ie - index end in inorder  n-1
 * 
 * index - index of pre[PreOrderIndex] in inorder array 
 * 
 * 1) Base condition if place to seach for index in inorder
 *      Base condt for leaf 
 *      if(is>ie)  -->return null
 * 
 * 2) Set the root based on Pre order 
 *      root = pre [ PreOrderIndex ]
 *      PreOrderIndex++;
 * 
 * 3) Find the root in in order 
 *     for i : is -> ie 
 *       if inorder[i]==root --> break 
 *     index=i
 * 
 * 4) Recursively call for left and right 
 * 
 *    root.left= call ( is, index-1, in ,pre)
 *    root.right=call ( index+1, ie, in ,pre)
 *    
 *    return root 
 * 
 *         
 *   ///////////////////////////COMBO 2////////////////////////////////////////
 * For inorder and postOrder combo :
 * 
 * PostOrder - left right root 
 * in[] ={40,20,60,50,70,10,80,100,30}
 * post[]={40,60,70,50,20,100,80,30,10}
 * 
 * Root from above :
 * From post - root always pre[n-1]
 * So in= 50,20,60   10   15,30,45
 * 
 * For every index/root in POST order from N-1 to 0  :
 *        Create a BTNode 
 *        Find index i in inorder (preOrder root in inorder )
 *        
 *        In post order left .. right .. root present 
 *        so after root right call to be made 
 *        
 *        BTNode.right = right of index in inorder
 *        BTNode.left = left of index in inorder 
 *        
 *        Return root 
 *        
 *        Recursively  Call for right , right -> left , right-> right and so on ....
 *        call for left , left-> left , left-> right ....
 *     
 *     
 * Algo :
 * static PostOrderIndex = n-1 in main 
 * is - index start in inorder 0 
 * ie - index end in inorder  n-1
 * 
 * index - index of post[PostOrderIndex] in inorder array 
 * 
 * 1) Base condition if place to seach for index in inorder
 *      Base condt for leaf 
 *      if(is>ie)  -->return null
 * 
 * 2) Set the root based on post order 
 *      root = post [ PostOrderIndex ]
 *      postOrderIndex--;
 * 
 * 3) Find the root in in order 
 *     for i : is -> ie 
 *       if inorder[i]==root --> break 
 *     index=i
 * 
 * 4) Recursively call for right and the left
 *      left ..... right ... root  
 *      
 *    root.right=call ( index+1, ie, in ,post)
 *    root.left= call ( is, index-1, in ,post)
 *    
 *    return root 
 *    
 *       
 *       
 * @author shree
 *
 */
public class Tree09_Tree_from_In_PreOrder {

	public static void main(String[] args) {
		// Construct binary tree 
		
		//Combo 1 Inorder + preorder 
		int in[] ={40,20,60,50,70,10,80,100,30};
		int pre[]={10,20,40,50,60,70,30,80,100};
		
		
		int end=in.length-1;int start=0;
		// start is=0 end ie=n-1
		BTNode root=ConsInOrder_PreOrder(start,end,in,pre);
		System.out.println(" Tree below :");
        Tree03_Traversal_Level_order.TraverseLevelOrderQueueTwoLoops(root);
		Tree02_Traversal_DepthFirst.InOrderTraversal(root);
       
        //Combo  2 Inorder + postOrder
        int post[]={40,60,70,50,20,100,80,30,10};
        
        //Set the postOrderIndex as n-1 
        postOrderIndex=end;
        
        BTNode root2=ConsInOrder_PostOrder(start,end,in,post);
		System.out.println(" Tree below :");
        Tree03_Traversal_Level_order.TraverseLevelOrderQueueTwoLoops(root2);
        Tree02_Traversal_DepthFirst.InOrderTraversal(root);
        
        
	}

	//Static index for pre order array 
	static int preOrderIndex=0;
	private static BTNode ConsInOrder_PreOrder(int start, int end, int[] in, int[] pre) {
		// Base case if empty array 
		if(start>end) {
			return null;
		}
		
		//For each root in pre order array 
		BTNode root=new BTNode(pre[preOrderIndex]);
		preOrderIndex=preOrderIndex+1;
		
		//Find Index 
		int index=0;
		for(int i=start;i<=end;i++) {
			if(in[i]==root.key) {
				index=i;
				break;
			}
		}
		
		//Recursive call 
		root.left=ConsInOrder_PreOrder(start,index-1, in, pre);
		root.right=ConsInOrder_PreOrder(index+1,end,in, pre);
		
		//Retur root
		return root;
	}
	
	//Static index for post order array 
		static int postOrderIndex=0;
		private static BTNode ConsInOrder_PostOrder(int start, int end, int[] in, int[] pre) {
			// Base case if empty array 
			if(start>end) {
				return null;
			}
			
			//For each root in pre order array 
			BTNode root=new BTNode(pre[postOrderIndex]);
			postOrderIndex=postOrderIndex-1;
			
			//Find Index 
			int index=0;
			for(int i=start;i<=end;i++) {
				if(in[i]==root.key) {
					index=i;
					break;
				}
			}
			
			//Post order left<--- right <--- root
			//Recursive call first right 
			root.right=ConsInOrder_PostOrder(index+1,end,in, pre);
	        //then left
			root.left=ConsInOrder_PostOrder(start,index-1, in, pre);
			
			//Retur root
			return root;
		}

}

/**
 * 
 * Construct Binary Tree from Inorder and Preorder

Let us consider the below traversals:

Inorder sequence: D B E A F C 
Preorder sequence: A B D E C F
subtree and elements on right in the right subtree. So we know the below structure now. 

                 A
               /   \
             /       \
           D B E     F C
We recursively follow the above steps and get the following tree.

         A
       /   \
     /       \
    B         C
   / \        /
 /     \    /
D       E  F
Algorithm: 

Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick the next element in the next recursive call. 
Create a new tree node tNode with the data as the picked element. 
Find the picked element’s index in Inorder. Let the index be inIndex. 
Call buildTree for elements before inIndex and make the built tree as a left subtree of tNode. 
Call buildTree for elements after inIndex and make the built tree as a right subtree of tNode. 
return tNode.
We store indexes of inorder traversal in a hash table. So that search can be done O(1) time. 

/* Java program to construct tree using inorder
and preorder traversals *
import java.io.*;
import java.util.*;

/* A binary tree node has data, pointer to left child
and a pointer to right child *
class Node
{
char data;
Node left,right;
Node(char item)
{
	data = item;
	left = right = null;
}
}
class Tree
{

public static Node root;

// Store indexes of all items so that we
// we can quickly find later
static HashMap<Character,Integer> mp = new HashMap<>();
static int preIndex = 0;

/* Recursive function to construct binary of size
	len from Inorder traversal in[] and Preorder traversal
	pre[]. Initial values of inStrt and inEnd should be
	0 and len -1. The function doesn't do any error
	checking for cases where inorder and preorder
	do not form a tree *
public static Node buildTree(char[] in, char[] pre, int inStrt, int inEnd)
{

	if(inStrt > inEnd)
	{
	return null;
	}

	/* Pick current node from Preorder traversal using preIndex
		and increment preIndex *
	char curr = pre[preIndex++];
	Node tNode;
	tNode = new Node(curr);

	/* If this node has no children then return *
	if (inStrt == inEnd)
	{
	return tNode;
	}

	/* Else find the index of this node in Inorder traversal *
	int inIndex = mp.get(curr);

	/* Using index in Inorder traversal, construct left and
		right subtress *
	tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
	tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
	return tNode;
}

// This function mainly creates an unordered_map, then
// calls buildTree()
public static Node buldTreeWrap(char[] in, char[] pre, int len)
{
	for(int i = 0; i < len; i++)
	{
	mp.put(in[i], i);
	}
	return buildTree(in, pre, 0, len - 1);
}

/* This function is here just to test buildTree() *
static void printInorder(Node node)
{
	if(node == null)
	{
	return;
	}
	printInorder(node.left);
	System.out.print(node.data + " ");
	printInorder(node.right);
}

/* Driver code *
public static void main (String[] args)
{
	char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
	char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
	int len = in.length;

	Tree.root=buldTreeWrap(in, pre, len);

	/* Let us test the built tree by printing
		Inorder traversal *
	System.out.println("Inorder traversal of the constructed tree is");
	printInorder(root);
}
}

// This code is contributed by avanitrachhadiya2155
 

Output

Inorder traversal of the constructed tree is 
D B E A F C 
Time Complexity: O(n)
Auxiliary Space: O(n), The extra space is used to store the elements in the map also due to recursive function call stack.
 * 
 * 
 */
