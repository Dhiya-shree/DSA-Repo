package arrayCode;

import java.util.ArrayList;

/**
 *  Problem #1: Betting game
 *  You are involved in a betting game whose rules are as follows :
 *  a) If you win a round, the bet amount will be added to your current sum and next bet amount will become $1;
 *  b) If you lose a round, the bet amount will be reduced from your current sum and next bet will become twice the previous.
 *  c) game ends either when all the rounds are complete or when you don't have sufficient sum.
 *  Initially, you are given with a string result consisting of characters from the set {'W', 'L'}, 
 *  where 'W' indicates a win and 'L' indicates a loss, and initial sum is 4. Initial bet amount for the 1st round will be $1.
 *  You need to find and print the amount at the end of the game (final sum) and 
 *  in case you do not have enough money in between the game to play the next round, then return -1.
 *  
 *  Baba - thoda complicated cases , sab aur sari edge cases patha hona chahiye ,
 *  Aur Read the ques carefully .............................................................
 *  
 *  ----------------------------------------------------------------------------------------------------------------------------
 *  
 *  Problem #2:Find duplicates in an 
 *   duplicates in an array
 *   
 *   Encode and Decode ...vry tough
 *   
 * -----------------------------------------------------------------------------------------------------------------------
 * 
 *  Problem #3 : Prefix Sum
 *  
 *  Given an array arr[] of size n, its prefix sum array is another array prefixSum[ ] of the same size, 
 *  such that the value of prefixSum[i] is arr[0] + arr[1] + arr[2] … arr[i].
 *  We need to create the prefix Array so that getsum() queries can be resolved in O(1) time.
 *  
 *  
 *-----------------------------------------------------------------------------------------------------------------
 *
 * Problem #4 :Equilibrium point 
 * 
 * Given a sequence arr[ ] of size n, Write a function int equilibrium(int[] arr, int n)
 *  that returns an equilibrium index (if any) or -1 if no equilibrium index exists. 
 * What is an Equilibrium Point?
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes
 *      is equal to the sum of elements at higher indexes.
 *      
 * 1) Naive Approach:
 * To solve the problem follow the below idea: Use two loops. The Outer loop iterates through all the element and inner loop finds out whether the current index picked by the outer loop is equilibrium index or not.
 * Time Complexity: O(n2)
 * Auxiliary Space: O(1)
 * 
 * 2) Efficient Approach
 * To solve the problem follow the below idea:
 * The idea is to get the total sum of the array first. Then Iterate through the array and keep updating the left sum which is initialized as zero. In the loop, we can get the right sum by subtracting the elements one by one. 
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)  
 * 
 * -------------------------------------------------------------------------------------------------------------
 * 
 * Problem #5 : Modified Equilibrium point 
 *           assignment given in video 
 *  
 * @author shree
 *
 */
public class ArrayPart10 {

	public static void main(String[] args) {
		// Array part Tennnnu 
		
		String bet="WWLWLLL";
		int initial_sum=4;
		int ans= BettingGameFinalVasool(bet,initial_sum);
		System.out.println(" Betting game "+ans);
		
		//------------------------------------------------------------
		
		int arr[]= {3, 4, 12, 3, 12, 3, 4, 4, 12, 7, 11, 6, 5};
		int n =arr.length;
		ArrayList<Integer> arr2=duplicates(arr, n);
		System.out.println(arr2.get(0));

		//------------------------------------------------------------
		
		int findSum[]= {0,1,2,3,4,5,6,7,8,9,10};
		int sum[]= GetPrefixSumNaive(findSum);
		ArrayPart01.PrintRayy(sum);
		int ans1=getSum(4,9,sum);
		System.out.println(" Ans get sum in O 1 is "+ans1);
		
		//---------------------------------------------------------------------
		
		long[] Eqil= {0,1};
		ans1=GetEquilibriumPoint(Eqil);
		System.out.println(" Equilibrium point at "+ans1+" value ");//+findSum[ans1]);
		
		
		//-----------------------------------------------------------------------------
		
		int equilM[]= {1,2,3,4,5};
		int ansM=GetEquilibriumPointModified(equilM);
	}

	
	 private static int GetEquilibriumPointModified(int[] equilM) {
		// TODO Auto-generated method stub
		return 0;
	}


