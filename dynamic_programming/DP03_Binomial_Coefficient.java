package dynamic_programming;

public class DP03_Binomial_Coefficient {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}
/**
Nth Catalan Number
Difficulty: MediumAccuracy: 31.06%Submissions: 135K+Points: 4
Given a number n. The task is to find the nth catalan number.
The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
Catalan Number for n is equal to the number of expressions containing n pairs of parenthesis that are correctly matched, i.e., for each of the n(' there exist n ')' on there right and vice versa.
Note: Positions start from 0 as shown above.
rute Force Approach
Intuition
 According to the definition of the Catalan number itself, which is given by the recurrence relation:

Catalan(n) = Summation of (Catalan(i) * Catalan(n-i-1)) for i = 0 to n-1.
In simple terms, the nth Catalan number is the sum of products of Catalan numbers for all possible ways to divide a sequence of n elements into two non-empty subsequences.

Implementation
The base case of the recursion is handled using the condition if (n <= 1), where the function returns 1 when n is 0 or 1. For these values, the Catalan number is defined as 1.
For larger values of n, the function proceeds with a recursive approach to calculate the Catalan number. The function uses the recurrence relation of Catalan numbers: Catalan(n) = Σ (Catalan(i) * Catalan(n - i - 1)), for i = 0 to n - 1. Here, Σ represents the summation.
For the loop for (int i = 0; i < n; i++), the function iterates from i = 0 to i = n - 1, and for each i, it calculates Catalan(i) * Catalan(n - i - 1). The result of this multiplication is added to the ans.
The function recursively calls itself to calculate the Catalan numbers for i and n - i - 1. 
The ans variable is updated with the sum of all the products of Catalan numbers for the values of i from 0 to n - 1.
Finally, the function returns the calculated ans, which represents the nth Catalan number.
Code



class Solution
{
    public:
    //Function to find the nth catalan number.
    int findCatalan(int n) 
    {
         if(n<=1) return 1;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=findCatalan(i)*findCatalan(n-i-1);
        }
        return ans;
    }
};
Complexity
Time Complexity: O(4^n),The function makes a recursive call for each value from 0 to n-1, and for each recursive call, it further makes two additional recursive calls (one with i and the other with n-i-1). Therefore, the total number of recursive calls made by the function can be represented by the recurrence relation:

T(n) = T(0) + T(1) + T(2) + ... + T(n-1)

This recurrence relation represents the sum of all Catalan numbers from 0 to n-1. The nth Catalan number itself is known to be approximately equal to (4^n)/(n*sqrt(n)). As n grows, the time complexity becomes exponential due to the increasing number of recursive calls.Hence, the time complexity of the findCatalan function is O(4^n).
Auxiliary Space: O(n) : In each recursive call, some variables are stored in the stack frame, such as the value of n and ans. Since each recursive call creates two more recursive calls (unless the base case is reached), the maximum depth of the call stack will be equal to the height of the binary tree formed by the recursive calls.

The height of this binary tree can be represented by the recurrence relation:

H(n) = H(0) + H(1) + H(2) + ... + H(n-1)

This recurrence relation represents the sum of all heights of binary trees with nodes from 0 to n-1. Since the height of a binary tree with n nodes is O(n), the maximum depth of the call stack is O(n).

Expected Approach:
Intuition
The idea is to use following formula:


 
Implementation
Base case, if n is 0 or n is 1, then return 1.
Create an array dp[] of size n+1 for storing ith Catalan number.
Initialize, dp[0] and dp[1] = 1
Loop through i = 2 to the given Catalan number n: 
   Nested loop through j = 0 to j < i and Keep adding value of dp[j] * dp[i – j – 1] into dp[i].
Finally, return dp[n].
Example
n=4
output= 14


 
code



class Solution {
    public static int findCatalan(int n) {
        // code here
        if (n == 0 || n == 1) {
            return 1;
        }

        int dp[] = new int[n + 1];
        // Initializing dp[0] and dp[1] as 1
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + (dp[j] * dp[i - j - 1]));
            }
        }

        // returning the nth catalan number.
        return dp[n];
    }
}
Complexity
Time Complexity: O(n^2), as we are using two nested loops.
Auxiliary Space: O(n), as we are using dp array having linear size.

Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/program-nth-catalan-number/
*/
