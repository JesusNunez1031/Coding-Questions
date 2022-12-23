package codingbat.warmup_2;

public class countXX {

    /*
    Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".

    codingbat.warmup_2.countXX("abcxx") → 1
    codingbat.warmup_2.countXX("xxx") → 2
    codingbat.warmup_2.countXX("xxxx") → 3
     */

    int countXX(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.startsWith("xx", i)) {
                count++;
            }
        }
        return count;
    }
}
