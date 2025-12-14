package queue_Dequeue;
/**
 * Gas Station
Difficulty: MediumAccuracy: 34.79%Submissions: 199K+Points: 4Average Time: 20m
There are some gas stations along a circular route. You are given two integer arrays gas[] denoted as the amount of gas present at each station and cost[] denoted as the cost of travelling to the next station. You have a car with an unlimited gas tank. You begin the journey with an empty tank from one of the gas stations. Return the index of the starting gas station if it's possible to travel around the circuit without running out of gas at any station in a clockwise direction. If there is no such starting station exists, return -1.
Note: If a solution exists, it is guaranteed to be unique.

Examples:

Input: gas[] = [4, 5, 7, 4], cost[]= [6, 6, 3, 5]
Output: 2
Explanation: It is possible to travel around the circuit from station at index 2. Amount of gas at station 2 is (0 + 7) = 7.
Travel to station 3. Available gas = (7 – 3 + 4) = 8.
Travel to station 0. Available gas = (8 – 5 + 4) = 7.
Travel to station 1. Available gas = (7 – 6 + 5) = 6.
Return to station 2. Available gas = (6 – 6) = 0.
Input: gas[] = [1, 2, 3, 4, 5], cost[] = [3, 4, 5, 1, 2]
Output: 3
Explanation: It is possible to travel around the circuit from station at index 3. Amount of gas at station 3 is (0 + 4) = 4.
Travel to station 4. Available gas = 4 – 1 + 5 = 8.
Travel to station 0. Available gas = 8 – 2 + 1 = 7.
Travel to station 1. Available gas= 7 – 3 + 2 = 6.
Travel to station 2. Available gas = 6 – 4 + 3 = 5.
Travel to station 3. The cost is 5. The gas is just enough to travel back to station 3.
Input: gas[] = [3, 9], cost[] = [7, 6]
Output: -1
Explanation: There is no gas station to start with such that you can complete the circuit.
Constraints:
1 ≤ gas.size(), cost.size() ≤ 106
1 ≤ gas[i], cost[i] ≤ 103


 * 
 * 
 * @author shree
 *
 */
