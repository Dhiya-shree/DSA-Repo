package string_code;

import java.util.Arrays;
import java.util.HashMap;

public class String12_LongestSubString_Distict_Hard {

	public static void main(String[] args) {
		// Longest Substring with Distinct Characters
		
		String s="abcdabc";
		int n=s.length();
		
		int ans=LongSubset(s,n);
		System.out.println(" ans "+ans);
		
		ans=LongSubSetEfficient(s,n);
		System.out.println(" Ans efficient "+ans);
		
		ans=LongSufficientLessSpace(s,n);
		System.out.println(" Ans effici less space "+ans);
		
		///////////////////////// GGGOOGGGG
		ans=longestDistinctN1(s);
		System.out.println(" ans best efficient N1 "+ans);
		
		ans=longestDistinctN2(s);
		System.out.println(" Ans efficient  N2"+ans);
		
		ans=longestDistinctN3(s);
		System.out.println(" Ans N3 "+ans);
		

	}

	private static int LongSufficientLessSpace(String s, int n) {
		//less space 
		int CHAR[]=new int[256];
		
		int c=0;int val=0;int len=0;String st="";
		int start=0;int end=0;
		Arrays.fill(CHAR,-1);
		for(int i=0;i<n;i++) {
			c=s.charAt(i);
		    if(CHAR[c]!=-1) {
		    	end=CHAR[c];
		    	val=end-start;
		    	start=end;
		    	CHAR[c]=i;
		    }
		    else {
		    	val++;
		    	CHAR[c]=i;
		    }
		    
		    if(val>len) {
				len=val;
				st=s.substring(start,i+1);
				System.out.println(" Substring greater "+st);
			}
		}
		System.out.println(" Final greater substring "+st+" Val "+len);
		return len;
	}

	private static int LongSubSetEfficient(String s, int n) {
		// Efficient 
		
		HashMap<Integer,Integer> hm=new HashMap<>();
		int c=0;int val=0;int len=0;String st="";
		int start=0;int end=0;
		for(int i=0;i<n;i++) {
			c=s.charAt(i);
			if(hm.containsKey(c)) {
				end=hm.get(c);
				val=(end-start);
				start=end;
			}
			else {
				val++;
			}
			hm.put(c,i);
			System.out.println(" HM created "+hm.toString());
			System.out.println(" Val "+val+" start "+start+" end "+i);
			if(val>len) {
				len=val;
				st=s.substring(start,i+1);
				System.out.println(" Substring greater "+st);
			}
		}
		System.out.println(" Final greater substring "+st+" Val "+len);
		return len;
	}

	private static int LongSubset(String s, int n) {
		// long subset len 
		int len=1;String st = "";
		HashMap<Integer,Integer> hm=new HashMap<>(n);
		int c;
		char remc;
		int removeTill=0;int start=0;
		for(int i=0;i<n;i++) {                     //Time O n 
            c=s.charAt(i);
            if(hm.containsKey(c)) {
            	// Already present char ?
            	// Delete that Beeach till the curr already present point 
            	removeTill=hm.get(c);
            	for(int j=start;j<=removeTill;j++) {   //TIME Best 1 , Worst N 
            		remc=s.charAt(j);
            		hm.remove(remc);      
            	}
            	start=removeTill+1;
            }
            
            hm.put(c,i);
            if(hm.size()>len) {
            	len=hm.size();
            	st=s.substring(start,i+1);
            }
		
            
            
	}
		//Time Worst O 2 N 
		System.out.println(" Big with distinct char "+st);
		return len;

}

	
	
	
	//////////////////////////////////// N ^2 
	private static int longestDistinctN2(String str) 
    { 
	int n = str.length(); 
	int res = 0;
	for (int i = 0; i < n; i++){
	    boolean visited[]=new boolean[256];
	    for(int j=i;j<n;j++){
	        if(visited[str.charAt(j)]==true){
	            break;
	        }
	        else{
	            res=Math.max(res,j-i+1);
	            visited[str.charAt(j)]=true;
	        }
	    }
	} 
	return res; 
    } 
	
	/////////////////////////////N GOG 
	 private static int longestDistinctN1(String str) 
	    { 
		int n = str.length(); 
		int res = 0;
		int prev[]=new int[256];
		Arrays.fill(prev,-1);
		int i=0;
		for (int j = 0; j < n; j++){
		    i=Math.max(i,prev[str.charAt(j)]+1);
		    int maxEnd=j-i+1;
		    res=Math.max(res,maxEnd);
		    prev[str.charAt(j)]=j;
		} 
		return res; 
	    } 
	    
	

	//////////////////////////////N ^3
	private static boolean areDistinct(String str, int i, int j) 
	    { 
	    
		boolean visited[]=new boolean[256]; 

		for (int k = i; k <= j; k++) { 
			if (visited[str.charAt(k)] == true) 
				return false; 
			visited[str.charAt(k)] = true; 
		} 
		return true; 
	    } 

