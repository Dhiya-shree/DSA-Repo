package Sort_Types_Problem;

import java.util.Arrays;

/**
 * Problem #1 : Merge overlapping interval 
 *   {1,4} {2,7} - merge {1,7}
 *   {1,4} {6,7} - merge NO
 * 
 * 1) Find larger STARTING in two interval (a,c) in {a,b}{c,d}
 * 2) If the larger(A) is found between other interval { c -d}
 * 
 * or 
 * 
 * 1) Find larger ENDING in two interval (b,d) in {a,b}{c,d}
 * 2) If the smaller b is found between other interval { c -d}
 * 
 * 
 * Sol: 
 * 
 * 1) Sort based on StTARTING 
 * 2) For i in 1 to n-1 
 *        if( arr[1][0] is between arr[0][0],arr[0][1]) 
 *            then merge ....
 *            Second element a-> Min of arr[0][0] , arr[1][0]
 *            Second element b-> Max of arr[0][1] , arr[1][1]
 *            DELETE First element , as merged is updated in second 
 *            N-- size decrease 
 *       else 
 *            increment i++ ; continue ;
 *            
 * As we have sorted , merging with linear traversal is more than enough .
 *       
 *       Time Complexity: O(N*log(N))
 *       Auxiliary Space Complexity: O(1)
 *       
 * Merge Overlapping Intervals Space Optimized Approach
The above solution requires O(n) extra space for the stack. We can avoid the use of extra space by doing merge operations in place. Below are detailed steps. 

Follow the steps mentioned below to implement the approach:

Sort all intervals in increasing order of start time.
Traverse sorted intervals starting from the first interval, 
Do the following for every interval.
If the current interval is not the first interval and it overlaps with the previous interval,
 then merge it with the previous interval. Keep doing it while the interval overlaps with the previous one.         
 Otherwise, Add the current interval to the output list of intervals.
Below is the implementation of the above approach:

 
 * 
 * 
 * Problem #2 : Meeting the maximum guests
 * You are given arrival and departure times of the guests, you need to find the minimum time interval to attend the party so that there are maximum people at the party.
 * 
 * Party party yeah ...
 * 
 * Time 0000 to 2359 
 * WE have two array arrival[] and departure[]
 * There we have people coming and going  
 * 
 * Oppositite to merging with interval 
 *  Same ans instead of merging with {1,5}{3,10} as {1,10}
 *  To find least time merge as {1,5}{3,10} as {3,5}
 *  
 *   * 1) Find larger STARTING in two interval (a,c) in {a,b}{c,d}
 * 2) If the larger(A) is found between other interval { c -d}
 * 
 * or 
 * 
 * 1) Find larger ENDING in two interval (b,d) in {a,b}{c,d}
 * 2) If the smaller b is found between other interval { c -d}
 * 
 * Merge - min of starting and min of ending 
 *  
 * Easy solution :
 * 
 * 1) Put all arrival in 1 array and sort 
 * 2) Put all depature in 2 array and sort 
 * 
 * 3) Run loop till i<arr1 len && j<arr2 len
 *     if(arr1<=dep1)
 *          i++
 *          noOfPerson++
 *     else
 *         noOfperson--
 *         j++
 *         
 *     max=Maximum of res 
 *     
 * Return res 
 * 
 * onsider a big party where a log register for guest's entry and exit times is maintained. Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
Example : 

Input: arrl[] = {1, 2, 9, 5, 5}
       exit[] = {4, 5, 12, 9, 12}
First guest in array arrives at 1 and leaves at 4, 
second guest arrives at 2 and leaves at 5, and so on.

Output: 5
There are maximum 3 guests at time 5.  
Below is a Simple Method to solve this problem.
1) Traverse all intervals and find min and max time (time at which first guest arrives and time at which last guest leaves)
2) Create a count array of size 'max - min + 1'. Let the array be count[].
3) For each interval [x, y], run a loop for i = x to y and do following in loop. 
     count[i - min]++;
4) Find the index of maximum element in count array. Let this index be 'max_index', return max_index + min.
Above solution requires O(max-min+1) extra space. Also time complexity of above solution depends on lengths of intervals. In worst case, if all intervals are from 'min' to 'max', then time complexity becomes O((max-min+1)*n) where n is number of intervals. 
An Efficient Solution is to use sorting n O(nLogn) time. The idea is to consider all events (all arrivals and exits) in sorted order. Once we have all events in sorted order, we can trace the number of guests at any time keeping track of guests that have arrived, but not exited.
Consider the above example. 

    arr[]  = {1, 2, 10, 5, 5}
    dep[]  = {4, 5, 12, 9, 12}

Below are all events sorted by time.  Note that in sorting, if two
events have same time, then arrival is preferred over exit.
 Time     Event Type         Total Number of Guests Present
------------------------------------------------------------
   1        Arrival                  1
   2        Arrival                  2
   4        Exit                     1
   5        Arrival                  2
   5        Arrival                  3    // Max Guests
   5        Exit                     2
   9        Exit                     1
   10       Arrival                  2 
   12       Exit                     1
   12       Exit                     0 

Total number of guests at any time can be obtained by subtracting 
total exits from total arrivals by that time.
So maximum guests are three at time 5.
Following is the implementation of above approach. Note that the implementation doesn’t create a single sorted list of all events, rather it individually sorts arr[] and dep[] arrays, and then uses merge process of merge sort to process them together as a single sorted array. 
\
Time Complexity : O(max(departure time)) 
Auxiliary Space : O(max(departure time)) 


 *  
 * @author shree
 *
 */

