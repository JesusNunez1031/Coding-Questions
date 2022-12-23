package codingbat.string_2;

public class repeatFront {
    /*
    Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1
    characters of the string, and so on. You may assume that n is between 0 and the length of the string, inclusive
    (i.e. n >= 0 and n <= str.length()).

    codingbat.string_2.repeatFront("Chocolate", 4) → "ChocChoChC"
    codingbat.string_2.repeatFront("Chocolate", 3) → "ChoChC"
    codingbat.string_2.repeatFront("Ice Cream", 2) → "IcI"
     */
    public String repeatFront(String str, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(str, 0, n - i);
        }
        return result.toString();
    }
}
