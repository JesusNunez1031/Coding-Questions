import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class russianDollEnvelopesTest {
    russianDollEnvelopes driver = new russianDollEnvelopes();

    @Test
    @DisplayName("Two envelopes used")
    void TwoEnvelopes() {
        int russianEnvelopes = driver.maxEnvelopes(new int[][]{{5, 10}, {2, 6}});
        assertEquals(2, russianEnvelopes);
        System.out.println(russianEnvelopes + " nested envelopes created");
    }

    @Test
    @DisplayName("Three envelopes used")
    void ThreeEnvelopes() {
        int russianEnvelopes = driver.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}});
        assertEquals(1, russianEnvelopes);
        System.out.println(russianEnvelopes + " nested envelopes created");
    }

    @Test
    @DisplayName("Four envelopes used")
    void FourEnvelopes() {
        int russianEnvelopes = driver.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
        assertEquals(3, russianEnvelopes);
        System.out.println(russianEnvelopes + " nested envelopes created");
    }

    @Test
    @DisplayName("Five envelopes used")
    void FiveEnvelopes() {
        int russianEnvelopes = driver.maxEnvelopes(new int[][]{{2, 2}, {5, 4}, {6, 4}, {6, 7}, {2, 3}, {8, 10}});
        assertEquals(4, russianEnvelopes);
        System.out.println(russianEnvelopes + " nested envelopes created");
    }
}