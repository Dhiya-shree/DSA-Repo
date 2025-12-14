package greedy_Algo;
/**
 * 
 * 
 * 
 * @author shree
 *
 */
public class Greedy06_Decode_Huffman {

	public static void main(String[] args) {
		// TODONOW Auto-generated method stub

	}

}


//User function Template for Java

/*class MinHeapNode
{
 char data;
 int freq;
 MinHeapNode left, right, top;
 MinHeapNode(char c, int freq)
 {
     left = right = null;
     this.data = c;
     this.freq = freq;
 }
}*/

class Solution {
 // Function to return the decoded string.
 public String decodeHuffmanData(MinHeapNode root, String binaryString) {

     // add your code here
     int n=binaryString.length();
     pointer=-1;
     StringBuilder sb=new StringBuilder();
     while(pointer<n){
         char x= decodeHuffmanDat(root,binaryString,n);
         if(x!='?'){
             sb.append(x);
         }
         else{
             return sb.toString();
         }
             
         }
    return "-1";
     
 }
 
 int pointer;
 public char decodeHuffmanDat(MinHeapNode root, String binaryString,int n) {

    if(root.data!='$'){
       return root.data; 
    }
    pointer++;
    if(pointer>=n){
        return '?';
    }
    if(binaryString.charAt(pointer)=='0'){
        return decodeHuffmanDat(root.left,binaryString,n);
        
    }
    else{
        return decodeHuffmanDat(root.right,binaryString,n);
    }
 }
}
/*
 * 
 * Given an encoded binary string and a Huffman MinHeap tree, your task is to complete the function decodeHuffmanData(), which decodes the binary encoded string and return the original string.

Note: Each node of the min heap contains 2 data members, a character and an integer to denote its frequency. The character '$' is the special character used for internal nodes whose min heap node only need a integer field.

Examples:

Input :
binaryString = 
1111111111110001010101010100010010101010101
Min Heap Tree =  
               $(20)
             /      \
           /          \
        $(8)            \
      /     \             \
   $(3)      \            $(12)
   /  \       \           /    \
B(1)    D(2)    E(5)    C(6)    A(6)

Output: AAAAAABCCCCCCDDEEEEE

Explanation:
The following chart can be made from the 
given min heap tree.
character    frequency    code
   A             6        11               
   B             1        000
   C             6        10
   D             2        001    
   E             5        01

 

Input :
binaryString =
01110100011111000101101011101000111
Min Heap Tree =  
                        $(13)
                     /        \
                   /            \
                 /                \
              $(5)                  \
            /      \                  \
           /        \                   \
        $(3)         \                  $(8)
       /    \         \                /    \
    $(2)     \         \            $(4)     \
   /   \      \         \          /   \      \
f(1)    o(1)    r(1)    g(2)    k(2)    s(2)    e(4)

Output: geeksforgeeks

Explanation:
The following chart can be made from the 
given min heap tree.
character    frequency    code
   f             1        0000                 
   o             1        0001
   r             1        001
   g             2        01    
   k             2        100
   s             2        101
   e             4        11

Expected Approach:
Intuition:
We can iterate through the binary string and follow the path through the Huffman tree as determined by the 0s and 1s in the string. When a leaf node is reached, the corresponding character is added to the decoded string and the current node is reset to the root of the tree.

Example:
binaryString: "1001011"
MinHeapNode:

    '$'
   /   \
 'A'    'B'
        /   \
       'C'   'D'
              / \
             'E' 'F'

Initialize ans to an empty string and curr to the root of the Huffman tree.
Iterate through the characters in the binary string.
The first character is '1', so move the curr pointer to the right child of the current node.
The second character is '0', so move the curr pointer to the left child of the current node.
The third character is '0', so move the curr pointer to the left child of the current node. This node is a leaf node, so add the character 'A' to the ans string and reset the curr pointer to the root of the tree.
The fourth character is '1', so move the curr pointer to the right child of the current node.
The fifth character is '0', so move the curr pointer to the left child of the current node. This node is a leaf node, so add the character 'C' to the ans string and reset the curr pointer to the root of the tree.
The sixth character is '1', so move the curr pointer to the right child of the current node.
The seventh character is '1', so move the curr pointer to the right child of the current node. This node is a leaf node, so add the character 'F' to the ans string and reset the curr pointer to the root of the tree.
Implementation:
Initialize an empty string ans to store the decoded string and a pointer curr to the root of the Huffman tree.
Iterate through the characters in the binary string.
If current character = '0'
move the curr pointer to the left child of the current node.
 If current character ='1'
 move the curr pointer to the right child of the current node.
If both the left and right child of the current node are NULL, (means the current node is a leaf node).
 Add the character at the current node to the ans string and reset the curr pointer to the root of the tree.
Repeat steps 3 and 4 until all characters in the binary string have been processed.
Return the ans string, appended with a null character to indicate the end of the string.
 
Code



//Back-end complete function Template for Java

class Solution {
    public String decodeHuffmanData(MinHeapNode root, String binaryString) {

        String ans = "";
        MinHeapNode curr = root;

        // iterating over the string.
        for (int i = 0; i < binaryString.length(); i++) {
            // if character is "0" then moving to left child of parent node
            // else to the right child.
            if (binaryString.charAt(i) == '0')
                curr = curr.left;
            else
                curr = curr.right;

            // if both the child of current node are null, we add the data
            // at current node in our result and update current node.
            if (curr.left == null && curr.right == null) {
                ans += curr.data;
                curr = root;
            }
        }
        // returning the resultant string.
        return ans + '\0';
    }
}
Complexity:
Time complexity: O(n), The solution involves a single loop through the binary string, which has a length of n. Therefore, the time complexity of the solution is O(n).
Space Complexity: O(1), The solution does not require any additional data structures, so the space complexity is constant at O(1).

Alternate Approach
Intuition:
We can preprocess the Huffman tree and create a map that associates binary codes with characters. Then, we can simply traverse the binary string and decode characters using the map.

Implementation:
Traverse the Huffman tree and create a map that associates binary codes with characters.
Initialize a string to store the decoded result.
Start from the beginning of the binary string and check for the longest prefix in the map.
Append the character associated with the found prefix to the result.
Move the pointer to the next position and repeat steps 3-4 until the entire binary string is processed.
Code



void generateHuffmanCodes(MinHeapNode* root, string code, unordered_map<string, char>& huffmanCodes) {
    if (!root) return;
    
    if (root->data != '$') {
        huffmanCodes[code] = root->data;
        return;
    }
    
    generateHuffmanCodes(root->left, code + "0", huffmanCodes);
    generateHuffmanCodes(root->right, code + "1", huffmanCodes);
}

string decodeHuffmanData(struct MinHeapNode* root, string binaryString) {
    unordered_map<string, char> huffmanCodes;
    generateHuffmanCodes(root, "", huffmanCodes);
    
    string result = "";
    int index = 0;
    
    while (index < binaryString.size()) {
        string prefix = "";
        while (huffmanCodes.find(prefix) == huffmanCodes.end()) {
            prefix += binaryString[index];
            index++;
        }
        
        result += huffmanCodes[prefix];
    }
    
    return result;
}
Complexity:
Time Complexity: O(N + M), where N is the length of the binary string and M is the total number of nodes in the Huffman tree.
Space Complexity: O(M), where M is the total number of nodes in the Huffman tree.

Useful links to help you understand the concepts of this problem:
 */
