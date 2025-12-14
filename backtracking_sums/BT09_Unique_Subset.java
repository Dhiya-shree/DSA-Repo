package backtracking_sums;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BT09_Unique_Subset {

	public static void main(String[] args) {
		// unique subsets 
        int arr[]= {1,1,2,3,4,5,6,7,8,9,1,2,3,4,5};//{2,2,2,4,5,6,6,6,7,8}; //{1,2,4,5,6,6,6,7,8};//1233
        
       digit=new int[10];
        
        long start=System.currentTimeMillis();
        
        ArrayList<ArrayList <Integer>> ANS=AllSubsets(arr,arr.length);
        long end=System.currentTimeMillis();
        System.out.println(" Answer is "+ANS.toString());
        System.out.println(" Correct is"+/* (),(1),(1 2),(1 2 3)\r\n"
        		+ "(1 2 3 3),(1 3),(1 3 3),(2),(2 3)\r\n"
        		+ "(2 3 3),(3),(3 3)");/*/  "(),(1),(1,2),(1,2,2),(2),(2,2) ");
        System.out.println(" Time taken "+(end-start)+" milli seconds ");
        
        System.out.println(" Digitper "+Arrays.toString(digit));
        
        System.out.println(" Length "+ansFinal.size());
	}
	
	
	//static HashMap<Integer,String> hs;static int ptr;
	public static ArrayList<ArrayList <Integer>> AllSubsets(int arr[], int n)
   {
       // your code here
		ansFinal=new ArrayList <ArrayList <Integer>>();
		ansFinal.add(new ArrayList<>());
		Arrays.sort(arr);
       ptr=0;count=(int) Math.pow(2, n)-1;
       System.out.println(" Count "+(count+1));
       
      cc=0;
      
      ArrayList<Integer> ans=new ArrayList<>();
      
      for(int i=0;i<n;i++) {
    	  ans.add(arr[i]);
    
      }
      
      for(int i=0;i<n && !ans.isEmpty();i++) {
    	 
      Permutation(ans,ans.size(),0,ans.size()-1);
      int a=ans.get(0);
      while(!ans.isEmpty() && ans.get(0)==a) {
      ans.remove(0);
      }
      }
      
     System.out.println(" Length "+ansFinal.size());
       return ansFinal;
   }
	 static  int digit[];
	static ArrayList<ArrayList <Integer>> ansFinal;static int ptr;static int count;static HashSet<String> hs;static int cc;static boolean swit;
	private static void Permutation(ArrayList<Integer> ans, int n, int left, int right) {
		// Take permute combo 
		if(left>=right) {
		
			GetSubSet(ans,n);
		}
		else {
			
			if(CanContinue(ans,left,n) ) {
		//	System.out.println(" String "+arr+" left "+left);
			for(int i=left;i<=right && i<n;i++) {
			//	GetSubSet(ans,n);
				
				if(IsSafe(ans,i,left,n) ) {
				ans=swap(ans,i,left);
				Permutation(ans,n,left+1,right);
				ans=swap(ans,left,i);
				 
			
			}

			}
			}
		}
		
	}



	private static boolean CanContinue(ArrayList<Integer> ans, int left,int n) {
		
		if(left>ans.size()-1) {
			return false;
		}
		
		if(ptr<count) {
		return true;
		}
		return false;
	}


	private static boolean IsSafe(ArrayList<Integer> ans, int i, int left,int n) {
		

	   	if(i==left) {
	   		return true;
	   	}
		

		if(i!=left && ans.get(left)>=ans.get(i)) {
			return false;
		}
		
		
		
	//	StringBuffer sb=new StringBuffer();
		for(int j=1;j<left;j++) {
			if(ans.get(j)<ans.get(j-1)) {
				return false;
			}
		}
		

		
		return true;
	}
	private static void GetSubSet(ArrayList<Integer> ans2, int n) {
		// Have permutation so use that 
		//StringBuffer sb=new StringBuffer();
		
		 ArrayList<Integer> ans=new ArrayList<Integer>();

		 // ans.add(arr[0]);
		
		 for(int i=0;i<n;i++) {
		
			 if(i==0) {
				 ans.add(ans2.get(0));
			 }
		 else if(ans2.get(i)>=ans2.get(i-1)) {
				 ans.add(ans2.get(i));
			 }
			 else if(ans2.get(i)<ans2.get(i-1)) {
				 break;
			 }

			 if(!ansFinal.contains(ans)) {
					ptr++;
					digit[ans.get(0)]++;
					 ansFinal.add(new ArrayList<Integer>(ans));
				}
			
			
		 }
		 
		
			System.out.println(ptr+" .... Permute  "+ans2.toString());
			

		
	}
	private static ArrayList<Integer> swap(ArrayList<Integer> ans, int i, int j) {
		// swap
		int sw=ans.get(i);
		ans.set(i,ans.get(j));
		ans.set(j,sw);
		return  ans;
	
	}
	
	
	// Driver code
	  public static void Solve(int arr[],int n )
	  {
		  ArrayList<Integer> A=new ArrayList<>();
		  for(int i=0;i<n;i++) {
			  A.add(arr[i]);
		  }

	    // Function call
	    ArrayList<ArrayList<Integer> > result = solveAB(A);
	    result.sort((x, y) -> {
	      for (int i = 0;
	           i < Math.min(x.size(), y.size()); i++) {
	        if (x.get(i) != y.get(i)) {
	          return x.get(i) - y.get(i);
	        }
	      }
	      return x.size() - y.size();
	    });

	    for (ArrayList<Integer> v : result) {
	      for (int i : v) {
	        System.out.print(i + " ");
	      }
	      System.out.println();
	    }
	  }

		
	
	public static ArrayList<ArrayList<Integer> >
    solveAB(ArrayList<Integer> v)
  {
    
    // To store the resulting subsets
    HashSet<ArrayList<Integer> > res = new HashSet<>();
    ArrayList<Integer> subset = new ArrayList<>();
    ArrayList<ArrayList<Integer> > result = new ArrayList<>();

    // Insert it into the resultant vector
    res.add(subset);

    // Iterate over all elements
    for (int i = 0; i < v.size(); i++) {
      int N = res.size();
      for (ArrayList<Integer> it : res) {
        // Iterate through every subset
        // generated till now and insert
        // the current element in the
        // end of it
        subset = new ArrayList<>(it);
        subset.add(v.get(i));
        result.add(subset);
        N--;
        if (N == 0) {
          break;
        }
      }
      res.addAll(result);
      result.clear();
    }

    return new ArrayList<>(res);
  }

  
	
} 


	
