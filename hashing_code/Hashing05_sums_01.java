package hashing_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Problem #1 : Check if 2 array equal
 * Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.
 * 
 * 
 * Problem #2 : Hashing for pair 
 * You are given an array of distinct integers and a sum. Check if there's a pair with the given sum in the array.
 * 
 * 
 * Problem #3 : Hashing pair 2 
 *  are given an array of integers and an integer sum - non distinct 
 *  . You need to find if two numbers in the array exists that have sum equal to the given sum.
 *  
 *  Problem # 4 : Count of non repeated 
 *  
 *  You are given an array of integers. You need to print the count of non-repeated elements in the array.
 *  
 *  Problem #5 :Print Non-Repeated Elements
 *  You are given an array of integers. You need to print the non-repeated elements as they appear in the array.
 *  
 * @author shree
 *
 */
public class Hashing05_sums_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long A[]= {1,2,4,3,3,3,4,5};
		long B[]= {1,4,2,3,3,3,4,5};
        boolean ans=checkEqual(A,B,A.length);
        System.out.println(" Equal is "+ans);
        
        int arr[]= {1,2,2,5,8,3,4,10,11,17,23,12,14,15};
        int n=arr.length;
        int sum=23;
        ans= CheckSumExist(arr,n,sum);
        System.out.println(" Sum exist is "+ans);
        
        ans= CheckSumExistNonDistinct(arr,n,sum);
        System.out.println(" Sum exist is "+ans);
        
        int ans1=CountOfNonRepeated(arr,n);
        System.out.println(" Count of repetaed "+ans1);
        
        ArrayList<Integer> ans2=PrintNonRepeated(arr,n);
        System.out.println(" ARRay "+ans2.toString());
	}

	 private static ArrayList<Integer> PrintNonRepeated(int[] arr, int n) {
		// Print non repetaed using hashmap 
		 ArrayList<Integer> ans= new ArrayList<Integer>();
		 HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		 int val=0;
		 for(int i=0;i<n;i++) {
			 if(hm.containsKey(arr[i])) {
				val=hm.get(arr[i]);
				val++;
				hm.put(arr[i],val);
			 }
			 else {
				 hm.put(arr[i],0);
			 }
		 }
		 for(int i=0;i<n;i++) {
			 if(hm.get(arr[i])==0) {
				 
				 ans.add(arr[i]);
			 }
			 
		 }
		 
		 hm.forEach((k,v)->{
			 if(v==0) {
				ans.add(k); 
			 }
		 }
		 );
		 Iterator<Entry<Integer, Integer>> itr= hm.entrySet().iterator();
		 while(itr.hasNext()) {
			 Map.Entry<Integer, Integer> mape= (Map.Entry<Integer, Integer>) itr.next();
			 if(((int)mape.getValue())==0) {
				 ans.add((int)mape.getKey());
			 }
		 }
		 
		return ans;
	}

	private static int CountOfNonRepeated(int[] arr, int n) {
		// just count 
		 HashSet<Integer> hs= new HashSet<Integer>();
         HashSet<Integer> ex= new HashSet<Integer>();
		 int c=0; int sub=0;
		 for(int i=0;i<n;i++) {
			 if(hs.contains(arr[i])) {
				ex.add(arr[i]);
			
			 }
			 else {
				 hs.add(arr[i]);
				 c++;
			 }
		 }
		 sub=ex.size();
	  System.out.println(" HashMap "+ex.toString());
		 	System.out.println("sub  "+sub+" count "+c);
		 System.out.println(" HashMap "+hs.toString());
		return (c-sub);
	}

	private static boolean CheckSumExistNonDistinct(int[] arr, int n, int sum) {
		// same sum 
		return false;
	}

	private static boolean CheckSumExist(int[] arr, int n, int sum) {
		// Sum exist - usua sort and two pointer 
		 HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>(n);
		 
		 int diff=0;
		 for(int i=0;i<n;i++) {
			 diff=sum-arr[i];
			 hm.put(arr[i],diff);
		 }
		 System.out.println(" HashMap "+hm.toString()); int key=0;
		 for( Map.Entry<Integer,Integer> e : hm.entrySet()) {
		      diff=e.getValue();
		      key=e.getKey();
		      if(key!=diff && hm.containsKey(diff)) {
		    	  System.out.println("...val "+diff);
		    	  return true;
		      }
			 
		 }
		return false;
	}

	public static boolean checkEqual(long A[],long B[],int N)
	    {
	        //Chec equal 
	        HashMap<Long,Integer> hm= new HashMap<Long,Integer>(N);
	        int c=0;
	        for(int i=0;i<N;i++){
	            
	           if((hm.containsKey(A[i]))){
	               c=hm.get(A[i]);
	               c++;
	               hm.put(A[i],c);
	           }
	           else {
	        	   hm.put(A[i],1);
	           }
	        }
	       // int e=0;
	        System.out.println(" HashMap "+hm.toString());
	        for(int i=0;i<N;i++){
	         
	            if(hm.containsKey(B[i])){
	                c=hm.get(B[i]);
	               c--;
	               if(c==0){
	                   hm.remove(B[i]);
	               }
	               else{
	               hm.put(B[i],c);}
	            }
	            else{
	                return false;
	            }
	            System.out.println(" With element of B "+B[i]);
	            System.out.println(" HashMap "+hm.toString());
	        }
	        if(hm.size()==0){
	            return true;
	        }
	        else{
	            return false;
	        }
	        
	    }
}


