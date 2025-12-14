package searchSortCode;

import java.util.ArrayList;

/**
 * Problem #1: Peak Element 
 * 
 * In this problem, we are given an array of unsorted integers . Our task is to find a peak element in the array. 
 * A peak element is an element whose neighbors have value smaller than that of the element. 
 * 
 * Naive Approach:
 * The idea is to traverse the array and return the element that has higher value than its neighbors.
 * Steps:
 * If the element at index 0 is greater than the element at index 1, return arr[0].
 * If the element at index n-1 is greater than the element at index n-2, return arr[n-1].
 * If none of the above cases prevail, we traverse the remaining elements and check for a peak element.  
 * 
 * Find a peak element using iterative Binary search
 * The interesting fact about using Binary search in this unsorted array problem
 *  is that if the element to the left of the mid element is greater, 
 *  then a peak will definitely be present in the left part of the array.
 *   Similarly if the element to the right of mid is greater ,
 *   then a peak would be present in the right of the array. 
 *   We will be using this logic to solve our problem.
 *   
 *   Steps :============) 
 *   We calculate the mid as (low+high)/2 where low is the lower bound and high is the upper bound of the array.
 *   We run a loop while low is lesser than or equal to high.
 *   We check the condition : 
 *         If the mid is 0 or arr [mid-1] is smaller than arr[mid ] and
 *         if mid is n-1 and arr[mid+1] i smaller than arr[mid], we return mid.
 *   If mid is greater than 0 and arr[mid-1] is greater than arr[mid] , we update high to mid-1.
 *   If both the conditions do not prevail, we update low to mid+1.
 *   
 *   Time Complexity: O(log N), Where n is the number of elements in the input array.
 *   Auxiliary Space: O(1), No extra space is required, so the space complexity is constant.
 *   
 * Problem #2: Two pointer method
 * 
 * n this particular problem, we are provided with a sorted array of integers. 
 * Our objective is to determine whether there exists a pair of integers in the array that adds 
 * up to a given target value. Initially, we will explore a naive solution with a time complexity of O(n^2), 
 * followed by an optimized approach utilizing the Two Pointer method. 
 * 
 * Two pointer method :
 * 
 * Pointer 1 - i=0
 * Pointer 2 j=n-1 
 * 
 * Steps : In an sorted array ,we have val = xx 
 * while (i<j):
 *    -> Add sum=arr[i]+arr[j]
 *         if(sum==val)=> return
 *         if(sum>val) => j=+1
 *         else => i=i+1
 * 
 * 
 * Problem #3 : Roof Top
 *  You are given heights of consecutive buildings. 
 *  You can move from the roof of a building to the roof of next adjacent building. 
 *  You need to find the maximum number of
 *   consecutive steps you can put forward such that you gain an increase in altitude with each step
 *   
 *   
 * Problem #5 : Triplet in a sorted array
 * 
 * In this particular problem, we are provided with a sorted array of integers. 
 * Our objective is to determine whether there
 *  exists a triplet of integers in the array whose sum is equal to the target value given.
 * @author shree
 *
 */
public class Search05 {

