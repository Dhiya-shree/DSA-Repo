package recursion;

public class R01_Print1toN {

	public static void main(String[] args) {
		int n=5;
        Print1toNMethod(n);
        TailRecursionPrint1toNMethod(n);
	}

	private static void Print1toNMethod(int n) {
		if(n==0) {
			return;
		}
		Print1toNMethod(n-1);
		System.out.println(n);
	}
	static int i=1;
	private static void TailRecursionPrint1toNMethod(int n) {
		System.out.println(i);
		if(i==n) {
			return;
		}
		++i;
		TailRecursionPrint1toNMethod(n);
	}

}
