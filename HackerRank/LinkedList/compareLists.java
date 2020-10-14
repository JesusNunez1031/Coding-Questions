public class compareLists {
    /*
        Given the head to two lists, return true if both lists have equal values and they have equal length
     */

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null || head2 == null) {
            return false;
        }

        int len1 = getLength(head1);
        int len2 = getLength(head2);

        if (len1 != len2) {
            return false;
        }

        SinglyLinkedListNode ptr1 = head1;
        SinglyLinkedListNode ptr2 = head2;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data != ptr2.data) {
                return false;
            }

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }

    static int getLength(SinglyLinkedListNode list) {
        if (list == null) {
            return 0;
        }

        SinglyLinkedListNode iter = list;
        int size = 0;

        while (iter != null) {
            size++;
            iter = iter.next;
        }
        return size;
    }
}
