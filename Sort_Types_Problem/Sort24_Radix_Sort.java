package Sort_Types_Problem;

import java.util.Arrays;

import arrayCode.ArrayPart01;

/**
 * Radix Sort :
 *     Supports linear time for large range of numbers 
 *     Uses counting sort as sub routine 
 *     Not a comparison based algorithm 
 *     Solves lineraly 
 *     
 *     Counting sort for small numbers , radix for many 
 *     Radix -    Counting n+K if K=n2 worse
 * 
 *     Radix time :
 *     k <= n^c where c is a constant.
 *       Here K =10 
 *       Consider no of didgits as D 
 *       Time D * O (n+10)
 *       Time : O D*n , D - no of digits, N - no of elements 
 *       Space : O 1 as O 10 
 *       
 *       We have trade off between space and time , We can consider two digit at a time .
 *       Space will increase O (100) and time will decrease O D/2 *(n +100)
 *       b - digits to consider , D - total digit 
 *       
 *       Time : O D/b*(n+10^b) 
 *       Space: O (10^b)
 * 
 * Algo :
 *  Make sure the number of digits in each is equal 
 *  arr{ 1,99,999,99999,54} => {00001,00099,00999,99999,00054}
 *  
 *  Find the largest and Find the no of digits by Log of 10 
 *  Rewrite the array with leading zeros 
 *  
 *  Stable sort with last 5th digit lsb 
 *  Stable sort with last 4th digit 
 *  Stable sort with last 3th digit 
 *  Stable sort with last 2th digit 
 *  Stable sort with last 1st digit  msb
 *  
 *  Stable sort - counting sort 
 *   Start count 10 
 *   For digit 1 exp1 , find count = arr[i]/exp%10 => 5678/1 %10 =8 last digit
 *   For digit 2 exp10 , find count = arr[i]/exp%10 => 5678/10 %10 =567%10=7  second last 
 *   For digit 3 exp100, find count = arr[i]/exp%10 => 5678/100 %10 =56%10 = 6 3 last digit 
 *   For digit 4 exp1000, find count = arr[i]/exp%10 => 5678/1000 %10 =5%10 =5 first digit  
 *   
 *   
 * @author shree
 *
 */
public class Sort24_Radix_Sort {

	public static void main(String[] args) {
		
		int arr[]={ 1,99,999,99999,54};
		int n=arr.length;
		System.out.println(" UN  Sorted ");
		ArrayPart01.PrintRayy(arr);
		RadixSortNaive(arr,n);
		System.out.println(" Sorted ");
		ArrayPart01.PrintRayy(arr);
		
		//GOG
		int arr1[]={ 1,99,999,99999,54};
		int n1=arr1.length;
		System.out.println(" UN  Sorted ");
		ArrayPart01.PrintRayy(arr1);
		RadixSortGOG(arr1,n1);
		System.out.println(" Sorted ");
		ArrayPart01.PrintRayy(arr1);
	}

	private static void RadixSortNaive(int[] arr, int n) {
		//  Find max 
		int max=arr[0];
		
		for(int i=0;i<n;i++) {
			max=Math.max(max,arr[i]);
		}
		
		//Check for each and every digit 
		for(int exp=1;(max/exp)>0;exp=exp*10) {
			CountingSortRadix(arr,n,exp);
			System.out.println(" After digit "+exp);
			ArrayPart01.PrintRayy(arr);
		}
		
	}

