package leetCode.arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicatesLen(int[] nums) {
        int ptr;
        int length = 1;

        for(int i = 1; i < nums.length;) {
            ptr = nums[i-1];
            if(ptr == nums[i]) {
                while(ptr == nums[i]) {
                    i++;
                }
            }
            else {
                length++;
                i++;
            }
        }
        return length;
    }

    public static int removeDuplicates(int[] nums) {
        int ptr = 1;

        for(int i = 0;i < nums.length-1;i++) {
            //Modify the array to the right value only if the values are not dups
            if(nums[i] != nums[i+1]) {
                nums[ptr++] = nums[i+1];
            }
        }
        return ptr;
    }

    public static void main(String[] args) {
        int[] array = {0,0,1,1,1,2,2,3,3,4};

        //System.out.println(removeDuplicatesLen(array));
        System.out.println(removeDuplicates(array));
    }
}
