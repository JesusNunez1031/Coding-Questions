import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class Problem2 {

    //Question: Remove duplicates in a linked list
    /*
    Defenition for singly-linked list
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
     }

     Solution 1: For every node, look forward for the same node and remove
     Runtime: O(n^2), O(1) space
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public void removeDups(ListNode head){
        ListNode cur = head;

        while (cur != null){
            ListNode runner = cur;
            while (runner.next != null){
                if(runner.next.val == cur.val){
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
    }

    /* Solution 2: Iterate through list. If you haven't seen the current node before,
    add it to visited set. Otherwise remove it
     */

    public void removeDups2(ListNode n){
        Set<Integer> set = new HashSet<>();
        ListNode prev = null;
        while (n != null){
            if(set.contains(n.val)){
                prev.next = n.next;
            }
            else {
                set.add(n.val);
                prev = n;
            }
            n = n.next;
        }
    }
}
