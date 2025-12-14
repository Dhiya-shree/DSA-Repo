package heap_tree;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * Rearrange charactrs 
 * 
 * Given a string S such that it may contain repeated lowercase alphabets. Rearrange the characters in the string such that no two adjacent characters are same.
 

Example 1:

Input:
S = geeksforgeeks
Output: 1
Explanation: egeskerskegof can be one way of
rearranging the letters.

Example 2:

Input:
S = bbbabaaacd
Output: 1
Explanation: abababdcab can be one way of 
rearranging the letters.

Your Task:
You don't need to read input or print anything. Complete the function rearrangeString() which takes string S as input parameter and returns the string after rearrangement.
If the characters are successfully rearranged then the generated output will be 1 else 0.


Expected Time Complexity : O(|S| log |S|)
Expected Auxilliary Space : O(1)


Constraints:
1 <= |S| <= 105
String has only lowercase English alphabets.
 * 
 * 
 * Rearrange characters in a String such that no two adjacent characters are same using Priority Queue
To solve the problem using this approach follow the below idea:

The idea is to put the highest frequency character first (a greedy approach). Use a priority queue (Or Binary Max Heap) and put all characters and ordered by their frequencies (highest frequency character at root). One by one take the highest frequency character from the heap and add it to result. After adding it, just decrease the frequency of the character and then temporarily move this character out of priority queue so that it is not picked again next time.

Follow the given steps to solve the problem:

Build a Priority_queue or max_heap, pq that stores characters with their frequencies. 
Priority_queue or max_heap is built on the bases of the frequency of character. 
Create a temporary Key that will be used as the previously visited element (the previous element in the resultant string. Initialize it { char = '#' , freq = '-1' } 
While pq is not empty. 
Pop an element and add it to the result. 
Decrease the frequency of the popped element by '1' 
Push the previous element back into the priority_queue if its frequency is greater than zero. 
Make the current element as the previous element for the next iteration. 
If the length of the resultant string and the original string is not equal, then print "not possible", else print the resultant string.
 * 
 * 
 * @author shree
 *
 */
class CAC implements Comparable<CAC>{
    int cr;
    int freq;
    CAC(int c,int f){
        cr=c;
        freq=f;
    }
    
    public int compareTo(CAC c){
        return c.freq-freq;
    }
    
}

public class Heap11_Rearrange_Characters {

	public static void main(String[] args) {
		// re arrange char 

		String str="geeksforgeeks";
		
		//O n log N 
		String ans=rearrangeCharacters(str);
		System.out.println(" Ans "+ans);
		
		// O N 
		ans=rearrangeCharactersEfficient(str);
		System.out.println(" Ans "+ans);
	}

	 private static String rearrangeCharactersEfficient(String str) {
		// using array odd and even positions to fill up place 
			int n=str.length();
			int ch[]=new int[26];
			int c=0;int max=0;int maxc=0;
			for(int i=0;i<n;i++){
			    c=str.charAt(i)-97;
			    ch[c]=ch[c]+1;
			    if(ch[c]>max) {
			    	max=ch[c];
			    	maxc=c;
			    }
			}
			System.out.println("max "+max+" N "+n+"cc "+maxc);
	        if(max>((n+1)/2)){
	         //   System.out.println("max "+max);
	            return str;
	        }
	       		
			char ans[]=new char[n];int j=0;
			for(int i=0;i<max;i++) {
				ans[j]=(char)(maxc+97);
				j=j+2;
			}
				System.out.println("ans "+Arrays.toString(ans));
			int val=max;j=1;
		    while(val<n){
		        
		    }
		 
			String aans=String.valueOf(ans);
			return aans;
	}

	//Function to rearrange the characters in a string such that 
    //no two adjacent characters are same.
    static String rearrangeCharacters(String str)
    {
		// Your code here
		//Get min and last of any heap 
		//Custom heap min 
		
		int n=str.length();
		int ch[]=new int[26];
		int c=0;
		for(int i=0;i<n;i++){
		    c=str.charAt(i)-97;
		    ch[c]=ch[c]+1;
		}
		System.out.println(" arr "+Arrays.toString(ch));
		
		PriorityQueue<CAC> pq=new PriorityQueue<>();
		for(int i=0;i<26;i++){
		    
		    if(ch[i]>0){
		       
		    pq.add(new CAC(i,ch[i]));
		     System.out.print(" arr "+i+" ci "+ch[i]+"......");
		    
		    }
		}
		
	    char ans[]=new char[n];
	    int j=0;
		CAC curr=null;CAC next=null;
		while(!pq.isEmpty()){
		    curr=pq.poll();
		    ans[j]=(char)(curr.cr+97);j++;
		    curr.freq=curr.freq-1;
		    System.out.println(" curr "+ans[j-1]+" "+curr.freq);
		    //set second 
		    if(curr.freq==0){
		        continue;
		    }
		    else if(pq.isEmpty()==true && curr.freq>0){
		        return "NO";
		    }
		    else if(pq.isEmpty()==false && pq.peek().freq>curr.freq){
		        pq.add(curr);
		    }
		    else if(pq.isEmpty()==false){
		        next=pq.poll();
		        ans[j]=(char)(next.cr+97);j++;
		        next.freq=next.freq-1;
		        pq.add(curr);
		        if(next.freq>0){
		            pq.add(next);
		            System.out.println(" next "+ans[j-1]+" "+next.freq);
		        }
		    }
		}
		
		String aans=String.valueOf(ans);
		return aans;
	}
}
