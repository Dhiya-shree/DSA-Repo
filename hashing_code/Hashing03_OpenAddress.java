package hashing_code;

import java.util.ArrayList;

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
 *            -->Linear Probing    Load factor must be 1 : 100 element 100 slot
 *            -->Quadratic Probing Load factor must be <0.5 : 100 element 200 slot minimum
 *            -->Double Hashing 
 * 
 * Open Addressing:
 *   --> Number of slots in hash table must be greater than keys to be inserted 
 *   --> m > n
 *   --> Cache Friendly  -> as everything in same array fewer misses
 *   
 *   
 *  1) Linear Probing 
 *  
 *  Insert:
 *     Hash Func : Hash(Key)=Key%7;
 *     Consider : 50,51,49,16,56,15,19
 *     Mapping :   1, 2, 0, 2 -- Collision 
 *     
 *    Whenever there is collision , search linearly for next empty slot 
 *    Use next emplt slot 3 for 16 
 *    Consider : 50,51,49,16,56,15,19
 *    Mapping :   1, 2, 0, 3, 0 -- Collision 
 *    
 *    Linearly search next empty spot for 56 - 4
 *    Consider : 50,51,49,16,56,15,19
 *    Mapping :   1, 2, 0, 3, 4, 1-- Collision 
 *   
 *    Linearly search next empty spot for 15 - 5
 *    Consider : 50,51,49,16,56,15,19
 *    Mapping :   1, 2, 0, 3, 4, 5, 5 -- Collision 
 *    
 *    Linearly search next empty spot for 19 - 6
 *    Consider : 50,51,49,16,56,15,19
 *    Mapping :   1, 2, 0, 3, 4, 5, 6 -- MAPPED 
 *    
 *  If last element is also occupied search in circular manner .  
 *  At least one spot will be empty , given m>n
 *  
 *  
 *  For below : Stopping conditions :
 *      1) Empty index slot not for slot marked as deleted 
 *      2) Key found 
 *      3) Traversed through whole table 
 *    
 *  For Search:
 *   
 *   1) Find the index using hash func key%7 
 *   2) -->If the hash index have the element - return true
 *     --> If the hash index did not have the element
 *             Search linearly till you encounter the key ->return true 
 *            or again came to same slot circularly  --> return false 
 * 
 *  For Delete:
 *    DO NOT simply remove the element , mark as delete 
 *   1) Find the index using hash func key%7 
 *   2) -->If the hash index have the element -mark as delete -1
 *     --> If the hash index did not have the element
 *             Search linearly till you encounter the key ->mark as delete -1
 *            or again came to same slot circularly  --> Element not present
 *  
 *  
 *  If more number of values have same index -> cluster size also increase
 *  
 *  Three numbers having index 0 , 7,14,21 
 *  Then it will occupy contiguous location 0,1,2 
 *  and form a cluster of index 0 in range 0-3
 * 
 *  So if there are K element with same index, cluster size is K+1
 *  PERFORMANCE :
 *  
 *  1) If cluster size is very high , then on average for search,insert ,delete 
 *          O ( K+1+1) where K is cluster size 
 *       Because till we find element / empty slot we keep on searching.
 *       
 *  
 *  Linear Probing has Cluster Problem : Solution ?
 *      Modifying Hash function to give different index 
 *        Linear Probing: Hash(key)= (key+i)%m 
 *         i --> element already present 
 *    
 *  1) Quadratic Probing - Secondary cluster 
 *       Load factor must be less than alpha<< 0.5 
 *       Number of slot should be greater twice the elements at least
 *       m -> Must be a prime number 
 *       m -> No of slots n-> No of elements 
 *       
 *       
 *       Hash(key)= ( key+ i^2)% m 
 *       If collision happen go to second slot ..
 *       If next time collision 4 slot 
 *       .. More the collision , more spacing between slot 
 *       No Primary Clusters , but still have cluster Secondary 
 *       Because Probe sequence is fixed ..
 *         Every time see a collision same sequence
 *       
 *       Cons:- Might not find empty slot as termination condition 
 *       For index i=1  1 2 3 4 5 6 7 8 16
 *                 i=2    2   4         16
 *                 i=4        4         16
 *                 i=8                8    64 
 *           With some , some index can have same probe sequence 
 *           So we can not decide with empty slot 
 *       
 *  
 *  2) Double Hashing 
 *      Hash(key)= ( H1(key)+ i* H2(key) )% m
 *          H1(key)--> Original func key%m 
 *          H2(key)--> For finding next slot that is empty
 *                          6 - (key%6) 
 *                      6 & m should be pime 
 *                      
 *   Pseudo Algo :
 *   
 *     if( table is full)
 *          --> Return error 
 *      
 *     index-H1Key= key%m 
 *     offset-H2Key= (m-1)-key%(m-1)
 *     
 *     // if offset is 1 , then it will become linear probing 
 *     
 *     // Instead of multiply , add multiple times 
 *     while( table[index] is not empty){
 *          index= ( index+offset) % m   }
 *      
 *     table[index]= key;
 *                      
 *   Requirement :
 *    1) M and H2 (key) should be relatively prime , to find the free slot 
 *                Relative prime number - give unique and all number when relative prime 
 *                
 *         So H2 function - will give all extra empty spots for diff i 
 *         if no element i=0 
 *         
 *         If element present i will increase 
 *         By m for H1 and m-1 for H2 , all slots will be checked 
 *         
 *   For m= 7 , m-1=6 , 7 & 6 are relatively prime
 *   
 *   6%7 is 1 :  (1*6)%7=6
 *               (2*6)%7=5
 *               (3*6)%7=4
 *               (4*6)%7=3
 *               (5*6)%7=2
 *               (6*6)%7=1
 *               0 first slot already have value 
 *              
 *         
 *   Pros : 
 *   If m is relatively prime in H2(key) function no need for double size.
 *   Works with n slots for n elements 
 *   Avoids clustering 
 *   Distributes key more uniformly compared to Linear and Quadratic probing 
 *   
 *   Example : 
 *   For arr - 49,63,56,52,54,48 
 *   Take m=7 >=n
 *   H1(key) = Key%7 
 *   H2(key) = 6-(key%6)
 *   Above has 6- key%m - to avoid 0 value 
 *   Hash(key)= ( H1(key)+ i* H2(key) )% m  H2(key) -> should not be 0 , if not become linear probing 
 *   If we have 0 value then we will keep probing the same index
 *   
 *   1) For first occur i=0 , H1 func only for ele 9 index : 2
 *   2) If any index has element 
 *       index=2  ele 16 collision occur i =1
 *       16%7 + (1)*(6 - 16%6)= 2+(6-4)=2+2 = 4 
 *       If index 4 empty put in index 4 
 *       
 *   3) Second time same index element 23
 *        index= 2 i=2   
 *        23%7 +(2)* (6- 23%6)= 2+ 2*(6-5) 
 *        = 2+2 = 4 
 *        
 *        At index 4 element already preset 
 *         23%7 +(3)* (6- 23%6)= 2+ 3*(6-5) 
 *        = 2+3 = 5 
 *        
 *        Put in index 5 and so on....
 *       
 *  Double hashing is an advanced Open addressing technique that effectively mitigates clustering.
 *  By employing two distinct hash functions, it optimizes the probing sequence 
 *  by utilizing one function for generating the index and the other for determining the increments  
 *   
 *  PERFORMANCE :
 *  
 *   Load factor n/m should be <= 1
 *   Every probe sequence looks at a random location 
 *   (1-alpha)fraction of table empty , no of probes :
 *   
 * 
 *   Search :
 *  
 *   If unsuccessful to find in first time 
 *     and no empty slot 
 *     
 *   Expected no of probes required = 1/(1-alpha)
 *   
 *   As alpha tends to 1 , it tends to infinite mathematically .
 *   
 *     
 *   1) If probe sequence finds a point randomly
 *        Alpha = n/m should be <= 1
 *     (1-alpha) Fraction of the table is empty
 *       
 *      If alpha is 0.8 and 1-alpha is 1-0.8=0.2
 *      0.8 will be occupied ; 0.2 will not be occupied 
 *      
 *      So 20% of slots are empty slot , 
 *        So 1/5 of slots are empty ...
 *   If alpha is 0.8 then no.of unsuccessful search before finding element is 5 
 *        
 *    0.9 , no of probe for unsuccessful search : 10% 1/10 ,
 *    10 unsuccessful probe 
 *   
 *    0.99 , no of probe for unsuccessful search : 1/100 ,
 *    100 unsuccessful probe 
 *    
 *    1 --> Infinite 
 *    
 *    
 * 
 * @author shree
 */


