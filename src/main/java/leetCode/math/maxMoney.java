package leetCode.math;

public class maxMoney {
    /*
    Given a street of N houses (a row of houses), each house having K amount of money kept inside; now there is a thief
    who is going to steal this money but he has a constraint/rule that he cannot steal/rob two adjacent houses. Find the maximum money he can rob.

    Example 1:
    Input:
    N = 5 , K = 10
    Output:
    30
    Explanation:
    The Robber can rob from the first, third and fifth houses which will result in 30.

    Example 2:
    Input:
    N = 2 , K = 12
    Output:
    12
    Explanation:
    The Robber can only rob from the first or second which will result in 12.
     */
    static int maximizeMoney(int N, int K) {
        if (N == 1) {
            return K;
        }

        if (N % 2 == 0) {
            return (N / 2) * K;
        }

        return ((N / 2) + 1) * K;
    }
}
