package matrix_MultiArray;

import java.util.Arrays;

import arrayCode.ArrayPart01;

public class MedianInRowSorted {

	public static void main(String[] args) {
		
		int matrix[][] = {{1, 2, 3, 4},
				{9, 11, 12,13},
				{21,22,34,45},
		         {5, 6, 7, 8},
		         { 14, 15,16,17}};
		
		int n=matrix.length;
		int m=matrix[0].length;
		
		
		 // For only array with non duplicate values 
	    int median_ans=FindMedianInRowSortedArray(matrix,n,m);
	    System.out.println(" median is "+median_ans);
	    
	    median_ans=FindMedianInRowSortedGoG(matrix,n,m);
	    System.out.println(" median is "+median_ans);
	
	
	}
	
	static int FindMedianInRowSortedGoG(int m[][],int r, int c)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<r ; i++)
        {
            
            // Finding the minimum element
            if(m[i][0] < min)
                min = m[i][0];
            
            // Finding the maximum element
            if(m[i][c-1] > max)
                max = m[i][c-1];
        }
        
        int desired = (r * c + 1) / 2;
        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            
            // Find count of elements smaller than mid
            for(int i = 0; i < r; ++i)
            {
                
                get = Arrays.binarySearch(m[i],mid);
                
                // If element is not found in the array the 
                // binarySearch() method returns 
                // (-(insertion_point) - 1). So once we know 
                // the insertion point we can find elements
                // Smaller than the searched element by the 
                // following calculation
                if(get < 0)
                    get = Math.abs(get) - 1;
                
                // If element is found in the array it returns 
                // the index(any index in case of duplicate). So we go to last
                // index of element which will give  the number of 
                // elements smaller than the number including 
                // the searched element.
                else
                {
                    while(get < m[i].length && m[i][get] == mid)
                        get += 1;
                }
                
                place = place + get;
            }
            
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }
    
    // Driver Program to test above method.
	
	 private static int FindMedianInRowSortedArray(int[][] matrix, int n,int m) {
		// Given row sorted array 
		 // n --> ROW 
		 // m --> COL
		 int min=Integer.MAX_VALUE;int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			min=Math.min(matrix[i][0],min);
			max=Math.max(matrix[i][m-1],max);
		}
		
		int mid=0;//(min+max)/2;
		int mid_pos=0;
		int curr_mid_pos=0;
		int median_pos=(n*m+1)/2;
		
		//int left=min;int right=max;
		while(min<max) {
			mid=(min+max)/2;
			mid_pos=0;
			//int r=0;
			for(int i=0;i<n;i++) {
				//Check if the middle pos is in array 
				// Or return the pos where middle element is supposed to be 
				
				// For a sorted row - user binary search 
				// Check if middle present in row elements 
				// If not present pos= length of row 
				// If present at pos 0 = return 0 
				// If present at pos 2 = return 2
				// If it shoul be present between pos 2 and 3 = 3
				//index of the search key, if it is contained in the array;otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the
				//key would be inserted into the array: the index of the firstelement greater than the key, or a.length if allelements in the array are less than the specified key. Notethat this guarantees that the return value will be >= 0 ifand only if the key is found.
				
				// if else is not present at a , it will give n as ans , so adding 1
				System.out.println(" Current mid is "+mid+" left "+min+" right "+max);
				System.out.println(" search for array :");
				ArrayPart01.PrintRayy(matrix[i]);
				curr_mid_pos=Arrays.binarySearch(matrix[i],mid)+1;
				
				// ADD all pos to mid pos 
				System.out.println(" Found curr pos "+curr_mid_pos);
				mid_pos=mid_pos+Math.abs(curr_mid_pos);
				
				System.out.println(" Found mid_pos:"+mid_pos);
			}
			
			
			System.out.println(" Final mid pos "+mid_pos+" Median pos"+median_pos);
			if(mid_pos<median_pos) {
				min=mid+1;
			}
			else {
				// we dont stop at mid 
				// we keep on search including mid 
				
				max=mid;
			}
		}
		
		return min;
	}
}

/**
Median of a Row Wise Sorted Matrix

We are given a row-wise sorted matrix of size r*c, we need to find the median of the matrix given. It is assumed that r*c is always odd.
Examples: 
 

Input : 1 3 5
        2 6 9
        3 6 9
Output : Median is 5
If we put all the values in a sorted 
array A[] = 1 2 3 3 5 6 6 9 9)

Input: 1 3 4
       2 5 6
       7 8 9
Output: Median is 5
 

Simple Method: The simplest method to solve this problem is to store all the elements of the given matrix in an array of size r*c. Then we can either sort the array and find the median element in O(r*clog(r*c)) or we can use the approach discussed here to find the median in O(r*c). Auxiliary space required will be O(r*c) in both cases.
An efficient approach for this problem is to use a binary search algorithm. The idea is that for a number to be median there should be exactly (n/2) numbers that are less than this number. So, we try to find the count of numbers less than all the numbers. Below is the step by step algorithm for this approach: 
Algorithm:  

First, we find the minimum and maximum elements in the matrix. The minimum element can be easily found by comparing the first element of each row, and similarly, the maximum element can be found by comparing the last element of each row.
Then we use binary search on our range of numbers from minimum to maximum, we find the mid of the min and max and get a count of numbers less than or equal to our mid. And accordingly change the min or max.
For a number to be median, there should be (r*c)/2 numbers smaller than that number. So for every number, we get the count of numbers less than that by using upper_bound() in each row of the matrix, if it is less than the required count, the median must be greater than the selected number, else the median must be less than or equal to the selected number.
Below is the implementation of the above approach:

 


// Java program to find median of a matrix
// sorted row wise
import java.util.Arrays;

public class MedianInRowSorted 
{
    // function to find median in the matrix
    static int binaryMedian(int m[][],int r, int c)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<r ; i++)
        {
            
            // Finding the minimum element
            if(m[i][0] < min)
                min = m[i][0];
            
            // Finding the maximum element
            if(m[i][c-1] > max)
                max = m[i][c-1];
        }
        
        int desired = (r * c + 1) / 2;
        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            
            // Find count of elements smaller than mid
            for(int i = 0; i < r; ++i)
            {
                
                get = Arrays.binarySearch(m[i],mid);
                
                // If element is not found in the array the 
                // binarySearch() method returns 
                // (-(insertion_point) - 1). So once we know 
                // the insertion point we can find elements
                // Smaller than the searched element by the 
                // following calculation
                if(get < 0)
                    get = Math.abs(get) - 1;
                
                // If element is found in the array it returns 
                // the index(any index in case of duplicate). So we go to last
                // index of element which will give  the number of 
                // elements smaller than the number including 
                // the searched element.
                else
                {
                    while(get < m[i].length && m[i][get] == mid)
                        get += 1;
                }
                
                place = place + get;
            }
            
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }
    
    // Driver Program to test above method.
    public static void main(String[] args) 
    {
        int r = 3, c = 3;
        int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };
        
        System.out.println("Median is " + binaryMedian(m, r, c));
    }
}

// This code is contributed by Sumit Ghosh

 


Output
Median is 5

Time Complexity: O(32 * r * log(c)). The upper bound function will take log(c) time and is performed for each row. And since the numbers will be max of 32 bit, so binary search of numbers from min to max will be performed in at most 32 ( log2(2^32) = 32 ) operations. 
Auxiliary Space: O(1) 


*/