package string_code;

import java.util.ArrayList;

/**
 * Pattern searching 
 * For text n "abcdefabc"
 * Pattern m "ab"  , 1<=m<=n
 * 
 * 1) Naive Method 
 *    No pre processing 
 *    O ( n+m+1)*m Time 
 *   All char in patter are distinct : O n 
 *    
 * 2) Rabin Karp 
 *     Use rolling hash 
 *     Pre process pattern 
 *     Matches has func and not the char 
 *      O ( n+m+1)*m Time 
 *      Better than naive in average 
 *      O n space
 * 
 * 3) KMP algorithm
 *      Linear time 
 *      Precompute LPS array of length pattern 
 *      
 *      Most popular 
 *      Time O n 
 *      
 * 
 * 4) Suffix tree :--> TRie 
 *      Pre process text
 *      Data Structure      
 *      O (m)
 *      
 * 5) Other algo 
 *     Boyer Algorithm 
 *     Z algorithm 
 *     
 * 
 * 
 * @author shree
 *
 */

public class String05_PatternSearch {

	public static void main(String[] args) {
		/*
		 * NAIVE PATTERN SEARCHING 
		 * 
		 * Loop over the string 
		 *    Have a window of the length of pattern 
		 *    Check if pattern== window created 
		 * 
		 */

		String str="ABCDEFGHIJABCDABCDCDDABCD";
		String pattern="D";
		ArrayList<Integer> ans=NaivePatternSearch(str,pattern);
		System.out.println(" Matched "+ans.toString());
		
		/*
		 * IMPROVED NAIVE PATTERN SEARCHING 
		 *  ---- FOR DISTINCT CHARACTERS in pattern 
		 *  
		 * Loop over the string 
		 *    Have a window of the length of pattern 
		 *    Check if pattern== window created 
		 * 
		 */
		
		String text="ABCDEFGHIJKLEFGMNOPEFG";
		String distinct="EFG";//DISTINCT CHARACTER 
		ans=PatternSearchDistinct(distinct,text);
		System.out.println(" Improvised search distinct "+ans.toString());
	
	}

	private static ArrayList<Integer> PatternSearchDistinct(String distinct_pattern, String str) {
		// Improvised pattern search for distinct pattern
		// Slinding window 
		
				ArrayList<Integer> ans=new ArrayList<>();
				int n=str.length();
				int m=distinct_pattern.length(); int d=1;
				String substr; int count=0;
				//Loop runs for n-m+1 time 
				for(int i=0;i<=n-m;i++) {
					//Substring is O(m) time 
					//As the pattern is unique character 
					// AAA 
					// AAAAA - 3 patterns 
					// But unique char - ABC 
					//ABCABCABC 
					//Three pattern 
					//But patter does not form in between the window 
					
					if(str.charAt(i)==distinct_pattern.charAt(0)) {
						count=i+1;
						while(d<m && str.charAt(count)==distinct_pattern.charAt(d)) {
							count++;
							d++;
						}
						System.out.println(" count "+count+" I is "+i+" M-1"+(m-1));
						if(count-i==m) {
							ans.add(i);
							i=count;
							d=1;
						}
						else {
							i=count;
							d=1;
						}
					}
					
				}
				
				//Time O (n)
				return ans;
		
	}

	private static ArrayList<Integer> NaivePatternSearch(String str, String pattern) {
		// Slinding window 
		
		ArrayList<Integer> ans=new ArrayList<>();
		int n=str.length();
		int m=pattern.length();
		String substr;
		//Loop runs for n-m+1 time 
		for(int i=0;i<=n-m;i++) {
			//Substring is O(m) time 
			substr=str.substring(i, i+m);
			if(substr.equals(pattern)) {
				//Checking constant O 1 time 
				ans.add(i);
			}
		}
		
		//Time O (n+m-1)* m 
		return ans;
	}

}

/**
 * 
 * Naive Pattern Searching Algorithm

Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.

Examples:
Input:  txt[] = "THIS IS A TEST TEXT"
        pat[] = "TEST"
Output: Pattern found at index 10

Input:  txt[] =  "AABAACAADAABAABA"
        pat[] =  "AABA"
Output: Pattern found at index 0
        Pattern found at index 9
        Pattern found at index 12
pattern-searching


Pattern searching is an important problem in computer science. When we do search for a string in notepad/word file or browser or database, pattern searching algorithms are used to show the search results.

Naive Pattern Searching: The idea is to slide the pattern over text one by one and check for a match. If a match is found, then slides by 1 again to check for subsequent matches.

That is check for the match of the first character of the pattern in the string, if it matches then check for the subsequent characters of the pattern with the respective characters of the string. If a mismatch is found then move forward in the string.

Below is the implementation of the above approach:

// Java program for Naive Pattern Searching
public class NaiveSearch {

    public static void search(String txt, String pat)
    {
        int M = pat.length();
        int N = txt.length();

        /* A loop to slide pat one by one 
        for (int i = 0; i <= N - M; i++) {

            int j;

            /* For current index i, check for pattern 
            //  match 
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                System.out.println("Pattern found at index " + i);
        }
    }

    public static void main(String[] args)
    {
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        search(txt, pat);
    }
}

Output:
Pattern found at index 0 
Pattern found at index 9 
Pattern found at index 13 



What is the best case?
The best case occurs when the first character of the pattern is not present in text at all.

txt[] = "AABCCAADDEE";
pat[] = "FAA";
The number of comparisons in best case is O(n).

What is the worst case ?
The worst case of Naive Pattern Searching occurs in following scenarios.
When all characters of the text and pattern are same.

txt[] = "AAAAAAAAAAAAAAAAAA";
pat[] = "AAAAA";
Worst case also occurs when only the last character is different.

txt[] = "AAAAAAAAAAAAAAAAAB";
pat[] = "AAAAB";


The number of comparisons in the worst case is O(m*(n-m+1)). Although strings which have repeated characters are not likely to appear in English text, they may well occur in other applications (for example, in binary texts). The KMP matching algorithm improves the worst case to O(n). We will be covering KMP in the next post. Also, we will be writing more posts to cover all pattern searching algorithms and data structures.

 * 
 * 
 */