	public static void main(String[] args) {
		
		int arr[]={108 ,366 ,997 ,656 ,248 ,607 ,150 ,698 ,351 ,84 ,3 ,404, 239 ,851 ,56 ,893 ,206 ,22 ,836 ,192 ,912,
				496 ,489 ,440 ,984 ,324 ,337 ,758 ,359 ,727 ,303 ,466 ,92 ,651 ,121 ,691 ,609 ,623 ,389 ,959 ,58 ,391 ,362 ,296 ,
				241};
		
		//{564, 832 ,265 ,123 ,750 ,771 ,150 ,82 ,708 ,295 ,23 ,718 ,316 ,116 ,918 ,682 ,194 ,18 ,248 ,769 ,206 ,827 ,156 ,
			//	948 ,365 ,192 ,633 ,885 ,57 ,462 ,879 ,972 ,646 ,143 ,446 ,395 ,266 ,596 ,828 ,973 ,890 ,203};
		//{9 ,14, 10, 10, 1 ,2 ,1 ,7 ,10, 10, 14, 19, 9};// {1,13};//{0,1,2,11,9,5,6,7,8,6};
		int n=arr.length;
		int ans=FindThePeakElement(arr,n);
		
		System.out.println(" Peak element "+arr[ans]);
		
        ans=FindThePeakElementGoG(arr,n);
		
		System.out.println(" Peak element "+arr[ans]);
		
		int val=23;
		int arr2[]= {1,2,3,4,5,7,8,9,11,12,13,15,30,40,50,100};
		ans=TwoPointerMethod(arr2,val);
		System.out.println(" Two pointr ans "+ans);
		
		int arr3[]={4,6,1,5,6};// {5,7};
		ans=maxStep(arr3);
	    System.out.println(" Roof top  "+ans);	
	    
	    int arr4[]= {1,2,3,4};//{1,2,3,7,5};
	    	//{135 ,101 ,170 ,125 ,79 ,159 ,163 ,65 ,106 ,146 ,82 ,28 ,162 ,92 ,196 ,143 ,28 ,37 ,192 ,5 ,103 ,
	    		//154 ,93 ,183 ,22 ,117 ,119 ,96 ,48 ,127 ,172 ,139 ,70 ,113 ,68 ,100 ,36 ,95 ,104 ,12 ,123, 134};
	    ArrayList<Integer> Array1= new ArrayList<>(2);
	    Array1=subarraySum(arr4,0);
	    System.out.println(" Ans is "+Array1.get(0)+" to "+Array1.get(1));
	    
	    
	  //If given unsorted array - sort it first !!!!! //O log n + O n2 
	    ans=FindTheTriipletPairWithSum(arr,val);// O n2
		System.out.println(" It is present  "+ans);
	}

	private static int FindTheTriipletPairWithSum(int[] arr, int val) {
		// For every element use two pointer pair sum method 
		int n=arr.length;
		int ans=0;
		//For two pinter 
		int start =0;
		int end=n-1;
		int new_val=0;
		int new_sum=0;
		
		for(int i=0;i<n-2;i++) {
			
			new_val=val-arr[i];
			//Now need to find this new val s sum of any two number in remaining array
			start=i+1;
			while(start<end) {
				new_sum=arr[start]+arr[end];
				if(new_sum==new_val) {
					System.out.println(" Pair prsenet ");
					ans=1;
					return ans;
				}
				if(new_sum<new_val) {
					
					start=start+1;
				}
				else {
					end=end-1;
				}
			}
	
		}
		return 0;
	}
	
	 private static ArrayList<Integer> subarraySum(int[] arr, int val) 
	    {
		 
		    int n=arr.length;
		    int start=0;
		    int end=1;
		    int sum=arr[0];
		    if(arr[0]==val) {
		    	   ArrayList<Integer> Array3= new ArrayList<>(1);
				    Array3.add(-1);
				    return Array3;
		    }
		    if(val==0) {
		    	for(int i=0;i<n;i++) {
		    		if(arr[i]==0) {
		    			ArrayList<Integer> Array1= new ArrayList<>(2);
				    	 Array1.add(i+1);
						    Array1.add(i+1);
		    		}
		    	}
		    	 ArrayList<Integer> Array3= new ArrayList<>(1);
				    Array3.add(-1);
				    return Array3;
		    }
		 //  System.out.println(" N s "+n+" ..."+arr[n]);
		    while(start<=n && end<=n){
		    	 System.out.println(" Sum "+sum +" Val "+val+ " Srat "+start+" end "+end);
		    		if(sum==val ) {
		    		System.out.println(" Hey ");
		    		break;
		    	}
		    	if(sum>val) {
		    		
		    		if(start<n) {
		    			sum=sum-arr[start];
		    		start=start+1;
		    		}
		    		else {
		    			System.out.println(" In start else br ......");
		    			break;

		    		}
		    	}
		    	
		    	else {
		    		
		    		if(end<n) {
		    			sum=sum+arr[end];
		    		end=end+1;}
		    	else  {
		    		System.out.println(" In end else br ......");
		    		break;
	    		}
		    }
		    	System.out.println(" In enduu else br //////////////");
		    }
		//   System.out.println(arr[start]+"......"+arr[end]);
		    System.out.println(" Sum "+sum +" Val "+val+ " Srat "+start+" end "+end);
		    if(sum!=val) {
		        ArrayList<Integer> Array2= new ArrayList<>(1);
		    Array2.add(-1);
		    return Array2;
		  }
		    ArrayList<Integer> Array1= new ArrayList<>(2);
		    	 Array1.add(start+1);
				    Array1.add(end);
		    
			return Array1;
	        // Your code here
	    }
	private static int maxStep(int A[])
    {
        // Your code here
		System.out.println(" Callonsj");
        int count=0;int maxi=0;
        int n=A.length-1;
        if(n==0){
        	System.out.println(" N is 1");
            return 0;
        }
        
        if(n==1) {
        	if(A[0]<A[1]) {
        		return 1 ;
        	}
        	else {
        		return 0;
        	}
        }
        for(int i=0;i<n;i++){
        	//System.out.println(" A 1"+A[i]+"  A 2 "+A[i+1]);
            if(A[i]<A[i+1]){
                count=count+1;
                System.out.println(" A 1 ------------- ");
                
            }
            else{
            	System.out.println(" A 2 ////////////// ");
                count=0;
            }
            System.out.println(" Count "+count+" MAXi "+maxi);
            maxi=Math.max(maxi,count);
        }
        return maxi;
    }
	private static int TwoPointerMethod(int[] arr2, int val) {
		// Find the pair whose sum = val
		int n=arr2.length;
		int i=0;
		int j=n-1;
		int sum=0;
		while(i<j) {
			sum=arr2[i]+arr2[j];
			if(sum==val) {
				System.out.println(" Pair found "+arr2[i]+" and "+arr2[j]+"  is sum "+sum);
				//To find one pair add return statement 
				//return 1000;
			}
			if(sum<val) {
				System.out.println(" Remove i "+arr2[i]);
				i=i+1;
			}
			else {
				System.out.println(" Remove j "+arr2[j]);
				j=j-1;
			}
		}
		return 0;
	}

