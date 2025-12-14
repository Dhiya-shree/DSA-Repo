package hashing_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem #1: Pair with gievn sum in unsorted array
 * In this particular problem, we are presented with an array of integers, and
 * our objective is to find a pair of integers from the array whose sum equals a
 * given target. We return true if we can find such a pair, else we return
 * false. To accomplish this, we will explore two distinct approaches: a Naive
 * approach utilizing nested loops, and an Efficient solution employing Hashing
 * .
 * 
 * Problm #2 : Subarray with zero sum
 * Given an array of positive and negative numbers, find if there is a subarray
 * (of size at-least one) with 0 sum.
 * 
 * Loop fro 0 to n-1 :
 * Add in prev arr sum prev_sum
 * if prev arr value prev_sum==0 return true
 * Or if prc
 * else add the current prev sum obtained in set
 * 
 * For any sum
 * a , b , c , d , e , f
 * On adding sum till f a+b+c+d+e+f = (a+b) sum till b
 * It ca mean only one thing
 * c+d+e+f = 0
 * So we got a+b+c+d+e+f= a+b+0
 * 
 * Thus when current add is present in already observed sum ,the subarray adds
 * to 0.
 * 
 * Corner case :
 * {-3,2,1,5}
 * 
 * prev [] curr -3
 * prev [-3] curr -1
 * prev [-3,-1] curr 0
 * prev [-3,-1,0] curr 5
 * End
 * 
 * To handle this case we check for
 * Sum ==0
 * 
 * 
 * arr[] = {1, 4, -2, -2, 5, -4, 3}
 * 
 * If we consider all prefix sums, we can
 * notice that there is a subarray with 0
 * sum when :
 * 1) Either a prefix sum repeats or
 * 2) Or prefix sum becomes 0.
 * 
 * Prefix sums for above array are:
 * 1, 5, 3, 1, 6, 2, 5
 * 
 * Since prefix sum 1 repeats, we have a subarray
 * with 0 sum.
 * 
 * 
 * Problem #3 : Zero Sum Subarray
 * 
 * You are given an array arr[] of size n. Find the total count of sub-arrays
 * having their sum equal to 0.
 * 
 * 
 * Sol :
 * 
 * Create a hashmap
 * Loop from 0 to n-1 as i
 * -> Find sum pre array
 * -> If pre_sum==0 increment count
 * -> if pre_sum is preset
 * Increment count in while loop ... till count is 0
 * Update the pre_sum value with 1
 * -> else add the pre_sum with value 0
 * 
 * calculate the prefixSum for every element
 * now check how many times the particular prefixSum is repeat (let's say x
 * times repeat), then our answer is the summation of whole these (x*(x-1))/2
 * example {0,0,5, 5, 0, 0}
 * prefix sum = 0 0 5 10 10 10
 * particular prefixSum it's cnt / repeatition (x)
 * 0 2
 * 5 1
 * 10 3
 * answer = ( (2*1)/2 + (1*0)/2 +(3*2)/2 )
 * for => 0(x = 2) 5(x = 1) 10(x = 3)
 * hence answer = 1 + 0 + 3 = 4
 * But wait we should also have to add 2 in our answer, as that's the special
 * conditions which we've to always remembered that how many times we get 0 in
 * our prefixSum==> so 0 count is 2
 * Hence our final answer will be,
 * Answer = 4 + 2 = 6
 * 
 * 
 * Problem #4 : Subarray with given sum
 *
 * 
 * 
 * Sol :
 * 
 * Loop from 0 to n-1 as i
 * -> Find curr_sum sum till i
 * -> diff= curr_sum - sum
 * if diff found in prev_sum HS
 * Return true
 * -> Add prev_sum , hm.put(curr_sum)
 * 
 * Ex 1 2 3 4 5 6 7 8 sum:25
 * 
 * prev sum : 1 3 6 10 15 21 28 .....
 * At curr sum : 28
 * Diff = 28-25
 * 3 present in prev_sum -> return true
 * 
 * 2 3 4 6 sum: 9
 * prev sum : 2 5 9 15
 * At 9 : diff=9-9 not present in hm
 * So have cndt to check cur_sum==sum
 * if true return ;
 * 
 * Problem #5 : Count of Sub array with given sum
 * Sol :
 * 
 * Loop from 0 to n-1 as i
 * -> Find curr_sum sum till i
 * -> if prev_sum==sum
 * count++
 * -> diff= curr_sum - sum
 * if diff found in prev_sum HS
 * cont=count+freq
 * -> Add prev_sum , hm.put(curr_sum,freq)
 * 
 * 
 * @author shree
 *
 */
