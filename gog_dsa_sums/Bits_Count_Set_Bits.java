package gog_dsa_sums;

/**
 * 
 * For number x 
 * 1 2 4 8 16 32 64 ........ N h g i i i o x
 *                           |  
 *                           Highest 2^n power bit 
 * 
 * SolveBits(x=70)
 * Count set bits from 0 to 2^n = 2^(n-1)*n + 1
 * Remaining bits from n+1 to x = x-(2^n)
 * 
 *   Ex if x=70 
 *         N=64 n=6 
 *   Bits from 0 to 64 = 2^(n-1)*n+1 
 *                     = 2^5 * 6 + 1 
 *                     = 32*6+1= 193 
 *                     
 *  Remaining bits from 65 to 70 = x-N= x-2^n= 70-64
 *                               = 6 
 *                               
 *  65 to 70 :
 *    1000001 65 
 *    1000010 66adcv
 *    1000011 67 
 *    1000100 68 
 *    1000101 69 
 *    1000110 70 
 *    |
 *    First set bit in remaining count = count of remaining bit 
 *                                     = x - 2^n = 6 
 *                                     
 *  Repeat process for remaining 6 
 *  
 *  count = count till high pow of 2 + first set bit of remain + Solve(remain no of bits)
 *        = 2^n-1 * n + 1            + x - 2^n                 + SolveBits(6)
 *   
 * 
 * 
 * @author shree
 *
 */
public class Bits_Count_Set_Bits {

	public static void main(String[] args) {
		//  bits no brinkam 
       
		int n=45;
		int res=solve(n);
        
      
       System.out.println(" REsult "+res);
       
       int Bits[]=Init_BitsTable();
        res=0;
        int j=0;
      for(int i=1;i<130;i++){
    	  n=i;
    	  res=res+Bits[i];
    	  if((n&(n-1))==0) {
    	  System.out.println(i+" res "+res+" 2^x-1*x+1 ="+((1<<(j-1))*j+1 ));
    	  j=j+1;
    	  }
      }
      
    }
    
    public static int highestPow(int n)
    {
        int x = 0; 
        while(1 << x <= n) x++;
        
        return x-1;
    }
    
    public static int solve(int n)
    {
        if(n == 0) return 0;
     //   if(n==1) return 1;
        
        // Calculate Highest Power
        int x = highestPow(n);
        System.out.println(" N "+n+ " HighPow "+x);
        System.out.println(" 2^x-1 "+(1<<(x-1))+" 2^x= "+(1<<x));
        // Count Bits Till 2 ^ x - 1 if n = 11 Then for 7
        int bits = (1 << (x-1)) * x;
        System.out.println("bits till 2^x-1 * x = "+bits);
        // Count the Rest left Most Bits
        int rest = n - (1 << x) + 1;
        System.out.println("Rest of left most bits n-2^x +1 = "+rest);
        System.out.println(" solve "+(rest-1)+" ...........................");
        return  bits + rest + solve(rest - 1);
        
    }
    
    
     
    public static int  AnsBits(int n){
         int bits[]=new int[n+1];
         int res=0;
       for(int i=0;i<=n;i++){
            bits[i]=(i&1)+bits[i/2];
            res=res+bits[i];
         //   System.out.println(i+"-"+bits[i]);
        }
        return res;
    }
    
    
    public static int[] Init_BitsTable(){
         int bits[]=new int[256];
       for(int i=0;i<256;i++){
            bits[i]=(i&1)+bits[i/2];
         //   System.out.println(i+"-"+bits[i]);
        }
        return bits;
    }

}
