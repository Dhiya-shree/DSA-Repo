package backtracking_sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BT08_Unique_Subset2 {

	public static void main(String[] args) {
		
		int arr[]={1,1,2,3,4,5,6,7,8,9,1,2,3,4,5};
		Arrays.sort(arr);
		digit=new int[10];
		long start=System.currentTimeMillis();
	//	Subsets(arr,arr.length);
	
	
	
		int n=arr.length;
		
		Subsets(arr,n);
		
		
		long end=System.currentTimeMillis();
		System.out.println(" Time "+(end-start)+"milli secs ");
		
//////////////////////////////
		
ArrayList<Integer> ans = new ArrayList<Integer>();
Arrays.sort(arr);
for(int i=0;i<n;i++) {
ans.add(arr[i]);
}
ArrayList<ArrayList<Integer>> result
=  solve(arr,n);

// print all unique subsets
for (int i = 0; i < result.size(); i++) {
ArrayList<Integer> temp = result.get(i);
for (int j = 0; j < temp.size(); j++) {
System.out.print(temp.get(j) + " ");
}
System.out.println();
}


System.out.println(" anser "+result.toString());
System.out.println(" Time "+(end-start)+"milli secs ");
System.out.println(" Digit "+Arrays.toString(digit));
System.out.println(" Length "+result.size());
		
	}
 
	static int[] digit;
	private static void Subsets(int[] arr, int n) {
		// Consider for only 1 
		Arrays.sort(arr);
		
		ArrayList<ArrayList<Integer>> ansF=new ArrayList<ArrayList<Integer>> ();
		ansF.add(new ArrayList<>());
		Arrays.sort(arr);ptr=0;
	  
		System.out.println(" Permutation ");
		int count=(int) (Math.pow(2,n));
		ansF=GetSubSetList(arr,n,count,ansF);
		Collections.sort(ansF,new ComparLexico());
		System.out.println(" Length "+ansF.size());
		System.out.println(" Answer "+ansF.toString());
		
	//	return ansF;
	}

    private static ArrayList<ArrayList<Integer>> GetSubSetList(int[] ans, int n, int count, ArrayList<ArrayList<Integer>> ansF) {
		
    	ArrayList<Integer> arr=new ArrayList<>();
    	ansF.add(arr);
    	for(int i=1;i<=count;i++) {
    		arr=new ArrayList<>();
    		for(int j=0;j<n;j++) {
    			if((i& (int)Math.pow(2,j))>=1) {
    				arr.add(ans[j]);
    			}
    		}
    		System.out.println(arr.toString());
    	if(!ansF.contains(arr)) {
    		//	digit[arr.get(0)]++;
    		ansF.add(arr);
    		}
    	}
		return ansF ;
	}

	static int ptr;
	
	
	
	 // Function to return all unique subsets
    static ArrayList<ArrayList<Integer>> solve(int arr[],int n)
    {
    	
    	ArrayList<Integer> ans = new ArrayList<Integer>();
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			ans.add(arr[i]);
		}
		
        
        // To store the resulting subsets.
    	ArrayList<ArrayList<Integer>> result
            = new ArrayList<ArrayList<Integer> >();
    	ArrayList<Integer> subset = new ArrayList<Integer>();
   
        // Helper function call
        findSubsets(ans, 0, subset, result);

        
        ArrayList<ArrayList<Integer>> res
            = new ArrayList<ArrayList<Integer> >();
        res.add(new ArrayList<>());
        for (int i = 0; i < result.size(); i++) {
            res.add(new ArrayList<>(result.get(i)));
        }
      
        return res;
    }

	
	
	 // Helper function to find all unique subsets
    static void findSubsets(ArrayList<Integer> v, int idx,
    		ArrayList<Integer> subset,
                            ArrayList<ArrayList<Integer> > result)
    {
        // If the current subset is not empty insert it into
        // the result
        if (!subset.isEmpty()) {
            if (!result.contains(subset)) {
                result.add(new ArrayList<>(subset));
            }
        }

        // Iterate over every element in the array
        for (int j = idx; j < v.size(); j++) {
            // Pick the element and move ahead
            subset.add(v.get(j));
            findSubsets(v, j + 1, subset, result);

            // Backtrack to drop the element
            subset.remove(subset.size() - 1);
        }
    }

   
   
        
   
	
}

class ComparLexico implements Comparator<ArrayList<Integer>>{
	

	@Override
	public int compare(ArrayList<Integer> x, ArrayList<Integer> y) {
		if(x.isEmpty()) {
			return 1;
		}
		else if(y.isEmpty()) {
			return 0;
		}
		else {
			
			      for (int i = 0;
			           i < Math.min(x.size(), y.size()); i++) {
			        if (x.get(i) != y.get(i)) {
			          return x.get(i) - y.get(i);
			        }
			      }
			      return x.size() - y.size();
			    

			
		}
	}
	
}

