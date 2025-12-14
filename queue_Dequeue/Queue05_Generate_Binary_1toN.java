package queue_Dequeue;
/**
 * Generate Binary Numbers
Difficulty: EasyAccuracy: 67.48%Submissions: 50K+Points: 2
Given a number n. The task is to generate all binary numbers with decimal values from 1 to n.

Examples:

Input: n = 2
Output: ["1", "10"]
Explanation: Binary numbers from 1 to 2 are 1 and 10.
Input: n = 5
Output: ["1", "10", "11", "100", "101"]
Explanation: Binary numbers from 1 to 5 are 1 , 10 , 11 , 100 and 101.
Constraints:
1 ≤ n ≤ 106
 * 
 * 
 * @author shree
 *
 */
public class Queue05_Generate_Binary_1toN {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}




class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        // similar to generate random number 
         ArrayList<String> ans=new ArrayList<>();
        Queue<String> q=new ArrayDeque<>();
         ans.add("1");
        if(N==1){
              return ans;
        }
          ans.add("10");
         if(N==2){
            return ans;
        }
        q.add("10");
        q.add("11");
         ans.add("11");
          if(N==3){
            return ans;
        }
        int n=3;
        //q 10 11
        //  100 101 
        //   110 111
        // 100 - 1000 1001
        // 101 - 1010 1011
        String parent;
        String c1;
        String c2;
        while(n!=N){
            parent=q.remove();
            c1=parent+"0";
            c2=parent+"1";
            ans.add(c1);
            n++;
            if(n==N){
                return ans;
            }
            ans.add(c2);
            n++;
            q.add(c1);
            q.add(c2);
            
        }
        
        return ans;
        
    }
    
}
/**

iven a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n. 

Examples: 

Input: n = 2
Output: 1, 10
Explanation: The first two non-zero numbers with digits as 0 and 1 only

Input: n = 5
Output: 1, 10, 11, 100, 101

[Simple Approach] Using Bit Manipulation
We traverse for all numbers from 1 to n and print their binary representations one by one. To get binary representation of a number i, we check the last bit of it by doing bitwise & with 1 and then right shift it to get the next bit.




public class Main {
    public static void genBin(int n) {
        for (int i = 1; i <= n; i++) {
            String s = Integer.toBinaryString(i);  // Get Binary Representation of i
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        genBin(5);
    }
}

Output
1
10
11
100
101
[Interesting Approach] Using queue
This is an interesting approach as it involves a queue. We consider binary representations as a binary tree (root as 1 and every left child as 0 appended and right as 1 appended to the parent) and do level order traversal of the binary tree. We start by enqueuing the first binary number "1". In each iteration, we dequeue the front number, print it, and generate the next two binary numbers by appending "0" and "1" to the front number. These new numbers are then enqueued, and the process repeats until n binary numbers are printed. The queue helps manage the sequence efficiently.




import java.util.LinkedList;
import java.util.Queue;

public class GfG {
    static void generatePrintBinary(int n) {
        Queue<String> q = new LinkedList<>();

        // Enqueue the first binary number
        q.add("1");

        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
        while (n-- > 0) {
            
            // print the front of queue
            String s1 = q.poll();
            System.out.println(s1);

            String s2 = s1;

            q.add(s1 + "0");

            // Append "1" to s2 and enqueue it. 
            // Note that s2 contains the previous front
            q.add(s2 + "1");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        generatePrintBinary(n);
    }
}

Output
1
10
11
100
101


Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/interesting-method-generate-binary-numbers-1-n/
*/