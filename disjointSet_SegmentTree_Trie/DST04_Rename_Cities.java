package disjointSet_SegmentTree_Trie;

import java.util.TreeMap;

/**
 * 
 * Renaming Cities
Difficulty: MediumAccuracy: 66.38%Submissions: 7K+Points: 4Average Time: 45m
Some cities are going to be renamed and accordingly name of their railway stations will also change. Changing the name of railway station should also result in changed station code. Railways have an idea that station code should be the shortest prefix out of all railway stations renamed prior to this. If some city has same name, then prefix will be the name with suffix as the count of occurence of that city prior to this and including this, seperated with spaces.

Given N renamed cities consisting of lowercase alphabets only. The task is to generate a station ID for all the stations.

Example 1:

Input:
N = 6
Cities[] = {shimla,safari,jammu,delhi,
                jammu,dehradun}
Output:
s
sa
j
d
jammu 2
deh
Explanation: Till shimla, no stations are there.
So, it's first character will be the unique
smallest prefix. For safari, first character of
shimla matches, so unique smallest prefix is sa
Similarly, j is smallest unique prefix for jammu
and d is for delhi. For last city jammu, we have
countered jammu before, and therefor no smallest
prefix is possible. So, we can generate its code
as jammu with suffix equal to the count of jammu,
i.e, 2. Smallest unique prefix is jammu2. Now,
delhi can be renamed as d, and dehradun can be
renamed as deh, since deh is the smallest non
matching prefix.
 * 
 * 
 * @author shree
 *
 */
public class DST04_Rename_Cities {

}
//Back-end complete function Template for Java


class Node{
	boolean isEndOfWord;
	TreeMap<Character,Node> mp;
	Node(){
		isEndOfWord=false;
		mp=new TreeMap<Character,Node>();
	}
}
//User function Template for Java

class Trie{
  int isEnd;
  int idx;
  Trie child[]=new Trie[26];
  Trie(){
      isEnd=0;
      idx=0;
      for(int i=0;i<26;i++){
          child[i]=null;
      }
  }
}

//Back-end complete function Template for Java

class SolutionGoG
{
  //Function to insert string into TRIE.
	public static void insertInTrie(Node root, String s)
	{
	    //if not present, we insert key into trie. If the key is prefix 
      //of trie node, we just mark the leaf node.
	    for(int i=0;i<s.length();i++)
	    {
	        if(root.mp.containsKey(s.charAt(i))==false)
	        {
	            root.mp.put(s.charAt(i),new Node());
	        }
	        root=root.mp.get(s.charAt(i));
	    }
	    //marking last node as leaf.
	    root.isEndOfWord=true;
	}
	
	//Function to use TRIE data structure and search the given string.
	public static int searchInTrie(Node root, String s)
	{
	    int i=0;
	    for(i=0;i<s.length();i++)
	    {
	         if(root.mp.containsKey(s.charAt(i))==false)
	         return i;
	         root=root.mp.get(s.charAt(i));
	    }
	    
	    if(root.isEndOfWord==false)
	    {
	        return i;
	    }
	    
	    return Integer.MAX_VALUE;
	}
	
	public static void check(String arr[],int n)
	{
	    TreeMap<String,Integer>temp=new TreeMap<>();
	    Node root=new Node();
	    
	    for(int i=0;i<n;i++)
	    {
	        //searching if the string is already present in the trie or not.
	        int k=searchInTrie(root,arr[i]);
	        String s=arr[i];
	        
	        //if the string is present already in the trie we increase the
          //counter to count the number of times it appears in the trie.
	        if(k==Integer.MAX_VALUE)
	        {
	            if(temp.containsKey(s)){
	                int val=temp.get(s);
	                val++;
	                temp.put(s,val);
	            }
	            else
	                temp.put(s,1);
	            
	            System.out.print(s);
	            
	            if(temp.get(s)>1)
	                System.out.print(" "+temp.get(s));
	            System.out.println();
	        }
	        
	        else
	        {
	            //printing index upto which string can be uniquely identified.
	            for(int j=0;j<=k;j++)
	            {
	                if(j<s.length())
	                System.out.print(s.charAt(j));
	            }
	            //inserting the string.
	            insertInTrie(root,s);
	            if(temp.containsKey(s)){
	                int val=temp.get(s);
	                val++;
	                temp.put(s,val);
	            }
	            else
	                temp.put(s,1);
	            
	            if(temp.get(s)>1)
	                System.out.print(" "+temp.get(s));
	            System.out.println();
	            
	        }
	    }
	}
}


