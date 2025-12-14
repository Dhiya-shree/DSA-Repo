package hashing_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import arrayCode.ArrayPart01;

/**
 * Account Merge
 * 
 * Given a list of accounts where each element accounts { i } is a list of
 * strings, where the first element account { i }{ 0 } is a name, and the rest
 * of the elements are emails representing emails of the account. Now, we would
 * like to merge these accounts. Two accounts definitely belong to the same
 * person if there is some common email to both accounts. Note that even if two
 * accounts have the same name, they may belong to different people as people
 * could have the same name. A person can have any number of accounts initially,
 * but all of their accounts definitely have the same name. After merging the
 * accounts, return the accounts in the following format: the first element of
 * each account is the name, and the rest of the elements are emails in sorted
 * order.
 * 
 * Note: Accounts themselves can be returned in any order.
 * 
 * Input:
N = 4
accounts { } =
{{"John","johnsmith@mail.com","john_newyork@mail.com"},
{"John","johnsmith@mail.com","john00@mail.com"},
{"Mary","mary@mail.com"},
{"John","johnnybravo@mail.com"}}
Output:
{{"John","john00@mail.com","john_newyork@mail.com", "johnsmith@mail.com"},
{"Mary","mary@mail.com"},
{"John","johnnybravo@mail.com"}}
Explanation:
The first and second John's are the same person as
they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none
of their email addresses are used by other accounts.
We could return these arrays in any order, for example,
the answer {{'Mary', 'mary@mail.com'},
{'John', 'johnnybravo@mail.com'},
{'John', 'john00@mail.com', 'john_newyork@mail.com',
'johnsmith@mail.com'}}
would still be accepted.
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Hashing98_HArd_AccountMerge {

	public static void main(String[] args) {
		//Account merge 
		List<List<String>> accounts= new ArrayList<>();
		List<String> l1= new ArrayList<>();
		l1.add("John");l1.add("johnsmith@mail.com");l1.add("john_newyork@mail.com"); 
		
		List<String> l2= new ArrayList<>();
		l2.add("John");l2.add("johnsmith@mail.com"); l2.add("john00@mail.com");
		
		List<String> l3= new ArrayList<>();
		l3.add("Mary"); l3.add("mary@mail.com");
		
		List<String> l4= new ArrayList<>();
		l4.add("John"); l4.add("johnnybravo@mail.com");
		
		List<String> l6= new ArrayList<>();
		l6.add("John");l6.add("johnsmith@mail.com");l6.add("john_newyork@mail.com"); l6.add("john00smith@mail.com");
		l6.add("john01smith@mail.com");
		
		List<String> l7= new ArrayList<>();
		l7.add("John");l7.add("johnsmith@mail.com");l7.add("john_newyork@mail.com"); 
		l7.add("john00smith@mail.com");
		l7.add("john01smith@mail.com");
		l7.add("john02smith@mail.com");
		
		List<String> l5=new ArrayList<>();
		l5.add("bob");
		l5.add("bob0@mail.com"); 
		l5.add("bob1@mail.com");
		l5.add("bob1gfg.org");
		l5.add("bob2@gmail.com");
		l5.add("bob2@google.in");
		l5.add("bob2@mail.com"); 
		l5.add("bob3@gmail.com"); 
		l5.add("bob3@mail.com");
		l5.add("bob4@gmail.com"); 
		l5.add("bob4gfg.org");
		l5.add("bob6@mail.com");
		l5.add("bob7@google.in");
		l5.add("bob7@mail.c");
		
		accounts.add(l4);accounts.add(l3);accounts.add(l2);accounts.add(l1);
		accounts.add(l5);
		accounts.add(l6);
		accounts.add(l7);

		List<List<String>> ans= AccountMerge(accounts);
		System.out.println(" Ans account merge "+ans);
		
		List<List<String>> ans1= AccountMergeOptimized(accounts);
		System.out.println(" Ans account merge "+ans1);
	}

	private static List<List<String>> AccountMergeOptimized(List<List<String>> accounts) {
		// Optimized 
		System.out.println(" Input array "+accounts.toString());
		int length=accounts.size();
		ArrayList<List<String>> harr= new ArrayList<List<String>>();
		
		System.out.println(" Length tot "+length);
		
	    for(int i=0;i<length;i++) {
		    if(accounts.get(i).get(0)!="-1") {
		    	System.out.println(" ----------------> ------------------> --------------- FOR "+i);
			CheckIfOtherArePresent(accounts,accounts.get(i).get(0),harr,length,i);
		    }
	
		}
	    System.out.println(" Accounts "+accounts.toString());
	    
	    System.out.println(" Harr "+harr.toString());
		return harr;
		
	}

	private static void CheckIfOtherArePresent(List<List<String>> accounts, String name, ArrayList<List<String>> harr,int length,int search) {
		// To check if others are present 
		ArrayList<Integer> present=new ArrayList<>();
		for(int i=0;i<length;i++) {
			 if(accounts.get(i).get(0)==name) {
				 
				 if( CheckForCommonMail(accounts.get(i),accounts.get(search))) {
					 present.add(i);
				 }
			 }
		}
		
		System.out.println(" For i "+search+" Arryalist is "+present.toString());
		
		CreateHarrMerge(harr,present,accounts,name);
		
		DEleteListOfAccounts(present,accounts);
		
	}

	private static void DEleteListOfAccounts(ArrayList<Integer> present, List<List<String>> accounts) {
		// Delete and put -1 
		for(int i: present) {
			
			accounts.get(i).clear();
			accounts.get(i).add("-1");
		}
		
	}

	private static void CreateHarrMerge(ArrayList<List<String>> harr, ArrayList<Integer> present, List<List<String>> accounts, String name) {
		// Merge the array and put in hashset 
		HashSet<String> hs= new HashSet<String>();String s=" ";
		for(int i:present) {
			for(int j=1;j<accounts.get(i).size();j++) {
				s=accounts.get(i).get(j);
				hs.add(s);
			}
		}
		List<String> li= new ArrayList<>(hs);
		Collections.sort(li,String.CASE_INSENSITIVE_ORDER);
		li.add(0,name);
		harr.add(li);
		
	}

	private static boolean CheckForCommonMail(List<String> list, List<String> list2) {
		// Check if both have anything in common 
		int len1=list.size();String val=" ";
		for(int i=1;i<len1;i++) {
			val=list.get(i);
			for(String s : list2) {
				if(s==val) {
					return true;
				}
			}
		}
		return false;
	}

	private static List<List<String>> AccountMerge(List<List<String>> accounts) {
		// TODO Auto-generated method stub
		
		System.out.println(" Input array "+accounts.toString());
		int length=accounts.size();int len=0;int len2=0;int len3=0;
		ArrayList<HashSet<String>> harr= new ArrayList<HashSet<String>>(length);
		System.out.println(" Length tot "+length);
		for(int i=0;i<length;i++) {
			len=accounts.get(i).size();
			HashSet<String> hs= new HashSet<String>(len);
			//System.out.println(" Length i "+len);
			
			for(int j=0;j<len;j++) {
				if(j==0) {
					hs.add(String.valueOf(i)+accounts.get(i).get(j));
				}
				else {
			hs.add(accounts.get(i).get(j));}
			}
			harr.add(hs);
		}
		System.out.println(" Harr "+harr.toString());
		
		String searchfor; boolean flg=false;String name = "1";
		for(int i=0;i<length;i++) {
		//	For the array length 4 
			len=harr.get(i).size();
			
			
			for(String s: harr.get(i)) {
//				if(s.length()==1 && Integer.parseInt(String.valueOf(s.charAt(0)))==i) {
//					name=s;
//					System.out.println(" Name "+name);
//				}
				if(s.length()==1   && Integer.parseInt(s)==i) {
				//For every element in the hashmap 
				System.out.println(" No need for chek "+s);
				}
				else {
				flg=CheckIfPresent(s,harr,i);
					
				//	harr.get(i).remove(s);
				}
				}
			if(flg==true) {
			harr.get(i).add("-1");
			//harr.get(i).remove(name);
			flg=false;
			}
			
		}
		System.out.println(" Harr "+harr.toString());
		
		Iterator<HashSet<String>> itrH = harr.iterator();
		while(itrH.hasNext()) {
			//	For the array length 4 
			if(itrH.next().contains("-1")){
				itrH.remove();
			}
		}	
				
		length=harr.size();
		List<List<String>> ans = new ArrayList<>();
		for(int i=0;i<length;i++) {
	
			//HashSet<String> hs=new HashSet<>();
			Iterator <String> itr = harr.get(i).iterator();
			List<String> li= new ArrayList<>();
			while(itr.hasNext()) {
				String s=itr.next();
				//System.out.println("string "+String.valueOf(s.charAt(0))+" ....value "+String.valueOf(i));
				if(Character.isDigit(s.charAt(0))) {
				name=s.substring(1);
					//System.out.println(" NAME "+name);
					//li.add(name);
					//hs.add(name);
				}
				else {
					li.add(s);
				}
			}
			System.out.println(" Created HS "+li.toString());
			//li.addAll(hs);
			Collections.sort(li,String.CASE_INSENSITIVE_ORDER);
			li.add(0, name);
			ans.add(li);
			
		}
		System.out.println(" Ans baba "+ans.toString());
		return ans;
	}

	private static boolean CheckIfPresent(String s, ArrayList<HashSet<String>> harr, int i) {
		// Check if method present 
		
		for(int j=i+1;j<harr.size();j++) {
			
			if(harr.get(j).contains(s)) {
				
				//Merge 
				
				for(String c: harr.get(i)) {
					harr.get(j).add(c);
					//harr.get(j).remove(s);
				}
				return true;
			}
		}
		
		return false;
		
	}

}
