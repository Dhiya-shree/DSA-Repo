package arrayCode;

/*
 * Problem #1 : Range Sum Queries using Prefix Sum
 * 
 * Problem #2 : Equilibrium index of an array
 * Equilibrium index of an array is an index such
 *  that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 *  A[0] + A[1] + ... A[i-1] = A[i+1] + A[i+2] ... A[n-1]
 *  a[0]+a[1]===a[2]+a[3]  or  a[0]+a[1]+a[2]===a[3]
 *  
 *  Problem #3 : Largest Sum Subarray
 *  We are given an array of positive and negative integers.
 *   We have to find the subarray having maximum sum.
 *   
 *   Problem #4 : Merge two sorted Arrays
 *   
 *   Problem #5 : Largest Element in an Array
 */

public class ArrayPart02 {

	public static void main(String[] args) {
		// Problem general 
        int ar[]=new int[10];
        for(int i=0;i<7;i++) {
        	ar[i]=1+i;
        }
        
        int range[][]= {{1,2},{3,6},{0,8}};
        int NoOfRanges=range.length;
        FindTheSumOfRanges(ar,NoOfRanges,range);
        FindTheSumOfRangesEfficient(ar,NoOfRanges,range);
//        //Time Complexity : Max(O(n),O(q))
//        //Auxiliary Space : O(n)
        int[] ar1= {-7, 1, 5, 2, -4, 3, 0};
        EquilibriumIndex(ar1);
        EquilibriumIndexEfficient(ar1);
        //Time Complexity : O(n)
        //Auxiliary Space : O(1)
        LargestSumSubArrayWrong(ar1);
        //Sub array is continuous , ex [0,1,3,-7,8,9,-15,10,11]
        //Large sub array is [10,11] and not [0,1,3,8,9,10,111] :| 
        LargestSumSubArrayCorrect(ar1);
        //Time Complexity : O(n)
        //Auxiliary Space : O(1)
        int[] ar2= {-7, 0,2,4,6,8};
        int[] ar3= {-8,1,3,5,7};
        MergeTwoSortedArray(ar2,ar3);
        //Time Complexity : O(n+m)  n-ar2, m-ar3
        //Auxiliary Space : O(n+m)  n-ar2, m-ar3
        
        LargestElementInArray(ar1);
        //Time Complexity : O(n)
        //Auxiliary Space : O(1)
        
	}

	private static void LargestElementInArray(int[] ar1) {
		// Largst Element in array 
		int l=ar1.length;
		int max=0;
		for(int i=0;i<l;i++) {
			if(ar1[i]>max) {
				max=ar1[i];
			}
		}
		System.out.println("Maximum "+max);
	}

	private static void MergeTwoSortedArray(int[] ar2, int[] ar3) {
		// Merge sorted array
		int l1=ar2.length;
		int l2= ar3.length;
		int n =l1+l2;
		int ans[]=new int[n];
		int i=0;
		int j=0;
		for(int k=0;k<n;k++) {
			if(i==l1) {
				ans[k]=ar3[j];
				j++;
				continue;
			}
			if(j==l2) {
				ans[k]=ar2[i];
				i++;
				continue;
			}
			if(ar2[i]<=ar3[j]) {
				ans[k]=ar2[i];
				i++;
			}
			else {
				ans[k]=ar3[j];
				j++;
			}
		}
		ArrayPart01.PrintRayy(ar2);
		ArrayPart01.PrintRayy(ar3);
		ArrayPart01.PrintRayy(ans);
	}

	private static void LargestSumSubArrayCorrect(int[] ar1) {
		// Sub array means - continuous array not sub set 
		int max=0;
		int max_curr=0;
		int len=ar1.length;
		int ans[]=new int [len];
		int j=0;
		for(int i=0;i<len;i++) {
			max_curr=max_curr+ar1[i];
			if(max_curr>max) {
				ans[j]=ar1[i];
				j++;
				max=max_curr;
			}
			else {
				max_curr=0;
			}
		}
		System.out.println("Max sum "+max);
		ArrayPart01.PrintRayy(ar1);
		ArrayPart01.PrintRayy(ans);
		
	}

