package week_2.keepbang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine()
            .split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

    // 배열 복사
    int[] arrCopy = new int[n];
    System.arraycopy(arr, 0, arrCopy, 0, n);

    quick_sort(arrCopy, 0, n - 1);
    Arrays.stream(arrCopy).forEach(i -> System.out.print(i + " "));
  }

  public static void quick_sort(int[] arr, int low, int high) {
    if (low < high) {
      int pos = partition(arr, low, high);
      quick_sort(arr, low, pos - 1);
      quick_sort(arr, pos + 1, high);
    }

  }

  public static int partition(int[] arr, int low, int high) {
    int pivotIndex = select_pivot_middle(arr, low, high);
    int pivot = arr[pivotIndex];

    // 중간값을 마지막 인덱스로 이동시킴
    swap(arr, pivotIndex, high);

    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, high);

    return i + 1;
  }

  // i와 j의 위치를 변경
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // 오른쪽, 왼쪽, 가운데 값 중 중간값을 구한다.
  public static int select_pivot_middle(int[] arr, int low, int high) {
    int leftValue = arr[low];
    // ex) 배열크기가 10일 경우 low : 5, high : 10
    // 5 + (10 - 5) / 2
    // = 5 + 5 / 2
    // = 5 + 2.5(버림)
    // = 7(중간 인덱스)
    int midValue = arr[low + (high - low) / 2];
    int rightValue = arr[high];

    if ((leftValue > midValue) != (leftValue> rightValue)) {
      return low;
    } else if ((midValue> leftValue) != (midValue > rightValue)) {
      return high / 2;
    } else {
      return high;
    }
  }


}
