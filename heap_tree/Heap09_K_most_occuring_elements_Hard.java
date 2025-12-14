package heap_tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * K Most Occuring elements 
 * 
 * Given an array , lets consider below is the ans of freq-val 
 * {1,1,1,1,2,2,2,3,,4,4,5,,67,/.....}
 *  
 *  Value Freq
 *    1    10
 *    2    10
 *    3     5
 *    4     2
 *    5     1
 *    67    1
 *    
 * If they asked K=1 , 1 most value = 10
 * K=2 , 2 most value = 10+10 = 20 
 * K=3,  3 most value = 10+10+5 = 25
 * K=4 , 4 most value = 10+10+5+2 = 27
 * K=5 , 5 most value = 10+10+5+2+1=28
 * K=6 , 6 most value =  10+10+5+2+1+1= 29 
 * 
 * K will not be 7 , given that K<= distinct element count 
 * 
 * 
 * 
 * 
 * Given an array arr[] of N integers in which elements may be repeating several times. Also, a positive number K is given and the task is to find sum of total frequencies of K most occurring elements

Note: The value of K is guaranteed to be less than or equal to the number of distinct elements in arr.

Example 1:

Input:
N = 8
arr[] = {3,1,4,4,5,2,6,1}
K = 2
Output: 4
Explanation: Since, 4 and 1 are 2 most
occurring elements in the array with
their frequencies as 2, 2. So total
frequency is 2 + 2 = 4.
Example 2:

Input:
N = 8
arr[] = {3,3,3,4,1,1,6,1}
K = 2
Output: 6
Explanation: Since, 3 and 1 are most
occurring elements in the array with
frequencies 3, 3 respectively. So,
total frequency is 6.
Your Task:
Complete the function kMostFrequent() whic returns the frequencies of K most occuring elements.

Constraints:
1 <= N <= 106
1 <= K <= N
1 <= arr[i] <= 106

Expected Time Complexity : O(N log N)
Expected Auxilliary Space: O(N)
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Heap09_K_most_occuring_elements_Hard {

	public static void main(String[] args) {
		// k most 
		int n= 8;
		int arr[] = {3,1,4,4,5,2,6,1};
		int K = 2;
		
		// Naive 
		// O N Log N + N 
		// Space N 
		int ans=KMost_HashMap(arr,K,n);
		System.out.println(" Ans naive "+ans);
		
		
		// Efficient O N Log N +  N+K space 
		// Space O 1 
		ans=KMost_HeapSort(arr,K,n);
		System.out.println(" Ans naive "+ans);
		

	}

	private static int KMost_HeapSort(int[] arr, int k, int n) {
		 // heap sort with no extra space 
        heapSort(arr,n);  // N Log N 
     
   //   System.out.println(Arrays.toString(arr));
       int i=0;int freq=0;int c=0;int check=0;int max=0;
       while(i<n){           //N 
           check=arr[i];
           i++;freq++;
           while(i<n && arr[i]==check){
               freq++;
               i++;
           }
       //    System.out.println(check+" "+freq);
          if(arr[freq-1]>0){
              arr[freq-1]=-1;
             
          }
          else{
             arr[freq-1]=arr[freq-1]-1;
          }
          max=Math.max(max,freq-1);
          freq=0;
       }
   //   System.out.println(Arrays.toString(arr));
   
       for(int j=max;j>=0 && k>0;j--){  
           if(arr[j]<0){
               
               while(arr[j]<0 && k>0){
               c=c+j+1;
               k--;
               arr[j]=arr[j]+1;
               }
           }
       }
       return c;
   }
   
    static void buildHeap(int arr[], int n)
   {
       // Your code here
       for(int i=(n-2/2);i>=0;i--){
           heapify(arr,n,i);
       }
       
   }

   //Heapify function to maintain heap property.
   static void heapify(int arr[], int n, int i)
   {
       // Your code here
       int left=2*i+1;
       int right=2*i+2;
       int large=i;
       if(left<n && arr[left]>arr[large]){
           large=left;
       }
       if(right<n && arr[right]>arr[large]){
           large=right;
       }
       if(i!=large){
           int swap=arr[i];
           arr[i]=arr[large];
           arr[large]=swap;
           heapify(arr,n,large);
       }
       return;
   }
   
   //Function to sort an array using Heap Sort.
   public static void heapSort(int arr[], int n)
   {
       //code here
       buildHeap(arr,n);
     //  System.out.println(Arrays.toString(arr));
       for(int i=n-1;i>=0;i--){
           
           int max=arr[0];
           arr[0]=arr[i];
           arr[i]=max;
       //    System.out.println(max);
           heapify(arr,i,0);
       }
   }

	private static int KMost_HashMap(int[] arr, int k, int n) {
		// hash map
		
		//eate hashmap 
        HashMap<Integer,Integer> mp=new HashMap<>();
        
        // Value - freq pair 
        for(int i=0;i<n;i++){
            
            if(!mp.isEmpty() && mp.containsKey(arr[i])){
                int a=mp.get(arr[i])+1;
                mp.put(arr[i],a);
            }
            else{
                mp.put(arr[i],1);
            }
        }
        
         PriorityQueue<DatawithFreq> q = new PriorityQueue<>();
         // Must to defy comparable 
         Iterator<Entry<Integer, Integer>> itr=mp.entrySet().iterator();
         while(itr.hasNext()) {
        	 Entry<Integer, Integer> e=itr.next();
        	 q.add(new DatawithFreq(e.getKey(),e.getValue()));
         }
         // Must to map in test ide
       //  Iterator<Entry<Integer, Integer>> itr=mp.entrySet().iterator();
     //    for(Map.Entry<Integer, Integer> e : mp.entrySet()) {
        //	 Entry<Integer, Integer> e=itr.next();
    //    	 q.add(new DatawithFreq(e.getKey(),e.getValue()));
      //   }
         
        DatawithFreq curr=null;
//        int s=q.size();
//        for(int i=0;i<s;i++) {
//        	curr=q.poll();
//        	System.out.println(" Data "+curr.data+"-"+curr.freq);
//        }
        
        int ans=0;
        for(int i=0;i<k;i++) {
        	//get value 
        	curr=q.poll();
        	ans=ans+curr.freq;
        }
       
     //  int checkWhyBelowNoWork=0;
      /*  PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>(new Comparator() {

			public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue()-o2.getValue();
			}
        	
        });
        
        for(Map.Entry<Integer,Integer> m: mp.entrySet()) {
        	q.add(m);
        }
        System.out.println(" Q "+q);*/
       return ans;
	}

}

class DatawithFreq implements Comparable<DatawithFreq>{
	int data;
	int freq;
	DatawithFreq(int d,int f){
		data=d;
		freq=f;
	}
	@Override
	public int compareTo(DatawithFreq o) {
		// check eith freq
		
		return o.freq-freq;
	}
	
	
}
