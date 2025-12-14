package stack_queue;


/**
 *  Infix Post-fix PreFix
 * 
 *  Infix --> x+y human writable form operator in-between operand 
 *  Post fix--> xy + first operand , second operand, third operand
 *  Prefix --> +xy operator followed by first - second operand
 * 
 * Advantages of prefix and ppost fix ?
 *  No need to use parenthesis
 *  No Precedence rules
 *  No Associativity rule 
 * 
 *  Expression can be evaluated in one traversal 
 *  Infix needs more than 1 pass 
 *  
 *  Precedence and associativity rules:
 *  Used when there are more than 1 operator in expression 
 *  if left to right -> left first right second 
 *  If right to left -> right first left second
 *  
 *  same precedence -> same associativity
 *  ^ - exponentiation and bitwise OR 
 *  ^  rIGHT To left     ^
 *  *'/' left to right   |
 *  + - left to right    |
 *                    PRECEDENCE  
 *                    
 * Example :
 *  
 *  1) 10+ 20*2 - 10+40( precedence) = 50
 *  2) 10+  2-3 - (Same precedence - use associativity)
 *       left to right - 12-3 = 9
 *  3) 2^1^2 - associativity  right to left 
 *         2^(1^2) = 2^1 = 2
 *         
 * Infix       Pre Fix        Post fix         
 *  x+y*z      + x *yz        x yz* +
 * (x+y)*z     * +xy z        xy+ z *
 *  
 * Infix to prefix:
 * 1) Parenthesize given infix expression : (x+(y*z)) based on precedence
 * 2) Start with innermost bracket - convert to prefix : operator first (x+(*yz))
 * 3) Convert the outer expression , till all brackets are removed + x *yz
 * 
 * Infix to post fix:
 * 1) Parenthesize given infix expression : (x+(y*z)) based on precedence
 * 2) Start with innermost bracket - convert to postfix : operator last  (x+(yz*))
 * 3) Convert the outer expression , till all brackets are removed x yz* +
 * 
 *  
 *  On conversion for infix to post/pre fix
 *   
 *   if precedence >= then  push in stack
 *   else < pop from stack 
 *   
 *   Because most of symbols with same precedence are having 
 *   Right to left associativity
 *   Right side higher precedence 
 *   So on traversing left to right 
 *   Right side operator curr operator is of high priority 
 *   So simply push in stack 
 *   if curr stack precedence == top of stack precedence 
 * 
 *   Left to right associativity for same precedence 
 *   ==  !=	equality	left-to-right 
 * 
 * 
 *
Level	Operator	Description	Associativity
16	()
[]
.	parentheses
array access
member access	left-to-right
15	++
--	unary post-increment
unary post-decrement	left-to-right
14	+
-
!
~
++
--
unary plus
unary minus
unary logical NOT
unary bitwise NOT
unary pre-increment
unary pre-decrement	right-to-left
13	()
new	cast
object creation	right-to-left
12	* / %	multiplicative	left-to-right
11	+ -  +	additive  
   string concatenation	left-to-right
10	<< >> >>>	shift	left-to-right
9	< <=
     > >= instanceof
     	relational	left-to-right
8	== !=	equality	left-to-right
7	&	bitwise AND	left-to-right
6	^	bitwise XOR	left-to-right
5	|	bitwise OR	left-to-right
4	&&	logical AND	left-to-right
3	||	logical OR	left-to-right
2	?:	ternary	right-to-left
1	 =   +=   -=
*=   /=   %=
&=   ^=   |=
<<=  >>= >>>=	assignment	right-to-left
0	->
lambda expression arrow	right-to-left

 * 
 * 
 * 
 * @author shree
 *
 */
public class Stack10_Infix_Post_Pre_fix {

	public static void main(String[] args) {
		
	   // Infix evaluation 
		// Just give to compiler 
		
		
		
	}

}
