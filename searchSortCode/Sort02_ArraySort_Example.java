package searchSortCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/***
 * SORTING in JAVA
 * 
 * Two types of sorting : 1) Array 2) Collections
 * 
 * For sorting of non primitive ---> Use stable sorting algorithm
 * 
 * ARRAY ---------------normal array ->Array.sort() for primitives ( int
 * [],char[] etc)- Dual Pivot , Quick Sort - No custom Comparator - Use natural
 * order asc ->Array.sort for Objects ( String [],Students[],Integer []etc) -
 * Merge sort , Tim sort adaptation ----> Comparator - separate class for
 * sorting rule of obj -> compare method ----> Comparable - same obj class for
 * sorting rule of obj -> compareTo method They use merge sort for objects as it
 * needs stability . Primitives stability not needed ,so quick sort is used in
 * java COLLECTION -------------for collections ..ONLY non-primitive ->For List
 * , Array List , Linked List : Stability needed ->Merge and Tim sort used To
 * use collection for primitive type - wrapper class is used
 * 
 * Comparator - Comparable :
 * 
 * 1) In same class of object (Stusent) -- implements Comparable<Object> --
 * public int compareTo()
 * 
 * 2) In diff class , Sort code present -- implements comparator<Object> --
 * public int compare() Stablity of sorting -> Stablity not required for
 * primitive -> For non primitive , stablity might be important -----> ex:
 * Consider object student { dept ,mark} Entries
 * :(CS,101),(ECE,102),(CS,105),(IT,106),(CS,200)
 * 
 * After stable sorting algo by dept : (CS,101),(CS,105),(CS,200)-> group CS
 * together and correct order ,(ECE,102),(IT,106)
 * 
 * 
 * Example: 
 * Example 1: https://ide.geeksforgeeks.org/DKl3m1yEI9 
 * Example 2:https://ide.geeksforgeeks.org/QEI4LTVGvO 
 * Example 3:https://ide.geeksforgeeks.org/zOlskD0ci2 
 * Example 4:https://ide.geeksforgeeks.org/feY4eDr3kH 
 * Example 5:https://ide.geeksforgeeks.org/ZnP1TJVHbb 
 * Example 6:https://ide.geeksforgeeks.org/Ne1K1H0528
 * 
 * @author shree
 *
 */

//Class for comparator 
//Student class - Point 
class Point{
	int x,y;
	Point(int i,int j){
		x=i;
		y=j;
	}
}

class Point2 implements Comparable<Point2>{// A user-defined Point class implementing 
	// Comparable interface
	    int x, y;
	    
	    // Costructor intialising x & y
	    Point2(int x, int y)
	    {
	        this.x = x;
	        this.y = y;
	    }
	    
	    // compareTo() function defining the
	    // nature of sorting i.e., according to
	    // x-coordinate
	    public int compareTo(Point2 P)
	    {
	        // Comparing two objects by
	        // Subtracting the passed object 
	        // from current object
	        return this.x - P.x;
	    }
	}

//Comparator da 
class MySort implements Comparator<Point>{
	// Used for sorting in ascending order of
    // roll number
    public int compare(Point a, Point b)
    {
        return a.x - b.x;
    }
}

//Comparator even first , odd next 
class EvenOddSort implements Comparator<Integer>{
	
	public int compare(Integer a,Integer b) {
		System.out.println(" A is "+a+ " A%2 "+(a%2));
		System.out.println(" B is "+b+ " B%2 "+(b%2));
		System.out.println(" Ans "+( (a%2) - (b%2)));
		return ( (a%2) - (b%2));
	}
}
public class Sort02_ArraySort_Example {

