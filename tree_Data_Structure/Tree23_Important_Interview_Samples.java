package tree_Data_Structure;

public class Tree23_Important_Interview_Samples {
/*
 * 
 * Sample Problems on Trees

Problem #1 : Print Nodes in Top View of Binary Tree

Description - Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)

A node x is there in output if x is the topmost node at its horizontal distance. The horizontal distance of left child of a node x is equal to a horizontal distance of x minus 1, and that of a right child is the horizontal distance of x plus 1.

Top view of the above binary tree is
4 2 1 3 7


Top view of the above binary tree is
2 1 3 6


Solution - The idea is to do something similar to vertical Order Traversal. Like vertical Order Traversal, we need to put nodes of same horizontal distance together. We do a level order traversal so that the topmost node at a horizontal node is visited before any other node of same horizontal distance below it. Hashing is used to check if a node at a given horizontal distance is seen or not.
Pseudo Code
// function should print the topView of 
// the binary tree 
void topview(Node* root) 
{ 
    if(root==NULL) 
       return; 
    queue < Node* > q
    map < int,int > m
    int hd=0
    root->hd=hd
       
     // push node and horizontal distance to queue 
    q.push(root); 
    while(!q.empty()) 
    { 
        hd=root->hd
        // check whether node at hd distance seen or not 
        if(m.find(hd)==false)   
            m[hd]=root->data
        if(root->left) 
        { 
            root->left->hd=hd-1
            q.push(root->left)
        } 
        if(root->right) 
        { 
            root->right->hd=hd+1
            q.push(root->right)
        } 
        q.pop()
        root=q.front()
    } 
    for(it=m.begin();it!=m.end();it++) 
    { 
        print(it->second)
    }
}



Problem #2 : Diameter of a Binary Tree

Description - The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).

Solution - The diameter of a tree T is the largest of the following quantities:
the diameter of T’s left subtree
the diameter of T’s right subtree
the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)

Pseudo Code
int diameter(struct node *root, int* height)
{
   / /* lh --> Height of left subtree
    //    rh --> Height of right subtree *
    int lh = 0, rh = 0

    //* ldiameter  --> diameter of left subtree
        rdiameter  --> Diameter of right subtree *
    int ldiameter = 0, rdiameter = 0

    if(root == NULL)
    {
        *height = 0
        return 0 /* diameter is also 0 *
    }

    //* Get the heights of left and right subtrees in lh and rh
    //And store the returned values in ldiameter and ldiameter *
    ldiameter = diameter(root->left, &lh)
    rdiameter = diameter(root->right, &rh)

    //* Height of current node is max of heights of left and
     //   right subtrees plus 1*
    *height = max(lh, rh) + 1

    return max(lh + rh + 1, max(ldiameter, rdiameter))
}



Problem #3 : Convert a Binary Tree into its Mirror Tree

Description - Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.Trees in the below figure are mirror of each other.
MirrorTree1
Solution - The idea is to recursively call for left and right subtrees of a given node. On each recursive call swap the pointers of the children nodes.
Pseudo Code
// function to convert binary tree to it's mirror
void mirror(struct Node* node) 
{
    if (node == NULL) 
        return
    else
    {
        struct Node* temp
         
        //* Recur for subtrees *
        mirror(node->left)
        mirror(node->right)
     
        //* swap the pointers in this node *
        temp     = node->left
        node->left = node->right
        node->right = temp
    }
}



Problem #4 : Convert a given Binary Tree to Doubly Linked List

Description - Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
TreeToList
Solution - The idea is to do inorder traversal of the binary tree. While doing inorder traversal, keep track of the previously visited node in a variable say prev. For every visited node, make it next of prev and previous of this node as prev.
Pseudo Code
// A simple recursive function to convert a given Binary tree to Doubly
// Linked List
// root --> Root of Binary Tree
// head --> Pointer to head node of created doubly linked list
void BinaryTree2DoubleLinkedList(node *root, node **head)
{
    // Base case
    if (root == NULL) 
        return
 
    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static node* prev = NULL
 
    // Recursively convert left subtree
    BinaryTree2DoubleLinkedList(root->left, head)
 
    // Now convert this node
    if (prev == NULL)
        *head = root
    else
    {
        root->left = prev
        prev->right = root
    }
    prev = root
 
    // Finally convert right subtree
    BinaryTree2DoubleLinkedList(root->right, head)
}

 * 
 */
}
