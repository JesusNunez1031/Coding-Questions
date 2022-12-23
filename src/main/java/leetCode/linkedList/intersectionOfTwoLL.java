package leetCode.linkedList;

public class intersectionOfTwoLL {
    /*
    Write a program to find the node at which the intersection of two singly linked lists begins.

    For example, the following two linked lists:
    A:           [a1] -> [a2] ↴
                             [c1] -> [c2] -> [c3]
    B:   [b1] -> [b2] -> [b3]  ┘

    begin to intersect at node c1.

    Example 1:
    A:           [4] -> [1] ↴
                            [8] -> [4] -> [5]
    B:   [5] -> [6] -> [1]   ┘
    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
    Output: Reference of the node with value = 8
    Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From
    the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the
    intersected node in A; There are 3 nodes before the intersected node in B.

    Example 2:
    A:    [1] -> [9] -> [1] ↴
                            [2] -> [4]
    B:                 [3]   ┘
    Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    Output: Reference of the node with value = 2
    Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From
    the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the
    intersected node in A; There are 1 node before the intersected node in B.

    Example 3:
    A: [2] -> [6] -> [4]

    B: [1] -> [5]
    Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
    Output: null
    Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two
    lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
    Explanation: The two lists do not intersect, so return null.

    Notes:
        If the two linked lists have no intersection at all, return null.
        The linked lists must retain their original structure after the function returns.
        You may assume there are no cycles anywhere in the entire linked structure.
        Each value on each linked list is in the range [1, 10^9].
        Your code should preferably run in O(n) time and use only O(1) memory.
     */
    //TC: O(m + n) and O(1) space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //check for valid lists
        if (headA == null || headB == null) {
            return null;
        }

        //pointers to list A and B
        ListNode a_pointer = headA;
        ListNode b_pointer = headB;

        /*
            Once a list reaches its last node, set its pointer to the start of the other list. If a list is longer by two
            nodes, when the shorter list ends, it'll be pointed to the longer list therefore it'll be ahead by 2 so when
            the longer is reset to the shorter list, it'll start on par with the other list allowing it to find the
            intersection, if there is no intersection, loop will end on null
         */
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
