package Sort_Types_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import arrayCode.ArrayPart01;

/**
 * 
 * Problem #1: Count the number of possible triangles
 * Given an unsorted array arr[] of n positive integers. Find the number of triangles
 *  that can be formed with three different array elements as lengths of three sides of triangles. 
 * 
 * Given an unsorted array of positive integers, find the number of triangles that can be formed with three different array elements as three sides of triangles. For a triangle to be possible from 3 values, the sum of any of the two values (or sides) must be greater than the third value (or third side). 
Examples: 

Input: arr= {4, 6, 3, 7}
Output: 3
Explanation: There are three triangles 
possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. 
Note that {3, 4, 7} is not a possible triangle.  

Input: arr= {10, 21, 22, 100, 101, 200, 300}.
Output: 6

Explanation: There can be 6 possible triangles:
{10, 21, 22}, {21, 100, 101}, {22, 100, 101}, 
{10, 100, 101}, {100, 101, 200} and {101, 200, 300}
 * 
 * 
 * 
 * Problem # 2 :Sort by aboslute diff 
 * 
 * Given an array of N elements and a number K. The task is to arrange array elements according to the absolute difference with K, i. e., element having minimum difference comes first and so on.
Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.

Brute Force Approach
Intuition
The idea is to use a multimap that stores key-value pairs and can have multiple values for a key. the map uses the difference of the array's element with X as the key and the array element as the value. After that Update the values of the array by iterating over the map.

Implementation
Steps:-

Store the values in the multimap with the difference of array elements with X as the key.
In multimap, the values will be already in sorted order according to key i.e. difference with X because it implements self-balancing-binary-search-tree internally.
Update all the values of an array with the values of the map so that the array has the required output.
Below is the implementation of the above approach:

Complexity
Time Complexity: O(N Log N), Map takes NlogN time to store elements in sorted order.
Auxiliary Space: O(N), Map takes O(N) space to store elements.
 * 
 * 
 * Expected Approach
Intuition
In C++, we can use stable_sort(), operator overloading with the help of a class, and customize sorting according to the need of the question or write a lambda expression for the custom comparator function inside the stable_sort function.

Implementation
Steps:-

Create our comparator function which returns true if absolute diff with the first element and x is less than the second element else return false.
Pass this comparator function as a third parameter inside the stable_sort function to overload the comparison operator according to our comparator function.
Complexity
Time Complexity: O(N Log N), Sorting takes NlogN time.
Space Complexity: O(1), Inbuilt sorting works in O(1) space.
 * 
 * 
 * 
 * Problem #3: Triplet sum 
 * Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X
 * 
 * 
 * 
 * 
 * Problem #4 :  Closer sort
 * 
 * Given an array arr[](0-based indexing) of N integers which is closer sorted (defined below) and an element x. The task is to find the index of element x if it is present. If not present, then print -1.
Closer Sorted: The first array is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e, maybe to the arr[i+1] or arr[i-1].
 *
 * 
 * 
 * Problem #5 : Number of pairs 
 * Given two arrays X and Y of positive integers, 
 * find the number of pairs such that xy > yx (raised to power of) where x is an element from X and y is an element from Y.
 * 
 * x^ y> y^x
 * 
 * x^y/y^x>1
 * 
 * 
 * @author shree
 *
 */


class sortABS implements Comparator<Integer>{

	int K;
	//Integer a;
	sortABS(int k){
		this.K=k;
	}
	public int compare(Integer a ,Integer b) {
		return (Math.abs(a-K)-Math.abs(b-K));
	}
}



public class Sort26_Sort_Problems {

