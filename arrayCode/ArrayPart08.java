package arrayCode;

import java.util.ArrayList;

/**
 * Problem #1:
 * Maximum occured integer   -_- Make you cry  - 10 pointer 
 * Given n integer ranges, the task is to find the maximum occurring integer in these ranges. If more than one such integer exists, find the smallest one. The ranges are given as two arrays L[] and R[].  L[i] consists of starting point of range and R[i] consists of corresponding end point of the range.
 * For example consider the following ranges.
 * L[] = {2, 1, 3}, R[] = {5, 3, 9}
 * Ranges represented by above arrays are.
 * [2, 5] = {2, 3, 4, 5}
 * [1, 3] = {1, 2, 3}
 * [3, 9] = {3, 4, 5, 6, 7, 8, 9}
 * The maximum occurred integer in these ranges is 3.
 * 
 * ------------------------------------------------------------------------------------------------------------------------------------- 
 * 
 * Problem #2:
 * Who has the majority? Simple 
 * Given an array arr[] of size N and two elements x and y, 
 * use counter variables to find which element appears most in the array. If both elements have the same frequency, then return the smaller element.
 * 
 * ---------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #3:Minimum Consecutive Flips
 * 
 * Given a binary array, we need to convert this array into an array that either contains all 1s or all 0s.  We need to do it using the minimum number of group flips. 
 * 
 * Approach 1:
 * Traverse the two traversals of the array.
 * We first traverse to find the number of groups of 0s and the number of groups of 1. 
 * We find the minimum of these two. 
 * Then we traverse the array and flip the 1s if groups of 1s are less. Otherwise, we flip 0s.
 * 
 * 
 * Approach 2:
 * An Efficient Solution is based on the below facts : 
 * There are only two types of groups (groups of 0s and groups of 1s)
 * Given that :
 * Either the counts of both groups are same or the difference between counts is at most 1.
 * Note hat ;- Here we are considering group not elements , group diff can only be 1.
 * ...................example : {1,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0} - 4 1 group / 4 0 group - even though elements vary largely in number 
 *  For example, in {1, 1, 0, 1, 0, 0} there are two groups of 0s and two groups of 1s.  
 *  In example, {1, 1, 0, 0, 0, 1, 0, 0, 1, 1}, count of groups of 1 is one more than the counts of 0s.
 *  
 * Based on the above facts, we can conclude that if we always flip the second group and other groups that of the same type as the second group,
 *  we always get the correct answer. 
 *  
 * 1.Count same {1, 1, 0, 1, 0, 0}
 * In the first case, when group counts are the same, it does not matter which group type we flip as both will lead to the correct answer
 * 
 * 2.1 Count diff {1, 1, 0, 0, 0, 1, 0, 0, 1, 1}
 * In the second case, when there is one extra,by ignoring the first group and starting from the second group,
 *  we convert this case to first case (for subarray beginning from the second group) and get the correct answer.
 *  
 * 
 * --------------------------------------------------------------------------------------------------
 * 
 * Problem #4: Find the Safe Position
 * There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed. 
 * The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction (clockwise). 
 * In each step, a certain number of people are skipped and the next person is executed. 
 * The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), 
 * until only the last person remains, who is given freedom.
 * 
 * Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle.
 *  The task is to choose the place in the initial circle so that you are the last one remaining and so survive.
 *  
 * Approach 1 : O n2
 * Recursion - Josephus problem
 * 
 * Approach 2 : O  n log n 
 * 
 * Create array with 1 to n person in 0 to n-1 index 
 * Reduce kill by 1 as index from 0 t0 n-1 -> kill=kill-1
 * Loop 1: i=0
 *     1) Increment index by Kill i=i+kill
 *     2) i%n -> mod n to make sure to stay in range 0 to n-1
 *     3) Kill / Array.Remove(index)
 *  Break -------> When array.length is 1 . The last number is last standing person 
 *  
 *  -----------------------------------------------------------------------------------------------------------------------------------
 *  
 *  Problem #5 :Fraction Trouble
 *  
 *  Consider the set of irreducible fractions A = {n/d | n≤d and d ≤ 10000 and gcd(n,d) = 1}.You are given a member of this set and your task is to find the largest fraction in this set less than the given fraction.
 *  Note : this is a set and so all the members are unique.
 *  Example 1:
 *  Input: n = 1, d = 8 ;
 *  Output: 1249 9993
 *  Explanation: 1/8 >= 1249/9993 and this is the largest fraction. 
 *  
 *  Question
 *  Here we will get the numerator & denominator value as input, we have to find around an equivalent value to that. But had the below conditions.
 *  Condt 1#: Try to find a new denominator larger as possible, but <= 10000.
 *  Condt 1#: And new numerator & new denominator should have GCD = 1.
 *  Answer:-
 *  So we are looking for a larger value, so we need to take 10000 as the denominator, and loop through by subtracting that value.
 *  Now based on the new denominator value, find the new numerator value.
 *  Now we have a new denominator and its equivalent numerator, so we can check the GCD of those 2 numbers, it should equal 1. 
 *  As well as compare max & new numerator & denominator values. 
 *  If the condition is satisfied then save that values in max. Here we will continue our loop to look for any other max values.
 *  
 *  Approach:
 *  ---Loop 1 from 10000 to 1
 *  1) Set the num as denom 
 *  2) Numerator = ( n * Denominator -1)/d;
 *  3) GCD( Numerator and Denominator ) ==1 
 *  4) If GCD = 1, set that as max denom and max numerator 
 *  5) Continue ...
 *  6) If curr denom * max numerator > curr numerator * max denom 
 *  7) Rewrite the max values and continue 
 *  
 *  
 * @author shree
 *
 */
