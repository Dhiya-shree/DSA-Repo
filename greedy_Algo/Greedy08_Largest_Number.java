package greedy_Algo;
/**
 * Largest number with given sum
Difficulty: EasyAccuracy: 44.25%Submissions: 55K+Points: 2Average Time: 15m
Geek lost the password of his super locker. He remembers the number of digits N as well as the sum S of all the digits of his password. He know that his password is the largest number of N digits that can be made with given sum S. As he is busy doing his homework, help him retrieving his password.

Example 1:

Input:
N = 5, S = 12
Output:
93000
Explanation:
Sum of elements is 12. Largest possible 
5 digit number is 93000 with sum 12.
 * 
 * 
 * @author shree
 *
 */
public class Greedy08_Largest_Number {

	//Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum)
    {
        // add your code here
       
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(sum>8){
                sb.append("9");
                sum=sum-9;
            }
            else if(sum>0){
                sb.append(String.valueOf(sum));
                sum=0;
            }
            else{
                sb.append("0");
            }
        }
        if(sum>0){
            return "-1";
        }
       
        return sb.toString();
    }
}
