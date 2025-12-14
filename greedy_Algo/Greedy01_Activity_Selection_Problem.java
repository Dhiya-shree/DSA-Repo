package greedy_Algo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Activity Selection Problem :
 * 
 * Given a set of acitvity given by pair of start and end time 
 * Given a singe machine that can do only 1 task at a time 
 * Maximize the number of ativity that can be performed on a sngle machine 
 * 
 * 
 * Activity set =(start1,end1) , (start2,end2) ,.....
 * Machine can do 1 task at a time 
 * 
 * Naive solution :
 * Consider every solution as first activiy and recursively check the number of activities 
 * machine can do starting with first one 
 * Activity 0 1 2 3 
 * Machine start with 0 
 *    The combination 
 *    01 - 0123 , 0132 
 *    02 - 0213 , 0231
 *    03 - 0312 , 0321 
 *    
 *  Similarly check for starting with 1,2,3 .
 *  
 *  
 * Efficient solution :
 * Use Greedy Algorithm 
 * 1)
 * Sort based on end time 
 * Start with acivity with least end time 
 * 2)
 * While every activity checked 
 *   Get the next small end time 
 *   Is Feasible ->if start of next small endtime 
 *   greater than curr end time 
 *     Add the activity and consider it as currecnt 
 *   else 
 *     Continue ; 
 *   
 * 3) Count how many times added and return 
 * 
 * 
 *   
 * 
 *  
 * 
 * 
 * 
 * @author shree
 *
 */
public class Greedy01_Activity_Selection_Problem {

	public static void main(String[] args) {
		/*
		  ACTIVITY SELECTION PROBLEM 
		  
		   1) Sort according to finish time 
		   
		   2) Initialize solution as first activity 
		   
		   3) Do following for all activities :
		   
		       a) Curr activity overlap with previous 
		           IGNORE 
		       b) Not overlap 
		           ADD in result 
		 
		 */

		int activity[][]= {{1,3},{3,8},{10,11},{2,4}};
		
		int maxActivity =ActivitySelection(activity); //N LOG N 
		
		System.out.println(" Maximum activity machine can do "+maxActivity);
		
		 maxActivity =ActivitySelectionObject(); //N LOG N 
			
		System.out.println(" Maximum activity machine can do "+maxActivity);
		
	}

	private static int ActivitySelection(int[][] activity) {
		// Sort 
		int n=activity.length;
		
		/////////////Sorting    n Log N 
		MergeSortBasedOnEnd(0,n-1,activity,n);
		System.out.println(" Sorted activity ");
		for(int i=0;i<n;i++) {
			System.out.println(" Activity s-t "+
		          activity[i][0]+"----"+activity[i][1]);
		}
		
		
		///////Initialise 
		int res=1;
		int prevStart=activity[0][0];
		int prevEnd=activity[0][1];
		System.out.println(" Consider activity "+prevStart+"-"+prevEnd);
		int currStart=0;int currEnd=0;
		
		// Loop       N time 
		for(int i=1;i<n;i++) {
			currStart=activity[i][0];
			currEnd=activity[i][1];
			if(currStart<prevEnd) {
				//IGNORE - Overlaps 
			}
			else {
				// add
				res++;
				System.out.println(" Consider activity "+currStart+"-"+currEnd);
			    prevStart=currStart;
			    prevEnd=currEnd;
			}
		}
		
		return res;
	}

	private static void MergeSortBasedOnEnd(int low,int high,int[][] activity, int n) {
		// merge sort 
		if(high>low) {
		int mid=(low + (high-low)/2);
		MergeSortBasedOnEnd(low,mid,activity,n);
		MergeSortBasedOnEnd(mid+1,high,activity,n);
		MergeFinalOnEnd(low,mid,high,activity,n);
		}
	}

	private static void MergeFinalOnEnd(int low, int mid, int high, int[][] activity, int n) {
		// prepare two array 
		
		int n1=mid-low+1;//+1 to consider mid 
	   int n2=high-mid;
		int left[][]=new int [2][n1];
		int right[][]=new int[2][n2];
		
		// Must start with i=0 left filing from i=0 not i=low 
		for(int i=0;i<n1;i++) {
			left[i]=activity[i+low];
		}
		for(int i=0;i<n2;i++) {
			right[i]=activity[i+mid+1];
		}
		
		
		int l=0;int r=0;
		// Pointer to placce correct value in activity array must 
		// MUST be LOW 
		int pointer=low;
		while(l<n1 && r<n2) {
			
			if(left[l][1]<=right[r][1]) {
				activity[pointer]=left[l];
				l++;pointer++;
			}
			else if(left[l][1]==right[r][1]) {
				// code wont execute not needed 
               // Check for start point that has 
				if(left[l][0]>right[r][0]) {
					activity[pointer]=left[l];
					l++;pointer++;
				}
				else {
					activity[pointer]=right[r];
					r++;pointer++;
				}
				
		}
			else {
				activity[pointer]=right[r];
				r++;pointer++;
			}
		}
		
		while(l<n1) {
			activity[pointer]=left[l];
			l++;pointer++;
		}
		
		while(r<n2) {
			activity[pointer]=right[r];
			r++;pointer++;
		}
			
	}
	
