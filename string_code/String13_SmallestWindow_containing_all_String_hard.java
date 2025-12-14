package string_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Smallest window in a string containing all the characters of another string
 * Given two strings S and P.
 *  Find the smallest window in the string S consisting of all the characters(including duplicates)
 *   of the string P. 
 *   
 *    Return "-1" in case there is no such window present.
 *    
 *     In case there are multiple such windows of same length,
 *      return the one with the least starting index
 * Note : All characters are in Lowercase alphabets. 
 * 
 * @author shree
 *
 */
public class String13_SmallestWindow_containing_all_String_hard {

	public static void main(String[] args) {
		String text="geeksffforgeekfhfjggjggeeksfoorgeekeiyugkjtgeekaaasforgeekyrrfhjfebksforgeekszirforgeek";
		String patt="geeksforgeek";
		
		String ans="";
		//ans=smallestWindow(text, patt);
		//System.out.println(" Ans is =================="+ans);
		
		ans=smallestWindowArray(text, patt);
		System.out.println(" Ans is ......"+ans);

	}

	 private static String smallestWindow(String s, String p) {
		 
		int n=s.length();
		int m=p.length();
		System.out.println(" N "+n);
		if(n<m) {
			return "-1";
		}
		
		if(n==m) {
			
		if( s.equals(p)) {
			return p;
		}
		else {
			return "-1";
		}
		}
		//==================For 1 CHAR 
		if(m==1) {
		    char pat=p.charAt(0);
			for(int i=0;i<n;i++) {
				if(s.charAt(i)==pat) {
					return p;
				}
			}
			return "-1";
		}
		
		//==================================CODE========================================
		
		
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>(256);
		HashMap<Character,Integer> hp=new HashMap<Character,Integer>(256);
		 //
		//hm.put('&',-10);
		
		// We stop when hp===hm , to check use a method - CheckEqual
		// Check for first m char in text 
		  char c;char cp;int val=0;
		  int counter=m;
	      for(int i=0;i<m;i++){
	             c=s.charAt(i);cp=p.charAt(i);
	              if(hm.containsKey(c)){
	                  val=hm.get(c)+1;
	              }
	              else{
	                  val=1;
	              }
	             hm.put(c,val);
	             if(hp.containsKey(cp)){
	                  val=hp.get(cp)+1;
	              }
	              else{
	                  val=1;
	              }
	             hp.put(cp,val);
	         }
	      //for(int i=0;i<m;i++){
	    	  for(Map.Entry<Character,Integer> en : hm.entrySet()){
		             c=en.getKey();
		              
		              if(hp.containsKey(c)){
		            	
		                  counter=counter-en.getValue();
		                  //j=j+val;
		              }
		              System.out.println(" Counter at M "+counter+" char "+c+" val "+val);
		       }
	      System.out.println(" HM is "+hm.toString());
	      System.out.println(" HP is "+hp.toString());
	      System.out.println(" Counter at M "+counter);
	      String ans_Str="";int ans_len=-1;int start=0;
	         if(counter==0 && CheckEqual(hm,hp)){
	        	 System.out.println(" First .....");
	             ans_Str=p;
	            ans_len=m;
	            return p;
//	            // Possible smallest and first in window return 
	         }
	         
	         char cs;int currlen=0;String currStr=""; cs=s.charAt(start);
	         for(int i=m;i<n;i++) {
	        	 
	        	
	        	 
	        	// ====================================Add the current char
	        	 c=s.charAt(i);
	        	 if(hm.containsKey(c)) {
	        		 val=hm.get(c);
	        		 hm.put(c,val+1);
	        	 }
	        	 else {
	        		 hm.put(c,1);
	        	 }
	        	 
	        	
		          //  return p;
		            // Possible smallest and first in window return 
		              
	        	
	        	 //===============================DELETE UNUSED 
		        	System.out.println(" Substring in i "+s.substring(start,i+1));
	        	 while(start<i &&( (!hp.containsKey(cs))|| ( hp.get(cs)<hm.get(cs)) )) {
	        		 // Delete or reduce the count if the element is not needed 
	        		 val=hm.get(cs);
	        		 if(val==1 ) {
	        			 hm.remove(cs);
	        		 }
	        		 else {
	        			 hm.put(cs,val-1);
	        		 }
	        		 
	        		  if(hp.containsKey(cs)){
		            	  counter=counter+1;
		              }
	        		 start++;
	        		 cs=s.charAt(start);
	        	 }
	        	 
	        	 System.out.println(" Counter after deletion "+counter);
	        	  if(hp.containsKey(c)){
	            	  counter=counter-1;
	              }
	        	  System.out.println(" Counter after Additionn "+counter);
	        	// =====================================Check if val found 
	        	  
	        	// System.out.println(" HM at i "+i+" is ..."+hm.toString()+" curr cs "+cs);
	        	 currlen=i-start+1;
	        	 if(counter<=0 && (currlen<ans_len|| ans_len==-1) && CheckEqual(hm,hp) ){
	        		 if(currlen==m) {// Found at starting 
	        			 return p;
	        		 }
	        	
	        		
	        		 currStr=s.substring(start,i+1);
		              ans_len=currlen;
		            	  ans_Str=currStr;
		              
	        	 }
	        	 
		         
	         }
	        //============================LAST 
	         //===============================DELETE UNUSED 
	        	
//        	 while((!hp.containsKey(cs))|| ( hp.get(cs)<hm.get(cs)) ) {
//        		 // Delete or reduce the count if the element is not needed 
//        		 val=hm.get(cs);
//        		 if(val==1 ) {
//        			 hm.remove(cs);
//        		 }
//        		 else {
//        			 hm.put(cs,val-1);
//        		 }
//        		 start++;
//        		 cs=s.charAt(start);
//        	 }
//        	 
//        	// =====================================Check if val found 
//        	 System.out.println(" HM at i "+n+" is ..."+hm.toString()+" curr cs "+cs);
//        	 if( CheckEqual(hm,hp) ){
//        		 currlen=n-start;
//        		 if(currlen==m) {// Found at starting 
//        			 return p;
//        		 }
//        	
//        		
//        		 currStr=s.substring(start,n);
//	              System.out.println(" Curr string "+currStr);
//	              if(currlen<ans_len|| ans_len==-1) {
//	            	  ans_len=currlen;
//	            	  ans_Str=currStr;
//	              }
//        	 }
	    
	         if(ans_len!=-1) {
	        	 return ans_Str;
	         }
		 
		 
		return "-1";
		 
		 
	 }
	 
