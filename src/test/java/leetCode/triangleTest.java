package leetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class triangleTest {
    triangle driver = new triangle();

    @Test
    @DisplayName("Triangle with one value")
    void TriangleWithOneValue() {
        assertEquals(1, driver.minimumTotalDP(List.of(List.of(1))));
    }

    @Test
    @DisplayName("Triangle with two lists")
    void TriangleWithTwoLists() {
        assertEquals(3, driver.minimumTotalDP(List.of(List.of(1), List.of(5, 2))));
    }

    @Test
    @DisplayName("Triangle with three lists")
    void TriangleWithThreeLists() {
        assertEquals(1, driver.minimumTotalDP(List.of(List.of(1), List.of(5, 2), List.of(-5, 10, 0))));
    }

    @Test
    @DisplayName("Triangle with four lists")
    void TriangleWithFourLists() {
        assertEquals(4, driver.minimumTotalDP(List.of(List.of(1), List.of(5, 2), List.of(-5, 10, 0), List.of(4, 23, 1, 2))));
    }
}