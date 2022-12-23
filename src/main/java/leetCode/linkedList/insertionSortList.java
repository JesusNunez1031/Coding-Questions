package leetCode.linkedList;

public class insertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sorted = new ListNode();
        //variables for the iterator of the given list, and prev and next node
        ListNode iter = head, prevNode, nextNode;

        while (iter != null) {
            //reference to the head of the sorted list and the next node
            prevNode = sorted;
            nextNode = sorted.next;

            //find the position to insert the current node
            while (nextNode != null) {
                if (iter.val < nextNode.val) {
                    break;
                }
                //update prev and next as we traverse the list
                prevNode = nextNode;
                nextNode = nextNode.next;
            }

            //save the reference to the next node in curr, will allow us to update the current node
            ListNode nextIter = iter.next;

            //insert the current node to the list
            iter.next = nextNode;
            prevNode.next = iter;

            //move the iter to the next node
            iter = nextIter;
        }
        return sorted.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        head.print(insertionSortList(head));
    }
}
