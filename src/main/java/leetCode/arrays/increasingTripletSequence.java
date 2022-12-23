package leetCode.arrays;

public class increasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        //we need three total indexes so if the size of the array is less than 3 return false
        if (nums.length < 3) {
            return false;
        }

        /*
            we have 4 pointers, a, b, c, d, each represent a pair of decreasing sequences in nums
             - the first pair a, b are the first occurrence of an increasing sequence in nums so a < b
             - we then find another increasing sequence and set those values to c and d so c < d
             - finally, we compare the indexes to check if the sequences are valid, if a < c or b < d then we found an
               triplet increasing sequence
        */
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        int c, d;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                c = nums[i];
                d = nums[i + 1];

                /*
                    c < d if we are in this piece of code, so all that is left to do is check if a < c or if b < d, by
                    transitive property if a < c, then a is also < d so this makes it a valid triplet, the same applies
                    to b, if b < d then since a is < b, this makes it another valid triplet
                */
                if (a < c || b < d) {
                    return true;
                }
                //save the current increasing sequence for the next time we find another
                a = c;
                b = d;
            }
        }
        return false;
    }
}
