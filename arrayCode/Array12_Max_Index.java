package arrayCode;

import java.util.Arrays;

/*
* Problem #1:Maximum Index  Two poniter [IMPORTANT MAXXXXX]
* Given an array A[] of N positive integers.
*  The task is to find the maximum of j - i subjected to
*   the constraint of A[i] < A[j] and i < j.
*
* 1) Binary Search 
*      Create MaxArr array 
*         Traverse from n-1 to 0 and store max element to right 
*      Loop from 0 to n-1 
*      For element at i 
*        Check for pos of element greatest than arr[i]
*        For pos : arr[i]<<<< MaxArr
*        BinarySeach MaxArr,arr[i],i,n-1
*        ans=pos-i
*   Time N Log N 
* 
* 2) Two pointer :
*    Time N + N 
*    
*    example [7 3 1 8 9 10 4 5 6]
*    Rmax: [10 10 10 10 10 10 6 6 6] 
*    Lmin: [7 3 1 1 1 1 1 1 1 ] 
*    
*    MinArr = MinFrom0 to n-1 
*    MaxArr = Max From n-1 to 0  
*        
*    i=0 j=0 
*    while j>i
*    
*    if Rmax>=Lmin 
*       ans= max of ans, j-i 
*       j++
*    else
*       i++ 
*  
*  
*/

public class Array12_Max_Index {

	public static void main(String[] args) {
		// binary max index 

		int arr[]= {34, 8, 10, 3, 2, 80, 30, 33, 1};
		int ans=Binary_maxIndexDiff(arr);
		System.out.println(" Binary Val "+ans);
		
		ans=TwoPointer_maxIndexDiff(arr);
		System.out.println(" Ans Two pointer "+ans);
		
	}
	
	 // Function to find the maximum index difference.
    static int TwoPointer_maxIndexDiff(int[] arr) {
        
        int n=arr.length;
        int MaxArr[]=new int[n];
        int MinArr[]=new int[n];
        MinArr[0]=arr[0];
        MaxArr[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            MinArr[i]=Math.min(arr[i],MinArr[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            MaxArr[i]=Math.max(arr[i],MaxArr[i+1]);
        }
        
        System.out.println(Arrays.toString(MinArr));
        System.out.println(Arrays.toString(MaxArr));
        
        int i=0;int j=0;int ans=0;
        while(j>=i && j<n && i<n){
           System.out.println(i+" "+MinArr[i]+" J "+j+" "+MaxArr[j]);
            if(MaxArr[j]>=MinArr[i]){
                ans=Math.max(ans,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return ans;
    }

	 // Function to find the maximum index difference.
    static int Binary_maxIndexDiff(int[] arr) {
        
        int n=arr.length;
        int DecreaseArr[]=new int[n];
        DecreaseArr[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            DecreaseArr[i]=Math.max(DecreaseArr[i+1],arr[i]);
        }
        
       System.out.println("Max Array "+Arrays.toString(DecreaseArr));
        int max=0;
        for(int i=0;i<n-1;i++){
            
            int pos=CheckBinaryGreat(i,n-1,DecreaseArr,arr[i],i);
            System.out.println(i+" "+arr[i]+" pos "+pos+" "+arr[pos]);
            max=Math.max(max,pos-i);
        }
        return max;
    }
    //9 4 8 16 19 2
   // 34 8 10 3 2 80 30 33 1
    static int CheckBinaryGreat(int l,int r,int arr[],int ele,int pos){
        
       int ans=0;
       while(l<=r){
           
           int mid=(l+r)/2;
           if(ele<=arr[mid]){
             //  System.out.println(arr[mid]+" "+mid+" lr "+l+" "+r);
               ans=Math.max(ans,mid);
               l=mid+1;
           }
           else{
               r=mid-1;
           }
           
       } 
        
        return ans;
    }
}
