package heap_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 * Median in stream :
 * 
 * For input 1 , 20 ,3 ,4,5,6,7,8,9,20,......
 * 
 * Method 1: Array
 * Sort the values in hand 
 * Find median 
 * 
 * Method 2 : Binary Serach tree 
 * 2.1:
 * Prepare the BST 
 * Find the kth smallest item 
 * where K=N/2
 * 
 * 2.2:
 * Prepare augumented BST with count of left nodes 
 * use the count to find median 
 * 
 * Method 3: Heap 
 * 3.1 :
 * Create a min heap and max heap 
 * A-> min heap 
 * B -> Max heap 
 * 
 * For value , 1,2,4,7,9....
 * 
 * Put value in max heap 
 * Put top value from in max heap in min heap 
 * 
 * if min heap > max heap size
 *    put max heap top value to min heap 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Heap13_Median_in_stream {

	public static void main(String[] args) {
		
	  
	}
	
	
	  public ArrayList<Double> getMedian(int[] arr) {
	        // code here
	        ArrayList<Double> ans=new ArrayList<Double>();
	        int n=arr.length;
	        PriorityQueue<Integer> min=new  PriorityQueue<Integer>();// 6 7 8 
	        PriorityQueue<Integer> max=new  PriorityQueue<Integer>(Collections.reverseOrder());
	        // 1  2 3   3 2 1 
	        
	        for(int i=0;i<n;i++){
	            
	            if(min.isEmpty() && max.isEmpty()){
	                ans.add((double)arr[i]);
	                min.add(arr[i]);
	                continue;
	            }
	            else if(max.isEmpty()){
	                if(min.peek()<arr[i]){
	                    max.add(min.poll());min.add(arr[i]);
	                }
	                else{
	                    max.add(arr[i]);
	                }
	            }
	            else{
	                int mi=min.peek();
	                int ma=max.peek();
	                if(arr[i]<ma){
	                    max.add(arr[i]);
	                }
	                else{
	                    min.add(arr[i]);
	                }
	                
	                
	                if(min.size()-max.size()>1){
	                    max.add(min.poll());
	                }
	                
	                if(max.size()-min.size()>1){
	                    min.add(max.poll());
	                }
	                
	            }
	         //   System.out.println(min+"-"+max);
	            if(min.size()>max.size()){
	                ans.add((double)min.peek());
	            }
	            else if(max.size()>min.size()){
	                ans.add((double)max.peek());
	            }
	            else{
	                ans.add((double)(min.peek()+max.peek())/2);
	            }
	            
	            
	        }
	        return ans;
	    }
	
	 static  PriorityQueue<Integer> high_min=new PriorityQueue<Integer>();
	    static PriorityQueue<Integer> less_max=new PriorityQueue<Integer>(Collections.reverseOrder());
	       
	    //Function to insert heap.
	    private static void insertHeap(int x)
	    {
	        if(less_max.isEmpty() && high_min.isEmpty()){
	            less_max.add(x);
	            return;
	        }
	        if(!less_max.isEmpty() && high_min.isEmpty()){
	            if(x>=less_max.peek()){
	                high_min.add(x);
	            }
	            else{
	            less_max.add(x);
	            balanceHeaps();
	            }
	        }
	        else if(less_max.size()==high_min.size()){
	          if(x<=high_min.peek()){
	              less_max.add(x);
	          }
	          else{
	              high_min.add(x);
	              balanceHeaps();
	          }
	         }
	         
	         else if(less_max.size()>high_min.size()){
	         if(x>=less_max.peek()){
	             high_min.add(x);
	         }
	         else{
	             less_max.add(x);
	              balanceHeaps();
	         }
	        
	         }  
	        
	    }
	    
	    //Function to balance heaps.
	    private static void balanceHeaps()
	    {
	       
	     if(less_max.size()>high_min.size()){
	           int val=less_max.poll();
	           high_min.add(val);
	     }
	     else if(less_max.size()<high_min.size()){
	          int val=high_min.poll();
	           less_max.add(val);
	     }
	    }
	    
	    //Function to return Median.
	    private static double getMedian()
	    {
	        // add your code here
	        
	        double ans=0;
	        if(less_max.size()==high_min.size()){
	             ans=(less_max.peek()+high_min.peek())/2;
	        }
	      /*  else if(less_max.size()>high_min.size()){
	        ans=less_max.peek();
	        }
	        else if(less_max.size()<high_min.size()){
	            ans=high_min.peek();
	        }*/
	        else{
	            ans=less_max.peek();
	        }
	        return ans;
	    }
	    
}
/**
 * 
 * Median of a Stream

Given that integers are read from a data stream. Find median of elements read so for in an efficient way. For simplicity assume, there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 ... 
 

After reading 1st element of stream - 5 -> median - 5
After reading 2nd element of stream - 5, 15 -> median - 10
After reading 3rd element of stream - 5, 15, 1 -> median - 5
After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...

Making it clear, when the input size is odd, we take the middle element of sorted data. If the input size is even, we pick the average of the middle two elements in the sorted stream.
Note that output is the effective median of integers read from the stream so far. Such an algorithm is called an online algorithm. Any algorithm that can guarantee the output of i-elements after processing i-th element, is said to be online algorithm. Let us discuss three solutions to the above problem

Method : Using Heaps
We can use a max heap on the left side to represent elements that are less than effective median, and a min-heap on the right side to represent elements that are greater than effective median.

After processing an incoming element, the number of elements in heaps differs utmost by 1 element. When both heaps contain the same number of elements, we pick the average of heaps root data as effective median. When the heaps are not balanced, we select effective median from the root of the heap containing more elements.

Given below is the implementation of the above method. For the algorithm to build these heaps, please read the highlighted code.




// Java code to implement the approach

import java.io.*;
import java.util.*;

class GFG {

	// Function to find the median of stream of data
	public static void streamMed(int A[], int N)
	{
		// Declaring two min heap
		PriorityQueue<Double> g = new PriorityQueue<>();
		PriorityQueue<Double> s = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			
			// Negation for treating it as max heap
			s.add(-1.0 * A[i]);
			g.add(-1.0 * s.poll());
			if (g.size() > s.size())
				s.add(-1.0 * g.poll());
		
			if (g.size() != s.size())
				System.out.println(-1.0 * s.peek());
			else
				System.out.println((g.peek() - s.peek())
								/ 2);
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		int A[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		int N = A.length;
		
		// Function call
		streamMed(A, N);
	}
}
 

Output

5
10
5
4
3
4
5
6
7
6.5
7
6.5
Time Complexity: If we omit the way how stream was read, complexity of median finding is O(N log N), as we need to read the stream, and due to heap insertions/deletions.

Auxiliary Space: O(N)
At first glance the above code may look complex. If you read the code carefully, it is simple
 * 
 * 
 */

