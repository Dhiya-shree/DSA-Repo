package stack_queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * If only previous element matters -> STACK 
 * 
 * Largest rectangular area in a Histogram 
 * determining the Largest Rectangular Area in a Histogram. 
 * This shape will be comprised of a series of adjacent bars, each with a specified height stored in an array. 
 * To simplify the problem, we will assume that all bars possess the same width, measuring 1 unit.
 *  We will look at both the Naive solution and the Efficient solution (using stack) to solve this problem.
 * 
 * 
 * Naive :
 * For every bar check till the bar values are greater than or equal to currenct bar 	
 * 
 * For: 6 1 4 5 6 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * For bar 6 :
 * On left side consider : None 
 * On right side consider :None 
 * Area  6  
 * 
 * For bar 1:
 * On left side consider : 6 
 * On right side consider : 4 5 6 3 1 1 1 1 1 1 1 1......
 * 
 * Area : 25 
 * 
 * 
 * For bar 4 :
 * On left side consider : None 
 * On right side consider : 5 6 
 * 
 * Bar - 4 - 5 - 6 
 * Value : bar_value(min)*no of bar = 4*3=12 
 * 
 * and so on ....
 * Large area = 25 
 * 
 * Better Solution :
 *  Instead of counting left and right larger elements 
 *  Find left and rightmost smaller elements 
 *  With index of left and right smaller elements 
 *  We can find left and right count and proceed with area 
 *  
 *  Pre calculation :
 *  Array of leftmost smaller element index for every array 
 *  Array of rightmost smaller element index for every array
 * 
 * Steps :
 * 1) Initialize res->0 
 * 2) Find previous smaller element 
 * 3) Find Next smaller element
 * 4) Apply below formula :
 *      area = curr val*(left+right+1)
 * 5) return area 
 *  
 * Two stacks usage and two array and O 3N times 
 * 
 * Efficient Solution :
 * Using single stack  
 *
 *
 * 
 * 
 * 
 * @author shree
 *
 */
public class Stack06_LargeArea_in_Histogram {

	public static void main(String[] args) {
		//Area

		int bar[]={1,1,1,1,1,1,1,1};//{6,12,15,4,1,5,6};;// {6,2,5,4,1,5,6};
		int ans=NaiveLargeArea(bar,bar.length);
		//N 2 
		System.out.println(" Large area "+ans);
		
		ans=BetterLargeArea(bar,bar.length);	// O 3 N 
		System.out.println(" Large area "+ans);
		
		ans=GoGBetterMaxArea(bar,bar.length);	// O 3 N 
		System.out.println(" Large area "+ans);
		
		ans=EfficientGoGMaxArea(bar,bar.length);	// O 2 N 
		System.out.println(" Large area "+ans);
		
		ans=FindTheAreaForEveryPoint(bar,bar.length);	// O 2 N 
		System.out.println(" Large area "+ans);
	}

