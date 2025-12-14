package dynamic_programming;
/**
 * Longest Increasing Subsequence
Difficulty: MediumAccuracy: 32.8%Submissions: 343K+Points: 4
Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

Examples:

Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.
Input: arr[] = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output: 6
Explanation: One of the possible longest strictly increasing subsequences is [0, 2, 6, 9, 13, 15], which has a length of 6.
Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.
 * 
 * 
 * @author shree
 *
 */
public class DP05_Longest_Increasing_Sub_sequence {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}




class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
        // code here
        
        if(n==1){
            return 1;
        }
        if(n==2){
            if(a[0]<a[1]){
                return 2;
            }
            else{
                return 1;
            }
        }
        
        int ans=BinaryAns(n,a);
        return ans;
    }
    
      static int BinaryAns(int n, int arr[]) {
       
       int array[]=new int[n];   
       int len=1;int lenMax=0;
       array[0]=arr[0];
       for(int i=1;i<n;i++){
           if(arr[i]>array[len-1]){
               array[len]=arr[i];
               len++;
           }
           else{
               // find correct position for elemrnt arr i
               // in ans array array 
           
               lenMax=Math.max(len,lenMax);
               int x=findPosfor(array,arr[i],len);
               array[x]=arr[i];
          //     len=x+1;
//System.out.println(" X "+x+" len "+len+" pos "+arr[i]+" lenmax"+lenMax);
           }
       }
         
       lenMax=Math.max(len,lenMax);
       return lenMax;
          
      }
      
        static int findPosfor(int array[],int ele,int n) {
     
          if(ele<array[0]){
              return 0;
          }
          
          int low=0;
          int high=n-1;
          while(low<high){
            int mid=low+(high-low)/2;
              if(array[mid]>=ele){
                  high=mid;
              }
              else{
                  low=mid+1;
              }
              
          }
          
          if(high==-1){
              return 0;
          }
          return high;
          
        }
}


