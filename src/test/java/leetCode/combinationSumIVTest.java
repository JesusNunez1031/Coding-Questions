package leetCode;

import leetCode.dynamicProgramming.combinationSumIV;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class combinationSumIVTest extends SoftAssert {
    combinationSumIV driver = new combinationSumIV();

    @Test
    void Test1() {
        assertEquals(7, driver.combinationSum4(new int[]{1, 2, 3}, 4));
    }

    @Test
    void Test2() {
        assertEquals(0, driver.combinationSum4(new int[]{9}, 4));
    }

    @Test
    void Test3() {
        assertEquals(15, driver.combinationSum4(new int[]{1, 2, 3, 4}, 5));
    }
}