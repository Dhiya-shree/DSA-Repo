package binary_Search_Tree;
/****
 * 
 * Binary Search TRee 
 * --> similar to binary search in sorted array 
 * 
 * Binary search 
 * sorted Array ----> sorted Tree 
 *              (with median in root)
 *            
 * For every node keys in left side are smaller 
 * For every node keys in right side are greater 
 * 
 * All keys are typically considered distinct 
 * 
 * Like linked list it is a linked data structure 
 * Not like array that has everything in a location 
 * 
 * Adv ->best resizing 
 * DisAdv > not cache friendly , diff items at diff location 
 * 
 * Implementation in C++ : Self Balancing Binary TRee 
 *    ->map 
 *    ->set 
 *    ->Multimap 
 *    -> MultiSet 
 *    
 * Java implementation :
 *   -> TreeSet 
 * 
 * 
 * 
 * Binary tree -> providing faster search 
 * 
 *           50
 *         /   \
 *       30     70
 *     /   \   /  \
 *    10   40 60  80
 *    
 * 
 * Operations on BST :
 * 
 * 1) Create an empty BST 
 *       root.key
 *       left
 *       right
 * 2) Insert and deletion order needs to be maintained 
 * 
 *   Insertion : 20,15,30,40,50,12,18,35,80,7
 *   
 *   Insert 20 as root 
 *   Insert 15 in left <20
 *   Insert 30 in right>20 
 *   
 *   Insert 40 in right's right >20 & >30
 *   Insert 50 in right's right's right >20 & >30 & >40
 *   
 *   Insert 12 in left's left <15 & <20
 *   Insert 18 in left's right >15 & <20
 *   
 *   Insert 35 in right's right's left >20,30 <40
 *   Insert 80 in right's right's right's right >20,30,40,50
 *   
 *   Insert 7 in left's left's left <20,15,12
 *   
 *   Tree after insertion 
 *               20
 *              /  \
 *            15    30
 *          /  \      \
 *         12  18     40
 *        /          /  \
 *       7          35   50
 *                        \
 *                        80
 *                        
 *                        
 *   Height of tree = Nodes number 
 *   ->Increasing order or decreasing order
 *           
 *   If H= no of nodes 
 *   Similar to LL 
 *   
 *   Need to have balanced binary tree 
 *   Self balancing binary tree O H - O N Log N ?
 * 
 * 
 * 
 * Complexity table  
 *                         Use 
 *                    Binary_search
 * Data Struct  Unsorted  Sorted   Linked   BST     HashTable  
 * Operation     Array     Array   List   
 *  SEARCH        O(n)    O(logn)  O(n)    O(logn)    O(1)
 * 
 *  INSERT        O(1)    O(n)     O(1)    O(logn)    O(1) 
 *  
 *  DELETE        O(n)    O(n)     O(n)    O(logn)    O(1)
 *  
 *  Find          O(n)    O(logn)  O(n)    O(logn)    O(n)
 *  Closest 
 *  
 *  Sorted       O(nlogn)   O(nlogn)    O(n)    O(n)      O(logn)
 *  Traversal
 * 
 * Binary Search tree implements all operation in O Log N tim e
 * Hash Table has O 1 search  inset and delete .. but higher for find closet and sorted traversal
 * 
 * BST is used when need to search,insert,delete + Find closest/Sorted traversal
 * BST time complexity for BST formation :
 *      Balanced:O Log N 
 *  Not-Balanced: O H 
 * 
 * Self balancing tree control height at Log N 
 * 
 * 
 * @author shree
 *
 */
 
public class BST01_binary_search_tree_Intro {

	
	/*
	 * 
	 * Applications of BST

Applications of Binary Search tree:

BSTs are used for indexing.
It is also used to implement various searching algorithms.
IT can be used to implement various data structures.
Real-time Application of Binary Search tree:

BSTs are used for indexing in databases.
It is used to implement searching algorithms.
BSTs are used to implement Huffman coding algorithm.
It is also used to implement dictionaries.
Advantages of Binary Search Tree:

BST is fast in insertion and deletion when balanced.
BST is efficient.
We can also do range queries – find keys between N and M (N <= M).
BST code is simple as compared to other data structures.
Disadvantages of Binary Search Tree:

The main disadvantage is that we should always implement a balanced binary search tree. Otherwise the cost of operations may not be logarithmic and degenerate into a linear search on an array.
Accessing the element in BST is slightly slower than array.
A BST can be imbalanced or degenerated which can increase the complexity.
	 * 
	 * 
	 */
}