	private static int FindTheAreaForEveryPoint(int[] arr,int n) {
		//Find the area efficient method 
		// Every time you find a smaller element 
		// pop everying inbetween small1 and small2
		// Final we have only increasing numbers 
		// Pop it based on N value 
		Stack<Integer> s=new Stack<>();
		int inbetween=0;
		int area[]=new int[n];
		int max=0;
		// For left 
		// Element having some smaller in right of them 
		for(int i=0;i<n;i++) {
		//	System.out.println(" Stack left "+s.toString());
			while(!s.isEmpty() && arr[s.peek()]>=arr[i]) {
				inbetween=s.pop();
				// If empty 0 to i
                // Or i(next small-curr i) - s.peek(previous small)-1
				if(s.isEmpty()) {
					area[inbetween]=arr[inbetween]*i;
				}
				else {
				area[inbetween]=arr[inbetween]*(i-s.peek()-1);
				}
				max=Math.max(area[inbetween],max);
			}
			
			s.push(i);
		}
		
		// Elements that dont have smaller 
		while(!s.isEmpty()) {
			inbetween=s.pop();
			 // If empty then 1 st element having no smaller  so N 
            //  If not length - val pos - 1
            // 5 have no deceasing char on right 
            // 5 to end --> ans ----> 10 -5 - 1= 4(Actual 4 element .. with N val is 10)
			if(s.isEmpty()) {
				area[inbetween]=arr[inbetween]*n;
			}
			else {
			area[inbetween]=arr[inbetween]*(n-s.peek()-1);
			}
			max=Math.max(area[inbetween],max);
		}
		
		System.out.println(" Area --> "+Arrays.toString(area));
		return max;
	}
	private static int EfficientGoGMaxArea(int arr[],int n){
        Stack <Integer> s=new Stack<>();
        int res=0;
        int tp;
        int ans[]=new int[n];
        int curr;
        System.out.println(" Array "+Arrays.toString(arr));
        // For next smaller part and currval * left 
        for(int i=0;i<n;i++){
            while(s.isEmpty()==false && arr[s.peek()]>=arr[i]){
                tp=s.peek();s.pop();
                System.out.print(" From "+arr[tp]+"---"+arr[i]+"  ");
                
                // If empty 0 to i
                // Or i(next small-curr i) - s.peek(previous small)-1
                // Here no need to add 1 explicitly as it is included inbetween 
                curr=arr[tp]* (s.isEmpty() ? i : i - s.peek() - 1);
                System.out.print(" AREA:"+curr+" TP len "+arr[tp]+" for tp:"+tp+" With n times as "+(curr/arr[tp]));
                ans[tp]=curr;
                res=Math.max(res,curr);
            }
           
            s.add(i);
            System.out.println("  =====>"+s.toString());
        }
        System.out.println(" Array ans left + value area "+ Arrays.toString(ans));
        System.out.println(" Stack "+s.toString());
        while(s.isEmpty()==false){
            tp=s.peek();s.pop();
            System.out.print(" From "+arr[tp]+"---"+arr[n-1]+"  ");
            // If empty then 1 st element having no smaller  so N 
            //  If not length - val pos - 1
            // 5 have no deceasing char on right 
            // 5 to end --> ans ----> 10 -5 - 1= 4(Actual 4 element .. with N val is 10)
            curr=arr[tp]* (s.isEmpty() ? n : n - s.peek() - 1);
            System.out.println(" AREA:"+curr+" TP len "+arr[tp]+" for tp:"+tp+" With n times as "+(curr/arr[tp]));
            ans[tp]=curr;
            res=Math.max(res,curr);
        }
        System.out.println(" Array ans right + value area "+ Arrays.toString(ans));
        System.out.println(" Stack "+s.toString());
        
        return res;
    
    }
	private static int BetterLargeArea(int[] bar, int n) {
		// Pre calculation 
		/*
		 * *  Instead of counting left and right larger elements 
         *  Find left and rightmost smaller elements 
         *  With index of left and right smaller elements 
         *  We can find left and right count and proceed with area 
         *   Area= currval*(left+right+1)  
		 */
		int left[]=PreviousSmallerElement(bar,n);
		int right[]=NextSmallerElement(bar,n);
		System.out.println(" Bar   "+Arrays.toString(left));
		System.out.println(" Left  "+Arrays.toString(left));
		System.out.println(" Right "+Arrays.toString(right));
		
		int max_area=0;
		int area=1;
		
		for(int i=0;i<n;i++) {
			area=bar[i]*(left[i]+right[i]+1);
			max_area=Math.max(area,max_area);
		}
		
		return max_area;
	}

	private static int[] NextSmallerElement(int[] arr, int n) {
		// Next smaller element
		Stack<Integer> s = new Stack<>();
		int ans[] = new int[n];

		ans[n-1] = 0;
		s.push(n-1);

		for (int i = n-2; i >=0; i--) {

			while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
				s.pop();
			}

			// Careful here -> Customized for right
			if (s.isEmpty()) {
				ans[i] = n-i-1;
			} else {
				ans[i] = s.peek()-i-1;
			}

			s.push(i);

		}

