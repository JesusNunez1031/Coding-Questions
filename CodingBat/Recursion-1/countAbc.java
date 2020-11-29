public class countAbc {
    /*
    Count recursively the total number of "abc" and "aba" substrings that appear in the given string.

    countAbc("abc") → 1
    countAbc("abcxxabc") → 2
    countAbc("abaxxaba") → 2
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
