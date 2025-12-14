package stack_queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * 
 *  Infix to prefix :
 *  
 * Infix to prefix:
 * 1) Parenthesize given infix expression : (x+(y*z)) based on precedence
 * 2) Start with innermost bracket - convert to prefix : operator first (x+(*yz))
 * 3) Convert the outer expression , till all brackets are removed + x *yz
 * 
 * Input : x + y * z
 *       = (x+(y*z))
 *       =(x+(*yz))
 *       = + x *yz
 * 
 * With stack :
 * 
 * 1) Create a stack and string builder ans
 * 2) Traverse from right to left 
 * 3) If operand(numbers) append with ans
 *    If left parenthesis ( -> push into stack 
 *    If right parenthesis ) -> pop until removing 1 left parenthesis
 *    If operator:
 *        If stack is empty -->push 
 *        Else
 *          if top of stack precedence < current --> push in stack 
 *          if top of stack precedence < current 
 *                  --> Remove till top precedence less than current 
 *                  --> push the current operator 
 *          if top of stack precedence == current 
 *                  --> Use associativity rules 
 * 4) Pop all till stack is empty 
 * 5) You will have postfix , reverse it to get postfix  
 * 
 * 
 * 
 * Evaluation of prefix :
 * 1) Traverse from right side 
 *     Do all operation similar to postfix
 *  In prefix : we pop 1stt element as A and second as B 
 *  If postfix : pop the first element as B and second as B 
 *       For A +_* B  
 *         
 * 1) Set first operand as B
 * 2) Set second operand as A 
 * 3) Then taken the next operator 
 * 4) Compute A operator B
 * 5) Consider the ans as B 
 * 6) Repeat step 2 to 6 till loop ends
 * 
 * Special case:
 *   Unary operator 
 *   Bitwise NOT 
 *   If above realized skip setting B 
 *   
 *   
 * Evaluation of Post fix :
 * 1) CReate stack s 
 * 2) Traverse the exp right to left
 *      If operand -> push in stack
 *      else 
 *         x - operator 
 *         operand1= s.pop
 *         operand2= s.pop
 *         Compute ans and push in stack
 *  3) return st.top()
 * 
 * 
 * @author shree
 *
 */
public class Stack12_Infix_to_postFix {

	static HashSet<Character> RightToLeft= new HashSet<Character>();

	static HashMap<Character,Integer> precedence=new HashMap<>();
	// Infix to prefix 
	
	
	public static void main(String[] args) {
		// Prefix using stack - postfix with ans reversed
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		ConversionPreFix obj = new ConversionPreFix(exp.length());
        obj.infixToPostfix(exp);
		    GeneratePrecedenceTable();
		    GenerateAssociativity();
		//	String exp="(x+y)*z";
	      String ans=FindPrefix(exp,exp.length());
			System.out.println(" Infix "+exp+" Prefix :"+ans);

			
	    String exp2 = " ((1+2)*4)/4";
	    ans=FindPrefix(exp2,exp2.length());
		System.out.println(" Infix "+exp2+" Prefix :"+ans);
		
		//Evaluation of Post fix 
		int ani= EvaluatePreFix(ans,ans.length());
		System.out.println(" Ans for "+ans+" is --"+ani);

		}
      
	
		private static void GenerateAssociativity() {
		// setting right to left 
			// If right to left -> push in stack 
			RightToLeft.add('+');
			RightToLeft.add('-');
			RightToLeft.add('!');
			RightToLeft.add('~');
			RightToLeft.add('=');
			/*
			RightToLeft.add('++');
			RightToLeft.add('--');
			RightToLeft.add('?:');
			RightToLeft.add('+=');
			RightToLeft.add('-=');
			RightToLeft.add('*=');
			RightToLeft.add('/=');
			RightToLeft.add('%=');
			RightToLeft.add('type');
			*/
			
		
	}


