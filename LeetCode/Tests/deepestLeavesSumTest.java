import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class deepestLeavesSumTest {
    deepestLeavesSum driver = new deepestLeavesSum();

    @Test
    @DisplayName("Simple Tree")
    void SimpleTree() {
        TreeNode tree = new TreeNode();
        tree = tree.makeTree(new Integer[]{1, 2, 3});
        assertEquals(5, driver.deepestLeavesSum(tree));
    }

    @Test
    @DisplayName("Simple Tree 2")
    void SimpleTree2() {
        TreeNode tree = new TreeNode();
        tree = tree.makeTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertEquals(27, driver.deepestLeavesSum(tree));
    }

    @Test
    @DisplayName("Complex Tree")
    void ComplexTree() {
        TreeNode tree = new TreeNode();
        tree = tree.makeTree(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
        assertEquals(19, driver.deepestLeavesSum(tree));
    }

    @Test
    @DisplayName("Complex Tree 2")
    void ComplexTree2() {
        TreeNode tree = new TreeNode();
        tree = tree.makeTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, null, null, 8});
        assertEquals(15, driver.deepestLeavesSum(tree));
    }

    @Test
    @DisplayName("Complex Tree 3")
    void ComplexTree3() {
        TreeNode tree = new TreeNode();
        tree = tree.makeTree(new Integer[]{5, 4, 8, 11, null, 17, 4, 7, null, null, null, 5});
        assertEquals(12, driver.deepestLeavesSum(tree));
    }
}