package hashing_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * Problem #1 : Count distinct element in every window
 * Given an array of size n and an integer k, return the count of distinct
 * numbers in all windows of size k.
 * 
 * Problem #2: Numbers containing 1, 2 and 3
 * 
 * Given an array arr[] of n numbers. The task is to print only those numbers
 * whose digits are from set {1,2,3}.
 * 
 * Problem #3 : Wnner of an electin
 * 
 * Given an array of names (consisting of lowercase characters) of candidates in
 * an election.
 * A candidate name in array represents a vote casted to the candidate.
 * Print the name of candidate that received Max votes. If there is tie, print
 * lexicographically smaller name.
 * 
 * 
 * Problem #4 : More than n/k occurring elements
 * we are presented with an array of integers of size n and a number k. Our
 * objective is to find the elements occuring more than n/k times in the array.
 * To accomplish this,
 * we will explore two distinct approaches: a Naive approach utilizing nested
 * loops, and an Efficient solution employing Hashing .
 * 
 * 
 * Sol :
 * 1 ) Time n2 -> Use two loop to find freq
 * 2 ) Time n Log n -> Sort the array and tranverse once to find frequency \
 * 3) If space okay
 * O n - using hashMap
 * 
 * 
 * Problem #5 : Moore Voting algo to find more than n/K occuring elements
 * 
 * By theory , K-1< N
 * As :
 * if all elements are K size
 * K *( N/ k+1)<= N
 * Number of n/k occuring elements will not be more than K-1
 * So we have ADVANTAGE to initialize the hashmap to length o K-1
 * 
 * 
 * Moore Voting algo for >n/2 occuring :
 * if same element present count++
 * If diff element present count-- ,
 * If count<1
 * make curr element as max
 * 
 * Moore Voting algo for > n/k occurence
 * 
 * 1) Initiate HM for size K-1
 * 2) Loop from 0 to n as i :
 * if( element already present in HM ):
 * freq ++
 * else if ( hm.size < K-1 )
 * put -> arr[i],1
 * else : -> Time possibly - n*k
 * for all elements in hm :
 * decrease the freq by 1
 * if freq=0 --> remove the element
 * < We will get the possible values that can have >n/k occurence ,... need to
 * check them >
 * 
 * 3) For all the elements in HM , - Time n*k
 * Check the freq by traversing through Arr array
 * if freq> n/k
 * -> Found the element , continue for next ....
 * 
 * Time complexity - N*K \
 * 
 * 1,1,1,1, n=4 k = 1 , n/k - 4 ; For any ele to be there more than 4 times in 4
 * set is Im possible
 * 2,2,2,2
 * 3,3
 * K= 4 ; N=10 ; N/K -> 10/4 - 2.5/ 3
 * 
 * 
 * @author shree
 *
 */
public class Hashing10_sums_medium3 {

	public static void main(String[] args) {
		// med 3

		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;

		ArrayList<Integer> ans = CountOfDistinctInWindow(arr, arr.length, k);
		System.out.println(" Ans " + ans.toString());

		countDistinctGoG(arr, k);

		printDistinct(arr, arr.length, k);

		int arr2[] = { 1, 2, 3, 11, 22, 33, 123, 4, 5, 6, 7, 8, 9, 10 };
		int n2 = arr2.length;

		int ans2 = NoOfNumbersConatining123(arr2, n2);
		System.out.println(" Number is " + ans2);

		CreateAHashMapWithNumberof123();

		String Votes[] = { "john", "johnny", "jackie", "johnny", "john",
				"jackie", "jamie", "jamie", "john", "johnny", "jamie",
				"johnny", "john" };
		String[] ans3 = WinnerOfElection(Votes, Votes.length);
		System.out.println(" Winner is " + ans3[0] + " with vote " + ans3[1]);

		int arr4[] = { 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8,
				8, 8, 8, 8, 8, 8, 8, 8 };
		int n4 = arr4.length;
		int k4 = 6;
		int ans4 = FindNumberOfMoreThanNbyKoccurence(arr4, n4, k4);
		System.out.println("LESS efficient n/k occurence is " + ans4);

		ans4 = MooreVotingNbyKoccurence(arr4, n4, k4);
		System.out.println(" Moore efficient n/k occurence is " + ans4);

	}

