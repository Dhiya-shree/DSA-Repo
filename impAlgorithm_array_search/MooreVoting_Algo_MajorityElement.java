package impAlgorithm_array_search;


/**
 * 
 * Majority Element
 * 
 * Our Task: Find the majority element in the array. 
 * A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element). 
 * What is a majority element?
 * A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element). 
 * 
 * Approach 1: Moore’s Voting Algorithm:->
 * This is a two-step process:
 * 1.The first step gives the element that may be the majority element in the array.
 * If there is a majority element in an array, then this step will definitely return majority element, otherwise, it will return candidate for majority element.
 * 
 * 2.Check if the element obtained from the above step is the majority element. 
 * This step is necessary as there might be no majority element. 
 * Time Complexity: O(n), As two traversal of the array, is needed, so the time complexity is linear.
 * Auxiliary Space: O(1), As no extra space is required.
 * 
 * * Majority Element Using Moore’s Voting Algorithm:
 *  
 * Follow the steps below to solve the given problem:
 * Loop through each element and maintains a count of the majority element, and a majority index, maj_index
 * If the next element is the same then increment the count if the next element is not the same then decrement the count.
 * if the count reaches 0 then change the maj_index to the current element and set the count again to 1.
 * Now again traverse through the array and find the count of the majority element found.
 * If the count is greater than half the size of the array, print the element
 * Else print that there is no majority element
 * 
 * @author shree
 *
 */
public class MooreVoting_Algo_MajorityElement {

	public static void main(String[] args) {
		// Vote for mooooore ;*>
		int major[]={3, 3, 4, 2, 4, 4, 2, 4, 4};
		int ans=0;
		   ans=MajorityElement(major);
		   System.out.println(" majority element "+ans);
		   ans=MajorityElementMooreVotingAlgo(major);
		   System.out.println(" majority element "+ans);

	}
	
	 private static int MajorityElementMooreVotingAlgo(int[] major) {
			//Use moore voting algo 
			   int count=0;
			   int element_index=0;
			   int element=major[0];
			   int n=major.length;
			   
			   ////////////////////////Check for major element present 
			   for(int i=1;i<n;i++) {
				   if(major[i]==element) {
					   count++;
				   }
				   else {
					   count--;
				   }
				   
				   if(count<1) {
					   element=major[i];
					   element_index=i;
					   count=1;
				   }
			   }
			   System.out.println(" Major member can be "+element+" at index "+element_index+ " with final count "+count);
			   
			   
			   /////////////////////////////////////// Confirm if that is major element 
			   count=0;
			   for(int i=0;i<n;i++) {
				   if(major[i]==element) {
					   count++;
				   }
				   if(count>(n/2)) {
					   return element;
				   }
			   }
			   
			return -1;
		}


		private static int MajorityElement(int[] major) {
			// find majority element with start  index 
			   int element =major[0];
			   int index=0;
			   int count=1;
			   int n=major.length;
			   for(int i=1;i<n;i++) {
				   if(major[i]==element) {
					   count++;
				   }
				   else {
					   count--;
					   if(count==0) {
						   element=major[i];
						   index=i;
						   count=1;
					   }
			   }
			   }
			   System.out.println(" Major member can be "+element+" at index "+index+ " with final count "+count);
			   count=0;
			   for(int i=0;i<n;i++) { 
				   if(major[i]==element) {
					   count++;
				   }
				   if(count>n/2) {
					   return element;
				   }
			   }
			return -1;
		}

}
