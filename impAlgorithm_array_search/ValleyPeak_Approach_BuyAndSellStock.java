package impAlgorithm_array_search;

import java.util.ArrayList;

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
 */

public class ValleyPeak_Approach_BuyAndSellStock {
    //Profit - going  up add the value 
	//Loss - going down add the value
	public static void main(String[] args) {
		int price[]= {100,180,260,310,40,535,695};//{1,5,3,8,12};
		int profit=0;
		int n=price.length;
		profit=Valley_Peak_Stocks(price,n);
		System.out.println("Answer "+profit);
		ArrayList<ArrayList<Integer>> pro=new ArrayList<ArrayList<Integer>>();
		pro=stockBuySell(price,n);
		
		System.out.println("Answer "+pro);

	}
	
	private static ArrayList<ArrayList<Integer> > stockBuySell(int price[], int n) {
	    ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	    //int max=0;
		int count=0;
    	for(int i=1;i<n;i++) {
    		if(price[i]>price[i-1]) //Making profit add it 
    		{   ans.add(new ArrayList<Integer>(2));
    		    ans.get(count).add(0,i-1);
    		    ans.get(count).add(1,i);
    		    count++;
    			//max=price[i]-price[i-1]+max;
    			//System.out.println(" Current profit "+max+" At i "+i);
    		}
    	}
    	
    	for(int i=0;i<count;i++)
    	{  
    		System.out.println(" Start "+ans.get(i).get(0)+" end "+ans.get(i).get(1));
    	}
    	return ans;
        // code here
    }

	private static int Valley_Peak_Stocks(int[] price, int n) {
		// Using valley peak
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

}
