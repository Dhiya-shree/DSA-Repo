package recursion;

import java.util.ArrayList;

public class R05_GenerateSubSets {

	public static void main(String[] args) {
		// Generate subsets 
		String str="geeksforGeeks";
		// N char 2^n sets 
		ArrayList<String> ans=powerSet(str);
		System.out.println("Ans is "+ans.toString());

	}

	static ArrayList<String> powerSet(String s)
	{
		// generste set 
		int n=s.length();
		ArrayList<String> ans=new ArrayList<String>((int)Math.pow(2,n));
		RecurPowerSet(ans,s,0,"",n);
		return ans;
	}

	static void RecurPowerSet(ArrayList<String> ans,String s,int index,String curr,int n)
	{
		if(index>=n){
			ans.add(curr);
			return;
		}


		// without curr index   
		RecurPowerSet(ans,s,index+1,curr,n);

		// with curr index 
		curr=curr+Character.toString(s.charAt(index));
		RecurPowerSet(ans,s,index+1,curr,n);

	}

}

/*
 * Generate Subsets

Given a set represented as a string, write a recursive code to print all the subsets of it. The subsets can be printed in any order.

Examples:
 

Input :  set = "abc"
Output : "". "a", "b", "c", "ab", "ac", "bc", "abc"

Input : set = "abcd"
Output : "" "a" "ab" "abc" "abcd" "abd" "ac" "acd"
         "ad" "b" "bc" "bcd" "bd" "c" "cd" "d"


The idea is to consider two cases for every character.

(i) Consider current character as part of the current subset
(ii) Do not consider current character as part of the current subset.

 


// Java program to generate power set
class GFG {

    // str : Stores input string
    // curr : Stores current subset
    // index : Index in current subset, curr
    static void powerSet(String str, int index, String curr)

    {
        int n = str.length();

        // base case
        if (index == n) {
            System.out.println(curr);
            return;
        }

        // Two cases for every character
        // (i) We consider the character
        // as part of current subset
        // (ii) We do not consider current
        // character as part of current
        // subset
        powerSet(str, index + 1, curr + str.charAt(index));
        powerSet(str, index + 1, curr);
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "abc";
        int index = 0;
        String curr = "";
        powerSet(str, index, curr);
    }
}

 


Output
abc
ab
ac
a
bc
b
c


Let us understand the recursion with an example "abc". Every node in the below tree represents the string curr.
 

           ""
        /      \
       a        ""
     /   \      /  \
    ab    a     b    ""
  /  \   / \   / \   / \
 abc ab ac  a bc  b c

At root, index = 0.
At next level of tree index = 1
At third level, index = 2
At fourth level index = 3 (becomes equal to string length), so we print the subset.

 * 
 * 
 */
