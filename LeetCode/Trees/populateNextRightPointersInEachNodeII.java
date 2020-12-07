public class populateNextRightPointersInEachNodeII {
    /*
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.

    Follow up:
        You may only use constant extra space.
        Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

    Example 1:
                           1 --> null
                        /     \
                       2  -->  3 --> null
                    /     \      \
                   4  -->  5  -->  7 --> null
    Input: root = [1,2,3,4,5,null,7]
    Output: [1,#,2,3,#,4,5,7,#]
    Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its
    next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers,
    with '#' signifying the end of each level.


    Constraints:
        The number of nodes in the given tree is less than 6000.
        -100 <= node.val <= 100
     */
    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //TC/S: O(n)/O(1) space
    private Node connect(Node root) {
        if (root == null) {
            return null;
        }

        //reference node to the head used to iterate through tree
        Node iter = root;

        while (iter != null) {
            /*
                temp nodes used to traverse a level in the tree, the dummy node will hold all the nodes in a level, while
                temp will be used to iterate through the level
            */
            Node dummy = new Node(0);
            Node temp = dummy;

            while (iter != null) {
                /*
                    if there is a left node from the root, set the next of the dummy to it and move temp
                    to the left node
                */
                if (iter.left != null) {
                    temp.next = iter.left;
                    temp = temp.next;
                }

                /*
                    repeat the previous step with only of the root has a right node, we set the the next of the left to
                    the right node
                 */
                if (iter.right != null) {
                    temp.next = iter.right;
                    temp = temp.next;
                }
                //when the root node's next is null, we have completed a level
                iter = iter.next;
            }
            /*
                move to the node that is next from dummy, from the root, if left was not null, then we move to the node
                left of the root since the first next from the dummy is the left node. If the left was null, then we move
                to the right of the right
            */
            iter = dummy.next;
        }
        return root;
    }
}
