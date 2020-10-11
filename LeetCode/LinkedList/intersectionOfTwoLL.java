public class intersectionOfTwoLL {
    /*
       Once both lists reached their ends, then switch their pointers with the other, so if a list
       is longer by two nodes, when the shorter ends, it'll be pointed to the longer list therefore
       it'll be ahead by two so when the longer resets, it'll start on par with the other list allowing it to find the intersection
   */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a_pointer = headA;
        ListNode b_pointer = headB;

        while (a_pointer != b_pointer) {

            //if listA reaches the end, point it to the listB
            if (a_pointer == null) {
                a_pointer = headB;
            } else {
                a_pointer = a_pointer.next;
            }

            //if listB reaches the end, point it to the listA
            if (b_pointer == null) {
                b_pointer = headA;
            } else {
                b_pointer = b_pointer.next;
            }
        }
        return a_pointer;
    }
}
