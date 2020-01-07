public class ArrayReverse {
  public static void main(String[] args) {
    int[] testArr = {1, 2, 3, 4, 5};
    testArr = arrayReverse(testArr);
    for(int el : testArr) {
      System.out.print(el + " ");
    }
    System.out.println();
  }

  public static int[] arrayReverse(int[] arr) {
    int[] returnArr = new int[arr.length];
    int idx = 0;
    for(int i = arr.length - 1; i >= 0; i--) {
      returnArr[idx] = arr[i];
      idx++;
    }
    return returnArr;
  }
}