package code401Challenges.ArrayShift;

public class ArrayShift {
    public static int[] insertShiftArray(int[] arr, int newVal) {
        // create new array with size of arr + 1
        int[] resultArray = new int[arr.length + 1];

        // identify the middle index of the new array
        int middleIndex = resultArray.length / 2;

        /* loop through the new array. insert all elements from
        * arr up to middleIndex. insert remaining elements from
        * arr in new array offset by one.*/
        for(int i = 0; i < resultArray.length; i++) {
            if(i == middleIndex) {
                resultArray[i] = newVal;
            }
            else if(i < middleIndex){
                resultArray[i] = arr[i];
            }
            else {
                resultArray[i] = arr[i - 1];
            }
        }

        return resultArray;
    }
}
