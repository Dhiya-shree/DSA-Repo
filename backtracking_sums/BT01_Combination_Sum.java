package backtracking_sums;

import java.util.ArrayList;
import java.util.Collections;

public class BT01_Combination_Sum {

	public static void main(String[] args) {
		// Combination sum 
       
        int sum=12;
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(8);
        arr.add(1);
        arr.add(8);
        arr.add(6);
        arr.add(8);
       // arr.add(16);
     //   arr.add(22);
        
        combinationSum(arr,sum);
        System.out.println(" Ans "+ans);
        
	}
	
	//Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // is safe condts 
        // 1 - number greater than sum avoided 
        
        ans = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        //REmove duplicates 
        /*
         5
8 1 8 6 8
12        
         */
        //With duplicates wrong answer 
        System.out.println(" A "+A.toString() +" B "+B);
        int n=A.size();
        
        for(int i=n-1;i>0;i--) {
        	while(A.get(i)==A.get(i-1)) {
        		A.remove(i);
        		i=i-1;
        	}
        }
        
        System.out.println(" A  without duplicate "+A.toString());
         n=A.size();
        
        stop=0;
        //pointer 
         pointer=0;
        // sort to find the place to stop 
        for(int i=0;i<n;i++){
            if(A.get(i)>B){
               stop=i;
            }
        }
        if(stop==0 && A.get(0)<B) {
        	stop=n;
        }
        System.out.println(" Stop "+stop);
        Recursion(A,B,0,0,new ArrayList<Integer>());
        return ans;
        
    }
    
    static int pointer;
    static void Recursion(ArrayList<Integer> arr,int sum,int curr,int start,
    ArrayList<Integer> val){
        // start used t reove duplicates 
    	
    	System.out.println(" Curr "+curr+" val "+val.toString());
        if(curr==sum){
        	System.out.println(" Added above Val ..................");
             AddinAnswer(val,val.size());
        }
        else{
        	 System.out.println(" In for loop ");
            for(int i=start;i<stop;i++){
               
            if(isSafe(curr,sum,arr.get(i))){
            	System.out.println(" Curr "+curr+" val "+val.toString());
                curr=curr+arr.get(i);
                val.add(arr.get(i));
                Recursion(arr,sum,curr,start,val);
                curr=curr-arr.get(i);
                start=start+1;
                val.remove(arr.get(i));
                System.out.println(" Curr "+curr+" val "+val.toString());
            }
            
        }
        
    }
    
    }
    
    private static void AddinAnswer(ArrayList<Integer> val, int size) {
		// to create ans 
    	ans.add(new ArrayList<>());
    	for(int i=0;i<size;i++) {
    		ans.get(pointer).add(val.get(i));
    	}
    	pointer++;
		
	}

	static int stop;
    static ArrayList<ArrayList<Integer>> ans;
    
    
    static boolean isSafe(int curr,int sum,int a){
        if(curr+a>sum){
            return false;
        }
        return true;
    }

}
