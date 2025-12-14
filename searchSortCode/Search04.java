/**
 * 
 */
package searchSortCode;

/**
 * 
 * Problem #1 : Find the square root Given an integer X, find its square root.
 * If X is not a perfect square, then return floor(√x).
 * 
 * Naive Approach: To find the floor of the square root, try with all-natural
 * numbers starting from 1. Continue incrementing the number until the square of
 * that number is greater than the given number.
 * 
 * Follow the steps below to implement the above idea 1)Create a variable
 * (counter) i and take care of some base cases, (i.e when the given number is 0
 * or 1). 2)Run a loop until i*i <= n, where n is the given number. 3) Increment
 * i by 1. 4) The floor of the square root of the number is i – 1
 * 
 * Approach efficient #2 :
 * 
 * Square root an integer using Binary search: The idea is to find the largest
 * integer i whose square is less than or equal to the given number. The values
 * of i * i is monotonically increasing, so the problem can be solved using
 * binary search.
 * 
 * Below is the implementation of the above idea:
 * 
 * 1)Base cases for the given problem are when the given number is 0 or 1, then
 * return X; 2) Create some variables, for storing the lower bound say l = 0,
 * and for upper bound r = X / 2 (i.e, The floor of the square root of x cannot
 * be more than x/2 when x > 1).
 * 
 * 3)Run a loop until l <= r, the search space vanishes 4) Check if the square
 * of mid (mid = (l + r)/2 ) is less than or equal to X, 5)Ifyes then search for
 * a larger value in the second half of the search space, i.e l = mid + 1,
 * update ans = mid 6) Else if the square of mid is more than X then search for
 * a smaller value in the first half of the search space, i.e r = mid – 1
 * Finally, 7) Return the ans
 * 
 * 
 * 
 * -------------------------------------------------------------------------------------------------
 * 
 * Probem #2: Smallest Positive missing number
 * 
 * Use indexing
 * 
 * 1) Filter the array make everything as 0 if it is negative 2) Indexing : If
 * arr[i]<n , make the position -ve , arr[arr[i]]= -1*arr[arr[i]] If
 * arr[arr[i]]=0 , then arr[arr[i]]= -1*arr[i] 3) if arr[i]>=0 -( non negative
 * not present in array ) return i;
 * 
 * 4) Find max . if max==n , present in array sp return n+1 5) Else return n
 * 
 * 
 * No need to find max if follwed below but no change in complexities Use
 * indexing
 * 
 * 1) Filter the array make everything as 0 if it is negative 2) Indexing : If
 * arr[i]<n , make the position -ve , arr[arr[i]]= -1*arr[arr[i]] If
 * arr[arr[i]-1]=0 , then arr[arr[i]-1]= -1*arr[i] 3) if arr[i]>=0 -( non
 * negative not present in array ) return i+1;
 * 
 * 4) Find max . if max==n , present in array sp return n+1 5) Else return n
 * 
 * Yes, there is an alternate approach to solve this problem called the
 * "Indexing Method". In this approach, we iterate through the array and for
 * every positive element `x`, we mark `arr[x-1]` as negative. Finally, we
 * iterate through the array again and return the index+1 of the first positive
 * element. This approach has a time complexity of O(N) and an auxiliary space
 * complexity of O(1)
 * 
 * -----------------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #3 : Unbounded Binary Search
 * 
 * determine the presence or absence of a given target element in the array
 * 
 * Naive Solution : As the length is not known - can not use binary search
 * 
 * 1) Loop from 1 to N
 *  If arr[i]== search return i ;
 *  else if arr[i]>search
 * return -1 ;
 * 
 * Time complextity based on position , worst case can be at n O(n)
 * 
 * 
 * Efficient solution :
 * 
 * 1) Loop from i= 1 to X , i=i*2 ( Search on 1,2,4,8,16,32 ... Log (pos) 
 * If  arr[i]== search return i ; 
 * else if arr[i]>search return BinarySearch(arr,search, left = (i/2)+1 , right = (i*2)-1)
 * 
 * TimeComplextity - Searching range of pos O log 2*pos + Binary O log N Time
 * Complexity - O(log 2*pos) + O log(pos) -> O(log pos)
 * 
 * -------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #4 : Unbounded binary search in Binary array
 * 
 * Given an infinite sorted array consisting 0s and 1s. The problem is to find
 * the index of first ‘1’ in that array. As the array is infinite, therefore it
 * is guaranteed that number ‘1’ will be present in the array.
 * 
 * Approach: The problem is closely related to the problem of finding position
 * of an element in a sorted array of infinite numbers. As the array is
 * infinite, therefore we do not know the upper and lower bounds between which
 * we have to find the occurrence of first ‘1’.
 * 
 * Approach : 1) Find upper and lower bound ->Loop from i= 1 to X , i=i*2 (
 * Search on 1,2,4,8,16,32 ... Log (pos) If arr[i]== search return i ; else if
 * arr[i]>search return BinarySearch(arr, search, left = (i/2)+1 , right =
 * (i*2)-1) 2) Use binary search
 * 
 * Let p be the position of element to be searched. Number of steps for finding
 * high index ‘h’ is O(Log p). The value of ‘h’ must be less than 2*p. The
 * number of elements between h/2 and h must be O(p). Therefore, time complexity
 * of Binary Search step is also O(Log p) and overall time complexity is 2*O(Log
 * p)which is O(Log p)
 * 
 * ------------------------------------------------------------------------------------------------------------------------
 *
 * Problem #5 : Search in sorted Rotated array
 * 
 * In this problem we are given a sorted array that is rotated a certain number
 * of times . Our task is to detect the presence of a given target element in
 * the array . We will first have a look at the naive approach that requires
 * O(n) time complexity and later the Efficient approach which employs binary
 * search to achieve logarithmic time complexity .
 *  -----------------------------------------------------------------------------------------------
 * @author shree
 *
 */
