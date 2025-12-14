package searchSortCode;

/**
 * Problem #1 & #2 : Index of first Occurrence and last Occurrence in Sorted
 * 
 * Problem #3 : Count Occurrences in Sorted
 * Find First and last Occurrences and subtract it 
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[].
 * Expected time complexity is O(Logn) 
 * 
 * 
 * Problem # 4:Count More than n/k Occurences
 * 
 * Given an array arr[] of size N and an element k. 
 * The task is to find all elements in array that appear more than n/k times.
 * 
 * 	/**
		 * Yes, your code can be further optimized. Instead of iterating over the entire array to find the maximum element, 
		 * you can use the Arrays.sort() method to sort the array in ascending order. 
		 * Then, you can directly access the last element of the sorted array to get the maximum value. 
		 * This will reduce the time complexity of finding the maximum element from O(n) to O(log n).
		 *

 * Problem #5 : Count 1s in a Sorted Binary Array
 *   Find first occurence of 1 
 *   Subtrat length - first occur 
 *   If first occur= -1 return 0 
 *   In this particular problem, we are presented with a sorted binary array, which consists solely of 0's and 1's.
 *    Our objective is to determine the frequency of 1's in the array by utilizing the technique of binary search.
 * 

 * \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
 * Given a sorted array arr[] with possibly duplicate elements, the task is to
 * find indexes of the first and last occurrences of an element x in the given
 * array.
 * 
 * 
 * Naive Approach:
 * 
 * The idea to solve this problem is iterate on the elements of given array and
 * check given elements in an array and keep track of first and last occurrence
 * of the found element’s index. Below are the steps to implement the above
 * idea: Run a for loop and for i = 0 to n-1 Take first = -1 and last = -1 When
 * we find an element first time then we update first = i We always update
 * last=i whenever we find the element. We print first and last.
 * 
 * An efficient approach using binary search: \ 1. For the first occurrence of a
 * number a) If (high >= low) b) Calculate mid = low + (high – low)/2; c) If
 * ((mid == 0 || x > arr[mid-1]) && arr[mid] == x) return mid; d) Else if (x >
 * arr[mid]) return first(arr, (mid + 1), high, x, n); e) Else return first(arr,
 * low, (mid -1), x, n); f) Otherwise return -1;
 * 
 * 2. For the last occurrence of a number a) if (high >= low) b) calculate mid =
 * low + (high – low)/2; c)if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x
 * ) return mid; d) else if(x < arr[mid]) return last(arr, low, (mid -1), x, n);
 * e) else return last(arr, (mid + 1), high, x, n); f) otherwise return -1;
 * 
 * -----------------------------------------------------------------------------------------------------------
 * An Iterative Implementation of Binary Search Solution : For the first
 * occurrence, we will first find the index of the number and then search again
 * in the left subarray as long as we are finding the number.
 * 
 * For the last occurrence, we will first find the index of the number and then
 * search again in the right subarray as long as we are finding the number
 *  First occurrence: 
 *  Do while low <= high: First, find the mid element 
 *  Check if the arr[mid] > x then the first element will occur on the left side of mid. So,
 * bring the high pointer to mid – 1 Check if the arr[mid] < x then the first
 * element will occur on the right side of mid. So, bring the low pointer to mid
 * + 1 If arr[mid] == x then this may be the first element. So, update the
 * result to mid and move the high pointer to mid – 1. Return the result. 
 * 
 * Last
 * occurrence:
 * 
 * Do while low <= high: First, find the mid element Check if the arr[mid] > x
 * then the last element will occur on the left side of mid. So, bring the low
 * pointer to mid – 1 Check if the arr[mid] < x then the last element will occur
 * on the right side of mid. So, bring the low pointer to mid + 1 If arr[mid] ==
 * x then this may be the last element. So, update the result to mid and move
 * the low pointer to mid + 1. Finally, Return the result.
 * 
 */
public class Search03 {

