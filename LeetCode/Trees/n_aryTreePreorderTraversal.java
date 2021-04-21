import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class n_aryTreePreorderTraversal {
    /*
        Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

        Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated
        by the null value (See examples)


        Example 1:
                            [1]
                        /    |    \
                      [3]   [2]   [4]
                    /     \
                  [5]     [6]
        Input: root = [1,null,3,2,4,null,5,6]
        Output: [1,3,5,6,2,4]

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
        Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]

        Constraints:
            The number of nodes in the tree is in the range [0, 10^4].
            0 <= Node.val <= 104
            The height of the n-ary tree is less than or equal to 1000.

        Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    //TC: O(n) if skewed tree or O(max(height of tree))
    public List<Integer> preorder(Node root) {
        return preorderHelper(root, new ArrayList<>());
    }

    private List<Integer> preorderHelper(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        //process root first
        list.add(root.val);

        //then search through all the children
        for (Node child : root.children) {
            preorderHelper(child, list);
        }

        return list;
    }

    //Follow up | TC/S: O(n) since we use a stack to simulate recursion
    public List<Integer> preorderIter(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        //list to hold preorder values
        List<Integer> list = new ArrayList<>();

        //stack to simulate recursion through iteration
        Stack<Node> stack = new Stack<>();

        //add the first node to the stack
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            //preorder so we process the root first
            list.add(curr.val);

            /*
                since preorder is root, left, then right, we have to add child nodes in reverse order so after adding
                all "curr" children nodes to the stack, the top node will be the left-most node
            */
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }
        return list;
    }
}
