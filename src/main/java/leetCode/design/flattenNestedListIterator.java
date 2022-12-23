package leetCode.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Pre-defined methods
interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

public class flattenNestedListIterator implements Iterator<Integer> {
    /*
    You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may
    also be integers or other lists. Implement an iterator to flatten it.

    Implement the NestedIterator class:
        - NestedIterator(List<leetCode.design.NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
        - int next() Returns the next integer in the nested list.
        - boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.

    Example 1:
    Input: nestedList = [[1,1],2,[1,1]]
    Output: [1,1,2,1,1]
    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should
    be: [1,1,2,1,1].

    Example 2:
    Input: nestedList = [1,[4,[6]]]
    Output: [1,4,6]
    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should
    be: [1,4,6].

    Constraints:
        1 <= nestedList.length <= 500
        The values of the integers in the nested list is in the range [-10^6, 10^6].
     */

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface leetCode.design.NestedInteger {
     * <p>
     * // @return true if this leetCode.design.NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this leetCode.design.NestedInteger holds, if it holds a single integer
     * // Return null if this leetCode.design.NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this leetCode.design.NestedInteger holds, if it holds a nested list
     * // Return empty list if this leetCode.design.NestedInteger holds a single integer
     * public List<leetCode.design.NestedInteger> getList();
     * <p>
     * }
     */
    //TC: O(n) time to flatten nested List, and O(1) to get next and check if there is a next value
    List<Integer> flattenedList = null; //list of all integer values in the nested list
    int index = 0; //index of the current value in flattened List

    /*
        when the constructor is called to make the nested list, we flatten the list into "flattenedList". This
        makes getting integer values much easier
    */
    public flattenNestedListIterator(List<NestedInteger> nestedList) {
        flattenedList = new ArrayList<>();

        /*
            go through each value in the nestedList, if the value is a single integer add to flattened list, otherwise
            search through the list itself and add all values from it
         */
        for (NestedInteger num : nestedList) {
            checkIndex(num);
        }
    }

    @Override
    public Integer next() {
        return flattenedList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flattenedList.size();
    }

    /*
        Method checks if "num" is a single integer and adds it to the list of flattened values, otherwise, it does a
        dfs search through the values in the "num" list
     */
    private void checkIndex(NestedInteger num) {
        //if num is a single digit, add it to the list
        if (num.isInteger()) {
            flattenedList.add(num.getInteger());
        } else {
            //if num is a list, dfs search through all the values in that list
            for (NestedInteger val : num.getList()) {
                checkIndex(val);
            }
        }
    }
}
