package codingbat.ap_1;

public class wordsFront {
    /*
    Given an array of strings, return a new array containing the first N strings. N will be in the range 1..length.

    codingbat.ap_1.wordsFront(["a", "b", "c", "d"], 1) → ["a"]
    codingbat.ap_1.wordsFront(["a", "b", "c", "d"], 2) → ["a", "b"]
    codingbat.ap_1.wordsFront(["a", "b", "c", "d"], 3) → ["a", "b", "c"]
     */
    public String[] wordsFront(String[] words, int n) {
        String[] newArr = new String[n];

        for (int i = 0; i < n; i++) {
            newArr[i] = words[i];
        }
        //or, if (n >= 0) System.arraycopy(words, 0, newArr, 0, n);
        return newArr;
    }
}
