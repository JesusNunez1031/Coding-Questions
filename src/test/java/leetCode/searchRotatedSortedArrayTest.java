//package leetCode;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class searchRotatedSortedArrayTest {
//    searchRotatedSortedArray driver = new searchRotatedSortedArray();
//
//    @Test
//    @DisplayName("Rotated array 1")
//    void RotatedArray1() {
//        assertEquals(2, driver.search(new int[]{4, 5, -10, -3, -1, 1, 2}, -10));
//    }
//
//    @Test
//    @DisplayName("Rotated array 2")
//    void RotatedArray2() {
//        assertEquals(8, driver.search(new int[]{8, 9, 10, 12, 15, 0, 1, 2, 3, 4}, 3));
//    }
//
//    @Test
//    @DisplayName("Rotated array 3")
//    void RotatedArray3() {
//        assertEquals(4, driver.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//    }
//}