/*
 following is a GFG article that can be used to understand the concepts used in this problem. It may or may not be exactly applicable to the problem statement given here.
Given an array arr[] of size n, the task is to find the length of the Longest Increasing Subsequence (LIS) i.e., the longest possible subsequence in which the elements of the subsequence are sorted in increasing order.

Examples:            

Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest increasing subsequence is 3, 10, 20

Input: arr[] = [30, 20, 10]
Output:1
Explanation: The longest increasing subsequences are [30], [20] and [10]

Input: arr[] = [2, 2, 2]
Output: 1
Explanation: We consider only strictly increasing.

Input: arr[] = [10, 20, 35, 80]
Output: 4
Explanation: The whole array is sorted

Table of Content

[Naive Approach] Using Recursion - Exponential Time and Linear Space
[Better Approach - 1] Using Memoization - O(n^2) Time and O(n) Space
[Better Approach - 2] Using DP (Bottom Up Tabulation) - O(n^2) Time and O(n) Space
[Expected Approach] Using Binary Search - O(n Log n) Time and O(n) Space
Problems based on LIS
[Naive Approach] Using Recursion - Exponential Time and Linear Space
The idea to do traverse the input array from left to right and find length of the Longest Increasing Subsequence (LIS) ending with every element arr[i]. Let the length found for arr[i] be L[i]. At the end we return maximum of all L[i] values. Now to compute L[i], we use recursion, we consider all smaller elements on left of arr[i], recursively compute LIS value for all the smaller elements on left, take the maximum of all and add 1 to it. If there is no smaller element on left of an element, we return 1.

Let L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS. Then, L(i) can be recursively written as: 

L(i) = 1 + max(L(prev) ) where 0 < prev < i and arr[prev] < arr[i]; or
L(i) = 1, if no such prev exists.
Formally, the length of LIS ending at index i, is 1 greater than the maximum of lengths of all LIS ending at some index prev such that arr[prev] < arr[i] where prev < i.

After we fill the L array, we find LIS as maximum of all in L[]

Overall LIS = max(L[i]) where 0 <= i < n

We can see that the above recurrence relation follows the optimal substructure property. Follow the below illustration to see overlapping subproblems.

Consider arr[] = [3, 10, 2, 11]

L(i): Denotes LIS of subarray ending at position 'i'

Recursion Tree
Recursion Tree



// Java program to find lis using recursion
// in Exponential Time and Linear Space
import java.util.*;

class GfG {
    static int lisEndingAtIdx(int[] arr, int idx) {
      
        // Base case
        if (idx == 0)
            return 1;

        // Consider all elements on the left of i,
        // recursively compute LISs ending with 
        // them and consider the largest
        int mx = 1;
        for (int prev = 0; prev < idx; prev++)
            if (arr[prev] < arr[idx])
                mx = Math.max(mx, lisEndingAtIdx(arr, prev) + 1);
        return mx;
    }

    static int lis(int[] arr) {
        int n = arr.length;
        int res = 1;
        for (int idx = 1; idx < n; idx++)
            res = Math.max(res, lisEndingAtIdx(arr, idx));
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(lis(arr));
    }
}

Output
5
[Better Approach - 1] Using Memoization - O(n^2) Time and O(n) Space
If notice carefully, we can see that the above recursive function lisEndingAtIdx() also follows the overlapping subproblems property i.e., same substructure solved again and again in different recursion call paths. We can avoid this using the memoization approach. Since there is only one parameter that changes in recursive calls and the range of the parameter goes from 0 to n-1, so we us a 1D array of size n and initialize it as -1 to indicate that the values are not computed yet.




import java.util.*;

class GfG {
    static int lisEndingAtIdx(int[] arr, int idx, int[] memo) {
      
        // Base case
        if (idx == 0)
            return 1;

        // Check if the result is already computed
        if (memo[idx] != -1)
            return memo[idx];

        // Consider all elements on left of i,
        // recursively compute LISs ending with 
        // them and consider the largest
        int mx = 1;
        for (int prev = 0; prev < idx; prev++)
            if (arr[prev] < arr[idx])
                mx = Math.max(mx, lisEndingAtIdx(arr, prev, memo) + 1);

        // Store the result in the memo array
        memo[idx] = mx;
        return memo[idx];
    }

    static int lis(int[] arr) {
        int n = arr.length;
      
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
      
        int res = 1;
        for (int idx = 1; idx < n; idx++)
            res = Math.max(res, lisEndingAtIdx(arr, idx, memo));
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(lis(arr));
    }
}

Output
5
[Better Approach - 2] Using DP (Bottom Up Tabulation) - O(n^2) Time and O(n) Space
The tabulation approach for finding the Longest Increasing Subsequence (LIS) solves the problem iteratively in a bottom-up manner. The idea is to maintain a 1D array lis[], where lis[i] stores the length of the longest increasing subsequence that ends at index i. Initially, each element in lis[] is set to 1, as the smallest possible subsequence for any element is the element itself.

The algorithm then iterates over each element of the array. For each element arr[i], it checks all previous elements arr[0] to arr[i-1]. If arr[i] is greater than arr[prev] (ensuring the subsequence is increasing), it updates lis[i] to the maximum of its current value or lis[prev] + 1, indicating that we can extend the subsequence ending at arr[prev] by including arr[i].

Finally, the length of the longest increasing subsequence is the maximum value in the lis[] array.

longest-increasing-subsequence--1.webplongest-increasing-subsequence--1.webp





import java.lang.*;

class GfG {

    // lis() returns the length of the longest
    // increasing subsequence in arr[] of size n
    static int lis(int arr[]) {
        int n = arr.length;
        
        int lis[] = new int[n];
      
        // Initialize LIS values for all indexes
        for (int i = 0; i < n; i++)
            lis[i] = 1;

        // Compute optimized LIS values in
        // bottom up manner
        for (int i = 1; i < n; i++)
            for (int prev = 0; prev < i; prev++)
                if (arr[i] > arr[prev] && lis[i] < lis[prev] + 1)
                    lis[i] = lis[prev] + 1;

        // Pick maximum of all LIS values
        int max = 1;
        for (int i = 0; i < n; i++)
            max = Math.max(max, lis[i]);

        return max;
    }

    public static void main(String args[]) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(lis(arr));
    }
}

Output
5
[Expected Approach] Using Binary Search - O(n Log n) Time and O(n) Space
We can solve this in O(n Log n) time using Binary Search. The idea is to traverse the given sequence and maintain a separate list of sorted subsequence so far. For every new element, find its position in the sorted subsequence using Binary Search.

Refer Longest Increasing Subsequence Size (N * logN) for details.

Problems based on LIS
LIS on Circular Array
Printing LIS
Count LISs
Max Sum Subsequence
Longest Arithmetic Subsequence
Longest Bitonic Subsequence
Longest Alternating Subsequence
Longest Common Increasing Subsequence
Building Bridges
Box Stacking
More Problems on LIS


Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

*/