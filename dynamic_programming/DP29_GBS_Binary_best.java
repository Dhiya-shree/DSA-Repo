package dynamic_programming;

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
 *  while low<=high
 *  
 *  3)Find mid=3   low+high/2
 *  
 *  4) ifPossible(mid) then yes 
 *         ans=mid , high=mid-1;
 *  
 *  5) if NOT possible 
 *        low=mid-1
 *  
 *  6) return ans 
 *  
 *  
 *  IsPossible 
 *  
 *  Check if possible to cut arr with max time=mid 
 *  
 *  start=arr[0] 
 *  currK=1 
 *  for i: 1 to n 
 *    
 *    if arr[i]-start<=mid && currK+1<k
 *       add ele in curr group 
 *       currK=currK+1
 *    else
 *      start new group 
 *      m=m-1
 *      currK=1;
 *      start=arr[i]
 *      
 *      if m==0 then return false 
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
public class DP29_GBS_Binary_best {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}
