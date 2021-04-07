import java.util.Arrays;

public class minimumOperationsToMakeArrayEqual {
    /*
    You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
    In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to
    arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal. It is
    guaranteed that all the elements of the array can be made equal using some operations.

    Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.

    Example 1:
    Input: n = 3
    Output: 2
    Explanation: arr = [1, 3, 5]
    First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
    In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].

    Example 2:
    Input: n = 6
    Output: 9

    Constraints:
        1 <= n <= 10^4
     */
    //TC: O(1)
    public int minOperations(int n) {
        int mid = n / 2; //get the number of values in the center of the array
        /*
        if n is odd only one value remains in the center
        Ex: [1 3 5] n = 3, arr[i] = (2 * i) + 1
               ^ we want to convert all values to 3
            changes to make all values 3, [1 3 5]
                                           2  -2
            on the left we have 2 operations, or 2(sum(mid)) = 2(sum(n/2)) === mid * (mid + 1), this
            formula applies since values in the array are uniform, meaning for all values prior to the mid we add to set
            them to 3, and the later half are subtracted from, hence we use the sum formula on the first half

          when is n is even, 2 values are at the center, so we change all values to the mid of the the two values,
          Ex: [1 3 5  7  9  11] n = 6 mid = 5 & 7, so we change all values to 6
               5 3 1 -1 -3  -5
               to get the number of operations, we sum all the even changes to get 9, 1 + 3 + 5 = n^2, where n is mid,
               so mid * mid if n is even
         */
        return n % 2 == 0 ? mid * mid : mid * (mid + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = (2 * i) + 1;
        }
        System.out.println(Arrays.toString(arr));
    }
}
