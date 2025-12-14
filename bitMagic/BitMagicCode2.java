package bitMagic;

import java.util.Arrays;
import java.util.Scanner;

/*
 * For setting k th bit use -> n|(1<<k)
 * For un setting k bit use -> n&(~(1<<(k-1)))
 */
public class BitMagicCode2 {
	static Scanner c= new Scanner(System.in);
public static void main(String[] args) {
	
	NoOfBits2FlipToConvertAtoB();
	//O(n)
	PowerSetOfAString();
	//O(n2.n)
	SwapBitsofOddAndEven();
	//O(1)
	EfficientSwapBitsOfOddAndEven();
	maxConsecutiveOnes(222);
	//O(n)
	MaxANDvalueOfAraay();
	GreyToBinary(604791);//Wont work re
	CorrectGreyToBinary(604791);
	BinartyToGrey(100000000);
	Efficient1LineBinaryToGrey(100000000);
}

private static void CorrectGreyToBinary(int n) {
	// Use this 
	int ans = n ;
	while(n>0) {
		n=n>>1;
		ans=ans^n;
	}
	System.out.println("Ans"+ans);
}

private static void GreyToBinary(int i) {
	/*
	 * My Attempt to help you understand this problem!!!
Step 1: Understanding and Visualization The problem states that we are given a number N
 represented in Gray code and we need to find its binary equivalent.
  We are also asked to return the decimal representation of the binary equivalent.

Gray code is a binary numeral system where two successive values differ in only one bit.
 To better understand the problem, let's take an example:

Example: Input: N = 4 Output: 7

In this example, N is given as 4, which represents the Gray code 110. 
We need to find the binary equivalent of the Gray code and return its decimal representation.

Step 2: Brute Force Approach A brute force approach to solve this problem
 would be to convert the given Gray code to binary by following the Gray code conversion rules. 
 Then, we can convert the obtained binary number to its decimal representation.

To convert Gray code to binary, we can follow the below steps:

Start with the most significant bit of the Gray code and copy 
it to the corresponding bit in the binary number.
For each subsequent bit in the Gray code, XOR it with the corresponding bit in the binary number,
 and copy the result to the binary number.
Repeat step 2 until all bits in the Gray code are processed.
Finally, we can convert the obtained binary number to its decimal representation.

Step 3: Optimization The brute force approach works correctly but may not be efficient enough 
for larger inputs. To optimize the solution, we can directly derive the binary equivalent of 
the Gray code without converting it to binary first.

The algorithm to convert Gray code to binary is as follows:

Initialize a variable called "result" with the value of the most significant bit of the Gray code.
Iterate through each bit of the Gray code, starting from the second most significant bit.
For each bit, perform an XOR operation between the bit itself and the corresponding bit in the 
result.
Append the result of the XOR operation to the "result" variable.
At the end of the iteration, "result" will contain the binary equivalent of the Gray code.
Step 4: Walk-through Let's walk through the optimized solution using the first example:

Example: Input: N = 4

To find the binary equivalent of the Gray code 110:

Initialize "result" with the value of the most significant bit: result = 1.
Iterate through each bit of the Gray code, starting from the second most significant bit:
For the second bit (1), perform XOR operation between 1 and 1 (the corresponding bit in the result): 1 XOR 1 = 0.
Append the result of XOR (0) to the "result" variable: result = 10.
For the third bit (0), perform XOR operation between 0 and 0: 0 XOR 0 = 0.
Append the result of XOR (0) to the "result" variable: result = 100.
After processing all bits in the Gray code, "result" contains the binary equivalent: result = 100.
Step 5: Implementation Let's write the code for the optimized solution in C++.

int grayToBinary(int n) {
    int result = n;  // Initialize result with the most significant bit
    while (n > 0) {
        n = n >> 1;  // Right shift the number
        result = result ^ n;  // Perform XOR operation
    }
    return result;
}
Let me explain the implementation in a step-by-step manner:

Initialize the variable result with the given Gray code value n. 
This will store the binary equivalent of the Gray code.
We start a loop that continues until n becomes 0.
In each iteration of the loop, we perform two operations: a.
 Right shift n by 1 bit using the >> operator. 
This effectively moves the bits of n one position to the right.
 For example, if n is 6 (represented in binary as 110), 
 the right shift operation n >> 1 will give 3 (represented in binary as 011).
  b. Perform an XOR operation between result and the updated value of n. 
  This operation is denoted by the ^ operator. 
  The XOR operation compares the corresponding bits of result and n and sets the resulting bit to
   1 if the bits are different and 0 if they are the same.
  The result of this operation is then assigned back to result.
Let's go through an example to illustrate how this implementation works:

Example: Input: N = 4

Initialize result with the value of n: result = 4.
The loop starts:
In the first iteration, n is right-shifted by 1, resulting in n = 2. 
The value of result is XORed with n, i.e., result = 4 ^ 2, which gives result = 6.
In the second iteration, n is right-shifted by 1, resulting in n = 1.
The value of result is XORed with n, i.e., result = 6 ^ 1, which gives result = 7.
In the third iteration, n is right-shifted by 1, resulting in n = 0.
 Since n becomes 0, the loop terminates.
The final value of result is 7, which represents the binary equivalent of the Gray code 4 (110).
To understand why we perform the XOR operation, let's consider the nature of Gray codes. 
In Gray code, consecutive numbers differ by only one bit.
 This property allows us to derive the binary equivalent of a Gray code by 
 considering the changes in bits from one Gray code to the next.

Let's take an example to illustrate this:

Example: Gray code sequence: 4 (110), 5 (111), 6 (101), 7 (100), 8 (1100)

If we compare the binary representation of consecutive Gray codes,
we can observe the following pattern:

For the most significant bit (MSB), it remains the same in the binary representation.
For the remaining bits, the bit changes occur in a specific pattern.
For example, when we compare Gray code 4 (110) with Gray code 5 (111),
 we can see that the only bit that changes is the least significant bit (LSB). 
 Similarly, when we compare Gray code 6 (101) with Gray code 7 (100),
  we observe that the only bit that changes is the second least significant bit. 
  This pattern holds true for all consecutive Gray codes.

The XOR operation in the implementation takes advantage of this pattern. 
By performing XOR between result and the right-shifted value of n, 
we effectively handle the bit changes between successive Gray codes.

Let's consider the example of Gray code 4 (110) to further illustrate this:

Initialize result with the value of n: result = 4.
In the first iteration, n is right-shifted by 1, resulting in n = 2 (010 in binary). 
The XOR operation result = result ^ n is performed: result = 4 ^ 2. 
This XOR operation effectively handles the bit change from the second least significant bit (1) 
to the least significant bit (0), resulting in result = 6 (110 in binary).
By applying the XOR operation iteratively for each bit change in the Gray code, 
we obtain the binary equivalent.
	 */
	int n=i;

	//int a,b;//=n&1;
	//To find set bit msb
	int k= 1<<((int) (Math.log(i)/Math.log(2)));
	//k--;
	int ans =(n>>k)&1;
	int temp =(n>>k)&1;
	System.out.println(temp+" k is "+k);
	//k--;
	while(k>0) {
		ans=ans<<1;
		k--;
		temp=temp^((n>>k)&1);;
		ans=ans|temp;
		System.out.println("Teno"+temp+" k "+k+"Ans"+ ans);
	}
	//ans=temp;
	System.out.println();
	System.out.println("Ans"+ans);
}

private static void Efficient1LineBinaryToGrey(int i) {
	// g0=bo^b1 ... so as below
	int n=i;
	System.out.println( n ^ (n >> 1));
}

private static void BinartyToGrey(int i) {
	// Binary to grey
	int n=i;
	int ans=0;
	int a=n&1;
	n=n>>1;
	int  b=n&1;
	int k=1;
	int temp=0;
	ans=((a^b));
	while(n>0) {
		a=n&1;
		n=n>>1;
		b=n&1;
		temp=((a^b)<<k);
		ans=ans+temp;
		System.out.println("Temp"+temp+"Ans  "+ans +" K is "+k);
		k++;
	}
	System.out.println("Ans"+ans);
}

private static void MaxANDvalueOfAraay() {
	/*
	 * Given an array arr[] of N positive elements. 
	 * The task is to find the Maximum AND Value generated by
	 *  any pair of the element from the array.
	 */
	int ar[]= {4, 8, 12, 16};
	int len=ar.length;
	int max_and=0;
	for(int i=0;i<len;i++) {
		for(int j=i+1;j<len;j++) {
			max_and=Math.max(max_and,ar[i]&ar[j]);
		}
	}
	System.out.println("Max and"+max_and);
}

public static void maxConsecutiveOnes(int n) {
    
    // Your code here
    int conse=0;
    int max_conse=0;
    while(n>0){
        if((n&1)!=0){
            conse++;
        }
        else{
            conse=0;
        }
        max_conse=Math.max(max_conse, conse);
        n=n>>1;
    }
    System.out.println("Max conse"+max_conse);
}

private static void EfficientSwapBitsOfOddAndEven() {
	/*
	 * C++ explanation of One line code:

n & 0xAAAAAAAA: This bitwise AND operation extracts all the even-positioned bits of
 the integer n (assuming the least significant bit is at position 0). 
 The hexadecimal constant 0xAAAAAAAA is a 32-bit integer with all even-positioned bits
  set to 1 and odd-positioned bits set to 0. So, performing an AND operation with n will 
  retain only the even-positioned bits of n, and all other bits will become 0.

((n & 0xAAAAAAAA) >> 1): After extracting the even-positioned bits, this part performs
 a bitwise right-shift by 1 position. This operation effectively moves the even-positioned
  bits one position to the right. It is equivalent to dividing the extracted even-positioned
   bits by 2.

n & 0x55555555: This bitwise AND operation extracts all the odd-positioned bits of the integer n.
 The hexadecimal constant 0x55555555 is a 32-bit integer with all odd-positioned bits set to 1
  and even-positioned bits set to 0. So, performing an AND operation with n will retain only
   the odd-positioned bits of n, and all other bits will become 0.

((n & 0x55555555) << 1): After extracting the odd-positioned bits, 
this part performs a bitwise left-shift by 1 position. 
This operation effectively moves the odd-positioned bits one position to the left. 
It is equivalent to multiplying the extracted odd-positioned bits by 2.

((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1):
 Finally, both the results obtained from steps 2 and 4 are combined using the bitwise OR
  operation (|). The OR operation combines the bits from the two expressions, 
  resulting in a new integer where even and odd bits have been swapped.

class Solution
{
    public:
    //Function to swap odd and even bits.
    unsigned int swapBits(unsigned int n)
    {
    	// Your code here
    	return (((n&0xAAAAAAAA)>>1) | (n&0x55555555)<<1);
    }
};
	 */
	int a=0xAAAAAAAA;//Give all even by &
	int b=0x55555555;//Give all odd by &
	int n=23;
	int c=(n&a)>>1;
	int d=(n&b)<<1;//Shift to change position 
	int ans=c|d;//add all the bits
	System.out.println("Ans of"+n+"is "+ans);
}

private static void SwapBitsofOddAndEven() {
	// to swap bits of 1-2 , 3-4 , 5-6 and so on 
	int n=23;
	int n1=n;
	int a,b,c,d;
	for(int i=0;i<32;i=i+2){
		if(n<(Math.pow(2,i))) {
			break;
		}
		c=(1<<i);
		d=(1<<(i+1));
		a=(n1&c);
		b=(n1&d);
		System.out.println("A:"+a+"B"+b+"posi"+c+"Posi"+d);
		if((a!=0 && b!=0)||(a==b) ){
			System.out.println("Same in "+i+"and "+i+1);
		}
		else {
			//_1_^010=
			System.out.println("Different"+i+" "+i+1+"A: "+a+"B :"+b);
			if(a==0) {
				n1=c|n1; //a 0 set as 1
				System.out.println("N1="+n1+"at"+c);
				n1=n1&(~d);//Need to unset at i+1th bit so using ~(1<<i)
				System.out.println("N1="+n1+"at"+~c);
			}
			else {
				n1=n1&((~c));//Need to unset at ith bit so using ~(1<<i-1)
				System.out.println("N1="+n1);
				n1=(d)|n1;//b 0 set as 1
				System.out.println("N1="+n1);
			}
		}
		System.out.println("N1+++"+n1);
	}
	System.out.println("Ans+"+n1);
}

private static void PowerSetOfAString() {
	// given string abc to give 0,a,b,c,ab,bc,ac,abc
	String str="abc";
	int n= str.length();
	String temp = "";
	int instances=1<<n;//2 power n instance for abc length 3 , 8 instances
	String ans[]=new String[instances];
	for(int i=0;i<instances;i++) {
		for(int j=0;j<instances;j++) {
			if((i&(1<<j))!=0) {
				System.out.print(str.charAt(j));
				temp=temp.concat(str.substring(j, j+1));
				//System.out.println("Temp"+temp);
			}
		}
		ans[i]=temp;
		//System.out.println("i"+i+"temp"+temp+"ans"+ans[i]);
		temp="";
		System.out.println();
	}
	ans[0]=" ";
	System.out.println(Arrays.toString(ans));
	
}

private static void NoOfBits2FlipToConvertAtoB() {
	// XOR to find no of bits different between a and b
	int a=10,b=20;
	int res=a^b;
	int n=0;
	//To find set bits of res
	while(res>0) {
		if((res&1)==1) {
			n++;
		}
		res=res>>1;
	}
	System.out.println(n+"Count of to be flipped ");
}
}
