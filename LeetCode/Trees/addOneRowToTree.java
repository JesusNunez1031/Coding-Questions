import java.util.LinkedList;
import java.util.Queue;

public class addOneRowToTree {
    /*
    Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given
    depth d. The root node is at depth 1.

    The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree
    nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left
    subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree
    root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root
    of the whole original tree, and the original tree is the new root's left subtree.

    Example 1:
    Input:
    A binary tree as following:
           4
         /   \
        2     6
       / \   /
      3   1 5
    v = 1
    d = 2
    Output:
           4
          / \
         1   1
        /     \
       2       6
      / \     /
     3   1   5

    Example 2:
    Input:
    A binary tree as following:
          4
         /
        2
       / \
      3   1
    v = 1
    d = 3
    Output:
          4
         /
        2
       / \
      1   1
     /     \
    3       1

    Note:
        The given d is in range [1, maximum depth of the given tree + 1].
        The given binary tree has at least one tree node.
     */
    //TC: O(n) and O(d) space were d is the depth required "d", worst case we visit n nodes [BFS]
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        //if the depth is 1, we make a new node for v, and attach the tree to the left of the new node
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth += 1;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                /*
                    when the depth is d - 1, we know that this is where we will attach the new nodes v, to do that we first
                    save the reference to the current nodes left and right subtrees, then we make the new nodes and set
                    them to the left and right, and finally we reattach the original left and right subtrees to the new
                    nodes v
                */
                if (depth == d - 1) {
                    TreeNode temp_left = curr.left;
                    TreeNode temp_right = curr.right;

                    curr.left = new TreeNode(v);
                    curr.right = new TreeNode(v);

                    curr.left.left = temp_left;
                    curr.right.right = temp_right;
                } else {
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
            }
            //once we've added the new nodes, we don't need to process no more nodes
            if (depth >= d - 1) {
                break;
            }
        }
        return root;
    }

    //TC: O(n) and O(n) space due to the use of recursive stack [DFS]
    public TreeNode addOneRowDFS(TreeNode root, int v, int d) {
        //if depth == 1, we make a new node v and set its left to the tree
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        addNewRow(root, v, d, 1);

        return root;
    }

    private void addNewRow(TreeNode root, int v, int d, int depth) {
        if (root == null) {
            return;
        }
        /*
            when we get to the d - 1 depth, we need to add the new nodes so they are at depth d, we save the reference
            to the left subtree, add the new node v to the left, and then make the left subtree of the new node v the
            original left subtree. Repeat the same steps for the right
         */
        if (depth == d - 1) {
            TreeNode temp_left = root.left;
            root.left = new TreeNode(v);
            root.left.left = temp_left;
            TreeNode temp_right = root.right;
            root.right = new TreeNode(v);
            root.right.right = temp_right;
        } else {
            addNewRow(root.left, v, d, depth + 1);
            addNewRow(root.right, v, d, depth + 1);
        }
    }
}
