package codingbat.ap_1;

public class wordsCount {
    /*
    Given an array of strings, return the count of the number of strings with the given length.

    codingbat.ap_1.wordsCount(["a", "bb", "b", "ccc"], 1) → 2
    codingbat.ap_1.wordsCount(["a", "bb", "b", "ccc"], 3) → 1
    codingbat.ap_1.wordsCount(["a", "bb", "b", "ccc"], 4) → 0
     */
    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (String word : words) {
            if (word.length() == len) {
                count++;
            }
        }
        return count;
    }
}
