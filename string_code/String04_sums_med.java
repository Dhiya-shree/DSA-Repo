package string_code;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 
 * Problem #1 :Reverse words in a given string
 * Given a String S, reverse the string without reversing its individual words.
 *  Words are separated by dots.
 *  
 *  Problem #2 : Remove common characters and concatenate
 *  Given two strings s1 and s2. Modify both the strings such that all the common characters of s1 and s2 are to be removed and the uncommon characters of s1 and s2 are to be concatenated.
 *  Note: If all characters are removed print -1.
 * 
 * Problem #3 : String to sum of numbers in string 
 * Given a string str containing alphanumeric characters. The task is to calculate the sum of all the numbers present in the string
 * 
 * Given a number 'N'. The task is to find the Nth number whose each digit is a prime number i.e 2, 3, 5, 7. 
 * In other words you have to find nth number of this sequence : 2, 3, 5, 7, 22, 23 ,.. and so on.Problem #4: Nth number made of prime digits 
 * 
 * 
 * @author shree
 *
 */
public class String04_sums_med {

	public static void main(String[] args) {
		// sums 
		String S = "i.like.this.program.very.much";
		String anS=reverseWords(S);
       System.out.println(" ans is "+anS);
       
       String a="aacdb";
       String b="gadf";
     
       anS=concatenatedString(a,b);
       System.out.println(" Concated string is "+anS);
       
       String num="abcd234gf21oaidjidh";
       System.out.println(" Find sum "+ findSum(num));
      
       int enth=10;
       int ani=primeDigits(enth);
       System.out.println(enth+" Nth prime digit for is "+ani);
	}
	
	 private static int primeDigits(int n)
	    {
	        // 2  3  5  7 
		    //22 23 25 27 
		   //32 33 35 37 
		    // 52 53 55 57 
		 // 72 73 75 77
		   // 222 223 225 227 
		 // 232 233 235 237 
		 // 2272 2273 2275 2277 
	        // 10 10/2= 3 + 3
	        // 9 = 9/2 = 3 + 1
		 // 21 - 5 + 1 
		 //   1 + 1 +  1 
		 //25 - 6 + 1 
		   // 1 + 2 + 1
		 // 
		 // 53 - 13 + 1 
		   //   3 + 1 + 1 
		 //   5 2 2 
		 //100 - 25+ 0 
		 //    
		 
		 
		 StringBuffer s= new StringBuffer();
	        int val=0;
	        while(n>0){
	            val=n%4;
	            s.append(GetVal(val));
	          //   System.out.println(" Value "+s+" N is "+n);
	            n=n-val;
	            if(val==0){
	                n=n-1;
	            }
	            n=n/4;
	        }
	     //   s.append(n);
	       // System.out.println(" Value "+s+" N is "+n);
	        return Integer.parseInt(s.reverse().toString());
	    }
	    
	    public static String GetVal(int n){
	        if(n==1){
	            return "2";
	        }
	        else if(n==2){
	            return "3";
	        }
	        else if(n==3){
	            return "5";
	        }
	        else{
	            return "7";
	        }
	       // return "";
	    }
	 
	  public static int primeDigitsGoG(int n)
	    {
	        //Your code here
	        StringBuilder sb = new StringBuilder();
	        
	        while(n>0){
	            int a = n%4;
	            switch (a) {
	                case 1:
	                    sb.append(2);
	                    n=n/4;
	                    break;
	                case 2:
	                    sb.append(3);
	                    n=n/4;
	                    break;
	                case 3:
	                    sb.append(5);
	                    n=n/4;
	                    break;
	                case 0:
	                    sb.append(7);
	                    n=n/4;
	                    n=n-1;
	                    break;
	            }
	            
	        }
	        sb.reverse();
	        return Integer.parseInt(sb.toString());
	    }
	    
	  
	private static long findSum(String str)
    {
        // your code here
        int n=str.length();
        int sum=0; String prevnum="0";  boolean prevnumb=true;char c;
        for(int i=0;i<n;i++){
            c=str.charAt(i);
            if(c>=48 && c<=57){
              //   System.out.println(" Boolean "+prevnumb+" Value "+prevnum +" sum "+sum);
                if(prevnumb){
                    prevnum=prevnum+c;
                }
                else{
                    sum=sum+Integer.parseInt(prevnum);
                    prevnum=String.valueOf(c);
                   
                }
                prevnumb=true;
                
            }
            else{
                prevnumb=false;
            }
           // System.out.println(" Boolean "+prevnumb+" Value "+prevnum +" sum "+sum);
        }
        sum=sum+Integer.parseInt(prevnum);
        return sum;
    }
	
