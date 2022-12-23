package codingbat.warmup_1;

public class monkeyTrouble {

    /*
    We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling.
    We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble.

    codingbat.warmup_1.monkeyTrouble(true, true) → true
    codingbat.warmup_1.monkeyTrouble(false, false) → true
    codingbat.warmup_1.monkeyTrouble(true, false) → false
     */

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return ((aSmile && bSmile) || (!aSmile && !bSmile));
    }

}