class Solution
{
  public static void check(String arr[],int n)
  {
      if(n==1){
         System.out.println(arr[0].charAt(0));  
         return;
      }
      //Your code here
      Trie root=new Trie();
      for(int i=0;i<n;i++){
          String code=InsertInRoot(root,arr,i);
          System.out.println(code);
      }
  }
  
  public static String InsertInRoot(Trie root,String []arr,int idx)
  {
     String st=arr[idx];
     boolean isCodeSet=false;
     String code=st;
     int n=st.length();
     Trie next=root;
     for(int i=0;i<n;i++){
         int ch=st.charAt(i)-97;
         if(next.child[ch]==null){
             next.child[ch]=new Trie();
             next=next.child[ch];
             next.isEnd=1;
             next.idx=idx;
             if(!isCodeSet){
             isCodeSet=true;
             code=(st.substring(0,i+1));
             }
         }
         else if(next.child[ch].isEnd>0 && arr[next.idx].equals(st)){
           if(!isCodeSet){
               next=next.child[ch];
                     isCodeSet=true;
             code=st+" "+Integer.toString(next.isEnd+1);
                 next.isEnd=next.isEnd+1;
               }
               return code;
         }
         else if(next.child[ch].isEnd>0){
             next=next.child[ch];
         }
        
         if((i==n-1 )){
          //   int end=next.isEnd;
          next.isEnd=next.isEnd+1;
          next.idx=idx;
          
         }
     }
     return code;
  }
}


class Solution
{
  //Function to insert string into TRIE.
	public static void insertInTrie(Node root, String s)
	{
	    //if not present, we insert key into trie. If the key is prefix 
      //of trie node, we just mark the leaf node.
	    for(int i=0;i<s.length();i++)
	    {
	        if(root.mp.containsKey(s.charAt(i))==false)
	        {
	            root.mp.put(s.charAt(i),new Node());
	        }
	        root=root.mp.get(s.charAt(i));
	    }
	    //marking last node as leaf.
	    root.isEndOfWord=true;
	}
	
	//Function to use TRIE data structure and search the given string.
	public static int searchInTrie(Node root, String s)
	{
	    int i=0;
	    for(i=0;i<s.length();i++)
	    {
	         if(root.mp.containsKey(s.charAt(i))==false)
	         return i;
	         root=root.mp.get(s.charAt(i));
	    }
	    
	    if(root.isEndOfWord==false)
	    {
	        return i;
	    }
	    
	    return Integer.MAX_VALUE;
	}
	
	public static void check(String arr[],int n)
	{
	    TreeMap<String,Integer>temp=new TreeMap<>();
	    Node root=new Node();
	    
	    for(int i=0;i<n;i++)
	    {
	        //searching if the string is already present in the trie or not.
	        int k=searchInTrie(root,arr[i]);
	        String s=arr[i];
	        
	        //if the string is present already in the trie we increase the
          //counter to count the number of times it appears in the trie.
	        if(k==Integer.MAX_VALUE)
	        {
	            if(temp.containsKey(s)){
	                int val=temp.get(s);
	                val++;
	                temp.put(s,val);
	            }
	            else
	                temp.put(s,1);
	            
	            System.out.print(s);
	            
	            if(temp.get(s)>1)
	                System.out.print(" "+temp.get(s));
	            System.out.println();
	        }
	        
	        else
	        {
	            //printing index upto which string can be uniquely identified.
	            for(int j=0;j<=k;j++)
	            {
	                if(j<s.length())
	                System.out.print(s.charAt(j));
	            }
	            //inserting the string.
	            insertInTrie(root,s);
	            if(temp.containsKey(s)){
	                int val=temp.get(s);
	                val++;
	                temp.put(s,val);
	            }
	            else
	                temp.put(s,1);
	            
	            if(temp.get(s)>1)
	                System.out.print(" "+temp.get(s));
	            System.out.println();
	            
	        }
	    }
	}
}



