package matrix_MultiArray;

/**
 * Java Multi 
 * 
 * Array is considered as collection of N objects 
 * THere can be diff number of element in individual objects 
 * Ex obj1= 1,2,3,4,5
 *    obj2=6,7,8
 *    obj3=9,10 
 *    
 *    Array of objects : arr[][]={obj1.obj2,obj3};
 *    Objects not stored in contiguous location 
 *    
 * row arr.length 
 * col  arr[i].length
 * 
 * 1) Memory allocation in java is diff from C++
 *     Not contiguous , C++ contiguous
 *  
 * 2) Do not specify the dimensions with array names 
 *         int arr[2][5] is Invalid 
 *         int arr[][5] is also Invalid
 * 
 * Passing a 2D array as an argument to a function allows you to manipulate and process multidimensional data within the function's scope. In Java Passing 2D array to a function has a clean and easy way.Passing a 2D array as an argument to a function allows you to manipulate and process multidimensional data within the function's scope. In Java Passing 2D array to a function has a clean and easy way.
 * 
 * Array in Java

A multi-dimensional array can be termed as an array of arrays that stores homogeneous data in tabular form. 

C++ Return 2D Array From Function - GeeksforGeeks
In this videa we will discuss the following

The general form of declaring 2-dimensional array
Accessing Elements of Two-Dimensional Arrays
Few Important Points 
2D Array with uniform row size
2D Jagged Array with variable Row Sizes
 * 
 * 
 * 
 * Two - dimensional array is the simplest form of a multidimensional array. A two - dimensional array can be seen as an array of one - dimensional array for easier understanding.

Indirect Method of Declaration:
Declaration - Syntax:
data_type[][] array_name = new data_type[x][y];
        For example: int[][] arr = new int[10][20];
        
Initialization - Syntax:
array_name[row_index][column_index] = value;
        For example: arr[0][0] = 1;
        
 * 
 * 
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Matrix02_Java_Intro {

	public static void main(String[] args) {
		
		int arr[][]= {{1,2,3},{4,5,6}};
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		//Jagged pyramid type of array 
		int len=3;
		int arr2[][]= new int[len][];
		for(int i=0;i<len;i++) {
			arr2[i]=new int[i+1];// Pyramid type of array 
			for(int j=0;j<arr2[i].length;j++) {
				arr2[i][j]=i+j;
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
        
		// Passing 2D 
		print(arr);
		print(arr2);
		
         int m = 2, n = 3;
        
    	int arr3[][] = new int[m][n];

    	for(int i = 0; i < arr3.length; i++)
    	{
    		for(int j = 0; j < arr3[i].length; j++)
    		{
    		    arr3[i][j] = 10;
    		    
    			System.out.print(arr3[i][j] + " ");
    		}
    	}
    } 
	
	
	public static void print(int[][] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int	j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
		}
	}


	

}


/*
Implementing Matrix using 2D Arrays in Java

Two - dimensional array is the simplest form of a multidimensional array. A two - dimensional array can be seen as an array of one - dimensional array for easier understanding.

Indirect Method of Declaration:
Declaration - Syntax:
data_type[][] array_name = new data_type[x][y];
        For example: int[][] arr = new int[10][20];
        
Initialization - Syntax:
array_name[row_index][column_index] = value;
        For example: arr[0][0] = 1;
        


Example:


class GFG {
    public static void main(String[] args)
    {

        int[][] arr = new int[10][20];
        arr[0][0] = 1;

        System.out.println("arr[0][0] = " + arr[0][0]);
    }
}

Output:
arr[0][0] = 1






Direct Method of Declaration:

Syntax:

data_type[][] array_name = {
                             {valueR1C1, valueR1C2, ....}, 
                             {valueR2C1, valueR2C2, ....}
                           };

For example: int[][] arr = {{1, 2}, {3, 4}};



Example:


class GFG {
    public static void main(String[] args)
    {

        int[][] arr = { { 1, 2 }, { 3, 4 } };

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                System.out.println("arr[" + i + "][" + j + "] = "
                                   + arr[i][j]);
    }
}

Output:
arr[0][0] = 1
arr[0][1] = 2
arr[1][0] = 3
arr[1][1] = 4




Accessing Elements of Two-Dimensional Arrays


Elements in two-dimensional arrays are commonly referred by x[i][j] where 'i' is the row number and 'j' is the column number.

Syntax:
x[row_index][column_index]


For example:
int[][] arr = new int[10][20];
arr[0][0] = 1;


The above example represents the element present in first row and first column.

Note: In arrays if size of array is N. Its index will be from 0 to N-1. Therefore, for row_index 2, actual row number is 2+1 = 3.

Example:


class GFG {
    public static void main(String[] args)
    {

        int[][] arr = { { 1, 2 }, { 3, 4 } };

        System.out.println("arr[0][0] = " + arr[0][0]);
    }
}

Output:
arr[0][0] = 1




Representation of 2D array in Tabular Format: A two - dimensional array can be seen as a table with 'x' rows and 'y' columns where the row number ranges from 0 to (x-1) and column number ranges from 0 to (y-1). A two - dimensional array 'x' with 3 rows and 3 columns is shown below:

two-d


Print 2D array in tabular format:

To output all the elements of a Two-Dimensional array, use nested for loops. For this two for loops are required, One to traverse the rows and another to traverse columns.

Example:


class GFG {
    public static void main(String[] args)
    {

        int[][] arr = { { 1, 2 }, { 3, 4 } };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}

Output:
1 2 
3 4

*/