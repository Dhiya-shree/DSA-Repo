package disjointSet_SegmentTree_Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 
 * Camel Case
Difficulty: MediumAccuracy: 47.6%Submissions: 13K+Points: 4Average Time: 45m
Given a dictionary of words dict where each word follows CamelCase notation, print all words in the dictionary that match with a given pattern consisting of uppercase characters only.
CamelCase is the practice of writing compound words or phrases such that each word or abbreviation begins with a capital letter. Common examples include: “PowerPoint” and “WikiPedia”, “GeeksForGeeks”, “CodeBlocks”, etc.

Note: The order should be such that the output strings should be sorted by the lexicographic order of their abbreviations. For strings with same abbreviations the strings should be sorted by the usual lexicographic order. So, if Output Strings are Hi and HelloWorld, Hi should come first as H lexiographically is smaller than HW.


Example 1:

Input:
n = 8
dict[] = {Hi,Hello,HelloWorld,HiTech
HiGeek,HiTechWorld,HiTechCity,HiTechLab}
pattern = HA
Output: No match found
Example 2:

Input:
n = 3
dict[]={WelcomeGeek,WelcomeToGeeksForGeeks
GeeksForGeeks}
pattern = WTG
Output: WelcomeToGeeksForGeeks
Explanation: WTG occurs in
WelcomeToGeeksForGeeks.

Your Task:
Complete findAllWords() function and print as mentioned. If the pattern is not found, print "No match found" (without quotes) in the function itself. The new line is provided by the driver code.


Expected Time Complexity: O(N * WORD_LEN).
Expected Auxiliary Space: O(N * WORD_LEN).


Constraints:
1 <= N <= 100
1 <= length of pattern <= length of string <= 100
 * 
 * 
 * @author shree
 *
 */
public class DST03_Camel_Case {

}




//User function Template for Java

class TrieN{
  int isEnd;
  int val;
  TrieN child[]=new TrieN[26];
  TrieN(){
      val=0;
      isEnd=0;
      for(int i=0;i<26;i++){
          child[i]=null;
      }
  }
}

class TrieWord{
  ArrayList<Integer> ptr;
  TrieWord child[]=new TrieWord[26];
  TrieWord(){
     ptr=new ArrayList<Integer>();
     for(int i=0;i<26;i++){
          child[i]=null;
      }
  }
}

class Solution
{
  
  static class TrieNode
  {
	     HashMap<Character, TrieNode> child;
	     boolean isleaf;
	     ArrayList<String> words;
	     public TrieNode() {
	          child = new HashMap<>();
	          isleaf = false;
	          words = new ArrayList<>();
	     }
	     
	     //Function to insert word into the Trie.
	     public void insert(String w) 
	     {
	         TrieNode crawl = this;
	         for(int level = 0; level < w.length(); level++)
	         {
	             char c = w.charAt(level);
	             //considering only uppercase characters.
	             if(Character.isUpperCase(c) == false) 
	             continue;
	             
	             //getting current character position.
	             if(crawl.child.containsKey(c) == false)
	                crawl.child.put(c, new TrieNode());
	             crawl = crawl.child.get(c);
	         }
	         //marking last node as leaf.
	         crawl.isleaf = true;
	         //pushing word into list associated with leaf node.
	         crawl.words.add(w);
	     }
	 }
	
	 //Function to print all children of Trie node root.
	 static void printAll(TrieNode node) 
	 {
	     //if current node is leaf.
	     if(node.isleaf) {
	         Collections.sort(node.words);
	         for(String s : node.words) {
	             System.out.print(s+" ");
	         }
	     }
	     //recursing for all children of root node.
	     for(int i = 0; i < 26; i++) 
	     {
	         char c = (char)('A'+i);
	         if(node.child.containsKey(c)==false)continue;
	         printAll(node.child.get(c));
	     }
	 }
	 
	 //Function to search for pattern in Trie.
	 static boolean search(TrieNode node, String ptrn)
	 {
	     TrieNode crawl = node;
	     for(int i = 0; i < ptrn.length(); i++)
	     {
	         char c = ptrn.charAt(i);
	         //Invalid pattern
	         if(crawl.child.containsKey(c) == false) return false;
	         crawl = crawl.child.get(c);
	     }
	     //printing all words matching that pattern.
	     printAll(crawl);
	     return true;
	 }
	 
