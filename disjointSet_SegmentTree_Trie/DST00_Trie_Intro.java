package disjointSet_SegmentTree_Trie;

import java.util.Stack;

/**
 * 
 * 
 * Trie Data Structure
 * 
 * BestTT for implementng dictonaries
 * 
 * On dictionary below operations can be performed efficiently
 *  1) Search 
 *  2) Insert 
 *  3) Delete
 *  4) Prefix Search 
 *  5) Lexological ordering of words 
 * 
 * 
 * Insert :
 * Insert based on alphabets 
 * 1 insert bed  root -- b -- e--d d isEnd=true
 * 2 insert bet  root -- b --e --d
 *                           |___t
 * Insert bat geek geeks 
 *  
 *          root
 *         /    \
 *        b      g
 *      /   \     \
 *     a     e     e
 *     |    / \     \
 *     t   d   t     e
 *      t,d true      \
 *    other false      k ( true geek)
 *                      \
 *                       s ( true geeks)
 * 
 * Search :
 *  search bad root->b-->a-->d present if isEnd d=true 
 *  search eek root-> no e present False
 *  search gee root->g->e->e Not present isEnd e=false 
 *  Can only search prefix of a word  
 *  
 *        
 * Delete :
 *   delete a string 
 *   For geek , at trie "K" isEnd=false (prev will be true as word end) 
 *   geek  not present 
 *   geeks present 
 *          root
 *         /    \
 *        b      g
 *      /   \     \
 *     a     e     e
 *     |    / \     \   changed to
 *     t   d   t     e    DELETE
 *      t,d true      \    |||||
 *    other false      k ( false geek)
 *                      \
 *                       s ( true geeks)
 * 
 * Prefix search :
 * Consider dict contains geek,geek,bed,bat
 * For input prefix = 2 
 * O/p = geeks , geek 
 * 
 * Lexiograpic order :
 * Order for above 
 * bat bed bet geek geeks 
 * 
 * 
 *  Trie  Vs Hashing 
 * 
 *   word=HelloWorld 
 *   word-len=length of word = 10 
 * 
 * Search   O word-len    Oword-len 
 *         on wors case  on avg case
 * Insert   O word-len    Oword-len 
 *         on wors case  on avg case   
 * Delete   O word-len    Oword-len 
 *         on wors case  on avg case 
 *         
 * Prefix  O prefix len+  not supported
 * search    o/p length 
 * for prefix ge      Time= O ge+geeks= O 2+5 
 * o/p geek,geeks 
 * 
 * Lexiographic O oupput len    not
 *  order                      supported 
 * 
 * o/p bat,bed,bet,geek,geeks O 5 
 * 
 * 
 * C++
 * struct TrieNode
 *     
 *     TrieNode child[26]
 *     bool isEnd 
 *     TrieNode(){
 *         isEnd=false;
 *         for i=0 to i<26 
 *           child[i]=null
 *     }
 *     
 * class BTrieNode{
	BTrieNode child[]=new BTrieNode[26];
	boolean isEnd;
}
 *
 *  For 256 characters
 *  Use hashMap instead of array 
 * 
 * 
 * 
 * Operations:
 * 
 * Insert :
 * 
 * Insert bat 
 * Put b:
 * b ascii value 66 , b-'a'= 1 
 * Fill index 1 in trie node
 * root--> b(false)
 * Put a:  
 * Create a trie in Trie of B index 0 (for a) 
 * root--> b(false) --> a (false)
 * Put t :
 * Create trie in a index ( ascii of 't' - 'a')
 * root --> b(false) --> a (false) -->t (true)
 * 
 * Insert bet 
 * root--> b already present ,, parse 
 * put e : B trie , doesnt have 'e' 
 * Create trie at B index 'e'-'a'
 * Put t :
 * root --> b(false) --> e (false) -->t (true)
 * 
 * 
 * 
 * Empty Trie -> all 26 child are null and isEmpty is false
 * 
 * 
 * @author shree
 *
 */

class BTrieNode{
	BTrieNode child[]=new BTrieNode[26];
	boolean isEnd;
}

public class DST00_Trie_Intro {

	public static void main(String[] args) {
		// TRie 
		
		String str[]= {"ball","back","barish","bat","bet","bed","geek","geeks","cat","cut","cute"};
		int n=str.length;
		
		// Create a trie 
		BTrieNode root=new BTrieNode();
		
		InsertList_Trie(root,str,n);
		
		Stack<Character> st=new Stack<>();
		PrintTheTrie_recur(root,st);
		
		SearchhWord("bed",root);
		
		System.out.println(" Normal delete ............");
		DeleteWord("back",root);
		PrintTheTrie_recur(root,st);
		System.out.println(" Through delete ............");
		DeleteThorough_Recur("bed",root,0);
		PrintTheTrie_recur(root,st);
		st=new Stack<>();
		PrintTheTrie_recur(root,st);
		
		PrefixSearch("ba",root);
		
		//Lexiographic Search 
		// Printing is already making lexiographic search 
		String[] str2={"aaa","aa","aac","aba","acc","aaaa","ae"};
		InsertList_Trie(root,str2,str2.length);
		System.out.println(" Printing in Lexiographic order ");
		PrintTheTrie_recur(root,st);

	}

