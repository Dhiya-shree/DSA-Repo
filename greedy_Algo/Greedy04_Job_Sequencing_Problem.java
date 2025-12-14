package greedy_Algo;

import java.util.Arrays;

/**
 * 
 * Job Sequencing Problem
 * 
 * 
 * Given N jobs with deadline and profit
 * Find the maximum profit following rules
 * 
 * Rules :
 * Profit if finished within deadline
 * One Unit by every job ( once job done only once and every job takes 1 unit of
 * time )
 * One job takes 1 unit of time
 * Only one job can be assigned at a time
 * Time starts with 0
 * 
 * Job deadline1,profit1 ; deadline2,profit2 ...
 * Need to find maximum profit
 * 
 * Example :
 * 
 * Jobs : J1 J2 J3 J4
 * Deadline 4 1 1 1
 * Profit 70 80 30 100
 * 
 * From 0 time starts
 * At 1 time , complete job J4 profit=100
 * ( J2,J3 can not be done deadline passed No profit )
 * At 2 time , complete job J1 profit= 100+70
 * 
 * Maximum profit : 170
 * 
 * 
 * Solution : O N2
 * 1) Sort jobs in decreasing order of profit
 * 
 * 2) Initialize the result as first job in sorted list
 * Assign latest possible slot
 * 
 * 3) Do following for the remaining :
 * for n-1 jobs
 * 
 * 1) if job can be added
 * 
 * for deadline to 0
 * if any empty slot -> add the curr profit in that slot
 * break
 * 2) else
 * Ignore
 * 
 * DO NOT CARE ABOUT DEADLINE
 * 1,1 1,5 1,10 2,20 5,100 5,500
 * 
 * Maxdeadline is 5
 * So first 5 biggest profit can be taken
 * 
 * But there might be an overlap in deadline , so use slot
 * Consider empty slots from deadline till 0 to fill up
 * 
 * Lateral ignore it
 * 
 * Example
 * 2,100 1,50 2,10 1,20 3,30
 * 
 * Step 1:-
 * Sorted :
 * 2,100 1,50 3,30 1,20 3,30
 * Find max deadline also
 * 
 * 
 * Step 2:-
 * Initialize
 * Create array slot with size as maximum deadline
 * array [3] = ---- , ---- , -----
 * First job put 2,100
 * slot = ----- , 100 , -----
 * 
 * 
 * Step 3:
 * Loop for others 1 to maxDeadLine
 * 
 * if slot empty
 * Fill the value
 * else
 * Ignore
 * 
 * Loop from 1 to maxDeadline while slot length is not filled
 * 
 * for 1
 * set 1,50 slot = 50,100,-----
 * 
 * for 2
 * set 3,30 slot = 50,100,50
 * 
 * Stop
 * Ans : slot 50+100+50
 * 
 * 
 *
 * 
 * Solution 2:
 *
 * 
 * 
 * @author shree
 *
 */
public class Greedy04_Job_Sequencing_Problem {

    public static void main(String[] args) {

        int deadline[] = { 4, 1, 1, 5, 5 };
        int profit[] = { 50, 5, 20, 10, 80 };
        int n = profit.length;

        int maxProfit = JobSequencingSlot(deadline, profit, n);
        System.out.println(" Max profit " + maxProfit);

        maxProfit = NonGreedy(deadline, profit, n);
        // System.out.println(" Max profit "+maxProfit);
    }

    private static int JobSequencingSlot(int[] deadline, int[] profit, int n) {
        // Create jobs
        int jobs[][] = new int[n][2];
        int maxSlot = 0;
        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
            maxSlot = Math.max(maxSlot, deadline[i]);
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(b[1], a[1]));

        // Initialize
        int slot[] = new int[maxSlot];
        slot[jobs[0][0] - 1] = jobs[0][1];
        int deadL = 0, prof = 0;

        for (int i = 1; i < n; i++) {
            deadL = jobs[i][0] - 1;
            prof = jobs[i][1];
            System.out.println(" Curr " + prof + " - " + (deadL + 1));

            // Find empty spot from the dealine to 0
            for (int j = deadL; j >= 0; j--) {
                if (slot[j] < prof) {
                    slot[j] = prof;
                    break;
                }
            }

            System.out.println(" slot " + Arrays.toString(slot));
        }

        int ans = 0;
        for (int i = 0; i < maxSlot; i++) {
            System.out.println(" Consider profit " + slot[i]);
            ans = ans + slot[i];
        }
        return ans;
    }

    private static int NonGreedy(int[] deadline, int[] profit, int n) {
        // Find max deadline
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, profit[i]);
        }

        int slot[] = new int[max];

        for (int i = 0; i < n; i++) {
            // Not possible to fill
            slot[i] = i;
            // Might take n2

        }
        return 0;
    }
}

