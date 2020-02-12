package code401Challenges.sort;

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

    public T[] getArr() {
        return arr;
    }
}
