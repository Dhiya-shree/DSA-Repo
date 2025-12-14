package impAlgorithm_Sorting;
/**
 * 
 * Number of pairs
Difficulty: MediumAccuracy: 21.82%Submissions: 91K+Points: 4
Given two positive integer arrays arr and brr, find the number of pairs such that xy > yx (raised to power of) where x is an element from arr and y is an element from brr.

Examples :

Input: arr[] = [2, 1, 6], brr[] = [1, 5]
Output: 3
Explanation: The pairs which follow xy > yx are: 21 > 12,  25 > 52 and 61 > 16 .
Input: arr[] = [2 3 4 5], brr[] = [1 2 3]
Output: 5
Explanation: The pairs which follow xy > yx are: 21 > 12 , 31 > 13 , 32 > 23 , 41 > 14 , 51 > 15 .
Expected Time Complexity: O((N + M)log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ arr.size(), brr.size() ≤ 105
1 ≤ brr[i], arr[i] ≤ 103
 * 
 * 
 * @author shree
 *
 */
public class Number_Of_Pairs {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}
//Back-end complete function Template for Java
class Solution {
  // Function to count number of pairs such that x^y is greater than y^x.
  public long countPairs(int x[], int y[], int M, int N) {
      // code here
     // -- * --   // 3 2 
     // 2 2 2 2 == 4 4 
     // 3 3 3 3 3 243   5 5 5 125
     // 
     Arrays.sort(x);
     Arrays.sort(y);
     int l=0;
     while(l<N && y[l]==1){
         l++;
     }
     int two=0;
     int l2=l;
     while(l2<N && y[l2]==2){
         two++;l2++;
     }
   //  System.out.println(l+" "+l2);
     long ans=0;
     for(int i=0;i<M;i++){
         // find greater in y 
         if(x[i]==1){
             // no ans 
         }
         else if(x[i]==2){
            //   System.out.println("2 "+l);
           ans=(long)(ans+l+findGreater(y,l,N-1,N,4));    
       //     System.out.println("2 "+l+" "+ans);
         }
         else if(x[i]==3){
              ans=(long)(ans+l2+findGreater(y,l,N-1,N,x[i]));   
       //      System.out.println("4 "+l+" "+ans);
         }
         else{
            ans=(long)(ans+l+findGreater(y,l,N-1,N,x[i])); 
      //     System.out.println("x "+l+" "+ans);
         }
         
     }
     
     return ans;
      
  }
  
  
  public int findGreater(int arr[],int l,int h,int n,int k){
      
      if(l==n){
          return 0;
      }
      else if(l==h){
          if(arr[l]>k){
              return 1;
          }
          else{
              return 0;
          }
      }
      
   //   System.out.println(k+" is ..."+l+" "+h);
      int ans=-1;int mid=0;
      while(l<=h){
          mid=(l+h)/2;
          if(arr[mid]<=k){
              l=mid+1;
          }
          else{
              ans=mid;
              h=mid-1;
          }
      }
      
   //     System.out.println(k+" is "+ans+" ..."+l+" "+h);
     
      if(ans>=0){
   //       System.out.println(k+" is "+ans+" "+(n-ans));
       return (n-ans);    
      }
      else{
          return 0;
      }
      
      
  }
}
/*
 *Example:

Input:
m = 3, n = 2
arr[] = {2, 1, 6}, brr[] = {1, 5}
Output: 3
Explanation: There are total 3 pairs
where pow(x, y) is greater than pow(y, x)
Pairs are (2, 1), (2, 5) and (6, 1).

Expected Approach:
Intuition:
We are using the principle of if (x < y) then (x^y > y^x) leaving some exceptional cases including 0,1,2,3, so we are keeping track of the frequency of 0,1,2,3 appearing in Y and the rest elements are computed by the above-defined rule.

Dry Run:
arr = [2, 1, 6] (elements of array X)
brr = [1, 5] (elements of array Y)
Initial Setup:
m = 3 (size of arr)
n = 2 (size of brr)
NoOfY = [0, 0, 0, 0, 0] (initial counts of 0, 1, 2, 3, 4 in brr)
Counting elements in Y[] less than 5:
Loop over brr to populate NoOfY:
For brr[0] = 1: NoOfY[1]++ → NoOfY = [0, 1, 0, 0, 0]
For brr[1] = 5: NoOfY remains unchanged as 5 >= 5.
Sorting brr[] for binary search:
Since brr = [1, 5] is already sorted, it remains the same.
Iteration Breakdown:
1. For arr[0] = 2:
Call count(2, brr, N, NoOfY):
x = 2
NoOfY = [0, 1, 0, 0, 0]
idx = upper_bound(brr.begin(), brr.end(), 2) - brr.begin():
upper_bound returns the position of the first element greater than 2, which is 5 at index 1.
idx = 1
ans = N - idx = 2 - 1 = 1 (1 pair where y > 2)
ans += NoOfY[0] + NoOfY[1] = 1 + 1 = 2
For x = 2, subtract pairs for y = 3 and y = 4:
ans -= (NoOfY[3] + NoOfY[4]) = 2 - 0 = 2
Return ans = 2.
2. For arr[1] = 1:
Call count(1, brr, N, NoOfY):
x = 1
NoOfY = [0, 1, 0, 0, 0]
Since x = 1, return NoOfY[0] = 0.
Return ans = 0.
3. For arr[2] = 6:
Call count(6, brr, N, NoOfY):
x = 6
NoOfY = [0, 1, 0, 0, 0]
idx = upper_bound(brr.begin(), brr.end(), 6) - brr.begin():
upper_bound returns 2 as there is no element greater than 6.
idx = 2
ans = N - idx = 2 - 2 = 0 (no pairs where y > 6)
ans += NoOfY[0] + NoOfY[1] = 0 + 1 = 1
Return ans = 1.
Summing Up Total Pairs:
total_pairs = 2 (for arr[0] = 2) + 0 (for arr[1] = 1) + 1 (for arr[2] = 6) = 3
Code:



//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    long countPairs(int x[], int y[], int M, int N) {
        // Array to store counts of 0, 1, 2, 3 and 4 present in array y.
        int[] freq = new int[5];
        // Storing the count in array if y[i]<5.
        for (int i = 0; i < N; i++) {
            if (y[i] < 5) freq[y[i]]++;
        }
        // Sorting y[] so that we can do binary search on it later on.
        Arrays.sort(y);
        long ans = 0;
        // Taking every element of x[] and counting pairs with it.
        for (int i = 0; i < M; i++) {
            // If x[i] is 0, then there can't be any value in y[]
            // such that x[i]^y[val]>y[val]^x[i].
            if (x[i] == 0) continue;
            // If x[i] is 1, then the number of pair is equal to
            // number of zeroes in y[].
            if (x[i] == 1) {
                ans = ans + (long)freq[0];
                continue;
            }
            // We work with logic that if x<y then x^y is greater than y^x.
            // Finding number of elements in y[] with value greater than x.
            // binary() gets address of first element greater than x[i] in y[].
            int ind = binary(M, N, x[i], y);
            // Updating number of pairs.
            // If we have reached here, then x must be greater than 1.
            // Increasing number of pairs for y=0 and y=1 .
            ans = ans + (long)(N - ind) + (long)freq[0] + (long)freq[1];
            // Decreasing number of pairs for exception where x=2
            // and (y=4 or y=3).
            if (x[i] == 2) ans = ans - (long)freq[3] - (long)freq[4];
            // Increasing number of pairs for exception where x=3 and y=2.
            if (x[i] == 3) ans = ans + (long)freq[2];
        }
        // returning number of pairs.
        return ans;
    }

    // Function to find upper bound using binary search.
    public int binary(int M, int N, int x, int[] y) {
        int high = N - 1, low = 0;
        int ans = high + 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (y[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}
Complexity:
Time Complexity: O((m + n)logn) where m and m are the sizes of arrays arr and brr respectively. The sort step takes O(nlogn) time. Then every element of arr is searched in brr using the binary search(upper_bound) function. This step takes O(mLogn) time, so overall time O(mlogn + nlogn) => O((m+n)logn). 
Space Complexity: O(1), As we are using constant extra spac*/
 */