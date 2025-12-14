package disjointSet_SegmentTree_Trie;

import java.util.Arrays;

/**
 * 
 * Binary Indexed Tree : Introduction 
 * 
 * Other name : Ferwick Tree 
 * 
 * Used for fixed input array and multiple queries 
 *     1) Prefix operations - sum , product , xor , or etc 
 *     2) Update a value 
 * 
 * It is actually an array but the concept is Tree based 
 * 
 * It requires O NLogN preProcessing and O N auxillary space 
 * 
 * Segmented tree / Heap can only have two children
 * Binary Indexed tree can have any number of children 
 * 
 * 
 * Segmented tree  - getSum , update O Log N  actually O 4Log N 
 *   Range Query takes two index and gives o/p 
 *   Space used = 4*N 
 * 
 * Binary Indexed Tree - getSum/Or/XOR , update - O Log N <--
 * Binary Indexed Tree Pre processing : O N Log N
 *            Space used for tree is  : O N 
 *   Range Query takes two index and gives o/p for prefix also 
 *   Range Query 0-5 0-3 takes sum for 3 digit prefix from 0 to N 
 *   
 * Binary Indexed tree less space , less time and simple code than segment tree
 *
 * RangeSum(i,j) - sum of range from i to j 
 *        = prefix dum 0toj - prefix sum 0-i
 *   
 * Range Max Query - Maximum value in a range 
 * Range MIN Query - Minimum value in a range 
 * Above can be done only by Segmented tree and not a Binary Indexed Tree 
 * 
 */
/*
 *  Example Problem :
 *  
 *  i/p arr= 10,20,30,40,50,60
 *  Consider below operations :
 *  getSumum(2) sum upto 2   :60
 *  getSum(4)                :150
 *  Update(3,45)        update index 3 
 *  getSum(4)                :155
 *  getSum(5)                :215
 *  
 *  Method 1: Array 
 *  getSum - for loop O N 
 *  Update - O 1 arr[id]=newVal
 *  If more update query , best T= ON 
 *  
 *  Method 2: Prefix sum 
 *  Create prefix sum array 
 *  prefix sum = 10,30,60,100,150,210 
 *  getSum = prefixSum i       O 1 
 *  update = change from prefix sum i to N   O N time 
 *  If more sum it will be good , best T with both sum and update = O N 
 *  
 *  Method 3 : Segment Tree 
 *  getSum - O Log n , Upper bound : 4 log N operations 
 *  Updare - O log n , upper bound :  log N opeartions
 *  sum and update , best = O Log N 
 *  Space = 4 N 
 *  
 *  Problem :
 *  getSum i = getSum(0,i) in segment tree 
 *  
 *  More space +slightly more operation 
 *  
 *  Method 4 : Binary indexed tree 
 *  
 * 
 *   
 * 
 */

