package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Words from phone number 
 * 
 * Given a keypad as shown in the diagram, and an N digit number
 * which is represented by array a[ ], 
 * the task is to list all words which are possible by
 * pressing these numbers.
 * 
 * 
 * Example 1:

Input: N = 3, a[] = {2, 3, 4}
Output:
adg adh adi aeg aeh aei afg afh afi 
bdg bdh bdi beg beh bei bfg bfh bfi 
cdg cdh cdi ceg ceh cei cfg cfh cfi 
Explanation: When we press 2,3,4 then 
adg, adh, adi, ... cfi are the list of 
possible words.
Example 2:

Input: N = 3, a[] = {3, 4, 5}
Output:
dgj dgk dgl dhj dhk dhl dij dik dil 
egj egk egl ehj ehk ehl eij eik eil 
fgj fgk fgl fhj fhk fhl fij fik fil
Explanation: When we press 3,4,5 then 
dgj, dgk, dgl, ... fil are the list of 
possible words.
Your Task:
You don't need to read input or print anything. You just need to complete the function possibleWords() that takes an array a[ ] and N as input parameters and returns an array of all the possible words in lexicographical increasing order. 

Expected Time Complexity: O(4N * N).
Expected Auxiliary Space: O(N).
 * 
 * @author shree
 *
 */
public class R08_Possible_words_from_phone {

	public static void main(String[] args) {
		// button number - char 
		
		int num[]= {8,7,5,4,5,6,1,0,5,5};
		ArrayList <String>  ans=possibleWords(num,num.length);
		System.out.println(" For number "+Arrays.toString(num));
		System.out.println(" Possible value "+ans.toString());

	}
	
	public static ArrayList <String> possibleWords(int a[], int N)
	    {
	        // your code here  
	        ArrayList <String> ans=new ArrayList <String>();
	        PossibleWords(ans,a,"",0,N);
	        return ans;
	    }
	    
	    public static void PossibleWords( ArrayList <String> ans,int a[], String curr,int id,int n)
	    {
	        if(id==n){
	            if(curr.length()>0){
	            ans.add(curr);
	            }
	            return;
	        }
	        
	        int recur=3;
	        if(a[id]==9 || a[id]==7){
	            recur=4;
	        }
	        
	        String ab=null;
	        for(int i=0;i<recur;i++){
	            ab=GetString(a[id],i);
	            PossibleWords(ans,a,curr+ab,id+1,n);
	        }
	        
	    }
	    
	    public static String GetString(int n,int s){
	        char num=0;
	        if(n==1){
	            num=' ';
	        }
	        else if(n<=7){
	            num=(char)('a'+(n-2)*3+s);
	        }
	        else if(n==8){
	            num=(char)('t'+s);
	        }
	        else if(n==9){
	            num=(char)('w'+s);
	        }
	        return Character.toString(num);
	    }
	    //a 97 , w 119 

}