public class Hashing08_sums_medium {

    public static void main(String[] args) {
        // Medium sums

        int arr[] = { 1, 2, 2, 5, 5, 8, 3, 4, 10, 11, 17, 5, 12, 15, 17, 23, 12, 14, 15, 2, 3, 4, 1 };
        int n = arr.length;
        int sum = 15;

        boolean bans = FindSumPair(arr, n, sum);
        System.out.println(" Ans sum pair " + bans);

        int arr2[] = { 1, -2, 2, 5, -5, 8, -3, 4, 10, 11, 17, -5, -12, 15, 17, -15, 12, -14, 2, 0 };
        int n2 = arr2.length;
        bans = find0sumSubArray(arr2, n2);
        System.out.println(" Store prev array O n method " + bans);

        int ans = ZeroSumSbArrayCount(arr2, n2);
        System.out.println(" Count of zero sum sub array is " + ans);

        bans = SubArrayWithSum(arr, n, 46);
        System.out.println(" Array sub with size is found is " + bans);

        ans = CountOfSubArrayThatGivesSumarr(arr, n, 10);
        System.out.println(" Count is " + ans);

        int arr3[] = { 16, 16, 16, 0, 3, 13, 25, 21 };// {16 ,9, 19 ,19 ,16 ,16 ,13 ,25 ,24 ,24 ,7 ,17 ,22 ,5 ,21 ,2 ,22
                                                      // ,4 ,22, 10, 5, 15, 0 ,
        // 3 ,13, 7 ,25, 12};//sum 16// {10,2,-2,-20,-10}; sum -10
        int n3 = arr3.length;
        ans = CountOfSubArrayThatGivesSumarr(arr3, n3, 16);
        System.out.println(" Count is " + ans);

    }

    private static int CountOfSubArrayThatGivesSumarr(int[] arr, int n, int sum) {
        // Create hashset
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int prev_sum = 0;
        int diff = 0;
        // To count no of subarray
        int count = 0;
        int freq = 0;
        for (int i = 0; i < n; i++) {
            // Find prev sum
            prev_sum = prev_sum + arr[i];
            // case

            diff = prev_sum - sum;

            if (prev_sum == sum || diff == 0) {
                count++;
                ;
            }

            System.out.println(" Count " + count + " prev " + prev_sum + " diff " + diff);
            System.out.println(i + " Prev sum " + hm.toString());
            if (hm.containsKey(diff)) {
                freq = hm.get(diff);
                // System.out.println(" Diff is "+diff+ " with freq "+freq+"..count "+count);

                // hm.put(diff,freq+1);
                count = count + freq;
                System.out.println(" Diff is " + diff + " with freq " + freq + "..count " + count);
            }

            if (hm.containsKey(prev_sum)) {
                freq = hm.get(prev_sum);
                System.out.println(" prev sum is " + prev_sum + " with freq " + freq + "..count " + count);

                hm.put(prev_sum, freq + 1);
            } else {
                hm.put(prev_sum, 1);
            }

        }
        System.out.println(" Prev sum " + hm.toString());
        hm.clear();
        return count;
    }

    private static boolean SubArrayWithSum(int[] arr, int n, int sum) {
        // Create hashset
        Set<Integer> hs = new HashSet<Integer>();
        int prev_sum = 0;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            // Find prev sum
            prev_sum = prev_sum + arr[i];
            // case
            if (prev_sum == sum) {
                return true;
            }
            diff = prev_sum - sum;

            if (hs.contains(diff)) {
                return true;
            }
            hs.add(prev_sum);

        }

