package impAlgorithm_array_search;

/**
 * Various method on higher time complexity :
 * https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 * 
 * For O(log N )
 * Floyd’s Tortoise and Hare Algorithm (Cycle Detection Algorithm)
 * 
 * Use the function f(x) = arr[x] to construct the sequence:
 * arr[0], arr[arr[0]], arr[arr[arr[0]]], arr[arr[arr[arr[0]]]] ……. 
 * 
 * 
 * Each new element in the sequence is an element in arr[] at the index of the previous element.
 * Starting from x = arr[0], it will produce a linked list with a cycle.
 * The cycle appears because arr[] contains duplicate elements(at least one). The duplicate value is an entrance to the cycle. 
 *
 * For Example: Let the array arr[] = {2, 6, 4, 1, 3, 1, 5} 
 
index	0	1	2	3	4	5	6
arr	2	6	4	1	3	1	5
Starting from index 0, the traversal looks as follows: 

arr[0] = 2 –> arr[2] = 4 –> arr[4] = 3 –> arr[3] = 1 –> arr[1] = 6 –> arr[6] = 5 –> arr[5] = 1. 
 
 *
 * 
 * Algorithm consists of two parts and uses two pointers, usually called tortoise and hare.
 *  hare = arr[arr[hare]] is twice as fast as tortoise = arr[tortoise].
 * Since the hare goes fast, it would be the first one who enters the cycle and starts to run around the cycle.
 * At some point, the tortoise enters the cycle as well, and since it’s moving slower the hare catches the tortoise up at some intersection point
 * 
 * Note that the intersection point is not the cycle entrance in the general case, but the two intersect at somewhere middle in cycle.
 * Move tortoise to the starting point of sequence and hare remains within cycle and both move with the same speed i.e. tortoise = arr[tortoise] and hare = arr[hare]. Now they intersect at duplicate element.
 * 
 * 
 * 
 * 
 * @author shree
 * 
 *
 */
public class Floyd_Turtle_Hare_Algo_Cycle_detection_Repeating_elements_logN {

	public static void main(String[] args) {
		
		Long[] arr= {(long) 1,(long) 2,(long) 3};
		int arr1[]= {1,1,2,3,4,5,6,7,7,8,9};
		int n=arr.length;
		int ans=0;
		ans= FindOneRepeatingElementGOG(arr1,arr1.length);
		System.out.println("Repeating element is "+ans);
		
		ans=FindTheFrequencyOf1(arr,n);
		System.out.println(" Frequency "+ans);
		
		ans=twoRepeated(arr1,arr1.length);
		System.out.println(" Finding two repeated in O n "+ans);
		
	}

	private static class Pair{
         long x;
         long y;
         
         Pair(long x, long y){
             this.x = x;
             this.y = y;
         }

		
     }
	 
	private static int FindTheFrequencyOf1(Long[] arr, int n) {
		// tortoise and hare
	
		int tor=(arr[0].intValue());
		int hare=arr[0].intValue();
		int prev;
		int count=0;
		//int last=arr[n-1].intValue();
		//int is=0;
		int il=0;
		while(true) {
			prev=tor;
			tor=arr[tor].intValue();
			System.out.println(" Hare "+hare);
			il=(arr[hare].intValue());
			hare=arr[il].intValue();
			if(tor==hare) {
				break;
			}
			if(tor>n-1||hare>n-1) {
				Pair p=new Pair(-1,-1);
				return (int) p.y;
			}
		}
		
		tor=arr[0].intValue();
		while(tor!=hare) {
			prev=tor;
			tor=arr[(int) tor].intValue();;
		}
		 
		System.out.println(" REpeating element is "+tor+" pOs "+prev);
		while(prev<n && arr[(int) prev]==tor) {
			count++;
			prev++;
			System.out.println(" Arr prev count "+count);	
		}
		Pair p=new Pair(tor,count);
		System.out.println(" REpeated "+count+" pelen"+p.x);
		return (int) p.y;
	}

	private static int FindOneRepeatingElementGOG(int[] arr, int n) {
		// Initialize variables
	    int tortoise = arr[0];
	    int hare = arr[0];
	 
	    // Loop till we find the
	    // duplicate element
	    while (true)
	    {
	        tortoise = arr[tortoise];
	         
	        // Hare moves with twice
	        // the speed of tortoise
	        hare = arr[arr[hare]];
	        if (tortoise == hare)
	            break;
	    }
	     
	    tortoise = arr[0];
	 
	    // Loop to get start point
	    // of the cycle as start
	   
	    // point will be the duplicate
	    // element
	    while (tortoise != hare)
	    {
	        tortoise = arr[tortoise];
	        hare = arr[hare];
	    }
		return hare;
	}
	
	private static int twoRepeated(int arr[], int N)
    {
        // Your code here
        int ans[]=new int[2];
        int order=0;
        int n=N+2;
        int pos=0;
        for(int i=0;i<n;i++){
            pos=Math.abs(arr[i]);
            if(arr[pos]<0){
                ans[order]=Math.abs(pos);
                order=1;
            }
            else{
                arr[pos]=arr[pos]*-1;
            }
        }
        return ans[0];
    }
}
