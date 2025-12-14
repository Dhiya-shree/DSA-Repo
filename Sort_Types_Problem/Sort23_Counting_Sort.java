package Sort_Types_Problem;

import arrayCode.ArrayPart01;

/**
 * Counting sort :
 * 
 *  Linear time sorting algorithm 
 *  Not comparison , but counts the values 
 *  Only when input element are in very small range 
 *  For elements value in range of 0 to K-1 
 *     Time taken : O (n+k)
 *     Space :O(n+k)
 *     STABLE algo 
 *  Used as subordinate fr radix sort 
 *  When value of K becomes nLogN/n2/quadratic not to be used , as we have merge , quick etc
 *  
 *  Can not be used as general purpose sorting algo 
 *  Naive - Can not be used for sorting objects 
 *  General purpose Can be used for sorting objects 
 *  
 *  
 *  Counting sort is a sorting technique based on keys between a specific range.
 *   It works by counting the number of objects having distinct key values (kind of hashing). Then doing some arithmetic to calculate the position of each object in the output sequence.
 * EX : arr={1,4,4,1,0,1}
 * K -5 => value of max in arr: 4 (5-1) 
 * 
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Sort23_Counting_Sort {

	public static void main(String[] args) {
		// Counting 
		
		int arr[]={1,4,4,0,2,1};
		int n=arr.length;
		System.out.println(" Unsorted array ");
		ArrayPart01.PrintRayy(arr);
		CountingSortNaive(arr,n);
		System.out.println(" Sorted array ");
		ArrayPart01.PrintRayy(arr);
		
		//General
		int arr2[]={1,4,4,1,2,1};
		int n2=arr2.length;
		System.out.println(" Unsorted array ");
		ArrayPart01.PrintRayy(arr2);
		CountingSortGeneral(arr2,n2);
		System.out.println(" Sorted array ");
		ArrayPart01.PrintRayy(arr2);
		
		//  min to Max val elements , Negative 
		int arr3[] = { -1, -4, 0, 1, 2, 1 };
		int n3 = arr3.length;
		System.out.println(" Unsorted array ");
		ArrayPart01.PrintRayy(arr3);
		CountingSortNegative(arr3, n3);
		System.out.println(" Sorted array ");
		ArrayPart01.PrintRayy(arr3);
		
		String arrS="shree";
		String ans=countSort(arrS);
		System.out.println("AN "+ans);
	}

	
	private static String countSort(String arrS){
	        // code here
	        int n=arrS.length();
	        int arr[]= new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=arrS.charAt(i);
	        }
	        System.out.println(" UNsorted array ");
			ArrayPart01.PrintRayy(arr);
	        CountingSortNegative(arr, n);
	        System.out.println(" Sorted array ");
			ArrayPart01.PrintRayy(arr);
			String ans="";
			char a;
			 for(int i=0;i<n;i++){
				 a=(char) arr[i];
		            ans=ans+(String.valueOf(a));
		      }
			
	        return ans;
	    }
	 
	 
	private static void CountingSortNegative(int[] arr, int n) {
		// For min to max not 0 to k 
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {         ///O n 
			max=Math.max(arr[i],max);
			min=Math.min(arr[i],min);
		}
		// For -5 to 4 we need 10 ele : max-min+1
		// For 3 to 10 we need 8 ele : max- min+1
		
		int k =max-min+2;
		int count[]=new int[k];
		int output[]=new int[n];
		System.out.println(" Max "+max+" Min"+min);
		//Count array create 
		// -5 in 0 , 4 in 9 : val=max+1
		for(int i=0;i<n;i++) { 
			int index=0;
			if(min<0) { 
			index=arr[i]+max+2;}
			else {
				index=arr[i]-min;
			}
			count[index]++;
		}
		
		//Modify count 
		for(int i=1;i<k;i++) {
			count[i]=count[i-1]+count[i];
		}
		System.out.println(" Count arra ");
		ArrayPart01.PrintRayy(count);
		
		//Create output 
		int idx_temp=0;
		int idx_count=0;// count ind = arr[i]+max+1
		for(int i=n-1;i>=0;i--) {   
			// index is val
			if(min<0) { 
				idx_count=arr[i]+max+2;}
				else {
					idx_count=arr[i]-min;
				}
		//	idx_count=arr[i]+max+2;
			idx_temp=count[idx_count]-1;
			// WE are searching all all val , we serach count for val in arr[i] so can not be 0 
			System.out.println(" Arr i is "+arr[i]+" for i .."+i+"  Count"+count[idx_count]+" of val..."+(count[idx_count]-1)+"..Gives count:"+arr[idx_temp]);
			// Copy the element to output 
			output[idx_temp]=arr[i];
			
			count[idx_count]--;
		}
		
		System.out.println(" Count arra ");
		ArrayPart01.PrintRayy(count);
		//Copy element back to arr 
		for(int i=0;i<n;i++) {         ///O n 
			arr[i]=output[i];
		}
	}

	private static void CountingSortGeneral(int[] arr, int n) {
		// high space consumption 
				// O n+k
				//For 1 4 4 1 0 1
				int max=-1;//Max val
				for(int i=0;i<n;i++) {         ///O n 
					max=Math.max(arr[i],max);
				}
				// Val of K is max +1 
				int k=max+1;
				//Count array of length K 5 to store 0 to 4
				int count[]=new int[k];
				
				// Increment count of all element that occur in count[]
				// val 1 3 0 0 2 for arr 
				for(int i=0;i<n;i++) {      // O n 
					int index=arr[i];
					count[index]++;
				}
				
				//General purpose 
				// val 1 3 0 0 2 for arr
				// --->1 4 4 4 6
				// pos 0 1 2 3 4
				// Count now has pos to place 
				// 4 at 6 
		
				for(int i=1;i<k;i++) {
					count[i]=count[i-1]+count[i];
				}
				System.out.println(" Count arra ");
				ArrayPart01.PrintRayy(count);
				// Output array used to store sorted , count only used to take noe of count 
				int output[]=new int[n];
				int idx_temp=0;
				// Copy arr objects in order with basis as count array 
				for(int i=n-1;i>=0;i--) {   
					// index is val
					idx_temp=count[arr[i]]-1;
					// WE are searching all all val , we serach count for val in arr[i] so can not be 0 
					System.out.println(" Arr i is "+arr[i]+" for i .."+i+"  Count"+count[arr[i]]+" of val..."+(count[arr[i]]-1)+"..Gives count:"+arr[idx_temp]);
					// Copy the element to output 
					output[idx_temp]=arr[i];
					
					count[arr[i]]--;
				}
				System.out.println(" Count arra ");
				ArrayPart01.PrintRayy(count);
				//Copy element back to arr 
				for(int i=0;i<n;i++) {         ///O n 
					arr[i]=output[i];
				}
				
			}
	private static void CountingSortNaive(int[] arr, int n) {
		// high space consumption 
		// O n+k
		//For 1 4 4 1 0 1
		int max=-1;//Max val
		for(int i=0;i<n;i++) {         ///O n 
			max=Math.max(arr[i],max);
		}
		// Val of K is max +1 
		int k=max+1;
		//Count array of length K 5 to store 0 to 4
		int count[]=new int[k];
		
		// Increment count of all element that occur in count[]
		// val 1 3 0 0 2 for arr 
		for(int i=0;i<n;i++) {      // O n 
			int index=arr[i];
			count[index]++;
		}
		
		// Put correct val ack in arr 
		//If count has 3 times in pos 1 , put 1 three times
		int index=0;
		for(int i=0;i<k;i++) {        // O k 
			
			while(count[i]!=0) {     // O n 
				arr[index]=i;
				index++;
				count[i]=count[i]-1;
			}
		}
		
	}

}
/*
 * 
 * 
 * Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects having distinct key values (kind of hashing). Then doing some arithmetic to calculate the position of each object in the output sequence.

Let us understand it with the help of an example.
For simplicity, consider the data in the range 0 to 9. 
Input data: 1, 4, 1, 2, 7, 5, 2
  1) Take a count array to store the count of each unique object.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  2  0   1  1  0  1  0  0

  2) Modify the count array such that each element at each index 
  stores the sum of previous counts. 
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  4  4  5  6  6  7  7  7

The modified count array indicates the position of each object in 
the output sequence.
 
  3) Output each object from the input sequence followed by 
  decreasing its count by 1.
  Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
  Put data 1 at index 2 in output. Decrease count by 1 to place 
  next data 1 at an index 1 smaller than this index.




Implementation:

// The main function that sort the given string arr[] in
// alphabetical order
void countSort(char arr[])
{
    // The output character array that will have sorted arr
    char output[strlen(arr)];

    // Create a count array to store count of inidividul
    // characters and initialize count array as 0
    int count[RANGE + 1], i;
    memset(count, 0, sizeof(count));

    // Store count of each character
    for(i = 0; arr[i]; ++i)
        ++count[arr[i]];

    // Change count[i] so that count[i] now contains actual
    // position of this character in output array
    for (i = 1; i <= RANGE; ++i)
        count[i] += count[i-1];

    // Build the output character array
    for (i = 0; arr[i]; ++i)
    {
        output[count[arr[i]]-1] = arr[i];
        --count[arr[i]];
    }

    // Copy the output array to arr, so that arr now
    // contains sorted characters
    for (i = 0; arr[i]; ++i)
        arr[i] = output[i];
}
Time Complexity: O(N + K) where N is the number of elements in input array and K is the range of input.
Auxiliary Space: O(N + K)

The problem with the previous counting sort was that it could not sort the elements if we have negative numbers in the array because there are no negative array indices. So what we can do is, we can find the minimum element and store count of that minimum element at zero index.

Implementation:

void countSort(vector <int>& arr)
{
    int max = *max_element(arr.begin(), arr.end());
    int min = *min_element(arr.begin(), arr.end());
    int range = max - min + 1;
    
    vector<int> count(range), output(arr.size());
    for(int i = 0; i < arr.size(); i++)
        count[arr[i]-min]++;
        
    for(int i = 1; i < count.size(); i++)
           count[i] += count[i-1];
  
    for(int i = arr.size()-1; i >= 0; i--)
    { 
         output[ count[arr[i]-min] -1 ] = arr[i]; 
              count[arr[i]-min]--; 
    }
    
    for(int i=0; i < arr.size(); i++)
            arr[i] = output[i];
}
Important Points:
Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
It is not a comparison based sorting. It's running time complexity is O(n) with space proportional to the range of data.
It is often used as a sub-routine to another sorting algorithm like radix sort.
Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
Counting sort can be extended to work for negative inputs also.
 * 
 * 
 * 
 * 
 */
