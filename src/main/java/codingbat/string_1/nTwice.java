package codingbat.string_1;

public class nTwice {
    /*
    Given a string and an int n, return a string made of the first and last n chars from the string. The string length will be at least n.

    codingbat.string_1.nTwice("Hello", 2) → "Helo"
    codingbat.string_1.nTwice("Chocolate", 3) → "Choate"
    codingbat.string_1.nTwice("Chocolate", 1) → "Ce"
     */
    public String nTwice(String str, int n) {
        String firstN = str.substring(0, n);
        String lastN = str.substring(str.length() - n);
        return firstN + lastN;
    }

}
