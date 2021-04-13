public class BeautifulArrangementII {
    /*
    Given two integers n and k, you need to construct a list which contains n different positive integers ranging from
    1 to n and obeys the following requirement:
    Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has
    exactly k distinct integers.

    If there are multiple answers, print any of them.

    Example 1:
    Input: n = 3, k = 1
    Output: [1, 2, 3]
    Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1
    distinct integer: 1.

    Example 2:
    Input: n = 3, k = 2
    Output: [1, 3, 2]
    Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2
    distinct integers: 1 and 2.

    Note:
        The n and k are in the range 1 <= k < n <= 10^4.
     */
    //TC: O(n)
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];

        /*
            the highest value in the array is n and lowest is 1. To make k distinct integers in the resulting array
            we need to make sure that every pair of values yields a difference different than the previous pair if k > 1
            Ex: given n = 5
                k = 1  |  [1, 2, 3, 4, 5] ==> result array
                2-1=1, 3-2=1, 4-3=1, 5-4=1, the difference of all value pairs is 1 hence we only have k, 1, values

                k = 2  |  [1, 5, 4, 3, 2]
                5-1=4, |4-5|=1, |3-4|=1, |2-3|=1, we have 2 different differences here, 4 and 1, hence k = 2

                k = 3  |  [1, 5, 2, 3, 4]
                5-1=4, |2-5|=3, |3-2|=1, |4-3| = 1, here we have 4, 3, and 1 as differences, i.e. k = 3

                the pattern formed is that we alternate starting adding values the result array with low, then high while
                k > 1, after this, if we ended on a high value, the rest of the values added will be in descending order,
                otherwise, if we end on a low value, the rest of the values will be added in ascending order.
        */
        int high = n;
        int low = 1;
        int i = 0; //index to add values into array

        //add the first value into the result array
        result[i++] = low++;

        boolean endedHigh = false; //flag to indicate if we ended on a high value

        //add values in alternating patterns
        while (k > 1) {
            result[i++] = high--;
            k--;
            endedHigh = true; //set flag to true in case this is the last addition, we add the rest of the values in descending order

            //if we can still add values, add the next low value and also change flag in case this is the last entry
            if (k > 1) {
                result[i++] = low++;
                k--;
                endedHigh = false;
            }
        }

        //add the remaining values to the array in the right order
        while (i < n) {
            //if we ended on a high value, remaining values must be added in descending order, otherwise in ascending
            if (endedHigh) {
                result[i] = high--;
            } else {
                result[i] = low++;
            }
            i++;
        }
        return result;
    }
}