class Party implements Comparable<Party>{
	int start;
	 int end;
	 int  noOfPerson;
	public Party(int i, int j) {
		this.start=i;
		this.end=j;
		this.noOfPerson=1;
		
	}
	
	@Override
	public int compareTo(Party o) {
		// Compare to for increasing give object at end , for decrease obj at start 
		return (this.start-o.start);
	}
}
class Interval implements Comparable<Interval>{
	int start;
	 int end;
	public Interval(int i, int j) {
		this.start=i;
		this.end=j;
		
	}
	
	@Override
	public int compareTo(Interval o) {
		// Compare to for increasing give object at end , for decrease obj at start 
		return (this.start-o.start);
	}


//	Interval(int start,int end){
//	int start1=this.start;
//	int end1=this.end;
//	}
}
public class Sort20_Merge_OverLapping_Interval {

	public static void main(String[] args) {
		
		Interval inter[]=  {new Interval(1,5),
				new Interval(2,7),
				new Interval(8,15),
				new Interval(16,24),
				new Interval(25,230),
				new Interval(25,25)};
		
		int n=inter.length;
		
		for(int i=0;i<n;i++) {
			if(inter[i].start!=-1) {
				System.out.println(" Pair "+inter[i].start+" & "+inter[i].end);
			}
		}
		MergeIntervalWithoutOverLap(inter,n);
		
		Party party[]=  {new Party(1,5),
				new Party(2,7),
				new Party(8,15),
				new Party(16,24),
				new Party(25,230),
				new Party(25,25)};
		
		int n2=party.length;
		
		for(int i=0;i<n;i++) {
			if(party[i].start!=-1) {
				System.out.println(" Pair "+party[i].start+" & "+party[i].end);
			}
		}
		MeetMaximumNoOfGuests(party,n2);
		
		int partyGoG[][]= {{1,5},{2,7},{8,15},{16,24},{25,230},{25,25}};
		int ans= FindMaxMeeting(partyGoG);
		System.out.println(" Meet is "+ans);
		
		int start[]= {1,2,8,6,25,25};
		int end[]= {5,7,15,24,25,230};
		int n3=start.length;
		maxOverlapGoG(start, end, n3);
		
	}

	public static void maxOverlapGoG(int []start,int [] end ,int n)
	{
	    // Finding maximum starting time
	    int maxa = Arrays.stream(start).max().getAsInt();
	    
	    // Finding maximum ending time
	    int maxb = Arrays.stream(end).max().getAsInt();
	    
	    int maxc = Math.max(maxa,maxb); 
	        
	    int []x = new int[maxc + 2];
	    Arrays.fill(x, 0);
	        
	    int cur=0,idx=0;

	    // Creating an auxiliary array
	    for(int i = 0; i < n; i++)
	    {
	        // Lazy addition
	        ++x[start[i]];
	        --x[end[i]+1];
	    }
	        
	    int maxy=Integer.MIN_VALUE;
	    
	    //Lazily Calculating value at index i
	    for(int i = 0; i <= maxc; i++) 
	    {
	        cur+=x[i];
	        if(maxy < cur)
	        {
	            maxy = cur;
	            idx = i;
	            
	        }         
	    }
	        System.out.println("Maximum value is:"+
	                        maxy+" at position: "+idx+"");
	        
	} 
	
	private static int FindMaxMeeting(int[][] party) {
		// Create two array depa and arraival 
		int n=party.length;
		int arr[]=new int[n];
		int dep[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=party[i][0];
			dep[i]=party[i][1];
		}
		// WE have arr and dep - sort and work 
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		// Have similar to partition fun
		int i=0,j=0;
		int max=-1;
		int curPerson=0;
		while(i<n && j<n) {
			if(arr[i]<=dep[j]) {
				curPerson++;
				i++;
			}
			else {
				curPerson--;
				j++;
			}
			max=Math.max(max, curPerson);
		}
		return max;
	}

