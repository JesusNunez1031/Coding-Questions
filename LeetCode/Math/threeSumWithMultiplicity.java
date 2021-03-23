public class threeSumWithMultiplicity {
    /*
    Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

    As the answer can be very large, return it modulo 109 + 7.

    Example 1:
    Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
    Output: 20
    Explanation:
    Enumerating by the values (arr[i], arr[j], arr[k]):
    (1, 2, 5) occurs 8 times;
    (1, 3, 4) occurs 8 times;
    (2, 2, 4) occurs 2 times;
    (2, 3, 3) occurs 2 times.

    Example 2:
    Input: arr = [1,1,2,2,2,2], target = 5
    Output: 12
    Explanation:
    arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
    We choose one 1 from [1,1] in 2 ways,
    and two 2s from [2,2,2,2] in 6 ways.

    Constraints:
        3 <= arr.length <= 3000
        0 <= arr[i] <= 100
        0 <= target <= 300
     */
    //TC: O(n + 100 * 100) since we look through all n values in arr for the frequency and have nested loops that iterate through all 100 values twice looking for tuples
    public int threeSumMulti(int[] arr, int target) {
        /*
            since the max possible value that can be in the array is 100, we set it to 101 and fill in the
            frequency of all values in arr into the array
        */
        long[] freq = new long[101];

        long tuples = 0;

        for (int num : arr) {
            freq[num]++;
        }

        //look through the freq array for the tuples arr[i] arr[j] & arr[k]
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;   //third value needed so arr[i] + arr[j] + arr[k] == target

                //the third value needed is not in the range of possible values
                if (k < 0 || k > 100) {
                    continue;
                }
                /*
                    case 1: all values are equal, so we use the combination formula for C(n, 3)
                        n! / 3!(n - 3)! [simplified =>] (n * (n - 1) * (n - 2)) / 6
                */
                if (i == j && j == k) {
                    tuples += (freq[i] * (freq[i] - 1) * (freq[i] - 2) / 6);
                }
                /*
                    case 2: i and j are equal but k is not, C(n, 2) * freq[k]
                        n! / 2! (n - 2)! * freq[k] [simplified =>] n * (n - 1) / 2 * freq[k]
                */
                else if (i == j && j != k) {
                    tuples += ((freq[i] * (freq[i] - 1) / 2) * freq[k]);
                }
                //case 3: all values are different so we just multiply all the frequencies freq[i] * freq[j] * freq[k]
                else if (i < j && j < k) {
                    tuples += (freq[i] * freq[j] * freq[k]);
                }
            }
        }
        //the result can be large so we take the mod 10^9+7 from the result
        return (int) (tuples % ((int) 1e9 + 7));
    }
}
