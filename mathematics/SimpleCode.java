package mathematics;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleCode {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Hello !!! Press 0 to continue ..");
		int switch_num;
		int a,b,c=0;
		a=sc.nextInt();
		System.out.println(" Type : ");
		System.out.println("        1-->Count");
		System.out.println("        2-->Absolute value");
		System.out.println("        3-->CeliciusToFahrenheit");
		System.out.println("        4-->QuadraticRoots");
		System.out.println("        5-->Palindrome");
		System.out.println("        6-->Factorial");
		System.out.println("        7-->DigitsInFactorial");
		System.out.println("        8-->TrailingZeros");
		System.out.println("        9-->HCForGCD");
		System.out.println("        10-->LCM");
		
		switch_num=sc.nextInt();
        switch(switch_num) {
        case 1:
        {
        	System.out.println(	"Give the number to count digits ");
        	long aa=sc.nextLong();
        	CountMethod(aa);
        	break;
        }
        case 2:
        {
        	System.out.println("Gve the number to count digits ");
        	a=sc.nextInt();
        	AbsolutevalueMethod(a);
        	break;
        }
        case 3:
        {
        	System.out.println("Gve the number to count digits ");
        	a=sc.nextInt();
        	CeliciusToFahrenheitMethod(a);
        	break;
        }
        case 4:
        {
        	System.out.println("Gve the number to count digits ");
        	a=sc.nextInt();
        	b=sc.nextInt();
        	c=sc.nextInt();
        	QuadraticRootsMethod(a,b,c);
        	break;
        }
        case 5:
        {
        	System.out.println("Gve the number to count digits ");
        	a=sc.nextInt();
        	PalindromeMethod(a);
        	break;
        }
        case 6:
        {
        	System.out.println("Gve the number to count digits ");
        	a=sc.nextInt();
        	FactorialMethod(a);
        	break;
        }
        case 7:
        {
        	System.out.println("Gve the number to count digits ");
        	a=sc.nextInt();
        	DigitsInFactorialMethod(a);
        	break;
        }
        case 8:
        {
        	System.out.println("Gve the number to count digits ");
        	a=sc.nextInt();
        	TrailingZerosMethod(a);
        	break;
        }
        case 9:
        {
        	System.out.println("Gve the number to count digits ");
        	a=sc.nextInt();
        	b=sc.nextInt();
        	GCDorHCFMethod(a,b);
        	break;
        }
        case 10:
        {
        	System.out.println("Gve the number to count digits ");
        	a=sc.nextInt();
        	b=sc.nextInt();
        	LCMMethod(a,b);
        	break;
        }
        default:
        {
        	System.out.println(" None were pressed :(");
        }
        }
        sc.close();
	}

	private static void LCMMethod(int a,int b) {
		//LCM = a*b/ GCD (a,b)
		System.out.println((a*b/GCDRecur(a, b)));
	}

	private static void GCDorHCFMethod(int a,int b) {
		//Efficient
		System.out.println(GCDRecur(a,b));
		// Non Efficent solution 
		System.out.println(b);
		while(a%b!=0) {
		int c=0;
		if(a>b)		
			c=a-b;
		else
			c=b-a;
		if(b>c) {
			a=b;
			b=c;
		}
		else {
			a=c;
		}
	}
		System.out.println(b);
		
	}

	private static int GCDRecur(int a, int b) {
		if(b==0) {
			return a;
		}
		return GCDRecur(b,a% b);
	}

	private static void TrailingZerosMethod(int a) {
		int res=0;
		for (int i=5;i<=a;i=i+5){
			int n=i;
			while(n%5==0) {
				res++;
		       // System.out.println(n+" "+res);
				n=n/5;
		       // System.out.println(n);

			}
		}
		System.out.println(res);
		
		///Efficient solu
		// Training zero 0f N! = n/5 + n/25 + n/125 ...+n/5 power k 
		// where 5 poer k < = N 
		res=0;
		for( int i=5;i<=a;i=(i*5)) {
			res=res+(a/i);
		}
		System.out.println(res);
	}

	private static void DigitsInFactorialMethod(int N){
     double res=1;
     for(int i=2;i<=N;i++){
        	res=Math.log10(i)+res;
        }
        System.out.println((int)Math.floor(res));
     //  System.out.println(Findlength(res));
       
    }
	
	

	private static void FactorialMethod(int N) {
        long res=1;
        for(int i=2;i<=N;i++){
            res=res*i;
        }
        System.out.println(res);
    }

	private static void PalindromeMethod(int a) {
		int temp=a;
		int rev=0;
		while(a>0) {
			rev=a%10+(rev*10);
			a=a/10;
		}
		if(temp==rev) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not palindrome");
		}
	}

	private static void QuadraticRootsMethod(int a, int b, int c) {
	      ArrayList<Integer> arr =new ArrayList<Integer>();
	      double D = ((b*b)-(4*(a*c)));
	      System.out.println(D);
	      if(D<0){
	          arr.add(0,-1);
	          arr.add(1,-1);
	       System.out.println("Imaginary");
	        System.out.println(arr.get(0)+" "+arr.get(1));
	      }
	      else{
	    	  D=Math.sqrt(D);
	    	  double ans1=Math.floor((-b+D)/(2*a));
	    	  double ans2=Math.floor((-b-D)/(2*a));
	    	// System.out.println(arr.get(0)+" "+arr.get(1));
	    	  arr.add(0,(int)ans1);
	    	  arr.add(1,(int)ans2);
	         System.out.println(arr.get(0)+"AND "+arr.get(1));

	      }
	    }

	private static void CeliciusToFahrenheitMethod(int a) {
		 double ans=(a*1.8)+32;
		System.out.println(ans);
	}

	private static void AbsolutevalueMethod(int a) {
		System.out.println(Math.abs(a));
	}

	private static void CountMethod(long a) {
		String str = Long.toString(a);
		System.out.println(str.length());
	}

}
