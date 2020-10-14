public class detectIntersection {
    static class Result {
        SinglyLinkedListNode tail;
        int size;

        public Result(int size, SinglyLinkedListNode tail) {
            this.size = size;
            this.tail = tail;
        }
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null || head2 == null) {
            return 0;
        }

        Result r1 = getLength(head1);
        Result r2 = getLength(head2);

        if (r1.tail != r2.tail) {
            return 0;
        }

        SinglyLinkedListNode longer = r1.size > r2.size ? head1 : head2;
        SinglyLinkedListNode shorter = r1.size < r2.size ? head1 : head2;

        longer = moveToNthNode(longer, Math.abs(r1.size - r2.size));

        while (longer != shorter) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer.data;

    }

    static SinglyLinkedListNode moveToNthNode(SinglyLinkedListNode list, int n) {
        SinglyLinkedListNode iter = list;
        while (n > 0 && iter != null) {
            iter = iter.next;
            n--;
        }
        return iter;
    }

    static Result getLength(SinglyLinkedListNode list) {

        SinglyLinkedListNode iter = list;
        int size = 1;

        while (iter.next != null) {
            size++;
            iter = iter.next;
        }
        return new Result(size, iter);
    }

}
