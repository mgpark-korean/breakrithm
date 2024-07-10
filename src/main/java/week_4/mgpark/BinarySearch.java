package week_4.mgpark;

import java.util.List;

public class BinarySearch {

  public static void main(String[] args) {
    execute(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16), 13);
    execute(List.of(1, 17, 32, 24, 3, 12, 28, 9, 21), 21);
  }

  private static void execute(List<Integer> numbers, int target) {
    System.out.println("=====search start...====================");
    System.out.println("numbers = " + numbers);
    System.out.println("target = " + target);
    Integer search = binarySearch(numbers, target);
    System.out.println("=====search end...====================");
    System.out.println("search index : " + search);
    if (search > 0) {
      System.out.println("index number is " + numbers.get(search));
    }
  }


  private static Integer binarySearch(List<Integer> numbers, int target) {
    System.out.println("Binary Search start, target: " + target);
    int left = 0;
    int right = numbers.size() - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      System.out.println("index) left: " + left + ", right: " + right + ", mid: " + mid);
      System.out.println("number) left: " + numbers.get(left) + ", right: " + numbers.get(right) + ", mid: " + numbers.get(mid));

      if (numbers.get(mid) == target) {
        System.out.println("find target..! target index : " + mid);
        return mid;
      }

      if (numbers.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
      System.out.println("-----------------------------");
    }
    return -1;
  }
}
