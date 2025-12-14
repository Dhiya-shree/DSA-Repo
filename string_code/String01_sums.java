package string_code;

import java.util.Arrays;

/**
 * Problem #1 : Binary string 
 * Given a binary string S. The t
 * ask is to count the number of substrings that start and end with 1.
 * For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
 *  No of 1   Substring 
 *  1         0
 *  2         1
 *  3         3
 *  4         6 
 *  5         10
 *  
 *  Problem #2: Implement strstr
 *  Your task is to implement the function strstr.
 *   The function takes two strings as arguments (s,x) and  locates the occurrence of the string x in the string s.
 *   The function returns an integer denoting the first occurrence of the string x in s (0 based indexing).
 *  Note: You are not allowed to use inbuilt function.
 *  
 *  
 * Problem #3 : Palindrome 
 * Naive : REverse and check 
 * Efficient : two pointer 
 * 
 * Problem #4: Check if strings are rotaion of each other or not 
 * You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.
 * 
 * Problem #5 : Isomorphic strings
 * Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
 * If the characters in str1 can be changed to get str2, then two strings, str1 and str2, are isomorphic.
 *  A character must be completely swapped out for another character while maintaining the order of the characters. 
 *  A character may map to itself, but no two characters may map to the same character.
 * 
 * @author shree
 *
 */
public class String01_sums {

	public static void main(String[] args) {
		// Binar string 
		
		String binary="110111";
		int ans=NoOfSubString(binary);
		System.out.println(" Ans count binary "+ans);
		
		String a="acba";
		String b="acab";
		ans=CustomIndexOf(a,b);
		System.out.println(" index of b in a "+ans);
		System.out.println(" Pre build index "+ a.indexOf(b));
		
		boolean abs=CheckIfPalindromeNaive(a);
		System.out.println(" A is "+a+" Palindrome is "+abs);
		
		abs=CheckIfPalindromeEfficient(a);
		System.out.println(" A is "+a+" Palindrome is "+abs);
		
		ans=CheckIfRotation(a,b);
		System.out.println(" check if rotation is "+ans);
		
		String c=   "pijthbsfy"; //"xudzhi";    
		String d=   "fvladzpbf";//"ftakcz";   
		abs=CheckIfIsoMorphic(c,d);
		System.out.println(" Check if isomorphorpic "+c+" "+d+" Is -->"+abs);

	}

	private static boolean CheckIfIsoMorphic(String c, String d) {
		// Check if isomorpic , same freq 
		int n=c.length();
		int m=d.length();
		
		if(n!=m) {
			return false;
		}
		if(n==1) {
			return true;
		}
		
		char array[]=new char[26];
		int arr[]=new int[26];
		// Lets assume above is the char found in c 
		//lETS try to map individual of d to c
		// Mapping to d done by val of char in c 
		int val=0;char map;int map_val=0;char valc;
		for(int i=0;i<n;i++) {
			valc=c.charAt(i);
			val=valc-97;
			map=d.charAt(i);
			map_val=map-97;
			System.out.println(" I is "+i+" Array val "+array[val]+"  c char of val "+c.charAt(i)+"-"+val+" Need to map to val "+map+"-"+map_val);
			if(array[val]=='\u0000' &&  arr[map_val]==0) {
				array[val]=map;
				arr[map_val]=-1;
			}
			else if(array[val]=='\u0000' &&  arr[map_val]==-1){
				return false;
			}
			else if(array[val]!=map) {//|| array[map_val]!=valc) {
				return false;
			}
			
		}
		System.out.println(" Array bro "+Arrays.asList(array).toString());
		return true;
	}

	private static int CheckIfRotation(String a, String b) {
		//Check if rotatin 
		int n=a.length();
		int m=b.length();
		if(n!=m) {
			return 0;
		}
		char start=b.charAt(0);
		for(int i=0;i<m;i++) {
			System.out.println(" Start is "+start+" Cat at a is "+a.charAt(i)+" At i :"+i);
			if(start==a.charAt(i)) {
				if(CheckForSubsequent(a,b,i,n)) {
					return 1;
				}
			}
		}
		return 0;
	}

