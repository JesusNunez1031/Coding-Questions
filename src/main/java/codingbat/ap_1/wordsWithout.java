package codingbat.ap_1;

public class wordsWithout {
    /*
    Given an array of strings, return a new array without the strings that are equal to the target string. One approach
    is to count the occurrences of the target string, make a new array of the correct length, and then copy over the correct strings.

    codingbat.ap_1.wordsWithout(["a", "b", "c", "a"], "a") → ["b", "c"]
    codingbat.ap_1.wordsWithout(["a", "b", "c", "a"], "b") → ["a", "c", "a"]
    codingbat.ap_1.wordsWithout(["a", "b", "c", "a"], "c") → ["a", "b", "a"]
     */
    public String[] wordsWithout(String[] words, String target) {
        int counter = 0, j = 0;
        for (String word : words) {
            if (word.equals(target)) {
                counter++;
            }
        }
        String[] newArr = new String[words.length - counter];

        for (String word : words) {
            if (!word.equals(target)) {
                newArr[j] = word;
                j++;
            }
        }
        return newArr;
    }
}
