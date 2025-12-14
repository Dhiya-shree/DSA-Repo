package disjointSet_SegmentTree_Trie;
/**
 * Range GCD Queries
Difficulty: MediumAccuracy: 74.99%Submissions: 5K+Points: 4Average Time: 45m
You are given an array arr of size N, and Q queries.  You have to find GCD of the elements in the given range alongside updating the value of the array as per query.
Note: 0-based indexing is used.

Example 1:

Input:
N = 6, Q = 3
arr[] = {2,3,4,6,8,16}
Queries = findRangeGCD(0,2)
          updateValue(3,8)
          findRangeGCD(2,5)
Output:
1
4
Explanation: There are 3 queries: 
Query 1 : gcd(2, 3, 4) = 1
Query 2 : 6 changes to 8
Query 3 : gcd(4, 8, 8, 16) = 4
Your Task:
Complete findRangeGcd and updateValue function.
findRangeGcd: This function takes L, R, st (segment tree array), and n(size of arr) as arguments and returns the range GCD.
updateValue:  This function takes index, new_val, arr, st (segment tree array), and n(size of arr) as arguments and updates arr[index] to new_val.

Expected Time Complexity: O(Q*Log(N)*Log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 105
1 <= Q <= 105
0 <= L, R, index <= N-1
1 <= arr[i], value <= 105
 * 
 * @author shree
 *
 */
public class DST13_ST_Range_GCD {

}


//User function Template for Java

class Solution
{
  //Function to find gcd of given range.
  public static int findRangeGcd(int l, int r, int st[],int n) 
  { 
   //    System.out.println(Arrays.toString(st));
      return findRange(l,r,st,0,n-1,0);
  } 
  
   public static int findRange(int l, int r, int st[],int s,int e,int curr) 
  { 
    //   System.out.println(l+" "+r+"  curr "+curr+" "+s+" "+e+" "+st[curr]);
      if(curr>=st.length){
          return 0;
      }
      if(s>r || e<l){
          return 0;
      }
      
      if(l==s && r==e){
          
          return st[curr];
      }
      
      int mid=(s+e)/2;
      // System.out.println(l+" "+r+"  mid "+mid);
      int left=0,right=0,gcd=0;
      if(l<=mid){
          left=findRange(l,Math.min(r,mid),st,s,mid,2*curr+1);
      }
      if(r>mid){
         right=findRange(Math.max(mid+1,l),r,st,mid+1,e,2*curr+2); 
      }
      gcd=FindGCD(left,right);
      return gcd;
      
  }
  
  //Function to update a value in input array and segment tree.
  public static void updateValue(int index,int new_val,int arr[],int st[],int n) 
  {
      //Your code here
      if(new_val==arr[index]){
          return;
      }
 //     System.out.println(Arrays.toString(st));
      arr[index]=new_val;
      update(index,arr,st,0,n-1,0);
   //    System.out.println(Arrays.toString(st));
      
  }
  
    public static void update(int index,int arr[],int st[],int s,int e,int curr) 
  {
      if(index<s || index>e || curr>=st.length){
          return;
      }
      
      if(s==e && s==index){
          st[curr]=arr[index];
      }
      else if(s==e){
          return;
      }
      
      int mid=(s+e)/2;
      
       update(index,arr,st,s,mid,2*curr+1);
        update(index,arr,st,mid+1,e,2*curr+2);
      
      int gcd=0;
      if(curr*2+2<st.length){
      gcd=FindGCD(st[curr*2+1],st[curr*2+2]);
      }
      else if(curr*2+1<st.length){
          gcd=st[curr*2+1];
      }
      else{
          gcd=st[curr];
      }
      st[curr]=gcd;
      return ;
  
  }    
  
  public static int FindGCD(int a,int b){
      
      if(b==0){
          return a;
      }
        
      if(a==0){
          return b;
      }
      
      if(a>b){
          return FindGCD(b,a%b);
      }
      return FindGCD(a,b%a);
      
  }
  
}
