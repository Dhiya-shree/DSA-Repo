package arrayCode;

import java.util.ArrayList;

/*
 * Problem #1 :Move Zeros to End - in given array move zeros to end and rerurn 
 * 
 * Problem #2 :Rearrange an array with O(1) extra space
 *   Given an array arr[] of size N where every element is in the range from 0 to n-1.
 *   Rearrange the given array so that the transformed array arrT[i] becomes arr[arr[i]].
 * ans 3  4  0  1  2
 * arr 0  1  2  3  4
 *     4  0  1  2  3
 *  in 1 2 3 4 0   
 *  va 0 1 2 3 4
 *  in 1 2 3 4 0
 *  si 0 1 2 3 4
 *  ns 4 0 1 2 3
 * ans 3  4  0  1  2    
 *    
 *    Problem #3: Left rotate by 1 
 *    
 *    Problem #4: Left rotate by D 
 *    
 *    Problem #5: Leaders in a array
 *      An element is a leader if it is greater than or equal to all the elements to its right side. 
 *      And the rightmost element is always a leader. 
 */
public class ArrayPart04 {

	public static void main(String[] args) {
		//Problems below 
		
		MoveZerosToEnd();
		
		RearrangeArrayInO1();
		//O n.n.n
		RearrangeArrayInO1Efficient();
		//O n
		int arr[]= {0,1,2,3,4,5,6,7,8,9};
		arr=LeftRotateBy1(arr);
		//O n
		LeftRotateByD(arr,3);
		//O nD time O 1 space
		int arr1[]= {0,1,2,3,4,5,6,7,8,9};
		LeftRotateByDInODSpace(arr1,3);
		//O n and OnD
		int arr2[]= {0,1,2,3,4,5,6,7,8,9};
		LeftRotateByDInO1Space(arr2,3);
		//O n and O 1 space
		
		LeadersInAarray();
		//O n and O 1 space
	}

	private static void LeadersInAarray() {
		// To find elements that doesnt have bigger elements in right side 
		int arr[]= {0,1,2,3,4,5,10,1,2,3,4,5,9,3,2,1,0};
		int n=arr.length;
		int ans[]=new int[n];
		int max=arr[n-1];
		
		int pointer=0;
		ans[0]=arr[pointer];
		for(int i=n-2;i>=0;i--) {
			if(arr[i]>max) {
				ans[pointer]=arr[i];
				max=arr[i];
				pointer++;
			}
		}
		ArrayPart01.PrintRayy(ans);
		ans=reverse_left_rotate(ans,0,pointer);
		ArrayPart01.PrintRayy(ans);
		leaders(ans, n);
		
	}

	private static void LeftRotateByDInO1Space(int[] arr, int d) {
		// Left Rotate By D In O1 Space
		//int d=5;
		int n=arr.length;
		arr=reverse_left_rotate(arr,0,d);
		PrintRay(arr);
		arr=reverse_left_rotate(arr,d,n);
		PrintRay(arr);
		arr=reverse_left_rotate(arr,0,n);
		System.out.println("Rotated :");
		PrintRay(arr);
		ArrayPart01.PrintRayy(arr);
	}
	
