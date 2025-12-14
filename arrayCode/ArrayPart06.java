package arrayCode;

/*
 * Problem #1: Stock Buy and Sell Problem
 *    The cost of a stock on each day is given in an array. 
 *    Find the maximum profit that you can make by buying and selling on those days. 
 *    If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 *    
 *  Approach 1:
 *     A simple approach is to try buying the stocks and selling them every single day when profitable and keep updating the maximum profit so far.
 *        Follow the steps below to solve the problem:
 *        Try to buy every stock from start to end – 1
 *        After that again call the maxProfit function to calculate answer
 *        curr_profit = price[j] – price[i] + maxProfit(start, i – 1) + maxProfit(j + 1, end)
 *        profit = max(profit, curr_profit)
 *        
 *  Approach 2 : Valley Peak Approach 
 *    At every bottom point buy the stock and at every high point sell it to get profit 
 *    find the next greater element and subtract it from the current element so that the difference keeps increasing until we reach a minimum.
 *     If the sequence is a decreasing sequence, so the maximum profit possible is 0.
 *    
 *    Difference going up add the profit ( current - previous element )
 *    Difference less -> ignore it , not selling it 
 *    Loop 1 : Traverse through the array from second element 
 *                 1) Initialize ax=0 
 *                 2)if price[i] > price[i – 1]
 *                         maxProfit = maxProfit + price[i] – price[i – 1]
 *                         
 *  --------------------------------------------------------------------------------------------------------------------------------------------------
 *  
 *  Problem #2: Trapping Rain Water
 *       Given an array of N non-negative integers arr[ ] representing an elevation map where the width of each bar is 1, 
 *       compute how much water it is able to trap after rain.
 *       ex 3 0 2 0 4 ans:7
 *       
 *  Approach 1:
 *  Approach 1 (Brute Approach): This approach is the brute approach. The idea is to:
 *  Traverse every array element and find the highest bars on the left and right sides. Take the smaller of two heights. The difference between the smaller height and the height of the current element is the amount of water that can be stored in this array element.
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
 *  --------------------------------------------------------------------------------------------------------------------------------------------
 *  
 *  Problem #3 : Number Game
 *  Given a number n the task is to find the minimum number which is divisible by all numbers from 1 to n. Print the answer modulo (10^9+7).
 *  Find LCM of all numbers till n
 *  Lcm of 2,3- 6
 *  Lcm of 6,4 - 12
 *  Lcm of 12,5- 60
 *  Lcm of 6,60-60...... 
 *  
 *  To find lcm find GCD in recursion and use a*b/gcd
 *  
 *  GCD :
 *  GCD of (a,b) -->
 *  if(b==0) return a ;
 *  GCD of (b,a%b)--> continue ......
 *  
 *  ---------------------------------------------------------------------------------------------------------------------------------------------------------
 *  
 *  Problem #4 : Maximum consecutive 1 in binary array 
 *   Given a binary array, find the count of the maximum number of consecutive 1's present in the array.
 *   
 *   
 *   ---------------------------------------------------KADANE ALGO -------------MAX SUB ARRAY SUM----------------------
 *   Problem #5 : Maximum sub array Sum 
 *   The idea is to use the Kadane’s Algorithm to find the maximum subarray sum and store the starting and ending index of the subarray having maximum sum and print the subarray from starting index to ending index. Below are the steps:
 *   Initialize 3 variables endIndex to 0, currMax, and globalMax to first value of the input array.
 *	 For each element in the array starting from index(say i) 1, update currMax to max(nums[i], nums[i] + currMax) and globalMax and endIndex to i only if currMax > globalMax.
 *	 To find the start index, iterate from endIndex in the left direction and keep decrementing the value of globalMax until it becomes 0. The point at which it becomes 0 is the start index.
 *	 Now print the subarray between [start, end].
 * 
 * 
 * Given an array arr[], the task is to find the elements of a contiguous subarray of numbers that has the largest sum.
 *  
 * 
 */
public class ArrayPart06 {

