package string_code;

public class String09_Check_Rotation_Concates1s1_check_s2 {

	public static void main(String[] args) {
		// To check if rotation 
		
		/*
		 *Concatenate s1 with s1 
		 *Check if s2 present in S1 
		 * 
		 * s1 = AABCDE 
		 * s2= BCDEAA
		 * 
		 * To check 
		 * s1= s1+ s1= AABCDEAABCDE 
		 * Above have all possible combo of rotation 
		 * 
		 * If pattern s2 present in s1 => True 
		 * 
		 *
		 */
		
		 String s1="AABCDE";
		 String s2="BCDEAE";
		 
		 boolean ans= CheckIfRotation(s1,s2);
		 if(ans) {
			 System.out.println(" String is rotation ");
		 }
		 else {
			 System.out.println(" Not rotation ");
		 }

	}

	private static boolean CheckIfRotation(String s1, String s2) {
		// if length not same 100% not rotation 
		int n=s1.length();
		int n1=s2.length();
		if(n!=n1) {
			return false;
		}
		
		
		s1=s1+s1;
		n1=s1.length();
		return KMP_Pattern_Check(s1,s2,n,n1);
	}

	private static boolean KMP_Pattern_Check(String s1, String s2, int n, int n1) {
		// Check pattern present or not 
		
		int lps[]=BuildLPSARRAY(s2,n);
		//Create lps array with pattern
		
		boolean ans= CheckKMPwithLPS(s1,s2,n,n1,lps);
		
		
		return ans;
	}

	private static boolean CheckKMPwithLPS(String s1, String s2, int m, int n, int[] lps) {
		// kmp algo 
		int i=0; //text pointer 
		int j=0;//pat pointer 
		
		char text[]=s1.toCharArray();
		char patt[]=s2.toCharArray();
		
		while(i<n) {
			
			if(text[i]==patt[j]) {
				j++;
				i++;
			}
			else {
				if(j==0) {
					i++;
				}
				else {
					j=lps[j-1];
				}
			}
			
			if(j==m) {
				return true;
			}
			
		}
		return false;
	}

