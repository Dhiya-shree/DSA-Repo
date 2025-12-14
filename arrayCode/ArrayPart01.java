package arrayCode;

/*
 * O-->
 * 
 * Insert - O(n)
 * Delete - O(n)
 * Search --> Unsorted - O(n)
 *     -----> Sorted   - O(log(n))
 * Get ith element    -O(1)
 * Update ith element -O(1)
 * Insert at end - O(1)
 * Delete at end - O(1)  //if ar was return with 0 to n-1 elements
 * 
 */

public class ArrayPart01 {
public static void main(String[] args) {
//	int arr[];//Array declaration 
//	arr=new int[10];//Array initiation
	int ar[]=new int[5];//Declaration and allocation 
	for(int i=0;i<3;i++) {
		ar[i]=i+2;
	}
	int length_actual= ar.length;
	ar=InsertIntoManual(ar,length_actual,3,5);
	PrintTHEray(ar,length_actual);
	ar=InsertIntoManual(ar,length_actual,0,1);
	PrintTHEray(ar,length_actual);
	ar=DeleteManual(ar,length_actual,2);
	PrintTHEray(ar,length_actual);
	ar=DeleteManual(ar,length_actual,4);
	PrintTHEray(ar,length_actual);
	
}

private static int[] DeleteManual(int[] ar, int size, int ele) {
	//Deleting method 
	int flag = 0;
	for(int i=0;i<size-1;i++) {
		if(ar[i]==ele || flag==1) {
			flag=1;
			ar[i]=ar[i+1];
		}
	}
	ar[size-1]=0;
	return ar;
}

private static void PrintTHEray(int[] ar, int length_actual) {
	// Method to print arrays 
	for(int i=0;i<length_actual;i++) {
		System.out.print(ar[i]+" ");
	}
	System.out.println();
	
}

private static int lengthofRay(int[] ar,int size) {
	int res = 0;
	for(int i=0;i<size;i++) {
		if(ar[i]!=0) {
			res++;
		}
	}
	return res;
}

private static int[] InsertIntoManual(int[] ar, int size, int pos, int ele) {
	// Inserting method
	int len= lengthofRay(ar,size);
	if(size==len) {
		System.out.println("No space available :( ");
		return ar;
	}
	for(int i=size-1;i>pos;i--) {
		ar[i]=ar[i-1];
	}
	ar[pos]=ele;
	return ar;
	
}
public static void PrintRayy(int[] arr) {
	int len=arr.length;
	for(int i=0;i<len;i++) {
		System.out.print(arr[i]+" ");
	}
	System.out.println();
}

public static void PrintRayy2D(int[][] arr, int n, int k) {
	//int len=arr.length;
	//int len2=arr[0].length;
	for(int i=0;i<n;i++) {
		for(int j=0;j<k;j++) {
		System.out.print(arr[i][j]+" ");
	}
		System.out.println();
	}
	System.out.println();
}

public static void PrintRayy(Object[] arr) {
	int len=arr.length;
	for(int i=0;i<len;i++) {
		System.out.print(arr[i]+" ");
	}
	System.out.println();
}

public static void PrintRayy(long[] arr) {
	int len=arr.length;
	for(int i=0;i<len;i++) {
		System.out.print(arr[i]+" ");
	}
	System.out.println();
}
}
