package leetCode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class N_aryTreePostorderTraversal {
    /*
        Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

        Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated
        by the null value (See examples)

        Example 1:
                            [1]
                        /    |    \
                      [3]   [2]   [4]
                    /     \
                  [5]     [6]
        Input: root = [1,null,3,2,4,null,5,6]
        Output: [5,6,3,2,4,1]

        Example 2:
                     __________[1]___________
                    /       /       \        \
                  [2]     [3]       [4]       [5]
                         /   \       |       /   \
                       [6]   [7]    [8]    [9]   [10]
                              |      |      |
                             [11]   [12]   [13]
                              |
                             [14]
        Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]

        Constraints:
            The number of nodes in the tree is in the range [0, 10^4].
            0 <= leetCode.trees.Node.val <= 104
            The height of the n-ary tree is less than or equal to 1000.

        Follow up: Recursive solution is trivial, could you do it iteratively?
     */
    //TC: O(n) if skewed tree or O(max(height of tree))
    public List<Integer> postorder(Node root) {
        return postOrderHelper(root, new ArrayList<>());
    }

    public List<Integer> postOrderHelper(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        //process all children first
        for (Node child : root.children) {
            postOrderHelper(child, list);
        }

        //postorder so left is processed first, then right, then finally root
        list.add(root.val);

        return list;
    }

    //Follow up | TC/S: O(n)
    public List<Integer> postorderIter(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        //list to hold postorder values
        List<Integer> list = new ArrayList<>();

        //stack to simulate recursion through iteration
        Stack<Node> stack = new Stack<>();

        //add the first node into the stack
        stack.push(root);

        while (!stack.isEmpty()) {
            /*
                we only pop a node from the stack if its been visited already, so to get the current node we peek the top
                of the stack
             */
            Node curr = stack.peek();

            /*
                if the current node has children process the children by adding them to the stack in reverse order since
                postorder is left, right, then root hence the leftmost node will be at the top
             */
            if (curr.children != null) {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    stack.push(curr.children.get(i));
                }

                //once the current nodes children have been processed, erase its children to avoid repeat nodes
                curr.children = null;
            } else {
                //if a node has no children, it must have been processed already so we add it to the list
                list.add(stack.pop().val);
            }
        }
        return list;
    }
}
