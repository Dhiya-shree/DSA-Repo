package impAlgorithm_array_search;

/**
 * 8 Mark olunga padi ............
 * 
 * Allocate Minimum pages 
 * 
 * Given a number of pages in N different books and M students.
 *  The books are arranged in ascending order of the number of pages.
 *  Every student is assigned to read some consecutive books.
 *  The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
 *  
 *  Approach 1 : 
 *  Recursive solution 
 *  
 *  1) For i loop 0 to n-1 
 *       -> a1: Take 0 to i for student 1 
 *      -> a2 : Find max for i+1 to n-1 for all other students 
 *      ->return  Min ( a1,a2)
 *  O n2 
 *  
 *  Best when sum is very high 
 *  
 *  2) Binary solution :
 *  
 *   A Binary Search method for solving the book allocation problem:
 *   Case 1: When no valid answer exists.
 *   
 *   If the number of students is greater than the number of books (i.e, M > N), 
 *   In this case at least 1 student will be left to which no book has been assigned.
 *   
 *   Case 2: When a valid answer exists.
 *   The maximum possible answer could be when there is only one student.
 *    So, all the book will be assigned to him and the result would be the sum of pages of all the books.
 * 
 * The minimum possible answer could be when number of student is equal to the number of book (i.e, M == N) , 
 * In this case all the students will get at most one book.
 * 
 *  So, the result would be the maximum number of pages among them (i.e, minimum(pages[])).
 * Hence, we can apply binary search in this given range and each time we can consider 
 * the mid value as the maximum limit of pages one can get.
 * 
 *  And check for the limit if answer is valid then update the limit accordingly.
 * 
 * 
 * Below is the implementation of the above idea:
 * 
 * Initialise the start to minimum(pages[]) and end = sum of pages[],
 * Do while start <= end
 * Calculate the mid and check if mid number of pages can assign any student by satisfying the given condition such that all students will get at least one book. Follow the steps to check for validity.
 * Initialise the studentsRequired = 1 and curr_sum = 0 for sum of consecutive pages of book
 * Iterate over all books or say pages[]
 * Add the pages to curr_sum and check curr_sum > curr_min then increment the count of studentRequired by 1.
 * Check if the studentRequired > M, return false.
 * Return true.
 * If mid is valid then, update the result and move the end = mid – 1
 * Otherwise, move the start = mid + 1
 * Finally, return the result.
 *  
 *  
 *  
 * @author shree
 *
 */
public class Allocate_Minimum_page_Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,2,3,4,5,6,77,88,99};
		int n=arr.length;
		int k=4;
		
		int ans=0;
		
		ans=NaiveRecursionGoG(arr,n,0,k);
		System.out.println(" REcur sol "+ans);
		
		ans=EfficientBinarySearch(arr,n,k);
		System.out.println(" Efficien "+ans);
		
		ans=EfficientBinarySearchGoG(arr,n,k);
		System.out.println(" Efficien "+ans);
	}

	// Utility method to check if current minimum value
		// is feasible or not.
		static boolean isPossible(int arr[], int n, int m,
								int curr_min)
		{
			int studentsRequired = 1;
			int curr_sum = 0;

			// iterate over all books
			for (int i = 0; i < n; i++) {
				curr_sum += arr[i];
				if (curr_sum > curr_min) {
					studentsRequired++; // increment student
										// count

					curr_sum = arr[i]; // update curr_sum
				}
			}

			return studentsRequired <= m;
		}

		// method to find minimum pages
		private static int EfficientBinarySearchGoG(int[] arr, int n, int m) {
			int sum = 0;

			// return -1 if no. of books is less than
			// no. of students
			if (n < m)
				return -1;

			// Count total number of pages
			for (int i = 0; i < n; i++)
				sum += arr[i];

			// initialize start as arr[n-1] pages(minimum answer
			// possible) and end as total pages(maximum answer
			// possible)
			int start = arr[n - 1], end = sum;
			int result = Integer.MAX_VALUE;

			// traverse until start <= end
			while (start <= end) {
				// check if it is possible to distribute
				// books by using mid is current minimum
				int mid = start + (end - start) / 2;
				if (isPossible(arr, n, m, mid)) {
					// update result to current distribution
					// as it's the best we have found till now.
					result = mid;

					// as we are finding minimum so,
					end = mid - 1;
				}

				else
					// if not possible, means pages should be
					// increased ,so update start = mid + 1
					start = mid + 1;
			}

			// at-last return minimum no. of pages
			return result;
		}

	
	private static int EfficientBinarySearch(int[] arr, int n, int k) {
		// Find sum and max , ans in range of sum and max 
		int sum=0;
		int max=-1;
		for(int i=0;i<n;i++) {
			sum=sum+arr[i];
			max=Math.max(max,arr[i]);
		}
		//Special case , one book and one student 
		if(n==1) {
			return (arr[0]);
		}
		if(k==1) {
			return (sum);
		}
		
		// Setting range max - sum 
		int low= max;
		int high=sum;
		
		int mid=0;int ans=0;
		//Binary search 
		
		while(low<=high) {
			mid=(low+high)/2;
			
			if(ans==mid) {
				break;
			}
			if( FindIfFeasible( arr,n,k,mid)) {
				// If books can be allocated with given mid 
				// As we need to find min of max pages 
				//check the left half - low to mid-1
				high=mid-1;
				ans=mid;
				//Mid possible ans 
			}
			else {
				///If not search right
				low=mid+1;
			}
		}
		return ans;
	}

	private static boolean FindIfFeasible(int[] arr, int n, int k, int mid) {
		// Method to find if it can be allocated between n students 
		//All student must get pages less than mid 
		// If remaining pages can be allocated to students in less than mid 
		
		int req=1;//REquired too stidents to split < mid
		int sum=0;
		
		for(int i=0;i<n;i++) {
			
			if(sum+arr[i]>mid) {
				req++;
				sum=arr[i];
			}
			else {
				sum=sum+arr[i];
			}
			
		}
		if(req<=k) {
			return true;
		}
		// More students required 
		return false;
	}

	private static int FindSum(int arr[],int start,int end) {
		int sum=0;
		for(int i=start;i<end;i++) {
			sum=sum+arr[i];
		}
		return sum;
	}
	private static int NaiveRecursionGoG(int[] arr, int n, int i, int k) {
		// To find combination to have 
		// Minimum possible page
		//From maximum pages 
		// { 1,2,3,4} student - 2
		//Possible combination 
		//Combo  (10,0),(1,9),(3,7),(6,4),(0,10)  .......sum 1
        // Max      10 ,  9  ,  7  ,  6  ,  10    ......Max of sum 2
		//Min of Max   - -----> 6 (6,4)     ............Min of max found 3
		//In recursion min of max sum is 
		// Min ( MAX_value ,max( recur for others,sum));
		
		//Special case , one book 
		if(n==1) {
			return (arr[0]);
		}
		if(k==1) {
			return (FindSum(arr, 0, n));
		}
		
		//For min initiate 
		int ans=Integer.MAX_VALUE;
		
		//Find all possible combo 
		
		for(int i1=0;i1<n;i1++) {
			
			ans = Math.min(ans,   //Min of max found 
				    Math.max( NaiveRecursionGoG(arr,n,i1,k-1),//Max of sum and remain
				    		(FindSum(arr,i1,n)) )
				    );
		}
		
		return ans;
	}

}
