package leetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class numberOfSubmatricesThatSumToTargetTest {
    numberOfSubmatricesThatSumToTarget driver = new numberOfSubmatricesThatSumToTarget();

    @Test
    @DisplayName("3 x 3 matrix")
    void ThreeByThreeMatrix() {
        assertEquals(4, driver.numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));
    }

    @Test
    @DisplayName("2 x 2 matrix")
    void TwoByTwoMatrix() {
        assertEquals(5, driver.numSubmatrixSumTarget(new int[][]{{1, -1}, {-1, 1}}, 0));
    }
}