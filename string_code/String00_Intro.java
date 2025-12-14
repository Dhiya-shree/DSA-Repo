package string_code;


/**
 * 
 *  Array there Y need String ?
 *  
 *  -> Small set 
 *  -> Limited char 
 *  -> Contiguous location stored for a to z and A to Z 
 *  -> C . C++
 *       ASCII representation 
 *       8 bits 
 *       128 char - uses parity bit not needed 
 *        
 *       Extended ACSII 
 *       256= 128 + 128 - char 
 *       Controller char 
 *       
 *       Only English 
 *       Supports wchar_t for storing small 
 *       
 *  -> JAVA 
 *        UTF 16 representation 
 *        16 bits 
 *        Universal set of char - not only English 
 *        
 *        Even in UTF - 16
 *        Values of string still same as ASCII
 *        Because first 128 in UTF is same as ASCII
 *        
 *        All language 
 *        Supports byte for small char 
 *        
 *  
 *  JAVA STRING     
 *      Stored in 16 bits UTF 16
 *      Initiation :
 *          1) Character array 
 *               char str[]={'g','e','e','k'};
 *          
 *          2) String class - Immutable - contents can not be changed 
 *                String str="geeks";
 *                All functions on string give new objects 
 *                No modify the existing class 
 *                
 *          Mutable classes: 
 *          
 *          Thread safe class- can be used for multi thread environment 
 *          Buffer can be used by multiple string 
 *          Thread safe -> extra overhead 
 *          3) String Buffer class 
 *                StringBuffer str = new StringBuffer("geeks");
 *          
 *          Not Thread safe, used only within a thread 
 *          No thread safe -> no overhead         
 *          4) String Builder class 
 *                StringBuilder str = new StringBuilder("geeks");
 *                
 *       
 *  Immutable and thread safe - String 
 *  Mutable but not thread safe - String builder 
 *  Mutable and Thread safe - String buffer 
 *  
 *  JAVA Compiler to String 
 *         - No new place bro .. same content , same memory
 *            - Use new if must to get new memory  
 *  == compares the reference and not the context ..
 *  
 *  When use eclipse , same space for a word .So give true for == 
 *  But it is still comparing reference 
 *  
 *  To check the actual contents use str1.equals(str2)
 *  GoG dont store at same ref baba ... so must to use func to compare 
 *  
 *  String s1="geeks";
 *  String s2="geeks";
 *  String s3 = new String("geeks");
 *  
 *  s1==s2 -> Compiler : yes bro both pointing to same ref 
 *  s1==s3 -> NO Compiler : No bro s3 got spaace with new na ..diff reference 
 *  
 *  String JAVA Functions : 
 *  1) str.length()
 *  2) str.charAT(int index) - return val , can not assign
 *  3) str.substring(2)
 *  4) str.substring(2,5)
 *  5) str.contains(s2) -> return true if str contains s2  
 *  6) str.equals(s1) -> return true if content are same 
 *  7) str.compareTo(s1) -> return 0 if same , >0 if str is lexicographically big and <0 if s1 is big 
 *  8) str.indexOf(s2) -> return negative value if index not present ,
 *       otherwise return the index of first occurrence of s1 present in s2 
 *  9) str.indexOf(s2,3) -> return negative value if index not present ,
 *       otherwise return the index of first occurrence of s1 present in s2 
 *         After the given index (ex: 3)
 *  10) str.lastIndexOf(s2) -> return negative value if index not present ,
 *       otherwise return the index of last occurrence of s1 present in s2 
 *  11) str.lastIndexOf(s2,3) -> return negative value if index not present ,
 *       otherwise return the index of last occurrence of s1 present in s2 
 *         before the given index (ex: 3)  
 *  12)String Concatenation 
 *       Use + "shree"+"dhiya"=> "shreedhiya"    
 *  13)  DANGER SUMU :
 *           String s1="geeksfor";
 *           String s2=s1;
 *           NOw both s1 and s2 point at same place ?
 *           yes 
 *           Concat s1 now 
 *           s1=s1+"geeks";
 *           Here s1 pointing to diff ref altogeter 
 *           and s2 geeks reference geeks 
 *           So NO false 
 *      
 *   14) Objects.equals(string1, string2)
 *   Using Objects.equals() : Object.equals(Object a, Object b) method returns true if the arguments are equal to each other and 
 *   false otherwise. Consequently, if both arguments are null, true is returned and if exactly one argument is null, false is returned.
 *   Otherwise, equality is determined by using the equals() method of the first argument.
 * 
 * 
 *   15) Why not to use == for comparison of Strings?
 *   In general both equals() and “==” operator in Java are used to compare objects to check equality
 *      but here are some of the differences between the two:
 *      
 *      Main difference between .equals() method and == operator is that one is a method and other is a operator.
 *      One can use == operators for reference comparison (address comparison) and .equals() method for content comparison.
 *      Both s1 and s2 refers to different objects.
 *      When one uses == operator for s1 and s2 comparison then the result is false as both have different addresses in memory.
 *      Using equals, the result is true because it's only comparing the values given in s1 and s2.
 * 
 *  C++ String :
 *  
 *  1)C style string 
 *        array of char 
 *        char str[]="gfg"
 *        { g , f , g ,\0 }
 *        \0 as terminator 
 *        str={'g','f','g'}
 *        .. no \0 will be added 
 *        Give segmentation fault as no zero 
 *        or if find \0 after some point give random values 
 *        
 *       so need to manually put {'g','f','g','\0'}
 *       double quotes -> compiler put 0 
 *       Single quote -> manually put 0
 *       
 *       Func :
 *          strlen(str)
 *          strcmp(s1,s2)
 *          strcpy(s1,s2)
 *     
 *  2)C++ style 
 *       Rich Library $ 
 *       +,,<,>,...operation allowed 
 *       can assign string later 
 *       no care for size 
 *       can be changed to c style 
 *       
 *       
 * 
 * @author shree
 *
 */
