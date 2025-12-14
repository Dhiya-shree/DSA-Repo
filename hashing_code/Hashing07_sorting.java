package hashing_code;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

//class sortu implements Comparator<Map.Entry<Integer,Integer>>{
//
//	public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//		// TODO Auto-generated method stub
//		return (o1.getValue() - o2.getValue());
//	}
//
//	
//	
//	
//	
//}
public class Hashing07_sorting {

	public static void main(String[] args) {
		// Problem 2
		
		////////////////////////////////////////////////////////////////////
		 int arr[]= {1,2,2,5,8,3,4,10,3,3,4,5,1,1,1,1,2,2,2,2,2,2,2,8,8,9};
	     int n=arr.length;int val=0;
	     HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	     for(int i=0;i<n;i++) {
			 if(hm.containsKey(arr[i])) {
				val=hm.get(arr[i]);
				val++;
				hm.put(arr[i],val);
			 }
			 else {
				 hm.put(arr[i],0);
			 }
		 }
	     ///////////////////////////////////////////////////////////////////////
	     
	     
	     HashMap<Integer,Integer> hans1=SortAsListOfMap(hm);
	     System.out.println(" Sorted hashmap "+hans1.toString());
	     
	     HashMap<Integer,Integer> hans2=SortAsLambdaMap(hm);
	     System.out.println(" Sorted hashmap "+hans2.toString());
	     
	     HashMap<Integer,Integer> hans3=SortAsLambdaStream(hm);
	     System.out.println(" Sorted hashmap "+hans3.toString());

	}

	 private static HashMap<Integer, Integer> SortAsLambdaStream(HashMap<Integer, Integer> hm) {
		/*
		 *  use streams to sort the map. 
		 *  We will use the stream() method to get the stream of entrySet 
		 *  followed by the lambda expression inside sorted() method to sort the stream and 
		 *  finally, we will convert it into a map using toMap() method.
		 *   Inside the toMap() method, we use the LinkedHashMap::new method reference 
		 *   to retain the sorted order of the map.
		 */
		 HashMap<Integer, Integer> temp
         = hm.entrySet()
               .stream()
               .sorted((i1, i2)
                           -> i1.getValue().compareTo(
                               i2.getValue()))
               .collect(Collectors.toMap(
                   Map.Entry::getKey,
                   Map.Entry::getValue,
                   (e1, e2) -> e1, LinkedHashMap::new));

     return temp;
		
	}

	private static HashMap<Integer, Integer> SortAsLambdaMap(HashMap<Integer, Integer> hm) {
		// use lambda expression for sorting. The logic is the same, and even we also passed the comparator 
		 //object but only using lambda.
			
		// Create a list from elements of HashMap
	        LinkedList<Map.Entry<Integer, Integer> > list= new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
	        System.out.println("Created linked list is "+list.toString());
	 
	        // Sort the list using lambda expression
	        // (o1,o2)-> o1.getValue.compareTo(o2.getValue)
	        //Use comparable 
	        
	        //O1 first - ascending 
	        //O2 first descending 
	        Collections.sort(list,(o1,o2)->o1.getValue().compareTo(o2.getValue()));
	        System.out.println("Ascending Sorted linked list is "+list.toString());
	        
	        Collections.sort(list,(o1,o2)->o2.getValue().compareTo(o1.getValue()));
	        System.out.println("Descending Sorted linked list is "+list.toString());
	        
	        hm.clear();
			//Puting sorted linked list to HM 
			for(Map.Entry<Integer,Integer> mape :list) {
				hm.put(mape.getKey(),mape.getValue());
			}
			System.out.println(" Hashmap sorted is "+hm.toString());
			return hm;
	}

	private static HashMap<Integer, Integer> SortAsListOfMap(HashMap<Integer, Integer> hm) {
		// The idea is to store the entry set in a list and sort the list on the basis of values.
		//Then fetch values and keys from the list and put them in a new hashmap.
		//Thus, a new hashmap is sorted according to values.
		
		// Create a linked list of Map with hashmap.entryset
		
		System.out.println(" Hashmap is "+hm.toString());
		LinkedList<Map.Entry<Integer,Integer>> list=new LinkedList<Map.Entry<Integer,Integer>>(hm.entrySet());
		System.out.println("Created linked list is "+list.toString());
		// Colection sort , giving comparator here itself 
		Collections.sort(list, new Comparator< Map.Entry<Integer, Integer>>() {

			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// Public compare method 
				// O2 first  - descending order 
				// O1 first - ascending order 
				int a=o1.getValue();
				int b=o2.getValue();
				return (b-a);
			}
			
		}
		  	);
		System.out.println("Sorted linked list is "+list.toString());
		hm.clear();
		//Puting sorted linked list to HM 
		for(Map.Entry<Integer,Integer> mape :list) {
			hm.put(mape.getKey(),mape.getValue());
		}
		System.out.println(" Hashmap sorted is "+hm.toString());
		return hm;
	}

	

}


		


