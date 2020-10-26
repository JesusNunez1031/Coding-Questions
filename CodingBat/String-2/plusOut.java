public class plusOut {
    /*
    Given a string and a non-empty word string, return a version of the original String where all chars have been replaced
    by pluses ("+"), except for appearances of the word string which are preserved unchanged.

    plusOut("12xy34", "xy") → "++xy++"
    plusOut("12xy34", "1") → "1+++++"
    plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
     */
    public String plusOut(String str, String word) {
        int slen = str.length();
        int wlen = word.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < slen; i++) {
            if (i <= slen - wlen) {
                String tmp = str.substring(i, i + wlen);
                if (tmp.equals(word)) {
                    sb.append(word);
                    i += wlen - 1;
                } else
                    sb.append("+");
            } else
                sb.append("+");
        }
        return sb.toString();
    }
}
