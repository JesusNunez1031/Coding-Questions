public class hourglassSum2D {
    /*
        There are 16 hourglasses in arr. An hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
        The array will always be 6x6.
             -63, -34, -9, 12,  --> the 16 hourglass sums of the 2d array below, the return value will be 28
            -10,   0, 28, 23,
            -27, -11, -2, 10,
              9,  17, 25, 18             -9 -9 -9  1 1 1
                                         0 -9  0  4 3 2
                                        -9 -9 -9  1 2 3
                                         0  0  8  6 6 0
                                         0  0  0 -2 0 0
                                         0  0  1  2 4 0
     */
    static int hourglassSum(int[][] arr) {
        int rows = arr.length;
        int col = arr[0].length;
        //since the max value found in index is -9, -9*7 = -63
        int max_hourglass_val = -63, sum = 0;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                max_hourglass_val = Math.max(max_hourglass_val, sum);
            }
        }
        return max_hourglass_val;
    }
}
