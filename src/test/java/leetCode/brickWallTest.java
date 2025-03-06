package leetCode;

import leetCode.hashMaps.brickWall;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class brickWallTest extends SoftAssert {
    brickWall driver = new brickWall();

    @Test
    void BrickWall1() {
        List<List<Integer>> wall = List.of(List.of(1, 2, 2, 1), List.of(3, 1, 2), List.of(1, 3, 2), List.of(2, 4), List.of(3, 1, 2), List.of(1, 3, 1, 1));
        assertEquals(2, driver.leastBricks(wall));
    }

    @Test
    void BrickWall2() {
        List<List<Integer>> wall = List.of(List.of(1, 2, 1), List.of(3, 5, 2), List.of(1, 3, 3), List.of(2, 4, 3), List.of(3, 1, 2), List.of(1, 3, 1, 2));
        assertEquals(3, driver.leastBricks(wall));
    }
}