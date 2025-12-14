package disjointSet_SegmentTree_Trie;
/**
 * 
 * Range Longest Correct Bracket Subsequence Queries
Difficulty: MediumAccuracy: 68.91%Submissions: 6K+Points: 4Average Time: 40m
Given a bracket sequence or in other words a string S of length N and queries Q, consisting of characters ‘(‘ and ‘)’. Find the length of the maximum correct bracket subsequence of sequence for a given query range from L to R(L and R inclusive).

Note: A correct bracket sequence is the one that has matched bracket pairs or which contains another nested correct bracket sequence.

Example 1:

Input:
S = ())(())(())( , Q = 2
Queries = {(3,6), (0,11)}
Output:
4
10
Explanation: For query 1, Longest Correct
Bracket Subsequence is (()).Hence length=4
For query 2, Longest Correct Bracket
Subsequence is ()(())(()). Hence length=10
Your Task:
Complete getLongestSequence() function and return the maximum length of the correct bracket subsequence of the sequence. The segment tree array has been prebuilt and provided to you.

Expected Time Complexity: O(Q*Log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N, Q <= 104
0 <= L <= R <= N-1
 * 
 * @author shree
 *
 */
public class DST14_ST_Range_Longest_CorrectBracketSubSeq {

}


//User function Template for Java



//str : given string
//n : length of the string
//qs and qe are L and R respectively
//st : segment tree of the given string of Node type
//return the maximum length of correct bracket subsequence of the sequence.

class Solution 
{
  //Function to returns the maximum length of correct bracket subsequence
  //between starting and ending indexes.
  public static int getLongestSequence(Node[] st,String str,int qs,int qe,int n)
  {
      //Your code here
      if(qs==qe){
          return 0;
      }
      if(qe-qs==1){
          if(str.charAt(qs)=='(' && str.charAt(qe)==')'){
              return 2;
          }
          return 0;
      }
      
     
      
      Node ans= getSequence(st,str,qs,qe,0,n-1,0);
      if(ans==null){
          return 0;
      }
      return ans.pairs*2;
  }
  
   public static Node getSequence(Node[] st,String str,int qs,int qe,int s,int e,int curr)
  {
      
      if(s>qe || e<qs || curr>=st.length){
          Node dum= new Node();
          return dum;
      }
   //   System.out.println(qs+" "+qe+" curr "+curr+" "+s+" "+e);
      if(qs==s&& qe==e){
  //        System.out.println(s+" "+e+" "+st[curr].pairs+" "+st[curr].open+" "+st[curr].closed);
          return st[curr];
      }
     
      //))(( ))() )))))) ) 1to 9 
      //()) )( ()((  ) (()()) ( 14   2 to 15 
      int mid=(s+e)/2;
     Node left=new Node(),right=new Node(),ans=new Node();
//     System.out.println(qs+" "+qe+" mid "+mid);
      if(qs<=mid){
          left=getSequence(st,str,qs,Math.min(mid,qe),s,mid,2*curr+1);
      }
      if(qe>mid){
          right=getSequence(st,str,Math.max(mid+1,qs),qe,mid+1,e,2*curr+2);
      }
     
      int mix=Math.min(left.open,right.closed);
      int match=(left.pairs+right.pairs);
      ans.open=Math.max(0,left.open-mix+right.open);
      ans.closed=Math.max(0,left.closed-mix+right.closed);
      ans.pairs=mix+match;
  //     System.out.println(left.pairs+" "+left.open+" "+left.closed);
    //    System.out.println(right.pairs+" "+right.open+" "+right.closed);
//     System.out.println(s+" "+e+" ans "+ans.pairs+" "+ans.open+" "+ans.closed);
      return ans;
  }
}