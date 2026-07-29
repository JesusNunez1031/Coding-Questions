package leetCode.strings;

public class RotateString {
    /*
        Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
        A shift on s consists of moving the leftmost character of s to the rightmost position.

        For example, if s = "abcde", then it will be "bcdea" after one shift.

        Example 1:
        Input: s = "abcde", goal = "cdeab"
        Output: true

        Example 2:
        Input: s = "abcde", goal = "abced"
        Output: false

        Constraints:
            - 1 <= s.length, goal.length <= 100
            - s and goal consist of lowercase English letters.
     */

    // TC: O(n^2) | worst case n possible rotation points can be tried and for each it compares a string of lengh n
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        char c = goal.charAt(0); // take the first character of goal
        int i = s.indexOf(c); // start rotating s from the first character of the goal

        while (i != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i)); // append the suffix of s from i to the string
            sb.append(s.substring(0, i)); // append prefix to the string
            // check if the current "rotation" of s matches the goal
            if (sb.toString().equals(goal)) {
                return true;
            }
            // if no match, search for the next occurrence of the first character of goal in s
            i = s.indexOf(c, i + 1);
        }
        return false;
    }

    // TC: O(n)
    public boolean rotateStringEz(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // create a string made up of two strings s concatenated together then check if the goal can be found
        // within the new string. If it can be found, then the goal is a rotation of s.
        String combined = s + s;
        return combined.contains(goal);
    }
}

