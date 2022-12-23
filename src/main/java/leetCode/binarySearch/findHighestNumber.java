package leetCode.binarySearch;

import java.util.List;

public class findHighestNumber {
    /*
    Given an array in such a way that the elements stored in array are in increasing order initially and then after
    reaching to a peak element, elements stored are in decreasing order. Find the highest element.
    Note: A[i] != A[i+1]

    Example 1:
    Input:
    11
    1 2 3 4 5 6 5 4 3 2 1
    Output: 6
    Explanation: Highest element is 6.

    Example 2:
    Input:
    5
    1 2 3 4 5
    Output: 5
    Explanation: Highest element is 5.
     */

    public int findPeakElement(List<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > a.get(i + 1)) {
                return a.get(i);
            } else if (i == a.size() - 1) {
                return a.get(i);
            }
        }
        return -1;
    }

    //using binary search, we get an O(log n) solution
    public int findPeakElementBS(List<Integer> a)
    {
        int left = 0;
        int right = a.size() - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            //if the value at the mid is greater than its predecessor and is greater than its successor, highest number was found
            if(a.get(mid - 1) < a.get(mid) && a.get(mid) > a.get(mid + 1)) {
                return a.get(mid);
            }
            //if mid is greater than its previous and less than the next value, move forward by one
            if(a.get(mid - 1) < a.get(mid) && a.get(mid) < a.get(mid + 1)) {
                left = mid + 1;
            }
            //otherwise we move back by one
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
