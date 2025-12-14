package dynamic_programming;

public class DP01_WaysToWrite_N_as_Sum {

	public static void main(String[] args) {
		//ways to write n as sum 
		int n=6;
	    //Recursion 
		int val=CountWayRecur(n);
	    System.out.println(" Recursion value "+val);
	    // memoization 
	    memo=new int[n+1];
	 //   memo[1]=1;
	    val= CountWayMemo(n);    
	    System.out.println(" Memoization value "+val);

	}
	
	 static int memo[];
     static int CountWayMemo(int n){
    	 // base case
    	  if (n < 0)  
    	      return 0;
    	  if (n == 0)  
    	      return 1;
        
          if(memo[n]!=0) {
        	  return memo[n];
          }
          memo[n]=CountWayMemo(n-1)+CountWayMemo(n-3)+CountWayMemo(n-5);
         
        
        return memo[n];
        
     }

	  static int CountWayRecur(int n){
	         
	         if(n<0){  // number combo goes negative does not exist
	             return 0;
	         }
	         
	         if(n==0){  // number combo exists 
	             return 1;
	         }
	         
	         int res=CountWayRecur(n-1)+CountWayRecur(n-3)+
	                            CountWayRecur(n-5);
	         
	         return res;
	     }
	  
	  
}
