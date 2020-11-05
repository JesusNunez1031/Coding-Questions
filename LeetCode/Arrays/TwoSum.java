import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length;i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length;i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length;i++) {
            int val = target - nums[i];
            if(map.containsKey(val) && i != map.get(val)) {
                return new int[] {i, map.get(val)};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4};

        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }
}
