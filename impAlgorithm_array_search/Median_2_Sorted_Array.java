package impAlgorithm_array_search;

    /**
	 * Problem #1: Median of Two Sorted Arrays......................8 points 
	 * 
	 * ex1) ar1 -> 1 3 4 6 8 10
	 *      ar2 -> 0 2 3 5 7 9  11
	 *  Merged -> 0 1 2 3 3 4 5 |6 7 8 9 10 11  => median - 5+6/2
	 *  Instead of directly merging have pointers at 4 places to signify beginning and ending 
	 *  
	 *  split ar1-> 1 3 4| \6 8 10
	 *  split ar2-> 0 2 3 5| \7 9 11
	 *  
	 *  mini1 =>|4
	 *  mini2 => |5
	 *  maxi1 =>\6
	 *  maxi2 =>\7 
	 *  
	 * length - odd : median=> Max( mini1 , mini2)
	 * 
	 * ex2) ar1 -> 1 3 4 6 8 10 12
	 *      ar2 -> 0 2 3 5 7 9  11
	 *  Merged -> 0 1 2 3 3 4 5| 6 7 8 9 10 11 12=> median - 5+6/2
	 *  Instead of directly merging have pointers at 4 places to signify beginning and ending 
	 *  
	 *  split ar1-> 1 3 4| \6 8 10 12
	 *  split ar2-> 0 2 3 5| \7 9  11
	 *  
	 *  mini1 =>|4
	 *  mini2 => |5
	 *  maxi1 =>\6
	 *  maxi2 =>\7 
	 *  
	 *  Min(maxi1,maxi2) + Max(mini1 + mini2) => 
	 * length - odd : median=> maxi1+maxi2/2
	 * 
	 * Given two sorted arrays, a[] and b[], the task is to find the median of these sorted arrays, 
	 * where N is the number of elements in the first array, and M is the number of elements in the second array. 
	 * This is an extension of median of two sorted arrays of equal size problem. 
	 * Here we handle arrays of unequal size also
	 * 
	 * Median of two sorted arrays of different sizes using Binary Search:
	 * The given two arrays are sorted, so we can utilize the ability of Binary Search to divide the array 
	 * and find the median. Median means the point at which the whole array is divided into two parts. 
	 * Hence since the two arrays are not merged so to get the median we require merging which is costly. 
	 * Hence instead of merging, we will use a modified binary search algorithm to efficiently find the median.
	 * 
	 * Follow the steps below to solve the problem:
	 * If we would have merged the two arrays, the median is the point that will divide the sorted merged array 
	 * into two equal parts. So the actual median point in the merged array would have been (M+N+1)/2;
	 * 
	 * We divide A[] and B[] into two parts. We will find the mid value and divide the first array A[] into
	 *  two parts and simultaneously choose only those elements from left of B[] array such that the sum of the count 
	 *  of elements in the left part of both A[] and B[] will result in the left part of the merged array. 
	 * Now we have 4 variables indicating four values two from array A[] and two from array B[].
	 *        leftA -> Rightmost element in left part of A.
	 *        leftb -> Rightmost element in left part of B
	 *        rightA -> Leftmost element in right part of A
	 *        rightB -> Leftmost element in right part of B
	 * 
	 * Hence to confirm that the partition was correct we have to check if leftA<=rightB and leftB<=rightA. 
	 * This is the case when the sum of two parts of A and B results in the left part of the merged array.
	 * 
	 * 
	 *  If the condition fails we have to find another midpoint in A and then left part in B[].
	 *  If we find leftA > rightB. means we have to decrease the size of A’s partition and shift to lesser value in A[]. 
	 *  So update the right pointer of to mid-1 else we will increase the left pointer to mid+1. 
	 *  Repeat the above steps with new partitions till we get the answers.
	 *  If leftA ≤ rightB and leftB ≤ rightA, then we get the correct partition and our answer depends
	 *   on the total size of the merged array (i.e. M+N). 
	 *   
	 * If (M+N) is even we take max(leftA, leftB) and min(rightA, rightB), 
	 * add them and divide by 2 to get our answer, 
	 * 
	 * else we will just return the maximum of leftA and leftB.
	 * 
	 * 
	 * @author shree
	 *
	 */
public class Median_2_Sorted_Array {

		public static void main(String[] args) {
			 int arr1[]= {1,2,3,4,5};//{1,3,4,6 ,8,10,12};
			 int arr2[]= {3,4,5,6,7,8}; //{ 0, 2 ,3, 5, 7 ,9 , 11};
			 
			 int ans=MedianOfSortedArray(arr1,arr2,arr1.length,arr2.length);
	         System.out.println(" Media is "+ans);
	         
	         ans=(int) MedianGoG(arr1,arr2);
	         System.out.println(" Media is "+ans);
		}

