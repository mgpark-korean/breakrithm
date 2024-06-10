package week_1.keepbang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine()
            .split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

    selectionSort(n, arr);

    Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
  }

  public static void selectionSort(int n, int[] arr) {
    for (int i = 0; i < n; i++) {
      int min = arr[i]; // 최소값
      int minIndex = i; // 최소값의 인덱스
      // 최소값을 찾는 반복문
      for (int j = i + 1; j < n; j++) {
        if (min > arr[j]) {
          // 이전 최소값보다 작을 경우 최소값 변경
          min = arr[j];
          minIndex = j;
        }
      }
      // 최소값과 i 인덱스 값의 위치 변경
      arr[minIndex] = arr[i];
      arr[i] = min;
    }
  }

}
