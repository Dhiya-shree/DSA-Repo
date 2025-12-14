package hashing_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import arrayCode.ArrayPart01;

/**
 * 
 * Problem #1 : Longest sub array with given sum
 * we are presented with an array of integers,
 * and our objective is to find if the longest subarray with given sum that
 * exists in the array
 * 
 * Problem #2 : Longest sub array with equal 1 and zero
 *
 * we are presented with a binary array (ie. containing only 0's and 1's) .Our
 * objective is to find if the longest subarray with equal number of 0's and 1's
 * that exists in the array. To accomplish this, we will explore two distinct
 * approaches: a Naive approach utilizing nested loops, and an Efficient
 * solution employing Hashing
 * 
 * @author shree
 * 
 *         Problem #3 : Count of Sub array with equal 0 and 1
 * 
 *         Given an array containing 0s and 1s. Find the number of subarrays
 *         having equal number of 0s and 1s.
 *         Sol :
 *         Make 0 as -1
 *         Make sum as 0
 *         Count when subarray == sum with prev sum
 * 
 *         Problem #4 :Longest common span with same sum in binary arrays
 * 
 *         two binary arrays (ie. containing only 0's and 1's) of equal size.
 *         Our objective is to find the longest common span with equal sum that
 *         exists in the arrays.
 *         To accomplish this, we will explore two distinct approaches: a Naive
 *         approach utilizing nested loops, and an Efficient solution employing
 *         Hashing
 * 
 *         Sol :
 * 
 *         1) Sub two array temp[]= arr - arr2
 *         if 1-1 = 0
 *         if 0-0 = 0
 *         if 1-0 =1
 *         if 0-1 = 1
 * 
 *         If the values are 1 in both array - no concern
 *         If values are 0 in both array same sum
 *         If values are 1 by arr1 ,
 *         It needs to be balanced by val -1 from arr2.
 * 
 *         2) Find the largest sub array with given sum with sum as zero
 *         If sum 0 , it has same 1 , same 0 , if not 1 from arr1 balanced by -1
 *         from arr2
 * 
 * 
 *         Problem #5 : Longest sub sequence
 *         \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ /// SUB SEQUENCE ----- NOT
 *         Sub array //////////////////////////\\\\\\\\\\\\\\\\......./
 *         Given an array of positive integers.
 *         Find the length of the longest sub-sequence such that elements in the
 *         subsequence are consecutive integers, the consecutive numbers can be
 *         in any order
 * 
 *         Sol : 1 4 5 3 6
 *         Have a countlarge count
 *         Loop 0 :
 *         For every element , add element in array Ele : 4
 *         count1=Loop1 ans
 *         count2=Loop2 ans
 *         count=count1+count2
 *         large count = max of large count and curr count
 * 
 *         Loop_Recurrencre 1
 *         Check for element - 1 , check ->3
 *         If present , Loop 1 for 3
 *         If not present , return 0
 * 
 *         Loop Recurrence 2
 *         Check for element - 1 , check ->3
 *         If present , Loop 2 for 5
 *         If not present , 0
 * 
 *         Sol shree: Wont work :)
 *         Find min in array
 *         Start with min
 *         Check for min+1
 *         If present count ++;
 *         If not set update large , set count as 0
 * 
 * 
 *         Efficient solution:
 *         This problem can be solved in O(n) time using an Efficient Solution.
 *         The idea is to use Hashing. We first insert all elements in a Set.
 *         Then check all the possible starts of consecutive subsequences.
 * 
 *         Algorithm:
 * 
 *         Create an empty hash.
 *         Insert all array elements to hash.
 *         Do following for every element arr[i]
 *         Check if this element is the starting point of a subsequence. To
 *         check this, simply look for arr[i] - 1 in the hash, if not found,
 *         then this is the first element a subsequence.
 *         If this element is the first element, then count the number of
 *         elements in the consecutive starting with this element. Iterate from
 *         arr[i] + 1 till the last element that can be found.
 *         If the count is more than the previous longest subsequence found,
 *         then update thi
 * 
 * 
 *
 */
public class Hashing09_sums_medium2 {

