//package leetCode;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class courseScheduleIIITest {
//    courseScheduleIII driver = new courseScheduleIII();
//
//    @Test
//    @DisplayName("0 courses")
//    void scheduleCourse0() {
//        int[][] courses = {};
//        assertEquals(0, driver.scheduleCourse(courses));
//    }
//
//    @Test
//    @DisplayName("1 course")
//    void scheduleCourse1() {
//        int[][] courses = {{3, 6}};
//        assertEquals(1, driver.scheduleCourse(courses));
//    }
//
//    @Test
//    @DisplayName("2 courses")
//    void scheduleCourse2() {
//        int[][] courses = {{3, 2}, {4, 3}};
//        assertEquals(0, driver.scheduleCourse(courses));
//    }
//
//    @Test
//    @DisplayName("4 courses")
//    void scheduleCourse4() {
//        int[][] courses = {{3, 5}, {2, 6}, {10, 20}, {20, 35}};
//        assertEquals(4, driver.scheduleCourse(courses));
//    }
//
//    @Test
//    @DisplayName("8 courses")
//    void scheduleCourse8() {
//        int[][] courses = {{3, 5}, {2, 6}, {10, 20}, {20, 35}, {30, 50}, {14, 55}, {20, 80}, {10, 100}};
//        assertEquals(7, driver.scheduleCourse(courses));
//    }
//}