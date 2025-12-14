package greedy_Algo;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  Fractional Knapsack problem 
 *  
 *  
 *  N LOG N 
 *  
 *  
 *  Fractional KnapSack Problem 
 *  Thief with 1 knapsack + breakable things 
 *  he can take any percent of 1 anything 
 *  
 *  A thief successfully broke vault 
 *  But has only 1 knapsack where he can hide totally an weight of capacity c
 *  Fill up the knapsack with available  value 
 *  
 *  1 article put in only once 
 *  
 *  Consider there are 100 gm of diamond with 1 gm each  100gm = 1 lakh  
 *  Consider there are 300 gm of gold with 1 gm each     300gm = 50000 
 *  Consider there are 700 gm of silver with 1 gm each   700gm = 7000
 *  
 *  If the Thief can take 500 gm capcity only 
 *  Best to take :
 *    1) 100 gm diamond Fraction : 1
 *    2) 300 gm gold    Fraction : 1 
 *    2) 100 gm silver  Fraction : 6/7 
 *    
 *  Value taken by theif = 1 lahk + 50000 + 6/7 of 5000
 *  Value = 1 lakh 56,000 
 *  
 *  
 *  
 *  Given a set of items with weight and values 
 *  And a knapsack with capacity c 
 *  Collect maximum value in knapsack 
 * 
 *  Set = w1,v1 ; w2,v2 ; w3,v3 .....
 *  Capcity c 
 *  
 *  Example :
 *  Set   50,600 20,500 30,400
 *  Capcity = 70 
 *  
 *  Maximum : 500+400+600*2/5 ( 20 + 30+ 50*(20/50))  No wastage 10 
 *          : 900+240                   20/50 === remain(70-20-30) / weight 
 *          : 1140 
 *          
 *  Solution 1: 
 *  Convert set to ratio array 
 *  Double ratio = Value/Weight 
 *  
 *  Step 1:
 *  Sort the set by ratio found 
 *     20,500   30,400  50,600
 *  
 *  Step 2:
 *  initialize 
 *  res = capacity 70
 *   ans=0
 *  curr=0;
 *  
 *  Step 3:
 *  For all set  :
 *     if res>weight
 *      res= res-weight    70-20 - 50 
 *      ans = ans+ value   500 
 *                                  CONSIDER ALL SET ONLY ONCE !!!!!!!!!!!!
 *      
 *   else    TO HANDLE FRACTIONS 
 *       fraction = res/weight 
 *       ans=ans+ (value*fraction)
 *       res=res-weight*ffraction  
 *      
 *      
 *   [   OR   ] 
 *  
 * Step 3:
 *  For all set while res>0  :
 *       fraction=1
 *     if res<weight 
 *       fraction = res/weight 
 *      
 *      ans=ans+ (value*fraction)        CONSIDER ALL SET ONLY ONCE !!!!!!!!!!!!
 *      res=res-weight*ffraction  
 * 
 *   return ans ;             
 *   Maximum value 
 *     
 *  
 *  
 * 
 * @author shree
 *
 */
public class Greedy03_Fractional_KnapSack {

	public static void main(String[] args) {
		
		int weight[]= {50,20,30,10};
		int value[]= {600,500,400,100};
		int n=weight.length;
		int capacity=70;
		
		SetFKS set[]=new SetFKS[n];
		
		for(int i=0;i<n;i++) {
			set[i]=new SetFKS(weight[i],value[i]);
		}
		
		// Sort by ratio   N LOg N 
		// Comparator called 
	//	Arrays.sort(set,new ComparatorSetFKS());
		//Comparable called 
		Arrays.sort(set);
		
		System.out.println(" Sorted set ");
		for(int i=0;i<n;i++) {
			System.out.println(" Set is "+set[i].weight+"---"+set[i].value+" with ratio "+set[i].r);
		}
		
		
		// Initialize 
		int res=capacity;
		int ans=0;
		double fraction=1;        //CONSIDER ALL SET ONLY ONCE !!!!!!!!!!!!
		// below res>0 simply reduce some cycle    N 
		for(int i=0;i<n && res>0 ;i++) {
			
			if(set[i].weight>res) {  // After RES is 0 , further will go in if condt 
				fraction=res;
			}
			else { 
				fraction =set[i].weight;
			}
			System.out.println(" Consider a fraction "+fraction+
					" for weight "+set[i].weight+ " and value "+(int)((set[i].value*fraction)/set[i].weight));
			ans=(int) (ans+(set[i].value*(fraction))/set[i].weight);
			res=(int) (res-(set[i].weight*(fraction))/set[i].weight);
		}
		
		System.out.println(" Ans for maximum value is "+ans);
		
		
		
        
	       
        double ans1=0;
        double fraction1=0;
        double res1=capacity;
        for(int i=0;i<n && res1>0;i++){
            
            if(set[i].weight>res1){
            	fraction1=res1/set[i].weight;
            }
            else{
            	fraction1=1;
            }
            
            ans1=ans1+((set[i].value*fraction1));
            res1=res1-((set[i].weight*fraction1));
        }
        System.out.println(" Double ans is "+ans1);
	}
}

