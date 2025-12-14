package impAlgorithm_array_search;

/***algo
 * Brian Kernighan’s Algorithm: 
Subtracting 1 from a decimal number flips all the bits after the rightmost set
 bit(which is 1) including the rightmost set bit. 
for example : 
10 in binary is 00001010 
9 in binary is 00001001 
8 in binary is 00001000 
7 in binary is 00000111 
So if we subtract a number by 1 and do it bitwise & with itself (n & (n-1)), 
we unset the rightmost set bit. If we do n & (n-1) in a loop and 
count the number of times the loop executes, we get the set bit count. 
The beauty of this solution is the number of times
 it loops is equal to the number of set bits in a given integer. 
 * 
 *
 */
public class BrianKurningam_Algo_CountTotalSetBits {
	
	//Instead of if(n&1!0)
	//////          count++;
	//USE
	////////// count=count+(n&1);
public static void main(String[] args) {
	int n=220254;
	NaiveCountSetBits(n);
	EfficientCountofSetBits(n);
	CountOfAllBitsTillN(n);
	
}
    public static int table[] = new int[256];
	public static int table2[] = new int[256];

    private static void CountOfAllBitsTillN(int n) {
		/*
		 * 1-1
		 * 2-1
		 * 3-2
		 * 4-1
		 * 5-2
		 * 6-2
		 */
    	TableWithTotalSumOfBIts();
    	int a=n&255;
		n=a;
		int b=(n<<8)&255;
		n=b;
		int c=(n<<16)&255;
		n=c;
		int d=(n<<24);
		System.out.println("A"+a+"TABLE"+table2[a]+" B"+b
				+"TABLE"+table2[b]+" C"+c
				+"TABLE"+table2[c]+" D"+d+"TABLE"+table2[d]);
		System.out.println("Ans=" +( table2[a]+table2[b]+table2[c]+table2[d]));
	}
	private static void TableWithTotalSumOfBIts() {
		// Has sum of bits
		table2[0]=0;
		for(int i=1;i<256;i++) {
			table2[i]=table2[i-1]+table[i];
			System.out.println(i+" "+table2[i]);
		}
		
	}
	private static void EfficientCountofSetBits(int n) {
       //initialize table with 256 count values 
		CreateTableWith256();
        // or 
		EfficientCreateTableWith256();
		//Use 0xff or 255
		int a=n&255;
		n=a;
		int b=(n<<8)&255;
		n=b;
		int c=(n<<16)&255;
		n=c;
		int d=(n<<24);
		System.out.println("A"+a+"TABLE"+table[a]+" B"+b
				+"TABLE"+table[b]+" C"+c
				+"TABLE"+table[c]+" D"+d+"TABLE"+table[d]);
		System.out.println("Ans=" +( table[a]+table[b]+table[c]+table[d]));
	}

	private static void EfficientCreateTableWith256() {
		// Check if odd or even 
		//Remove the last bit and move 1 bit to right n>>1 or N/2
		// Use the count of bit of n/2 number 
		// Ex for 15 - 1111
		// 15&1 = 1 
		// 15>>1 or 15/2= 7
		// 7 = 3 bits (111)  -- total - 4 
		table[0]=0;
		for(int i=1;i<256;i++) {
			table[i]=table[i>>1]+(i&1);
			System.out.println(i+" "+table[i]);
		}
		
	}

	private static void CreateTableWith256() {
		// Count of bits in 15 = count of bits in 8 and 7 = 1 and 3 = 4 bits 
		// Creating a table for 0 to 255
		//Table(7)=1
		// Table [15] = table(7)+ 1
		// Table[15] = table ( 15&14) +1
		// Table [15] = table (n & (n-1))+1
		table[0]=0;
		for(int i=1;i<256;i++) {
			table[i]=table[(i &(i-1))]+1;
			//System.out.println(i+" "+table[i]);
		}
		
	}

	private static void NaiveCountSetBits(int n) {
		int count =0;
		System.out.println("n & n-1 gives the set bit 1st");
		System.out.println("Repetive n&n-1 if esult 1 - count ++ and "+
		"continue reduceing n =n&n-1");
		while(n>0) {
			n=n&(n-1);
			count=count+1;
			System.out.println(n+" "+count);
		}
		System.out.println("Count"+count);
	}
}
/**
 * 1101
 * 1100
 * 
 * 
 * /
 */