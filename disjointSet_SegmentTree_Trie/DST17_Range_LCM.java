package disjointSet_SegmentTree_Trie;
/**
 * 
 * https://www.geeksforgeeks.org/range-lcm-queries/
 * Range LCM Queries
Difficulty: MediumAccuracy: 68.19%Submissions: 5K+Points: 4Average Time: 45m
You are given an array of size N and Q queries. Solve the queries to find LCM for the given range alongside the queries to update the array values.

Note: 0-based indexing is used.

Example 1:

Input:
N = 6, Q = 3
arr[] = {2,3,4,6,8,16}
Queries: getLCM(0,2)
         updateValue(3,8)
         getLCM(2,5)
Output:
12
16
Explanation: There are 3 queries: 
Query 1 :  lcm(2, 3, 4) = 12
Query 2 :  6 changes to 8
Query 3 :  lcm(4, 8, 8, 16) = 16
Your Task:
Complete updateValue() and getLCM() function. The segment tree array has been prebuilt for you. You only need to use it to complete the queries.
getLCM() returns the LCM of elements in range [L,R].
updateValue() processes the point update query.

Expected Time Complexity: O(Q*Log(N)*Log(N) ).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104
1 <= Q <= 105
0 <= L, R, index <= N-1
1 <= arr[i], value <= 104

Topic Tags
 * 
 * @author shree
 *
 */
public class DST17_Range_LCM {

}
//User function Template for Java

//arr : given array
//n : size of the array
//qs and qe are L and R respectively given in the problem to denotes range
//st : segment tree of the array arr


//Function to find LCM of given range.
public static long getLCM(long st[], long arr[], int n, int qs, int qe)
{
 //Your code here
 if(qs==qe){
     return arr[qs];
 }
// System.out.print(Arrays.toString(st));
//    System.out.print(Arrays.toString(arr));
 return getLCMM(st,arr,n,qs,qe,0,n-1,0);
}

public static long getLCMM(long st[], long arr[], int n, int qs, int qe,int s,int e,int curr)
{
 
  if(curr>st.length || s>e || qs>e || s>qe){
      return 1;
  }
  
  if(s==qs && e==qe){
//        System.out.println(qs+" "+qe+" ans"+st[curr]);
      return st[curr];
  }
  

  int mid=(s+e)/2;
  long left=1,right=1;
//     System.out.println(qs+" "+qe+" s "+s+" "+e+" curr "+curr+" mid"+mid);
  if(qs<=mid){
       left=getLCMM(st,arr,n,qs,Math.min(qe,mid),s,mid,2*curr+1);
  }
  if( qe>mid){
      right=getLCMM(st,arr,n,Math.max(qs,mid+1),qe,mid+1,e,2*curr+2);
  }
  
  long ans=1;
  if(left==0 || right==0){
      return 0;
  }
  if(left>right){
   ans= LCM(right,left);  
  }
  
  ans= LCM(left,right);
 
  return ans;
 
}
//Function to update a value in input array and segment tree.
public static void updateValue(long arr[],long st[],int n,int index,long new_val)
{
 
 if(index>=n){
     return;
 }
 //Your code here
 if(new_val==arr[index]){
     return;
 }
 
 arr[index]=new_val;
 
 boolean print=false;
 
 update(arr,st,n,index,print,0,n-1,0);
}

public static void update(long arr[],long st[],int n,int id,boolean print,int s,int e,int curr)
{
  if(curr>=st.length || s>e){
      return;
  }
  
  if(s==e && s==id){
      if(print){ System.out.println(s+" "+e+" ans"+arr[s]);}
      st[curr]=arr[s];
      return;
  }
  else if(s==e){
     return;
  }
  
  int mid=(s+e)/2;
   if(print){ System.out.println(" s "+s+" "+e+" curr "+curr+" mid"+mid);}
 if(id<=mid){
      update(arr,st,n,id,print,s,mid,2*curr+1);
  }
 if(id>mid){
     update(arr,st,n,id,print,mid+1,e,2*curr+2);
  }
  
  long left=1,right=1;
  if(curr*2+1<st.length){
      left=st[curr*2+1];
  }
   if(curr*2+2<st.length){
      right=st[curr*2+2];
  }
  
  if(left==0 || right==0){
      st[curr]=0;
      return;
  }
  
  if(left>right){
    st[curr]= LCM(right,left);  
  }
  
  
   st[curr]=  LCM(left,right);
  if(print){   System.out.println(s+" "+e+" a "+st[curr]);}

  return;
  
}
