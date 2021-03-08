public class removePalindromicSubsequences {
    /*
    Given a string s consisting only of letters 'a' and 'b'. In a single step you can remove one palindromic subsequence from s.
    Return the minimum number of steps to make the given string empty.
    A string is a subsequence of a given string, if it is generated by deleting some characters of a given string without changing its order.
    A string is called palindrome if is one that reads the same backward as well as forward.

    Example 1:
    Input: s = "ababa"
    Output: 1
    Explanation: String is already palindrome

    Example 2:
    Input: s = "abb"
    Output: 2
    Explanation: "abb" -> "bb" -> "".
    Remove palindromic subsequence "a" then "bb".

    Example 3:
    Input: s = "baabb"
    Output: 2
    Explanation: "baabb" -> "b" -> "".
    Remove palindromic subsequence "baab" then "b".

    Example 4:
    Input: s = ""
    Output: 0

    Constraints:
        0 <= s.length <= 1000
        s only consists of letters 'a' and 'b'
     */
    //TC: O(n) and constant space used
    public int removePalindromeSub(String s) {
        /*
            since only 2 letters, a and b, are present in the string, the only possible solutions can be either
            0 if the string is empty, 1 if the string is a palindrome, and 2 if the string has both letters a and b since
            in one step we can remove a palindrome composed of one set of letters, and the rest is removed afterwards.
        */
        if (s.length() == 0) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    //Returns true if s is a palindrome, false otherwise
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        //if s is a palindrome of odd length, left and right will be ==, if its of even length left > right
        return left > right || left == right;
    }
}
