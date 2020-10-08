public class sameEnds {

    /*
        Given a string, return the longest substring that appears at both the beginning and end of the string without overlapping. For example, sameEnds("abXab") is "ab".

        sameEnds("abXYab") → "ab"
        sameEnds("xx") → "x"
        sameEnds("xxx") → "x"
     */
    public String sameEnds(String string) {

        int len = string.length();
        String fin = "";
        String tmp = "";

        for (int i = 0; i < len; i++) {
            tmp += string.charAt(i);
            int tmplen = tmp.length();
            //Check the substring from len-tmplen to the len of the string, so in other words, as long as i does not exceed half the length of the string, we can continue checking
            if (i < len / 2 && tmp.equals(string.substring(len - tmplen, len)))
                fin = tmp;
        }
        return fin;
    }
}
