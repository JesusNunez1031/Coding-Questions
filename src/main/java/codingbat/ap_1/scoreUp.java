package codingbat.ap_1;

public class scoreUp {
    /*
    The "key" array is an array containing the correct answers to an exam, like {"a", "a", "b", "b"}. the "answers"
    array contains a student's answers, with "?" representing a question left blank. The two arrays are not empty and
    are the same length. Return the score for this array of answers, giving +4 for each correct answer, -1 for each
    incorrect answer, and +0 for each blank answer.

    codingbat.ap_1.scoreUp(["a", "a", "b", "b"], ["a", "c", "b", "c"]) → 6
    codingbat.ap_1.scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "c"]) → 11
    codingbat.ap_1.scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "b"]) → 16
     */
    public int scoreUp(String[] key, String[] answers) {
        int score = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals("?")) {
                score += 0;
            } else if (answers[i].equals(key[i])) {
                score += 4;
            } else {
                score -= 1;
            }
        }
        return score;
    }
}