	private static int[] BuildLPSARRAY(String s2, int n) {
		// lps array 
	    int len=0;
	    int i=1;
	    int ans[]=new int[n];
	    char str[]=s2.toCharArray();
	    while(i<n) {
	    	
	    	if(str[len]==str[i]) {
	    		len=len+1;
	    		ans[i]=len;
	    		i++;
	    	}
	    	else {
	    		if(len==0) {
	    		   ans[i]=0;
	    		   i++;
	    		}
	    		else {
	    			len=ans[len-1];
	    		}
	    	}
	    	
	    }
		return ans;
	}

}
/**
 * 
 * Check if Strings are Rotations

Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1? 
(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)

Algorithm: areRotations(str1, str2)

    1. Create a temp string and store concatenation of str1 to
       str1 in temp.
                          temp = str1.str1
    2. If str2 is a substring of temp then str1 and str2 are 
       rotations of each other.

    Example:                 
                     str1 = "ABACD"
                     str2 = "CDABA"

     temp = str1.str1 = "ABACDABACD"
     Since str2 is a substring of temp, str1 and str2 are 
     rotations of each other.
 

  
// Java program to check if two given strings are rotations of 
// each other

class StringRotation
{
    /* Function checks if passed strings (str1 and str2)
       are rotations of each other 
    static boolean areRotations(String str1, String str2)
    {
        // There lengths must be same and str2 must be 
        // a substring of str1 concatenated with str1.  
        return (str1.length() == str2.length()) &&
               ((str1 + str1).indexOf(str2) != -1);
    }
    
    // Driver method
    public static void main (String[] args)
    {
        String str1 = "AACD";
        String str2 = "ACDA";

        if (areRotations(str1, str2))
            System.out.println("Strings are rotations of each other");
        else
            System.out.printf("Strings are not rotations of each other");
    }
}
// This code is contributed by  munjal 

 


Output
Strings are rotations of each other
Method 2(Using STL):

Algorithm :

1. If the size of both the strings is not equal, then it can never be possible.

2. Push the original string into a queue q1.

3. Push the string to be checked inside another queue q2.

4. Keep popping q2's and pushing it back into it till the number of such operations are less than the size of the string.

5. If q2 becomes equal to q1 at any point during these operations, it is possible. Else not.


 

#include <bits/stdc++.h>
using namespace std;
bool check_rotation(string s, string goal)
{
    if (s.size() != goal.size())
        return false;
    queue<char> q1;
    for (int i = 0; i < s.size(); i++) {
        q1.push(s[i]);
    }
    queue<char> q2;
    for (int i = 0; i < goal.size(); i++) {
        q2.push(goal[i]);
    }
    int k = goal.size();
    while (k--) {
        char ch = q2.front();
        q2.pop();
        q2.push(ch);
        if (q2 == q1)
            return true;
    }
    return false;
}
int main()
{
    string s1 = "ABCD";
    string s2 = "CDAB";
    if (check_rotation(s1, s2))
        cout << s2 << " is a rotated form of " << s1
             << endl;
    else
        cout << s2 << " is not a rotated form of " << s1
             << endl;
    string s3 = "ACBD";
    if (check_rotation(s1, s3))
        cout << s3 << " is a rotated form of " << s1
             << endl;
    else
        cout << s3 << " is not a rotated form of " << s1
             << endl;
    return 0;
}

 


Output
CDAB is a rotated form of ABCD
ACBD is not a rotated form of ABCD

 Time Complexity: Time complexity of this problem depends on the implementation of strstr function. 
If the implementation of strstr is done using KMP matcher then complexity of the above program is (-)(n1 + n2) where n1 and n2 are lengths of strings. KMP matcher takes (-)(n) time to find a substring in a string of length n where length of substring is assumed to be smaller than the string. 

Method 3:

Algorithm:

1.Find all the positions of first character of original string in the string to be checked.

2.For every position found, consider it to be the starting index of the string to be checked.

3.Beginning from the new starting index, compare both strings and check whether they are equal or not.

(Suppose original string to be s1,string to be checked be s2,n is length of strings and j is the position of first character of s1 in s2, then for i < (length of original string) ,check if s1[i]==s2[(j+1)%n). Return false if any character mismatch is found, else return true.

4.Repeat 3rd step for all positions found.

/*package whatever //do not write package name here 

import java.io.*;
import java.util.*;

class GFG
{
  
    // java program to check if two strings are rotation of each other or not
    static boolean checkString(String s1, String s2, int indexFound, int Size)
{
    for(int i=0;i<Size;i++)
    {
      
       //check whether the character is equal or not
        if(s1.charAt(i) != s2.charAt((indexFound+i)%Size))return false;
      
      // %Size keeps (indexFound+i) in bounds, 
      // since it ensures it's value is always less than Size 
    }
  
     return true;
}
  

    // Driver code
    public static void main(String args[])
    {
        String s1="abcd";
        String s2="cdab";
  
        if(s1.length() != s2.length()){
            System.out.println("s2 is not a rotation on s1");
        }
        else{
    
            ArrayList<Integer>indexes = new ArrayList<Integer>(); //store occurrences of the first character of s1
      
            int Size = s1.length();
            
            char firstChar = s1.charAt(0);
    
    
            for(int i=0;i<Size;i++)
            {
                if(s2.charAt(i)==firstChar)
                {
                  indexes.add(i);
                }
            }
    

            boolean isRotation=false;

             // check if the strings are rotation of each other for every occurence of firstChar in s2  
            for(int idx: indexes)
            {
                isRotation = checkString(s1, s2, idx, Size);

                if(isRotation)
                    break;
            }

            if(isRotation)System.out.println("s2 is rotation of s1");
            else System.out.println("s2 is not a rotation of s1");
    
        }
    }
}

// This code is contributed by shinjanpatra

 


Output
s2 is rotation of s1

Time Complexity:

Time Complexity will be n*n in the worst case, where n is the length of the string.
 * 
 * import java.util.*;

class GFG{
static boolean check_rotation(String s, String goal)
{
    if (s.length() != goal.length())
        ;
    Queue<Character> q1 = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
        q1.add(s.charAt(i));
    }
    Queue<Character> q2 = new LinkedList<>();
    for (int i = 0; i < goal.length(); i++) {
        q2.add(goal.charAt(i));
    }
    int k = goal.length();
    while (k>0) {
        k--;
        char ch = q2.peek();
        q2.remove();
        q2.add(ch);
        if (q2.equals(q1))
            return true;
    }
    return false;
}
public static void main(String[] args)
{
    String s1 = "ABCD";
    String s2 = "CDAB";
    if (check_rotation(s1, s2))
        System.out.print(s2+ " is a rotated form of " +  s1
             +"\n");
    else
        System.out.print(s2+ " is not a rotated form of " +  s1
             +"\n");
    String s3 = "ACBD";
    if (check_rotation(s1, s3))
        System.out.print(s3+ " is a rotated form of " +  s1
             +"\n");
    else
        System.out.print(s3+ " is not a rotated form of " +  s1
             +"\n");
}
}

// This code is contributed by gauravrajput1 

 


Output
CDAB is a rotated form of ABCD
ACBD is not a rotated form of ABCD

 Time Complexity: Time complexity of this problem depends on the implementation of strstr function. 
If the implementation of strstr is done using KMP matcher then complexity of the above program is (-)(n1 + n2) where n1 and n2 are lengths of strings. KMP matcher takes (-)(n) time to find a substring in a string of length n where length of substring is assumed to be smaller than the string. 

Method 3:

Algorithm:

1.Find all the positions of first character of original string in the string to be checked.

2.For every position found, consider it to be the starting index of the string to be checked.

3.Beginning from the new starting index, compare both strings and check whether they are equal or not.

(Suppose original string to be s1,string to be checked be s2,n is length of strings and j is the position of first character of s1 in s2, then for i < (length of original string) ,check if s1[i]==s2[(j+1)%n). Return false if any character mismatch is found, else return true.

4.Repeat 3rd step for all positions found.

/*package whatever //do not write package name here 

import java.io.*;
import java.util.*;

class GFG
{
  
    // java program to check if two strings are rotation of each other or not
    static boolean checkString(String s1, String s2, int indexFound, int Size)
{
    for(int i=0;i<Size;i++)
    {
      
       //check whether the character is equal or not
        if(s1.charAt(i) != s2.charAt((indexFound+i)%Size))return false;
      
      // %Size keeps (indexFound+i) in bounds, 
      // since it ensures it's value is always less than Size 
    }
  
     return true;
}
  

    // Driver code
    public static void main(String args[])
    {
        String s1="abcd";
        String s2="cdab";
  
        if(s1.length() != s2.length()){
            System.out.println("s2 is not a rotation on s1");
        }
        else{
    
            ArrayList<Integer>indexes = new ArrayList<Integer>(); //store occurrences of the first character of s1
      
            int Size = s1.length();
            
            char firstChar = s1.charAt(0);
    
    
            for(int i=0;i<Size;i++)
            {
                if(s2.charAt(i)==firstChar)
                {
                  indexes.add(i);
                }
            }
    

            boolean isRotation=false;

             // check if the strings are rotation of each other for every occurence of firstChar in s2  
            for(int idx: indexes)
            {
                isRotation = checkString(s1, s2, idx, Size);

                if(isRotation)
                    break;
            }

            if(isRotation)System.out.println("s2 is rotation of s1");
            else System.out.println("s2 is not a rotation of s1");
    
        }
    }
}

// This code is contributed by shinjanpatra

 


Output
s2 is rotation of s1

Time Complexity:

Time Complexity will be n*n in the worst case, where n is the length of the string.
 * 
 */