        return false;
    }

    private static int ZeroSumSbArrayCount(int[] arr, int n) {
        // Create hashmap to store prev_sum and occurence
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        // Create presum , count , freq
        int prev_sum = 0;
        int count = 0;
        int freq = 0;

        // Loop through array
        for (int i = 0; i < n; i++) {

            // Prev sum - > sum of all elements till i
            prev_sum = prev_sum + arr[i];

            // Check if prev_sum if zero
            // To handle case when count of all element with i gives 0
            if (prev_sum == 0) {
                count++;
            }

            // Check if presum already present
            // Increment count and freq
            if (hm.containsKey(prev_sum)) {
                freq = hm.get(prev_sum);
                // Increment freq
                hm.put(prev_sum, freq + 1);

                // Based on freq increment count
                count = count + freq;
            } else {
                // If not present
                // Add with freq 1
                hm.put(prev_sum, 1);
            }

        }
        return count;
    }

    private static boolean find0sumSubArray(int arr[], int n) {
        // Your code here
        HashSet<Integer> hs = new HashSet<Integer>(n);
        int prev_arr = 0;
        for (int i = 0; i < n; i++) {

            prev_arr = prev_arr + arr[i];
            // Get sub array till the point i , and check if
            // Every element before i is 0

            // -3 -2 -1 6 5 7
            // At i=3 at 6 we have
            // Prev arr {-3,-2,-1}whose sum saved in
            // Hs as -3 , -5 ,-6
            // At 6 ,-6+6=0 return

            // -3 -2 -1 5 1
            // At i=3 at 5 we have
            // Prev arr {-3,-2,-1}whose sum saved in
            // Hs as -3 , -5 ,-6

            // After 5 & 1 we have zero - true

            // 4 2 -3 1 6
            // prev arr [] at 4 , curr: 4
            // prev arr [4] at 2 , curr: 6
            // Prev arr[4,6] at -3 , curr:3
            // prev arr[4,6,3] at 1 , curr:4
            // prev arr found already present
            // STop true

            // After adding 4 val + Wuith sub array 0 ( 2,-3,1)
            // At pos 1 , we have the val as 4
            // Thus when curr sum == aleady in sub array we break
            // As only possibility is you got a sum of zero n between

            System.out.println(hs.toString());
            System.out.println(prev_arr + "....");

            // No need to chek for - prev arr
            // For -3 1 2 4 5
            // 1:-3-> -3
            // 2:1 -> -2 in arr -3,1
            // 3:2 -> 0 in arr -3,1,2 ( So wont be true )

            // Condt for prev_arr 0 is MUST !!!!!!!
            if (prev_arr == 0 || arr[i] == 0) {
                System.out.println("O1" + prev_arr);
                return true;
            }

            if (hs.contains(prev_arr)) {
                System.out.println("C1" + prev_arr + "..arrr " + arr[i]);
                return true;
            }

            // Add the sub array till that point
            hs.add(prev_arr);

        }
        /*
         * if(prev_arr==0 || arr[n-1]==0){
         * System.out.println("O2"+prev_arr);
         * return true;
         * }
         * 
         * if(hs.contains(prev_arr)){
         * System.out.println("C2"+prev_arr);
         * return true;
         * }
         */
        return false;

    }

    private static boolean FindSumPair(int[] arr, int n, int sum) {
        // While adding elements in hashmap
        // Check if its diff is present
        int diff = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            diff = sum - arr[i];
            if (hs.contains(diff)) {
                return true;
            }
        }
        return false;
    }

}

