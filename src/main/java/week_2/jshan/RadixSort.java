package week_2.jshan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    int[] nArr = {101,850,229,449,221,111};
    int n = nArr.length;

    int k = 0;
    for (int i=0; i<n; i++) {
      // k 구하기 자릿수 구하기
      k = Math.max(k, getDigitCount(nArr[i]));
    }
    sortByRadix(nArr, k);

    Arrays.stream(nArr).forEach(i -> System.out.print(i + " "));
  }

  public static void sortByRadix(int[] arr, int k) {
    // 자릿수 별로 돌기
    for (int pos=0; pos<k; pos++) {

      ArrayList<Integer>[] digitSortedArr = new ArrayList[10];
      for (int i = 0; i < 10; i++) {
        digitSortedArr[i] = new ArrayList<>();
      }
      // 자릿수 별 배열 저장
      for (int i=0; i<arr.length; i++) {
        int digit = getDigitN(arr[i], pos);
        digitSortedArr[digit].add(arr[i]);
        // System.out.printf("digit : %d, number : %d \n", digit, arr[i]);
      }

       for (int i = 0; i < 10; i++) {
           System.out.print("idx : "+ i + " -> ");
           digitSortedArr[i].forEach(dn -> System.out.print(dn +", "));
           System.out.println();
       }
      System.out.println("==================================================================");

      // 배열에 저장
      int idx = 0;
      for (int i=0; i<10; i++) {
        for (int j=0; j<digitSortedArr[i].size(); j++) {
          arr[idx++] = digitSortedArr[i].get(j);
        }
      }
    }
  }

  private static int getDigitCount(int number) {
    return Integer.toString(number).length();
  }

  private static int getDigitN(int n, int pos) {
    // System.out.printf("n : %d, pos : %d \n", n, pos);
    // pos=0 -> 1번째 digit를 의미
    // pos=1 -> 2번째 digit를 의미

    // pos=1 예제
    // (327 / (10 * 1)) % 10 = 327/10 = 32 % 10 = 2
    return (n / (int) Math.pow(10, pos)) % 10;
  }
}
