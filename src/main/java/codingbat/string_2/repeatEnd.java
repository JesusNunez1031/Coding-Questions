package codingbat.string_2;

public class repeatEnd {
    /*
    Given a string and an int n, return a string made of n repetitions of the last n characters of the string. You may
    assume that n is between 0 and the length of the string, inclusive.

    codingbat.string_2.repeatEnd("Hello", 3) → "llollollo"
    codingbat.string_2.repeatEnd("Hello", 2) → "lolo"
    codingbat.string_2.repeatEnd("Hello", 1) → "o"
     */
    public String repeatEnd(String str, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(str.substring(str.length() - n));
        }
        return result.toString();
    }
}
