package searchSortCode;

/**
 *  Ternary Search 
 *  Time Complexity: O(Log3N), where N is the number of elements in the array.
 *  
 *  Ternary Search is a Divide and Conquer Algorithm used to perform search operation in a sorted array.
 *   This algorithm is similar to the Binary Search algorithm but rather than dividing the array into two parts,
 *    it divides the array into three equal parts.
 *  In this algorithm, the given array is divided into three parts and the key (element to be searched) is compared 
 *  to find the part in which it lies and that part is further divided into three parts.
 *  We can divide the array into three parts by taking mid1 and mid2 which can be calculated as shown below. 
 *  Initially, l and r will be equal to 0 and N-1 respectively, where N is the length of the array.
 *  
 *  mid1 = l + (r-l)/3
 *  mid2 = r – (r-l)/3
 * 
 * 
 * Note: The array must be sorted in order to perform the Binary Search or Ternary Search operation.
 * 
 * 
 * Steps to perform Ternary Search:
 * First, we compare the key with the element at mid1. If found equal, we return mid1.
 * If not, then we compare the key with the element at mid2. If found equal, we return mid2.
 * If not, then we check whether the key is less than the element at mid1. If yes, then recur to the first part.
 * If not, then we check whether the key is greater than the element at mid2. If yes, then recur to the third part.
 * If not, then we recur to the second (middle) part.
 * 
 * 
 * @author shree
 *
 */
public class Search02 {

	public static void main(String[] args) {
		
		int sorted[]= {1,2,3,4,5,6,7,8,9,10,11,12,12,13,14,15};
		int element=0;
		int n=sorted.length-1;// Imp to avoid index out of bound 
		int ans=TernarySearchIterative(sorted,n,element);
		System.out.println(" ans "+ans);
		
		ans=TernarySearchRecursion(sorted,0,n,element);
		System.out.println(" ans "+ans);
	}

	private static int TernarySearchRecursion(int[] sorted, int low, int high, int element) {
		//Recursion 
		
		if(low>high) {
			return -1;
		}
		int mid1=low+(high-low)/3;
		int mid2=high-(high-low)/3;
		int ans=0;
		int mide=sorted[mid1];
		int mide2=sorted[mid2];
		System.out.println(" Mid + mide ");
		if(mide==element) {
			return mid1;
		}
		if(mide2==element) {
			return mid2;
		}
		
		if(element<mide) {
			high=mid1-1;
			ans=TernarySearchRecursion(sorted,low,high,element);
			//return ans;
		}
		else if(element >mide2) {
			low=mid2+1;
			ans=TernarySearchRecursion(sorted,low,high,element);
			//return ans;
		}
		else {
			low=mid1+1;
			high=mid2-1;
			ans=TernarySearchRecursion(sorted,low,high,element);
			//return ans;
		}
		return ans;
	}

	private static int TernarySearchIterative(int[] sorted, int n, int element) {
		// log 3 time 
		
		int mid1=0;int mid2=0;
		int mide1=0;int mide2=0;//int mide=0;
		int low=0;
		int high=n;
		//int mid=0;
		while(low<=high) {
			mid1=low + (high - low) / 3;
			mid2= high -(high-low)/3;
			mide1=(sorted[mid1]);
			mide2=(sorted[mid2]);
			if(mide2==element) {
				return mid2;
			}
			if(mide1==element) {
				return mid1;
			}
			if(element<mide1) {
				high=mid1-1;
				//low=0;
			}
			else if(element<mide2 && element>mide1) {
				low=mid1+1;
				high=mid2-1;
			}
			else {
				low=mid2+1;
				//high=n-1;
			}
			System.out.println(" MId no "+mid1+" md ele "+mide1 +" Low no "+low+" High no "+high);
			//System.out.println(" MId no "+mid2+" md ele "+mide2 +" Low no "+low+" High no "+high);
		}
		
		return -1;
	}
}
