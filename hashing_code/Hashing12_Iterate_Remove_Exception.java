package hashing_code;

public class Hashing12_Iterate_Remove_Exception {

	public static void main(String[] args) {
		// TODOLATER Auto-generated method stub

	}

}


/***


Given a HashMap and a value in Java, the task is to remove an entry from this HashMap using the value, while iterating over it.

Examples:

Input: HashMap: {1=Geeks, 2=ForGeeks, 3=GeeksForGeeks}, value = “ForGeeks”
Output: {1=Geeks, 3=GeeksForGeeks}

Input: HashMap: {1=G, 2=e, 3=e, 4=k, 5=s}, value = k
Output: {1=G, 2=e, 3=e, 5=s}


Using Java 7 and before:
Get the HashMap and the Value
Create an iterator to iterate over the HashMap using HashMap.iterate() method.
Iterate over the HashMap using the Iterator.hasNext() method.
While iterating, check for the value at that iteration to be equal to the value specified. The entry value of the Map can be obtained with the help of entry.getValue() method.
If the value matches, remove the entry of that iteration from the HashMap using remove() method.
The required entry has been successfully removed.
Syntax:

Iterator> 
    iterator = map.entrySet().iterator();

while (iterator.hasNext()) {
    Map.Entry entry = iterator.next();
    if (valueToBeRemoved.equals(entry.getValue())) {
        iterator.remove();
    }
}
Below is the implementation of the above approach:


// Java program to remove an entry using value 
// from a HashMap while iterating over it 
  
import java.util.*; 
  
public class GFG { 
    public static void main(String[] args) 
    { 
  
        // Create a HashMap 
        HashMap<Integer, String> 
            map = new HashMap<>(); 
  
        // Populate the HashMap 
        map.put(1, "Geeks"); 
        map.put(2, "ForGeeks"); 
        map.put(3, "GeeksForGeeks"); 
  
        // Get the value to be removed 
        String valueToBeRemoved = "ForGeeks"; 
  
        // Print the initial HashMap 
        System.out.println("Original HashMap: "
                           + map); 
  
        // Get the iterator over the HashMap 
        Iterator<Map.Entry<Integer, String> > 
            iterator = map.entrySet().iterator(); 
  
        // Iterate over the HashMap 
        while (iterator.hasNext()) { 
  
            // Get the entry at this iteration 
            Map.Entry<Integer, String> 
                entry 
                = iterator.next(); 
  
            // Check if this value is the required value 
            if (valueToBeRemoved.equals(entry.getValue())) { 
  
                // Remove this entry from HashMap 
                iterator.remove(); 
            } 
        } 
  
        // Print the modified HashMap 
        System.out.println("Modified HashMap: "
                           + map); 
    } 
} 
Output:
Original HashMap: {1=Geeks, 2=ForGeeks, 3=GeeksForGeeks}
Modified HashMap: {1=Geeks, 3=GeeksForGeeks}
Using Java 8 lambda expressions:
Get the HashMap and the Value
Get the entry set of this map using HashMap.entrySet() method.
Using lambda expression, remove the entry from the map if the value is equal to the value specified. The entry value of the Map can be obtained with the help of entry.getValue() method.
The required entry has been successfully removed.
Syntax:

map.entrySet()
   .removeIf(
       entry -> (valueToBeRemoved
                    .equals(entry.getValue())));
Below is the implementation of the above approach:


// Java program to remove an entry using value 
// from a HashMap while iterating over it 
  
import java.util.*; 
  
public class GFG { 
    public static void main(String[] args) 
    { 
  
        // Create a HashMap 
        HashMap<Integer, String> 
            map = new HashMap<>(); 
  
        // Populate the HashMap 
        map.put(1, "Geeks"); 
        map.put(2, "ForGeeks"); 
        map.put(3, "GeeksForGeeks"); 
  
        // Get the value to be removed 
        String valueToBeRemoved = "ForGeeks"; 
  
        // Print the initial HashMap 
        System.out.println("Original HashMap: "
                           + map); 
  
        // Remove the specified entry from the Map 
        map.entrySet() 
            .removeIf( 
                entry -> (valueToBeRemoved.equals(entry.getValue()))); 
  
        // Print the modified HashMap 
        System.out.println("Modified HashMap: "
                           + map); 
    } 
} 
Output:
Original HashMap: {1=Geeks, 2=ForGeeks, 3=GeeksForGeeks}
Modified HashMap: {1=Geeks, 3=GeeksForGeeks}

*/