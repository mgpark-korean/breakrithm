package week_2.mgpark;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import week_2.mgpark.util.Argument;
import week_2.mgpark.util.ListUtils;

public class RadixSort {
  public static void main(String[] args) {
    execute(new String[]{
        "6",
        "5 2 6 1 3 8"
    });
    execute(new String[]{
        "6",
        "19 24 23 16 1 2"
    });
    execute(new String[]{
        "6",
        "195 25 5386 48 84 55"
    });
  }

  private static void execute(String[] args) {
    Argument argument = Argument.of(args);
    List<Integer> sortedList = radixSort(argument.arr());
    ListUtils.print(sortedList);
  }

  private static List<Integer> radixSort(List<Integer> arr) {
    List<Integer> copiedList = ListUtils.copyAsNew(arr);
    int maxDigit = getMaxDigit(arr);

    List<List<Integer>> digitBucket = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
      digitBucket.add(new ArrayList<>());
    }

    for (int digit = 0; digit < maxDigit; digit++) {
      for (Integer number : copiedList) {
        int digitOfNumber = getDigit(number, digit);
        digitBucket.get(digitOfNumber).add(number);
      }

      copiedList.clear();

      for (List<Integer> integers : digitBucket) {
        copiedList.addAll(integers);
        integers.clear();
      }

      ListUtils.print(copiedList);
    }
    
    return copiedList;
  }

  /**
   * 배열의 최대 자리수를 반환한다.
   *
   * @param numbers 숫자 배열.
   * @return 최대 자리수.
   */
  private static int getMaxDigit(List<Integer> numbers) {
    int maxDigit = 0;

    for (Integer number : numbers) {
      int currentDigit = (int) Math.log10(number) + 1;  // 주어지는 숫자가 양수만 받기 때문에 log로 계산.
      if (maxDigit < currentDigit) {
        maxDigit = currentDigit;
      }
    }

    return maxDigit;
  }

  /**
   * 숫자의 특정 자리수를 반환한다.
   *
   * @param number 숫자.
   * @param digit  자리수.
   * @return 특정 자리수의 숫자.
   */
  private static int getDigit(Integer number, int digit) {
    try {
      int divisor = (int) Math.pow(10, digit);
      return (number / divisor) % 10;
    } catch (IndexOutOfBoundsException e) {
      return 0;
    }
  }
}
