package Sort_Types_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import arrayCode.ArrayPart01;

/**
 * Problem #1:Merge 3 sorted array
 * Given three sorted arrays A, B and C of size N, M and P respectively.
 * The task is to merge them into a single array which must be sorted in
 * increasing order.
 * 
 * Problem #2: Find triplets with sum 0
 * Given an array arr[] of n integers. Check whether it contains a triplet that
 * sums up to zero.
 * Note: Return 1, if there is at least one triplet following the condition else
 * return 0.
 * 
 * Problem #2: Intersection for 2 sorted array
 * The intersection of two arrays contains the elements common to both the
 * arrays. The intersection should not count duplicate elements.
 * Given two sorted arrays arr1[] and arr2[] of sizes N and M respectively. Find
 * their intersection
 * Intersection
 * Iterate in while loop till any of the one array is finished.
 * In each iteration we look for smaller of the two elements from both the array
 * and increase its pointer because it will not be in other list, hence not part
 * of intersection.
 * For intersection, if both the elements are equal we print it and increment
 * both pointer only if it is not same as the last element printed in
 * intersection.
 * 
 * Time Complexity: O(max(m*log(m), n*log(n)) + min(m, n) )
 * Auxiliary Space: O(1)
 * 
 * 
 * 
 * Problem # 4 : Union of sorted array
 * 
 * Given two unsorted arrays that represent two sets (elements in every array
 * are distinct), find the union and intersection of two arrays.
 * Example:
 * arr1[] = {7, 1, 5, 2, 3, 6} arr2[] = {3, 8, 6, 20, 7}
 * Then your program should print Union as {1, 2, 3, 5, 6, 7, 8, 20}.
 * 
 * Method: (Using map data structure)
 * From the knowledge of data structures, we know that map stores distinct keys
 * only. So if we insert any key appearing more than one time it gets stored
 * only once. The idea is to insert both the arrays in one common map which
 * would then store the distinct elements of both arrays (union of both the
 * array).
 * 
 * Time Complexity: O(m * log(m) + n * log(n)), for using map data structure.
 * Auxiliary Space: O(m + n)
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
 * @author shree
 *
 */
public class Sort14_Merge_Sort5 {

