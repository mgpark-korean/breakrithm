package week_1.mgpark;

import week_1.mgpark.util.ArrayPinter;

public class SelectionSort {

  public static void main(String[] args) {
    int[] arrays = {5, 2, 6, 1, 3, 8};
    for (int i = 0; i < arrays.length; i++) {
      int minPos = -1;
      for (int j = i; j < arrays.length; j++) {
        if (minPos < 0 || arrays[minPos] > arrays[j]) {
          minPos = j;
        }
      }

      int temp = arrays[i];
      arrays[i] = arrays[minPos];
      arrays[minPos] = temp;
    }

    ArrayPinter.print(arrays);
  }
}
