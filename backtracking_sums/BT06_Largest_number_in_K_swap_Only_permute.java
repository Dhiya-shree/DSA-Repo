package backtracking_sums;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BT06_Largest_number_in_K_swap_Only_permute {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintStream o = new PrintStream(new FileOutputStream("C:\\Users\\shree\\Downloads\\LargestNumberSwapOP.txt"));
		System.setOut(o);
		String num="61892795431";//"59484321567989";
		int K=4;//6;
		String ans=findMaximumNum(num, K);
		System.out.println(" Ans is "+ans);
		System.out.println("Correct: 99876215431");//99988765523441");
		o.close();
	}
	
	 //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
        {
       
         if(k==0){
             return str;
         }
          int n=str.length();
          StringBuilder sb=new StringBuilder();
         int arr[]=new int[n];
     ///   int ans[]=new int[n];
           int digit[]=new int[10];int val=0;
           for(int i=0;i<n;i++) {
    	    	val=Character.getNumericValue(str.charAt(i));
    	    	digit[val]++;
    	    	arr[i]=val;
    	    }
           
           int p=0;
           greatest=new int[n];
   	    for(int i=9;i>=0 && p<n;i--) {
			while(digit[i]>0) {
				greatest[p]=digit[i];
				sb.append(i);
				p++;
				digit[i]--;
			}
		   }
    	    
   	    great=sb.toString();
         if(k>=n){
           
    	    
		   return sb.toString();
         }
         
         sb=new StringBuilder(n);
         
          ansArr=String.valueOf(str);String ans=String.valueOf(str);
          permute(str,n,0,n-1,ans,k,0);
          
         
          return ansArr;
        }
    
      static String ansArr;
      static int[] greatest;static String great;
      
      static public void permute(String str,int n,int left,int right,String ans,int k,int swap){
          
    	  if(swap==k || left>=right) {
    		  for(int i=0;i<n;i++) {
    			  if(ans.charAt(i)<ansArr.charAt(i)) {
    				  return;
    			  }
    			  else if(ans.charAt(i)>ansArr.charAt(i)) {
    				  ansArr=new String(ans);
    				  return;
    			  }
    		  }
    		  
    		  System.out.println(" String Final =====> "+str);
    		  return;
    	  }
    	  else {
    		  
    		  for(int i=left;i<=right && i<n;i++) {
    			  
    			  if(SafeToSwap(str,i,left)) {
    				  System.out.println(" String "+str+" Swapping "+str.charAt(i)+" and "+str.charAt(left));
    				  str=swap(str,i,left);
    				  ans=String.valueOf(str);
    				  permute(str,n,left+1,n-1,ans,k,swap+1);
    				  str=swap(str,i,left);
    			  }
    			  else if(str.charAt(left)==great.charAt(left)) {
    				  permute(str,n,left+1,n-1,ans,k,swap);
    			  }
    		  }
    	  }
         
      }

	private static String swap(String str, int i, int j) {
		// swap
		char a=str.charAt(i);
		char b=str.charAt(j);
		char ch[]=str.toCharArray();
		ch[i]=b;
		ch[j]=a;
		return (new String(ch));
	}

	private static boolean SafeToSwap(String str, int i, int left) {
		//safe to swap
		
		
		if(str.charAt(left)==great.charAt(left)) {
		    return false;	
		}
		else if(str.charAt(i)==great.charAt(left)) {
			return true;
		}
		
		
		return false;
	}
	
}
