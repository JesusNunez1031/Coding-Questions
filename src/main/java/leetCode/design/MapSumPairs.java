package leetCode.design;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {
    /*
    Implement the MapSum class:
        - MapSum() Initializes the MapSum object.
        - void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
        - int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.

    Example 1:
    Input
    ["MapSum", "insert", "sum", "insert", "sum"]
    [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
    Output
    [null, null, 3, null, 5]

    Explanation
    MapSum mapSum = new MapSum();
    mapSum.insert("apple", 3);
    mapSum.sum("ap");           // return 3 (apple = 3)
    mapSum.insert("app", 2);
    mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)

    Constraints:
        1 <= key.length, prefix.length <= 50
        key and prefix consist of only lowercase English letters.
        1 <= val <= 1000
        At most 50 calls will be made to insert and sum.
     */

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
    //TC: O(k^2) where k is the avg length of all key's added
    class MapSum {
        Map<String, Integer> map; // holds all the entries from insert()
        Map<String, Integer> scores; //for every new entry, all its prefixes are added to this map to avoid searching for prefixes from entries in "map"

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            map = new HashMap<>();
            scores = new HashMap<>();
        }

        public void insert(String key, int val) {
            //calculate the difference between the keys value and the value previously seen for this key if any
            int diff = val - map.getOrDefault(key, 0);

            // add the entry to the map, so we can later reference it to update scores for all similar "key" prefixes
            map.put(key, val);

            StringBuilder prefix = new StringBuilder();

            /*
                add all the prefixes of "key" and set their values to the diff, so if the prefix has been seen before it
                gets updated to the difference between its new value, and it's old
             */
            for (char c : key.toCharArray()) {
                prefix.append(c);
                // put/update the prefix value in scores
                scores.put(prefix.toString(), scores.getOrDefault(prefix.toString(), 0) + diff);
            }
        }

        public int sum(String prefix) {
            // return the value from the map of prefixes, if prefix does not exist, default to 0
            return scores.getOrDefault(prefix, scores.getOrDefault(prefix, 0));
        }
    }
}
