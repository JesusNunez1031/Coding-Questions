package codingbat.recursion_1;

public class countX {
    /*
    Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.

    codingbat.recursion_1.countX("xxhixx") → 4
    codingbat.recursion_1.countX("xhixhix") → 3
    codingbat.recursion_1.countX("hi") → 0
     */
    public int countX(String str) {
        if (str.length() == 0)
            return 0;

        if (str.charAt(0) == 'x')
            return 1 + countX(str.substring(1));

        return countX(str.substring(1));
    }
}
