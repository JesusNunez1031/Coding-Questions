public class firstLetterOfWordInString {
    /*
    Given a string S, the task is to output a string with the first letter of every word in the string.

    Example 1:
    Input: geeks for geeks
    Output: gfg
    Explanation: First alphabet of every word
    required.

    Example 2:
    Input: bad is good
    Output: big
    Explanation: First alphabet of every word
    required.
     */
    public String firstAlphabet(String S) {
        if (S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (i == 0) {
                sb.append(c);
            } else if (c == ' ') {
                sb.append(S.charAt(i + 1));
            }
        }
        return sb.toString();
    }
}
