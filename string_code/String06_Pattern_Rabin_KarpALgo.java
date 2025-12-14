package string_code;

import java.util.ArrayList;

/**
 * RABIN KARP ALGORITHM - ROLLING HASH 
 *   Multiple pattern best , if for signle pattern use suffix tree/KMP also 
 *   Multiple patterh simly check with HashSet of patterns hash value 
 *   used for searching / matching pattern 
 *   Uses a hash function 
 *   
 *   Optimized 
 *   Convert the pattern to integer hash value 
 *   Check with the text hash value 
 * 
 *   Hash Value : Simple - ess efficient 
 *   Hash(string )= sum of char value 
 *   Hash("abcdabc")= 0+1+2+3+0+1+2;  a=0; b=1;c=2;d=4;e=5 ....
 *   
 *   COns :
 *   Hash(abc)=a+b+c= 1+2+3=6
 *   Hash(bca)=b+c+a= 2+3+1=6
 *   Hash(cab)=c+a+b= 1+2+3=6
 *   Different string same hash 
 *   
 *   
 *   More efficient hashing :
 *   Hash(string )= sum of char value * D ^ position in string pattern 
 *   D=5
 *   Hash(abc) = a*5^2 + b* 5^1 + c* 5^0 
 *            = 1*25 + 2* 5 + 3* 1 
 *            = 25+10+3
 *            =38
 *            
 *   Hash(bca)= 2*25 + 3*5 + 1*1
 *             = 66
 *   Hash(cab) = 3*25 + 1*5+ 2*1
 *           = 82    
 *   
 *   
 *   p-> hash of pattern 
 *   t-> hash of text 
 *   
 *   if both hash are same 
 *      -> Check for substring and string 
 *      
 * ROLLING HASH -> Simple hashng 
 * 
 * To compute the hash of existing window by using previous hash value 
 * t(i+1)= t(i)-t(i)+ t(i+m);
 * 
 * For large pattern extermely useful 
 * Can check with big O 1 case instead of finding substring at all places 
 * 
 * Cons:
 * Hash value can be the same for different pattern 
 * GOD and DOG are different but same hash value 
 * At such cases need to compute substring 
 * 
 * 
 * ROLLING HASH -> Eficient Hashing 
 *  Hash ( m)= val(m-1)*d^m-1+ val(m-2)*d^m-2+val(m-3)*d^m-3...+val(0)*d^0
 * 
 *  Rolling :
 *  For window i+1 t(i+1)
 *  Decimal arithmetic :
 *     text= "1324567"  1324  3245 2456 4567 
 *     decimal=10,m=4
 *     t0=1324 
 *     t1= 324*10+5
 *       =3245 
 *       
 *    To achive T1 :
 *       t1= ( 1324 - 1*10^3) * 10 + 5 = 3245 
 *       t1= ( t0  - first*d^(m-1) ) * d + new_val 
 *       
 *   Similar was used for hashing 
 *   Hash(string )= sum of char value * D ^ position in string pattern 
 *   D=5
 *   Hash(abc) = a*5^2 + b* 5^1 + c* 5^0 
 *            = 1*25 + 2* 5 + 3* 1 
 *            = 25+10+3
 *            =38
 *  Text abcabca
 *  abc = 38 
 *  For window : bca value must be 66 with D=5 
 *  
 *  D=5 M=3 
 *  Hash abc -->bca window 2
 *  first : a 1
 *  Current : a 1
 *  t1= D* ( t0- ((firstval)*D^(m-1))) + new val a
 *
 *  t1 = 5*( 38 - 1*(5^2) ) + a
 *     = 5*( 38 - 25 ) + 1
 *     = 5* 13 + 1
 *     = 65 + 1
 *     = 66
 *
 *  Horner rule 
 *   To find hash func of the pattern
 *
 * @author shree
 *
 */
public class String06_Pattern_Rabin_KarpALgo {

	public static void main(String[] args) {
		// Rabin Karp algo 

		/*
		 *  Find hash for pattern length m  =>p 
		 *  Find hash for text lengt 0-m => t 
		 *  Val of first string = First 
		 *  for int i=m;i<=n-m
		 *    if(p==t)
		 *       check if values are same 
		 *         if yes - matched 
		 *            
		 *    Find t 
		 *       t= t-first + curr value( char@i)
		 * 
		 */
		String str="CDABCDEFGHIJABCDABCDCDDABCDzzzzzzzzzz";
		String pattern="CD";
		ArrayList<Integer> ans=RabinKarpPattern(str,pattern);
		System.out.println(" Matched "+ans.toString());
		
		//Worst case  O n-m+1 * m 
		// Best / Average O n 
		// To make surevalue does not go negative 
		// Use modulu 1000000+7 
		ans=EfficientRabinKarpPattern(str,pattern);
		System.out.println(" Matched "+ans.toString());
		
		ans=EfficientRabinKarpPatternModulo(str,pattern);
		System.out.println(" Matched "+ans.toString());
		
	}

