public class ArrayReverse {
  public static void main(String[] args) {
    // array to be used for testing
    int[] testArr = {1, 2, 3, 4, 5};

    /* run arrayReverse with testArr as argument
    ** and assign the value to testArr */
    testArr = arrayReverse(testArr);

    // print reversed array
    for(int el : testArr) {
      System.out.print(el + " ");
    }
    System.out.println();
  }

  /***********************************************
  ** Method used to reverse the values of an array
  ** of integers and return the new array
  ***********************************************/
  public static int[] arrayReverse(int[] arr) {
    // create new array for storing reversed array
    int[] reversedArr = new int[arr.length];
    /* integer to be used to keep track of 
    ** position in reversedArr */
    int idx = 0;

    /* loop backward through input array and assign
    ** each value to reversedArr at idx */
    for(int i = arr.length - 1; i >= 0; i--) {
      reversedArr[idx] = arr[i];
      idx++;
    }
    return reversedArr;
  }
}