package week_2.keepbang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  digit, 10, arr
 *  2, 3, 5
 *  1번
 *  23 15 38 94 62 123 243 234 112
 *  1의자리 :    62 112 23 123 243 94 234 15 38
 *  10의자리 :   112 15 23 123 234 38 243 62 94
 *  100의자리 :  15 23 38 62 94 112 123 234 243
 */
public class RadixSort {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine()
            .split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

    Arrays.stream(radixSort(n, arr)).forEach(i -> System.out.print(i + " "));
  }

  public static int[] radixSort(int n, int[] arr) {
    // 최대값
    int maxValue = Arrays.stream(arr).max().orElse(0);

    // 배열 복사
    int[] arrCopy = new int[n];
    System.arraycopy(arr, 0, arrCopy, 0, n);

    int digit = 1; // 1, 10, 100, 1000 ...

    while (maxValue / digit > 0) { // 자릿수 체크
      List<Integer>[] arr_new = new ArrayList[10];

      for (int i = 0; i < 10; i++) {
        arr_new[i] = new ArrayList<>();
      }

      System.out.println("digit = " + digit);
      for (int value : arrCopy) {
        // (3426 % (100 * 10)) / 100 = 426 / 100 = 4.26
        int digitNum = (value % (digit * 10)) / digit; // 해당 자릿수의 정수 추출
        System.out.println("digitNum = " + digitNum);
        // 자릿수의 정수와 일치하는 인덱스에 값을 추가
        arr_new[digitNum].add(value);
      }

      // 리스트배열을 하나의 배열로 변환
      arrCopy = Arrays.stream(arr_new)
          .flatMapToInt(store -> store.stream().mapToInt(value -> value))
          .toArray();

      Arrays.stream(arrCopy).forEach(i -> System.out.print(i + " "));
      System.out.println();

      digit *= 10; // 자릿수 증가
    }

    return arrCopy;
  }

}
