package bitMagic;

public class intrduction {
	
public static void main(String[] args) {
	int ans1=63;
	ans1=CheckIfPowerOf2(ans1);
	System.out.println(ans1);
	
	int ans2=31;
	ans2=FindMSBbit(ans2);
	System.out.println(ans2);
	
	CheckIfBitSetorNotAtn(ans2, 4);
	
	int ans3=6;
	ans3=FindXORof1toN(ans3);
	System.out.println(ans3);
}

private static int FindXORof1toN(int n) {
	/*/ Find the remainder of N by moduling it with 4.
	If rem = 0, then xor will be same as N.
			If rem = 1, then xor will be 1.
			If rem = 2, then xor will be N+1.
			If rem = 3 ,then xor will be 0.*/
	
	int sum = 0;
	if(n%2==0) {
		sum=(n*(n-1))/2;
	}
	else {
		
	}
	int rem=sum%4;
	if(rem==0) {
		return n;
	}
	if(rem==1) {
		return 1;
	}
	if(rem==2) {
		return n+1;
	}
	if(rem==3) {
		return 0;
	}
	System.out.println("Wrong answr");
	return -1;
}

private static int FindMSBbit(int x) {
	// MSB bit position = log base2of number
	int n=x;
	int count=0;
	while(x!=0) {
		count++;
		x=x>>1;
	}
	return (CheckIfBitSetorNotAtn(n,count));
}

private static int CheckIfBitSetorNotAtn(int x, int count) {
	// left shift 1 <<(n-1)  , n And temp
	int temp=1<<(count-1);
	int ans=x&temp;
	System.out.println(x+"X "+temp+"T "+ans+"A "+count+"c");
	if(ans!=0) {
		System.out.println("SET");
	}
	else {
		System.out.println("NOT SET");
	}
	return ans;
}

private static int CheckIfPowerOf2(int ans1) {
	// power of 2 are 2,4,8,16 or in bits 10,100,1000,10000
	//If num AND num-1 is zero then it is power of 2 
	//Ex 100(8)-011(7) == 0 --- 8 is power of 2 
	//Other method 
	int ans= ans1 & (ans1-1);
	if(ans==0) {
		System.out.println("Power of 2");
	}
	else {
		System.out.println("Not a poer of 2");
	}
	return ans;
} 
	
/* Operators of C++
 * 1) & And 
 * 2) Or |
 * 3) Exor ^
 * 4) Left shift-move bits by left , num<< 1 <-1 left shit one = num*2;num<<3 = num * 2^3
 * 5) right shift-move bits by right , num>> 1 ->1 right shit one = num/2;num>>3 = num /2^3
 * 6) Not negation ~ Only unary inversion  
 * 32 bits - Unsigned - 0 to (2^32-1)
 *   Ex: ~1 --> binary of 1 = 000..0001  ~1 = 111..1110( (2^32-1)-1))
 * Unsigned inversion of X = MaxNum(2^32-1) - X
 * Signed 32 bits= 2^31to (2^31-1) , MSB , leading bit 1- negative ; 0-positive
 * Signed inversion of X- 2s complement inverse+-1 for ~1=-2 ; ~5=-6etc
 * Do notuse ~ on signed number , C++may or may not take the 2s complement 
 * 2^32-x=-x
 */
	
////////////JAVA ////////////////////////////
  /*Operators of Java 
   * 1) And $ 1 and 1 -> 1
   * 2) OR  | 0 or 0 -> 1
   * 3) XOR ^ different --> 1
   * 4) Not ~ - inverse all number 
   * Positive bit - inverse all bit 2^32-x
   * Negative number - 2s complement -x-1
   * 5)Left shift << ; num<<x= num*(2^x)
   * ex) -1<<1= -2 ; -1<<2=-4
   * 6) Signed Right  shift >>; num>>x= 2^32-x
   * ex-signed ) Right shift and fill 1 at beginning ans - negative : MSB-1
   * 7)Unsigned right shift : positive and negative >>> ; num>>>x
   * ex-unsigned) Right shift and fill leading bit as 0 
   *  negative num will become positive as MSB wll be 0 
   * num>>>x= 2^31-x ---> ans positive 
   * 
   */
	
	
	//////////////////ARTICLE 1 ///////////////////////////////////////////
	
