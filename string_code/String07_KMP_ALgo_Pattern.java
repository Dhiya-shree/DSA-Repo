package string_code;

import java.util.Arrays;

/**
 * KMP ALgo 
 * 
 * Part 1 : Constructing LPS array Preprocessing array for pattern 
 * LPS - Longest proper prefix 
 *   Construct pefix  and suffix array 
 *   
 *   Pattern - "abc"
 *   
 *   Proper prefix :
 *     "","a","ab"
 *     "abc" is prefix 
 *     "abc" is not a proper prefix 
 *     length of proper prefix  < pattern 
 *   Suffix for "abc":
 *    "","c","bc","abc"
 * 
 * Need to find longest proper prefix which is suffix at every point :???
 * First entry :
 * LPS - array first entry always 0 
 * For pattern of string length 1-n , the only possible for 1 and must value for any n 
 *    is ZERO 0 
 * 
 * 
 * Second entry :
 * Second entry depends on second char 
 * If both are same character " aa" - entry 1 
 * " aa" , proper prefix - "","a" , Suufix -"","a","aa"
 *   Longest prefix- suffix : "a" len 1 
 * 
 * If both are diff character " ab" - entry 0 
 * " ab" , proper prefix - "","a" , Suffix - "","b","ab"
 *   Longest prefix suffix - "" len 0 
 * 
 * 
 * LPS for string s  
 * S = " ababc"
 * LPS =[0,0] first , second
 * ---->For aba 
 * Proper prefix - "","a","ab"
 * Suffix - "a","","ba","aba"
 * Same - "a" value len 1 
 * LPS = [0,0,1]
 * ---->For abab
 * Proper prefix - "","a","ab","aba"
 * Suffix - "b","","ab","bab","abab"
 * Same - "ab" value len 2 
 * LPS = [0,0,1,2]
 * ---->For ababc
 * Proper prefix - "","a","ab","aba","abab"
 * Suffix - "","c","bc","abc","babc"
 * Same - "" value len 0
 * LPS = [0,0,1,2,0]
 * 
 * 
 *
 * @author shree
 *
 */
public class String07_KMP_ALgo_Pattern {

	public static void main(String[] args) {
		//Construct LPS array for KMP algo 
		
		/*NAIVE 
		 * 
		 *  For len of n :
		 *     For each substring 
		 *     check if the string are same at beginning and end 
		 *         If beginning prefix == ending suffix 
		 *             return lengtn 
		 *      return 0 
		 */
		
		 String S="abcbabca";
		 int ans[]=FindLPSArray(S,S.length());
		 System.out.println(" Value of LPS "+Arrays.toString(ans));
		
		 /***
		  * EFFICIENT 
		  * 
		  * 
		  * Basic idea 
		  * 1) If we len length of lps array i-1 
		  *       if str[len] and str[i] same
		  *       Then lps[i]=len+1
		  *                                x=i-1
		  *   0 , 1, 2,....len-1,len,.....,....x(lps=len), i,..,...n
		  *   
		  *  A))==>     if str[len]==str[i]
		  *       then characters from 0 to len-1 
		  *       are same as len to i 
		  *       
		  *       lps[i]=len+1
		  *       
		  *       Prefix: 0 to len-1
		  *       Suffix : len to i 
		  *       
		  *  B))==>     if str[len] ! = str[i]
		  *         if str len not equal to str i 
		  *         
		  *       ==>  if len==0 
		  *          str[0] is not equal to str[i]
		  *             lps[i]=0
		  *          
		  *       ==> if len !=0 
		  *          REcursively apply lps[]
		  *          len=lps[len-1]
		  *          compare str[len] and str[i]
		  *          
		  *          
		  *       
		  *  
		  *       
		  *   As str[len] == str[i]
		  *   0 1 2 3 4 5 6 7 8 9 10
		  *   a a a b b a a a b b b
		  *   0 1 2 2 2 3 3 3
		  *   
		  *   For 5 : a
		  *   len=lps[4]=2
		  *   str[2]==str[5]==a==a
		  *   This means 0 to 2 equal char as 3 to 5 
		  *   a a a |  b b a
		  *   lps[i]=len+1= 3 
		  *   
		  *   For 6 : a 
		  *   len=lps[5]=3
		  *   str[3] == str[6] -> b!=a
		  *      len!=0 
		  *    len=lps[len-1]=lps[2]= 2
		  *    
		  *    str[2]==str[6]
		  *       lps[6]= len+1=2+1=3
		  *       
		  * For 7 : a 
		  *    len=lps[6]=3
		  *    
		  *    str[3]!=str[7]
		  *    and len not 0
		  *    
		  *    Thus recursion 
		  *       len=lps[len-1]=lps[2]=2
		  *       
		  *       str[2]==str[7]
		  *       lps[7]=2+1=3
		  *       
		  *   
		  * ------------------------------
		  *           0 1 2 3 4 5 6 7
		  *   For str a b c b a b c a
		  *       lps 0 0 0 0 1 2 3 0
		  *   
		  *   For 4 : a 
		  *   len=0
		  *   str[0]==str[4]
		  *   lps[4]=1
		  *   
		  *   For 5: b 
		  *   len=1
		  *   str[1]==str[5]
		  *   lps[5]=2
		  *   
		  *   For 6: c
		  *   len=2
		  *   At this point ...................len =2
		  *   0 to len == len to i 
		  *   a b c == b a b c
		  *   str[2]==str[6]
		  *   lps[6]=3 
		  *   
		  *  For 7 :  a 
		  *  len=3
		  *  str[3]==str[7]NO 
		  *  
		  *  Recursive start 
		  *    len=lps[len-1]= lps[2]=0 
		  *    len=0 thus lps[7]=0
		  * 
		  * 
		  * 
		  */
		 ans=FindLPSArrayEfficient(S,S.length());
		 System.out.println(" Value of LPS "+Arrays.toString(ans));
		/*
		 * 
		 * Condt :
		 * 
		 * if str[len]==str[i]
		 *     lps[i]=len+1;
		 *     
		 * if str[len]!= str[i]
		 *     if len==0  then lps[i]=0;
		 *     
		 *     if len>0 then 
		 *        len=lps[len-1]
		 *        loop recursively with changed len 
		 * 
		 */
		 int lps[]=new int[S.length()];
		 fillLPSGoG(S,lps);
		 System.out.println(" Value of LPS "+Arrays.toString(lps));
		 
	}

