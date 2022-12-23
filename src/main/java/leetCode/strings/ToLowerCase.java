package leetCode.strings;

public class ToLowerCase {
    /*
    Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

    Example 1:
    Input: s = "Hello"
    Output: "hello"

    Example 2:
    Input: s = "here"
    Output: "here"

    Example 3:
    Input: s = "LOVELY"
    Output: "lovely"

    Constraints:
        1 <= s.length <= 100
        s consists of printable ASCII characters.
     */
    //TC: O(n)
    public String toLowerCase(String s) {
        if (s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            //if c is in the range of A ascii 65 and Z ascii 90, we need to convert it to lower case
            if (c >= 'A' && c <= 'Z') {
                //to convert c to lowercase, we add the difference between a and A, which is 32
                sb.append((char) (c + ('a' - 'A')));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
