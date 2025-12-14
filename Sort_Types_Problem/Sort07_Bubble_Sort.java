package Sort_Types_Problem;

import java.util.Arrays;

// Finish java collections, arrays and stability before this */

public class Sort07_Bubble_Sort {
 
	public static void main(String[] args) {
		
		// Comparison sort 
		//Bubble sort On2 - Stable sort 
		// Move largest element to last 
		//Second largest to second last 
		//...
		// (n-1)+(n-2)+.....+2+1
		//  n*(n-1)/2
		// O n2
		
		int arr1[]= {1,3,4,6,8,9,0,2,4,6,7,10};
		int arr2[]= {91, 23, 32, 74 ,6};
		BubbleSort bs= new BubbleSort();
		arr1=bs.bubbleSort(arr1);
		System.out.println(Arrays.toString(arr1));
		// Bubble sort work for n-1 times * 0to n-i-1 times-n2
		//Eve if in middle sorted , it continues to run 
		// To stop if sorted , have a flag 
		// So when array is sorted , N times only 
		arr2=bs.bubbleSortOptimized(arr2);
		System.out.println(Arrays.toString(arr2));
		//Bubble sort is stable 
		//When sort by max first 
		// And swap only if element > current , not >=
		
	}
	
}

class BubbleSort{
	int[] bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            
        }
        return arr;
    }
	
	int[] bubbleSortOptimized(int arr[]) {
		
		int n=arr.length;
		System.out.println(" N "+n);
		int swapped=0;//To know if no stopping was there
		for(int i=0;i<n-1;i++) {
			swapped=0;
			
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					System.out.println(" Arr j "+arr[j]+" Arr j+1 "+ arr[j+1]);
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped++;
				}
			}
			// Break if no swapping 
			if(swapped==0) {
				break;
			}
		}
		return arr;
	}
}
/**\
 * 
 * ubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. This algorithm is not suitable for large data sets as its average and worst case time complexity is quite high.

 

How Bubble Sort Works?
 
Consider an array arr[] = {5, 1, 4, 2, 8}

First Pass: 

Bubble sort starts with very first two elements, comparing them to check which one is greater.
( 5 1 4 2 8 ) --> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1. 
( 1 5 4 2 8 ) -->  ( 1 4 5 2 8 ), Swap since 5 > 4 
( 1 4 5 2 8 ) -->  ( 1 4 2 5 8 ), Swap since 5 > 2 
( 1 4 2 5 8 ) --> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
Second Pass: 

Now, during second iteration it should look like this:
( 1 4 2 5 8 ) --> ( 1 4 2 5 8 ) 
( 1 4 2 5 8 ) --> ( 1 2 4 5 8 ), Swap since 4 > 2 
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
( 1 2 4 5 8 ) -->  ( 1 2 4 5 8 ) 
Third Pass: 

Now, the array is already sorted, but our algorithm does not know if it is completed.
The algorithm needs one whole pass without any swap to know it is sorted.
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 

 
 * 
 */
