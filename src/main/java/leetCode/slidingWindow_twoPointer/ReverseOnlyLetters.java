package leetCode.slidingWindow_twoPointer;

public class ReverseOnlyLetters {
    /*
    Given a string s, reverse the string according to the following rules:
        All the characters that are not English letters remain in the same position.
        All the English letters (lowercase or uppercase) should be reversed.
    Return s after reversing it.

    Example 1:
    Input: s = "ab-cd"
    Output: "dc-ba"

    Example 2:
    Input: s = "a-bC-dEf-ghIj"
    Output: "j-Ih-gfE-dCba"

    Example 3:
    Input: s = "Test1ng-Leet=code-Q!"
    Output: "Qedo1ct-eeLg=ntse-T!"

    Constraints:
        1 <= s.length <= 100
        s consists of characters with ASCII values in the range [33, 122].
        s does not contain '\"' or '\\'.
     */
    //TC: O(n) where n is the length of s
    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] str = s.toCharArray();

        while (left < right) {
            // move left pointer while the current character is not a letter
            while (left < right && !Character.isLetter(str[left])) {
                left++;
            }

            // move the right pointer while the current character is not a letter
            while (right > left && !Character.isLetter(str[right])) {
                right--;
            }

            // swap letter characters
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
        // return swapped letter string
        return new String(str);
    }
}
