package arrayCode;


/*
 * 
 * Problem #1:Maximum Difference Problem with Order
 *     Given an array arr[] of integers, find out the maximum difference between any two elements such that the larger element appears after the smaller number. 
 *     Max a[j]>a[i] such that j>i
 *     
 * Problem #2:Rearrange Array Alternately  [ O 1 space makes you cry :( [Important !!!!!!!!!]) ]
 *     Given a sorted array of positive integers. Your task is to rearrange the array elements alternatively i.e 
 *     first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.
 *     
 * Problem #3: Frequencies in a Sorted Array 
 *         Find how many times a number is present 
 *         The idea is to maintain a variable to keep track of the frequency of elements while traversing the array. Follow the steps below to solve the problem:
 *         Initialize a variable, say freq as 1 to store the frequency of elements.
 *         Iterate in the range [1, N-1] using the variable i and perform the following steps:
 *         If the value of arr[i] is equal to arr[i-1], increment freq by 1.
 *         Else print value the frequency of arr[i-1] obtained in freq and then update freq to 1.
 *         Finally, after the above step, print the frequency of the last distinct element of the array as freq.
 *         
 *         
 * Problem #4 : Smallest Positive missing number [ O 1 space makes you cry again :((( :( [Important !!!!!!!!!]) ]
 *    You are given an array arr[] of N integers. The task is to find the smallest positive number missing from the array.
 *    Note: Positive number starts from 1.
 *    
 *    --------------------------------------------------------------------------------------------
 *    Approach 1:  Using encoding and decoding to use O 1 space  encode : max+i Decode: arr%max
 *    1st loop :
 *        1) Find the max element and increment by 1
 *                   max=max+1
 *        2) Make all elements less than zero as 0 
 *    2nd loop: To sort of sort the array
 *       1) For arr value greater than 0 
 *              1)Use modulo max to get some index -> arr[i]%max - 1( -1 used so as to match element 1 to n to index 0 to n-1) ( % max to decode )
 *              2) Encode the value as arr[index]= arr[index]+ max; ( Encoding the value so as too make arr[arr[i]] as max and pre-existing value must remain 
 *              Ex: For arr : -1,0,1,2,3,5 :  Arr --> max+1,max+2,max+3,0,max+5
 *    3rd loop:
 *       1) For arr[i]<max 
 *            Print ans - i+1
 *            
 *   No ans found then ans= n+1
 *   ------------------------------------------------------------------------------
 *    Approach 2: Using negation instead of decoding and encoding 
 *    1st loop :
 *        1) Find all element > n and <1 and make it to some constant c >n --> used to eliminate all below 1 and above range elements 
 *                   if arr[i]<1 or arr[i]>n --> arr[i]= 100000008
 *    2nd loop: Rearrange remaining 
 *       1) For arr value =Math.abs(arr[i)   ( we negate value to mark presence so to retrieve actual value doing this )
 *             arr[arr[i]-1] = arr[arr[i]-1]*-1;
 *             Place with negative value mean -> the element present 
 *             Ex : -9 11 20 1 2 3
 *        will be  -11 -20 -1 2 3 - values are present for 1,2,3 thus arr[1 , 2 and 3] has negative values of themselves 
 *             
 *    3rd loop:
 *       1) For arr[i]>0 
 *            Print ans - i+1   for given example - 1st greater than 0 at 3 : Ans 4       
 *   No ans found then ans= n+1
 *   
 *   ------------------------------------------------------------------------------
 *    Approach 3: Cyclic sort 
 *    Iterate through the array arr using a for loop 
 *    1st Loop:
 *        1) While the current element arr[i] is positive and within the range of 1 to size, 
 *               and it is not already in its correct position (arr[arr[i] - 1] != arr[i]):
 *                          2) Swap the elements arr[i] and arr[arr[i] - 1]. 
 *          (This step moves the current element to its correct position by swapping it with the element at its expected position.)
 *    2nd Loop :
 *         1)Iterate through the array arr once more using a for loop.
 *         For each element arr[i], check if it matches its expected value i + 1.
 *       If it doesn't match, it means i + 1 is missing in the array. In this case, we return i + 1 as the missing number.
 *       
 *    If no missing number is found, it means all the numbers from 1 to size are present in the array.
 *    In this case, we return size + 1 as the next expected number.
 *    
 *    
 * Problem #5 :Frequencies of Limited Range Array Elements
 *    Given an array A[] of N positive integers which can contain integers from 1 to P 
 *    where elements can be repeated or can be absent from the array. 
 *    Your task is to count the frequency of all elements from 1 to N.Note: 
 *    The elements greater than N in the array can be ignored for counting and do modify the array in-place.
 *    
 *    Approach 1:
 *    1) Loop 1 Traverse the array from start to end.
 *       1) For each element check if the element is less than or equal to zero or not.
 *             ---- If negative or zero skip the element as it is the frequency and
 *             ---- If the element is greater than N or P then also, because no need to calculate its frequency according to question states.
 *       2) If an element (e = array[i] – 1 ) is positive, then check if array[e] is positive or not. 
 *             ----If positive then that means it is the first occurrence of e in the array and
 *                   -> replaces array[i] with array[e], i.earray[i] = array[e] and assign array[e] = -1. 
 *             ----If array[e] is negative, then it is not the first occurrence, 
 *                   ->the update array[e] as array[e]– and update array[i] as array[i] = 0.
 *       
 *    2) Loop 2 Again traverse the array and 
 *             1) check if element is negative that means
 *                       it is frequency so make them positive 
 *             2)else if element is already positive that means is it skipped element(i.e it is greater than P or N) 
 *                       so make them zero because no need to calculate the frequency of these elements.
 *      
 *        
 * 
 *    
 */