/**
 * Subarray 0
 * 
 * Given an array of positive and negative numbers, find if there is a subarray
 * (of size at-least one) with 0 sum.
 * 
 * Examples :
 * 
 * 
 * Input: {4, 2, -3, 1, 6}
 * Output: true
 * Explanation:
 * There is a subarray with zero sum from index 1 to 3.
 * 
 * Input: {4, 2, 0, 1, 6}
 * Output: true
 * 
 * Explanation :
 * 
 * The third element is zero. A single element is also a sub-array.
 * 
 * Input: {-3, 2, 3, 1, 6}
 * Output: false
 * 
 * 
 * A simple solution is to consider all subarrays one by one and check the sum
 * of every subarray. We can run two loops: the outer loop picks a starting
 * point i and the inner loop tries all subarrays starting from i (See this for
 * implementation). The time complexity of this method is O(n2).
 * We can also use hashing. The idea is to iterate through the array and for
 * every element arr[i], calculate the sum of elements from 0 to i (this can
 * simply be done as sum += arr[i]). If the current sum has been seen before,
 * then there is a zero-sum array. Hashing is used to store the sum values so
 * that we can quickly store sum and find out whether the current sum is seen
 * before or not.
 * 
 * 
 * Example :
 * 
 * arr[] = {1, 4, -2, -2, 5, -4, 3}
 * 
 * If we consider all prefix sums, we can
 * notice that there is a subarray with 0
 * sum when :
 * 1) Either a prefix sum repeats or
 * 2) Or prefix sum becomes 0.
 * 
 * Prefix sums for above array are:
 * 1, 5, 3, 1, 6, 2, 5
 * 
 * Since prefix sum 1 repeats, we have a subarray
 * with 0 sum.
 * 
 * Following is implementation of the above approach.
 * 
 * 
 * 
 * // A Java program to find
 * // if there is a zero sum subarray
 * import java.util.HashSet;
 * import java.util.Set;
 * 
 * class ZeroSumSubarray
 * {
 * // Returns true if arr[]
 * // has a subarray with sero sum
 * static Boolean subArrayExists(int arr[])
 * {
 * // Creates an empty hashset hs
 * Set<Integer> hs = new HashSet<Integer>();
 * 
 * // Initialize sum of elements
 * int sum = 0;
 * 
 * // Traverse through the given array
 * for (int i = 0; i < arr.length; i++)
 * {
 * // Add current element to sum
 * sum += arr[i];
 * 
 * // Return true in following cases
 * // a) Current element is 0
 * // b) sum of elements from 0 to i is 0
 * // c) sum is already present in hash set
 * if (arr[i] == 0
 * || sum == 0
 * || hs.contains(sum))
 * return true;
 * 
 * // Add sum to hash set
 * hs.add(sum);
 * }
 * 
 * // We reach here only when there is
 * // no subarray with 0 sum
 * return false;
 * }
 * 
 * // Driver code
 * public static void main(String arg[])
 * {
 * int arr[] = { -3, 2, 3, 1, 6 };
 * if (subArrayExists(arr))
 * System.out.println(
 * "Found a subarray with 0 sum");
 * else
 * System.out.println("No Such Sub Array Exists!");
 * }
 * }
 * 
 * 
 * 
 * Output
 * No Such Sub Array Exists!
 * 
 * 
 * Time Complexity of this solution can be considered as O(n) under the
 * assumption that we have good hashing function that allows insertion and
 * retrieval operations in O(1) time.
 * Space Complexity: O(n) .Here we required extra space for unordered_set to
 * insert array elements.
 * 
 * 
 */

