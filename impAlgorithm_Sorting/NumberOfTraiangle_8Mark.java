package impAlgorithm_Sorting;
import java.util.Arrays;
import arrayCode.ArrayPart01;

/**
 * 
 * Problem #1: Count the number of possible triangles
 * Given an unsorted array arr[] of n positive integers. Find the number of triangles
 *  that can be formed with three different array elements as lengths of three sides of triangles. 
 * 
 * Given an unsorted array of positive integers, find the number of triangles that can be formed with three different array elements as three sides of triangles. For a triangle to be possible from 3 values, the sum of any of the two values (or sides) must be greater than the third value (or third side). 
Examples: 

Input: arr= {4, 6, 3, 7}
Output: 3
Explanation: There are three triangles 
possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. 
Note that {3, 4, 7} is not a possible triangle.  

Input: arr= {10, 21, 22, 100, 101, 200, 300}.
Output: 6

Explanation: There can be 6 possible triangles:
{10, 21, 22}, {21, 100, 101}, {22, 100, 101}, 
{10, 100, 101}, {100, 101, 200} and {101, 200, 300}

 * 
 * Method 1(Brute Force) :

Approach: 

The brute force method is to run three loops and keep track of the number of triangles possible so far. The three loops select three different values from an array. The innermost loop checks for the triangle property which specifies the sum of any two sides must be greater than the value of the third side).

Algorithm: 

Run three nested loops each loop starting from the index of the previous loop to end of array i.e run first loop from 0 to n, loop j from i to n and k from j to n.
Check if array[i] + array[j] > array[k], i.e. sum of two sides is greater than the third
Check condition (2) for all combinations of sides by interchanging i, j, k
If all three conditions match, increase the count.
Print the count
 * 
 * Method 2: This is a tricky and efficient approach to reduce the time complexity from O(n^3) to O(n^2)where two sides of the triangles are fixed and the count can be found using those two sides.

Approach: 

First sort the array in ascending order. Then use two loops. The outer loop to fix the first side and inner loop to fix the second side and then find the farthest index of the third side (greater than indices of both sides) whose length is less than sum of the other two sides. So a range of values third sides can be found, where it is guaranteed that its length if greater than the other individual sides but less than the sum of both sides.

Algorithm: Let a, b and c be three sides. The below condition must hold for a triangle (sum of two sides is greater than the third side) 

a + b > c 
b + c > a 
a + c > b
Following are steps to count triangle. 

Sort the array in ascending order.
Now run a nested loop. The outer loop runs from start to end and the inner loop runs from index + 1 of the first loop to the end. Take the loop counter of first loop as i and second loop as j. Take another variable k = i + 2
Now there is two pointers i and j, where array[i] and array[j] represents two sides of the triangles. For a fixed i and j, find the count of third sides which will satisfy the conditions of a triangle. i.e find the largest value of array[k] such that array[i] + array[j] > array[k]
So when we get the largest value, then the count of third side is k - j, add it to the total count.
Now sum up for all valid pairs of i and j where i < j
 * 
 * Complexity Analysis: 

Time Complexity: O(n^2). 
The time complexity looks more because of 3 nested loops. It can be observed that k is initialized only once in the outermost loop. The innermost loop executes at most O(n) time for every iteration of the outermost loop, because k starts from i+2 and goes up to n for all values of j. Therefore, the time complexity is O(n^2).
Space Complexity: O(1). 
No extra space is required. So space complexity is constant
 * 
 * Method 3: The time complexity can be greatly reduced using Two Pointer methods in just two nested loops.

Approach: 

First sort the array, and run a nested loop, fix an index and then try to fix an upper and lower index within which we can use all the lengths to form a triangle with that fixed index.

Algorithm:

Sort the array and then take three variables l, r and i, pointing to start, end-1 and array element starting from end of the array.
Traverse the array from end (n-1 to 1), and for each iteration keep the value of l = 0 and r = i-1
Now if a triangle can be formed using arr[l] and arr[r] then triangles can obviously formed 
from a[l+1], a[l+2].....a[r-1], arr[r] and a[i], because the array is sorted , which can be directly calculated using (r-l). and then decrement the value of r and continue the loop till l is less than r
If a triangle cannot be formed using arr[l] and arr[r] then increment the value of l and continue the loop till l is less than r 
 
So the overall complexity of iterating 
through all array elements reduces.
 * 
 * omplexity Analysis: 

Time complexity: O(n^2). 
As two nested loops are used, but overall iterations in comparison to the above method reduces greatly.
Space Complexity: O(1). 
As no extra space is required, so space complexity is constant
 * 
 * @author shree
 *
 */
public class NumberOfTraiangle_8Mark {

