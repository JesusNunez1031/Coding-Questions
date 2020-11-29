public class strDist {
    /*
    Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with
    sub and return its length.

    strDist("catcowcat", "cat") → 9
    strDist("catcowcat", "cow") → 3
    strDist("cccatcowcatxx", "cat") → 9
     */
    public int strDist(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        }

        boolean equals = str.startsWith(sub);

        if (equals && str.endsWith(sub)) {
            return str.length();
        }

        if (!equals)
            return strDist(str.substring(1), sub);

        return strDist(str.substring(0, str.length() - 1), sub);
    }
}