	public static void main(String[] args) {
		int arr3[] = { 16, 9, 19, 18, 16, 16, 13, 25, 24, 24, 7, 17, 22, 5, 21, 2, 23, 3, 22, 10, 5, 15, 0,
				20, 13, 7, 25, 12 };// sum 16// {10,2,-2,-20,-10}; sum -10
		int n3 = arr3.length;
		int ans = LongestSubArrayOfSum(arr3, n3, 48);
		System.out.println(" Large sub array with sum is  " + ans);

		int arr[] = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1 };
		int arr2[] = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1 };
		n3 = arr.length;
		ans = LongestSubArryawthEqual0anD1(arr, n3);
		System.out.println(" N3 " + n3);
		System.out.println(" Largest sub array value " + ans);

		// MAke all the 0 as 1 and set the sum as 0
		ans = LongestSubArryawthEqual0anD1GOG(arr, n3);
		System.out.println(" Largest sub array value.............................GoG  " + ans);

		// Count 0
		// Find len - 0 count
		// Pass the min of above value
		ans = LongestSubArryawthEqual0anD1Easy(arr2, n3);
		System.out.println(" Largest sub array value.............................EASY " + ans);

		ans = CountOfSubArraywithEqual0Or1(arr, n3);
		System.out.println(" Count of equal 0 and 1" + ans);

		int a[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1 };
		int b[] = { 0, 0, 0, 1, 1, 1, 1, 0, 1 };

		ans = LongestSubArrayWithSameValueSpan(a, a.length, b, b.length);
		System.out.println(" Longest common span with same sum in binary arrays is " + ans);

		ans = LongestConsecutiveSUBSEQUENCEWontWork(arr3, n3);
		System.out.println(" Longest conse sub sequence " + ans);

		ans = LongestConsecutiveSUBSEQUENCENoIdeaIfWillWORK(arr3, n3);
		System.out.println(" Longest conse sub sequence " + ans);

		ans = LongestonsSubSequenceGoG(arr3, n3);
		System.out.println(" Long sub sequence that woek " + ans);

		ans = findLongestConseqSubseq(arr3, n3);
		System.out.println(" Long sub sequence that woek GoG " + ans);

	}

	// Returns length of the longest
	// consecutive subsequence
	private static int findLongestConseqSubseq(int arr[], int n) {
		HashSet<Integer> S = new HashSet<Integer>();
		int ans = 0;

		// Hash all the array elements
		for (int i = 0; i < n; ++i)
			S.add(arr[i]);

		// check each possible sequence from the start
		// then update optimal length
		for (int i = 0; i < n; ++i) {
			// if current element is the starting
			// element of a sequence
			if (!S.contains(arr[i] - 1)) {
				// Then check for next elements
				// in the sequence
				int j = arr[i];
				while (S.contains(j))
					j++;

				// update optimal length if this
				// length is more
				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}
		return ans;
	}

	private static int LongestonsSubSequenceGoG(int[] arr, int n) {
		// Acctually working Long sub sequ

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		// Initiate instead of setting
		int count = 1;
		int lar = 0;

		int next = 0;
		int prev = 0;
		int pres = 0;

		for (int i = 0; i < n; i++) {

			pres = arr[i];
			prev = arr[i] - 1;
			next = arr[i] + 1;
			if (hm.containsKey(pres)) {
				continue;
			}
			while (hm.containsKey(next)) {
				count++;
				next++;
			}

			while (hm.containsKey(prev)) {
				count++;
				prev--;
			}

			hm.put(pres, count);
			if (lar < count) {
				lar = count;
				System.out.println(" Value of lar " + lar + " pos:" + i + " .. in between prev->pres->next " + prev
						+ "->" + pres + "->" + next);
			}
			count = 1;
		}

		return lar;
	}

	private static int LongestConsecutiveSUBSEQUENCENoIdeaIfWillWORK(int[] arr, int n) {
		// largest conse

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		// Initiate instead of setting
		int count = 1;
		int lar = 0;

		int next = 0;
		int prev = 0;
		int pres = 0;
		int freq = 0;
		int prev_freq = 0;
		int next_freq = 0;

		for (int i = 0; i < n; i++) {
			pres = arr[i];
			next = arr[i] + 1;
			prev = arr[i] - 1;

			if (hm.containsKey(prev)) {
				freq = hm.get(prev);
				count = count + freq;
				// hm.put(prev,)
			}
			if (hm.containsKey(next)) {
				freq = hm.get(next);
				count = count + freq;
				hm.put(next, count);

			}
			// count=count+1;
			// Initiate count as 1

			if (lar < count) {
				lar = count;
				System.out.println(" Value of lar " + lar + " pos:" + i + " .. in between prev->pres->next " + prev
						+ "->" + pres + "->" + next);

			}

			if ((!hm.containsKey(pres)) || (hm.containsKey(pres) && hm.get(pres) != count)) {

				hm.put(pres, count);
				// continue;
			}
			// else if(hm)
			// hm.put(arr[i],count);
			count = 1;

		}

		System.out.println("Un Modified array ");
		ArrayPart01.PrintRayy(arr);

		Arrays.sort(arr);
		System.out.println(" Modified array ");
		ArrayPart01.PrintRayy(arr);
		System.out.println(" Hashmap with consecutive is " + hm.toString());
		return lar;
	}

	private static int LongestConsecutiveSUBSEQUENCEWontWork(
			int[] arr, int n) {
		// sub sequence
		int min = 0;
		for (int i : arr) {
			min = Math.min(min, i);
		}

		HashSet<Integer> hs = new HashSet<>();
		int count = 0;
		int lar = 0;

		// if(min)
		// You can search for min+1 re
		// What about next element
		// if min is 1 and next min element is 1000
		// WIll you loop for 999 times checking for a element

		return 0;
	}

	private static int LongestSubArrayWithSameValueSpan(int[] a, int n, int[] b, int length2) {
		// temp creation\

		if (n != length2) {
			return -1;
		}
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = a[i] - b[i];
		}

		// Create hashmap
		HashMap<Integer, Integer> hm = new HashMap<>();

		int lar = Integer.MIN_VALUE;
		int larCurr = 0;
		int prev = 0;
		int sum = 0;
		int pos = 0;
		for (int i = 0; i < n; i++) {
			prev = arr[i] + prev;
			if (arr[i] == sum) {
				larCurr = 1;
			}
			if (prev == sum) {
				larCurr = i + 1;
			}

			if (hm.containsValue(prev)) {
				pos = hm.get(prev);
				larCurr = Math.max(larCurr, pos - i);
			}

			if (lar < larCurr) {
				lar = larCurr;
				// end=i;
			}

			hm.put(prev, i);
		}
		return lar;
	}

	private static int LongestSubArryawthEqual0anD1Easy(int[] arr, int n) {
		// Count 0
		// Find len - 0 count
		// Pass the min of above value

		System.out.println(" Val of n " + n);
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				count++;
			}
		}

		int len = n - count;
		System.out.println(" LEN " + len + " Count " + count);
		len = Math.min(count, len);
		return len;
	}

	private static int CountOfSubArraywithEqual0Or1(int[] arr, int n) {
		// Make all 0 as -1
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		// Call normal langest sub array of sum
		int sum = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int prev_sum = 0;
		int diff = 0;
		// To count no of subarray
		int count = 0;
		int freq = 0;
		for (int i = 0; i < n; i++) {
			// Find prev sum
			prev_sum = prev_sum + arr[i];
			// case

			diff = prev_sum - sum;

			if (prev_sum == sum || diff == 0) {
				count++;
				;
			}

			System.out.println(" Count " + count + " prev " + prev_sum + " diff " + diff);
			System.out.println(i + " Prev sum " + hm.toString());
			if (hm.containsKey(diff)) {
				freq = hm.get(diff);
				// System.out.println(" Diff is "+diff+ " with freq "+freq+"..count "+count);

				// hm.put(diff,freq+1);
				count = count + freq;
				System.out.println(" Diff is " + diff + " with freq " + freq + "..count " + count);
			}

			if (hm.containsKey(prev_sum)) {
				freq = hm.get(prev_sum);
				System.out.println(" prev sum is " + prev_sum + " with freq " + freq + "..count " + count);

				hm.put(prev_sum, freq + 1);
			} else {
				hm.put(prev_sum, 1);
			}

		}
		System.out.println(" Prev sum " + hm.toString());
		hm.clear();
		return count;

	}

	private static int LongestSubArryawthEqual0anD1GOG(int[] arr, int n) {
		// Make all 0 as -1
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		// Call normal langest sub array of sum
		int sum = 0;
		int large = LongestSubArrayOfSum(arr, n, sum);
		return large;
	}

	private static int LongestSubArryawthEqual0anD1(int[] arr, int n) {
		// Array to count 0 or 1
		ArrayList<Integer> zero = new ArrayList<>();
		ArrayList<Integer> ones = new ArrayList<>();
		// zero.add(-1);
		// ones.add(-1);
		System.out.println(zero.toString() + "......" + ones.toString());
		// Value to indicate curr pos value , prev value , count of 0/1
		int zpos = 0;
		int val = 0;
		int preval = 0;
		int opos = 0;
		int count = 0;
		// Lagre value
		int lar = 0;
		int larCurr = 0;
		int end = 0;
		int flg = 0;
		// As we cant have same keys lets have odd for 1 and even for zero
		for (int i = 0; i < n; i++) {
			val = arr[i];
			if (val == 0 && preval == 0) {
				if (zpos == 0 && zero.isEmpty()) {
					zero.add(1);
				}
				count = zero.get(zpos) + 1;
				zero.set(zpos, count);
			} else if (val == 1 && preval == 1) {
				if (opos == 0 && ones.isEmpty()) {
					ones.add(1);
				}
				count = ones.get(opos) + 1;
				ones.set(opos, count);
			} else {
				if (val == 0) {
					if (zpos == 0 && zero.isEmpty()) {
						zero.add(1);

					} else {
						zero.add(1);
						zpos++;
					}
					preval = 0;

				}

				if (val == 1) {
					if (opos == 0 && ones.isEmpty()) {
						ones.add(1);
					} else {
						ones.add(1);
						opos++;
						// ones.set(zpos,1);
					}
					preval = 1;

				}
			}
			System.out.println(" Zero " + zero.toString());
			System.out.println(" Ones " + ones.toString());

		}

		System.out.println(" Zero " + zero.toString());
		System.out.println(" Ones " + ones.toString());
		// int len=Math.
		// for(int i=)
		return 0;
	}

	private static int LongestSubArrayOfSum(int[] arr, int n, int sum) {
		// Create hashset
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int prev_sum = 0;
		int diff = 0;
		int lar = Integer.MIN_VALUE;
		int larCurr = 0;
		// int start=0;
		int end = 0;
		// To store the pos of prev sum
		int pos = 0;
		for (int i = 0; i < n; i++) {
			// Find prev sum
			prev_sum = prev_sum + arr[i];
			// case

			diff = prev_sum - sum;

			if (prev_sum == sum || diff == 0) {
				larCurr = 0;
			}

			// System.out.println(" Count "+count+" prev "+prev_sum+" diff "+diff);
			// System.out.println(i+" Prev sum "+hm.toString());
			if (hm.containsKey(diff)) {
				pos = hm.get(diff);
				// end=i;
				// start=pos;
				larCurr = Math.max((i - pos), larCurr);
				System.out.println("Start " + diff + " end " + arr[i] + " ..Value" + larCurr);
			}

			if (larCurr > lar) {
				lar = larCurr;
				// start=pos;
				end = i;
				System.out.println(" Large array of sum....................... " + sum);
				for (int abc = end - lar + 1; abc <= end; abc++) {
					System.out.print(arr[abc] + "(" + abc + ")" + "-->");
				}
				System.out.print("Val " + sum);
			}
			System.out.println();
			if (hm.containsKey(prev_sum)) {
				pos = hm.get(prev_sum);
				System.out.println(" prev sum is " + prev_sum + " with freq " + pos + "no change  ");

				// hm.put(prev_sum,freq+1);
			} else {
				hm.put(prev_sum, i);
			}

		}
		System.out.println(" Prev sum " + hm.toString());
		System.out.println(" Large array of sum " + sum);
		for (int i = end - lar + 1; i < end + 1; i++) {
			System.out.print(arr[i] + " ");
		}
		return lar;
	}

}

