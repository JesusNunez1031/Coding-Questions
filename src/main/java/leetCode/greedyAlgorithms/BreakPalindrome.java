package leetCode.greedyAlgorithms;

public class BreakPalindrome {
    /*
    Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase
    English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.

    Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

    A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b
    differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is
    lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is
    smaller than 'd'.

    Example 1:
    Input: palindrome = "abccba"
    Output: "aaccba"
    Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
    Of all the ways, "aaccba" is the lexicographically smallest.

    Example 2:
    Input: palindrome = "a"
    Output: ""
    Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.

    Example 3:
    Input: palindrome = "aa"
    Output: "ab"

    Example 4:
    Input: palindrome = "aba"
    Output: "abb"

    Constraints:
        1 <= palindrome.length <= 1000
        palindrome consists of only lowercase English letters.
     */
    //TC: O(n)
    public String breakPalindrome(String palindrome) {
        // a string of length 1 is always a palindrome
        if (palindrome.length() < 2) {
            return "";
        }
        char[] str = palindrome.toCharArray();
        /*
            the first non 'a' character encountered will generate the smallest non-palindrome string if changed to 'a'.
            This condition holds true as long as we do not exceed half of the length of the string since if the first n/2
            characters are 'a', the latter half will also be 'a', so all we need to do is change the last character to
            'b' to satisfy the condition, and it's exclusively the last character that is changed to ensure the lowest
            lexicographical order
        */
        for (int i = 0; i < str.length / 2; i++) {
            if (str[i] != 'a') {
                str[i] = 'a';
                return String.valueOf(str);
            }
        }

        // first half of character are 'a' so update the end of the palindrome string to 'b'
        str[str.length - 1] = 'b';

        return String.valueOf(str);
    }
}