	public static void main(String[] args) {
		int arr[]= {0,0,0,1,1,2,3,4,5,5,6,7,8,9,10};
		int element=5;
		int n=arr.length;
		
		for(int i=0;i<n;i++){
		System.out.println(i+" Arr "+arr[i]);
		
		}
		
		int ans=0;
//		//Non efficient -Time n/2 not log n  - wrong 
		ans=FindTheFirstOccur(arr,element,n);
		System.out.println(" First occur ans us "+ans+" val is "+(arr[ans]));
		ans=FindTheLastOccur(arr,element,n);
		System.out.println(" First occur ans us "+ans+" val is "+(arr[ans]));
		
		//Efficient iterative O log n
		ans=FindTheFirstOccurEffiIterative(arr,element,n);
		System.out.println(" First occur ans us "+ans+" val is ");//+(arr[ans]));
		ans=FindTheLastOccurEffiIterative(arr,element,n);
		System.out.println(" First occur ans us "+ans+" val is ");//+(arr[ans]));
		

		//Efficient iterative O log n
		ans=FindTheFirstOccurEffiRecur(arr,element,n-1,0);
		System.out.println(" First occur ans us "+ans+" val is ");//+(arr[ans]));
		ans=FindTheLastOccurEffiRecur(arr,element,n-1,0,n-1);
		System.out.println(" First occur ans us "+ans+" val is ");//+(arr[ans]));
		
		//Freq of occurence in sorted array 
		
		ans= FindTheFreqSorted(arr,n,element);
		System.out.println(" Freq of sorted is "+ans);
		
		ans= FindTheFreqSortedEficient(arr,n,element);
		System.out.println(" Freq of sorted is "+ans);
		
		// Find all >n/k occur
		
		int k=5;
		
		ans=FindAllAboveGiven(arr,n,k);
		System.out.println(" Elements above n/k given above count "+ans);
		
		/// Count in sorted binary array 
		
		int bin[]= {0,0,0,0,0,0};
		n=bin.length;
		
		ans=CountOneInSorted(bin,n);
		System.out.println(" No of 1 is "+ans);
		
		ans=CountOneInSortedRev(bin,n);
		System.out.println(" No of 1 is sorted  "+ans);
	}

	
	private static int CountOneInSortedRev(int[] bin, int n) {
		// TODO Auto-generated method stub
		//int element=1;
		int ans=-1;
		int low=0;
		int high =n-1;
		int mid=0;int mide=0;
		
		while(low<=high) {
			mid=(int) Math.floor((low+high)/2);
			mide=bin[mid];
			System.out.println("Last tuu  Low "+low+" High "+high+" Mid "+mid+" ele "+mide);
			if(mide==1) {
				if(mid==n-1 || bin[mid+1]==0) {
					ans=mid;
					break;
				}
				else {
					low=mid+1;
				}
			}
			else {
				high=mid-1;
			}
		}

		System.out.println(" last "+ans);
		if(ans==-1) {
			return 0;
		}
		return (ans+1);
	}


	private static int CountOneInSorted(int[] bin, int n) {
		// Count no of 1 in sorted array 
		//Setting element as 1 
		int first = FindTheFirstOccurEffiIterative(bin,1, n);
		if(first ==-1) {
			return 0;
		}
		return (n-first);
	}


	private static int FindAllAboveGiven(int[] arr, int n, int k) {
		// Find freq of all 
		
		//optimize 
		/**
		 * Yes, your code can be further optimized. Instead of iterating over the entire array to find the maximum element, 
		 * you can use the Arrays.sort() method to sort the array in ascending order. 
		 * Then, you can directly access the last element of the sorted array to get the maximum value. 
		 * This will reduce the time complexity of finding the maximum element from O(n) to O(log n).
		 */
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(max,arr[i]);
		}
		int[] arr2=new int[max+1];
		int count=0;
		
		for(int i=0;i<n;i++) {
			arr2[arr[i]]=arr2[arr[i]]+1;
		}
		
