import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class removeAllAdjacentDuplicatesInStringIITest {
    removeAllAdjacentDuplicatesInStringII driver = new removeAllAdjacentDuplicatesInStringII();

    @Test
    void removeDuplicates() {
        assertEquals("ps", driver.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}