public class Search04 {

	public static void main(String[] args) {
		// Complete it 
		

		int X=9883934;
		long ans=FindSquareRootBinary(X);
		System.out.println(" Floor square root "+ans);
		
		int arr[]= {3,4,-1,1};
		int n=arr.length;
		ans= SmallesPositiveMissing(arr,n);
		System.out.println(" Smallest missing "+ans);
		
		int arrInfinite[]= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		int search=16;
		//int n=arr.length;   -_- Can not do , infinte array , you find the bound 
		
		int ans2=UnboundedBinarySearch(arrInfinite,search);
		System.out.println(" Ans unbounded search  "+ans2);
		
		int arrInfiniteBinary[]= {0,0,0,0,
				1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
				1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
		};
		/** Above is infinite array can not fnd length*/
		ans2=UnboundedBinarySearchBinaryArray(arrInfiniteBinary);
		System.out.println(" Ans unbounded search  "+ans2);
		
		
		
int sortedRotateArr[]= {6 ,11 ,24 ,37 ,42};//{34,7,18,26};
//{145, 158 ,10 ,13 ,23 ,39 ,50 ,58 ,64 ,77 ,82 ,93 ,110 ,114 ,122 ,140};//{34,7,18,26};//{2, 3, 4, 5 ,6 ,7 ,8 ,9 ,10, 1};// {10,20,30,40,50,60,70,5,6,7,8};
		n=sortedRotateArr.length;
		search=1;
	//	ans2=SearchInRoteatedSorted(sortedRotateArr,n,search,0,n-1);
		
		System.out.println(" Search in sorted "+ans2);
		
       // ans2=SearchInRoteatedSortedGoG(sortedRotateArr,search);
		
		System.out.println(" Search in sorted GoG  "+ans2);
		
       ans2=SearchInRoteatedSortedItself(sortedRotateArr,((n-1)/2),search,0,n-1);
		
		System.out.println(" Search in sorted minimu  "+ans2+" value "+sortedRotateArr[ans2]);
		}

