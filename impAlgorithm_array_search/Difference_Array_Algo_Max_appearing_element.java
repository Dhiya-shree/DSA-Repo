package impAlgorithm_array_search;

/**
 * Maximum Appearing Element !!! Our Task: Given two arrays L[ ] and R[ ] of
 * size N where L[i] and R[i] (0 ? L[i], R[i] < 106) denotes a range of numbers,
 * the task is to find the maximum occurred integer in all the ranges. If more
 * than one such integer exists, print the smallest one.
 * 
 * 
 * Follow the below steps to Implement the idea: Initialize a Hash array arr[]
 * to store the occurrence of every element in all the ranges combined. Iterate
 * over all the N ranges and increment L[i] by one and decrement R[i] by one.
 * Run a Loop from 1 to the maximum end value of all the ranges and take the
 * Prefix sum.
 * 
 * --------------------------------------------------------------------------------------------
 * 1) Naive Approach: The idea is to: Traverse through all the ranges. Then for
 * every range, count frequencies, make a hash table (array) to store every
 * item. Then traverse through other ranges and increment the frequency of every
 * item. The item with the highest frequency is our answer. Time Complexity:
 * O(N*M). Here N is the number of ranges and M is the maximum number of
 * elements in any of the ranges. Auxiliary Space: O(M). For Hash table.
 * 
 * 2) Efficient Approach: Below is the idea to solve the problem: The idea is to
 * use the Difference array technique. Create a vector initialized with value
 * zero. Iterate through every range and mark the presence of the beginning of
 * every range by incrementing the start of the range with one i.e. arr[L[i]]++
 * and mark the end of the range by decrementing at index one greater than the
 * end of range by one i.e. arr[R[i]+1]–. Now when computing the prefix sum,
 * Since the beginning is marked with one, all the values after beginning will
 * be incremented by one. Now as increment is only targeted only till the end of
 * the range, the decrement on index R[i]+1 prevents that for every range i.
 * Time Complexity: O(N + MAX) Auxiliary space: O(MAX)
 * 
 * Maximum occurred integer in n ranges using Difference array technique. Below
 * is the idea to solve the problem: The idea is to use the Difference array
 * technique. Create a vector initialized with value zero. Iterate through every
 * range and mark the presence of the beginning of every range by incrementing
 * the start of the range with one i.e. arr[L[i]]++ and mark the end of the
 * range by decrementing at index one greater than the end of range by one i.e.
 * arr[R[i]+1]–. Now when computing the prefix sum, Since the beginning is
 * marked with one, all the values after beginning will be incremented by one.
 * Now as increment is only targeted only till the end of the range, the
 * decrement on index R[i]+1 prevents that for every range i.
 * 
 * 
 * Illustration: L[] = {1, 2, 3} , R[] = {3, 5 , 7} 1. For beginning of range
 * arr[L[i]]++ the array becomes {0,1,1,1,0,0,0,0,……} 2. For end of range
 * arr[R[i]+1]– the array becomes {0,1,1,1,-1, 0, -1, 0,-1,……} 3. After prefix
 * sum the array becomes {0,1,2,3,2,2,1,1,0…} Do prefix sum, the sum of elements
 * after (1) is incremented by one because beginning was marked. Now elements
 * after (3) must not be incremented so if there’s a range one, two, three, the
 * values from one, two, three should only be incremented by one or their
 * frequency should be incremented by one. That is why decreasing the value of
 * arr[R[i]+1] is needed so that elements after the end of this range have minus
 * one subtracted to values. That is how to nullify the impact of incrementing
 * the value when prefix will be taken. So when taking the prefix, simply
 * decrement every value after the range ends, since I want to increment
 * elements only in the range. That’s the idea of this algorithm.
 * 
 * @author shree
 *
 */
public class Difference_Array_Algo_Max_appearing_element {

	public static void main(String[] args) {
		/////////////////////////////////////////////////////////////////////////////////////////////

		int left[] = { 1, 2, 5, 15 };
		int right[] = { 5, 8, 7, 18 };
		int ans1 = MaximumAppearingElement(left, right);
		System.out.println(" Maximum apperared element is " + ans1);
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		int[] L = { 1, 4, 9, 13, 21 };
		int[] R = { 15, 8, 12, 20, 30 };
		int n = L.length;
		System.out.println(maximumOccurredElement(L, R, n));

	}

	private static int MaximumAppearingElement(int[] left, int[] right) {
		int max = 0;
		// int l_len=left.length;
		int rlen = right.length;
		for (int i = 0; i < rlen; i++) {
			max = Math.max(max, right[i]);
		}
		////////////////////////////////////////////////////////////////////////////////////////
		// IF MAX IS GIVEN USE THAT
		///////////////////////////////////////////////// REDUCE COMPLEXITY BY O N
		System.out.println(" max is " + max);
		int arr[] = new int[max + 2];
		for (int i = 0; i < rlen; i++) {
			arr[left[i]] = 1;
			arr[right[i] + 1] = -1;
		}
		int curr = 0;
		int mcurr = 0;
		int ans = 0;
		for (int i = 0; i < max; i++) {
			curr = curr + arr[i];
			if (mcurr < curr) {
				mcurr = curr;
				ans = i;
			}
		}

		////////////////////////////// Frequency array

		for (int i = 1; i <= max; i++) {
			arr[i] = arr[i - 1] + arr[i];
			System.out.println(i + " at os " + " Arr " + arr[i]);
		}
		return ans;
	}
	
	
	////////////////// GOG 
	
	static int MAX = 1000000;

	// Return the maximum occurred element in all ranges.
	static int maximumOccurredElement(int[] L, int[] R,
									int n)
	{
		// Initialising all element of array to 0.
		int[] arr = new int[MAX];

		// Adding +1 at Li index and
		// subtracting 1 at Ri index.
		int maxi = -1;
		for (int i = 0; i < n; i++) {
			arr[L[i]] += 1;
			arr[R[i] + 1] -= 1;
			if (R[i] > maxi) {
				maxi = R[i];
			}
		}

		// Finding prefix sum and index
		// having maximum prefix sum.
		int msum = arr[0];
		int ind = 0;
		for (int i = 1; i < maxi + 1; i++) {
			arr[i] += arr[i - 1];
			if (msum < arr[i]) {
				msum = arr[i];
				ind = i;
			}
		}

		return ind;
	}
}
