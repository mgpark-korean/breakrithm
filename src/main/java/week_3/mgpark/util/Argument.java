package week_3.mgpark.util;

import java.util.Arrays;
import java.util.List;

/**
 * main으로 받는 args 객체.
 *
 * @param arrSize 배열 크기.
 * @param arr     배열.
 */
public record Argument(
    int arrSize,
    List<Integer> arr
) {

  private static final String SEPARATOR = " ";

  public static Argument of(String[] args) {
    if (args == null || args.length != 2) {
      throw new IllegalArgumentException("invalid args!");
    }

    final int arrSize = Integer.parseInt(args[0]);
    final List<Integer> arr = Arrays.stream(args[1].split(SEPARATOR))
        .map(Integer::parseInt).toList();

    return new Argument(arrSize, arr);
  }
}
