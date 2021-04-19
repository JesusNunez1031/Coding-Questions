import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class removeNthNodeFromEndTest {
    removeNthNodeFromEnd driver = new removeNthNodeFromEnd();

    @Test
    @DisplayName("Remove node at the center")
    void removeNthFromEndCenter() throws Exception {
        //make the expected list
        ListNode expected = new ListNode();
        expected = expected.makeList(new int[]{1, 2, 4, 5});

        //create the resulting list by calling method with values and nth node to delete
        ListNode list = new ListNode();
        list = driver.removeNthFromEnd(list.makeList(new int[]{1, 2, 3, 4, 5}), 3);

        //assert all values in both lists are the same
        while(expected != null) {
            assertEquals(expected.val, list.val);
            expected = expected.next;
            list = list.next;
        }

        //assert if both lists have reached the end, i.e. both list & result == null
        assertEquals(expected, list);
    }

    @Test
    @DisplayName("Remove last node")
    void removeNthFromEndLast() throws Exception {
        ListNode expected = new ListNode();
        expected = expected.makeList(new int[]{1, 2, 3, 4});

        ListNode list = new ListNode();
        list = driver.removeNthFromEnd(list.makeList(new int[]{1, 2, 3, 4, 5}), 1);

        while(expected != null) {
            assertEquals(expected.val, list.val);
            expected = expected.next;
            list = list.next;
        }
        assertEquals(expected, list);
    }
}