	private static boolean DeleteThorough_Recur(String str, BTrieNode root,int curr) {
		// delete thorough 
		
		if(root==null) {
			return false;
		}
		
		if(curr==str.length() && root.isEnd) {
			System.out.println(" Found string "+str+ " delete it ..");
			root.isEnd=false;
			for(int i=0;i<26;i++) {
				if(root.child[i]!=null) {
					return false;
				}
			}
			return true;
		}
		else if(curr==str.length()) {
			System.out.println(" String not found ....");
			for(int i=0;i<26;i++) {
				if(root.child[i]!=null) {
					return false;
				}
			}
			return true;
		}
		
		int idx=str.charAt(curr)-'a';
		boolean delete=DeleteThorough_Recur(str, root.child[idx], curr+1);
		
		if(root.isEnd && delete) {
			// curr makes a word , but remaining deletable 
			root.child[idx]=null;
			return false;
		}
		else if(delete) {
			// everthring inc curr deletable 
			root.child[idx]=null;
			for(int i=0;i<26;i++) {
				if(i!=idx && root.child[i]!=null) {
					return false;
				}
			}
			
		}
		
		return delete;
		
	}

	private static void PrefixSearch(String str, BTrieNode root) {
		// Simple prefix search 
		// go to prefix in the branch 
		// print all 
		
		Stack<Character> st=new Stack<>();
		int idx=str.charAt(0)-'a';
		int len=str.length();
		int n=0;
		root=root.child[idx];
		while(root!=null) {
			
			if(n==len-1) {
				System.out.println("Prefix "+str+" words :::");
				st.push((char)(idx+'a'));
				if(root.isEnd) {
					System.out.println(st.toString());
				}
				PrintTheTrie_recur(root, st);
				System.out.println(" All prefix words printed .......");
				break;
			}
			n++;
			st.push((char)(idx+'a'));
			idx=str.charAt(n)-'a';
			root=root.child[idx];
		}
		
	}

	private static boolean DeleteWord(String str, BTrieNode root) {
		// search and delete the word 
		if(root==null) {
			System.out.println(" String NOT found ");
			return false;
		}
	//	BTrieNode rootF=root;
		int idx=str.charAt(0)-'a';
		int n=str.length();
		int len=0;
		BTrieNode next=root.child[idx];
		while(next!=null) {
			
			if(len==n-1) {
				if(next.isEnd) {
					System.out.println(" String found and deleted "+str);
					next.isEnd=false;
					return true;
				}
				else {
					System.out.println(" String NOT found ");
					return false;
				}
			}
			len++;
			idx=str.charAt(len)-'a';
			next=next.child[idx];
			
		}
		System.out.println(" String NOT found ");
		return false;
	}

	private static boolean SearchhWord(String str, BTrieNode root) {
		// Search given word
		
		if(root==null) {
			System.out.println(" String NOT found ");
			return false;
		}
		
		int idx=str.charAt(0)-'a';
		int n=str.length();
		int len=0;
		BTrieNode next=root.child[idx];
		while(next!=null) {
			
			if(len==n-1) {
				if(next.isEnd) {
					System.out.println(" String found "+str);
					return true;
				}
				else {
					System.out.println(" String NOT found ");
					return false;
				}
			}
			len++;
			idx=str.charAt(len)-'a';
			next=next.child[idx];
			
		}
		System.out.println(" String NOT found ");
		return false;
	}

	private static void PrintTheTrie_recur(BTrieNode root,Stack<Character> st) {
		
		if(root!=null && root.isEnd==true) {
		  System.out.println("===> "+st.toString());
		}
		
		// Print using recur
		for(int i=0;i<26;i++) {
			if(root.child[i]!=null) {
				st.push((char) (i+97));
				System.out.print((char) (i+97)+" ");//+st.toString()+" end "+root.child[i].isEnd);
				PrintTheTrie_recur(root.child[i],st);
				st.pop();
			}
		}
		//System.out.println();
	}


	private static BTrieNode InsertList_Trie(BTrieNode root, String[] str, int n) {
		// Read the list and insert 
		
		for(int i=0;i<n;i++) {
			String curr=str[i];
			int len=curr.length();
			BTrieNode prev=root;
			boolean isEnd=false;
			for(int j=0;j<len;j++) {
				if(j==len-1) {
					isEnd=true;
					BTrieNode next=InsertChar(prev,curr.charAt(j)-'a',isEnd);	
				}
				else {
				BTrieNode next=InsertChar(prev,curr.charAt(j)-'a',isEnd);			
				prev=next;
				}
			}
		}
		
		return root;
		
	}

	private static BTrieNode InsertChar(BTrieNode prev, int pos,boolean isEnd) {
		// insert char at given trie dsa 
		if(prev==null) {
			prev=new BTrieNode();
		}
		
		// no entry 
		if(prev.child[pos]==null) {
			prev.child[pos]=new BTrieNode();
		}
		
		if(isEnd) {
			prev.child[pos].isEnd=true;
		}
		
		return prev.child[pos];
	}

}
