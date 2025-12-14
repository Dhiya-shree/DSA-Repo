package Sort_Types_Problem;

import arrayCode.ArrayPart01;

/**
 * Merging of sorted Array 
 * 
 * Consider 3 points - low , mid and high 
 * low to mid is started and mid+1 to high another sorted
 * low to mid  and mid+1 to high both together not sorted  
 * low <= mid < high 
 * Atleast 1 low , and 1 high 
 * 
 * 
 * This video is a complex version of the previously discussed problem on Merge Sort. Here we take a single array with three points namely, the lower, the middle and the highest point. The elements from the lower to the middle are sorted and the elements from the (middle+1) to the higher are sorted. 
 * The task is to merge these two sorted parts into one.
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Sort11_Merge_Sort2 {

	public static void main(String[] args) {
		

	int arr[]= {1,3,4,5,7,10,0,2,6,8,9};
	int n=arr.length;
	int ans[]=MergeSortedFunction(arr,0,(n/2),n-1);
	
	ArrayPart01.PrintRayy(ans);
}

	private static int[] MergeSortedFunction(int[] arr, int low, int mid, int high) {
		// Merge function 
		
		//Prepare two array left nd right
		int n1=mid-low+1;
		int n2=high-mid;
		
		int leftA[] = new int[n1];
		int rightA[] = new int[n2];
		
		for(int i=0;i<n1;i++) {
			leftA[i]=arr[low+i];
		}
		
		for(int i=0;i<n2;i++) {
			rightA[i]=arr[mid+i+1];
		}
		System.out.println(" N1 "+n1+"  N2 "+n2+" High "+high);
		
		ArrayPart01.PrintRayy(leftA);
		
		ArrayPart01.PrintRayy(rightA);
		// Sorting 
		
		int ans[]=new int[high+1];
		int j = 0,k=0;
		boolean jflg=true; boolean kflg=true;
		for(int i=0;i<=high;i++) {
			System.out.println(" J f "+jflg+"  K f "+kflg);
			System.out.println(" Arr j " +leftA[j]+" Arr k "+rightA[k] );
			 if(jflg && leftA[j]<=rightA[k]) {
				 // Above equal too symbol is musttt for STABILITY
				 // Without equal too not stable -_-
				 ans[i]=leftA[j];
				 System.out.println(" left "+leftA[j]);
				 if(j==n1-1) {
					 jflg=false;
				 }
				 else {
					 j++;
				 }
			 }
			 else if(kflg) {
				 ans[i]=rightA[k];
				 System.out.println(" rightA "+rightA[k]);
				 if(k==n2-1) {
					 kflg=false;
				 }
				 else {
					 k++;
				 }
			 }
			 else if(jflg) {
				 ans[i]=leftA[j];
				 System.out.println(" left "+leftA[j]);
				 if(j==n1-1) {
					 jflg=false;
				 }
				 else {
					 j++;
				 }
			 }
		}
		return ans;
		
		
		//return null;
	}

	
}

/**
 * 
 * Given two sorted arrays, the task is to merge them in a sorted manner.
Examples: 

Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8} 
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8} 
Output: arr3[] = {4, 5, 7, 8, 8, 9} 


Method 1 (O(n1 * n2) Time and O(n1+n2) Extra Space) 

Create an array arr3[] of size n1 + n2.
Copy all n1 elements of arr1[] to arr3[]
Traverse arr2[] and one by one insert elements (like insertion sort) of arr3[] to arr1[]. This step take O(n1 * n2) time.

We have discussed implementation of above method in Merge two sorted arrays with O(1) extra space


Method 2 (O(n1 + n2) Time and O(n1 + n2) Extra Space) 
The idea is to use Merge function of Merge sort. 

Create an array arr3[] of size n1 + n2.
Simultaneously traverse arr1[] and arr2[]. 
Pick smaller of current elements in arr1[] and arr2[], copy this smaller element to next position in arr3[] and move ahead in arr3[] and the array whose element is picked.
If there are remaining elements in arr1[] or arr2[], copy them also in arr3[].
Below image is a dry run of the above approach: 





 

Below is the implementation of the above approach: 

 


// Java program to merge two sorted arrays
import java.util.*;
import java.lang.*;
import java.io.*;

class MergeTwoSorted
{
    // Merge arr1[0..n1-1] and arr2[0..n2-1] 
    // into arr3[0..n1+n2-1]
    public static void mergeArrays(int[] arr1, int[] arr2, int n1,
                                int n2, int[] arr3)
    {
        int i = 0, j = 0, k = 0;
    
        // Traverse both array
        while (i<n1 && j <n2)
        {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
    
        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];
    
        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];
    }
    
    public static void main (String[] args) 
    {
        int[] arr1 = {1, 3, 5, 7};
        int n1 = arr1.length;
    
        int[] arr2 = {2, 4, 6, 8};
        int n2 = arr2.length;
    
        int[] arr3 = new int[n1+n2];
        
        mergeArrays(arr1, arr2, n1, n2, arr3);
    
        System.out.println("Array after merging");
        for (int i=0; i < n1+n2; i++)
            System.out.print(arr3[i] + " ");
    }
}



Output: 

Array after merging
1 2 3 4 5 6 7 8
Time Complexity : O(n1 + n2) 
Auxiliary Space : O(n1 + n2)


Method 3: Using Maps (O(nlog(n) + mlog(m)) Time and O(N) Extra Space) 

Insert elements of both arrays in a map as keys.
Print the keys of the map.
Below is the implementation of above approach.
 * 
 */