public class ArrayPart05 {

	public static void main(String[] args) {
		// Two pointer saga continues ;)
		
          MaximumDifferenceProblemWithOrder();
          // O n O 1 space 
          MaximumDifferenceProblemWithOrderGoG();
          //O n and O 1 clean code 
          RearrangeArrayAlternatively();
          
          RearrangeONspace();
          
          FrequencyOfArraySorted();
          
          FrequencyOfLimitedArrayElements();
          // O 3N O 1 
          FrequencyOfLimitedArrayElementsGoG();
          //O 2N O 1
          
          int arr[]= {0,-10,-1,-3,-20,1} ;//{1,2,3,4,5};//{0,-10,1,3,-20} ; //{0,1};{4,3,-1,1};//
  		  int n=arr.length;
          FindSmallestMissingPositiveNumber(arr,n);
          int arr1[]= {4,3,-1,1};//{0,-10,1,3,-20} ;//{1,2,3,4,5};//{0,-10,1,3,-20} ; //{0,1};
  		  int n1=arr.length;
          FindSmallestMissingPositiveNumberOnGoG(arr1,n1);
          
          int ans =findMissingNumberGoGEfficient3(arr);
          System.out.println(" ANs "+ans);
          findMissingNumberSmallCyclicSortGoG(arr,n);
          }

	
	private static void FrequencyOfLimitedArrayElementsGoG() {
		// Geeks for geeks O 2N solution
		int arr[]= {1, 1, 1, 1, 1,2,3,-45 };//{0,1,1,1,-22,3,3,4,4,5,5,5,6,6,6,6,7,7,7,8,9,2007};//{95059,40000, 8028 ,13268 ,5319 ,16207 ,2326, 29718, 28555 ,11739 ,14825 ,28180 ,5203, 811 ,29,968, 9866 ,2024, 23043, 6569 ,10641, 26410, 
		//1012, 7930 ,24930, 18016, 20772, 13239, 19970 ,26509, 19122, 23384, 19165, 7710, 29110 ,213};// {0,1,1,1,-22,3,3,4,4,5,5,5,6,6,6,6,7,7,7,8,9,2007};
        int N=arr.length;
        int P=1;
		int i = 0;
		System.out.println(" Before a while ....");
		ArrayPart01.PrintRayy(arr);
        while (i<N)
        {
            // If this element is already processed,
            // then nothing to do
            if (arr[i] <= 0 || arr[i]>N || arr[i]>P)
            {
                i++;
                continue;
            }
     
            // Find index corresponding to this element
            // For example, index for 5 is 4
            int elementIndex = arr[i]-1;
     
            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't lose anything.
            if (arr[elementIndex] > 0)
            {
                arr[i] = arr[elementIndex];
     
                // After storing arr[elementIndex], change it
                // to store initial count of 'arr[i]'
                arr[elementIndex] = -1;
            }
            else
            {
                // If this is NOT first occurrence of arr[i],
                // then decrement its count.
                arr[elementIndex]--;
     
                // And initialize arr[i] as 0 means the element
                // 'i+1' is not seen so far
                arr[i] = 0;
                i++;
            }
        }
        System.out.println(" After a while ....");
        ArrayPart01.PrintRayy(arr);
        for(int i1=0;i1<N;i1++) {
            if(arr[i1] < 0) arr[i1] = -arr[i1];
            else arr[i1]=0;
        }
        System.out.println(" Answer ....");
        ArrayPart01.PrintRayy(arr);
		
	}