	   private static int longestDistinctN3(String str) 
	    { 
		int n = str.length(); 
		int res = 0;
		for (int i = 0; i < n; i++) 
			for (int j = i; j < n; j++) 
				if (areDistinct(str, i, j)) 
					res = Math.max(res, j - i + 1); 
		return res; 
	    } 
}

/**

Longest Substring with Distinct Characters

Given a string str, find the length of the longest substring without repeating characters. 

Example:

For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.

For “BBBB” the longest substring is “B”, with length 1.

For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7



 

Method 1 (Simple : O(n3)): We can consider all substrings one by one and check for each substring whether it contains all unique characters or not. There will be n*(n+1)/2 substrings. Whether a substring contains all unique characters or not can be checked in linear time by scanning it from left to right and keeping a map of visited characters. 

// Java program to find the length of the
// longest substring without repeating
// characters
import java.io.*;
import java.util.*;

class GFG{

// This function returns true if all characters in
// str[i..j] are distinct, otherwise returns false
public static Boolean areDistinct(String str,
								int i, int j)
{
	
	// Note : Default values in visited are false
	boolean[] visited = new boolean[26];

	for(int k = i; k <= j; k++)
	{
		if (visited[str.charAt(k) - 'a'] == true)
			return false;
			
		visited[str.charAt(k) - 'a'] = true;
	}
	return true;
}

// Returns length of the longest substring
// with all distinct characters.
public static int longestUniqueSubsttr(String str)
{
	int n = str.length();
	
	// Result
	int res = 0;
	
	for(int i = 0; i < n; i++)
		for(int j = i; j < n; j++)
			if (areDistinct(str, i, j))
				res = Math.max(res, j - i + 1);
				
	return res;
}

// Driver code
public static void main(String[] args)
{
	String str = "geeksforgeeks";
	System.out.println("The input string is " + str);

	int len = longestUniqueSubsttr(str);
	
	System.out.println("The length of the longest " +
					"non-repeating character " +
					"substring is " + len);
}
}
 

Output

The input string is geeksforgeeks
The length of the longest non-repeating character substring is 7
Time Complexity: O(n^3) since we are processing n^2 substrings with maximum length n.
Auxiliary Space: O(1)

 

Method 2 (Better : O(n2)) The idea is to use window sliding. Whenever we see repetition, we remove the previous occurrence and slide the window.

// Java program to find the length of the
// longest substring without repeating
// characters
import java.io.*;
import java.util.*;

class GFG{

public static int longestUniqueSubsttr(String str)
{
	int n = str.length();
	
	// Result
	int res = 0;
	
	for(int i = 0; i < n; i++)
	{
		
		// Note : Default values in visited are false
		boolean[] visited = new boolean[256];
		
		for(int j = i; j < n; j++)
		{
			
			// If current character is visited
			// Break the loop
			if (visited[str.charAt(j)] == true)
				break;

			// Else update the result if
			// this window is larger, and mark
			// current character as visited.
			else
			{
				res = Math.max(res, j - i + 1);
				visited[str.charAt(j)] = true;
			}
		}

		// Remove the first character of previous
		// window
		visited[str.charAt(i)] = false;
	}
	return res;
}

// Driver code
public static void main(String[] args)
{
	String str = "geeksforgeeks";
	System.out.println("The input string is " + str);

	int len = longestUniqueSubsttr(str);
	System.out.println("The length of the longest " +
					"non-repeating character " +
					"substring is " + len);
}
}
 

Output

The input string is geeksforgeeks
The length of the longest non-repeating character substring is 7
Time Complexity: O(n^2) since we are traversing each window to remove all repetitions.
Auxiliary Space: O(1)

 

Method 3 ( Linear Time ): Using this solution the problem can be solved in linear time using the window sliding technique. Whenever we see repetition, we remove the window till the repeated string.

import java.io.*;

class GFG {
	public static int longestUniqueSubsttr(String str)
	{
		String test = "";

		// Result
		int maxLength = -1;

		// Return zero if string is empty
		if (str.isEmpty()) {
			return 0;
		}
		// Return one if string length is one
		else if (str.length() == 1) {
			return 1;
		}
		for (char c : str.toCharArray()) {
			String current = String.valueOf(c);

			// If string already contains the character
			// Then substring after repeating character
			if (test.contains(current)) {
				test = test.substring(test.indexOf(current)
									+ 1);
			}
			test = test + String.valueOf(c);
			maxLength = Math.max(test.length(), maxLength);
		}

		return maxLength;
	}

	// Driver code
	public static void main(String[] args)
	{
		String str = "geeksforgeeks";
		System.out.println("The input string is " + str);

		int len = longestUniqueSubsttr(str);
		System.out.println("The length of the longest "
						+ "non-repeating character "
						+ "substring is " + len);
	}
}
 

Output

7
Time Complexity: O(n) since we slide the window whenever we see any repetitions.
Auxiliary Space: O(1)

 

Method 4 (Linear Time): Let us talk about the linear time solution now. This solution uses extra space to store the last indexes of already visited characters. The idea is to scan the string from left to right, keep track of the maximum length Non-Repeating Character Substring seen so far in res. When we traverse the string, to know the length of current window we need two indexes. 
1) Ending index ( j ) : We consider current index as ending index. 
2) Starting index ( i ) : It is same as previous window if current character was not present in the previous window. To check if the current character was present in the previous window or not, we store last index of every character in an array lasIndex[]. If lastIndex[str[j]] + 1 is more than previous start, then we updated the start index i. Else we keep same i.  

Below is the implementation of the above approach :

// Java program to find the length of the longest substring
// without repeating characters
import java.util.*;

public class GFG {

	static final int NO_OF_CHARS = 256;

	static int longestUniqueSubsttr(String str)
	{
		int n = str.length();

		int res = 0; // result

		// last index of all characters is initialized
		// as -1
		int [] lastIndex = new int[NO_OF_CHARS];
		Arrays.fill(lastIndex, -1);

		// Initialize start of current window
		int i = 0;

		// Move end of current window
		for (int j = 0; j < n; j++) {

			// Find the last index of str[j]
			// Update i (starting index of current window)
			// as maximum of current value of i and last
			// index plus 1
			i = Math.max(i, lastIndex[str.charAt(j)] + 1);

			// Update result if we get a larger window
			res = Math.max(res, j - i + 1);

			// Update last index of j.
			lastIndex[str.charAt(j)] = j;
		}
		return res;
	}

	/* Driver program to test above function 
	public static void main(String[] args)
	{
		String str = "geeksforgeeks";
		System.out.println("The input string is " + str);
		int len = longestUniqueSubsttr(str);
		System.out.println("The length of "
						+ "the longest non repeating character is " + len);
	}
}
 

Output

The input string is geeksforgeeks
The length of the longest non-repeating character substring is 7
Time Complexity: O(n + d) where n is length of the input string and d is number of characters in input string alphabet. For example, if string consists of lowercase English characters then value of d is 26. 
Auxiliary Space: O(d) 

Alternate Implementation : 

import java.util.*;
class GFG {

static int longestUniqueSubsttr(String s)
{

	// Creating a set to store the last positions of occurrence
	HashMap<Character, Integer> seen = new HashMap<>();
	int maximum_length = 0;

	// starting the initial point of window to index 0
	int start = 0;

	for(int end = 0; end < s.length(); end++)
	{
	// Checking if we have already seen the element or not
	if(seen.containsKey(s.charAt(end)))
	{
		// If we have seen the number, move the start pointer
		// to position after the last occurrence
		start = Math.max(start, seen.get(s.charAt(end)) + 1);
	}

	// Updating the last seen value of the character
	seen.put(s.charAt(end), end);
	maximum_length = Math.max(maximum_length, end-start + 1);
	}
	return maximum_length;
}

// Driver code
public static void main(String []args)
{
	String s = "geeksforgeeks";
	System.out.println("The input String is " + s);
	int length = longestUniqueSubsttr(s);
	System.out.println("The length of the longest non-repeating character substring is " + length);
}
}
 

Output

The input String is geeksforgeeks
The length of the longest non-repeating character substring is 7
Time Complexity: O(n + d) where n is length of the input string and d is number of characters in input string alphabet. For example, if string consists of lowercase English characters then value of d is 26. 
Auxiliary Space: O(d) 

As an exercise, try the modified version of the above problem where you need to print the maximum length NRCS also (the above program only prints the length of it).

 

Method 5 (Linear time):   In this method we will apply  KMP Algorithm technique, to solve the problem. We maintain an Unordered Set to keep track of the maximum non repeating char sub string (Instead of standard LPS array of KMP). When ever we find a repeating char, then we clear the Set and reset len to zero. Rest everything is almost similar to KMP.

/*package whatever //do not write package name here 
import java.util.*;

class GFG {
public static int longestSubstrDistinctChars(String s)
{
	if (s.length() == 0) {
	return 0;
	}
	int n = s.length();
	HashSet<Character> st = new HashSet<Character>();
	int len = 1;
	st.add(s.charAt(0));
	int i = 1;
	int maxLen = 0;
	while (i < n) {
	if (s.charAt(i) != s.charAt(i - 1)
		&& !st.contains(s.charAt(i))) {
		st.add(s.charAt(i));
		len++;
		i++;
		if (len > maxLen) {
		maxLen = len;
		}
	}
	else {
		if (len == 1) {
		i++;
		}
		else {
		st.clear();
		i = i - len + 1;
		len = 0;
		}
	}
	}
	return Math.max(maxLen, len);
}

public static void main(String[] args)
{
	String str = "abcabcbb";
	System.out.println("The input string is " + str);
	int len = longestSubstrDistinctChars(str);
	System.out.println(
	"The length of the longest non-repeating character substring "
	+ len);
}
}
 

Output

The input string is abcabcbb
The length of the longest non-repeating character substring 3
Time Complexity : O(n) where n is the input string length

Auxiliary Space: O(m) where m is the length of the resultant sub string



*/