package gog_dsa_sums;

import java.util.Arrays;

public class Array_Make_Array_zero {

	
	public static void main(String[] args) {
		int n=3;
		int p=96;
		int q=9;
		int arr[]= {196,182,174};
	    int ans=minimumOperations(n,arr,p,q);
	    System.out.println(" Ans "+ans);
	}
	
	public static int minimumOperations(int n, int[] arr, int p, int q) {
        // code here
        
        if(n==1){
            if(arr[0]==0){
                return 0;
            }
            else{
                if(arr[0]%p==0){
                    return (arr[0]/p);
                }
                else{
                    return (arr[0]/p +1);
                }
            }
        }
        
   
        Arrays.sort(arr);
        
      
        return minOp(0,n,arr,p,q,0);
        
    }
    
     public static int minOp(int s,int n, int[] arr, int p, int q,int ans) {
         
       if(arr[n-1]<=0){
           return ans;
       }
       
       
       int s2=0;
       
        System.out.println("Before....."+Arrays.toString(arr) + " "+s);
      int last=arr[n-1]-p;int max=last;
      arr[n-1]=last;
      int curr=0;
      boolean lastset=false;
      
      for(int i=n-2;i>=0;i--){
          curr=arr[i]-q;
          if(curr<=last && !lastset){
              arr[i+1]=last;
              arr[i]=curr;
              System.out.println(last+"<== old in "+(i+1)+" val "+arr[i+1]+" new now "+arr[i]+" at "+i+" curr "+curr);
              lastset=true;
          }
          else if(lastset){
              arr[i]=curr;
              System.out.println(" last set new now "+arr[i]+" at "+i+" curr "+curr);
          }
          else{
               arr[i+1]=curr; 
               System.out.println(" new now "+arr[i+1]+" at "+(i+1)+" curr "+curr);
          }
          
          if(curr==0){
              s2=i;
          }
          
       System.out.println(i+"After"+Arrays.toString(arr));
          max=Math.max(max,curr);
      }
      
      if(arr[0]>last) {
    	  arr[0]=last;
      }
      
       System.out.println("After   ============>"+Arrays.toString(arr));
       
       if(max<=0){
           return ans+1;
       }
       s=s2;
       return minOp(s,n,arr,p,q,ans+1);
      
     }
    
}

/*

6
1 1 18 5 17 18
2
1

3
196 182 174
96
9

*/
