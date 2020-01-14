package code401Challenges.ArrayShift;

import code401Challenges.ArrayShift.ArrayShift;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayShiftTest {
    @Test public void testArrayShiftHappy1() {
        int[] expectedHappy1 = {2,4,5,6,8};
        int[] actualHappy1 = ArrayShift.insertShiftArray(new int[]{2, 4, 6, 8}, 5);
        assertArrayEquals(expectedHappy1, actualHappy1);
    }

    @Test public void testArrayShiftHappy2() {
        int[] expectedHappy2 = {4,8,15,16,23,42};
        int[] actualHappy2 = ArrayShift.insertShiftArray(new int[]{4,8,15,23,42}, 16);
        assertArrayEquals(expectedHappy2, actualHappy2);
    }

    @Test public void testArrayShiftFail1() {
        int[] expectedFail1 = {1, 2};
        int[] actualFail1 = ArrayShift.insertShiftArray(new int[]{8, 9, 10}, 11);
        assertFalse(Arrays.equals(expectedFail1, actualFail1));
    }

    @Test public void testArrayShiftEdge1() {
        int[] expectedEdge1 = {0};
        int[] actualEdge1 = ArrayShift.insertShiftArray(new int[0], 0);
        assertArrayEquals(expectedEdge1, actualEdge1);
    }
}
