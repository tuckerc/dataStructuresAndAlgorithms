package code401Challenges.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {

    Integer[] intArr;
    Sort<Integer> intSort;
    String[] strArr;
    Sort<String> strSort;
    Integer[] emptyArr;
    Sort<Integer> emptySort;
    Double[] doubleArr;
    Sort<Double> doubleSort;

    @Before
    public void setUp() throws Exception {

        intArr = new Integer[]{34, 76, 2, 6, 90, 3, 1};
        intSort = new Sort<>(intArr);
        strArr = new String[]{"romeo", "tango", "charlie", "juliet", "bravo", "delta"};
        strSort = new Sort<>(strArr);
        emptyArr = new Integer[]{};
        emptySort = new Sort<>(emptyArr);
        doubleArr = new Double[]{354.34, 7643.2, 3.3, 66.234, 865.33, -34.5, -876.1};
        doubleSort = new Sort<>(doubleArr);

    }

    @Test
    public void intSortInsertionSortTest() {
        intSort.insertionSort();
        assertArrayEquals(new Integer[]{1, 2, 3, 6, 34, 76, 90}, intArr);
    }

    @Test
    public void strSortInsertionSortTest() {
        strSort.insertionSort();
        assertArrayEquals(new String[]{"bravo", "charlie", "delta", "juliet", "romeo", "tango"}, strArr);
    }

    @Test
    public void emptySortInsertionSortTest() {
        emptySort.insertionSort();
        assertArrayEquals(new Integer[]{}, emptyArr);
    }

    @Test
    public void doubleSortInsertionSortTest() {
        doubleSort.insertionSort();
        assertArrayEquals(new Double[]{-876.1, -34.5, 3.3, 66.234, 354.34, 865.33, 7643.2}, doubleArr);
    }
}