package arrayCode;


/**
 * Problem #1: Max consecutive even and odd number 
 * Length of the longest alternating even odd subarray by Storing the previous element
 * By simply storing the nature of the previous element we encounter( odd or even) and comparing it with the next element.
 *  Follow the steps below to solve the problem:
 *		Initialize a variable maxLength to 0, to keep the track of maximum length of the alternating subarray obtained.
 *		Initialize a variable currLen to 1 considering first element as the part of alternating subarray.
 *		Starting with element at index 1, compare every element with it’s previous. If there nature are different, increment the currLen variable.
 *		Otherwise, reset the currLen to 1 again so that, this current element is considered in new alternating subarray.
 *		Keep storing the max length of subarray in maxLength before resetting the currLen.
 *		Return the found max length of subarray.
 *
 *----------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Problem #2: Max sub array sum in circular array   -------------------- Make you ;) 8 mark sum 
 *  kadane algo + for circular Max(Normal kadane val, Total add+ circular Kadane[Kadane after negating all elements ]}
 * Given a circular array of size n, find the maximum subarray sum of the non-empty subarray.
 * 
 * =( Will not work 
 * Reason - considering elements two times giving wrong values 
 * Approach 1: O 2n-1
 *   1. Run loop till 2(n-1)+1 , if i >n-1 , take modulo value . If not greater take as it is 
 *   2. By above we have converted n array to 2n array with extra space using arithmetic modulo 
 *   3. Find kadane max sub array sum 
 *   
 *   
 * Only solution :|
 * Approach 2: O 3n
 *   1.Find kadane max array - NormalMaxi 
 *   2. Find total sum of all element is arr - Totalmax
 *   3. Find min sum subarray by negating all element and using kadane 
 *   4. CircularMaxArray= Totalmax + Min sum Subarray   
 *      Total --> all positive and negative 
 *      Min Sum Subarray --> Maximum negative ( that is together and can be removed )
 *      Crcular max= All posi + All neg + removable neg
 *   5. Ans-> max of NormalMaxi and CircularMaxArray
 *   
 * --------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #3: Minimum adjacent difference in a circular array
 * 
 * Given an array Arr of n integers arranged in a circular fashion. Your task is to find the minimum absolute difference between adjacent elements.
 * Pre calculate min - > 0 and n--1 
 * Calculate other and return lowest number 
 * 
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #4 : Wave Array 
 * 
 * Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
 * In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
 * If there are multiple solutions, find the lexicographically smallest one.
 * 
 * Note:The given array is sorted in ascending order, and you don't need to return anything to make changes in the original array itself.
 * 
 * -------------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Problem #5:Majority Element
 * 
 * Our Task: Find the majority element in the array. 
 * A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element). 
 * What is a majority element?
 * A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element). 
 * 
 * Approach 1: Moore’s Voting Algorithm:->
 * This is a two-step process:
 * 1.The first step gives the element that may be the majority element in the array.
 * If there is a majority element in an array, then this step will definitely return majority element, otherwise, it will return candidate for majority element.
 * 
 * 2.Check if the element obtained from the above step is the majority element. 
 * This step is necessary as there might be no majority element. 
 * Time Complexity: O(n), As two traversal of the array, is needed, so the time complexity is linear.
 * Auxiliary Space: O(1), As no extra space is required.
 * 
 * 
 * 
 * @author shree
 *
 */