	private static void MeetMaximumNoOfGuests(Party[] party, int n) {
		// Sort based on start and check mergeale
				System.out.println(" Unsorted ");
				for(int i=0;i<n;i++) {
					if(party[i].start!=-1) {
						System.out.println(" Pair "+party[i].start+" & "+party[i].end);
					}
				}
				Arrays.sort(party);
				System.out.println(" Sorted ");
				for(int i=0;i<n;i++) {
					if(party[i].start!=-1) {
						System.out.println(" Pair "+party[i].start+" & "+party[i].end);
					}
				}
				// Now we have sorted array 
				int start_new=0;
				int end_new=0;
				int totPer=0;
				for(int i=1;i<n;i++) {
					if(party[i].start>=party[i-1].start &&
							party[i].start<=party[i-1].end ) {
						//Can merge 
						start_new= Math.max(party[i].start, party[i-1].start);
						end_new= Math.min(party[i].end, party[i-1].end);
						totPer=party[i].noOfPerson+party[i-1].noOfPerson;
						// Putting -ve in old 
						party[i-1].start=-1;
						party[i-1].end=-1;
						party[i-1].noOfPerson=-1;
						
						//Putting merged val in new 
						party[i].start=start_new;
						party[i].end=end_new;
						party[i].noOfPerson=totPer;
					}
				}		
				int maxval=-1;
				System.out.println(" Sorted + Merged : ");
					for(int i=0;i<n;i++) {
						if(party[i].start!=-1) {
							maxval=Math.max(maxval,party[i].noOfPerson);
							System.out.println(" Pair "+party[i].start+" & "+party[i].end+" has "+party[i].noOfPerson);
						}
					}

			}
		

	private static void MergeIntervalWithoutOverLap(Interval[] inter, int n) {
		// Sort based on start and check mergeale
		System.out.println(" Unsorted ");
		for(int i=0;i<n;i++) {
			if(inter[i].start!=-1) {
				System.out.println(" Pair "+inter[i].start+" & "+inter[i].end);
			}
		}
		Arrays.sort(inter);
		System.out.println(" Sorted ");
		for(int i=0;i<n;i++) {
			if(inter[i].start!=-1) {
				System.out.println(" Pair "+inter[i].start+" & "+inter[i].end);
			}
		}
		// Now we have sorted array 
		int start_new=0;
		int end_new=0;
		for(int i=1;i<n;i++) {
			if(inter[i].start>=inter[i-1].start &&
					inter[i].start<=inter[i-1].end ) {
				//Can merge 
				start_new= Math.min(inter[i].start, inter[i-1].start);
				end_new= Math.max(inter[i].end, inter[i-1].end);
				
				// Putting -ve in old 
				inter[i-1].start=-1;
				inter[i-1].end=-1;
				
				//Putting merged val in new 
				inter[i].start=start_new;
				inter[i].end=end_new;
			}
		}		
		System.out.println(" Sorted + Merged : ");
			for(int i=0;i<n;i++) {
				if(inter[i].start!=-1) {
					System.out.println(" Pair "+inter[i].start+" & "+inter[i].end);
				}
			}

	}

}
/*
 * 
 * // C++ program to merge overlapping Intervals in
// O(n Log n) time and O(1) extra space.
#include <bits/stdc++.h>
using namespace std;

// An Interval
struct Interval {
	int s, e;
};

// Function used in sort
bool mycomp(Interval a, Interval b) { return a.s < b.s; }

void mergeIntervals(Interval arr[], int n)
{
	// Sort Intervals in increasing order of
	// start time
	sort(arr, arr + n, mycomp);

	int index = 0; // Stores index of last element
	// in output array (modified arr[])

	// Traverse all input Intervals
	for (int i = 1; i < n; i++) {
		// If this is not first Interval and overlaps
		// with the previous one
		if (arr[index].e >= arr[i].s) {
			// Merge previous and current Intervals
			arr[index].e = max(arr[index].e, arr[i].e);
		}
		else {
			index++;
			arr[index] = arr[i];
		}
	}

	// Now arr[0..index-1] stores the merged Intervals
	cout << "\n The Merged Intervals are: ";
	for (int i = 0; i <= index; i++)
		cout << "[" << arr[i].s << ", " << arr[i].e << "] ";
}

// Driver program
int main()
{
	Interval arr[]
		= { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };
	int n = sizeof(arr) / sizeof(arr[0]);
	mergeIntervals(arr, n);
	return 0;
}

// This code is contributed by Aditya Kumar (adityakumar129)
 * 
 */