/*
 * Job Sequencing Problem | Greedy Approach
 * 
 * Problem: Given an array of jobs where every job has a deadline and associated
 * profit if the job is finished before the deadline. It is also given that
 * every job takes a single unit of time, so the minimum possible deadline for
 * any job is 1. How to maximize total profit if only one job can be scheduled
 * at a time.
 * 
 * Examples:
 * Input: Four Jobs with following deadlines and profits
 * JobID Deadline Profit
 * a 4 20
 * b 1 10
 * c 1 40
 * d 1 30
 * Output: Following is maximum profit sequence of jobs
 * c, a
 * 
 * Input: Five Jobs with following deadlines and profits
 * JobID Deadline Profit
 * a 2 100
 * b 1 19
 * c 2 27
 * d 1 25
 * e 3 15
 * Output: Following is maximum profit sequence of jobs
 * c, a, e
 * 
 * 
 * 
 * 
 * This is a standard Greedy Algorithm problem. Following is the greedy
 * algorithm to solve the above problem:
 * 1) Sort all jobs in decreasing order of profit.
 * 2) Initialize the result sequence as the first job in sorted jobs.
 * 3) Do following for remaining n-1 jobs
 * .......a) If the current job can fit in the current result sequence
 * without missing the deadline, add the current job to the result.
 * Else ignore the current job.
 * 
 * 
 * 
 * Implementation:
 * 
 * // Java program to find the maximum profit
 * // job sequence from a given array
 * // of jobs with deadlines and profits
 * import java.util.Arrays;
 * 
 * // A class to represent a job
 * class Job implements Comparable<Job>
 * {
 * char id; // Job Id
 * int dead; // Deadline of job
 * 
 * // Profit if job is over
 * // before or on deadline
 * int profit;
 * 
 * Job(char id, int dead, int profit) {
 * this.id = id;
 * this.dead = dead;
 * this.profit = profit;
 * }
 * // This function is used for sorting all
 * // jobs according to decreasing order of profit
 * 
 * @Override
 * public int compareTo(Job o) {
 * if(this.profit < o.profit)
 * return 1;
 * return -1;
 * }
 * };
 * 
 * class GFG
 * {
 * // Returns minimum number of platforms reqquired
 * static void printJobScheduling(Job arr[], int n)
 * {
 * // Sort all jobs according to
 * // decreasing order of prfit
 * Arrays.sort(arr);
 * 
 * // To store result (Sequence of jobs)
 * int result[] = new int[n];
 * // To keep track of free time slots
 * boolean slot[] = new boolean[n];
 * 
 * // Initialize all slots to be free
 * for (int i=0; i<n; i++)
 * slot[i] = false;
 * 
 * // Iterate through all given jobs
 * for (int i=0; i<n; i++)
 * {
 * // Find a free slot for this job
 * // (Note that we start
 * // from the last possible slot)
 * for (int j=Math.min(n, arr[i].dead)-1; j>=0; j--)
 * {
 * // Free slot found
 * if (slot[j]==false)
 * {
 * result[j] = i; // Add this job to result
 * slot[j] = true; // Make this slot occupied
 * break;
 * }
 * }
 * }
 * 
 * // Print the result
 * for (int i=0; i<n; i++)
 * if (slot[i])
 * System.out.print(arr[result[i]].id + " ");
 * }
 * 
 * // Driver Code
 * public static void main(String args[])
 * {
 * Job arr[] = {new Job('a', 2, 100),
 * new Job('b', 1, 19),
 * new Job('c', 2, 27),
 * new Job('d', 1, 25),
 * new Job('e', 3, 15)};
 * 
 * int n = arr.length;
 * 
 * System.out.print("Following is maximum profit"
 * +" sequence of job : ");
 * 
 * printJobScheduling(arr, n);
 * }
 * }
 * 
 * 
 * Output:
 * Following is maximum profit sequence of job : c a e
 * 
 * 
 * 
 * 
 * Time Complexity of the above solution is O(n2). It can be optimized using
 * Disjoint Set Data Structure. Please refer below post for details.
 * 
 * 
 */

/**
 * *
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Solution Wrong :
 * 
 * 1) Sorting
 * 
 * Sort based on deadline Wrong
 * 1 1 1 4
 * 80 30 100 70
 * 
 * Now sort based on Profit Wrong
 * 1 1 1 4
 * 100 80 30 70
 * 
 * Sorting Algo
 * if o1.deadline > o2.deadline / this.deadline > o.deadline
 * return 1
 * else if o1.deadline == o2.deadline / this.deadline==o.deadline
 * // Compare the profit
 * // Profit on descending O2 first
 * if(o1.profit>o2.profit )
 * return 1
 * else
 * return -1
 * 
 * 
 * Above sorting will not work for
 * 
 * 2 2 3 3
 * 50 10 100 200
 * 
 * Here by your sorting ans will be
 * time 0 50
 * time 1 10
 * time 2 100
 * 
 * Ans: 160
 * But actual ans is 350
 * time 0 50
 * time 1 100
 * time 2 200
 * 
 * 
 * 2) Initialize
 * Profit =0
 * time=0
 * 
 * 
 * 3) Loop
 * for int i=0;i<n;i++
 * 
 * if( deadline > start )
 * add profit
 * /// NO
 * FOCUS HERE !!!!!!!!!!!!!!
 * Time only up by 1 unit
 * Every job takes only 1 unit !!!!!!!!
 * 
 * BELOW TOTALLY WRONG X X X X X X X
 * time=time+deadline
 * 
 * Use below time increase by only 1
 * time=time+1 ONLY INCREMENT BY 1 ///////////////////////////////////////////
 * 
 * 
 * else
 * IGNORE
 * 
 * 
 * 
 */
