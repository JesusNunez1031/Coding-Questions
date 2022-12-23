package leetCode.trees;

import java.util.*;

public class N_aryTreeLevelOrderTraversal {
    /*
    Given an n-ary tree, return the level order traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by
    the null value (See examples).

    Example 1:
                     [1]
                   /  |  \
                 [3] [2] [4]
                 / \
               [5] [6]
    Input: root = [1,null,3,2,4,null,5,6]
    Output: [[1],[3,2,4],[5,6]]

    Example 2:
                          [1]
                     /  |     |   \
                   [2] [3]    [4]  [5]
                       / \     |   /  \
                     [6] [7]  [8] [9] [10]
                          |    |    |
                         [11] [12] [13]
                          |
                         [14]
    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
    Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

    Constraints:
        The height of the n-ary tree is less than or equal to 1000
        The total number of nodes is between [0, 10^4]
     */
    //TC: O(n) where n is the number of nodes in the tree
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> levels = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for(int i = 0;i < size;i++) {
                Node curr = queue.remove();
                level.add(curr.val);

                //add all the children of this node to the queue
                queue.addAll(curr.children);
            }
            levels.add(level);
        }
        return levels;
    }
}
