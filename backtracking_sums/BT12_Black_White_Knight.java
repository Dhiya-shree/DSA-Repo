package backtracking_sums;

//Find the number of places black and white can be placed 

		//sol
		/*
		   No of places a single black knight can be placed in n*n 
		   Place of black = n*n-1 
		   
		   No of places white knight can be placed without getting attacked by black 
		      = n*n  - no of places black can reach
		      
		   For n=3,3 
		   black : 8 
		   White : 9-2 = 7 
		   
		   For 2*2 
		   4*3
		   
		   For 2*3 
		    1 2
		    3 4
		    5 6
		   
		    26 
		    
		    3*3 = 56 
		  
		 */
public class BT12_Black_White_Knight {

	public static void main(String[] args) {
		// black and white 
	    long modulo=(long) (Math.pow(10,9)+7);
		int n=30;
		int m=3;
		


		long one=0;
		long val=0;
	
				if(n>5 && m>5 ){
					
					
					// For val=8
					int newN=n-4;
					int newM=m-4;
					long valCenter=(newN*newM)%modulo;
					valCenter=valCenter*((n*m)-8-1)%modulo;
					
					long val1=Corner(n,m,0,2,0,m)%modulo;
					long val2=Corner(n,m,2,n,0,2)%modulo;
					long val3=Corner(n,m,n-2,n,2,m)%modulo;
					long val4=Corner(n,m,2,n-2,m-2,m)%modulo;
					
					val=(val1+val2+val3+val4+valCenter)%modulo;
					
				}
				else{ 
					
				
					System.out.println(" In if ");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
					one=SimpleBlackWhite(n,m,i,j);
			//		System.out.println(" For "+i+"- "+j+" one "+one);
					val=val+((n*m)-one-1);
				//System.out.println(" Total path from "+i+" - "+j +" for black is "+((n*m)-1-one));
			}
		}
				
				}
		System.out.println(" Total path "+val);
			

	}

	
	private static long Corner(int n,int m,int s1,int e1,int s2,int e2) {
		long one=0;long val=0;
		for(int i=s1;i<e1;i++) {
			for(int j=s2;j<e2;j++) {
		if(i-2>=0 && i+2<n && j-2>=0 && j+2<m) {
			one=8;
			}
			/////  up middle down 
			else if(i-1>=0 && i+2<n && j-2>=0 && j+2<m) {
				one=6;
			}
			else if(i==0  && i+2<n && j-2>=0 && j+2<m) {
				one=4;
			}
			else if(i-2>=0 && i+1<n && j-2>=0 && j+2<m) {
				one=6;
			}
			else if(i-2>=0 && i==n-1 && j-2>=0 && j+2<m) {
				one=4;
			}
			///// left border right 
			else if(i-2>=0 && i+2<n && j-1>=0 && j+2<m) {
				one=6;
			}
			else if(i-2>=0 && i+2<n && j==0 && j+2<m) {
				one =4;
			}
			else if(i-2>=0 && i+2<n && j-2>=0 && j+1<m) {
				one=6;
			}
			else if(i-2>=0 && i+2<n && j-2>=0 && j==m-1) {
				one=4;
			}
			else {
				one=SimpleBlackWhite(n,m,i,j);
			}
		
		   val=val+((n*m)-one-1);
			}
			
		}
		return val;
	}

	private static int SimpleBlackWhite(int n, int m, int left, int right) {
		    int sum=0;
			int l1=0,l2=0,l3=0,l4=0;int r1=0,r2=0,r3=0,r4=0;
				// prepare all
				{
					
					l1=left-2;
					l2=left-1;
					l3=left+1;
					l4=left+2;
					
					
					r1=right-2;
					r2=right-1;
					r3=right+1;
					r4=right+2;
				}
				
			//	onTheWay[left][right]=true;
				// 8 combo 
				if(l1>=0 && r2>=0) {// && onTheWay[l1][r2]==false) {
					sum=sum+1;			
				}
				if(l1>=0 && r3<m ) {//&& onTheWay[l1][r3]==false) {
					sum=sum+1;			
				}
				if(l4<n && r2>=0 ) {//&& onTheWay[l4][r2]==false) {
					sum=sum+1;			
				}
				if(l4<n && r3<m ) {//&& onTheWay[l4][r3]==false) {
					sum=sum+1;				
				}
				
				if(l2>=0 && r1>=0) {// && onTheWay[l2][r1]==false) {
					sum=sum+1;				
				}
				if(l2>=0 && r4<m) {// && onTheWay[l2][r4]==false) {
					sum=sum+1;			
				}
				if(l3<n && r1>=0 ) {//&& onTheWay[l3][r1]==false) {
					sum=sum+1;			
				}
				if(l3<n && r4<m) {// && onTheWay[l3][r4]==false) {
					sum=sum+1;				
				}

				System.out.println(" AT left-right "+left+"-"+right+" attack possib "+sum);
			
			return sum;
		}
	

}
