package codingbat.string_1;

public class minCat {
    /*

Given two strings, append them together (known as "concatenation") and return the result. However, if the strings are different lengths, omit chars from the longer string so it is the same length as the shorter string. So "Hello" and "Hi" yield "loHi". The strings may be any length.

    codingbat.string_1.minCat("Hello", "Hi") → "loHi"
    codingbat.string_1.minCat("Hello", "java") → "ellojava"
    codingbat.string_1.minCat("java", "Hello") → "javaello"
     */
    public String minCat(String a, String b) {
        if (a.length() > b.length()) {
            return a.substring(a.length() - b.length()).concat(b);
        }
        return a.concat(b.substring(b.length() - a.length()));
    }
}
