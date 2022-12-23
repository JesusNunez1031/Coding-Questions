package leetCode.binarySearch;

public class findSmallestLetterGreaterThanTarget {
    /*
    Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find
    the smallest element in the list that is larger than the given target.
    Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

    Examples:
    Input:
    letters = ["c", "f", "j"]
    target = "a"
    Output: "c"

    Input:
    letters = ["c", "f", "j"]
    target = "c"
    Output: "f"

    Input:
    letters = ["c", "f", "j"]
    target = "d"
    Output: "f"

    Input:
    letters = ["c", "f", "j"]
    target = "g"
    Output: "j"

    Input:
    letters = ["c", "f", "j"]
    target = "j"
    Output: "c"

    Input:
    letters = ["c", "f", "j"]
    target = "k"
    Output: "c"

    Note:
        letters has a length in range [2, 10000].
        letters consists of lowercase letters, and contains at least 2 unique letters.
        target is a lowercase letter.
     */
    //TC: O(log n)
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            //if the value of letters of mid is less than target we want to move right, otherwise we want to move left
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        /*
            since we can wrap around the array, if the left is at the end of array, we return the index of the remainder,
            otherwise if left is within bounds of letters, the remainder will be the index
         */

        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
        char target = 'a';

        System.out.println(nextGreatestLetter(arr, target));
    }
}