/*
 * Brute Force
Intuition:
The idea is that the first city will have its first letter as its output. While the second to last cities will have an output as the longest common substring starting from 0th index of current city and every previous city , concatenated with an extra letter or digit to make it unique.

Example:
[ "Shimla", "Safari", "Safedabad", "Safedaganj"]
1. Shimla has no previous element . Hence "S" will be its output.
2. Safari and Shimla has "S" as Longest common substring as "S" , hence "Sa" .
3. Safedabad has two elements ," Safari" and "Shimla" having  Longest common substring as "Saf" and "S" respectively.  Out of these "Saf" will be chosen , hence "Safe".
4. Safedaganj has three elements "Safedabad", "Safari" and "Shimla" having  Longest common substring as "Safeda", "Saf" and "S" resp. Out of which "Safeda" will be chosen , hence "Safedag".
Approach:
 For the first city, its first character will be the output.
Second city onwards, start traversing to all the previous cities and find  Longest common substring starting with 0th index with each, the one having maximum length will be the part of our answer.
  2.1 If the length of  Longest common substring is less than the current city, then print the  Longest common substring concatenated with a letter succeeding in the current city name.
 2.2 If the length of  Longest common substring is equal to the current city, then print the  Longest common substring concatenated with number of occurence of the city.
Implementation:



from collections import Counter
def sol(arr):
    k=Counter(arr)
    print(arr[0][0]
    for i in range(1,len(arr)):
        final_lcs=""
        for j in range(i-1,-1,-1):
            lcs=""
            l=0
            while(l < len(arr[i]) and l < len(arr[j])):
                if arr[i][l]==arr[j][l]:
                    lcs+=arr[i][l]
                else:
                    lcs+=arr[i][l]
                    break
                l+=1
            if len(final_lcs)<len(lcs):
                final_lcs=lcs
        if k[arr[i]]>=2:
            final_lcs+=str(k[arr[i]])
        print(final_lcs)
 
 

Complexity
Time complexity: 

since we have a loop (i) that iterates on every string , inside that for every arr[i], we have another loop (j) that iterates upon all previous cities, also a loop (L) that iterates on string to check matching characters. Therefore, the overall complexity becomes O(N*N* LEN(ARR[i])

Space complexity:

we will just need a dictionary to store the count for every city, hence O(N).

Expected Approach:
Intuition:
We have three tasks to do. 

 Take a word
Search if a word similar to it exists or not. If yes, then concatenate it with its number of occurence.
Else, Search if a word with similar prefix exists or not. If yes, concatenate it with an extra character succeeding the prefix.
Above three can easily be implemented using TRIE DATA STRUCTURE.  

Implementation:
 Insert every word into trie.
While searching if, we reach end of a word, then concatenate the word with its frequency.
Else, concatenate the prefix with the next succeeding word.
Complexity:
Time complexity: O(N* (LEN(WORD)).  We need to traverse the complete list of string as well as letters of each string.

Space complexity:  O(N*(LEN(WORD)).  To store the letters of each word , we need to maintain a trie.




//Back-end complete function Template for Java

class Solution
{
    //Function to insert string into TRIE.
	public static void insertInTrie(Node root, String s)
	{
	    //if not present, we insert key into trie. If the key is prefix 
        //of trie node, we just mark the leaf node.
	    for(int i=0;i<s.length();i++)
	    {
	        if(root.mp.containsKey(s.charAt(i))==false)
	        {
	            root.mp.put(s.charAt(i),new Node());
	        }
	        root=root.mp.get(s.charAt(i));
	    }
	    //marking last node as leaf.
	    root.isEndOfWord=true;
	}
	
	//Function to use TRIE data structure and search the given string.
	public static int searchInTrie(Node root, String s)
	{
	    int i=0;
	    for(i=0;i<s.length();i++)
	    {
	         if(root.mp.containsKey(s.charAt(i))==false)
	         return i;
	         root=root.mp.get(s.charAt(i));
	    }
	    
	    if(root.isEndOfWord==false)
	    {
	        return i;
	    }
	    
	    return Integer.MAX_VALUE;
	}
	
	public static void check(String arr[],int n)
	{
	    TreeMap<String,Integer>temp=new TreeMap<>();
	    Node root=new Node();
	    
	    for(int i=0;i<n;i++)
	    {
	        //searching if the string is already present in the trie or not.
	        int k=searchInTrie(root,arr[i]);
	        String s=arr[i];
	        
	        //if the string is present already in the trie we increase the
            //counter to count the number of times it appears in the trie.
	        if(k==Integer.MAX_VALUE)
	        {
	            if(temp.containsKey(s)){
	                int val=temp.get(s);
	                val++;
	                temp.put(s,val);
	            }
	            else
	                temp.put(s,1);
	            
	            System.out.print(s);
	            
	            if(temp.get(s)>1)
	                System.out.print(" "+temp.get(s));
	            System.out.println();
	        }
	        
	        else
	        {
	            //printing index upto which string can be uniquely identified.
	            for(int j=0;j<=k;j++)
	            {
	                if(j<s.length())
	                System.out.print(s.charAt(j));
	            }
	            //inserting the string.
	            insertInTrie(root,s);
	            if(temp.containsKey(s)){
	                int val=temp.get(s);
	                val++;
	                temp.put(s,val);
	            }
	            else
	                temp.put(s,1);
	            
	            if(temp.get(s)>1)
	                System.out.print(" "+temp.get(s));
	            System.out.println();
	            
	        }
	    }
	}
}
 

Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/program-for-assigning-usernames-using-trie/
 * 
 */
