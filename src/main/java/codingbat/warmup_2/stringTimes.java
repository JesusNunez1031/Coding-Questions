package codingbat.warmup_2;

public class stringTimes {

    /*
    Given a string and a non-negative int n, return a larger string that is n copies of the original string.

    codingbat.warmup_2.stringTimes("Hi", 2) → "HiHi"
    codingbat.warmup_2.stringTimes("Hi", 3) → "HiHiHi"
    codingbat.warmup_2.stringTimes("Hi", 1) → "Hi"
     */
    public String stringTimes(String str, int n) {
        StringBuilder result = new StringBuilder();
        result.append(String.valueOf(str).repeat(Math.max(0, n)));
        return result.toString();
    }
}
