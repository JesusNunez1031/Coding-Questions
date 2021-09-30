public class SplitLinkedListInParts {
    /*
    Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

    The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
    This may lead to some parts being null.

    The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a
    size greater than or equal to parts occurring later.

    Return an array of the k parts.

    Example 1:
    Input: head = [1,2,3], k = 5
    Output: [[1],[2],[3],[],[]]
    Explanation:
    The first element output[0] has output[0].val = 1, output[0].next = null.
    The last element output[4] is null, but its string representation as a ListNode is [].

    Example 2:
    Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
    Output: [[1,2,3,4],[5,6,7],[8,9,10]]
    Explanation:
    The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size
    than the later parts.

    Constraints:
        The number of nodes in the list is in the range [0, 1000].
        0 <= Node.val <= 1000
        1 <= k <= 50
     */
    //TC: O(n + k) where n is the number of nodes in list
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];

        // find the length of the list
        int length = 0;
        ListNode iter = head;
        while (iter != null) {
            length++;
            iter = iter.next;
        }

        // size of one part list
        int partLength = length / k;

        // number of extra nodes to add at the first couple of part lists
        int overflow = length % k;

        int i = 0; // parts made counter and index pointer

        // reset iter, prev will be used to disconnect the last node of a part from given list
        iter = head;
        ListNode prev = null;

        while (iter != null && i < k) {
            parts[i] = iter; // set the current list at index i

            // Each part will be of length "partLength" and we add 1 extra node to the current part of overflow nodes remain
            for (int j = 0; j < partLength + (overflow > 0 ? 1 : 0); j++) {
                prev = iter;
                iter = iter.next;
            }

            i++;
            overflow--;
            prev.next = null; // cut off the current part list from the given list
        }
        return parts;
    }
}
