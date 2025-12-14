package Sort_Types_Problem;

import arrayCode.ArrayPart01;

/**
 * Cycle sort 
 * 
 *    1) Worst case is O n2
 *    2) Least memory writes -> useful where memory writes are costly eeprom - write reduce the age 
 *    3) In place and Not stable 
 *    4) Useful for questions like :
 *       8 MARK .... Find minimum swap need to sort array
 *    Time Complexity Analysis: 
 *        Worst Case: O(n2) 
 *        Average Case: O(n2) 
 *        Best Case: O(n2)
 *        Auxiliary Space: O(1)
 *    The space complexity is constant cause this algorithm is in place so it does not use any extra memory to sort. 
 *     
 *     
 *     
 *  1) Count how many element are smaller than current element 
 *  2) Find pos of current elemnt and place it there      
 * 
 *  Ex 1:
 *   20 40 50 10 30 -- for 20 1 smaller pos 1 val 40 .......1 swap
 *   20 40. 50 10 30 -- for 40 3 smaller pos 3 val 10 ..... 1 swap 
 *   20.. 40. 50 10 30 -- for 10 0 smaller pos 0 val 20 ....1 swap
 *   Cycle 1 observed - Swapped above 
 *   10 20 50 40 30 
 *   
 *   Again.....
 *   10 20 50. 40 30 --for 50 4 smaller pos 4 val 30........1 swap
 *   10 20 50.. 40 30.-- for 30 2 smaller pos 2 val 50......1 swap 
 *   Cycle 2 observed - Swapped above 
 *   10 20 30 40 50
 *   Total swap : 5
 *   
 *  Ex 2: 40 30 20 10
 *   40. 30 20 10 -- for 40 smaller 3 pos 3 val 10 
 *   40.. 30 20 10. -- for 10 smaller 0 pos 0 val 40
 *   Cycle 1 swap 
 *   
 *   10 30. 20.. 40 -- 30 20 swap cycle 2  
 *   
 * EX 3: Sorted array 10 20 30 
 *  10. 20 30 - for 10 smaller 0 pos 0 val 10 
 *  Cycle observed swap
 *  10 20. 30 - for 20 smaller 1 pos 1 val 20 
 *  Cycle observed swap
 *  10 20 30. - for 30 smaller 2 pos 2 val 30 
 *  Cycle observed swap
 *  
 *  Cycle sort is an in-place sorting Algorithm, unstable sorting algorithm, and a comparison sort that is theoretically optimal in terms of the total number of writes to the original array. 
 

It is optimal in terms of the number of memory writes. It minimizes the number of memory writes to sort (Each value is either written zero times if it’s already in its correct position or written one time to its correct position.)
It is based on the idea that the array to be sorted can be divided into cycles. Cycles can be visualized as a graph. We have n nodes and an edge directed from node i to node j if the element at i-th index must be present at j-th index in the sorted array. 
Cycle in arr[] = {2, 4, 5, 1, 3} 


 * @author shree
 *
 */
public class Sort21_Cycle_Sort {

	public static void main(String[] args) {
		
		int arr[]= {50,10,20,30,40};
		int n=arr.length;
		
		CycleSortDistinct(arr,n);
		
		int arr1[]= {10,20,50,20,20,30,40};
		int n1=arr1.length;
		CycleSortDuplicate(arr1,n1);
		
		int arr1c[]= {10,20,50,20,20,30,40};
		int n1c=arr1c.length;
		cycleSort(arr1c,n1c);
		
		int arr2[]= {50,10,20,30,40};
		int n2=arr.length;
		
		CycleSortFindTheSwap(arr2,n2);
	}

	private static void CycleSortFindTheSwap(int[] arr, int n) {
		// Cs - cycle start 
				int swap=0; int count=0;
				for(int cs=0;cs<n-1;cs++) {
					
					// Check the smaller and its current pos 
					int item=arr[cs];
					int pos=cs;
					
					for(int i=cs+1;i<n;i++) {
						if(arr[i]<item) {
							pos++;
							//System.out.println(" Pos val "+pos);
						}
					}
					// If item is already in correct position
					if (pos == cs)
						continue;

//					// ignore all duplicate elements
					while (item == arr[pos])
						pos += 1;

					// put the item to it's right position
					if (pos != cs) {
					System.out.println(" 1....Swapping "+arr[pos]+" at "+pos +" With "+arr[cs]+" At cs"+cs);
					//swap the correct to its place 
					swap = item;
					//item = arr[pos];
					arr[cs]=arr[pos];
					arr[pos] = swap;
					count++;
					}
					
					while(pos!=cs && arr[cs]!=arr[pos] ) {
						
						// Check the smaller and its current pos 
						item=arr[cs];
						pos=cs;
						
						for(int i=cs+1;i<n;i++) {
							if(arr[i]<item) {
								pos++;
							}
						}
						
						// If item is already in correct position
						if (pos == cs)
							continue;

//						// ignore all duplicate elements
						while (item == arr[pos])
							pos += 1;

						// put the item to it's right position
						if (pos != cs) {
							System.out.println("2.... Swapping "+arr[pos]+" at "+pos +" With "+arr[cs]+" At cs"+cs);
						//swap the correct to its place 
							swap = item;
							//item = arr[pos];
							arr[cs]=arr[pos];
							arr[pos] = swap;
							count++;
						}
					}
				}
				System.out.println("Count is "+count);
				System.out.println(" Cycle sorted dupliate ");
				ArrayPart01.PrintRayy(arr);
		
	}