	/*
	 * Bitwise Operators


The operators that works at Bit level are called bitwise operators. In general there are six types of Bitwise Operators as described below:
 

& (bitwise AND) Takes two numbers as operands and does AND on every bit of two numbers. The result of AND is 1 only if both bits are 1. Suppose A = 5 and B = 3, therefore A & B = 1.
| (bitwise OR) Takes two numbers as operands and does OR on every bit of two numbers. The result of OR is 1 if any of the two bits is 1. Suppose A = 5 and B = 3, therefore A | B = 7.
^ (bitwise XOR) Takes two numbers as operands and does XOR on every bit of two numbers. The result of XOR is 1 if the two bits are different. Suppose A = 5 and B = 3, therefore A ^ B = 6.
<< (left shift) Takes two numbers, left shifts the bits of the first operand, the second operand decides the number of places to shift.
>> (right shift) Takes two numbers, right shifts the bits of the first operand, the second operand decides the number of places to shift.
~ (bitwise NOT) Takes one number and inverts all bits of it. Suppose A = 5, therefore ~A = -6.


Important Facts about Bitwise Operators:
 

The left shift and right shift operators cannot be used with negative numbers.
The bitwise XOR operator is the most useful operator from technical interview perspective. We will see some very useful applications of the XOR operator later in the course.
The bitwise operators should not be used in place of logical operators.
The left-shift and right-shift operators are equivalent to multiplication and division by 2 respectively.
The & operator can be used to quickly check if a number is odd or even. The value of expression (x & 1) would be non-zero only if x is odd, otherwise the value would be zero.
Time and Auxiliary Space used will be - O(1) 
	 * 
	 */
	
	
	//////////////////////ARTICLE 2 ////////////////////////////////////////
	
