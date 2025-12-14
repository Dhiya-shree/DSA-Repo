package impAlgorithm_Sorting;

/**
 * Count inversions in a array ...................... 8 MARK
 * A pair (arr i , arr j ) is inversed if
 * 1) i<j
 * 2) arr[i]>arr[j]
 * 
 * Inversion Count for an array indicates – how far (or close) the array is from
 * being sorted. If the array is already sorted, then the inversion count is 0,
 * but if the array is sorted in reverse order, the inversion count is the
 * maximum.
 * 
 * Given an array a[]. The task is to find the inversion count of a[]. Where two
 * elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * 
 * Examples:
 * 
 * Input: arr[] = {8, 4, 2, 1}
 * Output: 6
 * Explanation: Given array has six inversions: (8, 4), (4, 2), (8, 2), (8, 1),
 * (4, 1), (2, 1).
 * 
 * 
 * 
 * Input: arr[] = {1, 20, 6, 4, 5}
 * Output: 5
 * Explanation: Given array has five inversions: (20, 6), (20, 4), (20, 5), (6,
 * 4), (6, 5).
 * 
 * Naive Approach:
 * 
 * Traverse through the array, and for every index, find the number of smaller
 * elements on its right side of the array. This can be done using a nested
 * loop. Sum up the counts for all indices in the array and print the sum.
 * 
 * Follow the below steps to Implement the idea:
 * 
 * Traverse through the array from start to end
 * For every element, find the count of elements smaller than the current number
 * up to that index using another loop.
 * Sum up the count of inversion for every index.
 * Print the count of inversions.
 * Below is the Implementation of the above approach:
 * 
 * // C++ program to Count Inversions
 * // in an array
 * #include <bits/stdc++.h>
 * using namespace std;
 * 
 * int getInvCount(int arr[], int n)
 * {
 * int inv_count = 0;
 * for (int i = 0; i < n - 1; i++)
 * for (int j = i + 1; j < n; j++)
 * if (arr[i] > arr[j])
 * inv_count++;
 * 
 * return inv_count;
 * }
 * 
 * // Driver Code
 * int main()
 * {
 * int arr[] = { 1, 20, 6, 4, 5 };
 * int n = sizeof(arr) / sizeof(arr[0]);
 * cout << " Number of inversions are "
 * << getInvCount(arr, n);
 * return 0;
 * }
 * 
 * // This code is contributed
 * // by Akanksha Rai
 * 
 * 
 * Output
 * 
 * Number of inversions are 5
 * Time Complexity: O(N2), Two nested loops are needed to traverse the array
 * from start to end.
 * Auxiliary Space: O(1), No extra space is required.
 * 
 * 
 * 
 * Problem #5 : Count inversions in a array .................... 8 mark
 * A pair (arr i , arr j ) is inversed if
 * 1) i<j
 * 2) arr[i]>arr[j]
 * 
 * Count Inversions in an array using Merge Sort:
 * Below is the idea to solve the problem:
 * 
 * Use Merge sort with modification that every time an unsorted pair is found
 * increment count by one and return count at the end.
 * 
 * Illustration:
 * 
 * Suppose the number of inversions in the left half and right half of the array
 * (let be inv1 and inv2); what kinds of inversions are not accounted for in
 * Inv1 + Inv2?
 * The answer is – the inversions that need to be counted during the merge step.
 * Therefore, to get the total number of inversions that needs to be added are
 * the number of inversions
 * in the left subarray, right subarray, and merge().
 * 
 * How to get the number of inversions in merge()?
 * In merge process, let i is used for indexing left sub-array and j for right
 * sub-array. At any step in merge(), if a[i] is greater than a[j], then there
 * are (mid – i) inversions. because left and right subarrays are sorted, so all
 * the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be
 * greater than a[j]
 * 
 * 
 * 
 * Follow the below steps to Implement the idea
 * 
 * The idea is similar to merge sort, divide the array into two equal or almost
 * equal halves in each step until the base case is reached.
 * Create a function merge that counts the number of inversions when two halves
 * of the array are merged,
 * Create two indices i and j, i is the index for the first half, and j is an
 * index of the second half.
 * If a[i] is greater than a[j], then there are (mid – i) inversions because
 * left and right subarrays are sorted, so all the remaining elements in
 * left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
 * Create a recursive function to divide the array into halves and find the
 * answer by summing the number of inversions in the first half, the number of
 * inversions in the second half and the number of inversions by merging the
 * two.
 * The base case of recursion is when there is only one element in the given
 * half.
 * Print the answer.
 * 
 * Time Complexity: O(n * log n), The algorithm used is divide and conquer i.e.
 * merge sort whose complexity is O(n log n).
 * Auxiliary Space: O(n), Temporary array.
 * 
 * Note: The above code modifies (or sorts) the input array. If we want to count
 * only inversions, we need to create a copy of the original array and call
 * mergeSort() on the copy to preserve the original array’s order.
 * 
 * 
 * 
 * @author shree
 *
 */
