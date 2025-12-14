package stack_queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * Infix to post fix:
 * 1) Parenthesize given infix expression : (x+(y*z)) based on precedence
 * 2) Start with innermost bracket - convert to postfix : operator last  (x+(yz*))
 * 3) Convert the outer expression , till all brackets are removed x yz* +
 * 
 * With stack :
 * 
 * 1) Create a stack
 * 2) Traverse from left to right 
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
 * 
 * 
 * Evaluation of PostFix :
 *  Input : 10 2 * 3+
 *  Output : (10*2) 3+
 *         = 20 3 +
 *         =23
 * 
 * Traverse from left to right 
 * 1) Set first operand as A
 * 2) Set second operand as B 
 * 3) Then taken the next operator 
 * 4) Compute A operator B
 * 5) Consider the ans as A 
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
 * 2) Traverse the exp 
 *      If operand -> push in stack
 *      else 
 *         x - operator 
 *         operand2= s.pop
 *         operand1= s.pop
 *         Compute ans and push in stack
 *  3) return st.top()
 *  
 * 
 * 
 * @author shree
 *
 */
public class Stack11_Infix_Postfix {

	static HashSet<Character> RightToLeft= new HashSet<Character>();
	
	static HashMap<Character,Integer> precedence=new HashMap<>();
	// Infix to postfix 
	public static void main(String[] args) {
		
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
        Conversion obj = new Conversion(exp.length());
        obj.infixToPostfix(exp);
		    GeneratePrecedenceTable();
		    GenerateAssociativity();
		//	String exp="(x+y)*z";
			System.out.println(" Precendence "+precedence.get('+'));
			String ans=FindPostfix(exp,exp.length());
			System.out.println(" Infix "+exp+" Postfix :"+ans);

			
	    String exp2 = " ((1+2)*4)/4";
	    ans=FindPostfix(exp2,exp2.length());
		System.out.println(" Infix "+exp2+" Postfix :"+ans);
		
		//Evaluation of Post fix 
		int ani= EvaluatePostFix(ans,ans.length());
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


		private static int EvaluatePostFix(String exp,int n) {
			Stack<Integer> s=new Stack<>();
			int ans=0;
			int a=0;int b=0;
			char sym;
			for(int i=0;i<n;i++) {
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
						else if(sym=='+' && (i+1<n && 
								exp.charAt(i+1)=='+')) {
							i=i+1;
							s.push(a+1);
						}
						else if(sym=='-' && (i+1<n && 
								exp.charAt(i+1)=='-')) {
							i=i+1;
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


		private static String FindPostfix(String exp, int n) {
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
			return sb.toString();
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

class Conversion {
    private int top;
    private int capacity;
    private char[] array;
    private String output;
    private Map<Character, Integer> precedenc;

    public Conversion(int capacity) {
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
                output += exp.charAt(i);
            } else if (exp.charAt(i) == '(') {
                push(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {
                while (!isEmpty() && peek() != '(') {
                    char a = pop();
                    output += a;
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
                    output += a;
                }
                push(exp.charAt(i));
            }
        }
        while (!isEmpty()) {
            char a = pop();
            output += a;
        }
        System.out.println(" Capacity "+capacity);
        System.out.println(output);
    }
}
/**

Infix to Postfix

Write a program to Convert Infix expression to Postfix.

Infix expression: The expression of the form a operator b (a + b). When an operator is in-between every pair of operands.
Postfix expression: The expression of the form a b operator (ab+). When an operator is followed by every pair of operands.

Examples:

Input: A + B * C + D
Output: ABC*+D+

Input: ((A + B) - C * (D / E)) + F
Output: AB+CDE/*-F+  

 

Why postfix representation of the expression? 
The compiler scans the expression either from left to right or from right to left. 
Consider the expression: a + b * c + d

The compiler first scans the expression to evaluate the expression b * c, then again scans the expression to add a to it. The result is then added to d after another scan. The repeated scanning makes it very inefficient and Infix expressions are easily readable and solvable by humans whereas the computer cannot differentiate the operators and parenthesis easily so, it is better to convert the expression to postfix(or prefix) form before evaluation.
The corresponding expression in postfix form is abc*+d+. The postfix expressions can be evaluated easily using a stack. 

 

Steps to convert Infix expression to Postfix expression using Stack:
Scan the infix expression from left to right. 
If the scanned character is an operand, output it. 
Else, 
If the precedence and associativity of the scanned operator are greater than the precedence and associativity of the operator in the stack(or the stack is empty or the stack contains a '(' ), then push it.
'^' operator is right associative and other operators like '+','-','*' and '/' are left-associative. Check especially for a condition when both,  operator at the top of the stack and the scanned operator are '^'. In this condition, the precedence of the scanned operator is higher due to its right associativity. So it will be pushed into the operator stack. In all the other cases when the top of the operator stack is the same as the scanned operator, then pop the operator from the stack because of left associativity due to which the scanned operator has less precedence. 
Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.) 
If the scanned character is an ‘(‘, push it to the stack. 
If the scanned character is an ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis. 
Repeat steps 2-6 until the infix expression is scanned. 
Print the output 
Pop and output from the stack until it is not empty.
Below is the implementation of the above algorithm: 

// Java implementation to convert
 //infix expression to postfix
// Note that here we use ArrayDeque class for Stack
// operations

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Test {

    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int Prec(char ch)
    {
        switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
    static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Deque<Character> stack
            = new ArrayDeque<Character>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
                stack.push(c);

            //  If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty()
                       && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }

                stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty()
                       && Prec(c) <= Prec(stack.peek())) {

                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }
      
        return result;
    }

    // Driver's code 
    public static void main(String[] args)
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
      
          // Function call
        System.out.println(infixToPostfix(exp));
    }
}

Output
abcd^e-fgh*+^*+i-
Time Complexity: O(N), where N is the size of the infix expression
Auxiliary Space: O(N)


*/

/*
Evaluation of Postfix

 
The Postfix notation is used to represent algebraic expressions. The expressions written in postfix form are evaluated faster compared to infix notation as parenthesis is not required in postfix. We have discussed infix to postfix conversion. In this post, the evaluation of postfix expressions is discussed.

 

Example: 

Input: str = "2 3 1 * + 9 -"
Output: -4
Explanation: 

Scan 2, it's a number, so push it to stack. Stack contains '2' 
Scan 3, again a number, push it to stack, stack now contains '2 3' (from bottom to top) 
Scan 1, again a number, push it to stack, stack now contains '2 3 1' 
Scan *, it's an operator, pop two operands from stack, apply the * operator on operands, we get 3*1 which results in 3. We push the result 3 to stack. The stack now becomes '2 3'. 
Scan +, it's an operator, pop two operands from stack, apply the + operator on operands, we get 3 + 2 which results in 5. We push the result 5 to stack. The stack now becomes '5'. 
Scan 9, it's a number, so we push it to the stack. The stack now becomes '5 9'. 
Scan -, it's an operator, pop two operands from stack, apply the - operator on operands, we get 5 - 9 which results in -4. We push the result -4 to the stack. The stack now becomes '-4'. 
There are no more elements to scan, we return the top element from the stack (which is the only element left in a stack).
Input: str = "100 200 + 2 / 5 * 7 +"
Output: 757

Evaluation of Postfix Expression Using Stack:
Follow the steps mentioned below to evaluate postfix expression using stack:

Create a stack to store operands (or values). 
Scan the given expression from left to right and do the following for every scanned element. 
If the element is a number, push it into the stack 
If the element is an operator, pop operands for the operator from the stack. Evaluate the operator and push the result back to the stack 
When the expression is ended, the number in the stack is the final answer                                                                                                            
Below is the implementation of the above approach:


// Java program to evaluate value of a postfix expression

import java.util.Stack;

public class Test 
{
    // Method to evaluate value of a postfix expression
    static int evaluatePostfix(String exp)
    {
        //create a stack
        Stack<Integer> stack=new Stack<>();
        
        // Scan all characters one by one
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
            
            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
            stack.push(c - '0');
            
            //  If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                    
                    case '-':
                    stack.push(val2- val1);
                    break;
                    
                    case '/':
                    stack.push(val2/val1);
                    break;
                    
                    case '*':
                    stack.push(val2*val1);
                    break;
              }
            }
        }
        return stack.pop();    
    }
    
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        String exp="231*+9-";
        System.out.println("postfix evaluation: "+evaluatePostfix(exp));
    }
}

Output
postfix evaluation: -4
Time Complexity: O(N) 
Auxiliary Space: O(N)

There are the following limitations of the above implementation. 
It supports only 4 binary operators '+', '*', '-' and '/'. It can be extended for more operators by adding more switch cases. 
The allowed operands are only single-digit operands. The program can be extended for multiple digits by adding a separator-like space between all elements (operators and operands) of the given expression. 
Below given is the extended program which allows operands to have multiple digits. 


// Java program to evaluate value of a postfix 
// expression having multiple digit operands
import java.util.Stack;

class Test1
{
    // Method to evaluate value of a postfix expression
    static int evaluatePostfix(String exp)
    {
        //create a stack
        Stack<Integer> stack = new Stack<>();
        
        // Scan all characters one by one
        for(int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
            
            if(c == ' ')
            continue;
            
            // If the scanned character is an operand 
            // (number here),extract the number
            // Push it to the stack.
            else if(Character.isDigit(c))
            {
                int n = 0;
                
                //extract the characters and store it in num
                while(Character.isDigit(c))
                {
                    n = n*10 + (int)(c-'0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;

                //push the number in stack
                stack.push(n);
            }
            
            // If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                    
                    case '-':
                    stack.push(val2- val1);
                    break;
                    
                    case '/':
                    stack.push(val2/val1);
                    break;
                    
                    case '*':
                    stack.push(val2*val1);
                    break;
            }
            }
        }
        return stack.pop(); 
    }
    
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(exp));
    }
}

Output
757
Time Complexity: O(N) 
Auxiliary Space: O(N)

*/