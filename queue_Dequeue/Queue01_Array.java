package queue_Dequeue;

/**
 * 
 *  Queue Data Structure :
 *  Pipe - supply chain
 *  FIFO - first in first out 
 *  
 *  dequeue()<---- |1|2|3|4|5<----- enqueue()
 *                  |       | 
 *                front    rear
 * 
 * Operations: 
 *  enqueue - add to queue 
 *  dequeue - remove 
 *  getFront - return int 
 *  getRear - return int at back 
 *  size - int of size 
 *  isEmpty - return true if empty 
 *  
 *  
 *  Application :
 *  1) Single resource multiple consumers -> ticket system 
 *  2) Synchronization between slow and fast devices 
 *  3) In operating systems buffers for keyboard, Spooling , First come first serve scheduling , semaphores  
 *  4) IN computer networks - mail queue , routers , switches 
 *  5) Variations : Deque , Priority queue , Doubly ended priority queue.
 *    
 *       Semaphores are sleeping processors available in queue .
 *       When resource available process wake up and use the resources 
 *       
 *       Spooling - used in printers , printers can do one process a time so used queue
 *       
 *       While routing data from high data network to low , a queue is used 
 *       
 * 
 * @author shree
 *
 */

class ArrayQueue{
	//Waste of spae 
	int capacity;
	int front;int rear;
	int array[];
	
	public ArrayQueue(int c) {
		array=new int[c];
		capacity=c;
		front=0;
		rear=-1;
	}
	
	void enQueue(int val) {
		if(rear>=capacity-1) {
			System.out.println(" Full ");
		}
		rear=rear+1;
		array[rear]=val;
	}
	
	int deQueue() {
		if(rear==-1){
			System.out.println(" Empty ");
		}
		int res= getFront();
		front=front-1;
		return res;
	}

	 int getFront() {
		
		if(front<=-1 && front>=capacity) {
			System.out.println(" No front ...");
			return -1;
		}
		return array[front];
	}
	
	 int getRear() {
			
			if(rear<=-1 && rear>=capacity) {
				System.out.println(" No rear ...");
				return -1;
			}
			return array[rear];
		}
	
	 int sizeQueue() {
		 return (rear-front);
	 }
	 
	 boolean isEmpty() {
		 if(rear==-1) {
			 return true;
		 }
		 return false;
	 }
	
	
}

class CircularArrayQueue{
	//Waste of space with normal array 
	// Use circular array 
	// rear= rear % size 
	// if rear <front - add 
	
	//Not recommended as rear value might be greater than int 
	// Update rear as pos
	int capacity;
	int front;int rear;
	int array[];int pos;
	
	public CircularArrayQueue(int c) {
		array=new int[c];
		capacity=c;
		front=0;
		rear=-1;
	}
	
	void enQueue(int val) {
		pos=rear%capacity;
		if(rear-front>=capacity-1) {
			System.out.println(" Full ");
		}
		
		array[pos]=val;
	}
	
	int deQueue() {
		if(rear==-1){
			System.out.println(" Empty ");
		}
		int res= getFront();
		front=front+1;
		return res;
	}

	 int getFront() {
		
		if(front<=-1 && front>=capacity) {
			System.out.println(" No front ...");
			return -1;
		}
		return array[front];
	}
	
	 int getRear() {
			pos=rear%capacity;
			if(this.isEmpty()) {
				System.out.println(" No rear ...");
				return -1;
			}
			return array[rear];
		}
	
	 int sizeQueue() {
		 
		 return (rear-front);
	 }
	 
	 boolean isEmpty() {
		 if(rear==-1) {
			 return true;
		 }
		 return false;
	 }
	
	
}

class BetterCircularQueue { 
	int front, rear, size; 
	int capacity; 
	int array[]; 

	public BetterCircularQueue(int capacity) 
	{ 
		this.capacity = capacity; 
		front = this.size = 0; 
		rear = capacity - 1; 
		array = new int[this.capacity]; 
	} 

	
	boolean isFull(BetterCircularQueue queue) 
	{ 
		return (queue.size == queue.capacity); 
	} 

	
	boolean isEmpty(BetterCircularQueue queue) 
	{ 
		return (queue.size == 0); 
	} 

	
	void enqueue(int item) 
	{ 
		if (isFull(this)) 
			return; 
		this.rear = (this.rear + 1) 
					% this.capacity; 
		this.array[this.rear] = item; 
		this.size = this.size + 1; 
		System.out.println(item 
						+ " enqueued to queue"); 
	} 

	
	int dequeue() 
	{ 
		if (isEmpty(this)) 
			return Integer.MIN_VALUE; 

		int item = this.array[this.front]; 
		this.front = (this.front + 1) 
					% this.capacity; 
		this.size = this.size - 1; 
		return item; 
	} 

	
	int front() 
	{ 
		if (isEmpty(this)) 
			return Integer.MIN_VALUE; 

		return this.array[this.front]; 
	} 

	
	int rear() 
	{ 
		if (isEmpty(this)) 
			return Integer.MIN_VALUE; 

		return this.array[this.rear]; 
	} 
} 

