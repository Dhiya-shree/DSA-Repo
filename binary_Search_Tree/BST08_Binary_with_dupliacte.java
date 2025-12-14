package binary_Search_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class BSTNodeD{
	int key;int count;
	BSTNodeD left;BSTNodeD right;
	BSTNodeD(int d){
		key=d;
		left=null;
		right=null;
	   count=0;
	}
	
	void updateCount() {
		this.count=count+1;
	}
	
}
public class BST08_Binary_with_dupliacte {
	public static void main (String[] args) throws IOException {
		   
		
		//////////////////////////////////////////////////////////////////////READ INPUT 
	//BufferedReader br=new BufferedReader(
	  //  new InputStreamReader(System.in));
	    
	    //int Tree_count=Integer.parseInt(br.readLine());
	    
	    //while(Tree_count>0){
	        int tree_element=10;
	        String s="56 47 1 28 36 96 28 16 73 98";//1 2 3 2 1
	       // String to array 
	       int n=s.length();
	       if(n<2){
	           //no call direct ans 
	          System.out.println(-1);
	       }
	       else{
	           boolean setNot=true; BSTNodeD root=null;
	         int i=0;int val=0;int j=0;
	     	while(i<n) {
			if(s.charAt(i)!=' ') {
			val=val*10+(s.charAt(i)-48);
			}
			else {
			//	arr[j]=val;
			if(setNot){
			   root=new BSTNodeD(val);
			   setNot=false;
			}
			else{
			    InsertIterative(root,val); /////////////////////////MAKE TREE
			    ViewBST(root);
			    System.out.println();
			}
				val=0;
				j++;
			}
			i++;
		}
	     	if(j!=tree_element) {
		 InsertIterative(root,val);
	     	}
	     	
	     	System.out.println();
	     	
		ViewBST(root);
	      	//Ready with tree for element >2
	      	finAns=-1;
	      int small=SmallerCountOnRight(root);
	      
	       System.out.println(" Smaller on right "+finAns+"..."+small);
	
	        
	       }
	      //  System.out.println(tree_element);//+"..next int "+tree_element2);
	       // System.out.println("String ..."+s);
	      //   System.out.println("arr ..."+Arrays.toString(arr));
	      //  Tree_count--;
	    //}
	    
	}
	 static int finAns;
	private static int SmallerCountOnRight(BSTNodeD root) {
		if(root==null) {
			return 0;
		}
		
		int left=SmallerCountOnRight(root.left);
		
	//	System.out.println(root.key+" "+finAns+"...left"+left);
	//	if(root.times>1) {
		//	left=left+(root.times-1);
		//}
		if(left>finAns) {
			finAns=left;
	//	    System.out.println(" Set ..."+left);	
		}
		
		//For root - using times 
		left=left+1;
		SmallerCountOnRight(root.right);
		return left;
	}

	private static boolean InsertIterative(BSTNodeD root, int data) {
		// insert terative 
		
		
		while(root!=null) {
		    //Removing below condt to add duplicate in tree 
//			if(root.key==data) {
//			    root.updateCount();
//			}
			if(root.key<data) {
				if(root.right==null) {
					root.right=new BSTNodeD(data);
				    return true;
				}
				else {
					root=root.right;
				}
			}
			else {
				root.updateCount();
				if(root.left==null) {
					if(root.right!=null) {
						UpdateAllRight(root.right,data);
					}
					root.left=new BSTNodeD(data);
				    return true;
				}
				else {
					if(root.right!=null) {
						UpdateAllRight(root.right,data);
					}
					root=root.left;
				}
			}
		}
		
		return false;
	}
	private static void UpdateAllRight(BSTNodeD root,int data) {
		// update all right 
		
		if(root==null) {
			return;
		}
		if(root.key<data) {
			return;
		}
		
		root.updateCount();
		UpdateAllRight(root.left, data);
		UpdateAllRight(root.right, data);
		
	}
	static int maxCount;
	private static void ViewBST(BSTNodeD root) {
		if(root==null) {
			return;
		}
		maxCount=Math.max(maxCount,root.count);
		System.out.print(root.key+"-"+root.count+" ");
		ViewBST(root.left);
		System.out.print("|");
		ViewBST(root.right);
	}
	    
	
	
}
