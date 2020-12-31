import java.util.LinkedList;
import java.util.Queue;

public class populateNextRightPointersInEachNode {
    /*
    You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
    The binary tree has the following definition:
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should b
    e set to NULL.
    Initially, all next pointers are set to NULL.

    Follow up:
    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

    Example 1:
    Input: root = [1,2,3,4,5,6,7]
    Output: [1,#,2,3,#,4,5,6,7,#]

    Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point
    to its next right node, just like in Figure B. The serialized output is in level order as connected by the next
    pointers, with '#' signifying the end of each level.

    Constraints:
        The number of nodes in the given tree is less than 4096.
        -1000 <= node.val <= 1000
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

    public static Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }

        //connect the left node of root to the right node of root
        root.left.next = root.right;

        //if the current node has a next, point the right of the node to the left of the next of the root node
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        //call the method on the left and right trees
        connect(root.left);
        connect(root.right);

        return root;
    }

    private Node connectBFS(Node root) {
        if(root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size;i++) {
                Node current = queue.remove();

                //if the current node has a right, we set its left.next to the right node
                if(current.right != null) {
                    current.left.next = current.right;
                    //point the right of the current node to the left of the node .next to the current node
                    if(current.next != null) {
                        current.right.next = current.next.left;
                    }
                }

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = null;
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, new Node(6), new Node(7), null);


    }
}