public class Hashing03_OpenAddress {

	public static void main(String[] args) {
		// User gives no of data 
		
		// Hashmap dont use actual key to store at the slots 
		// In C++ they use pointer 
		// In Java they use reference as key to store value 
		// Thus empty can be quickly checked by checking Null 
		
		//Thus for insert/serach 
		   // If they reference is null -> empty slot not present
		
		//For Deletion
		  // Use a dummy node inside a class 
		//  Store the reference in the dummy node after deleting
		// To check for deleted check in dummy 
		
		
		int arr[]= {23,54,12,6,89,31,42,61,64,7,14,28};
	    int m_hash=7;
	    int n=arr.length;
	    
	    
	    Linear_Probe_OpenAddress LinearProbe= new Linear_Probe_OpenAddress(arr, m_hash, n);
	    for(int i=0;i<n;i++) {
	    	LinearProbe.insert(arr[i]);
	    }
	    LinearProbe.search(12);
	    LinearProbe.View();
	    LinearProbe.delete(12);
	    LinearProbe.View();
	    
	    
	    DoubleHashing_OpenAddress DoubleHash= new DoubleHashing_OpenAddress(arr, m_hash, n);
	    for(int i=0;i<n;i++) {
	    	DoubleHash.insert(arr[i]);
	    }
	    DoubleHash.search(12);
	    DoubleHash.View();
	    DoubleHash.delete(12);
	    DoubleHash.View();
	    
	    
	   
	    
	    
	    Quadratic_Probe_OpenAddress QuadraticProbe= new Quadratic_Probe_OpenAddress(arr, m_hash, n);
	    for(int i=0;i<n;i++) {
	    	QuadraticProbe.insert(arr[i]);
	    }
	    QuadraticProbe.search(12);
	    QuadraticProbe.View();
	    QuadraticProbe.delete(12);
	    QuadraticProbe.View();
	    
	    
	}
}

