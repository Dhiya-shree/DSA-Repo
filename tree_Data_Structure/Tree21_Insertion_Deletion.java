package tree_Data_Structure;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Insertion
 * Problem: Given a Binary Tree and a Key. The task is to insert the key into
 * the binary
 * tree at first position available in level order.
 * 
 * 
 * Deletion :
 * While performing the delete operation on binary trees, there arise a few
 * cases:
 * The node to be deleted is a leaf node. That is it does not have any children.
 * The node to be deleted is a internal node. That is it have left or right
 * child.
 * The node to be deleted is the root node.
 * 
 * No issues in 1st case
 * But when node has child -> can not handle child
 * Can not link previous to node's child like Linked list
 * 
 * Deletion : ---- to remove the data from tree
 * 
 * Find any leaf data
 * Replace data of leaf and curr node pos
 * Delete the leaf
 * 
 * 
 * @author shree
 *
 */
public class Tree21_Insertion_Deletion {

    public static void main(String[] args) {
        // insertion and deletion
        Node root = new Node(100);
        root.left = new Node(40);
        root.right = new Node(60);
        root.left.left = new Node(10);
        root.left.left.left = new Node(100);
        root.left.right = new Node(30);
        root.left.right.right = new Node(30); ///
        root.right.right = new Node(600);
        root.right.left = new Node(22);

        root.right.right.right = new Node(6000);
        root.right.right.right.left = new Node(60);

        int data = 55555;
        Tree20_Depth_First_ITERATIVE.PreOrder_Iterative_Space(root);
        System.out.println("Insertion ......");
        Node newRoot = InsertionTree(root, data);
        Tree20_Depth_First_ITERATIVE.PreOrder_Iterative_Space(newRoot);

        System.out.println("Deletion ......");
        newRoot = DeletionTree(root, data);
        Tree20_Depth_First_ITERATIVE.PreOrder_Iterative_Space(newRoot);

    }

    private static Node DeletionTree(Node root, int key) {
        // replace with far right/left node

        // Farthest node
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.data == key) {
                return null;
            } else {
                return root;
            }
        }

        // Level order traversal
        Queue<Node> q = new ArrayDeque<>();
        // Stack<Node> sc=new Stack<>();
        int count = 1;// int ActualCount=2;
        q.offer(root);
        Node curr = root;
        boolean NOTfound = true;
        while (!q.isEmpty() && curr != null && NOTfound) {
            count = q.size();
            for (int i = 0; i < count; i++) {
                curr = q.poll();

                if (curr.left != null) {
                    if (curr.left.data == key) {
                        if (curr.left.left == null && curr.left.right == null) {
                            curr.left = null;
                        } else {
                            Node farthest = FindFarthest(curr.left);
                            farthest.left = curr.left.left;
                            farthest.right = curr.left.right;
                            curr.left = farthest;
                            NOTfound = false;
                            break;
                        }
                    } else {
                        q.offer(curr.left);
                    }
                }

                if (curr.right != null) {
                    if (curr.right.data == key) {
                        System.out.println(" Key " + key);
                        if (curr.right.left == null && curr.right.right == null) {
                            System.out.println(" Cur left null " + curr.data);
                            curr.left = null;
                        } else {
                            Node farthest = FindFarthest(curr.right);
                            System.out.println(" Farthest " + farthest.data + " right " + key);
                            farthest.left = curr.right.left;
                            farthest.right = curr.right.right;
                            curr.right = farthest;
                            NOTfound = false;
                            break;
                        }
                    } else {
                        q.offer(curr.right);
                    }
                }

            } // for endds

        } // while ends

        // Delete farthest

        if (preFarthest != null) {
            if (left) {
                // WE considered left most
                preFarthest.left = null;
            } else {
                preFarthest.right = null;
            }

        }

        return root;
    }

    static Node preFarthest;
    static boolean left = false;

    private static Node FindFarthest(Node root) {
        Node farthest = null;
        preFarthest = root;
        if (root.left != null) {
            Node curr = root.left;
            while (curr != null) {
                preFarthest = preFarthest.left;
                farthest = curr;
                curr = curr.left;
            }
            left = true;
        } else {
            Node curr = root.right;
            while (curr != null) {
                preFarthest = preFarthest.right;
                farthest = curr;
                curr = curr.right;
            }
        }
        return farthest;
    }

    private static Node InsertionTree(Node root, int data) {
        // level order whereever null put the piece
        // Use two stack 1 for parent

        if (root == null) {
            return new Node(data);
        }
        Queue<Node> q = new ArrayDeque<>();
        // Stack<Node> sc=new Stack<>();
        int count = 1;// int ActualCount=2;
        q.offer(root);
        Node curr = root;
        boolean NOTadded = true;
        while (!q.isEmpty() && curr != null && NOTadded) {
            count = q.size();
            for (int i = 0; i < count; i++) {
                curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                } else {
                    NOTadded = false;
                    curr.left = new Node(data);
                    break;
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                } else {
                    NOTadded = false;
                    curr.right = new Node(data);
                    break;
                }

            }

        }

        return root;
    }

}