public class ArrayPart08 {

	public static void main(String[] args) {
		//Calls here babe 
		int ans=0;
		int L[] = {1,4,3,1};//{1,5,9,10,11};//{2,1,3};//{1,5,9,13,21};//{1,4,3,1};
		int R[] ={15,8,5,4};//{15,8,12,20,30};//{5,3,9};//{15,8,12,20,30};// {15,8,5,4};
		ans= MaximumOccuredIntegerInRange(L,R,30);
		System.out.println(" Maximum occured integer "+ ans);
		
		//--------------------------------------------------------------
		
		int arr[]= {1,1,2,3,4,5};
		ans=WhoIsMajority(arr,1,5);
		System.out.println(" Majority in x and y "+ans);
		
		//------------------------------------------------------------------
		
		int ArrBool[]= {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1,1,1};
		ans=MinimumConsecutiveFlips(ArrBool);
		System.out.println(" Ans------------------------------------------- "+ans);
		ans=MinimumConsecutiveFlipsEfficient(ArrBool);
		System.out.println(" Ans efficient -------------------------------------- "+ans);
        ans=MinimumConsecutiveFlipsNeededGoG(ArrBool);
        System.out.println(" Ans efficient  GoG --------------------------------------- "+ans);
        
        //--------------------------------------------------------------------------- Very Very Important - Josephus in O nLogN MUSTTTT
        
        int NoOfPeople=14;
        int kill=3;
        ans=FindTheSafePosition(NoOfPeople,kill);
        System.out.println(" Safe position "+ans);
        
        //-------------------------------------------------------------------------Fraction trouble 
        
        int n=2;
        int d=53;
        int sol[]=new int[2];
        sol=FractionTrouble(n,d);
        System.out.println(" Numerator "+sol[0]+ " denominator "+sol[1]);
        sol=FractionTroubleOptimized(n,d);
        System.out.println(" Numerator "+sol[0]+ " denominator "+sol[1]);
        
	}

