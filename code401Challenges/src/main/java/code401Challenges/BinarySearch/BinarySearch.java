package code401Challenges.BinarySearch;

public class BinarySearch {
  public static void main(String[] args) {
    int key = 9;
    int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(binarySearch(testArray,key));
  }

  public static int binarySearch(int[] arr, int key) {
    int middleIndex = arr.length / 2;
    if(arr.length == 0) {
      return -1;
    }
    return _recurseBinarySearch(arr, key, middleIndex, (arr.length - 1));
  }

  private static int _recurseBinarySearch(int[] arr, int key, int currentIndex, int lastIndex) {
    if(arr[currentIndex] == key) {
      return currentIndex;
    }
    else if (arr[currentIndex] < key && currentIndex != (arr.length - 1)) {
      if(lastIndex - currentIndex == 1) {
        currentIndex++;
        return _recurseBinarySearch(arr, key, currentIndex, lastIndex);
      }
      else {
        currentIndex = currentIndex + ((lastIndex - currentIndex) / 2);
        return _recurseBinarySearch(arr, key, currentIndex, lastIndex);
      }
    }
    else if (arr[currentIndex] > key && currentIndex != 0) {
      lastIndex = currentIndex;
      currentIndex = currentIndex / 2;
      return _recurseBinarySearch(arr, key, currentIndex, lastIndex);
    }
    else {
      return -1;
    }
  }
}
