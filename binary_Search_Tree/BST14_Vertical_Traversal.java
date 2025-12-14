package binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * Vertical traversal of BST 
 * 
 * 
 * Vertical distance = same horizontal distance from leftmost node
 * 
 * Nodes with same vertical distance is 
 * 
 * Nodes that are at same distance from left most node
 * 
 * 
 * To find horizontal distance 
 * 
 * Take root distance as 0 .
 * left child = root distance -1 
 * right child= root distance +1 
 * 
 *          55(0)
 *         /   \
 *   (-1)30     70(+1)
 *     /   \   /  \
 *    10   40 50  80(+2) 
 *  (-2)  (0) (0)  \   
 *                  90 
 *                  (+3)
 *    
 * Use any treaversal and put distance
 * 
 * 
 * Pre order traversal will not work to maintain horizontal order 
 * 
 * Level order for root first 
 *  + Queue<Class wrapper(Node,distance)>
 * 
 * 
 * Time Complexity: O(N log N). The hashing based solution can be considered as O(N) under the assumption that we have a good hashing function that allows insertion and retrieval operations in O(1) time. In the above C++ implementation, map of STL is used. map in STL is typically implemented using a Self-Balancing Binary Search Tree where all operations take O(Log N) time. 
 * Auxiliary Space: O(N)
 * 
 * @author shree
 *
 *
 */
//Common and must for BOTTOM and TOP View 
class WrapNodeDistance{
	BSTNode root;
	int distance;
	WrapNodeDistance(BSTNode node,int d) {
		root=node;
		distance=d;
	}
	
}
public class BST14_Vertical_Traversal {

	public static void main(String[] args) {
		// vertical traversal 
		
		int arr[]= {5,3,4,8,9,6,7,1,2,0,10};
		BSTNode root=BST02_operation_medium.ConstructBST(arr);
		System.out.println(" BST ");
		BST02_operation_medium.ViewBST(root);
		System.out.println(" Vertical Traversal ");
		TMap=new TreeMap<>();
		int distance=0;// root start with 0
		//Below will not work to maintain vertical order 
		VerticalTraversal(root,distance);

		System.out.println(" TMAP : "+TMap.toString());
	    Set<Integer> set=TMap.keySet();
	    inBtw=new ArrayList<>();
	    for(Integer x:set) {
	    	inBtw.addAll(TMap.get(x));
	    }
	
	    System.out.println(" Final array ");
	    System.out.println(inBtw.toString());
       //Efficient solution 
	    
	    vTraversal(root);
	    
	    //Level order traversal 
	    inBtw=new ArrayList<>();
	    TMap=new TreeMap<>();
	    LevelOrderVerticalTraversal(root,distance);
	    inBtw=new ArrayList<>();
	    Set<Integer> setu=TMap.keySet();
	    inBtw=new ArrayList<>();
	    for(Integer x:setu) {
	    	inBtw.addAll(TMap.get(x));
	    }
	
	    System.out.println(" Final array ");
	    System.out.println(inBtw.toString());
	    
	}

	private static void LevelOrderVerticalTraversal(BSTNode root, int distance) {
		// level order traversal 
		
		Queue<WrapNodeDistance> q=new ArrayDeque<>();
		q.offer(new WrapNodeDistance(root,distance));
		int count=0;
		BSTNode curr=null;
		int d=0;
		while(!q.isEmpty()) {
			count=q.size();
			for(int i=0;i<count;i++) {
				curr=q.peek().root;
				d=q.poll().distance;
				// Add the root 
				if(!TMap.isEmpty() && TMap.containsKey(d)) {
					inBtw=TMap.get(d);
					inBtw.add(curr.data);
					TMap.put(d, inBtw);
				}
				else {
					inBtw=new ArrayList<>();
					inBtw.add(curr.data);
					TMap.put(d, inBtw);
				}
				
				if(curr.left!=null) {
					q.offer(new WrapNodeDistance(curr.left, d-1));
				}
				if(curr.right!=null) {
					q.offer(new WrapNodeDistance(curr.right, d+1));
				}
			}
			
		}
		
	}

	static ArrayList<Integer> inBtw;
	static TreeMap<Integer,ArrayList<Integer>> TMap;
	private static void VerticalTraversal(BSTNode root, int distance) {
		// root distance d 
		// left - d-1
		// right - d+1
		
		if(root==null) {
			return;
		}
		// Pre order - root left then right 
		
		if(TMap.containsKey(distance)) {
			inBtw=TMap.get(distance);
			inBtw.add(root.data);
			TMap.put(distance, inBtw);
		}
		else {
			inBtw=new ArrayList<>();
			inBtw.add(root.data);
			TMap.put(distance, inBtw);
		}
		
		
		
		VerticalTraversal(root.left, distance-1);
		VerticalTraversal(root.right, distance+1);
	}

	

     private static void vTraversal(BSTNode root){
	        Queue<PairBSTVertical> q=new LinkedList<>();
	        Map<Integer,ArrayList<Integer>> mp=new TreeMap<>();
	        q.add(new PairBSTVertical(root,0));
	        while(q.isEmpty()==false){
	        	PairBSTVertical p=q.poll();
	            BSTNode curr=p.BSTNode;
	            int hd=p.hd;
	            if(mp.containsKey(hd))
	                mp.get(hd).add(curr.key);
	            else{
	                ArrayList<Integer> al=new ArrayList<>();
	                al.add(curr.key);
	                mp.put(hd,al);
	            }
	            if(curr.left!=null)
	                q.add(new PairBSTVertical(curr.left,hd-1));
	            if(curr.right!=null)
	                q.add(new PairBSTVertical(curr.right,hd+1));
	        }
	        for(Map.Entry<Integer,ArrayList<Integer>> p:mp.entrySet()){
	            ArrayList<Integer> al=p.getValue();
	            for(int x: al)
	                System.out.print(x+" ");
	            System.out.println();
	        }
	    }
	    
}

class PairBSTVertical{
    BSTNode BSTNode;
    int hd;
    PairBSTVertical(BSTNode n,int h){BSTNode=n;hd=h;}
}
