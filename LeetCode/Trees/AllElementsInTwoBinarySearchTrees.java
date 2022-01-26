import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    /*
    Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in
    ascending order.

    Example 1:
         [2]            [1]
        /   \          /   \
     [1]     [4]     [0]   [3]
    Input: root1 = [2,1,4], root2 = [1,0,3]
    Output: [0,1,1,2,3,4]

    Example 2:
        [1]            [8]
           \          /
            [8]    [1]
    Input: root1 = [1,null,8], root2 = [8,1]
    Output: [1,1,8,8]

    Constraints:
        The number of nodes in each tree is in the range [0, 5000].
        -10^5 <= Node.val <= 10^5
     */
    //TC: O(n)
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();

        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();

        // populate each list with the in order sequence of each tree
        inOrder(root1, t1);
        inOrder(root2, t2);

        // pointers used to traverse lists
        int i = 0;
        int j = 0;

        // sort the list values onto the result list
        while (i < t1.size() && j < t2.size()) {
            if (t1.get(i) < t2.get(j)) {
                result.add(t1.get(i));
                i++;
            } else {
                result.add(t2.get(j));
                j++;
            }
        }

        // add remaining values to the end from the longer list
        while (i < t1.size()) {
            result.add(t1.get(i++));
        }

        while (j < t2.size()) {
            result.add(t2.get(j++));
        }

        return result;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}