public class Queue07_Circular_Tour_Medium {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}
class Solution {
    public int startStation(int[] gas, int[] cost) {
        // Your code here
        
        
        int n=cost.length;
        
        if(n==1){
            return 0;
        }
        
        if(n==1){
            if((cost[0]+cost[1])>=(gas[0]+gas[1])){
                return ((gas[0]-cost[0]>=gas[1]-cost[1]))?0:1;
            }
            return -1;
        }
        
        
        Queue<Integer> q=new ArrayDeque<Integer>();
        int i=0;
        int netGas=0;
        int netCost=0;
        while(i<n){
            int a=i;int need=0;int remain=0;
            if(gas[i]<cost[i]){
            
            while(i<n && gas[i]<cost[i]){
                 remain=gas[i]+remain;
                 need=cost[i]+need;
                 netGas=netGas+gas[i];
                 netCost=netCost+cost[i];
                i++;
                
            }
            q.add(a);
            gas[a]=remain;
            cost[a]=need;
            }
            else{
                remain=0;need=0;
             while(i<n && remain>=need){
                 remain=gas[i]+remain;
                 need=cost[i]+need;
                  netGas=netGas+gas[i];
                 netCost=netCost+cost[i];
                i++;
                
            }
            q.add(a);
            gas[a]=remain;
            cost[a]=need;
            
            }
            
        }
        // - + 
        // - + - 
        // + - +
        // - + - +
       /*        System.out.println(q.toString());
        System.out.println(Arrays.toString(gas));
        System.out.println(Arrays.toString(cost));*/
        int ans=-1;int need=0;int remain=0;
        n=q.size();
        while(!q.isEmpty() && n-->0){
            int curr=q.peek();
            if(gas[curr]<cost[curr]){
                q.poll();
                q.add(curr);
            }
            else{
                ans=curr;
                need=0;remain=0;
                while(!q.isEmpty() && remain>=need){
                    
                    curr=q.poll();
                    remain=gas[curr]+remain;
                 need=cost[curr]+need;
               //  System.out.println(curr+" "+remain+" "+need);
                }
               
                if(q.isEmpty() && remain>=need){
                    return ans;
                }
                
                cost[curr]=need;
                gas[curr]=remain;
                q.add(curr);
            }
        }
        
      /*  System.out.println(q.toString());
        System.out.println(Arrays.toString(gas));
        System.out.println(Arrays.toString(cost));*/
        return -1;
    }
}/*

There are n gas stations along a circular tour, where the amount of gas at the ith gas station is gas[i]. You have a car with a gas tank of unlimited capacity and it costs cost[i] of gas to travel from the ith station to its next station. You begin the journey with an empty tank at one of the gas station.
Given two integer arrays gas[] and cost[], the task is to return the starting gas station's index if you want to travel around the circular tour once in the clockwise direction, otherwise return -1.

Note: If a solution exists, it is guaranteed to be unique.

Examples:

Input: gas[] = [4, 5, 7, 4], cost[] = [6, 6, 3, 5]
Output: 2
Explanation: Start at gas station at index 2 and fill up with 7 units of gas. Your tank = 0 + 7 = 7

Travel to station 3. Available gas = (7 - 3 + 4) = 8.
Travel to station 0. Available gas = (8 - 5 + 4) = 7.
Travel to station 1. Available gas = (7 - 6 + 5) = 6.
Return to station 2. Available gas = (6 - 6) = 0.
Therefore, return 2 as the starting index.

Input: gas[] = [1, 2 ,3 ,4, 5], cost[] = [3, 4, 5, 1, 2]
Output: 3
Explanation: Start at gas station 3 (index 3) and fill up with 4 units of gas. Your tank = 0 + 4 = 4

Travel to station 4. Available gas = 4 - 1 + 5 = 8
Travel to station 0. Available gas = 8 - 2 + 1 = 7
Travel to station 1. Available gas= 7 - 3 + 2 = 6
Travel to station 2. Available gas = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. The gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.

Input: arr[] = [3, 9], cost[] = [7, 6]
Output: -1
Explanation: There is no gas station to start with such that you can complete the tour.

Table of Content

[Naive Approach] Considering Every Index as Starting Point - O(n^2) Time and O(1) Space
[Expected Approach 1] Greedy Approach - O(n) Time and O(1) Space
[Expected Approach 2] Greedy Approach in One Pass - O(n) Time and O(1) Space
[Naive Approach] Considering Every Index as Starting Point - O(n^2) Time and O(1) Space
The simplest approach is to consider each index as a starting point and check if a car can complete the circular tour starting from that index. If we find a valid starting point, we will return it.




// Java program to find starting index of circular Tour
// by considering each index as starting point.

import java.util.*;

class GfG {
    static int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int startIdx = -1;
        for (int i = 0; i < n; i++) {
            
            // Current Available gas
            int currGas = 0;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                
                // Circular Index
                int idx = (i + j) % n;
                currGas = currGas + gas[idx] - cost[idx];
                
                // If Available gas is less than zero, then it isn't
                // possible to proceed further with this starting point
                if (currGas < 0) {
                    flag = false;
                    break;
                }
            }
            
          	// If flag is true, then we have found
      		// the valid starting point
            if (flag) {
                startIdx = i;
                break;
            }
        }
        
        return startIdx;
    }
    
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(startStation(gas, cost));
    }
}

Output
3
[Expected Approach 1] Greedy Approach - O(n) Time and O(1) Space
We start by assuming the 0th index as the starting point for the circular tour. As we traverse the array, we calculate the available gas at each gas station, which is the previously available gas + gas[i] - cost[i]. If, at any station i, the available gas drops below zero, it indicates that a car cannot proceed to the next station (i + 1) from the current starting point. In such a case, we update the starting point to i + 1 and continue the process. After completing the traversal of the array, we check whether the starting point is valid for the circular tour.

If a car starts at gas station A and cannot reach gas station B, then any gas station located between A and B cannot help us reach B either. But why?

If we start at A and are unable to reach B, but we can reach all the stations up to B-1. Let's assume a gas station C (C<=B-1) located between station A and B. When we arrive at C from A, we must have had a positive amount of gas in our tank. Therefore, if we can't reach B starting with positive amount of gas at C, it would be impossible to reach B from C with a zero amount of gas.




// Java program to find starting index of circular Tour
// using greedy approach

import java.util.*;

class GfG {
    static int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int startIdx = 0;

        // Initially car tank is empty
        int currGas = 0;

        for (int i = 0; i < n; i++) {
            currGas = currGas + gas[i] - cost[i];

            // If currGas becomes less than zero, then
            // It's not possible to proceed with this startIdx
            if (currGas < 0) {
                startIdx = i + 1;
                currGas = 0;
            }
        }

        // Checking if startIdx can be a valid 
    	// starting point for the Circular tour
        currGas = 0;
        for (int i = 0; i < n; i++) {

            // Circular Index
            int idx = (i + startIdx) % n;
            currGas = currGas + gas[idx] - cost[idx];
            if (currGas < 0)
                return -1;
        }

        return startIdx;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(startStation(gas, cost));
    }
}



Output
3
[Expected Approach 2] Greedy Approach in One Pass - O(n) Time and O(1) Space
This approach is optimization for the previous one. After completing the entire traversal of the array, instead of checking the validity by circularly traversing from the starting index, we calculate the total gas remaining (net gas and the cost difference). If the difference is greater than or equal to zero, then it's obvious that the starting point is valid; otherwise, it is not possible to complete a circular loop.

gas-station-3.webpgas-station-3.webp







// Java program to find starting index of circular Tour
// using greedy approach in one pass

class GfG {
    static int startStation(int[] gas, int[] cost) {
        int n = gas.length;

        // Variables to track total and current remaining gas
        int totalGas = 0;
        int currGas = 0;
        int startIdx = 0;

        // Traverse through each station to calculate remaining
        // gas in the tank, and total gas
        for (int i = 0; i < n; i++) {
            currGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];

            // If currGas is negative, circular tour can't
            // start with this index, so update it to next one
            if (currGas < 0) {
                currGas = 0;
                startIdx = i + 1;
            }
        }

        // No solution exists
        if (totalGas < 0)
            return -1;

        return startIdx;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(startStation(gas, cost));
    }
}

Output
3
Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
Also Explore o
*/

