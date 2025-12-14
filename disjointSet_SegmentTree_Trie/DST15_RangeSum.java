package disjointSet_SegmentTree_Trie;
/**
 * 
 * Range Sum Queries
Difficulty: MediumAccuracy: 61.3%Submissions: 8K+Points: 4
You are given an array arr[] of size N and Q queries. 
getSum(L,R):  return the sum of range [L,R]
updateValue(index,value): update arr[index] to value.

You need to calculate the answer for Type-1 queries and do the update in the segment tree for Type-2 queries.

Note: 0-based indexing is used.

Example 1:

Input:
N = 6, Q = 3
arr[] = {1,3,5,7,9,11}
Queries = getSum(0,2)
          updateValue(3,17)
          getSum(0,5)
Output:
9
46
Explanation: There are 3 queries: 
Query 1: 1 + 3 + 5 = 9
Query 2: 7 changes to 17
Query 3: 1 + 3 + 5 + 17 + 9 + 11= 46
Your Task:
Complete the updateValue() and getSum() function. The formed segment tree is already provided in both the function as a function argument.
updateValue() processes Type-2 query and does the required update in the segment tree.
getSum() returns the answer for Type-1 query.

Expected Time Complexity: O(Q*Log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 105
1 <= Q <= 105
0 <= L, R, index <= N-1
1 <= arr[i], value <= 105

Example:
Input:
1
6 3
1 3 5 7 9 11
G 0 2
U 3 17
G 0 5

Output:
9
46

Explanation:
Testcase 1: There are 3 queries: 
                    Query 1 :  1 + 3 + 5 = 9
                    Query 2 :  7 changes to 17
                    Query 3 :  1 + 3 + 5 + 17 + 9 + 11= 46
 * 
 * @author shree
 *
 */
public class DST15_RangeSum {

}



//User function Template for Java

class Sol
{
//arr : given array
//n : size of arr
//index : need to update
//new_val : given value to which we need to update index
//st : constructed segment-tree


//Function to update a value in input array and segment tree.
static void updateValue(int arr[], long st[], int n, int index, int val) 
{
 // Your code here
 long diff=((long)arr[index]-val);
 arr[index]=val;
 update(st,n,index,diff,0,n-1,0);
}

static void update(long st[], int n, int id,long diff,int s,int e,int curr) 
{
  if(curr>st.length || s>e ){
      return;
  }
  
 
  if(s==e && s==id){
      st[curr]=st[curr]-diff;
  }
   if(id<s || id>e){
      return;
  }
  else if(s==e){
      return;
  }
  
  
  int mid=(s+e)/2;
  
  if(id<=mid){
      update(st,n,id,diff,s,mid,2*curr+1);
  }
  if(id>mid){
       update(st,n,id,diff,mid+1,e,2*curr+2);
  }
  
  
  st[curr]=st[curr]-diff;
}


//Function to return sum of elements in range from index qs (query start)
//to qe (query end).
public static long getSum(long st[], int n, int l, int r) 
{
 // Your code here
return getSumM(st,n,l,r,0,n-1,0);
}

public static long getSumM(long st[], int n, int qs, int qe,int s,int e,int curr) {
 
 if(curr>st.length || s>qe || e<qs){
     return 0;
 }
 
 if(qs==s && qe==e){
     return st[curr];
 }

 
 long ans=0;long left=0;long right=0;
 int mid=(s+e)/2;
 
 if(qs<=mid){
 left=getSumM(st,n,qs,Math.min(mid,qe),s,mid,2*curr+1);
 }
 if(qe<=e && qe>mid){
     
 right=getSumM(st,n,Math.max(mid+1,qs),qe,mid+1,e,2*curr+2);
 }
 
 ans=left+right;
 return ans;
}

}
