package leetCode;

import leetCode.arrays.BeautifulArrangementII;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class BeautifulArrangementIITest extends SoftAssert {
    BeautifulArrangementII driver = new BeautifulArrangementII();

    @Test
    public void constructArrayK1() {
        assertEquals(new int[]{1, 2, 3, 4, 5}, driver.constructArray(5, 1));
    }

    @Test
    public void constructArrayK2() {
        assertEquals(new int[]{1, 5, 4, 3, 2}, driver.constructArray(5, 2));
    }

    @Test
    public void constructArrayK3() {
        assertEquals(new int[]{1, 5, 2, 3, 4}, driver.constructArray(5, 3));
    }

    @Test
    public void constructArrayK4() {
        assertEquals(new int[]{1, 5, 2, 4, 3}, driver.constructArray(5, 4));
    }
}