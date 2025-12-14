package string_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Lexicographic Rank of a String
 * 
 * String = BAC
 * Permutations of A - B - C :
 * ABC
 * ACB
 * BAC
 * CAB
 * CBA
 * BCA
 * 
 * Permutation with Lexicographic rank
 * ABC 1
 * ACB 2
 * BAC 3
 * BCA 4
 * CAB 5
 * CBA 6
 * 
 * Rank of BAC = 3
 * 
 * 1) Count lexicographicaaly smaller string and add 1
 * 
 * Example : For "STRING"
 * 
 * For i =0: - - - - - - (No fixed )
 * Count the string smaller that S ={R,I,N,G}
 * possible smaller strings are
 * R - - - - - 5!
 * I - - - - - 5!
 * N - - - - - 5!
 * G - - - - - 5!
 * 
 * 4* 5! possible smaller string which dont have S in 0 place
 * 
 * For i=2: S - - - - - S fixed
 * Count the string smaller that T ={R,I,N,G}
 * possible smaller strings are
 * S R - - - - 4!
 * S I - - - - 4!
 * S N - - - - 4!
 * S G - - - - 4!
 * 
 * 4* 4! possible smaller string which dont have ST in 01 place
 * 
 * 
 * For i=3: S T - - - - ST fixed
 * Count the string smaller that R ={I,N,G}
 * possible smaller strings are
 * S T I - - - 3!
 * S T N - - - 3!
 * S T G - - - 3!
 * 
 * 3* 3! possible smaller string which dont have STR in 012 place
 *
 * For i=4: S T R - - - STR fixed
 * Count the string smaller that I ={G}
 * possible smaller strings are
 * S T R G - - 2!
 *
 * 1* 2! possible smaller string which dont have STRI in 0123 place
 *
 * For i=5: S T R I - - STRI fixed
 * Count the string smaller that N ={G}
 * possible smaller strings are 0
 *
 * S T R I G - 1!
 * 
 * 1*1! possible smaller than dont have STRIN
 *
 * Total possible lesser than STRING
 * =4*4! + 4*5! + 3*3! + 2! + 1
 * = 480 + 96 + 18 + 2 +1
 * ==> 597
 * 
 * Rank => 597+1= 598
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class String11_Lexicographic_RAnk_Medium {

	public static void main(String[] args) {
		// Lexicographic

		/*
		 * NAIVE SOLUTION
		 * 1) Find all permutation
		 * 2) Find Value for all
		 * 3) Find the Rank
		 * 
		 * For a String length n :
		 * Number of permutation = ! n
		 * 
		 * Check the permuation with given string
		 * If same , rank = no of permutation
		 * 
		 */

		String S = "tucmhpqzwrgeixkjnaslvyfdbo";
		int rank = 0;
		// rank=NaiveRank(S,S.length());
		System.out.println(" Value of rank " + rank);

		/**
		 * Efficient sol
		 * 
		 * 1) Count lexicographicaaly smaller string and add 1
		 */

		rank = EfficientRank(S, S.length());
		System.out.println(" Value of rank " + rank);

	}

	private static int EfficientRank(String s, int n) {

		int res = 0;// Final count

		int fact = FindFact(n - 1);
		// factorial needed - find by taking all values in account
		// go from 1 to n! , and for

		int count[] = new int[256];// CHAR array

		// String --> count array
		for (int i = 0; i < n; i++) {
			count[s.charAt(i)]++;
			// Array of values
		}
		System.out.println(" Count 1 " + Arrays.toString(count));

		// Count array is len 26 has 1 where we have string char
		// Make the count array to minimum array
		// For count=10 => miimum = sum of previous count 0 to 9
		int min = count[0];
		for (int i = 1; i < 256; i++) {
			count[i] = min + count[i];
			min = count[i];
		}

		System.out.println(" Count " + Arrays.toString(count));

		// Now count is cumulative array
		// For STRING For char T
		// Value at T-1 pos will give the number of smaller char
		char c;
		int val = 1;
		// fact=1;
		for (int i = 0; i < n - 1; i++) {
			c = s.charAt(i);
			System.out.println("ccccc  " + count[c - 1]);
			val = (count[c - 1]) * fact;
			System.out.println(" For char " + c + " val is ..." + val + " fact found.." + fact);
			fact = fact / (n - i - 1);
			res = res + val;

			// Decrease the count of values after the T

			for (int j = c; j < 256; j++) {
				count[j]--;
			}
		}
		return res + 1;

	}

	private static int FindFact(int n) {
		// fact
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

	private static int NaiveRank(String s, int length) {
		// Find permuation of sorted char array

		char[] str = s.toCharArray();
		Arrays.sort(str);

		String newS = s;
		System.out.println(" un Sorted string " + newS);
		s = String.valueOf(str);
		permute(0, s, newS);

		Collections.sort(str_arr);
		System.out.println(" Sorted " + str_arr);

		for (int i = 0; i < str_arr.size(); i++) {
			if (newS.equals(str_arr.get(i))) {
				return i + 1;
			}
		}
		return -1;
	}

	// Count of total permutations
	static int total = 0;
	static ArrayList<String> str_arr = new ArrayList<>(10);

	static void permute(int i, String s, String newS) {

		// Base case
		if (i == (s.length() - 1)) {
			System.out.print(s + "\n");
			total++;
			str_arr.add(s);
			return;
		}

		char prev = '*';

		// Loop from j = 1 to length of String
		for (int j = i; j < s.length(); j++) {
			char[] temp = s.toCharArray();
			if (j > i && temp[i] == temp[j])
				continue;
			if (prev != '*' && prev == s.charAt(j)) {
				continue;
			}

			// Swap the elements
			temp = swap(temp, i, j);
			prev = s.charAt(j);

			// Recursion call
			permute(i + 1, String.valueOf(temp), newS);
		}

	}

	static char[] swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

}
