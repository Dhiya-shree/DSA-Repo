package disjointSet_SegmentTree_Trie;

import java.util.Arrays;

/**
 * 
 * Segment Tree Data Structure 
 * 
 * Used for fixed sized arrays and used 
 * for operations :
 *      1) Range Query O LogN typically
 *           given start and end index , return value 
 *      2) Update a Value O LogN typically
 *           given index,value . Update val of the index 
 *  
 * Above operations on fixed type of array , 
 * where no of elements do not change .
 * 
 * Segment tree requires pre processing time fr building segment tree 
 * and auxillary space for storing the same .
 * Segment tree Time O N 
 *              Space O N 
 *        for array length N 
 * 
 * 	Ex : arr= 10,20,30,40,50
 *       getSum(0,3) - sum from 0 to 3 index val=100
 *       For multiple query above will be costly 
 *       For M sum query , time complexity=M*N 
 *       
 *       With preprocessing :
 *       arr2=10 20 60 100 150 
 *       getSum(1,3)= getSum(0,3)-getSum(0,1)=100-10=90
 *       For M sum query , time = N*1 
 * 
 * With preProcessing : Update query is costly 
 *       For updating value at 1 index 
 *       Need to make preprocess array again from i to N
 *   
 * For M update query :
 *   Without pre processing : Time = N * 1 
 *   With pre processing array maintenance ~ N*M 
 *   
 * To make it easy : Find the diff 
 *   arr= 10,20,30,40,50
 *   arr2=10 20 60 100 150 
 *  Change at index 1 20 to 60 , diff=40 
 *   arr= 10,60,30,40,50 
 *   For values from index 1 to n , add diff 40 in pre process array 
 *   arr2= 10,60,100,140,190
 *   
 *   
 *  More getSum query? Use pre processing .. else no use in using 
 *  
 *  Motivation for Segment Tree:
 *  
 *  If more getSum - pre processing best 
 *  If more update - no pre processing best 
 *  
 *  Consider below scenario :
 *  x/4 query of 1 type  O N
 *  3x/4 query of other type O 1
 *  
 *  Average time= x/4 * ON + 3x/4*O1  / x
 *              = O N 
 *              
 *  If 3/4 is update query , pick no pre processing 
 *  If 3/4 is Sum query , then use pre processing 
 *  
 *  But using segment tree , O Log N for both query 
 *  Only update - no pre processing O 1 
 *  Only getSum - use pre processing O N preprocess , O 1 
 *  Both update+getSum mix - use Segment tree
 *  
 *  Segment tree is actually an array 
 *  Segment tree similar to heap Data structure 
 *  N=5 
 *  arr= 10,20,30,40,50           SUM
 *                               (start,end) range 
 *         root---->  150
 *                   (0,4)
 *                 /       \
 *               60         90
 *             (0,2)        (3,4)
 *           /      \       /    \
 *          30      30     40     50
 *        (0,1)   (2,2)   (3,3)  (4,4)
 *        /    \
 *       10    20
 *     (0,0)  (1,1)
 *     
 *    Root - sum of all elements from first to last 
 *    Leaf - Single element 
 *    
 *  Building segment tree 
 *  
 *  Create root 
 *  Total elements= 2N-1
 *  N=5 5elements 
 *  Root =  sum of all =150 
 *  Divide elements into half ;
 *       first half for left 3 elements , next half for right 2
 *       
 *  Repeat process for left : 
 *     3 elements 
 *     root = sum = 10,20,30=60 
 *     left= 10,20
 *     right=30 done 
 *     
 *     Left tree
 *     root = sum 10,20 = 30 
 *     left =10 done 
 *     Right= 20 done 
 *  Repeat process for right :
 *     2 elements 
 *     root = 40,50 = sum = 90 
 *     left : 40 done 
 *     right : 50 done 
 *   
 *  Ex 2 : 
 *  N=6
 *  arr= 10,20,30,40,50,60          SUM
 *                               (start,end) range 
 *         root---->  210
 *                   (0,5)
 *                 /       \
 *               60         150
 *             (0,2)        (3,5)
 *           /      \       /    \
 *          30      30     90     60
 *        (0,1)   (2,2)   (3,4)  (5,5)
 *        /    \         /     \
 *       10    20       40      50 
 *     (0,0)  (1,1)    (3,3)   (4,4)
 *     
 *    Root - sum of all elements from first to last 
 *    Leaf - Single element 
 *    
 *  Building segment tree 
 *  
 *  Create root 
 *  Total elements= 2N-1
 *  N=5 5elements 
 *  Root =  sum of all =210 
 *  Divide elements into half ;
 *       first half for left 3 elements , next half for right 3
 *       
 *  Repeat process for left : 
 *     3 elements 
 *     root = sum = 10,20,30=60 
 *     left= 10,20
 *     right=30 done 
 *     
 *     Left tree
 *     root = sum 10,20 = 30 
 *     left =10 done 
 *     Right= 20 done 
 *  Repeat process for right :
 *     3 elements 
 *     root = 40,50,60 = sum = 150 
 *     left : 40,50  
 *     right : 60 done   
 *     Left Tree :
 *     root = 40,50=sum=90
 *     left : 40 done
 *     right : 50 done 
 *     
 *  
 *  For getSum range , traverse the segment tree
 *  For updation  from node till root need to update 
 *  
 *  Heap is different from Segment tree:
 *  
 *  Heap , Complete Binary Tree  all leaf same level 
 *  No GAPS 
 *  left i = 2i+1
 *  right i= 2i+2
 *  parent i = i-1/2
 *  
 *  Segment not a complete binary tree 
 *  GAPS are there 
 *  Different leaf 
 *              root
 *              /  \
 *             l1   r1
 *           /  \   |  \  
 *          l2  r2  X   X
 * X - Dummy nodes added 
 * To make the value as Complete binary tree 
 * And to apply below formula:
 *  left i = 2i+1
 *  right i= 2i+2
 *  parent i = i-1/2   
 *  
 * Gaps filled with dummy nodes , will never be accessed .
 * Arr = 10,20,30,40,50,60
 *         root---->  210   0 
 *                  (0,5) 
 *               /         \
 *            60             150      1 2 
 *          (0,2)           (3,5)
 *         /      \         /     \
 *       30       30       90      60    3 4 5 6
 *     (0,1)    (2,2)     (3,4)    (5,5)
 *    /    \    /   \     /     \     |  \
 *  10     20  X     X  40      50    X   X  X---> Dummy nodes   
 *(0,0)   (1,1)        (3,3)   (4,4)           7 8 9 10 11 12 13 14
 *                                                 X  X        X  X 
 * In array :
 *   0   1  2  3  4  5  6  7  8  9 10 11 12 13 14
 *  210 60 150 30 30 90 60 10 20 X X   0 50  X  X
 *  
 *  size of array = 2* 2^[log2N] -1
 *  n= 6 
 *  size= 2*2^(log 6)-1 ~ 2*2^3-1
 *      = 16-1=15 
 *     
 *  N=4,8,16,32,62 etc give complete binary tree 
 *  N= powee of 2 , 
 *  size of Array = 2 * N -1 ( 2^ log2N = 2^log 2^x= 2^x = N )
 *  
 *  Array size = 2 * smallest power of 2 greater than N -1 
 *  for 6 , power of 2 greater than 6=8 
 *  Array size= 2*8 -1 = 15 
 *  
 *  size of array = 2* 2^[log2N] -1
 *  Simple formula :    <4N 
 *    n=9        2* 2^log9 = 2 * 2^4 -1 = 31
 *  By using 4N (36) 
 *  
 *  
 */

