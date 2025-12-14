package disjointSet_SegmentTree_Trie;
/**
 * 
 * Largest Sum Contiguous Subarray in Range
Difficulty: MediumAccuracy: 68.57%Submissions: 4K+Points: 4Average Time: 45m
Given an Array arr of size N, and Q queries of two types 1 and 2. In the type-1 query, you will be given a range (left, right) and the task is to print the Largest sum Contiguous Subarray from the Array arr between the range (left, right). For type 2 queries, you will be given the index, an integer value, you need to update value to arrindex.

Example 1:

Input:
N = 8, Q = 3
arr[] = {-2,-3,4,-1,-2,1,5,-3}
Queries: query(5,8)
         update(1,11)
         query(1,3)
Output:
6
12
Explanation: In the first query, the task
is to print the largest sum of contiguous
subarray in range 5-8, which consists of
{-2, 1, 5, -3}. The largest sum is 6,
which is formed by the subarray {1, 5}.
In the second query, an update operation
is done, which updates a[1] to 10, hence
the sequence is {10,-3,4,-1,-2,1,5,-3}. 
In the third query, the task is to print 
the largest sum of a contiguous subarray
in range 1-3, which consists of {10,-3,4}
The largest sum is 11, which is formed by
the subarray {10, -3, 4}.
Your Task:
Your task is to complete the function query() that should return the Largest Sum Contiguous Subarray in the given range and update() that should update the value in the array. A Tree has been already implemented for you(see driver's code)

Constraints:
1 <= N <= 103
1 <= Q <= 500
-103 <= A[] <= 103
1 <= left,right <= N 
1 <= Index <= N
 * 
 * Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/range-query-largest-sum-contiguous-subarray/
Also Explore our Best 
 * @author shree
 *
 */
public class DST16_LargestSum_Continuous_Subarray {

}



static void updateUtil(int arr[],int index,int low,int high,int idx,int value) 
{ 
    if (low == high) 
    { 
        tree[index].sum = value; 
        tree[index].prefixsum = value; 
        tree[index].suffixsum = value; 
        tree[index].maxsum = value; 
    }  
    else
    { 
        int mid = (low + high) / 2; 
  
        //if node to be updated is in left subtree.
        if (idx <= mid) 
        { 
            updateUtil(arr, 2 * index + 1, low, mid, idx, value); 
        }  
        //else node to be updated is in right subtree.
        else 
        { 
            updateUtil(arr, 2 * index + 2, mid + 1, high, idx, value); 
        } 
  
        // parent node's sum is the summation of left  
        // and rigth child 
        tree[index].sum = tree[2 * index + 1].sum + 
                          tree[2 * index + 2].sum; 
  
        // parent node's prefix sum will be equivalent 
        // to maximum of left child's prefix sum or left  
        // child sum + right child prefix sum. 
        tree[index].prefixsum = Math.max(tree[2 * index + 1].prefixsum,  
                                         tree[2 * index + 1].sum +  
                                         tree[2 * index + 2].prefixsum); 
  
        // parent node's suffix sum will be equal to right 
        // child suffix sum or rigth child sum + suffix  
        // sum of left child 
        tree[index].suffixsum = Math.max(tree[2 * index + 2].suffixsum,  
                                         tree[2 * index + 2].sum +  
                                         tree[2 * index + 1].suffixsum); 
  
        // maxum will be the maximum of prefix, suffix of 
        // parent or maximum of left child or right child 
        // and summation of left child's suffix and  
        // right child's prefix. 
        tree[index].maxsum = Math.max(tree[index].prefixsum,  
                             Math.max(tree[index].suffixsum, 
                             Math.max(tree[2 * index + 1].maxsum,  
                             Math.max(tree[2 * index + 2].maxsum, 
                                      tree[2 * index + 1].suffixsum +  
                                      tree[2 * index + 2].prefixsum)))); 
    } 
} 


static node queryUtil(int arr[], int index, int low, int high, int l, int r)  
{ 
    node result = new node(); 
    
    //initially all the values are Integer.MIN_VALUE. 
    result.sum=result.prefixsum=result.suffixsum=result.maxsum=Integer.MIN_VALUE; 
  
    //if segment of this node is outside the given range, we return result.
    if (r < low || high < l) 
    { 
        return result; 
    } 
  
    //if segment of this node is a part of given range, we return tree[index].
    if (l <= low && high <= r) 
    { 
        return tree[index]; 
    } 
  
    //if a part of this segment overlaps with the given range, we call
    //the function recursively for the children nodes accordingly.
    int mid = (low + high) / 2; 
    if (l > mid)  
    { 
        return queryUtil(arr, 2 * index + 2, mid + 1, high, l, r); 
    } 
    if (r <= mid) 
    { 
        return queryUtil(arr, 2 * index + 1,low, mid, l, r); 
    } 
  
    node left = queryUtil(arr, 2 * index + 1,low, mid, l, r); 
    node right = queryUtil(arr, 2 * index + 2, mid + 1, high, l, r); 
  
    //finding the maximum and returning it.
    result.sum = left.sum + right.sum; 
    result.prefixsum = Math.max(left.prefixsum,left.sum + right.prefixsum); 
  
    result.suffixsum = Math.max(right.suffixsum,right.sum + left.suffixsum);
    
    result.maxsum = Math.max(result.prefixsum, 
                    Math.max(result.suffixsum, 
                    Math.max(left.maxsum, 
                    Math.max(right.maxsum, left.suffixsum + 
                             right.prefixsum)))); 
  
    return result; 
} 

//Function to update a value in input array and segment tree.
static void update(int arr[], int arrSize, int index, int value)
{
	arr[index-1]=value;
	
	//updating the value of nodes in segment tree.
	updateUtil(arr, 0, 0, arrSize-1, index-1, value);
}

//Funciton to return the Maximum-Sum in the range.
static int query(int arr[], int n, int left, int right) 
{
	return queryUtil(arr, 0, 0, n - 1, left - 1, right - 1).maxsum;
}
  