	public static void main(String[] args) {

		int A[] = { 1, 2, 3, 4 };
		int B[] = { 1, 2, 3, 4, 5 };
		int C[] = { 1, 2, 3, 4, 5, 6 };
		ArrayList<Integer> Al = new ArrayList<Integer>();
		Al = merge3sorted(A, B, C);
		System.out.println(Al.toString());

		//////////////////////////////////////////
		int arr[] = { 60, -65, 5, -21, 8, 93 };
		boolean ans = findTriplets(arr, arr.length);
		System.out.println(" As " + ans);

		////////////////////////////////////////
		// Intersection of sorted array

		ArrayList<Integer> ansI = IntersectionSortedArray(A, B);
		System.out.println(" aNs Intersection " + ansI.toString());

		////////////////////////////////////////
		// Union of sorted array

		int a1[] = { 1, 35 };
		int a2[] = { 6, 9, 13, 15, 20, 25, 29, 46 };
		ArrayList<Integer> ansU = UnionSortedArrayNaive(a1, a2);
		System.out.println(" aNs Intersection " + ansU.toString());

		ansU = UnionSortedArrayEfficient(a1, a2);
		System.out.println(" aNs Intersection " + ansU.toString());

		/////// Count inversion
		// If array sorted - no inversion
		// If array reverse (4,3,2,1) the it will form (4,3)(4,2)(4,1)(3,2)(3,1)(2,1)
		// for n =4 , 3+2+1
		// Reverse - n-1 + n-2 + ...1 => n(n-1)/2

		long ainv[] = { 2, 4, 1, 3, 5 };
		int ainvCopy[] = { 2, 4, 1, 3, 5 };
		int len = ainv.length;
		long sol = CountInversions(ainv);
		System.out.println(" Count inv " + sol);

		sol = CountInversionsGOG(ainvCopy, 0, len - 1);
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

	private static long CountInversions(long[] ainv) {
		// Use merging
		// Every possiblity needs to be checked
		// Arr i> arr j , i<j can be
		// 0 , 1
		// 0 and n-1
		// or anywhere in between
		// As it needs to be checked between every two number use merge sort
		long n = ainv.length;

		long ans = MergeCountInversions(ainv, n, 0, n - 1);
		return ans;
	}

	private static long MergeCountInversions(long[] ainv, long n, long low, long high) {
		// Merge count inv
		long res = 0;
		if (low < high) {
			long mid = (low + high) / 2;
			res = res + MergeCountInversions(ainv, n, low, mid);
			res = res + MergeCountInversions(ainv, n, mid + 1, high);
			res = res + MergeCountInversion_FINAL(ainv, n, low, mid, high);
		}
		return res;
	}

	private static long MergeCountInversion_FINAL(long[] ainv, long n, long low, long mid, long high) {
		// Merge final inversion O n times

		// if(high-low==1) {
		// if(arr[low]>arr[high]) {
		// return 1;
		// }
		// else {
		// return 0;
		// }
		// }
		long res = 0;
		int n1 = (int) (mid - low + 1);
		int n2 = (int) (high - mid);
		long left[] = new long[n1];
		long right[] = new long[n2];
		for (int i = 0; i < n1; i++) {
			left[i] = ainv[(int) (i + low)];
		}
		for (int i = 0; i < n2; i++) {
			right[i] = ainv[(int) (i + mid + 1)];
		}
		// int ans[]=nre int[n1+n2];
		int i = 0;
		int j = 0;
		// int tot=n1+n2;
		// Why initiating of index needs to be low
		int index = (int) low;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				// res++;
				ainv[index] = left[i];
				index++;
				i++;

			} else {
				ainv[index] = right[j];
				j++;
				index++;
				/// Res update - left> right
				res = res + (n1 - i);
			}
		}

		while (i < n1) {
			ainv[index] = left[i];
			i++;
			index++;
		}

		System.out.println(right.toString());

		while (j < n2) {
			ainv[index] = right[j];
			System.out.println(" J is " + j);
			j++;
			index++;
		}