/**

Given marks scored out of 100 by a student in subjects where the name of the subject is key and marks scored is the value. Our task is to sort the hashmap according to values i.e. according to marks.
Example: 
 

Input : Key = Math, Value = 98
        Key = Data Structure, Value = 85
        Key = Database, Value = 91
        Key = Java, Value = 95
        Key = Operating System, Value = 79
        Key = Networking, Value = 80

Output : Key = Operating System, Value = 79
         Key = Networking, Value = 80
         Key = Data Structure, Value = 85
         Key = Database, Value = 91
         Key = Java, Value = 95
         Key = Math, Value = 98
Solution: The idea is to store the entry set in a list and sort the list on the basis of values.
 Then fetch values and keys from the list and put them in a new hashmap.
  Thus, a new hashmap is sorted according to values.
Below is the implementation of the above idea: 
 


// Java program to sort hashmap by values
import java.util.*;
import java.lang.*;
 
public class GFG {
 
    // function to sort hashmap by values
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, 
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap 
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
 
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
 
        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        Map<String, Integer> hm1 = sortByValue(hm);
 
        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println("Key = " + en.getKey() + 
                          ", Value = " + en.getValue());
        }
    }
}
Output
Key = Operating System, Value = 79
Key = Networking, Value = 80
Key = Data Structure, Value = 85
Key = Database, Value = 91
Key = Java, Value = 95
Key = Math, Value = 98
 Using Java 8 Lambdas


Here we will change how we did sorting and will use lambda expression for sorting. The logic is the same, and even we also passed the comparator object but only using lambda.

Below is the implementation of the above approach:


// Java program to sort hashmap by values
import java.lang.*;
import java.util.*;
 
public class GFG {
 
    // function to sort hashmap by values
    public static HashMap<String, Integer>
    sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list
            = new LinkedList<Map.Entry<String, Integer> >(
                hm.entrySet());
 
        // Sort the list using lambda expression
        Collections.sort(
            list,
            (i1,
             i2) -> i1.getValue().compareTo(i2.getValue()));
 
        // put data from sorted list to hashmap
        HashMap<String, Integer> temp
            = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
 
        HashMap<String, Integer> hm
            = new HashMap<String, Integer>();
 
        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        Map<String, Integer> hm1 = sortByValue(hm);
 
        // print the sorted hashmap
        for (Map.Entry<String, Integer> en :
             hm1.entrySet()) {
            System.out.println("Key = " + en.getKey()
                               + ", Value = "
                               + en.getValue());
        }
    }
}
Output
Key = Operating System, Value = 79
Key = Networking, Value = 80
Key = Data Structure, Value = 85
Key = Database, Value = 91
Key = Java, Value = 95
Key = Math, Value = 98
Using Streams in Java 8

Here we will use streams to sort the map. We will use the stream() method to get the stream of entrySet followed by the lambda expression inside sorted() method to sort the stream and finally, we will convert it into a map using toMap() method. Inside the toMap() method, we use the LinkedHashMap::new method reference to retain the sorted order of the map.


// Java program to sort hashmap by values
import static java.util.stream.Collectors.*;
 
import java.lang.*;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class gfg3 {
 
    // function to sort hashmap by values
    public static HashMap<String, Integer>
    sortByValue(HashMap<String, Integer> hm)
    {
        HashMap<String, Integer> temp
            = hm.entrySet()
                  .stream()
                  .sorted((i1, i2)
                              -> i1.getValue().compareTo(
                                  i2.getValue()))
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1, LinkedHashMap::new));
 
        return temp;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
 
        HashMap<String, Integer> hm
            = new HashMap<String, Integer>();
 
        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        Map<String, Integer> hm1 = sortByValue(hm);
 
        // print the sorted hashmap
        for (Map.Entry<String, Integer> en :
             hm1.entrySet()) {
            System.out.println("Key = " + en.getKey()
                               + ", Value = "
                               + en.getValue());
        }
    }
}
Output
Key = Operating System, Value = 79
Key = Networking, Value = 80
Key = Data Structure, Value = 85
Key = Database, Value = 91
Key = Java, Value = 95
Key = Math, Value = 98

Whether you're preparing for your first job interview or aiming to upskill in this ever-evolving tech landscape, GeeksforGeeks Courses are your key to success. We provide top-quality content at affordable prices, all geared towards accelerating your growth in a time-bound manner. Join the millions we've already empowered, and we're here to do the same for you. Don't miss out - check it out now!

Last Updated : 06 Apr, 2022

*/