package Sort_Types_Problem;

import arrayCode.ArrayPart01;

/**
 * Quick sort - Lomuto partition 
 * 
 *Naive takes any partition index 
 *Lomuto traverses once to partition 
 *
 *Lomut - pivot always last element
 *
 *Lomuto partition 
 

Lomuto’s Partition Algorithm (unstable algorithm)
Lomutopartition(arr[], lo, hi) 

    pivot = arr[hi]
    i = lo     // place for swapping
    for j := lo to hi – 1 do
        if arr[j] <= pivot then
            swap arr[i] with arr[j]
            i = i + 1
    swap arr[i] with arr[hi]
    return i

    
QuickSort(arr[], l,  r)

If r > l
     1. Find the partition point of the array  
              m =Lomutopartition(a,l,r) 
     2. Call Quicksort for less than partition point   
             Call Quicksort(arr, l, m-1)
     3. Call Quicksort for greater than the partition point 
             Call Quicksort(arr, m+1, r)
 *
 * 
 * 
 * 
 * @author shree
 *
 */
public class Sort16_Quick_Sort2 {

public static void main(String[] args) {
		
		int arr[]= {5,13,6,9,12,11,8};
		// Expected o/p - 5 6 | 8 | 9  12 11 13
		//int partion_index=6;
		int n=arr.length;
		
		int ans= LomutoPartition(arr,0,n-1);
		// Lomuto always takes last as partition 
		// If given a partition index what to do ?
		// Simply swap partition index and last element 
		// before sending to Lomuto partition function 
		System.out.println(" Sorted array "+ans);
		ArrayPart01.PrintRayy(arr);
		int sol[]= quicksortLomuto(arr,0,n-1);
		System.out.println(" Sorted array ");
		ArrayPart01.PrintRayy(sol);
		
		ArrayPart01.PrintRayy(arr);
		int arr2[]= {5,13,6,9,12,11,8};
		// Expected o/p - 5 6 | 8 | 9  12 11 13
		//int partion_index=6;
		int n2=arr2.length;
		sol= quicksort(arr2,0,n2-1);
		System.out.println(" Sorted array ");
		ArrayPart01.PrintRayy(sol);
		ArrayPart01.PrintRayy(arr2);
		
}


static int[] quicksortLomuto(int numbers[], int start, int end)
{
    if (start < end) 
    {
        int pivot_position = LomutoPartition(numbers, start, end);
        // Leave the pivot position 
        
        // Low to pivot_pos-1
        quicksortLomuto(numbers, start, pivot_position - 1);
       
        // pivot_pos+1 to high
        quicksortLomuto(numbers, pivot_position + 1, end);
    }
	return numbers;
}
private static int LomutoPartition(int[] arr,int low, int high) {
	// O n time + O n space
	// Pivot always last 
	//int temp[]=arr;
	int pivot=arr[high]; //Pivot as last element
	int Lower_Window=low-1;
	int swap=0;
	// Traverse from left to right , last element pivot so don't mind
    for( int j=low;j<high ;j++) {
    	// Ignore the last element 
        // 0 to i should be less than pivot 
    	// i+1 to high greater 
    	// If i-i+1 element is greater - swap  
    	if( arr[j]<pivot) {
    		// Found smaller element ?
    		// Increment the window of smaller element by i++
    	    Lower_Window++;
    	   // swap(arr[i],arr[j]);
    	   // Smaller and the 0 position - to get smaller in smaller window to the left  
    	   swap=arr[Lower_Window];
    	   arr[Lower_Window]=arr[j];
    	   arr[j]=swap;
    	}
        // For high value , dont care ...
    	// If all value are high than pivot 
    	// Smaller window will be -1 
    	// No changes 
    }
	
    // We did every comparison with help of pivot element 
    // Small <Pivot < high 
    // Pivot is currently smaller - > swap last and mid position 
    // Mid pos is nothing but Lower_Window ....
    // Lower window can be -1 , 
    // Till lower window we have smaller values , need to put in Lower_window+1  
    
    
    // If last element > all elements 
    // Lower window value -> high ...
    // No swap 
    
    // If last elements < all elements 
    // Lower window value ->0 
    // swap last 
    
  //  int pivotpos=++Lower_Window;
    swap=arr[Lower_Window+1];
    
    arr[Lower_Window+1]=arr[high];
    arr[high]=swap;
    //Pivot position returning 
	return (1+Lower_Window);
}

static int sort(int numbers[], int start, int last)
{
    int pivot = numbers[last];
    int index = start - 1;
    int temp = 0;
  
    for (int i = start; i < last; ++i)
    {
        if (numbers[i] < pivot) {
            ++index;
          
            // swap the position
            temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
        }
    }
  
    int pivotposition = ++index;
  
    temp = numbers[index];
    numbers[index] = pivot;
    numbers[last] = temp;
  
    return pivotposition;
}

static int[] quicksort(int numbers[], int start, int end)
{
    if (start < end) 
    {
    	
        int pivot_position = sort(numbers, start, end);
        quicksort(numbers, start, pivot_position - 1);
        quicksort(numbers, pivot_position + 1, end);
    }
    
	return numbers;
}


}