public class Inversion_Count_Merge_Sort {

	public static void main(String[] args) {
		/////// Count inversion
		// If array sorted - no inversion
		// If array reverse (4,3,2,1) the it will form (4,3)(4,2)(4,1)(3,2)(3,1)(2,1)
		// for n =4 , 3+2+1
		// Reverse - n-1 + n-2 + ...1 => n(n-1)/2

		int ainv[] = { 2, 4, 1, 3, 5 };
		int ainv_copy[] = { 2, 4, 1, 3, 5 };
		// Cant send array two times , it will be sorted the first time bro
		int len = ainv.length;
		int sol = CountInversions(ainv);
		System.out.println(" Count inv " + sol);

		sol = CountInversionsGOG(ainv_copy, 0, len - 1);
		System.out.println(" Count inv GOG " + sol);
	}

	private static int CountInversionsGOG(int arr[], int l, int r) {
		int res = 0;
		if (l < r) {

			int m = (r + l) / 2;

			res += CountInversionsGOG(arr, l, m);
			res += CountInversionsGOG(arr, m + 1, r);
			res += countAndMerge(arr, l, m, r);
		}
		return res;
	}

	static int countAndMerge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1, n2 = r - m;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for (int i = 0; i < n1; i++)
			left[i] = arr[i + l];
		for (int j = 0; j < n2; j++)
			right[j] = arr[m + 1 + j];
		int res = 0, i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
				res = res + (n1 - i);
			}
		}
		while (i < n1)
			arr[k++] = left[i++];
		while (j < n2)
			arr[k++] = right[j++];
		return res;
	}

	private static int CountInversions(int[] ainv) {
		// Use merging
		// Every possiblity needs to be checked
		// Arr i> arr j , i<j can be
		// 0 , 1
		// 0 and n-1
		// or anywhere in between
		// As it needs to be checked between every two number use merge sort
		int n = ainv.length;

		int ans = MergeCountInversions(ainv, n, 0, n - 1);
		return ans;
	}

	private static int MergeCountInversions(int[] ainv, int n, int low, int high) {
		// Merge count inv
		int res = 0;
		if (low < high) {
			int mid = (low + high) / 2;
			res = res + MergeCountInversions(ainv, n, low, mid);
			res = res + MergeCountInversions(ainv, n, mid + 1, high);
			res = res + MergeCountInversion_FINAL(ainv, n, low, mid, high);
		}
		return res;
	}

	private static int MergeCountInversion_FINAL(int[] arr, int n, int low, int mid, int high) {
		// Merge final inversion O n times

		if (high - low == 1) {
			if (arr[low] > arr[high]) {
				return 1;
			} else {
				return 0;
			}
		}
		int res = 0;
		int n1 = mid - low + 1;
		int n2 = high - mid;
		int left[] = new int[n1];
		int right[] = new int[n2];
		for (int i = 0; i < n1; i++) {
			left[i] = arr[i + low];
		}
		for (int i = 0; i < n2; i++) {
			right[i] = arr[i + mid + 1];
		}
		// int ans[]=nre int[n1+n2];
		int i = 0;
		int j = 0;
		// int tot=n1+n2;
		// Why initiating of index needs to be low
		int index = low;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				// res++;
				arr[index] = left[i];
				index++;
				i++;

			} else {
				arr[index] = right[j];
				j++;
				index++;
				/// Res update - left> right
				res = res + (n1 - i);
			}
		}

		while (i < n1) {
			arr[index] = left[i];
			i++;
			index++;
		}

		System.out.println(right.toString());

		while (j < n2) {
			arr[index] = right[j];
			System.out.println(" J is " + j);
			j++;
			index++;
		}

		return res;
	}

}
