package leetCode;

import org.junit.jupiter.api.Test;

class findMinInRotatedSortedArrayTest {
    findMinInRotatedSortedArray driver = new findMinInRotatedSortedArray();

    @Test
    void findMinT1() {
        assertEquals(1, driver.findMin(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    void findMinT2() {
        assertEquals(0, driver.findMin(new int[]{4,5,6,7,0,1,2}));
    }

    @Test
    void findMinT3() {
        assertEquals(5, driver.findMin(new int[]{10, 11, 12, 13, 5, 6, 7, 8, 9}));
    }
}