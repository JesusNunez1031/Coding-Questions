package codingbat.string_1;

public class firstHalf {

    /*
    Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".

    codingbat.string_1.firstHalf("WooHoo") → "Woo"
    codingbat.string_1.firstHalf("HelloThere") → "Hello"
    codingbat.string_1.firstHalf("abcdef") → "abc"
     */

    public String firstHalf(String str) {
        int mid = str.length() / 2;
        return str.substring(0, mid);
    }
}
