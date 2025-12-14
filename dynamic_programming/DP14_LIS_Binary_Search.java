package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Longest increasing sub sequence 
 * 
 * A subsequnece of given sequence is 0 or more element picked in order of apprearing in sequenece .
 * 
 * For sequenec length N , 2*N subsequnence possible 
 * 
 * For example :
 * arr = 3,4,2,8,10 
 * s^N - as 00000,00001,00010,00011.....11111(32)
 *    3,4,2,8,10 - 5
 *    34,342,3428,34280,32,328,3280,38,380,30 - 10 
 *    42,428,4280,48,480,40 - 6 
 *    28,280,20 - 3
 *    80," "- 2 
 * 
 * LIS= 3,4,8,10 
 * length = 4 
 * 
 * Array in sorted increasing LIS=N , decreasing LIS=1 
 * 
 * 
 * Naive O 2^N
 * Dynamic O N*N
 * Better solution O NlogN 
 * 
 * 
 * Better Solution - Binary search 
 * 
 * 
 * Sol 1 :
 *   1) Sort the array O N log N 
 *   2) Find LCS O N+N = O 2N = O N 
 *   Total Complexity = O NLogN + ON = O N LogN
 *   
 *   
 * Sol 2 : GOG 
 * 
 * tail[n]:
 * tail i -> Store the minimum possible tail value for LIS of length i+1
 * 
 * Example....
 * For array 8,100,150,10,12,14,110 
 * 
 * For i=0
 * tail 0 - minimum possible value for i=1 is always arr[0]
 * Tail - 8 . . . . . .   len 1
 * 
 * For i=1 
 * 100>8 
 * tail1 = 100 
 * Tail - 8 100 . . . . . len 2 ( greater than prev size of tail increase )
 * 
 * For i=2 150>100 
 * tail2=150 
 * Tail - 8 100 150 . . . . len 3  ( greater than prev size of tail increase )
 * 
 * For i=3 value NOT greater than last value 
 *  For 10 , find pos in tail that it can be replaced . 
 *     for j=i to 1 if tail[j-1]<10 
 *     replace tail[j-1]=10 
 * 
 * For 10 ...replace at tail1 , tail1=10
 * Tail - 8 10 150 . . . .  len 3 
 * 
 * For i=4 12<150 
 * Value NOT great , do binary search and find ceiling of 12 ( 10 < 12 < 150 )
 * 
 * Thus tail 2=12 
 * Tail - 8 10 12 . . . . len 3
 * 
 * For i=5 14>12 
 * greater than prev , size of tail increase+append 
 * tail 4=12 
 * Tail - 8 10 12 14 . . . len 4
 * 
 * For i=6 110 >14
 * greater than prev , size of tail increase+append 
 * tail 5=110
 * Tail - 8 10 12 14 110 . . len 5
 * 
 * LCS = 8 10 12 14 110 
 * length of lcs= lenth of tail = 5 
 * 
 * 
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
public class DP14_LIS_Binary_Search {

	public static void main(String[] args) {
		// Lis 
		int arr[]= {3,4,8,1,2,5};
		int n=arr.length;
				
				
		// Sort + LCS 
		int ans=LIS_sort_lcs(arr,n);
		System.out.println(" Only length LCS+Sort ans "+ans);
		
		// GOG Tail Binary search 
		ans= LIS_Tail_BinarySearch(arr,n);
		System.out.println(" GOG binary search + Tail "+ans);

	}

	private static int LIS_Tail_BinarySearch(int[] arr, int n) {
		// Create array Tail 
		int tail[]=new int[n];
		
		//base tail 0 = arr[0]
		tail[0]=arr[0];
		int len=0;
		for(int i=1;i<n;i++) {
			// ele greater than tail , increase len and append value in tail 
			if(arr[i]>tail[len]) {
				len++;
				tail[len]=arr[i];
				System.out.println(" Tail array == append...... "+Arrays.toString(tail));
			}
			else {
				// ele smaller 
				// Find the ceiling by binary search 
				// replace element in the pos 
				
				//atp array is sorted in increasing order 
				//use the order for help 
				int index=FindCeil_BinarySearch(tail,0,n,arr[i]);
				
				//Both work well 
				
				//GOG ceil 
				index=CeilIndex(tail,0,len-1,arr[i]);
				
				System.out.println(" Index "+index);
				tail[index]=arr[i];
				System.out.println(" Tail array == replace......"+Arrays.toString(tail));
			}
		}
		
		System.out.println(" Tail array "+Arrays.toString(tail));
		return len+1;
	}

	private static int CeilIndex(int[] tail, int left, int right, int ele) {
		// Linear Binary search 
		
		while(right>left) {
			int mid=left+(right-left)/2;
			if(tail[mid]>=ele) {
				right=mid;
			}
			else {
				left=mid+1;
			}
		}
		if(right==-1) {
			return 0;
		}
		return right;
	}

	private static int FindCeil_BinarySearch(int[] arr,int start, int n, int ele) {
		// given array in increasing order 
		// find index of ele 
		
		if(start>n) {
			return 0;
		}
		
		int mid=(int)(start+n)/2;
		if(mid==0) {
			return 0;
		}
		if(arr[mid]<ele && arr[mid-1]>ele) {
			return mid;
		}
		else if(arr[mid]<ele) {
			return FindCeil_BinarySearch(arr,start,mid-1,ele);
		}
		else {
			return FindCeil_BinarySearch(arr,mid+1,n,ele);
		}
		
	}

	private static int LIS_sort_lcs(int[] arr, int n) {
		// Sort 
		//Find LCS 
		int arr2[]=new int[n];
		for(int i=0;i<n;i++) {
			arr2[i]=arr[i];
		}
		
		//Sort Arr2  N Log N
		Arrays.sort(arr2);
		
		System.out.println(" Sorted "+Arrays.toString(arr2));
		
		
		// LCS of sorted and unsorted array 
		// O N+N time O N+N space 
		int memo[][]=new int[n][n];
		int ans=LCSArray(arr2,arr,n-1,n-1,memo);
		
		return ans;
	}

	private static int LCSArray(int[] arr2, int[] arr, int n2, int n, int[][] memo) {
		// lcs of array 
		if(n<0 ||n2<0) {
			return 0;
		}
		
		if(memo[n][n2]!=0) {
			return memo[n][n2];
		}
		int lcs=0;
		if(arr2[n2]==arr[n]) {
			lcs=1+LCSArray(arr2, arr, n2-1, n-1, memo);
			
		}
		else {
			int lcs1=LCSArray(arr2, arr, n2-1, n, memo);
			int lcs2=LCSArray(arr2, arr, n2, n-1, memo);
			lcs=Math.max(lcs1, lcs2);
		}
		memo[n][n2]=lcs;
		return lcs;
	}

}