		return res;
	}

	private static ArrayList<Integer> UnionSortedArrayEfficient(int[] a, int[] b) {
		// Union efficient O m+n
		// Use merge sort theory

		ArrayList<Integer> al = new ArrayList<Integer>();
		int n = a.length;
		int m = b.length;
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			System.out.println(" I " + i + " J " + j);
			if ((i > 0) && (a[i] == a[i - 1])) {
				i++;
				System.out.println(" INc i");
				continue;
			}

			if ((j > 0) && (b[j] == b[j - 1])) {
				j++;
				System.out.println(" INc j");
				continue;
			}

			if (a[i] > b[j]) {
				al.add(b[j]);
				System.out.println(" add j " + b[j]);
				// Increment j
				j++;
			} else if (b[j] > a[i]) {
				// Increment 1 st array
				al.add(a[i]);
				System.out.println(" add i " + a[i]);
				i++;
			} else {
				System.out.println(" add j i " + a[i] + "...j " + b[j]);
				al.add(b[j]);
				i++;
				j++;
			}
		}
		System.out.println(" Out of loop i-" + i + " J " + j);
		while (i < n) {
			// Below condt bery necessary as the remaining element can contain duplicates

			if ((i > 0) && (a[i] == a[i - 1])) {
				i++;
				System.out.println(" INc i");
				continue;
			}
			System.out.println(" add i ool " + a[i]);
			al.add(a[i]);
			i++;
		}
		while (j < m) {
			// Below condt bery necessary as the remaining element can contain duplicates
			if ((j > 0) && (b[j] == b[j - 1])) {
				j++;
				System.out.println(" INc j");
				continue;
			}
			System.out.println(" add j ooj " + b[j]);
			al.add(b[j]);
			j++;
		}
		return al;
	}
	/*
	 * 17 2
	 * 1 4 18 19 19 28 29 32 35 35 39 39 44 49 49 50 50
	 * 8 34
	 */

	private static ArrayList<Integer> UnionSortedArrayNaive(int[] a, int[] b) {
		// Union Naive O (m+n) log(m+n)

		ArrayList<Integer> al = new ArrayList<Integer>();
		int n = a.length;
		int m = b.length;
		// int i=0;int j=0;

		for (int i = 0; i < n; i++) {
			al.add(a[i]);
		}
		for (int i = 0; i < m; i++) {
			al.add(b[i]);
		}

		/// Sort the array
		Collections.sort(al);

		// Remove duplicates
		for (int i = (m + n - 1); i > 0; i--) {

			if (al.get(i) == al.get(i - 1)) {
				al.remove(i);
			}
		}
		return al;
	}

	private static ArrayList<Integer> IntersectionSortedArray(int[] a, int[] b) {
		// Intersection of two arrat

		ArrayList<Integer> al = new ArrayList<Integer>();
		int n = a.length;
		int m = b.length;
		int i = 0;
		int j = 0;
		while (i < n && j < m) {

			if ((i > 0) && (a[i] == a[i - 1])) {
				i++;
				continue;
			}

			if (a[i] > b[j]) {
				// Increment j
				j++;
			} else if (b[i] > a[i]) {
				// Increment 1 st array
				i++;
			} else {
				al.add(a[i]);
				i++;
			}
		}
		return al;
	}

	public static boolean findTriplets(int arr[], int n) {
		// -65 -21 5 8 60 93
		// add code here.
		Arrays.sort(arr);
		ArrayPart01.PrintRayy(arr);

		// Special cases after sorting
		if (arr[0] > 0) {
			return false;
		}
		if (n < 2) {
			return false;
		}
		if (arr[0] == 0 && n > 2) {
			if (arr[1] == 0 && arr[2] == 0) {
				return true;
			} else {
				return false;
			}
		}
		// end

		int sum = 0;
		boolean flag = false;// int val=0;
		for (int i = 0; i < n - 2; i++) {
			sum = 0;
			int p1 = 0;
			int p2 = n - 1;
			while (p2 > p1) {
				System.out.println(" P1 " + p1 + " P2 " + p2);
				sum = arr[p1] + arr[p2] + arr[i];
				System.out.println(" p1 " + arr[p1] + " p2 " + arr[p2] + " sum " + sum);
				// val=Math.abs(sum-arr[i]);
				if ((sum == 0) && p1 != i && p2 != i && p1 != p2) {
					flag = true;
					return flag;
				}
				if (sum > 0) {
					p2--;
					System.out.println(" P2 --------------");
				} else {
					System.out.println(" P1 ++++++++++++");
					p1++;
				}

			}
		}

		return flag;
	}

	static ArrayList<Integer> merge3sorted(int A[], int B[], int C[]) {
		// add ypur code here
		ArrayList<Integer> Al = new ArrayList<Integer>();
		int n1 = A.length;
		int n2 = B.length;
		int n3 = C.length;
		int tot = n1 + n2 + n3;
		int l = 0, m = 0, n = 0;
		System.out.println(" N 1 " + n1 + " n2 " + n2 + " n3 " + n3 + "  tot " + tot);
		boolean lflg = true, mflg = true, nflg = true;
		int i = 0;
		while (i < tot && lflg && mflg && nflg) {
			if (lflg && (A[l] <= B[m] && A[l] <= C[n])) {
				Al.add(A[l]);
				// l++;
				if (l == n1 - 1) {
					lflg = false;
				} else {
					l++;
				}
			} else if (mflg && (B[m] <= A[n] && B[m] <= C[n])) {
				Al.add(B[m]);
				// m++;
				if (m == n2 - 1) {
					mflg = false;
				} else {
					m++;
				}
			} else if (nflg) {
				Al.add(C[n]);
				// n++;
				if (n == n3 - 1) {
					nflg = false;
				} else {
					n++;
				}
			}
		}

		return Al;
	}
}