	private static void FrequencyOfLimitedArrayElements() {
		//Give the frequency of elements 
		int arr[]= {1, 1, 1, 1, 1,2,3,-45 };//{0,1,1,1,-22,3,3,4,4,5,5,5,6,6,6,6,7,7,7,8,9,2007};//{95059,40000, 8028 ,13268 ,5319 ,16207 ,2326, 29718, 28555 ,11739 ,14825 ,28180 ,5203, 811 ,29,968, 9866 ,2024, 23043, 6569 ,10641, 26410, 
				//1012, 7930 ,24930, 18016, 20772, 13239, 19970 ,26509, 19122, 23384, 19165, 7710, 29110 ,213};// {0,1,1,1,-22,3,3,4,4,5,5,5,6,6,6,6,7,7,7,8,9,2007};
		int n=arr.length;
		int P=1;
		int codeu=40001;
		int temp=0;
		//int temp2=0;
		ArrayPart01.PrintRayy(arr);
		if(P>n) {
			P=n;
		}
		for(int i=0;i<n;i++) {
			if(arr[i]>P || arr[i]<0 ) {
				arr[i]=0;
			}
			else {
				System.out.println(" ARR i "+arr[i]+ " I "+i + "codeu "+codeu+" Arr codeu "+codeu);
				arr[i]=arr[i]*codeu;
				System.out.println(" ARR i "+arr[i]+ " I "+i);
			}
		}
		ArrayPart01.PrintRayy(arr);
		for(int i=0;i<n;i++) {
			temp=arr[i]/codeu;
			if(temp>0 && temp<=P) {
			System.out.println(" ARR i "+arr[i]+ " I "+i + "codeu "+codeu+" Arr arr tem "+arr[temp-1]+" temp "+temp);
			arr[temp-1]=arr[temp-1]+1;
			System.out.println(" ARR i "+arr[i]+ " I "+i + "codeu "+codeu+" Arr arr tem "+arr[temp-1]+" temp "+temp);
			}
			
		}
		ArrayPart01.PrintRayy(arr);
		for(int i=0;i<n;i++) {
			arr[i]=arr[i]%codeu;
		}
		ArrayPart01.PrintRayy(arr);
		int m=40001;
		int ab=((40000)*m)+5;
		System.out.println(ab+" "+(ab/m)+" "+(ab%m));
	}


	private static void findMissingNumberSmallCyclicSortGoG(int arr[], int n) {
        for(int i=0;i<n;i++){
            while(arr[i]>0 && arr[i]<=n && arr[arr[i]-1]!=arr[i] ){
                arr=swapArrayElements(arr, arr[i]-1, i);
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1) {
            	System.out.println(" Ans true  "+(i+1));
                break;
            }
        }
        System.out.println(" Ans laast "+(n+1));
 
	}


