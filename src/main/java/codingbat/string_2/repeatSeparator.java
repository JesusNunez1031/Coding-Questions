package codingbat.string_2;

public class repeatSeparator {
    /*
    Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string.

    codingbat.string_2.repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    codingbat.string_2.repeatSeparator("This", "And", 2) → "ThisAndThis"
    codingbat.string_2.repeatSeparator("This", "And", 1) → "This"
     */
    public String repeatSeparator(String word, String sep, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(word);
            if (!(i == count - 1)) {
                result.append(sep);
            }
        }
        return result.toString();
    }
}
