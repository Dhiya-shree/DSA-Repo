package string_code;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem #1 : Case-specific Sorting of Strings Given a string S consisting of
 * only uppercase and lowercase characters. The task is to sort uppercase and
 * lowercase letters separately such that if the ith place in the original
 * string had an Uppercase character then it should not have a lowercase
 * character after being sorted and vice versa.
 * 
 * N = 12 S = defRTSersUXI Output: deeIRSfrsTUX Explanation: Sorted form of
 * given string with the same case of character as that in original string is
 * deeIRSfrsTUX
 *
 *
 *
 *
 *Problem #2 : Repeating Character - First Appearance Leftmost
 *
 *You are given a string S (both uppercase and lowercase characters). 
 *You need to print the repeated character whose first appearance is leftmost 2:
 *S = geeksforgeeks  Output: g
 *
 *Problem #3 : Non repeating character left most 
 *
 *
 *Problem #4 : Minimum indexed character
 *Given a string str and another string patt. Find the minimum index of the character in str that is also present in patt.
 *
 *str = geeksforgeeks   patt = set   Output: 1
 *
 *
 *Problem #5 : The Modified String
 *Ishaan is playing with strings these days. He has found a new string. He wants to modify it as per the following rules to make it valid:
 *The string should not have three consecutive same characters (Refer example for explanation).
 *He can add any number of characters anywhere in the string.
 *Find the minimum number of characters which Ishaan must insert in the string to make it valid.
 *
 *
 * @author shree
 *
 */
public class String03_sums_medium {

	public static void main(String[] args) {
		// Medium 
		
		String sor="defRTSersUXI";
		String ans=caseSort(sor);
		System.out.println(" case sorted value "+ans);

		String char_re="geeksforgeeks";
		int ani=repeatedCharacter(char_re);
		System.out.println(" value of repeating cgar is "+ani);
		
		char anc=NonRepeatingChar(char_re);
		System.out.println(" non repeating is "+anc);
		
		String str = "geeksforgeeks" ,patt = "set";
		ani=minIndexChar(str, patt);
		System.out.println(" minimum indexed char "+ani);
		
		String modi="aaaaaabbbccc";
		//ANS aa ' aa ' aa bb' b c'cc- to prreent three char 
		ani=modified(modi);
		System.out.println(" No of string to be inserted are "+ani);
	}
	
	 private static char NonRepeatingChar(String a) {
		// non repeating lefft most 
		 int n=a.length();
	     int min=0;
	     int tot[]=new int[256];
	     
	     
	     
	     
	     return '$';
	      
	}
	 
	 private static int modified(String a)
	    {
	        // Your code here
	        int n=a.length();
	        if(n<2){
	            return 0;
	        }
	       
	        int ans=0;
	        char prev=a.charAt(0);
	       char now;
	       int count=0;
	        for(int i=1;i<n;i++){
	            now=a.charAt(i);
	            if(now==prev){
	               count=count+1;
	                
	            }
	            else{
	                 // System.out.println("count "+ count+ " ans is "+ans);
	               if(count>=2){
	                   ans=ans+(count/2);
	                  // System.out.println("count "+ count+ " ans is "+ans);
	                  
	               }   
	                count=0;
	               prev=now;
	            
	            }
	            
	          //  System.out.println(" ans is "+ans);
	        //    System.out.println(" now "+now +" prev "+ prev +" prev-ptrev "+prevprev); 
	        }
	        //last check aaa aaa bbb ccc
	        if(count>=2){
	                   ans=ans+(count/2);
	                  // System.out.println("count "+ count+ " ans is "+ans);
	                  
	               }   
	        return ans;
	    }
	 private static int minIndexChar(String str, String patt)
	    {
	        // Your code here
	        int s=patt.length();
	        HashSet<Character> hs=new HashSet<>(s);
	        
	        for(int i=0;i<s;i++){
	            hs.add(patt.charAt(i));
	        }
	        
	        int n=str.length();
	        
	        for(int i=0;i<n;i++){
	            
	            if(hs.contains(str.charAt(i))){
	                return i;
	            }
	        }
	        return -1;
	    }

	private static int repeatedCharacter(String a)
	    {
	        int n=a.length();
	       int min=0;
	       boolean flg=true;
	        int c; int tot[]=new int[256];
	        for(int i=0;i<n;i++){
	            c=a.charAt(i);
	            if(tot[c]>0 && (min>tot[c] || flg) ){
	            min=tot[c];
	            flg=false;
	            }
	            tot[c]=i+1;
	        }
	        
	        if(flg){
	            return -1;
	        }
	       else{
	       return min-1;
	           
	       }
	        
	    }      
	        
	private static String caseSort(String str)
    {
        // Your code here
        int n=str.length();
        int arr[]=new int[n];
        char low[]=new char[n];int l=0;
        char up[]=new char[n];int u=0;char c;
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

}
