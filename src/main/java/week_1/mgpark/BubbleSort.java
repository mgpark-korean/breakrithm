package week_1.mgpark;

import week_1.mgpark.util.ArrayPinter;

public class BubbleSort {

  public static void main(String[] args) {
    int[] arrays = {5, 2, 6, 1, 3, 8};
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;

      for (int i = 0; i < arrays.length - 1; i++) {
        if (i + 1 < arrays.length && arrays[i] > arrays[i + 1]) {
          int temp = arrays[i];
          arrays[i] = arrays[i + 1];
          arrays[i + 1] = temp;
          isSorted = false;
        }
      }
    }

    ArrayPinter.print(arrays);
  }
}
