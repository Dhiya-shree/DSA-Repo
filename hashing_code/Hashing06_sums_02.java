package hashing_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Problem #1 : Sorting Elements of an Array by Frequency
 * Given an array of integers, sort the array according to frequency of elements. 
 * That is elements that have higher frequency come first. 
 * If frequencies of two elements are same, then smaller number comes first.
 * 
 * Problem # 2 : Sort a array according to other 
 * Given two integer arrays A1[ ] and A2[ ] of size N and M respectively. Sort the first array A1[ ] such that all the relative positions of the elements in the first array are the same as the elements in the second array A2[ ].
See example for better understanding.
Note: If elements are repeated in the second array, consider their first occurance only.
 * 
 * 
 * Problem # 3 : Fist Repeating element 
 * Given an array arr[] of size n, find the first repeating element. The element should occur more than once and the index of its first occurrence should be the smallest.

Note:- The position you return should be according to 1-based indexing. 
 * 
 * Problem # 4 :  Intersection and union 
 * Given two arrays a[] and b[] respectively of size n and m, the task is to print the count of elements in the intersection (or common elements) of the two arrays.
For this question, the intersection of two arrays can be defined as the set containing distinct common elements between the two arrays. 

Given two arrays a[] and b[] of size n and m respectively. The task is to find the number of elements in the union between these two arrays.

Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in the union.

Note : Elements are not necessarily distinct.


 * Problem # 5 : Positive negative Pair 
 * 
 * Given an array of distinct integers, find all the pairs having both negative and positive values of a number in the array.

Given an array of distinct integers, find all the pairs having both negative and positive values of a number in the array.


 * 
 * @author shree
 *
 */


public class Hashing06_sums_02 {

	public static void main(String[] args) {
		// Problem 2
		
		////////////////////////////////////////////////////////////////////
		// sort 
		
				int arr[]= {1,2,2,5,5,8,3,4,10,11,17,5,12,15,17,23,12,14,15};
			     int n=arr.length;
			     ArrayList<Integer> ans2=SortAndShow(arr,n);
			     System.out.println(" ARRay "+ans2.toString());

			     int b[]= {1,2,3,4,5,20};
			     int m=b.length;
			     int ans[]=sortA1ByA2(arr, n, b, m);
			     System.out.println(" Ans "+Arrays.toString(ans));
		
			     int ans1=firstRepeated(arr, n);
			     System.out.println(" First repetaed small inex "+ans1);
			     
			     ans1=NumberofElementsInIntersection(arr, b,n, m);
			     System.out.println(" Intersected ele "+ans1);
			     
			     ans1=doUnion(arr, n, b, m);
			     System.out.println(" Union elements "+ans1);
			     
			     int arr2[]= {1,3,6,-2,-1,-3,2,7};
			     int n2=arr2.length;
			     ArrayList<Integer> ans3=findPairs(arr2,n2);
			     System.out.println(" Negative Positive pair "+ ans3.toString());
			     
	  }
	
	 public static int doUnion(int arr[], int n, int b[], int m) 
	    {
	        //Your code here
	         HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	       //  HashMap<Integer,Integer> h0=new HashMap<Integer,Integer>();
	     //  int small=Integer.MAX_VALUE;
	       //boolean flag=false;
	         for(int i=0;i<n;i++) {
	            // System.out.println(hm.toString());
					
							 hm.put(arr[i],i+1);
						 
					 }
					 
				//	 int ans=0;
					  for(int i=0;i<m;i++) {
	            // System.out.println(hm.toString());
					
				 hm.put(b[i],0);
					 
					 }
					 return hm.size();
	    }
	
	 public static ArrayList<Integer> findPairs(int arr[], int n) 
	    { 
	    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	    ArrayList<Integer> ans= new ArrayList<Integer>();
	       //  HashMap<Integer,Integer> h0=new HashMap<Integer,Integer>();
	     //  int small=Integer.MAX_VALUE;
	       //boolean flag=false;
	       int c=0;
	         for(int i=0;i<n;i++) {
	            // System.out.println(hm.toString());
					if(hm.containsKey(-1*arr[i]) ){
					    hm.put(arr[i],1);
					}
					else{
							 hm.put(arr[i],0);
					}
					
					 }
					 
				//	  System.out.println(hm.toString());
					// int ans=0;
					int val=0;//int con=0;
					  for(int i=0;i<hm.size();i++) {
	            // System.out.println(hm.toString());
	            c=hm.get(arr[i]);
					val=Math.abs(arr[i]);
					    if(c==1){
					        ans.add(-1*val);
					        ans.add(val);
					        
					       // c--;
					    }
					  //  hm.remove(arr[i]);
					  //  hm.remove(arr[i]*-1);
					   //  System.out.println(hm.toString());
					     //System.out.println(ans.toString());
					}
				 
					 
					 
					 return ans;
	    
	    }
	 
