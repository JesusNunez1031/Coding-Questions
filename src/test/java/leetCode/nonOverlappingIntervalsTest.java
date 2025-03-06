//package leetCode;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class nonOverlappingIntervalsTest {
//    nonOverlappingIntervals driver = new nonOverlappingIntervals();
//
//    @Test
//    @DisplayName("Two intervals")
//    void TwoIntervals() {
//        int overlaps = driver.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}});
//        Assertions.assertEquals(0, overlaps);
//        System.out.println("Delete " + overlaps + " interval(s)");
//    }
//
//    @Test
//    @DisplayName("Three intervals")
//    void ThreeIntervals() {
//        int overlaps = driver.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}});
//        Assertions.assertEquals(2, overlaps);
//        System.out.println("Delete " + overlaps + " interval(s)");
//    }
//
//    @Test
//    @DisplayName("Four intervals")
//    void FourIntervals() {
//        int overlaps = driver.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
//        Assertions.assertEquals(1, overlaps);
//        System.out.println("Delete " + overlaps + " interval(s)");
//    }
//}