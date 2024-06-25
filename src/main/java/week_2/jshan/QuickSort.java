package week_2.jshan;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    int[] nArr = {42, 23, 17, 13, 8, 9, 3, 28, 11, 5,
        30, 19, 37, 2, 15, 7, 4, 1, 12, 6};
    int n = nArr.length;

    quickSort(nArr, 0, n-1);

    Arrays.stream(nArr).forEach(i -> System.out.print(i + " "));
  }

  // QuickSort function
  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {

      int pos = partition(arr, low, high);

      quickSort(arr, low, pos - 1);
      quickSort(arr, pos + 1, high);
    }
  }

  // Partition function
  private static int partition(int[] arr, int low, int high) {
    System.out.printf("partition >>> low : %d, high : %d \n", low, high);
    System.out.print("오리진 Arr : ");
    Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
    System.out.println();
    int pivot = selectPivot(arr, low, high); // high 값이 리턴 됨.
    int i = low - 1;

    // 기준 값 high 전까지 비교 한다.
    for (int j = low; j <= high - 1; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    System.out.print("스왑 완료 Arr : ");
    Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
    System.out.println();

    swap(arr, i + 1, high);
    System.out.print("pivot 값 위치 고정 완료 Arr : ");
    Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
    System.out.println();
    System.out.println("=======================================================================");
    return i + 1; // 마지막 pivot index 값.
  }

  // Helper function to swap two elements in an array
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Function to select pivot
  private static int selectPivot(int[] arr, int low, int high) {
    return arr[high]; // Choosing the last element as pivot
  }
}
