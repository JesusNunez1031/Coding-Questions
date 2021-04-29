import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class findFirstAndLastPositionOfElementTest {
    findFirstAndLastPositionOfElement driver = new findFirstAndLastPositionOfElement();

    @Test
    @DisplayName("One occurrence of target")
    void searchRangeOneOccurrenceOfTarget() {
        int[] nums = new int[]{1, 2, 3, 4, 8};
        int target = 3;
        assertArrayEquals(new int[]{2, 2}, driver.searchRange(nums, target));
        System.out.printf("%d appears only once at index %d in array %s", target, 2, Arrays.toString(nums));
    }

    @Test
    @DisplayName("Two occurrences of target")
    void searchRangeTwoOccurrenceOfTarget() {
        int[] nums = new int[]{1, 2, 3, 3, 4, 4, 8, 9};
        int target = 4;
        assertArrayEquals(new int[]{4, 5}, driver.searchRange(nums, target));
        System.out.printf("%d appears twice, first at index %d, then again at index %d in array %s", target, 4, 5, Arrays.toString(nums));
    }

    @Test
    @DisplayName("Multiple occurrences of target")
    void searchRangeMultipleOccurrenceOfTarget() {
        int[] nums = new int[]{1, 2, 3, 3, 4, 4, 8, 8, 8, 8, 8, 8, 9};
        int target = 8;
        assertArrayEquals(new int[]{6, 11}, driver.searchRange(nums, target));
        System.out.printf("%d appears multiple times, first at index %d, lastly at index %d in array %s", target, 6, 11, Arrays.toString(nums));
    }
}