	private static void CycleSortDuplicate(int[] arr, int n) {
		// Cs - cycle start 
		int swap=0;
		for(int cs=0;cs<n-1;cs++) {
			
			// Check the smaller and its current pos 
			int item=arr[cs];
			int pos=cs;
			
			for(int i=cs+1;i<n;i++) {
				if(arr[i]<item) {
					pos++;
					//System.out.println(" Pos val "+pos);
				}
			}
			// If item is already in correct position
			if (pos == cs)
				continue;

//			// ignore all duplicate elements
			while (item == arr[pos])
				pos += 1;

			// put the item to it's right position
			if (pos != cs) {
			System.out.println(" 1....Swapping "+arr[pos]+" at "+pos +" With "+arr[cs]+" At cs"+cs);
			//swap the correct to its place 
			swap = item;
			//item = arr[pos];
			arr[cs]=arr[pos];
			arr[pos] = swap;
			}
			
			while(pos!=cs && arr[cs]!=arr[pos] ) {
				
				// Check the smaller and its current pos 
				item=arr[cs];
				pos=cs;
				
				for(int i=cs+1;i<n;i++) {
					if(arr[i]<item) {
						pos++;
					}
				}
				
				// If item is already in correct position
				if (pos == cs)
					continue;

//				// ignore all duplicate elements
				while (item == arr[pos])
					pos += 1;

				// put the item to it's right position
				if (pos != cs) {
					System.out.println("2.... Swapping "+arr[pos]+" at "+pos +" With "+arr[cs]+" At cs"+cs);
				//swap the correct to its place 
					swap = item;
					//item = arr[pos];
					arr[cs]=arr[pos];
					arr[pos] = swap;
				}
			}
		}
		System.out.println(" Cycle sorted dupliate ");
		ArrayPart01.PrintRayy(arr);
		
	}

	private static void CycleSortDistinct(int[] arr, int n) {
		// CS - for cycle start  , before CS will be sorted 0-cs-1 sorted 
		// N-1 bcos not needed for last element 
		int swap=0;
		for(int cs=0;cs<=n-2;cs++) {
			int item=arr[cs];//element at discussion 
			int pos=cs;// No of smaller ele in array 
			
			for(int i=cs+1;i<n;i++) { //Checking for all values lesser than cs 
				
				if(arr[i]<item) {
					pos++;
				}
			}
			//Count smaller 
			//Swap
			//Continue till smaller element and current position are same 
			
			//swap the correct element of pos 0 
			swap = item;
			item = arr[pos];
			arr[pos] = swap;
			
			//Below will execute only if swap one time did not give val 
			//Cycle observed when pos==cs 
			// Till we find cycle 
			while(pos!=cs) {
				
				pos=cs;
				//item=arr[cs];
				//Above we did for 1 swap , here swap till cycle found 
				for(int i=cs+1;i<n;i++) { //Checking for all values lesser than cs 
					
					if(arr[i]<item) {
						pos++;
					}
				}
				
				//swap the correct elemet of pos 0 
//				swap=item;
//				arr[cs]=arr[pos];
//				arr[pos]=item;
				swap = item;
				item = arr[pos];
				arr[pos] = swap;
			}
			
		}
		System.out.println(" Cycle sorted ");
		ArrayPart01.PrintRayy(arr);
		
	}
	
	// Function sort the array using Cycle sort
		public static void cycleSort(int arr[], int n)
		{
			// count number of memory writes
			int writes = 0;

			// traverse array elements and put it to on
			// the right place
			for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
				// initialize item as starting point
				int item = arr[cycle_start];

				// Find position where we put the item. We basically
				// count all smaller elements on right side of item.
				int pos = cycle_start;
				for (int i = cycle_start + 1; i < n; i++)
					if (arr[i] < item)
						pos++;

				// If item is already in correct position
				if (pos == cycle_start)
					continue;

				// ignore all duplicate elements
				while (item == arr[pos])
					pos += 1;

				// put the item to it's right position
				if (pos != cycle_start) {
					int temp = item;
					item = arr[pos];
					arr[pos] = temp;
					writes++;
				}

				// Rotate rest of the cycle
				while (pos != cycle_start) {
					pos = cycle_start;

					// Find position where we put the element
					for (int i = cycle_start + 1; i < n; i++)
						if (arr[i] < item)
							pos += 1;

					// ignore all duplicate elements
					while (item == arr[pos])
						pos += 1;

					// put the item to it's right position
					if (item != arr[pos]) {
						System.out.println(" Swapping "+arr[pos]+" at "+pos +" With "+item);
						int temp = item;
						item = arr[pos];
						arr[pos] = temp;
						writes++;
					}
				}
			}
			System.out.println(" No of writes "+writes);
			System.out.println(" Cycle sorted GoG");
			ArrayPart01.PrintRayy(arr);
		}
}
