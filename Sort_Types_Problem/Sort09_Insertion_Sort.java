package Sort_Types_Problem;

import java.util.Arrays;

public class Sort09_Insertion_Sort {

	public static void main(String[] args) {
	         	// In place sort 
				//Insertion sort On2 - Stable sort 
				// Used for small array in Tim Sort and InterSort
				//...
				// (n-1)+(n-2)+.....+2+1
				//  n*(n-1)/2
				// O n2 and space O n 
		       // Works in O n in best case ; already sorted 
		        //Worst case ; reverse 
		
		        // We have sorted and unsorted half 
		        // For I find its place in sorted sub array 
		        // Place the element , shift all right element by 1 
		
		        
				
				int arr1[]= {1,3,4,6,8,9,0,2,4,6,7,10};
				int arr2[]= {91, 23, 32, 74 ,6};
				InsertionSort Is= new InsertionSort();
				arr1=Is.InsertSort(arr1);
				System.out.println(Arrays.toString(arr1));
				// Insert sort work for n-1 times * number < sorted  times-n2
				// Use while loop for time optimization 
				
				//Best case - sorted 
				// Worst case - reverse -  n2 
				//General O n2
				arr2=Is.InsertUnstable(arr2);
				System.out.println(Arrays.toString(arr2));
				//Bubble sort is stable 
				//When sort by max first 
				// And swap only if element > current , not >=
				
			}
			
		}

		class InsertionSort{
			void insertionSortGoG(int arr[], int n) 
			{ 
			    int i, key, j; 
			    for (i = 1; i < n; i++)
			    { 
			        key = arr[i]; 
			        j = i - 1; 

			        // Move elements of arr[0..i-1],  
			        // that are greater than key, to one 
			        // position ahead of their 
			        // current position
			        while (j >= 0 && arr[j] > key)
			        { 
			            arr[j + 1] = arr[j]; 
			            j = j - 1; 
			        } 
			        arr[j + 1] = key; 
			    } 
			} 
			
			int[] InsertSort(int arr[])
		    {
				
				int n = arr.length;
				 for (int i = 0; i < n - 1; i++) {
					 int j=i-1;
					 while(j>=0 && arr[j]>arr[i]) {
						 arr[j+1]=arr[j]; //right shifting 
						 j--;
					 }
					 arr[j+1]=arr[i];
				 }
				 return arr;
				//Worst always O n2 
//		        int n = arr.length;
//		        for (int i = 0; i < n - 1; i++) {
//		            for (int j = 0; j <i - 1; j++) {
//		                if (arr[i] < arr[j]) {
//		                    // swap arr[j+1] and arr[j]
//		                    int temp = arr[j];
//		                    arr[j] = arr[i];
//		                    arr[i] = temp;
//		                }
//		            }
//		            
//		        }
//		        return arr;
		    }
			
			int[] InsertUnstable(int arr[]) {
				
				int n = arr.length;
				 for (int i = 0; i < n - 1; i++) {
					 int j=i-1;
					 // As there is equal to sign , not stable will shift same values 
					 while(j>=0 && arr[j]>=arr[i]) {
						 arr[j+1]=arr[j]; //right shifting 
						 j--;
					 }
					 arr[j+1]=arr[i];
				 }
				 return arr;
			}
		}

/**
 * 
 * Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.

Characteristics of Insertion Sort:
This algorithm is one of the simplest algorithm with simple implementation
Basically, Insertion sort is efficient for small data values
Insertion sort is adaptive in nature, i.e. it is appropriate for data sets which are already partially sorted.
Working of Insertion Sort algorithm:
Consider an example: arr[]: {12, 11, 13, 5, 6}

   12   	   11   	   13   	   5   	   6   
First Pass:

Initially, the first two elements of the array are compared in insertion sort.
   12   	   11   	   13   	   5   	   6   
Here, 12 is greater than 11 hence they are not in the ascending order and 12 is not at its correct position. Thus, swap 11 and 12.
So, for now 11 is stored in a sorted sub-array.
   11   	   12   	   13   	   5   	   6   
Second Pass:

 Now, move to the next two elements and compare them
   11   	   12   	   13   	   5   	   6   
Here, 13 is greater than 12, thus both elements seems to be in ascending order, hence, no swapping will occur. 12 also stored in a sorted sub-array along with 11
Third Pass:

Now, two elements are present in the sorted sub-array which are 11 and 12
Moving forward to the next two elements which are 13 and 5
   11   	   12   	   13   	   5   	   6   
Both 5 and 13 are not present at their correct place so swap them
   11   	   12   	   5   	   13   	   6   
After swapping, elements 12 and 5 are not sorted, thus swap again
   11   	   5   	   12   	   13   	   6   
Here, again 11 and 5 are not sorted, hence swap again
   5   	   11   	   12   	   13   	   6   
here, it is at its correct position
Fourth Pass:

Now, the elements which are present in the sorted sub-array are 5, 11 and 12
Moving to the next two elements 13 and 6
   5   	   11   	   12   	   13   	   6   
Clearly, they are not sorted, thus perform swap between both
   5   	   11   	   12   	   6   	   13   
Now, 6 is smaller than 12, hence, swap again
   5   	   11   	   6   	   12   	   13   
Here, also swapping makes 11 and 6 unsorted hence, swap again
   5   	   6   	   11   	   12   	   13   
Finally, the array is completely sorted.
 

Illustrations:

insertion-sort

 

Insertion Sort Algorithm 
To sort an array of size N in ascending order: 

Iterate from arr[1] to arr[N] over the array. 
Compare the current element (key) to its predecessor. 
If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.
 */