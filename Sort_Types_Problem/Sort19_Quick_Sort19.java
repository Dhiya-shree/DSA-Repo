package Sort_Types_Problem;

import java.util.Arrays;

import arrayCode.ArrayPart01;

/**
 * 
 * Problem #1 : K th smallest element QUICK SORTED ALGO  
 * 
 * Use Lomato partition , when partition index==KEy 
 * return the element
 * 
 * Given an array and a number k where k is smaller than the size of the array, we need to find the k'th smallest element in the given array. It is given that all array elements are distinct.

Examples:  

Input: arr[] = {7, 10, 4, 3, 20, 15}, k = 3 
Output: 7 

Input: arr[] = {7, 10, 4, 3, 20, 15}, k = 4 
Output: 10 

We have discussed a similar problem to print k largest elements. 

Method 2 (Using Min Heap - HeapSelect) 
We can find k'th smallest element in time complexity better than O(N Log N). A simple optimization is to create a Min Heap of the given n elements and call extractMin() k times. 


Time complexity: O(n + kLogn).

Space complexity: O(n) for call stack

Method 1 (Simple Solution) 
A simple solution is to sort the given array using an O(N log N) sorting algorithm like Merge Sort, Heap Sort, etc, and return the element at index k-1 in the sorted array. 
The Time Complexity of this solution is O(N log N) 
 * 
 * 
 * 
 * Problem #2: Minimum Difference in an Array
 * 
 * Find Minimum Difference in an Array
 * 
 * Sort array , find diff between every two 
 * Return smallest of diff 
 * 
 * 
 * Find minimum difference between any two elements (pair) in given array

Given an unsorted array, find the minimum difference between any pair in the given array.

Examples :

 

Input: {1, 5, 3, 19, 18, 25}
Output: 1
Explanation: Minimum difference is between 18 and 19

Input: {30, 5, 20, 9}
Output: 4
Explanation: Minimum difference is between 5 and 9

Input: {1, 19, -4, 31, 38, 25, 100}
Output: 5
Explanation: Minimum difference is between 1 and -4

Naive Approach: To solve the problem follow the below idea:

A simple solution is to use two loops two generate every pair of elements and compare them to get the minimum difference

 
 * 
 * Problem #3:Chocolate distribution among array equally 
 * Chocolate Distribution Problem

Given an array of N integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 

Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates given to the students is minimum.
Examples:

 Time Complexity: O(N*log(N))
Auxiliary Space: O(1)

 

Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3 
Output: Minimum Difference is 2 
Explanation:
We have seven packets of chocolates and we need to pick three packets for 3 students 
If we pick 2, 3 and 4, we get the minimum difference between maximum and minimum packet sizes.

Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5 
Output: Minimum Difference is 6
 * 
 * Problem # 4 : Sort two array with diff types pf elements 
 * 
 *    1) Sort negative and positive 
 *    2) Sort 0 and 1 
 *    3) Sort odd and even 
 *    All above only needs partition func , NO sorting needed
 * 
 * Given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array. Traverse array only once.
Examples: 

Input :  arr[] = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
Output : arr[] = [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 

Input :  arr[] = [1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1] 
Output : arr[] = [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1]  
 
Step 1 : Here we can take two pointers type0 (for element 0) starting from beginning (index = 0) and type1 (for element 1) starting from end index.
Step 2: We intend to put 1 to the right side of the array. Once we have done this then 0 will definitely towards left side of array to achieve this we do following. 
We compare elements at index type0 
1) if this is 1 then this should be moved to right side so we need to swap this with index type1 once swapped we are sure that element at index type1 is '1' so we need to decrement index type1 
2) else it will be 0 then we need to simple increment index type0

Time Complexity : O(n)  

Auxiliary Space: O(1)

 * 
 * Problem #5 :Sort an array with three types of elements
 * 
 * Use Hoare
 * 1) Sort array of 1 ,2 , 3 
 * 2) Three way partioning (single pivot)
 * 3) Pattern around a range ( two pivot a-b )
 *
 * DUTCH NATIONAL FLAG - HOARE 
 * 
 * Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
Examples: 
 

Input: {0, 1, 2, 0, 1, 2}
Output: {0, 0, 1, 1, 2, 2}

Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

Method 1 

Approach:The problem is similar to our old post Segregate 0s and 1s in an array, and both of these problems are variation of famous Dutch national flag problem.
The problem was posed with three colours, here 
1' and `2'. The array is divided into four sections: 
a[1..Lo-1] zeroes (red)
a[Lo..Mid-1] ones (white)
a[Mid..Hi] unknown
a[Hi+1..N] twos (blue)
If the ith element is 0 then swap the element to the low range, thus shrinking the unknown range.
Similarly, if the element is 1 then keep it as it is but shrink the unknown range.
If the element is 2 then swap it with an element in high range.
Algorithm: 
Keep three indices low = 1, mid = 1 and high = N and there are four ranges, 1 to low (the range containing 0), low to mid (the range containing 1), mid to high (the range containing unknown elements) and high to N (the range containing 2).
Traverse the array from start to end and mid is less than high. (Loop counter is i)
If the element is 0 then swap the element with the element at index low and update low = low + 1 and mid = mid + 1
If the element is 1 then update mid = mid + 1
If the element is 2 then swap the element with the element at index high and update high = high - 1 and update i = i - 1. As the swapped element is not processed
Print the array.
Dry Run: 
Part way through the process, some red, white and blue elements are known and are in the "right" place. The section of unknown elements, a[Mid..Hi], is shrunk by examining a[Mid]:
 
DNF1

Examine a[Mid]. There are three possibilities: 
a[Mid] is (0) red, (1) white or (2) blue. 
Case (0) a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++
 

DNF2


Case (1) a[Mid] is white, Mid++

DNF3
Case (2) a[Mid] is blue, swap a[Mid] and a[Hi]; Hi--
 

DNF4
Continue until Mid>Hi. 



Complexity Analysis: 
Time Complexity: O(n). 
Only one traversal of the array is needed.
Space Complexity: O(1). 
No extra space is required.

Method 2

Approach:
                      Count the number of 0s, 1s and 2s in the given array. Then store all the 0s in the beginning followed by all the 1s then all the 2s

Algorithm: 
Keep three counter c0 to count 0s, c1 to count 1s and c2 to count 2s
Traverse through the array and increase the count of c0 if the element is 0,increase the count of c1 if the element is 1 and increase the count of c2 if the element is 2
Now again traverse the array and replace first c0 elements with 0, next c1 elements with 1 and next c2 elements with 2.

Complexity Analysis: 
Time Complexity: O(n). 
Only non nested traversals of the array is needed.
Space Complexity: O(1). 
As no extra space is required.
 * 
 * @author shree
 *
 */
