package week_3.keepbang;

import java.util.Arrays;

public class HeapSort {

  public static void main(String[] args) {
    int[] arr = {29, 31, 15, 18, 50, 29, 24};
    
    heapSort(arr, arr.length);

    Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
  }

  public static void heapSort(int[] arr, int n) {
    // max-heap 변환
    for (int i = n / 2; i >= 0; i--) {
      heapify(arr, n, i);
    }

    Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
    System.out.println();

    // heap sort 진행
    for (int i = n - 1; i > 0; i--) {
      swap(arr, 0, i);
      System.out.print("swap : ");
      Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
      System.out.println();
      System.out.println("i = " + i);
      heapify(arr, i, 0);
      System.out.print("heapify : ");
      Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
      System.out.println();
    }
  }

  public static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int l = i * 2;
    int r = i * 2 + 1;

    if (l < n && arr[l] > arr[largest]) {
      largest = l;
    }

    if (r < n && arr[r] > arr[largest]) {
      largest = r;
    }

    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, n, largest);
    }

  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
