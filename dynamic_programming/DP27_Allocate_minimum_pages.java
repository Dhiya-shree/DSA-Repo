package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Allocate minimum pages :
 * 
 * Given:
 * An array of no of pages in books and K number of students 
 * K number of students need to read all the books 
 * Rules :
 * Only contiguous pages and books can be alloacted  
 * 
 * Find:
 * Minimize the maximum pages allocated 
 * 

 * 
 * Only contiguous pages can be read /allocated 
 * 
 * Ex arr={10,20,30,40}
 *    K=2 
 *    
 *  Book1 10 page , Book2 20 page , Book3 30 page , Book4 40 page 
 *  Student 2 = student A and B 
 *  
 *  Student A , can not read 10 pages in book1 and 10 pages in Book2 
 *  Only Contiguous pages can be read !!!!!!
 *  
 *  Student A , can not read Book1 and Book4 
 *  Only Contiguous pages can be read !!!!!!
 *  For reading Book1 and Book4 , Student A has to read Book1-->Book2-->Book3-->Book4
 *  
 *  For 4 books and 2 student :
 *  
 *  Possible COMBO :
 *  
 *  Student A can read 0  = 0 pages 
 *  Student B can read book 1 & book 2 & book 3 & book 4 = 100 pages 
 *  Maximu number of pages alloacted = 100
 *   
 *  Student A can read book 1  = 10 pages 
 *  Student B can read book 2 & book 3 & book 4 = 90 pages 
 *  Maximu number of pages alloacted = 90
 *  
 *  Student A can read book 1 & book 2 = 30 pages 
 *  Student B can read book 3 & book 4 = 70 pages 
 *  Maximu number of pages alloacted = 70
 * 
 *  Student A can read book 1 & book 2  & book 3= 60 pages 
 *  Student B can read book 4 = 40 pages 
 *  Maximum number of pages alloacted = 60
 *  
 *  Student A can read book 1 & book 2  & book 3 & book 4= 100 pages 
 *  Student B can read 0 book = 40 pages 
 *  Maximum number of pages alloacted = 100
 *  
 *  Minimum of (Maximum number of pages)= 60 
 * 
 *  arr={10,20,30,40}   O/P : 60 
 *    K=2 
 *    
 *    
 *  Special case :
 *  If K=1 , only 1 student need to read all books 
 *  o/p = sum of all pages 
 *  
 *  If Number of book=1 , enough if only 1 student read it !!!
 *  o/p = pages in the single book
 *  
 *  
 *  Recursion example 
 *              
 *               WRONG !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *                 array of booka  n=4  1 2 3 4
 *             /      |        |        |       \
 *       |1234    1|234      12|34   123|4       |1234   studentA|staudentB 
 *      0-sum    sum-1   sum-sum12  sum-sum123   sum-0
 *              
 * 
 * Naive Recursion :
 * 
 * Xn books 
 * x0|x1|x2.....xi-1|xi|......|xn-1
 * 
 * Choose K-1 cuts out of n-1 cuts shown above 
 * 1|2|3|4
 * n=4
 * n-1=3 cuts available 
 * k=2
 * k-1=1 choose 1 cut out of 3 available cuts 
 * 
 *  
 * Total ways : n-1 C 
 *                   k-1
 * 
 * ex: 10,20,30,40 
 * cuts available : 10|20|30|40
 * Cuts to choose =1 
 * Minimized max pages 
 *           10 20 30 | 40 
 *           
 * Xn books 
 * x0|x1|x2.....xi-1|xi|......|xn-1
 * Consider first cut at i , then :
 * x0|x1|x2.....xi-1|<<1st cut>>|xi|......|xn-1
 * Recursion for 0 to K-1 
 * Recursion for k to n
 * 
 * Recursion   exponential time complexity 
 * 
 * RecurPages arr,n,k
 * 
 * if k==1 
 *   1 student sum of array from 0 to n-1
 * 
 * if n==1 
 *   return arr[0] 1 book 
 *   
 * int res=min value 
 * int min=max value 
 * for i=1 to n 
 *   // student with maximum value 
 *   res=max of minpages arr,i,k-1 & sum arr,i,n-1
 *   //minimum of maximum value 
 *   min=min of min,res 
 *   
 * return min 
 * 
 *  First cutat i :
 *        arr0 , arr1 ..... arri-1 | arri....arr n-1
 *   use remaining cut in first half   sum the remaining for ans 
 * 
 * K=3
 * First cut 
 *       arr0 arr1.... arri-1 | arri to arrN
 *                 |              sum of arr
 *          Make best second cut  K=2
 *          arr0 arr1 ......arrn-1  i as N 
 *          arr0 arr1 ...arri-1 | arri arrN  
 *          make best third cut     sum of arr
 *           |
 *           K=1 
 *           sum of array stop 
 *           
 *  As continguous allocation to ways to do :
 *  1) Demonstrated above 
 *     Give the last part to current student 
 *     Recur for first part for remaining studeny 
 *     
 *  2) Give the contiguous first part to current student]
 *      arr0 arr1 ... arri-1 sum= student A
 *     Recur the last part for remaining sudents B and C
 *     
 *  
 * Cases :
 *                   n-1
 *  MP (n,k) = min ( MAX (MP(i,k-1), sum(arr,i,n-1)) ) 
 *                   i=1
 *                   
 *  MP(1,K) = arr[0]
 *  MP(N,1) = sum of 0 to n-1
 * 
 * 
 * Recursion tree :
 *                  MP n,k    
 *   /                 |                 \       Make cut at 0,1,......before i | ith value to student 
 * MP 1,k-1       MP n-2,K-1          MP n-1,k-1
 *              /          \          |        \         \
 *       MP 1,K-2    MP n-3,k-2  MP 1,k-2   MPn-3,k-2    MP n-2,K-2 ...
 *                    overlap subproblem 
 *                    
 *  Dynamic Solution :
 *  
 *  table[k+1][n+1]
 *  table ij = minimum pages for i people and j books 
 *  
 *  table ij : if i==0 sum arr,0,j-1
 *             if j==1 K=1 arr[0]  at j==0 
 *             else      j-1
 *                min of MAX { table[i-1],[j]  , sum(p,j-1) }
 *                       x=1
 *  arr= 10,20,30,40 
 *  K=2 
 *  n\k  1   2     3      4
 *  k=1 10   20    30     40 
 *  k=2 10   20    30     60 
 *   
 *  table 1,1 1,2 1,3 1,4 sum of books 
 *  table 2,1 2 students 1 book , ans=1 book pages 
 *  table 2,2 at k=2 and books =2 each student 1 book , max pages=20 
 *     table 2,2 = min ( max table 1,2 ; sum 1,1)
 *               =   max of 10,20 = 20 
 *  At table 2,3
 *  Books=3 student=2 book pages 10,20,30 best to 10,20 and 30 . max pages=30
 *      table 2,3 = min of 
 *                    k=1  1) table 1,1 , sum 1,2 =10,50 = 50
 *                    k=2  1) table 1,2  , sum 2,2 =30,30 =30
 *                = min of 50,30 = 30 
 *  table 2,4
 *  Ans :
 *  Books =4 student=2 
 *  table 2,4 = min of 
 *                K=1 Max table 1,1 sum 1,4 = 10,90 = 90
 *                K=2 Max table 1,2 sum 2,4 = 30,70 = 70
 *                K=3 Max table 1,3 sum 3,4 = 60,40 = 60
 *            = min of 90,70,60 
 *      table 2,4 = 60
 * 
 * 
 * 
 * Table 
 * Space N+ N^K
 * time : O N^2 * K Time   ... Advanced use sum array 
 * 
 * 
 * table [k][n]
 * sumTill[n] sumTill i-. gives sum from 0,1,2,3...i 
 * 
 * for i: 0 to k no of students 
 * 
 *   for j: 0 to n no of books 
 *   
 *   if i==1  // only 1 student , let that student read all 
 *      sumTill[i]=sumTill[i-1]+arr[i]
 *      table ij= sumTill[i]\
 *   else if j==0  // only 1 book 
 *       table ij= book[j] 
 *   else 
 *      for x : 0 to j-1   // x=j no sense , for 1 student we are not giving any work then
 *         
 *          firstHalf = table i-1 , x remaining x books read best by i-1 students 
 *          currentCut = sum of x to j , curr studentreads remaining book pages 
 *                     = sumTill j - sumTill x 
 *          maxPages = maximum of currentCut, FirstHalf 
 *          minPages= min f minPages,maxPages
 *          
 *      table ij= min 
 *      
 *   return table k-1,n-1
 *
 *
 *  Binary based solution 
 *  
 *  Time = n log sum 
 *  
 *  if sum>>> , then binary solution very slow 
 *  
 *  Check arr[i] before picking one 
 * 
 * 
 * @author shree
 *
 */
