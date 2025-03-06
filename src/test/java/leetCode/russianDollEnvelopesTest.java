//package leetCode;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class russianDollEnvelopesTest {
//    russianDollEnvelopes driver = new russianDollEnvelopes();
//
//    @Test
//    @DisplayName("Two envelopes used")
//    void TwoEnvelopes() {
//        int russianEnvelopes = driver.maxEnvelopes(new int[][]{{5, 10}, {2, 6}});
//        Assertions.assertEquals(2, russianEnvelopes);
//        System.out.println(russianEnvelopes + " nested envelopes created");
//    }
//
//    @Test
//    @DisplayName("Three envelopes used")
//    void ThreeEnvelopes() {
//        int russianEnvelopes = driver.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}});
//        Assertions.assertEquals(1, russianEnvelopes);
//        System.out.println(russianEnvelopes + " nested envelopes created");
//    }
//
//    @Test
//    @DisplayName("Four envelopes used")
//    void FourEnvelopes() {
//        int russianEnvelopes = driver.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
//        Assertions.assertEquals(3, russianEnvelopes);
//        System.out.println(russianEnvelopes + " nested envelopes created");
//    }
//
//    @Test
//    @DisplayName("Five envelopes used")
//    void FiveEnvelopes() {
//        int russianEnvelopes = driver.maxEnvelopes(new int[][]{{2, 2}, {5, 4}, {6, 4}, {6, 7}, {2, 3}, {8, 10}});
//        Assertions.assertEquals(4, russianEnvelopes);
//        System.out.println(russianEnvelopes + " nested envelopes created");
//    }
//}