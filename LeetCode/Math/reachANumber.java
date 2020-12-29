public class reachANumber {
    /*
    You are standing at position 0 on an infinite number line. There is a goal at position target.
    On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

    Return the minimum number of steps required to reach the destination.

    Example 1:
    Input: target = 3
    Output: 2
    Explanation:
    On the first move we step from 0 to 1.
    On the second step we step from 1 to 3.

    Example 2:
    Input: target = 2
    Output: 3
    Explanation:
    On the first move we step from 0 to 1.
    On the second move we step  from 1 to -1.
    On the third move we step from -1 to 2.

    Note:
    target will be a non-zero integer in the range [-10^9, 10^9].
     */
    //TC: O(steps) == Sqrt(target)
    private int reachNumber(int target) {
        if (target == 0) {
            return 0;
        }
        int sum = 0, steps = 0;
        target = Math.abs(target);

        //add steps until the target is reached
        while (sum < target) {
            sum += steps;
            steps++;
        }

        /*
            if the target is passed, add steps until 2*k steps can be subtracted, or sum - target is divisible by 2 which
            will give us the actual target
         */
        while ((sum - target) % 2 == 1) {
            sum += steps;
            steps++;
        }
        return steps - 1;
    }
}