		private static int EvaluatePreFix(String exp,int n) {
			//Same as posttfix 
			// But reverse traversal 
			// Top member in stack is A 
			// Inner member is B for 
			Stack<Integer> s=new Stack<>();
			int ans=0;
			int a=0;int b=0;
			char sym;
			for(int i=n-1;i>=0;i--) {
				sym=exp.charAt(i);
				System.out.println(" Sym is "+sym);
				if(sym==' ') {
					break;
				}
				if(Character.isDigit(sym)) {
					System.out.println(" Pushing "+(sym-48));
					s.push((int) sym-48);
				}
				else {
					a=s.pop();
					if(s.isEmpty()) {
						if(sym=='!' || sym=='~') {
							s.push(~a);
						}
						else if(sym=='+' && (i-1>=0 && 
								exp.charAt(i-1)=='+')) {
							i=i-1;
							s.push(a+1);
						}
						else if(sym=='-' && (i-1>=0 && 
								exp.charAt(i-1)=='-')) {
							i=i-1;
							s.push(a-1);
						} 
					}
					else {
						b=s.pop();
						System.out.println(" With a "+a+" With B "+b);
						a=getValueWithOperator(b,a,sym);
						System.out.println(" A is "+a);
						s.push(a);
					}
					
				}
				
			}
			
		ans=s.pop();
		if(s.isEmpty()) {
			return ans;	
		}
		else {
			System.out.println(" Stack not empty ....");
			System.out.println("Curr ans "+ans);
		}
		return s.pop();
	}


		private static int getValueWithOperator(int a, int b, char sym) {
			int ans=0;
			if(sym=='+') {
				ans=(a+b);
			}
			else if(sym=='-') {
				ans=(a-b);
			}
			else if(sym=='*') {
				ans=(a*b);
			}
			else if(sym=='/') {
				ans=(a/b);
			}
			else if(sym=='%') {
				ans=(a%b);
			}
			else if(sym=='^') {
				ans=(a^b);
			}
			else if(sym=='&') {
				ans=(a*b);
			}
			else if(sym=='|') {
				ans=(a-b);
			}
			else  {
				System.out.println(" Burugeso.....");
				return 0;
			}
			return ans;
		}


		private static String FindPrefix(String exp, int n) {
			// Infix to postfix 
			Stack<Character> s=new Stack<>();
			StringBuilder sb=new StringBuilder();
			char a;char b;
			int j=1000;
			for(int i=0;i<n;i++) {
				a=exp.charAt(i);
				//If operand append 
				if(Character.isLetter(a) || Character.isDigit(a)) {
					sb.append(a);
				}
				else if(a=='(') {
					// Open (
					s.push(a);
				}
				else if(a==')') {
					//Close bracket 
					j=1000;
					b=s.peek();
					while(!s.isEmpty() && j>0 && b!='(') {
						sb.append(b);
						s.pop();
						b=s.peek();
						j--;
					}
					
					if(s.peek()=='(') {
						s.pop();
					}
					else {
						System.out.println(" no close bracket ");
					}
				}
				else {
					//Considering you have opertor 
					if(s.isEmpty()) {
						s.push(a);
					}
					else {
					b=s.peek();
					System.out.println(" B "+b+" A "+a );
					if(precedence.containsKey(b) && precedence.get(b)<precedence.get(a)) {
						s.push(a);
					}
					else if(precedence.containsKey(b)&&RightToLeft.contains(a) && precedence.get(b)==precedence.get(a)) {
						
						if(RightToLeft.contains(a)){
							s.push(a);
						}
					//	else {
							// For left to right associativity 
							// Curr is consider less priority 
							
						//}
					}
					else {
						while( !s.isEmpty() && precedence.containsKey(s.peek()) && precedence.get(s.peek())>=precedence.get(a)) {
							b=s.peek();
							sb.append(b);
							s.pop();
							
						}
						s.push(a);
					}			
				}
				}
				
			}
			
			while(!s.isEmpty()) {
				sb.append(s.pop());
			}
			return sb.reverse().toString();
		}