public class Sort19_Quick_Sort19 {

	public static void main(String[] args) {
		
		int arr[]= {1,4,2,5,2,7,8,9,10,4,12,34,22};
		int arrc[]= {1,4,2,5,2,7,8,9,10,4,12,34,22};
		int K=6;
		int n=arr.length;
		int ans=KthSmallestElement(arr,n,K-1,n-1,0);
		System.out.println(" Ans "+arr[ans]);
		
		//MinHeap gfg = new MinHeap(arr,k);
		    System.out.print("K'th smallest element is " + 
		    		kthSmallest(arr, n, K));
		    
		    // SEND K as 1 
		    ans=MinimumDiff(arr,n,2,n-1,0);
			System.out.println(" Ans "+ans);
			
			//Choco distribution 
			ans=ChocoDistribution(arrc,3);
			System.out.println(" Ans coco "+ans);
			
		// Swap negative and positive 
	   int arr1[]= {-2,2,-3,3,-7,-8,-9,6,4};
	   LumatoPartitionPosNeg(arr1,arr1.length);
	   ArrayPart01.PrintRayy(arr1);
	   
	// Swap odd  and even 
	   int arr2[]= {1,3,6,9,8,7,5,4,2,0};
	   LumatoPartitionOddEven(arr2,arr2.length);
	   ArrayPart01.PrintRayy(arr2);
	   
	// Swap zero and one 
	   int arr3[]= {0,0,0,0,1,1,1,1,0,1,1,0,1,1,0,1,1,1,0,1,1,1,1,0};
	   LumatoPartitionOneZero(arr3,arr3.length);
	   ArrayPart01.PrintRayy(arr3);
	   
	   
	   // Swap 0 , 1 2 
	   int arr4[]= {0,1,2,0,1,2,0,0,0,1,1,1,2,2,2,2,2};
	   arr4=DutchFlagHoare012(arr4,arr4.length);
	   ArrayPart01.PrintRayy(arr4);
	   
	   int arr4c[]= {0,1,2,0,1,2,0,0,0,1,1,1,2,2,2,2,2};
	   sort012GOG(arr4c,arr4c.length);
	   ArrayPart01.PrintRayy(arr4c);
	   
	   int arr4c2[]= {0,1,2,0,1,2,0,0,0,1,1,1,2,2,2,2,2};
	   sortArrGOG120(arr4c2,arr4c2.length);
	   ArrayPart01.PrintRayy(arr4c2);
	   
	// Three partition single pivot - 2 
	   int arr5[]= {0,1,3,5,6,7,8,9,10,3,4,5,66,77,1,1,2,2,2,2,2};
	   int pivot=2;
	   DutchFlagHoareThreePartition(arr5,pivot,arr5.length);
	   ArrayPart01.PrintRayy(arr5);
	   
	// Three partition double pivot - 2,7 
	   int arr6[]= {0,1,3,5,6,7,8,9,10,3,4,5,66,77,1,1,2,2,2,2,2};
	   int pivot1=2;int pivot2=7;
	   DutchFlagHoareThreePartitionDoublePivot(arr6,pivot1,pivot2,arr6.length);
	   ArrayPart01.PrintRayy(arr6);
	   
		  }

