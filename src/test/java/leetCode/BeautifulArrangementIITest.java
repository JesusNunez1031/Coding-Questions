package leetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BeautifulArrangementIITest {
    BeautifulArrangementII driver = new BeautifulArrangementII();

    @Test
    @DisplayName("k = 1")
    void constructArrayK1() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, driver.constructArray(5, 1));
    }

    @Test
    @DisplayName("k = 2")
    void constructArrayK2() {
        assertArrayEquals(new int[]{1, 5, 4, 3, 2}, driver.constructArray(5, 2));
    }

    @Test
    @DisplayName("k = 3")
    void constructArrayK3() {
        assertArrayEquals(new int[]{1, 5, 2, 3, 4}, driver.constructArray(5, 3));
    }

    @Test
    @DisplayName("k = 4")
    void constructArrayK4() {
        assertArrayEquals(new int[]{1, 5, 2, 4, 3}, driver.constructArray(5, 4));
    }
}