	public static void main(String[] args) {
	  
		int arr[] ={26 ,9 ,27 ,22 ,16 ,27};// {6, 4, 9, 7, 8};
		int n=arr.length;
		
		int ans=CoutNoOfTriange(arr,n);
		System.out.println(" Ans "+ans);
		
		ans=CountNoOfTraiangleBruteForce(arr,n);
		System.out.println(" Ans Brute "+ans);
		
		ans=CountNoOfTriangleTwoPointerIdx0(arr,n);
		System.out.println(" Ans two pointer fix 2nd and run "+ans);
		
		ans=CountNoOfTriangle_Two_PointerGoG(arr,n);
		System.out.println(" Ans Gog Two Pointer "+ans);
		
	}

	private static int CountNoOfTriangle_Two_PointerGoG(int[] arr, int n) {
		// Time O n2
		Arrays.sort(arr);

        int count = 0;

        for (int i = n - 1; i >= 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) {

                    // If it is possible with a[l], a[r]
                    // and a[i] then it is also possible
                    // with a[l+1]..a[r-1], a[r] and a[i]
                    count += r - l;

                    // checking for more possible solutions
                    r--;
                }
                else // if not possible check for
                // higher values of arr[l]
                {
                    l++;
                }
            }
        }
        System.out.print("No of possible solutions: " + count);
		return count;
	}

	private static int CountNoOfTriangleTwoPointerIdx0(int[] arr, int n) {
		// Time Complexity: O(n^2). 
		 // Sort the array elements in non-decreasing order
        Arrays.sort(arr);

        // Initialize count of triangles
        int count = 0;

        // Fix the first element. We need to run till n-3 as
        // the other two elements are selected from
        // arr[i+1...n-1]
        for (int i = 0; i < n - 2; ++i) {
            // Initialize index of the rightmost third
            // element
            int k = i + 2;

            // Fix the second element
            for (int j = i + 1; j < n; ++j) {
                // Find the rightmost element which is
                // smaller than the sum of two fixed
                // elements The important thing to note here
                // is, we use the previous value of k. If
                // value of arr[i] + arr[j-1] was greater
                // than arr[k], then arr[i] + arr[j] must be
                // greater than k, because the array is
                // sorted.
                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;

                // Total number of possible triangles that
                // can be formed with the two fixed elements
                // is k - j - 1. The two fixed elements are
                // arr[i] and arr[j]. All elements between
                // arr[j+1] to arr[k-1] can form a triangle
                // with arr[i] and arr[j]. One is subtracted
                // from k because k is incremented one extra
                // in above while loop. k will always be
                // greater than j. If j becomes equal to k,
                // then above loop will increment k, because
                // arr[k] + arr[i] is always/ greater than
                // arr[k]
                if (k > j)
                    count += k - j - 1;
            }
        }
        return count;

	}

	private static int CountNoOfTraiangleBruteForce(int[] arr, int n) {
		//Time Complexity: O(N^3) where N is the size of input array.
		//Space Complexity: O(1)
		// Sort the array
        Arrays.sort(arr);
        // Count of triangles
        int count = 0;
        // The three loops select three different values
        // from array
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if (arr[i] + arr[j] > arr[k])
                        count++;
        return count;
	}

	private static int CoutNoOfTriange(int[] arr, int n) {
		//Triange sum of two sides , greater than third 
		Arrays.sort(arr);
		System.out.println(" Sorted ...");
		ArrayPart01.PrintRayy(arr);
        int count=0;
        //--fixed --1 --2 , 1 and 3 can be in 4 numbers 6,7,8,9 - 1to 4 
        // 4 6 7 etc 4,6 - 3 , 4,7-2  , 4,8 -1 
        // 4 -3 -2
        // p2-p1 * p2-p1-1
        
        // 6 7 8 9 - 2 to 4 
        // 6 7 ..2 6 8 ..1 
        // 6 -2 -1
        // p2-p1-1 * p2-p1
        
        // 7 8 9 -3 to 4 
        // 7 8 .. 1 
        // p2-p1 * p2-p1-1
        int sum=0;
        for(int i=n-1;i>1;i--){
            int p1=0;int p2=i-1;
            
            System.out.println(" P 1 "+p1+" P2 "+p2);
            // 1 2 3 4 5 6 7 8 9
            while(p1<p2){
            	sum=arr[p2]+arr[p1];
            	System.out.println(" arrp2 "+arr[p2]+" Arr p1 "+arr[p1]+" VAL - "+(arr[p2]-arr[p1])+"...sum"+sum+"...compare....arr[i]:-"+arr[i]);
            	if( sum>arr[i]) {
            		
            			System.out.println(" P2-p1 :"+(p2-p1));
            		count=count+(p2-p1);
            		//break;
            		System.out.println(" Counted "+count);
            		//continue;
            	///break;
            		//}
            		p2--;
            	}
            	else {
            		p1++;
            	}
            	
         
            }
            
        }
        return count;
        //return count;
	}
}

