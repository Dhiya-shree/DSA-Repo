package gog_dsa_sums;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * Bnary Solution >>>>>>>>>>>>>>>>> Dynamic table 
 *       N log N >>>>>>>>>>>>>>>>>> N^3 time and N^2 space  
 *
 *Given array of arrival time arr 
 * In 1 session K person can participate 
 * M no of session can be conducted 
 * Find minimum wait time 
 * 
 * arr= 3 3 4 6 9 
 * m=2
 * k=3 
 * 
 * Two meeting can be done , each with 3 or less person 
 * 
 * First meeting 3,3,4 . Meet start at 4.Minimum wait time=1
 * Second meeting 6,9 . Meet start at 9 .Minimum wait time=3
 * 
 * 1 interview can accomodate max of K students 
 * Maximum M interview possible 
 * 
 * 
 * 
 * N=5
 * M=2
 * K=3 
 * arr= 4,3,6,9,3 
 * 
 * 
 *  M1 K=3       M2 K=3 
 *  4,3,6        9,3   Max time= 3,6=6
 *  
 *  
 *  M1           M2
 *  3,3,4        6,9   Max time=1,3 =3
 *  
 *  Solving ........
 *  
 *  1) Sort array 
 *     3,3,4,6,9 
 *  
 *  2) low=0 
 *     high = arr[n-1]-arr[0]
 *          = 9-3=6 
 *  
 *  3)Find mid=3 
 *  
 *  4) ifPossible(mid) then yes 
 *  
 *  5) ans=mid 
 *  
 *  6) Check for low to mid (mid as high)
 *       new mid= 0 to mid-1 
 *  
 *  7) if NOT possible new mid
 *  
 *  8) ans between new mid and mid zn
 * 
 * 
 * 9
3
3
9 12 9 9 3 2 12 0 5
 * 
 * @author shree
 *
 */
public class GBS_Interview_Min_Wait_time {

	public static void main(String[] args) {
		//159 
		int arr[]= {3,3,4,6,9};//{9,12, 9 ,9, 3, 2 ,12, 0 ,5};//{3,3,4,6,9};// {0 ,1, 12, 5 ,2 ,10, 12, 6 ,6 ,11 ,11};
		//  0 2 3 5 9 9 9 12 12 
		// Diff 0 2 1 2 4 0 0 3 0
		//   
		int m=2;//3;//2;//4;
		int k=3;//3;//3;//11;
		int n=arr.length;
		
		int sol=GOG_ans(n,m,k,arr);
		System.out.println(" Answer is "+sol);
		
		
		int memo[][]=new int[m+1][n];
		Arrays.sort(arr);
		System.out.println(" Sorted array "+Arrays.toString(arr));
		int ans=PlaceCuts(n,m,k,arr,memo,0);
		System.out.println(" Answer is "+ans);
		
		for(int i=0;i<m+1;i++) {
			System.out.println("Memo "+Arrays.toString(memo[i]));
		}

		ans=PlaceCuts_Table(n,k,m,arr);
		System.out.println(" Table ans is "+ans);
		
		
				
	}

	private static int GOG_ans(int n, int m, int k, int[] arr) {
		// binary sol n log n 
		
		Arrays.sort(arr);
		
		int low=0;
		int high=arr[n-1]-arr[0];
		int mid=0;int ans=high;
		
		while(low<=high) {
			mid=(high+low)/2;
			System.out.println(" Check for mid "+mid);
			if(IsPossibleToCut(n,m,k,arr,mid)) {
				System.out.println(" Possible ");
				high=mid-1;
				ans=mid;
			}
			else {
				System.out.println("NOT Possible ");
				low=mid+1;
			}
		}
		return ans;
	}

	private static boolean IsPossibleToCut(int n, int m, int k, int[] arr, int mid) {
		// check if possile to cut with maximum value as mid
		int currK=1;
		int start=arr[0];
		System.out.println("Adding "+start+" at 0 in m "+m);
		for(int i=1;i<n;i++) {
			
			if(m<=0) {
				return false;
			}
			
			if((arr[i]-start)<=mid && currK+1<=k) {
				currK=currK+1;
				System.out.println("Adding "+arr[i]+" at "+i+" in m "+m);
			}
			else {
				m=m-1;
				currK=1;
				start=arr[i];
				if(m<=0) {
					return false;
				}
				System.out.println(" Create new ....... "+arr[i]+" at "+i+" in m "+m);
			}
		}
			
		return true;
	}

	private static int PlaceCuts_Table(int n, int k, int m, int[] arr) {
		// Table 
		
        if(k==1 && m>=n) {
        	return 0;
        }
        
        //Must to do 
        Arrays.sort(arr);
        
        if(m==1) {
			return arr[n-1]-arr[0];
		}
        
        int table[][]=new int[m+1][n];
        for(int i=1;i<m+1;i++) {
			Arrays.fill(table[i],Integer.MAX_VALUE);;
		}
        
        for(int i=1;i<m+1;i++) {
        	
        	for(int j=0;j<n;j++) {
        		
        		if(i==1) {
        			if(n-j<=k) {
        			table[i][j]=arr[n-1]-arr[j];
        			}
        			else {
        				// you can not make cut from 0 to n , when 0 to n is less than K 
        			//	table[i][j]=Integer.MAX_VALUE;
        			}
        		}
        		else {
        			
        			int maxCut=0;int min=Integer.MAX_VALUE;
        			for(int x=j+1;x<n && x-j<=k;x++) {
        				int currVal=Math.abs(arr[j]-arr[x-1]);
        				int nextPart=table[i-1][x];
        				maxCut=Math.max(currVal, nextPart);
        				min=Math.min(min, maxCut);
        			}
        			table[i][j]=min;
        		}
        	}
        }
		
        for(int i=0;i<m+1;i++) {
			System.out.println("Table"+Arrays.toString(table[i]));
		}
		
		return table[m][0];
	}

	private static int PlaceCuts(int n, int m, int k, int[] arr, int[][] memo,int till) {
		// base case 
		if(till>=n || m==0) {
			return 0;
		}
		
		if(m==1) {
			if(n-till<=k) {
			memo[m][till]=Math.abs(arr[n-1]-arr[till]);
		   return Math.abs(arr[n-1]-arr[till]);}
			else {
				memo[m][till]=Integer.MAX_VALUE;
				return memo[m][till];
			}
		}
		
		int maxCut=0;int min=Integer.MAX_VALUE;
		for(int x=till+1;x<n && x-till<=k;x++) {
			int currVal= Math.abs(arr[x-1]-arr[till]);
			int otherPart=PlaceCuts(n,m-1, k, arr, memo,x);
		
			if(x<n-1) {
				System.out.println(" At cut "+m+" cut from "+arr[till]+" to "+arr[x-1]+" = "+currVal);
			System.out.println(" At cut "+m+" cut from "+arr[x]+" to "+arr[n-1]+" val is "+otherPart);
			}
			
			maxCut=Math.max(currVal, otherPart);
			min=Math.min(maxCut, min);
			System.out.println(" At M="+m+" max is "+maxCut+" Min is "+min);
		}
		System.out.println(" Min of cut "+m+" ------- "+min);
		memo[m][till]=min;
		return min;
	}
	
}