  static int prev_mid=0;
	private static int SearchInRoteatedSortedItself(int[] sortedRotateArr, int n, int search,int left , int right) {
		// Find the mid , comparing it to leftmost and rightmost we will know which is sorted half 
		
		int mid=(left+right)/2;
		System.out.println(".............................. Left "+left+" Right "+right+" Mid "+mid+" To search "+search);
		int mide=0;
		
		
		int leftmost=left;int rightmost=right;
			mide=sortedRotateArr[mid];
			if(mide==search) {
				System.out.println(" id same "+mide+" -"+search);
				return mid;
			}
			if((right-left)==1) {
				//int min=Math.min(sortedRotateArr[right])
				return right;
			}
		   //4 5 6 7 8 2 3 4 
			if(mide>sortedRotateArr[leftmost]) {
				System.out.println(" >>1>Search ");//+search+" < mide "+mide+"..."+mid);
				if(search<mide && search>=sortedRotateArr[leftmost] ) {
					System.out.println("-------11111 Left is sorted ");
					prev_mid=leftmost;
					
					rightmost=mid-1;
					System.out.println(" Right change "+rightmost);
				//	return (SearchInRoteatedSortedItself(sortedRotateArr,n, search,leftmost,rightmost));
				}
				else {
					
					leftmost=mid+1;
					System.out.println(" Left change "+leftmost);
					//System.out.println(" Rightmost "+rightmost+ " left "+leftmost);
				//	return (SearchInRoteatedSortedItself(sortedRotateArr,n,search,leftmost,rightmost));
					
				}
			}
			else{
				System.out.println(">>2> ");//Search "
						//+ ""+search+" > mide "+mide+"..."+mid);
				if(search>mide && search<=sortedRotateArr[rightmost]  ) {
					System.out.println("--------222 Right is sorted ");
					
					leftmost=mid+1;
					System.out.println(" Left change "+leftmost);
				//	return (SearchInRoteatedSortedItself(sortedRotateArr,n, search,leftmost,rightmost));
				}
				else {
					rightmost=mid-1;
					System.out.println(" Right change "+rightmost);
					//System.out.println(" Right "+rightmost+ " leftmost: "+leftmost);
				//	return (SearchInRoteatedSortedItself(sortedRotateArr,n,search,leftmost,rightmost));
					
				}
			}
			if(left>=right) {
				System.out.println(" Left > riht ");
				return (sortedRotateArr[mid]< sortedRotateArr[prev_mid]?mid:prev_mid);
			}
			
		prev_mid=mid;
		return SearchInRoteatedSortedItself(sortedRotateArr,n,search,leftmost,rightmost);
	}


	private static int SearchInRoteatedSortedGoG(int[] arr,  int target) {
		// GoG solution 
		// first find the range
				// first start with a box of size 2
				int start = 0;
				int end = 1;

				// condition for the target to lie in the range
				while (target > arr[end]) {
					int temp = end + 1; // this is my new start
					// double the box value
					// end = previous end + sizeofbox*2
					end = end + (end - start + 1) * 2;
					start = temp;
				}
				return binarySearch(arr, target, start, end);
	}
	static int binarySearch(int[] arr, int target,
							int start, int end)
	{
		while (start <= end) {
			// find the middle element
			//		 int mid = (start + end) / 2; //
			//		 might be possible that (start +
			//		 end) exceeds the range of int in
			//		 java
			int mid = start + (end - start) / 2;

			if (target < arr[mid]) {
				end = mid - 1;
			}
			else if (target > arr[mid]) {
				start = mid + 1;
			}
			else {
				// ans found
				return mid;
			}
		}
		return -1;
	}