	 static private boolean CheckEqual(HashMap<Character,Integer> s, HashMap<Character,Integer> p){
	        int val=0;
	        System.out.println(" Equal called .........");
	        for(Map.Entry<Character,Integer> en : p.entrySet()){
	            
	            if(s.containsKey(en.getKey())){
	                val=s.get(en.getKey());
	                if(val!=en.getValue()){
	                    return false;
	                }
	            }
	            else{
	                return false;
	            }
	        }
	        return true;
	    }



private static String smallestWindowArray(String s, String p) {
	 
	int n=s.length();
	int m=p.length();
	System.out.println(" N "+n);
	if(n<m) {
		return "-1";
	}
	
	if(n==m) {
		
	if( s.equals(p)) {
		return p;
	}
	else {
		return "-1";
	}
	}
	//==================For 1 CHAR 
	if(m==1) {
	    char pat=p.charAt(0);
		for(int i=0;i<n;i++) {
			if(s.charAt(i)==pat) {
				return p;
			}
		}
		return "-1";
	}
	
	//==================================CODE========================================
	
	
	int[] hm=new int[256];
	int[] hp=new int[256];
	 //
	//hm.put('&',-10);
	
	// We stop when hp===hm , to check use a method - CheckEqual
	// Check for first m char in text 
	  char c;char cp;int val=0;
	  int counter=m;
     for(int i=0;i<m;i++){
          //  c=s.charAt(i);
    	 cp=p.charAt(i);
           //  hm[c]++;
             hp[cp]++; 
        }
    if(	CheckArrayEqual(hm,hp)) {
    	return p;
    }
    // System.out.println(" HM is "+Arrays.toString(hm));
     //System.out.println(" HP is "+Arrays.toString(hp));
     //System.out.println(" Counter at M "+counter);
     String ans_Str="";int ans_len=-1;int start=0;
       
        
        char cs;int currlen=0;String currStr=""; cs=s.charAt(start);
        for(int i=0;i<n;i++) {
       	 
       	
       	 System.out.println(" I is ..................................."+i+ " ...val "+s.substring(start,i+1));
       	// ====================================Add the current char
       	 c=s.charAt(i);
         hm[c]++;
         
		 
       	
	          //  return p;
	            // Possible smallest and first in window return 
	              
      	        	 //===============================DELETE UNUSED 
	        	
       	 while((hp[cs]==0)||(hm[cs]>hp[cs]) ){
       		 // Delete or reduce the count if the element is not needed 

           	 if(hp[cs]!=0) {
           		 counter++;
           	 }
       		 hm[cs]--;
       		System.out.println(" Substring delete "+start+" val "+cs+ "is -"+s.substring(start,i+1));
       	 	//System.out.println(" Counter after Deleteion ");
       		 start++;
       		 cs=s.charAt(start);
       	 }
       	System.out.println(" Counter after Addituin "+counter);
     	  System.out.println(" Array HM ........");PrintArray(hm);
       	 if(hp[c]!=0) {
       		 counter--;
       	 }
       	System.out.println(" Substring final i...."+i+"==="+s.substring(start,i+1));
      

       	// =====================================Check if val found 
       	
       	 currlen=i-start+1;
       	 System.out.println(" HM atlenb " +currlen);
       	 System.out.println(" Array len ans "+ans_len);
       	 System.out.println(" Array equal value "+CheckArrayEqual(hm, hp));
       	 System.out.println("For attayy "+s.substring(start,i+1));
       	 if(counter<=0 && (currlen<ans_len|| ans_len==-1) && (CheckArrayEqual(hm,hp)) ){
       		
       		
       		 currStr=s.substring(start,i+1);
       		 if(currlen==m) {// Found at starting 
       			 return currStr;
       		 }
       	
	              ans_len=currlen;
	            	  ans_Str=currStr;
	              
       	 }
       	 
	         
        }
   
        if(ans_len!=-1) {
       	 return ans_Str;
        }
	 
	 
	return "-1";
	 
}

private static void PrintArray(int[] hm) {
	//print 
	char c;
	for(int i=0;i<256;i++) {
		if(hm[i]!=0) {
			c=(char) i;
			System.out.print(c+"="+hm[i]+"  ");
		}
	}
	System.out.println();
	//return null;
}

private static boolean CheckArrayEqual(int[] hm, int[] hp) {
	// Arraycheck
	for(int i=0;i<256;i++) {
		if(hp[i]!=0 && hp[i]>hm[i] ) {
			return false;
		}
	}
	return true;
}
}