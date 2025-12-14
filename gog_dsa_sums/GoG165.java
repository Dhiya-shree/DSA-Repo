package gog_dsa_sums;

/**
 * 
 * 1) Dictionary smallest 
 *       Trie set 
 *       Map and minimum 
 * 
 * 2) Sum Equals Length  || similar to subarray with 0 sum 
 *    Count subarray with 0 sum 
 *    Check subarray with K sum 
 *    Count subarray with K sum 
 *    
 *    idea :
 *    
 *    sum 
 *    
 *    10 , 20 , 15 , 45 , 36 ..... | 30 
 *    At a given point value 30 , to get value K 
 *    Check if 30-K is present before 30 in hashmap 
 *    
 *    2,7,10,15,20,28,36|   K=16 
 *    At sum=36 , needed K=16 
 *    Check in hashmap if sum-K present 
 *    36-16=20 present in hashmap K present
 *    
 *      Given an array of length n 
 *      Find longest length sub array 
 *      Sum of sub array == length of the subarray 
 *      
 *      No subarray return -1 
 *      
 *      ex 16,-1,3,-7,2,8,11,24
 *         output 5 ,, -1+3+-7+2+8 = 5 length=5 
 *      
 *      From 0 , if sum at i ==i+1 
 *      
 *      HashMap approach 
 *      
 *      map[0]=-1 
 *      Loop the array 
 *      map[16]=0
 *      map[15]=-1
 *      map[18]=2
 *      map[11] =3
 *      map[13] =4
 *      map[21]=5
 *      map[32]=6
 *      map[56]=7 
 *      
 *      
 * 
 * 
 * @author shree
 *
 */
public class GoG165 {

	public static void main(String[] args) {
		// GoG 165 
		
        int arr[]= {16,-1,3,-7,2,8,11,24};
	}

}
