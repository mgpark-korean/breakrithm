package week_4.mgpark;

import java.util.List;

public class LowerUpperBound {

  public static void main(String[] args) {
    System.out.println("Case 1.");
    execute(List.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30), 16);

    System.out.println("Case 2.");
    execute(List.of(1, 3, 9, 12, 17, 21, 24, 28, 32, 35), 20);

    System.out.println("Case 3.");
    execute(List.of(4, 8, 9, 12, 15, 18, 23, 24, 24, 26, 27, 29, 31), 24);
  }

  private static void execute(List<Integer> numbers, int target) {
    int lowerBound = lowerBound(numbers, target);
    int upperBound = upperBound(numbers, target);
    System.out.println("lowerBound = "+lowerBound + ", upperBound = " + upperBound);
  }

  private static int lowerBound(List<Integer> numbers, int target) {
    int left = 0;
    int right = numbers.size() - 1;
    int minIndex = numbers.size();

    while (left <= right) {
      int mid = (left + right) / 2;
      if (numbers.get(mid) >= target) {
        right = mid - 1;
        minIndex = Math.min(minIndex, mid);
      } else {
        left = mid + 1;
      }
    }

    return minIndex;
  }

  private static int upperBound(List<Integer> numbers, int target) {
    int left = 0;
    int right = numbers.size() - 1;
    int minIndex = numbers.size();
    while (left <= right) {
      int mid = (left + right) / 2;
      if (numbers.get(mid) > target) {
        right = mid - 1;
        minIndex = Math.min(minIndex, mid);
      } else {
        left = mid + 1;
      }
    }
    return minIndex;
  }
}
