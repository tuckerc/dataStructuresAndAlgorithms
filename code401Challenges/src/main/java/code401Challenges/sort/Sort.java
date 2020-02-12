package code401Challenges.sort;

import java.util.Arrays;

public class Sort<T extends Comparable<T>> {

    T[] arr;

    public Sort(T[] arr) {
        this.arr = arr;
    }

    public void insertionSort() {

        // loop through the array separating the sorted portion and the unsorted portion
        for(int i = 1; i < this.getArr().length; i++) {

            int j = i - 1;
            T temp = this.getArr()[i];

            while(j >= 0 && temp.compareTo(this.getArr()[j]) < 0) {

                this.getArr()[j + 1] = this.getArr()[j];
                j--;

            }

            this.getArr()[j + 1] = temp;

        }
    }

    public void mergeSort(T[] arr) {

        if (arr.length > 1) {
            // declare midpoint
            int mid = arr.length / 2;
            // create left sub-array
            T[] left = Arrays.copyOfRange(arr, 0, mid);
            // create right sub-array
            T[] right = Arrays.copyOfRange(arr, mid, arr.length);

            // sort the left sub-array
            mergeSort(left);
            // sort the right sub-array
            mergeSort(right);
            // merge the left and right
            merge(left, right, arr);
        }

    }

    private void merge(T[] left, T[] right, T[] original) {
        int leftIdx = 0;
        int rightIdx = 0;
        int originalIdx = 0;

        // compare left and right, putting the original array
        // in sorted order until one side is used up
        while(leftIdx < left.length && rightIdx < right.length) {
            if(left[leftIdx].compareTo(right[rightIdx]) <= 0) {
                original[originalIdx] = left[leftIdx];
                leftIdx++;
            } else {
                original[originalIdx] = right[rightIdx];
                rightIdx++;
            }
            originalIdx++;
        }

        // fill the rest of the original with either the
        // remainder of either the of the left or right
        if(leftIdx == left.length) {
            while(rightIdx < right.length) {
                original[originalIdx] = right[rightIdx];
                originalIdx++;
                rightIdx++;
            }
        } else {
            while(leftIdx < left.length) {
                original[originalIdx] = left[leftIdx];
                originalIdx++;
                leftIdx++;
            }
        }
    }

    public T[] getArr() {
        return arr;
    }
}
