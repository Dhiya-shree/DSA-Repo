package string_code;

import java.util.HashMap;

public class String10__Anagram_Search {

	public static void main(String[] args) {
		// Search anagram in a string 
		// geeksforgeeks
		//Pattern frog 
		// Ans => true ; forg - anagram present in text 
		
		// Use char 256 as it may contain any char 
		
		String s="geeksforgeeks";
		String patt="frog";
		
		 int ans= CheckIfAnagramPresent(s,patt,s.length(),patt.length());
		 if(ans>=0) {
			 System.out.println("For "+patt+" String is Anagram  "+s.substring(ans, ans+patt.length()));
		 }
		 else {
			 System.out.println(" Not Anagram  ");
		 }

	}

	private static int CheckIfAnagramPresent(String s, String patt, int n, int m) {
		// Create an array of CHAR 256 
		// With ascii value add / delete if value present 
		
		HashMap<Integer,Integer> Ht=new HashMap<>(m);
		HashMap<Integer,Integer> Hp=new HashMap<>(m);
		int val=0;
		int c; int ct;
		System.out.println(" HP is "+Hp.toString());
		System.out.println(" HT is "+Ht.toString());
		for(int i=0;i<m;i++) {
			c=patt.charAt(i);
			ct=s.charAt(i);
			
			
			if(Hp.containsKey(c)) {
			val=Hp.get(c)+1;}
			else {
			  val=1;
			}
			
			Hp.put(c,val);
			
			if(Ht.containsKey(ct)) {
				val=Ht.get(ct)+1;}
				else {
				  val=1;
				}
				
				Ht.put(ct,val);
			//	System.out.println(" HP is "+Hp.toString());
				//System.out.println(" HT is "+Ht.toString());
		}
		
		if(Ht.equals(Hp)) {
			return 0;
		}
		
		System.out.println(" HP is "+Hp.toString());
		System.out.println(" HT is "+Ht.toString());
		int remove=0;
		for(int i=m;i<n;i++) {
			System.out.println(" Checking for ....."+s.substring(remove+1,i+1));
			// REMOVE the first val 
			
			ct=s.charAt(remove);
			System.out.println(" Ct "+ct+"...."+s.charAt(remove));
		    val=Ht.get(ct);
		    if(val==1) {
		    	Ht.remove(ct);
		    }
		    else {
		    	Ht.put(ct,val-1);
		    }
		    
		    //ADD THE LAST VALUE 
		    c=s.charAt(i);
		    if(Ht.containsKey(c)) {
				val=Ht.get(c)+1;}
				else {
				  val=1;
				}
				
	        Ht.put(c,val);
	        
	        // Compare HP and HT 
	        System.out.println(" HP is "+Hp.toString());
			System.out.println(" HT is "+Ht.toString());
	        if(Hp.equals(Ht)) {
	        	return i-m+1;
	        }
	        
	        remove++;
			
		}
		
		return -1;
		
	}

}
