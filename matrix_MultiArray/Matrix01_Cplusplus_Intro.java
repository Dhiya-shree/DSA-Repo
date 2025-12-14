package matrix_MultiArray;

/**
 * Matrix - Multi Dimenisonal Array
 * 
 * Jagged array - each having diff col length 
 * 
 * A multi-dimensional array can be termed as an array of arrays that stores
 * homogeneous data in tabular form. Data in multidimensional arrays is
 * generally stored in row-major order in the memory
 * 
 * 
 * we will discuss the following aspects:
 * 
 * The general form of declaring N-dimensional arrays Size of Multidimensional
 * Arrays Important Points Related to Multidimensional Arrays 
 * The most commonly
 * used forms of the multidimensional array 2D Array Initialization of
 * Two-Dimensional Arrays Accessing Elements of Two-Dimensional Arrays Ways of
 * Creating Multidimensional Arrays in C++ 
 * Double Pointer Method - non cache friendly
 *  Array of Pointers 
 *  Below are Jagged Array
 *  Array of Vectors - scalable colum 
 *  Vector of Vectors - scalable colum and row 3D Array
 *
 * 
 * 
 * 
 * 
 * C++ - row major order
 * 
 * 1) As multi D array are also array they are stred in contengious pattern
 * 
 * Ex arr [3][2] -{{10,20}, {30,40}, {50,60}};
 * 
 * Row Order Major - storing ....
 * 
 * pos: 2000 2002 2003 2004 2005 2006 ... val: 10 20 30 40 50 60 row r1---r1
 * r2----r2 r3----r3
 * 
 * Column Order Major - storing ....
 * 
 * pos: 2000 2002 2003 2004 2005 2006 ... val: 10 30 50 20 40 60 row
 * c1--------c1 c2---------c2
 * 
 * 2)Internal curly brackets are optional
 *
 * int arr[3][2]={10,20,30,40,50,60}; As it is row based oder - it takes 1,20 ;
 * 30,40 ; 50,60
 * 
 * 3) Only the 1st dimension can be omitted in initializing
 * 
 * int arr[3][2]={10,20,30,40,50,60}; int arr[][2]={10,20,30,40,50,60}; both
 * works ...
 * 
 * 
 * 
 * 
 * Passing 2D arrays as arguments in CPP
 * 
 * There are various ways to pass a 2D Array as Argument to a Function. The
 * methods are as follows:
 * 
 * Specifying both row and col size Passing just the col size Globally declaring
 * the row and col size Using Double Pointer Method Using Array of Pointers
 * Method Using Array of Vectors Method Using Vector of Vectors Method
 * 
 * 
 * Specifying both row and col size
 * #include <iostream>
#include <cmath>
#include <bits/stdc++.h> 
#include <climits>
#include <deque>
using namespace std;

void print(int mat[3][2])
{
	for(int i = 0; i < 3; i++)
	{
		for(int	j = 0; j < 2; j++)
			cout << mat[i][j] << " ";
	}
}

int main()
{	
	int m = 3, n = 2;

	int mat[3][2] = {{10, 20},
					 {30, 40},
					 {50, 60}};

	print(mat);

	return 0;
}
 * 
 * Passing just the col size 
 *  #include <iostream>
#include <cmath>
#include <bits/stdc++.h> 
#include <climits>
#include <deque>
using namespace std;

void print(int mat[][2], int m)
{
	for(int i = 0; i < m; i++)
	{
		for(int	j = 0; j < 2; j++)
			cout << mat[i][j] << " ";
	}
}

int main()
{	

	int mat[3][2] = {{10, 20},
					 {30, 40},
					 {50, 60}};

	print(mat, 3);

	return 0;
}
 * 
 * Globally declaring the row and col size
 * #include <iostream>
#include <cmath>
#include <bits/stdc++.h> 
#include <climits>
#include <deque>
using namespace std;

const int R = 3;
const int C = 2;

void print(int mat[R][C])
{
	for(int i = 0; i < R; i++)
	{
		for(int	j = 0; j < C; j++)
			cout << mat[i][j] << " ";
	}
}

int main()
{	

	int mat[R][C] = {{10, 20},
					 {30, 40},
					 {50, 60}};

	print(mat);

	return 0;
}
 * 
 *  Using Double Pointer Method 
 *  #include <iostream>
#include <cmath>
#include <bits/stdc++.h> 
#include <climits>
#include <deque>
using namespace std;

void print(int **arr, int m, int n)
{
	for(int i = 0; i < m; i++)
	{
		for(int	j = 0; j < n; j++)
			cout << arr[i][j] << " ";
	}
}

int main()
{	
	int m = 3, n = 2;

	int *arr[m];

	for(int i = 0; i < m; i++)
	{
		arr[i] = new int[n];

		for(int j = 0; j < n; j++)
		{
			arr[i][j] = i;

			cout << arr[i][j] << " ";
		}
	}


	return 0;
}
 *  
 * Using Array of Pointers Method 
 * 
 * 
 * Using Array of Vectors Method
 * 
 * #include <iostream>
#include <cmath>
#include <bits/stdc++.h> 
#include <climits>
#include <deque>
using namespace std;

void print(vector<int> arr[], int m)
{
	for(int i = 0; i < m; i++)
	{
		for(int	j = 0; j < arr[i].size(); j++)
			cout << arr[i][j] << " ";
	}
}

int main()
{	
	int m = 3, n = 2;

	vector<int> arr[m];

	for(int i = 0; i < m; i++)
	{
		for(int j = 0; j < n; j++)
		{
			arr[i].push_back(i);
		}
	}

	print(arr, m);

	return 0;
}
 *  Using Vector of Vectors Method
 * 
 * #include <iostream>
#include <cmath>
#include <bits/stdc++.h> 
#include <climits>
#include <deque>
using namespace std;

void print(vector<vector<int>> arr)
{
	for(int i = 0; i < arr.size(); i++)
	{
		for(int	j = 0; j < arr[i].size(); j++)
			cout << arr[i][j] << " ";
	}
}

int main()
{	
	int m = 3, n = 2;

	vector<vector<int>> arr;

	for(int i = 0; i < m; i++)
	{
		vector<int> v;

		for(int j = 0; j < n; j++)
		{
			v.push_back(i);
		}

		arr.push_back(v);
	}

	print(arr);

	return 0;
}
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class Matrix01_Cplusplus_Intro {

	/*
	 * Array fixed:
	 * int main()
{
	int arr[3][2] = {{10, 20},
					 {30, 40},
					 {50, 60}};

	for(int i = 0; i < 3; i++)
	{
		for(int j = 0; j < 2; j++)
		{
			cout << arr[i][j] << " ";
		}
	}


	return 0;
}

	 * 
	 * Array Variable:
	 * 
	 * int main()
{	
	int m = 3, n = 2;
	int arr[m][n];


	for(int i = 0; i < m; i++)
	{
		for(int j = 0; j < n; j++)
		{
			arr[i][j] = i + j;
		}
	}

	for(int i = 0; i < m; i++)
	{
		for(int j = 0; j < n; j++)
		{
			cout << arr[i][j] << " ";
		}
	}


	return 0;
	 * 
	 * 
	 * Array Double pointer 
	 * 
	 * int main()
{	
	int m = 3, n = 2;
	int **arr;

	arr = new int* [m];

	for(int i = 0; i < m; i++)
		arr[i] = new int[n];

	for(int i = 0; i < m; i++)
	{
		for(int j = 0; j < n; j++)
		{
			arr[i][j] = 10;	

			cout << arr[i][j] << " ";
		}
	}


	return 0;
}
	 *
	 *Array of Pointer 
	 *
	 *nt main()
{	
	int m = 3, n = 2;

	int *arr[m];

	for(int i = 0; i < m; i++)
		arr[i] = new int[n];

	for(int i = 0; i < 3; i++)
	{
		for(int j = 0; j < 2; j++)
		{
			arr[i][j] = 10;	

			cout << arr[i][j] << " ";
		}
	}


	return 0;
}
	 *
	 *Array of Vector 
	 *
	 *int main()
{	
	int m = 3, n = 2;

	vector<int> arr[m];

	for(int i = 0; i < m; i++)
	{
		for(int j = 0; j < n; j++)
		{
			arr[i].push_back(10);
		}
	}

	for(int i = 0; i < m; i++)
	{
		for(int j = 0; j < n; j++)
		{
			cout << arr[i][j] << " ";
		}
	}


	return 0;
}
	 *
	 *
	 *Vector of Vector 
	 *
	 *int main()
{	
	int m = 3, n = 2;

	vector<vector<int>> arr;

	for(int i = 0; i < m; i++)
	{
		vector<int> v;

		for(int j = 0; j < n; j++)
		{
			v.push_back(10);
		}

		arr.push_back(v);
	}
	 *
	 *
	 *
	 */
	
	/**
	 * 2D Vector in C++

Matrix in C++ can be implemented using 2D arrays or Vectors. Just like arrays, 2D vectors means vector of vector.

Normal Vector Declaration:
vector< data_type > vec_name;



2-D Vector Declaration:
vector< vector < data_type > > vec_name;



Calculating the number of rows and columns:
The number of rows in a 2D Vector can be found by calculating the size of the outer vector as vec_name.size().
The number of items in each row of a 2D Vector can be found by calculating the size of each row as vec_name[i].size().


Below program illustrate 2D vectors by declaring and printing all elements of a 2D vector:

// C++ code to demonstrate 2D vector 
#include <iostream> 
#include <vector> // for 2D vector 
using namespace std; 
  
int main() 
{ 
    // Initializing 2D vector "vect" with 
    // values 
    vector<vector<int> > vect{ { 1, 2, 3 }, 
                               { 4, 5, 6 }, 
                               { 7, 8, 9 } }; 
  
    // Displaying the 2D vector 
    for (int i = 0; i < vect.size(); i++) { 
        for (int j = 0; j < vect[i].size(); j++) 
            cout << vect[i][j] << " "; 
        cout << endl; 
    } 
  
    return 0; 
} 
Output:
1 2 3 
4 5 6 
7 8 9 



Note: The functions of vector can be used with 2D vectors as well.
	 * 
	 * 
	 */
}
