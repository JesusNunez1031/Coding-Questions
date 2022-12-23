//package leetCode;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class intervalListIntersectionTest {
//    intervalListIntersection driver = new intervalListIntersection();
//
//    @Test
//    @DisplayName("Equal Size Lists")
//    void EqualSizedLists() {
//        int[][] intersections = driver.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
//        Assertions.assertArrayEquals(new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}}, intersections);
//        System.out.println("Intersections: " + Arrays.deepToString(intersections));
//    }
//
//    @Test
//    @DisplayName("One empty List")
//    void OneEmptyList() {
//        int[][] intersections = driver.intervalIntersection(new int[][]{{1, 3}, {5, 9}}, new int[][]{});
//        Assertions.assertArrayEquals(new int[][]{}, intersections);
//        System.out.println("Intersections: " + Arrays.deepToString(intersections));
//    }
//
//    @Test
//    @DisplayName("Un-Even Lists")
//    void UnEvenSizedLists() {
//        int[][] intersections = driver.intervalIntersection(new int[][]{{1, 3}, {5, 9}, {8, 10}, {10, 15}}, new int[][]{{1, 4}, {4, 6}});
//        Assertions.assertArrayEquals(new int[][]{{1, 3}, {5, 6}}, intersections);
//        System.out.println("Intersections: " + Arrays.deepToString(intersections));
//    }
//}