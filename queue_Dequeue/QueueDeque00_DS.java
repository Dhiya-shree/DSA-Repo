
package queue_Dequeue;
/**
 * 
 * Deque - Doubly ended Queue
 * 
 *  -> insert and delete at both front and rear
 *  -> four main operations 
 *         InsertFRont 
 *         InsertRear
 *         DeleteFront
 *         DeleteRear
 *  Additional operation :
 *  getFront
 *  getRear
 *  isEmpty
 *  size
 *  
 *  Implementation :
 *  1) LinkedList - Double linked list 
 *  2) Array 
 * 
 * Application:
 * 1) Can act as both stack and queue
 * 2) use to maintain history of actions-> browser history 
 * 3) A steal process scheduling algorithm 
 *    P1 processor  P2 
 *    T1 T2 T3 T4  no task
 *  As P2 not having task , delete from rear in P1 
 *  and insert at front in P2 for steal scheduling 
 *  4) Implementing priority queue with two priority 
 *    items - i1 i2 i1 i1 i1 i1 i2
 *    Items 1 priority need to complete all before item i2 
 *    put i1 in front and i2 in rear 
 *  5)Maximum / Minimum of all sub array of k in an array 
 *  
 *   
 * C++ STL
 * allows random access 
 * push_front , push_back
 * dq.front , dq.back 
 * pop_front , pop_back 
 * iterator dq.begin , dq.end
 * dq.insert at iterator position 
 * Internal working :
 * All operation in O 1 
 * Use circular array by c++
 * O N  -> need to copy if size varies 
 * 
 * To make dynamic :
 * Use pointer array 
 * P1 for dequeue of length 5 
 * If length is 6 , use P1 and continue dequeue values
 * So no need for copy .
 * Amortized also O 1 + gives random access
 * 
 * JAVA : 
 * Implemented by Linked List 
 * front - first 
 * rear - last 
 * dq = { }
 *  No exception ----- Exception
 * offerFront  --------addFirst
 * offerLast   --------addLast
 * pollFirst   --------removeFirst
 * pollLast   --------removeLast
 * peekFirst   --------getFirst
 * peekLast   -------- getLast
 * 
 * Exception function are needed :::<<<<<<<<<<<<<<<<<<<<<<<<
 *  When we have NULL stored as value in dequeue
 *  
 * When values are null , peek will also throw null so confusion caused 
 * But get will work and can distinguish , as it throw exception if dequeue is empty
 * 
 * Iteration in DQ :
 * 1) Iterator :
 *      Iterator it = dq.iterator();
 *      while(it.hasNext){
 *      it=it.next;
 *       ....do something
 *       }
 *       For descending :
 *       Iterator it = dq.descendingIterator();
 * 
 * 2) For each 
 *    for(int x : dq){
 *     //Do something 
 *    }
 * @author shree
 *
 */


class DequeLL{
	int data;
	DequeLL front;
	DequeLL rear;
	DequeLL next;
	DequeLL prev;
	int size;
	
	DequeLL(){
		data=0; size=0;
		front=null;
		rear=null;
		next=null;
		prev=null;
	}
	
	void InsertFront(int x) {
		DequeLL dq=new DequeLL();
		dq.data=x;
		size++;
		if(front==null) {
			front=dq;
			rear=dq;
		}
		else {
			front.prev=dq;
			front=dq;
		}
	}
	
	void InsertRear(int x) {
		DequeLL dq=new DequeLL();
		dq.data=x;
		size++;
		if(rear==null) {
			front=dq;
			rear=dq;
		}
		else {
			rear.next=dq;
			rear=dq;
		}
	}
	
	void DeleteFront() {
		if(size==0) {
			System.out.println(" Empty ");
			return;
		}
		else {
			front=front.next;
			size--;
		}
	}
	void DeleteRear() {
		if(size==0) {
			System.out.println(" Empty ");
			return;
		}
		else {
			rear=rear.prev;
			size--;
		}
	}
	
	int getSize() {
		return size;
	}
	
	boolean isEmpty() {
		if(size==0) {
			return true;
		}
		return false;
	}
	
	int getFront() {
		if(front!=null) {
			return front.data;
		}
		return -1;
	}
	int getRear() {
		if(rear!=null) {
			return rear.data;
		}
		return -1;
	}
}

class DequeArray{
	int[] arr;
	int size;
	int front;int rear=0;
	
	DequeArray(int c){
		arr=new int[c];
		size=c;
		front=0;
		rear=-1;
	}
	
	//While adding and deleting at front 
	// Shift n characters till rear 
	int deleteFront() {
		if(rear==-1) {
			return -1;
		}
		int res=arr[front];
		
		for(int i=1;i<=rear;i++) {
			arr[i-1]=arr[i];
		}
		rear=rear-1;
		return res;
	}
	
	void InsertFront(int x) {
		if(rear>=size-1) {
			System.out.println("Full");
			return;
		}
		for(int i=rear+1;i>0;i--) {
			arr[i]=arr[i-1];
		}
		arr[front]=x;
		rear=rear+1;
	}
	int deleteRear() {
		if(rear==-1) {
			return -1;
		}
		
		int res=arr[rear];
		rear++;
		return res;
	}
	void InsertRear(int x) {
		if(rear>=size-1) {
			System.out.println("Full");
		}
		arr[rear+1]=x;
		rear=rear+1;
	}
	int getSize() {
		return rear;
	}
	
