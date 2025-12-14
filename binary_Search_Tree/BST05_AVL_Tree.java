package binary_Search_Tree;

/**
 * AVL Tree :
 * Binary Search tree
 * balanced tree -for all root diff between no of nodes in left and right <=1 
 * Very strict reg height of tree 
 * 
 * Balance Factor =|lh -rh|
 * rh- right height 
 * lh - left height 
 * 
 * Balance factor <=1 for AVL 
 * 
 * 	Search,Floor,Ceil - same as BST 
 *  Insert,DElete costly 
 *  
 *  Insert operation :
 *  
 *  Perform normal insert operation O H 
 *  Transverse all ancestors from node to root 
 *  If balance factor NOT <=1 
 *  Restructure based on root 
 *  From root:
 *     Left side > - left as root
 *     Right nodes> - right as root  
 * 
 *  For double rotation :
 *  
 *  
 *  For cases :
 *  Insert 20,15,5,40,50,18
 *           20    left left case -> left rotation 
 *           /
 *          15   
 *         /
 *        5 
 * After 5 , balance of 20 = 2 ... restructure 
 *           15    
 *         /   \
 *        5     20 = right right case -> right rotation  
 *               40
 *                50 
 *  
 * From 50 , 20 is unbalance 
 * From 20 ..restrucure 
 *           15  = right left case -> two rotation  
 *         /   \
 *        5     40
 *              / \
 *             20  50
 *             /
 *            18     
 * First  rotation 
 * From 40 ..restrucure 
 *           15    
 *         /   \
 *        5      20 -> left rotation  
 *              / \
 *             18  40
 *                  \
 *                   50
 *                   
 * Second rotation :
 *          20->right rotation 
 *         / \
 *        15  40
 *       /  \    \
 *      5   18    50  
 *        
 * 	wont work with single rotation 
 * Right left case -- doing a singular right rotation 
 *               40
 *              /  \
 *             15   50 
 *            / \
 *           5  20
 *              /
 *             18
 *              \
 *              19
 *
 *  Deletion - even more check 
 *  
 *  Height of AVL Tree :
 *    H < C log2 (n+2) +b
 *    C= 1.4405
 *    b= -1.3277
 *    
 *    1      Unbalanced AVL Tree 
 *   1  1
 *  1   1 1
 *        1 1 
 * 
 *          
 *                
 *                
 * @author shree 
 * 
 *
 */
public class BST05_AVL_Tree {

}


/**
 * 
 * Introduction to AVL Tree

AVL tree is a self-balancing Binary Search Tree (BST) where the difference between heights of left and right subtrees cannot be more than one for all nodes.

An Example Tree that is an AVL Tree:

The above tree is AVL because differences between heights of left and right subtrees for every node is less than or equal to 1.

An Example Tree that is NOT an AVL Tree:

The above tree is not AVL because differences between heights of left and right subtrees for 8 and 18 is greater than 1.

Why AVL Trees?


Most of the BST operations (e.g., search, max, min, insert, delete.. etc) take O(h) time where h is the height of the BST. The cost of these operations may become O(n) for a skewed Binary tree. If we make sure that the height of the tree remains O(Logn) after every insertion and deletion, then we can guarantee an upper bound of O(Logn) for all these operations. The height of an AVL tree is always O(Logn) where n is the number of nodes in the tree.

Insertion


To make sure that the given tree remains AVL after every insertion, we must augment the standard BST insert operation to perform some re-balancing. Following are two basic operations that can be performed to re-balance a BST without violating the BST property (keys(left) < key(root) < keys(right)).
Left Rotation
Right Rotation


T1, T2 and T3 are subtrees of the tree 
rooted with y (on the left side) or x (on 
the right side)        

Keys in both of the above trees follow the 
following order: 
 keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)

So BST property is not violated anywhere.



Steps to follow for insertion: Let the newly inserted node be w.
Perform standard BST insert for w.
Starting from w, travel up and find the first unbalanced node. Let z be the first unbalanced node, y be the child of z that comes on the path from w to z and x be the grandchild of z that comes on the path from w to z.
Re-balance the tree by performing appropriate rotations on the subtree rooted with z. There can be 4 possible cases that need to be handled as x, y and z can be arranged in 4 ways. Following are the possible 4 arrangements:
y is left child of z and x is left child of y (Left Left Case)
y is left child of z and x is right child of y (Left Right Case)
y is right child of z and x is right child of y (Right Right Case)
y is right child of z and x is left child of y (Right Left Case)


Following are the operations to be performed in above mentioned 4 cases. In all of the cases, we only need to re-balance the subtree rooted with z and the complete tree becomes balanced as the height of subtree (After appropriate rotations) rooted with z becomes same as it was before insertion. (See this video lecture for proof)

a) Left Left Case
T1, T2, T3 and T4 are subtrees.




b) Left Right Case





c) Right Right Case





d) Right Left Case




Insertion Examples:
avlinsert1

avlinsert2-jpg

avlinsert3

avlinsert4

avlinsert5

Time Complexity: The rotation operations (left and right rotate) take constant time as only a few pointers are being changed there. Updating the height and getting the balance factor also takes constant time. So the time complexity of AVL insert remains same as BST insert which is O(h) where h is the height of the tree. Since the AVL tree is balanced, the height is O(Logn). So time complexity of AVL insert is O(Logn).
 * 
 * 
 */