public class DP27_Allocate_minimum_pages {

	public static void main(String[] args) {
		
		int pages[]= {15,10 ,19 ,10 ,5 ,18, 7}; //{10,20,30,40};
		int n=pages.length;
		int k=5;
		
		//Recur 
		int sol=MinPage_Recur(pages,n-1,k);
		System.out.println(" Recur sol is "+sol);
		
		//Memo 
		int memo[][]=new int[k+1][n];
		sol=MinPage_Memo(pages,n-1,k,memo);
		System.out.println(" Memo sol is "+sol);
		for(int i=0;i<k+1;i++) {
			System.out.println("Memo "+Arrays.toString(memo[i]));
		}
		
		sol=MinPage_Table(pages,n,k);
		System.out.println(" Table sol is "+sol);
	}

	private static int MinPage_Table(int[] arr, int n,int k) {
		// use table 
		int sum=0;
		int table[][]=new int[k][n];
		int sumArr[]=new int[n];
		// no of students 
		for(int i=0;i<k;i++) {
			
			//No of books 
			for(int j=0;j<n;j++) {
				
				if(i==0) {  // Only 1 student , student will ead all books 
					sum=sum+arr[j];
					table[i][j]=sum;
					sumArr[j]=sum;
				}
				else if(j==0) { // Only 1 book ,, irrespective of student max time= book 0 pages 
					table[i][j]=arr[j];
				}
				else {
					int min=Integer.MAX_VALUE;
					int maxPages=0;
					// j==x does not make sense 
					// it just gives sum 0 to n , with a student doing 0 reading
					// worst case 
					for(int x=0;x<=j;x++) { // j is current book , check for 0 to j books 
						int firstHalf=table[i-1][x];
						// Sum from x to j 
						int currCut=sumArr[j]-sumArr[x];
						maxPages=Math.max(firstHalf, currCut);
						min=Math.min(maxPages, min);
					}
					table[i][j]=min;
				}
			}
		}
		
		System.out.println(" Table below ");
		for(int i=0;i<k;i++) {
			System.out.println(" Table "+Arrays.toString(table[i]));
		}
		
		
		return table[k-1][n-1];
	}