	private static ArrayList<Integer> EfficientRabinKarpPatternModulo(String str, String pattern) {
		// Use modulo q a prime number 
		int q=101;
		int n=str.length();
		int m=pattern.length();
		int hash=1;// D power m-1 
		int D=256;
		
		//Find hash 
		// The value of h would be "pow(d, M-1)%q"
		for(int i=0;i<m-1;i++) {
			hash=(hash*D)%q;
			//Multyplyibg D ^M-1 with mod q 
		}
		
		ArrayList<Integer> ans=new ArrayList<>();
		int p=0;int t=0;int first=0;
		for(int i=0;i<m;i++) {
			p=((p*D)+pattern.charAt(i))%q;
			t=((t*D)+str.charAt(i))%q;
		}
		System.out.println(" P is "+p+" T is "+t);
		for(int i=m;i<n;i++) {
			
			if(t==p) {
				System.out.println(" Same tp.....");
				if(CheckIfSame(str,i-m,i,pattern)) {
		    		ans.add(i-m);
		    	}
			}
			System.out.println(" First "+(int)str.charAt(first));
			System.out.println(" first * hash "+ str.charAt(first)* hash);
			System.out.println(" T is "+t+ " D * - "+ (t-(str.charAt(first)* hash)));
			System.out.println(" D * val "+ (D*(t-(str.charAt(first)* hash))));
			System.out.println(" D * val + new  "+ ((D*(t-(str.charAt(first)* hash)))+str.charAt(i)));
			//Rolling hash 
			 t=(int) ((D*(t-(str.charAt(first)* hash)))+str.charAt(i))%q;
			first++;
			System.out.println(" T is "+t+" P s "+p);
		    if(t<0) {
		    	t=t+q;
		    }
			
		}
		if(t==p) {
			if(CheckIfSame(str,n-m,n,pattern)) {
	    		ans.add(n-m);
	    	}
		}
		
		return ans;
	}

	private static boolean CheckIfSame(String str, int start, int end, String pattern) {
		//Get str substring and patter 
		String sub=str.substring(start,end);
    	System.out.println(" Sub is "+sub);
    	if(sub.equals(pattern)) {
    	return true;
    	}
    	return false;
    	
		
	}

	private static ArrayList<Integer> EfficientRabinKarpPattern(String str, String pattern) {
		// Rabin Karp Efficient hashing 
				ArrayList<Integer> ans=new ArrayList<>();
				
				int n=str.length();
				int m=pattern.length();
				
				//Find hash forr pattern and text 0-m
				//Hashing D 
				int D=5;
				int first=0;
				int p=0;int t=0;
				//Efficient hashing 
				for(int i=0;i<m;i++) {
					p= (int) (p+(//GetValueForChar
							(pattern.charAt(i))* Math.pow(D,m-1-i)));
					t=(int) (t+(//GetValueForChar
							(str.charAt(i))*Math.pow(D,m-1-i)));
				}
				
				//To check substring same 
				String sub;
				int valFirst=0;
				int ValCurr=0;
				for(int i=m;i<n;i++) {
					valFirst=//GetValueForChar
							(str.charAt(first));
					ValCurr=//GetValueForChar
							(str.charAt(i));
					System.out.println(" T is "+t+" P is "+p);
				    if(t==p) {
				    	//CheckIfSame(str,t-m,t+1,pattern)
				    	sub=str.substring(i-m,i);
				    	System.out.println(" Sub is "+sub);
				    	if(sub.equals(pattern)) {
				    		ans.add(i-m);
				    		System.out.println("Added same ......");
				    	}
				    }
				    
				    //Reconstruct t 
				    //ROLLING HASH  - Efficient hashing 
				    t=(int) (D*(t-(valFirst* Math.pow(D,(m-1))))+ValCurr);
				    first++;
				    System.out.println(" New T formed "+t+" .......");
				}
				if(t==p) {
			    	//CheckIfSame(str,t-m,t+1,pattern)
			    	sub=str.substring(n-m,n);
			    	System.out.println(" Sub is "+sub);
			    	if(sub.equals(pattern)) {
			    		ans.add(n-m);
			    		System.out.println("Added same ......");
			    	}
			    }
				
				return ans;
	}

	private static int GetValueForChar(char ch) {
		
		return (ch-65+1);
	}
	private static ArrayList<Integer> RabinKarpPattern(String str, String pattern) {
		// Rabin Karp
		ArrayList<Integer> ans=new ArrayList<>();
		
		int n=str.length();
		int m=pattern.length();
		
		//Find hash forr pattern and text 0-m 
		int first=0;
		int p=0;int t=0;
		for(int i=0;i<m;i++) {
			p=p+pattern.charAt(i);
			t=t+str.charAt(i);
		}
		
		//To check substring same 
		String sub;
		for(int i=m;i<=n-m;i++) {
			System.out.println(" T is "+t+" P is "+p);
		    if(t==p) {
		    	//CheckIfSame(str,t-m,t+1,pattern)
		    	sub=str.substring(i-m,i);
		    	System.out.println(" Sub is "+sub);
		    	if(sub.equals(pattern)) {
		    		ans.add(i-m);
		    		System.out.println("Added same ......");
		    	}
		    }
		    
		    //Reconstruct t 
		    //ROLLING HASH 
		    // Finding current hash with help of previous hash 
		    t=t-str.charAt(first)+str.charAt(i);
		    first++;
		}
		if(t==p) {
	    	//CheckIfSame(str,t-m,t+1,pattern)
	    	sub=str.substring(n-m,n);
	    	System.out.println(" Sub is "+sub);
	    	if(sub.equals(pattern)) {
	    		ans.add(n-m);
	    		System.out.println("Added same ......");
	    	}
	    }
		
		return ans;
	}

}
