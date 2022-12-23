package leetCode.trees;

public class VerifyPreorderSerializationOfABinaryTree {
    /*
    One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the
    node's value. If it is a null node, we record using a sentinel value such as '#'.

    For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents
    a null node.

    Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization
    of a binary tree.

    It is guaranteed that each comma-separated value in the string must be either an integer or a character '#'
    representing null pointer.

    You may assume that the input format is always valid.

    For example, it could never contain two consecutive commas, such as "1,,3".
    Note: You are not allowed to reconstruct the tree.

    Example 1:
                     [9]
                    /   \
                  [3]    [2]
                  /  \     \
                [4]  [1]    [6]
    Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
    Output: true

    Example 2:
    Input: preorder = "1,#"
    Output: false

    Example 3:
    Input: preorder = "9,#,#,1"
    Output: false

    Constraints:
        1 <= preorder.length <= 104
        preorder consist of integers in the range [0, 100] and '#' separated by commas ','.
     */
    //TC: O(n) where n is the length of preorder string
    public boolean isValidSerialization(String preorder) {
        // remove the commas in the preorder string
        String[] nodes = preorder.split(",");

        /*
            holds a buffer of nodes that remain to be added, each non-null node encountered increases the count by 2
            since each subtree can have a total of three nodes, i.e. root, left, and right. Each null node reduces the
            count by 1
         */
        int buffer = 1; // start at once since a tree starts with a root node

        for (String node : nodes) {
            // reduce buffer due to new node added
            buffer--;

            // return false if buffer is exhausted
            if (buffer < 0) {
                return false;
            }

            // increase buffer by 2 if the node is not null
            if (!node.equals("#")) {
                buffer += 2;
            }
        }
        // all nodes were added
        return buffer == 0;
    }
}
