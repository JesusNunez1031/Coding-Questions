package codingbat.recursion_1;

public class countPairs {
    /*
    We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair.
    Pair's can overlap, so "AxAxA" contains 3 codingbat.map_2.pairs -- 2 for A and 1 for x. Recursively compute the number of codingbat.map_2.pairs in the given string.

    codingbat.recursion_1.countPairs("axa") → 1
    codingbat.recursion_1.countPairs("axax") → 2
    codingbat.recursion_1.countPairs("axbx") → 1
     */
    public int countPairs(String str) {
        if (str.length() <= 2) {
            return 0;
        }

        return str.charAt(0) == str.charAt(2) ? 1 + countPairs(str.substring(1)) : countPairs(str.substring(1));
    }
}
