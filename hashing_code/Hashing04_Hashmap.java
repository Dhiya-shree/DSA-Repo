package hashing_code;

/**
 *   JAVA HASHSET 
 *     Use for search , delete and insert operation
 *     Used  to store set of key 
 *     No duplicate key allowed 
 *     Any order possible 
 *     Uses Hashing 
 *     Uses hash func to convert the keys to index in hashtable
 *     Operation add,remove ,contain in O1 time
 *     
 *     HashSet< Object> hash=new HashSet<Object>(Arrays.asliast(arr));// Initialize with Array
 *     // ARR is array , Collection allow to transform 1 to other 
 *     HashSet< Object> hash=new HashSet<Object>(25);// Initialize with initial capacity 
 *     HashSet< Object> hash=new HashSet<Object>();
 *     hash.add(val); return true if added , ignore if already present give false
 *     hash.remove(val); if present return true and remove ; else false
 *     hash.contain(val; true if present 
 *     hash.size() -> return size
 *     hash.isEmpty()-> return true if hashset is empty 
 *     hash.clear()-> Clear the content of hash set 
 *     Above all use O 1 time in average 
 *     
 *     Hashset can not contain duplicate keys 
 *     If passing class , then we should make a hash func in it 
 *     
 *     Traversing in HashMap :
 *     
 *     1) Iterator 
 *     Iterator<String> itr= hash.iterator();
 *     while( itr.hasNext()){
 *     
 *        Syso -> i.next()
 *        
 *        }
 *     
 *     2) Simple for each loop 
 *         
 *         for( String str : hash){
 *          Syso--> str ;
 *          }
 *          
 *     
 *   JAVA HASHMAP :
 *   Implments Map interface 
 *   Uses Hashing 
 *   Used to store set of key - value pair 
 *   Any order possible 
 *   
 *   Initiation and functions :
 *   HashMap<Object(key),Object(val)> hashMap = new  HashMap<Object(key),Object(val)>(10);
 *   Constructor also available to :
 *      1) Specify the load factor 
 *      2) Specify the capacity for optimization
 *      3) Create hashmap from other hashmap 
 *      
 *   HashMap<Object(key),Object(val)> hashMap = new  HashMap<Object(key),Object(val)>();
 *   hashMap.put(key1,val1);
 *   hashMap.size() -> len worst O 1 
 *   hashMap.isEmpty()-> true/false worst O 1   
 *   hashMap.containskey(key)-> check if key is present 
 *   hashMap.remove(key)-> remove given key from hashMap and return its val , if key not present then null
 *   hashMap.conatinsValue(val)-> checks if val is present
 *   hashMap.get(key)-> gives val of given key , if not present null o/p
 *   Above all has time as O 1 
 *   
 *   hashMap.getOrDefault(x,some_val)
 *     -> if xkey is present in hashmap give its value 
 *     ----> If x key not present , give some_val
 *   Traversal:
 *   
 *   1) For each loop :--- Map entry 
 *      for(Map entry<String,Integer> e : hashMap.entrySet()){
 *      
 *          Syso key -> e.getkey();
 *          Syso val--> e.getvalue();
 *          }
 *   
 *          
 * 
 * 
 *  C++ Unordered set - hashing
 *  Same as set , but diff implementation by hashing
 *  unordered_set<int> varnam
 *  Diff output on diff compiler 
 *  Can not add duplicate , will ignore if tried to add 
 *  s.end - point to element after the last eement set , insert , begin , size , clear , find , count ,erase(s.begin,s.end -range of items )
 *  Output of order can be permutation of any order
 *  Time O 1 search insert and delete and above
 *  SEarch , delete , innsert O 1 - works only on KEY .
 *  
 *  C++ Unordered Map 
 *    For key-value pairs 
 *    unordered_map<string(key),int(val)> m;
 *    m["shree"]=888;
 *    No order of keys 
 *    User Hashing 
 *    Only Map-- red black tree
 *    Unordered MAP - hash tree
 *      first(key), second(val),begin,end,erase(key), erase(start number),erase(start,begin)
 *      find - give end if not present,count - similar tofind  1 present , 0 not ;end- pointer to ele after last element 
 *      No ordered , can give any order at anytime
 *    Search insert delete - O1 
 *  
 *  
 * 
 * 
 * 
 * @author shree
 *
 */
public class Hashing04_Hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
