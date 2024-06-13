package week_1.mgpark.util;

/**
 * 배열 출력기.
 */
public class ArrayPinter {

  public static void print(int[] arrays) {
    StringBuilder printBuilder = new StringBuilder();
    for (int i = 0; i < arrays.length; i++) {
      printBuilder.append(arrays[i]);
      if (i != arrays.length - 1) {
        printBuilder.append(" ");
      }
    }

    System.out.println(printBuilder);
  }
}
