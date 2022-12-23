package leetCode.trees;

public class pseudoPalindromicPathsInBinaryTree {
    /*
    Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic
    if at least one permutation of the node values in the path is a palindrome.

    Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

    Example 1:
          2
      → /   \ ←
       3     1
    → /  \    \ ←
     3    1    1
    Input: root = [2,3,1,3,1,null,1]
    Output: 2
    Explanation: The figure above represents the given binary tree. There are three paths going from the root node to
    leaf nodes: the path with → "red" [2,3,3], the path with ← "green" [2,1,1], and the path [2,3,1]. Among these
    paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3]
    (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).

    Example 2:
          2
      → /   \
       1     1
    → /  \
     1    3
           \
            1
    Input: root = [2,1,1,1,3,null,null,null,null,null,1]
    Output: 1
    Explanation: The figure above represents the given binary tree. There are three paths going from the root node to l
    eaf nodes: the green path "→" [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is
    pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).

    Example 3:
    Input: root = [9]
    Output: 1

    Constraints:
        The given binary tree will have between 1 and 10^5 nodes.
        leetCode.trees.Node values are digits from 1 to 9.
     */
    int paths = 0;  //count of pseudo palindrome paths
    int[] digits = new int[10]; //array to hold the frequency of the values for a path in the tree

    //TC: O(n) and O(h) space used where h is height of the tree
    private int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);

        return paths;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        //increase the frequency of the current digit
        digits[root.val]++;

        //if we are at a leaf node, check if the path is a pseudo palindrome path
        if (root.left == null && root.right == null) {
            if (isPalindrome()) {
                paths++;
            }
        } else {
            dfs(root.left);
            dfs(root.right);
        }
        //backtrack and reset the frequency of the values
        digits[root.val]--;
    }

    /*
        we check if at most one digit has an odd frequency (parity), if there is only one odd frequency, the path is a
        pseudo palindrome since its values can be rearranged into a valid palindrome
     */
    private boolean isPalindrome() {
        int odds = 0;

        for (int i = 1; i < digits.length; i++) {
            if (digits[i] % 2 != 0) {
                odds++;
            }
            if (odds > 1) {
                return false;
            }
        }
        return true;
    }
}