	 private static void fillLPSGoG(String str, int lps[]){
	        int n=str.length(),len=0;
	        lps[0]=0;
	        int i=1;
	        while(i<n){
	            if(str.charAt(i)==str.charAt(len))
	            {len++;lps[i]=len;i++;}
	            else
	            {if(len==0){lps[i]=0;i++;}
	                else{len=lps[len-1];}
	            }
	        }
	    }
	private static int[] FindLPSArrayEfficient(String s, int n) {
		// KMP LPS Algo
		
		int len=0;//start 
		int i=1; 
		int lps[]=new int[n];
		char str[]=s.toCharArray();
		
		//All char same Time : O n 
		// All char diff Time : O n 
		// Some matching : O  2 n work 
		while(i<n) {//Loops till all lps array fills 
			System.out.print(" comparing .....");
			System.out.println(s.substring(0, len)+"======"+s.substring(len,i+1));
			//Case 1 char match 
			if(str[i]==str[len]) {
				 len=len+1;//same as curr lps[i]
			    lps[i]=len;
			    // Update i and len as lps[i-1] that is current value 
			   
			    i++;
			}
			
			//Case 2 
			else {
				
				//Case A set lps as 0 
				if(len==0) {
					lps[i]=0;
					i++;
					//No need to update len as len already 0 as lps[i] current 
				}
				//Case B set len as lps[len-1]
				else{
					
					len=lps[len-1];
				}
			}
		}
		
		return lps;
	}

	private static int[] FindLPSArray(String s, int n) {
		//For each len loop 
		int ans[]=new int[n];
		for(int i=0;i<n;i++) {
			ans[i]=FindForSubstring(s,i+1);
		}
		return ans;
	}

	private static int FindForSubstring(String s, int n) {
		// Chec begin and end of each substring 
		boolean flg=true;
		//int length=s.length();
		char a;
		char b;
		//N - length of substring , for wich prefix and suffix needs to be found 
		for(int i=n-1;i>0;i--) {// For abcd - abcd is not a proper prefix 
			System.out.println(" Suffix-------------- "+s.substring(0,i));
			System.out.println(" Prefix is reverse of"+s.substring(0,i));
			
			flg=true;//sint num=0;
			for(int j=0;j<i;j++) {
				a=s.charAt(i);
				b=s.charAt(n-i+j);
				if(a!=b) {
					System.out.println(" check for char1 "+a+" cchar2 "+b);
				    flg=false;
				    
				    
				}
	
			}
			//As we check for back to front 
			//We get maximum first ..0 at end 
			System.out.println(" After check flg is "+flg);
			if(flg) {
				//System.out.println(" Same suffix - prefix "+);
				System.out.println(" Returning  .....>>>>>>>>>>>>>>>>>>>>>>"+i);
				return i;
			}
			
		}
		System.out.println(" REturning 0 .......");
		return 0;
	}
}
