import java.util.Random;

public class divisibleSumPairs {
    /*
        given an array of integers, return the number of pairs that summed are divisible by k
     */
    public static long timeStart, timeEnd, totalTime;

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int i = 0, j = i + 1;
        int count = 0;

        //Inc i by one while j loops and resets back to i + 1
        while (i != n - 1 && j <= n) {
            if (i < j && (ar[i] + ar[j]) % k == 0) {
                count++;
            }
            j++;

            if (j == n) {
                i++;
                j = i + 1;
            }
        }
        return count;
    }

    static int divisibleSumPairsFor(int n, int k, int[] ar) {
        int count = 0;

        //Inc i by one while j loops and resets back to i + 1
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i < j && (ar[i] + ar[j]) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random randy = new Random();

        for(int i = 0; i < arr.length;i++) {
            arr[i] = randy.nextInt(100);
        }

        timeStart = System.currentTimeMillis();
        System.out.println(divisibleSumPairs(arr.length, 3, arr));
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time using one loop is %d millisecs\n", totalTime);

        timeStart = System.currentTimeMillis();
        System.out.println(divisibleSumPairsFor(arr.length, 3, arr));
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time using 2 loops is %d millisecs\n", totalTime);
    }
}