	/**
	 * Proof of Activity selection 
	 * 
	 * Counter example 
	 * 
	 *  two solution set s1, s2 
	 *  set1 s1,e1  s2,e2 .....
	 *  set2 sx,ey s2,e3 ......
	 *  
	 *  Consider set 1 and set 2 starting by diffenent set 
	 *  and element is sol2 2 is 1 greater than s1 
	 *  
	 *  Considering s1 and sx has same finish time
	 *  All the remaining set after sx can also come for s2 
	 * 
	 */
	
	private static int ActivitySelectionObject() {
		// object activity 
		ActivityS[] act = {new ActivityS(1,3),
				new ActivityS(10,23),
				new ActivityS(4,8),
				new ActivityS(2,3)};
				
		//Sort 
		maxActivity(act);
		
		///////Initialise 
		int res=1;
		int prev=act[0].end;
		System.out.println(" Consider activity "+act[0].start+"-"+act[0].end);
		int n=act.length;
		// Loop       N time 
		for(int i=1;i<n;i++) {
			
			if(act[i].start<prev) {
				//IGNORE - Overlaps 
			}
			else {
				// add
				res++;
				System.out.println(" Consider activity "+act[i].start+"-"+act[i].end);
			    prev=act[i].end;
			}
		}
		
		return res;

	}

	private static void maxActivity(ActivityS[] act) {
		//sort
		Arrays.sort(act,new ActivityComparator());
	}

}

class ActivityComparator implements Comparator<ActivityS>{

	@Override
	public int compare(ActivityS o1, ActivityS o2) {
		// increase order 
		// Sub second from first 
		
		// Decreasing order
		// Sub first from second 
		
		return o1.end-o2.end;
	}
	
}

class ActivityS{
	int start;int end;
	public ActivityS(int i,int j) {
		// cons 
		start=i;end=j;
	}
}

