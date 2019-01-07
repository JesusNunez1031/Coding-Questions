import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {

    //Question: count the occurrences of each element in a single-linked list
    /*
    Defenition for singly-linked list
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
     }

     Solution: Iterate through nodes in linked list and count using a Map
     Runtime: O(n)
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public static Map<Integer, Integer> count(ListNode lst){
        Map<Integer, Integer> map = new HashMap<>();

        while (lst != null){
            int cnt = map.getOrDefault(lst.val, 0) + 1;
            map.put(lst.val, cnt);
        }
        return map;
    }
}
