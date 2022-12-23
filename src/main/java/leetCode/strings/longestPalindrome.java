package leetCode.strings;

import java.util.HashSet;
import java.util.Set;

public class longestPalindrome {
    /*
    Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that
    can be built with those letters.
    Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

    Example 1:
    Input: s = "abccccdd"
    Output: 7
    Explanation:
    One longest palindrome that can be built is "dccaccd", whose length is 7.

    Example 2:
    Input: s = "a"
    Output: 1

    Example 3:
    Input: s = "bb"
    Output: 2

    Constraints:
        1 <= s.length <= 2000
        s consists of lowercase and/or uppercase English letters only.
     */
    //TC/S: O(n)
    public int longestPalindrome(String s) {
        //store the frequency of all the characters in s into an array
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        //length of longest palindrome
        int length = 0;
        boolean odd = false; //flag to indicate when a character of odd frequency is found

        for (int f : freq) {
            //set flag to true if an odd frequency is found
            if (f % 2 == 1) {
                odd = true;
            }
            /*
                if the frequency of a character is even, add it to the length since any even frequency can be made into
                a palindrome, if its not even, add its frequency - 1 to make it even
             */
            length += f % 2 == 0 ? f : f - 1;
        }

        /*
            if we saw an odd frequency, we added f - 1 so in the case that the odd count was 1, we add +1 to the final
            length since a palindrome can have a single character in the center
         */
        return odd ? length + 1 : length;
    }

    public int longestPalindromeEz(String s) {
        Set<Character> set = new HashSet<>();

        //the remaining characters in the set are the characters whose count is odd in s
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }

        //the final length is the length of s minus all the odd character counts
        int maxLength = s.length() - set.size();

        //if the set is not empty, a palindrome can contain a single odd character, hence we return maxLength + 1
        if (set.size() != 0) {
            return maxLength + 1;
        }
        return maxLength;
    }
}
