package recursion;

public class R03_Recursion_Basic {

	public static void main(String[] args) {
		// Baisc s
		String s="aaeeaa";
		int n=s.length();
		boolean ans=isPalindrome(s,0);
		System.out.println("Palindrome "+ans);
		
		int sum=sum_of_digit(n);
		System.out.println("Sum of digits  "+sum);
	}

	public static boolean isPalindrome(String s, int i){
		if(i > s.length()/2)
		{
			return true ;
		}

		return s.charAt(i) == s.charAt(s.length()-i-1) && isPalindrome(s, i+1) ;

	}
	
	// Function to check sum 
    // of digit using recursion
    public static int sum_of_digit(int n)
    { 
        if (n == 0)
            return 0;
        return (n % 10 + sum_of_digit(n / 10));
    }


}

/**
Palindrome Check using Recursion

Given a string, write a recursive function that checks if the given string is a palindrome or not.

Examples: 

Input : malayalam
Output : Yes
Reverse of malayalam is also
malayalam.

Input : max
Output : No
Reverse of max is not max. 
 

The idea of a recursive function is simple: 

1) If there is only one character in string
   return true.
2) Else compare first and last characters
   and recur for remaining substring.
Below is the implementation of the above idea: 


// A recursive JAVA program to 
// check whether a given String 
// is palindrome or not
import java.io.*;

class GFG
{
    // A recursive function that 
    // check a str(s..e) is 
    // palindrome or not.
    static boolean isPalRec(String str, 
                            int s, int e)
    {
        // If there is only one character
        if (s == e)
            return true;

        // If first and last 
        // characters do not match
        if ((str.charAt(s)) != (str.charAt(e)))
            return false;

        // If there are more than 
        // two characters, check if
        // middle substring is also
        // palindrome or not.
        if (s < e + 1)
            return isPalRec(str, s + 1, e - 1);

        return true;
    }

    static boolean isPalindrome(String str)
    {
        int n = str.length();

    // An empty string is 
    // considered as palindrome
        if (n == 0)
            return true;

        return isPalRec(str, 0, n - 1);
    }

    // Driver Code
    public static void main(String args[])
    {
        String str = "geeg";

        if (isPalindrome(str))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

Output
Yes
Time Complexity: O(n)
Auxiliary Space: O(n)

Another Approach :

Basically while traversing check whether ith and n-i-1th index are equal or not.

If there are not equal return false and if they are equal then continue with the recursion calls.


/*package whatever //do not write package name here *
import java.io.*;

class GFG {
  public static boolean isPalindrome(String s, int i){
    if(i > s.length()/2)
    {
      return true ;
    }

    return s.charAt(i) == s.charAt(s.length()-i-1) && isPalindrome(s, i+1) ;

  }

  public static void main (String[] args) {
    String str = "geeg" ;
    if (isPalindrome(str, 0))
    { System.out.println("Yes"); }
    else
    { System.out.println("No"); }

  }
}

Output
Yes
Time Complexity: O(n)
Auxiliary Space: O(n)



*/



/*
Sum of Digits Using Recursion

Given a number, we need to find sum of its digits using recursion.
Examples: 
 

Input : 12345
Output : 15

Input : 45632
Output :20
          

The step-by-step process for a better understanding of how the algorithm works. 
Let the number be 12345. 
Step 1-> 12345 % 10 which is equal-too 5 + ( send 12345/10 to next step ) 
Step 2-> 1234 % 10 which is equal-too 4 + ( send 1234/10 to next step ) 
Step 3-> 123 % 10 which is equal-too 3 + ( send 123/10 to next step ) 
Step 4-> 12 % 10 which is equal-too 2 + ( send 12/10 to next step ) 
Step 5-> 1 % 10 which is equal-too 1 + ( send 1/10 to next step ) 
Step 6-> 0 algorithm stops 
following diagram will illustrate the process of recursion 
 




 


// Recursive java program to 
// find sum of digits of a number
import java.io.*;

class sum_of_digits
{
    // Function to check sum 
    // of digit using recursion
    static int sum_of_digit(int n)
    { 
        if (n == 0)
            return 0;
        return (n % 10 + sum_of_digit(n / 10));
    }

    // Driven Program to check above
    public static void main(String args[])
    {
        int num = 12345;
        int result = sum_of_digit(num);
        System.out.println("Sum of digits in " + 
                           num + " is " + result);
    }
}
Output: 

Sum of digits in 12345 is 15
Besides writing (n==0 , then return 0) in the code given above we can also write it in this manner , there will be no change in the output .

if(n<10) return n; By writing this there will be no need to call the function for the numbers which are less than 10 
Time complexity : O(logn) where n is the given number. 

Auxiliary space : O(logn) due to recursive stack space.
 


*/