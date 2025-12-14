package dynamic_programming;

import java.util.Arrays;

/**
 * 
 * Egg Dropping Puzzle
 * 
 * Given e no of eggs and f no of floors .
 * Floor
 * 6
 * 5
 * 4 Above threshold egg will break
 * 3 Consider 2 threshold floor egg will break
 * 2 egg droped from below will not break
 * 1
 * 
 * Rules :
 * 1) Egg may break from 1st floor also
 * 2) Egg may not break from top floor
 * Given n is floor, threshold floor tf can be 0,n or 0~n
 * n=100 , 0<= tf <= N
 * 3) If an egg breaks from an floor , it will break from higher floor also
 * n=100 , tf = 5 , egg will break from 6 to 100 floors
 * 
 * 
 * To find , Minimum number of Trials in worst case to find the threshold floor
 * 
 * 
 * Example :
 * 
 * Ex1:
 * e=1 , f=10
 * As we only have 1 egg , if we drop from floor 5 and if egg breaks , Can not
 * trial further -_-
 * If no eggs , no further trial
 * Can not find threshold
 * 
 * Given the situation best way to find threshold is dropping egg from each
 * floor
 * 1->2->3->4....
 * Floor egg breaks -1 => threshold floor
 *
 * Consider threshold floor is 1 floor, case scenario trial:1
 * Consider threshold floor is 5 floor, case scenario trial:5
 * Consider threshold floor is 8 floor, case scenario trail:8
 * Consider threshold floor is 10 floor, Worst case scenario: tf=10 , trail=10
 * Thus trails required = 10
 * 
 * Ex2:
 * e=2 , f=10
 * Worst cases :
 * 
 * Considet tf=10
 * We can drop egg at 4 floor , remaining egg=2
 * We can drop egg at 7 floor , remaining egg 2
 * We can drop egg at 9 floor , remaining egg 2
 * Drop at 10 , egg breaks
 * Trails = 4
 * 
 * Consider tf=1
 * We can drop egg at 4 floor egg break , remaining egg=1
 * We can drop egg at 1 floor , remain=1
 * Drp egg from 2 , egg breaks
 * Tf=2 , Trails=3
 * 
 * Consider tf=5
 * Drop egg at floor 4 , remain=2
 * Drop egg at floor 7 breaks , remain= 1
 * Drop egg at floor 5 , remain=1
 * Drop egg at 6 floor , breaks threshold
 * Trial=4
 * 
 * Consider tf=3
 * We can drop egg at 4 floor egg break , remaining egg=1
 * We can drop egg at 1 floor , remaining egg 1
 * We can drop egg at 2 floor , remaining egg 1
 * We can drop egg at 3 floor egg break .
 * Tf=3 trail=4
 * 
 * Worst case Trial = 4
 * 
 * 
 * How to break floor with the amount of egg ?
 * 
 * Recursion solution :
 * 
 * Res(f,e) - min trials needed to find threshold floor in worst case with e
 * eggs and f floor
 * x=f
 * Res(f,e) = Min( Max(Breaks,Does Not Break)) +1
 * x=0 | |
 * Recusive calls for res func
 * 
 * 
 * Loop - Drop egg from 1 to F floor ,
 * Breaks-Find how many trials needed if egg breaks
 * Does Not Breaks-How many trials needed if edd does not break
 * Trails for the floor : Max of breaks and not breaks +1
 * 
 * Minimum no of trials = Min among all floor
 * 
 * for floor = 1 to F ( taking each floor as threshold )
 * Recur two cases
 * 1) egg breaks at the floor --> recur for below floor with 1 less egg x-1,e-1
 * 2) egg doesnt break --> from x ,x+1,x=2.....f need to go to a random pos
 * recur for f-x,e
 * Max trial needed for a floor = Max of (egg break, egg does not break)+1
 * 
 * Minimum trial needed for worst case scenario = Min of max of each floor
 * 
 * 
 * for int i=1 to f recur
 * 
 * Recur :
 * 
 * Base Case:
 * res(f,1)=f 1 egg , so try all floor till f
 * res(1,e)=1 last floor return floor
 * res(0,e)=0 no floor No threshold 0 trials
 * 
 * breaks= res (f-1,e-1)
 * No breaks = res (f+1,e) floor
 * res (f,e) = min breaks,No breaks +1 / \
 * BREAKS f-1,e-1 NO Breaks f-x,e
 * Example : f=10 e=2
 * f=1 res 10,2
 * For i=1 to 10 i=1 i=2 i=3 i=4 ....... i=10
 * / \ / \ / \ / \ / \
 * r 0,1 r 9,2 r1,1 r8,2 r2,1 r7,2 r3,1 r6,2 r 9,1 r 0,2
 * -->1 | -->1 | -->2 | -->3 | -->9 -->0
 * | | | |
 * f=9 res 9,2 res 8,2 ..................................res 1,2
 * For i=1 to 9 i=1 i=2 ...... i=9
 * / \ / \
 * r0,1 r8,2 r 1,1 r 8,2 ......
 * 
 * 
 * Ex
 * f=5 e=3 x= 1 to 2
 * memo 2,2 = 1+ min ( max of memo 0,1, memo 1,2 x=1 )
 * max of memo 1,1 , memo 0,2 x=2 )
 * 
 * memo 3,2 = 1 + min ( max of memo 1,1 & memo 2,2 x=1
 * max of memo 2,1 & memo 1,2 x=2
 * max of memo 3,1 & memo 0,2 x=3 )
 * 
 * 
 * Thus need upper and curr row ans prev col values
 * 
 * 
 * Dynamic table
 * 
 * table[f+1][e+1]
 * 
 * for f=1 fill 1
 * for f=0 fill 0
 * for e=1 fill f
 * 
 * for i=1 to f+1
 * for j= 1 to e+1
 * 
 * int min =Int.max
 * for x=1 to i
 * 
 * break= table[x-1][e-1]
 * no break=table[i-x][e] // i here = f
 * max= max of( break,no break )+1
 * min=Min of min,max
 * 
 * table[f][e]=min
 * 
 * 
 * 
 * @author shree
 *
 */

