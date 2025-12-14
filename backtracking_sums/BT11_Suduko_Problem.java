package backtracking_sums;


/**
 * 
 * Suduko
 * 
 * Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (grid[][]), the task is to find a solved Sudoku. For simplicity, you may assume that there will be only one unique solution.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Zeros in the grid indicates blanks, which are to be filled with some number between 1-9. You can not replace the element in the cell which is not blank.


Suduko :

Fill the empty cells
Row and column and sub cell should not have 1 digit only once 
Grid always square (mostly 9 x 9)

Find 1 possible ans


 * 
 * Naive :
 * 
 * Try all X pow N configuration for given X empty spaces and N*N grid 
 * 
 * Efficient :
 * Use backtracking 
 * Begin with empty cell + a number 
 * Try filling rest of the cells 
 * 
 * Backtracking 
 * for 0,0 to n,n
 * 
 * Permutation :::::::::::::::
 * 
 * For i,j 
 * If val != 0
 *    Permute for next cell i,j+1 ( if col==n , change col=0 , row i=i+1)
 * else 
 *    For k=1 to n+1  & ans Not found 
 *      Check if safe for i,j to place k
 *      if safe :
 *         place in K 
 *         permute  for i,j+1 
 *         remove K , put  pos i,j = 0 
 *      else :
 *        continue 
 *        
 *  At any time  if all values placed , then asnFound will be true 
 *  So avoid going further K values 
 * 
 * 
 * Is Safe cond : i,j,k
 * 1) check if row i already have k 
 * 2) check if col j already have k 
 * 3) check if subset of i,j have k already
 *     1 to n subset 
 *     
 *     Subset Logic :
 *     int s=sqrt of n 
 *     int rowS= i - i%s
 *     int colS= j - j%s
 *     
 *     
 *     for i=0 , i<s
 *         j=0 , j<s
 *          
 *          grid [ i+ rowS][j+ cols]==k
 *       
 *    Example : For 4x4 matrix 4 subset 
 *            1 subset has 4 val , i 0-2 Nand j 0-2 
 *            
 *            For : 2,2 
 *            
 *            s=2     2%2=0
 *            rs= 2
 *            cs= 2
 *            
 *            0,0=> 2,2
 *            0,1=> 2,3
 *            1,0=> 3,2
 *            1,1=> 3,3
 *            
 *            Thus completes 4th subset 
 * 
 * 
 * @author shree
 *
 */

