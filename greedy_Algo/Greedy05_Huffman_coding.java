package greedy_Algo;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * Huffman coding 
 * 
 *  Used for lossless compression 
 *  Variable length coding
 *  
 *  Lossless compression 
 *  On decoding data -> there should not be any change in original data 
 *  No compromise with quality 
 *  Lossy ompression is also allowed ex) for video 320p etc 
 *  
 *  Variable length encoding :
 *  Every variable/char in the message will not have same encoding 
 *  Characters will have different bit sequence for encoding 
 *  
 *  Example problem :
 *  Fixed length coding 
 *  Seq = "abaabaca...." 100 char long 
 *  Need to compress above for storing and sharing over a network to save bandwidth:
 *  
 *  Characters in sequence - a,b,c
 *  Consider we have below frequencies :
 *  a-70 
 *  b-20
 *  c-10
 *  
 *  For sharing in iriginal format 
 *  each char - 8 bits 
 *  Total data : 800 bits 
 *  
 *  As we have only 3 char , use fixed length encoding 
 *  3 code - 2 bit enough for 3 distinct code
 *  00 - a 
 *  01 - b
 *  10 - c 
 *  With above encoding need 200 bits 
 *  
 *  Average length f Huffman coding :
 *    Count of bits in code * Probability 
 *  
 * 
 *  Huffman coding - variable length coding 
 *  1) Greedy Idea 
 *     The most frequent character has smallest code
 *     least frequent largest length code  
 *  
 *  2) Prefix REquirement for Decompression :
 *     No code should be prefix of any other 
 *     
 *  Example :
 *  1) with only greeady idea
 *  Consider above freq 
 *  a - 70 1 
 *  b - 20 0
 *  c - 10 11
 *  or 
 *  a - 70 0
 *  b - 20 00
 *  c - 10 01  
 *  
 *  Above follows greedy idea , but not prefix free
 *  ex) 1 1 1 
 *  can be -> aaa or ca or ac 
 *  
 *  Not able to decompress -> issue with decompression 
 *  
 *  
 *  2) Greedy idea + prefix free 
 *  Consider above freq && Prefix free
 *  a  0            a  1  -> small code for max repeat 
 *  b  10    [OR]   b 01
 *  c  11           c 00
 *  
 *  Total bits needed : 70*1 +20*2 +10*2 = 130 bits 
 *  
 *  Ex Decode 001110 for above 
 *  Consider a,b,c as 0,10,11
 *  then    0 0 11 10
 *          a a c  b
 *   Only one possible solution 
 *  
 *  
 *    ////////////////////////////////////////////////////////////////////////////////
 *    
 *     
 *     
 *   HUFFMAN ALGORITHM 50 
 *   
 *   
 *   High level idea :
 *   
 *   Consider input of sequence with below frequency 
 *   char : a  d  b  e  f
 *   freq : 10 50 20 40 80
 *   Total freq=200
 *   
 *   Step 1: Build a Binary tree / Huffman tree 
 *   
 *   Every input character is a leaf 
 *   Every left child edge is labelled as 0 and right as 1
 *   Every root to leaf path represents huffman coding of the leaf 
 *   
 *   
 *   1) Sort by freq
 *         80f 50d 40e 20b 10a 
 *   2) Follow above rules and start with total amount of freq
 *          [ null , 200 , null ] 
 *          [ char , freq , code ]
 *   3) Fill values based on above left:0 right: 1 
 *      Loop : 
 *      From root subtract high freq node at i 
 *      Small freq go left 
 *      High go right 
 *      
 *      Below :
 *      1->  200-80 = 120,80 80 left 
 *      2->  120-50 = 70,50 50 left 
 *      3->  70-40  = 30,40 40 go right 40>30 
 *      4->  30-20  = 10,20 go right 20>10
 *      10 go left .......end 
 *      
 *   
 *                 [ null , 200 , null ] 
 *               0/                     \1
 *   [ f , 80 , 0 ]         [ null , 120 , 1 ] 
 *                        0/                  \1
 *            [ d , 50 , 10 ]        [ null , 70 , 11 ] 
 *                                 0/             \1
 *                [ null , 30 , 110 ]         [ e , 40 , 111  ] 
 *              0 /                  \1             
 * [ a , 10 , 1100 ]       [ b , 20 , 1101 ]
 * 
 *    
 *  4) Traverse Binary tree and print codes 
 *       f ->0
 *       d ->10
 *       e ->111
 *       a ->1100
 *       b ->1101
 * 
 * Top down Wont Work 
 * HuffMan need to split maximum 
 * 
 * a-50 b - 40 c - 30 d-35 e-55 
 * Try to split as 100 or near 
 *       $
 *      / \
 *    a,e  c,b,d
 *    105     120
 *    /  \    / \ 
 *   55  50  40  65
 *   e    a   b  /  \
 *              30  35
 *              c    d
 * Huffman algorithm solution :
 * top-down tree creation 
 * 
 * Step 1: Sort 
 * Sort based on Freq
 * 
 * Step 2: Initialize 
 * array to store coding encode 
 * encode=0
 * 
 * Step 3: loop 
 * 
 * for i=0 to n 
 *   1) Subtract sub=total-currfreq 
 *   2) if sub>currfreq
 *        // curr end with 0 
 *        curr encode = encode + 0 
 *        // encode for next high 1
 *        encode = encode + 1
 *        
 *      else :
 *       // curr end with 1
 *        curr encode = encode + 1
 *        // encode for next low 0
 *        encode = encode + 0
 *   3) Save encode for curr one 
 *   
 *   
 * 
 * Huffman algorithm solution with MinHeap :
 * bottom up tree creation 
 * Correct approach 
 * 
 * Create node of char , freq   5 char,freq node 
 * Take last two node create a new node $ with left and right as last two node 
 * 4 node 
 *    f,d,e,$
 *          |\
 *          a b
 *          
 * Consider $ and create $ node again 
 * 3 Node 
 *    f,d,$
 *        |\
 *        e $
 *          |\ 
 *          a b
 * Continue till heap number of nodes =1 
 * 2 Node 
 *    f , $ 
 *        |\
 *        d $
 *          |\
 *          e $
 *            |\ 
 *            a b
 * Continue 1 Node 
 *    $
 *    |\
 *    f $ 
 *      |\
 *      d $
 *        |\
 *        e $
 *          |\ 
 *          a b
 *  
 *           
 *    
 * 
 * Sort based on freq 
 * 
 * Build binary tree 
 * 1) Create leaf nodes with sorted freq order and
 *      build a min heap h of all the leaves initially 
 * 
 * 2) While h.size()>1:
 *       a) left=h.extractMin()
 *       b) right=h.extractMin()
 *       c) Create a new tree node with 
 *             1) Character as "$"
 *             2) Frequency as left freq + right freq
 *             3) left and right childer as left and right 
 *       d) Insert new node into h 
 *  
 * 3) The only node left in h is our required binary tree 
 *    
 * Get the codes
 * Use Preorder traversal 
 * root left right 
 *    
 * 
 * 
 * 
 *                                                    
 * @author shree
 *
 */