	private static int MooreVotingNbyKoccurence(int[] arr, int n, int k) {
		// Moore voting
		HashMap<Integer, Integer> hm = new HashMap<>(k - 1);

		int decre = 0;
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			} else if (hm.size() < k - 1) {
				hm.put(arr[i], 1);
			} else {
				// Decrement all freq y 1 and remove anything with freq 0
				// if you try to modify while processing it wont work
				// Below cause Concurrent Modification exception
				/**
				 * for(Map.Entry<Integer,Integer> map: hm.entrySet()) {
				 * decre=map.getValue()-1;
				 * hm.put(map.getKey(),decre);
				 * }
				 * for(Map.Entry<Integer,Integer> map: hm.entrySet()) {
				 * if(map.getValue()==0) {
				 * hm.remove(map.getKey(),map.getValue());
				 * }
				 * }
				 */

				// Use iterator to avoid above error

				// getting entrySet() into Set
				Iterator<Entry<Integer, Integer>> itr = hm.entrySet().iterator();
				// Creating an iterator object
				// to iterate over the ArrayList

				// Condition check
				// it holds true till there is single element
				// remaining in the List
				while (itr.hasNext()) {
					Entry<Integer, Integer> e = itr.next();
					decre = e.getValue() - 1;
					if (decre == 0) {
						itr.remove();
						// hm.remove(e.getKey(),e.getValue());
					} else {
						hm.put(e.getKey(), decre);
					}
				}

			}

		}

		System.out.println(" HM is " + hm.toString());
		// We got all the needed values
		// Now check

		int val = 0;
		int count = 0;
		int check = n / k;
		ArrayList<Integer> ans = new ArrayList<>();
		for (Map.Entry<Integer, Integer> map : hm.entrySet()) {
			val = map.getKey();
			for (int j = 0; j < n; j++) {
				if (arr[j] == val) {
					count++;
				}
			}

			if (count > check) {
				ans.add(val);
			}
		}
		System.out.println("Ans array " + ans.toString());
		return ans.size();

	}

	private static int FindNumberOfMoreThanNbyKoccurence(int[] arr, int n, int k) {
		// Have an array of more than n/k occur
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			} else {
				hm.put(arr[i], 1);
			}
		}

		int val = n / k;
		System.out.println(" Hm is " + hm);
		System.out.println(" Val is " + val);
		for (Map.Entry<Integer, Integer> map : hm.entrySet()) {
			if (map.getValue() > val) {
				ans.add(map.getKey());
			}
		}
		System.out.println(" HIgh ocuring " + ans.toString());
		return ans.size();
	}

	private static String[] WinnerOfElection(String[] arr, int n) {

		String ans[] = new String[2];
		HashMap<String, Integer> hm = new HashMap<>();
		// Update the name and the votes
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			} else {
				hm.put(arr[i], 1);
			}
		}

		System.out.println(" HM is " + hm.toString());
		LinkedList<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
		// Sort based on the votes
		Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

		System.out.println(" List is " + list);
		// Puting sorted linked list to HM
		int curr = 0;
		hm.clear();
		for (Map.Entry<String, Integer> mape : list) {
			if (mape.getValue() >= curr) {
				curr = mape.getValue();
			} else {
				break;
			}
			System.out.println(" Curr is " + curr);
			hm.put(mape.getKey(), mape.getValue());
		}
		System.out.println(" HM after " + hm.toString());
		// Map<String, Integer> ans=hm.entrySet();
		curr = Integer.MAX_VALUE;
		String val[] = new String[hm.size()];// int strLen=0;
		int a = 0;
		for (String str : hm.keySet()) {
			val[a] = str;
			a++;
		}
		sortLexicographically(val);
		Arrays.sort(val,
				String.CASE_INSENSITIVE_ORDER);
		ans[0] = val[0];
		ans[1] = String.valueOf(hm.get(val[0]));
		return ans;
	}

	// this method sort the string array lexicographically.
	public static void sortLexicographically(String strArr[]) {
		for (int i = 0; i < strArr.length; i++) {
			for (int j = i + 1; j < strArr.length; j++) {
				if (strArr[i].compareToIgnoreCase(strArr[j]) > 0) {
					String temp = strArr[i];
					strArr[i] = strArr[j];
					strArr[j] = temp;
				}
			}
		}
	}

	private static void CreateAHashMapWithNumberof123() {
		// FRom 1,2,3,11......100000000 we have t save
		mp.put(1, 1);
		mp.put(2, 1);
		mp.put(3, 1);
		int num = 0;
		int digit = 0;
		boolean flag = true;
		for (int i = 11; i < 1000000; i++) {
			num = i;
			while (num > 0) {
				digit = num % 10;
				num = num / 10;
				if (!(digit < 4 && digit > 0)) {
					flag = false;
				}

			}
			if (flag) {
				mp.put(i, 1);
			}
			flag = true;
		}

	}

	static HashMap<Integer, Integer> mp = new HashMap<>();

	private static int NoOfNumbersConatining123(int[] arr, int n) {
		// give count of numbers having 1 / 2 / 3
		// Hashset for storing numbers that have unique
		int num = 0;
		int digit = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 4 && arr[i] > 0) {
				mp.put(arr[i], i);
				continue;
			}

			// System.out.println(" Val "+);
			num = arr[i];
			while (num > 0) {
				digit = num % 10;
				num = num / 10;
				if (digit < 4 && digit > 0) {
					mp.put(arr[i], i);
					System.out.println(" Arr [i " + arr[i] + "....digit " + digit);
					continue;
				}
			}

		}
		System.out.println(" Hashmap is " + mp.toString());
		return mp.size();
	}

	private static ArrayList<Integer> CountOfDistinctInWindow(int[] arr, int n, int k) {
		// Count of distinct using hashing
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;
		// int len=0;
		int start = 0;
		int i = 0;
		while (i < n && start < n) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			} else {
				hm.put(arr[i], 1);
			}
			System.out.println(" I is " + i + " arr i " + arr[i] + hm.toString());
			i++;
			// count=hm.size();
			count++;
			if (count == k) {
				System.out.println(" HM at 4 " + hm.toString());
				ans.add(hm.size());

				hm.put(arr[start], hm.get(arr[start]) - 1);

				if (hm.get(arr[start]) == 0) {
					hm.remove(arr[start], 0);
				}

				start++;
				count--;
			}

		}

		return ans;
	}

	private static void countDistinctGoG(int arr[], int k) {
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		// Traverse the first window and store count
		// of every element in hash map
		for (int i = 0; i < k; i++)
			hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);

		// Print count of first window
		System.out.println(hM.size());

		// Traverse through the remaining array
		for (int i = k; i < arr.length; i++) {

			// Remove first element of previous window
			// If there was only one occurrence
			if (hM.get(arr[i - k]) == 1) {
				hM.remove(arr[i - k]);
			}

			else // reduce count of the removed element
				hM.put(arr[i - k], hM.get(arr[i - k]) - 1);

			// Add new element of current window
			// If this element appears first time,
			// set its count as 1,
			hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);

			// Print count of current window
			System.out.println(hM.size());
		}
		return;
	}

	private static void printDistinct(int arr[], int n, int k) {
		HashMap<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < k; i++) {
			m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
		}

		System.out.print(m.size() + " ");

		for (int i = k; i < n; i++) {

			m.put(arr[i - k], m.get(arr[i - k]) - 1);

			if (m.get(arr[i - k]) == 0) {
				m.remove(arr[i - k]);
			}
			m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);

			System.out.print(m.size() + " ");
		}
	}

}

