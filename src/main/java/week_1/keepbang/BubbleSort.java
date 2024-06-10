package week_1.keepbang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine()
        .split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

    bubbleSort(n, arr);

    Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

  }

  public static void bubbleSort(int n, int[] arr) {
    // 정렬 여부
    boolean sorted;

    do {
      sorted = true;
      for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) { // 정렬이 되어 있는지 확인
          // 정렬이 안되어 있을 경우
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          sorted = false; // 정렬이 안되어 있으므로 false로 변경
        }
      }
    } while (!sorted); // 모든 값이 정렬 되어 있을 경우 종료
  }

}
