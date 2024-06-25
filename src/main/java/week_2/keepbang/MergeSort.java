package week_2.keepbang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * mid + 1, mid, low, mid + 1, arr[i], arr[j]
 * 17 21 15 16 30 20 35
 */
public class MergeSort {

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

    Arrays.stream(mergeSort(arrCopy)).forEach(i -> System.out.print(i + " "));

  }

  public static int[] mergeSort(int[] arr) {
    if (arr.length <= 1) {
      return arr;
    }

    int mid = arr.length / 2;

    int[] left = Arrays.copyOfRange(arr, 0, mid);
    int[] right = Arrays.copyOfRange(arr, mid, arr.length);

    return merge(mergeSort(left), mergeSort(right));
  }

  private static int[] merge(int[] left, int[] right) {
    Arrays.stream(left).forEach(i -> System.out.print(i + " "));
    System.out.println();
    Arrays.stream(right).forEach(i -> System.out.print(i + " "));
    System.out.println();

    int[] answer = new int[left.length + right.length];

    int i = 0, j = 0, k = 0;

    // 배열 하나가 answer에 다 들어갈 때까지 반복문 수행
    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        answer[k++] = left[i++];
      } else {
        answer[k++] = right[j++];
      }
    }

    // 왼쪽 배열 나머지 추가
    while (i < left.length) {
      answer[k++] = left[i++];
    }

    // 오른쪽 배열 나머지 추가
    while (j < right.length) {
      answer[k++] = right[j++];
    }

    System.out.print("merge : ");
    Arrays.stream(answer).forEach(n -> System.out.print(n + " "));
    System.out.println();


    return answer;
  }

}