		return ans;
	}

	private static int[] PreviousSmallerElement(int[] arr, int n) {
		// Previous smaller element
		Stack<Integer> s=new Stack<>();
		int ans[]=new int[n];
		
		ans[0]=0;
		s.push(0);
		
		for(int i=1;i<n;i++) {
			
			while(!s.isEmpty() && arr[s.peek()]>arr[i]) {
				s.pop();
			}
			
			// Careful here -> Customized for left
			if(s.isEmpty()) {
				ans[i]=i;
			}
			else {
				ans[i]=i-s.peek()-1;
			}
			
			s.push(i);
			
		}
		
		return ans;
	}

	private static int NaiveLargeArea(int[] bar, int n) {
		//naive 
		
		int left=0;
		int right=0;
		int curr=0;
		int max=1;
		int area=0;
		for(int i=0;i<n;i++) {
			curr=bar[i];
			System.out.print(" Curr:"+curr);
			//Left side counter 
			for(int j=i-1;j>=0;j--) {
				
				if(bar[j]>=curr) {
					left++;
					System.out.print(" "+bar[j]);
				}
				else {
					break;
				}
			}
			
			System.out.print("<--"+curr+"-->");
		//Right side counter 
           for(int j=i+1;j<n;j++) {
				
				if(bar[j]>=curr) {
					System.out.print(bar[j]+" ");
					right++;
				}
				else {
					break;
				}
			}
			
           area=curr*(left+right+1);
           System.out.println(" Area "+area+" Left "+left+" Right"+right);
           max=Math.max(area,max);
           left=0;
           right=0;
           
		}
		return max;
	}
	
	private static int GoGBetterMaxArea(int arr[],int n){
        int res=0;
        int[] ps=new int[n];int[] ns=new int[n];
   
       Stack <Integer> s=new Stack<>();
       s.add(0);
       for(int i=0;i<n;i++){
           while(s.isEmpty()==false && arr[s.peek()]>=arr[i])
               s.pop();
           int pse=s.isEmpty()?-1:s.peek();
           ps[i]=pse;
           s.push(i);
       }
       
       while(s.isEmpty()==false){
           s.pop();
       }
       
       s.push(n-1);
       for(int i=n-1;i>0;i--){
           while(s.isEmpty()==false && arr[s.peek()]>=arr[i])
               s.pop();
           int nse=s.isEmpty()?n:s.peek();
           ns[i]=nse;
           s.add(i);
       }
       
       for(int i=0;i<n;i++){
           int curr=arr[i];
           curr+=(i-ps[i]-1)*arr[i];
           curr+=(ns[i]-i-1)*arr[i];
           res=Math.max(res,curr);
       }
       return res;
   
   }

}

class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        /*
        60 20 50 40 10 50 60 
        60 
        20  (60 ans 60 * 1)
        20 50 
        20 40 ( 50 pop ans 50*1  )
        20 40 10 
        20 10 ( 80 ans 40*2)
        10 ( 80 ans 20*4)
        10 50 
        10 50 60 
        10 50 (60 ans 60 * 1)
        10 ( 100 ans 50* 1+1)
        10 ( 70 ans 10*n smallest )
        */
        
        int n=arr.length;
        Stack<Integer> s=new Stack<Integer>();
        int i=1;
        s.push(0);
        int ans=0;
        while(i<n){
            
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
             //    System.out.println(s.toString()+" "+s.peek());
                int v=s.pop();
                int s1=s.isEmpty()?i:(i-s.peek()-1);
          //      System.out.println(s1+" * "+arr[v]+" = "+(s1*arr[v]));
                ans=Math.max(ans,s1*arr[v]);
            }
            
            s.push(i);
            i++;
            
        }
        
        while(!s.isEmpty()){
          int v=s.pop();
          int s1=s.isEmpty()?n:(i-s.peek()+(n-i-1));
       //   System.out.println(s1+" * "+arr[v]+" = "+(s1*arr[v]));
          ans=Math.max(ans,s1*arr[v]);   
        }
        
        return ans;
        
    }
}