/**
 * nsertion in a Binary Tree
 * 
 * Problem: Given a Binary Tree and a Key. The task is to insert the key into
 * the binary tree at first position available in level order.
 * 
 * 
 * 
 * 
 * The idea is to do iterative level order traversal of the given tree using a
 * queue. If we find a node whose left child is empty, we make new key as the
 * left child of the node. Else if we find a node whose right child is empty, we
 * make new key as the right child of that node. We keep traversing the tree
 * until we find a node whose either left or right child is empty.
 * 
 * 
 * 
 * Below is the implementation of this approach:
 * 
 * 
 * 
 * 
 * // Java program to insert element in binary tree
 * 
 * import java.util.LinkedList;
 * import java.util.Queue;
 * public class GFG {
 * 
 * // Binary Tree Node
 * static class Node {
 * int key;
 * Node left, right;
 * 
 * // constructor
 * Node(int key){
 * this.key = key;
 * left = null;
 * right = null;
 * }
 * }
 * 
 * static Node root;
 * static Node temp = root;
 * 
 * // Function to perform InOrder traversal
 * // of the Binary Tree
 * static void inorder(Node temp)
 * {
 * if (temp == null)
 * return;
 * 
 * inorder(temp.left);
 * System.out.print(temp.key+" ");
 * inorder(temp.right);
 * }
 * 
 * // Function to insert a new element in the
 * // Binary Tree
 * static void insert(Node temp, int key)
 * {
 * Queue<Node> q = new LinkedList<Node>();
 * q.add(temp);
 * 
 * // Do level order traversal until we find
 * // an empty place.
 * while (!q.isEmpty()) {
 * temp = q.peek();
 * q.remove();
 * 
 * if (temp.left == null) {
 * temp.left = new Node(key);
 * break;
 * } else
 * q.add(temp.left);
 * 
 * if (temp.right == null) {
 * temp.right = new Node(key);
 * break;
 * } else
 * q.add(temp.right);
 * }
 * }
 * 
 * // Driver code
 * public static void main(String args[])
 * {
 * // Create the following Binary Tree
 * // 10
 * // / \
 * // 11 9
 * // / \
 * // 7 8
 * root = new Node(10);
 * root.left = new Node(11);
 * root.left.left = new Node(7);
 * root.right = new Node(9);
 * root.right.left = new Node(15);
 * root.right.right = new Node(8);
 * 
 * System.out.print( "Inorder traversal before insertion: ");
 * inorder(root);
 * 
 * int key = 12;
 * insert(root, key);
 * 
 * System.out.print("\nInorder traversal after insertion: ");
 * inorder(root);
 * }
 * }
 * 
 * 
 * Output
 * 
 * Inorder traversal before insertion: 7 11 10 15 9 8
 * Inorder traversal after insertion: 7 11 12 10 15 9 8
 * 
 */

