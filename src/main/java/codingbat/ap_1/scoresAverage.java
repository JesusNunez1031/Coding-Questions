package codingbat.ap_1;

public class scoresAverage {
    /*
    Given an array of scores, compute the int average of the first half and the second half, and return whichever is
    larger. We'll say that the second half begins at index length/2. The array length will be at least 2. To practice
    decomposition, write a separate helper method int average(int[] scores, int start, int end) { which computes the
    average of the elements between indexes start..end. Call your helper method twice to implement codingbat.ap_1.scoresAverage().
    Write your helper method after your codingbat.ap_1.scoresAverage() method in the JavaBat text area. Normally you would compute
    averages with doubles, but here we use ints so the expected results are exact.

    codingbat.ap_1.scoresAverage([2, 2, 4, 4]) → 4
    codingbat.ap_1.scoresAverage([4, 4, 4, 2, 2, 2]) → 4
    codingbat.ap_1.scoresAverage([3, 4, 5, 1, 2, 3]) → 4
     */
    int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += scores[i];
        }
        return sum / (end - start);
    }

    public int scoresAverage(int[] scores) {

        if (scores.length <= 2) {
            return Math.max(scores[0], scores[1]);
        }
        int mid = scores.length / 2;
        int firstHa = average(scores, 0, mid);
        int secondHa = average(scores, mid, scores.length);

        return Math.max(firstHa, secondHa);
    }

}
