package week_1.mgpark;

import week_1.mgpark.util.ArrayPinter;

/**
 * 십입 정렬.
 */
public class InsertionSort {

  public static void main(String[] args) {
    int[] arrays = {5, 2, 6, 1, 3, 8};
    int[] sortedArray = new int[arrays.length];

    for (int i = 0; i < arrays.length; i++) {
      sortedArray[i] = arrays[i];
      if (i > 0) {
        for (int j = i; j >= 0; j--) {
          if (j != 0 && sortedArray[j] < sortedArray[j - 1]) {
            // swap
            int temp = sortedArray[j];
            sortedArray[j] = sortedArray[j - 1];
            sortedArray[j - 1] = temp;
          } else {
            break;
          }
        }
      }
    }

    ArrayPinter.print(sortedArray);
  }
}