/*
 * 
 * Deletion in a Binary Tree
 * 
 * Problem: Given a Binary Tree and a node to be deleted from this tree. The
 * task is to delete the given node from it.
 * 
 * Examples:
 * Delete 10 in below tree
 * 
 * Output :
 * 
 * 
 * 
 * Delete 20 in below tree
 * 
 * Output :
 * 
 * 
 * 
 * 
 * While performing the delete operation on binary trees, there arise a few
 * cases:
 * The node to be deleted is a leaf node. That is it does not have any children.
 * The node to be deleted is a internal node. That is it have left or right
 * child.
 * The node to be deleted is the root node.
 * 
 * 
 * In the first case 1, since the node to be deleted is a leaf node, we can
 * simply delete the node without any overheads. But in the next 2 cases, we
 * will have to take care of the children of the node to be deleted.
 * 
 * In order to handle all of the cases, one way to delete a node is to:
 * Starting at the root, find the deepest and rightmost node in binary tree and
 * node which we want to delete.
 * Replace the deepest rightmost node’s data with the node to be deleted.
 * Then delete the deepest rightmost node.
 * 
 * 
 * 
 * Below is the implementation of the above approach:
 * 
 * // Java program to delete element in binary tree
 * import java.util.LinkedList;
 * import java.util.Queue;
 * public class GFG {
 * 
 * // Binary Tree Node
 * static class Node {
 * int key;
 * Node left, right;
 * 
 * // constructor
 * Node(int key){
 * this.key = key;
 * left = null;
 * right = null;
 * }
 * }
 * 
 * static Node root;
 * static Node temp = root;
 * 
 * // Function to perform Inorder traversal
 * // of a binary tree
 * static void inorder(Node temp)
 * {
 * if (temp == null)
 * return;
 * 
 * inorder(temp.left);
 * System.out.print(temp.key+" ");
 * inorder(temp.right);
 * }
 * 
 * // Function to delete the given deepest node
 * // (d_node) in binary tree
 * static void deleteDeepest(Node root, Node d_node)
 * {
 * Queue<Node> q = new LinkedList<Node>();
 * q.add(root);
 * 
 * // Do level order traversal until last node
 * Node temp;
 * while(!q.isEmpty())
 * {
 * temp = q.peek();
 * q.remove();
 * 
 * if (temp.right!=null)
 * {
 * if (temp.right == d_node)
 * {
 * temp.right = null;
 * d_node = null;
 * return;
 * }
 * else
 * q.add(temp.right);
 * }
 * 
 * if (temp.left!=null)
 * {
 * if (temp.left == d_node)
 * {
 * temp.left=null;
 * d_node = null;
 * return;
 * }
 * else
 * q.add(temp.left);
 * }
 * }
 * }
 * 
 * // Function to delete element in binary tree
 * static void deletion(Node root, int key)
 * {
 * Queue<Node> q = new LinkedList<Node>();
 * q.add(root);
 * 
 * Node temp = null;
 * Node key_node = null;
 * 
 * // Do level order traversal to find deepest
 * // node(temp) and node to be deleted (key_node)
 * while (!q.isEmpty())
 * {
 * temp = q.peek();
 * q.remove();
 * 
 * if (temp.key == key)
 * key_node = temp;
 * 
 * if (temp.left!=null)
 * q.add(temp.left);
 * 
 * if (temp.right!=null)
 * q.add(temp.right);
 * }
 * 
 * int x = temp.key;
 * deleteDeepest(root, temp);
 * key_node.key = x;
 * }
 * 
 * // Driver code
 * public static void main(String args[])
 * {
 * // Create the following Binary Tree
 * // 10
 * // / \
 * // 11 9
 * // / \ / \
 * // 7 12 15 8
 * root = new Node(10);
 * root.left = new Node(11);
 * root.left.left = new Node(7);
 * root.left.right = new Node(12);
 * root.right = new Node(9);
 * root.right.left = new Node(15);
 * root.right.right = new Node(8);
 * 
 * System.out.print( "Inorder traversal before Deletion:");
 * inorder(root);
 * 
 * int key = 11;
 * deletion(root, key);
 * 
 * System.out.print("\nInorder traversal after Deletion:");
 * inorder(root);
 * }
 * }
 * 
 * Output:
 * Inorder traversal before Deletion: 7 11 12 10 15 9 8
 * Inorder traversal after Deletion: 7 8 12 10 15 9
 * 
 * 
 * 
 */