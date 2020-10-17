import java.util.ArrayList;
import java.util.List;

public class findAllDisappearedNumbers {

    //Using another array to find missing values
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] range = new int[nums.length + 1];

        for (int num : nums) {
            range[num]++;
        }

        for (int i = 1; i < range.length; i++) {
            if (range[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
