package leetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class taskSchedulerTest {
    taskScheduler driver = new taskScheduler();

    @Test
    @DisplayName("Two Unique Tasks with cooldown")
    void TwoTasks() {
        assertEquals(8, driver.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

    @Test
    @DisplayName("Three Unique Tasks with cooldown")
    void ThreeTasks() {
        assertEquals(12, driver.leastInterval(new char[]{'A','A','A','B','B','B','C','C'}, 4));
    }

    @Test
    @DisplayName("Two Unique Tasks without cooldown")
    void TwoTasksNoCD() {
        assertEquals(6, driver.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
    }
}