public class Greedy05_Huffman_coding {

	public static void main(String[] args) {
		// Huffman coding 
		
		char c[]= {'a','b','d','e','f'};
		int freq[]= {10,20,50,40,80};
		
		HuffmanEncodingGreedy(c,freq,c.length);
		
		HuffmanEncodingMinHeapGreedy(c,freq,c.length);

	}

	private static void HuffmanEncodingMinHeapGreedy(char[] c, int[] freq, int n) {
		// use min heap 
		// Time O NLogN 
		// Space  O N 
		PriorityQueue<NodeHME> pq=new PriorityQueue<>();
		
		// Put all nodes in Min heap   NLOGN 
		for(int i=0;i<n;i++) {
			pq.add(new NodeHME(c[i],freq[i]));
		}

		// for min heap size    NLOGN  time
		while(pq.size()>1) {
		
			NodeHME left=pq.poll();
			NodeHME right=pq.poll();
			
			pq.add(new NodeHME('$',left.freq+right.freq,left,right));
		
		}
		
		printCodes(pq.peek(),""); // O N 
	}

	private static void printCodes(NodeHME root, String s) {
		// preorder traversal 
		if(root.c!='$') {
			System.out.println(root.c+" code is "+s);
			return;
		}
		
		printCodes(root.left, s+"0");
		printCodes(root.right, s+"1");
	}