	// Function to sort the array of 0s, 1s and 2s
    static void sortArrGOG120(int arr[], int n)
    {
        int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;
    
        // Count the number of 0s, 1s and 2s in the array
        for (i = 0; i < n; i++) {
            switch (arr[i]) {
            case 0:
                cnt0++;
                break;
            case 1:
                cnt1++;
                break;
            case 2:
                cnt2++;
                break;
            }
        }
    
        // Update the array
        i = 0;
    
        // Store all the 0s in the beginning
        while (cnt0 > 0) {
            arr[i++] = 0;
            cnt0--;
        }
    
        // Then all the 1s
        while (cnt1 > 0) {
            arr[i++] = 1;
            cnt1--;
        }
    
        // Finally all the 2s
        while (cnt2 > 0) {
            arr[i++] = 2;
            cnt2--;
        }
    
        // Print the sorted array
      //  printArr(arr, n);
    }
    
 


	// Sort the input array, the array is assumed to
    // have values in {0, 1, 2}
    static void sort012GOG(int a[], int arr_size)
    {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
            case 0: {
                temp = a[lo];
                a[lo] = a[mid];
                a[mid] = temp;
                lo++;
                mid++;
                break;
            }
            case 1:
                mid++;
                break;
            case 2: {
                temp = a[mid];
                a[mid] = a[hi];
                a[hi] = temp;
                hi--;
                break;
            }
            }
        }
    }
	private static void DutchFlagHoareThreePartitionDoublePivot(int[] arr, int pivot1,int pivot2, int n) {
		// Split less same and high in range without quick sort
		int left=0;
		int right=n-1;
		//int i=0;// same as arr mid
		int mid=0; // dutch 
	//	int pivot =1;
		int swap=0;
		while(mid<=right) {
			//For 0
			if(arr[mid]<pivot1) {
				swap=arr[left];
				arr[left]=arr[mid];
				arr[mid]=swap;
				left++;mid++;
			}
			else if(arr[mid]>=pivot1 && arr[mid]<=pivot2  ) {
				mid++;
			}
			else if(arr[mid]>pivot2) {
				swap=arr[mid];
				arr[mid]=arr[right];
				arr[right]=swap;
				right--;
			}
			
			
		}
		
	}




	private static void DutchFlagHoareThreePartition(int[] arr, int pivot, int n) {
		// Split less same and high in range without quick sort
				int left=0;
				int right=n-1;
				//int i=0;// same as arr mid
				int mid=0; // dutch 
			//	int pivot =1;
				int swap=0;
				while(mid<=right) {
					//For 0
					if(arr[mid]<pivot) {
						swap=arr[left];
						arr[left]=arr[mid];
						arr[mid]=swap;
						left++;mid++;
					}
					else if(arr[mid]==pivot) {
						mid++;
					}
					else if(arr[mid]>pivot) {
						swap=arr[mid];
						arr[mid]=arr[right];
						arr[right]=swap;
						right--;
					}
					
					
				}
	}



	private static int[] DutchFlagHoare012(int[] arr, int n) {
		// Split 0 , 1 and 2 
		int left=0;
		int right=n-1;
		//int i=0;// same as arr mid
		int mid=0; // dutch 
		int pivot =1;int swap=0;
		while(mid<=right) {
			//For 0
			if(arr[mid]==0) {
				swap=arr[left];
				arr[left]=arr[mid];
				arr[mid]=swap;
				left++;mid++;
			}
			else if(arr[mid]==pivot) {
				mid++;
			}
			else if(arr[mid]>pivot) {
				swap=arr[mid];
				arr[mid]=arr[right];
				arr[right]=swap;
				right--;
			}
			
			
		}
		return arr;
		
		
	}




	private static void LumatoPartitionOneZero(int[] arr, int n) {
		// divide 0 and 1
		// Set pivot as 1
				
				int pivot=1;
				int win=-1;int swap=0;
				for(int i=0;i<n;i++) {
					if((arr[i]<pivot)) {
						win++;
						swap=arr[i];
						arr[i]=arr[win];
						arr[win]=swap;
					}
				}
	}




	private static void LumatoPartitionOddEven(int[] arr, int n) {
		// divide pos and negative 
		// Set no Pivot 
		// Con arr[i]&1==1 odd swap 
				
				int pivot=1;
				int win=-1;int swap=0;
				for(int i=0;i<n;i++) {
					if((arr[i]&pivot)==1) {
						win++;
						swap=arr[i];
						arr[i]=arr[win];
						arr[win]=swap;
					}
				}
	}




	private static void LumatoPartitionPosNeg(int[] arr, int n) {
		// divide pos and negative 
		// Set Pivot as 0 
		
		int pivot=0;
		int win=-1;int swap=0;
		for(int i=0;i<n;i++) {
			if(arr[i]<pivot) {
				win++;
				swap=arr[i];
				arr[i]=arr[win];
				arr[win]=swap;
			}
		}
		
	}




	private static int ChocoDistribution(int[] arr, int k) {
		//Sort and find diff btw 0 to k
		int min=Integer.MAX_VALUE;
		int n=arr.length;
		// if there are no chocolates or number
		// of students is 0
		if (k == 0 || n == 0)
			return 0;

		// Sort the given packets
		//sort(arr, arr + n);

		// Number of students cannot be more than
		// number of packets
		if (n < k)
			return -1;
		Arrays.sort(arr);
		k=k-1;
		for(int i=0;(i+k)<n;i++) {
			System.out.println(" Arr i+k..+I+K="+(i+k)+"..val .."+arr[i+k]+" ...i="+i+"..arr "+arr[i]);
			min=Math.min(min,(arr[i+k]-arr[i]));
		}
		return min;
	}




	private static int MinimumDiff(int[] arr, int n, int k, int high, int low) {
		
		while(low<high)
		{
			int pos=partitionLumato(arr,n,k,low,high);
			if(pos==k) {
				return pos;
			}
			else if(pos>k) {
				high=pos-1;
			}
			else {
				low=pos+1;
			}
			
		}
		return arr[k]-arr[0];
		//return 0;
	}




	private static int KthSmallestElement(int[] arr,int n, int k, int high,int low) {
		while(low<high)
		{
			int pos=partitionLumato(arr,n,k,low,high);
			if(pos==k) {
				return pos;
			}
			else if(pos>k) {
				high=pos-1;
			}
			else {
				low=pos+1;
			}
			
		}
		return -1;
		//return 0;
	}

	private static int partitionLumato(int[] arr,int n, int k, int low, int high) {
		int win=-1;
		int pivot=arr[high];
		int swap=0;
		for(int i=0;i<n;i++) {
			if(arr[i]<pivot) {
				win++;
				swap=arr[i];
				arr[i]=arr[win];
				arr[win]=swap;
			}
		}
		win++;
		swap=arr[high];
		arr[high]=arr[win];
		arr[win]=swap;
		return win;
	}
	
	  static // Function to return k'th largest element in a given array
	  int kthSmallest(int arr[], int n, int k)
	  {

	    // Build a heap of first k elements: O(k) time
	   MinHeap mh = new MinHeap(arr, n);

	    // Process remaining n-k elements. If current element is
	    // smaller than root, replace root with current element
	    for (int i = 0; i < k - 1; i++)
	      mh.extractMin();

	    // Return root
	    return mh.getMin();
	  }
	
}	
	class MinHeap
	  {
	    int[] harr; // pointer to array of elements in heap
	    int capacity; // maximum possible size of min heap
	    int heap_size; // Current number of elements in min heap

	    int parent(int i) { return (i - 1) / 2; }
	    int left(int i) { return ((2 * i )+ 1); }
	    int right(int i) { return ((2 * i) + 2); }
	    int getMin() { return harr[0]; } // Returns minimum

	    // to replace root with new node x and heapify() new root
	    void replaceMax(int x)
	    {
	      this.harr[0] = x;
	      minHeapify(0);
	    }
	    MinHeap(int a[], int size)
	    {
	      heap_size = size;
	      harr = a; // store address of array
	      int i = (heap_size - 1) / 2;
	      while (i >= 0)
	      {
	        minHeapify(i);
	        i--;
	      }
	    }

	    // Method to remove maximum element (or root) from min heap
	    int extractMin()
	    {
	      if (heap_size == 0)
	        return Integer.MAX_VALUE;

	      // Store the maximum value.
	      int root = harr[0];

	      // If there are more than 1 items, move the last item to root
	      // and call heapify.
	      if (heap_size > 1)
	      {
	        harr[0] = harr[heap_size - 1];
	        minHeapify(0);
	      }
	      heap_size--;
	      return root;
	    }

	    // A recursive method to heapify a subtree with root at given index
	    // This method assumes that the subtrees are already heapified
	    void minHeapify(int i)
	    {
	      int l = left(i);
	      int r = right(i);
	      int smallest = i;
	      if (l < heap_size && harr[l] < harr[i])
	        smallest = l;
	      if (r < heap_size && harr[r] < harr[smallest])
	        smallest = r;
	      if (smallest != i) 
	      {
	        int t = harr[i];
	        harr[i] = harr[smallest];
	        harr[smallest] = t;
	        minHeapify(smallest);
	      }
	    }
	 
	  };
	
/*
	  
	  // Java program to sort an array with two types
// of values in one traversal.public class GFG {
/* Method for segregation 0 and 1
     given input array 
class segregation {
    static void segregate0and1(int arr[], int n)
    {
        int type0 = 0;
        int type1 = n - 1;

        while (type0 < type1) {
            if (arr[type0] == 1) {

                // swap type0 and type1
                arr[type0] = arr[type0] + arr[type1];
                arr[type1] = arr[type0] - arr[type1];
                arr[type0] = arr[type0] - arr[type1];
                type1--;
            }
            else {
                type0++;
            }
        }
    }

    // Driver program
    public static void main(String[] args)
    {
        int arr[]
            = { 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0 };

        segregate0and1(arr, arr.length);
        for (int a : arr)
            System.out.print(a + " ");
    }
}

 


	  */