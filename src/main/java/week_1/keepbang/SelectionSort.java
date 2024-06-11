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

    Arrays.stream(selectionSort(n, arr))
        .forEach(i -> System.out.print(i + " "));
  }

  public static int[] selectionSort(int n, int[] arr) {
    // 배열 복사
    int[] arrCopy = new int[n];
    System.arraycopy(arr, 0, arrCopy, 0, n);

    for (int i = 0; i < n; i++) {
      int min = arrCopy[i]; // 최소값
      int minIndex = i; // 최소값의 인덱스
      // 최소값을 찾는 반복문
      for (int j = i + 1; j < n; j++) {
        if (min > arrCopy[j]) {
          // 이전 최소값보다 작을 경우 최소값 변경
          min = arrCopy[j];
          minIndex = j;
        }
      }
      // 최소값과 i 인덱스 값의 위치 변경
      arrCopy[minIndex] = arrCopy[i];
      arrCopy[i] = min;
    }

    return arrCopy;
  }

}