class DoubleHashing_OpenAddress{
	//index-H1Key= key%m 
	//offset-H2Key= (m-1)-key%(m-1)
	ArrayList<Integer> table=new ArrayList<Integer>();
	int TableLen;
	int mHash;
	int index;
	int set;
	int alpha_count;
	
	DoubleHashing_OpenAddress(int arr[],int m,int len){
		//Consider 0.8 load factor - Quadratic 
		double alpha=(len/m);
		TableLen=(int) (len/alpha);
		mHash=m;
		System.out.println(" Len of arr "+len+" aTable len "+TableLen);
		// Expected probe = 1/ (1-alpha)
		// Took alpha of0.8
		alpha_count= (int) (1/(1-alpha));
		for(int i=0;i<TableLen;i++) {
			table.add(-1);
		}
		set=0;
				
	}
	
	public void View() {
		// View array 
		System.out.println(" View array list ");
		System.out.println(table.toString());
		
	}

	void insert(int ele){
		
		index=DoubleHashing(ele);
		System.out.println(" Index suggested for "+ele+" is "+index+"..and set "+set);
		if(table.get(index)==-1) {
			table.set(index,ele);
			set=0;
			return;
		}
		while(table.get(index)!=-1 ) {
			index=DoubleHashing(ele);
			System.out.println(" Index suggested for "+ele+" is "+index+"..and set "+set);
			if(index>TableLen || set>TableLen) {
				//index=0;
				System.out.println("...............Index here "+index);
				set=0;
				return;
			}
			if(table.get(index)==-1) {
				table.set(index,ele);
				System.out.println("Fina  Index insert "+ele+" at  double "+index);
				set=0;
				return;
				}
			
		}
			//set++;
		//
			//System.out.println(" Index insert"+ele+"at  double "+index);
		
//	if(table.get(index)==-1) {
//		table.set(index,ele);
//		System.out.println("Fina  Index insert "+ele+" at  double "+index);
//		set=0;
//		return;}
//	else{
//		System.out.println(" Index "+index+" ..already occupied");
//		set=0;
//	}
	}
	
    void search(int ele){
		
		index=DoubleHashing(ele);
		
		while(table.get(index)!=-1 && set<alpha_count) {
			index=DoubleHashing(ele);
			if(ele==table.get(index)) {
				System.out.println(" Element found at index"+index);
				set=0;
				return;
			}
		}
		System.out.println(" Element not found ");
		set=0;
	}

 void delete(int ele){
		
		index=DoubleHashing(ele);
		while(table.get(index)!=-1 && set<alpha_count) {
			index=DoubleHashing(ele);
			if(ele==table.get(index)) {
				System.out.println(" Element deleted"+index);
				table.set(index,-1);
				set=0;
				return;
			}
		}
		System.out.println(" Element not found ");
		set=0;
	}
	private int DoubleHashing(int ele) {
		//ash(key)= ( H1(key)+ i* H2(key) )% m
		int val1= H1_Key_DoubleHashing(ele);
		int val2=H2_Key_DoubleHashing(ele);
		set++;
		int val=(val1+(set*val2))%mHash;
		System.out.println(" Val "+val+" Val 1"+val1+" val2 "+val2);
		return val;
	}

