import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class insertIntervalTest {
    insertInterval driver = new insertInterval();

    @Test
    @DisplayName("In between intervals")
    void insertInBetween() {
        int[] newInterval = {4, 6};
        assertArrayEquals(new int[][]{{1, 3}, {4, 6}, {7, 10}, {11, 13}}, driver.insert(new int[][]{{1, 3}, {7, 10}, {11, 13}}, newInterval));
    }

    @Test
    @DisplayName("Merge into empty list")
    void MergeIntoEmptyList() {
        int[] newInterval = {1, 2};
        assertArrayEquals(new int[][]{{1, 2}}, driver.insert(new int[][]{{1, 2}}, newInterval));
    }

    @Test
    @DisplayName("Merge into an interval")
    void MergeIntoAnInterval() {
        int[] newInterval = {2, 6};
        assertArrayEquals(new int[][]{{1, 10}}, driver.insert(new int[][]{{1, 5}, {6, 10}}, newInterval));
    }
}