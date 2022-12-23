package leetCode.design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class designHashMap {
    /*
    Design a HashMap without using any built-in hash table libraries.
    To be specific, your design should include these functions:
        - put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
        - get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
        - remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

    Example:
    MyHashMap hashMap = new MyHashMap();
    hashMap.put(1, 1);
    hashMap.put(2, 2);
    hashMap.get(1);            // returns 1
    hashMap.get(3);            // returns -1 (not found)
    hashMap.put(2, 1);          // update the existing value
    hashMap.get(2);            // returns 1
    hashMap.remove(2);          // remove the mapping for 2
    hashMap.get(2);            // returns -1 (not found)

    Note:
        All keys and values will be in the range of [0, 1000000].
        The number of operations will be in the range of [1, 10000].
        Please do not use the built-in HashMap library.
     */

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    //This class is an easy way of implementing a hashmap like structure although it does not work like a hashmap
    class MyHashMapEz {
        int[] map;

        /**
         * Initialize your data structure here.
         */
        public MyHashMapEz() {
            map = new int[1000000]; //max value in the map will be 1000000
            //fill in all the cells to -1 in the map
            Arrays.fill(map, -1);
            /*
            instead of filling the array with -1, to reflect all indexes being -1, when we add a new value, we add the
            value + 1, when we get a value, we return the value - 1 so if map[key] = 0, -1 will be returned. Removing values
            just sets map[key] to 0. All functions are now O(1).
            */
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            //indexes of the array work as keys
            map[key] = value;

            //Efficient way
            //map[key] = value + 1
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return map[key];

            //efficient way
            //return map[key] - 1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            map[key] = -1;

            //efficient way
            //map[key] = 0;
        }
    }

    /******************************************************************************************************************/
    class MyHashMap {
        //entry class for objects added, i.e. key-value pairs
        class Entry {
            //each entry has a key and value pair
            public int key;
            public int value;

            //constructor to make a new Entry object
            public Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        /*
            A hashmap is a LinkedList DS where nodes can be thought of buckets that hold entries. A bucket can hold either
            one or many entries depending on how many collisions are encountered when adding new entries. To minimize the
            number of collisions, we need a good hash function and for that we need a large enough prime number.
            TC: O(1) and O(n) space used
        */
        List<Entry>[] map;
        public static final int SIZE = 2027;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            map = new LinkedList[SIZE];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            //get the bucket from where to add the new entry
            int bucket = key % SIZE;

            //if the bucket does not exists, create it and add the entry to it
            if (map[bucket] == null) {
                map[bucket] = new LinkedList<>();
            } else {
                /*
                    if the bucket exists, search through the entries and if the key already exists, update its value,
                    otherwise add the new entry to the bucket
                 */
                for (Entry entry : map[bucket]) {
                    if (entry.key == key) {
                        entry.value = value;
                        return;
                    }
                }
            }
            map[bucket].add(new Entry(key, value));
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            //get the bucket to search for
            int bucket = key % SIZE;
            //get the list of the bucket and search for the value for the key
            List<Entry> entries = map[bucket];
            //the bucket does not exist
            if (entries == null) {
                return -1;
            }
            //search through entries for "key" and if found return its value
            for (Entry entry : entries) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
            //key does not exist in the map
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            //get the bucket
            int bucket = key % SIZE;
            Entry toRemove = null; //reference to the entry to be removed, if unchanged, the entry does not exist
            List<Entry> entries = map[bucket];
            //bucket does not exist
            if (entries == null) {
                return;
            } else {
                //if the bucket exists, search for the entry to be removed
                for (Entry entry : entries) {
                    if (entry.key == key) {
                        toRemove = entry;
                    }
                }
                //if the entry to be removed is not null, then it exists
                if (toRemove == null) {
                    return;
                } else {
                    map[bucket].remove(toRemove);
                }
            }
        }
    }
}
