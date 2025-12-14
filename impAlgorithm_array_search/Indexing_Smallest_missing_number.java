package impAlgorithm_array_search;

/**
 ** Problem: Smallest Positive missing number
 * 
 * Use indexing 
 * 
 * 1) Filter the array make everything as 0 if it is negative 
 * 2) Indexing :
 *     If arr[i]<n , make the position -ve , arr[arr[i]]= -1*arr[arr[i]]
 *     If arr[arr[i]]=0 , then arr[arr[i]]= -1*arr[i]
 * 3) if arr[i]>=0 -( non negative not present in array )
 *         return i;
 *         
 * 4) Find max . if max==n , present in array sp return n+1
 * 5) Else return n 
 * 
 * 
 * No need to find max if follwed below but no change in complexities 
 *  Use indexing 
 * 
 * 1) Filter the array make everything as 0 if it is negative 
 * 2) Indexing :
 *     If arr[i]<n , make the position -ve , arr[arr[i]]= -1*arr[arr[i]]
 *     If arr[arr[i]-1]=0 , then arr[arr[i]-1]= -1*arr[i]
 * 3) if arr[i]>=0 -( non negative not present in array )
 *         return i+1;
 *         
 * 4) Find max . if max==n , present in array sp return n+1
 * 5) Else return n 
 * 
 * Yes, there is an alternate approach to solve this problem called the "Indexing Method". 
 * In this approach, we iterate through the array and for every positive element `x`, we mark `arr[x-1]` as negative.
 *  Finally, we iterate through the array again and return the index+1 of the first positive element. 
 *  This approach has a time complexity of O(N) and an auxiliary space complexity of O(1)
 * 
 * @author shree
 *
 */
public class Indexing_Smallest_missing_number {

	public static void main(String[] args) {
		int arr[]= {3,4,-1,1};
		int n=arr.length;
		int ans= SmallesPositiveMissing(arr,n);
		System.out.println(" Smallest missing "+ans);
	}

	private static int SmallesPositiveMissing(int[] arr, int n) {
		// use marking -ve  for O 1 space 
		 if(n==1 && arr[0]!=1) {
				return 1;
			}
			else if(n==1) {
				return 2;
			}
			
			int max=0;
			
			for(int i=0;i<n;i++) {
				max=Math.max(max,arr[i]);
				if(arr[i]<1) {
					arr[i]=0;
				}
			}
			int encode=0;
			//int decode=0;
		//	System.out.println(" N +"+n+" max "+max);
			for(int i=0;i<n;i++) {
				encode=Math.abs(arr[i]);
						System.out.println(" I "+i+" encde"+encode);
						if(encode>0 && encode<n ) {
						    if(arr[encode]!=0){
							arr[encode]=-1*(Math.abs(arr[encode]));}
							else{
							arr[encode]=-1*(encode);    
							}
							System.out.println(" Changed ----:"+arr[encode-1]);
						}
			}
			
			for(int i=1;i<n;i++) {
				if(arr[i]>=0) {
					return (i);
				}
				
			}
			if(max==n) {
				return n+1;
			}
			else {
				return n;
			}
	    }	
	
}