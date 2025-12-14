package hashing_code;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *  Big Universe of value - Difficult to get purfect hash key 
 *  More collisions 
 *  
 *  Birthday Paradox :
 *  If there are 23 people in room , then the probablity of having same birthday for two people is 1/2 50%
 *  If number of people are 70 , then probablity that two are having same birthday is 99.99%
 *       23-> 50%
 *       70->99.99%
 *  
 *  Perfect hashing - offers 0 collision 
 *  Know keys in advance - Perfect hashing 
 *   Can be used in Dictionary 
 *   We can ensure every key is mapped correctly 
 *   
 *  If no knowledge of key collision will happen , Go for 
 *      1) Chaining 
 *      2) Open addressing 
 *            -->Linear Probing 
 *            -->Quadratic Probing 
 *            -->Double Hashing 
 * 
 * CHAINING VS 
 *    1) Hash table never fails
 *    2) Less sensitive to Hash Function 
 *    3) Poor Cache Performance
 *    4) Extra space for links 
 *    5) Two pointer needs even if self balance tre
 *    Performance: 1+Alpha
 *    if 90% table occupied , alpha=0.9 , performance: 1.9
 *    Max comparison : ~2 
 *    
 *    
 * OPEN ADDRESSING 
 *    1) Table may become full and resizing becomes mandatory
 *    2) Extra care required for clustering 
 *    3) Cache Friendly 
 *    4) Extra space might be needed to achieve 
 *          same performance as chaining 
 *    5) No extra space
 *    Performance : 1/(1-alpha)
 *    if 90% table occupied , alpha=0.9 , performance: 1/0.1=10 
 *   Max comparison : ~10
 *   So bigger table required for less comparison , and better performance
 *   
 *   
 * 
 * 1) Chaining 
 *      Best Suited Data Structure :
 *         ---> Linked List (Time to search in length N is O n , Not cache friendly , use extra space to store reference ) 
 *         ---> Dynamic sized tree  ( Array List -Time to search in length N is O n, It is Cache FRiendly)
 *        ( Java 8 uses self balancing tree for Hash Maps)
 *         ---> Self Balancing Tree  (Time to search in length N is O logn , Not cache friendly  ) 
 *                AVL tree
 *                Red Black Tree  
 * 
 * 
 *    Maintain an ARRAY of Linked List 
 *    ArrayList <Linked List> 
 *    
 *    Create a hash key for every value 
 *    m should not be raised to 2^n , it must be an prime 
 *    If we chose 2^n as M , then we will be only considering last n digits for creating has key 
 * 
 *  Hash(Key)=key%7 
 *  7 linked list are needed to be in a array 
 *  We have an array of linked list headers :
 *    Whenever collision happens insert the element at the end of linked list 
 *    
 *  Place elements in the linked list 
 *  If linked list is alredy occupied , add that element in node of linked list 
 *
 *  PERFORMANCE :
 *   m= no of slots m hash table 
 *   n= no of keys to be inserted 
 *   
 *   Load factor alpha= n/m 
 *   Expected chain length = Load factor(n/m)
 *   Expected time to Search :O(1+load factor(n/m))
 *   Expected time to Insert :O(1+alpha(n/m))
 *   Expected time to Delete :O(1+load factor(n/m))
 *   
 *   Expected time to search : O 1 for choosing linked list + O aplha for seraching in linked list 
 *     
 *   Load factor is a parameter mentioning how big the hash table shold be 
 *   Trade off between space and time 
 *   
 * Consider Hash table small and no of linked list members is high : 
 * Load Factor Less---  More Collision 
 * 
 * Consider Hash table array length large and linked list elements less:	`
 * Load Factor High---- less Collision
 * 
 * Expected chain length :
 *  Worst case :All memebers can have same key forming a biggg linked list 
 *  Best case : No member repeated in linked list , all linked list length 1 
 *  Consider Average case :
 *   Uniform Distribution of keys 
 *   Expected Chain length = alpha = load factor = n/m
 *   
 * Ex: Consider uniform distribution 
 * Keys n=500 , m Table size = 500
 * Loaf factor = 1 - low 
 * Expected chain length = 1 ( each linked list 1 element)
 * Expected time = O (1 +1)
 * 
 * Keys n=500 , m Table size = 5
 * Loaf factor = 100 - high 
 * Expected chain length = 100( each linked list 100 element)
 * Expected time = O (1 + nLogN )  // Consider searching in linked list of length N 
 *  
 *  
 * @author shree
 *
 */
public class Hashing02_Collision_Chaining {

	public static void main(String[] args) {
		
		int key[]= {50,21,58,19,15,49,56,56,22,23,25,7,23,81,94,12,11,10,32,67,83,35,64};
		
		//Linked list delete needs to be Integer 
		// Linked List . remove ( int a ) -> remove value in index a 
		// Linked List . remove (Integer a ) -> remove element (Object Integer) a from the List
		
		MyHash mh = new MyHash(7);
	    mh.insert(10);
	    mh.insert(20);
	    mh.insert(15);
	    mh.insert(7);
	    System.out.println(mh.search(10));
	    mh.delete(15);
	    System.out.println(mh.search(15));
	    
	    
		int m_Hash=7;
		
		Chaining chain=new Chaining(key,key.length,m_Hash);
		chain.seeChaining();
		chain.insertChaining(7);
		chain.searchChaining(21);
		chain.deleteChaining(56);
		chain.seeChaining();
		
		
	}

}

class Chaining{
	  int m_hash;
	  ArrayList< LinkedList<Integer>> ans;
	
Chaining(int[] key, int length, int m_Hash) {
	// Get has key for every key and put in chaining fashsion 
	m_hash=m_Hash;
	ans=new ArrayList<LinkedList<Integer>>();
	for(int i=0;i<m_Hash;i++) {
		ans.add( new LinkedList<Integer>());
	}
	//int hashKey=0;
	for(int i=0;i<length;i++) {
		//hashKey=GetHashKey(key[i],m_Hash);
		insertChaining(key[i]);
	}
	
}

public void seeChaining() {
	// Just traverse and see 
	int len=0;
	for(int i=0;i<m_hash;i++) {
		len=ans.get(i).size();
		for(int j=0;j<len;j++) {
			System.out.print(ans.get(i).get(j)+" ");
		}
		System.out.println();
	}
	
}

 void insertChaining(int key) {
	int hashKey=GetHashKey(key,m_hash);
	//LinkedList<Integer> insetLL=ans.get(hashKey);
	//if(ans.get(hashKey).isEmpty()) {
		ans.get(hashKey).add(key);
		return;
	//}
	
//	int first=ans.get(hashKey).getFirst();
//	int last=ans.get(hashKey).getLast();
//	if(key<=first) {
//		ans.get(hashKey).add(key,0);
//	}
//	else  {
//		ans.get(hashKey).add(key);
//	}
	
}

 void searchChaining(int key) {
	int hashKey=GetHashKey(key,m_hash);
	if(ans.get(hashKey).contains(key)){
		System.out.println(" Element is preset ");
	}
	else {
		System.out.println(" Element is NOT preset ");
	}
}

 void deleteChaining(int key) {
	int hashKey=GetHashKey(key,m_hash);
	System.out.println(" Key "+key+" M hash "+m_hash+"...Hash key "+hashKey);
	System.out.println(" Value "+ans.get(hashKey).contains(key)+"..len "+ans.get(hashKey).size());
	if(!ans.get(hashKey).isEmpty()){
	ans.get(hashKey).remove((Integer) key);
	}
}

private static int GetHashKey(int i, int m_Hash) {
	// m_hash is prime  so continue ;)
	int val=i%m_Hash;
	// Modulo gives value in 0 to m_Hash
	return val;
}
}

class MyHash
{
    int BUCKET;
    ArrayList<LinkedList<Integer>> table;
    MyHash(int b)
    {
        BUCKET = b;
        table = new ArrayList<LinkedList<Integer>>();
        for (int i=0; i<b; i++)
           table.add(new LinkedList<Integer>());
    }
    void insert(Integer k)
    {
        int i = k % BUCKET;
        table.get(i).add(k);
    }
    boolean search(Integer k)
    {
        int i = k % BUCKET;
        return table.get(i).contains(k);
    }
    void delete(Integer k)
    {
        int i = k % BUCKET;
        table.get(i).remove(k);
    }
}