	private static boolean CheckForSubsequent(String a, String b, int i,int n) {
		// Check for subsequent 
		for(int k=0;k<n;k++) {
			i=i%n;
			System.out.println(" At k :"+k+" B is "+b.charAt(k)+" A is "+a.charAt(i)+" For i "+i);
			if(a.charAt(i)!=b.charAt(k)) {
				return false;
			}
			i++;
		}
		return true;
	}

	private static boolean CheckIfPalindromeEfficient(String a) {
		// Two pointer 
		int n=a.length();
		for(int i=0,j=n-1;i<(n/2+1);i++,j--) {
			if(a.charAt(i)!=a.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}

	private static boolean CheckIfPalindromeNaive(String a) {
		// Palindrome 
		StringBuilder b=new StringBuilder(a);
		b.reverse();
		
		return a.equals(b.toString());
	}

	private static int CustomIndexOf(String a, String b) {
		// Index of 
		int n=a.length();
		int m=b.length()-1;
		if(n==1 && m==1) {
			if(a.equals(b)) {
				return 0;
			}
		}
		System.out.println(" A :"+a);
		System.out.println(" B :"+b);
		char start=b.charAt(0);
		char fin=b.charAt(m);
		System.out.println(" Start is "+start+" end is "+fin);
		for(int i=0;i<(n-m);i++) {
			System.out.println("At i "+i+" Val start "+a.charAt(i)+" ..end "+a.charAt(i+m));
			if(a.charAt(i)==start && a.charAt(i+m)==fin) {
				 if(CheckIfSame(i,i+m,a,b)) {
					 return i;
				 }
			}
		}
		return -1;
	}

	private static boolean CheckIfSame(int i, int j, String a, String b) {
		// Check both 
		int t=0;
		System.out.println(" A is "+a+" B is "+b+" in compare");
		for(int k=i;k<=j;k++) {
			if(a.charAt(k)!=b.charAt(t)) {
				return false;
			}
			t++;
		}
		return true;
	}

	private static int NoOfSubString(String binary) {
		// Count sub string 
		int n=binary.length();
		char a;
		int count=-1;int prev=0;
		for(int i=0;i<n;i++) {
			a=binary.charAt(i);
			if(a=='1' && count==-1) {
				count=0;
			}
		    else if(a=='1' && count==0) {
				count=1;
				prev=2;
			}
		    else if(a=='1'){
				count=count+(prev);
				prev++;
			}
			System.out.println(" I is "+i+" prev is :"+prev+" count is "+count);
		}
		return count;
	}

}

/*
 * A string is said to be a palindrome if it is the same if we start reading it from left to right or right to left. So let us consider a string “str”, now the task is just to find out with its reverse string is the same as it is. 

Example:

Input : str = "abba" 
Output: Yes

Input : str = "geeks"
Output: No  
Naive Approach: By Reversing the given string and Comparing
We can check if the given string is a palindrome by comparing the original string with its reversed version. 
Below is the implementation of the above approach:

/*package whatever //do not write package name here 

import java.io.*;

class GFG {
	public static boolean isPalindrome(String str)
	{
		// Initializing an empty string to store the reverse
		// of the original str
		String rev = "";

		// Initializing a new boolean variable for the
		// answer
		boolean ans = false;

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		// Checking if both the strings are equal
		if (str.equals(rev)) {
			ans = true;
		}
		return ans;
	}
	public static void main(String[] args)
	{
		// Input string
		String str = "geeks";

		// Convert the string to lowercase
		str = str.toLowerCase();
		boolean A = isPalindrome(str);
		System.out.println(A);
	}
}

Output
false
Time Complexity:-The time complexity of the given code is O(n), where n is the length of the input string. This is because the for loop iterates through each character in the string once to create the reverse string.

Space Complexity:- The space complexity of the code is O(n), where n is the length of the input string. This is because the reverse string is created and stored in a separate string variable, which takes up space in memory proportional to the length of the input string. In addition, the other variables used in the code (i, str, and ans) take up a constant amount of space that is independent of the input size.

In the above example, if we write ABba in place of abba, then also we should get the output as yes.  So, we must change the case of the string to either lowercase or uppercase before we check it for a palindrome. If we do not do this, we will get unexpected results. This is because the compiler checks the characters based on their ASCII value and the ASCII value of A is not the same as a. 

Approach: Our approach will be that we will first convert the string to lowercase. Then, we will take two pointers i pointing to the start of the string and j pointing to the end of the string. Keep incrementing i and decrementing j while i < j and at every step check whether the characters at these pointers are the same or not. If not then the string is not a palindrome else it is.

Example 1:

// Java program to check whether a
// string is a Palindrome
// Using two pointing variables

// Main class
public class GFG {

	// Method
	// Returning true if string is palindrome
	static boolean isPalindrome(String str)
	{

		// Pointers pointing to the beginning
		// and the end of the string
		int i = 0, j = str.length() - 1;

		// While there are characters to compare
		while (i < j) {

			// If there is a mismatch
			if (str.charAt(i) != str.charAt(j))
				return false;

			// Increment first pointer and
			// decrement the other
			i++;
			j--;
		}

		// Given string is a palindrome
		return true;
	}

	// Method 2
	// main driver method
	public static void main(String[] args)
	{
		// Input string
		String str = "geeks";

		//Convert the string to lowercase
		str = str.toLowerCase();
		// passing bool function till holding true
		if (isPalindrome(str))

			// It is a palindrome
			System.out.print("Yes");
		else

			// Not a palindrome
			System.out.print("No");
	}
}


Output
No
Time Complexity:- The time complexity of the given code is O(n), where n is the length of the input string. This is because the while loop iterates through half of the string to check if it is a palindrome. Since we only check half of the string, the number of iterations is proportional to n/2, which is O(n).

Space Complexity:- The space complexity of the code is O(1), because the code only uses a constant amount of additional space that is independent of the input size. The only variables used in the code are i, j, and str, which each take up a constant amount of space. No additional space is created in the code.

Example 2:

// Java Program to check Whether the String is Palindrome
// or Not

// Main class
class GFG {

	// Method 1
	// Returns true if string is a palindrome
	static boolean isPalindrome(String str)
	{

		// Pointers pointing to the beginning
		// and the end of the string
		int i = 0, j = str.length() - 1;

		// While there are characters to compare
		while (i < j) {

			// If there is a mismatch
			if (str.charAt(i) != str.charAt(j))
				return false;

			// Increment first pointer and
			// decrement the other
			i++;
			j--;
		}

		// Given string is a palindrome
		return true;
	}

	// Main driver method
	public static void main(String[] args)
	{
		String str = "geeks";
		String str2 = "RACEcar";
	
		//Change strings to lowercase
		str = str.toLowerCase();
		str2 = str2.toLowerCase();

		// For string 1
		System.out.print("String 1 :");

		if (isPalindrome(str))
			System.out.print("It is a palindrome");
		else
			System.out.print("It is not a palindrome");

		// new line for better readability
		System.out.println();

		// For string 2
		System.out.print("String 2 :");
		if (isPalindrome(str2))
			System.out.print("It is a palindrome");
		else
			System.out.print("It is not a palindrome");
	}
}

Output
String 1 :It is not a palindrome
String 2 :It is a palindrome
Time Complexity:- The time complexity of the given code is O(n), where n is the length of the input string. This is because the while loop in the 
 method iterates through half of the string to check if it is a palindrome. Since we only check half of the string, the number of iterations is proportional to n/2, which is O(n).

Space Complexity:- The space complexity of the code is O(1), because the code only uses a constant amount of additional space that is independent of the input size. The only variables used in the code are i, j, str, and str2, which each take up a constant amount of space. No additional space is created in the code.

Recursive approach: The approach is very simple. Just like the two-pointer approach, we will check the first and the last value of the string but this time it will be through recursion.

We will take two pointers i pointing to the start of the string and j pointing to the end of the string. 
Keep incrementing i and decrementing j while i < j and at every step 
Check whether the characters at these pointers are the same or not. We are doing this through recursion – (i+1, j-1
If all the characters are the same on the ith and jth index till i>=j condition satisfies, print true else false
Below is the implementation of the above approach:

//// Java program to check whether a
// string is a Palindrome using recursion

import java.io.*;

class GFG {
	public static boolean isPalindrome(int i, int j,
									String A)
	{
		// comparing the two pointers
		if (i >= j) {
			return true;
		}

		// comparing the characters on those pointers
		if (A.charAt(i) != A.charAt(j)) {
			return false;
		}

		// checking everything again recursively
		return isPalindrome(i + 1, j - 1, A);
	}

	public static boolean isPalindrome(String A)
	{
		return isPalindrome(0, A.length() - 1, A);
	}

	public static void main(String[] args)
	{
		// Input string
		String A = "geeks";

		// Convert the string to lowercase
		A = A.toLowerCase();
		boolean str = isPalindrome(A);
		System.out.println(str);
	}
}

Output
false
Time Complexity:- The time complexity of the given code is O(n), where n is the length of the input string. This is because the 
 function recursively calls itself for the characters at positions (i+1, j-1) until the pointers i and j cross each other or the characters at the pointers are not equal. Since we compare each character in the string exactly once, the time complexity is O(n).

Space Complexity:- The space complexity of the code is O(n), where n is the length of the input string. This is because each recursive call creates a new stack frame that stores the current values of the function parameters and local variables. In the worst case, the function call stack may grow as large as n/2 (when the input string is a palindrome), so the space complexity is O(n).
 * 
 */

/**
 * 
 * A palindrome is a word, phrase, number, or other sequences of characters which reads the same forward and backward (ignoring spaces, punctuation, and capitalization). In this article, we'll discuss how to check if a given string is a palindrome or not in C++.

Method 1: Using Iterators One approach to check if a string is a palindrome is to use iterators to iterate over the characters in the string and compare them. Here's an example of how to use iterators to check if a string is a palindrome:

#include <iostream>
#include <string>
using namespace std;

bool isPalindrome(string input) {
    string::iterator begin = input.begin();
    string::iterator end = input.end() - 1;
    while (begin < end) {
        if (*begin != *end) {
            return false;
        }
        begin++;
        end--;
    }
    return true;
}

int main() {
    string input;
    cout << "Enter a string: ";
    cin >> input;
    if (isPalindrome(input)) {
        cout << input << " is a palindrome" << endl;
    } else {
        cout << input << " is not a palindrome" << endl;
    }
    return 0;
}
 

In this example, the isPalindrome() function takes a string as input and uses iterators to iterate over the characters in the string from both the beginning and the end. It compares the characters at each position, and if any pair of characters is not equal, it returns false, indicating that the string is not a palindrome. If the function completes the iteration and all pairs of characters are equal, it returns true, indicating that the string is a palindrome.

Method 2: Using the string.rbegin() and string.rend() function Another approach to check if a string is a palindrome is to use the string.rbegin() and string.rend() function. This will give you the reverse iterator to the beginning and end of the string respectively.

#include <iostream>
#include <string>
using namespace std;

bool isPalindrome(string input) {
    for (int i = 0; i < input.length(); i++) {
        if(input[i] != input[input.length() - i - 1])
            return false;
    }
    return true;
}

int main() {
    string input;
    cout << "Enter a string: ";
    cin >> input;
    if (isPalindrome(input)) {
        cout << input << " is a palindrome" << endl;
    } else {
        cout << input << " is not a palindrome" << endl;
    }
    return 0;
}
 * 
 */