	private static void HuffmanEncodingGreedy(char[] c, int[] freq, int n) {
		// just codes 
		// Speacial case must handle
		if(n==1) {
			System.out.println(" For 1 -- 0 ");
		}
		if(n==2) {
			System.out.println(" For two use 1 and 0 ");
		}
		
		int val[][]=new int[n][2]; 
		int total=0;
		for(int i=0;i<n;i++) {
			val[i][0]=c[i];
			val[i][1]=freq[i];
			total=total+freq[i];
		}
		
		//sort 
		Arrays.sort(val,(a,b)->Integer.compare(b[1],a[1]));
		
		//Initialize 
		StringBuilder encode=new StringBuilder();
		String curr=null;
		//StringBuilder curr2=new StringBuilder();
		int sub=0;
	   //Loop 
		
		//Only till n-1
		for(int i=0;i<n-1;i++) {
			sub=total-val[i][1];
			if(sub>val[i][1]) {
				// curr with 0
				curr=encode.toString()+"0";
				System.out.println(" For char "+((char)val[i][0])+" code is "+curr);
				
				//encode with 1 
				encode=encode.append('1');
			}
			else {
				// curr with 1
				curr=encode.toString()+"1";
				System.out.println(" For char "+((char)val[i][0])+" code is "+curr);
				
				//encode with 0
				encode=encode.append('0');
			}
			
			// Decrease total 
			total=sub;	
		}
		
		// For last char just print last value 
		// Will fail if n==1 handle n=1 seperately 
		System.out.println(" For char "+((char)val[n-1][0])+" code is "+encode);

		
		
	}

}

class NodeHME implements Comparable<NodeHME>{
	char c;
	int freq;
	NodeHME left,right;
	public NodeHME(char i,int j) {
		c=i;
		freq=j;
		left=null;right=null;
	}
	
	public NodeHME(char i, int j, NodeHME l, NodeHME r) {
		c=i;
		freq=j;
		left=l;right=r;
	}

	public int compareTo(NodeHME o) {
		return this.freq-o.freq;//asc min heap 
	}
}