/*
 * Here is my observation:
 * 
 * Index { 0, 1, 2, 3, 4, 5, 6, 7}
 * 
 * If the array is { 5, -2, 2, 3, -3, 1, 2, -2}
 * 
 * so the prefix sum array will be { 5, 3, 5, 8, 5, 6, 8, 6}
 * 
 * 
 * 
 * Now there is a zero-sum subarray from index 3 to 4, {-2, 2}. So the prefix
 * sum of index 2 is repeated at index 4. The same thing is happening for
 * sub-array {3, -3} and {-2, 2, 3, -3}.
 * 
 * So we can say that if the prefix sum at index l repeats at index r, there is
 * a zero-sum subarray from l+1 to r.
 * 
 * 
 * 
 * How to count the sub-arrays.
 * 
 * 
 * 
 * Now for a prefix sum [ prefix_sum[i] ],
 * 
 * if the count is 2 then there is 1 zero-sum subarray
 * 
 * if the count is 3 then there is 3 zero-sum subarray
 * 
 * if the count is 4 then there is 6 zero-sum subarray
 * 
 * if the count is n then there is nC2 = (n*(n-1))/2 zero-sum subarray
 * 
 * 
 * 
 * for the given array
 * 
 * count of presum value 5 is 3, so the ans is (3*2)/2=3,
 * 
 * count of presum value 8 is 2, so the ans is 3+(2*1)/2 = 3+1 = 4
 * 
 * count of presum value 6 is 2, so the ans is 4+(2*1)/2 = 4+1 = 5
 * 
 * 
 * 
 * Now if the array is { 0 0 1}
 * 
 * so the prefix sum array will be { 0 0 1}
 * 
 * count of 0 is 2, so the ans is (2*1)/2 = 1
 * 
 * This is wrong, we are considering the subarray {0, 0} only.
 * 
 * We have to consider {0}, {0} subarrays also.
 * 
 * To handle this case, if the value of presum is 0, we have to increase the
 * answer.
 *
 * 
 * TC : O(n) , SC : O(n)
 * 
 * Idea : If we can store the contigous sub array sum using kadane's algorithm
 * in a hasmap
 * 
 * We know that for N length array the total number of sub arrays will be
 * (N)*(N+1)/2 .
 * 
 * In Hashmap we will have the prefix sum count.
 * 
 * If sum == 0 , we will include ans += (val)*(val+1)/2
 * 
 * If sum > 0 , thats means we have exclude 1 sub array and count total number
 * of subarrays for (val-1),
 * 
 * so if sum > 0 , ans += (val-1)*((val-1)+1)/2;
 * 
 * return the total count (ans)
 * 
 * 
 * 
 * public static long findSubarray(long[] arr ,int n)
 * {
 * //Your code here
 * HashMap<Long,Integer> map = new HashMap<>();
 * long sum = 0;
 * for(int i =0 ; i < n ; i++){
 * sum = sum + arr[i];
 * if(!map.keySet().contains(sum)){
 * map.put(sum,1);
 * }
 * else{
 * map.put(sum,map.get(sum)+1);
 * }
 * }
 * long ans = 0;
 * for(Map.Entry<Long,Integer> entry : map.entrySet()){
 * int val = entry.getValue();
 * if(entry.getKey() == 0){
 * ans = ans + ( ((val)*(val+1)) / 2 );
 * }
 * else{
 * ans = ans + ( ((val-1)*(val)) / 2 );
 * }
 * }
 * return ans;
 * 
 * }TC : O(n) , SC : O(n)
 * 
 * Idea : If we can store the contigous sub array sum using kadane's algorithm
 * in a hasmap
 * 
 * We know that for N length array the total number of sub arrays will be
 * (N)*(N+1)/2 .
 * 
 * In Hashmap we will have the prefix sum count.
 * 
 * If sum == 0 , we will include ans += (val)*(val+1)/2
 * 
 * If sum > 0 , thats means we have exclude 1 sub array and count total number
 * of subarrays for (val-1),
 * 
 * so if sum > 0 , ans += (val-1)*((val-1)+1)/2;
 * 
 * return the total count (ans)
 * 
 * 
 * 
 * public static long findSubarray(long[] arr ,int n)
 * {
 * //Your code here
 * HashMap<Long,Integer> map = new HashMap<>();
 * long sum = 0;
 * for(int i =0 ; i < n ; i++){
 * sum = sum + arr[i];
 * if(!map.keySet().contains(sum)){
 * map.put(sum,1);
 * }
 * else{
 * map.put(sum,map.get(sum)+1);
 * }
 * }
 * long ans = 0;
 * for(Map.Entry<Long,Integer> entry : map.entrySet()){
 * int val = entry.getValue();
 * if(entry.getKey() == 0){
 * ans = ans + ( ((val)*(val+1)) / 2 );
 * }
 * else{
 * ans = ans + ( ((val-1)*(val)) / 2 );
 * }
 * }
 * return ans;
 * 
 * }
 * 
 * 
 */
