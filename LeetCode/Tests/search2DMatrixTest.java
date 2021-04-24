import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class search2DMatrixTest {
    search2DMatrix driver = new search2DMatrix();

    @Test
    @DisplayName("Matrix 1, target is in matrix")
    void searchMatrix1() {
        assertTrue(driver.searchMatrix(new int[][]{{1, 2, 3, 4}, {6, 8, 12, 13}, {15, 19, 20, 21}}, 19));
    }

    @Test
    @DisplayName("Matrix 2, target is not in matrix")
    void searchMatrix2() {
        assertFalse(driver.searchMatrix(new int[][]{{1, 2, 3, 4}, {6, 8, 12, 13}, {15, 19, 20, 21}}, 10));
    }

    @Test
    @DisplayName("Matrix 3, empty matrix")
    void searchMatrix3() {
        assertFalse(driver.searchMatrix(new int[][]{{}}, 10));
    }
}