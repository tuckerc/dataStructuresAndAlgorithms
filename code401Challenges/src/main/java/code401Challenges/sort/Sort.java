package code401Challenges.sort;

import java.util.Arrays;

public class Sort<T extends Comparable<T>> {

    private T[] arr;

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

    public void quicksort(T[] arr, int left, int right) {
        if(left < right) {
            // Partition the array by setting the position of the pivot value
            int partitionIdx = partition(arr, left, right);

            // sort the portion of the array to the left of the partition
            quicksort(arr, left, partitionIdx - 1);

            // sort the portion of the array to the right of the partition
            quicksort(arr, partitionIdx + 1, right);
        }
    }

    private int partition(T[] arr, int left, int right) {
        // set the pivot value as the far right value
        T pivot = arr[right];

        // create a variable to track the largest index of the values lower
        // than the pivot
        int low = left - 1;

        // loop from left to right swapping any values less than the pivot
        // with the value immediately after the current low
        for(int i = left; i < right; i++) {
            if(arr[i].compareTo(pivot) < 0) {
                low++;
                swap(arr, i, low);
            }
        }

        // swap the pivot value with the value immediately after the low value
        // all values smaller than the pivot will be on the left, and
        // all values greater than the pivot will be on the right
        swap(arr, right, low + 1);

        // return the new index of the pivot value
        return low + 1;
    }

    private void swap(T[] arr, int i, int low) {
        T temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
    }

    public T[] getArr() {
        return arr;
    }
}