	private static int GetEquilibriumPoint(long findSum[]) {
		// Find equilibrium point for left sum = right sum 
		 int n=findSum.length;
		 long leftSum[]=new long[n];
		 long rightSum[]=new long[n];
		 leftSum[0]=findSum[0];
		 rightSum[n-1]=findSum[n-1];
		 if(n==1) {
			 return 1;
		 }
		 for(int i=1,j=n-2;i<n;i++,j--) {
			 leftSum[i]=leftSum[i-1]+findSum[i];
			 rightSum[j]=rightSum[j+1]+findSum[j];
		 }
		 ArrayPart01.PrintRayy(findSum);
		 ArrayPart01.PrintRayy(rightSum);
		 ArrayPart01.PrintRayy(leftSum);
		 long left=0;long right=0;
		 for(int i=0;i<n;i++) {
			 if(i==0) {
				 left=0;
				 right=rightSum[1];
			 }
			 else if(i==n-1) {
				 left=leftSum[n-2];
				 right=0;
			 }
			 else {
				 left=leftSum[i-1];
				 right=rightSum[i+1];
			 }
			 System.out.println(" Left is "+left+" Right is "+right+" For i "+i+" Left - right -->"+(left-right));
			 if(left-right==0) {
				 System.out.println(" Left is "+left+" Right is "+right+" For i "+i);
				 System.out.println(" Answer eqil "+findSum[i]);
				 return i;
			 }
		 }
		return -1;
	}


	private static int getSum(int i, int j, int[] sum) {
		//Getting sum from find sum method
		 int ans=0;
		 if(i==0) {
		 ans=sum[j];}
		 else {
			 ans=sum[j]-sum[i-1];
		 }
		return ans;
	}


	private static int[] GetPrefixSumNaive(int[] findSum) {
		// make array as prefix sum 
		 int n=findSum.length;
		 for(int i=1;i<n;i++) {
			 findSum[i]=findSum[i]+findSum[i-1];
		 }
		return findSum;
	}


	public static ArrayList<Integer> duplicates(int arr[], int n) {
	       
	       int max=n;
	       
	       for(int i=1;i<n;i++){
	           max=Math.max(max,arr[i]+1);
	           
	       }
	      // max=max+1;
	       ArrayList<Integer> arr2 = new ArrayList<Integer>(max);
	      //ō ArrayList<Integer> ans = new ArrayList<Integer>(max);
	      // arr2.add(0,-1);
	       for(int i=0;i<max;i++){
	           arr2.add((i+1)*10);
	           System.out.println(i+" .... "+(i+1)*10);
	       }
	       int ind=0;int curr=0;
	       for(int i=0;i<n;i++){
	    	   ind=arr[i];curr=arr2.get(ind);
	    	   if(curr%10==0 && curr>0) {
	           arr2.set(ind,curr+1);
	           }
	    	   else if(curr>0) {
	    		   arr2.set(ind,curr*-1);
	    	   }
	    	   System.out.println(i+"-:"+(curr)+" To --->"+(arr2.get(ind))+" pos "+ind);
	       }
	     //  System.out.println(" Maxi "+max);
	       for(int i=max-1;i>=0;i--){
	    	  
	    	   curr=arr2.get(i);
	    	   System.out.println(i+"<--:"+curr);
	    	   if(curr<0) {
	           arr2.set(i,((curr*-1)/10)-1);
	           System.out.println(arr2.get(i));
	    	   }
	    	   else if(i==0 && curr>0 && arr2.size()==1 ) {
	    		   arr2.set(0, -1);
	    	   }
	    	   else {
	    		  arr2.remove(i);
	    	   }
	    	   //System.out.println(" ARR2 "+arr2.get(i));
	       }
	       
	       max=arr2.size();
	       System.out.println(" Max is "+max);
	       for(int i=0;i<max;i++){
	           System.out.println(i+" .... "+arr2.get(i));
	       }
	     
	       
		return arr2;
	       
	       
	 }
	private static int BettingGameFinalVasool(String bet, int initial_sum) {
		// find the vasool
		int n=bet.length();
		int sum=initial_sum;
		int money=1;//1$
		for(int i=0;i<n;i++) {
			char a=bet.charAt(i);
			if(a=='W') {
				sum=sum+money;
				money=1;
			}
			else if(a=='L') {
				sum=sum-money;
				money=2*money;
			}
			System.out.println(" Char is "+a+" Sum "+sum+" Money "+money);
			if(sum<0 || (sum<money&&i<(n-1))) {
				return -1;
			}
		}
		return sum;
	}

}
