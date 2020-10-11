public class RemoveDuplicatesFromList {

    public static ListNode set;

    //Method with external set for testing
    public static ListNode deleteDuplicatesTest(ListNode head) {
        set = new ListNode(head.val);
        ListNode setHead = set;

        head = head.next;

        while (head != null) {
            if (head.val != setHead.val) {
                setHead.next = new ListNode(head.val);
                setHead = setHead.next;
            }
            head = head.next;
        }
        return set;
    }

    public ListNode deleteDuplicates(ListNode head) {
        //Check for null lists
        if (head == null) {
            return null;
        }

        //Make a new List to hold values and set it to the first value in given list
        ListNode set = new ListNode(head.val);
        //Set a pointer var for set
        ListNode setHead = set;

        //move head pointer by one since we already added it to the set
        head = head.next;

        while (head != null) {
            //If the next value in given list isnt in out set, set it to the next node in set and move pointer
            if (head.val != setHead.val) {
                setHead.next = new ListNode(head.val);
                setHead = setHead.next;
            }
            //Otherwise we move given list pointer by 1
            head = head.next;
        }
        return set;
    }


    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
//
//        ListNode head = l1;
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }

        ListNode list = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
//        ListNode l4 = new ListNode(3);
//        ListNode l5 = new ListNode(3);

        list.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        deleteDuplicatesTest(list);

        while (list != null) {
            System.out.printf("%d -> ", list.val);
            list = list.next;
        }

        System.out.println();

        while (set != null) {
            System.out.printf("%d -> ", set.val);
            set = set.next;
        }

    }
}
