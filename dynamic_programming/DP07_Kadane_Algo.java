package dynamic_programming;
/**
 * 
 * 
 * Kadane's Algorithm - II
Difficulty: EasyAccuracy: 40.85%Submissions: 19K+Points: 2
You are given an array arr of size sizeOfArr. You need to find the maximum sum in the array provided that you cannot sum neighboring elements or adjacent elements.

Example 1:

Input:
sizeOfArr = 4
arr[] = {4,5,6,7,8}
Output: 18
Explanation:The given elements are 4 5 6 7 8
For 4, the maximum sum will be 4 as no
element other than 4 from index 0 to 0
For 5, the maximum sum will be 5 as we cannot
add 4 and 5(neighboring elements).
For 6, the maximum sum will be 10 as we can
add 6 and 4.
For 7, the maximum sum will be 12 as we can
add 7 and 5.
For 8, the maximum sum will be 18 as we can
add 4 and 6 and 8.
 * @author shree
 *
 */
public class DP07_Kadane_Algo {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}


//User function Template for Java

class Solution
{
  //Function to return the maximum sum without adding adjacent elements.
  public long maximumSum(int arr[], int n)
  {
    //Your code here
    if(n==1){
        return (long) arr[0];
    }
    long ans=Math.max(Math.max(arr[0],arr[1]),arr[0]+arr[1]);;
    
    arr[1]=Math.max(arr[1],arr[0]);
  //  ans=Math.max(arr[2],ans);
    for(int i=2;i<n;i++){
        arr[i]=Math.max(arr[i],Math.max(arr[i-1],arr[i]+arr[i-2]));
        ans=Math.max(ans,arr[i]);
    }
    return ans;
  }

}
/*
 * roach:
Intuition
The idea is to explore all possible combinations of including or excluding elements in the sum while making sure that no two adjacent elements are taken. At each step of the recursion, we have two choices:

Include the current element in the sum and skip the adjacent element.
Skip the current element and move on to the next element.
Implementation
Firstly check if all elements are negative then return max(arr[]).
Else return func(arr, sizeOfArray-1).
Implementation of func(arr, i):

Base Cases:
if(i<0) return 0.
if(i is 0) return max(0, arr[0]).
Recursive Cases:
If arr[i] is picked then (arr[i] + func(arr, i - 2)).
If arr[i] is not picked then func(arr, i-1).
Return max of both recursive cases.
code



class Solution{
    public:
    //recursive function to return 
    //the maximum sum without adding adjacent elements.
    long long func(int arr[], int i){
        //base cases
        if(i<0){
            return 0;
        }
        if(i==0){
            return max(0, arr[0]);
        }
        
        //recursive cases:
        
        // if current element is pick then previous cannot be
        // picked
        long long pick = arr[i] + func(arr, i - 2);   
        
        // if current element is not picked then previous
        // element is picked
        long long notPick = func(arr, i - 1);
        
        return max(pick, notPick);
    }
    
    //Function to return the maximum sum without adding adjacent elements.
    long long maximumSum(int arr[], int sizeOfArray){
        int maxx=INT_MIN;
        bool isAllNegative=true;                
        //if all numbers are negative, we search the maximum number.
        for(int i=0;i<sizeOfArray;i++){
           maxx=max(maxx,arr[i]);
           if(arr[i]>0){
               isAllNegative=false;
               break;
           }
        }
        //returning the maximum number if all numbers are negative.
        if(isAllNegative==true){
           return maxx;                     
        }
        
        return func(arr,sizeOfArray-1);         
    }
};
 

Complexity
Time Complexity: O(2n), as every element has 2 choices to pick and not pick, there are n elements.
Auxiliary Space: O(n), as recursion call stack can grow up to max size of n.

Expected Approach:
Intuition
The idea is to dynamic programming to improve time complexity of above solution.

If we use dynamic programming then if once we calculate the maximum sum ending at ith index then we store that sum into dp[i] and if again we require ith value then we can simply use dp[i] value instead of calculating again by calling function, so dynamic programming makes sure that we do not calculate the same value again and again.

So if we are at ith index then we have 2 choices:
Either take ith element and add it into dp[i-2]
Or ignore ith element and so take dp[i-1]
Now store the maximum of both choices in dp[i]
Implementation
Declare an dp array of size sizeOfArray, initialized with all values as 0.
Base Cases:
Initialize dp[0] as maximum of first element or 0.
Initialize dp[1] as maximum of second element, first element or 0.
Run a loop for i from 2 to sizeOfArray-1:
 dp[i] = max(dp[i-2]+arr[i], dp[i-1]), using same recursive formula we used in previous approach.
Check if all elements are negative then return max(arr[]).
Else return dp[sizeOfArray-1].
Let us understand it with the help of an example:
Input: sizeOfArray = 8, 
          arr[] = {-366,  50,  677,  -13,  -33,  -923,  495,  -851}.
          dp[] = {0     ,  50,  677,  677, 677,   677, 1172,  1172}.
All elements are not negative so answer is dp[sizeOfArray-1] which dp[7] = 1172.

code



//Back-end complete function Template for Java

class Solution
{
    //Function to return the maximum sum without adding adjacent elements.
    public long maximumSum(int arr[], int sizeOfArray)
    {
        //dp[] array stores maximum sum at each index.
        long  dp[]=new long[sizeOfArray]; 
        //taking maximum of first element or 0 at dp[0].
        dp[0]=Math.max(dp[0],(long)arr[0]); 
        //taking maximum of second element, first element or 0 at dp[1].
        dp[1]=Math.max(dp[0],(long)arr[1]); 
        
        
        for(int i=2;i<sizeOfArray;i++)
        {
            //storing maximum sum at ith index by using previous values of dp[].
            dp[i]=Math.max(dp[i-2]+arr[i],dp[i-1]);
        }
        
        int maxx=Integer.MIN_VALUE;
        boolean isAllNegative=true;              
        
        //if all numbers are negative, we search the maximum number.
        for(int i=0;i<sizeOfArray;i++)
        {
           maxx=Math.max(maxx,arr[i]);
           if(arr[i]>0)
           {
               isAllNegative=false;
               break;
           }
        
        }
        
        //returning the maximum number if all numbers are negative
        if(isAllNegative==true)
        {
           return maxx;                      
        }
        //else returning the maximum sum.
        else
        return (dp[sizeOfArray-1]);             
    }

}
Complexity
Time Complexity: O(n), as we are iterating over an array of size n.
Auxiliary Space: O(n), as we are using dp array having linear size.

 

Alternate Approach
Intuition
The intuition behind the this approach is to use a single array to keep track of the maximum sum that can be achieved up to each element in the input array. We start by initializing the array in a way that it stores the maximum sum that can be obtained at each position considering only that element. Then, we iteratively update the array to store the maximum sum considering the current element and the previous maximum sums up to two positions back.

Implementation
Initialize the first two elements of the array arr[] in a way that arr[1] stores the maximum of arr[0] and arr[1].
Loop starts from i = 2, as we have already considered the first two elements.
Update arr[i] to store the maximum of the current element arr[i], the maximum sum considering only the previous element arr[i-1], and the maximum sum considering the current element and the maximum sum two positions back arr[i] + arr[i-2]. The Math.max function is used to find the maximum of the three values.
After completing the loop, the maximum sum is stored in arr[sizeOfArray-1], which represents the maximum sum of non-adjacent elements in the input array.
Finally, iterate through the array to find the overall maximum sum and returns it as the result.
code



class Solution
{
  
    public long maximumSum(int arr[], int sizeOfArray)
    {
      arr[1] = Math.max(arr[0],arr[1]);
      for(int i = 2;i<sizeOfArray;i++){
          
          arr[i] = Math.max(arr[i],Math.max(arr[i-1],arr[i]+arr[i-2]));
      }
      long max = arr[0];
      for(int i =0;i<sizeOfArray;i++){
          max = Math.max(max,arr[i]);
      }
      return max;
    }

}
 

Complexity
Time Complexity: O(n),where n is  the size of the input array arr[]. This is because the algorithm iterates through the array once, performing constant-time operations at each step.
Auxiliary Space: O(1), The algorithm uses a single array arr[] of constant size to store intermediate results.

Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

rce Approach:
Intuition
The idea simply runs a loop from every index and checks the max sum we can get for every index.

Implementation
Steps:-

Initialize the answer variable and result array with INT_MIN.
Run a loop from 1 to the size of the array.
Take a temporary sum variable to store the sum starting from the ith index. 
Now run a nested loop from the ith index to the size of the array.
Add the value of the array into the temporary sum and update the result array and answer with the maximum value we get till now.
Now print the result array in which we have stored maximum sum we got at every index.
Return the answer.
code



class Solution
{
    public:
    //Function to print the maximum contiguous subarray sum ending at each 
    //position in the array and return the overall maximum.
    long long maximumSum(int arr[], int sizeOfArray)
    {
       //code here
       long long ans=INT_MIN;
       long long res[sizeOfArray];
       for(int i=0;i<sizeOfArray;i++) { 
           res[i] = INT_MIN;
       }
       for(int i=0;i<sizeOfArray;i++) {
           long long temp_sum=0;
           for(int j=i;j<sizeOfArray;j++) {
               temp_sum = temp_sum+arr[j];
               res[j] = max(res[j], temp_sum);
               ans = max(ans,temp_sum);
           }
       }
       for(int i=0;i<sizeOfArray;i++) {
           cout << res[i] << " ";
       }
       cout << "\n";
       return ans;
    }
};
Complexity:
Time Complexity: O(n2), As we are using a nested loop and both loop runs till the size of the array hence complexity will become O(N2).
Auxiliary Space: O(n), As we are using a result array for storing the maximum sum at every index which takes linear size.

Expected Approach:
Intuition
The idea is to use dynamic programming. By using dynamic programming we can store the maximum sum of elements till the ith index in dp[i] and if we require the maximum sum ending at ith index then we use the value of dp[i] instead of running a loop from 0 to ith index to calculate the sum.

Let dp[i] define the max subarray sum ending at index i, then at each stage we have 2 choices: 
Either take the current element and add it with the previous sum we get.
Or start adding elements into the sum from this index and ignore previous elements which mean we consider subarray from this index.
Implementation
Declare an dp array of size sizeOfArray, initialized with all values as 0.
Initialize dp[0] and variable ans with arr[0].
Run a loop for i from 1 to sizeOfArray-1:
 dp[i] will be max(dp[i-1]+arr[i], arr[i]).
 ans will be max(ans, dp[i]).
Print dp array.
Return ans.
Let us understand it better with the help of an example:
Input: N = 6, arr[] = {5,  -2,  -3,  32,  -5,  65}.
dp[0]=arr[0]=5 , ans = 5
dp[1]=max(5-2,-2)=3 , ans = max(5,3)=5
dp[2]=max(3-3,-3)=0 , ans = max(5,0)=5
dp[3]=max(0+32,32)=32 , ans = max(5,32)=32
dp[4]=max(32-5,-5)=27,  ans = max(32,27)=32
dp[4]=max(27+65,65)=92,  ans = max(32,92)=92
dp[] array             = {5,    3,   0,  32,  27.  92}.
Return ans = 92 as answer.

code



//Back-end complete function Template for Java

class Solution
{
    //Function to print the maximum contiguous subarray sum ending at each 
    //position in the array and return the overall maximum.
    public long maximumSum(int arr[], int sizeOfArray)
    {
        //dp[] array stores maximum sum at each index.
        long  dp[]=new long[sizeOfArray];
        dp[0]=arr[0];
        long  answer=arr[0];
        
        //calculating maximum sum at each index
        //and updating overall maximum value.
        for(int i=1;i<sizeOfArray;i++)
        {
           dp[i]=Math.max(dp[i-1]+arr[i],(long)arr[i]);
           answer=Math.max(answer,dp[i]);
        }
        
        //printing maximum sum at each index.      
        for(int i=0;i<sizeOfArray;i++)
        {
           System.out.print(dp[i]+" ");
        }
        System.out.println();
        
        //returning the overall maximum value.
        return answer;
    }

}
Complexity
Time Complexity: O(n), as we are iterating over an array of size n.
Auxiliary Space: O(n),  This is because it requires an additional array size n to store the possible sum of contiguous elements of the array ending at each position in the array .The space required grows linearly with the input size. 

 

Alternate Approach:
Intuition
The question is demanding to display maximum possible sum of contiguous elements of the array ending at each position in the array so we do not need the array instead we can just use two variables to store current maximum and total maximum and can keep updating it after each iteration. In this way we can reduce space complexity to O(1)

Implementation
Initialize two variables curr_max (maximum sum including the curr index) and total_max(maximum subrray sum encountered till current index) with arr[0]
Display the curr_max
Run a for loop from i = 1
Replace curr_max with maximum of ( curr_max + arr[i] ) or arr[i]
Display the curr_max
If curr_max is greater than total_max replace total_max with curr_max
After the loop finishes Display total_max and return it.
Lets Understand with an example

Input: N = 6, arr[] = {5,  -2,  -3,  32,  -5,  65}.
curr_max=total_max=arr[0]=5 Print curr_max
for i = 1 , curr_max=max(5-2,-2)=3 , total_max= max(5,3)=5 Print curr_max
for i = 1 , curr_max=max(3-3,-3)=0 ,  total_max = max(5,0)=5 Print curr_max
for i = 1 , curr_max=max(0+32,32)=32 , total_max = max(5,32)=32 Print curr_max
for i = 1 , curr_max=max(32-5,-5)=27,   total_max = max(32,27)=32 Print curr_max
for i = 1 , curr_max=max(27+65,65)=92, total_max = max(32,92)=92 Print curr_max
Return  total max = 92 as answer.

code




class Solution
{
    //Function to print the maximum contiguous subarray sum ending at each 
    //position in the array and return the overall maximum.
    public long maximumSum(int arr[], int sizeOfArray)
    {
    int curr_max = arr[0];
    int total_max = arr[0];

    System.out.print(curr_max+ " ");
    for(int i = 1; i< sizeOfArray;i++){
        curr_max = Math.max(curr_max+arr[i],arr[i]);
        System.out.print(curr_max+ " ");
        total_max = Math.max(total_max,curr_max);
        
    }
    System.out.println();
    return total_max;
    }
}
 

Complexity
Time Complexity: O(n),This is because the we are iterating over an array of size sizeOfArray(n) which is linear time complexity.
Auxiliary Space: O(1),This is because the code only uses a constant amount of additional space to store the variables curr_max and total_max. The space required does not depend on the input size. Hence, the space complexity remains constant regardless of the value of sizeOfArray.

Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 */