	private int H2_Key_DoubleHashing(int ele) {
		// //index-H1Key= key%m 
		int val=ele%mHash;
		return val;
	}

	private int H1_Key_DoubleHashing(int ele) {
		//offset-H2Key= (m-1)-key%(m-1)
		int val=(mHash-1)-(ele%(mHash-1));
		return val;
	}
	
}



class Linear_Probe_OpenAddress{
	
	ArrayList<Integer> table=new ArrayList<Integer>();
	int TableLen;
	int mHash;
	int index;
	int set;
	int alpha_count;
	
	Linear_Probe_OpenAddress(int arr[],int m,int len){
		//Consider 1 load factor
		int alpha=(len/1);
		TableLen=alpha;
		mHash=m;
		System.out.println(" Len of arr "+len+" aTable len "+TableLen);
		for(int i=0;i<TableLen;i++) {
			table.add(-1);
		}
				
	}
	
	public void View() {
		// View array 
		System.out.println(" View array list ");
		System.out.println(table.toString());
		
	}
	void insert(int ele){
		
		index=LinearProbe(ele);
		int ins=index;
		while(table.get(index)!=-1 && set<TableLen) {
			index=LinearProbe(ele);
			if(index==ins) {
				break;
			}
		}
		table.set(index,ele);
		set=0;
	}
	
    void search(int ele){
		
		index=LinearProbe(ele);
		int ins=index;
		while(table.get(index)!=-1 && set<TableLen) {
			index=LinearProbe(ele);
			if(index==ins) {
				break;
			}
			if(ele==table.get(index)) {
				System.out.println(" Element found at index"+index);
				set=0;
				return;
			}
		}
		System.out.println(" Element not found ");
		set=0;
	}

 void delete(int ele){
		
		index=LinearProbe(ele);
		int ins=index;
		while(table.get(index)!=-1 && set<TableLen) {
			index=LinearProbe(ele);
			if(index==ins) {
				break;
			}
			if(ele==table.get(index)) {
				System.out.println(" Element deleted"+index);
				table.set(index,-1);
				set=0;
				return;
			}
		}
		System.out.println(" Element not found ");
		set=0;
	}
	private int LinearProbe(int ele) {
		// Linear probe 
		int val=ele%mHash;
		val=val+set;
		set++;
		if(val==TableLen) {
			val=0;set=0;
		}
		return val;
	}
	
}

class Quadratic_Probe_OpenAddress{
	
	ArrayList<Integer> table=new ArrayList<Integer>();
	int TableLen;
	int mHash;
	int index;
	int set;
	int alpha_count;
	
	Quadratic_Probe_OpenAddress(int arr[],int m,int len){
		//Consider 0.5 max load factor - Quadratic 
		int alpha=(int) (len/0.5);
		TableLen=alpha;
		mHash=m;
		System.out.println(" Len of arr "+len+" aTable len "+TableLen);
		for(int i=0;i<TableLen;i++) {
			table.add(-1);
		}
		System.out.println(table.toString());
				
	}
	
	public void View() {
		// View array 
		System.out.println(" View array list ");
		System.out.println(table.toString());
		
	}
	
	void insert(int ele){
		
		index=QuadraticProbe(ele);
		int ins=index;
		while(table.get(index)!=-1 && set<TableLen) {
			index=QuadraticProbe(ele);
			if(index==ins) {
				break;
			}
		}
		table.set(index,ele);
		set=0;
	}
	
    void search(int ele){
		
		index=QuadraticProbe(ele);
		int ins=index;
		while(table.get(index)!=-1 && set<TableLen) {
			index=QuadraticProbe(ele);
			if(index==ins) {
				break;
			}
			if(ele==table.get(index)) {
				System.out.println(" Element found at index"+index);
				set=0;
				return;
			}
		}
		System.out.println(" Element not found ");
		set=0;
	}

 void delete(int ele){
		
		index=QuadraticProbe(ele);
		int ins=index;
		while(table.get(index)!=-1 && set<TableLen) {
			index=QuadraticProbe(ele);
			if(index==ins) {
				break;
			}
			if(ele==table.get(index)) {
				System.out.println(" Element deleted"+index);
				table.set(index,-1);
				set=0;
				return;
			}
		}
		System.out.println(" Element not found ");
		set=0;
	}
	private int QuadraticProbe(int ele) {
		// Quaratic probe key+i^set /m 
		int val=(ele+(set*set))%mHash;
		set++;
		if(val==TableLen) {
			val=0;
			set=0;
		}
		return val;
	}
	
}

