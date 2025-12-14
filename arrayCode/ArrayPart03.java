package arrayCode;

import java.util.ArrayList;

/*
 * Problem #1:Maximum Index  Two poniter [IMPORTANT MAXXXXX]
 * Given an array A[] of N positive integers.
 *  The task is to find the maximum of j - i subjected to
 *   the constraint of A[i] < A[j] and i < j.
 *   
 *   
 * 	Problem #2: MatchStick Game [IMPORTANT]
 * Two friends, A and B, are playing the game of matchsticks. 
 * In this game, a group of N matchsticks is placed on the table. 
 * The players can pick any number of matchsticks from 1 to 4 (both inclusive) during their chance.
 *  The player who takes the last match stick wins the game.
 *   If A starts first, how many matchsticks should he pick on his 1st turn such that
 *    he is guaranteed to win the game or determine if it's impossible for him to win. 
 *    Return -1 if it's impossible for A to win the game, else return the number of matchsticks
 *     should he pick on his 1st turn such that he is guaranteed to win.
 * 
 *  Problem #3: Second largest element in the array index , 
 *  First large must be > second large
 *  1) Initialize the first as 0(i.e, index of arr[0] element
 *  2) Start traversing the array from array[1],
 *     a) If the current element in array say arr[i] is greater than first.
 *      Then update first and second as,
 *      second = first
 *      first = arr[i]
 *     b) If the current element is in between first and second,
 *     then update second to store the value of current variable as second = arr[i]
 *     3) Return the value stored in second.
 *     
 *    Problem #4:Check if array is sorted and rotated
 *    Given an array arr[] of N distinct integers, 
 *    check if this array is Sorted (non-increasing or non-decreasing) and Rotated counter-clockwise
 *     
 *     nput:N = 4   arr[] = {3,4,1,2}    Output: Yes  
 *      Explanation: The array is sorted (1, 2, 3, 4) and rotated twice  (3, 4, 1, 2).   
 *     
 *    Problem #5:Reverse array in groups
 *    Given an array arr[] of positive integers of size N.
 *     Reverse every sub-array group of size K.Note: If at any instance, 
 *     there are no more subarrays of size greater than or equal to K, 
 *     then reverse the last subarray (irrespective of its size).
 *      You shouldn't return any array, modify the given array in-place
 *      
 *      
 *    Problem #6  Remove duplicates from sorted array and return array with size
 *    
 *    
 */
public class ArrayPart03 {

	public static void main(String[] args) {
		// Prblemu
	    int A[]= {65,6,74,94,56,89,9,63,75,25,34,68,93,48,16};
		int N=A.length;
		maxIndexDiff(A, N);
		maxIndexDiffEffi(A,N);
		N=48;
		matchGame(N);
		//O(1)
		SecondLargeElementIndex(A,N);
		//O( n2)
		SecondLargeElementIndexEEfficient(A,N);
		//O(1)
		int n1=3;
		int A1[]= {2,1,2};
		largestAndSecondLargest( n1,A1);
		//O(n)
		int A3[]= {2,3,5,1,4};
		SortedAndRotated(A3,5);
		
		ReverseArrayInGroup();
		
		reverseInGroupsArrayList();
        
		RemoveDuplicateInSorted();
	}

	
	private static void RemoveDuplicateInSorted() {
		// given array with duplicates
		int arr[]= {5,10,10,50,50,100,100,100,100,1000};
		int temp=1;
		int n=arr.length;
		for(int i=1;i<n;i++) {
			if(arr[i]!=arr[i-1]) {
				arr[temp]=arr[i];
				temp++;
			}
		}
		ArrayPart01.PrintRayy(arr);
		System.out.println(" Temp "+temp);
	}


	private static void ReverseArrayInGroup() {
		// Reverse Array In Group of K 
		int arr[]= {0,9};//,1,2,3,4,5,6,7,8,9,10,11,12,13};
		int n=arr.length;
		ArrayPart01.PrintRayy(arr);
		System.out.println(" ==Arrey above dekho !!!!");
		int reverse=5;
	//	int start=Math.ceilDiv((start+end),2);;
		if(n==1) {
			ArrayPart01.PrintRayy(arr);
			System.out.println(" No need to reverse single element");
			return;
		}
		if(reverse>n) {
			reverse=n;
		}
		int mid=Math.ceilDiv(reverse,2);
		System.out.println("Mid "+mid);
		int temp=0;
		int end=reverse-1;
		int start=Math.floorDiv((end),2);;

		//int k=0;
		
		System.out.println("Hey there , First start is "+start + " end is "+end +" at i= ");
		int i=0;
		while(i<n){
			System.out.println("Switched i "+i+"value "+arr[i] +" with place "+end+ "value "+arr[end]);
			temp=arr[end];
			arr[end]=arr[i];
			arr[i]=temp;
			end--;i++;
			//System.out.println("Switched i "+i+"value "+arr[i] +" with place "+end+ "value "+arr[end]);
			if(i>=end) {
				i=i+mid;
			    start=i;
				if((i+reverse)>n-1) {
					end=n-1;
				}else {
				end=i+reverse-1;
				}
				//mid=Math.ceilDiv((start+end),2);
				//start=Math.ceilDiv((i+end),2);
				
				//start=Math.ceilDiv((start+end),2);//+Math.ceilDiv((reverse),2);
				System.out.println(" I   "+i+" Reverse "+reverse+" Start "+start);
				System.out.println("Hey there , new  start is "+start + " end is "+end +" at i= "+i);
			}
           //i++;end--;
		}
		
		ArrayPart01.PrintRayy(arr);
		
	}