		 private static void GeneratePrecedenceTable() {
			  precedence.put('+',1);
	    	   precedence.put('-',1);
	    	   precedence.put('*',2);
	    	   precedence.put('/',2);
	    	   precedence.put('%',12);
	    	   precedence.put('=',1);
	    	   precedence.put('>',9);
	    	   precedence.put('<',9);
	    	   precedence.put('!',14);
	    	   precedence.put('|',5);
	    	   precedence.put('^',3);
	    	   precedence.put('&',7);
				//precedence 
		    /*	   precedence.put("->", 0);
		    	   //=   +=   -=
		    	//   *=   /=   %=
		    		//	   &=   ^=   |=
		    			//   <<=  >>= >>>=
		    	   precedence.put("=", 1);
		    	   precedence.put("+=", 1);
		    	   precedence.put("-=", 1);
		    	   precedence.put("*=", 1);
		    	   precedence.put("/=", 1);
		    	   precedence.put("%=", 1);
		    	   precedence.put("&=", 1);
		    	   precedence.put("^=", 1);
		    	   precedence.put("|=", 1);
		    	   precedence.put("<<=",1);
		    	   precedence.put(">>=",1);
		    	   precedence.put(">>>=",1);
		    	   
		    	   //Ternary 
		    	   precedence.put("?:", 2);
		    	   //Logical OR AND 
		    	   precedence.put("||", 3);
		    	   precedence.put("&&", 4);
		    	   //Bitwise or , and xor 
		    	   precedence.put("|", 5);
		    	   precedence.put("^", 6);
		    	   precedence.put("&", 7);
		    	   precedence.put("!=", 8);
		    	   precedence.put("==", 8);
		    	   precedence.put("<", 9);
		    	   precedence.put(">", 9);
		    	   precedence.put("<=",9);
		    	   precedence.put(">=",9);
		    	   precedence.put(">>",10);
		    	   precedence.put("<<",10);
		    	   precedence.put(">>>",10);
		    	   precedence.put("+",11);
		    	   precedence.put("-",11);
		    	   precedence.put("*",12);
		    	   precedence.put("/",12);
		    	   precedence.put("%",12);
		    	   precedence.put("new",13);
		    	   precedence.put("~",14);
		    	   precedence.put("++",14);
		    	   precedence.put("--",14);
		    	   precedence.put("!",14);
		    	   precedence.put(".",15);
		    	   precedence.put("[]",15);
		    	   
		    	   
		    	  */ 
				
			}


}

class ConversionPreFix {
    private int top;
    private int capacity;
    private char[] array;
    private String output;
    private Map<Character, Integer> precedenc;