	public static void main(String[] args) {
	  
		int arr[] ={26 ,9 ,27 ,22 ,16 ,27};// {6, 4, 9, 7, 8};
		int n=arr.length;
		
		/*Method 3: The time complexity can be greatly reduced using Two Pointer methods in just two nested loops.

Approach: 

First sort the array, and run a nested loop, fix an index and then try to fix an upper and lower index within which we can use all the lengths to form a triangle with that fixed index.

Algorithm:

Sort the array and then take three variables l, r and i, pointing to start, end-1 and array element starting from end of the array.
Traverse the array from end (n-1 to 1), and for each iteration keep the value of l = 0 and r = i-1
Now if a triangle can be formed using arr[l] and arr[r] then triangles can obviously formed 
from a[l+1], a[l+2].....a[r-1], arr[r] and a[i], because the array is sorted , which can be directly calculated using (r-l). and then decrement the value of r and continue the loop till l is less than r
If a triangle cannot be formed using arr[l] and arr[r] then increment the value of l and continue the loop till l is less than r 
 
So the overall complexity of iterating 
through all array elements reduces.
		 * 
		 */
		int ans=CoutNoOfTriange(arr,n);
		System.out.println(" Ans "+ans);
		
		ans=CountNoOfTriangle_Two_PointerGoG(arr,n);
		System.out.println(" Ans Gog Two Pointer "+ans);
		
		List<Integer> sortu=new ArrayList<Integer>();
		int K=7;
		sortu.add(10);
		sortu.add(9);
		sortu.add(5);
		sortu.add(3);
		sortu.add(2);
		//int n1=sortu.length;
		SortByAbsiff(sortu,K);
		
		List<Integer> sortu2=new ArrayList<Integer>();
		//int K=7;
		sortu2.add(10);
		sortu2.add(9);
		sortu2.add(5);
		sortu2.add(3);
		sortu2.add(2);
		//int n1=sortu.length;
		SortByAbsiffGoGSingleLine(sortu,K);
		SortByAbsiffGoG(sortu,K);
		
		int trip[]= {1 ,4 ,45, 6, 10, 8};
		int sum=13;
		int nt=trip.length;
		boolean an=find3Numbers(trip,nt,sum);
		System.out.println(" ans 333 ::"+an);
		
		
		
		int close[]= {230 ,433 ,451, 476, 612, 631, 643, 695, 938, 794};
				//{83 ,96 ,139 ,155, 243, 270, 276, 320, 339, 361, 380, 453, 555, 873, 867 ,909 ,911 ,926 ,940}; //{3, 2 ,10, 4, 40};
		int find=794;
	    ans=PositionInCloser(close,close.length,find);
	    System.out.println(" It is in pos "+ans);
	    
	    
	    int count[]= {2,3,4,5};
	    int count2[]= {1,2,3};
	    ans=countPairs(count,count2,count.length,count2.length);
	    System.out.println(" No of pairs "+ans);
	}
	
	private static int countPairs(int x[], int y[], int M, int N)
    {
        // your code here
        long count=(long)0;
        Arrays.sort(y);
        System.out.println(" Sorted Y ");
        ArrayPart01.PrintRayy(y);
        Arrays.sort(x);
        System.out.println(" Sorted X ");
        ArrayPart01.PrintRayy(x);
        int start=0; int start2=0;
       
//        while(x[start2]==1){
//            
//                start2++;
//                System.out.println(" Saw 1 in x "+start2);
//        }
    //    M=start
         while(y[start]==1){
            
                count=count+(M);
                start++;
                System.out.println(" Saw 1 in y "+start);
            
           
        }
        int j=0;//double val1=0;double val2=0;
        //int j=0;
        for(int i=start2;i<M;i++){
            j=start;
           if(x[i]==1) {
        	   continue;
           }
           else if(x[i]==2) {
               //skip=j;
        	   System.out.println(" Xi is 2 "+x[i]);
        	   while(j<N&&(y[j]==2|| y[j]==3||y[j]==4)) {
        		   System.out.println(" J "+y[j]);
        		   j++;
        		   
        	   }
        	   System.out.println(" J is "+j+"..adding n-j"+(N-j));
        	   count=count+(N-j);
        	 //  skip=0;
           }
           else if(x[i]==3) {
        	 //  j=j;
        	   System.out.println(" Xi is <5 "+x[i]);
        	   while(j<N && (y[j]==2|| y[j]>x[j])) {
        		   System.out.println(" J "+y[j]);
        		   j++;
        		  
        	   }
        	   System.out.println(" J is "+j+"..adding n-j"+(N-j));
        	   count=count+(N-j);
        	  // j=0;
           }
           else if(x[j]==4) {
        	   System.out.println(" Xi is4 "+x[i]);
        	   while(j<N && (y[j]==2||y[j]==3|| y[j]>x[j])) {
        		   System.out.println(" J "+y[j]);
        		   j++;
        		  
        	   }
        	   System.out.println(" J is "+j+"..adding n-j"+(N-j));
        	   count=count+(N-j);
           }
           else {
        	   System.out.println(" Xi is "+x[i]);
        	   while(j<N && y[j]<x[i]) {
        		   System.out.println(" J "+y[j]);
        		   j++;
        		  
        	   }
        	   System.out.println(" J is "+j+"..adding n-j"+(N-j));
        	   count=count+(N-j);
        	 //  j=0;
           }
            
        }
        return (int) count;
	}