	/*
	 * Bit Algorithms | Important Tactics

Let's look at some of the useful tactics of the Bitwise Operators which can be helpful in solving a lot of problems really easily and quickly.
 

How to set a bit in the number 'num' : If we want to set a bit at nth position in number 'num' ,it can be done using 'OR' operator( | ).
First we left shift '1' to n position via (1 << (n-1))
Then, use 'OR' operator to set bit at that position.'OR' operator is used because it will set the bit even if the bit is unset previously in binary representation of number 'num'.
 
How to unset/clear a bit at n'th position in the number 'num' :

Suppose we want to unset a bit at nth position in number 'num' then we have to do this with the help of 'AND' (&) operator.
First we left shift '1' to n position via (1 << (n-1)) than we use bitwise NOT operator '~' to unset this shifted '1'.
Now after clearing this left shifted '1' i.e making it to '0' we will 'AND'(&) with the number 'num' that will unset bit at nth position.

      3. Toggling a bit at nth position : Toggling means to turn bit 'on'(1) if it was 'off'(0) and to turn 'off'(0) if it was 'on'(1) previously. We will be using 'XOR' operator here which is this '^'. The reason behind 'XOR' operator is because of its properties.

Properties of 'XOR' operator.
1^1 = 0
0^0 = 0
1^0 = 1
0^1 = 1
If two bits are different then 'XOR' operator returns a set bit(1) else it returns an unset bit(0).
 
       4. Checking if bit at nth position is set or unset:

       1) Left shift given number 1 by n-1 to create a number that has only set bit as n-th bit. temp = 1 << (n-1) 

       2) If bitwise AND of n and temp is non-zero, then result is SET else result is NOT SET.

       The bitwise AND should be between number, temp. As n is the bit here, not number. Simply, if (N & (1 << k)) > 0) its "Set".

       5. Divide by 2:

x = x >> 1;
Logic: When we do arithmetic right shift, every bit is shifted to right and blank position is substituted with sign bit of number, 0 in case of positive and 1 in case of negative number. Since every bit is a power of 2, with each shift we are reducing the value of each bit by factor of 2 which is equivalent to division of x by 2. Example:
x = 18(00010010)
x >> 1 = 9 (00001001)
      6. Multiplying by 2:

x =  << 1;
Logic: When we do arithmetic left shift, every bit is shifted to left and blank position is substituted with 0 . Since every bit is a power of 2, with each shift we are increasing the value of each bit by a factor of 2 which is equivalent to multiplication of x by 2. Example:
x = 18(00010010)
x << 1 = 36 (00100100)
      7. Find log base 2 of a 32 bit integer: 


int log2(int x) 
{ 
    int res = 0; 
    while (x >>= 1) 
        res++; 
    return res; 
} 
Logic: We right shift x repeatedly until it becomes 0, meanwhile we keep count on the shift operation. This count value is the log2(x).
     8. Flipping the bits of a number: It can be done by a simple way, just simply subtract the number from the value obtained when all the bits are equal to 1 . For example:

Number : Given Number
Value  : A number with all bits set in given number.
Flipped number = Value – Number.

Example : 
Number = 23,
Binary form: 10111;
After flipping digits number will be: 01000;
Value: 11111 = 31;
     9. Swapping Two Numbers: We can easily swap two numbers say a and b by using the XOR(^) operator by applying below operations:

a ^= b;
b ^= a; 
a ^= b;
 
Steps to convert Binary Representation to 2's complement representation:

Invert all bits .
Add 1

	 */

////////////////////////////////NEGATIVE ////////////////////////////////////

/*
 * Number of bits be n 
 * Then range of numbers allowed = 2^n-1 to (2^n-1) -1
 * Consider n=4 , Range - 2^3 to 2^3-1= -8 to 7 
 * 
 * Highest positive number=0111 - 7 MSB - 0 for positive 
 * Highest negative number=1000 - -8 LSB - 1 for negative 
 * 
 * 1s for -3 : 0011 (3)
 * invert : 1100
 * add 1 : 1100 - 12
 * 
 * 2s complement of -3:
 * 3 - 0011
 * Invert all - 1100 
 * Add 1 - 1101 
 * -3 in 2s complement : 1101
 * -3 stored as 13 -1101 
 * 
 * Short cut for 2s 2^n-number 
 * n = 4 ;2^4=16
 * 16-3 = 13 
 * Thus 2s complement -3 is stored as 13 
 * 
 * Y 2s complement ?
 * 2s complement only used to store signed number 
 * Other option:
 * 1s complement: Invert all , MSB decides - or +
 *    ex) 3 - 0000 0011 and -3 - 1111 1100
 *    Cons: two representation of zero ex) 0000 0000 and 1111 1111 are +0 and -0
 *    
 * Sign bit - MSB used to differentiate - and +
 *    ex) 3 - 0000 0011 and -3 - 1000 0011
 *    Cons: two representation of zero ex ) 1000 0000 and 0000 0000
 *    Create confusion by 2 zero and reduce range by 1
 *    
 * 2S COMPLEMENT :
 * 1) Only 1 representation of zero 
 * 2) Easy arithmetic operation , 2s' = 2^n-x derived from idea 0-x
 *         Division - sub from 0 ex ) 3 - 0011 sub from 0 = 0000-0011 => 1101
 *         Sub a and b - take 2s complement of B and add with a : a+(2s complement of b )
 *         Addition as usual ...
 * 3) Leading bit is always 1 for negative numbers
 * 
 * Range :
 * For unsigned : 0 to 2^n -1 - C++ and Python ( Java dont have unsigned)
 * For signed : -2^(n-1) to 2^(n-1)-1  Java , C++  , Python 
 */
}
