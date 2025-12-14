package dynamic_programming;

import java.util.Arrays;

public class DP04_min_jumps_to_go_end {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int n=arr.length;
		System.out.println(" Array "+Arrays.toString(arr));
		int ans=minJumps(arr, n);
		System.out.println(" Ans "+ans);
		
		ans=MinJumpSol(arr, n);
		System.out.println(" Ans "+ans);

	}
	
	
	static int MinJumpSol(int arr[],int n) {
		int count=0;int i=0;
		while(i<n-1) { // at N-1 reached the last 
			count=count+1;
			System.out.println(" Arr i ................"+arr[i]+" at i "+i);
			int jump=arr[i];int maxJump=0;int maxi=0;
			for(int j=1;j<=jump && i+j<n;j++)
			{   
				if(arr[i+j]!=0 && maxJump<arr[i+j]) {
				maxJump=arr[i+j];
				maxi=j;
			//	System.out.println(" J "+j+" arr[i+j] "+arr[i+j]);
				}
				
			}
			
			if(maxi==0) {
				i=i+1;
			}
			else {
			i=i+maxi;
			}
			//System.out.println(" Maxi "+maxi+" New i "+i);
			}
		
		return count;
	}

// Returns minimum number of jumps 
// to reach arr[n-1] from arr[0] 
static int minJumps(int arr[], int n) 
{ 
    // jumps[n-1] will hold the result
    int jumps[]=new int[n]; 
    if (n == 0 || arr[0] == 0) 
        return Integer.MAX_VALUE; 
 
    jumps[0] = 0;
 
    // Find the minimum number of jumps to reach arr[i] 
    // from arr[0], and assign this value to jumps[i] 
    for (int i = 1; i < n; i++) 
    { 
        jumps[i] = Integer.MAX_VALUE; 
        System.out.println(" At i "+i+" jump ");
        for (int j = 0; j < i; j++) 
        	
        { 
        	System.out.println("I "+i+"<= J "+j+" "+arr[j]+"  jumps of J "+jumps[j]);
        	
            if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) 
            { 
                jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                
                System.out.println(" Jump i-j ans ............. "+i+" "+j+"  "+Arrays.toString(jumps));
                break;
            } 
            System.out.println(" Jump i-j "+i+" "+j+"  "+Arrays.toString(jumps));
        }
        System.out.println(" At i "+i+" jump is .... "+jumps[i]);
    } 
    System.out.println(" Jump "+Arrays.toString(jumps));
    return jumps[n-1];
}

}