/**
 * 
 * Given an unsorted array, count all distinct elements in it.
Examples: 

Input :   arr[] = {10, 20, 20, 10, 30, 10}
Output : 3
There are three distinct elements 10, 20 and 30.

Input :   arr[] = {10, 20, 20, 10, 20}
Output : 2

A simple solution is to run two loops. For every element, check if it has appeared before. If yes, increment count of distinct elements. 

 



// Java program to count distinct 
// elements in a given array
class GFG
{
    
static int countDistinct(int arr[], int n)
{
    int res = 1;

    // Pick all elements one by one
    for (int i = 1; i < n; i++) 
    {
        int j = 0;
        for (j = 0; j < i; j++)
            if (arr[i] == arr[j])
                break;

        // If not printed earlier, 
        // then print it
        if (i == j)
            res++;
    }
    return res;
}

// Driver code
public static void main(String[] args)
{
    int arr[] = { 12, 10, 9, 45, 2, 10, 10, 45 };
    int n = arr.length;
    System.out.println(countDistinct(arr, n));
}
}

// This code is contributed by Code_Mech.


 


Output
5

Time Complexity of above solution is O(n2). We can Use Sorting to solve the problem in O(nLogn) time. The idea is simple, first sort the array so that all occurrences of every element become consecutive. Once the occurrences become consecutive, we can traverse the sorted array and count distinct elements in O(n) time. Following is the implementation of the idea. 
  

public static int countDistinct(int arr[],int n)
    {

        HashSet<Integer> hs = new HashSet<Integer>();

        for(int i = 0; i < n; i++)
        { 
            // add all the elements to the HashSet 
            hs.add(arr[i]);
        }
        
        // return the size of hashset as 
        // it consists of all Unique elements 
        return hs.size();     
    }

    // Driver code
    public static void main(String[] args) 
    { 
        int arr[] = new int[]{6, 10, 5, 4, 9,
                                120, 4, 6, 10};
        System.out.println(countDistinct(arr, 
                                arr.length));
                                
                                
                                
// C++ program to count all distinct elements
// in a given array
#include <algorithm>
#include <iostream>
using namespace std;

int countDistinct(int arr[], int n)
{
    // First sort the array so that all
    // occurrences become consecutive
    sort(arr, arr + n);

    // Traverse the sorted array
    int res = 0;
    for (int i = 0; i < n; i++) {

        // Move the index ahead while
        // there are duplicates
        while (i < n - 1 && arr[i] == arr[i + 1])
            i++;

        res++;
    }

    return res;
}

// Driver program to test above function
int main()
{
    int arr[] = { 6, 10, 5, 4, 9, 120, 4, 6, 10 };
    int n = sizeof(arr) / sizeof(arr[0]);
    cout << countDistinct(arr, n);
    return 0;
}

 


Output
6

 

We can Use Hashing to solve this in O(n) time on average. The idea is to traverse the given array from left to right and keep track of visited elements in a hash set , as a set consists of only unique elements. 
Following is the implementation of the idea.

 


// CPP program to print all distinct elements 
 //  of a given array 
#include <bits/stdc++.h>
using namespace std;

// This function prints all distinct elements
int countDistinct(int arr[], int n)
{
    // Creates an empty hashset
    unordered_set<int> s;

    // Traverse the input array
    int res = 0;
    for (int i = 0; i < n; i++) {

        // If not present, then put it in
        // hashtable and increment result
        if (s.find(arr[i]) == s.end()) {
            s.insert(arr[i]);
            res++;
        }
    }

    return res;
}

// Driver program to test above function
int main()
{
    int arr[] = { 6, 10, 5, 4, 9, 120, 4, 6, 10 };
    int n = sizeof(arr) / sizeof(arr[0]);
    cout << countDistinct(arr, n);
    return 0;
}

 


Output
6
Set STL approach:
 

Sets are a type of associative containers in which each element has to be unique, because the value of the element identifies it. The value of the element cannot be modified once it is added to the set, though it is possible to remove and add the modified value of that element. We exploit the very basic property of set STL that it stores only unique numbers.

Examples: Arr = [1,2,2,2,3,16,2,8,2,1,8]

Distinct elements present = [1,2,3,16,8] 

Total number of distinct elements in the array are 5 

Algorithm :

 

1. Insert all the elements into the set S one by one.





 

2.  Store the total size s of the set using set::size().

3.The total size s is the number of distinct elements present in the array.

  import java.util.*;
  class GFG
  {

    // function that accepts the array and it's size and returns
    // the number of distince elements
    static int distinct(int[] arr, int len)
    {
      HashSet<Integer> S = new HashSet<>(); // declaring a set container using STL
      for (int i = 0; i < len; i++) {
        S.add(arr[i]); // inserting all elements of the
        // array into set
      }
      int ans = S.size(); // calculating the size of the set
      return ans;
    }

    // Driver code
    public static void main(String[] args)
    {
      int arr[] = { 12, 10, 9, 45, 2, 10, 10, 45};
      int l = arr.length; // calculating the size of the array
      int dis_elements
        = distinct(arr, l); // calling the function on array
      System.out.print(dis_elements +"\n");
    }
  }

  // This code is contributed by Rajput-Ji 
 


Output
5
 * 
 */