	public static void main(String[] args) {
		/*
		 * Arrays.sort()\
		 * The Arrays.sort() is a built-in method in Java of Arrays class which is used to sort an array 
		 * in ascending or descending or any other order specified by the user.
		 *
		 *Syntax:public static void sort(int[] arr, int from_Index, int to_Index)
		 *arr - The array to be sorted.
		 *from_Index - The index of the first element, inclusive, to be sorted.
		 *to_Index - The index of the last element, exclusive, to be sorted
		 *
		 *
		 *Different Sort uses:
		 */
		int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
        ArraySortingTypes(arr);
        
        System.out.println(" Comparator ");
        //Comparator 
        //sort an array according to user defined criteria: 
      	//We use Comparator interface for this purpose. Below is an example.
      	Point [] aru5 = {new Point(10, 20), new Point(3, 12), new Point(51, 7)};
        Arrays.sort(aru5, new MySort());
        // Compare of MySort used
        // Either the Point class should have comparator and implement Comparable 
        //Or any external class must be used by comparable and passed .
        // If not we get - Class cast exception 
        for (int i=0; i<aru5.length; i++)
        	System.out.println(aru5[i].x + " " + aru5[i].y);
        
        //With same class 
        Point2 aru6[] = {new Point2(10, 20), new Point2(3, 12), new Point2(51, 7)};
        Arrays.sort(aru6);
        //CompareTo given in Point2 used 
        // Either the Point class should have comparator and implement Comparable 
        //Or any external class must be used by comparable and passed .
        // If not we get - Class cast exception 
        for (int i=0; i<aru6.length; i++)
        	System.out.println(aru6[i].x + " " + aru6[i].y);
        
      		
        Arrays.sort(aru6,Collections.reverseOrder());
        //CompareTo output reversed and taken  
        // Either the Point class should have comparator and implement Comparable 
        //Or any external class must be used by comparable and passed .
        // If not we get - Class cast exception 
        for (int i=0; i<aru6.length; i++)
        	System.out.println(aru6[i].x + " " + aru6[i].y);
        /**
         * Collections.sort()
         * The Collections.sort() method is present in Collections class. 
         * It is used to sort the elements present in the specified list of Collection in ascending order.
         * It works similar to the Arrays.sort() method but
         * it is better as it can sort the elements of Array
         *  as well as any collection interfaces like a linked list, queue and many more....
         *  
         *  
         *  Syntax:public static void sort(List myList)
         *  myList : A List type object we want to sort.
         *  This method doesn't return anything
         *  
         *  Let us suppose that our list contains
         *  {"Geeks For Geeks", "Friends", "Dear", "Is", "Superb"}
         *  After using Collection.sort(), we obtain a sorted list as
         *  {"Dear", "Friends", "Geeks For Geeks", "Is", "Superb"}
         *  
         *  Below collection usage 
         */
        
        CollectionSortingType();
        
        /*
         * To use collection function for primitive type use - Wrapper class
         * To reverse the sorted array - instead use wrapper class 
         */
        
          Integer arrInte[]= {5,20,10,12};
          Arrays.sort(arrInte,Collections.reverseOrder());
          System.out.println( Arrays.toString(arrInte));
          
          // Odd sort even sort 
          Integer arrInte2[]= {5,20,13,10,12};
          Arrays.sort(arrInte2,new EvenOddSort());
          System.out.println( Arrays.toString(arrInte2));
	}

	private static void CollectionSortingType() {
		// Sorting an arrayList
		ArrayList <String> al = new ArrayList <String>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");

        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
        Collections.sort(al);

        // Let us print the sorted list
        System.out.println("List after the use of" +
                           " Collection.sort() :\n" + al);
		
        
        // Sorting an ArrayList in descending order 
        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
        Collections.sort(al, Collections.reverseOrder());

        // Let us print the sorted list
        System.out.println("List after the use of" +
                           " Collection.sort() :\n" + al);
        
        //Sorting an ArrayList according to user defined criteria:
        //We can use Comparator Interface for this purpose.
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new Sortbyroll());

        System.out.println("\nSorted by rollno");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
        
        
        
	}

	private static void ArraySortingTypes(int[] arr) {
		// Sort ascending 
		Arrays.sort(arr);
        System.out.printf("Modified arr[] : %s",
                          Arrays.toString(arr));
        
        
		// Sort a subarray
        Arrays.sort(arr, 1, 5);
        System.out.printf("Modified arr[] : %s",
                          Arrays.toString(arr));
        
        //Sort descending order
     // Note that we have Integer here instead of
        // int[] as Collections.reverseOrder doesn't
        // work for primitive types.
        Integer[] arr2 = {13, 7, 6, 45, 21, 9, 2, 100};

        // Sorts arr[] in descending order
        Arrays.sort(arr2, Collections.reverseOrder());

        System.out.printf("Modified arr[] : %s",
                          Arrays.toString(arr2));
        
        //Sort string alphabetically 
        
        String arr3[] = {"practice.geeksforgeeks.org",
                "quiz.geeksforgeeks.org",
                "code.geeksforgeeks.org"
		};

       // Sorts arr[] in ascending order
		Arrays.sort(arr3);
		System.out.printf("Modified arr[] : \n%s\n\n", Arrays.toString(arr3));

        // Sorts arr[] in descending order
		Arrays.sort(arr3, Collections.reverseOrder());

		System.out.printf("Modified arr[] : \n%s\n\n", Arrays.toString(arr3));
		
		
	}
	
}

//Class for collection comparator
//A class to represent a student.
class Student
{
 int rollno;
 String name, address;

 // Constructor
 public Student(int rollno, String name,
                            String address)
 {
     this.rollno = rollno;
     this.name = name;
     this.address = address;
 }

 // Used to print student details in main()
 public String toString()
 {
     return this.rollno + " " + this.name +
                        " " + this.address;
 }
}

class Sortbyroll implements Comparator<Student>
{
 // Used for sorting in ascending order of
 // roll number
 public int compare(Student a, Student b)
 {
     return a.rollno - b.rollno;
 }
}