	public static void main(String[] args) {
		// Hard level problems to cry more -_- 
		
		/**?----------------STOCK-BUY-SELL-PROBLEM-------START---------------------------------*/
		int price[]= {1,5,3,8,12};
		int start =0;
		int n=price.length;
		int profit=0;
        profit=StockBuyAAndSellGoGNaive(price,start,n-1);
        
        ArrayPart01.PrintRayy(price);
        System.out.println(" Profit "+profit);
        
        profit=StockBuyAAndSell(price,n);
        
        ArrayPart01.PrintRayy(price);
        System.out.println(" Profit "+profit);
        
        /**?----------------STOCK-BUY-SELL-PROBLEM-------END---------------------------------*/
        
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
        
////////////////////////////////////////////////TRAPPING RAIN WATER ////////////END//////////////////////////////////
        
        long n2=100;//845511670
        long ans2=NumberGame(n2);
        System.out.println(" Ans number game "+ans2);
        
        ans2=numGameGoG(n2);
        System.out.println(" Ans number game GoG "+ans2);
        
////////////////////////////////////////////////////////////////////// NUMBER GAME ///////////////////END /////////////////////////////////////
        
        boolean arrayBool[]= {true,true,true,true,false,false,true};
        ans=CountMaxConsecutive(arrayBool);
        System.out.println(" Ans max consecutove "+ans);
/** ?//////////////////////////////////////////////////////////////Maximum SUB Array Sum //////////////////////////////////////////////////////  */
        
        int arrayInt[]={2,3,-8,7,-1,2,3};//{-6,-1,-8};// 
        ans=MaximumSubArraySumNaive(arrayInt);
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
		//currMax=Long.valueOf(2492958345L);
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

	private static int CountMaxConsecutive(boolean[] arrayBool) {
		// To count max consecutive true 
		int max=0;
		int n=arrayBool.length;
		boolean FlagSet=false;
		int totalMax=0;
		if(arrayBool[0]==true) {
			max=1;
			FlagSet=true;
		}
		for(int i=1;i<n;i++) {
			if(arrayBool[i]==true && FlagSet==false) {
				max=max++;
					FlagSet=true;
				}
				if(arrayBool[i]==true && arrayBool[i-1]==true) {
					max++;
				}
			else {
				totalMax=Math.max(totalMax,max);
				max=0;
			}
		}
		totalMax=Math.max(totalMax,max);
		if(totalMax==0) {
			totalMax=-1;
		}
		return totalMax;
	}

	static long lcm(long a ,long b)
    {
       long lcm = (a * b) /gcd(a,b);
       return lcm;
    }

    static long gcd(long a ,long b)
    {
    	if(b == 0)
        	 return a;
        return gcd( b , a%b );
    }

    static Long numGameGoG(Long n) {

        long m = 1000000007L;
        long res = 1;
        for(long i = 1 ; i <= n ; i++){
            res = lcm(res , i) % m;
            System.out.println("Res "+res +" Lcm "+ i);
              }
          return res % m;
       }


    private static Long NumberGame(Long n) {
		// Number game 
    	if(n==1) {
    		return (long)1;
    	}
    	long ans = 1;
    	long Mod = 1000000007L;
    	
    	System.out.println("Mod is "+Mod);
    	for(int i=2;i<=n;i++) {
    		boolean temp;int temp2=0;long temp3;
    	    temp=PrimeOrNotMethod(i);
    	    System.out.println("Prime or not "+temp+" for I "+i);
    		if(temp) {/////
    			temp2=(int)Math.floor((Math.log(n)/Math.log(i)));
    			temp3=(long) (Math.pow(i,temp2));
    			//ans=ans%Mod;
//    			if((ans*temp3)>Mod) {
//    			ans=(ans*temp3)%Mod;
//    			}
//    			else {
    			//temp3=temp3%Mod;
    			ans=(int) (ans%Mod);
    			ans=(int) ((ans*temp3)%Mod);
    			//}
    			
    			
    			System.out.println("Ans now "+ans+" temp "+temp2+" power raised "+temp3);
    		}
    	}
		return (long) (ans%Mod);
	}
    
    public static boolean PrimeOrNotMethod( int i2) {
//		int b=a-1;
//		int c=a+1;
//		if(b%6==0 || c%6==0) {
//			System.out.println(" iS A PRIME");
//			return true;
//		}
//		else {
//			System.out.println("Not a prime");
//		}
		if(i2==2|| i2==3 || i2==5 ||i2==7||i2==11 ||i2==13) {
			return true;/////////////////////////////////////////////////////////////////continue
		}
		if(i2==1||i2%2==0 || i2%3==0 || i2%5==0 ||i2%7==0||i2%11==0 ||i2%13==0) {
			//System.out.println("Not a prime");
			return false;////////////////////////////////////////////////
		}
//		if(a==2||a==3) {
//			//System.out.println("Is a prime");
//			return true;
//		}
		int s=(int) Math.sqrt(i2);
		for(int i=17;i<=s+6;i=i+6) {
			if(i2%i==0 || i2%(i+2)==0) {
			//	System.out.println("Not a prime"+i+" "+i+2);
				return false;  ////////////////////////////////
			}
		}
		//System.out.println(" iS A PRIME");
		return true;//-------------------------------------------------//
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

	private static int StockBuyAAndSell(int[] price, int n) {
		// Stock buy and sell
    	int max=0;
    	for(int i=1;i<n;i++) {
    		if(price[i]>price[i-1]) //Making profit add it 
    		{
    			max=price[i]-price[i-1]+max;
    			System.out.println(" Current profit "+max+" At i "+i);
    		}
    	}
		return max;
	}

	static int count=0;static int po=10;
	private static int StockBuyAAndSellGoGNaive(int[] price, int start, int end) {
		// Recursion -_-
		if (end <= start)
			return 0;

		// Initialise the profit
		int profit = 0;

		// The day at which the stock
		// must be bought
		for (int i = start; i < end; i++) {

			// The day at which the
			// stock must be sold
			for (int j = i + 1; j <= end; j++) {

				// If buying the stock at ith day and
				// selling it at jth day is profitable
				if (price[j] > price[i]) {
                    count++;
                    System.out.println(((int)(Math.pow(po,count)))+" For no.of time "+ count+" For start as "+i+ " end as "+j +" with range between " +price[i]+"--"+price[j] );
					// Update the current profit
					int curr_profit
						= price[j] - price[i]
						+ StockBuyAAndSellGoGNaive(price, start, i - 1)
						+ StockBuyAAndSellGoGNaive(price, j + 1, end);
             
					
					System.out.println((count*po)+" After recusrsion ");
					System.out.println((count*po)+" For no.of time "+ count+" For start as "+i+ " end as "+j +" with range between " +price[i]+"--"+price[j]+" gave price "+
					curr_profit +" Already profit "+profit );
					// Update the maximum profit so far
					profit = Math.max(profit, curr_profit);
				}
			}
			//po=po*10;
		}
		return profit;
	}

}
