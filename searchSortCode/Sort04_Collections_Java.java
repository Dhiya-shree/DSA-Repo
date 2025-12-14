package searchSortCode;

//Integer - have compareTo function
// All wrapper classes have comparable interface 
//Collections.revereseOrder - works on basis of comparable of wrapper class
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Colections.Sort()
 * 
 * Sort the collections , Linked list , Array list 
 * 
 * @author shree
 *
 */

class PointSort04 implements Comparable<PointSort04>{

	int x,y;
	PointSort04(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int compareTo(PointSort04 o) {
		System.out.println(" This x "+this.x+" Point o "+o.x);
		return (this.x-o.x);
	}
	
}

//Comparator 
class PointSort04Comparator{

	int x,y;
	PointSort04Comparator(int x,int y){
		this.x=x;
		this.y=y;
	}
	
}

class Sort4ComparatorClass implements Comparator<PointSort04Comparator>{

	//@Override
	public int compare(PointSort04Comparator o1, PointSort04Comparator o2) {
		//Comparator method 
		System.out.println(" This o 1 "+o1.x+" Point comparator o2 "+o2.x);
		return (o1.x-o2.x) ;
	}
	
}


public class Sort04_Collections_Java {

	public static void main(String[] args) {
		
		//Colletion sorting - wrapper class
		//Integer - have compareTo function
		// All wrapper classes have comparable interface 
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(3);
		
		Collections.sort(list);
		System.out.println("List "+list);
		//Collections.revereseOrder - works on basis of comparable of wrapper class
		Collections.sort(list,Collections.reverseOrder());
		System.out.println("List reverse order "+list);
		
		
		//Colletion sorting - User defined type
		//Below not possible 
		// Collections only deal with collection 
		/**PointSort04[] ps4 = { new PointSort04(1,3),
				new PointSort04(5,9),
				new PointSort04(0,32),
				new PointSort04(100,13)};
		
		Collections.sort(ps4);
		*/
		
		List<PointSort04> list2=new ArrayList<PointSort04>();
		list2.add( new PointSort04(1,3));
		list2.add(new PointSort04(5,9));
		list2.add(new PointSort04(0,32));
		list2.add(new PointSort04(100,13));
		
		Collections.sort(list2);
		//Like it used wrapper class comparable , now it will use 
		// Point sort 4 CompareTo function 
		for(PointSort04 p :list2) {
			System.out.println(p.x+" "+p.y);
		}
		
		Collections.sort(list2,Collections.reverseOrder());
		//Like it used wrapper class comparable , now it will use 
		// Point sort 4 CompareTo function 
		for(PointSort04 p :list2) {
			System.out.println(p.x+" "+p.y);
		}
		
		// Use comparator now !!!!!!!!!
		List<PointSort04Comparator> list3=new ArrayList<PointSort04Comparator>();
		list3.add( new PointSort04Comparator(1,3));
		list3.add(new PointSort04Comparator(5,9));
		list3.add(new PointSort04Comparator(0,32));
		list3.add(new PointSort04Comparator(100,13));
		
		//Comparator class 
		Sort4ComparatorClass compclass= new Sort4ComparatorClass();
		Collections.sort(list3,compclass);
		//Like it used wrapper class comparable , now it will use 
		// Point sort 4 CompareTo function 
		for(PointSort04Comparator p :list3) {
			System.out.println(p.x+" "+p.y);
		}
		
		Collections.sort(list3,Collections.reverseOrder(compclass));
		//Like it used wrapper class comparable , now it will use 
		// Point sort 4 CompareTo function 
		for(PointSort04Comparator p :list3) {
			System.out.println(p.x+" "+p.y);
		}
		
		//Array sort 
		// 1- Arrays.sort(arr)
		// 2- Arrays.sort(arr,start,end) - sub array yes
		
		//Collections Sort  - can not sort a sub array 
		// 1- Collections.sort(list) //Internal comparable of wrapper class / need to define
		// 2- Collections.sort(list,comparator)
		
	}
	     
}
