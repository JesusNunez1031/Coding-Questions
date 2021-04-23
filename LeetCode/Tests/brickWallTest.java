import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class brickWallTest {
    brickWall driver = new brickWall();

    @Test
    @DisplayName("Brick wall 1")
    void BrickWall1() {
        List<List<Integer>> wall = List.of(List.of(1, 2, 2, 1), List.of(3, 1, 2), List.of(1, 3, 2), List.of(2, 4), List.of(3, 1, 2), List.of(1, 3, 1, 1));
        assertEquals(2, driver.leastBricks(wall));
    }

    @Test
    @DisplayName("Brick wall 2")
    void BrickWall2() {
        List<List<Integer>> wall = List.of(List.of(1, 2, 1), List.of(3, 5, 2), List.of(1, 3, 3), List.of(2, 4, 3), List.of(3, 1, 2), List.of(1, 3, 1, 2));
        assertEquals(3, driver.leastBricks(wall));
    }
}