	private static int FindThePeakElementGoG(int[] arr, int n) {
		int left=0;
		int right=n-1;
		//int mid=(left+right)/2;
		// Easy cases 
		if(n==1) {
			return arr[0];
		}
		else if(n>1) {
			if(arr[0]>=arr[1]) {
				return 0;
			}
			if(arr[n-1]>=arr[n-2]) {
				return (n-1);
			}
		}
		// Easy case ends 
		while(left<=right) {
			int midu=(left+right)/2;
			System.out.println(" Midu "+midu +" midu ele"+arr[midu]+ " left "+left+" ele "+arr[left]+" rght "+right+" ele r "+arr[right]);
			
			if( (midu==0 || arr[midu-1]<=arr[midu])&&( midu==n-1 && arr[midu+1]<=arr[midu])) {
				return midu;
			}
			else if(midu>0 && arr[midu+1]<arr[midu]) {
				right=midu-1;
			}
			else {
				left=midu+1;
			}
//			if(left>n-1 && right<0) {
//				break;
//			}
		}
		return 0;
		//return 0;
	}

	private static int FindThePeakElement(int[] arr, int n) {
		// TODO Auto-generated method stub
		
		int left=0;
		int right=n-1;
		//int mid=(left+right)/2;
		if(n==1) {
			return arr[0];
		}
		else if(n>1) {
			if(arr[0]>=arr[1]) {
				return 0;
			}
			if(arr[n-1]>=arr[n-2]) {
				return (n-1);
			}
		}
		while(left<=right) {
			int midu=(left+right)/2;
			System.out.println(" Midu "+midu +" midu ele"+arr[midu]+ " left "+left+" ele "+arr[left]+" rght "+right+" ele r "+arr[right]);
			if(Math.abs(right-left)==1) {
				return ((arr[right]>=arr[left])?right:left);
			}
//			if(Math.abs(midu-left)==1) {
//				return ((arr[midu]>=arr[left])?midu:left);
//			}
			if (midu==0) {
				left=1;
				System.out.println(" In needed ");
			    return((arr[midu]>=arr[left])?(midu):(left));
			}
			if(midu==n-1) {
				right=n-2;
			    return (((arr[midu]>=arr[right])?midu:(right)));
			}
			if( (midu>0 && midu<n-1 && arr[midu-1]<=arr[midu]) && (arr[midu+1]<=arr[midu])) {
				return midu;
			}
			if(midu>0 && midu<n-1  && arr[midu-1]>=arr[midu]) {
				right=midu-1;
			}
			else {
				left=midu+1;
			}
//			if(left>n-1 && right<0) {
//				break;
//			}
		}
		return 0;
	}
}
