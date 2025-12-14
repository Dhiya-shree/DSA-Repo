package impAlgorithm_array_search;

import arrayCode.ArrayPart01;

/*
 * Problem : Trapping rain water 
 * 
 *  Given an array of N non-negative integers arr[ ] representing an elevation map where the width of each bar is 1, 
 *   compute how much water it is able to trap after rain.
 *   ex 3 0 2 0 4 ans:7
 *       
 *  Approach 1:
 *  Approach 1 (Brute Approach): This approach is the brute approach. The idea is to:
 *  Traverse every array element and find the highest bars on the left and right sides. Take the smaller of two heights. 
 *  The difference between the smaller height and the height of the current element is the amount of water that can be stored 
 *  in this array element.
 *  Loop 1:
 *      Traverse the array from start to end - For every element: 
 *           Loop 2.a
 *          ->Traverse the array from start to that index and find the maximum height (a) and 
 *           Loop 2.b
 *          ->Traverse the array from the current index to the end, and find the maximum height (b).
 *          --> The amount of water that will be stored in this column is min(a,b) – array[i], add this value to the total amount of water stored
 *  Print the total amount of water stored.
 *  
 *  Approach 2:
 *  Approach 2 (Precalculation): This is an efficient solution based on the precalculation concept:
 *  In previous approach, for every element we needed to calculate the highest element on the left and on the right. 
 *  So, to reduce the time complexity: 
 *  For every element we can precalculate and store the highest bar on the left and on the right (say stored in arrays left[] and right[]). 
 *  Then iterate the array and use the precalculated values to find the amount of water stored in this index, 
 *  which is the same as ( min(left[i], right[i]) – arr[i] )
 * 
 * Follow the steps mentioned below to implement the approach:
 * Create two arrays left[] and right[] of size N. Create a variable (say max) to store the maximum found till a certain index during traversal.
 * Run one loop from start to end: In each iteration update max and also assign left[i] = max.
 * Run another loop from end to start: 
 * In each iteration update max found till now and also assign right[i] = max.
 * Traverse the array from start to end.
 * The amount of water that will be stored in this column is min(left[i], right[i]) – array[i]
 * Add this value to the total amount of water stored
 * Print the total amount of water stored.
 * 
 */
public class PreCalculation_TrappingRainWater {

	public static void main(String[] args) {
////////////////////////////////////////////////TRAPPING RAIN WATER ////////////START//////////////////////////////////
        
    int block[]= {3,0,2,0,4};//{8,8,2,4,5,5,1};//ans 4 // ans7 {3,0,2,0,4};
    int n1=block.length;
    System.out.println(" Bloacks+++ ");
    ArrayPart01.PrintRayy(block);
    int ans= TrappingRainWaterNaive(block,n1);
    System.out.println(" Ans trap "+ans);

    System.out.println(" Bloacks+++ Efficient O N  ");
    ArrayPart01.PrintRayy(block);
    int res= TrappingRainWaterEfficient(block,n1);
    System.out.println(" Ans trap efficient "+res);

    System.out.println(" Bloacks+++ Efficient GoG O N  ");
    ArrayPart01.PrintRayy(block);
    res= TrappingRainWaterEfficientGOG(block,n1);
    System.out.println(" Ans trap efficient "+res);

	}

	
	private static int TrappingRainWaterEfficientGOG(int[] arr, int n) {
		// As given in GoG 
    	// left[i] contains height of tallest bar to the
		// left of i'th bar including itself
		int left[] = new int[n];

		// Right [i] contains height of tallest bar to
		// the right of ith bar including itself
		int right[] = new int[n];

		// Initialize result
		int water = 0;

		// Fill left array
		left[0] = arr[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i - 1], arr[i]);

		// Fill right array
		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], arr[i]);

		// Calculate the accumulated water element by
		// element consider the amount of water on i'th bar,
		// the amount of water accumulated on this
		// particular bar will be equal to min(left[i],
		// right[i]) - arr[i] .
		for (int i = 0; i < n; i++)
			water += Math.min(left[i], right[i]) - arr[i];

		return water;
	}

	private static int TrappingRainWaterEfficient(int[] block, int n) {
		// Trapping rain water efficient
    	
    	int ans=0;
    	int max_left[] = new int[n];  // Max left array for all blocks
    	//int temp=0;
    	int max_right[]= new int[n]; // Max right block for a block x
    	int min_total[]= new int[n];//Min of max,left and max right - water will be stored to level of min_total
    	max_right[n-1]=block[n-1];
    	max_left[0]=block[0];
    	for(int i=1,j=n-2;i<n;i++,j--) {    // loop to find max_left for i
			max_left[i]=Math.max(max_left[i-1],block[i]);
			max_right[j]=Math.max(max_right[j+1],block[j]);
		}
//    	for(int i=1,j=n-2;i<n;i++,j--) {    // loop to find max_left for i
//			max_left[i]=Math.max(max_left[i-1],block[i]);
//			max_right[j]=Math.max(max_right[j+1],block[j]);
//		}
        for(int k=0;k<n;k++) {
			min_total[k]=Math.min(max_left[k],max_right[k]);
        	ans=ans+(min_total[k]-block[k]);
        }
        
		System.out.println(" Maximum in left array");
		ArrayPart01.PrintRayy(max_left);
		System.out.println(" Maximum in right array");
		ArrayPart01.PrintRayy(max_right);
		System.out.println(" Minimum in total array");
		ArrayPart01.PrintRayy(min_total);
		return ans;
	}

	private static int TrappingRainWaterNaive(int[] block, int n) {
		// Condt to apply 
    	//Taking 3 elements to consideration and max 
    	// Ini max-> first big element and increment it 
    	// For block 0 -- add difference btw pre and post 
    	//change 0 as ans 
    	// For block n -- check dif between that and max(max,next)
    	// Change n as max 
    	int ans=0;
    	int max_left=0;  // Max left block for a block x
    	//int temp=0;
    	int max_right=0; // Max right block for a block x
    	int min_total=0;//Min of max,left and max right - water will be stored to level of min_total
    	for(int i=1;i<n;i++) {
    		max_left=block[0];
    		max_right=block[n-1];
    		System.out.println(" For bloack  "+block[i]+" in position "+i+"............");
    		for(int j=0;j<i;j++) {    // loop to find max_left for i
    			max_left=Math.max(max_left,block[j]);
    			System.out.println(" Maximum in left "+max_left);
    		}
            for(int k=i+1;k<n-1;k++) {    // loop to find max_right for i
            	max_right=Math.max(max_right,block[k]);
            	System.out.println(" Maximum in right "+max_right);
    		}
            min_total=Math.min(max_right,max_left); 
            System.out.println("Minimum "+min_total);
            // min of both side 
    		if(block[i]<min_total) {       // to check if considered block is not very high and tallest among group 
    			ans=ans+(min_total-block[i]); //water stored is min level between two max - block
    			System.out.println("Answer is "+ans);
    		}
    		
    	}
    	
		return ans;
	}
}
