import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class letterCombinationsOfPhoneNumberTest {
    letterCombinationsOfPhoneNumber driver = new letterCombinationsOfPhoneNumber();

    @Test
    @DisplayName("1 digit")
    void letterCombinationsOneDigit() {
        assertEquals(List.of("a", "b", "c"), driver.letterCombinations("2"));
    }

    @Test
    @DisplayName("2 digits")
    void letterCombinationsTwoDigit() {
        assertEquals(List.of("ag", "ah", "ai", "bg", "bh", "bi", "cg", "ch", "ci"), driver.letterCombinations("24"));
    }

    @Test
    @DisplayName("3 digits")
    void letterCombinationsThreeDigit() {
        assertEquals(List.of("ajm", "ajn", "ajo", "akm", "akn", "ako", "alm", "aln", "alo", "bjm", "bjn", "bjo", "bkm", "bkn", "bko", "blm", "bln", "blo", "cjm", "cjn", "cjo", "ckm", "ckn", "cko", "clm", "cln", "clo"), driver.letterCombinations("256"));
    }
}