public class BT11_Suduko_Problem {

	
	public static void main(String[] args) {
		
		
		
	
		
		int grid[][]={ {0, 0, 6, 5, 0, 8, 4, 0, 0}, 
		         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		         {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		
		int n=grid.length;
	/*	HashMap<Integer,HashSet<Integer>> hm=new HashMap<>();
		for(int i=0;i<n;i++) {
			hm.put(i,)
		}
		int subset=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
				if(j<3) {
					
				}
				
			}
		}
		*/
		
		///////////////GOG 
		
		

        if (Suduko_GoG(grid, n)) {
            // print solution
            print(grid, n);
        }
        else {
            System.out.println("No solution");
        }
		
		/////////////
		
		 boolean digiR[]=new boolean[10];
         boolean digiC[]=new boolean[10];
         int valr=0;int valc=0;
        for(int i=0;i<n;i++) {
        	digiR=new boolean[10];
            digiC=new boolean[10];
				for(int j=0;j<n;j++) {
					
		valr=grid[i][j];valc=grid[j][i];
		
		if(valr!=0){
		    if(digiR[valr]==true){
		    	System.out.println(" Digi r "+i+"-"+j+" "+valr);
		      //  return false;
		    }
		    else{
		        digiR[valr]=true;
		    }
		}
		if(valc!=0){
		    if(digiC[valc]==true){
		     //   return false;
		    	System.out.println(" Digi c "+i+"-"+j+" "+valc);
		    }
		    else{
		        digiC[valc]=true;
		    }
		}
				}
				
        }
			
	    boolean digi[]=new boolean[10];
       
	    for(int k=0;k<n;k=k+3) {
	    	for(int l=0;l<n;l=l+3) {
	    		digi=new boolean[10];
	    		for(int i=k;i<k+3;i++) {
	    			for(int j=l;j<l+3;j++) {
	    				int val=grid[i][j];
	    				if(val!=0) {
	    					if(digi[val]==true) {
	    						System.out.println(" False in digi "+val+" i-j "+i+" - "+j);
	    					//	ansFound=true;
	    					//	return false;
	    					}
	    					else {
	    						digi[val]=true;
	    					}
	    				}
	    			}
	    		}
	    	}
	    }
        
	  
		ansG=new int[n][n];
		ansFound=false;
				SudokoSolve(grid,n,0,0,0);
		System.out.println(" Ans found is "+ansFound);
		PrintSuduko(ansG,n);
	    
		
		
	}


	static int ansG[][];static boolean ansFound;
	private static void SudokoSolve(int[][] grid, int n, int row,int col,int count) {
		// suduko 
		 
		if(count==n*n && row==n && col==0) {
		
			System.out.println(" Priniting ..........."+col+"---"+row);
			PrintSuduko(grid,n);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					ansG[i][j]=grid[i][j];
				}
			//	System.out.println();
				
			}
			ansFound=true;
		}
		else {
			
			
				int newCol=col+1;int newRow=row;
				if(col==n-1) {
					newRow=row+1;
					newCol=0;
				//	c=0;
				}
				
			//		System.out.println(count+"----->"+row+" "+col+" == "+grid[row][col]);
			if(  grid[row][col]==0) {
				System.out.println("Try--->"+row+" "+col);
					for(int k=1;k<10 && !ansFound;k++) {
					if( IfSafeToAssign(grid,n,row,col,k)) {
						System.out.println("Setting "+k+"----->"+row+" "+col);
						grid[row][col]=k;
						
						
						PrintSuduko(grid,n);
						System.out.println("Setting Next ----->"+newRow+" "+newCol+"---"+(count+1));
						SudokoSolve(grid,n,newRow,newCol,count+1);
					    grid[row][col]=0;
					
						
					}
					}
					
					
					
					}
			else  {
				System.out.println("Setting Next ----->"+newRow+" "+newCol+"---"+(count+1));
				SudokoSolve(grid,n,newRow,newCol,count+1);
				 }
		}
	}
	
	
	private static void PrintSuduko(int[][] grid, int n) {
	// print 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
			
		}
				
	
}

	private static boolean IfSafeToAssign(int[][] grid,int n, int r, int c,int a) {
		// check row 
		for(int i=0;i<n;i++) {
			if(grid[r][i]==a) {
				return false;
			}
			if(grid[i][c]==a) {
				return false;
			}
		}
		
		
		int subi=0;int subj=0;
		if(r<3) {
			subi=0;
			
		}
		else if(r<6) {
			subi=3;
			
		}
		else {
			subi=6;
			
		}
		int subset=subi;
		if(c<3) {
			subj=0;
		}
		else if(c<6) {
			subj=3;
			subset=subset+1;
		}
		else {
			subj=6;
			subset=subset+2;
		}
		
		
		
		
		
		for(int i=subi;i<subi+3;i++) {
		   for(int j=subj;j<subj+3;j++) {	
				if(grid[i][j]==a) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean isSafe(int[][] board, int row, int col, int num) {
// Row has the unique (row-clash)
		for (int d = 0; d < board.length; d++) {

// Check if the number we are trying to
// place is already present in
// that row, return false;
			if (board[row][d] == num) {
				return false;
			}
		}

// Column has the unique numbers (column-clash)
		for (int r = 0; r < board.length; r++) {

// Check if the number
// we are trying to
// place is already present in
// that column, return false;
			if (board[r][col] == num) {
				return false;
			}
		}

// Corresponding square has
// unique number (box-clash)
		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (board[r][d] == num) {
					return false;
				}
			}
		}

// if there is no clash, it's safe
		return true;
	}

	
	public static boolean Suduko_GoG(int[][] board, int n) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;

					// We still have some remaining
					// missing values in Sudoku
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}

// No empty space left
		if (isEmpty) {
			return true;
		}