	private static void CountingSortRadix(int[] arr, int n, int exp) {
		// Sort for each digit 
		int count[]=new int[10];//Only 0-9 possible digits 
		
		// Create count
		/*
		 * * 
		 * For digit 1 exp1 , find count = arr[i]/exp%10 => 5678/1 %10 =8 last digit
		 * For digit 2 exp10 , find count = arr[i]/exp%10 => 5678/10 %10 =567%10=7second last 
		 * For digit 3 exp100, find count = arr[i]/exp%10 => 5678/100 %10=56%10 = 6 3 last digit 
		 * For digit 4 exp1000, find count = arr[i]/exp%10 =>5678/1000 %10 =5%10 =5 first digit
		 */
		for(int i=0;i<n;i++) {
			count[(arr[i]/exp)%10]++;
		}
		
		//int idx1=0;
		// K is 10 as only last digit 
		for(int i=1;i<10;i++) {
			count[i]=count[i-1]+count[i];
		}
		
		int output[]=new int[n];
		int idx=0;
		for(int i=n-1;i>=0;i--) {
			idx=(arr[i]/exp)%10;
			output[(count[idx]-1)]=arr[i];
			count[idx]--;
			
		}
		
		for(int i=0;i<n;i++) {
			arr[i]=output[i];
		}
		//ArrayPart01.PrintRayy(arr);
	}
	
	
	// A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void RadixSortGOG(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // A utility function to print an array
//    static void print(int arr[], int n)
//    {
//        for (int i = 0; i < n; i++)
//            System.out.print(arr[i] + " ");
//    }

}

/*
 * 
 * The lower bound for the Comparison based sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is Ω(nLogn), i.e., they cannot do better than nLogn. Counting sort is a linear time sorting algorithm that sort in O(n+k) time when elements are in the range from 1 to k.

What if the elements are in the range from 1 to n2? 

 

We can’t use counting sort because counting sort will take O(n2) which is worse than comparison-based sorting algorithms. Can we sort such an array in linear time? 

Radix Sort is the answer. The idea of Radix Sort is to do digit by digit sort starting from least significant digit to most significant digit. Radix sort uses counting sort as a subroutine to sort.

The Radix Sort Algorithm 

Do the following for each digit I where I varies from the least significant digit to the most significant digit. Here we will be sorting the input array using counting sort (or any stable sort) according to the i’th digit.

Example:

Original, unsorted list: 170, 45, 75, 90, 802, 24, 2, 66 Sorting by least significant digit (1s place) gives: [*Notice that we keep 802 before 2, because 802 occurred before 2 in the original list, and similarly for pairs 170 & 90 and 45 & 75.] 170, 90, 802, 2, 24, 45, 75, 66 Sorting by next digit (10s place) gives: [*Notice that 802 again comes before 2 as 802 comes before 2 in the previous list.] 802, 2, 24, 45, 66, 170, 75, 90 Sorting by the most significant digit (100s place) gives: 2, 24, 45, 66, 75, 90, 170, 802

What is the running time of Radix Sort? 

Let there be d digits in input integers. Radix Sort takes O(d*(n+b)) time where b is the base for representing numbers, for example, for the decimal system, b is 10. What is the value of d? If k is the maximum possible value, then d would be O(logb(k)). So overall time complexity is O((n+b) * logb(k)). Which looks more than the time complexity of comparison-based sorting algorithms for a large k. Let us first limit k. Let k <= nc where c is a constant. In that case, the complexity becomes O(nLogb(n)). But it still doesn’t beat comparison-based sorting algorithms. 
What if we make the value of b larger? What should be the value of b to make the time complexity linear? If we set b as n, we get the time complexity as O(n). In other words, we can sort an array of integers with a range from 1 to nc if the numbers are represented in base n (or every digit takes log2(n) bits). 

 

Applications of Radix Sort: 

In a typical computer, which is a sequential random-access machine, where the records are keyed by multiple fields radix sort is used. For eg., you want to sort on three keys month, day and year. You could compare two records on year, then on a tie on month and finally on the date. Alternatively, sorting the data three times using Radix sort first on the date, then on month, and finally on year could be used.
It was used in card sorting machines with 80 columns, and in each column, the machine could punch a hole only in 12 places. The sorter was then programmed to sort the cards, depending upon which place the card had been punched. This was then used by the operator to collect the cards which had the 1st row punched, followed by the 2nd row, and so on.
 * 
 * 
 * 
 * 
 */
