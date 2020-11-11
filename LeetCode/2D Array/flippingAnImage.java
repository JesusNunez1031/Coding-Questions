public class flippingAnImage {
    /*
    Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
    To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

    Example 1:
    Input: [[1,1,0],[1,0,1],[0,0,0]]
    Output: [[1,0,0],[0,1,0],[1,1,1]]
    Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
    Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

    Example 2:
    Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
    Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

    Notes:
        1 <= A.length = A[0].length <= 20
        0 <= A[i][j] <= 1
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                //swap the first half of the row with the lest half
                int temp = A[i][j] > 0 ? 0 : 1;
                A[i][j] = A[i][len - 1 - j] > 0 ? 0 : 1;
                A[i][len - 1 - j] = temp;

            }
        }

        //invert the values
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
        return A;
    }

    //Method to make the reverse and invert in once loop
    public int[][] flipAndInvertImageEz(int[][] A) {
        int len = A.length;

        //for every row, we want to reverse the values
        for (int i = 0; i < len; i++) {
            int left = 0, right = len - 1;
            while (left <= right) {
                //reverse and revert values
                int temp = A[i][left] > 0 ? 0 : 1;  //if A[i][left] is > 0, we set the value to 0, else we set it to 1
                A[i][left] = A[i][right] > 0 ? 0 : 1;   //if A[i][right] is > 0, we set the value to 0, else we set it to 1
                A[i][right] = temp;

                left++;
                right--;
            }
        }
        return A;
    }
}
