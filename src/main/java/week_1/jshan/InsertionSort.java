package week_1.jshan;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
  public static void main(String[] args) {
    int[] nArr = {9,10,2,4,5,1};

    sortBySelection(nArr);
    Arrays.stream(nArr).forEach(num -> System.out.print(num+" "));

  }

  public static void sortBySelection(int[] arr) {
    for (int i=1; i<arr.length; i++) {
      int key = arr[i];
      // System.out.println("key : " + key);
      for (int j=i-1; j>=0; j--) {
        if (key < arr[j]) {
          // 값 치환
          arr[j+1] = arr[j];
          arr[j] = key;
          // System.out.printf("j[%d] : %d, j[%d+1] : %d \n", j, arr[j], j, arr[j+1]);
        }
      }
    }
  }
}
