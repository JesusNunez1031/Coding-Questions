import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class verifyAlienDictionaryTest {
    verifyAlienDictionary driver = new verifyAlienDictionary();

    @Test
    @DisplayName("Alien Alphabet 1")
    void isAlienSortedAlphabetOne() {
        String[] words = {"hello", "leetcode", "binary", "search"};
        String alphabet = "hlabcdefgijkmnopqrstuvwxyz";
        assertTrue(driver.isAlienSorted(words, alphabet));
    }

    @Test
    @DisplayName("Alien Alphabet 2")
    void isAlienSortedAlphabetTwo() {
        String[] words = {"word", "world", "row"};
        String alphabet = "worldabcefghijkmnpqstuvxyz";
        assertFalse(driver.isAlienSorted(words, alphabet));
        System.out.println("'d' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.");
    }
}