	private static String concatenatedString(String s1,String s2)
    {
        // Your code here
		 HashSet<Character> hs= new HashSet<>();
	        HashSet<Character> hs2= new HashSet<>();
	        StringBuffer sb=new StringBuffer();
	        int n=s1.length();
	        int m=s2.length();
	        for(int i=0;i<n;i++){
	            hs.add(s1.charAt(i));
	        }
	        char c;
	        for(int i=0;i<m;i++){
	            c=s2.charAt(i);
	          //  if(hs.contains(c)){
	          hs2.add(c);//}
	         // hs.add(c);
	        }
	        
	        
	        Iterator<Character> itr=(hs.iterator());
	        while(itr.hasNext()) {
	        	c=itr.next();
	        	if(hs2.contains(c)) {
	        		itr.remove();
	        		hs2.remove(c);
	        	}
	        
	        }
	        
	    // System.out.println(" Hash set "+hs.toString());
	      //  System.out.println(" Hash set 2 "+hs2.toString());
	        if(hs.size()==0 && hs2.size()==0){
	            
	            return "-1";
	        }
	         for(int i=0;i<n;i++){
	            c=s1.charAt(i);
	            if(hs.contains(c)){
	                sb.append(c);
	            }
	        }
	       
	        for(int i=0;i<m;i++){
	            c=s2.charAt(i);
	         if(hs2.contains(c)){
	                sb.append(c);
	            }
	        }
	       
	        return sb.toString();
    }
	
	private static String reverseWords(String S)
    {
        // code here 
        int n=S.length();
        StringBuffer sb=new StringBuffer();
        int start=n;String s=" ";
        for(int i=n-1;i>=0;i--){
            System.out.println(" I is "+i+" Char "+S.charAt(i));
            if(S.charAt(i)=='.'){
            	//sb.append('.');
                s=(S.substring(i+1,start))+'.';
               // sb.append('.');
                sb=sb.append(s);
                start=i;
            }
            else if(i==0) {
            	s=(S.substring(i,start));
                // sb.append('.');
                 sb=sb.append(s);
            }
            System.out.println(" S is "+s);
            System.out.println(" Sb is "+sb);
        }
      //  sb=sb.append(s);
        return sb.toString();
    }

}

/**
everse words in a given string

Reverse words in a given string

Let the input string be “i like this program very much”. The function should change the string to “much very program this like i”

reverse-words

 

Examples: 

Input: s = “geeks quiz practice code” 

// Java program to
// reverse a String
import java.util.*;
class GFG {

	// Reverse the letters
	// of the word
	static void reverse(char str[], int start, int end)
	{
		// Temporary variable
		// to store character
		char temp;

		while (start <= end) {
			// Swapping the first
			// and last character
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	// Function to reverse words
	static char[] reverseWords(char[] s)
	{
		// Reversing individual words as
		// explained in the first step

		int start = 0;
		for (int end = 0; end < s.length; end++) {
			// If we see a space, we
			// reverse the previous
			// word (word between
			// the indexes start and end-1
			// i.e., s[start..end-1]
			if (s[end] == ' ') {
				reverse(s, start, end);
				start = end + 1;
			}
		}

		// Reverse the last word
		reverse(s, start, s.length - 1);

		// Reverse the entire String
		reverse(s, 0, s.length - 1);
		return s;
	}

	// Driver Code
	public static void main(String[] args)
	{
		String s = "i like this program very much ";

		// Function call
		char[] p = reverseWords(s.toCharArray());
		System.out.print(p);
	}
}

// This code is contributed by gauravrajput1

Output: s = “code practice quiz geeks”

 

 

Algorithm:  

Initially, reverse the individual words of the given string one by one, for the above example, after reversing individual words the string should be “i ekil siht margorp yrev hcum”.
Reverse the whole string from start to end to get the desired output “much very program this like i” in the above example.
Below is the implementation of the above approach: 

// Java program to
// reverse a String
import java.util.*;
class GFG {

	// Reverse the letters
	// of the word
	static void reverse(char str[], int start, int end)
	{
		// Temporary variable
		// to store character
		char temp;

		while (start <= end) {
			// Swapping the first
			// and last character
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	// Function to reverse words
	static char[] reverseWords(char[] s)
	{
		// Reversing individual words as
		// explained in the first step

		int start = 0;
		for (int end = 0; end < s.length; end++) {
			// If we see a space, we
			// reverse the previous
			// word (word between
			// the indexes start and end-1
			// i.e., s[start..end-1]
			if (s[end] == ' ') {
				reverse(s, start, end);
				start = end + 1;
			}
		}

		// Reverse the last word
		reverse(s, start, s.length - 1);

		// Reverse the entire String
		reverse(s, 0, s.length - 1);
		return s;
	}

	// Driver Code
	public static void main(String[] args)
	{
		String s = "i like this program very much ";

		// Function call
		char[] p = reverseWords(s.toCharArray());
		System.out.print(p);
	}
}

// This code is contributed by gauravrajput1
 

Time complexity: O(N)
Auxiliary Space: O(N)

**/