	public static void reverseInGroupsArrayList () {
	       // int arr[]= {0,9};//,1,2,3,4,5,6,7,8,9,10,11,12,13};
		    ArrayList <Integer> Arr = new ArrayList<Integer>();
		    Arr.add(0);
		    Arr.add(1);
		    Arr.add(0);
		    Arr.add(1);
		    Arr.add(0);
		    Arr.add(1);
		    Arr.add(0);
		    Arr.add(1);
		    Arr.add(0);
		    Arr.add(1);
		    Arr.add(0);
		    Arr.add(1);
		//	int n=arr.length;
		  //  Arr.s
		//	ArrayPart1.PrintRayy(arr);
		//	System.out.println(" ==Arrey above dekho !!!!");
			int reverse=2; int n=12;
		//	int start=Math.ceilDiv((start+end),2);;
			if(n==1) {
			//	ArrayPart1.PrintRayy(arr);
				System.out.println(" No need to reverse single element");
				return;
			}
			if(reverse>n) {
				reverse=n;
			}
			int mid=Math.ceilDiv(reverse,2);
		//	System.out.println("Mid "+mid);
			int temp1=0;int temp2=0;
			int end=reverse-1;
			//int start=Math.floorDiv((end),2);;

			//int k=0;
			
		//	System.out.println("Hey there , First start is "+start + " end is "+end +" at i= ");
			int i=0;
			while(i<n){
			//	System.out.println("Switched i "+i+"value "+arr[i] +" with place "+end+ "value "+arr[end]);
				temp1=Arr.get(end);
				temp2=Arr.get(i);
				Arr.add(end,temp2);
				Arr.add(i,temp1);
				end--;i++;
				//System.out.println("Switched i "+i+"value "+arr[i] +" with place "+end+ "value "+arr[end]);
				if(i>=end) {
					i=i+mid;
				    //start=i;
					if((i+reverse)>n-1) {
						end=n-1;
					}else {
					end=i+reverse-1;
					}
					//mid=Math.ceilDiv((start+end),2);
					//start=Math.ceilDiv((i+end),2);
					
					//start=Math.ceilDiv((start+end),2);//+Math.ceilDiv((reverse),2);
				//	System.out.println(" I   "+i+" Reverse "+reverse+" Start "+start);
				//	System.out.println("Hey there , new  start is "+start + " end is "+end +" at i= "+i);
				}
	           //i++;end--;
			}
			Object[] arr=Arr.toArray();
			ArrayPart01.PrintRayy(arr);
			System.out.println("Success");
			return;
	    }

	private static void SortedAndRotated(int[] a, int n) {
		// Sorted And Rotated
		//int mismatch;
		int desc=0;
		int asc=0;
		for(int i=0;i<n;i++) {
			if(i==n-1) {
				if(a[0]<a[i]) {
					asc++;
					System.out.println("If n-1  " + i +" Asc "+asc+" Desc "+desc+ "1st "+a[0]+" 2 sc"+a[i]);
				}
				else if(a[0]>a[i]) {
					desc++;
					System.out.println("If else n-1  " + i +" Asc "+asc+" Desc "+desc+ "1st "+a[0]+" 2 sc"+a[i]);

				}
			}
			else {
			if(a[i]<a[i+1]) {
				asc++;
				System.out.println("If   " + i +" Asc "+asc+" Desc "+desc + "1st "+a[i]+" 2 sc"+a[i+1]);
			}
			else if(a[i]>a[i+1]) {
				desc++;
				System.out.println("If else  " + i +" Asc "+asc+" Desc "+desc+ "1st "+a[i]+" 2 sc"+a[i+1]);

			}
			
			System.out.println("else  i n "+i+" Asc "+asc+" Desc "+desc);}
		}
		int res=Math.abs(n-desc);
		int res2=Math.abs(n-asc);
		System.out.println("..............");
		System.out.println("Res1 desc "+ res+" Res2 asc "+res2);
		if(res2==2 || res==2) {
			System.out.println("Sorted and rotated ");
		}
		else if(res2==n || res==n) {
			System.out.println("Sorted ");
		}
		else {
			System.out.println("Unsorted");
		}
		
	}