public class Queue01_Array {

	public static void main(String[] args) {
		

	}

}


/*
 * 
 * Introduction to Queues

Like

Stack

data structure,

Queue 

is also a linear data structure that follows a particular order in which the operations are performed. The order is

F

irst

I

n

F

irst

O

ut (FIFO), which means that the element that is inserted first in the queue will be the first one to be removed from the queue. A good example of queue is any queue of consumers for a resource where the consumer who came first is served first.





The difference between stacks and queues is in removing. In a stack, we remove the most recently added item; whereas, in a queue, we remove the least recently added item.





Operations on Queue:

Mainly the following four basic operations are performed on queue:



Enqueue: Adds an item to the queue. If the queue is full, then it is said to be an Overflow condition.
Dequeue: Removes an item from the queue. The items are popped in the same order in which they are pushed. If the queue is empty, then it is said to be an Underflow condition.
Front: Get the front item from queue.
Rear: Get the last item from queue.




queue








Array implementation Of Queue

: For implementing a

queue

, we need to keep track of two indices - front and rear. We enqueue an item at the rear and dequeue an item from the front. If we simply increment front and rear indices, then there may be problems, the front may reach the end of the array. The solution to this problem is to increase front and rear in a circular manner.





Consider that an Array of size

N

is taken to implement a queue. Initially, the size of the queue will be zero(0). The total capacity of the queue will be the size of the array i.e. N. Now initially, the index

front

will be equal to 0, and

rear

will be equal to N-1. Every time an item is inserted, so the index

rear

will increment by one, hence increment it as:

rear = (rear + 1)%N

and everytime an item is removed, so the front index will shift to right by 1 place, hence increment it as:

front = (front + 1)%N

.





Example

:



Array = queue[N].
front = 0, rear = N-1.
N = 5.

Operation 1:
enque(5);
front = 0, 
rear = (N-1 + 1)%N = 0.
Queue contains: [5].

Operation 2:
enque(10);
front = 0, 
rear = (rear + 1)%N = (0 + 1)%N = 1.
Queue contains: [5, 10].

Operation 3:
enque(15);
front = 0, 
rear = (rear + 1)%N = (1 + 1)%N = 2.
Queue contains: [5, 10, 15].

Operation 4:
deque();
print queue[front]; 
front = (front + 1)%N = (0 + 1)%N = 1.
Queue contains: [10, 15].






Below is the Array implementation of queue in C++ and Java:




// Java program for array implementation of queue
 
// A class to represent a queue
class Queue
{
    int front, rear, size;
    int  capacity;
    int array[];
     
    public Queue(int capacity) {
         this.capacity = capacity;
         front = this.size = 0; 
         rear = capacity - 1;
         array = new int[this.capacity];
          
    }
     
    // Queue is full when size becomes equal to 
    // the capacity 
    boolean isFull(Queue queue)
    {  return (queue.size == queue.capacity);
    }
     
    // Queue is empty when size is 0
    boolean isEmpty(Queue queue)
    {  return (queue.size == 0); }
     
    // Method to add an item to the queue. 
    // It changes rear and size
    void enqueue( int item)
    {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1)%this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item+ " enqueued to queue");
    }
     
    // Method to remove an item from queue.  
    // It changes front and size
    int dequeue()
    {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
         
        int item = this.array[this.front];
        this.front = (this.front + 1)%this.capacity;
        this.size = this.size - 1;
        return item;
    }
     
    // Method to get front of queue
    int front()
    {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
         
        return this.array[this.front];
    }
      
    // Method to get rear of queue
    int rear()
    {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
         
        return this.array[this.rear];
    }
}

// Driver class
public class Test
{
    public static void main(String[] args) 
    {
        Queue queue = new Queue(1000);
          
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
      
        System.out.println(queue.dequeue() + 
                     " dequeued from queue\n");
      
        System.out.println("Front item is " + 
                               queue.front());
         
        System.out.println("Rear item is " + 
                                queue.rear());
    }
}


Output:

10 enqueued to queue
20 enqueued to queue
30 enqueued to queue
40 enqueued to queue
10 dequeued from queue
Front item is 20
Rear item is 40





Time Complexity:

Time complexity of all operations such as enqueue(), dequeue(), isFull(), isEmpty(), front(), and rear() is O(1). There is no loop in any of the operations.





Applications of Queue:

Queue is used when things don’t have to be processed immediatly, but have to be processed in 

F

irst 

I

n

F

irst 

O

ut order like 

Breadth First Search
. This property of Queue makes it also useful in following kind of scenarios:



When a resource is shared among multiple consumers. Examples include CPU scheduling, Disk Scheduling.
When data is transferred asynchronously (data not necessarily received at same rate as sent) between two processes. Examples include IO Buffers, pipes, file IO, etc.

 * 
 * 
 */
