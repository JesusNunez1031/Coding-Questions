
public class FibSeq {
    public static int result;
    public static long timeStart, timeEnd, totalTime;

    // Method to calculate the fibonacci sequence using simple recursion
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }
        return result;
    }

    Integer[] memo = new Integer[100];

    // Method to calculate fib sequence using memoization
    public static int fibMemo(int n, Integer[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }
        if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }
        memo[n] = result;
        return result;
    }

    // Method to calculate fib sequence using a bottom up approach
    public static int fibBottomUp(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] bottom_up = new int[n + 1];
        bottom_up[0] = 1;
        bottom_up[1] = 1;
        for (int i = 2; i <= n; i++) {
            bottom_up[i] = bottom_up[i - 1] + bottom_up[i - 2];
        }
        return bottom_up[n];
    }

    public static void main(String[] args) {
        Integer[] memo = new Integer[100];
        timeStart = System.currentTimeMillis();
        System.out.println(fib(45));
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for fib using only recursion is %d millisecs\n", totalTime);

        timeStart = System.currentTimeMillis();
        System.out.println(fibMemo(45, memo));
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for fib using memoization is %d millisecs\n", totalTime);

        timeStart = System.currentTimeMillis();
        System.out.println(fibBottomUp(45));
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for fib using bottom up is %d millisecs\n", totalTime);
    }
}