	private static int PositionInCloser(int[] arr, int n, int find) {
		// Closer is sorted array disposed a bit left or right 
		
		int left=0;
		int right=n-1;
		int mid=0;int swap=0;
		while(left<right) {
			System.out.println(" Before swap ");
			ArrayPart01.PrintRayy(arr);
			mid=(left+right)/2;
			System.out.println("Mid "+mid+"...."+arr[mid]+"...With left&right as "+left+"-"+right);
			if(arr[mid]==find) {
				System.out.println(" In mid+1 "+(mid)+"...val"+arr[mid]);
				return mid;
			}
			if(mid+1<n) {
			  if(arr[mid+1]==find) {
				  
				  System.out.println(" In mid+1 "+(mid+1)+"...val"+arr[mid+1]);
				return mid+1;}
			  if(arr[mid]>arr[mid+1]) {
				  swap=arr[mid+1];
				  arr[mid+1]=arr[mid];
				  arr[mid]=swap;
			  }
			}
			if(mid-1>-1 ) {
				  if(arr[mid-1]==find) {
					  System.out.println(" In mid+1 "+(mid-1)+"...val"+arr[mid-1]);
						return mid-1;}
					  if(arr[mid]<arr[mid-1]) {
						  swap=arr[mid-1];
						  arr[mid-1]=arr[mid];
						  arr[mid]=swap;
					  }
					}
			System.out.println(" After swap ");
			ArrayPart01.PrintRayy(arr);
			if(find<arr[mid]) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		return -1;
	}

	public static boolean find3Numbers(int arr[], int n, int X) { 
	    
	       // Your code Here
	      // boolean ans=false;
	       Arrays.sort(arr);
	       System.out.println(" Sorted ");
	       ArrayPart01.PrintRayy(arr);
	       int sum=0;int p1=0;int p2=0;int remain=0;
	       for(int i=0;i<n-2;i++){
	           remain=X-arr[i];
	           System.out.println(" remain "+remain);
	           // Two pointer 
	           p1=i+1; p2=n-1;
	           while(p1<p2){
	               sum=arr[p1]+arr[p2];
	               System.out.println(" Sum "+sum+" .. of "+arr[p1]+"+"+arr[p2]);
	               if(remain==sum){
	            	   System.out.println(" Ans ");
	                   return true;
	               }
	               if(remain>sum){
	                   p1++;
	               }
	               else{
	                   p2--;
	               }
	           }
	       }
	       return false;
	    
	    }
    
	private static void SortByAbsiffGoG(List<Integer> arr, int k) {
		// GoG
		 Collections.sort(arr, 
		            new Comparator<Integer>(){
		                //Comparing integers based on their absolute difference with the given number.
		                public int compare(Integer x, Integer y){
		                    return (int)(Math.abs(x - k) - Math.abs(y - k));
		                }
		            }
		        );
		System.out.println(" Sorted stable Comparator inside  "+arr);
	}

	private static void SortByAbsiffGoGSingleLine(List<Integer> arr, int k) {
		// Collection sort 
		
		Collections.sort(arr,  (a, b) -> Math.abs(k - a) - Math.abs(k - b));
		
		System.out.println(" Sorted stable Arrow function  "+arr);
	}

	private static void SortByAbsiff(List<Integer> arr, int k) {
		// Sort by abs with K 
		//Use collections sort 
		// Comparator - extrenal 
		// COmparable interal  as it is type list no use of comparable 
		// Use comparator 
		
		//Create comparator class
		System.out.println(" Unsorted "+arr.toString());
		sortABS obj = new sortABS(k);
		Collections.sort(arr,obj);
		// CReate a comparable 
		System.out.println(" Stable sorte Comparator outside "+arr.toString());
		
	}

	private static int CountNoOfTriangle_Two_PointerGoG(int[] arr, int n) {
		// Time O n2
		Arrays.sort(arr);

        int count = 0;

        for (int i = n - 1; i >= 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) {

                    // If it is possible with a[l], a[r]
                    // and a[i] then it is also possible
                    // with a[l+1]..a[r-1], a[r] and a[i]
                    count += r - l;

                    // checking for more possible solutions
                    r--;
                }
                else // if not possible check for
                // higher values of arr[l]
                {
                    l++;
                }
            }
        }
        System.out.print("No of possible solutions: " + count);
		return count;
	}

	private static int CoutNoOfTriange(int[] arr, int n) {
		//Triange sum of two sides , greater than third 
		Arrays.sort(arr);
		System.out.println(" Sorted ...");
		ArrayPart01.PrintRayy(arr);
        int count=0;
        //--fixed --1 --2 , 1 and 3 can be in 4 numbers 6,7,8,9 - 1to 4 
        // 4 6 7 etc 4,6 - 3 , 4,7-2  , 4,8 -1 
        // 4 -3 -2
        // p2-p1 * p2-p1-1
        
        // 6 7 8 9 - 2 to 4 
        // 6 7 ..2 6 8 ..1 
        // 6 -2 -1
        // p2-p1-1 * p2-p1
        
        // 7 8 9 -3 to 4 
        // 7 8 .. 1 
        // p2-p1 * p2-p1-1
        int sum=0;
        for(int i=n-1;i>1;i--){
            int p1=0;int p2=i-1;
            
            System.out.println(" P 1 "+p1+" P2 "+p2);
            // 1 2 3 4 5 6 7 8 9
            while(p1<p2){
            	sum=arr[p2]+arr[p1];
            	System.out.println(" arrp2 "+arr[p2]+" Arr p1 "+arr[p1]+" VAL - "+(arr[p2]-arr[p1])+"...sum"+sum+"...compare....arr[i]:-"+arr[i]);
            	if( sum>arr[i]) {
            		
            			System.out.println(" P2-p1 :"+(p2-p1));
            		count=count+(p2-p1);
            		//break;
            		System.out.println(" Counted "+count);
            		//continue;
            	///break;
            		//}
            		p2--;
            	}
            	else {
            		p1++;
            	}
            	
         
            }
            
        }
        return count;
        //return count;
	}
}
