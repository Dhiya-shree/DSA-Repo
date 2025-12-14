package disjointSet_SegmentTree_Trie;
/**
 * https://www.geeksforgeeks.org/min-max-range-queries-array/
 * Range Min Max Queries
Difficulty: MediumAccuracy: 54.91%Submissions: 8K+Points: 4Average Time: 40m
You are given an array of size N and Q queries.

getMinMax(L,R): return the minimum and maximum in the given range [L,R]
updateValue(index,value): update  arr[index] to value.

Note: 0-based indexing is used.

Example 1:

Input:
N = 6, Q = 3
arr[] = {11,3,7,5,9,1}
Queries = getMinMax(0,2)
          updateValue(3,17)
          getMinMax(0,5)
Output:
3 11
1 17
Explanation: There are 3 queries: 
Query 1 : Min(0, 1, 2) = 3,
          Max(0, 1, 2) = 11
Query 2 : 5 changes to 17
Query 3 : Min(0, 1, 2, 3, 4, 5) = 1,
          Max(0, 1, 2, 3, 4, 5) = 17

Your Task:
Complete updateValue() and getMinMax() function. The segment tree has been prebuilt and provided to you.

Expected Time Complexity: O(Q*Log(N)).
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
public class DST08_ST_Max_in_Range {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}

class PII{
	long first,second;
	PII(){
		
	}
}


//User function Template for Java


//arr : given array arr
//st : segment tree of the given array arr
//n :  size of arr array
//qs and qe : index range to find Min and Max value between these indexes.
//PII :  return pair denoting min,max respectively. PII is a class 
//with member first and second.
//index : given index to update with new_val


//Function to update a value in input array and segment tree.
public static PII getMinMax(PII st[], long arr[], int n, int qs, int qe)
{
 if(qs==qe){
      PII dum=new PII();
     dum.first=arr[qs];
     dum.second=arr[qs];
     return dum;
 }
 
 
 PII ans=getMinMaxM(st,n,qs,qe,0,n-1,0);
 return ans;

}

public static PII getMinMaxM(PII st[], int n, int qs, int qe,int s,int e,int curr)
{
 
 if(curr>=st.length){
     return null;
 }
 
 if(s>qe||e<qs){
     return null;
 }
 
if(s==qs && e==qe){
//       System.out.println("qs-qe "+qs+" "+qe+"  s-e "+s+" "+e+" "+curr);
 //     System.out.println("ans "+st[curr].first+" "+st[curr].second);
//          System.out.println("ans "+st[curr].first+" "+st[curr].second);
     PII dum=new PII();
     dum.first=st[curr].first;
     dum.second=st[curr].second;
     return dum;
 }
 
 int mid=(s+e)/2;
 PII ans=null;PII left=null,right=null;
//   System.out.println("qs-qe "+qs+" "+qe+"  s-e "+s+" "+e+" mid "+mid);
 if(qs<=mid && qs>=s && qe>=mid){
 ans=getMinMaxM(st,n,qs,mid,s,mid,2*curr+1);
 }
 else if(qs<=mid && qs>=s && qe<mid ){
 ans=getMinMaxM(st,n,qs,qe,s,mid,2*curr+1);
 }
 
 if(qe<=e && qe>mid && qs<=mid){
  right=getMinMaxM(st,n,mid+1,qe,mid+1,e,2*curr+2);
 }else if(qe<=e && qe>mid && qs>mid){
  right=getMinMaxM(st,n,qs,qe,mid+1,e,2*curr+2);
 }
 if(ans==null){
     ans=right;
 }
 else if(right!=null){
 ans.first=Math.min(ans.first,right.first);
 ans.second=Math.max(ans.second,right.second);
 }
 

 return ans;
}



public static void update(long arr[],PII st[],int n,int id,long val,int s,int e,int curr){
 
if(s>id || e<id || s>e){
//       System.out.println("RRR "+s+"   "+e+"  "+curr+" "+id);
    return;
}    
  
if(s==e && s==id){
//     System.out.println(" In ID "+id+" ..."+val);
     st[curr].first=arr[s];
    st[curr].second=arr[s];
    return ;
}
else if(s==e){
    return;
}

int mid=(s+e)/2;
// System.out.println(s+"   "+e+"  "+curr+" "+mid+" id "+id);
if(id>=s && id<=mid){
 update(arr,st,n,id,val,s,mid,2*curr+1);
}
if(id>mid &&  id<=e){
    update(arr,st,n,id,val,mid+1,e,2*curr+2);
}
//   System.out.println(s+"   "+e+"  "+curr+" "+id);
//System.out.println("No... "+st[curr].first+" - "+st[curr].second);
st[curr].first=Math.min(st[curr*2+1].first,st[curr*2+2].first);
st[curr].second=Math.max(st[curr*2+1].second,st[curr*2+2].second);
//  System.out.println("Yo... "+st[curr].first+" - "+st[curr].second);
return ;
 
}

//Function to return minimum and maximum of elements in range from index
//qs (quey start) to qe (query end). 
public static void updateValue(long arr[],PII st[],int n,int index,long new_val)
{
 //Your code here
 int s=0;
 int e=n-1;
 long old=arr[index];
 if(old==new_val){
     return;
 }
 arr[index]=new_val;
//    System.out.println(Arrays.toString(arr)+" "+index+" "+e);
 update(arr,st,n,index,new_val,s,e,0);
}
}

/*
18 16
2 5 1 9 9 7 8 6 5 6 9 6 4 9 3 2 3 2
U 10 2
G 13 14
U 6 4
U 8 9
U 4 6
U 3 3
G 3 16
U 7 6
G 12 12
G 10 15
U 8 8
G 13 17
G 4 6
G 3 6
U 5 5
G 13 14


*/
