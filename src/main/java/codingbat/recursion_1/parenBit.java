package codingbat.recursion_1;

public class parenBit {
    /*
    Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the
    parenthesis and their contents, so "xyz(abc)123" yields "(abc)".

    codingbat.recursion_1.parenBit("xyz(abc)123") → "(abc)"
    codingbat.recursion_1.parenBit("x(hello)") → "(hello)"
    codingbat.recursion_1.parenBit("(xy)1") → "(xy)"
     */
    public String parenBit(String str) {
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            return str;
        }

        if (str.charAt(0) == '(') {
            return parenBit(str.substring(0, str.length() - 1));
        }

        return parenBit(str.substring(1));
    }
}
