package bitMagic;

import java.util.Scanner;
/* Properties of XOR ^
 * 
 * x^0=x
 * x^y=y^x
 * (x^y)^z=x^(y^z)
 * x^x=0
 * 
 * For even number of X : x^x^x^x=0
 * For odd number of X : x^x^x=x
 * 
 * XOR all the given number -->. Gives the odd number of time 
 * 
 * For two odd occurrence :
 * 	Consider 5 and 6 are the only two odd occuring 
 * such as x,x,x,x,x,x,x,x,5,y,y,y,y,6
 * XOR of all =0^5^6=5^6= 0101^0110=0011(3)
 * Now to find the number from three 
 * 
 * k=x & ~(x-1) - Gives a number which has only last bit set of x 
 * k$Arr[n]--> if true put in ar1 and if false put in ar2
 * Xor of ar1 -> gives 1st odd
 * Xor of ar2 -> gives 2nd odd
 * 
 */

public class BitMaginCode1 {
	static Scanner c= new Scanner(System.in);
	public static void main(String[] args) {
		//1- check if kth bit is set or not 
		System.out.println("Gve nand k");
		CheckIfKthBitSetorNot();	
		FirstSetBit();
		CountofSetBits();
		PowerOfTwo();
		EfficientPowerofTwo();
		//O(log n)
		VeryEfficientPowerOf2();//n&(n&(n-1))
		//O(1)
		Only1OddNumberOfOccurence();
//	    // O(n)
		TwoOddOccurence();
		//O(n)
		TwoOddOccurenceGeeksForGeeks();
		
	}

	private static void TwoOddOccurenceGeeksForGeeks() {
		// XOR usage 
		int arr[] = {1,3,1,1,1,17,3,4,4,4,4,4,4,6,6,6,6,6,6,1};
		int arr_size = arr.length;
		printTwoOdd(arr, arr_size);
		
	}

	static void printTwoOdd(int arr[], int size)
	{
	/* Will hold XOR of two odd occurring elements */
	int xor2 = arr[0];
	
	/* Will have only single set bit of xor2 */
	int set_bit_no;
	int i;
	//int n = size - 2;
	int x = 0, y = 0;
	
	/* Get the xor of all elements in arr[].
		The xor will basically be xor of two
		odd occurring elements */
	for(i = 1; i < size; i++)
		xor2 = xor2 ^ arr[i];
	
	/* Get one set bit in the xor2. We get
		rightmost set bit in the following
		line as it is easy to get */
	set_bit_no = xor2 & ~(xor2-1);
	System.out.println("Set bit no"+set_bit_no+"XOR2"+xor2);
	/* Now divide elements in two sets:
			1) The elements having the
			corresponding bit as 1.
			2) The elements having the
			corresponding bit as 0. */
	for(i = 0; i < size; i++)
	{
		/* XOR of first set is finally going
			to hold one odd occurring number x */
		if((arr[i] & set_bit_no)>0)
		x = x ^ arr[i];
	
		/* XOR of second set is finally going
			to hold the other odd occurring number y */
		else
		y = y ^ arr[i];
	}
	
	System.out.println("The two ODD elements are "+
										x + " & " + y);
	}
	private static void TwoOddOccurence() {
		// x&(~(x-1)) - gives a number of x where last bit is only set 
		int array[]= {1,3,1,1,1,17,3,4,4,4,4,4,4,6,6,6,6,6,6,1};
		int n=array.length;
		int res=0;
		int res1 = 0,res2=0;
		for(int i=0;i<n;i++) {
			System.out.println(i+" "+n);
			res=res^array[i];
		}
		int k= res&(~(res-1));
		System.out.println("XOR an K"+res+" "+k);
		n--;
		while(n>=0) {
			int j=array[n];
			System.out.println(j+" "+n);
			if((k&j)>0) {
				res1=res1^j;
			}
			else {
				res2=res2^j;
			}
			n--;
		}
		System.out.println("K is "+k+"r1^r2="+res+"r1="+res1+"r2="+res2);
	}

	private static void Only1OddNumberOfOccurence() {
		// XOR all the numbers to find the odd number out \
		int array[]= {1,3,1,1,1,2,3,4,4,4,4,4,4,6,6,6,6,6,6};
		int n=array.length;
		int res=0;
		for(int i=0;i<n;i++) {
			res=res^array[i];
		}
		System.out.println(res+" Is the only one odd");
		
	}

	private static void VeryEfficientPowerOf2() {
		int n1=c.nextInt();
		//
		if((n1>1) && ((n1 & (n1 - 1)) == 0)){
			System.out.println(" Power of 2");
		}
		else {
			System.out.println("Not power of 2");
		}
		
	}

	private static void EfficientPowerofTwo() {
		// n&n-1 - sets the rightmost set bit to 0 
		int n1=c.nextInt();
		if(n1==1) {
			System.out.println("Not power of 2");
			return;
		}
		int a=(int) Math.ceil(Math.log(n1)/Math.log(2));
		int b=(int) Math.floor(Math.log(n1)/Math.log(2));

		if(a==b) {
			System.out.println("Power of 2");
		}
		else {
			System.out.println("Not power of 2");
		}
		
	}

	private static void PowerOfTwo() {
		// All power of 2 has only 1 set bit 
		int n1=c.nextInt();
		int count=0;
		if(n1==1) {
			System.out.println("Not power of 2");
			return;
		}
		while(n1>0) {
			n1=(n1&(n1-1));
			count++;
		}
		if(count==1) {
			System.out.println("Power of two "+count);
		}
		else {
			System.out.println("Not power of 2"+count);
		}
		return;
	}

	private static void CountofSetBits() {
		// Can only be used for small values - Use Brian Kurmingam 
		//for large values with a look yup table
		int n=c.nextInt();
		int count=0;
		while(n>0) {
			n=n&(n-1);
			count++;
		}
        System.out.println(count);
	}

	private static void FirstSetBit() {
		// to check first e bit of n
		int n=c.nextInt();
		int count=0;
		while(n!=0) {
			count++;
			if((n&1)!=0) {
				System.out.println(count);
			}
			n=n>>1;
		}
		
		System.out.println(count);
	}

	private static void CheckIfKthBitSetorNot() {
		System.out.println("Gve nand k");
        int n= c.nextInt();
		int k=c.nextInt();
		
		int temp=(int) (Math.pow(2, k));
		if((n&temp)==0) {
			System.out.println("NOT set at "+k+" for "+n);
		}
		else {
			System.out.println("Set at "+k+" for "+n);

		}
		//////////////////NAIVE SOLUION//////////
		int n1=n;
		System.out.println("Divide by 2 till we move kth bit to 1t place");
		for(int i=0;i<(k);i++) {
			n=n/2;
		}
		if((n&1)==0) {
			System.out.println("Not set");
		}
		else {
			System.out.println("SET");
		}
		
		///////////////////////	Efficient sol 1 /////////////////////
		System.out.println("Create 2^k-1 by left shft 1 by k-1 and& with n");
		int temp2=(1<<(k));
		System.out.println(temp2);
		if((n1&temp2)==0) {
			System.out.println("Not set");
		}
		else {
			System.out.println("SET");
		}
		
		//////////////////Efficient sol 2/////////////////////
		
		System.out.println("Move k th bit of n to 1st place by right shift and & with 1");
		temp2=(n1>>(k));
		System.out.println(temp2);

		if((1&temp2)==0) {
			System.out.println("Not set");
		}
		else {
			System.out.println("SET");
		}
		//O1  in T and S
	}
}
