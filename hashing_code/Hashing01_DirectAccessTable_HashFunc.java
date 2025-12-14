package hashing_code;
/**
 * 
 * Direct Address Table :
 *  For range of 0 to 999 / for small range 1000 to 999
 *  We cab use array of 1000 length to store variable 
 *  With index as key , we an access insert search / delete a element 
 * 
 * Cons:
 *  Can not work for large range 
 *  Wont work for String 
 *  Wont work for floating point numbers 
 *  
 * Hash Function can be used :
 *     For large range, Stringf and floating point 
 *     
 *  Hash func can convert the values to key 
 *  It should not take more than O log N to create key using hash function 
 *  
 *  1) For numbers of large range - modulo can be used 
 *             hash of element :element/m
 *             m should not be raised to 2^n , it must be an prime 
 *             If we chose 2^n as M , then we will be only considering last n digits for creating has key 
 * 
 *  2) For string , use exponential mul 
 *  Abcd - int val A*x^0 + b*x^1 + c*x^2 + d*x^3..
 *  
 *  3) Universal hash function 
 * 
 * 
 * @author shree
 *
 */
public class Hashing01_DirectAccessTable_HashFunc {

	public static void main(String[] args) {
		
		// Key f 0 to 99 
		boolean arr[]=new boolean[100];
		
		for(int i=0;i<80;i=i+4) {
		insert(arr,i);
		}
		
		boolean ans=search(arr,8);
		System.out.println(" Present is "+ans);
		
		Delete(arr,8);
		
		ans=search(arr,8);
		System.out.println(" Present is "+ans);
		
	}

	private static void Delete(boolean[] arr, int i) {
		// O 1 set as flase to remove
		arr[i]=false;
		
	}

	private static boolean search(boolean[] arr, int i) {
		// O1 true if present 
		return arr[i];
	}

	private static void insert(boolean[] arr, int i) {
		// O 1 insert 
		arr[i]=true;
		// Inserting as present 
		
	}
}

/**
Direct Address Table is a data structure that has the capability of mapping records to their corresponding keys using arrays. In direct address tables, records are placed using their key values directly as indexes. They facilitate fast searching, insertion and deletion operations. 

We can understand the concept using the following example. We create an array of size equal to maximum value plus one (assuming 0 based index) and then use values as indexes. For example, in the following diagram key 21 is used directly as index. 

 

hmap

 Advantages:

Searching in O(1) Time: Direct address tables use arrays which are random access data structure, so, the key values (which are also the index of the array) can be easily used to search the records in O(1) time.
Insertion in O(1) Time: We can easily insert an element in an array in O(1) time. The same thing follows in a direct address table also.
Deletion in O(1) Time: Deletion of an element takes O(1) time in an array. Similarly, to delete an element in a direct address table we need O(1) time.
 
Limitations:

Prior knowledge of maximum key value
Practically useful only if the maximum value is very less.
It causes wastage of memory space if there is a significant difference between total records and maximum value.
Hashing can overcome these limitations of direct address tables. 

How to handle collisions? 
Collisions can be handled like Hashing. We can either use Chaining or open addressing to handle collisions. The only difference from hashing here is, we do not use a hash function to find the index. We rather directly use values as indexes

*/