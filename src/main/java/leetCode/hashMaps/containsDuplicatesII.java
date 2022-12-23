package leetCode.hashMaps;

import java.util.HashMap;
import java.util.Map;

public class containsDuplicatesII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k <= 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!(map.containsKey(nums[i]))) {
                map.put(nums[i], i);
            } else {
                int j = map.get(nums[i]);
                if (i != j && Math.abs(i - j) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
