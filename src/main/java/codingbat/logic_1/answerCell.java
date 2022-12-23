package codingbat.logic_1;

public class answerCell {
    /*
    Your cell phone rings. Return true if you should answer it. Normally you answer, except in the morning you only answer if it is your mom calling. In all cases, if you are asleep, you do not answer.

    codingbat.logic_1.answerCell(false, false, false) → true
    codingbat.logic_1.answerCell(false, false, true) → false
    codingbat.logic_1.answerCell(true, false, false) → false
     */
    public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
        if (isAsleep) {
            return false;
        }
        return !isMorning || isMom;
    }
}