	private static void LargestSumSubArrayWrong(int[] ar1) {
		// Max sum of sub array 
		int max=0;
		int max_curr=0;
		int len=ar1.length;
		int ans[]=new int [len];
		int j=0;
		for(int i=0;i<len;i++) {
			max_curr=max+ar1[i];
			if(max_curr>max) {
				ans[j]=ar1[i];
				j++;
				max=max_curr;
			}
		}
		System.out.println("Max sum "+max);
		ArrayPart01.PrintRayy(ar1);
		ArrayPart01.PrintRayy(ans);

	}

	private static void LargestSumSubArrayWrong(int[] ar1) {
		// Max sum of sub array 
		int max=0;
		int max_curr=0;
		int len=ar1.length;
		int ans[]=new int [len];
		int j=0;
		for(int i=0;i<len;i++) {
			max_curr=max+ar1[i];
			if(max_curr>max) {
				ans[j]=ar1[i];
				j++;
				max=max_curr;
			}
		}
		System.out.println("Max sum "+max);
		ArrayPart01.PrintRayy(ar1);
		ArrayPart01.PrintRayy(ans);
	
	}

	private static void EquilibriumIndexEfficient(int[] ar1) {
		// Equi effi
		int sum =0;
		int len=ar1.length;
		for(int i=0;i<len;i++) {
			sum=sum+ar1[i];
		}
		int rsum=0;
		for(int i=0;i<len;i++) {
			rsum=rsum+ar1[i];
			if(sum==rsum) {
				System.out.println("Index"+sum+" "+rsum+"Pos "+i+"Answer ;)");
				break;
			}
			System.out.println("Index"+sum+" "+rsum+"Pos "+i);
			sum=sum-ar1[i];
		}
	}

	private static void EquilibriumIndex(int[] ar) {
		// Tequilibrium index
		ArrayPart01.PrintRayy(ar);
		int len=ar.length;
		int ar_L[] = new int [len];
		int ar_R[] = new int [len];
		ar_L[0]=ar[0];
		ar_R[len-1]=ar[len-1];
		for (int i=1,j=len-2;i<len;i++,j--) {
			ar_L[i]=ar_L[i-1]+ar[i];
			ar_R[j]=ar_R[j+1]+ar[j];
		}
		ArrayPart01.PrintRayy(ar_L);
		ArrayPart01.PrintRayy(ar_R);
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
			if(ar_L[i]==ar_R[j]) {
				System.out.println("Index"+ar_L[i]+"at ppos"+i+" "+ar_R[j]+"at ppos"+j);
				break;
			}
		}
		}
	}

	private static void FindTheSumOfRangesEfficient(int[] ar, int noOfRanges, int[][] range) {
		// Crate an array to store sum from i th element 
		int len = ar.length;
		int ans[]=new int [noOfRanges];
		int ar_sum[]=new int[len];
		ar_sum[0]=ar[0];
		for(int i=1;i<len;i++) {
			ar_sum[i]=ar_sum[i-1]+ar[i];
		}
		for(int j=0;j<noOfRanges;j++) {
			if(range[j][0]==0) {
				ans[j]=ar_sum[(range[j][1])];
			}
			else {
				ans[j]=ar_sum[(range[j][1])-1] - ar_sum[(range[j][0])-1];
			}
		}
		ArrayPart01.PrintRayy(ans);
	}

	private static void FindTheSumOfRanges(int[] ar, int noOfRanges, int[][] range) {
		// Sum of given ranges 
		ArrayPart01.PrintRayy(ar);
		int ans[]=new int[noOfRanges];
		//int len=ar.length;
		for(int i=0;i<noOfRanges;i++) {
			ans[i]=FindTheSum(ar,range[i][0],range[i][1]);
			}
		ArrayPart01.PrintRayy(ans);
		}

	private static int FindTheSum(int[] ar, int a, int b) {
		// Find range btw a and b
		int res=0;
		for(int i=a;i<b;i++) {
			res=res+ar[i];
	}
		return res;
	}

}
