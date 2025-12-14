package mathematics;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
//Imp -ModularArthmetic , Iterative power ,Check for prime , GP AP , Prime Checking .. 
public class SimpleCode2 {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Hello !!! Press 0 to continue ..");
			int switch_num;
			int a,b,c=0;
			a=sc.nextInt();
			System.out.println(" Type : ");
			System.out.println("        1-->Primality");
			System.out.println("        2-->Prime Factors");
			System.out.println("        3-->Check for prime");
			System.out.println("        4-->Exactly 3divisors");
			System.out.println("        5-->GP term");
			System.out.println("        6-->All divisors of a number");
			System.out.println("        7-->Seive of Eratosthenes");
			System.out.println("        8-->Computing power");
			System.out.println("        9-->ModularArthmetic");
			System.out.println("        10->Iterative Power");
			
			switch_num=sc.nextInt();
	        switch(switch_num) {
	        case 1:
	        {
	        	System.out.println(	"Give the number to count digits ");
	        	a=sc.nextInt();
	        	PrimalityMethod(10);
	        	break;
	        }
	        case 2:
	        {
	        	System.out.println("Gve the number to count digits ");
	        	a=sc.nextInt();
	        	PrimeFactorsMethod(a);
	        	break;
	        }
	        case 3:
	        {
	        	System.out.println("Gve the number to count digits ");
	        	a=sc.nextInt();
	        	CheckforprimeMethod(a);
	        	break;
	        }
	        case 4:
	        {
	        	System.out.println("Gve the number to count digits ");
	        	a=sc.nextInt();
	        	Exactly3divisorsMethod(a);
	        	break;
	        }
	        case 5:
	        {
	        	System.out.println("Gve the number to count digits ");
	        	a=sc.nextInt();
	        	b=sc.nextInt();
	        	c=sc.nextInt();
	        	GPtermMethod(a,b,c);
	        	break;
	        }
	        case 6:
	        {
	        	System.out.println("Gve the number to count digits ");
	        	a=sc.nextInt();
	        	AllDivisorsMethod(a);
	        	break;
	        }
	        case 7:
	        {
	        	System.out.println("Gve the number to count digits ");
	        	a=sc.nextInt();
	        	SeiveofEratosthenesMethod(a);
	        	break;
	        }
	        case 8:
	        {
	        	System.out.println("Gve the number to count digits ");
	        	a=sc.nextInt();
	        	c=sc.nextInt();
	        	ComputingpowerMethod(a,c);
	        	break;
	        }
	        case 9:
	        {
	        	System.out.println("Gve the number to count digits ");
	        	a=sc.nextInt();
	        	b=sc.nextInt();
	        	ModularArthmeticMethod(a,b);
	        	break;
	        }
	        case 10:
	        {
	        	System.out.println("Gve the number to count digits ");
	        	a=sc.nextInt();
	        	b=sc.nextInt();
	        	IterativePower(a,b);
	        	break;
	        }
	        default:
	        {
	        	System.out.println(" None were pressed :(");
	        }
	        }
	        sc.close();
}


	public static void PrimalityMethod(int N) {
		// The number must have exactly 3 divisors 1 , number itself and a prime number 
		// Condition if number has more than 1 prime number it is not 3 divisor 
		int count=0;
		int b=N;
		for(int a=4;a<N;a++) {
			if(a%2==0) {
				
				while(a%2==0) {
					a=a/2;
					System.out.println(count+"2"+a);
				}
			}
			if(a==0) {
				System.out.println(count+".."+a);
					count++;
						break;
					}
			a=b;
			if(a%3==0) {
				while(a%3==0) {
					a=a/3;
					System.out.println(count+"3"+a);

				}
			}
			if(a==0) {
				System.out.println(count+".."+a);

					count++;
						break;
					}
			a=b;
			System.out.println(count+"...5,7");
			int s=(int) Math.sqrt(a);
			for(int i=5;i<=s;i=i+6) {
				while(a%i==0) {
					System.out.println(count+" "+i+" "+a);
					a=a/i;
					if(a==0) {
						break;
					}
				}
					if(a==0) {
						System.out.println(count+".."+a);
						count++;
						break;
					}
				a=b;
				while(a%(i+2)==0) {
					System.out.println(count+" "+i+2+" "+a);
					a=a/(i+2);
					if(a==0) {
						break;
					}
				}
					if(a==0) {
						count++;
						break;
					}
				a=b;
				
			}
			
		}
		System.out.println(count);
	}

	public static void IterativePower(int a, int n) {
		//Every number power can be expressed as binary position 
		// Ex 3 power 10 =  
		// 10 Binary - 1010       or 1-8   0-4  1-2   0-1    
		// 3 power 10 = 3^8 * 3^2 or 3^8 * 3^0 *3^2 * 3^0
		//3power 19 - 3^16 *3^2* 3^1 as binary of 19 s 10011 
		//Loop needs to be run for binary equivalent of the power thus T(n)= O logN 
		//If long numbers are used then use long variable and Use mod 107 to calculate ans
		int ans=1;
		while(n>0) {
			if(n%2!=0) { //AT c++ we can use n&1 to find even or not . C++ gets +1
				//Java work with binary only 
				ans=ans*a;
			}
////////////////////////ALWAYS!!!!!! ------ GIVE WHILE CONTDITION OUTSIDE IF ELSE ------			
			n=n/2;// Divide by 2 can be done buy right shift by 1 -- n>>1
			a=a*a;
		}
		System.out.println(ans+"Power answer");
	}

	public static void ModularArthmeticMethod(long a, long b) {
		//Moulo add
		// a+ b mod n =( a mod n+b mod n)mod n
		//Moulo sub
		// a- b mod n =( a mod n-b mod n)mod n
		//Moulo mul
		// a* b mod n =( a mod n*b mod n)mod n
		//Given n = 10 power 9 + 7 
		long mod_num=(long) (Math.pow(10,9)+7);
		long c=a%mod_num;
		long d=b%mod_num;
		long add=(c+d)%mod_num;
		long sub=(c-d)%mod_num;
		long mul =(c*d)%mod_num;
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		//MOdulardivsion ...
		// a/b mod n can not expressed
		// Modular inverse  - where a/b is found by keeping M as b 
		//  a/b == a/M ...
		//Extended euclidean theorem 
		//ax = 1Mod b   x- is the modular inverse 
		//or inverseto exist a, b must be primes 
		//Primes have GCD one - 1 .. check that 
		//If not prime then return -1 
		long isgcdOne=GCDRecurMod(a,b);
		if(isgcdOne==1) {
		for(int i=0;i<b;i++) {
			if((a*i)%b==1) {
				System.out.println("Modular inverse is "+i);
				break;
			}
		}
		//Fermat theorem 
		//(  a power M-2 ) mod M is the inverse 
		int fermat_raised_to_poer_M_2= (int) Math.pow(a, b-2);
		System.out.println(fermat_raised_to_poer_M_2);
		System.out.println("Inverse is "+(fermat_raised_to_poer_M_2%b));}
		else {
			System.out.println(-1);
		}
	}
	private static long GCDRecurMod(long a, long b) {
		if(b==0) {
			return a;
		}
		return GCDRecurMod(b,a% b);
	}
	public static void ComputingpowerMethod(int a,int n) {
		int n1,x;
		if(n%2==0){
			n1=n/2;
			x=1;
		}
		else {
			n1=(n-1)/2;
			x=a;
		}
		int ans=a;
		for(int i=1;i<n1;i++) {
			ans=ans*a;
		}
		System.out.println((x*ans*ans)+" "+"Is the power of "+a+" to"+n);
		System.out.println(RecursionComputePowerMethod(a,n));
	}

	private static int RecursionComputePowerMethod(int a, int n) {
		if(n==0) {
			return 1;
		}
		int temp=RecursionComputePowerMethod(a, n/2);
		int ans=temp*temp;
		if(n%2==0) {
			return ans;
		}
		else {
			return ans*a;
		}
	}


	public static void SeiveofEratosthenesMethod(int a) {
		int s=a+1;
		boolean array[]=new boolean[s];
		Arrays.fill(array,true);
		for(int i=2;i<=a;i++) {
			if(array[i]) {
				System.out.println(i+" "+"Prime");
				for(int j=i*i;j<=a;j=j+i) {
					array[j]=false;
				}
			}
		}
		//Non efficient
//		Arrays.fill(array, true);
//		for(int i=2;i<=a;i++) {
//			if(array[i]) {
////			boolean isprime=CheckforprimeMethod(i);
////			
////			if(isprime==true) {
////				int k=i;
//				for(int j=2;i*j<=a;j++) {
//					int k=i*j;
//					if(k<=a) {
//					array[k]=false;}
//					else {break;}
//				}
////			}
//			}
//		}
			PrintArray(array);
		
	}

	private static void PrintArray(boolean[] array) {
		int s=array.length;
		for(int i=2;i<s;i++) {
			System.out.println(i+" "+array[i]);
		}
		for(int i=2;i<s;i++) {
			if(array[i]==true) {
			System.out.print(i+" "+";");}
		}
	}


	public static void AllDivisorsMethod(int a) {
		Vector<Integer> vec = new Vector<>();
		int s=(int) Math.sqrt(a);
		int pair=0;
	//	System.out.println(1);
		for(int i=1;i<s;i++) {
			if(a%i==0) {
				pair=a/i;
				if(pair==i) {
				System.out.println(i);}
				else {
					vec.add(pair);
					System.out.println(i);
				}
			}
		}
		for(int i=vec.size()-1;i>=0;i--) {
			System.out.println(vec.get(i));
		}
		
	}

	public static void GPtermMethod(int A,int B,int N)
    {   
		//a*(r)N-1 =84
		//a*(87/84)n-1=84
		//a*
		//GP a,ar,ar2,ar3...
		//GP n term - a*(rpower (N-1))
		
		//AP a,a+d,a+2d,a+3d...
		//AP n term - a+(N-1)*D
		
		float a=A;
		float b=B;
        if(N==1){
            System.out.println(A);
        }
        if(N==2){
            System.out.println(B);
        }
        
        double diff=b/a;
        //diff=diff/zeross;
        double ans=Math.pow(diff,N-1);
//
//        while(start%diff!=0) {
//        	
//        }
//       // int start=A;
//        double diff=Math.divideExact(B, A);
//        double ans=Math.pow(diff,N-1);
        System.out.println(ans+" "+diff);
        System.out.println(A*ans);
    }


	public static void Exactly3divisorsMethod(int a) {
		// The number must have exactly 3 divisors 1 , number itself and a prime number 
		// Condition if number has more than 1 prime number it is not 3 divisor 
		// Only numbers with 3 divisors are square of prime numbers
		//Prime number of n=2 to sqrt.n
		//To find number of prime number ^ 2 less than number  
		//int s=(int) Math.sqrt(a);
		int count=0;
		if(a<4) {
			//System.out.println("Not a three divisor ");
			return;
		}
		if(a>=4) {count++;//}
		System.out.println(4);}
		if(a>=9) { count++;//}
		System.out.println(9);}
		for(int i=5;i*i<=a;i=i+6){
			//System.out.println("Hii");
			int j=(i+2);
			if(CheckforprimeMethod(i) && a>=(i*i)) {
				System.out.println(i);
				count++;
			}
			if(CheckforprimeMethod(j) && a>=(j*j)) {
				System.out.println(j);
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean CheckforprimeMethod(int a) {
//		int b=a-1;
//		int c=a+1;
//		if(b%6==0 || c%6==0) {
//			System.out.println(" iS A PRIME");
//			return true;
//		}
//		else {
//			System.out.println("Not a prime");
//		}
		if(a==2|| a==3 || a==5 ||a==7||a==11 ||a==13) {
			return true;
		}
		if(a==1||a%2==0 || a%3==0 || a%5==0 ||a%7==0||a%11==0 ||a%13==0) {
			//System.out.println("Not a prime");
			return false;
		}
//		if(a==2||a==3) {
//			//System.out.println("Is a prime");
//			return true;
//		}
		int s=(int) Math.sqrt(a);
		for(int i=17;i<=s;i=i+6) {
			if(a%i==0 || a%(i+2)==0) {
			//	System.out.println("Not a prime"+i+" "+i+2);
				return false;
			}
		}
		//System.out.println(" iS A PRIME");
		return true;
	}

	public static void PrimeFactorsMethod(int a) {
		if(a<2) {return;}
		if(a%2==0) {
			System.out.println("2"+" ");
			while(a%2==0) {
				a=a/2;
				if(a==0)
					return;
			}
		}
		if(a%3==0) {
			System.out.println("3"+" ");
			while(a%3==0) {
				a=a/3;
				if(a==0)
					return;
				
			}
		}
		int s=(int) Math.sqrt(a);
		for(int i=5;i<=s;i=i+6) {
			while(a%i==0) {
				System.out.println(i+" ");
				a=a/i;
			}
			while(a%(i+2)==0) {
				System.out.println((i+2)+" ");
				a=a/(i+2);
			}
			if(a==0) {
				return;
			}
		}
		if(a>2) {
			System.out.println(a+"Prime ehh!!!");
			return;
		}
	}
	
}
