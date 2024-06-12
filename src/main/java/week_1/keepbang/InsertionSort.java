package week_1.keepbang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine()
            .split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

    Arrays.stream(insertionSort(n, arr))
        .forEach(i -> System.out.print(i + " "));
  }

  private static int[] insertionSort(int n, int[] arr) {
    // 배열 복사
    int[] arrCopy = new int[n];
    System.arraycopy(arr, 0, arrCopy, 0, n);

    for (int i = 1; i < n; i++) {
      int j = i - 1; // 비교할 대상 인덱스
      int key = arrCopy[i];
      // i번째 값과 그 이전 값들을 비교하며 위치를 변경함.
      while (j >= 0 && arrCopy[j] > key) { // j가 0보다 작거나 key가 j번째 값보다 크면 종료
        arrCopy[j + 1] = arrCopy[j];
        j--;
      }
      arrCopy[j + 1] = key; // 마지막 변경 지점에 key 입력
    }

    return arrCopy;
  }

}