/**
 * Given an array of integers, find the length of the longest sub-sequence such
 * that elements in the subsequence are consecutive integers, the consecutive
 * numbers can be in any order.
 * 
 * Examples:
 * 
 * Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
 * Output: 4
 * Explanation:
 * The subsequence 1, 3, 4, 2 is the longest
 * subsequence of consecutive elements
 * 
 * Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
 * Output: 5
 * Explanation:
 * The subsequence 36, 35, 33, 34, 32 is the longest
 * subsequence of consecutive elements.
 * 
 * 
 * Naive Approach: The idea is to first sort the array and find the longest
 * subarray with consecutive elements.
 * After sorting the array and removing the multiple occurrences of elements,
 * run a loop and keep a count and max (both initially zero). Run a loop from
 * start to end and if the current element is not equal to the previous
 * (element+1) then set the count to 1 else increase the count. Update max with
 * a maximum of count and max.
 * 
 * 
 * 
 * // C++ program to find longest
 * // contiguous subsequence
 * #include <bits/stdc++.h>
 * using namespace std;
 * 
 * // Returns length of the longest
 * // contiguous subsequence
 * int findLongestConseqSubseq(int arr[], int n)
 * {
 * int ans = 0, count = 0;
 * 
 * // sort the array
 * sort(arr, arr + n);
 * 
 * vector<int> v;
 * v.push_back(arr[0]);
 * 
 * //insert repeated elements only once in the vector
 * for (int i = 1; i < n; i++)
 * {
 * if (arr[i] != arr[i - 1])
 * v.push_back(arr[i]);
 * }
 * // find the maximum length
 * // by traversing the array
 * for (int i = 0; i < v.size(); i++)
 * {
 * 
 * // Check if the current element is equal
 * // to previous element +1
 * if (i > 0 && v[i] == v[i - 1] + 1)
 * count++;
 * // reset the count
 * else
 * count = 1;
 * 
 * // update the maximum
 * ans = max(ans, count);
 * }
 * return ans;
 * }
 * 
 * // Driver code
 * int main()
 * {
 * int arr[] = { 1, 2, 2, 3 };
 * int n = sizeof arr / sizeof arr[0];
 * cout << "Length of the Longest contiguous subsequence "
 * "is "
 * << findLongestConseqSubseq(arr, n);
 * return 0;
 * }
 * 
 * 
 * 
 * 
 * Output
 * Length of the Longest contiguous subsequence is 3
 * Complexity Analysis:
 * 
 * Time complexity: O(nLogn).
 * Time to sort the array is O(nlogn).
 * Auxiliary space : O(1).
 * As no extra space is needed.
 * Efficient solution:
 * This problem can be solved in O(n) time using an Efficient Solution. The idea
 * is to use Hashing. We first insert all elements in a Set. Then check all the
 * possible starts of consecutive subsequences.
 * 
 * Algorithm:
 * 
 * Create an empty hash.
 * Insert all array elements to hash.
 * Do following for every element arr[i]
 * Check if this element is the starting point of a subsequence. To check this,
 * simply look for arr[i] - 1 in the hash, if not found, then this is the first
 * element a subsequence.
 * If this element is the first element, then count the number of elements in
 * the consecutive starting with this element. Iterate from arr[i] + 1 till the
 * last element that can be found.
 * If the count is more than the previous longest subsequence found, then update
 * this.
 * Below image is a dry run of the above approach:
 * 
 * 
 * 
 * 
 * Below is the implementation of the above approach:
 * 
 * // C++ program to find longest
 * // contiguous subsequence
 * #include <bits/stdc++.h>
 * using namespace std;
 * 
 * // Returns length of the longest
 * // contiguous subsequence
 * int findLongestConseqSubseq(int arr[], int n)
 * {
 * unordered_set<int> S;
 * int ans = 0;
 * 
 * // Hash all the array elements
 * for (int i = 0; i < n; i++)
 * S.insert(arr[i]);
 * 
 * // check each possible sequence from
 * // the start then update optimal length
 * for (int i = 0; i < n; i++)
 * {
 * // if current element is the starting
 * // element of a sequence
 * if (S.find(arr[i] - 1) == S.end())
 * {
 * // Then check for next elements
 * // in the sequence
 * int j = arr[i];
 * while (S.find(j) != S.end())
 * j++;
 * 
 * // update optimal length if
 * // this length is more
 * ans = max(ans, j - arr[i]);
 * }
 * }
 * return ans;
 * }
 * 
 * // Driver code
 * int main()
 * {
 * int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
 * int n = sizeof arr / sizeof arr[0];
 * cout << "Length of the Longest contiguous subsequence "
 * "is "
 * << findLongestConseqSubseq(arr, n);
 * return 0;
 * }
 * 
 * 
 * 
 * 
 * Output
 * Length of the Longest contiguous subsequence is 4
 * 
 * 
 * Complexity Analysis:
 * 
 * Time complexity: O(n).
 * Only one traversal is needed and the time complexity is O(n) under the
 * assumption that hash insert and search take O(1) time.
 * Auxiliary space: O(n).
 * To store every element in hashmap O(n) space is needed
 * Another Solution:
 * 
 * This problem can be solved in O(N log N) time with another Method, this time
 * the Idea is to use Priority Queue.
 * 
 * Algorithm:
 * 
 * Create a Priority Queue to store the element
 * Store the first element in a variable
 * Remove it from the Priority Queue
 * Check the difference between this removed first element and the new peek
 * element
 * If the difference is equal to 1 increase count by 1 and repeats step 2 and
 * step 3
 * If the difference is greater than 1 set counter to 1 and repeat step 2 and
 * step 3
 * if the difference is equal to 0 repeat step 2 and 3
 * if counter greater than the previous maximum then store counter to maximum
 * Continue step 4 to 7 until we reach the end of the Priority Queue
 * Return the maximum value
 * 
 * // Java Program to find longest consecutive
 * // subsequence This Program uses Priority Queue
 * import java.io.*;
 * import java.util.PriorityQueue;
 * public class Longset_Sub
 * {
 * // return the length of the longest
 * // subsequence of consecutive integers
 * static int findLongestConseqSubseq(int arr[], int N)
 * {
 * 
 * PriorityQueue<Integer> pq
 * = new PriorityQueue<Integer>();
 * for (int i = 0; i < N; i++)
 * {
 * // adding element from
 * // array to PriorityQueue
 * pq.add(arr[i]);
 * }
 * 
 * // Storing the first element
 * // of the Priority Queue
 * // This first element is also
 * // the smallest element
 * int prev = pq.poll();
 * 
 * // Taking a counter variable with value 1
 * int c = 1;
 * 
 * // Storing value of max as 1
 * // as there will always be
 * // one element
 * int max = 1;
 * 
 * for (int i = 1; i < N; i++)
 * {
 * // check if current peek
 * // element minus previous
 * // element is greater then
 * // 1 This is done because
 * // if it's greater than 1
 * // then the sequence
 * // doesn't start or is broken here
 * if (pq.peek() - prev > 1)
 * {
 * // Store the value of counter to 1
 * // As new sequence may begin
 * c = 1;
 * 
 * // Update the previous position with the
 * // current peek And remove it
 * prev = pq.poll();
 * }
 * 
 * // Check if the previous
 * // element and peek are same
 * else if (pq.peek() - prev == 0)
 * {
 * // Update the previous position with the
 * // current peek And remove it
 * prev = pq.poll();
 * }
 * // if the difference
 * // between previous element and peek is 1
 * else
 * {
 * // Update the counter
 * // These are consecutive elements
 * c++;
 * 
 * // Update the previous position
 * // with the current peek And remove it
 * prev = pq.poll();
 * }
 * 
 * // Check if current longest
 * // subsequence is the greatest
 * if (max < c)
 * {
 * // Store the current subsequence count as
 * // max
 * max = c;
 * }
 * }
 * 
 * return max;
 * }
 * 
 * // Driver Code
 * public static void main(String args[])
 * throws IOException
 * {
 * int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
 * int n = arr.length;
 * System.out.println(
 * "Length of the Longest consecutive subsequence is "
 * + findLongestConseqSubseq(arr, n));
 * }
 * }
 * // This code is contributed by Sudipa Sarkar
 * 
 * Output
 * Length of the Longest consecutive subsequence is 4
 * 
 * 
 */
