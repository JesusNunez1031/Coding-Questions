import java.util.ArrayList;
import java.util.Random;

public class subarrayWithGivenSum {
    /*
    Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
    Input:
    The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

    Output:
    For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

    Constraints:
    1 <= T <= 100
    1 <= N <= 10^7
    1 <= Ai <= 10^10

    Example:
    Input:
    2
    5 12
    1 2 3 7 5

    10 15
    1 2 3 4 5 6 7 8 9 10
    Output:
    2 4
    1 5

    Explanation :
    Testcase1: sum of elements from 2nd position to 4th position is 12
    Testcase2: sum of elements from 1st position to 5th position is 15
     */

    //TC: O(2 * n) in the worst case, O(n) on average
    static ArrayList<Integer> subarraySum(int n, int s, int[] m) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int sum = 0;
        int j = 0, i;

        for (i = 0; i < n; i++) {
            sum += m[i];    //add the current value to sum

            //if the sum is greater than s, then reduce the sum until its less than s while also moving j pointer
            while (sum > s) {
                sum -= m[j];
                j++;
            }

            //if sum equals target, add the start and end to the indexes to the list and return
            if (sum == s) {
                indexes.add(j + 1);
                indexes.add(i + 1);
                return indexes;
            }
        }

        indexes.add(-1);    //no solution found
        return indexes;
    }

    static ArrayList<Integer> subarraySumSq(int n, int s, int[] m) {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n && sum <= s; j++) {
                sum += m[j];

                if (sum == s) {
                    indexes.add(i + 1);
                    indexes.add(j + 1);
                    return indexes;
                }
            }
        }
        indexes.add(-1);    //no solution found
        return indexes;
    }

    public static long timeStart, timeEnd, totalTime;

    public static void main(String[] args) {
        int sum = 50320;
        //int sum = 468;
        //int[] arr = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        Random randy = new Random();
        int[] arr = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arr[i] = randy.nextInt(1000000000);
        }

        timeStart = System.currentTimeMillis();
        System.out.println(subarraySum(arr.length, sum, arr));
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for first is %d millisecs\n", totalTime);

        timeStart = System.currentTimeMillis();
        System.out.println(subarraySumSq(arr.length, sum, arr));
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for assumed bad is %d millisecs\n", totalTime);

    }
}