/**
 *
 * Binary Indexed Tree :
 * 
 * 
 * Every number can be expressed as sum of power of 2 .
 * 
 * 14= 2^3 + 2^2 + 2^1 14 can be divided into 3 groups , with no of elements = power of 2 
 * 10= 2^3 + 2^1
 * 5 = 2^2 + 2^0
 * 
 * 
 * GetSum (i) = sum of numbers from arr 0 to arr[i]
 * 
 * getSum(13)= sum of numbers from arr[0] to arr[13] (14 elements )
 *           = arr 0 + arr1 +......+arr 13
 *           divide the elements into power of 2 
 *             7          11          13
 *           = E arr i +  E  arr i  + E  arr[i]
 *            i=0        i=8         i=12
 *      14=    8      +   4       +    2
 *             2^3        2^2           2^1   ---> no of elements 
 *  
 *  We will have divided binary indexed tree readily available ,
 *   sum of arr 0 to 7; 
 *   sum of arr 8 to 11;
 *   sum of arr 12 to 13;
 * 
 *  Total binary bits in a number < log N 
 * 
 * 
 * Ex : arr= 10,20,30,40,50,60,70,80,90,100
 * array =   - , 10  ,20   ,30   ,40   ,50  ,60   ,70   , 80  ,90   ,100
 * Index =   0    1   2*    3     4*    5    6     7      8*    9     10    *--> power of 2  
 * btSum = root, 0-0 , 0-1 ,2-2 , 0-3 , 4-4 , 4-5 , 6-6 , 0-7 , 8-8 , 8-9  
 * btTree=  0  , 10 , 30  , 30  , 100 ,  50 , 110 , 70 , 360 , 90  , 190 
 * 
 * 
 * 2^0 - only 1 element
 * 2^1 - two element 
 * 2^2 - 4 element , divide as 2^1 2^1- 2^0 and curr 
 *       2*,3,4 divide as 2^0 and 4 
 * 2^3 - 8 element , divide as 
 *      4*,5,6,7,8  - 2^1 , 2^0 curr 
 * 2^4 - 16 element divide as 
 *      8*,9,10,11,12,13,14,15,16 as 8* ,  9,10,11,12 , 13,14 , 15 , curr
 *       as 8* ,    9,10 11 12  ,  13,14  , 15 , curr 16 
 *       
 *       
 * Binary Indexed Tree 
 * n=10 -- 
 * root branch , till 1 , 2 , 4, 8 ...
 *                     root 0 
 *                /    |      |      \
 *              0-0   0-1    0-3      0-7  
 *              10     30    100      360 
 *                    /    /    \      |  \
 *                  2-2   4-4   4-5   8-8  8-9
 *                  30     50   110    90   190 
 *                               |
 *                              6-6
 *                              70
 *                     
 * 
 *  getSum(5) = sum of ele 0 to 5 
 *            = elements N=6 = 2^4 + 2^1
 *            = sum 0 to 4 + 5 to 6 
 *            =  Bt[4]   + Bt[6]
 *            =   100 + 110 
 *            = 210
 * 
 * 
 *  getSum(4)= sum of 5 elements  2^4 + 2^0 
 *           = sum of 0 to 4 + element 5 
 *           = bt[4]+bt[5]
 *           = 100+50
 *           =150 
 * 
 *  getSum(6) = sum from 0 to 6 , elements 7= 2^2 + 2^1+ 2^0 
 *            = sum of first 4 elements + sum of next 2 + ind 6 element 
 *            = bt[4]+bt[6]+bt[7]
 *            = 100+110+70
 *            = 280 
 *           

 *
 */


/*
 * 
 * Construction of Binary Indexed tree 
 * 
 * 
 * Divide into pair 
 *   1,2,4,8,16......
 *   
 * Elements 
 *  1,2,.,4,. . . ,8 , . . . . . . . . ,16....
 *      3   5 6 7      9 10 ....  
 *      
 *  Save additional elements , under prev power of two 
 *  As a tree 
 *  
 *  1 , 2 , 4 , 8 
 *      |   |   |
 *      3   5   9,10,11,12,13,14,15 
 *         6,7
 *     
 *  1 - x
 *  2 - 3 
 *  4 - 5,6,7
 *  8 - 9,10,11,12,13,14,15 
 *  16- 17,18.....
 *         
 * Divide further the array of elements under every sub tree 
 * 
 *  1 , 2 , 4 ,         8     , 16 
 *  |   |   |           |
 *  x   3   n3         n7     
 *         5,6,7     /    |      \
 *         5,11,7   2^0   2^1     2^2
 *         /   |    9     19       42
 *        5   11          |      13,14,15
 *             |          11     13,27,15
 *             7                 /      \
 *                              13      27 
 *                                      | 
 *                                      15
 *                                      
 *  array = 1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16
 *  BT2pow= 1  3     10          36           
 *  BTIarr= 1  3  3  10 5  11 7  36 9 19 11 42 13 27 15 136  
 *  With dummy node 
 *  BITree= x 1 3 3 10 5 11 7 36 9 19 11 42 13 27 15 136 
 *  
 *  During getsum for i , actually check for getSum i+1
 *  
 * 
 * 
 */

