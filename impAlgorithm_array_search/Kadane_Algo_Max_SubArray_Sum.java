package impAlgorithm_array_search;

/*
 * Kadane algorithm 
 * Kadane's algorithm is a dynamic programming approach used to solve the maximum subarray problem, 
 * which involves finding the contiguous subarray with the maximum sum in an array of numbers. 
 * The algorithm was proposed by Jay Kadane in 1984 and has a time complexity of O(n).
 * 
 *The idea is to use the Kadane’s Algorithm to find the maximum subarray sum and store the starting and ending index of the subarray having maximum sum and print the subarray from starting index to ending index. Below are the steps:
 *Initialize 3 variables endIndex to 0, currMax, and globalMax to first value of the input array.
 *For each element in the array starting from index(say i) 1, update currMax to max(nums[i], nums[i] + currMax) and globalMax and endIndex to i only if currMax > globalMax.
 *To find the start index, iterate from endIndex in the left direction and keep decrementing the value of globalMax until it becomes 0. The point at which it becomes 0 is the start index.
 *Now print the subarray between [start, end].
 * 
 * 
 * Given an array arr[], the task is to find the elements of a contiguous subarray of numbers that has the largest sum.
 */
public class Kadane_Algo_Max_SubArray_Sum {
public static void main(String[] args) {
	
	int arrayInt[]={2,3,-8,7,-1,2,3};//{-6,-1,-8};// 
    int ans = MaximumSubArraySumNaive(arrayInt);
    System.out.println(" Ans max consecutive sub array  "+ans);
    ans=MaximumSubArraySumEfficient(arrayInt);
    System.out.println(" Ans max consecutive sub array  "+ans);
    long ans1=MaximumSubArraySumEfficientGoG(arrayInt);
    System.out.println(" Ans max consecutive sub array  "+ans1);
}


private static long MaximumSubArraySumEfficientGoG(int[] arrayInt) {
	// Initialize currMax and globalMax
	// with first value of nums
	int n=arrayInt.length;
	int endIndex = 0;
	Long currMax =Long.valueOf(arrayInt[0]);
	Long globalMax =Long.valueOf(arrayInt[0]);

	// Iterate for all the elements
	// of the array
	for (int i = 1; i < n; ++i)
	{

	// Update currMax
	Long a=(long)(arrayInt[i] + currMax);
	Long b=(long) (arrayInt[i]);
	currMax =Math.max( a,b);

	// Check if currMax is greater
	// than globalMax
//	currMax=Long.valueOf(2492958345L);
	if (currMax > globalMax)
	{
		globalMax = currMax;
		endIndex = i;
	}
	}
   // globalMax=Long.valueOf(2492958345);
    System.out.println(" Globala  max "+globalMax);
	int startIndex = endIndex;

	// Traverse in left direction to
	// find start Index of subarray
	while (startIndex >= 0)
	{
	globalMax -= arrayInt[startIndex];

	if (globalMax == 0)
		break;

	// Decrement the start index
	startIndex--;
	}

	// Printing the elements of
	// subarray with max sum
	for(int i = startIndex; i <= endIndex; ++i)
	{
	System.out.print(arrayInt[i] + " ");
	}
	return globalMax;
}

private static int MaximumSubArraySumEfficient(int[] arrayInt) {
	// n2 finding the max sub array 
	// Subarray of 1,2,3,-3,4,5 is [1],[2,3],[-3],[-3,4,5],[1,2,3],[1,2,3,-3] always in order 
	int max=Integer.MIN_VALUE;
	int Now =0;
	int submax=0;
	int n=arrayInt.length;
	int startu=0;int endu=n;
	for(int i=0;i<n;i++) {
		submax=submax+arrayInt[i];
		System.out.println(" Sub max at i "+i+" is "+submax+ " max "+max);
		endu=i;
		if(submax<arrayInt[i]) {
		max=Math.max(max,arrayInt[i]);
		startu=i;
		if(startu==endu) {
			startu--;
		}
		submax=arrayInt[i];
		System.out.println(" Max "+max+" NOw "+Now);
		}
		max=Math.max(max,submax);
	}
	System.out.println(" Startu is "+startu+" endu is "+endu);
	for(int i = startu; i <= endu; ++i)
	{
	System.out.println(" Printingu...");
	System.out.print(arrayInt[i] + "<-- ");
	}
	return max;
}

private static int MaximumSubArraySumNaive(int[] arrayInt) {
	// n2 finding the max sub array 
	// Subarray of 1,2,3,-3,4,5 is [1],[2,3],[-3],[-3,4,5],[1,2,3],[1,2,3,-3] always in order 
	int max=Integer.MIN_VALUE;
	//int TotalMax = Integer.MIN_VALUE;
	int submax=0;
	int n=arrayInt.length;
	for(int i=0;i<n;i++) {
		submax=0;
		for(int j=i;j<n;j++){
			submax=submax+arrayInt[j];
			max=Math.max(max, submax);
		}
	}
	return max;
}


}
