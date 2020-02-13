package code401Challenges.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {

    Integer[] intArr;
    Sort<Integer> intSort;
    Integer[] reverseIntArr;
    Sort<Integer> reverseIntSort;
    Integer[] fewUniquesIntArr;
    Sort<Integer> fewUniquesIntSort;
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
        reverseIntArr = new Integer[]{20,18,12,8,5,-2};
        reverseIntSort = new Sort<>(reverseIntArr);
        fewUniquesIntArr = new Integer[]{5,12,7,5,5,7};
        fewUniquesIntSort = new Sort<>(fewUniquesIntArr);
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
    public void reverseIntSortInsertionSortTest() {
        reverseIntSort.insertionSort();
        assertArrayEquals(new Integer[]{-2, 5, 8, 12, 18, 20}, reverseIntArr);
    }

    @Test
    public void fewUniquesIntSortInsertionSortTest() {
        fewUniquesIntSort.insertionSort();
        assertArrayEquals(new Integer[]{5, 5, 5, 7, 7, 12}, fewUniquesIntArr);
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

    @Test
    public void intSortMergeSortTest() {
        intSort.mergeSort(intSort.getArr());
        assertArrayEquals(new Integer[]{1, 2, 3, 6, 34, 76, 90}, intArr);
    }

    @Test
    public void reverseIntSortMergeSortTest() {
        reverseIntSort.mergeSort(reverseIntSort.getArr());
        assertArrayEquals(new Integer[]{-2, 5, 8, 12, 18, 20}, reverseIntArr);
    }

    @Test
    public void fewUniquesIntSortMergeSortTest() {
        fewUniquesIntSort.mergeSort(fewUniquesIntSort.getArr());
        assertArrayEquals(new Integer[]{5, 5, 5, 7, 7, 12}, fewUniquesIntArr);
    }

    @Test
    public void strSortMergeSortTest() {
        strSort.mergeSort(strSort.getArr());
        assertArrayEquals(new String[]{"bravo", "charlie", "delta", "juliet", "romeo", "tango"}, strArr);
    }

    @Test
    public void emptySortMergeSortTest() {
        emptySort.mergeSort(emptySort.getArr());
        assertArrayEquals(new Integer[]{}, emptyArr);
    }

    @Test
    public void doubleSortMergeSortTest() {
        doubleSort.mergeSort(doubleSort.getArr());
        assertArrayEquals(new Double[]{-876.1, -34.5, 3.3, 66.234, 354.34, 865.33, 7643.2}, doubleArr);
    }

    @Test
    public void intSortQuickSortTest() {
        intSort.quicksort(intSort.getArr(), 0,
                intSort.getArr().length - 1);
        assertArrayEquals(new Integer[]{1, 2, 3, 6, 34, 76, 90}, intArr);
    }

    @Test
    public void reverseIntSortQuickSortTest() {
        reverseIntSort.quicksort(reverseIntSort.getArr(), 0,
                reverseIntSort.getArr().length - 1);
        assertArrayEquals(new Integer[]{-2, 5, 8, 12, 18, 20}, reverseIntArr);
    }

    @Test
    public void fewUniquesIntSortQuickSortTest() {
        fewUniquesIntSort.quicksort(fewUniquesIntSort.getArr(), 0,
                fewUniquesIntSort.getArr().length - 1);
        assertArrayEquals(new Integer[]{5, 5, 5, 7, 7, 12}, fewUniquesIntArr);
    }

    @Test
    public void strSortQuickSortTest() {
        strSort.quicksort(strSort.getArr(), 0,
                strSort.getArr().length - 1);
        assertArrayEquals(new String[]{"bravo", "charlie", "delta", "juliet", "romeo", "tango"}, strArr);
    }

    @Test
    public void emptySortQuickSortTest() {
        emptySort.quicksort(emptySort.getArr(), 0,
                emptySort.getArr().length - 1);
        assertArrayEquals(new Integer[]{}, emptyArr);
    }

    @Test
    public void doubleSortQuickSortTest() {
        doubleSort.quicksort(doubleSort.getArr(), 0,
                doubleSort.getArr().length - 1);
        assertArrayEquals(new Double[]{-876.1, -34.5, 3.3, 66.234, 354.34, 865.33, 7643.2}, doubleArr);
    }
}