public class longestMountainInArray {
    /*
    Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
    B.length >= 3
    There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
    (Note that B could be any subarray of A, including the entire array A.)

    Given an array A of integers, return the length of the longest mountain.

    Return 0 if there is no mountain.

    Example 1:
    Input: [2,1,4,7,3,2,5]
    Output: 5
    Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

    Example 2:
    Input: [2,2,2]
    Output: 0
    Explanation: There is no mountain.
    Note:

    0 <= A.length <= 10000
    0 <= A[i] <= 10000

    Follow up:
        Can you solve it using only one pass?
        Can you solve it in O(1) space?
     */
    //TC: O(n) time and constant space
    public static int longestMountain(int[] A) {
        int longest = 0;

        for (int i = 1; i < A.length; i++) {
            //a mountain must be of at least length 1
            int current_mountain = 1;               //will hold the size of the current mountain
            boolean found_decreasingSeq = false;    //boolean used to confirm we found a decreasing sequence

            //find check if starting from i, we can found an increasing sequence
            int j = i;
            while (j < A.length && A[j] > A[j - 1]) {
                j++;
                current_mountain++;
            }

            /*
                from the end of j, we check if there also exsits a decreasing sequence to complete a mountain
                we first check if i != j to ensure we first found an increasing sequence
            */
            while (i != j && j < A.length && A[j] < A[j - 1]) {
                j++;
                current_mountain++;
                found_decreasingSeq = true;
            }

            /*
                finally, if we found an increasing and decreasing sequence, we compare it to the current max,
                to update it or leave it as is. Check if the mountain is of size 3 or larger
            */
            if (i != j && found_decreasingSeq && current_mountain > 2) {
                longest = Math.max(longest, current_mountain);
                j--;    //decrement j so that it points to the previous value and not skip a value
            }
            //move i to j since we don't want to repeat steps
            i = j;
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain(arr));
    }
}