/*
 * Huffman Coding

Huffman coding is a lossless data compression algorithm. The idea is to assign variable-length codes to input characters, lengths of the assigned codes are based on the frequencies of corresponding characters. The most frequent character gets the smallest code and the least frequent character gets the largest code.
The variable-length codes assigned to input characters are Prefix Codes, means the codes (bit sequences) are assigned in such a way that the code assigned to one character is not the prefix of code assigned to any other character. This is how Huffman Coding makes sure that there is no ambiguity when decoding the generated bitstream. 
Let us understand prefix codes with a counter example. Let there be four characters a, b, c and d, and their corresponding variable length codes be 00, 01, 0 and 1. This coding leads to ambiguity because code assigned to c is the prefix of codes assigned to a and b. If the compressed bit stream is 0001, the de-compressed output may be "cccd" or "ccb" or "acd" or "ab".
See this for applications of Huffman Coding. 
There are mainly two major parts in Huffman Coding

Build a Huffman Tree from input characters.
Traverse the Huffman Tree and assign codes to characters.
Steps to build Huffman Tree
Input is an array of unique characters along with their frequency of occurrences and output is Huffman Tree. 

Create a leaf node for each unique character and build a min heap of all leaf nodes (Min Heap is used as a priority queue. The value of frequency field is used to compare two nodes in min heap. Initially, the least frequent character is at root)
Extract two nodes with the minimum frequency from the min heap.
 
Create a new internal node with a frequency equal to the sum of the two nodes frequencies. Make the first extracted node as its left child and the other extracted node as its right child. Add this node to the min heap.
Repeat steps#2 and #3 until the heap contains only one node. The remaining node is the root node and the tree is complete.
Let us understand the algorithm with an example:
character   Frequency
    a            5
    b           9
    c           12
    d           13
    e           16
    f           45
Step 1. Build a min heap that contains 6 nodes where each node represents root of a tree with single node.
Step 2 Extract two minimum frequency nodes from min heap. Add a new internal node with frequency 5 + 9 = 14. 
 

Huffman Coding step 2


Now min heap contains 5 nodes where 4 nodes are roots of trees with single element each, and one heap node is root of tree with 3 elements

character           Frequency
       c               12
       d               13
 Internal Node         14
       e               16
       f                45
Step 3: Extract two minimum frequency nodes from heap. Add a new internal node with frequency 12 + 13 = 25
 

Huffman Coding step 3


Now min heap contains 4 nodes where 2 nodes are roots of trees with single element each, and two heap nodes are root of tree with more than one nodes

character           Frequency
Internal Node          14
       e               16
Internal Node          25
       f               45
Step 4: Extract two minimum frequency nodes. Add a new internal node with frequency 14 + 16 = 30
 

Huffman Coding step 4


Now min heap contains 3 nodes.

character          Frequency
Internal Node         25
Internal Node         30
      f               45 
Step 5: Extract two minimum frequency nodes. Add a new internal node with frequency 25 + 30 = 55
 

Huffman Coding step 5


Now min heap contains 2 nodes.

character     Frequency
       f         45
Internal Node    55
Step 6: Extract two minimum frequency nodes. Add a new internal node with frequency 45 + 55 = 100
 

Huffman Coding step 6


Now min heap contains only one node.

character      Frequency
Internal Node    100
Since the heap contains only one node, the algorithm stops here.

Steps to print codes from Huffman Tree:
Traverse the tree formed starting from the root. Maintain an auxiliary array. While moving to the left child, write 0 to the array. While moving to the right child, write 1 to the array. Print the array when a leaf node is encountered.
 

Steps to print codes from Huffman Tree


The codes are as follows:

character   code-word
    f          0
    c          100
    d          101
    a          1100
    b          1101
    e          111
Below is the implementation of above approach: 



import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

// node class is the basic structure
// of each node present in the Huffman - tree.
class HuffmanNode {

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

// comparator class helps to compare the node
// on the basis of one of its attribute.
// Here we will be compared
// on the basis of data values of the nodes.
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {

        return x.data - y.data;
    }
}

public class Huffman {

    // recursive function to print the
    // huffman-code through the tree traversal.
    // Here s is the huffman - code generated.
    public static void printCode(HuffmanNode root, String s)
    {

        // base case; if the left and right are null
        // then its a leaf node and we print
        // the code s generated by traversing the tree.
        if (root.left
                == null
            && root.right
                   == null
            && Character.isLetter(root.c)) {

            // c is the character in the node
            System.out.println(root.c + ":" + s);

            return;
        }

        // if we go to left then add "0" to the code.
        // if we go to the right add"1" to the code.

        // recursive calls for left and
        // right sub-tree of the generated tree.
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    // main function
    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);

        // number of characters.
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        // creating a priority queue q.
        // makes a min-priority queue(min-heap).
        PriorityQueue<HuffmanNode> q
            = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {

            // creating a Huffman node object
            // and add it to the priority queue.
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

            // add functions adds
            // the huffman node to the queue.
            q.add(hn);
        }

        // create a root node
        HuffmanNode root = null;

        // Here we will extract the two minimum value
        // from the heap each time until
        // its size reduces to 1, extract until
        // all the nodes are extracted.
        while (q.size() > 1) {

            // first min extract.
            HuffmanNode x = q.peek();
            q.poll();

            // second min extract.
            HuffmanNode y = q.peek();
            q.poll();

            // new node f which is equal
            HuffmanNode f = new HuffmanNode();

            // to the sum of the frequency of the two nodes
            // assigning values to the f node.
            f.data = x.data + y.data;
            f.c = '-';

            // first extracted node as left child.
            f.left = x;

            // second extracted node as the right child.
            f.right = y;

            // marking the f node as the root node.
            root = f;

            // add this node to the priority-queue.
            q.add(f);
        }

        // print the codes by traversing the tree
        printCode(root, "");
    }
}
Output:

f: 0
c: 100
d: 101
a: 1100
b: 1101
e: 111
Time complexity: O(nlogn) where n is the number of unique characters. If there are n nodes, extractMin() is called 2*(n - 1) times. extractMin() takes O(logn) time as it calles minHeapify(). So, overall complexity is O(nlogn).
If the input array is sorted, there exists a linear time algorithm. We will soon be discussing in our next post.

Applications of Huffman Coding:
They are used for transmitting fax and text.
They are used by conventional compression formats like PKZIP, GZIP, etc.
Multimedia codecs like JPEG, PNG, and MP3 use Huffman encoding(to be more precise the prefix codes).
 It is useful in cases where there is a series of frequently occurring characters.
 * 
 * 
 */
