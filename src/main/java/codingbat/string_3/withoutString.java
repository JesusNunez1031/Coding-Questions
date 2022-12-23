package codingbat.string_3;

public class withoutString {
    /*
    Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive).
    You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".

    codingbat.string_3.withoutString("Hello there", "llo") → "He there"
    codingbat.string_3.withoutString("Hello there", "e") → "Hllo thr"
    codingbat.string_3.withoutString("Hello there", "x") → "Hello there"
     */

    public String withoutString(String base, String remove) {
        int blen = base.length();
        int rlen = remove.length();

        String lowbase = base.toLowerCase();
        String lowrem = remove.toLowerCase();
        //We use string builder to avoid potential n^2 time complexity if base is long; += operation on a normal string can cost alot
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < blen; i++) {
            if (i <= blen - rlen) {
                String tmp = lowbase.substring(i, i + rlen);
                if (!tmp.equals(lowrem))
                    sb.append(base.substring(i, i + 1));
                else {
                    i += rlen - 1;
                }
            } else {
                String tmp2 = lowbase.substring(i, i + 1);
                if (!tmp2.equals(lowrem))
                    sb.append(base.substring(i, i + 1));
            }
        }

        return sb.toString();
    }
}
