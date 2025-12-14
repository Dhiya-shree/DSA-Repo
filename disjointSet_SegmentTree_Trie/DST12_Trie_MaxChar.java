package disjointSet_SegmentTree_Trie;
/**
 * Most frequent word in an array of strings
Difficulty: MediumAccuracy: 22.13%Submissions: 56K+Points: 4Average Time: 25m
Given an array arr containing N words consisting of lowercase characters. Your task is to find the most frequent word in the array. If multiple words have same frequency, then print the word whose first occurence occurs last in the array as compared to the other strings with same frequency.

Example 1:

Input:
N = 3
arr[] = {geeks,for,geeks}
Output: geeks
Explanation: "geeks" comes 2 times.
Example 2:

Input:
N = 2
arr[] = {hello,world}
Output: world
Explanation: "hello" and "world" both
have 1 frequency. We print world as
its first occurence comes last in the
input array.
Your Task:
Complete mostFrequentWord function which takes array of strings and its length as arguments and returns the most frequent word. The printing is done by the driver code.

Expected Time Complexity: O(N * WORD_LEN).
Expected Auxiliary Space: O(N * WORD_LEN).

Constraints:
1 <= N <= 50000
1 <= |each string| <= 50
Sum of length of every string does not exceed 5*105

 * 
 * 
 * @author shree
 *
 */
public class DST12_Trie_MaxChar {

}
//Back-end complete function Template for Java


class trie_element {

  public trie_element nxt[];
  public int count;
  public int first_appearance;

  public trie_element() {
      count = 0;
      nxt=new trie_element[26];
      for (int i = 0; i < 26; i++)
          nxt[i] = null;
  }
}

class Solution
{
  //Function to find most frequent word in an array of strings.
  public String mostFrequentWord(String arr[],int n)
  {
      String ret="";
      int max_count=0;
      int ret_first_appearance=0;
      trie_element trie=new trie_element();
      
      for(int i=0;i<n;i++)
      {
          trie_element temp=trie;
          for(int j=0;j<arr[i].length();j++)
          {
              int index=arr[i].charAt(j)-'a';
              if(temp.nxt[index]==null)
              temp.nxt[index]=new trie_element();
              temp=temp.nxt[index];
          }
          
          //storing the count and first appearance of current word.
          temp.count++;
          
          if(temp.count==1)
          temp.first_appearance=i;
          
          //updating the maximum count if required and if they have
          //same frequency, then storing the word whose first 
          //occurrence occurs last in the array.
          if(temp.count>max_count||(temp.count==max_count&&
          temp.first_appearance>ret_first_appearance))
          {
              ret=arr[i];
              max_count=temp.count;
              ret_first_appearance=temp.first_appearance;
          }
      }
      //returning the most frequent word.
      return ret;
  }

}

/*
Brute Force:
Intuition (using Hashing)-
To find the word with maximum occurrence , we can easily calculate frequency of each word and store them in a map. Now, in case two or more words have same frequency then, we have to return the word which occurs last for the first time, that means, the word which has its index values  maximum ,for first time. So, we will also keep comparing the starting index values.

Example-
["GEEKS", "FOR", "GEEKS", "IS", "LOVE", "LOVE"]

 { GEEKS: 2 , FOR: 1, IS: 1, LOVE:2}
We can see that GEEK and LOVE have same frequency but since starting index of GEEK is 0 and LOVE  is 4.
Return LOVE.
Implementation:
Create a frequency map for given list.
Find the words with maximum frequency.
Return the word with greatest starting index.
Code:



def mostFrequentWord(self,arr,n):
        k={}
        for i in arr:
            if i not in k:
                k[i]=1
            else:
                k[i]+=1
        m=max(k.values())
        ind=0
        ans=""
        for i in k.keys():
            if k[i]==m and arr.index(i)>=ind:
                ans=i
                ind=arr.index(i)
        return ans
        
                
 

Time Complexity:Since we are traversing the array once, hence O(N)
Space Complexity:We need an extra space ( map/ dictionary) to store the frequencies hence, O(N).

Expected approach:
Intuition (Using Trie):
An efficient solution is to use Trie data structure. We will first insert a word in trie. In trie, we keep counts of words ending at a node. 

We do preorder traversal and compare count present at each node and find the maximum occurring word.

Implementation:
Create a Trie while traversing for each string. Also store its first occurrence at the end.
After ending of a word , make sure to update the count of the word.
At each iteration , keep track of the maximum counts achieved so far and starting index ( for the case of same frequencies)
Complexity:
Time Complexity- O(N*len(word))We will have to traverse the complete array for once i.e O(N) and in each traversal we will iterate over every letter of a particular string to form a trie O(len(Word)). 

Space Complexity:O(N* len(word)) A trie will be created for each string and consequently storing a letter in each node. 




//Back-end complete function Template for Java


class trie_element {
  
    public trie_element nxt[];
    public int count;
    public int first_appearance;

    public trie_element() {
        count = 0;
        nxt=new trie_element[26];
        for (int i = 0; i < 26; i++)
            nxt[i] = null;
    }
}

class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {
        String ret="";
        int max_count=0;
        int ret_first_appearance=0;
        trie_element trie=new trie_element();
        
        for(int i=0;i<n;i++)
        {
            trie_element temp=trie;
            for(int j=0;j<arr[i].length();j++)
            {
                int index=arr[i].charAt(j)-'a';
                if(temp.nxt[index]==null)
                temp.nxt[index]=new trie_element();
                temp=temp.nxt[index];
            }
            
            //storing the count and first appearance of current word.
            temp.count++;
            
            if(temp.count==1)
            temp.first_appearance=i;
            
            //updating the maximum count if required and if they have
            //same frequency, then storing the word whose first 
            //occurrence occurs last in the array.
            if(temp.count>max_count||(temp.count==max_count&&
            temp.first_appearance>ret_first_appearance))
            {
                ret=arr[i];
                max_count=temp.count;
                ret_first_appearance=temp.first_appearance;
            }
        }
        //returning the most frequent word.
        return ret;
    }

}
 

 

Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/frequent-word-array-strings
*/
*/