/*
Given an array which may contain duplicates, print all elements and their frequencies.

Examples: 

Input :  arr[] = {10, 20, 20, 10, 10, 20, 5, 20}
Output : 10 3
         20 4
         5  1

Input : arr[] = {10, 20, 20}
Output : 10 1
         20 2 

A simple solution is to run two loops. For every item count number of times, it occurs. To avoid duplicate printing, keep track of processed items. 
 


// Java program to count frequencies of array items
import java.util.Arrays;

class GFG
{
public static void countFreq(int arr[], int n)
{
    boolean visited[] = new boolean[n];
    
    Arrays.fill(visited, false);

    // Traverse through array elements and
    // count frequencies
    for (int i = 0; i < n; i++) {

        // Skip this element if already processed
        if (visited[i] == true)
            continue;

        // Count frequency
        int count = 1;
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                visited[j] = true;
                count++;
            }
        }
        System.out.println(arr[i] + " " + count);
    }
}

// Driver code
public static void main(String []args)
{
    int arr[] = new int[]{ 10, 20, 20, 10, 10, 20, 5, 20 };
    int n = arr.length;
    countFreq(arr, n);
}
}

// This code contributed by Adarsh_Verma.



 


Output
10 3
20 4
5 1
 

Time Complexity : O(n2) 
Auxiliary Space : O(n)

An efficient solution is to use hashing.

 


// Java program to count frequencies of array items
import java.util.*;

class GFG
{

    static void countFreq(int arr[], int n)
    {
        Map<Integer, Integer> mp = new HashMap<>();

        // Traverse through array elements and
        // count frequencies
        for (int i = 0; i < n; i++)
        {
            if (mp.containsKey(arr[i])) 
            {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } 
            else
            {
                mp.put(arr[i], 1);
            }
        }
        // Traverse through map and print frequencies
        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    // Driver code
    public static void main(String args[]) 
    {
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};
        int n = arr.length;
        countFreq(arr, n);
    }
}

// This code contributed by Rajput-Ji



 


Output
5 1
10 3
20 4
 

Time Complexity : O(n) 
Auxiliary Space : O(n)

In above efficient solution, how to print elements in same order as they appear in input? 

 


// Java program to count frequencies of array items 
import java.util.*;

class GFG 
{

    static void countFreq(int arr[], int n) 
    {
        Map<Integer, Integer> mp = new HashMap<>();

        // Traverse through array elements and 
        // count frequencies 
        for (int i = 0; i < n; i++)
        {
            mp.put(arr[i], mp.get(arr[i]) == null ? 1 : mp.get(arr[i]) + 1);
        }

        // To print elements according to first 
        // occurrence, traverse array one more time 
        // print frequencies of elements and mark 
        // frequencies as -1 so that same element 
        // is not printed multiple times. 
        for (int i = 0; i < n; i++) 
        {
            if (mp.get(arr[i]) != -1) 
            {
                System.out.println(arr[i] + " " + mp.get(arr[i]));
                mp.put(arr[i], -1);
            }
        }
    }

    // Driver code
    public static void main(String[] args) 
    {
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};
        int n = arr.length;
        countFreq(arr, n);
    }
}

// This code contributed by Rajput-Ji


 


Output
10 3
20 4
5 1
 

Time Complexity : O(n) 
Auxiliary Space : O(n)

This problem can be solved in Java using Hashmap. Below is the program. 

 



// Java program to count frequencies of
// integers in array using Hashmap
import java.io.*;
import java.util.*;
class OccurenceOfNumberInArray {
    static void frequencyNumber(int arr[], int size)
    {
        // Creating a HashMap containing integer
        // as a key and occurrences as a value
        HashMap<Integer, Integer> freqMap
            = new HashMap<Integer, Integer>();

        for (int i=0;i<size;i++) {
            if (freqMap.containsKey(arr[i])) {

                // If number is present in freqMap,
                // incrementing it's count by 1
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            }
            else {

                // If integer is not present in freqMap,
                // putting this integer to freqMap with 1 as it's value
                freqMap.put(arr[i], 1);
            }
        }

        // Printing the freqMap
        for (Map.Entry entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};
        int size = arr.length;
        frequencyNumber(arr,size);
    }
}


 


Output
5 1
10 3
20 4

*/