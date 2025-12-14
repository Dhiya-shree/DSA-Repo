package backtracking_sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class BT07_Unique_Subsets {

	
	/**
	 * 
	  null
	  1
	  11
	  111
	  1111
	  11111
	  111111
	  111101
	  111011
	  1111
	  111
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// unique subsets 
         int arr[]= {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6}; //{1,2,4,5,6,6,6,7,8};//1233
         
        digit=new int[10];
         
         long start=System.currentTimeMillis();
         
         ArrayList<ArrayList <Integer>> ANS=AllSubsets(arr,arr.length);
         long end=System.currentTimeMillis();
         System.out.println(" Answer is "+ANS.toString());
         System.out.println(" Correct is"+/* (),(1),(1 2),(1 2 3)\r\n"
         		+ "(1 2 3 3),(1 3),(1 3 3),(2),(2 3)\r\n"
         		+ "(2 3 3),(3),(3 3)");/*/  "(),(1),(1,2),(1,2,2),(2),(2,2) ");
         System.out.println(" Time taken "+(end-start)/1000+" seconds ");
         
         System.out.println(" Digitper "+Arrays.toString(digit));
	}
	
	 static  int digit[];
	//static HashMap<Integer,String> hs;static int ptr;
	public static ArrayList<ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
		ansFinal=new ArrayList <ArrayList <Integer>>();
		ansFinal.add(new ArrayList<>());
		Arrays.sort(arr);
        ptr=0;count=(int) Math.pow(2, n)-1;
        System.out.println(" Count "+(count+1));
        
       cc=0;
       
       
       for(int i=1;i<n;i++) {
       Permutation(arr,n,i,n-1);
       int arrN[]=new int[n-i];
       int s=0;
       for(int j=i;j<n;j++) {
    	   arrN[s]=arr[j];
    	   s++;
       }
       arr=arrN;
       }
       
      System.out.println(" Length "+ansFinal.size());
        return ansFinal;
    }
	
	static ArrayList<ArrayList <Integer>> ansFinal;static int ptr;static int count;static HashSet<String> hs;static int cc;static boolean swit;
	private static void Permutation(int[] arr, int n, int left, int right) {
		// Take permute combo 
		if(left>=right) {
		
			GetSubSet(arr,n);
		}
		else {
		   
			if(CanContinue(arr,left,n) ) {
		//	System.out.println(" String "+arr+" left "+left);
			for(int i=left;i<=right && i<n;i++) {
				if(IsSafe(arr,i,left,n) ) {
				arr=swap(arr,i,left);
				Permutation(arr,n,left+1,right);
				arr=swap(arr,left,i);
			}

			}
			}
		}
		
	}



	private static boolean CanContinue(int[] arr, int left,int start) {
		
		
		if(ptr<count) {
		return true;
		}
		return false;
	}


	private static boolean IsSafe(int[] arr, int i, int left,int n) {
		
		if(i==left) {
			return true;
		}
		

		if(i!=left && arr[left]==arr[i]) {
			return false;
		}
		
		if(arr[left]>arr[i]) {
			return false;
		}
		
		
		
	//	StringBuffer sb=new StringBuffer();
		for(int j=1;j<left-1;j++) {
			if(arr[j]<arr[j-1]) {
				return false;
			}
		}
		
		

		
		return true;
	}
	private static void GetSubSet(int[] arr, int n) {
		// Have permutation so use that 
		//StringBuffer sb=new StringBuffer();
		 ArrayList<Integer> ans=new ArrayList<Integer>();

		 // ans.add(arr[0]);
		
		 for(int i=0;i<n;i++) {
		
			 if(i==0) {
				 ans.add(arr[0]);
			 }
		 else if(arr[i]>=arr[i-1]) {
				 ans.add(arr[i]);
			 }
			 else if(arr[i]<arr[i-1]) {
				 break;
			 }

			
		
			
		 }
			if(!ansFinal.contains(ans)) {
				ptr++;
				digit[ans.get(0)]++;
				 ansFinal.add(new ArrayList<Integer>(ans));
			}
		 
			System.out.println(ptr+" .... Permute  "+Arrays.toString(arr));
			

		
	}
	private static int[] swap(int[] str, int i, int j) {
		// swap
		int sw=str[i];
		str[i]=str[j];
		str[j]=sw;
		return  str;
	
	}
} 


	
