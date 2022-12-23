package leetCode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /*
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
    Implement the leetCode.design.LRUCache class:

    leetCode.design.LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to
    the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

    Follow up:
    Could you do get and put in O(1) time complexity?

    Example 1:
    Input
    ["leetCode.design.LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    Output
    [null, null, null, 1, null, -1, null, -1, 3, 4]

    Explanation
    leetCode.design.LRUCache lRUCache = new leetCode.design.LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4

    Constraints:
        1 <= capacity <= 3000
        0 <= key <= 3000
        0 <= value <= 104
        At most 3 * 104 calls will be made to get and put.
     */
    //A Node has a key-value pair, and a reference to the next and previous node
    private static class Node {
        private Node next;
        private Node prev;
        private int val;
        private int key;

        //Each node will have a key and a value
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class DoublyLinkedList {
        private Node head;
        private Node tail;

        private DoublyLinkedList() {
            //sentinel values in the list
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);

            head.next = tail;
            tail.next = head;

        }

        public void remove(Node node) {
            //given the node to delete, point its previous node to the current node's next
            node.prev.next = node.next;
            //point the next node to the previous node of the node to be deleted
            node.next.prev = node.prev;
        }

        //add new nodes are added to the front of the list, after sentinel head node
        public void add(Node node) {
            Node head_next = head.next;
            head.next = node;
            node.prev = head;
            node.next = head_next;
            head_next.prev = node;
        }
    }

    //map used to check if a key exists in the cache in constant time
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList list = new DoublyLinkedList();   //we use a DLL to make deletion constant
    private final int CAPACITY;

    //initialize a cache of size capacity
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.CAPACITY = capacity;
    }

    public int get(int key) {
        /*
            if the "cache" has the key, we need to return its value, however, since we used it, we remove it and add
            it to the list since its the most recently used
         */
        if (cache.containsKey(key)) {
            Node used = cache.get(key);
            list.remove(used);
            list.add(used);

            return used.val;
        }
        //the cache does not contain the key
        return -1;
    }

    public void put(int key, int value) {
        /*
            if the cache contains the key, we need to update it to the new value, and since we used it, we also need to
            move it to the front of the list since its now the most recently used key
         */
        if (cache.get(key) != null) {
            Node updated = cache.get(key);
            list.remove(updated);
            updated.val = value;
            list.add(updated);
        } else {
            /*
                if the cache reaches capacity, remove the least used key, from the cache. We simulate this in the list
                by removing the last item in the list
             */
            if (cache.size() == CAPACITY) {
                //remove the least used item in cache from list and map
                cache.remove(list.tail.prev.key);
                list.remove(list.tail.prev);
            }
            //add the new item to the cache and list if there is space
            Node newNode = new Node(key, value);
            list.add(newNode);
            cache.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