	private static int[] FractionTrouble(int n, int d) {
		// Find fraction less than given n/d 
		// It must be high number <= 10000
		// GCD of n and d new ==1 
		int sol[]=new int [2];
		// initialize max numer -1 min and denom 1 max
		int max_denom=1;
		int max_numer=-1;
		int curr_denom=1;
		int curr_numer=1;
		// loop from 10000 to k>2
		for(int k=10000;k>2;k--) {
			// set denom and numwe , numer = ( n*denom -1)/d - n/d * Denom - 1/d ( To have less) 
			curr_denom=k;
			curr_numer= ( n*curr_denom -1)/d;
			// gcd = 1 and max numbers 
			if(gcdFractionTroube(curr_denom,curr_numer)==1 && (max_denom*curr_numer>curr_denom*max_numer)) {
				max_numer=curr_numer;
				max_denom=curr_denom;
				//break;
			}
		}
		sol[0]=max_numer;
		sol[1]=max_denom;
		
		
		return sol;
	}
	
	private static int[] FractionTroubleOptimized(int n, int d) {
		// Find fraction less than given n/d 
		// It must be high number <= 10000
		// GCD of n and d new ==1 
		int sol[]=new int [2];
		// initialize max numer -1 min and denom 1 max
		int max_denom=1;
		int max_numer=-1;
		int curr_denom=1;
		int curr_numer=1;
		// loop from 10000 to k>2
		for(int k=d-1;k<10000;k++) {
			// set denom and numwe , numer = ( n*denom -1)/d - n/d * Denom - 1/d ( To have less) 
			curr_denom=k;
			curr_numer= ( n*curr_denom -1)/d;
			if(gcdFractionTroube(curr_denom,curr_numer)==1 && (d*curr_numer<=curr_denom*n)) {
				max_numer=curr_numer;
				max_denom=((curr_numer*d)+1)/n;
				break;
			}
		}
		sol[0]=max_numer;
		sol[1]=max_denom;
		
		
		return sol;
	}

	private static int gcdFractionTroube(int denom, int numer) {
		// Finding GCD recursion 
		if(numer==0) {
			return denom;
		}
		return gcdFractionTroube(numer, denom%numer);
		
	}

	private static int FindTheSafePosition(int n, int k) {
		//Find the safe position expected O n2 and On space 
		ArrayList<Integer>arr = new ArrayList<Integer>();
		////////////////////[////// Create an array with position 1 to n in index 0 to n-1
        for(int i=1;i<=n;i++) {
        	System.out.println(i);
        	arr.add(i);};
        //////////////////////// Current index -0 
        int ind = 0;
        //////////////////////// No of person to kill -1 done as we are starting array from index 0 
        //Ex.n=4,k=2: 1 2 3 4 kill 2 element at index 1 
        k-=1;
        //We need last standing place so taking that when we have one entry in array 
        while(arr.size()!=1){
        	//Index to kill
            ind+=k;
            System.out.println(" Index for kill "+k+" ... is ...."+ind);
            //index mod size -> make sure not out of range 
            // If 1 2 3 4 5 6 7 8 9 10 are elements and need to kill 3 ( index 2)
            //--> 1 2 k 4 5 k 7 8 k 10  only when killing after pos 9 , the index 10 % size will give 0
            // Now again reduction will start from 0 
            //    1 2 4 5 7 8 10 ind-0 
            ind%=arr.size();
            System.out.println(" Index after changing wrt size...."+ind);
            System.out.println(" Removing "+arr.get(ind)+"----curr size"+arr.size());
            arr.remove(ind);
        }
        return arr.get(0);
	}

	private static int MinimumConsecutiveFlipsNeededGoG(int[] arr) {
		// GoG and
		// Traverse through all array elements
			// starting from the second element
		int n=arr.length;
			for(int i = 1; i < n; i++)
			{
				
			// If current element is not same
			// as previous
			if (arr[i] != arr[i - 1])
			{
					
				// If it is same as first element
				// then it is starting of the interval
				// to be flipped.
				if (arr[i] != arr[0])
					System.out.print("From " + i + " to ");
					
				// If it is not same as previous
				// and same as first element, then
				// previous element is end of interval
				else
					System.out.println(i - 1);
			}
			}
			
			// Explicitly handling the end of
			// last interval
			if (arr[n - 1] != arr[0])
				System.out.println(n - 1);
		
			

		return 0;
	}

