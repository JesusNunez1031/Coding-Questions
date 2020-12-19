public class minDominoRotationsForEqualRow {
    /*
    In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with
    two numbers from 1 to 6 - one on each half of the tile.)

    We may rotate the ith domino, so that A[i] and B[i] swap values.
    Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
    If it cannot be done, return -1.

    Example 1:
    Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
    Output: 2
    Explanation:
    The first figure represents the dominoes as given by A and B: before we do any rotations.
    If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

    Example 2:
    Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
    Output: -1
    Explanation:
    In this case, it is not possible to rotate the dominoes to make one row of values equal.

    Constraints:
        2 <= A.length == B.length <= 2 * 10^4
        1 <= A[i], B[i] <= 6
     */
    private int minDominoRotations(int[] A, int[] B) {
        //find the majority element in each A and B
        int majority_A = majorityElement(A);
        int majority_B = majorityElement(B);

        //get the number of swaps from each array only changing values that are not the majority element
        int swapsA = rotateDomino(A, B, majority_A);
        int swapsB = rotateDomino(B, A, majority_B);

        //if either swaps count == -1, that means there was a point in the array where we cant swap a domino
        if (swapsA == -1 || swapsB == -1) {
            return -1;
        }

        //return the smallest number of swaps we need to do on either A or B
        return Math.min(swapsA, swapsB);
    }

    //Using Boyer-Moore's voting algorithm to find majority element
    private int majorityElement(int[] array) {
        int candidate = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == candidate) {
                count++;
            } else {
                count--;
            }

            //pick a new candidate and reset count to 1
            if (count == 0) {
                candidate = array[i];
                count = 1;
            }
        }
        return candidate;
    }

    //Method return the number of swaps we need to make to make all dominoes match, "curr" is the array being observed, "temp" is the other array being compared to
    private int rotateDomino(int[] curr, int[] temp, int majority_element) {
        int swaps = 0;
        for (int i = 0; i < curr.length; i++) {
            /*
                if the current value is not the majority element and the element also doesnt exist in the current position
                of temp array, we cant make a valid swap
             */
            if (curr[i] != majority_element && temp[i] != majority_element) {
                return -1;
            }
            //if the current element is not the majority but the other array has it, we can swap here
            else if (curr[i] != majority_element) {
                swaps++;
            }
        }
        return swaps;
    }

    //---------------------------------------------Method 2-----------------------------------------------------------//
    /*
            if we assume the majority element will always be the first element in A and B, then we check how many swaps
            it would take to convert all of A and B to A[0] and compare this value to the number of swaps it would take
            to convert all of A and B to B[0]
     */
    private int minDominoRotationsEz(int[] A, int[] B) {
        int swaps = Math.min(swaps(A, B, A[0]),  //swaps to make all of A to A[0]
                swaps(B, A, A[0]));              //swaps to make all of B to A[0]

        swaps = Math.min(swaps, Math.min(swaps(A, B, B[0]),   //swaps to make all of A to B[0]
                swaps(B, A, B[0])));                          //swaps to make all of B to B[0]

        return swaps != Integer.MAX_VALUE ? swaps : -1;
    }

    private int swaps(int[] curr, int[] arr, int majority_element) {
        int swaps = 0;
        for (int i = 0; i < curr.length; i++) {
            /*
                if the current value is not the majority element and the element also doesnt exist in the current position
                of temp array, we cant make a valid swap
             */
            if (curr[i] != majority_element && arr[i] != majority_element) {
                return Integer.MAX_VALUE;
                //if the current element is not the majority but the other array has it, we can swap here
            } else if (curr[i] != majority_element) {
                swaps++;
            }
        }
        return swaps;
    }
}