public class DP21_Egg_Dropping_Puzzle {

	public static void main(String[] args) {
		// Egg Drop puzzle

		int e = 3;
		int f = 5;
		FloorCount = 10;
		// Recur solution
		repeat = new int[f + 1][e + 1];
		int sol = MinimumTrails_Recur(f, e, repeat);
		System.out.println(" Minimum trials " + sol);
		System.out.println(" Repeats .....");
		for (int i = 0; i < f + 1; i++) {
			System.out.println(Arrays.toString(repeat[i]));
		}

		// Memo 2D array
		int memo[][] = new int[f + 1][e + 1];
		// e =1 , value = f
		for (int i = 0; i < f + 1; i++) {
			memo[i][1] = i;// 1 egg , trial= no of floor
		}
		for (int i = 0; i < e + 1; i++) {
			memo[0][i] = 0;// no threshold
			memo[1][i] = 1;// last floor
		}
		sol = MinimumTrails_Memo(f, e, memo);
		System.out.println(" Minimum trial memo " + sol);
		System.out.println(" Memo  .....");
		for (int i = 0; i < f + 1; i++) {
			System.out.println(Arrays.toString(memo[i]));
		}

		// Dynamic table
		sol = MinimumTrails_Table(f, e);
		System.out.println(" Minimum trial table " + sol);
	}

	private static int MinimumTrails_Table(int f, int e) {
		// use table
		int table[][] = new int[f + 1][e + 1];

		for (int i = 0; i < f + 1; i++) {
			table[i][1] = i;// 1 egg , trial= no of floor
		}
		for (int i = 0; i < e + 1; i++) {
			table[0][i] = 0;// no floor
			table[1][i] = 1;// last floor
		}

		for (int i = 1; i < f + 1; i++) { // make each floor as threshold

			for (int j = 1; j < e + 1; j++) { // No of egg

				int min = Integer.MAX_VALUE;
				for (int x = 1; x <= i; x++) {

					int breaks = table[x - 1][e - 1];
					int NoBreak = table[i - x][e];
					int max = Math.max(breaks, NoBreak) + 1;
					min = Math.min(max, min);
				}
				table[i][j] = min;
			}
		}
		System.out.println(" Table ..........");
		for (int i = 0; i < f + 1; i++) {
			System.out.println(Arrays.toString(table[i]));
		}
		return table[f][e];
	}

	private static int MinimumTrails_Memo(int f, int e, int[][] memo) {
		// use memo
		if (memo[f][e] != 0) {
			return memo[f][e];
		}

		if (f <= 0 || e <= 0) {
			return 0;
		}
		/*
		 * Handled in memo
		 * 
		 * 
		 * if(f==1 || f==0) { // last floor or no floor
		 * return f;
		 * }
		 * 
		 * if(e==1) {
		 * return f;// Only 1 egg
		 * }
		 */
		int min = Integer.MAX_VALUE;
		for (int x = 1; x <= f; x++) {
			int breaks = MinimumTrails_Memo(x - 1, e - 1, memo);
			int noBreaks = MinimumTrails_Memo(f - x, e, memo);
			int max = Math.max(breaks, noBreaks) + 1;
			System.out.println(breaks + " -- " + noBreaks + " Max of floor from " + x + " is " + max);
			min = Math.min(max, min);
		}

		memo[f][e] = min;

		return min;
	}

	static int FloorCount;
	static int repeat[][];

	private static int MinimumTrails_Recur(int f, int e, int[][] repeat) {
		// Base cases
		repeat[f][e] = repeat[f][e] + 1;
		// Stop with egg count 1 , no egg count0 or negative
		if (e == 1) {
			return f; // It will take f trials ,
			// when we have only 1 egg 1-->2-->3-->.....--> f : f trials with 1 egg
		}

		// Egg count not needed
		if (f == 0) {
			return 0;// No threshold
		}
		if (f == 1) {
			return 1; // 1 trial needed , irrespective of egg count
		}

		/////////////// EXCEPTIONS .....................................
		if (f < 1) {
			System.out.println(" Error under ground ");
			return f;
		}
		if (f > FloorCount) {
			System.out.println(" Error on toop  floor ");
			return 0;
		} ////////////////////////////////// .............................

		int min = Integer.MAX_VALUE;/// use Max value for miniumum and vice versa
		for (int i = 1; i <= f; i++) {
			// If egg breaks e-1 && check for below floor i-1
			int breaks = MinimumTrails_Recur(i - 1, e - 1, repeat);
			// If egg no break e && go to next point .i=4 f=10 floorcount=10 , next floor is
			// 10-4=6
			int NoBreaks = MinimumTrails_Recur(f - i, e, repeat);

			int ans = Math.max(breaks, NoBreaks) + 1;

			System.out.println(
					" At f " + f + " egg " + e + " No breaks " + NoBreaks + " breaks is " + breaks + " ans " + ans);
			min = Math.min(ans, min);
		}

		return min;
	}

}
