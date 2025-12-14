package Sort_Types_Problem;

import java.util.Arrays;

public class Sort08_Selection_Sort {

	public static void main(String[] args) {
		        // Selection sort - On2 - Unstable 
		// In place algorithm , no extra memory 
		        //Good read - write compared to others 
				// Does less memory write 
				// Cycle sort - more memory writes optimized 
				//It is basic idea for heap sort 
		
				// (n-1)+(n-2)+.....+2+1   if 
				//  n*(n-1)/2  ............for 
				// O n2
		       //Always O n2 time complexity 
				
		        //Find minimum in the array - put in 1st place - replace with infinite 
		       // Find next minimum - put in second place- re0lace with Inf 
		        // So on ....
		
				int arr1[]= {1,3,4,6,8,9,0,2,4,6,7,10};
				int arr2[]= {91, 23, 32, 74 ,6};
				SelectionSort Ss= new SelectionSort();
				arr1=Ss.SelectionSortmethod(arr1);
				System.out.println(Arrays.toString(arr1));
				//Selection sorting 
				// Rearrange elements for optimization
				arr2=Ss.SelectionSortOptimized(arr2);
				System.out.println(Arrays.toString(arr2));
				//Selection sort is  NOT stable 
				// We take min/max 
				// Add at diff place 
				// So does not gurantee position for equal values
			}
			
		}

		class SelectionSort{
			int[] SelectionSortmethod(int arr[])
		    {
				// Use temp array - an extra array to place the sorted elements 
				int n = arr.length;

		        // One by one move boundary of unsorted subarray
		        for (int i = 0; i < n-1; i++)
		        {
		            // Find the minimum element in unsorted array
		            int min_idx = i;
		            for (int j = i+1; j < n; j++)
		                if (arr[j] < arr[min_idx])
		                    min_idx = j;

		            // Swap the found minimum element with the first
		            // element
		            int temp = arr[min_idx];
		            arr[min_idx] = arr[i];
		            arr[i] = temp;
		        }
		        
		        return arr;
		    }
			
			int[] SelectionSortOptimized(int arr[]) {
				
				 int n = arr.length;
			        int min=0;
			        int swap=0;
			      //  int temp[]=arr;
			     //   int minj=0;
			        for (int i = 0; i < n-1; i++) {
			        	min=i;
			        //	minj=i;
			            for (int j = i+1; j < n; j++) {
			                if (arr[j] <arr[min]) {
			                    // swap arr[j+1] and arr[j]
			                    min=j;
			                  //  minj=j;
			                }
			            }
			            swap=arr[i];
			            arr[i]=arr[min];
			            arr[min]=swap;
			            
			           // temp[i]=min;
			           // arr[minj]=Integer.MIN_VALUE;
			        }
			        //arr=temp;
			        return arr;
			}
		}
		
/**
 * 
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

The subarray which is already sorted. 
Remaining subarray which is unsorted.
In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray. 

Flowchart of the Selection Sort: 
 

Selection-Sort-Flowhchart
How selection sort works?
Lets consider the following array as an example: arr[] = {64, 25, 12, 22, 11}

First pass:

For the first position in the sorted array, the whole array is traversed from index 0 to 4 sequentially. The first position where 64 is stored presently, after traversing whole array it is clear that 11 is the lowest value.
   64   	   25   	   12   	   22   	   11   
Thus, replace 64 with 11. After one iteration 11, which happens to be the least value in the array, tends to appear in the first position of the sorted list.
   11   	   25   	   12   	   22   	   64   
 

Second Pass:

For the second position, where 25 is present, again traverse the rest of the array in a sequential manner.
   11   	   25   	   12   	   22   	   64   
After traversing, we found that 12 is the second lowest value in the array and it should appear at the second place in the array, thus swap these values.
   11   	   12   	   25   	   22   	   64   
Third Pass:
 

Now, for third place, where 25 is present again traverse the rest of the array and find the third least value present in the array.
   11   	   12   	   25   	   22   	   64   
While traversing, 22 came out to be the third least value and it should appear at the third place in the array, thus swap 22 with element present at third position.
   11   	   12   	   22   	   25   	   64   
Fourth pass:

Similarly, for fourth position traverse the rest of the array and find the fourth least element in the array 
As 25 is the 4th lowest value hence, it will place at the fourth position.
   11   	   12   	   22   	   25   	   64   

Fifth Pass:

At last the largest value present in the array automatically get placed at the last position in the array
The resulted array is the sorted array.
   11   	   12   	   22   	   25   	   64   
Approach:
Initialize minimum value(min_idx) to location 0
Traverse the array to find the minimum element in the array
While traversing if any element smaller than min_idx is found then swap both the values.
Then, increment min_idx to point to next element
Repeat until array is sorted
 */
