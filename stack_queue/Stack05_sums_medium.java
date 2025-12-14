package stack_queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Problem #1 : Previous greater element 
 * 
 *  Given an array , find an element greater than current and to left of it 
 * 
 * 
 * Problem #2: Next greater element 
 * 
 *  Given an array , find an element greater than current and to right of it 
 * 
 * 
 * Problem #3 : Get min at pop
 * 
 * 
 * @author shree
 *
 */


public class Stack05_sums_medium {

	public static void main(String[] args) {
		// sums 
		
       int array[]= {100, 80, 60 ,70 ,101, 90 ,85 ,45 ,31 ,99};
		
		
		int ans[]=PreviousGreaterElement(array,array.length);
		System.out.println(" Previous greater element  "+Arrays.toString(ans));
		
		ans=NextGreaterElement(array,array.length);
		System.out.println(" Next greater element  "+Arrays.toString(ans));
		

		Stack<Integer> s=_push(array,array.length);
		_getMinAtPop(s);
	}

	private static int[] NextGreaterElement(int[] arr, int n) {
		// stock span reverse 
		Stack<Integer> s=new Stack<Integer>();
	
		int ans[]=new int[n];
		//last element 0 greater in right 
		ans[n-1]=-1;
		s.push(arr[n-1]);
		for(int i=n-2;i>=0;i--) {
			System.out.println(" S..."+s.toString());
			while(!s.isEmpty() && s.peek()<=arr[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				ans[i]=-1;
			}
			else {
				ans[i]=s.peek();
			}
			s.push(arr[i]);
		}
		return ans;
	}

	private static int[] PreviousGreaterElement(int[] arr, int n) {
		// prebious greater element 
		Stack<Integer> s=new Stack<Integer>();
		int ans[]=new int[n];
		//First element 0 greater in left 
		ans[0]=-1;
		s.push(arr[0]);
		for(int i=1;i<n;i++) {
			
			while(!s.isEmpty() && s.peek()<=arr[i]) {
				s.pop();
			}
			
			if(s.isEmpty()) {
				ans[i]=-1;
			}
			else {
				ans[i]=s.peek();
			}
			
			s.push(arr[i]);
		}
		
		return ans;
	}
	
	 private static Stack<Integer> _push(int arr[],int n)
	    {
	        // your code here
	        Stack<Integer> s=new Stack<>();
	        for(int i=n-1;i>=0;i--){
	            s.push(arr[i]);
	        }
	        return s;
	    }
	    
	    //Function to print minimum value in stack each time while popping.
	 private   static void _getMinAtPop(Stack<Integer>s)
	    {
	        int n=s.size();
	        // your code here
	        if(n==1){
	            System.out.print(s.peek());
	        }
	        int arr[]=new int[n];
	        int min=s.peek();s.pop();
	        int i=n-1;
	        arr[i]=min;
	        i--;
	        int m1=0;
	        while(!s.isEmpty()){
	            m1=s.peek();
	            min=Math.min(m1,min);
	            arr[i]=min;
	            i--;
	            s.pop();
	        }
	        
	        for(int j=0;j<n;j++){
	            System.out.print(arr[j]+" ");
	        }
	        
	        
	        
	    }

}
