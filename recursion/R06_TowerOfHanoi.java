package recursion;

public class R06_TowerOfHanoi {

	public static void main(String[] args) {
		// Tower of hanoi
        int n=5;// no of disc 
		long ans=toh(n,1,3,2);
		// A 1   C3   B 2 
		/*
		Shift ‘N-1’ disks from ‘A’ to ‘B’, using C.
		Shift last disk from ‘A’ to ‘C’.
		Shift ‘N-1’ disks from ‘B’ to ‘C’, using A.

		 */
		System.out.println(" Number of shifts needed "+ans);
	}

	public static long toh(int n, int from, int to, int aux) {
		//   1       3        2 
		//  A        C        B 
		if(n<=0){
			return 0;
		}

		long ans=toh(n-1,from,aux,to);
		ans=ans+1;
		System.out.println("move disk "+(n)+" from rod "+from+" to rod "+to);
		ans=ans+toh(n-1,aux,to,from);
		return ans;
	}

}

/*

Tower of Hanoi

Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C) and N disks. Initially, all the disks are stacked in decreasing value of diameter i.e., the smallest disk is placed on the top and they are on rod A. The objective of the puzzle is to move the entire stack to another rod (here considered C), obeying the following simple rules: 

Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
No disk may be placed on top of a smaller disk.
Examples:

 

Input: 2
Output: Disk 1 moved from A to B
Disk 2 moved from A to C
Disk 1 moved from B to C

Input: 3
Output: Disk 1 moved from A to C
Disk 2 moved from A to B
Disk 1 moved from C to B
Disk 3 moved from A to C
Disk 1 moved from B to A
Disk 2 moved from B to C
Disk 1 moved from A to C

 

Tower of Hanoi using Recursion:
 The idea is to use the helper node to reach the destination using recursion. Below is the pattern for this problem:

Shift ‘N-1’ disks from ‘A’ to ‘B’, using C.
Shift last disk from ‘A’ to ‘C’.
Shift ‘N-1’ disks from ‘B’ to ‘C’, using A.
Lightbox
Follow the steps below to solve the problem:

Create a function towerOfHanoi where pass the N (current number of disk), from_rod, to_rod, aux_rod.
Make a function call for N – 1 th disk.
Then print the current the disk along with from_rod and to_rod
Again make a function call for N – 1 th disk.
Below is the implementation of the above approach.


// JAVA recursive function to
// solve tower of hanoi puzzle
import java.io.*;
import java.math.*;
import java.util.*;
class GFG {
	static void towerOfHanoi(int n, char from_rod,
							char to_rod, char aux_rod)
	{
		if (n == 0) {
			return;
		}
		towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
		System.out.println("Move disk " + n + " from rod "
						+ from_rod + " to rod "
						+ to_rod);
		towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
	}

	// Driver code
	public static void main(String args[])
	{
		int N = 3;

		// A, B and C are names of rods
		towerOfHanoi(N, 'A', 'C', 'B');
	}
}

Output
Move disk 1 from rod A to rod C
Move disk 2 from rod A to rod B
Move disk 1 from rod C to rod B
Move disk 3 from rod A to rod C
Move disk 1 from rod B to rod A
Move disk 2 from rod B to rod C
Move disk 1 from rod A to rod C
Time complexity: O(2N), There are two possibilities for every disk. Therefore, 2 * 2 * 2 * . . . * 2(N times) is 2N
Auxiliary Space: O(N), Function call stack space

*/