	private static int SearchInRoteatedSorted(int[] sortedRotateArr, int n, int search,int left , int right) {
		// Find the mid , comparing it to leftmost and rightmost we will know which is sorted half 
		int mid=0;
		int mide=0;
		if(left>right) {
			return -1;
		}
		int leftmost=left;int rightmost=right;
		mid=(left+right)/2;
			mide=sortedRotateArr[mid];
			if(mide==search) {
				return mid;
			}
			else if(search<mide) {
				System.out.println(" Search "+search+" < mide "+mide+"..."+mid);
				if(mide-sortedRotateArr[leftmost]>0 && search>=sortedRotateArr[leftmost] ) {
					System.out.println(" Left is sorted ");
					rightmost=mid-1;
					return Search01.BinarySearchRecursion(sortedRotateArr, leftmost,rightmost, search);
				}
				else {
					
					leftmost=mid+1;
					System.out.println(" Rightmost "+rightmost+ " left "+leftmost);
					return (SearchInRoteatedSorted(sortedRotateArr,n,search,leftmost,rightmost));
					
				}
			}
			else if(search>mide) {
				System.out.println(" Search "+search+" > mide "+mide+"..."+mid);
				if(sortedRotateArr[rightmost]-mide>0 && search<=sortedRotateArr[rightmost]  ) {
					System.out.println(" Right is sorted ");
					leftmost=mid+1;
					return Search01.BinarySearchRecursion(sortedRotateArr, leftmost,rightmost, search);
				}
				else {
					rightmost=mid-1;
					System.out.println(" Right "+rightmost+ " leftmost: "+leftmost);
					return (SearchInRoteatedSorted(sortedRotateArr,n,search,leftmost,rightmost));
					
				}
			}
		
		
		return -1;
	}


	private static int UnboundedBinarySearchBinaryArray(int[] arrInfiniteBinary)  {
		//Find the bound 
		
		if(arrInfiniteBinary[0]==1) {
			return 0;
		}
		int i=1;
		while(arrInfiniteBinary[i-1]==0) {
			i=i*2;
			System.out.println(" I "+i);
		}
		
		if(i<arrInfiniteBinary.length && arrInfiniteBinary[i]==1 && arrInfiniteBinary[i-1]==0) {
			return i;}
			else {
			//Found bounds 
			int low=(i/2)-1;
			int high=(i);
			int ans=0;
			System.out.println(" Low w"+low+" high "+high);
			// ;) , Can use Iterative , need to send n as high+1
			ans=Search03.FindTheFirstOccurEffiRecur(arrInfiniteBinary,1,high,low);
			return ans;
			}
	}


	private static int UnboundedBinarySearch(int[] arrInfinite, int search) {
		// Infinite array search an element 
		//for(int i=0;i<n
		// Can not use above , no N is there 
		int i=1;
		while(i<=search) {
			i=i*2;
		}
		if(i>arrInfinite.length-1){
			i=arrInfinite.length-1;
		}
		if(arrInfinite[i]==search) {
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

	private static int SmallesPositiveMissing(int[] arr, int n) {
		// use marking -ve  for O 1 space 
		 if(n==1 && arr[0]!=1) {
				return 1;
			}
			else if(n==1) {
				return 2;
			}
			
			int max=0;
			
			for(int i=0;i<n;i++) {
				max=Math.max(max,arr[i]);
				if(arr[i]<1) {
					arr[i]=0;
				}
			}
			int encode=0;
			//int decode=0;
		//	System.out.println(" N +"+n+" max "+max);
			for(int i=0;i<n;i++) {
				encode=Math.abs(arr[i]);
						System.out.println(" I "+i+" encde"+encode);
						if(encode>0 && encode<n ) {
						    if(arr[encode]!=0){
							arr[encode]=-1*(Math.abs(arr[encode]));}
							else{
							arr[encode]=-1*(encode);    
							}
							System.out.println(" Changed ----:"+arr[encode-1]);
						}
			}
			
			for(int i=1;i<n;i++) {
				if(arr[i]>=0) {
					return (i);
				}
				
			}
			if(max==n) {
				return n+1;
			}
			else {
				return n;
			}
	    }	

	private static long FindSquareRootBinary(long x) {
		// Root by binary 
		long high =(x-1);
		long ans=0;
		long mid=0; long roote=0; long nroote=0;
		long low=0;
		while(low<=high) {
			mid=(high+low)/2;
			
			nroote=((mid+1)*(mid+1));
			roote=(mid*mid);
			System.out.println(" X "+x+" Mide "+roote+" Nx roote "+nroote+" mid "+mid+" low - high "+low+"-"+high);
			if((x==roote) ||(x>roote && (x<nroote) )) {
				ans=mid;
				return ans;
			}
			else if(x<roote) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		return  ans;
	}

}
