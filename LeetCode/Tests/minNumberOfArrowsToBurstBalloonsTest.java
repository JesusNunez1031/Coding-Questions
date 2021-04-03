import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class minNumberOfArrowsToBurstBalloonsTest {
    minNumberOfArrowsToBurstBalloons driver = new minNumberOfArrowsToBurstBalloons();

    @Test
    @DisplayName("1st set of balloons")
    void findMinArrowShotsFirstSet() {
        assertEquals(2, driver.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

    @Test
    @DisplayName("2nd set of balloons")
    void findMinArrowShotsSecondSet() {
        assertEquals(4, driver.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
    }

    @Test
    @DisplayName("3rd set of balloons")
    void findMinArrowShotsThirdSet() {
        assertEquals(2, driver.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }
}