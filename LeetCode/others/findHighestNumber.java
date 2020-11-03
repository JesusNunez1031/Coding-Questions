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
}