	//Function to print all words in the CamelCase dictionary 
  //that matches with a given pattern.
	static void findAllWords(String[] dict, String pattern) 
  {
      //constructing Trie root node.
      TrieNode root=new TrieNode();
      
      //constructing Trie from given dict.
      for(String x:dict)
      root.insert(x);
      
      //searching for pattern in Trie.
      boolean res = search(root, pattern);
  
      System.out.print(res?"":"No match found");
      
  }   
  
};
  
  /*
  //Function to print all words in the CamelCase dictionary 
  //that matches with a given pattern.
  static void findAllWords(String[] dict, String pattern) 
  {
      //Your code here
      
          TrieWord root=new TrieWord();
          
          boolean insert=InsertAll(root,dict,pattern);
          if(!insert){
              System.out.print("No match found");
              return;
          }
      
          Print(root,dict);
  }  
  
  static void InsertN(TrieN root,String s,int val){
      
      TrieN next=root;
      int n=s.length();
      for(int i=0;i<n;i++){
          int c=(int) s.charAt(i);
          if(c>=97){
              c=c-97;
          }
          else{
              c=c-65;
          }
          
          if(next.child[c]==null){
              next.child[c]=new TrieN();
          }
          
          next=next.child[c];
          if(i==n-1){
              next.isEnd=next.isEnd+1;
              next.val=val;
          }
      }
  }
  
  static void PrintN(TrieN root,String dict[]){
      
      if(root==null){
          return;
      }
      
      if(root.isEnd>0){
          for(int i=0;i<root.isEnd;i++){
            System.out.print(dict[root.val]+" ");
          }
      }
      
      for(int i=0;i<26;i++){
          if(root.child[i]!=null){
              PrintN(root.child[i],dict);
          }
      }
  }
  
  static void Print(TrieWord root,String[] dict){
    
    if(root==null){
        return;
    }
    
    if(root.ptr.size()>0){
        int n=root.ptr.size();
        //   System.out.println(root.ptr.toString());
        if(n==1){
            System.out.print(dict[root.ptr.get(0)]+" ");
        }
        else{
            TrieN noot=new TrieN(); 
             for(int i=0;i<n;i++){
            InsertN(noot,dict[root.ptr.get(i)],root.ptr.get(i));
             }
             PrintN(noot,dict);
           }
        }
    
    
    
    for(int i=0;i<26;i++){
        if(root.child[i]!=null){
            Print(root.child[i],dict);
        }
    }
     
     return; 
  }
  
  
  static boolean InsertAll(TrieWord root,String[] dict, String pattern) 
  {
      
      boolean add=false;
      int n=dict.length;
      int pl=pattern.length();
      for(int i=0;i<n;i++){
          String s=dict[i];
          int n1=s.length();
          int p=0;
          int pos[]=new int[n1];int posl=0;
          for(int j=0;j<n1;j++){
              char ch=s.charAt(j);
              if(ch<97){
                  if(p<pl && ch!=pattern.charAt(p)){
                     break;
                  }
                  else if(p<pl &&  ch==pattern.charAt(p)){
                      pos[posl]=ch-'A';
                      p++;posl++;
                  //    continue;
                  }
                  else{
                      pos[posl]=ch-'A';
                      p++;posl++;
                 //     continue;
                  }
                  
              }
              
              // ignre smalll char 
              if(j==n1-1 && p>=pl){
                  add=true;
          //     System.out.println(i+" "+Arrays.toString(pos));
                  InsertString(pos,posl,root,i);
              }
              
          }
      }
      return add;
  }
  
   static void InsertString(int pos[],int n,TrieWord root,int s) 
  {
      
      if(root==null){
          root=new TrieWord();
      }
      TrieWord next=root;
      for(int i=0;i<n;i++){
          
          if(next.child[pos[i]]==null){
          next.child[pos[i]]=new TrieWord();
          
          }
          next=next.child[pos[i]];
          if(i==n-1){
               next.ptr.add(s);
              
          }
          
      }
    
  }
};
*/