	public static int NumberofElementsInIntersection(int arr[], int b[], int n, int m) {
        // Your code here
          HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
       //  HashMap<Integer,Integer> h0=new HashMap<Integer,Integer>();
     //  int small=Integer.MAX_VALUE;
       //boolean flag=false;
         for(int i=0;i<n;i++) {
            // System.out.println(hm.toString());
				
						 hm.put(arr[i],i+1);
					 
				 }
				 
				 int ans=0;
				  for(int i=0;i<m;i++) {
            // System.out.println(hm.toString());
				
				if(hm.containsKey(b[i])){
				    ans++;
				    hm.remove(b[i]);
				}
						// hm.put(arr[i],i+1);
					 
				 }
				 return ans;
    }
	
	public static int firstRepeated(int[] arr, int n) {
        // Your code here
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
       //  HashMap<Integer,Integer> h0=new HashMap<Integer,Integer>();
       int small=Integer.MAX_VALUE;
       boolean flag=false;
         for(int i=0;i<n;i++) {
            // System.out.println(hm.toString());
					 if(hm.containsKey(arr[i])) {
					     flag=true;
					 small=Math.min(hm.get(arr[i]),small);
					 }
					 else {
						 hm.put(arr[i],i+1);
					 }
				 }
				 if(flag){
				     return small;
				 }
				 return -1;
    }
	
	  private static int[] sortA1ByA2(int arr[], int n, int A2[], int M)
	    {
	        //add arr a in hash with count 
	       int ans[]= new int[n]; int point=0;
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
					
					 // if b val prsent in Ans
				//	for(int i=0;i<n;i++) {
				//	    System.out.print(arr[i]+" ");}
					// Collections.sort(hm,new sortu);
						 int c=0;
		            for(int i=0;i<M;i++){
		                if(hm.containsKey(A2[i])){
		                    c=hm.get(A2[i]);
		                    while(c>=0){
		                        ans[point]=A2[i];
		                        if(c==0){
		                            hm.remove(A2[i]);
		                        }
		                        c--;point++;
		                        
		                    }
		                }
		            }
					 
		            // after removing others , sort in descending order 
					 LinkedList<Map.Entry<Integer, Integer> > list= new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
				     Collections.sort(list, new Comparator< Map.Entry<Integer, Integer>>() {
				            
	                        
							public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
								// Public compare method 
								// O2 first  - descending order 
								// O1 first - ascending order 
								int a=o1.getKey();
								int b=o2.getKey();
								return (a-b);
							}
							
						}
						  	);
				     
				     // add sorted in ans 
					//	  	System.out.println("Descending Sorted list"+list.toString());
						  	for(Map.Entry<Integer,Integer> mape :list) {
						  	    c=mape.getValue();
						  	    while(c>=0){
							ans[point]=mape.getKey();
							point++;
							c--;
						  	    }
						}
						return ans;
				       // System.out.println("Descending Sorted li
	    }
			private static ArrayList<Integer> SortAndShow(int[] arr, int n) {
				// Sort and show 
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
				// Collections.sort(hm,new sortu);
					 
				 
				 LinkedList<Map.Entry<Integer, Integer> > list= new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
			        System.out.println("Created linked list is "+list.toString());
			 
			        // Sort the list using lambda expression
			        // (o1,o2)-> o1.getValue.compareTo(o2.getValue)
			        //Use comparable 
			        
			        //O1 first - ascending 
			        //O2 first descending 
			      //  Collections.sort(list,(o1,o2)->o1.getValue().compareTo(o2.getValue()));
			        //System.out.println("Ascending Sorted linked list is "+list.toString());
			        
			        Collections.sort(list, new Comparator< Map.Entry<Integer, Integer>>() {

						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							// Public compare method 
							// O2 first  - descending order 
							// O1 first - ascending order 
							int a=o1.getValue();
							int b=o2.getValue();
							if(a==b) {
								return(o1.getKey()-o2.getKey());
							}
							return (b-a);
						}
						
					}
					  	);
			        System.out.println("Descending Sorted linked list is "+list.toString());
			        
			        hm.clear();
					//Puting sorted linked list to HM 
					for(Map.Entry<Integer,Integer> mape :list) {
						ans.add(mape.getKey());
					}
				return ans;
			}
			

		}