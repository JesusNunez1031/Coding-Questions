package leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class palindromePartition {
    /*
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.

    Example:
    Input: "aab"
    Output:
    [
      ["aa","b"],
      ["a","a","b"]
    ]
     */

    /*
        TC: O(n * 2^n) where n is the length of the string s and O(n) space due to recursion stack there are a total of
        2^n possible substrings in the worst case
            Ex: given the string aaa n = 4 & total nodes = 2^4 = 8
                                                              aaa
                                                        /      |        \
                                                       /       |         \
                                                ["a"] "aa"   ["aa"] "a"   ["aaa"] ""
                                                   /      \       \
                                                  /        \       ["aa", "a"] ""
                                            ["a","a"] "a"  ["a", "aa"] ""
                                                /
                                               /
                                        ["a", "a", "a"] ""

        for each substring it takes O(n) time to generate and determine if its a valid palindrome or not
     */
    private static List<List<String>> partition(String s) {
        List<List<String>> palindromes = new ArrayList<>();
        List<String> partition = new ArrayList<>();

        generatePartitions(s, palindromes, partition, 0);

        return palindromes;
    }

    private static void generatePartitions(String s, List<List<String>> palindromes, List<String> partition, int start) {
        /*
            when the start is at the length of the string, we've checked for palindromes on the entire string so we add
            the current list to the total list of palindromes
         */
        if (start >= s.length()) {
            palindromes.add(new ArrayList<>(partition));
        }

        for (int i = start; i < s.length(); i++) {
            /*
                at every iteration, we check the substring from start to i for a palindrome, if the substring is a
                palindrome, we add it to the list of partitions
             */
            if (isPalindrome(s, start, i)) {
                partition.add(s.substring(start, i + 1));
                //System.out.println("Partitions: " + partition.toString() + "\nRemaining characters in s: " + s.substring(start + 1));  //see all the partitions being formed so far
                generatePartitions(s, palindromes, partition, i + 1);
                partition.remove(partition.size() - 1);
            }
        }
    }

    //Method to check if a string is a palindrome by comparing its start to its end
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaab";
        System.out.println(partition(s));
    }
}
