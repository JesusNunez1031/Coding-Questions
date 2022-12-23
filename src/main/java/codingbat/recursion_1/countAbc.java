package codingbat.recursion_1;

public class countAbc {
    /*
    Count recursively the total number of "abc" and "aba" substrings that appear in the given string.

    codingbat.recursion_1.countAbc("abc") → 1
    codingbat.recursion_1.countAbc("abcxxabc") → 2
    codingbat.recursion_1.countAbc("abaxxaba") → 2
     */
    public int countAbc(String str) {
        if (str.length() <= 2) {
            return 0;
        }

        if (str.startsWith("aba") || str.startsWith("abc")) {
            return 1 + countAbc(str.substring(2));
        }

        return countAbc(str.substring(1));
    }
}
