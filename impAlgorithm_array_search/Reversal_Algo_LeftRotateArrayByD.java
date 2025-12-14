package impAlgorithm_array_search;

/*
 * Left Rotate an Array by D places
 *  Reversal Approach (Efficient):
 *  This approach consists of 3 reversal steps:
 *    Reverse the elements from 0 to d-1 index
 *    Reverse the elements from d to n-1 index
 *    finally reverse the whole array
 *    Time Complexity: Theta(n)
 *    Space Complexity: Theta(1)
 *   
 *  [0,1,2,3,4,5] D=3 
 *  Reverse( 0 to 2)=[2,1,0,4,5]
 *  Reverse( 3 to 4)=[2,1,0,5,4]
 *  Reverse( 0 to 4)=[4,5,0,1,2]
 *  
 *  Reversed ans : [4,5,0,1,2] 
 */
 
public class Reversal_Algo_LeftRotateArrayByD {
public static void main(String[] args) {
	//O of D space - O n time
	left_rotate_O_of_D_Space();
	//O of 1 space - O n time
	int arr[]= {25, 6 ,20, 55, 69, 
			5, 50, 63, 61, 41 ,
			87 ,80 ,2 ,96 ,77 ,
			70 ,12, 43, 31, 8, 
			64 ,41 ,68 ,18 ,95,
			79 ,52, 74, 1, 98, 
			3 ,26, 3 ,74 ,32 ,
			23 ,79, 81, 37, 39, 
			21, 24, 18, 22 ,71 ,
			47 ,44};
		//{0,1,2,3,4,5,6,7,8,9};
	
	int d=77;
	int n=arr.length;
	if(d==0||d==n){
        return;
    }
    else if(d>n){
        d=d%n;
    }
	System.out.println("Rotate D times "+d);
	arr=reverse_left_rotate(arr,0,d);
	PrintRay(arr);
	arr=reverse_left_rotate(arr,d,n);
	PrintRay(arr);
	arr=reverse_left_rotate(arr,0,n);
	System.out.println("Rotated :");
	PrintRay(arr);
	
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

static void leftRotate(int arr[], int d, int n)
{
	int temp[] = new int[d];

	for(int i = 0; i  < d; i++)
	{
		temp[i] = arr[i];
	}

	for(int i = d; i  < n; i++)
	{
		arr[i - d] = arr[i];
	}

	for(int i = 0; i  < d; i++)
	{
		arr[n - d + i] = temp[i];
	}	
}

public static void left_rotate_O_of_D_Space()
{ 
   int arr[] = {1, 2, 3, 4, 5}, n = 5, d = 2;

   System.out.println("Before Rotation");

   for(int i = 0; i < n; i++)
   {
   		System.out.print(arr[i]+" ");
   }

   System.out.println();

   leftRotate(arr, d, n);

   System.out.println("After Rotation");

   for(int i = 0; i < n; i++)
   {
   		System.out.print(arr[i]+" ");
   }

} 

/*
 * Example 
 * 47 77
{25, 6 ,20, 55, 69, 
5, 50, 63, 61, 41 ,
87 ,80 ,2 ,96 ,77 ,
70 ,12, 43, 31, 8, 
64 ,41 ,68 ,18 ,95,
79 ,52, 74, 1, 98, 
3 ,26, 3 ,74 ,32 ,
23 ,79, 81, 37, 39, 
21, 24, 18, 22 ,71 ,
47 ,44}
 */

}