	private static int MinimumConsecutiveFlipsEfficient(int[] arrBool) {
		// Find the first group , change all the element belong too other group 
		int n=arrBool.length;
		int set_group=arrBool[0];
		int previ=set_group;
		int count_set_group=1;
		int opp_count=0;
		int ans=0;
		if(set_group==0) {
			ans=1;
		}
		for(int i=1;i<n;i++) {
			System.out.println(" ArrBool "+arrBool[i]+" set grouup "+set_group);
			if(arrBool[i]!=set_group) {
				if(arrBool[i]!=previ){
				System.out.println(" New group need to change "+arrBool[i]+" to "+set_group+" at place .."+i);
				previ=arrBool[i];
				opp_count++;
			}
			else{
				System.out.println(" Same group need to change "+arrBool[i]+" to "+set_group+" at place .."+i);
				//previ=arrBool[i];
				opp_count++;
			}
			}
			else{
				if(arrBool[i]!=previ){
		
				System.out.println(" New group no need to change "+arrBool[i]+" at place .."+i);
				previ=arrBool[i];
				count_set_group++;
			}
			else {
				System.out.println(" Same group.......at ......"+i);
			}
		}
			
		}
		System.out.println(" Group of "+set_group+" is "+count_set_group);
		System.out.println(" Group of "+ans+" is "+opp_count);
		return ans;
	}

	private static int MinimumConsecutiveFlips(int[] arrBool) {
		// Find minimum conse flips
		int n=arrBool.length;
		int count =0;
		int needSwitch=1;
		int switchToo=0;
		int curr_set=arrBool[0];
		int switch_bool[]=new int [2];
		for(int i=1;i<n-1;i++) {
			if(arrBool[i]!=curr_set) {
				switch_bool[curr_set]++;
				curr_set=arrBool[i];
			}
		}
		switch_bool[arrBool[n-1]]++;
		ArrayPart01.PrintRayy(switch_bool);
		count=0;
		if(switch_bool[1]>switch_bool[0]) {
			needSwitch=0;
			switchToo=1;
		}
		System.out.println(" Need to switch "+ Math.max(switch_bool[0],switch_bool[1])+" ---"+needSwitch);
		for(int i=0;i<n;i++) {
			if(arrBool[i]==needSwitch) {
			arrBool[i]=switchToo;
			}
				count++;
			
		}
		return count;
	}
	
	private static int WhoIsMajority(int[] arr, int x, int y) {
		// Simple O N 
		int maxX=0;
        int maxY=0;
        int n=arr.length;
        if(x==y){
            return x;
        }
        for(int i=0;i<n;i++){
            if(arr[i]==x){
                maxX++;
            }
            if(arr[i]==y){
                maxY++;
            }
        }
        if(maxX>maxY){
            return x;
        }
        else if(maxY>maxX){
            return y;
        }
        else{
            return Math.min(x,y);
        }
	}

	private static int MaximumOccuredIntegerInRange(int[] L, int[] R,int maxx) {
		// Find number coming inbetween all range 

		int n=L.length;
		int max[]=new int[maxx+2];
		for(int i=0;i<n;i++) {
//			if(max[L[i]]==1) {
//				max[L[i]]=-1*max[L[i]];
//			}
//			if(max[R[i]]==-1) {
//				max[R[i]]=-1*max[R[i]];
//			}
			max[L[i]]=-1+max[L[i]];
			max[R[i]+1]=1+(max[R[i]+1]);
			System.out.println(" Adding at "+L[i]+" vale of "+max[L[i]]);
			System.out.println(" ....Adding at "+R[i]+" vale of "+max[R[i]]);
		}
		ArrayPart01.PrintRayy(max);
		
		int min_most=0;
		int min_index=0;
		int curr=0;
		for(int i=0;i<maxx;i++) {
			curr=max[i]+curr;
			if(curr<min_most) {
				min_most=curr;
				min_index=i;
			}
			System.out.println(" Curr "+curr+" Min  most "+min_most+ " min index "+min_index+" At index ......"+i);
		}
		return min_index;
	}

}
