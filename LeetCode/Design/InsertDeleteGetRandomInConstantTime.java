import java.util.*;

public class InsertDeleteGetRandomInConstantTime {
    /*
    Implement the RandomizedSet class:
        - RandomizedSet() Initializes the RandomizedSet object.
        - bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
          false otherwise.
        - bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false
          otherwise.
        - int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one
          element exists when this method is called). Each element must have the same probability of being returned.

    You must implement the functions of the class such that each function works in average O(1) time complexity.

    Example 1:
    Input
    ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
    [[], [1], [2], [2], [], [1], [2], []]
    Output
    [null, true, false, true, 2, true, false, 2]

    Explanation
    RandomizedSet randomizedSet = new RandomizedSet();
    randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
    randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
    randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
    randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
    randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
    randomizedSet.insert(2); // 2 was already in the set, so return false.
    randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.

    Constraints:
        -2^31 <= val <= 2^31 - 1
        At most 2 * 105 calls will be made to insert, remove, and getRandom.
        There will be at least one element in the data structure when getRandom is called.
     */

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */

    class RandomizedSet {
        Map<Integer, Integer> indexes;
        List<Integer> nums;
        Random rand = new Random();

        public RandomizedSet() {
            indexes = new HashMap<>();
            nums = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element, false otherwise.
         */
        public boolean insert(int val) {
            if (indexes.containsKey(val)) {
                return false;
            }

            // add the new value to the index map with its value being the index where it is located in the list
            indexes.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element, false otherwise.
         */
        public boolean remove(int val) {
            if (!indexes.containsKey(val)) {
                return false;
            }

            // get the index of the value to be removed and the index of the last value in the list
            int index = indexes.get(val);
            int lastIndex = nums.size() - 1;

            /*
                if the index of "val" is not the last, get the value of the last index in the list, and override the
                index of "val" with this value, and update the index of the last value in the list in the indexes map.
             */
            if (index != lastIndex) {
                int lastElement = nums.get(lastIndex);
                nums.set(index, lastElement);
                indexes.put(lastElement, index);
            }

            // remove the last value from the list and remove "val" from the indexes map
            nums.remove(lastIndex);
            indexes.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }
}
