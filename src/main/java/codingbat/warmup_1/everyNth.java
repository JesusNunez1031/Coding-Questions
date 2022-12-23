package codingbat.warmup_1;

public class everyNth {

    /*

Given a non-empty string and an int N, return the string made starting with char 0, and then every Nth char of the string. So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.

    codingbat.warmup_1.everyNth("Miracle", 2) → "Mrce"
    codingbat.warmup_1.everyNth("abcdefg", 2) → "aceg"
    codingbat.warmup_1.everyNth("abcdefg", 3) → "adg"
     */
    public String everyNth(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i += n) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
