package leetCode.bitManipulation;

public class decodeXORedArray {
    /*
    There is a hidden integer array arr that consists of n non-negative integers.
    It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1].
    For example, if arr = [1,0,2,1], then encoded = [1,2,3].

    You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].

    Return the original array arr. It can be proved that the answer exists and is unique.

    Example 1:
    Input: encoded = [1,2,3], first = 1
    Output: [1,0,2,1]
    Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]

    Example 2:
    Input: encoded = [6,2,7,3], first = 4
    Output: [4,2,0,7,4]

    Constraints:
        2 <= n <= 10^4
        encoded.length == n - 1
        0 <= encoded[i] <= 10^5
     */
    //TC: O(n)
    public int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        //first value in decode is "first"
        decoded[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            /*
                we have n - 1 values to decode, where n is the length of encoded, so we iterate through all the values in
                encoded and set decode[i + 1] to the current value in decode ^ the current value in encoded
             */
            decoded[i + 1] = decoded[i] ^ encoded[i];
        }
        return decoded;
    }
}
