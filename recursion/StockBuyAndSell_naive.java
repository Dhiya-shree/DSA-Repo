package recursion;

public class StockBuyAndSell_naive {
	public static void main(String[] args) {
		
		int price[]= {1,5,3,8,12};
		int profit=0;
		int n=price.length-1;
		profit=BuyAndSell(price,0,n);
		System.out.println("Answer "+profit);
	}
    static int count=0;
	private static int BuyAndSell(int[] price, int start, int end) {
		// recusion function 
		//End condt - 0 at last 
		if(end<=start ) {
			System.out.println(" Ending ...............For range "+start+"-"+end);
			return 0;
		}
		
		int profit=0;
		//End gives finishing point and is n-1 last element 
		//Start gives starting point 
		for(int i=start;i<end;i++) {
			int curr_profit=0;int a=0;int b=0;
			//Giving end to stop at n-2 and j will be n-1 at last loop
			for(int j=i+1;j<=end;j++) {
				count++;
				System.out.println(" Starting ...............For range "+start+"-"+end+" in count "+count);
				if(price[j]>price[i]) // Condt as we only focus on profit , skipping condt where sell<buy
				{
				curr_profit=(price[j]-price[i]);  // Consider a,b,c,d,e,f,g,h,... for d and e profit = e-d
				System.out.println(" ----1---Starting ...............For range "+start+"-"+end+ " ans "+curr_profit);
				a=BuyAndSell(price, start,i-1);// Recursion to calculate profit in a to c 
				System.out.println(" ----2---Starting ...............For range "+start+"-"+end+ " "
						+ "ans "+a);
				b=BuyAndSell(price, j+1, end); // Recursion to calculate profit in f to h
				System.out.println(" ----3---Starting ...............For range "+start+"-"+end+ " ans "+b);
				curr_profit=curr_profit+a+b;
				System.out.println(" Ending ...............For range "+start+"-"+end+ " ans "+curr_profit);
				profit=Math.max(curr_profit,profit);
				}
				System.out.println(" End Ans  ...............For range "+start+"-"+end+" ans "+profit);
				
			}
		}
		return profit;
	}
	
}
