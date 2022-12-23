package leetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class onesAndZerosTest {
    onesAndZeros driver = new onesAndZeros();

    @Test
    @DisplayName("Array Of 5 binary values")
    void findMaxFormArrayOfFive() {
        int largest_subset = driver.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        Assertions.assertEquals(4, largest_subset);
        System.out.println("Largest subset is of size " + largest_subset);
    }

    @Test
    @DisplayName("Array Of 10 binary values")
    void findMaxFormArrayOfTen() {
        int largest_subset = driver.findMaxForm(new String[]{"10", "0001", "111001", "1", "0", "101010", "01001", "101", "01", "1101"}, 6, 5);
        Assertions.assertEquals(5, largest_subset);
        System.out.println("Largest subset is of size " + largest_subset);
    }
}