		private static int MedianOfSortedArray(int[] arr1, int[] arr2, int n1, int n2) {
			// Using binary search 
			//Instead of merging two array 
			//Have 4 pointer to know end and beginning in both arr - that can form the two side of median
			
			int mini1=0;
			int mini2=0;
			int maxi1=0;
			int maxi2=0;

			//Need to set smaller array as a 
			// No need to create two var 
			// if(n1<n2)
			//ArrayA= arr1 
			//ArrayB = arr2
			//else
			//ArrayA=arr2
			//ArrayB= arr1
			
			if(n1>n2) {
				return(MedianOfSortedArray(arr2,arr1,n2,n1));
			}
			
			int start=0;
			int end=n1;
			int mid1=0;
			int mid2=0;
			System.out.println(" Start "+start+" end "+end);
//			mid1=(start+end)/2;
//			int add=(n1+n2+1)/2;
//			mid2=(add)-mid1;
//			System.out.println("..."+add+" Mid 1"+mid1+"...+start+end/2"+((start+end)/2)+" ..mid2 "+mid2);
			while(start<=end) {
				//Split both the array 
				mid1=((start+end)/2);
				mid2=((n1+n2+1)/2)-mid1;
				System.out.println(" Mid 1...."+mid1+" ..mid2 "+mid2);
				//Get max and min  array 1
				mini1=(mid1==0?Integer.MIN_VALUE: arr1[mid1-1]);
				maxi1=(mid1>n1-1?Integer.MAX_VALUE : arr1[(mid1)]);
				
				//Get max and min  array 2
				mini2=(mid2==0?Integer.MIN_VALUE: arr2[mid2-1]);
				maxi2=(mid2>n2-1?Integer.MAX_VALUE : arr2[(mid2)]);
				System.out.println(" Left A "+mini1+ " Right A "+maxi1);
				System.out.println(" Left B "+mini2+ " Right B "+maxi2);
				if(mini2<=maxi1 && mini1<=maxi2) {
					
					System.out.println(" Left A "+mini1+ " Right A "+maxi1);
					System.out.println(" Left B "+mini2+ " Right B "+maxi2);
					if((n1+n2)%2==0) {
						return ((int)(Math.min(maxi1,maxi2)
								+Math.max(mini1,mini2)));
					}
					else {
						return (Math.max(mini1,mini2));
					}
				}
				
				if(mini1>maxi2) {
					end=mid1-1;
				}
				else {
					start=mid1+1;
				}
				
			}
			
			return -1;
		}
		
		private static double MedianGoG(int[] A, int[] B)
		{
			int n = A.length;
			int m = B.length;
			if (n > m)
				return MedianGoG(B,
							A); // Swapping to make A smaller

			int start = 0;
			int end = n;
			int realmidinmergedarray = (n + m + 1) / 2;
	        System.out.println(" Strat "+start+" .. end "+end+"...23r3"+realmidinmergedarray);
			while (start <= end) {
				int mid = (start + end) / 2;
				int leftAsize = mid;
				int leftBsize = realmidinmergedarray - mid;
				System.out.println(" MId b"+mid+" 2 array "+leftBsize);
				int leftA
					= (leftAsize > 0)
						? A[leftAsize - 1]
						: Integer
								.MIN_VALUE; // checking overflow
											// of indices
				int leftB = (leftBsize > 0) ? B[leftBsize - 1]
											: Integer.MIN_VALUE;
				int rightA = (leftAsize < n)
								? A[leftAsize]
								: Integer.MAX_VALUE;
				int rightB = (leftBsize < m)
								? B[leftBsize]
								: Integer.MAX_VALUE;

				System.out.println(" Left A "+leftA+ " Right A "+rightA);
				System.out.println(" Left B "+leftB+ " Right B "+rightB);
				// if correct partition is done
				if (leftA <= rightB && leftB <= rightA) {
					System.out.println(" Left A "+leftA+ " Right A "+rightA);
					System.out.println(" Left B "+leftB+ " Right B "+rightB);
					if ((m + n) % 2 == 0)
						return (Math.max(leftA, leftB)
								+ Math.min(rightA, rightB))
							/ 2.0;
					return Math.max(leftA, leftB);
				}
				else if (leftA > rightB) {
					end = mid - 1;
				}
				else
					start = mid + 1;
			}
			return 0.0;
		}

		

	}