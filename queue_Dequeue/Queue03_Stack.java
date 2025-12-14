package queue_Dequeue;

/**
 * STack and queue 
 * 
 * 1) Implement stack using queue
 * 
 *   Stack with func:
 *      top 
 *      push 
 *      pop
 *      size
 * 
 * Reverse your input and store as queue
 * Method 1:push costly 
 * For push :
 * Use extra stack .. q2 
 * q1 ==20,30,40
 * push 10:
 * 1)Create empty q2 :
 * 2)Make q2 value = q1 = 20,30,40
 * 3)q1= adding element =20 
 * 4) Merge q1+q2
 *      while q2!null
 *         q1.enqueue(q2.pop)
 *  
 * For Delete :
 * q1.dequeue==q1.pop
 * 
 * Method 2: pop costly 
 * Method 3: Only 1 queue+ recursive call stack
 * 
 * 2) Implement Queue using stack :
 * Method 1: Enqueue costly
 * Method 2: Dequeue costly 
 * Method 3: One stack and recursive call stack 
 * 
 * 
 32
98 18 82 72 10 76 68 28 98 57 87 54 7 66 20 84 29 25 33 72 4 30 71 20 9 69 41 16 97 50 19 24 47 46 22 52 80 56 65 89 42 29 94 51 35 1 25 65 88 15 44 57 28 92 60 66 33 37 38 52 76 29 75 8

 * @author shree
 *
 */
public class Queue03_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
int arr[]= {1,2,3};
int n=arr.length;
	}

}
