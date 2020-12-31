import java.util.Arrays;

public class AddOneToArrayNum {
    private static int[] addOneToArray(int[] nums) {
        int carry = 1;
        int total;
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            total = nums[i] + carry;
            if (total == 10)
                carry = 1;
            else
                carry = 0;
            result[i] = total % 10;
        }
        if (carry == 1) {
            result = new int[nums.length + 1];
            result[0] = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 9};
        System.out.printf("Given array %s + 1 is %s", Arrays.toString(arr), Arrays.toString(addOneToArray(arr)));
    }
}
