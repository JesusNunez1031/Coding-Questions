package codingbat.warmup_1;

public class startHi {
    /*
    Given a string, return true if the string starts with "hi" and false otherwise.

    codingbat.warmup_1.startHi("hi there") → true
    codingbat.warmup_1.startHi("hi") → true
    codingbat.warmup_1.startHi("hello hi") → false
     */

    public boolean startHi(String str) {
        if (str.length() <= 1) {
            return false;
        }
        return (str.startsWith("hi"));

    }

}
