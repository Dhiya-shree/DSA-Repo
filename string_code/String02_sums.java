package string_code;

import java.util.Arrays;

/**
 * Problem #1 : Subsequence or not 
 * Given two strings A and B, find if A is a subsequence of B. A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining element
 * 
 * Problem #2 : Maximum occring char 
 * Given a string str of lowercase alphabets.
 *  The task is to find the maximum occurring character in the string str. If more than one character occurs the maximum number of time then print the lexicographically smaller character.
 *  
 * Problem #3 : Anagram - same freq 
 * Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other.
 * Note:-
 * If the strings are anagrams you have to return True or else return False
 * 
 * |s| represents the length of string s.
 * 
 * Problem #4 : Isogram  - Every letter only once
 * 
 *  
 * Problem #5 : isomorphic string 
 * Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
 * If the characters in str1 can be changed to get str2, then two strings, str1 and str2, are isomorphic. A character must be completely swapped out for another character while maintaining the order of the characters. A character may map to itself, but no two characters may map to the same character
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class String02_sums {

	public static void main(String[] args) {
		// easy 
		
		String a="ABc";
		String b="AbCdefhGBikfharkfslhuwthgshdksudC";
		boolean anb=SubsequeneOrNot(a,b);
		System.out.println(" A subsequence of b is "+anb);
		
		String maxChar="testsample";
		char anc=getMaxOccuringChar(maxChar);
		System.out.println(" Maximum occuring is "+anc);
		
		String c = "geeksforgeeks", d = "forgeeksgeeks";
		anb=isAnagram(c,d);
		System.out.println(" Anagram of same frreq of char is "+anb);
		
		anb=isIsogram(maxChar);
		System.out.println(" isogram is "+anb);
		
		anb= areIsomorphic(c,d);
		System.out.println(" Isomorphic same mapping "+anb);
				

	}

	private static boolean areIsomorphic(String c,String d)
    {
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
		//	System.out.println(" I is "+i+" Array val "+array[val]+"  c char of val "+c.charAt(i)+"-"+val+" Need to map to val "+map+"-"+map_val);
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
	//	System.out.println(" Array bro "+Arrays.asList(array).toString());
		return true;
        
    }
	private  static boolean isIsogram(String a){
        int n=a.length();
   //    int m=b.length();
    
       int c; int tot[]=new int[26];
       for(int i=0;i<n;i++){
           c=a.charAt(i)-97;
           if(tot[c]==1){
               return false;
           }
           tot[c]=1;
       }
      return true;
   }
	 private static boolean isAnagram(String a,String b)
	    {
	        
	        // Your code here
	        int n=a.length();
	        int m=b.length();
	        if(n!=m){
	            return false;
	        }
	        if(n==1){
	            return a.equals(b);
	        }
	        int c;int d; int tot[]=new int[26];
	        for(int i=0;i<n;i++){
	            c=a.charAt(i)-97;
	            tot[c]=tot[c]+1;
	            d=b.charAt(i)-97;
	            tot[d]=tot[d]-1;
	            
	        }
	        int sum=0;
	           for(int i=0;i<26;i++){
	         //  System.out.println(" Tot "+tot[i]);
	               sum=sum+Math.abs(tot[i]);
	           }
	           if(sum==0){
	               return true;
	           }
	           else{
	               return false;
	           }
	        
	    }
	private static char getMaxOccuringChar(String line)
    {
        // Your code here
        int n=line.length();
        int arr[]=new int[26];
        int max=0;int val=0;char maxc=0;char ch;
        for(int i=0;i<n;i++){
            ch=line.charAt(i);
            val=ch-97;
            if(arr[val]=='\u0000'){
                arr[val]=1;
            }
            else{
                arr[val]=arr[val]+1;
            }
            
            if(arr[val]>max){
                max=arr[val];
                maxc=ch;
            }
            else if(arr[val]==max){
                if(maxc>ch){
                    maxc=ch;
                }
            }
        }
        return maxc;
    }
	 public static String caseSort(String str)
	    {
	        // Your code here
	        int n=str.length();
	        int arr[]=new int[n];
	        char low[] = null;int l=0;
	        char up[] = null;int u=0;char c;
	        for(int i=0;i<n;i++){
	            c=str.charAt(i);
	            if(c<97){
	                arr[i]=1;
	                up[u]=c;
	                u++;
	            }
	            else{
	                arr[i]=-1;
	                low[l]=c;
	                l++;
	            }
	        }
	        Arrays.sort(up,0,u);
	        Arrays.sort(low,0,l);
	        u=0;l=0;
	        StringBuilder st= new StringBuilder();
	         for(int i=0;i<n;i++){
	           if(arr[i]==1){
	               st.append(up[u]);
	               u++;
	           } 
	           else {
	        	   st.append(low[l]);
	               l++;
	           }
	         }
	         return st.toString();
	    }
	private static boolean SubsequeneOrNot(String a, String b) {
		//Case also considered 
		int n=a.length();
		int m=b.length();
		if(m<n) {
			return false;
		}
		if(m==n) {
			return (a.equals(b));
		}
		
		int count=0;
		char curr;
		System.out.println(" N is "+n+" M is "+m);
		for(int i=0;i<m;i++) {
			curr=a.charAt(count);
			if(b.charAt(i)==curr) {
				count++;			
			}
			System.out.println(" Count at i:"+i+" Is "+count+" char comp"+curr+" b char is "+b.charAt(i));
			if(count==n) {
				return true;
			}
		}
		return false;
	}

}
