package codingbat.warmup_1;

public class sleepIn {

    /*
        The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.

        codingbat.warmup_1.sleepIn(false, false) → true
        codingbat.warmup_1.sleepIn(true, false) → false
        codingbat.warmup_1.sleepIn(false, true) → true
     */

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        }
        return false;
    }
}
