package Sort_Types_Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import arrayCode.ArrayPart01;

/**
 * BUCKET SORT : UNIFORM DISTRIBUTION 
 *    Formula : BucketIndex=(bucket_count*arr[i])/max_val;
 * 
 *   1) Consider a situation where we have number uniformly distributed in a range 
 *        from 1 to 10^8 
 *   2) Floating point numbers uniformly distributed in range from 0.0 to 1.0 
 *   
 *   Above can be sorted with comparison sort merge,quick .. but uniform distribution not used there
 *   Counting sort can not be used for floating point numbers and will need a lot of extra space .
 * 
 * For uniform distribution , bucket sort is used .
 *        Similar to Hashing with Chaining 
 *  
 * Time complexity : Assuming K~ N 
 * 
 * Best case : Data is uniformly distributed : O (n) ( Insertion is best for smaller )
 * 
 * Worst case : Not uniform distribution -- > All item go into 1 bucket 
 *       If insertion sort used to sort individual bucket -> N2 
 *       If Comparison sort O nlogn is used sort individual bucket , then O n log n 
 *  
 * Ex: Uniform distribute array 
 * arr={20,88,70,85,75,95,18,82,60};
 * 
 * 1) Divide the range into multiple buckets 
 *   -->Find max , get max+1 , we need to include max value so 
 *       MUST max_value=max+1  !!!!!!!  -> if not index out of range 
 *   --> Bucket index=(No of bucket * value) / max_value 
 *       
 * 2) Consider 5 buckets ( based on time -space trade offf)
 *      In range 0 to 99 
 *        Range 1 - 0 to 19
 *        Range 2 - 20 to 39
 *        Range 3 - 40 to 59
 *        Range 4 - 60 to 79
 *        Range 5 - 80 to 99
 * 3) Scatter Step 3:- Traverse through the input element and put in in correct bucket 
 *       In range 0 to 99 
 *        Range 1 - 0 to 19   - 18
 *        Range 2 - 20 to 39   - 20
 *        Range 3 - 40 to 59   - ... no element 
 *        Range 4 - 60 to 79  - 75,60,70
 *        Range 5 - 80 to 99  - 88,85,82,95
 * 
 * 3) Sort Buckets 
 *       In range 0 to 99 
 *        Range 1 - 0 to 19   - 18
 *        Range 2 - 20 to 39   - 20
 *        Range 3 - 40 to 59   - ... no element 
 *        Range 4 - 60 to 79  - 60,70,75
 *        Range 5 - 80 to 99  - 82,85,88,95
 *        
 * 4) Join sorted elements :
 *       Merge al bucket - 18,20,60,70,75,82,85,88,95
 *        
 * To merge in buckets we can use any standard sorting algorithm (insertion sort for small n)
 *   
 *  
 * No of buckets and storage :
 * Total elements : N 
 * Total bucket : K 
 * If every element uniform distribute:
 *      N/K elements in each bucket 
 * 
 * Scatter space Constant 
 * If K=N , then Space is 1 
 * If K=N/2 , then Space is 2 time  
 * If K=N/3 , then Space is 3 time 
 * 
 * Sorting bucket : NlogN or N+K worst :N2 
 * 
 * Joining : Linear N 
 * 
 * If Data is NON - Uniform , all elements will be in 1 bucket , 
 *                      Then O n2 for 1 bucket 
 *                      
 *              
 *  
 *  
 * @author shree
 *
 */
public class Sort25_Bucket_Sort {

	public static void main(String[] args) {
		
		//Consider bucket is given 
		int arr[]={20,88,70,85,75,95,18,82,60};
		int n=arr.length;
		
		int bucket=5;
		
		System.out.println(" Unsorted ...");
		ArrayPart01.PrintRayy(arr);
		BucketSort(arr,n,bucket);
		System.out.println(" Sorted ...");
		ArrayPart01.PrintRayy(arr);
		
		/////////// GOG Floating number 
		float arr2[] = { (float) 0.897, (float) 0.565, 
				(float) 0.656, (float) 0.1234, (float) 0.665,
				(float) 0.3434 };

		int n2 = arr2.length;
		bucketSort(arr2, n2);

		System.out.println("Sorted array is ");
		for (float el : arr) {
			System.out.print(el + " ");
		}
		
	}

	private static void BucketSort(int[] arr, int n, int bucket_count) {
		// Find the maximum element and lower limit as 0 
		
		// Run a loop to find min - max , here use 0-100 
		int min=Integer.MAX_VALUE;
		int max=-1;
				
		//To find range of bucket 
		for(int i=0;i<n;i++) {
			min=Math.min(min,arr[i]);
			max=Math.max(max,arr[i]);
		}
		max=max+1;
		max=100;
		//int range=100/bucket_count; // Max/ bucket 
		
		//HAving arraylist of arrayList for bucket
		ArrayList<ArrayList<Integer>> buckets= new ArrayList<ArrayList<Integer>>(bucket_count);
		for(int i=0;i<bucket_count;i++) {
			buckets.add(new ArrayList<Integer>());
		}
		
		
		//Put in correct bucket 
		int BucketIndex=0;
		for(int i=0;i<n;i++) {
			System.out.println(" For index i "+i+"..array val:"+arr[i]+".....");
			BucketIndex=(bucket_count*arr[i])/max;
			System.out.println(" Bucket coynt "+bucket_count+" Bucket index="+BucketIndex);
			buckets.get(BucketIndex).add(arr[i]);
		}
		
		//Sorting of buckets 
		for(int i=0;i<bucket_count;i++) {
			Collections.sort(buckets.get(i));
			System.out.println(" Array in bucket "+i+" is "+(buckets.get(i).toString()));
			
		}
		
		//Merge the bucket to get ans 
		int index=0;
		for(int i=0;i<bucket_count;i++) {
			for(int j=0;j<buckets.get(i).size();j++) {
				arr[index]=buckets.get(i).get(j);
				index++;
			}
		}
	}
	
	
	// Function to sort arr[] of size n
    // using bucket sort
    static void bucketSort(float arr[], int n)
    {
        if (n <= 0)
            return;

        // 1) Create n empty buckets
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<Float>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            float idx = arr[i] * n;
            buckets[(int)idx].add(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
//    // Driver code
//    public static void main(String args[])
//    {
      
//        }
//    }



/*
 * 
 * Bucket sort is mainly useful when input is uniformly distributed over a range. For example, consider the following problem. 
Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed across the range. How do we sort the numbers efficiently?
A simple way is to apply a comparison based sorting algorithm. The lower bound for Comparison based sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is Ω(n Log n), i.e., they cannot do better than nLogn. 
Can we sort the array in linear time? Counting sort can not be applied here as we use keys as index in counting sort. Here keys are floating point numbers.  
The idea is to use bucket sort. Following is bucket algorithm.

bucketSort(arr[], n)
1) Create n empty buckets (Or lists).
2) Do following for every array element arr[i].
.......a) Insert arr[i] into bucket[n*array[i]]
3) Sort individual buckets using insertion sort.
4) Concatenate all sorted buckets.
BucketSort

Time Complexity: If we assume that insertion in a bucket takes O(1) time then steps 1 and 2 of the above algorithm clearly take O(n) time. The O(1) is easily possible if we use a linked list to represent a bucket (In the following code, C++ vector is used for simplicity). Step 4 also takes O(n) time as there will be n items in all buckets. 
The main step to analyze is step 3. This step also takes O(n) time on average if all numbers are uniformly distributed (please refer CLRS book for more details)
Following is the implementation of the above algorithm.


 * 
 * 
 * 
 */
