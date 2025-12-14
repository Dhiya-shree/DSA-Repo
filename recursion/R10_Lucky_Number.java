package recursion;
/**
 * 
 * Lucky Numbers
Difficulty: MediumAccuracy: 30.35%Submissions: 124K+Points: 4
Lucky numbers are subset of integers. Process of arriving at lucky numbers is:
Take the set of integers 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,……
First, delete every second number, we get following reduced set.
1, 3, 5, 7, 9, 11, 13, 15, 17, 19,…………
Now, delete every third number, we get
1, 3, 7, 9, 13, 15, 19,….….
Continue this process indefinitely……
Any number that does NOT get deleted due to above process is called “lucky”.

You are given a number N, you need to tell whether the number is lucky or not. If the number is lucky return 1 otherwise 0.

Example 1:

Input:
N = 5
Output: 0
Explanation: 5 is not a lucky number as it gets 
deleted in the second iteration.
Example 2:

Input:
N = 19
Output: 1
Explanation: 19 is a lucky number because 
it does not get deleted throughout the process.
Your Task:
You don't need to read input or print anything. You only need to complete the function isLucky() that takes N as parameter and returns either False if the N is not lucky else True.

Constraints:
1 <= N <= 105
 * 
 * @author shree
 *
 */
public class R10_Lucky_Number {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}
class Solution
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        // Your code here
        if(n%2==0){
            return false;
        }
        
        ArrayList<Integer> arr=new ArrayList<Integer>();
        
        for(int i=1;i<=n;i=i+2){
            arr.add(i);
        }
        
        
        return recur(arr,3,n);
        
    }
    
    public static boolean recur(ArrayList<Integer> arr,int d, int l){
    
        if(arr.size()<d){
            if(arr.get(arr.size()-1)==l){
                return true;
            }
            return false;
        }

        
        if(arr.size()<0){
            return true;
        }
        if(arr.size()==1){
            
            if(arr.get(0)!=l){
                return true;
            }
            else{
                return false;
            }
            
        }
        
        ArrayList<Integer> arr2=new ArrayList<Integer>();
        int n=arr.size()-1;
        int counter=0;
        for(int i=0;i<=n;i++){
            counter++;
            if(counter==d){
               counter=0;
               if(i==n){
                   return false;
               }
            }
            else{
                arr2.add(arr.get(i));
            }
        }
     //  System.out.println(arr2);
        
        return recur(arr2,d+1,l);
    }
}
/**
Expected Approach:
Intuition:
The idea is to stimulate the process.
Before every iteration, if we calculate the position of the given number, then in a given iteration, we can determine if the number will be deleted. Suppose the calculated position for the given number is P before some iteration, and each ith number is going to be removed in this iteration, i

if P < i then the input number is lucky, 
if P is such that P%i == 0 (i is a divisor of P), then the input is not lucky. 
Implementation:
Copy-of-Copy-of-Copy-of-P-(1)


Call the check function with two parameters n (the number to check) and counter (the current step in the process).
The check function is a recursive function that checks if a number n is lucky by simulating the process described above.
If counter is less than or equal to n, it checks if n is divisible by counter. If it is, the number should be removed, so the function returns false. If not, it calculates the next position of n by subtracting (n/counter) and increments counter by 1.
The function then makes a recursive call with the updated n and counter.
If counter becomes greater than n which is else condition, then the function returns true, indicating that n is a lucky number.
Proof:
So let's say we started with N



Copy-of-Copy-of-Copy-of-P-(2)-(1)


So we can see that at the ith iteration we start with the value N/(i+1).

Now we will stop at the ith iteration if (i+1)>N/(i+1)  (assuming that the number is lucky because if it is unlucky then we will be returning some way between and thus time complexity will be less for the unlucky numbers).

This means (i+1)*(i+1)>N 

 i=sqrt(N) 

Code:




class Solution
{
    public static boolean check(int n,int counter)
    {
        if(counter<=n){
            if(n%counter==0)
                return false;
		    // calculate next position of input number
		    n=n-n/counter;
		    counter++;
		    // make recursive call with updated counter 
		    // and position return check(n, counter);
		    return check(n, counter);
        }    
       	else
       		return true;
    }
    
    
    public static boolean isLucky(int n)
    {
        return check(n,2);
    }
    
}
Complexity:
Time Complexity: O(sqrt(N)) please see below proof section for the proof.
Space Complexity: O(sqrt(N)) please see below proof section for the proof.



*/