// Else for each-row backtrack
		for (int num = 1; num <= n; num++) {
			if (isSafe(board, row, col, num)) {
				board[row][col] = num;
				if (Suduko_GoG(board, n)) {
					// print(board, n);
					return true;
				} else {
					// replace it
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
	
	  public static void print(int[][] board, int N)
	    {

	        // We got the answer, just print it
	        for (int r = 0; r < N; r++) {
	            for (int d = 0; d < N; d++) {
	                System.out.print(board[r][d]);
	                System.out.print(" ");
	            }
	            System.out.print("\n");

	            if ((r + 1) % (int)Math.sqrt(N) == 0) {
	                System.out.print("");
	            }
	        }
	    }

}

/*
 * 
 Sudoku Problem

Given a partially filled 9x9 2D array 'grid[9][9]', the goal is to assign digits (from 1 to 9) to the empty cells so that every row, column, and subgrid of size 3x3 contains exactly one instance of the digits from 1 to 9. 




Example: 

Input:
grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
         {0, 0, 5, 2, 0, 6, 3, 0, 0} }
Output:
          3 1 6 5 7 8 4 9 2
          5 2 9 1 3 4 7 6 8
          4 8 7 6 2 9 5 3 1
          2 6 3 4 1 5 9 8 7
          9 7 4 8 6 3 1 2 5
          8 5 1 7 9 2 6 4 3
          1 3 8 9 4 7 2 5 6
          6 9 2 3 5 1 8 7 4
          7 4 5 2 8 6 3 1 9
Explanation: Each row, column and 3*3 box of 
the output matrix contains unique numbers.

Input:    
grid = { { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
         { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
         { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
         { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
         { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
         { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
         { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
         { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
         { 7, 4, 5, 0, 8, 6, 3, 1, 0 } };
Output:
           3 1 6 5 7 8 4 9 2 
           5 2 9 1 3 4 7 6 8 
           4 8 7 6 2 9 5 3 1 
           2 6 3 4 1 5 9 8 7 
           9 7 4 8 6 3 1 2 5 
           8 5 1 7 9 2 6 4 3 
           1 3 8 9 4 7 2 5 6 
           6 9 2 3 5 1 8 7 4 
           7 4 5 2 8 6 3 1 9 
Explanation: Each row, column and 3*3 box of 
the output matrix contains unique numbers.
Method 1: Simple.

Approach: The naive approach is to generate all possible configurations of numbers from 1 to 9 to fill the empty cells. Try every configuration one by one until the correct configuration is found, i.e. for every unassigned position fill the position with a number from 1 to 9. After filling all the unassigned position check if the matrix is safe or not. If safe print else recurs for other cases.

Algorithm: 

Create a function that checks if the given matrix is valid sudoku or not. Keep Hashmap for the row, column and boxes. If any number has a frequency greater than 1 in the hashMap return false else return true;
Create a recursive function that takes a grid and the current row and column index.
Check some base cases. If the index is at the end of the matrix, i.e. i=N-1 and j=N then check if the grid is safe or not, if safe print the grid and return true else return false. The other base case is when the value of column is N, i.e j = N, then move to next row, i.e. i++ and j = 0.
if the current index is not assigned then fill the element from 1 to 9 and recur for all 9 cases with the index of next element, i.e. i, j+1. if the recursive call returns true then break the loop and return true.
if the current index is assigned then call the recursive function with index of next element, i.e. i, j+1
Implementation:


// Java program for above approach
public class Sudoku {

    // N is the size of the 2D matrix   N*N
    static int N = 9;

     // Takes a partially filled-in grid and attempts
   //  to assign values to all unassigned locations in
    // such a way to meet the requirements for
    // Sudoku solution (non-duplication across rows,
    // columns, and boxes) 
    static boolean solveSudoku(int grid[][], int row,
                               int col)
    {

        //if we have reached the 8th
       //     row and 9th column (0
        //    indexed matrix) ,
           // we are returning true to avoid further
          //  backtracking       
        if (row == N - 1 && col == N)
            return true;

        // Check if column value  becomes 9 ,
        // we move to next row
        // and column start from 0
        if (col == N) {
            row++;
            col = 0;
        }

        // Check if the current position
        // of the grid already
        // contains value >0, we iterate
        // for next column
        if (grid[row][col] != 0)
            return solveSudoku(grid, row, col + 1);

        for (int num = 1; num < 10; num++) {

            // Check if it is safe to place
            // the num (1-9)  in the
            // given row ,col ->we move to next column
            if (isSafe(grid, row, col, num)) {

                //  assigning the num in the current
               // (row,col)  position of the grid and
               // assuming our assigned num in the position
               // is correct 
                grid[row][col] = num;

                // Checking for next
                // possibility with next column
                if (solveSudoku(grid, row, col + 1))
                    return true;
            }
            // removing the assigned num , since our
              // assumption was wrong , and we go for next
            //   assumption with diff num value   
            grid[row][col] = 0;
        }
        return false;
    }

    // A utility function to print grid 
    static void print(int[][] grid)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }

    // Check whether it will be legal
    // to assign num to the
    // given row, col
    static boolean isSafe(int[][] grid, int row, int col,
                          int num)
    {

        // Check if we find the same num
        // in the similar row , we
        // return false
        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == num)
                return false;

        // Check if we find the same num
        // in the similar column ,
        // we return false
        for (int x = 0; x <= 8; x++)
            if (grid[x][col] == num)
                return false;

        // Check if we find the same num
        // in the particular 3*3
        // matrix, we return false
        int startRow = row - row % 3, startCol
                                      = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;

        return true;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if (solveSudoku(grid, 0, 0))
            print(grid);
        else
            System.out.println("No Solution exists");
    }
}

Output
3 1 6 5 7 8 4 9 2 
5 2 9 1 3 4 7 6 8 
4 8 7 6 2 9 5 3 1 
2 6 3 4 1 5 9 8 7 
9 7 4 8 6 3 1 2 5 
8 5 1 7 9 2 6 4 3 
1 3 8 9 4 7 2 5 6 
6 9 2 3 5 1 8 7 4 
7 4 5 2 8 6 3 1 9
 Complexity Analysis:  

Time complexity: O(9^(n*n)). 
For every unassigned index, there are 9 possible options so the time complexity is O(9^(n*n)).
Space Complexity: O(n*n). 
To store the output array a matrix is needed.
Method 2: Backtracking. 

Approach: 
Like all other Backtracking problems, Sudoku can be solved by one by one assigning numbers to empty cells. Before assigning a number, check whether it is safe to assign. Check that the same number is not present in the current row, current column and current 3X3 subgrid. After checking for safety, assign the number, and recursively check whether this assignment leads to a solution or not. If the assignment doesn't lead to a solution, then try the next number for the current empty cell. And if none of the number (1 to 9) leads to a solution, return false and print no solution exists.

Algorithm: 

Create a function that checks after assigning the current index the grid becomes unsafe or not. Keep Hashmap for a row, column and boxes. If any number has a frequency greater than 1 in the hashMap return false else return true; hashMap can be avoided by using loops.
Create a recursive function that takes a grid.
Check for any unassigned location. If present then assign a number from 1 to 9, check if assigning the number to current index makes the grid unsafe or not, if safe then recursively call the function for all safe cases from 0 to 9. if any recursive call returns true, end the loop and return true. If no recursive call returns true then return false.
If there is no unassigned location then return true.
Implementation:


// A Backtracking program in
//Java to solve Sudoku problem 
class GFG {
    public static boolean isSafe(int[][] board, int row,
                                 int col, int num)
    {
        // Row has the unique (row-clash)
        for (int d = 0; d < board.length; d++) {

            // Check if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        // Column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++) {

            // Check if the number
            // we are trying to
            // place is already present in
            // that column, return false;
            if (board[r][col] == num) {
                return false;
            }
        }

        // Corresponding square has
        // unique number (box-clash)
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt;
             r++) {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    public static boolean solveSudoku(int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    // We still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // No empty space left
        if (isEmpty) {
            return true;
        }

        // Else for each-row backtrack
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    // print(board, n);
                    return true;
                }
                else {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board, int N)
    {

        // We got the answer, just print it
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }

    // Driver Code
    public static void main(String args[])
    {

        int[][] board
            = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        int N = board.length;

        if (solveSudoku(board, N)) {
            // print solution
            print(board, N);
        }
        else {
            System.out.println("No solution");
        }
    }
}

// This code is contributed
// by MohanDas

Output
3 1 6 5 7 8 4 9 2 
5 2 9 1 3 4 7 6 8 
4 8 7 6 2 9 5 3 1 
2 6 3 4 1 5 9 8 7 
9 7 4 8 6 3 1 2 5 
8 5 1 7 9 2 6 4 3 
1 3 8 9 4 7 2 5 6 
6 9 2 3 5 1 8 7 4 
7 4 5 2 8 6 3 1 9
Complexity Analysis:  

Time complexity: O(9^(n*n)). 
For every unassigned index, there are 9 possible options so the time complexity is O(9^(n*n)). The time complexity remains the same but there will be some early pruning so the time taken will be much less than the naive algorithm but the upper bound time complexity remains the same.
Space Complexity: O(n*n). 
To store the output array a matrix is needed
 * 
 */ 