/**
 * 
 * Introduction to Binary Search Trees

Binary Search Tree is a node-based binary tree data structure which has the following properties:
The left subtree of a node contains only nodes with keys lesser than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
The left and right subtree each must also be a binary search tree. There must be no duplicate nodes.


Sample Binary Search Tree:
200px-Binary_search_tree.svg

The above properties of Binary Search Tree provide an ordering among keys so that the operations like search, minimum and maximum can be done fast in comparison to normal Binary Trees. If there is no ordering, then we may have to compare every key to search a given key.

Searching a Key


Using the property of Binary Search Tree, we can search for an element in O(h) time complexity where h is the height of the given BST.

To search a given key in Binary Search Tree, first compare it with root, if the key is present at root, return root. If the key is greater than the root's key, we recur for the right subtree of the root node. Otherwise, we recur for the left subtree.

Implementation:

// A utility function to search a given key in BST
public Node search(Node root, int key)
{
    // Base Cases: root is null or key is present at root
    if (root==null || root.key==key)
        return root;

    // val is greater than root's key
    if (root.key > key)
        return search(root.left, key);

    // val is less than root's key
    return search(root.right, key);
}


Illustration to search a key 6 in the below BST:
Start from root.
Compare the key element with root, if less than root, then recur for left subtree, else recur for right subtree.
If element to search is found anywhere, return true, else return false.


bstsearch

Step 1: Compare 6 with 8.
        Since 6 is less than 8, 
        move to left subtree.
Step 2: Compare 6 with 3.
        Since 6 is greater than 3, 
        move to its right subtree.
Step 3: Comapre 6 with 6.
        Node Found.



Insertion of a Key


Inserting a new node in the Binary Search Tree is always done at the leaf nodes to maintain the order of nodes in the Tree. The idea is to start searching the given node to be inserted from the root node till we hit a leaf node. Once a leaf node is found, the new node is added as a child of the leaf node.

For Example:
         100                               100
        /   \        Insert 40            /    \
      20     500    --------->          20     500 
     /  \                              /  \  
    10   30                           10   30
                                              \   
                                              40



Implementation:

// Java program to demonstrate insert 
// operation in binary search tree

class BinarySearchTree {

    //* Class containing left and right
     //  child of current node and key value 
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() { 
        root = null; 
    }

    // This method mainly calls insertRec()
    void insert(int key) {
       root = insertRec(root, key);
    }
    
    //* A recursive function to insert a new key in BST /
    Node insertRec(Node root, int key) {

        
    	//* If the tree is empty, return a new node /
        if (root == null) {
            root = new Node(key);
            return root;
        }

       //* Otherwise, recur down the tree /
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        //* return the (unchanged) node pointer /
        return root;
    }

    // This method mainly calls inorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);

            System.out.print(root.key+" ");
            
            inorderRec(root.right);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Let us create following BST
      //              50
        //          /     \
        //        30      70
          //       /  \    /  \
        //      20   40  60   80 
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        tree.inorder();
    }
}

Output:
20 30 40 50 60 70 80


Illustration to insert 2 in the below tree:
Start from root.
Compare the element to be inserted with root, if it is less than root, then recur for left-subtree, else recur for right-subtree.
After reaching end,just insert that node at left(if less than current leaf node) else right.

bstsearch

Element to be inserted: 2

Step 1: Compare 2 with 8.
        Since 2 is less than 8, 
        move to left subtree.
Step 2: Compare 2 with 3.
        Since 2 is less than 3, 
        move to its left subtree.
Step 3: Comapre 2 with 1.
        Since 2 is greater than 1 and also 1 is a leaf node.
        Insert 2 as its right child of node 1.



Time Complexity: The worst case time complexity of search and insert operations is O(h) where h is height of Binary Search Tree. In the worst case, we may have to travel from root to the deepest leaf node. The height of a skewed tree may become n and the time complexity of search and insert operation may become O(n).

 * 
 * 
 */
