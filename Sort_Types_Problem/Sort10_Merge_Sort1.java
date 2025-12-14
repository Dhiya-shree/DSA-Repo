package Sort_Types_Problem;

import java.util.Arrays;

import arrayCode.ArrayPart01;

/**
 * Merge Sort 
 * 
 * 1) Divide and Conquer Algorithm - recursively seperate to two parts and merges them
 * 2) Sable sorting algorithm 
 * 3) Time - O n Log n 
 * 4) Bad - space - O n ..Not in-place algorithm ( adv version esist)
 * 5) Well sorted for linked list . Works in O(1) aux space 
 * 6) Used in external sorting 
 * 7) -_- in general quick sort outperforms for array
 * 8) In java based on input type , merge / quick is used 
 * 
 * 
 * Merge two sorted Array : problem #1 
 * @author shree
 *
 */
public class Sort10_Merge_Sort1 {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,6};
		int arr2[]= {4,5,7,8,9,10};
		int ans[]=MergeSortedArray(arr,arr2);
		
		ArrayPart01.PrintRayy(ans);
		
		ans=MergeSortedArrayNOTOptimized(arr,arr2);
	}

	private static int[] MergeSortedArrayNOTOptimized(int[] arr, int[] arr2) {
		// use sort function - M+n  O log m+n
		int n=arr.length;
		int m=arr2.length;
		System.out.println(" N "+n+" M "+m);
		int t=n+m;
		//int i=0;
		int ans[]=new int[t];
		for( int i=0;i<n;i++) {
			ans[i]=arr[i];
		}
		for(int i=n;i<t;i++) {
			ans[i]=arr2[i-n];
		}
		Arrays.sort(ans);
		return ans;
	}

	private static int[] MergeSortedArray(int[] arr, int[] arr2) {
		// Efficient M+n  
		int n=arr.length;
		int m=arr2.length;
		System.out.println(" N "+n+" M "+m);
		int t=n+m;
		int ans[]=new int[t];
		int j = 0,k=0;
		boolean jflg=true; boolean kflg=true;
		for(int i=0;i<t;i++) {
			 System.out.println(" Arr j " +arr[j]+" Arr k "+arr2[k] );
			 if(jflg && arr[j]<=arr2[k]) {
				 // Above equal too symbol is musttt for STABILITY
				 // Without equal too not stable -_-
				 ans[i]=arr[j];
				 if(j==n-1) {
					 jflg=false;
				 }
				 else {
					 j++;
				 }
			 }
			 else if(kflg) {
				 ans[i]=arr2[k];
				
				 if(k==m-1) {
					 kflg=false;
				 }
				 else {
					 k++;
				 }
			 }
			 else if(jflg) {
				 ans[i]=arr[j];
				 System.out.println(" left "+arr[j]);
				 if(j==n-1) {
					 jflg=false;
				 }
				 else {
					 j++;
				 }
			 }
		}
		return ans;
	}
}

/**
 * Given two sorted arrays, the task is to merge them in a sorted manner.
Examples: 

Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8} 
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}

Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8} 
Output: arr3[] = {4, 5, 7, 8, 8, 9} 

Method 1: (O(n1 * n2) Time and O(n1+n2) Extra Space) 

Create an array arr3[] of size n1 + n2.
Copy all n1 elements of arr1[] to arr3[]
Traverse arr2[] and one by one insert elements (like insertion sort) of arr3[] to arr1[]. This step take O(n1 * n2) time.
We have discussed implementation of above method in Merge two sorted arrays with O(1) extra space
Method 2: (O(n1 + n2) Time and O(n1 + n2) Extra Space) 
The idea is to use Merge function of Merge sort. 

Create an array arr3[] of size n1 + n2.
Simultaneously traverse arr1[] and arr2[]. 
Pick smaller of current elements in arr1[] and arr2[], copy this smaller element to next position in arr3[] and move ahead in arr3[] and the array whose element is picked.
If there are remaining elements in arr1[] or arr2[], copy them also in arr3[].
Below image is a dry run of the above approach: 



Below is the implementation of the above approach: 

#include <bits/stdc++.h>
using namespace std;

void mergeArrays(int arr1[], int arr2[], int n1, int n2, int arr3[]) {
    int i = 0, j = 0, k = 0;

    while (i < n1 && j < n2) {
        if (arr1[i] < arr2[j])
            arr3[k++] = arr1[i++];
        else
            arr3[k++] = arr2[j++];
    }

    while (i < n1)
        arr3[k++] = arr1[i++];

    while (j < n2)
        arr3[k++] = arr2[j++];
}

int main() {
    int arr1[] = {1, 3, 5, 7};
    int n1 = sizeof(arr1) / sizeof(arr1[0]);

    int arr2[] = {2, 4, 6, 8};
    int n2 = sizeof(arr2) / sizeof(arr2[0]);

    int arr3[n1+n2];
    mergeArrays(arr1, arr2, n1, n2, arr3);

    cout<<"Array after merging"<<"\n";
    for (int i = 0; i < n1+n2; i++)
        cout<<arr3[i]<<" ";

    return 0;
}

Output
Array after merging
1 2 3 4 5 6 7 8 
 * 
 */
