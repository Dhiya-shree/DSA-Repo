package searchSortCode;

/**
 * 
 * WE also have --------------" JUMP SEARCH " ...............
 *  BINARY SEARCH     O(LOG N) 
 *  Time Complexity: O(Log2N), where N is the number of elements in the array.
 *  
 *  Problem #1 & #2 :
 *  1) Iterative 
 *  2) Recursive 
 *  -------------------------------------
 *  Binary Search Approach:
 *   
 *  Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half.
 *   The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n). 
 *  Binary Search Algorithm: The basic steps to perform Binary Search are:
 *  
 *  Begin with the mid element of the whole array as a search key.
 *  If the value of the search key is equal to the item then return an index of the search key.
 *  Or if the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half.
 *  Otherwise, narrow it to the upper half.
 *  Repeatedly check from the second point until the value is found or the interval is empty.
 *                high = mid - 1
 * 
 * 
 * Step-by-step Binary Search Algorithm: We basically ignore half of the elements just after one comparison.
 * Compare x with the middle element.
 * If x matches with the middle element, we return the mid index.
 * Else If x is greater than the mid element, then x can only lie in the right half subarray after the mid element.
 *  So we recur for the right half.
 * Else (x is smaller) recur for the left half
 * 
 * 
 * 
 * ----------------------JAVA 
 * 
 *  Java to perform Binary Search are:
 *  
 *  Arrays.binarySearch()
 *  Collections.binarySearch()
 *  
 *  Arrays.binarySearch() is the simplest and most efficient method to find an element in a sorted array in Java
 *  Declaration:
 *  public static int binarySearch(data_type arr, data_type key )
 *  
 *  Where data_type can be any of the primitive data types: byte, char, double, int, float, short, long and Object as well.
 *  Description: This method searches the specified array of the given data type for the specified value using the binary search
 *  algorithm. The array must be sorted prior to making this call.
 *    If it is not sorted, the results are undefined. 
 *    If the array contains multiple elements with the specified value, there is no guarantee which one will be found.
 *  Parameters:
 *  arr - the array to be searched
 *  key - the value to be searched for
 *  Return Value: It returns the index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). 
 *  The insertion point is defined as the point at which the key would be inserted into the array:
 *   the index of the first element greater than the key,or a.length if all elements in the array are less than the specified key
 *   Note that this guarantees that the return value will be >= 0 if and only if the key is found.
 *   
 *   -------------------------------------------------------------------------------------------------------------
 * The Collections.binarySearch() method:
 *  is a Collections class method in Java that returns position of an object in a sorted list
 *  
 *  Declaration:
 *  // Returns index of key in sorted list sorted in
 *  // ascending order
 *  public static int binarySearch(List slist, T key)
 *  // Returns index of key in sorted list sorted in
 *  // order defined by Comparator c.
 *  public static int binarySearch(List slist, T key, Comparator c)
 *  
 *  
 *  If key is not present, the it returns "(-(insertion point) - 1)". 
 *  The insertion point is defined as the point at which the key would be inserted into the list.
 *  
 *  The method throws ClassCastException if elements of list are not comparable using the specified comparator,
 *   or the search key is not comparable with the elements.
 *   
 *   
 *   -----------------------------------------------------------------------------------------------------------------------
 *   
 *   Probem #3:
 *   
 *   Given a sorted array arr[] of size N without duplicates, and given a value x.
 *    Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.
 *     Find the index of K(0-based indexing)
 *   
 * @author shree
 *
 */
public class Search01 {

	public static void main(String[] args) {
		
		int sorted[]= {1,2,3,4,5,6,7,8,9,10,11,12,12,13,14,15};
		int element=9;
		int n=sorted.length-1;
		int ans=BinarySearchIterative(sorted,n,element);
		System.out.println(" ans "+ans);
		
		ans=BinarySearchRecursion(sorted,0,n,element);
		System.out.println(" ans "+ans);
		
		//-----------------------------------------------------
		long sorted1[]={4,5,6,7,8,9,10,11,12,13,14,15};
		n=sorted1.length;
		long element1=4;
		ans= FloorInSortedArray(sorted1,n,element1);
		System.out.println(" Less than "+ans);
		
	}

	private static int FloorInSortedArray(long[] sorted, int n, long element) {
		// less than given element 
		int mid=0;
		int mide=0;
		int low=0;
		int high=n-1;
		//int flag=0;
		while(low<=high) {
			
			mid=(int) Math.floor((low+high)/2);
			mide= (int) (sorted[mid]);
			if(mide==element ) {
			//	flag=1;
				 break;
			}
			if(mide<element) {
				low=mid+1;
			}
			else {
				high=mid-1;
			}
			System.out.println(" MId no "+mid+" md ele "+mide +" Low no "+low+" High no "+high);
		}
		if(mid==0) {
			return -1;
		}
		else{///////////////////////////////////////////Thats it , dont complicate 
			return mid;
		}
		
	//	return -1;
	}

	public static int BinarySearchRecursion(int[] sorted,int low,int high, int element) {
		// recursion 
		int mid=(int) Math.floor((low+high)/2);
		int mide=(sorted[mid]);
		int ans=0;
		if(low>high) {
			return -1;
		}
		if(mide==element) {
			return mid;
		}
		if(mide<element) {
			low=mid+1;
			ans=BinarySearchRecursion(sorted,low,high,element);
		}
		else {
			high=mid-1;
			ans=BinarySearchRecursion(sorted,low,high,element);
		}
		return ans;
	}

	private static int BinarySearchIterative(int[] sorted, int n, int element) {
		// middle - low +high /2
		int mid=0;
		int mide=0;
		int low=0;
		int high=n;
		while(low<=high) {
			
			mid=(int) Math.floor((low+high)/2);
			mide=(sorted[mid]);
			if(mide==element) {
				return mid;
			}
			if(mide<element) {
				low=mid+1;
			}
			else {
				high=mid-1;
			}
			System.out.println(" MId no "+mid+" md ele "+mide +" Low no "+low+" High no "+high);
		}
		
		return -1;
	}
}
