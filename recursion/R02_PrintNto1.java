package recursion;

//Tail recursion used 
//Tail recursion elimination of compiler will work 
//More space and time efficient
public class R02_PrintNto1 {

	public static void main(String[] args) {
		int n=5;
        PrintNto1Method(n);
	}

	private static void PrintNto1Method(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n);
		PrintNto1Method(n-1);
	}

	

}
