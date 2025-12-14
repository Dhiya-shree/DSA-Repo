package impAlgorithm_array_search;

public class Pair_Sum_Triplet_Sorted_Array {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5,6,7,8,10,12,13,20};
		int val=46;
		//If given unsorted array - sort it first !!!!! //O log n + O n2 
		int ans=FindTheTriipletPairWithSum(arr,val); //O n2 
		System.out.println(" It is present  "+ans);
	}

	private static int FindTheTriipletPairWithSum(int[] arr, int val) {
		// For every element use two pointer pair sum method 
		int n=arr.length;
		int ans=0;
		//For two pinter 
		int start =0;
		int end=n-1;
		int new_val=0;
		int new_sum=0;
		
		for(int i=0;i<n-2;i++) {
			
			new_val=val-arr[i];
			//Now need to find this new val s sum of any two number in remaining array
			start=i+1;
			while(start<end) {
				new_sum=arr[start]+arr[end];
				if(new_sum==new_val) {
					System.out.println(" Pair prsenet ");
					ans=1;
					return ans;
				}
				if(new_sum<new_val) {
					
					start=start+1;
				}
				else {
					end=end-1;
				}
			}
	
		}
		return 0;
	}
}