	boolean isEmpty() {
		if(rear==-1) {
			return true;
		}
		return false;
	}
	
}

//array ascircular buffer 
class Dequecircular{
	int[] arr;
	int size;int capacity;
	int front;int rear=0;
	/// We can also find rear by 
	// rear= (front + size -1   ) % capacity
	Dequecircular(int c){
		arr=new int[c];
		capacity=c;
		size=-1;
		front=0;
		rear=-1;
	}
	
	int deleteFront() {
		if(rear==-1) {
			return -1;
		}
		int res=arr[front];
		
		front=(front+1)%capacity;
		return res;
	}
	// rear+front x x x x x xx x x x -> one val 
	// front from back , rear from front 
	// val val rear x x x x front val val val 
	void InsertRear(int x) {
		if(isFull()) {
			System.out.println("Full");
			return;
		}
		rear=(rear+1)%capacity;
		arr[rear]=x;
		size++;
	}
	
	private boolean isFull() {
		//Full 
		if(size>=capacity-1) {
			return true;
		}
		return false;
	}

	void InsertFront(int x) {
		if(isFull()) {
			System.out.println("Full");
			return;
		}
		size++;
		// go back in array from curr front 
		// no neg so %
		front=(front-1+capacity)%capacity;
		arr[front]=x;
	}
	
	int deleteRear() {
		if(rear==-1) {
			return -1;
		}
		
		int res=arr[rear];
		rear=(rear-1+capacity)%capacity;
		return res;
	}
	
	boolean isEmpty() {
		if(size==-1) {
			return true;
		}
		return false;
	}
	int size() {
		
		return size;
	}
}
public class QueueDeque00_DS {

	public static void main(String[] args) {
		
		

	}

}

/**
 * Circular buffer deque 
 * 
 * // C++ implementation of De-queue using circular
// array
#include <iostream>
using namespace std;

// Maximum size of array or Dequeue
#define MAX 100

// A structure to represent a Deque
class Deque {
	int arr[MAX];
	int front;
	int rear;
	int size;

public:
	Deque(int size)
	{
		front = -1;
		rear = 0;
		this->size = size;
	}

	// Operations on Deque:
	void insertfront(int key);
	void insertrear(int key);
	void deletefront();
	void deleterear();
	bool isFull();
	bool isEmpty();
	int getFront();
	int getRear();
};

// Checks whether Deque is full or not.
bool Deque::isFull()
{
	return ((front == 0 && rear == size - 1)
			|| front == rear + 1);
}

// Checks whether Deque is empty or not.
bool Deque::isEmpty() { return (front == -1); }

// Inserts an element at front
void Deque::insertfront(int key)
{
	// check whether Deque if full or not
	if (isFull()) {
		cout << "Overflow\n" << endl;
		return;
	}

	// If queue is initially empty
	if (front == -1) {
		front = 0;
		rear = 0;
	}

	// front is at first position of queue
	else if (front == 0)
		front = size - 1;

	else // decrement front end by '1'
		front = front - 1;

	// insert current element into Deque
	arr[front] = key;
}

// function to inset element at rear end
// of Deque.
void Deque ::insertrear(int key)
{
	if (isFull()) {
		cout << " Overflow\n " << endl;
		return;
	}

	// If queue is initially empty
	if (front == -1) {
		front = 0;
		rear = 0;
	}

	// rear is at last position of queue
	else if (rear == size - 1)
		rear = 0;

	// increment rear end by '1'
	else
		rear = rear + 1;

	// insert current element into Deque
	arr[rear] = key;
}

// Deletes element at front end of Deque
void Deque ::deletefront()
{
	// check whether Deque is empty or not
	if (isEmpty()) {
		cout << "Queue Underflow\n" << endl;
		return;
	}

	// Deque has only one element
	if (front == rear) {
		front = -1;
		rear = -1;
	}
	else
		// back to initial position
		if (front == size - 1)
		front = 0;

	else // increment front by '1' to remove current
		// front value from Deque
		front = front + 1;
}

// Delete element at rear end of Deque
void Deque::deleterear()
{
	if (isEmpty()) {
		cout << " Underflow\n" << endl;
		return;
	}

	// Deque has only one element
	if (front == rear) {
		front = -1;
		rear = -1;
	}
	else if (rear == 0)
		rear = size - 1;
	else
		rear = rear - 1;
}

// Returns front element of Deque
int Deque::getFront()
{
	// check whether Deque is empty or not
	if (isEmpty()) {
		cout << " Underflow\n" << endl;
		return -1;
	}
	return arr[front];
}

// function return rear element of Deque
int Deque::getRear()
{
	// check whether Deque is empty or not
	if (isEmpty() || rear < 0) {
		cout << " Underflow\n" << endl;
		return -1;
	}
	return arr[rear];
}

// Driver code
int main()
{
	Deque dq(5);

	// Function calls
	cout << "Insert element at rear end : 5 \n";
	dq.insertrear(5);

	cout << "insert element at rear end : 10 \n";
	dq.insertrear(10);

	cout << "get rear element "
		<< " " << dq.getRear() << endl;

	dq.deleterear();
	cout << "After delete rear element new rear"
		<< " become " << dq.getRear() << endl;

	cout << "inserting element at front end \n";
	dq.insertfront(15);

	cout << "get front element "
		<< " " << dq.getFront() << endl;

	dq.deletefront();

	cout << "After delete front element new "
		<< "front become " << dq.getFront() << endl;
	return 0;
}

 * 
 * 
 */