    public ConversionPreFix(int capacity) {
        top = -1;
        this.capacity = capacity;
        array = new char[capacity];
        output = "";
        precedenc = new HashMap<>();
        precedenc.put('+', 1);
        precedenc.put('-', 1);
        precedenc.put('*', 2);
        precedenc.put('/', 2);
        precedenc.put('^', 3);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public char peek() {
        return array[top];
    }

    public char pop() {
        if (!isEmpty()) {
            top--;
            return array[top + 1];
        } else {
            return '$';
        }
    }

    public void push(char op) {
        top++;
        array[top] = op;
    }

    public boolean isOperand(char ch) {
        return Character.isLetter(ch);
    }

    public boolean notGreater(char i) {
        int a, b;
        if (precedenc.containsKey(i) && precedenc.containsKey(peek())) {
            a = precedenc.get(i);
            b = precedenc.get(peek());
            return (a <= b);
        } else {
            return false;
        }
    }

    public void infixToPostfix(String exp) {
        for (int i = 0; i < exp.length(); i++) {
            if (isOperand(exp.charAt(i))) {
                output = exp.charAt(i)+output;
            } else if (exp.charAt(i) == '(') {
                push(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {
                while (!isEmpty() && peek() != '(') {
                    char a = pop();
                    output = a+ output;
                }
                if (!isEmpty() && peek() != '(') {
                    System.out.println("Invalid expression");
                    return;
                } else {
                    pop();
                }
            } else {
                while (!isEmpty() && notGreater(exp.charAt(i))) {
                    char a = pop();
                    output = a+output;
                }
                push(exp.charAt(i));
            }
        }
        while (!isEmpty()) {
            char a = pop();
            output = a+output;
        }
        
        System.out.println(" Capacity "+capacity);
        System.out.println(output);
    }
}

/**



Infix To Prefix

To convert an infix to postfix expression refer to this article Infix to Postfix article. We use the same to convert Infix to Prefix.

Step 1: Reverse the infix expression i.e A+B*C will become C*B+A. Note while reversing each '(' will become ')' and each ')' becomes '('.
Step 2: Obtain the "nearly" postfix expression of the modified expression i.e CB*A+.
Step 3: Reverse the postfix expression. Hence in our example prefix is +A*BC.
Note that for Step 2, we don't use the postfix algorithm as it is. There is a minor change in the algorithm. We have to pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. But here, we have to pop all the operators from the stack which are greater in precedence than that of the scanned operator. Only in the case of "^" operator, we pop operators from the stack which are greater than or equal to in precedence.

Below is the C++ and Java implementation of the algorithm. 


// JAVA program to convert infix to prefix
import java.util.*;

class GFG 
{
  static boolean isalpha(char c)
  {
    if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') 
    {
      return true;
    }
    return false;
  }

  static boolean isdigit(char c) 
  {
    if (c >= '0' && c <= '9') 
    {
      return true;
    }
    return false;
  }

  static boolean isOperator(char c) 
  {
    return (!isalpha(c) && !isdigit(c));
  }

  static int getPriority(char C)
  {
    if (C == '-' || C == '+')
      return 1;
    else if (C == '*' || C == '/')
      return 2;
    else if (C == '^')
      return 3;

    return 0;
  }

  // Reverse the letters of the word
  static String reverse(char str[], int start, int end)
  {

    // Temporary variable to store character
    char temp;
    while (start < end)
    {

      // Swapping the first and last character
      temp = str[start];
      str[start] = str[end];
      str[end] = temp;
      start++;
      end--;
    }
    return String.valueOf(str);
  }

  static String infixToPostfix(char[] infix1) 
  {
    System.out.println(infix1);
    String infix = '(' + String.valueOf(infix1) + ')';

    int l = infix.length();
    Stack<Character> char_stack = new Stack<>();
    String output="";

    for (int i = 0; i < l; i++) 
    {

      // If the scanned character is an
      // operand, add it to output.
      if (isalpha(infix.charAt(i)) || isdigit(infix.charAt(i)))
        output += infix.charAt(i);

      // If the scanned character is an
      // ‘(‘, push it to the stack.
      else if (infix.charAt(i) == '(')
        char_stack.add('(');

      // If the scanned character is an
      // ‘)’, pop and output from the stack
      // until an ‘(‘ is encountered.
      else if (infix.charAt(i) == ')') 
      {
        while (char_stack.peek() != '(')
        {
          output += char_stack.peek();
          char_stack.pop();
        }

        // Remove '(' from the stack
        char_stack.pop();
      }

      // Operator found
      else {
        if (isOperator(char_stack.peek())) 
        {
          while ((getPriority(infix.charAt(i)) < 
                  getPriority(char_stack.peek()))
                 || (getPriority(infix.charAt(i)) <= 
                     getPriority(char_stack.peek())
                     && infix.charAt(i) == '^')) 
          {
            output += char_stack.peek();
            char_stack.pop();
          }

          // Push current Operator on stack
          char_stack.add(infix.charAt(i));
        }
      }
    }
    while(!char_stack.empty()){
          output += char_stack.pop();
    }
    return output;
  }

  static String infixToPrefix(char[] infix)
  {
    
        // Reverse String Replace ( with ) and vice versa Get Postfix Reverse Postfix *
         
    int l = infix.length;

    // Reverse infix
    String infix1 = reverse(infix, 0, l - 1);
    infix = infix1.toCharArray();

    // Replace ( with ) and vice versa
    for (int i = 0; i < l; i++)
    {

      if (infix[i] == '(') 
      {
        infix[i] = ')';
        i++;
      } 
      else if (infix[i] == ')')
      {
        infix[i] = '(';
        i++;
      }
    }

    String prefix = infixToPostfix(infix);

    // Reverse postfix
    prefix = reverse(prefix.toCharArray(), 0, l-1);

    return prefix;
  }
  
  */


/*
Evaluation of Prefix

In this article, we will discuss how to evaluate an expression written in prefix notation. The method is similar to evaluating a postfix expression. Please read Evaluation of Postfix Expression article to know how to evaluate postfix expressions

Algorithm:

EVALUATE_PREFIX(STRING)
Step 1: Put a pointer P at the end of the end
Step 2: If character at P is an operand push it to Stack
Step 3: If the character at P is an operator pop two 
        elements from the Stack. Operate on these elements
        according to the operator, and push the result 
        back to the Stack
Step 4: Decrement P by 1 and go to Step 2 as long as there
        are characters left to be scanned in the expression.
Step 5: The Result is stored at the top of the Stack, 
        return it
Step 6: End
Example to demonstrate working of the algorithm  

Expression: +9*26

Character | Stack       |  Explanation
Scanned   | (Front to   |
          |  Back)      | 
-------------------------------------------
6           6             6 is an operand, 
                            push to Stack
2           6 2           2 is an operand, 
                            push to Stack
*           12 (6*2)      * is an operator, 
                          pop 6 and 2, multiply 
                          them and push result 
                          to Stack 
9           12 9          9 is an operand, push 
                          to Stack
+           21 (12+9)     + is an operator, pop
                          12 and 9 add them and
                          push result to Stack

Result: 21
Examples:  

Input : -+8/632
Output : 8

Input : -+7*45+20
Output : 25
Complexity The algorithm has linear complexity since we scan the expression once and perform at most O(N) push and pop operations which take constant time.
Implementation of the algorithm is given below.  

Implementation:


// Java program to evaluate
// a prefix expression.
import java.io.*;
import java.util.*;

class GFG {

    static Boolean isOperand(char c)
    {
        // If the character is a digit
        // then it must be an operand
        if (c >= 48 && c <= 57)
            return true;
        else
            return false;
    }

    static double evaluatePrefix(String exprsn)
    {
        Stack<Double> Stack = new Stack<Double>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {

            // Push operand to Stack
            // To convert exprsn[j] to digit subtract
            // '0' from exprsn[j].
            if (isOperand(exprsn.charAt(j)))
                Stack.push((double)(exprsn.charAt(j) - 48));

            else {

                // Operator encountered
                // Pop two elements from Stack
                double o1 = Stack.peek();
                Stack.pop();
                double o2 = Stack.peek();
                Stack.pop();

                // Use switch case to operate on o1
                // and o2 and perform o1 O o2.
                switch (exprsn.charAt(j)) {
                case '+':
                    Stack.push(o1 + o2);
                    break;
                case '-':
                    Stack.push(o1 - o2);
                    break;
                case '*':
                    Stack.push(o1 * o2);
                    break;
                case '/':
                    Stack.push(o1 / o2);
                    break;
                }
            }
        }

        return Stack.peek();
    }

    //* Driver program to test above function 
    public static void main(String[] args)
    {
        String exprsn = "+9*26";
        System.out.println(evaluatePrefix(exprsn));
    }
}

Output
21
Note: 
To perform more types of operations only the switch case table needs to be modified. This implementation works only for single digit operands. Multi-digit operands can be implemented if some character-like space is used to separate the operands and operators.

Below given is the extended program which allows operands to have multiple digits.

// Java program to evaluate a prefix expression.
import java.util.*;
public class Main
{
    static boolean isdigit(char ch)
    {
        if(ch >= 48 && ch <= 57)
        {
            return true;
        }
        return false;
    }
     
    static double evaluatePrefix(String exprsn)
    {
        Stack<Double> stack = new Stack<Double>();
      
        for (int j = exprsn.length() - 1; j >= 0; j--) {
            
            // if jth character is the delimiter ( which is
            // space in this case) then skip it
            if (exprsn.charAt(j) == ' ')
                continue;
      
            // Push operand to Stack
            // To convert exprsn[j] to digit subtract
            // '0' from exprsn[j].
            if (isdigit(exprsn.charAt(j))) {
                
                // there may be more than
                // one digits in a number
                double num = 0, i = j;
                while (j < exprsn.length() && isdigit(exprsn.charAt(j)))
                    j--;
                j++;
      
                // from [j, i] exprsn contains a number
                for (int k = j; k <= i; k++)
                {
                    num = num * 10 + (double)(exprsn.charAt(k) - '0');
                }
      
                stack.push(num);
            }
            else {
      
                // Operator encountered
                // Pop two elements from Stack
                double o1 = (double)stack.peek();
                stack.pop();
                double o2 = (double)stack.peek();
                stack.pop();
      
                // Use switch case to operate on o1
                // and o2 and perform o1 O o2.
                switch (exprsn.charAt(j)) {
                case '+':
                    stack.push(o1 + o2);
                    break;
                case '-':
                    stack.push(o1 - o2);
                    break;
                case '*':
                    stack.push(o1 * o2);
                    break;
                case '/':
                    stack.push(o1 / o2);
                    break;
                }
            }
        }
      
        return stack.peek();
    }
    
  // Driver code
    public static void main(String[] args) {
        String exprsn = "+ 9 * 12 6";
        System.out.print((int)evaluatePrefix(exprsn));
    }
}

Output
81
Time Complexity: O(n)
Space Complexity: O(n)

*/