public class String00_Intro {

	public static void main(String[] args) {
		// String
		
		String str="geeksforgeeks";
		PrintTheFreq(str);
		
		StringFunctions();

	}

	private static void StringFunctions() {
		
		String s= "GeeksforGeeks";
        // or String s= new String ("GeeksforGeeks");

        // Returns the number of characters in the String.
        System.out.println("String length = " + s.length());

        // Returns the character at ith index.
        System.out.println("Character at 3rd position = "
                           + s.charAt(3));

        s.lastIndexOf('s');
        // Return the substring from the ith index character
        // to end of string
        System.out.println("Substring " + s.substring(3));

        // Returns the substring from i to j-1 index.
        System.out.println("Substring = " + s.substring(2,5));

        // Concatenates string2 to the end of string1.
        String s1 = "Geeks";
        String s2 = "forGeeks";
        System.out.println("Concatenated string = " +
                            s1.concat(s2));

        // Returns the index within the string
        // of the first occurrence of the specified string.
        String s4 = "Learn Share Learn";
        System.out.println("Index of Share " + 
                           s4.indexOf("Share"));

        // Returns the index within the string of the
        // first occurrence of the specified string,
        // starting at the specified index.
        System.out.println("Index of a = " + 
                           s4.indexOf('a',3));

        // Checking equality of Strings
        Boolean out = "Geeks".equals("geeks");
        System.out.println("Checking Equality " + out);
        out = "Geeks".equals("Geeks");
        System.out.println("Checking Equality " + out);

        out = "Geeks".equalsIgnoreCase("gEeks ");
        System.out.println("Checking Equality " + out);

        int out1 = s1.compareTo(s2);
        System.out.println("If s1 = s2 " + out1);

        // Converting cases
        String word1 = "GeeKyMe";
        System.out.println("Changing to lower Case " +
                            word1.toLowerCase());

        // Converting cases
        String word2 = "GeekyME";
        System.out.println("Changing to UPPER Case " + 
                            word2.toUpperCase());

        // Trimming the word
        String word4 = " Learn Share Learn ";
        System.out.println("Trim the word " + word4.trim());

        // Replacing characters
        String str1 = "feeksforfeeks";
        System.out.println("Original String " + str1);
        String str2 = "feeksforfeeks".replace('f' ,'g') ;
        System.out.println("Replaced f with g -> " + str2);
        String str3 = str1.replace('f' ,'g') ;
        System.out.println("Str "+str1+"Replaced f with g -> " + str3);
		
        
        String s5="shree";
        String s6=s5;
        System.out.println(" Is string 5 and 6 equal ?");
        System.out.println(" Ans is "+(s5==s6));
        
        s5=s5+" dhi";
        System.out.println(" Is string 5 and 6 equal after concatenation ?");
        System.out.println(" Ans is "+(s5==s6));
	}

	private static void PrintTheFreq(String str) {
		// Create i 
		int count[]=new int[26];
		int l=str.length();
		int val=0;
		for(int i=0;i<l;i++) {
			val=(int)((str.charAt(i))-'a');
			count[val]=count[val]+1;
		}
		
		for(int c=0;c<26;c++) {
			if(count[c]>0) {
			System.out.println(" char "+(char)(c+'a')+
					" count"+count[c]);	
			}
		}
		
	}

}
/**
 * 
 * 
 * 
 */