/**
 * 
 * Construction of Binary Index Tree 
 * 
 * 
 * array = 10,20,30,40 
 *       0  1 2  3  4
 * BIT = x,10,30,30,100
 * 
 *            x
 *         /  |  \
 *        1   2   4 
 *       10  30   100
 *            |
 *            30(3)
 *  
 * 
 * Binary tree construction 
 * 
 * find sum and fill places of power of 2 
 * 
 * if n==1 return arr[1]=arr0 arr[i]
 * if n==2 return arr[2] arr0 arr[i] arr1 arr[i]+arr[i+1]
 * if n==3 return arr0 arri , arr1 arri + arri+1 , arr2 arri+2
 * 
 * 
 * for int i=0 to n   2^i<n
 *    call BTI 
 *    
 *    
 * Best way to create BIT   === use "Update"
 * 
 * 
 * Construt arr,n 
 * {
 * arr= 10,20,30,40,50 
 * n=5 
 * 
 * int bti[]=new int[n+1]
 * bti0 - dummy 
 * 
 * Array.fill(bti,0)
 * 
 * for(int i=0;i<n;i++){
 *   
 *   UpdateNoDiff(i,arr[i])
 * 
 * }
 * }
 * 
 *  //update but not with diff , actual value 
 * UpdateNoDiff(i,x){
 *      i=i+1 //dummy cos 
 *      while i<=n
 *        bti[i]=bti[i]+x
 *        i= i + (i& -i)
 *        
 *   return  }
 * 
 */

/*
 * 
 * Prefix sum implementation 
 * 
 * 
 * Arr = 10,20,30,40,50,60,70,80,90
 * BT =  10,30,30,100,50,110,70,360,90
 * BTi=x,1 , 2  3 4   5   6   7  8   9
 * 
 * 
 *                rootX
 *           /  |   |    \
 *          1   2   4     8
 *         10   30  100   360
 *              |   |  \     \ 
 *              3   5   6     9 
 *              30  50  110   90
 *                       |
 *                       7
 *                       70
 * 
 * Value of getSum i 
 * 
 * Bcos of dummy : i=i+1
 * 
 * Result = BITree[i]+ BITree[parent[i]]+  BITree[Parent[parent[i]]]+ ... + till we reach dummy node x  
 * 
 * Ex , getSum(6) till 70 in original array 
 *     With BITree 
 *     i=i+1 ; i=7 
 *     getSum(7)= BIT[7]+ BIT[parent[7]]+ BIT[parent[parent[7]];
 *              = BIT 7 + BIT 6 + BIT 4 
 *              = 70 + 110 + 100
 *              = 180 
 *              
 *              
 *  Parent of an element i :
 *  Parent of i = i - (i & (-i))
 *  
 *                7 binary rep = 0 1 1 1
 *  parent of 7 = 6 Binary rep = 0 1 1 0 
 *  parent of 6 = 4 Binary rep = 0 1 0 0
 *  
 *  llly 
 *  For  i=9 binary rep = 1 0 0 1
 *  parent 8 binary rep = 1 0 0 0
 *    
 *  Thus ....
 *  Turn off the last set bit of a number to get parent 
 *  Last set bit = i& -i 
 *  
 *  parent = i - last set bit 
 *         = i - ( i & -i)
 *         
 *         
 *  For i=9 
 *      i=9  1 0 0 1
 *     i=-9  0 1 1 1
 *     i&-1  0 0 0 1
 *     
 * Last set bit = 0 0 0 1
 * 
 * For turning off last set bit 
 *         i = 9   1 0 0 1
 *  Last set bit   0 0 0 1
 *  i - (i & -i)   1 0 0 0 
 *  
 *  Parent of 9 = 8 
 *  Parent of i = i - ( i & -i)
 *  
 *  
 *  getSum(int i)
 *  
 *  i=i+1 : for dummy 
 *  int res=0 
 *  
 *  while(i>0) : i> dummy 
 *    res=res+ BT[i]
 *    i= i - (i& -i) : parent index 
 *  return res  
 *  
 * 
 */

