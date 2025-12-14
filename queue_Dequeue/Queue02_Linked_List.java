package queue_Dequeue;

/**
 * Queue using linked list :
 * 
 *     enqueue
 *     dequeue
 *     size 
 *     getFRont
 *     getRear
 *     isEmpty
 * 
 * 
 *
 * @author shree
 *
 */

class LLQueue{
	//Chose head as front and tail as rear 
	// If chosen opposite very hard to deque 
	int data;
	LLQueue next;
	LLQueue front;
	LLQueue rear;
	int size;
	LLQueue(){
		data=-1;
		this.next=null;
		size=0;
		this.front=null;
		this.rear=null;
	}
	
	void enqueue(int x) {
		LLQueue ll=new LLQueue();
		ll.data=x;
		if(rear==null) {
			front=ll;
			rear=ll;
		}
		else {
			rear.next=ll;
			rear=ll;
		}
		size++;	
	}
	
	int deQue() {
	
		if(size==-1) {
			System.out.println(" Empty ");
			return -1;
		}
		size--;
		int res=front.data;
		front=front.next;
		return res;
	}
	int size() {
		return size;
	}
	boolean isEmpty() {
		if(size==-1) {
			return true;
		}
		return false;
	}
}
public class Queue02_Linked_List {

	public static void main(String[] args) {
	

	}

}