/*
 * 
 *Strings in C++

Strings in C++ are used to store text or sequence of characters. In C++ strings can be stored in one of the two following ways:

C style string (using characters)
String class

 
Each of the above methods is discussed below:

 
C style string: In C, strings are defined as an array of characters. The difference between a character array and a string is the string is terminated with a special character ‘\0’. In C, the string is actually represented as an array of characters terminated by a null string. Therefore the size of the character array is always one more than that of the number of characters in the actual string. This thing continues to be supported in C++ too. The C++ compiler automatically sets “\0” at the end of the string, during initialization of the array.
Initializing a String in C++:

1. char str[] = "Geeks";
2. char str[6] = "Geeks";
3. char str[] = {'G', 'e', 'e', 'k', 's', '\0'};
4. char str[6] = {'G', 'e', 'e', 'k', 's', '\0'};
Below is the memory representation of a string “Geeks” in C++.


 
 

Let’s look at some examples to better understand the string representation in C++, using C style:

// C++ program to demonstrate
// Strings using C style

#include <iostream>
using namespace std;

int main()
{

	// Declare and initialize string
	char str[] = "Geeks";

	// Print string
	cout << str;

	return 0;
}

Output
Geeks
Standard String representation and String Class: In C++, one can directly store the collection of characters or text in a string variable, surrounded by double-quotes. C++ provides string class, which supports various operations like copying strings, concatenating strings etc.

Initializing string in C++:

1. string str1 = "Geeks";
2. string str2 = "Welcome to GeeksforGeeks!";
Example:

// C++ program to demonstrate String
// using Standard String representation

#include <iostream>
#include <string>
using namespace std;

int main()
{

	// Declare and initialize the string
	string str1 = "Welcome to GeeksforGeeks!";

	// Initialization by raw string
	string str2("A Computer Science Portal");

	// Print string
	cout << str1 << endl << str2;

	return 0;
}

Output
Welcome to GeeksforGeeks!
A Computer Science Portal 
 * 
 * 
 *
 * Introduction to Strings

Strings are defined as a stream of characters. Strings are used to represent text and are generally represented by enclosing text within quotes as: "This is a sample string!".

Different programming languages have different ways of declaring and using Strings. We will learn to implement strings in C/C++ and Java.

Strings in C/C++

In C/C++, Strings are defined as an array of characters. The difference between a character array and a string is that the string is terminated with a special character ‘\0’.

Declaring Strings: Declaring a string is as simple as declaring a one-dimensional array. Below is the basic syntax for declaring a string.
char str_name[size];


In the above syntax, str_name is any name given to the string variable and size is used to define the length of the string, i.e the number of characters strings will store. Please keep in mind that there is an extra terminating character which is the Null character ('\0') used to indicate the termination of string which differs strings from normal character arrays.

Initializing a String: A string can be initialized in different ways. We will explain this with the help of an example. Below is an example to declare a string with the name as str and initialize it with “GeeksforGeeks”.

1. char str[] = "GeeksforGeeks";

2. char str[50] = "GeeksforGeeks";

3. char str[] = {'G','e','e','k','s','f','o','r','G','e','e','k','s','\0'};

4. char str[14] = {'G','e','e','k','s','f','o','r','G','e','e','k','s','\0'};


Printing a string array: Unlike arrays we do not need to print a string, character by character. The C/C++ language does not provide an inbuilt data type for strings but it has an access specifier “%s” which can be used to directly print and read strings.

// C/C++ program to illustrate strings 
  
#include<bits/stdc++.h> 
  
int main() 
{    
    // declare and initialize string 
    char str[] = "Geeks"; 
      
    // print string 
    printf("%s",str); 
      
    return 0; 
} 
Output:
Geeks



Passing strings to function: As strings are character arrays, so we can pass strings to function in the same way we pass an array to a function. Below is a sample program to do this:

// C/C++ program to illustrate how to 
// pass strings to function 
  
#include<bits/stdc++.h> 
  
void printStr(char str[]) 
{ 
    printf("String is : %s",str); 
} 
  
int main() 
{    
    // declare and initialize string 
    char str[] = "GeeksforGeeks"; 
      
    // print string by passing string 
    // to a different function 
    printStr(str); 
      
    return 0; 
} 
Output:
String is : GeeksforGeeks



std::string Class in C++


C++ has in its definition a way to represent the sequence of characters as an object of a class. This class is called std::string. The String class stores the characters as a sequence of bytes with functionality of allowing access to single byte character.

string Class vs Character array:
A character array is simply an array of characters can terminated by a null character. A string is a class which defines objects that be represented as stream of characters.
Size of the character array has to allocated statically, more memory cannot be allocated at run time if required. Unused allocated memory is wasted in case of character array. In case of strings, memory is allocated dynamically. More memory can be allocated at run time on demand. As no memory is preallocated, no memory is wasted.
Implementation of character array is faster than std:: string. Strings are slower when compared to implementation than character array.
Character array does not offer much inbuilt functions to manipulate strings. String class defines a number of functionalities which allow manifold operations on strings.


Declaration Syntax: Declaring string using string class is simple and can be done using the string keyword as shown below.
string string_name = "Sample String";



Sample Program:

// C++ program to illustrate strings 
  
#include<bits/stdc++.h> 
using namespace std;

int main() 
{    
    // declare and initialize string 
    string str = "Geeks"; 
      
    // print string 
    cout<<str;
      
    return 0; 
} 
Output:
Geeks


To learn about std::string in details, refer: std::string class in C++.

Strings in Java

String is a sequence of characters. In java, objects of String are immutable which means a constant and cannot be changed once created.
Creating a String


There are two ways to create string in Java:
String literal
String s = “GeeksforGeeks”;
Using new keyword
String s = new String (“GeeksforGeeks”);


String Methods
int length(): Returns the number of characters in the String.
"GeeksforGeeks".length();  // returns 13
Char charAt(int i): Returns the character at ith index.
"GeeksforGeeks".charAt(3); // returns  ‘k’
String substring (int i): Return the substring from the ith  index character to end.
"GeeksforGeeks".substring(3); // returns “ksforGeeks”
String substring (int i, int j): Returns the substring from i to j-1 index.
 "GeeksforGeeks".substring(2, 5); // returns “eks”
String concat( String str): Concatenates specified string to the end of this string.
 String s1 = ”Geeks”;
 String s2 = ”forGeeks”;
 String output = s1.concat(s2); // returns “GeeksforGeeks”

int indexOf (String s): Returns the index within the string of the first occurrence of the specified string.
 String s = ”Learn Share Learn”;
 int output = s.indexOf(“Share”); // returns 6

int indexOf (String s, int i): Returns the index within the string of the first occurrence of the specified string, starting at the specified index.
 String s = ”Learn Share Learn”;
 int output = s.indexOf(‘a’,3);// returns 8

Int lastIndexOf( String s): Returns the index within the string of the last occurrence of the specified string.
 String s = ”Learn Share Learn”;
 int output = s.lastIndexOf(‘a’); // returns 14

boolean equals( Object otherObj): Compares this string to the specified object.
 Boolean out = “Geeks”.equals(“Geeks”); // returns true
 Boolean out = “Geeks”.equals(“geeks”); // returns false

boolean  equalsIgnoreCase (String anotherString): Compares string to another string, ignoring case considerations.
 Boolean out= “Geeks”.equalsIgnoreCase(“Geeks”); // returns true
 Boolean out = “Geeks”.equalsIgnoreCase(“geeks”); // returns true
 int compareTo( String anotherString): Compares two string lexicographically.
 int out = s1.compareTo(s2);  // where s1 ans s2 are
                             // strings to be compared

 This returns difference s1-s2. If :
 out < 0  // s1 comes before s2
 out = 0  // s1 and s2 are equal.
 out > 0   // s1 comes after s2.

int compareToIgnoreCase( String anotherString): Compares two string lexicographically, ignoring case considerations.
 int out = s1.compareToIgnoreCase(s2);  
// where s1 ans s2 are 
// strings to be compared

 This returns difference s1-s2. If :
 out < 0  // s1 comes before s2
 out = 0   // s1 and s2 are equal.
 out > 0   // s1 comes after s2.

Note- In this case, it will not consider case of a letter (it will ignore whether it is uppercase or lowercase).
String toLowerCase(): Converts all the characters in the String to lower case.
String word1 = “HeLLo”;
String word3 = word1.toLowerCase(); // returns “hello"

String toUpperCase(): Converts all the characters in the String to upper case.
String word1 = “HeLLo”;
String word2 = word1.toUpperCase(); // returns “HELLO”

String trim(): Returns the copy of the String, by removing whitespaces at both ends. It does not affect whitespaces in the middle.
String word1 = “ Learn Share Learn “;
String word2 = word1.trim(); // returns “Learn Share Learn”

 String replace (char oldChar, char newChar): Returns new string by replacing all occurrences of oldChar with newChar.
String s1 = “feeksforfeeks“;
String s2 = “feeksforfeeks”.replace(‘f’ ,’g’); // returns “geeksgorgeeks”

Note:- s1 is still feeksforfeeks and s2 is geeksgorgeeks
Program to illustrate all string  methods:
 * 
 * 
 */