public class ArrayPart07 {
   public static void main(String[] args) {
	
	   int arr[]= {1,2,3,4,5,6,0,3,4,6,6,7,8,9,0,1,2,3,4};
	   int ans=MaxConsecutiveEvenAndOdd(arr);
	   System.out.println(" Max conse odd even  "+ans);
	   ans=MaxConsecutiveEvenAndOddGoG_Kadane(arr);
	   System.out.println(" Max conse odd even  "+ans);
	  //----------------------------------------------Max sub array sum in circular array ----------------------------
	   
	   int arrcircular[]={ 8, -8, 9, -9, 10, -11, 12};// {20, 28, 2, 6 ,18, 12, -28, 3, -3, -26, 1, 6 ,6 ,-27, -6, -7, 28, -26, 13, 30, -5, -6};// {5,-3,-3,4,5};
	   ans=MaxSubArraySumInCircularArray(arrcircular);
	   System.out.println(" Max sub array circular array  "+ans);
	   ans=MaxSubArraySumInCircularArrayGoG(arrcircular);
	   System.out.println(" Max sub array circular array  gog..... "+ans);
	   
	 //---------------------------------------------------Minimum Absolute diff in circular array --------------------------------
	   
	   ans=MinimumAbsoluteDiffInCircularArray(arrcircular);
	   System.out.println(" Minimum absolute difference "+ans);
	   
	 //------------------------------------------------------------------Wave Array ----------------------------------------------
	   
	   int wave[]= {1,2,3,4,5,6,7,8,9,10};
	   ArrayPart01.PrintRayy(wave);
	   wave=ChnageToWaveArray(wave);
	   System.out.println(" After wave ...");
	   ArrayPart01.PrintRayy(wave);
	   
	 //-----------------------------------------------------------------Majority element ---------------------------------------------
	   
	   int major[]={3, 3, 4, 2, 4, 4, 2, 4, 4};
	   ans=MajorityElement(major);
	   System.out.println(" majority element "+ans);
	   ans=MajorityElementMooreVotingAlgo(major);
	   System.out.println(" majority element "+ans);
   }
   
   
   private static int MajorityElementMooreVotingAlgo(int[] major) {
	//Use moore voting algo 
	   int count=0;
	   int element_index=0;
	   int element=major[0];
	   int n=major.length;
	   
	   ////////////////////////Check for major element present 
	   for(int i=1;i<n;i++) {
		   if(major[i]==element) {
			   count++;
		   }
		   else {
			   count--;
		   }
		   
		   if(count<1) {
			   element=major[i];
			   element_index=i;
			   count=1;
		   }
	   }
	   System.out.println(" Major member can be "+element+" at index "+element_index+ " with final count "+count);
	   
	   
	   /////////////////////////////////////// Confirm if that is major element 
	   count=0;
	   for(int i=0;i<n;i++) {
		   if(major[i]==element) {
			   count++;
		   }
		   if(count>(n/2)) {
			   return element;
		   }
	   }
	   
	return -1;
}


private static int MajorityElement(int[] major) {
	// find majority element with start  index 
	   int element =major[0];
	   int index=0;
	   int count=1;
	   int n=major.length;
	   for(int i=1;i<n;i++) {
		   if(major[i]==element) {
			   count++;
		   }
		   else {
			   count--;
			   if(count==0) {
				   element=major[i];
				   index=i;
				   count=1;
			   }
	   }
	   }
	   System.out.println(" Major member can be "+element+" at index "+index+ " with final count "+count);
	   count=0;
	   for(int i=0;i<n;i++) { 
		   if(major[i]==element) {
			   count++;
		   }
		   if(count>n/2) {
			   return element;
		   }
	   }
	return -1;
}


private static int[] ChnageToWaveArray(int[] wave) {
	// Create wave by rearranging numbers -> increase and decrease 
	   int n=wave.length;
	   int temp=0;
	   if(n%2!=0) {
		   n=n-2;
	   }
	   for(int i=0;i<n;i=i+2) {
		   temp=wave[i];
		   wave[i]=wave[i+1];
		   wave[i+1]=temp;
		  // i++;
	   }
	return wave;
}


private static int MinimumAbsoluteDiffInCircularArray(int[] arrcircular) {
	// Min absolute difference in circular array wrt to adjacent elements 
	   int n=arrcircular.length;
	   int min=Math.abs((arrcircular[0]-arrcircular[n-1]));
	   int currmin=0;
	   for(int i=0;i<n-1;i++) {
		   currmin=Math.abs(arrcircular[i]-arrcircular[i+1]);
		   if(currmin<min) {
			   min=currmin;
		   }
	   }
	return min;
}


private static int normalMaxSum(int[] arr) {
	   //Normal kadane max sum problem 
	   int n=arr.length;
     int res = arr[0];

	int maxEnding = arr[0];

	for(int i = 1; i < n; i++)
	{
		maxEnding = Math.max(maxEnding + arr[i], arr[i]);

		res = Math.max(maxEnding, res);
	}
	
	return res;
}

static int MaxSubArraySumInCircularArrayGoG(int arr[])
{
	int n=arr.length;
	int max_normal = normalMaxSum(arr);
	//Getting max sum from kadane

	if(max_normal < 0)
		return max_normal;
	//If normal max is 0 , not even 1 element is positive 
	//Return the answer , no need to use circular approach 
	//Just return least negative number

	int arr_sum = 0;

	for(int i = 0; i < n; i++)
	{
		arr_sum += arr[i];//Finding total sum with all -ve and +ve numbers 

		arr[i] = -arr[i];// Negating all numbers - this being done so we an find minimum sum 
	}

	int max_circular = arr_sum + normalMaxSum(arr);
	// Arr sum -> total sum ; NormalMaxSum-. Kadane max with all nu,bers negated ~ Kadane min sum sub array 

	return Math.max(max_circular, max_normal);//Returning max of circular // normal 
}

   

   
   private static int MaxSubArraySumInCircularArray(int[] arrcircular) {
	// To find max subarray sum by kadane algorithm 
	// [1,2,3]->  converted to [0,1,2,0,1] and applied as of normal array 
	// To avoid O n space , use %n for finding array 
	// 3%3 = 0 , arr[0]=0
    // 4%3 1 , are[1]=1
	// Need to sun loop for O 2n-1
	   
	int n=arrcircular.length;
	int maxNormal=arrcircular[0];
	int MaxTotal=arrcircular[0];
	int submax=arrcircular[0];
	arrcircular[0]=-1*arrcircular[0];
	
	for(int i=1;i<n;i++) {
		/////////////////////NORMAL MAX //////////////////////////////
		submax=Math.max(arrcircular[i],submax+arrcircular[i]);
		maxNormal=Math.max(maxNormal, submax);
		System.out.println(" Max "+maxNormal+" Submax "+submax);
		/////////////////////TOTAL MAX /////////////////////////////////
		MaxTotal=MaxTotal+arrcircular[i];
		///////////////////// Negation and storing /////////////////////
		arrcircular[i]=-1*arrcircular[i];
		/////////////////////////////////
		System.out.println(" Normal Max------->"+maxNormal);
		System.out.println(" Total Max------->"+MaxTotal);
		System.out.println(" Arr circular now :"+arrcircular[i]);
	}
	System.out.println(" Normal Max------->"+maxNormal);
	System.out.println(" Total Max------->"+MaxTotal);
	   //submax=0; //Resetting value
	   if(maxNormal<0) {
		   return maxNormal;/* All elements are negative so return the lowest element found in kadane algo */
	   }
	   System.out.println(" Max normal "+maxNormal+" Total Max ..."+MaxTotal);
	   ArrayPart01.PrintRayy(arrcircular);
	   // circular name 
	   int MaxCirular=arrcircular[0];
	   submax=arrcircular[0];
	for(int i=1;i<n;i++) {
		submax=Math.max(arrcircular[i],submax+arrcircular[i]);
		MaxCirular=Math.max(MaxCirular, submax);
		System.out.println(" Max ----"+MaxCirular+" Submax---- "+submax);
	}
	System.out.println(" MAX circular-------> "+MaxCirular);
	MaxCirular=MaxTotal+MaxCirular;
	MaxTotal=Math.max(MaxCirular, maxNormal);
	System.out.println(" MAX circular..... "+MaxCirular+" Total Max ..."+MaxTotal+" Max normal "+maxNormal);
	return MaxTotal;
}



private static int MaxConsecutiveEvenAndOddGoG_Kadane(int[] arr)
   {
	   int n=arr.length;
   	if (n == 0)
   	return 0;

   	int maxLength = 0;

   	// storing the nature of first element, if
   	// remainder = 1, it is odd
   	int prevOdd = arr[0] % 2;
   	int curLength = 1;
   	for (int i = 1; i < n; i++)
   	{

   	// everytime we check if previous
   	// element has opposite even/odd
   	// nature or not
   	if (arr[i] % 2 != prevOdd)
   		curLength++;
   	else

   		// reset value when pattern is broken
   		curLength = 1;

   	// changing value when new maximum
   	// subarray is found
   	if (curLength > maxLength)
   		maxLength = curLength;

   	// updating even/odd nature of prev
   	// number encountered everytime
   	prevOdd = arr[i] % 2;
   	}

   	return maxLength;
   }	
private static int MaxConsecutiveEvenAndOdd(int[] arr) {
	//  Kadane max conse even and odd length
	int n=arr.length;
	int start=arr[0];
	int oddOrEven=1;
	int ansLen=0;
	int maxLen=1;
	if(arr[0]%2==0) {
		oddOrEven=2;
	}
	System.out.println(" Strat with "+start+" Even odd  "+oddOrEven);
	for(int i=1;i<n;i++) {
		if(oddOrEven==1 && (arr[i]%2==0)) {
			maxLen++;
			oddOrEven=2;
			System.out.println(" Conse cutive even at "+arr[i]+" curr max   ---"+maxLen);
		}
		else if(oddOrEven==2 && (arr[i]%2!=0)) {
			maxLen++;
			oddOrEven=1;
			System.out.println(" Conse cutive odd at "+arr[i]+" curr max   ---"+maxLen);
		}
		else {
			maxLen=1;
			if(arr[i]%2==0) {
				oddOrEven=2;
			}
			else {
				oddOrEven=1;
			}
		}
		System.out.println(" Max len "+maxLen+" Total maxi "+ansLen);
		ansLen=Math.max(maxLen,ansLen);
	}
	return ansLen;
}
}
