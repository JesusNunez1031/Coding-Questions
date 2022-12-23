package leetCode.linkedList;

import java.util.PriorityQueue;

public class mergeKSortedLists {
    /*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

    Merge all the linked-lists into one sorted linked-list and return it.

    Example 1:
    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6

    Example 2:
    Input: lists = []
    Output: []

    Example 3:
    Input: lists = [[]]
    Output: []

    Constraints:
        k == lists.length
        0 <= k <= 10^4
        0 <= lists[i].length <= 500
        -10^4 <= lists[i][j] <= 10^4
        lists[i] is sorted in ascending order.
        The sum of lists[i].length won't exceed 10^4.
     */
    //TC/S: O(n log k) where n is the number of nodes in the merged list and k is the number of lists  and O(n) space used since we used a priorityqueue
    public ListNode mergeKListsEz(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode merged = new ListNode(-1);
        ListNode iter = merged;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        //iterate through each node in the specific kthList and add them to the minheap
        for (ListNode kthList : lists) {
            ListNode list = kthList;

            while (list != null) {
                heap.add(list.val);
                list = list.next;
            }
        }

        //smallest values in the lists will be at the top of the heap, so values are removed from heap and added to the merged list
        while (!heap.isEmpty()) {
            iter.next = new ListNode(heap.remove());
            iter = iter.next;
        }
        return merged.next;
    }

    //Method 2 TC/S: O(n log k) where n is the number of nodes in the lists and k is the number of lists
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int interval = 1;   //holds the pointer to the next pair of lists to be merged

        //iterate through the list of lists and merged 2 lists at a time
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //if both lists are null, return null
        if (l1 == null && l2 == null) {
            return null;
        }

        //check if one list is empty, return the one that isn't
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode merged;    //merged will hold merged nodes from l1 and l2

        //if the first node in l1 is less than l2 first, make merged l1, otherwise make l2 merged
        if (l1.val <= l2.val) {
            merged = l1;
            l1 = l1.next;
        } else {
            merged = l2;
            l2 = l2.next;
        }

        ListNode iter = merged; //reference var used to modify merged

        //add values to the merged list as they come in order
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }

        //after adding nodes, if one list finished before the other, add remaining nodes
        if (l1 != null && l2 == null) {
            iter.next = l1;
        }
        if (l1 == null && l2 != null) {
            iter.next = l2;
        }
        return merged;
    }
}