/*
 * 
 * Activity Selection Problem

You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time. 
 

Example:  

Example 1 : Consider the following 3 activities sorted by
by finish time.
     start[]  =  {10, 12, 20};
     finish[] =  {20, 25, 30};
A person can perform at most two activities. The 
maximum set of activities that can be executed 
is {0, 2} [ These are indexes in start[] and 
finish[] ]

Example 2 : Consider the following 6 activities 
sorted by finish time.
     start[]  =  {1, 3, 0, 5, 8, 5};
     finish[] =  {2, 4, 6, 7, 9, 9};
A person can perform at most four activities. The 
maximum set of activities that can be executed 
is {0, 1, 3, 4} [ These are indexes in start[] and 
finish[] ]

The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the start time is more than or equal to the finish time of the previously selected activity. We can sort the activities according to their finishing time so that we always consider the next activity as minimum finishing time activity.
1) Sort the activities according to their finishing time 
2) Select the first activity from the sorted array and print it. 
3) Do the following for the remaining activities in the sorted array. 
.......a) If the start time of this activity is greater than or equal to the finish time of the previously selected activity then select this activity and print it.


// The following implementation assumes that the activities
// are already sorted according to their finish time
import java.util.*;
import java.lang.*;
import java.io.*;

class ActivitySelection
{
    // Prints a maximum set of activities that can be done by a single
    // person, one at a time.
    //  n   -->  Total number of activities
    //  s[] -->  An array that contains start time of all activities
    //  f[] -->  An array that contains finish time of all activities
    public static void printMaxActivities(int s[], int f[], int n)
    {
    int i, j;
     
    System.out.print("Following activities are selected : \n");
     
    // The first activity always gets selected
    i = 0;
    System.out.print(i+" ");
     
    // Consider rest of the activities
    for (j = 1; j < n; j++)
    {
         // If this activity has start time greater than or
         // equal to the finish time of previously selected
         // activity, then select it
         if (s[j] >= f[i])
         {
              System.out.print(j+" ");
              i = j;
          }
     }
    }
     
    // driver program to test above function
    public static void main(String[] args)
    {
    int s[] =  {1, 3, 0, 5, 8, 5};
    int f[] =  {2, 4, 6, 7, 9, 9};
    int n = s.length;
       
    printMaxActivities(s, f, n);
    }
    
}
 
 


Output
Following activities are selected n0 1 3 4 

How does Greedy Choice work for Activities sorted according to finish time? 
Let the given set of activities be S = {1, 2, 3, ...n} and activities are sorted by finish time. The greedy choice is to always pick activity 1. How come activity 1 always provides one of the optimal solutions. We can prove it by showing that if there is another solution B with the first activity other than 1, then there is also a solution A of the same size with activity 1 as the first activity. Let the first activity selected by B be k, then there always exist A = {B - {k}} U {1}. 

(Note that the activities in B are independent and k has the smallest finishing time among all. Since k is not 1, finish(k) >= finish(1)).

How to implement when given activities are not sorted? 
We create a structure/class for activities. We sort all activities by finish time (Refer sort in C++ STL). Once we have activities sorted, we apply the same algorithm.
Below image is an illustration of the above approach: 
  

Approach for Solving Activity Selection Problem


Below is the implementation of the above approach: 


// Java program for activity selection problem
// when input activities may not be sorted.
import java.io.*;
import java.util.*;

// A job has a start time, finish time and profit.
class Activity 
{
  int start, finish;

  // Constructor
  public Activity(int start, int finish)
  {
    this.start = start;
    this.finish = finish;
  }
}

// class to define user defined comparator
class Compare 
{

  // A utility function that is used for sorting
  // activities according to finish time
  static void compare(Activity arr[], int n)
  {
    Arrays.sort(arr, new Comparator<Activity>()
                {
                  @Override
                  public int compare(Activity s1, Activity s2)
                  {
                    return s1.finish - s2.finish;
                  }
                });
  }
}

// Driver class
class GFG {

  // Returns count of the maximum set of activities that
  // can
  // be done by a single person, one at a time.
  static void printMaxActivities(Activity arr[], int n)
  {
    // Sort jobs according to finish time
    Compare obj = new Compare();
    obj.compare(arr, n);
    System.out.println(
      "Following activities are selected :");

    // The first activity always gets selected
    int i = 0;
    System.out.print("(" + arr[i].start + ", "
                     + arr[i].finish + "), ");

    // Consider rest of the activities
    for (int j = 1; j < n; j++) 
    {

      // If this activity has start time greater than
      // or equal to the finish time of previously
      // selected activity, then select it
      if (arr[j].start >= arr[i].finish)
      {
        System.out.print("(" + arr[j].start + ", "
                         + arr[j].finish + "), ");
        i = j;
      }
    }
  }

  // Driver code
  public static void main(String[] args)
  {

    int n = 6;
    Activity arr[] = new Activity[n];
    arr[0] = new Activity(5, 9);
    arr[1] = new Activity(1, 2);
    arr[2] = new Activity(3, 4);
    arr[3] = new Activity(0, 6);
    arr[4] = new Activity(5, 7);
    arr[5] = new Activity(8, 9);

    printMaxActivities(arr, n);
  }
}

// This code is contributed by Dharanendra L V.
 
 

Output: 

 

Following activities are selected 
(1, 2), (3, 4), (5, 7), (8, 9),

Time Complexity: It takes O(n log n) time if input activities may not be sorted. It takes O(n) time when it is given that input activities are always sorted.
Using STL we can solve it as follows: 


// java program for the above approach
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

  // Pair class
  static class Pair {

    int first;
    int second;

    Pair(int first, int second)
    {
      this.first = first;
      this.second = second;
    }
  }

  static void SelectActivities(int s[], int f[])
  {

    // Vector to store results.
    ArrayList<Pair> ans = new ArrayList<>();

    // Minimum Priority Queue to sort activities in
    // ascending order of finishing time (f[i]).
    PriorityQueue<Pair> p = new PriorityQueue<>(
      (p1, p2) -> p1.first - p2.first);

    for (int i = 0; i < s.length; i++) {
      // Pushing elements in priority queue where the
      // key is f[i]
      p.add(new Pair(f[i], s[i]));
    }

    Pair it = p.poll();
    int start = it.second;
    int end = it.first;
    ans.add(new Pair(start, end));

    while (!p.isEmpty()) {
      Pair itr = p.poll();
      if (itr.second >= end) {
        start = itr.second;
        end = itr.first;
        ans.add(new Pair(start, end));
      }
    }
    System.out.println(
      "Following Activities should be selected. \n");

    for (Pair itr : ans) {
      System.out.println(
        "Activity started at: " + itr.first
        + " and ends at  " + itr.second);
    }
  }

  // Driver Code
  public static void main(String[] args)
  {

    int s[] = { 1, 3, 0, 5, 8, 5 };
    int f[] = { 2, 4, 6, 7, 9, 9 };

    // Function call
    SelectActivities(s, f);
  }
}

// This code is contributed by Kingash.

Output
Following Activities should be selected. 

Activity started at: 1 and ends at  2
Activity started at: 3 and ends at  4
Activity started at: 5 and ends at  7
Activity started at: 8 and ends at  9
 * 
 */
