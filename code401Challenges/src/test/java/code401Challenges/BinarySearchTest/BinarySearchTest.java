package code401Challenges.BinarySearchTest;

import code401Challenges.BinarySearch.BinarySearch;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

  @Test
  public void testBinarySearchHappy() {
    int key = 5;
    int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int expected = 4;
    int actual = BinarySearch.binarySearch(testArray, key);
    assertEquals(expected, actual);

    key = 400;
    expected = -1;
    actual = BinarySearch.binarySearch(testArray, key);
    assertEquals(expected, actual);

  }

  @Test
  public void testBinarySearchFail() {
    int key = 5;
    int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int expected = 99;
    int actual = BinarySearch.binarySearch(testArray, key);
    assertNotEquals("Should not return " + expected, actual);
  }

  @Test
  public void testBinarySearchEdge1() {
    int key = 5;
    int[] testArray = {};
    int expected = -1;
    int actual = BinarySearch.binarySearch(testArray, key);
    assertEquals(expected, actual);
  }

  @Test
  public void testBinarySearchEdge2() {
    int key = 5;
    int[] testArray = {5};
    int expected = 0;
    int actual = BinarySearch.binarySearch(testArray, key);
    assertEquals(expected, actual);
  }
}
