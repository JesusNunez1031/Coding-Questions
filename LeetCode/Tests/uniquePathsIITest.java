import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class uniquePathsIITest {
    uniquePathsII driver = new uniquePathsII();

    @Test
    @DisplayName("Grid with only one obstacle")
    void uniquePathsWithObstaclesOne() {
        int[][] grid = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 0, 0}};

        assertEquals(3, driver.uniquePathsWithObstacles(grid));
    }

    @Test
    @DisplayName("Grid with two obstacles")
    void uniquePathsWithObstaclesTwo() {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 0}};

        assertEquals(3, driver.uniquePathsWithObstacles(grid));
    }

    @Test
    @DisplayName("Grid with multiple obstacles")
    void uniquePathsWithObstaclesMultiple() {
        int[][] grid = {
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 0, 0}};

        assertEquals(1, driver.uniquePathsWithObstacles(grid));
    }
}