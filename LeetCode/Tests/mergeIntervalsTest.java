import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class mergeIntervalsTest {
    mergeIntervals driver = new mergeIntervals();

    @Test
    @DisplayName("List of 2 interval")
    void MergeTwoIntervals() {
        int[][] merged = driver.merge(new int[][]{{10, 30}, {21, 100}});
        assertArrayEquals(new int[][]{{10, 100}}, merged);
        System.out.println("Merged intervals: " + Arrays.deepToString(merged));

    }

    @Test
    @DisplayName("List of 3 interval")
    void MergeThreeIntervals() {
        int[][] merged = driver.merge(new int[][]{{1, 3}, {4, 6}, {5, 10}});
        assertArrayEquals(new int[][]{{1, 3},{4, 10}}, merged);
        System.out.println("Merged intervals: " + Arrays.deepToString(merged));

    }

    @Test
    @DisplayName("List of 4 interval")
    void MergeFourIntervals() {
        int[][] merged = driver.merge(new int[][]{{1, 3}, {2, 6}, {5, 10}, {9, 18}});
        assertArrayEquals(new int[][]{{1, 18}}, merged);
        System.out.println("Merged intervals: " + Arrays.deepToString(merged));

    }
}