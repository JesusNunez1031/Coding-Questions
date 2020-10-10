public class intersection extends ListNode {
    /*
    Given two (singly) linked lists, determine if the two lists intersect. Return the
    intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
    kth node of the first linked list is the exact same node (by reference) as the jth node of the second
    linked list, then they are intersecting.
     */

    //Make a class to hold the size and tail of a given list
    static class Result {
        public int size;
        public ListNode tail;

        public Result(ListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    /*
        Method runs in O(n) time
        1. First thing we do is create a new class to hold the tail node and size given a list
        2. Compare if the tails are equal (not in value). If there is no intersection, program stops here
        3. Find out which of the two lists is longer and then move its head ptr node k spaces to the right to match
        the position of the smaller list, k = [longer.size - shorter.size]
        4. Finally we loop through comparing longer to shorter until there is a collision if any and then return either list
     */
    public static ListNode findIntersection(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        //Result objects to hold tail value and size
        Result r1 = getSizeAndSize(l1);
        Result r2 = getSizeAndSize(l2);

        //If tails are not equal, the lists have no intersection (compare memory not actual value)
        if (r1.tail != r2.tail) {
            return null;
        }

        //Set pointers to the start of each linked list
        ListNode shorter = r1.size < r2.size ? l1 : l2;
        ListNode longer = r1.size > r2.size ? l1 : l2;

        /*
            Set the pointer of the longer list to match the start pointer of the shorter list
            we do this by moving the pointer of the longer list by the length of the [longer - shorter] places
         */
        longer = getKthNode(longer, Math.abs(r1.size - r2.size));

        //While there are no collisions
        while (longer != shorter) {
            shorter = shorter.next;
            longer = longer.next;
        }

        //return either longer or shorter
        return longer;
    }

    private static ListNode getKthNode(ListNode longer, int k) {
        ListNode current = longer;

        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    /*
        Return a Result object that holds only the tail and size of a given list, we also
        make sure to not use list and use current instead to not modify the head pointer in given list
     */

    private static Result getSizeAndSize(ListNode list) {
        if (list == null) {
            return null;
        }
        int size = 1;
        ListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(7);
        l1.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next = new ListNode(1);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(6);
        l2.next = l1.next.next.next.next;

        System.out.println(findIntersection(l1, l2).val);
    }
}
