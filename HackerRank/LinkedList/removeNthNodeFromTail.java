public class removeNthNodeFromTail {

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {

        int len = getLength(head) - 1;

        SinglyLinkedListNode iter = head;

        int pos = len - positionFromTail;
        int result = 0;

        while (iter != null) {
            if (pos == 0) {
                result = iter.data;
                break;
            }
            pos--;
            iter = iter.next;
        }
        return result;
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