	public static void largestAndSecondLargest(int sizeOfArray, int a[])
    {
        ArrayList<Integer> Arr = new ArrayList<Integer>(2);
        int n=sizeOfArray;int max1=0;int max2=0;
       if(n==1) {
			max1=a[0];
			max2=-1;
		}
		else if(n==2){
		    if(a[0]>a[1]){
		        max1=a[0];
		        max2=a[1];
		    }
		    else if(a[1]>a[0]){
		        max1=a[1];
		        max2=a[0];
		    }
		    else{
		        max1=a[0];
		        max2=-1;
		    }
		}
		else{
		max1=a[0];
		max2=-1;
		int res=-1;
		System.out.println("ELSSAAA"+ n);
		for(int i=0;i<n;i++) {
			
			if(a[i]>max1) {
				if(max2<max1 && res!=-1) {
					max2=max1;
				}
				max1=a[i];
				System.out.println("In if ");
			}
			else if((a[i]>max2||res==-1) && (a[i]!=max1)) {
				max2=a[i];
				res=i;
				System.out.println("In else if ");
			}
			else {
				continue;
			}
			
		//	System.out.println("Max 1 :"+ max1+" Max2 :"+max2+ " I: "+i+ " Res: "+ res);
		}
		if(res==-1) {
			System.out.println("Setting - 1"+res);
			max2=-1;
		}
		//System.out.println("Max 1: "+ max1+" Max2 +"+max2); 
		}
		Arr.add(max1);
		Arr.add(max2);
		System.out.println(Arr.get(0)+" "+Arr.get(1));
    }


	private static void SecondLargeElementIndexEEfficient(int[] a, int n) {
		// Two pointer 
		if(n<2) {
			System.out.println("Ans "+-1);
		}
		int max1=a[0];
		int max2=a[1];
		int res=-1;
		for(int i=0;i<n;i++) {
			if(a[i]>max1) {
				//if(max2<max1) {
					max2=max1;
				//}
				max1=a[i];
				System.out.println("In if ");
			}
			else if(a[i]>max2 && a[i]!=max1) {
				max2=a[i];
				res=i;
				System.out.println("In else if ");
			}
			else {
				continue;
			}
			System.out.println("Max 1 :"+ max1+" Max2 :"+max2+ " I: "+i+ " Res: "+ res);
		}
		System.out.println("Max 1: "+ max1+" Max2 +"+max2);
	}

	private static void SecondLargeElementIndex(int[] a, int n) {
		// Second Large Element Index
		int max1=a[0];
		int max2=0;
		int res=-1;
		///Need to initialize result s -1 as for array {1,1,1,1,1}
		//There is no second largest 
		for(int i=1;i<n;i++) {
			if(a[i]>max1) {
				max1=a[i];
			}
		}
		for(int i=0;i<n;i++) {
			if(a[i]<max1 && a[i]>max2) {
				max2=a[i];
				res=i;
			}
		}
		System.out.println(" Res"+ res);
		
	}

	private static void matchGame(long N) {
        // if n =1 ,A can choose 1 to win , if n2 A choose 2 , if N=3 A choose 3 , N=4 A choose 4 
		//if N =5, if A choose 1,2,3,4 Last B will take 
		// If N=6 , if A choose 1 , B can take 1,2,3,4 , But A can again take 1 
		//If N=7 , if A take 2, balance 5 , so B can take anycount 1-4, A can take last 
		//If N=8 , A -3 , B- 1 to 4 , A- 4 to 1  
		//If N=9 , A - 4 , B - 1 to 4 , A 4-1 win 
		//If N=10 , If A take 4 , B can take 1 , A can take 1-4 , B might win by taking 4 to 1 
		//So return modulo 5 
		int res=(int) (N%5);
		if (res==0) {
			System.out.println("A can not win"+res);
		}
		else {
			System.out.println("A can win "+res);
		}
		
    }
private static void maxIndexDiffEffi(int[] arr, int n) {
        if(n==1){
           System.out.println("0");
        }
        int RMax[] = new int[n]; 
        int LMin[] = new int[n]; 
        
        LMin[0] = arr[0];
        for (int i = 1; i < n; ++i) 
            LMin[i] = Integer.min(arr[i], LMin[i - 1]);
      
        RMax[n - 1] = arr[n - 1]; 
        for (int j = n - 2; j >= 0; --j)
            RMax[j] = Integer.max(arr[j], RMax[j + 1]); 
            
        int i = 0, j = 0, maxDiff = -1; 
        
        while (j < n && i < n) { 
            if (LMin[i] <= RMax[j]) { 
                System.out.println("J "+j+" I "+i+"Diff "+(j-i)+ " MaxDiff"+maxDiff);
                maxDiff = Integer.max(maxDiff, j - i); 
                j++; 
            } else
                i++;
        }
        
       System.out.println(" MAX DIFF"+maxDiff);
    }
			 

static void maxIndexDiff(int A[], int N) { 
	int ans=0;
    int j=N;
    int ansc=0;
    //int len=(int)(N/2);
    while(j>1) {
        j--;
    for(int i=0;i<=j;i++) {
    	if(A[i]<=A[j] && ansc<(j-i)) {
    		ansc=j-i;
    		break;
    	}
    }
    if(ansc>ans) {
    	ans=ansc;
    	break;
    }

    
    }
        System.out.println("Maximum index"+ans);
        
    }
}
