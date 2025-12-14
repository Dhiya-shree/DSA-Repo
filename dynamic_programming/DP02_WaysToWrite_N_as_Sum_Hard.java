package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DP02_WaysToWrite_N_as_Sum_Hard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        table=new int[10];
        table[0]=1;
          int ans=countWays(7);
          
          System.out.println(" Ans "+ans);
          System.out.println(Arrays.toString(table));
	}

	// Returns number of ways to write 
    // n as sum of two or more positive  
    // integers 
    static int[] table;
    static int countWays(int n) 
    { 
    	
         int res=table[n]; 
     if(res!=0){
         return res;
     }
     else{
         int res2=0;
         System.out.println(" N is :---"+n);
         for(int i=1;i<n;i++){
        	 
        	 for(int j=i;j<=n;j++) {
        		  table[j]=table[j]+table[j-i];
        			// res2=res2%1000000007;
             System.out.println(" At i "+i+" value  j " +j+" res is "+Arrays.toString(table)+" for n ........."+n);
        	 }
         }
         System.out.println(" N is res " +n+ ":---"+table[n]);
         res=table[n]%1000000007;
    //   table[n]=res;
         return res;
     }
     
    } 
    
    
    public static int[] matchingCnt(int n, String[] X) {
        // code here
        
        int ans[]=new int[n];
        int mn=0;
        for(int i=0;i<n;i++){
            mn=Math.max(mn,X[i].length());
        }
        
        ArrayList<HashMap<Integer,Integer>> arr=new ArrayList<HashMap<Integer,Integer>>(mn);
        for(int i=0;i<mn;i++){
            arr.add(new HashMap<Integer,Integer>());
        }
        
        for(int i=n-1;i>=0;i--){
            int count=0;
            int n1=X[i].length();
           
            for(int j=0;j<n1;j++){
                int c=X[i].charAt(j);
                int k=0;
                if(arr.get(j).containsKey(c)){
                k=arr.get(j).get(c);
                count=count+k;
                
                }
                
               arr.get(j).put(c,k+1);
            }
            ans[i]=count;
        }
       
        return ans;
    }

}