/*
 * 
 * Brute Force Approach
Intuition
Using map store the pattern as key and all the word corresponding to that pattern as value, now use this map to find the strings corresponding to given pattern.

Implementation
Traverse through every word and keep hashing that word with every uppercase letter found in the given string.
Example :
For string = "GeeksForGeeks" , the hashing after every upper case letter is found is
     { {G,GeeksForGeeks},
      {GF, GeeksForGeeks},
        {GFG, GeeksForGeeks} }
For every upper case alphabet encountered update the map.
Also keep track of the final pattern that every word from the dictinary generates using map (key), it wil help to sort the result later.
Traverse the map for pattern matching, and store the word into a vector in form of pair along with its pattern.
Now sort the vector according to the pattern and print it.
Code



//User function template for C++

// dict : given set of strings
// pattern : given pattern
class Solution
{
    public:
    //Function to print all words in the CamelCase dictionary 
    //that matches with a given pattern.
    void findAllWords(vector<string> dict, string pattern) 
    {
        //Map to store the each word accompanied by its pattern
	    map<string,string> key;

    	// Map to store the hashing of each words with every uppercase letter found
	    map<string, vector<string> > map;

    	// Traverse the words array that contains all the string
	    for (int i = 0; i < dict.size(); i++) {

		    string str = "";
    		// length of string words[i]
	    	int l = dict[i].length();
		    for (int j = 0; j < l; j++) {

    			// For every uppercase letter found map that uppercase to original words
	    		if (dict[i][j] >= 'A' && dict[i][j] <= 'Z') {
		    		str += dict[i][j];
			    	map[str].push_back(dict[i]);
				    key[dict[i]] = str;
    			}
	    	}
    	}

	    bool wordFound = false;

    	// Traverse the map for pattern matching
	    vector<pair<string, string>> res;
    	for (auto& it : map) {
	    	if (it.first == pattern) {
		    	wordFound = true;
			    for (auto& itt : it.second) {
				    res.push_back({key[itt],itt});
    			}
	    	}
	    }
	
    	sort(res.begin(),res.end());
	    
    	//Printing words that match the given pattern
	    for (auto str : res){
	        cout << str.second<< " ";
	    }
	
    	// If word not found print
	    if (!wordFound) {
		    cout << "No match found";
	    }
    }
};
 

Complexity
Time Complexity : O(N*M), As for every word in the list, the loop will run  M number of times.
Space Complexity : O(N*M) , where N is the length of the list containing the strings and M is the length of the longest string.

 

Expected Approach
Intuition
Use the upper case alphabets from every word of the dictionary to create tries, then use search operation in tries to find the strings associated with the given pattern, sort them accoding to the uppercase alphabets present in them.

 

Example 

List = {WelcomeGeek, Welcome, WelcomeToGeeksForGeeks, GeeksForGeeks}
For better understanding we take structure of our node as Row 1 for Current Character, Row 2 for checking if its end of the word and Row 3 for the words that would be present in the vector of that node.


Trie generated from the List.

 

Implementation
Create structure consisting a vector to store complete leaf, flag to check for end of word and children array.
Insert all dictionary keys into the Trie one by one. Here key refers to only Uppercase characters in original word in CamelCase notation.
When encountering the key for the first time, mark the last node as leaf node and insert the complete word for that key into the vector associated with the leaf node. 
If encountering a key that is already in the trie, update the vector associated with the leaf node with current word.
After inserting the word set bool isleaf to 1 and insert the word in the vector of string for the node of last character.
After all dictionary words are processed, search for the pattern in the trie and print them.
We need not to sort the words as trie already is a sorted tree-based data-structure.
Complexity
Time Complexity : O(N*M), We iterate through list which takes O(N) time and for each word we need to traverse it to insert it in the trie resulting into O(N*M) complexity, where N is the number of words in the dictionary.
Space Complexity : O(N).




class Solution
{
    static class TrieNode
    {
	     HashMap<Character, TrieNode> child;
	     boolean isleaf;
	     ArrayList<String> words;
	     public TrieNode() {
	          child = new HashMap<>();
	          isleaf = false;
	          words = new ArrayList<>();
	     }
	     
	     //Function to insert word into the Trie.
	     public void insert(String w) 
	     {
	         TrieNode crawl = this;
	         for(int level = 0; level < w.length(); level++)
	         {
	             char c = w.charAt(level);
	             //considering only uppercase characters.
	             if(Character.isUpperCase(c) == false) 
	             continue;
	             
	             //getting current character position.
	             if(crawl.child.containsKey(c) == false)
	                crawl.child.put(c, new TrieNode());
	             crawl = crawl.child.get(c);
	         }
	         //marking last node as leaf.
	         crawl.isleaf = true;
	         //pushing word into list associated with leaf node.
	         crawl.words.add(w);
	     }
	 }
	
	 //Function to print all children of Trie node root.
	 static void printAll(TrieNode node) 
	 {
	     //if current node is leaf.
	     if(node.isleaf) {
	         Collections.sort(node.words);
	         for(String s : node.words) {
	             System.out.print(s+" ");
	         }
	     }
	     //recursing for all children of root node.
	     for(int i = 0; i < 26; i++) 
	     {
	         char c = (char)('A'+i);
	         if(node.child.containsKey(c)==false)continue;
	         printAll(node.child.get(c));
	     }
	 }
	 
	 //Function to search for pattern in Trie.
	 static boolean search(TrieNode node, String ptrn)
	 {
	     TrieNode crawl = node;
	     for(int i = 0; i < ptrn.length(); i++)
	     {
	         char c = ptrn.charAt(i);
	         //Invalid pattern
	         if(crawl.child.containsKey(c) == false) return false;
	         crawl = crawl.child.get(c);
	     }
	     //printing all words matching that pattern.
	     printAll(crawl);
	     return true;
	 }
	 
	//Function to print all words in the CamelCase dictionary 
    //that matches with a given pattern.
	static void findAllWords(String[] dict, String pattern) 
    {
        //constructing Trie root node.
        TrieNode root=new TrieNode();
        
        //constructing Trie from given dict.
        for(String x:dict)
        root.insert(x);
        
        //searching for pattern in Trie.
        boolean res = search(root, pattern);
    
        System.out.print(res?"":"No match found");
        
    }   
};
Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/print-words-matching-pattern-camelcase-notation-dictonary/
 * 
 */