	private static int[] reverse_left_rotate(int[] arr, int s, int d) {
		// Reverse the given array 
		int mid=(int) Math.ceil((s+d)/2);
		int temp=0;
		int pointer=d-1;
		for(int i=s;i<mid;i++) {
			temp=arr[i];
			arr[i]=arr[pointer];
			arr[pointer]=temp;
			pointer--;
		}
		return arr;
		
	}
	public static void PrintRay(int[] arr) {
		// Print the array
		int len=arr.length;
		for(int i=0;i<len;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	private static void LeftRotateByDInODSpace(int[] arr, int d) {
		// Left Rotate By D In OD Space
		//Alternative 
		// Copy 0 to d-1 elements in arr_d 
		//Shift other left by D 
		//Copy arr_d in arr[d to n-1]
		int[] arr2 = arr.clone();
		int n=arr.length;
		int temp=d;
		for(int i=0;i<n;i++) {
			if(temp<n) {
			arr[i]=arr2[temp];
			temp++;}
			else {
				arr[i]=arr2[(temp%(n))];
				//System.out.println(i+" ...  "+temp%n+"  ..aa..."+arr[i]);
				temp++;
			}
		}
		ArrayPart01.PrintRayy(arr);
	}

	private static void LeftRotateByD(int[] arr, int d) {
		// left rotate by D 
		
		for(int j=0;j<d;j++) {
			arr=LeftRotateBy1(arr);
		}
		ArrayPart01.PrintRayy(arr);
	}

	private static int[] LeftRotateBy1(int[] arr) {
		// Left rotate by 1 
		//int arr[]= {0,1,2,3,4,5,6,7,8,9};
		int temp=arr[0];
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			arr[i]=arr[i+1];
		}
		arr[n-1]=temp;
		ArrayPart01.PrintRayy(arr);
		return(arr);
	}

	private static void RearrangeArrayInO1Efficient() {
		// Rearrange Array InO1 Efficient
		long arr[]= {4,0,1,2,3};
		int n=arr.length;
		for(int i=0;i<n;i++) {
		    arr[i] = (arr[i] + (arr[(int) arr[i]] % n) * n);
			//temp=(int) (arr[i]/code);
			//temp2=(int) (arr[temp]/code);
			//arr[i]=arr[i]+temp2;
			
			
		}
		arr=DecodeDivide(arr,n,n);
		ArrayPart01.PrintRayy(arr);
		
	}

	private static long[] DecodeDivide(long[] arr, int n, int code) {
		// decode by /
		for(int i=0;i<n;i++) {
			arr[i]=arr[i]/code;
		}
		return arr;
	}

	private static void RearrangeArrayInO1() {
		//Rearrange an array with O(1) extra space
		// To store value of arr 0 temp is used , further all values 1 by 1 is used 
		long arr[]= {4,0,1,2,3};
		int temp =0;
        int temp2=0;
		int code=1000000;
		int n=arr.length;
		arr=Encode(arr,n,code);
		for(int i=0;i<n;i++) {
			temp=(int) (arr[i]/code);
			temp2=(int) (arr[temp]/code);
			arr[i]=arr[i]+temp2;
			
		}
		arr=Decode(arr,n,code);
		ArrayPart01.PrintRayy(arr);
		
	}

	private static long[] Decode(long[] arr, int n, int code) {
		// Decode by div
		for(int i=0;i<n;i++) {
			arr[i]=arr[i]%code;
		}
		return arr;
	}

	private static long[] Decode(long[] arr, int n, int code) {
		// Decode by div
		for(int i=0;i<n;i++) {
			arr[i]=arr[i]%code;
		}
		return arr;
	}

	private static long[] Encode(long[] arr, int n, int code) {
		// Encode by *
		for(int i=0;i<n;i++) {
			arr[i]=arr[i]*code;
		}
		return arr;
	}

	private static void MoveZerosToEnd() {
		// moving zero toright 
		int arr[]= {0,0,1};//1,2,3,0,4,0,0,5,6,7,0,0,8,0,9,0};
		int n=arr.length;
		int temp=0;
		int temp2=0;
		for(int i=0;i<n;i++) {
			if(arr[i]!=0) {
				temp2=arr[i];
				arr[i]=arr[temp];
				arr[temp]=temp2;
				temp++;
			}
		}
		System.out.println("Moved to right ");
		ArrayPart01.PrintRayy(arr);
	}

	static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList <Integer> ans=new ArrayList<Integer>();
        int max=arr[n-1];
		//int pointer=0;
        ans.add(0,max);
		for(int i=n-2;i>=0;i--) {
			if(arr[i]>max) {
				max=arr[i];
				ans.add(0,max);
			}
		}
		return ans;
    }
}
