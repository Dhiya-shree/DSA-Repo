package string_code;

public class String14_Power_Set_Hard {
/**
 * Brute Force Approach[Accepted]
Intuition
The idea employed here is to generate all possible subsequences of a given string in lexicographically sorted order using a bitmasking approach. Each bit in the bitmask represents whether the corresponding character in the string should be included or excluded in the current subsequence. The algorithm systematically explores all possible combinations of characters by iterating through all possible bitmasks. This approach ensures a sorted and comprehensive list of subsequences is generated.

Implementation
Helper Function k:
k function takes a vector v, string s, the index n, and a bitmask num as parameters.
It generates a string st by including characters from s based on the set bits in the binary representation of num.
Adds the generated string st to the vector v.
Helper Function p:
p function recursively generates all possible subsequences by calling k for each bitmask from num to 1.
Sorts the vector v after generating all subsequences.
Main Function AllPossibleStrings:
Initializes an empty vector v to store the subsequences.
Calculates the initial value of num as (1 << s.size()) - 1 to represent all possible subsequences.
Calls the recursive function p to generate subsequences.
Returns the sorted vector v.
Code
class Solution
{
    public void k(List<String> v, String s, int n, int num) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            if ((num & (1 << i)) != 0) {
                st.append(s.charAt(i));
            }
        }
        v.add(st.toString());
    }

    public void p(List<String> v, String s, int n, int num) {
        if (num == 0) {
            return;
        }
        k(v, s, n, num);
        p(v, s, n, num - 1);
    }
    public List<String> AllPossibleStrings(String s)
    {
         List<String> v = new ArrayList<>();
        int n = s.length() - 1;
        int num = (1 << s.length()) - 1;
        p(v, s, n, num);
        Collections.sort(v);
        return v;
        // Code here
    }
}
Complexity
Time Complexity: O(2^n * n), where n is the length of the input string s.
Space Complexity: O(2^n * n), where n is the length of the input string s. The space is used to store all possible subsequences.
Expected Approach
Intuition
The approach utilizes bitmasking to represent inclusion/exclusion of characters in subsequences. By iterating through all possible subsets, the algorithm constructs subsequences using set bits in the bitmask. This ensures systematic generation of subsequences. Sorting the result guarantees lexicographically-sorted order, fulfilling the required output condition.

Implementation
Initialize Result Vector: Create an empty vector res to store the result.
Calculate String Size: Calculate the size n of the input string s.
Generate Subsets using Bitmasking: Iterate over all possible subsets of characters in the string using a bitmasking approach. For each subset, create a temporary string temp to store the characters of the subset.
Check Bitmask and Build Subset: For each character in the string, check if the corresponding bit is set in the bitmask. If set, add the character to the temporary string temp.
Check Empty Subset: Check if the temporary string temp is not empty to avoid adding empty strings to the result.
Sort Result Vector: Sort the result vector res in lexicographical order.
Return Result: Return the sorted result vector.
Code
class Solution {
    // Function to generate all possible strings from a given string.
    public List<String> AllPossibleStrings(String s) {
        // Creating a list to store the result.
        List<String> ans = new ArrayList<>();
        // Calculating the size of the string.
        int n = s.length();
        // Using StringBuilder for efficient string concatenation.
        StringBuilder sb = new StringBuilder();

        // Iterating over all possible subsets of characters in the string.
        // Using a bitmasking approach.
        for (int mask = 1; mask < (1 << n); mask++) {
            // Resetting the StringBuilder for each subset.
            sb.setLength(0);

            // Iterating over each character in the string.
            for (int i = 0; i < n; i++) {
                // Checking if the ith character should be included in the subset or not
                // by checking if the ith bit is set in the bitmask.
                if (((mask >> i) & 1) == 1) {
                    // If yes, appending the character to the StringBuilder.
                    sb.append(s.charAt(i));
                }
            }

            // Adding the subset (as a string) to the result list.
            ans.add(sb.toString());
        }

        // Sorting the result list in lexicographical order.
        Collections.sort(ans);

        // Returning the result list.
        return ans;
    }
}
Complexity
Time Complexity: O(n * 2^n), because, for each character in the string, there are 2 possibilities (include or exclude) in each subset, leading to a total of 2^n subsets.
Space Complexity: O(n * 2^n), as each subset and the result vector contribute to the space complexity.
Useful links to help you understand the concepts of this p
 * 
 */
}