class SetFKS implements Comparable<SetFKS>{
	double r;int weight;int value;
	
	SetFKS(int i,int j) {
		weight=i;
		value=j;
		r=j/i; // Sorting to give maximum value so ratio = value/weight
	}
	
	public int compareTo(SetFKS s) {
	//	System.out.println(" Comparable ");
	//	return (int) (s.r-this.r);
		// Instead of ration 
		// Can do without ratio
		
		// For ascending order this first / bigger 
		// this . r1 > s.r2
		// n1/d1 > n2/d2
		//n1*d2 > n2*d2 
		//  this.val * s.weight - s.val * this.weight
		
		// For descending 
		//  s.r2>this.r1
		//s.val * this.weight -  this.val * s.weight 
		return (s.value*this.weight)-( this.value * s.weight );
	}
}

class ComparatorSetFKS implements Comparator<SetFKS>{
	
	public int compare(SetFKS o1,SetFKS o2) {
		// o1 for ascending
		//o2 for descending 
		System.out.println(" Comparator ");
		return (int) (o2.r-o1.r);
		
	}
}



/*
Fractional Knapsack Problem

Given the weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In Fractional Knapsack, we can break items for maximizing the total value of the knapsack

Note: In the 0-1 Knapsack problem, we are not allowed to break items. We either take the whole item or don’t take it. 

 

Input: 
Items as (value, weight) pairs 
arr[] = {{60, 10}, {100, 20}, {120, 30}} 
Knapsack Capacity, W = 50

Output: Maximum possible value = 240 
Explanation: by taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. 
Hence total price will be 60+100+(2/3)(120) = 240

 

Input:  
Items as (value, weight) pairs 
arr[] = {{500, 30}}
Knapsack Capacity, W = 10
Output: 166.667

Naive Approach: Try all possible subsets with all different fractions but that will be very inefficient. 

Greedy approach for fractional knapsack problem:
An efficient solution is to use the Greedy approach. The basic idea of the greedy approach is to calculate the ratio value/weight for each item and sort the item on the basis of this ratio. Then take the item with the highest ratio and add them until we can’t add the next item as a whole and at the end add the next item as much as we can. Which will always be the optimal solution to this problem.

Follow the given steps to solve the problem using the above approach:

Calculate the ratio(value/weight) for each item.
Sort all the items in decreasing order of the ratio.
Initialize res =0, curr_cap = given_cap.
Do the following for every item “i” in the sorted order:
If the weight of the current item is less than or equal to the remaining capacity then add the value of that item into the result
else add the current item as much as we can and break out of the loop
Return res
Below is the implementation of the above approach:


# Structure for an item which stores weight and
# corresponding value of Item
class Item:
	def __init__(self, value, weight):
		self.value = value
		self.weight = weight

# Main greedy function to solve problem
def fractionalKnapsack(W, arr):

	# sorting Item on basis of ratio
	arr.sort(key=lambda x: (x.value/x.weight), reverse=True)

	# Uncomment to see new order of Items with their
	# ratio
	# for item in arr:
	#	 print(item.value, item.weight, item.value/item.weight)

	# Result(value in Knapsack)
	finalvalue = 0.0

	# Looping through all Items
	for item in arr:

		# If adding Item won't overflow, add it completely
		if item.weight <= W:
			W -= item.weight
			finalvalue += item.value

		# If we can't add current Item, add fractional part
		# of it
		else:
			finalvalue += item.value * W / item.weight
			break
	# Returning final value
	return finalvalue


# Driver's Code
if __name__ == "__main__":

	# Weight of Knapsack
	W = 50
	arr = [Item(60, 10), Item(100, 20), Item(120, 30)]

	# Function call
	max_val = fractionalKnapsack(W, arr)
	print ('Maximum value we can obtain = {}'.format(max_val))
 

Output

Maximum value we can obtain = 240
Time Complexity: O(N log N)
Auxiliary Space: O(N)




*/