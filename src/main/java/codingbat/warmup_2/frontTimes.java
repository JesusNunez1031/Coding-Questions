package codingbat.warmup_2;

public class frontTimes {
    /*
    Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;

    codingbat.warmup_2.frontTimes("Chocolate", 2) → "ChoCho"
    codingbat.warmup_2.frontTimes("Chocolate", 3) → "ChoChoCho"
    codingbat.warmup_2.frontTimes("Abc", 3) → "AbcAbcAbc"
     */

    public String frontTimes(String str, int n) {
        String newStr;
        if (str.length() < 3) {
            newStr = str;
        } else {
            newStr = str.substring(0, 3);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(newStr);
        }
        return result.toString();
    }
}