	private static int findMissingNumberGoGEfficient3(int[] arr) {
        int n = arr.length;
       int max = Integer.MAX_VALUE;
        if (n == 1 && arr[0] == 0)
            return 1; // Handle special case when array has only one element and it is 0

        // Modify the array to handle negative numbers and out-of-range values
        for (int i = 0; i < n; i++) {
            if (arr[i] < 1 || arr[i] > n)
                arr[i] = max;
        }
        ArrayPart01.PrintRayy(arr);
        // Mark the presence of each number by negating the value at its corresponding index
        for (int i = 0; i < n; i++) {
            int a = Math.abs(arr[i]);
            if (arr[i] != max)
                arr[a - 1] = -1 * Math.abs(arr[a - 1]); // just for visual
        }
        ArrayPart01.PrintRayy(arr);
        // Find the missing number based on the presence or absence of positive values
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                return i + 1;
        }

        return n + 1; // If no missing number found, return next expected number
    }
	private static void FindSmallestMissingPositiveNumberOnGoG(int[] arr1, int n1) {
		// geeks for geeks solution 
		int mx=Integer.MAX_VALUE;
		System.out.println(" n1"+n1+" Arr len "+ arr1.length);
		n1=arr1.length;
        for(int i=0;i<n1;i++) {
            if(arr1[i]<=0) {
                arr1[i]=0;}
            mx=Math.max(mx,arr1[i]);
        }
        mx=mx+1;
        for(int i=0;i<n1;i++) {
            if(arr1[i]>0) {
                int ind=arr1[i]%mx-1;
                if(ind<n1 && ind>=0) arr1[ind]+=mx;
            }
        }
        for(int i=0;i<n1;i++)
            if(arr1[i]<mx)
                System.out.println(" Ans "+( i+1));
	    System.out.println("Ans "+ (n1+1));
		
	}

	private static void FindSmallestMissingPositiveNumber(int[] arr, int n) {
		// Smallest Positive missing number
		int maxu=Integer.MAX_VALUE;
		//int minu=Integer.MAX_VALUE;
		//int arr[]= {4,3,-1,1};//{0,-10,1,3,-20} ;//{1,2,3,4,5};//{0,-10,1,3,-20} ; //{0,1};
		//int n=arr.length;
		int min=maxu;int max=n;
		//int sec_min=0;
		System.out.println(" Min "+min+" Maxu "+max);
		ArrayPart01.PrintRayy(arr);
		int temp=0;
		max=max+1;
		if(n==1){
	           if(arr[0]==1){
	               System.out.println(2);
	               
	           }
	           else{
	               System.out.println(1);
	           }
	       }
		for(int i=0;i<n;i++) {
			temp=arr[i]%max-1;
			if(temp<n && temp>=0 && arr[i]>0) {
				//ArrayPart5.swapArrayElements(arr,i,temp);
				System.out.println(" Arr i"+ temp+1+" Arr arr i "+ arr[temp]+" I "+i );
				arr[temp]=max+arr[temp];
			}
		}
		if(min<1) {
			System.out.println("One "+1);
		}
		temp=0;
		for(int i=0;i<n;i++) {
			if(arr[i]<max) {
				temp=i+1;
				break;
			}
		}
		if(temp==0) {
			temp=n+1;
		}
		
		System.out.println("Ans "+temp);
		ArrayPart01.PrintRayy(arr);
	}

	private static void FrequencyOfArraySorted() {
		// Frequencies in a Sorted Array 
		int[] arr= {1,1,1,2,2,3};
		int n=arr.length;
		int freq[][]=new int[n][2];
		int temp=1;
		int pointer=0;
		for(int i=1;i<n;i++) {
			if(arr[i]==arr[i-1]) {
				temp++;
				freq[pointer][0]=arr[i];
				freq[pointer][1]=temp;
				
			}
			else {
				pointer++;
				temp=1;
				freq[pointer][0]=arr[i];
				freq[pointer][1]=temp;
				
				//i++;
			}
		}
		ArrayPart01.PrintRayy2D(freq,n,2);
		
	}

	private static void RearrangeONspace() {
		// rearrange the array elements alternatively - O n space
		long arr[]= {1,2,3,4,5,6,7,8,9};
		int n=arr.length;
		ArrayPart01.PrintRayy(arr);
		long arr2[]=arr.clone();
        int start=0;
        int end=n-1;
        for(int i=0;i<n;i++){
        	if(i%2==0) {
            arr[i]=arr2[end];
            end--;
            //i=i+1;
        	}
        	else {
            arr[i]=arr2[start];
            start++;
        	}
             //System.out.println("Ans "+arr[i]+" start "+start);
            }
        ArrayPart01.PrintRayy(arr);
        ArrayPart01.PrintRayy(arr2);
	}

	private static void RearrangeArrayAlternatively() {
		// rearrange the array elements alternatively
		// 1 2 3 4 5 6 7 8 9 --> 9 1 8 2 7 3 6 4 5
		// 0 1 2 3 4 5 6 7 8 --> 8 0 7 1 6 2 5 3 4
		//                       0 1 2 3 4 5 6 7 8  
		/*
		 * 
		 * Key concept :-

# how to store 2 values at a single position ?
# Higher values are at even position and lower values are at odd {indexing from zero} .

Explaination

let maxi = maximum_value of the array +1 =19+1=20 { +1 is done so that modulo never become zero }. below image explains how we can store 2 values at a single place . 
We will have 2 loops one for manipulation of value at odd position and another for the manipulation of the value at  even position.
Formula used:- arr[i]=arr[i]+(arr[j]%maxi)*maxi;
i->even/ odd index
j->the index of the value which will be present finally in output array.{for manipulation part , see in my code} 
attaching a image below for proper understanding .{numbers on the array depict the order of the swap of numbers.}

 Check : D:\Codde explan and Algo\Exp images gog
		 */
		long arr[]= {1,2,3,4,5,6,7,8,9};
		int n=arr.length;
		ArrayPart01.PrintRayy(arr);
		//int temp=0;
		int i,end_j;
	       int maxi=(int) (arr[n-1]+1);
	       end_j=n-1;
	       for(i=0;i<n;i+=2)
	       {
	           arr[i]=arr[i]+(arr[end_j]%maxi)*maxi;
	           end_j--;
	       }
	       end_j=0;
	       for(i=1;i<n;i+=2)
	       {
	           arr[i]=arr[i]+(arr[end_j]%maxi)*maxi;
	           end_j++;
	       }
	       //Decode
	       for(i=0;i<n;i++)
	       {
	           arr[i]/=maxi;
	       }
			//ArrayPart1.PrintRayy(arr);
		
		ArrayPart01.PrintRayy(arr);
	}

	private static int[] swapArrayElements(int[] arr, int i, int end) {
		// swap i and end 
		int temp=arr[i];
		arr[i]=arr[end];
		arr[end]=temp;
		return arr;
	}

	private static void MaximumDifferenceProblemWithOrderGoG() {
		// Max a[j]>a[i] such that j>i
				int arr[]= {10,20,30};
				int n=arr.length;
				int min=arr[0];
				int ans=arr[1]-arr[0];
				ArrayPart01.PrintRayy(arr);
		        for(int i=1;i<n;i++) {
					ans=Math.max(ans,arr[i]-min);
					min=Math.min(arr[i],min);
					}
		     System.out.println("ans "+ ans +" min "+min);
	}

	private static void MaximumDifferenceProblemWithOrder() {
		// Max a[j]>a[i] such that j>i
		int arr[]= {10,20,30};
		int n=arr.length;
		//Avoid y
		arr=swapArrayElements(arr,0,1);
		int max_left=arr[n-1];
		int min_right=arr[0];
		int mid=Math.floorDiv(n,2);
		ArrayPart01.PrintRayy(arr);
        System.out.println("Mid is "+mid);
		for(int i=1,j=n-2;i<mid;i++,j--) {
			if(min_right<arr[i]) {
				arr[i]=min_right;
			}
			else {
				min_right=arr[i];
				}
			if(max_left>arr[j]) {
				arr[j]=max_left;
			}
			else {
				max_left=arr[j];
				}	
		}
		ArrayPart01.PrintRayy(arr);
		int ans=max_left-min_right;
		System.out.println("Ans "+ans +" Max right "+ max_left + " MIn left "+ min_right);
		
		if((n-1)%2==0) {
			mid=arr[mid];
			int a=max_left-mid;
			int b=mid-min_right;
			System.out.println(" A "+a+" B "+b +" Ans "+ans);
			ans=Math.max(Math.max(a, b),ans);
			
		}
		System.out.println("Ans "+ans);
		
	}

}