	private static int MinPage_Memo(int[] pages, int i, int k, int[][] memo) {
		// base case 
		if(k==1) {
			memo[k][i]=SumOf(pages,0,i);
			return SumOf(pages,0,i);
		}
		
		if(i==0) {
			memo[k][i]=pages[0];
			return pages[0];
		}
		
		int maxPages=Integer.MIN_VALUE;
		int minNet=Integer.MAX_VALUE;
		int firstHalfRecur=0;
		int CurrentCutPages=0;
		
		//Make cuts from 0 to i 
		for(int j=0;j<=i;j++) {
			
			firstHalfRecur=MinPage_Memo(pages,j, k-1, memo);
		    CurrentCutPages=SumOf(pages,j+1,i);
		    System.out.println(" Partition of k= "+k+" first "+firstHalfRecur+" second "+CurrentCutPages);
		    memo[k][j]=CurrentCutPages;
		    maxPages=Math.max(CurrentCutPages,firstHalfRecur);
		    minNet=Math.min(minNet, maxPages);
		}
		
		memo[k][i]=minNet;
		return minNet;
	}

	private static int MinPage_Recur(int[] pages, int n,int k) {
		// base case 
		if(k==1) {
			return SumOf(pages,0,n);
		}
		
		if(n==0) {
			return pages[0];//only one book
		}
		
		int maxPages=Integer.MIN_VALUE;
		int minVal=Integer.MAX_VALUE;
		int firstHalf=0;
		int secondForCurrStudent=0;
		
		//I can not be 0 , i=0 then stack overflow
		// As we always send first part for recur 
		// Next student recur always from 0 to i 
		// However small i can be 
		for(int i=0;i<n;i++) {
			firstHalf=MinPage_Recur(pages,i, k-1); // can not be i-1 , stack overflow 
			secondForCurrStudent=SumOf(pages,i+1,n);// ith page included above so use i+1 to N 
			maxPages=Math.max(firstHalf, secondForCurrStudent);
			minVal=Math.min(minVal, maxPages);
		}
		return minVal;
	}

	private static int SumOf(int[] pages, int st, int e) {
		// summ of method
		int sum=0;
		for(int i=st;i<=e;i++) {
			sum=sum+pages[i];
		}
		return sum;
	}
}