/**
 * 
 * Count Distinct Elements In Every Window
 * 
 * Given an array of size n and an integer k, return the count of distinct
 * numbers in all windows of size k.
 * 
 * Example:
 * 
 * Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
 * k = 4
 * Output: 3 4 4 3
 * 
 * Explanation:
 * First window is {1, 2, 1, 3}, count of distinct numbers is 3
 * Second window is {2, 1, 3, 4} count of distinct numbers is 4
 * Third window is {1, 3, 4, 2} count of distinct numbers is 4
 * Fourth window is {3, 4, 2, 3} count of distinct numbers is 3
 * 
 * Input: arr[] = {1, 2, 4, 4};
 * k = 2
 * Output: 2 2 1
 * 
 * Explanation:
 * First window is {1, 2}, count of distinct numbers is 2
 * First window is {2, 4}, count of distinct numbers is 2
 * First window is {4, 4}, count of distinct numbers is 1
 * 
 * 
 * Naive Approach: The naive solution is to traverse the given array considering
 * every window in it and keeping a count on the distinct elements of the
 * window.
 * 
 * Algorithm:
 * 
 * For every index i from 0 to len_array(n) - k, i.e n - k, traverse the array
 * from i to i + k. This is the window
 * Traverse the window, from i to that index and check if the element is present
 * or not.
 * If the element is not present in the prefix of the array, i.e no duplicate
 * element is present from i to index-1, then increase the count.
 * Print the count.
 * Below is the implementation of the above approach:
 * 
 * 
 * 
 * // Simple C++ program to count distinct
 * // elements in every window of size k
 * #include <bits/stdc++.h>
 * using namespace std;
 * 
 * // Counts distinct elements in window of size k
 * int countWindowDistinct(int win[], int k)
 * {
 * int dist_count = 0;
 * 
 * // Traverse the window
 * for (int i = 0; i < k; i++) {
 * // Check if element arr[i] exists in arr[0..i-1]
 * int j;
 * for (j = 0; j < i; j++)
 * if (win[i] == win[j])
 * break;
 * if (j == i)
 * dist_count++;
 * }
 * return dist_count;
 * }
 * 
 * // Counts distinct elements in all windows of size k
 * void countDistinct(int arr[], int n, int k)
 * {
 * // Traverse through every window
 * for (int i = 0; i <= n - k; i++)
 * cout << countWindowDistinct(arr + i, k) << endl;
 * }
 * 
 * // Driver program
 * int main()
 * {
 * int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4;
 * int n = sizeof(arr) / sizeof(arr[0]);
 * countDistinct(arr, n, k);
 * return 0;
 * }
 * 
 * 
 * 
 * 
 * Output
 * 3
 * 4
 * 4
 * 3
 * 
 * Complexity Analysis:
 * 
 * Time complexity: O(nk2).
 * The time complexity can be improved to O(n*k*log k) by modifying
 * countWindowDistinct() by the use of sorting. The function can further be
 * optimized to use hashing to find distinct elements in a window. With hashing
 * the time complexity becomes O(n*k).
 * Space Complexity: O(1) No extra space is needed.
 * 
 * Efficient Approach: So, there is an efficient solution using hashing, though
 * hashing requires extra O(n) space but the time complexity will improve. The
 * trick is to use the count of the previous window while sliding the window. To
 * do this a hash map can be used that stores elements of the current window.
 * The hash-map is also operated on by simultaneous addition and removal of an
 * element while keeping track of distinct elements. The problem deals with
 * finding the count of distinct elements in a window of length k, at any step
 * while shifting the window and discarding all the computation done in the
 * previous step, even though k - 1 elements are same from the previous adjacent
 * window. For example, assume that elements from index i to i + k - 1 are
 * stored in a Hash Map as an element-frequency pair. So, while updating the
 * Hash Map in range i + 1 to i + k, reduce the frequency of the i-th element by
 * 1 and increase the frequency of (i + k)-th element by 1.
 * Insertion and deletion from the HashMap takes constant time.
 * 
 * Algorithm:
 * Create an empty hash map. Let the hash map be hM.
 * Initialize the count of distinct elements as dist_count to 0.
 * Traverse through the first window and insert elements of the first window to
 * hM. The elements are used as key and their counts as the value in hM. Also,
 * keep updating dist_count
 * Print distinct count for the first window.
 * Traverse through the remaining array (or other windows).
 * Remove the first element of the previous window.
 * If the removed element appeared only once, remove it from hM and decrease the
 * distinct count, i.e. do "dist_count--"
 * else (appeared multiple times in hM), then decrement its count in hM
 * Add the current element (last element of the new window)
 * If the added element is not present in hM, add it to hM and increase the
 * distinct count, i.e. do "dist_count++"
 * Else (the added element appeared multiple times), increment its count in hM
 * Below is a dry run of the above approach:
 * 
 * 
 * Implementation:
 * 
 * 
 * // An efficient C++ program to
 * // count distinct elements in
 * // every window of size k
 * #include <iostream>
 * #include <unordered_map>
 * using namespace std;
 * 
 * void countDistinct(int arr[], int k, int n)
 * {
 * // Creates an empty hashmap hm
 * unordered_map<int, int> hm;
 * 
 * // initialize distinct element count for current window
 * int dist_count = 0;
 * 
 * // Traverse the first window and store count
 * // of every element in hash map
 * for (int i = 0; i < k; i++) {
 * if (hm[arr[i]] == 0) {
 * dist_count++;
 * }
 * hm[arr[i]] += 1;
 * }
 * 
 * // Print count of first window
 * cout << dist_count << endl;
 * 
 * // Traverse through the remaining array
 * for (int i = k; i < n; i++) {
 * // Remove first element of previous window
 * // If there was only one occurrence, then reduce distinct count.
 * if (hm[arr[i - k]] == 1) {
 * dist_count--;
 * }
 * // reduce count of the removed element
 * hm[arr[i - k]] -= 1;
 * 
 * // Add new element of current window
 * // If this element appears first time,
 * // increment distinct element count
 * 
 * if (hm[arr[i]] == 0) {
 * dist_count++;
 * }
 * hm[arr[i]] += 1;
 * 
 * // Print count of current window
 * cout << dist_count << endl;
 * }
 * }
 * 
 * int main()
 * {
 * int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
 * int size = sizeof(arr) / sizeof(arr[0]);
 * int k = 4;
 * countDistinct(arr, k, size);
 * 
 * return 0;
 * }
 * // This solution is contributed by Aditya Goel
 * 
 * 
 * 
 * 
 * Output
 * 3
 * 4
 * 4
 * 3
 * Complexity Analysis:
 * Time complexity O(n). A single traversal of the array is required.
 * Space Complexity O(n). Since the hashmap requires linear space
 * 
 * 
 */