/**
 * 
 * Quicksort is a Divide and Conquer Algorithm that is used for sorting the elements. In this algorithm, we choose a pivot and partitions the given array according to the pivot. Quicksort algorithm is a mostly used algorithm because this algorithm is cache-friendly and performs in-place sorting of the elements means no extra space requires for sorting the elements.

Note:

Quicksort algorithm is generally unstable algorithm because quick sort cannot be able to maintain the relative 
order of the elements.

Three partitions are possible for the Quicksort algorithm:

Naive partition: In this partition helps to maintain the relative order of the elements but this partition takes O(n) extra space.
Lomuto partition: In this partition, The last element chooses as a pivot in this partition. The pivot acquires its required position after partition but more comparison takes place in this partition.
Hoare's partition: In this partition, The first element chooses as a pivot in this partition. The pivot displaces its required position after partition but less comparison takes place as compared to the Lomuto partition.
 

Lomuto partition 
 

Lomuto’s Partition Algorithm (unstable algorithm)
Lomutopartition(arr[], lo, hi) 

    pivot = arr[hi]
    i = lo     // place for swapping
    for j := lo to hi – 1 do
        if arr[j] <= pivot then
            swap arr[i] with arr[j]
            i = i + 1
    swap arr[i] with arr[hi]
    return i

    
QuickSort(arr[], l,  r)

If r > l
     1. Find the partition point of the array  
              m =Lomutopartition(a,l,r) 
     2. Call Quicksort for less than partition point   
             Call Quicksort(arr, l, m-1)
     3. Call Quicksort for greater than the partition point 
             Call Quicksort(arr, m+1, r)

 

// Java program to demonstrate the Lomuto partition
// in quick sort

import java.util.*;
public class GFG {

    static int sort(int numbers[], int start, int last)
    {
        int pivot = numbers[last];
        int index = start - 1;
        int temp = 0;
      
        for (int i = start; i < last; ++i)
        {
            if (numbers[i] < pivot) {
                ++index;
              
                // swap the position
                temp = numbers[index];
                numbers[index] = numbers[i];
                numbers[i] = temp;
            }
        }
      
        int pivotposition = ++index;
      
        temp = numbers[index];
        numbers[index] = pivot;
        numbers[last] = temp;
      
        return pivotposition;
    }
  
    static void quicksort(int numbers[], int start, int end)
    {
        if (start < end) 
        {
            int pivot_position = sort(numbers, start, end);
            quicksort(numbers, start, pivot_position - 1);
            quicksort(numbers, pivot_position + 1, end);
        }
    }
  
    static void print(int numbers[])
    {
        for (int a : numbers) {
            System.out.print(a + " ");
        }
    }
  
    public static void main(String[] args)
    {
        int numbers[] = { 4, 5, 1, 2, 4, 5, 6 };
        quicksort(numbers, 0, numbers.length - 1);
        print(numbers);
    }
}

 


Output
1 2 4 4 5 5 6 
 */
