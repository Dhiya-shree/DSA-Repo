package impAlgorithm_array_search;

import searchSortCode.Search01;

/**
 * Infinite array - array where we don't know the length , and large large array 
 * Length can be of millions and questions might be asked to not search for length 
 *  
 *  
 * -------------------------------------------------------------------------------------------------------------
 * Problem #1 : Unbounded Binary Search 
 * 
 * determine the presence or absence of a given target element in the array
 * 
 * Naive Solution :
 * As the length is not known - can not use binary search 
 * 
 * 1) Loop from 1 to N 
 *     If arr[i]== search return i ;
 *     else if arr[i]>search return -1 ;
 *     
 *  Time complextity based on position , worst case can be at n 
 *  O(n)  
 *  
 *  
 *  Efficient solution :
 *  
 *  1) Loop from i= 1 to X , i=i*2 ( Search on 1,2,4,8,16,32 ... Log (pos)
 *        If arr[i]== search return i ;
 *        else if arr[i]>search return BinarySearch(arr, search, left = (i/2)+1 , right = (i*2)-1)
 *        
 *   TimeComplextity - Searching range of pos O log 2*pos + Binary O log N 
 *   Time Complexity - O(log 2*pos) + O log(pos) -> O(log pos)
 *   
 *    * Suppose you have a sorted array of infinite numbers, how would you search an
 * element in the array?
 * 
 * Since array is sorted, the first thing clicks into mind is binary search, but
 * the problem here is that we don’t know size of array.
 * If the array is infinite, that means we don’t have proper bounds to apply binary search.
 * In order to find position of key, first we find bounds and then apply binary search algorithm. 
 * 
 * Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element, 
 * ->if it is greater than high index element then copy high index in low index and double the high index.
 * ->if it is smaller, then apply binary search on high and low indices  found.
 * 
 * 
 * Approach: The problem can be solved based on the following observation: 
 * Since array is sorted we apply binary search but the length of array is infinite so that we take start = 0 and end = 1 .
 * After that check value of target is greater than the value at end index,if it is true then change newStart = end + 1  and 
 *                          newEnd = end +(end – start +1)*2 and apply binary search .
 *    Otherwise , apply binary search in the old index values.
 *    
 *    
 *  Let p be the position of element to be searched. Number of steps for finding high index ‘h’ is O(Log p). \
 *  The value of ‘h’ must be less than 2*p. The number of elements between h/2 and h must be O(p).
 *   Therefore, time complexity of Binary Search step is also O(Log p) and overall time complexity is 2*O(Log p) which is O(Log p)
 *
 * 
 * 
 * @author shree
 *
 */
public class InfiniteArray_Problem {

	public static void main(String[] args) {
		
		int arrInfinite[]= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		int search=16;
		//int n=arr.length;   -_- Can not do , infinte array , you find the bound 
		
		int ans2=UnboundedBinarySearch(arrInfinite,search);
		System.out.println(" Ans unbounded search  "+ans2);
	}

	private static int UnboundedBinarySearch(int[] arrInfinite, int search) {
		// Infinite array search an element 
		//for(int i=0;i<n
		// Can not use above , no N is there 
		int i=1;
		while(i<=search) {
			i=i*2;
		}
		if(i==search) {
			return i;
		}
		else {
			int low=(i/2)-1;
			int high=(i)-1;
			int ans=0;
			// ;) , Can use Iterative , need to send n as high+1
			ans=Search01.BinarySearchRecursion(arrInfinite,low,high,search);
			return ans;
		}
	}
}