		int must= (n/k);
		System.out.println(" Must "+must);
		for(int i=0;i<=max;i++) {
			System.out.println(" Arr "+arr2[i]);
			if(arr2[i]>must) {
				count++;
			}
		}
		return count;
	}


	private static int FindTheFreqSortedEficient(int[] arr, int n, int element) {
		// efficient 
		int first =FindTheFirstOccurEffiRecur(arr,element,n-1,0);
		System.out.println(" First occur ans us "+first);
		if(first==-1) {
			return 0;
		}
		else {
		int last =FindTheLastOccurEffiRecur(arr,element,n-1,0,n-1);
		System.out.println("last occur ans us "+last);
		
		return (last-first+1);}
	}


	private static int FindTheFreqSorted(int[] arr, int n, int element) {
		//Find last and first occurence , last - first gives ans 
		int first =FindTheFirstOccurEffiRecur(arr,element,n-1,0);
		System.out.println(" First occur ans us "+first);
		int last =FindTheLastOccurEffiRecur(arr,element,n-1,0,n-1);
		System.out.println("last occur ans us "+last);
		if(last==-1 &&first==-1) {
			return -1;
		}
		return (last-first+1);
	}


	private static int FindTheLastOccurEffiRecur(int[] arr, int element, int high, int low,int lengthper) {
		// effi recur
		if(low>high) {
			return -1;
		}
		int mid=(int) Math.floor((high+low)/2);
		int mide=arr[mid];
		int ans=0;
		
		System.out.println("Last uu recur --- - Low "+low+" High "+high+" Mid "+mid+" ele "+mide);
		if(mide==element) {
			if(mid==lengthper|| arr[mid+1]!=mide) {
				return mid;
			}
			else {
				low=mid+1;
				ans=FindTheLastOccurEffiRecur(arr, element, high, low,lengthper);
				return ans;
			}
		}
		else if(element < mide) {
			high=mid-1;
			ans=FindTheLastOccurEffiRecur(arr, element, high, low,lengthper);
			return ans;
		}
		else {
			low=mid+1;
			ans=FindTheLastOccurEffiRecur(arr, element, high, low,lengthper);
			return ans;
		}
		//return -1;
	}

	static int FindTheFirstOccurEffiRecur(int[] arr, int element, int high, int low) {
		// Effective recur 
		int mid=(int) Math.floor((high+low)/2);
		int mide=arr[mid];
		int ans=-1;
		if(low>high) {
			return -1;
		}
		System.out.println("First recur --- - Low "+low+" High "+high+" Mid "+mid+" ele "+mide);
		if(mide==element) {
			if(mid==0|| arr[mid-1]!=mide) {
				return mid;
			}
			else {
				high=mid-1;
				ans=FindTheFirstOccurEffiRecur(arr, element, high, low);
				return ans;
			}
		}
		else if(element < mide) {
			high=mid-1;
			ans=FindTheFirstOccurEffiRecur(arr, element, high, low);
			return ans;
		}
		else {
			low=mid+1;
			ans=FindTheFirstOccurEffiRecur(arr, element, high, low);
			return ans;
		}
		
	}

	private static int FindTheFirstOccurEffiIterative(int[] arr, int element, int n) {
		// work for cases like 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1.. here using prev we get o n/2 complexity 
		if(n==1) {
			return ((element==arr[0])?0:-1);
		}
		int low=0;
		int high =n-1;
		int mid=0;int mide=0;
		while(low<=high) 
		{
			mid=(int) Math.floor((low+high)/2);
			mide=arr[mid];
			
			System.out.println("Last - Low "+low+" High "+high+" Mid "+mid+" ele "+mide);
			if(mide==element) {
				if(mid==0 || arr[mid-1]!=mide) {
					return mid;
				}
				else {
					high=mid-1;
				}
			}
			
			else if(element<mide) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		
		return -1;
	}

	private static int FindTheLastOccurEffiIterative(int[] arr, int element, int n) {
		// work for cases like 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1.. here using prev we get o n/2 complexity 
		if(n==1) {
			return ((element==arr[0])?0:-1);
		}
		int low=0;
		int high =n-1;
		int mid=0;int mide=0;
		
		while(low<=high) {
			mid=(int) Math.floor((low+high)/2);
			mide=arr[mid];
			System.out.println("Last tuu  Low "+low+" High "+high+" Mid "+mid+" ele "+mide);
			if(mide==element) {
				if(mid==n-1 || arr[mid+1]!=mide) {
					return mid;
				}
				else {
					low=mid+1;
				}
			}

			else if(element>mide) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}

		return -1;
	}

	private static int FindTheLastOccur(int[] arr, int element, int n) {
		// first occur in sorted array 
		int curr=-1;
		int prev=0;
		int left=0;
		int high=n-1;
		int mid=0;
		int mide=0;
		while(left<=high) {
			mid=(int)Math.floor((left+high)/2);
			mide=arr[mid];
			System.out.println(" Mid "+mid+" left "+left +" righ "+high);
			if(mide==element) {
				curr=mid;
				break;
			}
			if(element>mide) {
				left=mid-1;
			}
			else {
				high=mid+1;
			}
			
		}
		
		if(curr==n-1||curr==-1) {
			return curr;
		}
		else {
			prev=curr+1;
		}
		
		while(arr[prev]==arr[curr] && prev<n-1) {
			curr=prev;
			prev=curr+1;
			System.out.println(" Curr "+curr+" prev "+prev);
		}
		if(prev==n-1 && arr[prev]==arr[curr]) {
			return prev;
		}
		return curr;
	}
	private static int FindTheFirstOccur(int[] arr, int element, int n) {
		// first occur in sorted array 
		int curr=0;
		int prev=0;
		int left=0;
		int high=n-1;
		int mid=0;
		int mide=0;
		while(left<=high) {
			mid=(int)Math.floor((left+high)/2);
			mide=arr[mid];
			System.out.println(" Mid "+mid+" left "+left +" righ tu2 "+high);
			if(mide==element) {
				curr=mid;
				break;
			}
			else if(element>mide) {
				left=mid-1;
			}
			else {
				high=mid+1;
			}
			
		}
		

		if(curr==n-1||curr==-1) {
			return curr;
		}
		else {
			prev=curr-1;
		}
		
		while(arr[prev]==arr[curr] && prev>0) {
			curr=prev;
			prev=curr-1;
			System.out.println(" Curr "+curr+" prev "+prev);
		}
		if(prev==0 && arr[prev]==arr[curr]) {
			return prev;
		}
		return curr;
	}
}
