package impAlgorithm_array_search;

public class Two_Pointer_Algo_FindPairInSortedArray {

	public static void main(String[] args) {
		int val=23;
		int arr2[]= {1,2,3,4,5,7,8,9,11,12,13,15,30,40,50,100};
		int ans=TwoPointerMethod(arr2,val);
		System.out.println(" Two pointr ans "+ans);
	}
	
	private static int TwoPointerMethod(int[] arr2, int val) {
		// Find the pair whose sum = val
		int n=arr2.length;
		int i=0;
		int j=n-1;
		int sum=0;
		while(i<j) {
			sum=arr2[i]+arr2[j];
			if(sum==val) {
				System.out.println(" Pair found "+arr2[i]+" and "+arr2[j]+"  is sum "+sum);
				//To find one pair add return statement 
				//return 1000;
			}
			if(sum<val) {
				System.out.println(" Remove i "+arr2[i]);
				i=i+1;
			}
			else {
				System.out.println(" Remove j "+arr2[j]);
				j=j-1;
			}
		}
		return 0;
	}
}
