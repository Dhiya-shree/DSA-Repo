package impAlgorithm_Sorting;

public class LexiographicOrderSort {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}

/**
 * 
 * Sorting a string array in Lexicographical Order (Dictionary Order) using two approaches:

By using any sorting technique to sort array elements.
By using sort() function present in Arrays class in util package in java.
Example:

Input : Harit Girish Gritav Lovenish Nikhil Harman 
Output: Girish Gritav Harit Harman Lovenish Nikhil

Input : Bob Alice
Output: Alice Bob 
Approach 1: Simple sorting technique.

In this approach, two strings are compared using compareToIgnoreCase() method of String class.


Functions used:

int compareToIgnoreCase(String);
Return value:

0 if the argument is a string lexicographically equal to this string.
Less than 0 if the argument is a string lexicographically greater than this string.
Greater than 0 if the argument is a string lexicographically less than this string.
A java program to sort an array of Strings in Lexicographical Order using sorting technique :


// Java Program to Sort Elements in 
// Lexicographical Order (Dictionary Order) 
import java.io.*; 
  
class GFG { 
  
    // this method sort the string array lexicographically. 
    public static void
    sortLexicographically(String strArr[]) 
    { 
        for (int i = 0; i < strArr.length; i++) { 
            for (int j = i + 1; j < strArr.length; j++) { 
                if (strArr[i].compareToIgnoreCase(strArr[j]) 
                    > 0) { 
                    String temp = strArr[i]; 
                    strArr[i] = strArr[j]; 
                    strArr[j] = temp; 
                } 
            } 
        } 
    } 
  
    // this function prints the array passed as argument 
    public static void printArray(String strArr[]) 
    { 
        for (String string : strArr) 
            System.out.print(string + " "); 
        System.out.println(); 
    } 
  
    public static void main(String[] args) 
    { 
        // Initializing String array. 
        String stringArray[] 
            = { "Harit",    "Girish", "Gritav", 
                "Lovenish", "Nikhil", "Harman" }; 
  
        // sorting String array lexicographically. 
        sortLexicographically(stringArray); 
  
        printArray(stringArray); 
    } 
}
Output
Girish Gritav Harit Harman Lovenish Nikhil 
Time Complexity: O(n2), where n is the size of an array.

Approach 2: By using Arrays.sort()

In this approach, sort() method in a java.utils.Arrays class method is used.

Functions used:

Arrays.sort(stringArray, String.CASE_INSENSITIVE_ORDER);

// First Parameter : Name of Array
// Second Parameter: Special command to ignore case while sorting.
A java program to sort array of Strings in Lexicographical Order using Arrays.sort() method :


// Java Program to Sort Elements in 
// Lexicographical Order (Dictionary Order) 
import java.io.*; 
import java.util.Arrays; 
  
class GFG { 
    // this function prints the array passed as argument 
    public static void printArray(String strArr[]) 
    { 
        for (String string : strArr) 
            System.out.print(string + " "); 
        System.out.println(); 
    } 
    public static void main(String[] args) 
    { 
        // Initializing String array. 
        String stringArray[] 
            = { "Harit",    "Girish", "Gritav", 
                "Lovenish", "Nikhil", "Harman" }; 
  
        // sorting String array in Lexicographical Order. 
        // Ingonring the case of string. 
        Arrays.sort(stringArray, 
                    String.CASE_INSENSITIVE_ORDER); 
  
        // printing String array after sorting. 
        printArray(stringArray); 
    } 
}
Output
Girish Gritav Harit Harman Lovenish Nikhil 
Time Complexity: O ( n log n )
 * 
 * 
 */
