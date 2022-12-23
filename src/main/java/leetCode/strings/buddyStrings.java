package leetCode.strings;

public class buddyStrings {
    /*
    Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal
    to B, otherwise, return false.
    Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters
    at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

    Example 1:
    Input: A = "ab", B = "ba"
    Output: true
    Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.

    Example 2:
    Input: A = "ab", B = "ab"
    Output: false
    Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.

    Example 3:
    Input: A = "aa", B = "aa"
    Output: true
    Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.

    Example 4:
    Input: A = "aaaaaaabc", B = "aaaaaaacb"
    Output: true

    Example 5:
    Input: A = "", B = "aa"
    Output: false
     */
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.length() == 2) {
            return A.charAt(1) == B.charAt(0) && A.charAt(0) == B.charAt(1);
        }

        if (A.equals(B)) {
            int[] frequency = new int[26];
            for (int i = 0; i < A.length(); i++) {
                frequency[A.charAt(i) - 'a']++;
                if (frequency[A.charAt(i) - 'a'] >= 2) {
                    return true;
                }
            }
            return false;
        }

        int count = 0;
        char[] a1 = new char[2];
        char[] b1 = new char[2];

        int i = 0, j = 0;

        while (i < A.length()) {
            if (A.charAt(i) != B.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                } else {
                    a1[j] = A.charAt(i);
                    b1[j] = B.charAt(i);
                    j++;
                }
            }
            i++;
        }
        return count != 0 && a1[0] == b1[1] && a1[1] == b1[0];
    }
}