/** 
 * 
 * Update in Binary Indexed Tree
 * 
 * Arr = 10,20,30,40,50,60,70,80,90
 * BT =  10,30,30,100,50,110,70,360,90
 * BTi=x,1 , 2  3 4   5   6   7  8   9
 * 
 * 
 *                rootX
 *           /  |   |    \
 *          1   2   4     8
 *         10   30  100   360
 *              |   |  \     \ 
 *              3   5   6     9 
 *              30  50  110   90
 *                       |
 *                       7
 *                       70 
 * 
 *  Update(4,55) - update index 4 of original array with 55
 *  
 *  New Arr = 10,20,30, 40, 55, 60, 70, 80, 90 ,100 , 110 
 *  New BTI = 10,30,30,100, 55,115, 70,365, 90 ,190 , 110
 *  BTindex=x,1 , 2  3  4    5   6   7  8   9  , 10 , 11
 *   
 *   
 *  For updating index 4 original array arr with 55 
 *  bti changes inedx from i+1=5 
 *  Changes needed in BTI in pos = 5 , 6, 8 
 *  
 *  llly 
 *  Update(2,35) -bti index = 5 ,  need changes in BTI pos : 3,4,8 
 *  Update(8,95) -bti index = 9 ,  need changes in BTI pos : 9,10 
 *  
 *  
 *  Update operation 
 *  
 *  i=i+1 Bcos of presence of dummy 
 *  
 *  In tree , in same level of a subtree all nodes next to curr need changes 
 *  Parent of i need changes 
 *  Loop above till reaches ... dummy 
 *  
 *  Relationship between all nodes that need changes 
 *  
 *  
 *  For update(4,55)
 *  i=i+1= 5
 *  Changes in 5,6,8   
 *   5 binary rep= 0 1 0 1
 *   6 binary rep= 0 1 1 0 
 *   8 binary rep= 1 0 0 0
 *   
 *  Next pos to change can be obtained from adding 1 to last set bit 
 *  
 *  Last set bit = i& -i 
 *     i= 5 0 1 0 1
 *     i=-5 1 0 1 1
 *  i & -i= 0 0 0 1    works because negative of number = 2s complement
 *  
 *  Add last set bit to the number 
 *    i 5 = 0 1 0 1
 *  i &-i = 0 1 0 1
 *    Add = 0 1 1 0 = 6 
 *    
 *  llly : For i=6 
 *  6 = 0 1 1 0 
 * -6 = 1 0 1 0 
 *    last set bit = 0 0 1 0 
 *  Add last set bit with i :
 *      6 0 1 1 0 
 *  6 &-6 0 0 1 0
 *   add  1 0 0 0 = 8 
 *   
 *   
 *  Thus by adding last set bit to number till pos<=N we can get pos to update 
 *  
 *  
 *  Update (int i , int newX)
 * 
 *  diff= arr[i] - newX
 *  arr[i]= newX
 *  
 *  i=i+1 // cos dummy 
 *  
 *  while( i<=n)
 *     bti[i] bti[i]+diff   // make change 
 *     i= i+ ( i&-i)   // next change pos 
 * 
 *  return 
 *  
 *  Ex :
 *  Update 1,25 
 *  
 *  i=i+1= 2 
 *  Change in pos for : 2,4,8 
 *  2= 0010 
 *  Add last set bit = 0010+0010= 0100 => 4 
 *  Add last set bit = 0100+0100= 1000 => 8 
 *  
 *  
 *  
 * @author shree
 *
 */
public class DST07_Binary_Indexed_Tree {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int n=arr.length;
		int BTI[]=new int[n+1];
		
		
		ConstructBTI(arr,n,BTI);
		System.out.println(" Array "+Arrays.toString(arr));
		System.out.println(" Binary Indexed Tree "+Arrays.toString(BTI));
		
		int s=getSum(9,BTI,n);
		System.out.println(" Sum till = "+s);
		
		Update(4,50,BTI,arr,n);
		System.out.println(" Update BTI "+Arrays.toString(BTI));
	}

	private static void Update(int id, int ele, int[] bTI, int[] arr, int n) {
		//update 
		
		if(id>=n) {
			System.out.println(" Out of index ");
			return;
		}
		
		//MUST to do before id+1
		int diff=ele-arr[id];
		arr[id]=ele;
		
		
		id=id+1;//cos dummy 
		
		while(id<=n) {
			bTI[id]=bTI[id]+diff;
			id=id+(id& -id);
		}
		return;
	}

	private static int getSum(int id, int[] bTI, int n) {
		// get sum 
		if(id>=n) {
			System.out.println(" Out of index ");
			return -1;
		}
		
		id=id+1; //dummy 
		int res=0;
		while(id>0) {
			res=bTI[id]+res;
			id=id- (id& -id);
		}
		
		return res;
	}

	private static void ConstructBTI(int[] arr, int n, int[] bTI) {
		// construct bti 
		class Local{
        private static void updateNoDiff(int x,int j,int[] bTI,int n) {
			j=j+1;
			while(j<=n) {
				bTI[j]=bTI[j]+x;
				j=j+(j&-j);
			}
		}
     	}
		
		Arrays.fill(bTI,0);
		
		for(int i=0;i<n;i++) {
			Local.updateNoDiff(arr[i],i,bTI,n);
		}
	
	}
}