/*
 *   Construction of Segment Tree 
 *   
 *   Given an array 
 *   I/P arr= 10,20,30,40
 *    Tree : 100,30,70,10,20,30 40
 *    
 *   i/p arr = 10,20,30,40,50,60 
 *    Tree : 210 60 50 30 30 90 60 10 20 X X 40 50 X X
 *    
 *   Recursively build left and right sub tree 
 *    
 *   BuildTree start,end,index start=0 end=n-1
 *   
 *   if start==end
 *      tree[idx]=arr[start]
 *      return arr[start]
 * 
 *   mid=start+end/2
 *   left = recur start,mid,2*idx+1
 *   right= recur mid+1,end,2*idx*2
 *   
 *   tree[idx]= left+right 
 *   return tree[idx]
 * 
 */
/**   
 *    
 *  Range Query 
 *  
 *  With the segment tree , retrive o/p for range queries 
 *  
 *  GetSum range Query 
 *  
 *  GetSum(2,3)=50 o/p=210
 *  arr=10,20,30,40
 *  
 *  GetSum( queryStart,queryEnd,Start=0,End=n-1,index=0 )
 *  queryStart,queryEnd-> user i/p range
 *  Start ,end - range of current node 
 *  index - index pf current node 
 *  
 *  
 *  GetSum recur :
 *  
 *   if End<Qstart or Start>QEnd
 *       return 0 
 *   
 *   if QStart<=Start && QEnd>=End
 *       return tree[idx]
 *       
 *   mid=start+end/2
 *   
 *   left=getSum(qs,qe,start,mid,2*idx+1)
 *   right=getSum(qs,qe,mid+1,end,2*idx+2)
 *   return left+right
 *   
 *  
 *  Height of Segment Tree =  O Log N 
 *  Work at every level = 4 C log N 
 *  At any level maximum number of nodes checked are 4 
 *  Thus at the very last level with height of O Log N 
 *         Time = 4 * LogN 
 *         Time = O Log N 
 *         
 *         
 *         
 * Update Query on segment Tree :
 *  
 * arr=10,20,30,40 
 * Tree= 100 30 70 10 20 30 40 
 * Update element in the array set 25 in pos 1 
 * New arr=10,25,30,40 
 * Same updations needs to be reflected on Segment Tree 
 * Updated Tree :
 * Tree * = 105 35 70 10 25 30 40 
 * 
 * From leaf till root needs to be changed .
 * 
 * 
 * Int diff= val-arr[i]
 * 
 * update st e id idx=0 diff id=index to place the value 
 * 
 * Recur :
 * 
 *     if(id<s || id>e) return 0;
 *     
 *      tree[idx]=tree[idx]+diff;
 *      
 *      if e>st 
 *      
 *      int mid=st+e/2;
 *      
 *      update st,mid,id,2*idx+1,diff
 *      
 *      update mid+1,e,id,2*idx+2,diff
 *      
 *      
 * 
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class DST06_Segment_Tree_Intro {

	public static void main(String[] args) {
		
		int arr[]= {10,20,30,40,50,60};
		int n=arr.length;
		
		// Tree Constructed 
		treeSize=4*n;
		//exact size 
		treeSize=((int) (Math.ceil(Math.log(n)/Math.log(2))))+1;
		treeSize=((int) Math.pow(treeSize,2)-1);
		
		segmentTree=new int[treeSize];
		ConstructSegmentTree(arr,n,0,n-1,0);//O N 
		System.out.println(Arrays.toString(segmentTree));
		
		
		int ans=RangeQuery_GetSum(2,5,0,n-1,0);
		System.out.println(" Ans for given range is "+ans);
		ans=GetSum_GoG(2,5,0,n-1,0);
		System.out.println(" Ans for given range is "+ans);
		
		
		int diff=25-arr[1];arr[1]=25;
		UpdateTree_GoG(diff,1,0,0,n-1);
		System.out.println(Arrays.toString(segmentTree));
		
		UpdateTree_Recur(25,1,0,0,n-1);  // O Log N 
		arr[1]=25;//set in array also 
		System.out.println(Arrays.toString(segmentTree));
		
	}
    private static void UpdateTree_GoG(int diff, int id, int idx, int st,
    		int e) {
		// update tree from root to leaf
    	if(id<st || id>e) {
    		return ;
    	}
    	
    	segmentTree[idx]=segmentTree[idx]+diff;
    	
    	if(e>st) {
    		int mid=(st+e)/2;
    		UpdateTree_GoG(diff, id , 2*idx+1, st,mid);
    		UpdateTree_GoG(diff,id, 2*idx+2, mid+1, e);
    	}
    
		
	}
	private static int UpdateTree_Recur(int val, int id,int idx,int st,int e) {
		//update tree from leaf to root 
    	
    	if(st==e && st==id) {
    		int diff=val-segmentTree[idx];
    		segmentTree[idx]=val;
    		return diff;
    	}
    	
    	if(st>e) {
    		return 0;
    	}
    	
    	int mid=st+e/2;int diff=0;
    	if(id<=mid) {
    		diff=UpdateTree_Recur(val,id,2*idx+1, st,mid);
    	}
    	else {
    		diff=UpdateTree_Recur(val,id,2*idx+2, mid+1,e);
    	}
    	
    	segmentTree[idx]=segmentTree[idx]+diff;
		return diff;
	}
	private static int GetSum_GoG(int qStart,int qEnd,int Start,int End,int idx) {
		// getSum
    //	qStart ....qEnd.. |Start .....End| ...qStart ....qEnd
   //              qEnd< Start   or   End>qStart
    	if(qEnd<Start || qStart>End) {
    		return 0;
    	}
    	
   //  |Start........qStart......End|.....qEnd
   //           left half managed     right half other call 
    	if(qStart<=Start && qEnd>=End) {
    		return segmentTree[idx];
    	}
    	
    	int mid=Start+End/2;
    	int left=GetSum_GoG(qStart, qEnd, Start,mid, 2*idx+1);
    	int right=GetSum_GoG(qStart, qEnd,mid+1, End, 2*idx+2);
    	
		return left+right;
	}
	private static int RangeQuery_GetSum(int qStart, int qEnd, int Start, int End, int CurrIdx) {
		// Range query get sum 
    	if(Start>End||CurrIdx>treeSize) {
    		return 0;
    	}
    	
    	
    	System.out.println(CurrIdx+" "+segmentTree[CurrIdx]);
    	if(Start==qStart && End==qEnd) {
    		return segmentTree[CurrIdx];
    	}
    	
    	int mid=Start+End/2;int ans=0;
    	System.out.println(mid);
    	if(qStart<=mid) {
    		System.out.println(qStart+" "+(mid)+" Curr "+Start+" "+mid);
    		ans=RangeQuery_GetSum(qStart, mid, Start,mid,CurrIdx*2+1);
    	}
    	if(mid<qEnd) {
    		System.out.println((mid+1)+" "+(qEnd)+" Curr "+Start+" "+End);
    		
    		ans=ans+RangeQuery_GetSum(mid+1, qEnd,mid+1,End,CurrIdx*2+2);
    	}
		return ans;
	}
	static int segmentTree[];static int treeSize;
	private static int ConstructSegmentTree(int[] arr, int n, int segmentStart,int segmentEnd,int treeIdx) {
		// Construct segment tree   range start,end,  index 
		// start with 0 to 
		
		if(treeIdx>=treeSize || segmentStart>segmentEnd) {
			return 0;
		}
		if(segmentEnd==segmentStart && segmentStart<n) {
		   segmentTree[treeIdx]=arr[segmentStart];
		  // System.out.println(arr[segmentStart]+" "+treeIdx+" ss-se "+segmentStart+" "+segmentEnd+"  ");
		   return segmentTree[treeIdx];
	     }
		
		
	    int left=segmentStart,right=segmentEnd;
		int mid=(left+right)/2;
		left=ConstructSegmentTree(arr, n, segmentStart, mid, 2*treeIdx+1);
		right=ConstructSegmentTree(arr, n, mid+1,segmentEnd, 2*treeIdx+2);
		
		
		segmentTree[treeIdx]=left+right;
		
		return segmentTree[treeIdx] ;
	}
}
