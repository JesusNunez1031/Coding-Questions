package leetCode.math;

public class pairsOfSongsWithTotalDurationsDivisibleBy60 {
    /*
    You are given a list of songs where the ith song has a duration of time[i] seconds.
    Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want
    the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

    Example 1:
    Input: time = [30,20,150,100,40]
    Output: 3
    Explanation: Three pairs have a total duration divisible by 60:
    (time[0] = 30, time[2] = 150): total duration 180
    (time[1] = 20, time[3] = 100): total duration 120
    (time[1] = 20, time[4] = 40): total duration 60

    Example 2:
    Input: time = [60,60,60]
    Output: 3
    Explanation: All three pairs have a total duration of 120, which is divisible by 60.


    Constraints:
        1 <= time.length <= 6 * 10^4
        1 <= time[i] <= 500
     */
    private int numPairsDivisibleBy60(int[] time) {
        int pairs = 0;
        //since we use % 60, all remainders will fall in the range of 0 - 60
        int[] remainders = new int[60];

        for (int t : time) {
            int remainder = t % 60;
            //if the reminder of the current song is 0, we add the count of all the values whose remainder has also been 0
            if (remainder == 0) {
                pairs += remainders[0];
            } else {
                //for any other remainder that's not 0, we add the values of the index of the current remainder
                pairs += remainders[60 - remainder];
            }
            //add 1 to the count of times a specific remainder has been seen
            remainders[remainder]++;
        }
        return pairs;
    }
}
