import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class deleteOperationForTwoStringsTest {
    deleteOperationForTwoStrings driver = new deleteOperationForTwoStrings();

    @Test
    @DisplayName("Test 1")
    void minDistanceT1() {
        String w1 = "sea";
        String w2 = "eat";

        assertEquals(2, driver.minDistance(w1, w2));
    }
}