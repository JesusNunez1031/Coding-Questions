import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class n_aryTreePreorderTraversalTest {
    n_aryTreePreorderTraversal driver = new n_aryTreePreorderTraversal();

    @Test
    @DisplayName("Tree 1")
    void Tree1() {
        Node subtree_1 = new Node(3, List.of(new Node(5, List.of()), new Node(6, List.of())));
        Node root = new Node(1, List.of(subtree_1, new Node(2, List.of()), new Node(4, List.of())));

        assertEquals(List.of(1, 3, 5, 6, 2, 4), driver.preorder(root));
    }

    @Test
    @DisplayName("Tree 2")
    void Tree2() {
        Node subtree_1 = new Node(3, List.of(new Node(6, List.of()), new Node(7, List.of(new Node(11, List.of(new Node(14, List.of())))))));
        Node subtree_2 = new Node(4, List.of(new Node(8, List.of(new Node(12, List.of())))));
        Node subtree_3 = new Node(5, List.of(new Node(9, List.of(new Node(13, List.of()))), new Node(10, List.of())));
        Node root = new Node(1, List.of(new Node(2, List.of()), subtree_1, subtree_2, subtree_3));

        assertEquals(List.of(1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10), driver.preorder(root));
    }
}